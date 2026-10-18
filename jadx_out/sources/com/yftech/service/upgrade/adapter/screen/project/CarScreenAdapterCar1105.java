package com.yftech.service.upgrade.adapter.screen.project;

import com.yftech.car.utils.PlatformProjectDescribe;
import com.yftech.service.upgrade.adapter.screen.a.b;
import com.yftech.service.upgrade.g.c;
import com.yftech.service.upgrade.g.d;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CarScreenAdapterCar1105 extends b implements com.yftech.service.upgrade.g.a.InterfaceC0100a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1587a = "all.bin";
    private static final String b = "all.md5";

    private void a(File[] fileArr) throws Throwable {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            if (file != null && file.exists() && !file.delete()) {
                com.yftech.service.upgrade.g.b.e("deleteFiles, delete fail:" + file.getPath());
            }
        }
    }

    private native boolean nativeStartUpgrade(String str);

    @Override // com.yftech.service.upgrade.g.a.InterfaceC0100a
    public void a(int i) {
        onUpgradeProgressChanged(i);
    }

    @Override // com.yftech.service.upgrade.adapter.IScreenAdapter
    public boolean a(String[] strArr) throws Throwable {
        String[] strArr2 = {f1587a, b};
        Map<String, File> mapA = d.a(strArr, strArr2);
        for (String str : strArr2) {
            if (!mapA.containsKey(str)) {
                com.yftech.service.upgrade.g.b.e("checkUpgradeFile, upgrade file(" + str + ") missing");
                return false;
            }
        }
        return true;
    }

    @Override // com.yftech.service.upgrade.adapter.b
    public String b() {
        return PlatformProjectDescribe.Project.CA1105.toString();
    }

    @Override // com.yftech.service.upgrade.adapter.IScreenAdapter
    public boolean b(String[] strArr) throws Throwable {
        com.yftech.service.upgrade.g.b.c("screen upgrade start");
        onUpgradeStateChanged(3);
        Map<String, File> mapA = d.a(strArr, new String[]{f1587a, b});
        File file = mapA.get(f1587a);
        File file2 = mapA.get(b);
        if (file == null || file2 == null) {
            com.yftech.service.upgrade.g.b.e("startUpgrade, upgrade file missing");
            onUpgradeStateChanged(2);
            return false;
        }
        onUpgradeStateChanged(4);
        File file3 = new File("/sdcard");
        if (!com.yftech.service.upgrade.g.a.a(new File[]{file, file2}, file3, this)) {
            com.yftech.service.upgrade.g.b.e("startUpgrade, copy upgrade file failed");
            onUpgradeStateChanged(2);
            a(new File[]{new File(file3, f1587a), new File(file3, b)});
            return false;
        }
        onUpgradeStateChanged(7);
        onUpgradeProgressChanged(0);
        File file4 = new File(file3, f1587a);
        File file5 = new File(file3, b);
        if (c.b(file4, file5) == null) {
            com.yftech.service.upgrade.g.b.e("startUpgrade, md5 not equals");
            onUpgradeStateChanged(2);
            a(new File[]{file4, file5});
            return false;
        }
        if (nativeStartUpgrade(f1587a)) {
            onUpgradeStateChanged(1);
            a(new File[]{file4, file5});
            return true;
        }
        com.yftech.service.upgrade.g.b.e("startUpgrade, start upgrade screen failed");
        onUpgradeStateChanged(2);
        a(new File[]{file4, file5});
        return false;
    }

    @Override // com.yftech.service.upgrade.adapter.screen.a.b, com.yftech.service.upgrade.adapter.screen.a.a, com.yftech.service.upgrade.adapter.b
    public String c() {
        StringBuilder sb = new StringBuilder();
        String strC = super.c();
        if (strC != null) {
            sb.append(strC);
        }
        sb.append("project=");
        sb.append(b());
        sb.append("\n");
        return sb.toString();
    }
}
