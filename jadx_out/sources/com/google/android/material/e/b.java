package com.google.android.material.e;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.annotation.at;
import androidx.annotation.k;
import androidx.annotation.p;
import androidx.annotation.r;
import androidx.core.n.af;
import com.google.android.material.q.c;
import com.google.android.material.t.e;
import com.google.android.material.t.f;
import com.google.android.material.t.j;
import com.google.android.material.t.n;
import com.google.android.material.t.o;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
class b {
    private static final int b = -1;
    private static final float d = 1.5f;
    private static final int e = 2;

    @ah
    private final a f;

    @ah
    private final j h;

    @ah
    private final j i;

    @p
    private final int j;

    @p
    private final int k;

    @p
    private int l;

    @ai
    private Drawable m;

    @ai
    private Drawable n;

    @ai
    private ColorStateList o;

    @ai
    private ColorStateList p;

    @ai
    private o q;

    @ai
    private ColorStateList r;

    @ai
    private Drawable s;

    @ai
    private LayerDrawable t;

    @ai
    private j u;

    @ai
    private j v;
    private boolean x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1280a = {R.attr.state_checked};
    private static final double c = Math.cos(Math.toRadians(45.0d));

    @ah
    private final Rect g = new Rect();
    private boolean w = false;

    public b(@ah a aVar, AttributeSet attributeSet, int i, @at int i2) {
        this.f = aVar;
        this.h = new j(aVar.getContext(), attributeSet, i, i2);
        this.h.b(aVar.getContext());
        this.h.O(-12303292);
        o.a aVarN = this.h.getShapeAppearanceModel().n();
        TypedArray typedArrayObtainStyledAttributes = aVar.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.a.o.CardView, i, com.google.android.material.a.n.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.a.o.CardView_cardCornerRadius)) {
            aVarN.a(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.a.o.CardView_cardCornerRadius, 0.0f));
        }
        this.i = new j();
        a(aVarN.a());
        Resources resources = aVar.getResources();
        this.j = resources.getDimensionPixelSize(com.google.android.material.a.f.mtrl_card_checked_icon_margin);
        this.k = resources.getDimensionPixelSize(com.google.android.material.a.f.mtrl_card_checked_icon_size);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean A() {
        return this.f.getPreventCornerOverlap() && x() && this.f.getUseCompatPadding();
    }

    private float B() {
        return Math.max(Math.max(a(this.q.b(), this.h.as()), a(this.q.c(), this.h.at())), Math.max(a(this.q.d(), this.h.av()), a(this.q.e(), this.h.au())));
    }

    @ah
    private Drawable C() {
        if (this.s == null) {
            this.s = D();
        }
        if (this.t == null) {
            this.t = new LayerDrawable(new Drawable[]{this.s, this.i, G()});
            this.t.setId(2, com.google.android.material.a.h.mtrl_card_checked_layer_id);
        }
        return this.t;
    }

    @ah
    private Drawable D() {
        if (!com.google.android.material.r.b.f1376a) {
            return E();
        }
        this.v = H();
        return new RippleDrawable(this.o, null, this.v);
    }

    @ah
    private Drawable E() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.u = H();
        this.u.g(this.o);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.u);
        return stateListDrawable;
    }

    private void F() {
        if (com.google.android.material.r.b.f1376a && this.s != null) {
            ((RippleDrawable) this.s).setColor(this.o);
        } else if (this.u != null) {
            this.u.g(this.o);
        }
    }

    @ah
    private Drawable G() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.n != null) {
            stateListDrawable.addState(f1280a, this.n);
        }
        return stateListDrawable;
    }

    @ah
    private j H() {
        return new j(this.q);
    }

    private float a(e eVar, float f) {
        if (eVar instanceof n) {
            return (float) ((1.0d - c) * ((double) f));
        }
        if (eVar instanceof f) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f.getForeground() instanceof InsetDrawable)) {
            this.f.setForeground(c(drawable));
        } else {
            ((InsetDrawable) this.f.getForeground()).setDrawable(drawable);
        }
    }

    @ah
    private Drawable c(Drawable drawable) {
        int iCeil;
        int i;
        if ((Build.VERSION.SDK_INT < 21) || this.f.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(v());
            iCeil = (int) Math.ceil(w());
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new InsetDrawable(drawable, iCeil, i, iCeil, i) { // from class: com.google.android.material.e.b.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private float v() {
        return (this.f.getMaxCardElevation() * d) + (A() ? B() : 0.0f);
    }

    private float w() {
        return this.f.getMaxCardElevation() + (A() ? B() : 0.0f);
    }

    private boolean x() {
        return Build.VERSION.SDK_INT >= 21 && this.h.aw();
    }

    private float y() {
        if (!this.f.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT < 21 || this.f.getUseCompatPadding()) {
            return (float) ((1.0d - c) * ((double) this.f.getCardViewRadius()));
        }
        return 0.0f;
    }

    private boolean z() {
        return this.f.getPreventCornerOverlap() && !x();
    }

    void a(float f) {
        a(this.q.a(f));
        this.m.invalidateSelf();
        if (A() || z()) {
            o();
        }
        if (A()) {
            m();
        }
    }

    void a(@p int i) {
        if (i == this.l) {
            return;
        }
        this.l = i;
        n();
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        if (this.t != null) {
            int iCeil = (i - this.j) - this.k;
            int iCeil2 = (i2 - this.j) - this.k;
            if ((Build.VERSION.SDK_INT < 21) || this.f.getUseCompatPadding()) {
                iCeil2 -= (int) Math.ceil(v() * 2.0f);
                iCeil -= (int) Math.ceil(w() * 2.0f);
            }
            int i5 = iCeil2;
            int i6 = this.j;
            if (af.p(this.f) == 1) {
                i4 = iCeil;
                i3 = i6;
            } else {
                i3 = iCeil;
                i4 = i6;
            }
            this.t.setLayerInset(2, i3, this.j, i4, i5);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        o();
    }

    void a(ColorStateList colorStateList) {
        if (this.r == colorStateList) {
            return;
        }
        this.r = colorStateList;
        n();
    }

    void a(@ah TypedArray typedArray) {
        this.r = c.a(this.f.getContext(), typedArray, com.google.android.material.a.o.MaterialCardView_strokeColor);
        if (this.r == null) {
            this.r = ColorStateList.valueOf(-1);
        }
        this.l = typedArray.getDimensionPixelSize(com.google.android.material.a.o.MaterialCardView_strokeWidth, 0);
        this.x = typedArray.getBoolean(com.google.android.material.a.o.MaterialCardView_android_checkable, false);
        this.f.setLongClickable(this.x);
        this.p = c.a(this.f.getContext(), typedArray, com.google.android.material.a.o.MaterialCardView_checkedIconTint);
        a(c.b(this.f.getContext(), typedArray, com.google.android.material.a.o.MaterialCardView_checkedIcon));
        this.o = c.a(this.f.getContext(), typedArray, com.google.android.material.a.o.MaterialCardView_rippleColor);
        if (this.o == null) {
            this.o = ColorStateList.valueOf(com.google.android.material.h.a.a(this.f, com.google.android.material.a.c.colorControlHighlight));
        }
        c(c.a(this.f.getContext(), typedArray, com.google.android.material.a.o.MaterialCardView_cardForegroundColor));
        F();
        l();
        n();
        this.f.setBackgroundInternal(c(this.h));
        this.m = this.f.isClickable() ? C() : this.i;
        this.f.setForeground(c(this.m));
    }

    void a(@ai Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            this.n = androidx.core.graphics.drawable.a.g(drawable.mutate());
            androidx.core.graphics.drawable.a.a(this.n, this.p);
        }
        if (this.t != null) {
            this.t.setDrawableByLayerId(com.google.android.material.a.h.mtrl_card_checked_layer_id, G());
        }
    }

    void a(@ah o oVar) {
        this.q = oVar;
        this.h.setShapeAppearanceModel(oVar);
        this.h.k(!this.h.aw());
        if (this.i != null) {
            this.i.setShapeAppearanceModel(oVar);
        }
        if (this.v != null) {
            this.v.setShapeAppearanceModel(oVar);
        }
        if (this.u != null) {
            this.u.setShapeAppearanceModel(oVar);
        }
    }

    void a(boolean z) {
        this.w = z;
    }

    boolean a() {
        return this.w;
    }

    @k
    int b() {
        if (this.r == null) {
            return -1;
        }
        return this.r.getDefaultColor();
    }

    void b(@r(a = 0.0d, b = 1.0d) float f) {
        this.h.p(f);
        if (this.i != null) {
            this.i.p(f);
        }
        if (this.v != null) {
            this.v.p(f);
        }
    }

    void b(ColorStateList colorStateList) {
        this.h.g(colorStateList);
    }

    void b(boolean z) {
        this.x = z;
    }

    @ai
    ColorStateList c() {
        return this.r;
    }

    void c(@ai ColorStateList colorStateList) {
        j jVar = this.i;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.g(colorStateList);
    }

    @p
    int d() {
        return this.l;
    }

    void d(@ai ColorStateList colorStateList) {
        this.o = colorStateList;
        F();
    }

    @ah
    j e() {
        return this.h;
    }

    void e(@ai ColorStateList colorStateList) {
        this.p = colorStateList;
        if (this.n != null) {
            androidx.core.graphics.drawable.a.a(this.n, colorStateList);
        }
    }

    ColorStateList f() {
        return this.h.U();
    }

    ColorStateList g() {
        return this.i.U();
    }

    @ah
    Rect h() {
        return this.g;
    }

    void i() {
        Drawable drawable = this.m;
        this.m = this.f.isClickable() ? C() : this.i;
        if (drawable != this.m) {
            b(this.m);
        }
    }

    float j() {
        return this.h.as();
    }

    @r(a = 0.0d, b = 1.0d)
    float k() {
        return this.h.ae();
    }

    void l() {
        this.h.r(this.f.getCardElevation());
    }

    void m() {
        if (!a()) {
            this.f.setBackgroundInternal(c(this.h));
        }
        this.f.setForeground(c(this.m));
    }

    void n() {
        this.i.a(this.l, this.r);
    }

    void o() {
        int iB = (int) ((z() || A() ? B() : 0.0f) - y());
        this.f.b(this.g.left + iB, this.g.top + iB, this.g.right + iB, this.g.bottom + iB);
    }

    boolean p() {
        return this.x;
    }

    @ai
    ColorStateList q() {
        return this.p;
    }

    @ai
    ColorStateList r() {
        return this.o;
    }

    @ai
    Drawable s() {
        return this.n;
    }

    @am(b = 23)
    void t() {
        if (this.s != null) {
            Rect bounds = this.s.getBounds();
            int i = bounds.bottom;
            this.s.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.s.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    o u() {
        return this.q;
    }
}
