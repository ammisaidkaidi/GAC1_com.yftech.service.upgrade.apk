package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ah;
import androidx.annotation.am;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1173a = {R.attr.stateListAnimator};

    f() {
    }

    static void a(@ah View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(@ah View view, float f) {
        int integer = view.getResources().getInteger(com.google.android.material.a.i.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, com.google.android.material.a.c.state_liftable, -com.google.android.material.a.c.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    static void a(@ah View view, AttributeSet attributeSet, int i, int i2) {
        Context context = view.getContext();
        TypedArray typedArrayA = s.a(context, attributeSet, f1173a, i, i2, new int[0]);
        try {
            if (typedArrayA.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayA.getResourceId(0, 0)));
            }
        } finally {
            typedArrayA.recycle();
        }
    }
}
