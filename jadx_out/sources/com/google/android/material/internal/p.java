package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1346a = "android.text.TextDirectionHeuristic";
    private static final String b = "android.text.TextDirectionHeuristics";
    private static final String c = "LTR";
    private static final String d = "RTL";
    private static boolean e;

    @ai
    private static Constructor<StaticLayout> f;

    @ai
    private static Object g;
    private CharSequence h;
    private final TextPaint i;
    private final int j;
    private int l;
    private boolean p;
    private int k = 0;
    private Layout.Alignment m = Layout.Alignment.ALIGN_NORMAL;
    private int n = ActivityChooserView.a.f166a;
    private boolean o = true;

    @ai
    private TextUtils.TruncateAt q = null;

    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private p(CharSequence charSequence, TextPaint textPaint, int i) {
        this.h = charSequence;
        this.i = textPaint;
        this.j = i;
        this.l = charSequence.length();
    }

    @ah
    public static p a(@ah CharSequence charSequence, @ah TextPaint textPaint, @androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
        return new p(charSequence, textPaint, i);
    }

    private void b() throws a {
        Class<?> cls;
        if (e) {
            return;
        }
        try {
            boolean z = this.p && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                g = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = p.class.getClassLoader();
                String str = this.p ? d : c;
                Class<?> clsLoadClass = classLoader.loadClass(f1346a);
                Class<?> clsLoadClass2 = classLoader.loadClass(b);
                g = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            f = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            f.setAccessible(true);
            e = true;
        } catch (Exception e2) {
            throw new a(e2);
        }
    }

    public StaticLayout a() throws a {
        if (this.h == null) {
            this.h = com.yftech.service.upgrade.a.d;
        }
        int iMax = Math.max(0, this.j);
        CharSequence charSequenceEllipsize = this.h;
        if (this.n == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(this.h, this.i, iMax, this.q);
        }
        this.l = Math.min(charSequenceEllipsize.length(), this.l);
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) androidx.core.m.i.a(f)).newInstance(charSequenceEllipsize, Integer.valueOf(this.k), Integer.valueOf(this.l), this.i, Integer.valueOf(iMax), this.m, androidx.core.m.i.a(g), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.o), null, Integer.valueOf(iMax), Integer.valueOf(this.n));
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        if (this.p) {
            this.m = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.k, this.l, this.i, iMax);
        builderObtain.setAlignment(this.m);
        builderObtain.setIncludePad(this.o);
        builderObtain.setTextDirection(this.p ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        if (this.q != null) {
            builderObtain.setEllipsize(this.q);
        }
        builderObtain.setMaxLines(this.n);
        return builderObtain.build();
    }

    @ah
    public p a(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
        this.k = i;
        return this;
    }

    @ah
    public p a(@ah Layout.Alignment alignment) {
        this.m = alignment;
        return this;
    }

    @ah
    public p a(@ai TextUtils.TruncateAt truncateAt) {
        this.q = truncateAt;
        return this;
    }

    @ah
    public p a(boolean z) {
        this.o = z;
        return this;
    }

    @ah
    public p b(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
        this.l = i;
        return this;
    }

    public p b(boolean z) {
        this.p = z;
        return this;
    }

    @ah
    public p c(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
        this.n = i;
        return this;
    }
}
