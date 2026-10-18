package androidx.h.a.a;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f815a;
    private final float b;

    protected d(float[] fArr) {
        this.f815a = fArr;
        this.b = 1.0f / (this.f815a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int iMin = Math.min((int) ((this.f815a.length - 1) * f), this.f815a.length - 2);
        return this.f815a[iMin] + (((f - (iMin * this.b)) / this.b) * (this.f815a[iMin + 1] - this.f815a[iMin]));
    }
}
