package androidx.core.g;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private a() {
    }

    public static double a(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    public static float a(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    public static int a(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static long a(long j, long j2, long j3) {
        if (j < j2) {
            return j2;
        }
        return j > j3 ? j3 : j;
    }
}
