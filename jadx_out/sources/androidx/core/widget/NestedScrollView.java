package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.n.ac;
import androidx.core.n.af;
import androidx.core.n.s;
import androidx.core.n.t;
import androidx.core.n.w;
import androidx.core.n.x;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements ac, s, w {
    private static final a B = new a();
    private static final int[] C = {R.attr.fillViewport};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f577a = 250;
    static final float b = 0.5f;
    private static final String c = "NestedScrollView";
    private static final int d = 250;
    private static final int z = -1;
    private c A;
    private final x D;
    private final t E;
    private float F;
    private b G;
    private long e;
    private final Rect f;
    private OverScroller g;
    private EdgeEffect h;
    private EdgeEffect i;
    private int j;
    private boolean k;
    private boolean l;
    private View m;
    private boolean n;
    private VelocityTracker o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private final int[] v;
    private final int[] w;
    private int x;
    private int y;

    static class a extends androidx.core.n.a {
        a() {
        }

        @Override // androidx.core.n.a
        public void a(View view, androidx.core.n.a.d dVar) {
            int scrollRange;
            super.a(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.b((CharSequence) ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.l(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.a(androidx.core.n.a.d.a.n);
                dVar.a(androidx.core.n.a.d.a.y);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.a(androidx.core.n.a.d.a.m);
                dVar.a(androidx.core.n.a.d.a.A);
            }
        }

        @Override // androidx.core.n.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.a(0, iMax, true);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.a(0, iMin, true);
            return true;
        }

        @Override // androidx.core.n.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            androidx.core.n.a.f.a(accessibilityEvent, nestedScrollView.getScrollX());
            androidx.core.n.a.f.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: androidx.core.widget.NestedScrollView.c.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f578a;

        c(Parcel parcel) {
            super(parcel);
            this.f578a = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        @ah
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f578a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f578a);
        }
    }

    public NestedScrollView(@ah Context context) {
        this(context, null);
    }

    public NestedScrollView(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new Rect();
        this.k = true;
        this.l = false;
        this.m = null;
        this.n = false;
        this.q = true;
        this.u = -1;
        this.v = new int[2];
        this.w = new int[2];
        c();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.D = new x(this);
        this.E = new t(this);
        setNestedScrollingEnabled(true);
        af.a(this, B);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    private View a(boolean z2, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        boolean z3 = false;
        View view = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z4 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private void a(int i, int i2, @ai int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.E.a(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.u) {
            int i = actionIndex == 0 ? 1 : 0;
            this.j = (int) motionEvent.getY(i);
            this.u = motionEvent.getPointerId(i);
            if (this.o != null) {
                this.o.clear();
            }
        }
    }

    private void a(boolean z2) {
        if (z2) {
            a(2, 1);
        } else {
            a(1);
        }
        this.y = getScrollY();
        af.h(this);
    }

    private boolean a(Rect rect, boolean z2) {
        int iA = a(rect);
        boolean z3 = iA != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iA);
            } else {
                b(0, iA);
            }
        }
        return z3;
    }

    private boolean a(View view) {
        return !a(view, 0, getHeight());
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.f);
        offsetDescendantRectToMyCoords(view, this.f);
        return this.f.bottom + i >= getScrollY() && this.f.top - i <= getScrollY() + i2;
    }

    private static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private void b(int i, int i2, int i3, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.e > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.g.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            a(z2);
        } else {
            if (!this.g.isFinished()) {
                h();
            }
            scrollBy(i, i2);
        }
        this.e = AnimationUtils.currentAnimationTimeMillis();
    }

    private void b(View view) {
        view.getDrawingRect(this.f);
        offsetDescendantRectToMyCoords(view, this.f);
        int iA = a(this.f);
        if (iA != 0) {
            scrollBy(0, iA);
        }
    }

    private void c() {
        this.g = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.r = viewConfiguration.getScaledTouchSlop();
        this.s = viewConfiguration.getScaledMinimumFlingVelocity();
        this.t = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private boolean c(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = false;
        boolean z3 = i == 33;
        View viewA = a(z3, i2, i3);
        if (viewA == null) {
            viewA = this;
        }
        if (i2 < scrollY || i3 > i4) {
            g(z3 ? i2 - scrollY : i3 - i4);
            z2 = true;
        }
        if (viewA != findFocus()) {
            viewA.requestFocus(i);
        }
        return z2;
    }

    private static int d(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private boolean d(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void e() {
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        } else {
            this.o.clear();
        }
    }

    private void f() {
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
    }

    private void g() {
        if (this.o != null) {
            this.o.recycle();
            this.o = null;
        }
    }

    private void g(int i) {
        if (i != 0) {
            if (this.q) {
                b(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.F == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.F = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.F;
    }

    private void h() {
        this.g.abortAnimation();
        a(1);
    }

    private void i() {
        this.n = false;
        g();
        a(0);
        if (this.h != null) {
            this.h.onRelease();
            this.i.onRelease();
        }
    }

    private void j() {
        if (getOverScrollMode() == 2) {
            this.h = null;
            this.i = null;
        } else if (this.h == null) {
            Context context = getContext();
            this.h = new EdgeEffect(context);
            this.i = new EdgeEffect(context);
        }
    }

    protected int a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        if (rect.bottom > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i2) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || rect.bottom >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // androidx.core.n.r
    public void a(int i) {
        this.E.c(i);
    }

    public final void a(int i, int i2, int i3) {
        b(i, i2, i3, false);
    }

    @Override // androidx.core.n.s
    public void a(int i, int i2, int i3, int i4, @ai int[] iArr, int i5, @ah int[] iArr2) {
        this.E.a(i, i2, i3, i4, iArr, i5, iArr2);
    }

    void a(int i, int i2, int i3, boolean z2) {
        b(i - getScrollX(), i2 - getScrollY(), i3, z2);
    }

    void a(int i, int i2, boolean z2) {
        a(i, i2, androidx.recyclerview.widget.m.a.b, z2);
    }

    @Override // androidx.core.n.v
    public void a(@ah View view, int i) {
        this.D.a(view, i);
        a(i);
    }

    @Override // androidx.core.n.v
    public void a(@ah View view, int i, int i2, int i3, int i4, int i5) {
        a(i4, i5, (int[]) null);
    }

    @Override // androidx.core.n.w
    public void a(@ah View view, int i, int i2, int i3, int i4, int i5, @ah int[] iArr) {
        a(i4, i5, iArr);
    }

    @Override // androidx.core.n.v
    public void a(@ah View view, int i, int i2, @ah int[] iArr, int i3) {
        a(i, i2, iArr, (int[]) null, i3);
    }

    public boolean a() {
        return this.p;
    }

    @Override // androidx.core.n.r
    public boolean a(int i, int i2) {
        return this.E.a(i, i2);
    }

    boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2) {
        boolean z3;
        boolean z4;
        int overScrollMode = getOverScrollMode();
        boolean z5 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z6 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        boolean z8 = overScrollMode == 0 || (overScrollMode == 1 && z6);
        int i9 = i3 + i;
        int i10 = !z7 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z8 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 > i14) {
            z3 = true;
            i13 = i14;
        } else if (i9 < i13) {
            z3 = true;
        } else {
            i13 = i9;
            z3 = false;
        }
        if (i11 <= i16) {
            if (i11 >= i15) {
                i15 = i11;
                z4 = false;
            }
            if (z4 && !b(1)) {
                this.g.springBack(i13, i15, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i13, i15, z3, z4);
            return !z3 || z4;
        }
        i15 = i16;
        z4 = true;
        if (z4) {
            this.g.springBack(i13, i15, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i13, i15, z3, z4);
        if (z3) {
        }
    }

    @Override // androidx.core.n.r
    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.E.a(i, i2, i3, i4, iArr, i5);
    }

    @Override // androidx.core.n.r
    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.E.a(i, i2, iArr, iArr2, i3);
    }

    public boolean a(@ah KeyEvent keyEvent) {
        this.f.setEmpty();
        if (!d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 62) {
            c(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        switch (keyCode) {
            case 19:
                return !keyEvent.isAltPressed() ? e(33) : d(33);
            case 20:
                return !keyEvent.isAltPressed() ? e(130) : d(130);
            default:
                return false;
        }
    }

    @Override // androidx.core.n.v
    public boolean a(@ah View view, @ah View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void b(int i, int i2) {
        b(i, i2, androidx.recyclerview.widget.m.a.b, false);
    }

    public final void b(int i, int i2, int i3) {
        a(i, i2, i3, false);
    }

    @Override // androidx.core.n.v
    public void b(@ah View view, @ah View view2, int i, int i2) {
        this.D.a(view, view2, i, i2);
        a(2, i2);
    }

    public boolean b() {
        return this.q;
    }

    @Override // androidx.core.n.r
    public boolean b(int i) {
        return this.E.a(i);
    }

    public final void c(int i, int i2) {
        a(i, i2, androidx.recyclerview.widget.m.a.b, false);
    }

    public boolean c(int i) {
        boolean z2 = i == 130;
        int height = getHeight();
        if (z2) {
            this.f.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                if (this.f.top + height > bottom) {
                    this.f.top = bottom - height;
                }
            }
        } else {
            this.f.top = getScrollY() - height;
            if (this.f.top < 0) {
                this.f.top = 0;
            }
        }
        this.f.bottom = this.f.top + height;
        return c(i, this.f.top, this.f.bottom);
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.g.isFinished()) {
            return;
        }
        this.g.computeScrollOffset();
        int currY = this.g.getCurrY();
        int i = currY - this.y;
        this.y = currY;
        boolean z2 = false;
        this.w[1] = 0;
        a(0, i, this.w, (int[]) null, 1);
        int i2 = i - this.w[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            this.w[1] = 0;
            a(0, scrollY2, 0, i3, this.v, 1, this.w);
            i2 = i3 - this.w[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z2 = true;
            }
            if (z2) {
                j();
                if (i2 < 0) {
                    if (this.h.isFinished()) {
                        this.h.onAbsorb((int) this.g.getCurrVelocity());
                    }
                } else if (this.i.isFinished()) {
                    this.i.onAbsorb((int) this.g.getCurrVelocity());
                }
            }
            h();
        }
        if (this.g.isFinished()) {
            a(1);
        } else {
            af.h(this);
        }
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.n.ac
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    public boolean d(int i) {
        int childCount;
        boolean z2 = i == 130;
        int height = getHeight();
        this.f.top = 0;
        this.f.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            this.f.top = this.f.bottom - height;
        }
        return c(i, this.f.top, this.f.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean dispatchNestedFling(float f, float f2, boolean z2) {
        return this.E.a(f, f2, z2);
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.E.a(f, f2);
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.E.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.h != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.h.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.h.setSize(width, height);
                if (this.h.draw(canvas)) {
                    af.h(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.i.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.i.setSize(width2, height2);
            if (this.i.draw(canvas)) {
                af.h(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    public boolean e(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !a(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            g(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f);
            g(a(this.f));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !a(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public void f(int i) {
        if (getChildCount() > 0) {
            this.g.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, ActivityChooserView.a.f166a, 0, 0);
            a(true);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * b);
    }

    @Override // android.view.ViewGroup, androidx.core.n.u
    public int getNestedScrollAxes() {
        return this.D.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean hasNestedScrollingParent() {
        return b(0);
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean isNestedScrollingEnabled() {
        return this.E.a();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.n) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    i = 0;
                } else if (i > scrollRange) {
                    i = scrollRange;
                }
                if (i != scrollY) {
                    super.scrollTo(getScrollX(), i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.n) {
            return true;
        }
        int i = action & 255;
        if (i != 6) {
            switch (i) {
                case 0:
                    int y = (int) motionEvent.getY();
                    if (!d((int) motionEvent.getX(), y)) {
                        this.n = false;
                        g();
                    } else {
                        this.j = y;
                        this.u = motionEvent.getPointerId(0);
                        e();
                        this.o.addMovement(motionEvent);
                        this.g.computeScrollOffset();
                        this.n = !this.g.isFinished();
                        a(2, 0);
                    }
                    break;
                case 1:
                case 3:
                    this.n = false;
                    this.u = -1;
                    g();
                    if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        af.h(this);
                    }
                    a(0);
                    break;
                case 2:
                    int i2 = this.u;
                    if (i2 != -1) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                        if (iFindPointerIndex != -1) {
                            int y2 = (int) motionEvent.getY(iFindPointerIndex);
                            if (Math.abs(y2 - this.j) > this.r && (2 & getNestedScrollAxes()) == 0) {
                                this.n = true;
                                this.j = y2;
                                f();
                                this.o.addMovement(motionEvent);
                                this.x = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        } else {
                            Log.e(c, "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        }
                    }
                    break;
            }
        } else {
            a(motionEvent);
        }
        return this.n;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        int measuredHeight = 0;
        this.k = false;
        if (this.m != null && a(this.m, this)) {
            b(this.m);
        }
        this.m = null;
        if (!this.l) {
            if (this.A != null) {
                scrollTo(getScrollX(), this.A.f578a);
                this.A = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iD = d(scrollY, paddingTop, measuredHeight);
            if (iD != scrollY) {
                scrollTo(getScrollX(), iD);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.l = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.p && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, androidx.d.c.b.a.b.b));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedFling(@ah View view, float f, float f2, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        f((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedPreFling(@ah View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedPreScroll(@ah View view, int i, int i2, @ah int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedScroll(@ah View view, int i, int i2, int i3, int i4) {
        a(i4, 0, (int[]) null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedScrollAccepted(@ah View view, @ah View view2, int i) {
        b(view, view2, i, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z2, boolean z3) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || a(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.A = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f578a = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.G != null) {
            this.G.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !a(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f);
        g(a(this.f));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onStartNestedScroll(@ah View view, @ah View view2, int i) {
        return a(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onStopNestedScroll(@ah View view) {
        a(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.x = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.x);
        switch (actionMasked) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z2 = !this.g.isFinished();
                this.n = z2;
                if (z2 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.g.isFinished()) {
                    h();
                }
                this.j = (int) motionEvent.getY();
                this.u = motionEvent.getPointerId(0);
                a(2, 0);
                break;
            case 1:
                VelocityTracker velocityTracker = this.o;
                velocityTracker.computeCurrentVelocity(1000, this.t);
                int yVelocity = (int) velocityTracker.getYVelocity(this.u);
                if (Math.abs(yVelocity) >= this.s) {
                    int i = -yVelocity;
                    float f = i;
                    if (!dispatchNestedPreFling(0.0f, f)) {
                        dispatchNestedFling(0.0f, f, true);
                        f(i);
                    }
                } else if (this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    af.h(this);
                }
                this.u = -1;
                i();
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.u);
                if (iFindPointerIndex != -1) {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i2 = this.j - y;
                    if (!this.n && Math.abs(i2) > this.r) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.n = true;
                        i2 = i2 > 0 ? i2 - this.r : i2 + this.r;
                    }
                    int i3 = i2;
                    if (this.n) {
                        if (a(0, i3, this.w, this.v, 0)) {
                            i3 -= this.w[1];
                            this.x += this.v[1];
                        }
                        int i4 = i3;
                        this.j = y - this.v[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z3 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (a(0, i4, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !b(0)) {
                            this.o.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        this.w[1] = 0;
                        a(0, scrollY2, 0, i4 - scrollY2, this.v, 0, this.w);
                        this.j -= this.v[1];
                        this.x += this.v[1];
                        if (z3) {
                            int i5 = i4 - this.w[1];
                            j();
                            int i6 = scrollY + i5;
                            if (i6 < 0) {
                                e.a(this.h, i5 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.i.isFinished()) {
                                    this.i.onRelease();
                                }
                            } else if (i6 > scrollRange) {
                                e.a(this.i, i5 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.h.isFinished()) {
                                    this.h.onRelease();
                                }
                            }
                            if (this.h != null && (!this.h.isFinished() || !this.i.isFinished())) {
                                af.h(this);
                            }
                        }
                    }
                } else {
                    Log.e(c, "Invalid pointerId=" + this.u + " in onTouchEvent");
                }
                break;
            case 3:
                if (this.n && getChildCount() > 0 && this.g.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    af.h(this);
                }
                this.u = -1;
                i();
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.j = (int) motionEvent.getY(actionIndex);
                this.u = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                a(motionEvent);
                this.j = (int) motionEvent.getY(motionEvent.findPointerIndex(this.u));
                break;
        }
        if (this.o != null) {
            this.o.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.k) {
            this.m = view2;
        } else {
            b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return a(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            g();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.k = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iD = d(i, width, width2);
            int iD2 = d(i2, height, height2);
            if (iD == getScrollX() && iD2 == getScrollY()) {
                return;
            }
            super.scrollTo(iD, iD2);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.p) {
            this.p = z2;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.n.q
    public void setNestedScrollingEnabled(boolean z2) {
        this.E.a(z2);
    }

    public void setOnScrollChangeListener(@ai b bVar) {
        this.G = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.q = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View, androidx.core.n.q
    public boolean startNestedScroll(int i) {
        return a(i, 0);
    }

    @Override // android.view.View, androidx.core.n.q
    public void stopNestedScroll() {
        a(0);
    }
}
