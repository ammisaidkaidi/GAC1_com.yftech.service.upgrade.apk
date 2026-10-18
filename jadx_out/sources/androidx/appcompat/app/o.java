package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f89a = 0;
    public static final int b = 1;
    private static o f = null;
    private static final float g = 0.017453292f;
    private static final float h = 9.0E-4f;
    private static final float i = -0.10471976f;
    private static final float j = 0.0334196f;
    private static final float k = 3.49066E-4f;
    private static final float l = 5.236E-6f;
    private static final float m = 0.4092797f;
    private static final long n = 946728000000L;
    public long c;
    public long d;
    public int e;

    o() {
    }

    static o a() {
        if (f == null) {
            f = new o();
        }
        return f;
    }

    public void a(long j2, double d, double d2) {
        float f2 = (j2 - n) / 8.64E7f;
        float f3 = (0.01720197f * f2) + 6.24006f;
        double d3 = f3;
        double dSin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin(2.0f * f3) * 3.4906598739326E-4d) + (Math.sin(f3 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d4 = (-d2) / 360.0d;
        double dRound = ((double) (Math.round(((double) (f2 - h)) - d4) + h)) + d4 + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(dAsin))) / (Math.cos(d5) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.e = 1;
            this.c = -1L;
            this.d = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.e = 0;
                this.c = -1L;
                this.d = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.c = Math.round((dRound + dAcos) * 8.64E7d) + n;
            this.d = Math.round((dRound - dAcos) * 8.64E7d) + n;
            if (this.d >= j2 || this.c <= j2) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
    }
}
