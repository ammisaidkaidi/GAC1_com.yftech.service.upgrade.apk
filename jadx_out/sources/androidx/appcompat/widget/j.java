package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @androidx.annotation.ah
    private final CompoundButton f272a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    j(@androidx.annotation.ah CompoundButton compoundButton) {
        this.f272a = compoundButton;
    }

    int a(int i) {
        Drawable drawableC;
        return (Build.VERSION.SDK_INT >= 17 || (drawableC = androidx.core.widget.c.c(this.f272a)) == null) ? i : i + drawableC.getIntrinsicWidth();
    }

    ColorStateList a() {
        return this.b;
    }

    void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    void a(@androidx.annotation.ai PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        d();
    }

    void a(@androidx.annotation.ai AttributeSet attributeSet, int i) {
        boolean z;
        int iG;
        int iG2;
        ba baVarA = ba.a(this.f272a.getContext(), attributeSet, androidx.appcompat.a.m.CompoundButton, i, 0);
        androidx.core.n.af.a(this.f272a, this.f272a.getContext(), androidx.appcompat.a.m.CompoundButton, attributeSet, baVarA.a(), i, 0);
        try {
            if (!baVarA.j(androidx.appcompat.a.m.CompoundButton_buttonCompat) || (iG2 = baVarA.g(androidx.appcompat.a.m.CompoundButton_buttonCompat, 0)) == 0) {
                z = false;
            } else {
                try {
                    this.f272a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f272a.getContext(), iG2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z && baVarA.j(androidx.appcompat.a.m.CompoundButton_android_button) && (iG = baVarA.g(androidx.appcompat.a.m.CompoundButton_android_button, 0)) != 0) {
                this.f272a.setButtonDrawable(androidx.appcompat.a.a.a.b(this.f272a.getContext(), iG));
            }
            if (baVarA.j(androidx.appcompat.a.m.CompoundButton_buttonTint)) {
                androidx.core.widget.c.a(this.f272a, baVarA.g(androidx.appcompat.a.m.CompoundButton_buttonTint));
            }
            if (baVarA.j(androidx.appcompat.a.m.CompoundButton_buttonTintMode)) {
                androidx.core.widget.c.a(this.f272a, af.a(baVarA.a(androidx.appcompat.a.m.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            baVarA.f();
        }
    }

    PorterDuff.Mode b() {
        return this.c;
    }

    void c() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            d();
        }
    }

    void d() {
        Drawable drawableC = androidx.core.widget.c.c(this.f272a);
        if (drawableC != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.g(drawableC).mutate();
                if (this.d) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.b);
                }
                if (this.e) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f272a.getDrawableState());
                }
                this.f272a.setButtonDrawable(drawableMutate);
            }
        }
    }
}
