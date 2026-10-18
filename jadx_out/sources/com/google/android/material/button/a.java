package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.core.n.af;
import com.google.android.material.internal.z;
import com.google.android.material.q.c;
import com.google.android.material.t.j;
import com.google.android.material.t.o;
import com.google.android.material.t.s;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f1211a;
    private final MaterialButton b;

    @ah
    private o c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    @ai
    private PorterDuff.Mode j;

    @ai
    private ColorStateList k;

    @ai
    private ColorStateList l;

    @ai
    private ColorStateList m;

    @ai
    private Drawable n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r;
    private LayerDrawable s;

    static {
        f1211a = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, @ah o oVar) {
        this.b = materialButton;
        this.c = oVar;
    }

    @ah
    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.d, this.f, this.e, this.g);
    }

    private void b(@ah o oVar) {
        if (i() != null) {
            i().setShapeAppearanceModel(oVar);
        }
        if (o() != null) {
            o().setShapeAppearanceModel(oVar);
        }
        if (k() != null) {
            k().setShapeAppearanceModel(oVar);
        }
    }

    @ai
    private j c(boolean z) {
        if (this.s == null || this.s.getNumberOfLayers() <= 0) {
            return null;
        }
        return f1211a ? (j) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (j) this.s.getDrawable(!z ? 1 : 0);
    }

    private Drawable m() {
        j jVar = new j(this.c);
        jVar.b(this.b.getContext());
        androidx.core.graphics.drawable.a.a(jVar, this.k);
        if (this.j != null) {
            androidx.core.graphics.drawable.a.a(jVar, this.j);
        }
        jVar.a(this.i, this.l);
        j jVar2 = new j(this.c);
        jVar2.setTint(0);
        jVar2.a(this.i, this.o ? com.google.android.material.h.a.a(this.b, com.google.android.material.a.c.colorSurface) : 0);
        if (f1211a) {
            this.n = new j(this.c);
            androidx.core.graphics.drawable.a.a(this.n, -1);
            this.s = new RippleDrawable(com.google.android.material.r.b.b(this.m), a(new LayerDrawable(new Drawable[]{jVar2, jVar})), this.n);
            return this.s;
        }
        this.n = new com.google.android.material.r.a(this.c);
        androidx.core.graphics.drawable.a.a(this.n, com.google.android.material.r.b.b(this.m));
        this.s = new LayerDrawable(new Drawable[]{jVar2, jVar, this.n});
        return a(this.s);
    }

    private void n() {
        j jVarI = i();
        j jVarO = o();
        if (jVarI != null) {
            jVarI.a(this.i, this.l);
            if (jVarO != null) {
                jVarO.a(this.i, this.o ? com.google.android.material.h.a.a(this.b, com.google.android.material.a.c.colorSurface) : 0);
            }
        }
    }

    @ai
    private j o() {
        return c(true);
    }

    void a() {
        this.p = true;
        this.b.setSupportBackgroundTintList(this.k);
        this.b.setSupportBackgroundTintMode(this.j);
    }

    void a(int i) {
        if (i() != null) {
            i().setTint(i);
        }
    }

    void a(int i, int i2) {
        if (this.n != null) {
            this.n.setBounds(this.d, this.f, i2 - this.e, i - this.g);
        }
    }

    void a(@ai ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (i() != null) {
                androidx.core.graphics.drawable.a.a(i(), this.k);
            }
        }
    }

    void a(@ah TypedArray typedArray) {
        this.d = typedArray.getDimensionPixelOffset(com.google.android.material.a.o.MaterialButton_android_insetLeft, 0);
        this.e = typedArray.getDimensionPixelOffset(com.google.android.material.a.o.MaterialButton_android_insetRight, 0);
        this.f = typedArray.getDimensionPixelOffset(com.google.android.material.a.o.MaterialButton_android_insetTop, 0);
        this.g = typedArray.getDimensionPixelOffset(com.google.android.material.a.o.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(com.google.android.material.a.o.MaterialButton_cornerRadius)) {
            this.h = typedArray.getDimensionPixelSize(com.google.android.material.a.o.MaterialButton_cornerRadius, -1);
            a(this.c.a(this.h));
            this.q = true;
        }
        this.i = typedArray.getDimensionPixelSize(com.google.android.material.a.o.MaterialButton_strokeWidth, 0);
        this.j = z.a(typedArray.getInt(com.google.android.material.a.o.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.k = c.a(this.b.getContext(), typedArray, com.google.android.material.a.o.MaterialButton_backgroundTint);
        this.l = c.a(this.b.getContext(), typedArray, com.google.android.material.a.o.MaterialButton_strokeColor);
        this.m = c.a(this.b.getContext(), typedArray, com.google.android.material.a.o.MaterialButton_rippleColor);
        this.r = typedArray.getBoolean(com.google.android.material.a.o.MaterialButton_android_checkable, false);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(com.google.android.material.a.o.MaterialButton_elevation, 0);
        int iW = af.w(this.b);
        int paddingTop = this.b.getPaddingTop();
        int iX = af.x(this.b);
        int paddingBottom = this.b.getPaddingBottom();
        if (typedArray.hasValue(com.google.android.material.a.o.MaterialButton_android_background)) {
            a();
        } else {
            this.b.setInternalBackground(m());
            j jVarI = i();
            if (jVarI != null) {
                jVarI.r(dimensionPixelSize);
            }
        }
        af.b(this.b, iW + this.d, paddingTop + this.f, iX + this.e, paddingBottom + this.g);
    }

    void a(@ai PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            if (i() == null || this.j == null) {
                return;
            }
            androidx.core.graphics.drawable.a.a(i(), this.j);
        }
    }

    void a(@ah o oVar) {
        this.c = oVar;
        b(oVar);
    }

    void a(boolean z) {
        this.o = z;
        n();
    }

    void b(int i) {
        if (this.i != i) {
            this.i = i;
            n();
        }
    }

    void b(@ai ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            if (f1211a && (this.b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.b.getBackground()).setColor(com.google.android.material.r.b.b(colorStateList));
            } else {
                if (f1211a || !(this.b.getBackground() instanceof com.google.android.material.r.a)) {
                    return;
                }
                ((com.google.android.material.r.a) this.b.getBackground()).setTintList(com.google.android.material.r.b.b(colorStateList));
            }
        }
    }

    void b(boolean z) {
        this.r = z;
    }

    boolean b() {
        return this.p;
    }

    ColorStateList c() {
        return this.k;
    }

    void c(int i) {
        if (this.q && this.h == i) {
            return;
        }
        this.h = i;
        this.q = true;
        a(this.c.a(i));
    }

    void c(@ai ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            n();
        }
    }

    PorterDuff.Mode d() {
        return this.j;
    }

    @ai
    ColorStateList e() {
        return this.m;
    }

    @ai
    ColorStateList f() {
        return this.l;
    }

    int g() {
        return this.i;
    }

    int h() {
        return this.h;
    }

    @ai
    j i() {
        return c(false);
    }

    boolean j() {
        return this.r;
    }

    @ai
    public s k() {
        if (this.s == null || this.s.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (s) this.s.getDrawable(2) : (s) this.s.getDrawable(1);
    }

    @ah
    o l() {
        return this.c;
    }
}
