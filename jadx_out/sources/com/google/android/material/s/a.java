package com.google.android.material.s;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a extends androidx.appcompat.b.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double f1377a = Math.cos(Math.toRadians(45.0d));
    static final float b = 1.5f;
    static final float c = 0.25f;
    static final float d = 0.5f;
    static final float e = 1.0f;

    @ah
    final Paint f;

    @ah
    final Paint g;

    @ah
    final RectF h;
    float i;
    Path j;
    float k;
    float l;
    float m;
    float n;
    private boolean o;
    private final int p;
    private final int q;
    private final int r;
    private boolean s;
    private float t;
    private boolean u;

    public a(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.o = true;
        this.s = true;
        this.u = false;
        this.p = androidx.core.b.c.c(context, com.google.android.material.a.e.design_fab_shadow_start_color);
        this.q = androidx.core.b.c.c(context, com.google.android.material.a.e.design_fab_shadow_mid_color);
        this.r = androidx.core.b.c.c(context, com.google.android.material.a.e.design_fab_shadow_end_color);
        this.f = new Paint(5);
        this.f.setStyle(Paint.Style.FILL);
        this.i = Math.round(f);
        this.h = new RectF();
        this.g = new Paint(this.f);
        this.g.setAntiAlias(false);
        a(f2, f3);
    }

    public static float a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * b)) + ((1.0d - f1377a) * ((double) f2))) : f * b;
    }

    private void a(@ah Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(this.t, this.h.centerX(), this.h.centerY());
        float f = (-this.i) - this.m;
        float f2 = this.i;
        float f3 = f2 * 2.0f;
        boolean z = this.h.width() - f3 > 0.0f;
        boolean z2 = this.h.height() - f3 > 0.0f;
        float f4 = this.n - (this.n * c);
        float f5 = f2 / ((this.n - (this.n * d)) + f2);
        float f6 = f2 / (f4 + f2);
        float f7 = f2 / ((this.n - (this.n * 1.0f)) + f2);
        int iSave2 = canvas.save();
        canvas.translate(this.h.left + f2, this.h.top + f2);
        canvas.scale(f5, f6);
        canvas.drawPath(this.j, this.f);
        if (z) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.h.width() - f3, -this.i, this.g);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.h.right - f2, this.h.bottom - f2);
        canvas.scale(f5, f7);
        canvas.rotate(180.0f);
        canvas.drawPath(this.j, this.f);
        if (z) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.h.width() - f3, (-this.i) + this.m, this.g);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.h.left + f2, this.h.bottom - f2);
        canvas.scale(f5, r6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.j, this.f);
        if (z2) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f, this.h.height() - f3, -this.i, this.g);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.h.right - f2, this.h.top + f2);
        canvas.scale(f5, f6);
        canvas.rotate(90.0f);
        canvas.drawPath(this.j, this.f);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.h.height() - f3, -this.i, this.g);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    private void a(@ah Rect rect) {
        float f = this.l * b;
        this.h.set(rect.left + this.l, rect.top + f, rect.right - this.l, rect.bottom - f);
        a().setBounds((int) this.h.left, (int) this.h.top, (int) this.h.right, (int) this.h.bottom);
        g();
    }

    public static float b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f1377a) * ((double) f2))) : f;
    }

    private static int e(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    private void g() {
        RectF rectF = new RectF(-this.i, -this.i, this.i, this.i);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.m, -this.m);
        if (this.j == null) {
            this.j = new Path();
        } else {
            this.j.reset();
        }
        this.j.setFillType(Path.FillType.EVEN_ODD);
        this.j.moveTo(-this.i, 0.0f);
        this.j.rLineTo(-this.m, 0.0f);
        this.j.arcTo(rectF2, 180.0f, 90.0f, false);
        this.j.arcTo(rectF, 270.0f, -90.0f, false);
        this.j.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.i / f;
            this.f.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.p, this.q, this.r}, new float[]{0.0f, f2, ((1.0f - f2) / 2.0f) + f2, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.g.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.p, this.q, this.r}, new float[]{0.0f, d, 1.0f}, Shader.TileMode.CLAMP));
        this.g.setAntiAlias(false);
    }

    public void a(float f) {
        a(f, this.l);
    }

    public void a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fE = e(f);
        float fE2 = e(f2);
        if (fE > fE2) {
            if (!this.u) {
                this.u = true;
            }
            fE = fE2;
        }
        if (this.n == fE && this.l == fE2) {
            return;
        }
        this.n = fE;
        this.l = fE2;
        this.m = Math.round(fE * b);
        this.k = fE2;
        this.o = true;
        invalidateSelf();
    }

    public void a(boolean z) {
        this.s = z;
        invalidateSelf();
    }

    public float b() {
        return this.n;
    }

    public void b(float f) {
        float fRound = Math.round(f);
        if (this.i == fRound) {
            return;
        }
        this.i = fRound;
        this.o = true;
        invalidateSelf();
    }

    public float c() {
        return this.i;
    }

    public final void c(float f) {
        if (this.t != f) {
            this.t = f;
            invalidateSelf();
        }
    }

    public float d() {
        return this.l;
    }

    public void d(float f) {
        a(this.n, f);
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public void draw(@ah Canvas canvas) {
        if (this.o) {
            a(getBounds());
            this.o = false;
        }
        a(canvas);
        super.draw(canvas);
    }

    public float e() {
        return (Math.max(this.l, this.i + (this.l / 2.0f)) * 2.0f) + (this.l * 2.0f);
    }

    public float f() {
        return (Math.max(this.l, this.i + ((this.l * b) / 2.0f)) * 2.0f) + (this.l * b * 2.0f);
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public boolean getPadding(@ah Rect rect) {
        int iCeil = (int) Math.ceil(a(this.l, this.i, this.s));
        int iCeil2 = (int) Math.ceil(b(this.l, this.i, this.s));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.o = true;
    }

    @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f.setAlpha(i);
        this.g.setAlpha(i);
    }
}
