package com.google.android.material.z.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
public final class i extends Visibility {
    @Override // android.transition.Visibility
    @ah
    public Animator onAppear(@ah ViewGroup viewGroup, @ah View view, @ai TransitionValues transitionValues, @ai TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }

    @Override // android.transition.Visibility
    @ah
    public Animator onDisappear(@ah ViewGroup viewGroup, @ah View view, @ai TransitionValues transitionValues, @ai TransitionValues transitionValues2) {
        return ValueAnimator.ofFloat(0.0f);
    }
}
