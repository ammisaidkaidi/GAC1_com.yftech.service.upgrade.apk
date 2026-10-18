package a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected PrintStream f1a;

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    private byte[] c(ByteBuffer byteBuffer) {
        byte[] bArrArray;
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            if (bArrArray.length == byteBuffer.capacity() && bArrArray.length == byteBuffer.remaining()) {
                byteBuffer.position(byteBuffer.limit());
            } else {
                bArrArray = null;
            }
        } else {
            bArrArray = null;
        }
        if (bArrArray != null) {
            return bArrArray;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    protected abstract int a();

    protected int a(InputStream inputStream, byte[] bArr) throws IOException {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = inputStream.read();
            if (i2 == -1) {
                return i;
            }
            bArr[i] = (byte) i2;
        }
        return bArr.length;
    }

    public String a(ByteBuffer byteBuffer) {
        return a(c(byteBuffer));
    }

    public String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }

    public void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[b()];
        a(outputStream);
        while (true) {
            int iA = a(inputStream, bArr);
            if (iA == 0) {
                break;
            }
            a(outputStream, iA);
            int iA2 = 0;
            while (iA2 < iA) {
                if (a() + iA2 <= iA) {
                    a(outputStream, bArr, iA2, a());
                } else {
                    a(outputStream, bArr, iA2, iA - iA2);
                }
                iA2 += a();
            }
            if (iA < b()) {
                break;
            } else {
                c(outputStream);
            }
        }
        b(outputStream);
    }

    protected void a(OutputStream outputStream) {
        this.f1a = new PrintStream(outputStream);
    }

    protected void a(OutputStream outputStream, int i) {
    }

    protected abstract void a(OutputStream outputStream, byte[] bArr, int i, int i2);

    public void a(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        a(c(byteBuffer), outputStream);
    }

    public void a(byte[] bArr, OutputStream outputStream) throws IOException {
        a(new ByteArrayInputStream(bArr), outputStream);
    }

    protected abstract int b();

    public String b(ByteBuffer byteBuffer) {
        return b(c(byteBuffer));
    }

    public String b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(new ByteArrayInputStream(bArr), byteArrayOutputStream);
            return byteArrayOutputStream.toString();
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
    }

    public void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        int iA;
        byte[] bArr = new byte[b()];
        a(outputStream);
        do {
            iA = a(inputStream, bArr);
            if (iA == 0) {
                break;
            }
            a(outputStream, iA);
            int iA2 = 0;
            while (iA2 < iA) {
                if (a() + iA2 <= iA) {
                    a(outputStream, bArr, iA2, a());
                } else {
                    a(outputStream, bArr, iA2, iA - iA2);
                }
                iA2 += a();
            }
            c(outputStream);
        } while (iA >= b());
        b(outputStream);
    }

    protected void b(OutputStream outputStream) {
    }

    public void b(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        b(c(byteBuffer), outputStream);
    }

    public void b(byte[] bArr, OutputStream outputStream) throws IOException {
        b(new ByteArrayInputStream(bArr), outputStream);
    }

    protected void c(OutputStream outputStream) {
        this.f1a.println();
    }
}
