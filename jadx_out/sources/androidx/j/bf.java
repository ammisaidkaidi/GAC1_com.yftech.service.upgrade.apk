package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class bf extends ag {
    private static final String b = "android:visibility:screenLocation";
    public static final int p = 1;
    public static final int q = 2;
    private int s;
    static final String o = "android:visibility:visibility";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f875a = "android:visibility:parent";
    private static final String[] r = {o, f875a};

    private static class a extends AnimatorListenerAdapter implements androidx.j.a.InterfaceC0067a, ag.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f877a = false;
        private final View b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        a(View view, int i, boolean z) {
            this.b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        private void a() {
            if (!this.f877a) {
                ay.a(this.b, this.c);
                if (this.d != null) {
                    this.d.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            if (!this.e || this.f == z || this.d == null) {
                return;
            }
            this.f = z;
            at.a(this.d, z);
        }

        @Override // androidx.j.ag.e
        public void a(@androidx.annotation.ah ag agVar) {
        }

        @Override // androidx.j.ag.e
        public void b(@androidx.annotation.ah ag agVar) {
            a();
            agVar.b(this);
        }

        @Override // androidx.j.ag.e
        public void c(@androidx.annotation.ah ag agVar) {
            a(false);
        }

        @Override // androidx.j.ag.e
        public void d(@androidx.annotation.ah ag agVar) {
            a(true);
        }

        @Override // androidx.j.ag.e
        public void e(@androidx.annotation.ah ag agVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f877a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.j.a.InterfaceC0067a
        public void onAnimationPause(Animator animator) {
            if (this.f877a) {
                return;
            }
            ay.a(this.b, this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.j.a.InterfaceC0067a
        public void onAnimationResume(Animator animator) {
            if (this.f877a) {
                return;
            }
            ay.a(this.b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public @interface b {
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f878a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

    public bf() {
        this.s = 3;
    }

    @SuppressLint({"RestrictedApi"})
    public bf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.e);
        int iA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iA != 0) {
            d(iA);
        }
    }

    private c b(an anVar, an anVar2) {
        c cVar = new c();
        cVar.f878a = false;
        cVar.b = false;
        if (anVar == null || !anVar.f859a.containsKey(o)) {
            cVar.c = -1;
            cVar.e = null;
        } else {
            cVar.c = ((Integer) anVar.f859a.get(o)).intValue();
            cVar.e = (ViewGroup) anVar.f859a.get(f875a);
        }
        if (anVar2 == null || !anVar2.f859a.containsKey(o)) {
            cVar.d = -1;
            cVar.f = null;
        } else {
            cVar.d = ((Integer) anVar2.f859a.get(o)).intValue();
            cVar.f = (ViewGroup) anVar2.f859a.get(f875a);
        }
        if (anVar == null || anVar2 == null) {
            if (anVar == null && cVar.d == 0) {
                cVar.b = true;
                cVar.f878a = true;
            } else if (anVar2 == null && cVar.c == 0) {
                cVar.b = false;
                cVar.f878a = true;
            }
        } else {
            if (cVar.c == cVar.d && cVar.e == cVar.f) {
                return cVar;
            }
            if (cVar.c != cVar.d) {
                if (cVar.c == 0) {
                    cVar.b = false;
                    cVar.f878a = true;
                } else if (cVar.d == 0) {
                    cVar.b = true;
                    cVar.f878a = true;
                }
            } else if (cVar.f == null) {
                cVar.b = false;
                cVar.f878a = true;
            } else if (cVar.e == null) {
                cVar.b = true;
                cVar.f878a = true;
            }
        }
        return cVar;
    }

    private void e(an anVar) {
        anVar.f859a.put(o, Integer.valueOf(anVar.b.getVisibility()));
        anVar.f859a.put(f875a, anVar.b.getParent());
        int[] iArr = new int[2];
        anVar.b.getLocationOnScreen(iArr);
        anVar.f859a.put(b, iArr);
    }

    public Animator a(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, an anVar, int i, an anVar2, int i2) {
        if ((this.s & 1) != 1 || anVar2 == null) {
            return null;
        }
        if (anVar == null) {
            View view = (View) anVar2.b.getParent();
            if (b(d(view, false), c(view, false)).f878a) {
                return null;
            }
        }
        return a(viewGroup, anVar2.b, anVar, anVar2);
    }

    @Override // androidx.j.ag
    @androidx.annotation.ai
    public Animator a(@androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ai an anVar, @androidx.annotation.ai an anVar2) {
        c cVarB = b(anVar, anVar2);
        if (!cVarB.f878a) {
            return null;
        }
        if (cVarB.e == null && cVarB.f == null) {
            return null;
        }
        return cVarB.b ? a(viewGroup, anVar, cVarB.c, anVar2, cVarB.d) : b(viewGroup, anVar, cVarB.c, anVar2, cVarB.d);
    }

    @Override // androidx.j.ag
    public void a(@androidx.annotation.ah an anVar) {
        e(anVar);
    }

    @Override // androidx.j.ag
    public boolean a(an anVar, an anVar2) {
        if (anVar == null && anVar2 == null) {
            return false;
        }
        if (anVar != null && anVar2 != null && anVar2.f859a.containsKey(o) != anVar.f859a.containsKey(o)) {
            return false;
        }
        c cVarB = b(anVar, anVar2);
        if (cVarB.f878a) {
            return cVarB.c == 0 || cVarB.d == 0;
        }
        return false;
    }

    @Override // androidx.j.ag
    @androidx.annotation.ai
    public String[] a() {
        return r;
    }

    public Animator b(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003b  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    public Animator b(final ViewGroup viewGroup, an anVar, int i, an anVar2, int i2) {
        View view;
        boolean z;
        boolean z2;
        if ((this.s & 2) != 2 || anVar == null) {
            return null;
        }
        final View view2 = anVar.b;
        View view3 = anVar2 != null ? anVar2.b : null;
        final View viewA = (View) view2.getTag(aa.e.save_overlay_view);
        if (viewA != null) {
            view = null;
            z2 = true;
        } else {
            if (view3 == null || view3.getParent() == null) {
                if (view3 != null) {
                    view = null;
                    viewA = view3;
                    z = false;
                } else {
                    viewA = null;
                    view = null;
                    z = true;
                }
            } else if (i2 == 4 || view2 == view3) {
                viewA = null;
                view = view3;
                z = false;
            } else {
                viewA = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view2.getParent() == null) {
                    viewA = view2;
                } else if (view2.getParent() instanceof View) {
                    View view4 = (View) view2.getParent();
                    if (b(c(view4, true), d(view4, true)).f878a) {
                        int id = view4.getId();
                        if (view4.getParent() == null && id != -1 && viewGroup.findViewById(id) != null && this.l) {
                            viewA = view2;
                        }
                    } else {
                        viewA = am.a(viewGroup, view2, view4);
                    }
                }
            }
            z2 = false;
        }
        if (viewA == null) {
            if (view == null) {
                return null;
            }
            int visibility = view.getVisibility();
            ay.a(view, 0);
            Animator animatorB = b(viewGroup, view, anVar, anVar2);
            if (animatorB != null) {
                a aVar = new a(view, i2, true);
                animatorB.addListener(aVar);
                androidx.j.a.a(animatorB, aVar);
                a(aVar);
            } else {
                ay.a(view, visibility);
            }
            return animatorB;
        }
        if (!z2) {
            int[] iArr = (int[]) anVar.f859a.get(b);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            viewA.offsetLeftAndRight((i3 - iArr2[0]) - viewA.getLeft());
            viewA.offsetTopAndBottom((i4 - iArr2[1]) - viewA.getTop());
            at.a(viewGroup).a(viewA);
        }
        Animator animatorB2 = b(viewGroup, viewA, anVar, anVar2);
        if (!z2) {
            if (animatorB2 == null) {
                at.a(viewGroup).b(viewA);
            } else {
                view2.setTag(aa.e.save_overlay_view, viewA);
                a(new ai() { // from class: androidx.j.bf.1
                    @Override // androidx.j.ai, androidx.j.ag.e
                    public void b(@androidx.annotation.ah ag agVar) {
                        view2.setTag(aa.e.save_overlay_view, null);
                        at.a(viewGroup).b(viewA);
                        agVar.b(this);
                    }

                    @Override // androidx.j.ai, androidx.j.ag.e
                    public void c(@androidx.annotation.ah ag agVar) {
                        at.a(viewGroup).b(viewA);
                    }

                    @Override // androidx.j.ai, androidx.j.ag.e
                    public void d(@androidx.annotation.ah ag agVar) {
                        if (viewA.getParent() == null) {
                            at.a(viewGroup).a(viewA);
                        } else {
                            bf.this.n();
                        }
                    }
                });
            }
        }
        return animatorB2;
    }

    @Override // androidx.j.ag
    public void b(@androidx.annotation.ah an anVar) {
        e(anVar);
    }

    public int c() {
        return this.s;
    }

    public void d(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.s = i;
    }

    public boolean d(an anVar) {
        if (anVar == null) {
            return false;
        }
        return ((Integer) anVar.f859a.get(o)).intValue() == 0 && ((View) anVar.f859a.get(f875a)) != null;
    }
}
