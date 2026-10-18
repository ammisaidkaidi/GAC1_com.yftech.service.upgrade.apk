package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.k;
import androidx.annotation.p;
import androidx.annotation.z;
import com.google.android.material.t.o;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
class c extends Drawable {
    private static final float b = 1.3333f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p
    float f1297a;

    @k
    private int j;

    @k
    private int k;

    @k
    private int l;

    @k
    private int m;

    @k
    private int n;
    private o p;

    @ai
    private ColorStateList q;
    private final com.google.android.material.t.p c = new com.google.android.material.t.p();
    private final Path e = new Path();
    private final Rect f = new Rect();
    private final RectF g = new RectF();
    private final RectF h = new RectF();
    private final a i = new a();
    private boolean o = true;

    @ah
    private final Paint d = new Paint(1);

    private class a extends Drawable.ConstantState {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @ah
        public Drawable newDrawable() {
            return c.this;
        }
    }

    c(o oVar) {
        this.p = oVar;
        this.d.setStyle(Paint.Style.STROKE);
    }

    @ah
    private Shader c() {
        Rect rect = this.f;
        copyBounds(rect);
        float fHeight = this.f1297a / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{androidx.core.graphics.e.a(this.j, this.n), androidx.core.graphics.e.a(this.k, this.n), androidx.core.graphics.e.a(androidx.core.graphics.e.c(this.k, 0), this.n), androidx.core.graphics.e.a(androidx.core.graphics.e.c(this.m, 0), this.n), androidx.core.graphics.e.a(this.m, this.n), androidx.core.graphics.e.a(this.l, this.n)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    @ah
    protected RectF a() {
        this.h.set(getBounds());
        return this.h;
    }

    public void a(@p float f) {
        if (this.f1297a != f) {
            this.f1297a = f;
            this.d.setStrokeWidth(f * b);
            this.o = true;
            invalidateSelf();
        }
    }

    void a(@k int i, @k int i2, @k int i3, @k int i4) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    void a(@ai ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.n = colorStateList.getColorForState(getState(), this.n);
        }
        this.q = colorStateList;
        this.o = true;
        invalidateSelf();
    }

    public void a(o oVar) {
        this.p = oVar;
        invalidateSelf();
    }

    public o b() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@ah Canvas canvas) {
        if (this.o) {
            this.d.setShader(c());
            this.o = false;
        }
        float strokeWidth = this.d.getStrokeWidth() / 2.0f;
        copyBounds(this.f);
        this.g.set(this.f);
        float fMin = Math.min(this.p.f().a(a()), this.g.width() / 2.0f);
        if (this.p.a(a())) {
            this.g.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.g, fMin, fMin, this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @ai
    public Drawable.ConstantState getConstantState() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1297a > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@ah Outline outline) {
        if (this.p.a(a())) {
            outline.setRoundRect(getBounds(), this.p.f().a(a()));
            return;
        }
        copyBounds(this.f);
        this.g.set(this.f);
        this.c.a(this.p, 1.0f, this.g, this.e);
        if (this.e.isConvex()) {
            outline.setConvexPath(this.e);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@ah Rect rect) {
        if (!this.p.a(a())) {
            return true;
        }
        int iRound = Math.round(this.f1297a);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.q != null && this.q.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.o = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.q != null && (colorForState = this.q.getColorForState(iArr, this.n)) != this.n) {
            this.o = true;
            this.n = colorForState;
        }
        if (this.o) {
            invalidateSelf();
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@z(a = FabTransformationScrimBehavior.c, b = 255) int i) {
        this.d.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@ai ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
