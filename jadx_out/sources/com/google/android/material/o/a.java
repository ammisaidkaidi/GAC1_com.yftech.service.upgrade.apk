package com.google.android.material.o;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.ac;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.at;
import androidx.annotation.p;
import androidx.annotation.q;
import androidx.annotation.w;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ba;
import androidx.core.n.af;
import androidx.core.n.ao;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import com.google.android.material.internal.n;
import com.google.android.material.internal.s;
import com.google.android.material.q.c;
import com.google.android.material.t.j;
import com.google.android.material.t.k;
import com.google.android.material.t.o;

/* JADX INFO: loaded from: classes.dex */
public class a extends n {
    private static final int[] d = {R.attr.state_checked};
    private static final int[] e = {-16842910};
    private static final int f = com.google.android.material.a.n.Widget_Design_NavigationView;
    private static final int g = 1;
    InterfaceC0091a c;

    @ah
    private final h h;
    private final i i;
    private final int j;
    private final int[] k;
    private MenuInflater l;
    private ViewTreeObserver.OnGlobalLayoutListener m;

    /* JADX INFO: renamed from: com.google.android.material.o.a$a, reason: collision with other inner class name */
    public interface InterfaceC0091a {
        boolean a(@ah MenuItem menuItem);
    }

    public static class b extends androidx.f.a.a {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.google.android.material.o.a.b.1
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
        @ai
        public Bundle f1367a;

        public b(@ah Parcel parcel, @ai ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1367a = parcel.readBundle(classLoader);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.f.a.a, android.os.Parcelable
        public void writeToParcel(@ah Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f1367a);
        }
    }

    public a(@ah Context context) {
        this(context, null);
    }

    public a(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.navigationViewStyle);
    }

    public a(@ah Context context, @ai AttributeSet attributeSet, int i) {
        boolean z;
        int iG;
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, f), attributeSet, i);
        this.i = new i();
        this.k = new int[2];
        Context context2 = getContext();
        this.h = new h(context2);
        ba baVarB = s.b(context2, attributeSet, com.google.android.material.a.o.NavigationView, i, f, new int[0]);
        if (baVarB.j(com.google.android.material.a.o.NavigationView_android_background)) {
            af.a(this, baVarB.a(com.google.android.material.a.o.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            j jVar = new j();
            if (background instanceof ColorDrawable) {
                jVar.g(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            jVar.b(context2);
            af.a(this, jVar);
        }
        if (baVarB.j(com.google.android.material.a.o.NavigationView_elevation)) {
            setElevation(baVarB.e(com.google.android.material.a.o.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(baVarB.a(com.google.android.material.a.o.NavigationView_android_fitsSystemWindows, false));
        this.j = baVarB.e(com.google.android.material.a.o.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateListG = baVarB.j(com.google.android.material.a.o.NavigationView_itemIconTint) ? baVarB.g(com.google.android.material.a.o.NavigationView_itemIconTint) : d(R.attr.textColorSecondary);
        if (baVarB.j(com.google.android.material.a.o.NavigationView_itemTextAppearance)) {
            iG = baVarB.g(com.google.android.material.a.o.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            iG = 0;
        }
        if (baVarB.j(com.google.android.material.a.o.NavigationView_itemIconSize)) {
            setItemIconSize(baVarB.e(com.google.android.material.a.o.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListG2 = baVarB.j(com.google.android.material.a.o.NavigationView_itemTextColor) ? baVarB.g(com.google.android.material.a.o.NavigationView_itemTextColor) : null;
        if (!z && colorStateListG2 == null) {
            colorStateListG2 = d(R.attr.textColorPrimary);
        }
        Drawable drawableA = baVarB.a(com.google.android.material.a.o.NavigationView_itemBackground);
        if (drawableA == null && a(baVarB)) {
            drawableA = b(baVarB);
        }
        if (baVarB.j(com.google.android.material.a.o.NavigationView_itemHorizontalPadding)) {
            this.i.e(baVarB.e(com.google.android.material.a.o.NavigationView_itemHorizontalPadding, 0));
        }
        int iE = baVarB.e(com.google.android.material.a.o.NavigationView_itemIconPadding, 0);
        setItemMaxLines(baVarB.a(com.google.android.material.a.o.NavigationView_itemMaxLines, 1));
        this.h.a(new g.a() { // from class: com.google.android.material.o.a.1
            @Override // androidx.appcompat.view.menu.g.a
            public void a(g gVar) {
            }

            @Override // androidx.appcompat.view.menu.g.a
            public boolean a(g gVar, MenuItem menuItem) {
                return a.this.c != null && a.this.c.a(menuItem);
            }
        });
        this.i.a(1);
        this.i.a(context2, this.h);
        this.i.a(colorStateListG);
        this.i.i(getOverScrollMode());
        if (z) {
            this.i.d(iG);
        }
        this.i.b(colorStateListG2);
        this.i.a(drawableA);
        this.i.f(iE);
        this.h.a(this.i);
        addView((View) this.i.a((ViewGroup) this));
        if (baVarB.j(com.google.android.material.a.o.NavigationView_menu)) {
            a(baVarB.g(com.google.android.material.a.o.NavigationView_menu, 0));
        }
        if (baVarB.j(com.google.android.material.a.o.NavigationView_headerLayout)) {
            b(baVarB.g(com.google.android.material.a.o.NavigationView_headerLayout, 0));
        }
        baVarB.f();
        a();
    }

    private void a() {
        this.m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.o.a.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                a.this.getLocationOnScreen(a.this.k);
                boolean z = a.this.k[1] == 0;
                a.this.i.c(z);
                a.this.setDrawTopInsetForeground(z);
                Activity activityA = com.google.android.material.internal.b.a(a.this.getContext());
                if (activityA == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                a.this.setDrawBottomInsetForeground((activityA.findViewById(R.id.content).getHeight() == a.this.getHeight()) && (Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0));
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
    }

    private boolean a(@ah ba baVar) {
        return baVar.j(com.google.android.material.a.o.NavigationView_itemShapeAppearance) || baVar.j(com.google.android.material.a.o.NavigationView_itemShapeAppearanceOverlay);
    }

    @ah
    private final Drawable b(@ah ba baVar) {
        j jVar = new j(o.a(getContext(), baVar.g(com.google.android.material.a.o.NavigationView_itemShapeAppearance, 0), baVar.g(com.google.android.material.a.o.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        jVar.g(c.a(getContext(), baVar, com.google.android.material.a.o.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) jVar, baVar.e(com.google.android.material.a.o.NavigationView_itemShapeInsetStart, 0), baVar.e(com.google.android.material.a.o.NavigationView_itemShapeInsetTop, 0), baVar.e(com.google.android.material.a.o.NavigationView_itemShapeInsetEnd, 0), baVar.e(com.google.android.material.a.o.NavigationView_itemShapeInsetBottom, 0));
    }

    @ai
    private ColorStateList d(int i) {
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
        return new ColorStateList(new int[][]{e, d, EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(e, defaultColor), i2, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.l == null) {
            this.l = new androidx.appcompat.view.g(getContext());
        }
        return this.l;
    }

    public void a(int i) {
        this.i.b(true);
        getMenuInflater().inflate(i, this.h);
        this.i.b(false);
        this.i.a(false);
    }

    public void a(@ah View view) {
        this.i.a(view);
    }

    @Override // com.google.android.material.internal.n
    @ap(a = {ap.a.LIBRARY_GROUP})
    protected void a(@ah ao aoVar) {
        this.i.a(aoVar);
    }

    public View b(@ac int i) {
        return this.i.b(i);
    }

    public void b(@ah View view) {
        this.i.b(view);
    }

    public View c(int i) {
        return this.i.c(i);
    }

    @ai
    public MenuItem getCheckedItem() {
        return this.i.a();
    }

    public int getHeaderCount() {
        return this.i.d();
    }

    @ai
    public Drawable getItemBackground() {
        return this.i.h();
    }

    @p
    public int getItemHorizontalPadding() {
        return this.i.i();
    }

    @p
    public int getItemIconPadding() {
        return this.i.j();
    }

    @ai
    public ColorStateList getItemIconTintList() {
        return this.i.e();
    }

    public int getItemMaxLines() {
        return this.i.k();
    }

    @ai
    public ColorStateList getItemTextColor() {
        return this.i.g();
    }

    @ah
    public Menu getMenu() {
        return this.h;
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.a(this);
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.m);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.j), androidx.d.c.b.a.b.b);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.j, androidx.d.c.b.a.b.b);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.a());
        this.h.b(bVar.f1367a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f1367a = new Bundle();
        this.h.a(bVar.f1367a);
        return bVar;
    }

    public void setCheckedItem(@w int i) {
        MenuItem menuItemFindItem = this.h.findItem(i);
        if (menuItemFindItem != null) {
            this.i.a((androidx.appcompat.view.menu.j) menuItemFindItem);
        }
    }

    public void setCheckedItem(@ah MenuItem menuItem) {
        MenuItem menuItemFindItem = this.h.findItem(menuItem.getItemId());
        if (menuItemFindItem == null) {
            throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        }
        this.i.a((androidx.appcompat.view.menu.j) menuItemFindItem);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        k.a(this, f2);
    }

    public void setItemBackground(@ai Drawable drawable) {
        this.i.a(drawable);
    }

    public void setItemBackgroundResource(@q int i) {
        setItemBackground(androidx.core.b.c.a(getContext(), i));
    }

    public void setItemHorizontalPadding(@p int i) {
        this.i.e(i);
    }

    public void setItemHorizontalPaddingResource(@androidx.annotation.o int i) {
        this.i.e(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(@p int i) {
        this.i.f(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.i.f(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(@p int i) {
        this.i.h(i);
    }

    public void setItemIconTintList(@ai ColorStateList colorStateList) {
        this.i.a(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.i.g(i);
    }

    public void setItemTextAppearance(@at int i) {
        this.i.d(i);
    }

    public void setItemTextColor(@ai ColorStateList colorStateList) {
        this.i.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(@ai InterfaceC0091a interfaceC0091a) {
        this.c = interfaceC0091a;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        if (this.i != null) {
            this.i.i(i);
        }
    }
}
