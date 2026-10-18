package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.n.af;
import com.google.android.material.a.c;
import com.google.android.material.a.e;
import com.google.android.material.a.h;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.g.d;
import com.google.android.material.g.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f1474a;
    private final RectF b;
    private final RectF c;
    private final int[] d;
    private float e;
    private float f;

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ai
        public h f1479a;
        public j b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
        this.f1474a = new Rect();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1474a = new Rect();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new int[2];
    }

    private float a(@ah View view, @ah View view2, @ah j jVar) {
        float fCenterX;
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        b(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1154a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX() - rectF.centerX();
        } else if (i != 3) {
            fCenterX = i != 5 ? 0.0f : rectF2.right - rectF.right;
        } else {
            fCenterX = rectF2.left - rectF.left;
        }
        return fCenterX + jVar.b;
    }

    private float a(@ah a aVar, @ah i iVar, float f, float f2) {
        long jA = iVar.a();
        long jB = iVar.b();
        i iVarB = aVar.f1479a.b("expansion");
        return com.google.android.material.a.a.a(f, f2, iVar.c().getInterpolation((((iVarB.a() + iVarB.b()) + 17) - jA) / jB));
    }

    @ah
    private Pair<i, i> a(float f, float f2, boolean z, @ah a aVar) {
        i iVarB;
        i iVarB2;
        if (f == 0.0f || f2 == 0.0f) {
            iVarB = aVar.f1479a.b("translationXLinear");
            iVarB2 = aVar.f1479a.b("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            iVarB = aVar.f1479a.b("translationXCurveDownwards");
            iVarB2 = aVar.f1479a.b("translationYCurveDownwards");
        } else {
            iVarB = aVar.f1479a.b("translationXCurveUpwards");
            iVarB2 = aVar.f1479a.b("translationYCurveUpwards");
        }
        return new Pair<>(iVarB, iVarB2);
    }

    private void a(View view, long j, int i, int i2, float f, @ah List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        animatorCreateCircularReveal.setStartDelay(0L);
        animatorCreateCircularReveal.setDuration(j);
        list.add(animatorCreateCircularReveal);
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f, @ah List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                animatorCreateCircularReveal.setStartDelay(j4);
                animatorCreateCircularReveal.setDuration(j3 - j4);
                list.add(animatorCreateCircularReveal);
            }
        }
    }

    private void a(@ah View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.d;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void a(@ah View view, @ah View view2, boolean z, @ah a aVar, @ah List<Animator> list) {
        float fA = a(view, view2, aVar.b);
        float fB = b(view, view2, aVar.b);
        Pair<i, i> pairA = a(fA, fB, z, aVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            fA = this.e;
        }
        fArr[0] = fA;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            fB = this.f;
        }
        fArr2[0] = fB;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(@ah View view, View view2, boolean z, boolean z2, @ah a aVar, float f, float f2, @ah List<Animator> list, @ah List<Animator.AnimatorListener> list2) {
        i iVar;
        Animator animatorA;
        if (view2 instanceof g) {
            final g gVar = (g) view2;
            float fC = c(view, view2, aVar.b);
            float fD = d(view, view2, aVar.b);
            ((FloatingActionButton) view).a(this.f1474a);
            float fWidth = this.f1474a.width() / 2.0f;
            i iVarB = aVar.f1479a.b("expansion");
            if (z) {
                if (!z2) {
                    gVar.setRevealInfo(new g.d(fC, fD, fWidth));
                }
                float f3 = z2 ? gVar.getRevealInfo().d : fWidth;
                animatorA = com.google.android.material.g.a.a(gVar, fC, fD, com.google.android.material.n.a.a(fC, fD, 0.0f, 0.0f, f, f2));
                animatorA.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        g.d revealInfo = gVar.getRevealInfo();
                        revealInfo.d = Float.MAX_VALUE;
                        gVar.setRevealInfo(revealInfo);
                    }
                });
                iVar = iVarB;
                a(view2, iVarB.a(), (int) fC, (int) fD, f3, list);
            } else {
                iVar = iVarB;
                float f4 = gVar.getRevealInfo().d;
                Animator animatorA2 = com.google.android.material.g.a.a(gVar, fC, fD, fWidth);
                int i = (int) fC;
                int i2 = (int) fD;
                a(view2, iVar.a(), i, i2, f4, list);
                a(view2, iVar.a(), iVar.b(), aVar.f1479a.a(), i, i2, fWidth, list);
                animatorA = animatorA2;
            }
            iVar.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.g.a.a(gVar));
        }
    }

    @TargetApi(21)
    private void a(View view, @ah View view2, boolean z, boolean z2, @ah a aVar, @ah List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fP = af.P(view2) - af.P(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fP);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fP);
        }
        aVar.f1479a.b("elevation").a((Animator) objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    private void a(@ah View view, @ah View view2, boolean z, boolean z2, @ah a aVar, @ah List<Animator> list, List<Animator.AnimatorListener> list2, @ah RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fA = a(view, view2, aVar.b);
        float fB = b(view, view2, aVar.b);
        Pair<i, i> pairA = a(fA, fB, z, aVar);
        i iVar = (i) pairA.first;
        i iVar2 = (i) pairA.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fA);
                view2.setTranslationY(-fB);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            a(view2, aVar, iVar, iVar2, -fA, -fB, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fA);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fB);
        }
        iVar.a((Animator) objectAnimatorOfFloat);
        iVar2.a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private void a(@ah View view, @ah a aVar, @ah i iVar, @ah i iVar2, float f, float f2, float f3, float f4, @ah RectF rectF) {
        float fA = a(aVar, iVar, f, f3);
        float fA2 = a(aVar, iVar2, f2, f4);
        Rect rect = this.f1474a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.b;
        rectF2.set(rect);
        RectF rectF3 = this.c;
        a(view, rectF3);
        rectF3.offset(fA, fA2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float b(@ah View view, @ah View view2, @ah j jVar) {
        float fCenterY;
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        b(view, rectF);
        a(view2, rectF2);
        int i = jVar.f1154a & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY() - rectF.centerY();
        } else if (i != 48) {
            fCenterY = i != 80 ? 0.0f : rectF2.bottom - rectF.bottom;
        } else {
            fCenterY = rectF2.top - rectF.top;
        }
        return fCenterY + jVar.c;
    }

    @ai
    private ViewGroup b(@ah View view) {
        View viewFindViewById = view.findViewById(com.google.android.material.a.h.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return c(viewFindViewById);
        }
        return ((view instanceof b) || (view instanceof com.google.android.material.transformation.a)) ? c(((ViewGroup) view).getChildAt(0)) : c(view);
    }

    private void b(@ah View view, @ah RectF rectF) {
        a(view, rectF);
        rectF.offset(this.e, this.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(View view, final View view2, boolean z, boolean z2, @ah a aVar, @ah List<Animator> list, @ah List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof g) && (view instanceof ImageView)) {
            final g gVar = (g) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, e.f1149a, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, e.f1149a, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            aVar.f1479a.b("iconFade").a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    gVar.setCircularRevealOverlayDrawable(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    gVar.setCircularRevealOverlayDrawable(drawable);
                }
            });
        }
    }

    private float c(@ah View view, @ah View view2, @ah j jVar) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        b(view, rectF);
        a(view2, rectF2);
        rectF2.offset(-a(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    @ai
    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c(@ah View view, View view2, boolean z, boolean z2, @ah a aVar, @ah List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof g) {
            g gVar = (g) view2;
            int iD = d(view);
            int i = 16777215 & iD;
            if (z) {
                if (!z2) {
                    gVar.setCircularRevealScrimColor(iD);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(gVar, g.c.f1318a, i);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(gVar, g.c.f1318a, iD);
            }
            objectAnimatorOfInt.setEvaluator(c.a());
            aVar.f1479a.b("color").a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private float d(@ah View view, @ah View view2, @ah j jVar) {
        RectF rectF = this.b;
        RectF rectF2 = this.c;
        b(view, rectF);
        a(view2, rectF2);
        rectF2.offset(0.0f, -b(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int d(@ah View view) {
        ColorStateList colorStateListAa = af.aa(view);
        if (colorStateListAa != null) {
            return colorStateListAa.getColorForState(view.getDrawableState(), colorStateListAa.getDefaultColor());
        }
        return 0;
    }

    private void d(View view, View view2, boolean z, boolean z2, @ah a aVar, @ah List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupB;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof g) && d.d == 0) || (viewGroupB = b(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.a.d.f1148a.set(viewGroupB, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupB, com.google.android.material.a.d.f1148a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupB, com.google.android.material.a.d.f1148a, 0.0f);
            }
            aVar.f1479a.b("contentFade").a((Animator) objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    protected abstract a a(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @androidx.annotation.i
    public void a(@ah CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @androidx.annotation.i
    public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah View view, @ah View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @ah
    protected AnimatorSet b(@ah final View view, @ah final View view2, final boolean z, boolean z2) {
        a aVarA = a(view2.getContext(), z);
        if (z) {
            this.e = view.getTranslationX();
            this.f = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            a(view, view2, z, z2, aVarA, arrayList, arrayList2);
        }
        RectF rectF = this.b;
        a(view, view2, z, z2, aVarA, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        a(view, view2, z, aVarA, arrayList);
        b(view, view2, z, z2, aVarA, arrayList, arrayList2);
        a(view, view2, z, z2, aVarA, fWidth, fHeight, arrayList, arrayList2);
        c(view, view2, z, z2, aVarA, arrayList, arrayList2);
        d(view, view2, z, z2, aVarA, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }
}
