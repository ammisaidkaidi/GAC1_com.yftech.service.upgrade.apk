package com.google.android.material.z.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import com.google.android.material.z.a.w;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
abstract class r<P extends w> extends Visibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P f1532a;

    @ai
    private w b;

    protected r(P p, @ai w wVar) {
        this.f1532a = p;
        this.b = wVar;
        setInterpolator(com.google.android.material.a.a.b);
    }

    private Animator a(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        Animator animatorA = z ? this.f1532a.a(viewGroup, view) : this.f1532a.b(viewGroup, view);
        if (animatorA != null) {
            arrayList.add(animatorA);
        }
        if (this.b != null) {
            Animator animatorA2 = z ? this.b.a(viewGroup, view) : this.b.b(viewGroup, view);
            if (animatorA2 != null) {
                arrayList.add(animatorA2);
            }
        }
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public void a(@ai w wVar) {
        this.b = wVar;
    }

    @ai
    public w b() {
        return this.b;
    }

    @ah
    public P d() {
        return this.f1532a;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(viewGroup, view, false);
    }
}
