package androidx.c;

import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f313a = new Object();
    private boolean b;
    private long[] c;
    private Object[] d;
    private int e;

    public f() {
        this(10);
    }

    public f(int i) {
        this.b = false;
        if (i == 0) {
            this.c = e.b;
            this.d = e.c;
        } else {
            int iB = e.b(i);
            this.c = new long[iB];
            this.d = new Object[iB];
        }
    }

    private void e() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f313a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public int a(E e) {
        if (this.b) {
            e();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.c = (long[]) this.c.clone();
            fVar.d = (Object[]) this.d.clone();
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @ai
    public E a(long j) {
        return a(j, (Object) null);
    }

    public E a(long j, E e) {
        int iA = e.a(this.c, this.e, j);
        return (iA < 0 || this.d[iA] == f313a) ? e : (E) this.d[iA];
    }

    public void a(int i) {
        if (this.d[i] != f313a) {
            this.d[i] = f313a;
            this.b = true;
        }
    }

    public void a(int i, E e) {
        if (this.b) {
            e();
        }
        this.d[i] = e;
    }

    public void a(@ah f<? extends E> fVar) {
        int iB = fVar.b();
        for (int i = 0; i < iB; i++) {
            d(fVar.b(i), fVar.c(i));
        }
    }

    public boolean a(long j, E e, E e2) {
        int iD = d(j);
        if (iD < 0) {
            return false;
        }
        Object obj = this.d[iD];
        if (obj != e && (e == null || !e.equals(obj))) {
            return false;
        }
        this.d[iD] = e2;
        return true;
    }

    public int b() {
        if (this.b) {
            e();
        }
        return this.e;
    }

    public long b(int i) {
        if (this.b) {
            e();
        }
        return this.c[i];
    }

    @Deprecated
    public void b(long j) {
        c(j);
    }

    public boolean b(long j, Object obj) {
        int iD = d(j);
        if (iD < 0) {
            return false;
        }
        E eC = c(iD);
        if (obj != eC && (obj == null || !obj.equals(eC))) {
            return false;
        }
        a(iD);
        return true;
    }

    public boolean b(E e) {
        return a(e) >= 0;
    }

    public E c(int i) {
        if (this.b) {
            e();
        }
        return (E) this.d[i];
    }

    @ai
    public E c(long j, E e) {
        int iD = d(j);
        if (iD < 0) {
            return null;
        }
        E e2 = (E) this.d[iD];
        this.d[iD] = e;
        return e2;
    }

    public void c(long j) {
        int iA = e.a(this.c, this.e, j);
        if (iA < 0 || this.d[iA] == f313a) {
            return;
        }
        this.d[iA] = f313a;
        this.b = true;
    }

    public boolean c() {
        return b() == 0;
    }

    public int d(long j) {
        if (this.b) {
            e();
        }
        return e.a(this.c, this.e, j);
    }

    public void d() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void d(long j, E e) {
        int iA = e.a(this.c, this.e, j);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int i = ~iA;
        if (i < this.e && this.d[i] == f313a) {
            this.c[i] = j;
            this.d[i] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
            i = ~e.a(this.c, this.e, j);
        }
        if (this.e >= this.c.length) {
            int iB = e.b(this.e + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        if (this.e - i != 0) {
            int i2 = i + 1;
            System.arraycopy(this.c, i, this.c, i2, this.e - i);
            System.arraycopy(this.d, i, this.d, i2, this.e - i);
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    @ai
    public E e(long j, E e) {
        E eA = a(j);
        if (eA == null) {
            d(j, e);
        }
        return eA;
    }

    public boolean e(long j) {
        return d(j) >= 0;
    }

    public void f(long j, E e) {
        if (this.e != 0 && j <= this.c[this.e - 1]) {
            d(j, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
        }
        int i = this.e;
        if (i >= this.c.length) {
            int iB = e.b(i + 1);
            long[] jArr = new long[iB];
            Object[] objArr = new Object[iB];
            System.arraycopy(this.c, 0, jArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i] = j;
        this.d[i] = e;
        this.e = i + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            E eC = c(i);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
