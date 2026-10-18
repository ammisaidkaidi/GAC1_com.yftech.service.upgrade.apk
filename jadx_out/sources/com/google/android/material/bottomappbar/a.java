package com.google.android.material.bottomappbar;

import androidx.annotation.ah;
import androidx.annotation.ap;
import androidx.annotation.r;
import com.google.android.material.t.g;
import com.google.android.material.t.q;

/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1194a = 90;
    private static final int b = 180;
    private static final int c = 270;
    private static final int d = 180;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;

    public a(float f, float f2, float f3) {
        this.f = f;
        this.e = f2;
        c(f3);
        this.i = 0.0f;
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public float a() {
        return this.g;
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public void a(float f) {
        this.g = f;
    }

    @Override // com.google.android.material.t.g
    public void a(float f, float f2, float f3, @ah q qVar) {
        if (this.g == 0.0f) {
            qVar.b(f, 0.0f);
            return;
        }
        float f4 = ((this.f * 2.0f) + this.g) / 2.0f;
        float f5 = f3 * this.e;
        float f6 = f2 + this.i;
        float f7 = (this.h * f3) + ((1.0f - f3) * f4);
        if (f7 / f4 >= 1.0f) {
            qVar.b(f, 0.0f);
            return;
        }
        float f8 = f4 + f5;
        float f9 = f7 + f5;
        float fSqrt = (float) Math.sqrt((f8 * f8) - (f9 * f9));
        float f10 = f6 - fSqrt;
        float f11 = f6 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f9));
        float f12 = 90.0f - degrees;
        qVar.b(f10, 0.0f);
        float f13 = f5 * 2.0f;
        qVar.b(f10 - f5, 0.0f, f10 + f5, f13, 270.0f, degrees);
        qVar.b(f6 - f4, (-f4) - f7, f6 + f4, f4 - f7, 180.0f - f12, (f12 * 2.0f) - 180.0f);
        qVar.b(f11 - f5, 0.0f, f11 + f5, f13, 270.0f - degrees, degrees);
        qVar.b(f, 0.0f);
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public float b() {
        return this.i;
    }

    void b(float f) {
        this.i = f;
    }

    float c() {
        return this.h;
    }

    void c(@r(a = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.h = f;
    }

    float d() {
        return this.f;
    }

    void d(float f) {
        this.f = f;
    }

    float e() {
        return this.e;
    }

    void e(float f) {
        this.e = f;
    }
}
