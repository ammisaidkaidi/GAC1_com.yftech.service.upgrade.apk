package com.google.android.material.z;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public final class r implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1560a;
    private float b;
    private float c;
    private float d;
    private boolean e;
    private boolean f;

    public r() {
        this(true);
    }

    public r(boolean z) {
        this.f1560a = 1.0f;
        this.b = 1.1f;
        this.c = 0.8f;
        this.d = 1.0f;
        this.f = true;
        this.e = z;
    }

    private static Animator a(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, f, f2), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f, f2));
    }

    @Override // com.google.android.material.z.v
    @ai
    public Animator a(@ah ViewGroup viewGroup, @ah View view) {
        return this.e ? a(view, this.c, this.d) : a(view, this.b, this.f1560a);
    }

    public void a(float f) {
        this.f1560a = f;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean a() {
        return this.e;
    }

    @Override // com.google.android.material.z.v
    @ai
    public Animator b(@ah ViewGroup viewGroup, @ah View view) {
        if (this.f) {
            return this.e ? a(view, this.f1560a, this.b) : a(view, this.d, this.c);
        }
        return null;
    }

    public void b(float f) {
        this.b = f;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public float c() {
        return this.f1560a;
    }

    public void c(float f) {
        this.c = f;
    }

    public float d() {
        return this.b;
    }

    public void d(float f) {
        this.d = f;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }
}
