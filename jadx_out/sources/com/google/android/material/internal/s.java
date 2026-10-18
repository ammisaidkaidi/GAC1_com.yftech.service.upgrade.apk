package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.at;
import androidx.annotation.au;
import androidx.appcompat.widget.ba;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public final class s {
    private static final String b = "Theme.AppCompat";
    private static final String d = "Theme.MaterialComponents";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1351a = {com.google.android.material.a.c.colorPrimary};
    private static final int[] c = {com.google.android.material.a.c.colorPrimaryVariant};

    private s() {
    }

    @ah
    public static TypedArray a(@ah Context context, AttributeSet attributeSet, @au @ah int[] iArr, @androidx.annotation.f int i, @at int i2, @au int... iArr2) {
        a(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static void a(@ah Context context) {
        a(context, f1351a, b);
    }

    private static void a(@ah Context context, AttributeSet attributeSet, @androidx.annotation.f int i, @at int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.ThemeEnforcement, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.a.o.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(com.google.android.material.a.c.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                b(context);
            }
        }
        a(context);
    }

    private static void a(@ah Context context, @ah int[] iArr, String str) {
        if (a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean a(@ah Context context, @ah int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static ba b(@ah Context context, AttributeSet attributeSet, @au @ah int[] iArr, @androidx.annotation.f int i, @at int i2, @au int... iArr2) {
        a(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return ba.a(context, attributeSet, iArr, i, i2);
    }

    public static void b(@ah Context context) {
        a(context, c, d);
    }

    private static void c(@ah Context context, AttributeSet attributeSet, @au @ah int[] iArr, @androidx.annotation.f int i, @at int i2, @ai @au int... iArr2) {
        boolean zD;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.ThemeEnforcement, i, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.a.o.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zD = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zD = d(context, attributeSet, iArr, i, i2, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zD) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static boolean c(@ah Context context) {
        return a(context, f1351a);
    }

    public static boolean d(@ah Context context) {
        return a(context, c);
    }

    private static boolean d(@ah Context context, AttributeSet attributeSet, @au @ah int[] iArr, @androidx.annotation.f int i, @at int i2, @au @ah int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }
}
