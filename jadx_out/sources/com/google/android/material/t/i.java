package com.google.android.material.t;

import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1411a;

    public i(float f) {
        this.f1411a = f - 0.001f;
    }

    @Override // com.google.android.material.t.g
    public void a(float f, float f2, float f3, @ah q qVar) {
        float fSqrt = (float) ((((double) this.f1411a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f1411a, 2.0d) - Math.pow(fSqrt, 2.0d));
        qVar.a(f2 - fSqrt, ((float) (-((((double) this.f1411a) * Math.sqrt(2.0d)) - ((double) this.f1411a)))) + fSqrt2);
        qVar.b(f2, (float) (-((((double) this.f1411a) * Math.sqrt(2.0d)) - ((double) this.f1411a))));
        qVar.b(f2 + fSqrt, ((float) (-((((double) this.f1411a) * Math.sqrt(2.0d)) - ((double) this.f1411a)))) + fSqrt2);
    }

    @Override // com.google.android.material.t.g
    boolean f() {
        return true;
    }
}
