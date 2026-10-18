package com.google.android.material.c;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.at;
import androidx.annotation.ax;
import androidx.annotation.p;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.core.m.h;
import androidx.core.n.af;
import androidx.j.aj;
import androidx.j.al;
import com.google.android.material.internal.r;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class c extends ViewGroup implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f1220a = 115;
    private static final int b = 5;
    private static final int[] c = {R.attr.state_checked};
    private static final int[] d = {-16842910};

    @ah
    private SparseArray<com.google.android.material.b.a> A;
    private d B;
    private g C;

    @ah
    private final al e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    @ah
    private final View.OnClickListener k;
    private final h.a<a> l;
    private boolean m;
    private int n;

    @ai
    private a[] o;
    private int p;
    private int q;
    private ColorStateList r;

    @p
    private int s;
    private ColorStateList t;

    @ai
    private final ColorStateList u;

    @at
    private int v;

    @at
    private int w;
    private Drawable x;
    private int y;
    private int[] z;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new h.c(5);
        this.p = 0;
        this.q = 0;
        this.A = new SparseArray<>(5);
        Resources resources = getResources();
        this.f = resources.getDimensionPixelSize(com.google.android.material.a.f.design_bottom_navigation_item_max_width);
        this.g = resources.getDimensionPixelSize(com.google.android.material.a.f.design_bottom_navigation_item_min_width);
        this.h = resources.getDimensionPixelSize(com.google.android.material.a.f.design_bottom_navigation_active_item_max_width);
        this.i = resources.getDimensionPixelSize(com.google.android.material.a.f.design_bottom_navigation_active_item_min_width);
        this.j = resources.getDimensionPixelSize(com.google.android.material.a.f.design_bottom_navigation_height);
        this.u = a(R.attr.textColorSecondary);
        this.e = new androidx.j.c();
        this.e.a(0);
        this.e.a(f1220a);
        this.e.a(new androidx.h.a.a.b());
        this.e.a(new r());
        this.k = new View.OnClickListener() { // from class: com.google.android.material.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j itemData = ((a) view).getItemData();
                if (c.this.C.a(itemData, c.this.B, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.z = new int[5];
        af.e((View) this, 1);
    }

    private boolean a(int i, int i2) {
        if (i == -1) {
            if (i2 <= 3) {
                return false;
            }
        } else if (i != 0) {
            return false;
        }
        return true;
    }

    private void d() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.C.size(); i++) {
            hashSet.add(Integer.valueOf(this.C.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            int iKeyAt = this.A.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.A.delete(iKeyAt);
            }
        }
    }

    private boolean g(int i) {
        return i != -1;
    }

    private a getNewItem() {
        a aVarA = this.l.a();
        return aVarA == null ? new a(getContext()) : aVarA;
    }

    private void h(int i) {
        if (g(i)) {
            return;
        }
        throw new IllegalArgumentException(i + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@ah a aVar) {
        com.google.android.material.b.a aVar2;
        int id = aVar.getId();
        if (g(id) && (aVar2 = this.A.get(id)) != null) {
            aVar.setBadge(aVar2);
        }
    }

    @ai
    public ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.a.b.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        return new ColorStateList(new int[][]{d, c, EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(d, defaultColor), i2, defaultColor});
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(g gVar) {
        this.C = gVar;
    }

    public boolean a() {
        return this.m;
    }

    public void b() {
        removeAllViews();
        if (this.o != null) {
            for (a aVar : this.o) {
                if (aVar != null) {
                    this.l.a(aVar);
                    aVar.b();
                }
            }
        }
        if (this.C.size() == 0) {
            this.p = 0;
            this.q = 0;
            this.o = null;
            return;
        }
        d();
        this.o = new a[this.C.size()];
        boolean zA = a(this.n, this.C.k().size());
        for (int i = 0; i < this.C.size(); i++) {
            this.B.b(true);
            this.C.getItem(i).setCheckable(true);
            this.B.b(false);
            a newItem = getNewItem();
            this.o[i] = newItem;
            newItem.setIconTintList(this.r);
            newItem.setIconSize(this.s);
            newItem.setTextColor(this.u);
            newItem.setTextAppearanceInactive(this.v);
            newItem.setTextAppearanceActive(this.w);
            newItem.setTextColor(this.t);
            if (this.x != null) {
                newItem.setItemBackground(this.x);
            } else {
                newItem.setItemBackground(this.y);
            }
            newItem.setShifting(zA);
            newItem.setLabelVisibilityMode(this.n);
            newItem.a((j) this.C.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.k);
            if (this.p != 0 && this.C.getItem(i).getItemId() == this.p) {
                this.q = i;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        this.q = Math.min(this.C.size() - 1, this.q);
        this.C.getItem(this.q).setChecked(true);
    }

    void b(int i) {
        int size = this.C.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.C.getItem(i2);
            if (i == item.getItemId()) {
                this.p = i;
                this.q = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    @ai
    com.google.android.material.b.a c(int i) {
        return this.A.get(i);
    }

    public void c() {
        if (this.C == null || this.o == null) {
            return;
        }
        int size = this.C.size();
        if (size != this.o.length) {
            b();
            return;
        }
        int i = this.p;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.C.getItem(i2);
            if (item.isChecked()) {
                this.p = item.getItemId();
                this.q = i2;
            }
        }
        if (i != this.p) {
            aj.a(this, this.e);
        }
        boolean zA = a(this.n, this.C.k().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.B.b(true);
            this.o[i3].setLabelVisibilityMode(this.n);
            this.o[i3].setShifting(zA);
            this.o[i3].a((j) this.C.getItem(i3), 0);
            this.B.b(false);
        }
    }

    com.google.android.material.b.a d(int i) {
        h(i);
        com.google.android.material.b.a aVarA = this.A.get(i);
        if (aVarA == null) {
            aVarA = com.google.android.material.b.a.a(getContext());
            this.A.put(i, aVarA);
        }
        a aVarF = f(i);
        if (aVarF != null) {
            aVarF.setBadge(aVarA);
        }
        return aVarA;
    }

    void e(int i) {
        h(i);
        com.google.android.material.b.a aVar = this.A.get(i);
        a aVarF = f(i);
        if (aVarF != null) {
            aVarF.b();
        }
        if (aVar != null) {
            this.A.remove(i);
        }
    }

    @ai
    @ax
    a f(int i) {
        h(i);
        if (this.o == null) {
            return null;
        }
        for (a aVar : this.o) {
            if (aVar.getId() == i) {
                return aVar;
            }
        }
        return null;
    }

    SparseArray<com.google.android.material.b.a> getBadgeDrawables() {
        return this.A;
    }

    @ai
    public ColorStateList getIconTintList() {
        return this.r;
    }

    @ai
    public Drawable getItemBackground() {
        return (this.o == null || this.o.length <= 0) ? this.x : this.o[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.y;
    }

    @p
    public int getItemIconSize() {
        return this.s;
    }

    @at
    public int getItemTextAppearanceActive() {
        return this.w;
    }

    @at
    public int getItemTextAppearanceInactive() {
        return this.v;
    }

    public ColorStateList getItemTextColor() {
        return this.t;
    }

    public int getLabelVisibilityMode() {
        return this.n;
    }

    public int getSelectedItemId() {
        return this.p;
    }

    @Override // androidx.appcompat.view.menu.o
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.n.a.d.a(accessibilityNodeInfo).b(androidx.core.n.a.d.b.a(1, this.C.k().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                if (af.p(this) == 1) {
                    int i8 = i5 - measuredWidth;
                    childAt.layout(i8 - childAt.getMeasuredWidth(), 0, i8, i6);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i6);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.C.k().size();
        int childCount = getChildCount();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.j, androidx.d.c.b.a.b.b);
        if (a(this.n, size2) && this.m) {
            View childAt = getChildAt(this.q);
            int iMax = this.i;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.h, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i3 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.g * i3), Math.min(iMax, this.h));
            int i4 = size - iMin;
            int iMin2 = Math.min(i4 / (i3 == 0 ? 1 : i3), this.f);
            int i5 = i4 - (i3 * iMin2);
            int i6 = 0;
            while (i6 < childCount) {
                if (getChildAt(i6).getVisibility() != 8) {
                    this.z[i6] = i6 == this.q ? iMin : iMin2;
                    if (i5 > 0) {
                        int[] iArr = this.z;
                        iArr[i6] = iArr[i6] + 1;
                        i5--;
                    }
                } else {
                    this.z[i6] = 0;
                }
                i6++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 == 0 ? 1 : size2), this.h);
            int i7 = size - (size2 * iMin3);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.z[i8] = iMin3;
                    if (i7 > 0) {
                        int[] iArr2 = this.z;
                        iArr2[i8] = iArr2[i8] + 1;
                        i7--;
                    }
                } else {
                    this.z[i8] = 0;
                }
            }
        }
        int measuredWidth = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.z[i9], androidx.d.c.b.a.b.b), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(measuredWidth, View.MeasureSpec.makeMeasureSpec(measuredWidth, androidx.d.c.b.a.b.b), 0), View.resolveSizeAndState(this.j, iMakeMeasureSpec, 0));
    }

    void setBadgeDrawables(SparseArray<com.google.android.material.b.a> sparseArray) {
        this.A = sparseArray;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setBadge(sparseArray.get(aVar.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@ai Drawable drawable) {
        this.x = drawable;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.y = i;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setItemBackground(i);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.m = z;
    }

    public void setItemIconSize(@p int i) {
        this.s = i;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setIconSize(i);
            }
        }
    }

    public void setItemTextAppearanceActive(@at int i) {
        this.w = i;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setTextAppearanceActive(i);
                if (this.t != null) {
                    aVar.setTextColor(this.t);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@at int i) {
        this.v = i;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setTextAppearanceInactive(i);
                if (this.t != null) {
                    aVar.setTextColor(this.t);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.t = colorStateList;
        if (this.o != null) {
            for (a aVar : this.o) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.n = i;
    }

    public void setPresenter(d dVar) {
        this.B = dVar;
    }
}
