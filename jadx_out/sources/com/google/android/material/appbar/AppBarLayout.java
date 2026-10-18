package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.annotation.ax;
import androidx.annotation.w;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.n.a.g;
import androidx.core.n.af;
import androidx.core.n.ao;
import androidx.core.n.q;
import androidx.core.n.y;
import com.google.android.material.internal.s;
import com.google.android.material.t.j;
import com.google.android.material.t.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1155a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 4;
    static final int e = 8;
    private static final int f = com.google.android.material.a.n.Widget_Design_AppBarLayout;
    private static final int g = -1;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;

    @ai
    private ao n;
    private List<a> o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @w
    private int t;

    @ai
    private WeakReference<View> u;

    @ai
    private ValueAnimator v;
    private int[] w;

    @ai
    private Drawable x;

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.b<T> {
        private static final int b = 600;
        private static final int c = -1;
        private int d;
        private int e;
        private ValueAnimator f;
        private int g;
        private boolean h;
        private float i;

        @ai
        private WeakReference<View> j;
        private a k;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(@ah T t);
        }

        protected static class b extends androidx.f.a.a {
            public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.b.1
                @Override // android.os.Parcelable.Creator
                @ai
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b createFromParcel(@ah Parcel parcel) {
                    return new b(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @ah
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b createFromParcel(@ah Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @ah
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public b[] newArray(int i) {
                    return new b[i];
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f1161a;
            float b;
            boolean d;

            public b(@ah Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f1161a = parcel.readInt();
                this.b = parcel.readFloat();
                this.d = parcel.readByte() != 0;
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // androidx.f.a.a, android.os.Parcelable
            public void writeToParcel(@ah Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f1161a);
                parcel.writeFloat(this.b);
                parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.g = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.g = -1;
        }

        private int a(@ah T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        @ai
        private View a(@ah CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof q) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private void a(CoordinatorLayout coordinatorLayout, @ah T t, int i, float f) {
            int iAbs = Math.abs(c() - i);
            float fAbs = Math.abs(f);
            a(coordinatorLayout, (AppBarLayout) t, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f));
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t, int i, int i2) {
            int iC = c();
            if (iC == i) {
                if (this.f == null || !this.f.isRunning()) {
                    return;
                }
                this.f.cancel();
                return;
            }
            if (this.f == null) {
                this.f = new ValueAnimator();
                this.f.setInterpolator(com.google.android.material.a.a.e);
                this.f.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(@ah ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.f.cancel();
            }
            this.f.setDuration(Math.min(i2, b));
            this.f.setIntValues(iC, i);
            this.f.start();
        }

        private void a(@ah CoordinatorLayout coordinatorLayout, @ah T t, int i, int i2, boolean z) {
            View viewC = c(t, i);
            if (viewC != null) {
                int iA = ((b) viewC.getLayoutParams()).a();
                boolean zA = false;
                if ((iA & 1) != 0) {
                    int iE = af.E(viewC);
                    if (i2 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i) < (viewC.getBottom() - iE) - t.getTopInset()) : (-i) >= (viewC.getBottom() - iE) - t.getTopInset()) {
                        zA = true;
                    }
                }
                if (t.d()) {
                    zA = t.a(a(coordinatorLayout));
                }
                boolean zC = t.c(zA);
                if (z || (zC && e(coordinatorLayout, (AppBarLayout) t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, @ah final T t, @ah androidx.core.n.a.d.a aVar, final boolean z) {
            af.a(coordinatorLayout, aVar, (CharSequence) null, new g() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.3
                @Override // androidx.core.n.a.g
                public boolean a(@ah View view, @ai g.a aVar2) {
                    t.setExpanded(z);
                    return true;
                }
            });
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private boolean a(@ah CoordinatorLayout coordinatorLayout, @ah T t, @ah View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private int b(@ah T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator interpolatorB = bVar.b();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorB == null) {
                        break;
                    }
                    int iA = bVar.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= af.E(childAt);
                        }
                    }
                    if (af.U(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f = topInset;
                    return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f)));
                }
            }
            return i;
        }

        private void b(final CoordinatorLayout coordinatorLayout, @ah final T t, @ah final View view) {
            if (c() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                a(coordinatorLayout, (AppBarLayout) t, androidx.core.n.a.d.a.m, false);
            }
            if (c() != 0) {
                if (!view.canScrollVertically(-1)) {
                    a(coordinatorLayout, (AppBarLayout) t, androidx.core.n.a.d.a.n, true);
                    return;
                }
                final int i = -t.getDownNestedPreScrollRange();
                if (i != 0) {
                    af.a(coordinatorLayout, androidx.core.n.a.d.a.n, (CharSequence) null, new g() { // from class: com.google.android.material.appbar.AppBarLayout.BaseBehavior.2
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        @Override // androidx.core.n.a.g
                        public boolean a(@ah View view2, @ai g.a aVar) {
                            BaseBehavior.this.a(coordinatorLayout, t, view, 0, i, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                }
            }
        }

        @ai
        private static View c(@ah AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void c(CoordinatorLayout coordinatorLayout, @ah T t) {
            int iC = c();
            int iA = a(t, iC);
            if (iA >= 0) {
                View childAt = t.getChildAt(iA);
                b bVar = (b) childAt.getLayoutParams();
                int iA2 = bVar.a();
                if ((iA2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int iE = -childAt.getBottom();
                    if (iA == t.getChildCount() - 1) {
                        iE += t.getTopInset();
                    }
                    if (a(iA2, 2)) {
                        iE += af.E(childAt);
                    } else if (a(iA2, 5)) {
                        int iE2 = af.E(childAt) + iE;
                        if (iC < iE2) {
                            i = iE2;
                        } else {
                            iE = iE2;
                        }
                    }
                    if (a(iA2, 32)) {
                        i += bVar.topMargin;
                        iE -= bVar.bottomMargin;
                    }
                    if (iC < (iE + i) / 2) {
                        i = iE;
                    }
                    a(coordinatorLayout, (AppBarLayout) t, androidx.core.g.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void d(CoordinatorLayout coordinatorLayout, @ah T t) {
            af.f((View) coordinatorLayout, androidx.core.n.a.d.a.m.a());
            af.f((View) coordinatorLayout, androidx.core.n.a.d.a.n.a());
            View viewA = a(coordinatorLayout);
            if (viewA == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) viewA.getLayoutParams()).b() instanceof ScrollingViewBehavior)) {
                return;
            }
            b(coordinatorLayout, (AppBarLayout) t, viewA);
        }

        private boolean e(@ah CoordinatorLayout coordinatorLayout, @ah T t) {
            List<View> listD = coordinatorLayout.d(t);
            int size = listD.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.b bVarB = ((CoordinatorLayout.f) listD.get(i).getLayoutParams()).b();
                if (bVarB instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) bVarB).h() != 0;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        public int a(@ah CoordinatorLayout coordinatorLayout, @ah T t, int i, int i2, int i3) {
            int iC = c();
            int i4 = 0;
            if (i2 == 0 || iC < i2 || iC > i3) {
                this.d = 0;
            } else {
                int iA = androidx.core.g.a.a(i, i2, i3);
                if (iC != iA) {
                    int iB = t.b() ? b(t, iA) : iA;
                    boolean zB = b(iB);
                    i4 = iC - iA;
                    this.d = iA - iB;
                    if (!zB && t.b()) {
                        coordinatorLayout.b(t);
                    }
                    t.a(g());
                    a(coordinatorLayout, (AppBarLayout) t, iA, iA < iC ? -1 : 1, false);
                }
            }
            d(coordinatorLayout, (AppBarLayout) t);
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(@ah CoordinatorLayout coordinatorLayout, @ah T t) {
            c(coordinatorLayout, (AppBarLayout) t);
            if (t.d()) {
                t.c(t.a(a(coordinatorLayout)));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(@ah CoordinatorLayout coordinatorLayout, @ah T t, Parcelable parcelable) {
            if (!(parcelable instanceof b)) {
                super.a(coordinatorLayout, t, parcelable);
                this.g = -1;
                return;
            }
            b bVar = (b) parcelable;
            super.a(coordinatorLayout, t, bVar.a());
            this.g = bVar.f1161a;
            this.i = bVar.b;
            this.h = bVar.d;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, @ah T t, View view, int i) {
            if (this.e == 0 || i == 1) {
                c(coordinatorLayout, (AppBarLayout) t);
                if (t.d()) {
                    t.c(t.a(view));
                }
            }
            this.j = new WeakReference<>(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, @ah T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = b(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                d(coordinatorLayout, (AppBarLayout) t);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void a(CoordinatorLayout coordinatorLayout, @ah T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -t.getTotalScrollRange();
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = b(coordinatorLayout, t, i2, i5, i6);
                }
            }
            if (t.d()) {
                t.c(t.a(view));
            }
        }

        public void a(@ai a aVar) {
            this.k = aVar;
        }

        @Override // com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah T t, int i) {
            boolean zA = super.a(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            if (this.g >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(this.g);
                int i2 = -childAt.getBottom();
                a_(coordinatorLayout, t, this.h ? i2 + af.E(childAt) + t.getTopInset() : i2 + Math.round(childAt.getHeight() * this.i));
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, (AppBarLayout) t, i3, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, (AppBarLayout) t, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.e();
            this.g = -1;
            b(androidx.core.g.a.a(g(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (AppBarLayout) t, g(), 0, true);
            t.a(g());
            d(coordinatorLayout, (AppBarLayout) t);
            return zA;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.f) t.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, t, i, i2, i3, i4);
            }
            coordinatorLayout.a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah T t, @ah View view, View view2, int i, int i2) {
            boolean z = (i & 2) != 0 && (t.d() || a(coordinatorLayout, (AppBarLayout) t, view));
            if (z && this.f != null) {
                this.f.cancel();
            }
            this.j = null;
            this.e = i2;
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean d(T t) {
            if (this.k != null) {
                return this.k.a(t);
            }
            if (this.j == null) {
                return true;
            }
            View view = this.j.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int c(@ah T t) {
            return -t.getDownNestedScrollRange();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable d(@ah CoordinatorLayout coordinatorLayout, @ah T t) {
            Parcelable parcelableD = super.d(coordinatorLayout, t);
            int iG = g();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + iG;
                if (childAt.getTop() + iG <= 0 && bottom >= 0) {
                    b bVar = new b(parcelableD);
                    bVar.f1161a = i;
                    bVar.d = bottom == af.E(childAt) + t.getTopInset();
                    bVar.b = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return parcelableD;
        }

        @ax
        boolean b() {
            return this.f != null && this.f.isRunning();
        }

        @Override // com.google.android.material.appbar.b
        int c() {
            return g() + this.d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(@ah T t) {
            return t.getTotalScrollRange();
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.a<AppBarLayout> {
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(@ah CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(@ai BaseBehavior.a aVar) {
            super.a(aVar);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ void a(boolean z) {
            super.a(z);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(@ah CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(@ah CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(@ah CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout, @ah View view, View view2, int i, int i2) {
            return super.a(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable d(@ah CoordinatorLayout coordinatorLayout, @ah AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ void b(boolean z) {
            super.b(z);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean b(int i) {
            return super.b(i);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean d() {
            return super.d();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean e() {
            return super.e();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ int f() {
            return super.f();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ int g() {
            return super.g();
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.c {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.ScrollingViewBehavior_Layout);
            c(typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.a.o.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        private static int a(@ah AppBarLayout appBarLayout) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).b();
            if (bVarB instanceof BaseBehavior) {
                return ((BaseBehavior) bVarB).c();
            }
            return 0;
        }

        private void a(@ah View view, @ah View view2) {
            CoordinatorLayout.b bVarB = ((CoordinatorLayout.f) view2.getLayoutParams()).b();
            if (bVarB instanceof BaseBehavior) {
                af.n(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) bVarB).d) + c()) - d(view2));
            }
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.c(appBarLayout.a(view));
                }
            }
        }

        @ai
        AppBarLayout a(@ah List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ void a(boolean z) {
            super.a(z);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        @Override // com.google.android.material.appbar.d, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(@ah CoordinatorLayout coordinatorLayout, @ah View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* bridge */ /* synthetic */ boolean a(@ah CoordinatorLayout coordinatorLayout, @ah View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah View view, @ah Rect rect, boolean z) {
            AppBarLayout appBarLayoutA = a(coordinatorLayout.c(view));
            if (appBarLayoutA != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f1170a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutA.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // com.google.android.material.appbar.c
        float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iA = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iA > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iA / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.c
        @ai
        /* synthetic */ View b(@ah List list) {
            return a((List<View>) list);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ void b(boolean z) {
            super.b(z);
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean b(int i) {
            return super.b(i);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public boolean b(@ah CoordinatorLayout coordinatorLayout, @ah View view, @ah View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // com.google.android.material.appbar.c
        int c(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.c(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public void c(@ah CoordinatorLayout coordinatorLayout, @ah View view, @ah View view2) {
            if (view2 instanceof AppBarLayout) {
                af.f((View) coordinatorLayout, androidx.core.n.a.d.a.m.a());
                af.f((View) coordinatorLayout, androidx.core.n.a.d.a.n.a());
            }
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean d() {
            return super.d();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ boolean e() {
            return super.e();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ int f() {
            return super.f();
        }

        @Override // com.google.android.material.appbar.d
        public /* bridge */ /* synthetic */ int g() {
            return super.g();
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public static class b extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1162a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 4;
        public static final int e = 8;
        public static final int f = 16;
        public static final int g = 32;
        static final int h = 5;
        static final int i = 17;
        static final int j = 10;
        int k;
        Interpolator l;

        @Retention(RetentionPolicy.SOURCE)
        @ap(a = {ap.a.LIBRARY_GROUP})
        public @interface a {
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.k = 1;
        }

        public b(int i2, int i3, float f2) {
            super(i2, i3, f2);
            this.k = 1;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.k = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.AppBarLayout_Layout);
            this.k = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.a.o.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.l = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.k = 1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.k = 1;
        }

        @am(a = 19)
        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.k = 1;
        }

        @am(a = 19)
        public b(@ah b bVar) {
            super((LinearLayout.LayoutParams) bVar);
            this.k = 1;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        public int a() {
            return this.k;
        }

        public void a(int i2) {
            this.k = i2;
        }

        public void a(Interpolator interpolator) {
            this.l = interpolator;
        }

        public Interpolator b() {
            return this.l;
        }

        boolean c() {
            return (this.k & 1) == 1 && (this.k & 10) != 0;
        }
    }

    public interface c extends a<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.a
        void a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(@ah Context context) {
        this(context, null);
    }

    public AppBarLayout(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.appBarLayoutStyle);
    }

    public AppBarLayout(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, f), attributeSet, i);
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.m = 0;
        Context context2 = getContext();
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            f.a(this);
            f.a(this, attributeSet, i, f);
        }
        TypedArray typedArrayA = s.a(context2, attributeSet, com.google.android.material.a.o.AppBarLayout, i, f, new int[0]);
        af.a(this, typedArrayA.getDrawable(com.google.android.material.a.o.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            j jVar = new j();
            jVar.g(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.b(context2);
            af.a(this, jVar);
        }
        if (typedArrayA.hasValue(com.google.android.material.a.o.AppBarLayout_expanded)) {
            a(typedArrayA.getBoolean(com.google.android.material.a.o.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayA.hasValue(com.google.android.material.a.o.AppBarLayout_elevation)) {
            f.a(this, typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayA.hasValue(com.google.android.material.a.o.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayA.getBoolean(com.google.android.material.a.o.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayA.hasValue(com.google.android.material.a.o.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayA.getBoolean(com.google.android.material.a.o.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.s = typedArrayA.getBoolean(com.google.android.material.a.o.AppBarLayout_liftOnScroll, false);
        this.t = typedArrayA.getResourceId(com.google.android.material.a.o.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayA.getDrawable(com.google.android.material.a.o.AppBarLayout_statusBarForeground));
        typedArrayA.recycle();
        af.a(this, new y() { // from class: com.google.android.material.appbar.AppBarLayout.1
            @Override // androidx.core.n.y
            public ao a(View view, ao aoVar) {
                return AppBarLayout.this.a(aoVar);
            }
        });
    }

    private void a(@ah final j jVar, boolean z) {
        float dimension = getResources().getDimension(com.google.android.material.a.f.design_appbar_elevation);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        if (this.v != null) {
            this.v.cancel();
        }
        this.v = ValueAnimator.ofFloat(f2, dimension);
        this.v.setDuration(getResources().getInteger(com.google.android.material.a.i.app_bar_elevation_anim_duration));
        this.v.setInterpolator(com.google.android.material.a.a.f1146a);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.AppBarLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@ah ValueAnimator valueAnimator) {
                jVar.r(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.v.start();
    }

    private void a(boolean z, boolean z2, boolean z3) {
        this.m = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @ai
    private View b(@ai View view) {
        if (this.u == null && this.t != -1) {
            View viewFindViewById = view != null ? view.findViewById(this.t) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.t);
            }
            if (viewFindViewById != null) {
                this.u = new WeakReference<>(viewFindViewById);
            }
        }
        if (this.u != null) {
            return this.u.get();
        }
        return null;
    }

    private boolean d(boolean z) {
        if (this.q == z) {
            return false;
        }
        this.q = z;
        refreshDrawableState();
        return true;
    }

    private void f() {
        setWillNotDraw(!g());
    }

    private boolean g() {
        return this.x != null && getTopInset() > 0;
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((b) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        this.i = -1;
        this.j = -1;
        this.k = -1;
    }

    private void j() {
        if (this.u != null) {
            this.u.clear();
        }
        this.u = null;
    }

    private boolean k() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || af.U(childAt)) ? false : true;
    }

    ao a(ao aoVar) {
        ao aoVar2 = af.U(this) ? aoVar : null;
        if (!androidx.core.m.e.a(this.n, aoVar2)) {
            this.n = aoVar2;
            f();
            requestLayout();
        }
        return aoVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) {
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
        }
        return new b((LinearLayout.LayoutParams) layoutParams);
    }

    void a(int i) {
        this.h = i;
        if (!willNotDraw()) {
            af.h(this);
        }
        if (this.o != null) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.o.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    public void a(@ai a aVar) {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        if (aVar == null || this.o.contains(aVar)) {
            return;
        }
        this.o.add(aVar);
    }

    public void a(c cVar) {
        a((a) cVar);
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    boolean a(@ai View view) {
        View viewB = b(view);
        if (viewB == null) {
            viewB = view;
        }
        return viewB != null && (viewB.canScrollVertically(-1) || viewB.getScrollY() > 0);
    }

    public boolean a(boolean z) {
        this.p = true;
        return d(z);
    }

    public void b(@ai a aVar) {
        if (this.o == null || aVar == null) {
            return;
        }
        this.o.remove(aVar);
    }

    public void b(c cVar) {
        b((a) cVar);
    }

    boolean b() {
        return this.l;
    }

    public boolean b(boolean z) {
        return c(z);
    }

    boolean c() {
        return getTotalScrollRange() != 0;
    }

    boolean c(boolean z) {
        if (this.r == z) {
            return false;
        }
        this.r = z;
        refreshDrawableState();
        if (!this.s || !(getBackground() instanceof j)) {
            return true;
        }
        a((j) getBackground(), z);
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public boolean d() {
        return this.s;
    }

    @Override // android.view.View
    public void draw(@ah Canvas canvas) {
        super.draw(canvas);
        if (g()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.h);
            this.x.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.x;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    void e() {
        this.m = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.a
    @ah
    public CoordinatorLayout.b<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        if (this.j != -1) {
            return this.j;
        }
        int i = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = bVar.k;
            if ((i2 & 5) != 5) {
                if (i > 0) {
                    break;
                }
            } else {
                int i3 = bVar.topMargin + bVar.bottomMargin;
                int iE = (i2 & 8) != 0 ? i3 + af.E(childAt) : (i2 & 2) != 0 ? i3 + (measuredHeight - af.E(childAt)) : i3 + measuredHeight;
                if (childCount == 0 && af.U(childAt)) {
                    iE = Math.min(iE, measuredHeight - getTopInset());
                }
                i += iE;
            }
        }
        int iMax = Math.max(0, i);
        this.j = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        if (this.k != -1) {
            return this.k;
        }
        int childCount = getChildCount();
        int iE = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i2 = bVar.k;
            if ((i2 & 1) == 0) {
                break;
            }
            iE += measuredHeight;
            if ((i2 & 2) != 0) {
                iE -= af.E(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iE);
        this.k = iMax;
        return iMax;
    }

    @w
    public int getLiftOnScrollTargetViewId() {
        return this.t;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iE = af.E(this);
        if (iE != 0) {
            return (iE * 2) + topInset;
        }
        int childCount = getChildCount();
        int iE2 = childCount >= 1 ? af.E(getChildAt(childCount - 1)) : 0;
        return iE2 != 0 ? (iE2 * 2) + topInset : getHeight() / 3;
    }

    int getPendingAction() {
        return this.m;
    }

    @ai
    public Drawable getStatusBarForeground() {
        return this.x;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @ax
    final int getTopInset() {
        if (this.n != null) {
            return this.n.b();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        if (this.i != -1) {
            return this.i;
        }
        int childCount = getChildCount();
        int iE = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = bVar.k;
            if ((i2 & 1) == 0) {
                break;
            }
            iE += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if (i == 0 && af.U(childAt)) {
                iE -= getTopInset();
            }
            if ((i2 & 2) != 0) {
                iE -= af.E(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iE);
        this.i = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.w == null) {
            this.w = new int[4];
        }
        int[] iArr = this.w;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.q ? com.google.android.material.a.c.state_liftable : -com.google.android.material.a.c.state_liftable;
        iArr[1] = (this.q && this.r) ? com.google.android.material.a.c.state_lifted : -com.google.android.material.a.c.state_lifted;
        iArr[2] = this.q ? com.google.android.material.a.c.state_collapsible : -com.google.android.material.a.c.state_collapsible;
        iArr[3] = (this.q && this.r) ? com.google.android.material.a.c.state_collapsed : -com.google.android.material.a.c.state_collapsed;
        return mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (af.U(this) && k()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                af.n(getChildAt(childCount), topInset);
            }
        }
        i();
        this.l = false;
        int childCount2 = getChildCount();
        for (int i5 = 0; i5 < childCount2; i5++) {
            if (((b) getChildAt(i5).getLayoutParams()).b() != null) {
                this.l = true;
                break;
            }
        }
        if (this.x != null) {
            this.x.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.p) {
            return;
        }
        d(this.s || h());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && af.U(this) && k()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = androidx.core.g.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        i();
    }

    @Override // android.view.View
    @am(a = 21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        k.a(this, f2);
    }

    public void setExpanded(boolean z) {
        a(z, af.ag(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.s = z;
    }

    public void setLiftOnScrollTargetViewId(@w int i) {
        this.t = i;
        j();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(@ai Drawable drawable) {
        if (this.x != drawable) {
            if (this.x != null) {
                this.x.setCallback(null);
            }
            this.x = drawable != null ? drawable.mutate() : null;
            if (this.x != null) {
                if (this.x.isStateful()) {
                    this.x.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.x, af.p(this));
                this.x.setVisible(getVisibility() == 0, false);
                this.x.setCallback(this);
            }
            f();
            af.h(this);
        }
    }

    public void setStatusBarForegroundColor(@androidx.annotation.k int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(@androidx.annotation.q int i) {
        setStatusBarForeground(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            f.a(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.x != null) {
            this.x.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@ah Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.x;
    }
}
