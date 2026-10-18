package com.google.android.material.q;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.ap;
import androidx.annotation.o;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class b {
    @ak
    public static int a(@ah Context context) {
        return a(context, com.google.android.material.a.c.minTouchTargetSize, com.google.android.material.a.f.mtrl_min_touch_target_size);
    }

    @ak
    public static int a(@ah Context context, @androidx.annotation.f int i, @o int i2) {
        TypedValue typedValueA = a(context, i);
        return (typedValueA == null || typedValueA.type != 5) ? (int) context.getResources().getDimension(i2) : (int) typedValueA.getDimension(context.getResources().getDisplayMetrics());
    }

    public static int a(@ah Context context, @androidx.annotation.f int i, @ah String str) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA != null) {
            return typedValueA.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int a(@ah View view, @androidx.annotation.f int i) {
        return a(view.getContext(), i, view.getClass().getCanonicalName());
    }

    @ai
    public static TypedValue a(@ah Context context, @androidx.annotation.f int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean a(@ah Context context, @androidx.annotation.f int i, boolean z) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA == null || typedValueA.type != 18) {
            return z;
        }
        return typedValueA.data != 0;
    }

    public static boolean b(@ah Context context, @androidx.annotation.f int i, @ah String str) {
        return a(context, i, str) != 0;
    }
}
