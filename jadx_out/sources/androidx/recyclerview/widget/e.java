package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.ai;
import androidx.annotation.aw;
import androidx.annotation.ay;

/* JADX INFO: loaded from: classes.dex */
public class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f1047a = "AsyncListUtil";
    static final boolean b = false;
    final Class<T> c;
    final int d;
    final a<T> e;
    final b f;
    final af<T> g;
    final ae.b<T> h;
    final ae.a<T> i;
    boolean m;
    final int[] j = new int[2];
    final int[] k = new int[2];
    final int[] l = new int[2];
    private int r = 0;
    int n = 0;
    int o = 0;
    int p = this.o;
    final SparseIntArray q = new SparseIntArray();
    private final ae.b<T> s = new ae.b<T>() { // from class: androidx.recyclerview.widget.e.1
        private void a() {
            for (int i = 0; i < e.this.g.a(); i++) {
                e.this.i.a(e.this.g.b(i));
            }
            e.this.g.b();
        }

        private boolean a(int i) {
            return i == e.this.p;
        }

        @Override // androidx.recyclerview.widget.ae.b
        public void a(int i, int i2) {
            if (a(i)) {
                e.this.n = i2;
                e.this.f.a();
                e.this.o = e.this.p;
                a();
                e.this.m = false;
                e.this.d();
            }
        }

        @Override // androidx.recyclerview.widget.ae.b
        public void a(int i, af.a<T> aVar) {
            if (!a(i)) {
                e.this.i.a(aVar);
                return;
            }
            af.a<T> aVarA = e.this.g.a(aVar);
            if (aVarA != null) {
                Log.e(e.f1047a, "duplicate tile @" + aVarA.b);
                e.this.i.a(aVarA);
            }
            int i2 = aVar.b + aVar.c;
            int i3 = 0;
            while (i3 < e.this.q.size()) {
                int iKeyAt = e.this.q.keyAt(i3);
                if (aVar.b > iKeyAt || iKeyAt >= i2) {
                    i3++;
                } else {
                    e.this.q.removeAt(i3);
                    e.this.f.a(iKeyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ae.b
        public void b(int i, int i2) {
            if (a(i)) {
                af.a<T> aVarC = e.this.g.c(i2);
                if (aVarC != null) {
                    e.this.i.a(aVarC);
                    return;
                }
                Log.e(e.f1047a, "tile not found @" + i2);
            }
        }
    };
    private final ae.a<T> t = new ae.a<T>() { // from class: androidx.recyclerview.widget.e.2

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseBooleanArray f1049a = new SparseBooleanArray();
        private af.a<T> c;
        private int d;
        private int e;
        private int f;
        private int g;

        private af.a<T> a() {
            if (this.c == null) {
                return new af.a<>(e.this.c, e.this.d);
            }
            af.a<T> aVar = this.c;
            this.c = this.c.d;
            return aVar;
        }

        private void a(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                e.this.i.a(z ? (i2 + i) - i4 : i4, i3);
                i4 += e.this.d;
            }
        }

        private void a(String str, Object... objArr) {
            Log.d(e.f1047a, "[BKGR] " + String.format(str, objArr));
        }

        private int b(int i) {
            return i - (i % e.this.d);
        }

        private void b(af.a<T> aVar) {
            this.f1049a.put(aVar.b, true);
            e.this.h.a(this.d, aVar);
        }

        private boolean c(int i) {
            return this.f1049a.get(i);
        }

        private void d(int i) {
            this.f1049a.delete(i);
            e.this.h.b(this.d, i);
        }

        private void e(int i) {
            int iB = e.this.e.b();
            while (this.f1049a.size() >= iB) {
                int iKeyAt = this.f1049a.keyAt(0);
                int iKeyAt2 = this.f1049a.keyAt(this.f1049a.size() - 1);
                int i2 = this.f - iKeyAt;
                int i3 = iKeyAt2 - this.g;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    d(iKeyAt);
                } else {
                    if (i3 <= 0) {
                        return;
                    }
                    if (i2 >= i3 && i != 1) {
                        return;
                    } else {
                        d(iKeyAt2);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.ae.a
        public void a(int i) {
            this.d = i;
            this.f1049a.clear();
            this.e = e.this.e.a();
            e.this.h.a(this.d, this.e);
        }

        @Override // androidx.recyclerview.widget.ae.a
        public void a(int i, int i2) {
            if (c(i)) {
                return;
            }
            af.a<T> aVarA = a();
            aVarA.b = i;
            aVarA.c = Math.min(e.this.d, this.e - aVarA.b);
            e.this.e.a(aVarA.f1034a, aVarA.b, aVarA.c);
            e(i2);
            b(aVarA);
        }

        @Override // androidx.recyclerview.widget.ae.a
        public void a(int i, int i2, int i3, int i4, int i5) {
            if (i > i2) {
                return;
            }
            int iB = b(i);
            int iB2 = b(i2);
            this.f = b(i3);
            this.g = b(i4);
            if (i5 == 1) {
                a(this.f, iB2, i5, true);
                a(iB2 + e.this.d, this.g, i5, false);
            } else {
                a(iB, this.g, i5, false);
                a(this.f, iB - e.this.d, i5, true);
            }
        }

        @Override // androidx.recyclerview.widget.ae.a
        public void a(af.a<T> aVar) {
            e.this.e.a(aVar.f1034a, aVar.c);
            aVar.d = this.c;
            this.c = aVar;
        }
    };

    public static abstract class a<T> {
        @ay
        public abstract int a();

        @ay
        public void a(@androidx.annotation.ah T[] tArr, int i) {
        }

        @ay
        public abstract void a(@androidx.annotation.ah T[] tArr, int i, int i2);

        @ay
        public int b() {
            return 10;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1050a = 0;
        public static final int b = 1;
        public static final int c = 2;

        @aw
        public abstract void a();

        @aw
        public abstract void a(int i);

        @aw
        public abstract void a(@androidx.annotation.ah int[] iArr);

        @aw
        public void a(@androidx.annotation.ah int[] iArr, @androidx.annotation.ah int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }
    }

    public e(@androidx.annotation.ah Class<T> cls, int i, @androidx.annotation.ah a<T> aVar, @androidx.annotation.ah b bVar) {
        this.c = cls;
        this.d = i;
        this.e = aVar;
        this.f = bVar;
        this.g = new af<>(this.d);
        u uVar = new u();
        this.h = uVar.a(this.s);
        this.i = uVar.a(this.t);
        b();
    }

    private boolean e() {
        return this.p != this.o;
    }

    @ai
    public T a(int i) {
        if (i < 0 || i >= this.n) {
            throw new IndexOutOfBoundsException(i + " is not within 0 and " + this.n);
        }
        T tA = this.g.a(i);
        if (tA == null && !e()) {
            this.q.put(i, 0);
        }
        return tA;
    }

    public void a() {
        if (e()) {
            return;
        }
        d();
        this.m = true;
    }

    void a(String str, Object... objArr) {
        Log.d(f1047a, "[MAIN] " + String.format(str, objArr));
    }

    public void b() {
        this.q.clear();
        ae.a<T> aVar = this.i;
        int i = this.p + 1;
        this.p = i;
        aVar.a(i);
    }

    public int c() {
        return this.n;
    }

    void d() {
        this.f.a(this.j);
        if (this.j[0] > this.j[1] || this.j[0] < 0 || this.j[1] >= this.n) {
            return;
        }
        if (!this.m || this.j[0] > this.k[1] || this.k[0] > this.j[1]) {
            this.r = 0;
        } else if (this.j[0] < this.k[0]) {
            this.r = 1;
        } else if (this.j[0] > this.k[0]) {
            this.r = 2;
        }
        this.k[0] = this.j[0];
        this.k[1] = this.j[1];
        this.f.a(this.j, this.l, this.r);
        this.l[0] = Math.min(this.j[0], Math.max(this.l[0], 0));
        this.l[1] = Math.max(this.j[1], Math.min(this.l[1], this.n - 1));
        this.i.a(this.j[0], this.j[1], this.l[0], this.l[1], this.r);
    }
}
