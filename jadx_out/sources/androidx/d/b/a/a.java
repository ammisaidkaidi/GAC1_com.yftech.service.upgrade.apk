package androidx.d.b.a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f593a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    C0046a[] e;
    private final double[] l;

    /* JADX INFO: renamed from: androidx.d.b.a.a$a, reason: collision with other inner class name */
    private static class C0046a {
        private static final String s = "Arc";
        private static double[] t = new double[91];
        private static final double u = 0.001d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double[] f594a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;

        C0046a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            this.r = false;
            this.q = i == 1;
            this.c = d;
            this.d = d2;
            this.i = 1.0d / (this.d - this.c);
            if (3 == i) {
                this.r = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (!this.r && Math.abs(d7) >= u && Math.abs(d8) >= u) {
                this.f594a = new double[101];
                this.j = d7 * ((double) (this.q ? -1 : 1));
                this.k = d8 * ((double) (this.q ? 1 : -1));
                this.l = this.q ? d5 : d3;
                this.m = this.q ? d4 : d6;
                a(d3, d4, d5, d6);
                this.n = this.b * this.i;
                return;
            }
            this.r = true;
            this.e = d3;
            this.f = d5;
            this.g = d4;
            this.h = d6;
            this.b = Math.hypot(d8, d7);
            this.n = this.b * this.i;
            this.l = d7 / (this.d - this.c);
            this.m = d8 / (this.d - this.c);
        }

        private void a(double d, double d2, double d3, double d4) {
            double dHypot;
            double d5 = d3 - d;
            double d6 = d2 - d4;
            int i = 0;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            while (i < t.length) {
                double d10 = d7;
                double radians = Math.toRadians((((double) i) * 90.0d) / ((double) (t.length - 1)));
                double dSin = Math.sin(radians) * d5;
                double dCos = Math.cos(radians) * d6;
                if (i > 0) {
                    dHypot = d10 + Math.hypot(dSin - d8, dCos - d9);
                    t[i] = dHypot;
                } else {
                    dHypot = d10;
                }
                i++;
                d9 = dCos;
                d7 = dHypot;
                d8 = dSin;
            }
            double d11 = d7;
            this.b = d11;
            for (int i2 = 0; i2 < t.length; i2++) {
                double[] dArr = t;
                dArr[i2] = dArr[i2] / d11;
            }
            for (int i3 = 0; i3 < this.f594a.length; i3++) {
                double length = ((double) i3) / ((double) (this.f594a.length - 1));
                int iBinarySearch = Arrays.binarySearch(t, length);
                if (iBinarySearch >= 0) {
                    this.f594a[i3] = iBinarySearch / (t.length - 1);
                } else if (iBinarySearch == -1) {
                    this.f594a[i3] = 0.0d;
                } else {
                    int i4 = -iBinarySearch;
                    int i5 = i4 - 2;
                    this.f594a[i3] = (((double) i5) + ((length - t[i5]) / (t[i4 - 1] - t[i5]))) / ((double) (t.length - 1));
                }
            }
        }

        double a() {
            return this.l + (this.j * this.o);
        }

        void a(double d) {
            double dF = f((this.q ? this.d - d : d - this.c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(dF);
            this.p = Math.cos(dF);
        }

        double b() {
            return this.m + (this.k * this.p);
        }

        public double b(double d) {
            return this.e + ((d - this.c) * this.i * (this.f - this.e));
        }

        double c() {
            double d = this.j * this.p;
            double dHypot = this.n / Math.hypot(d, (-this.k) * this.o);
            if (this.q) {
                d = -d;
            }
            return d * dHypot;
        }

        public double c(double d) {
            return this.g + ((d - this.c) * this.i * (this.h - this.g));
        }

        double d() {
            double d = this.j * this.p;
            double d2 = (-this.k) * this.o;
            double dHypot = this.n / Math.hypot(d, d2);
            return this.q ? (-d2) * dHypot : d2 * dHypot;
        }

        public double d(double d) {
            return this.l;
        }

        public double e(double d) {
            return this.m;
        }

        double f(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double length = d * ((double) (this.f594a.length - 1));
            int i = (int) length;
            return this.f594a[i] + ((length - ((double) i)) * (this.f594a[i + 1] - this.f594a[i]));
        }
    }

    public a(int[] iArr, double[] dArr, double[][] dArr2) {
        this.l = dArr;
        this.e = new C0046a[dArr.length - 1];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < this.e.length) {
            int i5 = 2;
            switch (iArr[i2]) {
                case 0:
                    i4 = 3;
                    break;
                case 1:
                    i3 = 1;
                    i4 = i3;
                    break;
                case 3:
                    if (i3 != 1) {
                        i5 = 1;
                        break;
                    }
                case 2:
                    i3 = i5;
                    i4 = i3;
                    break;
            }
            int i6 = i2 + 1;
            this.e[i2] = new C0046a(i4, dArr[i2], dArr[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
            i2 = i6;
        }
    }

    @Override // androidx.d.b.a.b
    public double a(double d2, int i2) {
        if (d2 < this.e[0].c) {
            d2 = this.e[0].c;
        } else if (d2 > this.e[this.e.length - 1].d) {
            d2 = this.e[this.e.length - 1].d;
        }
        for (int i3 = 0; i3 < this.e.length; i3++) {
            if (d2 <= this.e[i3].d) {
                if (this.e[i3].r) {
                    return i2 == 0 ? this.e[i3].b(d2) : this.e[i3].c(d2);
                }
                this.e[i3].a(d2);
                return i2 == 0 ? this.e[i3].a() : this.e[i3].b();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.d.b.a.b
    public void a(double d2, double[] dArr) {
        if (d2 < this.e[0].c) {
            d2 = this.e[0].c;
        }
        if (d2 > this.e[this.e.length - 1].d) {
            d2 = this.e[this.e.length - 1].d;
        }
        for (int i2 = 0; i2 < this.e.length; i2++) {
            if (d2 <= this.e[i2].d) {
                if (this.e[i2].r) {
                    dArr[0] = this.e[i2].b(d2);
                    dArr[1] = this.e[i2].c(d2);
                    return;
                } else {
                    this.e[i2].a(d2);
                    dArr[0] = this.e[i2].a();
                    dArr[1] = this.e[i2].b();
                    return;
                }
            }
        }
    }

    @Override // androidx.d.b.a.b
    public void a(double d2, float[] fArr) {
        if (d2 < this.e[0].c) {
            d2 = this.e[0].c;
        } else if (d2 > this.e[this.e.length - 1].d) {
            d2 = this.e[this.e.length - 1].d;
        }
        for (int i2 = 0; i2 < this.e.length; i2++) {
            if (d2 <= this.e[i2].d) {
                if (this.e[i2].r) {
                    fArr[0] = (float) this.e[i2].b(d2);
                    fArr[1] = (float) this.e[i2].c(d2);
                    return;
                } else {
                    this.e[i2].a(d2);
                    fArr[0] = (float) this.e[i2].a();
                    fArr[1] = (float) this.e[i2].b();
                    return;
                }
            }
        }
    }

    @Override // androidx.d.b.a.b
    public double[] a() {
        return this.l;
    }

    @Override // androidx.d.b.a.b
    public double b(double d2, int i2) {
        if (d2 < this.e[0].c) {
            d2 = this.e[0].c;
        }
        if (d2 > this.e[this.e.length - 1].d) {
            d2 = this.e[this.e.length - 1].d;
        }
        for (int i3 = 0; i3 < this.e.length; i3++) {
            if (d2 <= this.e[i3].d) {
                if (this.e[i3].r) {
                    return i2 == 0 ? this.e[i3].d(d2) : this.e[i3].e(d2);
                }
                this.e[i3].a(d2);
                return i2 == 0 ? this.e[i3].c() : this.e[i3].d();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.d.b.a.b
    public void b(double d2, double[] dArr) {
        if (d2 < this.e[0].c) {
            d2 = this.e[0].c;
        } else if (d2 > this.e[this.e.length - 1].d) {
            d2 = this.e[this.e.length - 1].d;
        }
        for (int i2 = 0; i2 < this.e.length; i2++) {
            if (d2 <= this.e[i2].d) {
                if (this.e[i2].r) {
                    dArr[0] = this.e[i2].d(d2);
                    dArr[1] = this.e[i2].e(d2);
                    return;
                } else {
                    this.e[i2].a(d2);
                    dArr[0] = this.e[i2].c();
                    dArr[1] = this.e[i2].d();
                    return;
                }
            }
        }
    }
}
