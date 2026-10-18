package androidx.d.b.a;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String d = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String e = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String f = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String g = "cubic(1, 1, 0, 0)";
    String b = "identity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static c f596a = new c();
    private static final String j = "standard";
    private static final String i = "accelerate";
    private static final String h = "decelerate";
    private static final String k = "linear";
    public static String[] c = {j, i, h, k};

    static class a extends c {
        private static double h = 0.01d;
        private static double i = 1.0E-4d;
        double d;
        double e;
        double f;
        double g;

        public a(double d, double d2, double d3, double d4) {
            a(d, d2, d3, d4);
        }

        a(String str) {
            this.b = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i2);
            this.e = Double.parseDouble(str.substring(i2, iIndexOf3).trim());
            int i3 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i3);
            this.f = Double.parseDouble(str.substring(i3, iIndexOf4).trim());
            int i4 = iIndexOf4 + 1;
            this.g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double c(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.d * d2 * d3 * d) + (this.f * d3 * d * d) + (d * d * d);
        }

        private double d(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.e * d2 * d3 * d) + (this.g * d3 * d * d) + (d * d * d);
        }

        private double e(double d) {
            double d2 = 1.0d - d;
            return (d2 * 3.0d * d2 * this.d) + (d2 * 6.0d * d * (this.f - this.d)) + (3.0d * d * d * (1.0d - this.f));
        }

        private double f(double d) {
            double d2 = 1.0d - d;
            return (d2 * 3.0d * d2 * this.e) + (d2 * 6.0d * d * (this.g - this.e)) + (3.0d * d * d * (1.0d - this.g));
        }

        @Override // androidx.d.b.a.c
        public double a(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > h) {
                d2 *= 0.5d;
                d3 = c(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double dC = c(d4);
            double d5 = d3 + d2;
            double dC2 = c(d5);
            double d6 = d(d4);
            return (((d(d5) - d6) * (d - dC)) / (dC2 - dC)) + d6;
        }

        void a(double d, double d2, double d3, double d4) {
            this.d = d;
            this.e = d2;
            this.f = d3;
            this.g = d4;
        }

        @Override // androidx.d.b.a.c
        public double b(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > i) {
                d2 *= 0.5d;
                d3 = c(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (d(d5) - d(d4)) / (c(d5) - c(d4));
        }
    }

    public static c a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        switch (str) {
            case "standard":
                return new a(d);
            case "accelerate":
                return new a(e);
            case "decelerate":
                return new a(f);
            case "linear":
                return new a(g);
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(c));
                return f596a;
        }
    }

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.b;
    }
}
