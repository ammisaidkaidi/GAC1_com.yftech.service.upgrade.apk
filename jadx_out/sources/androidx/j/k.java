package androidx.j;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class k extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeInterpolator f901a = new DecelerateInterpolator();
    private static final TimeInterpolator b = new AccelerateInterpolator();
    private static final String r = "android:explode:screenBounds";
    private int[] s;

    public k() {
        this.s = new int[2];
        a(new j());
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new int[2];
        a(new j());
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private static float a(View view, int i, int i2) {
        return a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private void a(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        float fRandom;
        float fRandom2;
        view.getLocationOnScreen(this.s);
        int i = this.s[0];
        int i2 = this.s[1];
        Rect rectQ = q();
        if (rectQ == null) {
            width = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectQ.centerX();
            iCenterY = rectQ.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fRandom2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            fRandom = ((float) (Math.random() * 2.0d)) - 1.0f;
        } else {
            fRandom = fCenterY;
            fRandom2 = fCenterX;
        }
        float fA = a(fRandom2, fRandom);
        float fA2 = a(view, width - i, iCenterY - i2);
        iArr[0] = Math.round((fRandom2 / fA) * fA2);
        iArr[1] = Math.round(fA2 * (fRandom / fA));
    }

    private void e(an anVar) {
        View view = anVar.b;
        view.getLocationOnScreen(this.s);
        int i = this.s[0];
        int i2 = this.s[1];
        anVar.f859a.put(r, new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.j.bf
    public Animator a(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        if (anVar2 == null) {
            return null;
        }
        Rect rect = (Rect) anVar2.f859a.get(r);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.s);
        return ap.a(view, anVar2, rect.left, rect.top, translationX + this.s[0], translationY + this.s[1], translationX, translationY, f901a, this);
    }

    @Override // androidx.j.bf, androidx.j.ag
    public void a(@androidx.annotation.ah an anVar) {
        super.a(anVar);
        e(anVar);
    }

    @Override // androidx.j.bf
    public Animator b(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        float f;
        float f2;
        if (anVar == null) {
            return null;
        }
        Rect rect = (Rect) anVar.f859a.get(r);
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) anVar.b.getTag(aa.e.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        a(viewGroup, rect, this.s);
        return ap.a(view, anVar, i, i2, translationX, translationY, f + this.s[0], f2 + this.s[1], b, this);
    }

    @Override // androidx.j.bf, androidx.j.ag
    public void b(@androidx.annotation.ah an anVar) {
        super.b(anVar);
        e(anVar);
    }
}
