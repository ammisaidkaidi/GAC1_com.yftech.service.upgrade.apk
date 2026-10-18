package com.google.android.material.i;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.f;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class c {
    private c() {
    }

    @ah
    public static Rect a(@ah Context context, @f int i, int i2) {
        TypedArray typedArrayA = s.a(context, null, com.google.android.material.a.o.MaterialAlertDialog, i, i2, new int[0]);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(com.google.android.material.a.f.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(com.google.android.material.a.f.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(com.google.android.material.a.f.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(com.google.android.material.a.f.mtrl_alert_dialog_background_inset_bottom));
        typedArrayA.recycle();
        if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    @ah
    public static InsetDrawable a(@ai Drawable drawable, @ah Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
