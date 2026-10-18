package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends aj implements androidx.appcompat.view.menu.g.b, androidx.appcompat.view.menu.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f156a = 56;
    static final int b = 4;
    private static final String k = "ActionMenuView";
    androidx.appcompat.view.menu.g.a c;
    e d;
    private androidx.appcompat.view.menu.g l;
    private Context m;
    private int n;
    private boolean o;
    private androidx.appcompat.widget.c p;
    private androidx.appcompat.view.menu.n.a q;
    private boolean r;
    private int s;
    private int t;
    private int u;

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        boolean d();

        boolean e();
    }

    private static class b implements androidx.appcompat.view.menu.n.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar) {
            return false;
        }
    }

    public static class c extends aj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ViewDebug.ExportedProperty
        public boolean f157a;

        @ViewDebug.ExportedProperty
        public int b;

        @ViewDebug.ExportedProperty
        public int c;

        @ViewDebug.ExportedProperty
        public boolean d;

        @ViewDebug.ExportedProperty
        public boolean e;
        boolean f;

        public c(int i, int i2) {
            super(i, i2);
            this.f157a = false;
        }

        c(int i, int i2, boolean z) {
            super(i, i2);
            this.f157a = z;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super((ViewGroup.LayoutParams) cVar);
            this.f157a = cVar.f157a;
        }
    }

    private class d implements androidx.appcompat.view.menu.g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar) {
            if (ActionMenuView.this.c != null) {
                ActionMenuView.this.c.a(gVar);
            }
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar, @androidx.annotation.ah MenuItem menuItem) {
            return ActionMenuView.this.d != null && ActionMenuView.this.d.a(menuItem);
        }
    }

    public interface e {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public ActionMenuView(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.t = (int) (56.0f * f);
        this.u = (int) (f * 4.0f);
        this.m = context;
        this.n = 0;
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.b();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.d = !cVar.f157a && z;
        cVar.b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, androidx.d.c.b.a.b.b), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:135:0x0246  */
    /* JADX WARN: Code duplicated, block: B:138:0x024d A[ADDED_TO_REGION, LOOP:5: B:138:0x024d->B:143:0x026f, LOOP_START, PHI: r3 r32
      0x024d: PHI (r3v8 int) = (r3v7 int), (r3v9 int) binds: [B:137:0x024b, B:143:0x026f] A[DONT_GENERATE, DONT_INLINE]
      0x024d: PHI (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:137:0x024b, B:143:0x026f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x024f  */
    /* JADX WARN: Code duplicated, block: B:141:0x025d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0260  */
    /* JADX WARN: Code duplicated, block: B:145:0x0276  */
    /* JADX WARN: Code duplicated, block: B:146:0x027b  */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v20 */
    private void c(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        View childAt;
        c cVar;
        int i7;
        ?? r6;
        ?? r2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = i8 / this.t;
        int i10 = i8 % this.t;
        if (i9 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i11 = this.t + (i10 / i9);
        int childCount = getChildCount();
        int i12 = i9;
        int i13 = 0;
        int iMax = 0;
        boolean z2 = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j = 0;
        while (i13 < childCount) {
            View childAt2 = getChildAt(i13);
            int i17 = size2;
            if (childAt2.getVisibility() == 8) {
                i8 = i8;
            } else {
                boolean z3 = childAt2 instanceof ActionMenuItemView;
                int i18 = i14 + 1;
                if (z3) {
                    r2 = 0;
                    childAt2.setPadding(this.u, 0, this.u, 0);
                } else {
                    r2 = 0;
                }
                c cVar2 = (c) childAt2.getLayoutParams();
                cVar2.f = r2;
                cVar2.c = r2;
                cVar2.b = r2;
                cVar2.d = r2;
                cVar2.leftMargin = r2;
                cVar2.rightMargin = r2;
                cVar2.e = z3 && ((ActionMenuItemView) childAt2).b();
                int iA = a(childAt2, i11, cVar2.f157a ? 1 : i12, childMeasureSpec, paddingTop);
                int iMax2 = Math.max(i15, iA);
                if (cVar2.d) {
                    i16++;
                }
                if (cVar2.f157a) {
                    z2 = true;
                }
                i12 -= iA;
                iMax = Math.max(iMax, childAt2.getMeasuredHeight());
                if (iA == 1) {
                    j |= (long) (1 << i13);
                }
                i14 = i18;
                i15 = iMax2;
            }
            i13++;
            size2 = i17;
            i8 = i8;
        }
        int i19 = i8;
        int i20 = size2;
        boolean z4 = z2 && i14 == 2;
        boolean z5 = false;
        while (true) {
            if (i16 <= 0 || i12 <= 0) {
                z = z5;
                break;
            }
            int i21 = Integer.MAX_VALUE;
            int i22 = 0;
            int i23 = 0;
            long j2 = 0;
            while (i22 < childCount) {
                c cVar3 = (c) getChildAt(i22).getLayoutParams();
                boolean z6 = z5;
                if (cVar3.d) {
                    if (cVar3.b < i21) {
                        j2 = 1 << i22;
                        i21 = cVar3.b;
                        i23 = 1;
                    } else if (cVar3.b == i21) {
                        j2 |= 1 << i22;
                        i23++;
                    }
                }
                i22++;
                z5 = z6;
            }
            z = z5;
            j |= j2;
            if (i23 > i12) {
                break;
            }
            int i24 = i21 + 1;
            int i25 = 0;
            while (i25 < childCount) {
                View childAt3 = getChildAt(i25);
                c cVar4 = (c) childAt3.getLayoutParams();
                int i26 = iMax;
                int i27 = childMeasureSpec;
                int i28 = childCount;
                long j3 = 1 << i25;
                if ((j2 & j3) != 0) {
                    if (z4 && cVar4.e) {
                        r6 = 1;
                        r6 = 1;
                        if (i12 == 1) {
                            childAt3.setPadding(this.u + i11, 0, this.u, 0);
                        }
                    } else {
                        r6 = 1;
                    }
                    cVar4.b += r6;
                    cVar4.f = r6;
                    i12--;
                } else if (cVar4.b == i24) {
                    j |= j3;
                }
                i25++;
                iMax = i26;
                childMeasureSpec = i27;
                childCount = i28;
            }
            z5 = true;
        }
        int i29 = childMeasureSpec;
        int i30 = childCount;
        int i31 = iMax;
        if (!z2) {
            i3 = 1;
            boolean z7 = i14 == 1;
            if (i12 > 0 || j == 0 || (i12 >= i14 - i3 && !z7 && i15 <= i3)) {
                i4 = i30;
                i5 = 0;
            } else {
                float fBitCount = Long.bitCount(j);
                if (z7) {
                    i5 = 0;
                } else {
                    if ((j & 1) != 0) {
                        i5 = 0;
                        if (!((c) getChildAt(0).getLayoutParams()).e) {
                            fBitCount -= 0.5f;
                        }
                    } else {
                        i5 = 0;
                    }
                    int i32 = i30 - 1;
                    if ((j & ((long) (1 << i32))) != 0 && !((c) getChildAt(i32).getLayoutParams()).e) {
                        fBitCount -= 0.5f;
                    }
                }
                int i33 = fBitCount > 0.0f ? (int) ((i12 * i11) / fBitCount) : i5;
                boolean z8 = z;
                i4 = i30;
                for (int i34 = i5; i34 < i4; i34++) {
                    if ((j & ((long) (1 << i34))) != 0) {
                        View childAt4 = getChildAt(i34);
                        c cVar5 = (c) childAt4.getLayoutParams();
                        if (childAt4 instanceof ActionMenuItemView) {
                            cVar5.c = i33;
                            cVar5.f = true;
                            if (i34 == 0 && !cVar5.e) {
                                cVar5.leftMargin = (-i33) / 2;
                            }
                            z8 = true;
                        } else if (cVar5.f157a) {
                            cVar5.c = i33;
                            cVar5.f = true;
                            cVar5.rightMargin = (-i33) / 2;
                            z8 = true;
                        } else {
                            if (i34 != 0) {
                                cVar5.leftMargin = i33 / 2;
                            }
                            if (i34 != i4 - 1) {
                                cVar5.rightMargin = i33 / 2;
                            }
                        }
                    }
                }
                z = z8;
            }
            if (z) {
                while (i5 < i4) {
                    childAt = getChildAt(i5);
                    cVar = (c) childAt.getLayoutParams();
                    if (cVar.f) {
                        i7 = i29;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((cVar.b * i11) + cVar.c, androidx.d.c.b.a.b.b), i7);
                    } else {
                        i7 = i29;
                    }
                    i5++;
                    i29 = i7;
                }
            }
            if (mode != 1073741824) {
                i6 = i31;
            } else {
                i6 = i20;
            }
            setMeasuredDimension(i19, i6);
        }
        i3 = 1;
        if (i12 > 0) {
            i4 = i30;
            i5 = 0;
        } else {
            i4 = i30;
            i5 = 0;
        }
        if (z) {
            while (i5 < i4) {
                childAt = getChildAt(i5);
                cVar = (c) childAt.getLayoutParams();
                if (cVar.f) {
                    i7 = i29;
                } else {
                    i7 = i29;
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((cVar.b * i11) + cVar.c, androidx.d.c.b.a.b.b), i7);
                }
                i5++;
                i29 = i7;
            }
        }
        if (mode != 1073741824) {
            i6 = i31;
        } else {
            i6 = i20;
        }
        setMeasuredDimension(i19, i6);
    }

    @Override // androidx.appcompat.widget.aj, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.aj, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.h <= 0) {
            cVar.h = 16;
        }
        return cVar;
    }

    @Override // androidx.appcompat.view.menu.o
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(androidx.appcompat.view.menu.g gVar) {
        this.l = gVar;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.q = aVar;
        this.c = aVar2;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean a() {
        return this.o;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected boolean a(int i) {
        boolean zE = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zE = false | ((a) childAt).e();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zE : zE | ((a) childAt2).d();
    }

    @Override // androidx.appcompat.view.menu.g.b
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean a(androidx.appcompat.view.menu.j jVar) {
        return this.l.a(jVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.aj
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        cVar.h = 16;
        return cVar;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public c c() {
        c cVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        cVarGenerateDefaultLayoutParams.f157a = true;
        return cVarGenerateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.widget.aj, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public androidx.appcompat.view.menu.g d() {
        return this.l;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        return this.p != null && this.p.e();
    }

    public boolean f() {
        return this.p != null && this.p.g();
    }

    public boolean g() {
        return this.p != null && this.p.j();
    }

    public Menu getMenu() {
        if (this.l == null) {
            Context context = getContext();
            this.l = new androidx.appcompat.view.menu.g(context);
            this.l.a(new d());
            this.p = new androidx.appcompat.widget.c(context);
            this.p.b(true);
            this.p.a(this.q != null ? this.q : new b());
            this.l.a(this.p, this.m);
            this.p.a(this);
        }
        return this.l;
    }

    @androidx.annotation.ai
    public Drawable getOverflowIcon() {
        getMenu();
        return this.p.d();
    }

    public int getPopupTheme() {
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.o
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean h() {
        return this.p != null && this.p.k();
    }

    public void i() {
        if (this.p != null) {
            this.p.h();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.p != null) {
            this.p.a(false);
            if (this.p.j()) {
                this.p.g();
                this.p.e();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // androidx.appcompat.widget.aj, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.r) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zA = bg.a(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f157a) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (a(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + cVar.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    a(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f157a) {
                    int i16 = width2 - cVar2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + cVar2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f157a) {
                int i18 = paddingLeft2 + cVar3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + cVar3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // androidx.appcompat.widget.aj, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.r;
        this.r = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.r) {
            this.s = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.r && this.l != null && size != this.s) {
            this.s = size;
            this.l.c(true);
        }
        int childCount = getChildCount();
        if (this.r && childCount > 0) {
            c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.p.c(z);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.d = eVar;
    }

    public void setOverflowIcon(@androidx.annotation.ai Drawable drawable) {
        getMenu();
        this.p.a(drawable);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z) {
        this.o = z;
    }

    public void setPopupTheme(@androidx.annotation.at int i) {
        if (this.n != i) {
            this.n = i;
            if (i == 0) {
                this.m = getContext();
            } else {
                this.m = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setPresenter(androidx.appcompat.widget.c cVar) {
        this.p = cVar;
        this.p.a(this);
    }
}
