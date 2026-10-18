package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: androidx.j.a$a, reason: collision with other inner class name */
    interface InterfaceC0067a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    private a() {
    }

    static void a(@androidx.annotation.ah Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0067a) {
                    ((InterfaceC0067a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    static void a(@androidx.annotation.ah Animator animator, @androidx.annotation.ah AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void b(@androidx.annotation.ah Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0067a) {
                    ((InterfaceC0067a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
