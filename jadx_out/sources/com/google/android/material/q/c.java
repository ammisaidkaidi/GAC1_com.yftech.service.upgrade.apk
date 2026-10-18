package com.google.android.material.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.au;
import androidx.appcompat.widget.ba;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class c {
    private c() {
    }

    public static int a(@ah Context context, @ah TypedArray typedArray, @au int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @au
    static int a(@ah TypedArray typedArray, @au int i, @au int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    @ai
    public static ColorStateList a(@ah Context context, @ah TypedArray typedArray, @au int i) {
        int color;
        int resourceId;
        ColorStateList colorStateListA;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListA = androidx.appcompat.a.a.a.a(context, resourceId)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i, -1)) == -1) ? typedArray.getColorStateList(i) : ColorStateList.valueOf(color);
        }
        return colorStateListA;
    }

    @ai
    public static ColorStateList a(@ah Context context, @ah ba baVar, @au int i) {
        int iB;
        int iG;
        ColorStateList colorStateListA;
        if (!baVar.j(i) || (iG = baVar.g(i, 0)) == 0 || (colorStateListA = androidx.appcompat.a.a.a.a(context, iG)) == null) {
            return (Build.VERSION.SDK_INT > 15 || (iB = baVar.b(i, -1)) == -1) ? baVar.g(i) : ColorStateList.valueOf(iB);
        }
        return colorStateListA;
    }

    @ai
    public static Drawable b(@ah Context context, @ah TypedArray typedArray, @au int i) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableB = androidx.appcompat.a.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableB;
    }

    @ai
    public static d c(@ah Context context, @ah TypedArray typedArray, @au int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }
}
