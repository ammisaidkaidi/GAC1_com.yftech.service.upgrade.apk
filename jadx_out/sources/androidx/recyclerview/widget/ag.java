package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1035a = 1;
    static final int b = 2;
    static final int c = 4;
    static final int d = 0;
    static final int e = 1;
    static final int f = 2;
    static final int g = 4;
    static final int h = 4;
    static final int i = 16;
    static final int j = 32;
    static final int k = 64;
    static final int l = 8;
    static final int m = 256;
    static final int n = 512;
    static final int o = 1024;
    static final int p = 12;
    static final int q = 4096;
    static final int r = 8192;
    static final int s = 16384;
    static final int t = 7;
    final b u;
    a v = new a();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1036a = 0;
        int b;
        int c;
        int d;
        int e;

        a() {
        }

        int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void a() {
            this.f1036a = 0;
        }

        void a(int i) {
            this.f1036a = i | this.f1036a;
        }

        void a(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        boolean b() {
            if ((this.f1036a & 7) != 0 && (this.f1036a & (a(this.d, this.b) << 0)) == 0) {
                return false;
            }
            if ((this.f1036a & 112) != 0 && (this.f1036a & (a(this.d, this.c) << 4)) == 0) {
                return false;
            }
            if ((this.f1036a & 1792) != 0 && (this.f1036a & (a(this.e, this.b) << 8)) == 0) {
                return false;
            }
            if ((this.f1036a & 28672) != 0) {
                return ((a(this.e, this.c) << 12) & this.f1036a) != 0;
            }
            return true;
        }
    }

    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    ag(b bVar) {
        this.u = bVar;
    }

    View a(int i2, int i3, int i4, int i5) {
        int iA = this.u.a();
        int iB = this.u.b();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View viewA = this.u.a(i2);
            this.v.a(iA, iB, this.u.a(viewA), this.u.b(viewA));
            if (i4 != 0) {
                this.v.a();
                this.v.a(i4);
                if (this.v.b()) {
                    return viewA;
                }
            }
            if (i5 != 0) {
                this.v.a();
                this.v.a(i5);
                if (this.v.b()) {
                    view = viewA;
                }
            }
            i2 += i6;
        }
        return view;
    }

    boolean a(View view, int i2) {
        this.v.a(this.u.a(), this.u.b(), this.u.a(view), this.u.b(view));
        if (i2 == 0) {
            return false;
        }
        this.v.a();
        this.v.a(i2);
        return this.v.b();
    }
}
