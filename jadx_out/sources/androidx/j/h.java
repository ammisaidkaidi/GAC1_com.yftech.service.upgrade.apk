package androidx.j;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class h extends ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f894a = "android:changeScroll:x";
    private static final String b = "android:changeScroll:y";
    private static final String[] o = {f894a, b};

    public h() {
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void d(an anVar) {
        anVar.f859a.put(f894a, Integer.valueOf(anVar.b.getScrollX()));
        anVar.f859a.put(b, Integer.valueOf(anVar.b.getScrollY()));
    }

    @Override // androidx.j.ag
    @androidx.annotation.ai
    public Animator a(@androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ai an anVar, @androidx.annotation.ai an anVar2) {
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (anVar == null || anVar2 == null) {
            return null;
        }
        View view = anVar2.b;
        int iIntValue = ((Integer) anVar.f859a.get(f894a)).intValue();
        int iIntValue2 = ((Integer) anVar2.f859a.get(f894a)).intValue();
        int iIntValue3 = ((Integer) anVar.f859a.get(b)).intValue();
        int iIntValue4 = ((Integer) anVar2.f859a.get(b)).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return am.a(objectAnimatorOfInt, objectAnimatorOfInt2);
    }

    @Override // androidx.j.ag
    public void a(@androidx.annotation.ah an anVar) {
        d(anVar);
    }

    @Override // androidx.j.ag
    @androidx.annotation.ai
    public String[] a() {
        return o;
    }

    @Override // androidx.j.ag
    public void b(@androidx.annotation.ah an anVar) {
        d(anVar);
    }
}
