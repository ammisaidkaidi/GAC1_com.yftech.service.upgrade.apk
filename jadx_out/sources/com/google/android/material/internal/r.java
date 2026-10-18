package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.j.ag;
import androidx.j.an;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class r extends ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1349a = "android:textscale:scale";

    private void d(@ah an anVar) {
        if (anVar.b instanceof TextView) {
            anVar.f859a.put(f1349a, Float.valueOf(((TextView) anVar.b).getScaleX()));
        }
    }

    @Override // androidx.j.ag
    public Animator a(@ah ViewGroup viewGroup, @ai an anVar, @ai an anVar2) {
        if (anVar == null || anVar2 == null || !(anVar.b instanceof TextView) || !(anVar2.b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) anVar2.b;
        Map<String, Object> map = anVar.f859a;
        Map<String, Object> map2 = anVar2.f859a;
        float fFloatValue = map.get(f1349a) != null ? ((Float) map.get(f1349a)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(f1349a) != null ? ((Float) map2.get(f1349a)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.r.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@ah ValueAnimator valueAnimator) {
                float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(fFloatValue3);
                textView.setScaleY(fFloatValue3);
            }
        });
        return valueAnimatorOfFloat;
    }

    @Override // androidx.j.ag
    public void a(@ah an anVar) {
        d(anVar);
    }

    @Override // androidx.j.ag
    public void b(@ah an anVar) {
        d(anVar);
    }
}
