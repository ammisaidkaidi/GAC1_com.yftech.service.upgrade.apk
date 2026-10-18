package com.google.android.material.z.a;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
public final class q extends r<w> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1531a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private final int d;
    private final boolean e;

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface a {
    }

    public q(int i, boolean z) {
        super(a(i, z), e());
        this.d = i;
        this.e = z;
    }

    private static w a(int i, boolean z) {
        switch (i) {
            case 0:
                return new t(z ? androidx.core.n.h.c : androidx.core.n.h.b);
            case 1:
                return new t(z ? 80 : 48);
            case 2:
                return new s(z);
            default:
                throw new IllegalArgumentException("Invalid axis: " + i);
        }
    }

    private static w e() {
        return new e();
    }

    public int a() {
        return this.d;
    }

    @Override // com.google.android.material.z.a.r
    public /* bridge */ /* synthetic */ void a(@ai w wVar) {
        super.a(wVar);
    }

    @Override // com.google.android.material.z.a.r
    @ai
    public /* bridge */ /* synthetic */ w b() {
        return super.b();
    }

    public boolean c() {
        return this.e;
    }

    @Override // com.google.android.material.z.a.r
    @ah
    public /* bridge */ /* synthetic */ w d() {
        return super.d();
    }

    @Override // com.google.android.material.z.a.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.z.a.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}
