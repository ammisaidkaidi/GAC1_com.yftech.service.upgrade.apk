package com.yftech.service.upgrade.adapter.dsp.project;

import android.os.SystemClock;
import androidx.appcompat.widget.ActivityChooserView;
import com.yftech.service.upgrade.adapter.dsp.a.a;
import com.yftech.service.upgrade.g.b;
import com.yftech.service.upgrade.g.c;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class CarDspAdapterDefault extends a implements com.yftech.service.upgrade.g.a.InterfaceC0100a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1582a = "dspupgrade.bin";
    private static final String b = "dspupgrade.md5";
    private final Object c = new Object();
    private int d = ActivityChooserView.a.f166a;

    private void a(File[] fileArr) throws Throwable {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            if (file != null && file.exists() && !file.delete()) {
                b.e("deleteFiles, delete fail:" + file.getPath());
            }
        }
    }

    private File[] c(String[] strArr) throws Throwable {
        if (strArr == null || strArr.length == 0) {
            b.e("findUpgradeFiles, pathList is empty");
            return null;
        }
        File file = new File(strArr[0]);
        if (!file.exists()) {
            b.e("findUpgradeFiles, pathList not exists");
            return null;
        }
        if (!file.isDirectory()) {
            b.e("findUpgradeFiles, pathList is not directory");
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            b.e("findUpgradeFiles, directory is empty");
            return null;
        }
        File file2 = null;
        File file3 = null;
        for (File file4 : fileArrListFiles) {
            if (file4.isFile()) {
                if (f1582a.equals(file4.getName())) {
                    file2 = file4;
                } else if (b.equals(file4.getName())) {
                    file3 = file4;
                }
                if (file2 != null && file3 != null) {
                    break;
                }
            }
        }
        if (file2 == null || file3 == null) {
            return null;
        }
        return new File[]{file2, file3};
    }

    @Override // com.yftech.service.upgrade.adapter.b
    public String a() {
        return "default";
    }

    @Override // com.yftech.service.upgrade.g.a.InterfaceC0100a
    public void a(int i) {
        onUpgradeProgressChanged(i);
    }

    @Override // com.yftech.service.upgrade.adapter.IDspAdapter
    public boolean a(String[] strArr) {
        return c(strArr) != null;
    }

    @Override // com.yftech.service.upgrade.adapter.b
    public String b() {
        return "default";
    }

    @Override // com.yftech.service.upgrade.adapter.IDspAdapter
    public boolean b(String[] strArr) throws Throwable {
        int iCharAt;
        this.d = ActivityChooserView.a.f166a;
        onUpgradeStateChanged(3);
        File[] fileArrC = c(strArr);
        if (fileArrC == null) {
            b.e("startUpgrade, not find upgrade file");
            onUpgradeStateChanged(2);
            return false;
        }
        onUpgradeStateChanged(4);
        File file = new File(com.yftech.service.upgrade.a.a.a().b());
        if (!com.yftech.service.upgrade.g.a.a(fileArrC, file, this)) {
            b.e("startUpgrade, copy failed");
            onUpgradeStateChanged(2);
            a(new File[]{new File(file, f1582a), new File(file, b)});
            return false;
        }
        onUpgradeStateChanged(5);
        onUpgradeProgressChanged(0);
        File file2 = new File(file, f1582a);
        File file3 = new File(file, b);
        String strA = c.a(file2, file3);
        if (strA == null) {
            b.e("startUpgrade, md5 not equals");
            onUpgradeStateChanged(2);
            a(new File[]{file2, file3});
            return false;
        }
        onUpgradeStateChanged(6);
        onUpgradeProgressChanged(0);
        byte[] bArr = new byte[strA.length() / 2];
        int i = 0;
        int i2 = 0;
        while (i < strA.length()) {
            if (strA.charAt(i) < 'a' || strA.charAt(i) > 'z') {
                iCharAt = (strA.charAt(i) < 'A' || strA.charAt(i) > 'Z') ? strA.charAt(i) - '0' : (strA.charAt(i) - 'A') + 10;
            } else {
                iCharAt = (strA.charAt(i) - 'a') + 10;
            }
            int i3 = i + 1;
            if (i3 < strA.length()) {
                int i4 = iCharAt << 4;
                if (strA.charAt(i3) < 'a' || strA.charAt(i3) > 'z') {
                    iCharAt = (strA.charAt(i3) < 'A' || strA.charAt(i3) > 'Z') ? ((strA.charAt(i3) - '0') & 15) | i4 : (((strA.charAt(i3) - 'A') + 10) & 15) | i4;
                } else {
                    iCharAt = (((strA.charAt(i3) - 'a') + 10) & 15) | i4;
                }
            }
            bArr[i2] = (byte) iCharAt;
            i += 2;
            i2++;
        }
        if (!nativeStartUpgrade(file2.getPath(), bArr)) {
            b.e("startUpgrade, start upgrade mcu failed");
            onUpgradeStateChanged(2);
            a(new File[]{file2, file3});
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (true) {
            synchronized (this.c) {
                if (this.d == 2 || this.d == 1) {
                    break;
                }
                try {
                    this.c.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - jUptimeMillis > 600000) {
                    b.e("startUpgrade, timeout not finish");
                    onUpgradeStateChanged(2);
                }
                a(new File[]{file2, file3});
                return true;
            }
        }
        a(new File[]{file2, file3});
        return true;
    }

    @Override // com.yftech.service.upgrade.adapter.dsp.a.a, com.yftech.service.upgrade.adapter.b
    public String c() {
        StringBuilder sb = new StringBuilder();
        String strC = super.c();
        if (strC != null) {
            sb.append(strC);
        }
        sb.append("platform=");
        sb.append(a());
        sb.append("\n");
        sb.append("project=");
        sb.append(b());
        sb.append("\n");
        sb.append("lastState=");
        sb.append(this.d);
        sb.append("\n");
        return sb.toString();
    }

    public native boolean nativeStartUpgrade(String str, byte[] bArr);

    @Override // com.yftech.service.upgrade.adapter.dsp.a.a, com.yftech.service.upgrade.adapter.IDspAdapter
    public void onUpgradeStateChanged(int i) {
        super.onUpgradeStateChanged(i);
        this.d = i;
        if (i == 2 || i == 1) {
            synchronized (this.c) {
                this.c.notifyAll();
            }
        }
    }
}
