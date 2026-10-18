package com.google.android.material.z.a;

import androidx.annotation.am;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1508a;
    final int b;
    final boolean c;

    private c(int i, int i2, boolean z) {
        this.f1508a = i;
        this.b = i2;
        this.c = z;
    }

    static c a(int i, int i2) {
        return new c(i, i2, false);
    }

    static c b(int i, int i2) {
        return new c(i, i2, true);
    }
}
