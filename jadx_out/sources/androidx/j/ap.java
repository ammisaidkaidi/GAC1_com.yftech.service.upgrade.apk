package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ap {

    private static class a extends AnimatorListenerAdapter implements ag.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f861a;
        private final View b;
        private final int c;
        private final int d;
        private int[] e;
        private float f;
        private float g;
        private final float h;
        private final float i;

        a(View view, View view2, int i, int i2, float f, float f2) {
            this.b = view;
            this.f861a = view2;
            this.c = i - Math.round(this.b.getTranslationX());
            this.d = i2 - Math.round(this.b.getTranslationY());
            this.h = f;
            this.i = f2;
            this.e = (int[]) this.f861a.getTag(aa.e.transition_position);
            if (this.e != null) {
                this.f861a.setTag(aa.e.transition_position, null);
            }
        }

        @Override // androidx.j.ag.e
        public void a(@androidx.annotation.ah ag agVar) {
        }

        @Override // androidx.j.ag.e
        public void b(@androidx.annotation.ah ag agVar) {
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
            agVar.b(this);
        }

        @Override // androidx.j.ag.e
        public void c(@androidx.annotation.ah ag agVar) {
        }

        @Override // androidx.j.ag.e
        public void d(@androidx.annotation.ah ag agVar) {
        }

        @Override // androidx.j.ag.e
        public void e(@androidx.annotation.ah ag agVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.e == null) {
                this.e = new int[2];
            }
            this.e[0] = Math.round(this.c + this.b.getTranslationX());
            this.e[1] = Math.round(this.d + this.b.getTranslationY());
            this.f861a.setTag(aa.e.transition_position, this.e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f = this.b.getTranslationX();
            this.g = this.b.getTranslationY();
            this.b.setTranslationX(this.h);
            this.b.setTranslationY(this.i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.b.setTranslationX(this.f);
            this.b.setTranslationY(this.g);
        }
    }

    private ap() {
    }

    @androidx.annotation.ai
    static Animator a(@androidx.annotation.ah View view, @androidx.annotation.ah an anVar, int i, int i2, float f, float f2, float f3, float f4, @androidx.annotation.ai TimeInterpolator timeInterpolator, @androidx.annotation.ah ag agVar) {
        float f5;
        float f6;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) anVar.b.getTag(aa.e.transition_position);
        if (iArr != null) {
            f5 = (iArr[0] - i) + translationX;
            f6 = (iArr[1] - i2) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int iRound = i + Math.round(f5 - translationX);
        int iRound2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f4));
        a aVar = new a(view, anVar.b, iRound, iRound2, translationX, translationY);
        agVar.a(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        androidx.j.a.a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
