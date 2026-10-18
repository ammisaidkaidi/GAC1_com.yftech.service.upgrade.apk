package androidx.d.b.a;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f599a = "LinearCurveFit";
    private double[] b;
    private double[][] c;
    private double d;

    public e(double[] dArr, double[][] dArr2) {
        this.d = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.b = dArr;
        this.c = dArr2;
        if (length2 > 2) {
            int i = 0;
            double d = 0.0d;
            double d2 = 0.0d;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
            this.d = 0.0d;
        }
    }

    private double a(double d) {
        if (Double.isNaN(this.d)) {
            return 0.0d;
        }
        int length = this.b.length;
        if (d <= this.b[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d >= this.b[i]) {
            return this.d;
        }
        double dHypot = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        while (i2 < i) {
            double d4 = this.c[i2][0];
            double d5 = this.c[i2][1];
            if (i2 > 0) {
                dHypot += Math.hypot(d4 - d2, d5 - d3);
            }
            if (d == this.b[i2]) {
                return dHypot;
            }
            int i3 = i2 + 1;
            if (d < this.b[i3]) {
                double d6 = (d - this.b[i2]) / (this.b[i3] - this.b[i2]);
                double d7 = 1.0d - d6;
                return dHypot + Math.hypot(d5 - ((this.c[i2][1] * d7) + (this.c[i3][1] * d6)), d4 - ((this.c[i2][0] * d7) + (this.c[i3][0] * d6)));
            }
            i2 = i3;
            d2 = d4;
            d3 = d5;
        }
        return 0.0d;
    }

    @Override // androidx.d.b.a.b
    public double a(double d, int i) {
        int length = this.b.length;
        int i2 = 0;
        if (d <= this.b[0]) {
            return this.c[0][i];
        }
        int i3 = length - 1;
        if (d >= this.b[i3]) {
            return this.c[i3][i];
        }
        while (i2 < i3) {
            if (d == this.b[i2]) {
                return this.c[i2][i];
            }
            int i4 = i2 + 1;
            if (d < this.b[i4]) {
                double d2 = (d - this.b[i2]) / (this.b[i4] - this.b[i2]);
                return (this.c[i2][i] * (1.0d - d2)) + (this.c[i4][i] * d2);
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.d.b.a.b
    public void a(double d, double[] dArr) {
        int length = this.b.length;
        int i = 0;
        int length2 = this.c[0].length;
        if (d <= this.b[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                dArr[i2] = this.c[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= this.b[i3]) {
            while (i < length2) {
                dArr[i] = this.c[i3][i];
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            if (d == this.b[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.c[i4][i5];
                }
            }
            int i6 = i4 + 1;
            if (d < this.b[i6]) {
                double d2 = (d - this.b[i4]) / (this.b[i6] - this.b[i4]);
                while (i < length2) {
                    dArr[i] = (this.c[i4][i] * (1.0d - d2)) + (this.c[i6][i] * d2);
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // androidx.d.b.a.b
    public void a(double d, float[] fArr) {
        int length = this.b.length;
        int i = 0;
        int length2 = this.c[0].length;
        if (d <= this.b[0]) {
            for (int i2 = 0; i2 < length2; i2++) {
                fArr[i2] = (float) this.c[0][i2];
            }
            return;
        }
        int i3 = length - 1;
        if (d >= this.b[i3]) {
            while (i < length2) {
                fArr[i] = (float) this.c[i3][i];
                i++;
            }
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            if (d == this.b[i4]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.c[i4][i5];
                }
            }
            int i6 = i4 + 1;
            if (d < this.b[i6]) {
                double d2 = (d - this.b[i4]) / (this.b[i6] - this.b[i4]);
                while (i < length2) {
                    fArr[i] = (float) ((this.c[i4][i] * (1.0d - d2)) + (this.c[i6][i] * d2));
                    i++;
                }
                return;
            }
            i4 = i6;
        }
    }

    @Override // androidx.d.b.a.b
    public double[] a() {
        return this.b;
    }

    @Override // androidx.d.b.a.b
    public double b(double d, int i) {
        double d2;
        int length = this.b.length;
        int i2 = 0;
        if (d < this.b[0]) {
            d2 = this.b[0];
        } else {
            int i3 = length - 1;
            d2 = d >= this.b[i3] ? this.b[i3] : d;
        }
        while (i2 < length - 1) {
            int i4 = i2 + 1;
            if (d2 <= this.b[i4]) {
                double d3 = this.b[i4] - this.b[i2];
                double d4 = this.b[i2];
                return (this.c[i4][i] - this.c[i2][i]) / d3;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.d.b.a.b
    public void b(double d, double[] dArr) {
        double d2;
        int length = this.b.length;
        int length2 = this.c[0].length;
        if (d <= this.b[0]) {
            d2 = this.b[0];
        } else {
            int i = length - 1;
            d2 = d >= this.b[i] ? this.b[i] : d;
        }
        int i2 = 0;
        while (i2 < length - 1) {
            int i3 = i2 + 1;
            if (d2 <= this.b[i3]) {
                double d3 = this.b[i3] - this.b[i2];
                double d4 = this.b[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    dArr[i4] = (this.c[i3][i4] - this.c[i2][i4]) / d3;
                }
                return;
            }
            i2 = i3;
        }
    }
}
