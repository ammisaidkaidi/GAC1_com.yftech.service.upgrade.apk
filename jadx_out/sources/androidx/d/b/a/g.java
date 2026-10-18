package androidx.d.b.a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f601a = "Oscillator";
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 6;
    double[] d;
    int l;
    float[] b = new float[0];
    double[] c = new double[0];
    double m = 6.283185307179586d;
    private boolean n = false;

    double a(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.c, d);
        if (iBinarySearch > 0) {
            return 1.0d;
        }
        if (iBinarySearch == 0) {
            return 0.0d;
        }
        int i2 = (-iBinarySearch) - 1;
        int i3 = i2 - 1;
        double d2 = ((double) (this.b[i2] - this.b[i3])) / (this.c[i2] - this.c[i3]);
        return this.d[i3] + ((((double) this.b[i3]) - (this.c[i3] * d2)) * (d - this.c[i3])) + ((d2 * ((d * d) - (this.c[i3] * this.c[i3]))) / 2.0d);
    }

    public void a() {
        double d = 0.0d;
        for (int i2 = 0; i2 < this.b.length; i2++) {
            d += (double) this.b[i2];
        }
        double d2 = 0.0d;
        for (int i3 = 1; i3 < this.b.length; i3++) {
            int i4 = i3 - 1;
            d2 += (this.c[i3] - this.c[i4]) * ((double) ((this.b[i4] + this.b[i3]) / 2.0f));
        }
        for (int i5 = 0; i5 < this.b.length; i5++) {
            float[] fArr = this.b;
            fArr[i5] = (float) (((double) fArr[i5]) * (d / d2));
        }
        this.d[0] = 0.0d;
        for (int i6 = 1; i6 < this.b.length; i6++) {
            int i7 = i6 - 1;
            this.d[i6] = this.d[i7] + ((this.c[i6] - this.c[i7]) * ((double) ((this.b[i7] + this.b[i6]) / 2.0f)));
        }
        this.n = true;
    }

    public void a(double d, float f2) {
        int length = this.b.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.c, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.c = Arrays.copyOf(this.c, length);
        this.b = Arrays.copyOf(this.b, length);
        this.d = new double[length];
        System.arraycopy(this.c, iBinarySearch, this.c, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.c[iBinarySearch] = d;
        this.b[iBinarySearch] = f2;
        this.n = false;
    }

    public void a(int i2) {
        this.l = i2;
    }

    public double b(double d) {
        switch (this.l) {
            case 1:
                return Math.signum(0.5d - (a(d) % 1.0d));
            case 2:
                return 1.0d - Math.abs((((a(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((a(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((a(d) * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.m * a(d));
            case 6:
                double dAbs = 1.0d - Math.abs(((a(d) * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (dAbs * dAbs);
            default:
                return Math.sin(this.m * a(d));
        }
    }

    double c(double d) {
        if (d <= 0.0d) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int iBinarySearch = Arrays.binarySearch(this.c, d);
        if (iBinarySearch > 0 || iBinarySearch == 0) {
            return 0.0d;
        }
        int i2 = (-iBinarySearch) - 1;
        int i3 = i2 - 1;
        double d2 = ((double) (this.b[i2] - this.b[i3])) / (this.c[i2] - this.c[i3]);
        return (d * d2) + (((double) this.b[i3]) - (d2 * this.c[i3]));
    }

    public double d(double d) {
        switch (this.l) {
            case 1:
                return 0.0d;
            case 2:
                return c(d) * 4.0d * Math.signum((((a(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return c(d) * 2.0d;
            case 4:
                return (-c(d)) * 2.0d;
            case 5:
                return (-this.m) * c(d) * Math.sin(this.m * a(d));
            case 6:
                return c(d) * 4.0d * ((((a(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            default:
                return this.m * c(d) * Math.cos(this.m * a(d));
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.c) + " period=" + Arrays.toString(this.b);
    }
}
