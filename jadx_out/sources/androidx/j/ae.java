package androidx.j;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ae extends bf {
    private static final String r = "android:slide:screenPosition";
    private a s;
    private int t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeInterpolator f833a = new DecelerateInterpolator();
    private static final TimeInterpolator b = new AccelerateInterpolator();
    private static final a u = new b() { // from class: androidx.j.ae.1
        @Override // androidx.j.ae.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final a v = new b() { // from class: androidx.j.ae.2
        @Override // androidx.j.ae.a
        public float a(ViewGroup viewGroup, View view) {
            return androidx.core.n.af.p(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final a w = new c() { // from class: androidx.j.ae.3
        @Override // androidx.j.ae.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };
    private static final a x = new b() { // from class: androidx.j.ae.4
        @Override // androidx.j.ae.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final a y = new b() { // from class: androidx.j.ae.5
        @Override // androidx.j.ae.a
        public float a(ViewGroup viewGroup, View view) {
            return androidx.core.n.af.p(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final a z = new c() { // from class: androidx.j.ae.6
        @Override // androidx.j.ae.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };

    private interface a {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class b implements a {
        private b() {
        }

        @Override // androidx.j.ae.a
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    private static abstract class c implements a {
        private c() {
        }

        @Override // androidx.j.ae.a
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public @interface d {
    }

    public ae() {
        this.s = z;
        this.t = 80;
        a(80);
    }

    public ae(int i) {
        this.s = z;
        this.t = 80;
        a(i);
    }

    @SuppressLint({"RestrictedApi"})
    public ae(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = z;
        this.t = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.h);
        int iA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        a(iA);
    }

    private void e(an anVar) {
        int[] iArr = new int[2];
        anVar.b.getLocationOnScreen(iArr);
        anVar.f859a.put(r, iArr);
    }

    @Override // androidx.j.bf
    public Animator a(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        if (anVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) anVar2.f859a.get(r);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return ap.a(view, anVar2, iArr[0], iArr[1], this.s.a(viewGroup, view), this.s.b(viewGroup, view), translationX, translationY, f833a, this);
    }

    public void a(int i) {
        if (i == 3) {
            this.s = u;
        } else if (i == 5) {
            this.s = x;
        } else if (i == 48) {
            this.s = w;
        } else if (i == 80) {
            this.s = z;
        } else if (i == 8388611) {
            this.s = v;
        } else {
            if (i != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.s = y;
        }
        this.t = i;
        ad adVar = new ad();
        adVar.a(i);
        a(adVar);
    }

    @Override // androidx.j.bf, androidx.j.ag
    public void a(@androidx.annotation.ah an anVar) {
        super.a(anVar);
        e(anVar);
    }

    public int b() {
        return this.t;
    }

    @Override // androidx.j.bf
    public Animator b(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        if (anVar == null) {
            return null;
        }
        int[] iArr = (int[]) anVar.f859a.get(r);
        return ap.a(view, anVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.s.a(viewGroup, view), this.s.b(viewGroup, view), b, this);
    }

    @Override // androidx.j.bf, androidx.j.ag
    public void b(@androidx.annotation.ah an anVar) {
        super.b(anVar);
        e(anVar);
    }
}
