package a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    protected abstract int a();

    protected int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i3 + i] = (byte) i4;
        }
        return i2;
    }

    public void a(InputStream inputStream, OutputStream outputStream) {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        a(pushbackInputStream, outputStream);
        while (true) {
            try {
                int iC = c(pushbackInputStream, outputStream);
                int iA = 0;
                while (a() + iA < iC) {
                    a(pushbackInputStream, outputStream, a());
                    a();
                    iA += a();
                }
                if (a() + iA == iC) {
                    a(pushbackInputStream, outputStream, a());
                    a();
                } else {
                    a(pushbackInputStream, outputStream, iC - iA);
                }
                d(pushbackInputStream, outputStream);
            } catch (d unused) {
                b(pushbackInputStream, outputStream);
                return;
            }
        }
    }

    protected void a(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }

    protected void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) throws d {
        throw new d();
    }

    public byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] a(String str) {
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayInputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected abstract int b();

    public ByteBuffer b(InputStream inputStream) {
        return ByteBuffer.wrap(a(inputStream));
    }

    public ByteBuffer b(String str) {
        return ByteBuffer.wrap(a(str));
    }

    protected void b(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }

    protected int c(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
        return b();
    }

    protected void d(PushbackInputStream pushbackInputStream, OutputStream outputStream) {
    }
}
