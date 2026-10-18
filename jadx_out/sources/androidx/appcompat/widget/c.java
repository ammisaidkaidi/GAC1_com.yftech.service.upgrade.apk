package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.b implements androidx.core.n.b.a {
    private static final String m = "ActionMenuPresenter";
    private b A;
    d g;
    e h;
    a i;
    RunnableC0018c j;
    final f k;
    int l;
    private Drawable n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private final SparseBooleanArray z;

    private class a extends androidx.appcompat.view.menu.m {
        public a(Context context, androidx.appcompat.view.menu.s sVar, View view) {
            super(context, sVar, view, false, androidx.appcompat.a.b.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.j) sVar.getItem()).k()) {
                a(c.this.g == null ? (View) c.this.f : c.this.g);
            }
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.m
        protected void f() {
            c.this.i = null;
            c.this.l = 0;
            super.f();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.q a() {
            if (c.this.i != null) {
                return c.this.i.d();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0018c implements Runnable {
        private e b;

        public RunnableC0018c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c != null) {
                c.this.c.h();
            }
            View view = (View) c.this.f;
            if (view != null && view.getWindowToken() != null && this.b.e()) {
                c.this.h = this.b;
            }
            c.this.j = null;
        }
    }

    private class d extends p implements ActionMenuView.a {
        public d(Context context) {
            super(context, null, androidx.appcompat.a.b.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            bc.a(this, getContentDescription());
            setOnTouchListener(new ai(this) { // from class: androidx.appcompat.widget.c.d.1
                @Override // androidx.appcompat.widget.ai
                public androidx.appcompat.view.menu.q a() {
                    if (c.this.h == null) {
                        return null;
                    }
                    return c.this.h.d();
                }

                @Override // androidx.appcompat.widget.ai
                public boolean b() {
                    c.this.e();
                    return true;
                }

                @Override // androidx.appcompat.widget.ai
                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.g();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean e() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.e();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.m {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, androidx.appcompat.a.b.actionOverflowMenuStyle);
            a(androidx.core.n.h.c);
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.m
        protected void f() {
            if (c.this.c != null) {
                c.this.c.close();
            }
            c.this.h = null;
            super.f();
        }
    }

    private class f implements androidx.appcompat.view.menu.n.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.s) {
                gVar.r().b(false);
            }
            androidx.appcompat.view.menu.n.a aVarA = c.this.a();
            if (aVarA != null) {
                aVarA.a(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean a(@androidx.annotation.ah androidx.appcompat.view.menu.g gVar) {
            if (gVar == c.this.c) {
                return false;
            }
            c.this.l = ((androidx.appcompat.view.menu.s) gVar).getItem().getItemId();
            androidx.appcompat.view.menu.n.a aVarA = c.this.a();
            if (aVarA != null) {
                return aVarA.a(gVar);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: androidx.appcompat.widget.c.g.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f261a;

        g() {
        }

        g(Parcel parcel) {
            this.f261a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f261a);
        }
    }

    public c(Context context) {
        super(context, androidx.appcompat.a.j.abc_action_menu_layout, androidx.appcompat.a.j.abc_action_menu_item_layout);
        this.z = new SparseBooleanArray();
        this.k = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof androidx.appcompat.view.menu.o.a) && ((androidx.appcompat.view.menu.o.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public androidx.appcompat.view.menu.o a(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.o oVar = this.f;
        androidx.appcompat.view.menu.o oVarA = super.a(viewGroup);
        if (oVar != oVarA) {
            ((ActionMenuView) oVarA).setPresenter(this);
        }
        return oVarA;
    }

    public void a(int i, boolean z) {
        this.r = i;
        this.v = z;
        this.w = true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void a(@androidx.annotation.ah Context context, @androidx.annotation.ai androidx.appcompat.view.menu.g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(context);
        if (!this.q) {
            this.p = aVarA.b();
        }
        if (!this.w) {
            this.r = aVarA.c();
        }
        if (!this.u) {
            this.t = aVarA.a();
        }
        int measuredWidth = this.r;
        if (this.p) {
            if (this.g == null) {
                this.g = new d(this.f125a);
                if (this.o) {
                    this.g.setImageDrawable(this.n);
                    this.n = null;
                    this.o = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.s = measuredWidth;
        this.y = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void a(Configuration configuration) {
        if (!this.u) {
            this.t = androidx.appcompat.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.c(true);
        }
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
        } else {
            this.o = true;
            this.n = drawable;
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (parcelable instanceof g) {
            g gVar = (g) parcelable;
            if (gVar.f261a <= 0 || (menuItemFindItem = this.c.findItem(gVar.f261a)) == null) {
                return;
            }
            a((androidx.appcompat.view.menu.s) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        h();
        super.a(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.j jVar, androidx.appcompat.view.menu.o.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public void a(boolean z) {
        super.a(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<androidx.appcompat.view.menu.j> arrayListM = this.c.m();
            int size = arrayListM.size();
            for (int i = 0; i < size; i++) {
                androidx.core.n.b bVarB = arrayListM.get(i).b();
                if (bVarB != null) {
                    bVarB.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.j> arrayListN = this.c != null ? this.c.n() : null;
        if (this.p && arrayListN != null) {
            int size2 = arrayListN.size();
            if (size2 == 1) {
                z2 = !arrayListN.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.f125a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.p);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.j jVar) {
        return jVar.k();
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public boolean a(androidx.appcompat.view.menu.s sVar) {
        boolean z = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.s sVar2 = sVar;
        while (sVar2.u() != this.c) {
            sVar2 = (androidx.appcompat.view.menu.s) sVar2.u();
        }
        View viewA = a(sVar2.getItem());
        if (viewA == null) {
            return false;
        }
        this.l = sVar.getItem().getItemId();
        int size = sVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = sVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        this.i = new a(this.b, sVar, viewA);
        this.i.a(z);
        this.i.c();
        super.a(sVar);
        return true;
    }

    public void b(int i) {
        this.t = i;
        this.u = true;
    }

    public void b(boolean z) {
        this.p = z;
        this.q = true;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:76:0x0102  */
    /* JADX WARN: Code duplicated, block: B:78:0x0106  */
    /* JADX WARN: Code duplicated, block: B:79:0x0108  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.c] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.j] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.n
    public boolean b() {
        ArrayList<androidx.appcompat.view.menu.j> arrayListK;
        int size;
        int iA;
        int i;
        ?? r0;
        int i2;
        boolean z;
        int measuredWidth;
        boolean z2;
        boolean z3;
        boolean z4;
        c cVar = this;
        View view = null;
        ?? r3 = 0;
        if (cVar.c != null) {
            arrayListK = cVar.c.k();
            size = arrayListK.size();
        } else {
            arrayListK = null;
            size = 0;
        }
        int i3 = cVar.t;
        int i4 = cVar.s;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f;
        int i5 = 0;
        boolean z5 = false;
        int i6 = 0;
        int i7 = i3;
        for (int i8 = 0; i8 < size; i8++) {
            androidx.appcompat.view.menu.j jVar = arrayListK.get(i8);
            if (jVar.requiresActionButton()) {
                i5++;
            } else if (jVar.l()) {
                i6++;
            } else {
                z5 = true;
            }
            if (cVar.x && jVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (cVar.p && (z5 || i6 + i5 > i7)) {
            i7--;
        }
        int i9 = i7 - i5;
        SparseBooleanArray sparseBooleanArray = cVar.z;
        sparseBooleanArray.clear();
        if (cVar.v) {
            iA = i4 / cVar.y;
            i = ((i4 % cVar.y) / iA) + cVar.y;
        } else {
            iA = 0;
            i = 0;
        }
        int i10 = 0;
        int i11 = i4;
        int i12 = 0;
        ?? r1 = cVar;
        while (i12 < size) {
            androidx.appcompat.view.menu.j jVar2 = arrayListK.get(i12);
            if (jVar2.requiresActionButton()) {
                View viewA = r1.a(jVar2, view, viewGroup);
                if (r1.v) {
                    iA -= ActionMenuView.a(viewA, i, iA, iMakeMeasureSpec, (int) r3);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth2 = viewA.getMeasuredWidth();
                i11 -= measuredWidth2;
                if (i10 != 0) {
                    measuredWidth2 = i10;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z4 = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z4 = true;
                }
                jVar2.d(z4);
                i10 = measuredWidth2;
                r0 = r3;
                i2 = size;
            } else if (jVar2.l()) {
                int groupId2 = jVar2.getGroupId();
                boolean z6 = sparseBooleanArray.get(groupId2);
                boolean z7 = (i9 > 0 || z6) && i11 > 0 && (!r1.v || iA > 0);
                if (z7) {
                    boolean z8 = z7;
                    i2 = size;
                    View viewA2 = r1.a(jVar2, null, viewGroup);
                    if (r1.v) {
                        int iA2 = ActionMenuView.a(viewA2, i, iA, iMakeMeasureSpec, 0);
                        iA -= iA2;
                        if (iA2 == 0) {
                            z = false;
                        }
                        measuredWidth = viewA2.getMeasuredWidth();
                        i11 -= measuredWidth;
                        if (i10 == 0) {
                            i10 = measuredWidth;
                        }
                        if (r1.v) {
                            if (i11 >= 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            z7 = z & z3;
                        } else {
                            if (i11 + i10 > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z7 = z & z2;
                        }
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    z = z8;
                    measuredWidth = viewA2.getMeasuredWidth();
                    i11 -= measuredWidth;
                    if (i10 == 0) {
                        i10 = measuredWidth;
                    }
                    if (r1.v) {
                        if (i11 >= 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z7 = z & z3;
                    } else {
                        if (i11 + i10 > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z7 = z & z2;
                    }
                } else {
                    i2 = size;
                }
                if (z7 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z6) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i13 = 0; i13 < i12; i13++) {
                        androidx.appcompat.view.menu.j jVar3 = arrayListK.get(i13);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.k()) {
                                i9++;
                            }
                            jVar3.d(false);
                        }
                    }
                }
                if (z7) {
                    i9--;
                }
                jVar2.d(z7);
                r0 = 0;
            } else {
                r0 = r3;
                i2 = size;
                jVar2.d(r0);
            }
            i12++;
            r3 = r0;
            size = i2;
            r1 = this;
            view = null;
        }
        return true;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public Drawable d() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.o) {
            return this.n;
        }
        return null;
    }

    @Override // androidx.core.n.b.a
    public void d(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.s) null);
        } else if (this.c != null) {
            this.c.b(false);
        }
    }

    public boolean e() {
        if (!this.p || j() || this.c == null || this.f == null || this.j != null || this.c.n().isEmpty()) {
            return false;
        }
        this.j = new RunnableC0018c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        return true;
    }

    @Override // androidx.appcompat.view.menu.n
    public Parcelable f() {
        g gVar = new g();
        gVar.f261a = this.l;
        return gVar;
    }

    public boolean g() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar == null) {
            return false;
        }
        eVar.a();
        return true;
    }

    public boolean h() {
        return i() | g();
    }

    public boolean i() {
        if (this.i == null) {
            return false;
        }
        this.i.a();
        return true;
    }

    public boolean j() {
        return this.h != null && this.h.g();
    }

    public boolean k() {
        return this.j != null || j();
    }

    public boolean l() {
        return this.p;
    }
}
