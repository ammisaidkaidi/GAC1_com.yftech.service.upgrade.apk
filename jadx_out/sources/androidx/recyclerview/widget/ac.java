package androidx.recyclerview.widget;

import androidx.annotation.ai;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class ac<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1030a = -1;
    private static final int c = 10;
    private static final int d = 10;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 4;
    T[] b;
    private T[] h;
    private int i;
    private int j;
    private int k;
    private b l;
    private a m;
    private int n;
    private final Class<T> o;

    public static class a<T2> extends b<T2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b<T2> f1031a;
        private final f b;

        public a(b<T2> bVar) {
            this.f1031a = bVar;
            this.b = new f(this.f1031a);
        }

        public void a() {
            this.b.a();
        }

        @Override // androidx.recyclerview.widget.t
        public void a(int i, int i2) {
            this.b.a(i, i2);
        }

        @Override // androidx.recyclerview.widget.ac.b, androidx.recyclerview.widget.t
        public void a(int i, int i2, Object obj) {
            this.b.a(i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.ac.b
        public boolean a(T2 t2, T2 t3) {
            return this.f1031a.a(t2, t3);
        }

        @Override // androidx.recyclerview.widget.t
        public void b(int i, int i2) {
            this.b.b(i, i2);
        }

        @Override // androidx.recyclerview.widget.ac.b
        public boolean b(T2 t2, T2 t3) {
            return this.f1031a.b(t2, t3);
        }

        @Override // androidx.recyclerview.widget.ac.b
        @ai
        public Object c(T2 t2, T2 t3) {
            return this.f1031a.c(t2, t3);
        }

        @Override // androidx.recyclerview.widget.t
        public void c(int i, int i2) {
            this.b.c(i, i2);
        }

        @Override // androidx.recyclerview.widget.ac.b, java.util.Comparator
        public int compare(T2 t2, T2 t3) {
            return this.f1031a.compare(t2, t3);
        }

        @Override // androidx.recyclerview.widget.ac.b
        public void d(int i, int i2) {
            this.b.a(i, i2, null);
        }
    }

    public static abstract class b<T2> implements t, Comparator<T2> {
        @Override // androidx.recyclerview.widget.t
        public void a(int i, int i2, Object obj) {
            d(i, i2);
        }

        public abstract boolean a(T2 t2, T2 t3);

        public abstract boolean b(T2 t2, T2 t3);

        @ai
        public Object c(T2 t2, T2 t3) {
            return null;
        }

        public abstract int compare(T2 t2, T2 t3);

        public abstract void d(int i, int i2);
    }

    public ac(@androidx.annotation.ah Class<T> cls, @androidx.annotation.ah b<T> bVar) {
        this(cls, bVar, 10);
    }

    public ac(@androidx.annotation.ah Class<T> cls, @androidx.annotation.ah b<T> bVar, int i) {
        this.o = cls;
        this.b = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.l = bVar;
        this.n = 0;
    }

    private int a(T t, int i, int i2, int i3) {
        T t2;
        for (int i4 = i - 1; i4 >= i2; i4--) {
            T t3 = this.b[i4];
            if (this.l.compare(t3, t) != 0) {
                break;
            }
            if (this.l.b(t3, t)) {
                return i4;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -1;
            }
            t2 = this.b[i];
            if (this.l.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.l.b(t2, t));
        return i;
    }

    private int a(T t, boolean z) {
        int iA = a(t, this.b, 0, this.n, 1);
        if (iA == -1) {
            iA = 0;
        } else if (iA < this.n) {
            T t2 = this.b[iA];
            if (this.l.b(t2, t)) {
                if (this.l.a(t2, t)) {
                    this.b[iA] = t;
                    return iA;
                }
                this.b[iA] = t;
                this.l.a(iA, 1, this.l.c(t2, t));
                return iA;
            }
        }
        b(iA, t);
        if (z) {
            this.l.a(iA, 1);
        }
        return iA;
    }

    private int a(T t, T[] tArr, int i, int i2) {
        while (i < i2) {
            if (this.l.b(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int a(T t, T[] tArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            T t2 = tArr[i4];
            int iCompare = this.l.compare(t2, t);
            if (iCompare < 0) {
                i = i4 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.l.b(t2, t)) {
                        return i4;
                    }
                    int iA = a(t, i4, i, i2);
                    return (i3 == 1 && iA == -1) ? i4 : iA;
                }
                i2 = i4;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    private void a(int i, boolean z) {
        System.arraycopy(this.b, i + 1, this.b, i, (this.n - i) - 1);
        this.n--;
        this.b[this.n] = null;
        if (z) {
            this.l.b(i, 1);
        }
    }

    private void a(T[] tArr, int i) {
        int i2 = 0;
        boolean z = !(this.l instanceof a);
        if (z) {
            b();
        }
        this.h = this.b;
        this.i = 0;
        this.j = this.n;
        this.b = (T[]) ((Object[]) Array.newInstance((Class<?>) this.o, this.n + i + 10));
        this.k = 0;
        while (true) {
            if (this.i >= this.j && i2 >= i) {
                break;
            }
            if (this.i == this.j) {
                int i3 = i - i2;
                System.arraycopy(tArr, i2, this.b, this.k, i3);
                this.k += i3;
                this.n += i3;
                this.l.a(this.k - i3, i3);
                break;
            }
            if (i2 == i) {
                int i4 = this.j - this.i;
                System.arraycopy(this.h, this.i, this.b, this.k, i4);
                this.k += i4;
                break;
            }
            T t = this.h[this.i];
            T t2 = tArr[i2];
            int iCompare = this.l.compare(t, t2);
            if (iCompare > 0) {
                T[] tArr2 = this.b;
                int i5 = this.k;
                this.k = i5 + 1;
                tArr2[i5] = t2;
                this.n++;
                i2++;
                this.l.a(this.k - 1, 1);
            } else if (iCompare == 0 && this.l.b(t, t2)) {
                T[] tArr3 = this.b;
                int i6 = this.k;
                this.k = i6 + 1;
                tArr3[i6] = t2;
                i2++;
                this.i++;
                if (!this.l.a(t, t2)) {
                    this.l.a(this.k - 1, 1, this.l.c(t, t2));
                }
            } else {
                T[] tArr4 = this.b;
                int i7 = this.k;
                this.k = i7 + 1;
                tArr4[i7] = t;
                this.i++;
            }
        }
        this.h = null;
        if (z) {
            c();
        }
    }

    private void b(int i, T t) {
        if (i > this.n) {
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.n);
        }
        if (this.n == this.b.length) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) this.o, this.b.length + 10));
            System.arraycopy(this.b, 0, tArr, 0, i);
            tArr[i] = t;
            System.arraycopy(this.b, i, tArr, i + 1, this.n - i);
            this.b = tArr;
        } else {
            System.arraycopy(this.b, i, this.b, i + 1, this.n - i);
            this.b[i] = t;
        }
        this.n++;
    }

    private boolean b(T t, boolean z) {
        int iA = a(t, this.b, 0, this.n, 2);
        if (iA == -1) {
            return false;
        }
        a(iA, z);
        return true;
    }

    private void c(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iE = e(tArr);
        if (this.n != 0) {
            a(tArr, iE);
            return;
        }
        this.b = tArr;
        this.n = iE;
        this.l.a(0, iE);
    }

    private void d(T t) {
        this.b[this.k] = t;
        this.k++;
        this.n++;
        this.l.a(this.k - 1, 1);
    }

    private void d(@androidx.annotation.ah T[] tArr) {
        boolean z = !(this.l instanceof a);
        if (z) {
            b();
        }
        this.i = 0;
        this.j = this.n;
        this.h = this.b;
        this.k = 0;
        int iE = e(tArr);
        this.b = (T[]) ((Object[]) Array.newInstance((Class<?>) this.o, iE));
        while (true) {
            if (this.k >= iE && this.i >= this.j) {
                break;
            }
            if (this.i >= this.j) {
                int i = this.k;
                int i2 = iE - this.k;
                System.arraycopy(tArr, i, this.b, i, i2);
                this.k += i2;
                this.n += i2;
                this.l.a(i, i2);
                break;
            }
            if (this.k >= iE) {
                int i3 = this.j - this.i;
                this.n -= i3;
                this.l.b(this.k, i3);
                break;
            }
            T t = this.h[this.i];
            T t2 = tArr[this.k];
            int iCompare = this.l.compare(t, t2);
            if (iCompare < 0) {
                e();
            } else if (iCompare > 0) {
                d(t2);
            } else if (this.l.b(t, t2)) {
                this.b[this.k] = t2;
                this.i++;
                this.k++;
                if (!this.l.a(t, t2)) {
                    this.l.a(this.k - 1, 1, this.l.c(t, t2));
                }
            } else {
                e();
                d(t2);
            }
        }
        this.h = null;
        if (z) {
            c();
        }
    }

    private int e(@androidx.annotation.ah T[] tArr) {
        int i = 0;
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.l);
        int i2 = 1;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            if (this.l.compare(tArr[i], t) == 0) {
                int iA = a(t, tArr, i, i2);
                if (iA != -1) {
                    tArr[iA] = t;
                } else {
                    if (i2 != i3) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i3) {
                    tArr[i2] = t;
                }
                int i4 = i2;
                i2++;
                i = i4;
            }
        }
        return i2;
    }

    private void e() {
        this.n--;
        this.i++;
        this.l.b(this.k, 1);
    }

    private void f() {
        if (this.h != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    private T[] f(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.o, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    public int a() {
        return this.n;
    }

    public int a(T t) {
        f();
        return a((Object) t, true);
    }

    public T a(int i) {
        f();
        T tC = c(i);
        a(i, true);
        return tC;
    }

    public void a(int i, T t) {
        f();
        T tC = c(i);
        boolean z = tC == t || !this.l.a(tC, t);
        if (tC != t && this.l.compare(tC, t) == 0) {
            this.b[i] = t;
            if (z) {
                this.l.a(i, 1, this.l.c(tC, t));
                return;
            }
            return;
        }
        if (z) {
            this.l.a(i, 1, this.l.c(tC, t));
        }
        a(i, false);
        int iA = a((Object) t, false);
        if (i != iA) {
            this.l.c(i, iA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@androidx.annotation.ah Collection<T> collection) {
        a(collection.toArray((Object[]) Array.newInstance((Class<?>) this.o, collection.size())), true);
    }

    public void a(@androidx.annotation.ah T... tArr) {
        a((Object[]) tArr, false);
    }

    public void a(@androidx.annotation.ah T[] tArr, boolean z) {
        f();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            c((Object[]) tArr);
        } else {
            c((Object[]) f(tArr));
        }
    }

    public void b() {
        f();
        if (this.l instanceof a) {
            return;
        }
        if (this.m == null) {
            this.m = new a(this.l);
        }
        this.l = this.m;
    }

    public void b(int i) {
        f();
        T tC = c(i);
        a(i, false);
        int iA = a((Object) tC, false);
        if (i != iA) {
            this.l.c(i, iA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(@androidx.annotation.ah Collection<T> collection) {
        b(collection.toArray((Object[]) Array.newInstance((Class<?>) this.o, collection.size())), true);
    }

    public void b(@androidx.annotation.ah T... tArr) {
        b((Object[]) tArr, false);
    }

    public void b(@androidx.annotation.ah T[] tArr, boolean z) {
        f();
        if (z) {
            d((Object[]) tArr);
        } else {
            d((Object[]) f(tArr));
        }
    }

    public boolean b(T t) {
        f();
        return b((Object) t, true);
    }

    public int c(T t) {
        if (this.h == null) {
            return a(t, this.b, 0, this.n, 4);
        }
        int iA = a(t, this.b, 0, this.k, 4);
        if (iA != -1) {
            return iA;
        }
        int iA2 = a(t, this.h, this.i, this.j, 4);
        if (iA2 != -1) {
            return (iA2 - this.i) + this.k;
        }
        return -1;
    }

    public T c(int i) {
        if (i < this.n && i >= 0) {
            return (this.h == null || i < this.k) ? this.b[i] : this.h[(i - this.k) + this.i];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.n);
    }

    public void c() {
        f();
        if (this.l instanceof a) {
            ((a) this.l).a();
        }
        if (this.l == this.m) {
            this.l = this.m.f1031a;
        }
    }

    public void d() {
        f();
        if (this.n == 0) {
            return;
        }
        int i = this.n;
        Arrays.fill(this.b, 0, i, (Object) null);
        this.n = 0;
        this.l.b(0, i);
    }
}
