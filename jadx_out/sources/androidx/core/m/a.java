package androidx.core.m;

import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f501a;
    private final File b;

    public a(@ah File file) {
        this.f501a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    private static boolean c(@ah FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @ah
    public File a() {
        return this.f501a;
    }

    public void a(@ai FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.b.delete();
            } catch (IOException e) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e);
            }
        }
    }

    public void b() {
        this.f501a.delete();
        this.b.delete();
    }

    public void b(@ai FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            c(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f501a.delete();
                this.b.renameTo(this.f501a);
            } catch (IOException e) {
                Log.w("AtomicFile", "failWrite: Got exception:", e);
            }
        }
    }

    @ah
    public FileOutputStream c() throws IOException {
        if (this.f501a.exists()) {
            if (this.b.exists()) {
                this.f501a.delete();
            } else if (!this.f501a.renameTo(this.b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f501a + " to backup file " + this.b);
            }
        }
        try {
            return new FileOutputStream(this.f501a);
        } catch (FileNotFoundException unused) {
            if (!this.f501a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f501a);
            }
            try {
                return new FileOutputStream(this.f501a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f501a);
            }
        }
    }

    @ah
    public FileInputStream d() {
        if (this.b.exists()) {
            this.f501a.delete();
            this.b.renameTo(this.f501a);
        }
        return new FileInputStream(this.f501a);
    }

    @ah
    public byte[] e() throws IOException {
        FileInputStream fileInputStreamD = d();
        try {
            byte[] bArr = new byte[fileInputStreamD.available()];
            int i = 0;
            while (true) {
                int i2 = fileInputStreamD.read(bArr, i, bArr.length - i);
                if (i2 <= 0) {
                    fileInputStreamD.close();
                    return bArr;
                }
                i += i2;
                int iAvailable = fileInputStreamD.available();
                if (iAvailable > bArr.length - i) {
                    byte[] bArr2 = new byte[iAvailable + i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
        } catch (Throwable th) {
            fileInputStreamD.close();
            throw th;
        }
    }
}
