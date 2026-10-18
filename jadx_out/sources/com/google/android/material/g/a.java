package com.google.android.material.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
    }

    @ah
    public static Animator.AnimatorListener a(@ah final g gVar) {
        return new AnimatorListenerAdapter() { // from class: com.google.android.material.g.a.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                gVar.g_();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                gVar.a();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ah
    public static Animator a(@ah g gVar, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(gVar, (Property<g, V>) g.b.f1317a, (TypeEvaluator) g.a.f1316a, (Object[]) new g.d[]{new g.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return objectAnimatorOfObject;
        }
        g.d revealInfo = gVar.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) gVar, (int) f, (int) f2, revealInfo.d, f3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ah
    public static Animator a(g gVar, float f, float f2, float f3, float f4) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(gVar, (Property<g, V>) g.b.f1317a, (TypeEvaluator) g.a.f1316a, (Object[]) new g.d[]{new g.d(f, f2, f3), new g.d(f, f2, f4)});
        if (Build.VERSION.SDK_INT < 21) {
            return objectAnimatorOfObject;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) gVar, (int) f, (int) f2, f3, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }
}
