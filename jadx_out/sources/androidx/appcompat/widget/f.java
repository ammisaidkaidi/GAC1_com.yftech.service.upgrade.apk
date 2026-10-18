package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @androidx.annotation.ah
    private final View f268a;
    private ay d;
    private ay e;
    private ay f;
    private int c = -1;
    private final k b = k.b();

    f(@androidx.annotation.ah View view) {
        this.f268a = view;
    }

    private boolean b(@androidx.annotation.ah Drawable drawable) {
        if (this.f == null) {
            this.f = new ay();
        }
        ay ayVar = this.f;
        ayVar.a();
        ColorStateList colorStateListAa = androidx.core.n.af.aa(this.f268a);
        if (colorStateListAa != null) {
            ayVar.d = true;
            ayVar.f241a = colorStateListAa;
        }
        PorterDuff.Mode modeAb = androidx.core.n.af.ab(this.f268a);
        if (modeAb != null) {
            ayVar.c = true;
            ayVar.b = modeAb;
        }
        if (!ayVar.d && !ayVar.c) {
            return false;
        }
        k.a(drawable, ayVar, this.f268a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            return this.d != null;
        }
        return i == 21;
    }

    ColorStateList a() {
        if (this.e != null) {
            return this.e.f241a;
        }
        return null;
    }

    void a(int i) {
        this.c = i;
        b(this.b != null ? this.b.b(this.f268a.getContext(), i) : null);
        c();
    }

    void a(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new ay();
        }
        this.e.f241a = colorStateList;
        this.e.d = true;
        c();
    }

    void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new ay();
        }
        this.e.b = mode;
        this.e.c = true;
        c();
    }

    void a(Drawable drawable) {
        this.c = -1;
        b((ColorStateList) null);
        c();
    }

    void a(@androidx.annotation.ai AttributeSet attributeSet, int i) {
        ba baVarA = ba.a(this.f268a.getContext(), attributeSet, androidx.appcompat.a.m.ViewBackgroundHelper, i, 0);
        androidx.core.n.af.a(this.f268a, this.f268a.getContext(), androidx.appcompat.a.m.ViewBackgroundHelper, attributeSet, baVarA.a(), i, 0);
        try {
            if (baVarA.j(androidx.appcompat.a.m.ViewBackgroundHelper_android_background)) {
                this.c = baVarA.g(androidx.appcompat.a.m.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListB = this.b.b(this.f268a.getContext(), this.c);
                if (colorStateListB != null) {
                    b(colorStateListB);
                }
            }
            if (baVarA.j(androidx.appcompat.a.m.ViewBackgroundHelper_backgroundTint)) {
                androidx.core.n.af.a(this.f268a, baVarA.g(androidx.appcompat.a.m.ViewBackgroundHelper_backgroundTint));
            }
            if (baVarA.j(androidx.appcompat.a.m.ViewBackgroundHelper_backgroundTintMode)) {
                androidx.core.n.af.a(this.f268a, af.a(baVarA.a(androidx.appcompat.a.m.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            baVarA.f();
        }
    }

    PorterDuff.Mode b() {
        if (this.e != null) {
            return this.e.b;
        }
        return null;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new ay();
            }
            this.d.f241a = colorStateList;
            this.d.d = true;
        } else {
            this.d = null;
        }
        c();
    }

    void c() {
        Drawable background = this.f268a.getBackground();
        if (background != null) {
            if (d() && b(background)) {
                return;
            }
            if (this.e != null) {
                k.a(background, this.e, this.f268a.getDrawableState());
            } else if (this.d != null) {
                k.a(background, this.d, this.f268a.getDrawableState());
            }
        }
    }
}
