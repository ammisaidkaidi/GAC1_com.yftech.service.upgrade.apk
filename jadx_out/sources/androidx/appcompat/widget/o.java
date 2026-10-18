package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @androidx.annotation.ah
    private final ImageView f277a;
    private ay b;
    private ay c;
    private ay d;

    public o(@androidx.annotation.ah ImageView imageView) {
        this.f277a = imageView;
    }

    private boolean a(@androidx.annotation.ah Drawable drawable) {
        if (this.d == null) {
            this.d = new ay();
        }
        ay ayVar = this.d;
        ayVar.a();
        ColorStateList colorStateListA = androidx.core.widget.f.a(this.f277a);
        if (colorStateListA != null) {
            ayVar.d = true;
            ayVar.f241a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.f.b(this.f277a);
        if (modeB != null) {
            ayVar.c = true;
            ayVar.b = modeB;
        }
        if (!ayVar.d && !ayVar.c) {
            return false;
        }
        k.a(drawable, ayVar, this.f277a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.b != null;
        }
        return i == 21;
    }

    public void a(int i) {
        if (i != 0) {
            Drawable drawableB = androidx.appcompat.a.a.a.b(this.f277a.getContext(), i);
            if (drawableB != null) {
                af.b(drawableB);
            }
            this.f277a.setImageDrawable(drawableB);
        } else {
            this.f277a.setImageDrawable(null);
        }
        d();
    }

    void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new ay();
        }
        this.c.f241a = colorStateList;
        this.c.d = true;
        d();
    }

    void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new ay();
        }
        this.c.b = mode;
        this.c.c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i) {
        int iG;
        ba baVarA = ba.a(this.f277a.getContext(), attributeSet, androidx.appcompat.a.m.AppCompatImageView, i, 0);
        androidx.core.n.af.a(this.f277a, this.f277a.getContext(), androidx.appcompat.a.m.AppCompatImageView, attributeSet, baVarA.a(), i, 0);
        try {
            Drawable drawable = this.f277a.getDrawable();
            if (drawable == null && (iG = baVarA.g(androidx.appcompat.a.m.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = androidx.appcompat.a.a.a.b(this.f277a.getContext(), iG)) != null) {
                this.f277a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                af.b(drawable);
            }
            if (baVarA.j(androidx.appcompat.a.m.AppCompatImageView_tint)) {
                androidx.core.widget.f.a(this.f277a, baVarA.g(androidx.appcompat.a.m.AppCompatImageView_tint));
            }
            if (baVarA.j(androidx.appcompat.a.m.AppCompatImageView_tintMode)) {
                androidx.core.widget.f.a(this.f277a, af.a(baVarA.a(androidx.appcompat.a.m.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            baVarA.f();
        }
    }

    boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f277a.getBackground() instanceof RippleDrawable);
    }

    ColorStateList b() {
        if (this.c != null) {
            return this.c.f241a;
        }
        return null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.b == null) {
                this.b = new ay();
            }
            this.b.f241a = colorStateList;
            this.b.d = true;
        } else {
            this.b = null;
        }
        d();
    }

    PorterDuff.Mode c() {
        if (this.c != null) {
            return this.c.b;
        }
        return null;
    }

    void d() {
        Drawable drawable = this.f277a.getDrawable();
        if (drawable != null) {
            af.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            if (this.c != null) {
                k.a(drawable, this.c, this.f277a.getDrawableState());
            } else if (this.b != null) {
                k.a(drawable, this.b, this.f277a.getDrawableState());
            }
        }
    }
}
