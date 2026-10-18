package com.google.android.material.t;

import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class l extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f1416a;
    private final float b;

    public l(@ah g gVar, float f) {
        this.f1416a = gVar;
        this.b = f;
    }

    @Override // com.google.android.material.t.g
    public void a(float f, float f2, float f3, @ah q qVar) {
        this.f1416a.a(f, f2 - this.b, f3, qVar);
    }

    @Override // com.google.android.material.t.g
    boolean f() {
        return this.f1416a.f();
    }
}
