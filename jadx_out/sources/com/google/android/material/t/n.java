package com.google.android.material.t;

import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public class n extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f1418a;

    public n() {
        this.f1418a = -1.0f;
    }

    @Deprecated
    public n(float f) {
        this.f1418a = -1.0f;
        this.f1418a = f;
    }

    @Override // com.google.android.material.t.e
    public void a(@ah q qVar, float f, float f2, float f3) {
        qVar.a(0.0f, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        qVar.b(0.0f, 0.0f, f4, f4, 180.0f, f);
    }
}
