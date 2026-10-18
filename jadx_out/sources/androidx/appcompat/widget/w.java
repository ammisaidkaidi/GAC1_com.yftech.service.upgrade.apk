package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes.dex */
class w extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeekBar f285a;
    private Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    w(SeekBar seekBar) {
        super(seekBar);
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.f285a = seekBar;
    }

    private void g() {
        if (this.b != null) {
            if (this.e || this.f) {
                this.b = androidx.core.graphics.drawable.a.g(this.b.mutate());
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(this.b, this.c);
                }
                if (this.f) {
                    androidx.core.graphics.drawable.a.a(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.f285a.getDrawableState());
                }
            }
        }
    }

    void a(@androidx.annotation.ai ColorStateList colorStateList) {
        this.c = colorStateList;
        this.e = true;
        g();
    }

    void a(Canvas canvas) {
        if (this.b != null) {
            int max = this.f285a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.b.getIntrinsicWidth();
                int intrinsicHeight = this.b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.b.setBounds(-i, -i2, i, i2);
                float width = ((this.f285a.getWidth() - this.f285a.getPaddingLeft()) - this.f285a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f285a.getPaddingLeft(), this.f285a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void a(@androidx.annotation.ai PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        g();
    }

    void a(@androidx.annotation.ai Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f285a);
            androidx.core.graphics.drawable.a.b(drawable, androidx.core.n.af.p(this.f285a));
            if (drawable.isStateful()) {
                drawable.setState(this.f285a.getDrawableState());
            }
            g();
        }
        this.f285a.invalidate();
    }

    @Override // androidx.appcompat.widget.s
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ba baVarA = ba.a(this.f285a.getContext(), attributeSet, androidx.appcompat.a.m.AppCompatSeekBar, i, 0);
        androidx.core.n.af.a(this.f285a, this.f285a.getContext(), androidx.appcompat.a.m.AppCompatSeekBar, attributeSet, baVarA.a(), i, 0);
        Drawable drawableB = baVarA.b(androidx.appcompat.a.m.AppCompatSeekBar_android_thumb);
        if (drawableB != null) {
            this.f285a.setThumb(drawableB);
        }
        a(baVarA.a(androidx.appcompat.a.m.AppCompatSeekBar_tickMark));
        if (baVarA.j(androidx.appcompat.a.m.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = af.a(baVarA.a(androidx.appcompat.a.m.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (baVarA.j(androidx.appcompat.a.m.AppCompatSeekBar_tickMarkTint)) {
            this.c = baVarA.g(androidx.appcompat.a.m.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        baVarA.f();
        g();
    }

    @androidx.annotation.ai
    Drawable b() {
        return this.b;
    }

    @androidx.annotation.ai
    ColorStateList c() {
        return this.c;
    }

    @androidx.annotation.ai
    PorterDuff.Mode d() {
        return this.d;
    }

    void e() {
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
    }

    void f() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f285a.getDrawableState())) {
            this.f285a.invalidateDrawable(drawable);
        }
    }
}
