package com.google.android.material.theme.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.at;
import androidx.annotation.f;
import androidx.appcompat.view.d;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1469a = {R.attr.theme, com.google.android.material.a.c.theme};
    private static final int[] b = {com.google.android.material.a.c.materialThemeOverlay};

    private a() {
    }

    @at
    private static int a(@ah Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1469a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @ah
    public static Context a(@ah Context context, @ai AttributeSet attributeSet, @f int i, @at int i2) {
        int iB = b(context, attributeSet, i, i2);
        boolean z = (context instanceof d) && ((d) context).getThemeResId() == iB;
        if (iB == 0 || z) {
            return context;
        }
        d dVar = new d(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            dVar.getTheme().applyStyle(iA, true);
        }
        return dVar;
    }

    @at
    private static int b(@ah Context context, @ai AttributeSet attributeSet, @f int i, @at int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }
}
