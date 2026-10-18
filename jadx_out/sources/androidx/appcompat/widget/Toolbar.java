package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String e = "Toolbar";
    private CharSequence A;
    private ColorStateList B;
    private ColorStateList C;
    private boolean D;
    private boolean E;
    private final ArrayList<View> F;
    private final ArrayList<View> G;
    private final int[] H;
    private final ActionMenuView.e I;
    private bb J;
    private androidx.appcompat.widget.c K;
    private a L;
    private androidx.appcompat.view.menu.n.a M;
    private androidx.appcompat.view.menu.g.a N;
    private boolean O;
    private final Runnable P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageButton f188a;
    View b;
    int c;
    c d;
    private ActionMenuView f;
    private TextView g;
    private TextView h;
    private ImageButton i;
    private ImageView j;
    private Drawable k;
    private CharSequence l;
    private Context m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private aq v;
    private int w;
    private int x;
    private int y;
    private CharSequence z;

    private class a implements androidx.appcompat.view.menu.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.g f192a;
        androidx.appcompat.view.menu.j b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.n
        public androidx.appcompat.view.menu.o a(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.n
        public void a(Context context, androidx.appcompat.view.menu.g gVar) {
            if (this.f192a != null && this.b != null) {
                this.f192a.d(this.b);
            }
            this.f192a = gVar;
        }

        @Override // androidx.appcompat.view.menu.n
        public void a(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.n
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.n
        public void a(androidx.appcompat.view.menu.n.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.n
        public void a(boolean z) {
            if (this.b != null) {
                boolean z2 = false;
                if (this.f192a != null) {
                    int size = this.f192a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f192a.getItem(i) == this.b) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f192a, this.b);
            }
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
            Toolbar.this.j();
            ViewParent parent = Toolbar.this.f188a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.f188a);
                }
                Toolbar.this.addView(Toolbar.this.f188a);
            }
            Toolbar.this.b = jVar.getActionView();
            this.b = jVar;
            ViewParent parent2 = Toolbar.this.b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.b);
                }
                b bVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.f46a = 8388611 | (Toolbar.this.c & 112);
                bVarGenerateDefaultLayoutParams.e = 2;
                Toolbar.this.b.setLayoutParams(bVarGenerateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.b);
            }
            Toolbar.this.l();
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.b).a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean a(androidx.appcompat.view.menu.s sVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean b() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n
        public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.j jVar) {
            if (Toolbar.this.b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.b).b();
            }
            Toolbar.this.removeView(Toolbar.this.b);
            Toolbar.this.removeView(Toolbar.this.f188a);
            Toolbar.this.b = null;
            Toolbar.this.m();
            this.b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.n
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.n
        public Parcelable f() {
            return null;
        }
    }

    public static class b extends androidx.appcompat.app.a.b {
        static final int b = 0;
        static final int c = 1;
        static final int d = 2;
        int e;

        public b(int i) {
            this(-2, -1, i);
        }

        public b(int i, int i2) {
            super(i, i2);
            this.e = 0;
            this.f46a = 8388627;
        }

        public b(int i, int i2, int i3) {
            super(i, i2);
            this.e = 0;
            this.f46a = i3;
        }

        public b(@androidx.annotation.ah Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = 0;
            a(marginLayoutParams);
        }

        public b(androidx.appcompat.app.a.b bVar) {
            super(bVar);
            this.e = 0;
        }

        public b(b bVar) {
            super((androidx.appcompat.app.a.b) bVar);
            this.e = 0;
            this.e = bVar.e;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public static class d extends androidx.f.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: androidx.appcompat.widget.Toolbar.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f193a;
        boolean b;

        public d(Parcel parcel) {
            this(parcel, null);
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f193a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.f.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f193a);
            parcel.writeInt(this.b ? 1 : 0);
        }
    }

    public Toolbar(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public Toolbar(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.toolbarStyle);
    }

    public Toolbar(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = 8388627;
        this.F = new ArrayList<>();
        this.G = new ArrayList<>();
        this.H = new int[2];
        this.I = new ActionMenuView.e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.d != null) {
                    return Toolbar.this.d.a(menuItem);
                }
                return false;
            }
        };
        this.P = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.d();
            }
        };
        ba baVarA = ba.a(getContext(), attributeSet, androidx.appcompat.a.m.Toolbar, i, 0);
        androidx.core.n.af.a(this, context, androidx.appcompat.a.m.Toolbar, attributeSet, baVarA.a(), i, 0);
        this.o = baVarA.g(androidx.appcompat.a.m.Toolbar_titleTextAppearance, 0);
        this.p = baVarA.g(androidx.appcompat.a.m.Toolbar_subtitleTextAppearance, 0);
        this.y = baVarA.c(androidx.appcompat.a.m.Toolbar_android_gravity, this.y);
        this.c = baVarA.c(androidx.appcompat.a.m.Toolbar_buttonGravity, 48);
        int iD = baVarA.d(androidx.appcompat.a.m.Toolbar_titleMargin, 0);
        iD = baVarA.j(androidx.appcompat.a.m.Toolbar_titleMargins) ? baVarA.d(androidx.appcompat.a.m.Toolbar_titleMargins, iD) : iD;
        this.u = iD;
        this.t = iD;
        this.s = iD;
        this.r = iD;
        int iD2 = baVarA.d(androidx.appcompat.a.m.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.r = iD2;
        }
        int iD3 = baVarA.d(androidx.appcompat.a.m.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.s = iD3;
        }
        int iD4 = baVarA.d(androidx.appcompat.a.m.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.t = iD4;
        }
        int iD5 = baVarA.d(androidx.appcompat.a.m.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.u = iD5;
        }
        this.q = baVarA.e(androidx.appcompat.a.m.Toolbar_maxButtonHeight, -1);
        int iD6 = baVarA.d(androidx.appcompat.a.m.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iD7 = baVarA.d(androidx.appcompat.a.m.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iE = baVarA.e(androidx.appcompat.a.m.Toolbar_contentInsetLeft, 0);
        int iE2 = baVarA.e(androidx.appcompat.a.m.Toolbar_contentInsetRight, 0);
        t();
        this.v.b(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.v.a(iD6, iD7);
        }
        this.w = baVarA.d(androidx.appcompat.a.m.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.x = baVarA.d(androidx.appcompat.a.m.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.k = baVarA.a(androidx.appcompat.a.m.Toolbar_collapseIcon);
        this.l = baVarA.d(androidx.appcompat.a.m.Toolbar_collapseContentDescription);
        CharSequence charSequenceD = baVarA.d(androidx.appcompat.a.m.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceD)) {
            setTitle(charSequenceD);
        }
        CharSequence charSequenceD2 = baVarA.d(androidx.appcompat.a.m.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceD2)) {
            setSubtitle(charSequenceD2);
        }
        this.m = getContext();
        setPopupTheme(baVarA.g(androidx.appcompat.a.m.Toolbar_popupTheme, 0));
        Drawable drawableA = baVarA.a(androidx.appcompat.a.m.Toolbar_navigationIcon);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        CharSequence charSequenceD3 = baVarA.d(androidx.appcompat.a.m.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceD3)) {
            setNavigationContentDescription(charSequenceD3);
        }
        Drawable drawableA2 = baVarA.a(androidx.appcompat.a.m.Toolbar_logo);
        if (drawableA2 != null) {
            setLogo(drawableA2);
        }
        CharSequence charSequenceD4 = baVarA.d(androidx.appcompat.a.m.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceD4)) {
            setLogoDescription(charSequenceD4);
        }
        if (baVarA.j(androidx.appcompat.a.m.Toolbar_titleTextColor)) {
            setTitleTextColor(baVarA.g(androidx.appcompat.a.m.Toolbar_titleTextColor));
        }
        if (baVarA.j(androidx.appcompat.a.m.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(baVarA.g(androidx.appcompat.a.m.Toolbar_subtitleTextColor));
        }
        if (baVarA.j(androidx.appcompat.a.m.Toolbar_menu)) {
            a(baVarA.g(androidx.appcompat.a.m.Toolbar_menu, 0));
        }
        baVarA.f();
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iB = b(bVar.f46a);
        if (iB == 48) {
            return getPaddingTop() - i2;
        }
        if (iB == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < bVar.topMargin) {
            iMax = bVar.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < bVar.bottomMargin) {
                iMax = Math.max(0, iMax - (bVar.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iA, iMax + measuredWidth, view.getMeasuredHeight() + iA);
        return iMax + measuredWidth + bVar.rightMargin;
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int measuredWidth = 0;
        int i3 = i2;
        int i4 = 0;
        while (i4 < size) {
            View view = list.get(i4);
            b bVar = (b) view.getLayoutParams();
            int i5 = bVar.leftMargin - i;
            int i6 = bVar.rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, androidx.d.c.b.a.b.b);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void a(View view, boolean z) {
        b bVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            bVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (b) layoutParams;
        }
        bVarGenerateLayoutParams.e = 1;
        if (!z || this.b == null) {
            addView(view, bVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(bVarGenerateLayoutParams);
            this.G.add(view);
        }
    }

    private void a(List<View> list, int i) {
        boolean z = androidx.core.n.af.p(this) == 1;
        int childCount = getChildCount();
        int iA = androidx.core.n.h.a(i, androidx.core.n.af.p(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.e == 0 && a(childAt) && c(bVar.f46a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.e == 0 && a(childAt2) && c(bVar2.f46a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.y & 112;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.n.m.a(marginLayoutParams) + androidx.core.n.m.b(marginLayoutParams);
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iA, iMax, view.getMeasuredHeight() + iA);
        return iMax - (measuredWidth + bVar.leftMargin);
    }

    private int c(int i) {
        int iP = androidx.core.n.af.p(this);
        int iA = androidx.core.n.h.a(i, iP) & 7;
        if (iA == 1 || iA == 3 || iA == 5) {
            return iA;
        }
        return iP == 1 ? 5 : 3;
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private boolean d(View view) {
        return view.getParent() == this || this.G.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    private void n() {
        if (this.j == null) {
            this.j = new p(getContext());
        }
    }

    private void o() {
        p();
        if (this.f.d() == null) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.f.getMenu();
            if (this.L == null) {
                this.L = new a();
            }
            this.f.setExpandedActionViewsExclusive(true);
            gVar.a(this.L, this.m);
        }
    }

    private void p() {
        if (this.f == null) {
            this.f = new ActionMenuView(getContext());
            this.f.setPopupTheme(this.n);
            this.f.setOnMenuItemClickListener(this.I);
            this.f.a(this.M, this.N);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f46a = 8388613 | (this.c & 112);
            this.f.setLayoutParams(bVarGenerateDefaultLayoutParams);
            a((View) this.f, false);
        }
    }

    private void q() {
        if (this.i == null) {
            this.i = new n(getContext(), null, androidx.appcompat.a.b.toolbarNavigationButtonStyle);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f46a = 8388611 | (this.c & 112);
            this.i.setLayoutParams(bVarGenerateDefaultLayoutParams);
        }
    }

    private void r() {
        removeCallbacks(this.P);
        post(this.P);
    }

    private boolean s() {
        if (!this.O) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private void t() {
        if (this.v == null) {
            this.v = new aq();
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a.b) {
            return new b((androidx.appcompat.app.a.b) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(@androidx.annotation.af int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void a(int i, int i2) {
        t();
        this.v.a(i, i2);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.r = i;
        this.t = i2;
        this.s = i3;
        this.u = i4;
        requestLayout();
    }

    public void a(Context context, @androidx.annotation.at int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.widget.c cVar) {
        if (gVar == null && this.f == null) {
            return;
        }
        p();
        androidx.appcompat.view.menu.g gVarD = this.f.d();
        if (gVarD == gVar) {
            return;
        }
        if (gVarD != null) {
            gVarD.b(this.K);
            gVarD.b(this.L);
        }
        if (this.L == null) {
            this.L = new a();
        }
        cVar.c(true);
        if (gVar != null) {
            gVar.a(cVar, this.m);
            gVar.a(this.L, this.m);
        } else {
            cVar.a(this.m, (androidx.appcompat.view.menu.g) null);
            this.L.a(this.m, (androidx.appcompat.view.menu.g) null);
            cVar.a(true);
            this.L.a(true);
        }
        this.f.setPopupTheme(this.n);
        this.f.setPresenter(cVar);
        this.K = cVar;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(androidx.appcompat.view.menu.n.a aVar, androidx.appcompat.view.menu.g.a aVar2) {
        this.M = aVar;
        this.N = aVar2;
        if (this.f != null) {
            this.f.a(aVar, aVar2);
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean a() {
        return getVisibility() == 0 && this.f != null && this.f.a();
    }

    public void b(int i, int i2) {
        t();
        this.v.b(i, i2);
    }

    public void b(Context context, @androidx.annotation.at int i) {
        this.p = i;
        if (this.h != null) {
            this.h.setTextAppearance(context, i);
        }
    }

    public boolean b() {
        return this.f != null && this.f.g();
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean c() {
        return this.f != null && this.f.h();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.f != null && this.f.e();
    }

    public boolean e() {
        return this.f != null && this.f.f();
    }

    public void f() {
        if (this.f != null) {
            this.f.i();
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean g() {
        Layout layout;
        if (this.g == null || (layout = this.g.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.ai
    public CharSequence getCollapseContentDescription() {
        if (this.f188a != null) {
            return this.f188a.getContentDescription();
        }
        return null;
    }

    @androidx.annotation.ai
    public Drawable getCollapseIcon() {
        if (this.f188a != null) {
            return this.f188a.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        if (this.v != null) {
            return this.v.d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        return this.x != Integer.MIN_VALUE ? this.x : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        if (this.v != null) {
            return this.v.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.v != null) {
            return this.v.b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        if (this.v != null) {
            return this.v.c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.g gVarD;
        return this.f != null && (gVarD = this.f.d()) != null && gVarD.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.x, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return androidx.core.n.af.p(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return androidx.core.n.af.p(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.w, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.j != null) {
            return this.j.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.j != null) {
            return this.j.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        o();
        return this.f.getMenu();
    }

    @androidx.annotation.ai
    public CharSequence getNavigationContentDescription() {
        if (this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    @androidx.annotation.ai
    public Drawable getNavigationIcon() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        return null;
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.K;
    }

    @androidx.annotation.ai
    public Drawable getOverflowIcon() {
        o();
        return this.f.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.m;
    }

    public int getPopupTheme() {
        return this.n;
    }

    public CharSequence getSubtitle() {
        return this.A;
    }

    @androidx.annotation.ai
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.TESTS})
    final TextView getSubtitleTextView() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.z;
    }

    public int getTitleMarginBottom() {
        return this.u;
    }

    public int getTitleMarginEnd() {
        return this.s;
    }

    public int getTitleMarginStart() {
        return this.r;
    }

    public int getTitleMarginTop() {
        return this.t;
    }

    @androidx.annotation.ai
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.TESTS})
    final TextView getTitleTextView() {
        return this.g;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public ae getWrapper() {
        if (this.J == null) {
            this.J = new bb(this, true);
        }
        return this.J;
    }

    public boolean h() {
        return (this.L == null || this.L.b == null) ? false : true;
    }

    public void i() {
        androidx.appcompat.view.menu.j jVar = this.L == null ? null : this.L.b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    void j() {
        if (this.f188a == null) {
            this.f188a = new n(getContext(), null, androidx.appcompat.a.b.toolbarNavigationButtonStyle);
            this.f188a.setImageDrawable(this.k);
            this.f188a.setContentDescription(this.l);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f46a = 8388611 | (this.c & 112);
            bVarGenerateDefaultLayoutParams.e = 2;
            this.f188a.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.f188a.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    void l() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).e != 2 && childAt != this.f) {
                removeViewAt(childCount);
                this.G.add(childAt);
            }
        }
    }

    void m() {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            addView(this.G.get(size));
        }
        this.G.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.E = false;
        }
        if (!this.E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.E = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.E = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0293  */
    /* JADX WARN: Code duplicated, block: B:102:0x0296  */
    /* JADX WARN: Code duplicated, block: B:105:0x02aa A[LOOP:0: B:104:0x02a8->B:105:0x02aa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02cc A[LOOP:1: B:107:0x02ca->B:108:0x02cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:112:0x02f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:117:0x0306 A[LOOP:2: B:116:0x0304->B:117:0x0306, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0078  */
    /* JADX WARN: Code duplicated, block: B:26:0x007f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x0100  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x011d  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x0134  */
    /* JADX WARN: Code duplicated, block: B:54:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x016a  */
    /* JADX WARN: Code duplicated, block: B:68:0x016e  */
    /* JADX WARN: Code duplicated, block: B:70:0x017d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0184  */
    /* JADX WARN: Code duplicated, block: B:73:0x018f  */
    /* JADX WARN: Code duplicated, block: B:75:0x019d  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:80:0x01be  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x021f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0222  */
    /* JADX WARN: Code duplicated, block: B:91:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x022d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0233  */
    /* JADX WARN: Code duplicated, block: B:96:0x0249  */
    /* JADX WARN: Code duplicated, block: B:97:0x026c  */
    /* JADX WARN: Code duplicated, block: B:99:0x026f  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        int iB;
        int iMax;
        int iMin;
        boolean zA;
        boolean zA2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        b bVar;
        b bVar2;
        boolean z2;
        int i5;
        int i6;
        int paddingTop;
        int i7;
        int i8;
        int i9;
        int i10;
        char c2;
        int i11;
        int i12;
        int i13;
        int iMax2;
        int i14;
        int size;
        int iA2;
        int i15;
        int i16;
        int size2;
        int i17;
        int i18;
        int i19;
        int size3;
        boolean z3 = androidx.core.n.af.p(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i20 = width - paddingRight;
        int[] iArr = this.H;
        iArr[1] = 0;
        iArr[0] = 0;
        int iE = androidx.core.n.af.E(this);
        int iMin2 = iE >= 0 ? Math.min(iE, i4 - i2) : 0;
        if (a(this.i)) {
            if (z3) {
                iB = b(this.i, i20, iArr, iMin2);
                iA = paddingLeft;
            } else {
                iA = a(this.i, paddingLeft, iArr, iMin2);
            }
            if (a(this.f188a)) {
                if (z3) {
                    iB = b(this.f188a, iB, iArr, iMin2);
                } else {
                    iA = a(this.f188a, iA, iArr, iMin2);
                }
            }
            if (a(this.f)) {
                if (z3) {
                    iA = a(this.f, iA, iArr, iMin2);
                } else {
                    iB = b(this.f, iB, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iA);
            iArr[1] = Math.max(0, currentContentInsetRight - (i20 - iB));
            iMax = Math.max(iA, currentContentInsetLeft);
            iMin = Math.min(iB, i20 - currentContentInsetRight);
            if (a(this.b)) {
                if (z3) {
                    iMin = b(this.b, iMin, iArr, iMin2);
                } else {
                    iMax = a(this.b, iMax, iArr, iMin2);
                }
            }
            if (a(this.j)) {
                if (z3) {
                    iMin = b(this.j, iMin, iArr, iMin2);
                } else {
                    iMax = a(this.j, iMax, iArr, iMin2);
                }
            }
            zA = a(this.g);
            zA2 = a(this.h);
            if (zA) {
                b bVar3 = (b) this.g.getLayoutParams();
                measuredHeight = bVar3.topMargin + this.g.getMeasuredHeight() + bVar3.bottomMargin + 0;
            } else {
                measuredHeight = 0;
            }
            if (zA2) {
                b bVar4 = (b) this.h.getLayoutParams();
                measuredHeight += bVar4.topMargin + this.h.getMeasuredHeight() + bVar4.bottomMargin;
            }
            if (!zA || zA2) {
                if (zA) {
                    textView = this.g;
                } else {
                    textView = this.h;
                }
                if (zA2) {
                    textView2 = this.h;
                } else {
                    textView2 = this.g;
                }
                bVar = (b) textView.getLayoutParams();
                bVar2 = (b) textView2.getLayoutParams();
                z2 = (!zA && this.g.getMeasuredWidth() > 0) || (zA2 && this.h.getMeasuredWidth() > 0);
                i5 = this.y & 112;
                i6 = iMin2;
                if (i5 == 48) {
                    paddingTop = getPaddingTop() + bVar.topMargin + this.t;
                } else if (i5 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    if (iMax2 < bVar.topMargin + this.t) {
                        iMax2 = bVar.topMargin + this.t;
                    } else {
                        i14 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        if (i14 < bVar.bottomMargin + this.u) {
                            iMax2 = Math.max(0, iMax2 - ((bVar2.bottomMargin + this.u) - i14));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - bVar2.bottomMargin) - this.u) - measuredHeight;
                }
                if (z3) {
                    if (z2) {
                        i11 = this.r;
                        c2 = 1;
                    } else {
                        c2 = 1;
                        i11 = 0;
                    }
                    int i21 = i11 - iArr[c2];
                    iMin -= Math.max(0, i21);
                    iArr[c2] = Math.max(0, -i21);
                    if (zA) {
                        b bVar5 = (b) this.g.getLayoutParams();
                        int measuredWidth = iMin - this.g.getMeasuredWidth();
                        int measuredHeight2 = this.g.getMeasuredHeight() + paddingTop;
                        this.g.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i12 = measuredWidth - this.s;
                        paddingTop = measuredHeight2 + bVar5.bottomMargin;
                    } else {
                        i12 = iMin;
                    }
                    if (zA2) {
                        b bVar6 = (b) this.h.getLayoutParams();
                        int i22 = paddingTop + bVar6.topMargin;
                        this.h.layout(iMin - this.h.getMeasuredWidth(), i22, iMin, this.h.getMeasuredHeight() + i22);
                        i13 = iMin - this.s;
                        int i23 = bVar6.bottomMargin;
                    } else {
                        i13 = iMin;
                    }
                    if (z2) {
                        iMin = Math.min(i12, i13);
                    }
                    iMax = iMax;
                } else {
                    if (z2) {
                        i8 = this.r;
                        i7 = 0;
                    } else {
                        i7 = 0;
                        i8 = 0;
                    }
                    int i24 = i8 - iArr[i7];
                    iMax += Math.max(i7, i24);
                    iArr[i7] = Math.max(i7, -i24);
                    if (zA) {
                        b bVar7 = (b) this.g.getLayoutParams();
                        int measuredWidth2 = this.g.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.g.getMeasuredHeight() + paddingTop;
                        this.g.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i9 = measuredWidth2 + this.s;
                        paddingTop = measuredHeight3 + bVar7.bottomMargin;
                    } else {
                        i9 = iMax;
                    }
                    if (zA2) {
                        b bVar8 = (b) this.h.getLayoutParams();
                        int i25 = paddingTop + bVar8.topMargin;
                        int measuredWidth3 = this.h.getMeasuredWidth() + iMax;
                        this.h.layout(iMax, i25, measuredWidth3, this.h.getMeasuredHeight() + i25);
                        i10 = measuredWidth3 + this.s;
                        int i26 = bVar8.bottomMargin;
                    } else {
                        i10 = iMax;
                    }
                    if (z2) {
                        iMax = Math.max(i9, i10);
                    }
                }
                a(this.F, 3);
                size = this.F.size();
                iA2 = iMax;
                for (i15 = i7; i15 < size; i15++) {
                    iA2 = a(this.F.get(i15), iA2, iArr, i6);
                }
                i16 = i6;
                a(this.F, 5);
                size2 = this.F.size();
                for (i17 = i7; i17 < size2; i17++) {
                    iMin = b(this.F.get(i17), iMin, iArr, i16);
                }
                a(this.F, 1);
                int iA3 = a(this.F, iArr);
                i18 = (paddingLeft + (((width - paddingLeft) - paddingRight) / 2)) - (iA3 / 2);
                i19 = iA3 + i18;
                if (i18 >= iA2) {
                    if (i19 > iMin) {
                        iA2 = i18 - (i19 - iMin);
                    } else {
                        iA2 = i18;
                    }
                }
                size3 = this.F.size();
                while (i7 < size3) {
                    iA2 = a(this.F.get(i7), iA2, iArr, i16);
                    i7++;
                }
                this.F.clear();
            }
            paddingLeft = paddingLeft;
            i6 = iMin2;
            i7 = 0;
            a(this.F, 3);
            size = this.F.size();
            iA2 = iMax;
            while (i15 < size) {
                iA2 = a(this.F.get(i15), iA2, iArr, i6);
            }
            i16 = i6;
            a(this.F, 5);
            size2 = this.F.size();
            while (i17 < size2) {
                iMin = b(this.F.get(i17), iMin, iArr, i16);
            }
            a(this.F, 1);
            int iA4 = a(this.F, iArr);
            i18 = (paddingLeft + (((width - paddingLeft) - paddingRight) / 2)) - (iA4 / 2);
            i19 = iA4 + i18;
            if (i18 >= iA2) {
                if (i19 > iMin) {
                    iA2 = i18 - (i19 - iMin);
                } else {
                    iA2 = i18;
                }
            }
            size3 = this.F.size();
            while (i7 < size3) {
                iA2 = a(this.F.get(i7), iA2, iArr, i16);
                i7++;
            }
            this.F.clear();
        }
        iA = paddingLeft;
        iB = i20;
        if (a(this.f188a)) {
            if (z3) {
                iB = b(this.f188a, iB, iArr, iMin2);
            } else {
                iA = a(this.f188a, iA, iArr, iMin2);
            }
        }
        if (a(this.f)) {
            if (z3) {
                iA = a(this.f, iA, iArr, iMin2);
            } else {
                iB = b(this.f, iB, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iA);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i20 - iB));
        iMax = Math.max(iA, currentContentInsetLeft2);
        iMin = Math.min(iB, i20 - currentContentInsetRight2);
        if (a(this.b)) {
            if (z3) {
                iMin = b(this.b, iMin, iArr, iMin2);
            } else {
                iMax = a(this.b, iMax, iArr, iMin2);
            }
        }
        if (a(this.j)) {
            if (z3) {
                iMin = b(this.j, iMin, iArr, iMin2);
            } else {
                iMax = a(this.j, iMax, iArr, iMin2);
            }
        }
        zA = a(this.g);
        zA2 = a(this.h);
        if (zA) {
            b bVar9 = (b) this.g.getLayoutParams();
            measuredHeight = bVar9.topMargin + this.g.getMeasuredHeight() + bVar9.bottomMargin + 0;
        } else {
            measuredHeight = 0;
        }
        if (zA2) {
            b bVar10 = (b) this.h.getLayoutParams();
            measuredHeight += bVar10.topMargin + this.h.getMeasuredHeight() + bVar10.bottomMargin;
        }
        if (zA) {
            if (zA) {
                textView = this.g;
            } else {
                textView = this.h;
            }
            if (zA2) {
                textView2 = this.h;
            } else {
                textView2 = this.g;
            }
            bVar = (b) textView.getLayoutParams();
            bVar2 = (b) textView2.getLayoutParams();
            if (zA) {
            }
            i5 = this.y & 112;
            i6 = iMin2;
            if (i5 == 48) {
                paddingTop = getPaddingTop() + bVar.topMargin + this.t;
            } else if (i5 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                if (iMax2 < bVar.topMargin + this.t) {
                    iMax2 = bVar.topMargin + this.t;
                } else {
                    i14 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    if (i14 < bVar.bottomMargin + this.u) {
                        iMax2 = Math.max(0, iMax2 - ((bVar2.bottomMargin + this.u) - i14));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - bVar2.bottomMargin) - this.u) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i11 = this.r;
                    c2 = 1;
                } else {
                    c2 = 1;
                    i11 = 0;
                }
                int i27 = i11 - iArr[c2];
                iMin -= Math.max(0, i27);
                iArr[c2] = Math.max(0, -i27);
                if (zA) {
                    b bVar11 = (b) this.g.getLayoutParams();
                    int measuredWidth4 = iMin - this.g.getMeasuredWidth();
                    int measuredHeight4 = this.g.getMeasuredHeight() + paddingTop;
                    this.g.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i12 = measuredWidth4 - this.s;
                    paddingTop = measuredHeight4 + bVar11.bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zA2) {
                    b bVar12 = (b) this.h.getLayoutParams();
                    int i28 = paddingTop + bVar12.topMargin;
                    this.h.layout(iMin - this.h.getMeasuredWidth(), i28, iMin, this.h.getMeasuredHeight() + i28);
                    i13 = iMin - this.s;
                    int i29 = bVar12.bottomMargin;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
                i7 = 0;
            } else {
                if (z2) {
                    i8 = this.r;
                    i7 = 0;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i210 = i8 - iArr[i7];
                iMax += Math.max(i7, i210);
                iArr[i7] = Math.max(i7, -i210);
                if (zA) {
                    b bVar13 = (b) this.g.getLayoutParams();
                    int measuredWidth5 = this.g.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.g.getMeasuredHeight() + paddingTop;
                    this.g.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i9 = measuredWidth5 + this.s;
                    paddingTop = measuredHeight5 + bVar13.bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zA2) {
                    b bVar14 = (b) this.h.getLayoutParams();
                    int i211 = paddingTop + bVar14.topMargin;
                    int measuredWidth6 = this.h.getMeasuredWidth() + iMax;
                    this.h.layout(iMax, i211, measuredWidth6, this.h.getMeasuredHeight() + i211);
                    i10 = measuredWidth6 + this.s;
                    int i212 = bVar14.bottomMargin;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        } else {
            if (zA) {
                textView = this.g;
            } else {
                textView = this.h;
            }
            if (zA2) {
                textView2 = this.h;
            } else {
                textView2 = this.g;
            }
            bVar = (b) textView.getLayoutParams();
            bVar2 = (b) textView2.getLayoutParams();
            if (zA) {
            }
            i5 = this.y & 112;
            i6 = iMin2;
            if (i5 == 48) {
                paddingTop = getPaddingTop() + bVar.topMargin + this.t;
            } else if (i5 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                if (iMax2 < bVar.topMargin + this.t) {
                    iMax2 = bVar.topMargin + this.t;
                } else {
                    i14 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    if (i14 < bVar.bottomMargin + this.u) {
                        iMax2 = Math.max(0, iMax2 - ((bVar2.bottomMargin + this.u) - i14));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - bVar2.bottomMargin) - this.u) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i11 = this.r;
                    c2 = 1;
                } else {
                    c2 = 1;
                    i11 = 0;
                }
                int i213 = i11 - iArr[c2];
                iMin -= Math.max(0, i213);
                iArr[c2] = Math.max(0, -i213);
                if (zA) {
                    b bVar15 = (b) this.g.getLayoutParams();
                    int measuredWidth7 = iMin - this.g.getMeasuredWidth();
                    int measuredHeight6 = this.g.getMeasuredHeight() + paddingTop;
                    this.g.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i12 = measuredWidth7 - this.s;
                    paddingTop = measuredHeight6 + bVar15.bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zA2) {
                    b bVar16 = (b) this.h.getLayoutParams();
                    int i214 = paddingTop + bVar16.topMargin;
                    this.h.layout(iMin - this.h.getMeasuredWidth(), i214, iMin, this.h.getMeasuredHeight() + i214);
                    i13 = iMin - this.s;
                    int i215 = bVar16.bottomMargin;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
                i7 = 0;
            } else {
                if (z2) {
                    i8 = this.r;
                    i7 = 0;
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int i216 = i8 - iArr[i7];
                iMax += Math.max(i7, i216);
                iArr[i7] = Math.max(i7, -i216);
                if (zA) {
                    b bVar17 = (b) this.g.getLayoutParams();
                    int measuredWidth8 = this.g.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.g.getMeasuredHeight() + paddingTop;
                    this.g.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i9 = measuredWidth8 + this.s;
                    paddingTop = measuredHeight7 + bVar17.bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zA2) {
                    b bVar18 = (b) this.h.getLayoutParams();
                    int i217 = paddingTop + bVar18.topMargin;
                    int measuredWidth9 = this.h.getMeasuredWidth() + iMax;
                    this.h.layout(iMax, i217, measuredWidth9, this.h.getMeasuredHeight() + i217);
                    i10 = measuredWidth9 + this.s;
                    int i218 = bVar18.bottomMargin;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        }
        a(this.F, 3);
        size = this.F.size();
        iA2 = iMax;
        while (i15 < size) {
            iA2 = a(this.F.get(i15), iA2, iArr, i6);
        }
        i16 = i6;
        a(this.F, 5);
        size2 = this.F.size();
        while (i17 < size2) {
            iMin = b(this.F.get(i17), iMin, iArr, i16);
        }
        a(this.F, 1);
        int iA5 = a(this.F, iArr);
        i18 = (paddingLeft + (((width - paddingLeft) - paddingRight) / 2)) - (iA5 / 2);
        i19 = iA5 + i18;
        if (i18 >= iA2) {
            if (i19 > iMin) {
                iA2 = i18 - (i19 - iMin);
            } else {
                iA2 = i18;
            }
        }
        size3 = this.F.size();
        while (i7 < size3) {
            iA2 = a(this.F.get(i7), iA2, iArr, i16);
            i7++;
        }
        this.F.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.H;
        if (bg.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (a(this.i)) {
            a(this.i, i, 0, i2, 0, this.q);
            measuredWidth = this.i.getMeasuredWidth() + b(this.i);
            iMax = Math.max(0, this.i.getMeasuredHeight() + c(this.i));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.i.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (a(this.f188a)) {
            a(this.f188a, i, 0, i2, 0, this.q);
            measuredWidth = this.f188a.getMeasuredWidth() + b(this.f188a);
            iMax = Math.max(iMax, this.f188a.getMeasuredHeight() + c(this.f188a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f188a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[c3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (a(this.f)) {
            a(this.f, i, iMax3, i2, 0, this.q);
            measuredWidth2 = this.f.getMeasuredWidth() + b(this.f);
            iMax = Math.max(iMax, this.f.getMeasuredHeight() + c(this.f));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (a(this.b)) {
            iMax4 += a(this.b, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.b.getMeasuredHeight() + c(this.b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
        }
        if (a(this.j)) {
            iMax4 += a(this.j, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.j.getMeasuredHeight() + c(this.j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.j.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iA = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).e == 0 && a(childAt)) {
                iA += a(childAt, i, iA, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + c(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.t + this.u;
        int i5 = this.r + this.s;
        if (a(this.g)) {
            a(this.g, i, iA + i5, i2, i4, iArr);
            int measuredWidth3 = this.g.getMeasuredWidth() + b(this.g);
            measuredHeight = this.g.getMeasuredHeight() + c(this.g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.g.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (a(this.h)) {
            iMax2 = Math.max(iMax2, a(this.h, i, iA + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.h.getMeasuredHeight() + c(this.h);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.h.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iA + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (s()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        androidx.appcompat.view.menu.g gVarD = this.f != null ? this.f.d() : null;
        if (dVar.f193a != 0 && this.L != null && gVarD != null && (menuItemFindItem = gVarD.findItem(dVar.f193a)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (dVar.b) {
            r();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        t();
        this.v.a(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        if (this.L != null && this.L.b != null) {
            dVar.f193a = this.L.b.getItemId();
        }
        dVar.b = b();
        return dVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    public void setCollapseContentDescription(@androidx.annotation.as int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(@androidx.annotation.ai CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            j();
        }
        if (this.f188a != null) {
            this.f188a.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@androidx.annotation.q int i) {
        setCollapseIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setCollapseIcon(@androidx.annotation.ai Drawable drawable) {
        if (drawable != null) {
            j();
            this.f188a.setImageDrawable(drawable);
        } else if (this.f188a != null) {
            this.f188a.setImageDrawable(this.k);
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z) {
        this.O = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.x) {
            this.x = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@androidx.annotation.q int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            n();
            if (!d(this.j)) {
                a((View) this.j, true);
            }
        } else if (this.j != null && d(this.j)) {
            removeView(this.j);
            this.G.remove(this.j);
        }
        if (this.j != null) {
            this.j.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(@androidx.annotation.as int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            n();
        }
        if (this.j != null) {
            this.j.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@androidx.annotation.as int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(@androidx.annotation.ai CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            q();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@androidx.annotation.q int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(@androidx.annotation.ai Drawable drawable) {
        if (drawable != null) {
            q();
            if (!d(this.i)) {
                a((View) this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.G.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        q();
        this.i.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void setOverflowIcon(@androidx.annotation.ai Drawable drawable) {
        o();
        this.f.setOverflowIcon(drawable);
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

    public void setSubtitle(@androidx.annotation.as int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.h == null) {
                Context context = getContext();
                this.h = new aa(context);
                this.h.setSingleLine();
                this.h.setEllipsize(TextUtils.TruncateAt.END);
                if (this.p != 0) {
                    this.h.setTextAppearance(context, this.p);
                }
                if (this.C != null) {
                    this.h.setTextColor(this.C);
                }
            }
            if (!d(this.h)) {
                a((View) this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.G.remove(this.h);
        }
        if (this.h != null) {
            this.h.setText(charSequence);
        }
        this.A = charSequence;
    }

    public void setSubtitleTextColor(@androidx.annotation.k int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(@androidx.annotation.ah ColorStateList colorStateList) {
        this.C = colorStateList;
        if (this.h != null) {
            this.h.setTextColor(colorStateList);
        }
    }

    public void setTitle(@androidx.annotation.as int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new aa(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != null) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a((View) this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.G.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.u = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleTextColor(@androidx.annotation.k int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(@androidx.annotation.ah ColorStateList colorStateList) {
        this.B = colorStateList;
        if (this.g != null) {
            this.g.setTextColor(colorStateList);
        }
    }
}
