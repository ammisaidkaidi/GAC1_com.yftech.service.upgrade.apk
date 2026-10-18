package androidx.c;

import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f321a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public j() {
        this(10);
    }

    public j(int i) {
        this.b = false;
        if (i == 0) {
            this.c = e.f312a;
            this.d = e.c;
        } else {
            int iA = e.a(i);
            this.c = new int[iA];
            this.d = new Object[iA];
        }
    }

    private void e() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f321a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
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
    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.c = (int[]) this.c.clone();
            jVar.d = (Object[]) this.d.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @ai
    public E a(int i) {
        return a(i, (Object) null);
    }

    public E a(int i, E e) {
        int iA = e.a(this.c, this.e, i);
        return (iA < 0 || this.d[iA] == f321a) ? e : (E) this.d[iA];
    }

    public void a(int i, int i2) {
        int iMin = Math.min(this.e, i2 + i);
        while (i < iMin) {
            d(i);
            i++;
        }
    }

    public void a(@ah j<? extends E> jVar) {
        int iB = jVar.b();
        for (int i = 0; i < iB; i++) {
            d(jVar.e(i), jVar.f(i));
        }
    }

    public boolean a(int i, E e, E e2) {
        int iG = g(i);
        if (iG < 0) {
            return false;
        }
        Object obj = this.d[iG];
        if (obj != e && (e == null || !e.equals(obj))) {
            return false;
        }
        this.d[iG] = e2;
        return true;
    }

    public int b() {
        if (this.b) {
            e();
        }
        return this.e;
    }

    @Deprecated
    public void b(int i) {
        c(i);
    }

    public boolean b(int i, Object obj) {
        int iG = g(i);
        if (iG < 0) {
            return false;
        }
        E eF = f(iG);
        if (obj != eF && (obj == null || !obj.equals(eF))) {
            return false;
        }
        d(iG);
        return true;
    }

    public boolean b(E e) {
        return a(e) >= 0;
    }

    @ai
    public E c(int i, E e) {
        int iG = g(i);
        if (iG < 0) {
            return null;
        }
        E e2 = (E) this.d[iG];
        this.d[iG] = e;
        return e2;
    }

    public void c(int i) {
        int iA = e.a(this.c, this.e, i);
        if (iA < 0 || this.d[iA] == f321a) {
            return;
        }
        this.d[iA] = f321a;
        this.b = true;
    }

    public boolean c() {
        return b() == 0;
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

    public void d(int i) {
        if (this.d[i] != f321a) {
            this.d[i] = f321a;
            this.b = true;
        }
    }

    public void d(int i, E e) {
        int iA = e.a(this.c, this.e, i);
        if (iA >= 0) {
            this.d[iA] = e;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.e && this.d[i2] == f321a) {
            this.c[i2] = i;
            this.d[i2] = e;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
            i2 = ~e.a(this.c, this.e, i);
        }
        if (this.e >= this.c.length) {
            int iA2 = e.a(this.e + 1);
            int[] iArr = new int[iA2];
            Object[] objArr = new Object[iA2];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        if (this.e - i2 != 0) {
            int i3 = i2 + 1;
            System.arraycopy(this.c, i2, this.c, i3, this.e - i2);
            System.arraycopy(this.d, i2, this.d, i3, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e++;
    }

    public int e(int i) {
        if (this.b) {
            e();
        }
        return this.c[i];
    }

    @ai
    public E e(int i, E e) {
        E eA = a(i);
        if (eA == null) {
            d(i, e);
        }
        return eA;
    }

    public E f(int i) {
        if (this.b) {
            e();
        }
        return (E) this.d[i];
    }

    public void f(int i, E e) {
        if (this.b) {
            e();
        }
        this.d[i] = e;
    }

    public int g(int i) {
        if (this.b) {
            e();
        }
        return e.a(this.c, this.e, i);
    }

    public void g(int i, E e) {
        if (this.e != 0 && i <= this.c[this.e - 1]) {
            d(i, e);
            return;
        }
        if (this.b && this.e >= this.c.length) {
            e();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int iA = e.a(i2 + 1);
            int[] iArr = new int[iA];
            Object[] objArr = new Object[iA];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i2] = i;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public boolean h(int i) {
        return g(i) >= 0;
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
            sb.append(e(i));
            sb.append('=');
            E eF = f(i);
            if (eF != this) {
                sb.append(eF);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
