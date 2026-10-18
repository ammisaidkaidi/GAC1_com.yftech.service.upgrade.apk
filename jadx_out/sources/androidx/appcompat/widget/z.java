package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f297a = -1;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;

    @androidx.annotation.ah
    private final TextView e;
    private ay f;
    private ay g;
    private ay h;
    private ay i;
    private ay j;
    private ay k;
    private ay l;

    @androidx.annotation.ah
    private final ab m;
    private int n = 0;
    private int o = -1;
    private Typeface p;
    private boolean q;

    z(@androidx.annotation.ah TextView textView) {
        this.e = textView;
        this.m = new ab(this.e);
    }

    private static ay a(Context context, k kVar, int i) {
        ColorStateList colorStateListB = kVar.b(context, i);
        if (colorStateListB == null) {
            return null;
        }
        ay ayVar = new ay();
        ayVar.d = true;
        ayVar.f241a = colorStateListB;
        return ayVar;
    }

    private void a(Context context, ba baVar) {
        String strE;
        this.n = baVar.a(androidx.appcompat.a.m.TextAppearance_android_textStyle, this.n);
        if (Build.VERSION.SDK_INT >= 28) {
            this.o = baVar.a(androidx.appcompat.a.m.TextAppearance_android_textFontWeight, -1);
            if (this.o != -1) {
                this.n = (this.n & 2) | 0;
            }
        }
        if (!baVar.j(androidx.appcompat.a.m.TextAppearance_android_fontFamily) && !baVar.j(androidx.appcompat.a.m.TextAppearance_fontFamily)) {
            if (baVar.j(androidx.appcompat.a.m.TextAppearance_android_typeface)) {
                this.q = false;
                switch (baVar.a(androidx.appcompat.a.m.TextAppearance_android_typeface, 1)) {
                    case 1:
                        this.p = Typeface.SANS_SERIF;
                        break;
                    case 2:
                        this.p = Typeface.SERIF;
                        break;
                    case 3:
                        this.p = Typeface.MONOSPACE;
                        break;
                }
                return;
            }
            return;
        }
        this.p = null;
        int i = baVar.j(androidx.appcompat.a.m.TextAppearance_fontFamily) ? androidx.appcompat.a.m.TextAppearance_fontFamily : androidx.appcompat.a.m.TextAppearance_android_fontFamily;
        final int i2 = this.o;
        final int i3 = this.n;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.e);
            try {
                Typeface typefaceA = baVar.a(i, this.n, new androidx.core.b.b.g.a() { // from class: androidx.appcompat.widget.z.1
                    @Override // androidx.core.b.b.g.a
                    public void a(int i4) {
                    }

                    @Override // androidx.core.b.b.g.a
                    public void a(@androidx.annotation.ah Typeface typeface) {
                        if (Build.VERSION.SDK_INT >= 28 && i2 != -1) {
                            typeface = Typeface.create(typeface, i2, (i3 & 2) != 0);
                        }
                        z.this.a(weakReference, typeface);
                    }
                });
                if (typefaceA != null) {
                    if (Build.VERSION.SDK_INT < 28 || this.o == -1) {
                        this.p = typefaceA;
                    } else {
                        this.p = Typeface.create(Typeface.create(typefaceA, 0), this.o, (this.n & 2) != 0);
                    }
                }
                this.q = this.p == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.p != null || (strE = baVar.e(i)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.o == -1) {
            this.p = Typeface.create(strE, this.n);
        } else {
            this.p = Typeface.create(Typeface.create(strE, 0), this.o, (this.n & 2) != 0);
        }
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
            TextView textView = this.e;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.e;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.e.getCompoundDrawables();
        TextView textView3 = this.e;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void a(Drawable drawable, ay ayVar) {
        if (drawable == null || ayVar == null) {
            return;
        }
        k.a(drawable, ayVar, this.e.getDrawableState());
    }

    private void b(int i, float f) {
        this.m.a(i, f);
    }

    private void l() {
        this.f = this.l;
        this.g = this.l;
        this.h = this.l;
        this.i = this.l;
        this.j = this.l;
        this.k = this.l;
    }

    void a() {
        b();
    }

    void a(int i) {
        this.m.a(i);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    void a(int i, float f) {
        if (androidx.core.widget.b.d || d()) {
            return;
        }
        b(i, f);
    }

    void a(int i, int i2, int i3, int i4) {
        this.m.a(i, i2, i3, i4);
    }

    void a(Context context, int i) {
        String strE;
        ColorStateList colorStateListG;
        ba baVarA = ba.a(context, i, androidx.appcompat.a.m.TextAppearance);
        if (baVarA.j(androidx.appcompat.a.m.TextAppearance_textAllCaps)) {
            a(baVarA.a(androidx.appcompat.a.m.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && baVarA.j(androidx.appcompat.a.m.TextAppearance_android_textColor) && (colorStateListG = baVarA.g(androidx.appcompat.a.m.TextAppearance_android_textColor)) != null) {
            this.e.setTextColor(colorStateListG);
        }
        if (baVarA.j(androidx.appcompat.a.m.TextAppearance_android_textSize) && baVarA.e(androidx.appcompat.a.m.TextAppearance_android_textSize, -1) == 0) {
            this.e.setTextSize(0, 0.0f);
        }
        a(context, baVarA);
        if (Build.VERSION.SDK_INT >= 26 && baVarA.j(androidx.appcompat.a.m.TextAppearance_fontVariationSettings) && (strE = baVarA.e(androidx.appcompat.a.m.TextAppearance_fontVariationSettings)) != null) {
            this.e.setFontVariationSettings(strE);
        }
        baVarA.f();
        if (this.p != null) {
            this.e.setTypeface(this.p, this.n);
        }
    }

    void a(@androidx.annotation.ai ColorStateList colorStateList) {
        if (this.l == null) {
            this.l = new ay();
        }
        this.l.f241a = colorStateList;
        this.l.d = colorStateList != null;
        l();
    }

    void a(@androidx.annotation.ai PorterDuff.Mode mode) {
        if (this.l == null) {
            this.l = new ay();
        }
        this.l.b = mode;
        this.l.c = mode != null;
        l();
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0126  */
    /* JADX WARN: Code duplicated, block: B:49:0x012d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0141  */
    @SuppressLint({"NewApi"})
    void a(@androidx.annotation.ai AttributeSet attributeSet, int i) {
        boolean z;
        boolean zA;
        ColorStateList colorStateListG;
        String strE;
        ColorStateList colorStateListG2;
        String strE2;
        ColorStateList colorStateListG3;
        boolean z2;
        int i2;
        Context context = this.e.getContext();
        k kVarB = k.b();
        ba baVarA = ba.a(context, attributeSet, androidx.appcompat.a.m.AppCompatTextHelper, i, 0);
        androidx.core.n.af.a(this.e, this.e.getContext(), androidx.appcompat.a.m.AppCompatTextHelper, attributeSet, baVarA.a(), i, 0);
        int iG = baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_textAppearance, -1);
        if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableLeft)) {
            this.f = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableTop)) {
            this.g = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableRight)) {
            this.h = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableBottom)) {
            this.i = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableStart)) {
                this.j = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (baVarA.j(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableEnd)) {
                this.k = a(context, kVarB, baVarA.g(androidx.appcompat.a.m.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        baVarA.f();
        boolean z3 = this.e.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iG != -1) {
            ba baVarA2 = ba.a(context, iG, androidx.appcompat.a.m.TextAppearance);
            if (z3 || !baVarA2.j(androidx.appcompat.a.m.TextAppearance_textAllCaps)) {
                z = false;
                zA = false;
            } else {
                zA = baVarA2.a(androidx.appcompat.a.m.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, baVarA2);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateListG4 = baVarA2.j(androidx.appcompat.a.m.TextAppearance_android_textColor) ? baVarA2.g(androidx.appcompat.a.m.TextAppearance_android_textColor) : null;
                colorStateListG = baVarA2.j(androidx.appcompat.a.m.TextAppearance_android_textColorHint) ? baVarA2.g(androidx.appcompat.a.m.TextAppearance_android_textColorHint) : null;
                if (baVarA2.j(androidx.appcompat.a.m.TextAppearance_android_textColorLink)) {
                    ColorStateList colorStateList = colorStateListG4;
                    colorStateListG3 = baVarA2.g(androidx.appcompat.a.m.TextAppearance_android_textColorLink);
                    colorStateListG2 = colorStateList;
                } else {
                    colorStateListG2 = colorStateListG4;
                }
                if (baVarA2.j(androidx.appcompat.a.m.TextAppearance_textLocale)) {
                    strE2 = baVarA2.e(androidx.appcompat.a.m.TextAppearance_textLocale);
                } else {
                    strE2 = null;
                }
                if (Build.VERSION.SDK_INT >= 26 || !baVarA2.j(androidx.appcompat.a.m.TextAppearance_fontVariationSettings)) {
                    strE = null;
                } else {
                    strE = baVarA2.e(androidx.appcompat.a.m.TextAppearance_fontVariationSettings);
                }
                baVarA2.f();
            } else {
                colorStateListG = null;
                colorStateListG2 = null;
            }
            colorStateListG3 = null;
            if (baVarA2.j(androidx.appcompat.a.m.TextAppearance_textLocale)) {
                strE2 = baVarA2.e(androidx.appcompat.a.m.TextAppearance_textLocale);
            } else {
                strE2 = null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                strE = null;
            } else {
                strE = null;
            }
            baVarA2.f();
        } else {
            z = false;
            zA = false;
            colorStateListG = null;
            strE = null;
            colorStateListG2 = null;
            strE2 = null;
            colorStateListG3 = null;
        }
        ba baVarA3 = ba.a(context, attributeSet, androidx.appcompat.a.m.TextAppearance, i, 0);
        if (z3 || !baVarA3.j(androidx.appcompat.a.m.TextAppearance_textAllCaps)) {
            z2 = z;
        } else {
            zA = baVarA3.a(androidx.appcompat.a.m.TextAppearance_textAllCaps, false);
            z2 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (baVarA3.j(androidx.appcompat.a.m.TextAppearance_android_textColor)) {
                colorStateListG2 = baVarA3.g(androidx.appcompat.a.m.TextAppearance_android_textColor);
            }
            if (baVarA3.j(androidx.appcompat.a.m.TextAppearance_android_textColorHint)) {
                colorStateListG = baVarA3.g(androidx.appcompat.a.m.TextAppearance_android_textColorHint);
            }
            if (baVarA3.j(androidx.appcompat.a.m.TextAppearance_android_textColorLink)) {
                colorStateListG3 = baVarA3.g(androidx.appcompat.a.m.TextAppearance_android_textColorLink);
            }
        }
        if (baVarA3.j(androidx.appcompat.a.m.TextAppearance_textLocale)) {
            strE2 = baVarA3.e(androidx.appcompat.a.m.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && baVarA3.j(androidx.appcompat.a.m.TextAppearance_fontVariationSettings)) {
            strE = baVarA3.e(androidx.appcompat.a.m.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && baVarA3.j(androidx.appcompat.a.m.TextAppearance_android_textSize) && baVarA3.e(androidx.appcompat.a.m.TextAppearance_android_textSize, -1) == 0) {
            this.e.setTextSize(0, 0.0f);
        }
        a(context, baVarA3);
        baVarA3.f();
        if (colorStateListG2 != null) {
            this.e.setTextColor(colorStateListG2);
        }
        if (colorStateListG != null) {
            this.e.setHintTextColor(colorStateListG);
        }
        if (colorStateListG3 != null) {
            this.e.setLinkTextColor(colorStateListG3);
        }
        if (!z3 && z2) {
            a(zA);
        }
        if (this.p != null) {
            if (this.o == -1) {
                this.e.setTypeface(this.p, this.n);
            } else {
                this.e.setTypeface(this.p);
            }
        }
        if (strE != null) {
            this.e.setFontVariationSettings(strE);
        }
        if (strE2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.e.setTextLocales(LocaleList.forLanguageTags(strE2));
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.e.setTextLocale(Locale.forLanguageTag(strE2.substring(0, strE2.indexOf(44))));
            }
        }
        this.m.a(attributeSet, i);
        if (androidx.core.widget.b.d && this.m.a() != 0) {
            int[] iArrE = this.m.e();
            if (iArrE.length > 0) {
                if (this.e.getAutoSizeStepGranularity() != -1.0f) {
                    this.e.setAutoSizeTextTypeUniformWithConfiguration(this.m.c(), this.m.d(), this.m.b(), 0);
                } else {
                    this.e.setAutoSizeTextTypeUniformWithPresetSizes(iArrE, 0);
                }
            }
        }
        ba baVarA4 = ba.a(context, attributeSet, androidx.appcompat.a.m.AppCompatTextView);
        int iG2 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableA = iG2 != -1 ? kVarB.a(context, iG2) : null;
        int iG3 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableA2 = iG3 != -1 ? kVarB.a(context, iG3) : null;
        int iG4 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableA3 = iG4 != -1 ? kVarB.a(context, iG4) : null;
        int iG5 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableA4 = iG5 != -1 ? kVarB.a(context, iG5) : null;
        int iG6 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableA5 = iG6 != -1 ? kVarB.a(context, iG6) : null;
        int iG7 = baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableEndCompat, -1);
        a(drawableA, drawableA2, drawableA3, drawableA4, drawableA5, iG7 != -1 ? kVarB.a(context, iG7) : null);
        if (baVarA4.j(androidx.appcompat.a.m.AppCompatTextView_drawableTint)) {
            androidx.core.widget.m.a(this.e, baVarA4.g(androidx.appcompat.a.m.AppCompatTextView_drawableTint));
        }
        if (baVarA4.j(androidx.appcompat.a.m.AppCompatTextView_drawableTintMode)) {
            i2 = -1;
            androidx.core.widget.m.a(this.e, af.a(baVarA4.a(androidx.appcompat.a.m.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i2 = -1;
        }
        int iE = baVarA4.e(androidx.appcompat.a.m.AppCompatTextView_firstBaselineToTopHeight, i2);
        int iE2 = baVarA4.e(androidx.appcompat.a.m.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int iE3 = baVarA4.e(androidx.appcompat.a.m.AppCompatTextView_lineHeight, i2);
        baVarA4.f();
        if (iE != i2) {
            androidx.core.widget.m.c(this.e, iE);
        }
        if (iE2 != i2) {
            androidx.core.widget.m.d(this.e, iE2);
        }
        if (iE3 != i2) {
            androidx.core.widget.m.e(this.e, iE3);
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.q) {
            this.p = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.n);
            }
        }
    }

    void a(boolean z) {
        this.e.setAllCaps(z);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    void a(boolean z, int i, int i2, int i3, int i4) {
        if (androidx.core.widget.b.d) {
            return;
        }
        c();
    }

    void a(@androidx.annotation.ah int[] iArr, int i) {
        this.m.a(iArr, i);
    }

    void b() {
        if (this.f != null || this.g != null || this.h != null || this.i != null) {
            Drawable[] compoundDrawables = this.e.getCompoundDrawables();
            a(compoundDrawables[0], this.f);
            a(compoundDrawables[1], this.g);
            a(compoundDrawables[2], this.h);
            a(compoundDrawables[3], this.i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.j == null && this.k == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.e.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.j);
            a(compoundDrawablesRelative[2], this.k);
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    void c() {
        this.m.f();
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    boolean d() {
        return this.m.g();
    }

    int e() {
        return this.m.a();
    }

    int f() {
        return this.m.b();
    }

    int g() {
        return this.m.c();
    }

    int h() {
        return this.m.d();
    }

    int[] i() {
        return this.m.e();
    }

    @androidx.annotation.ai
    ColorStateList j() {
        if (this.l != null) {
            return this.l.f241a;
        }
        return null;
    }

    @androidx.annotation.ai
    PorterDuff.Mode k() {
        if (this.l != null) {
            return this.l.b;
        }
        return null;
    }
}
