package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ai
    private Animator f1295a;

    a() {
    }

    public void a() {
        if (this.f1295a != null) {
            this.f1295a.cancel();
        }
    }

    public void a(Animator animator) {
        a();
        this.f1295a = animator;
    }

    public void b() {
        this.f1295a = null;
    }
}
