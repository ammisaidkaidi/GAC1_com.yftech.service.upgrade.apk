package com.google.android.material.h;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.f;
import androidx.annotation.k;
import androidx.annotation.r;
import androidx.annotation.z;
import androidx.core.graphics.e;
import com.google.android.material.q.b;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f1320a = 1.0f;
    public static final float b = 0.54f;
    public static final float c = 0.38f;
    public static final float d = 0.32f;
    public static final float e = 0.12f;

    private a() {
    }

    @k
    public static int a(@k int i, @k int i2) {
        return e.a(i2, i);
    }

    @k
    public static int a(@k int i, @k int i2, @r(a = 0.0d, b = 1.0d) float f) {
        return a(i, e.c(i2, Math.round(Color.alpha(i2) * f)));
    }

    @k
    public static int a(@ah Context context, @f int i, @k int i2) {
        TypedValue typedValueA = b.a(context, i);
        return typedValueA != null ? typedValueA.data : i2;
    }

    @k
    public static int a(Context context, @f int i, String str) {
        return b.a(context, i, str);
    }

    @k
    public static int a(@ah View view, @f int i) {
        return b.a(view, i);
    }

    @k
    public static int a(@ah View view, @f int i, @k int i2) {
        return a(view.getContext(), i, i2);
    }

    @k
    public static int a(@ah View view, @f int i, @f int i2, @r(a = 0.0d, b = 1.0d) float f) {
        return a(a(view, i), a(view, i2), f);
    }

    @k
    public static int b(@k int i, @z(a = FabTransformationScrimBehavior.c, b = 255) int i2) {
        return e.c(i, (Color.alpha(i) * i2) / 255);
    }

    @k
    public static int b(@ah View view, @f int i, @f int i2) {
        return a(view, i, i2, 1.0f);
    }
}
