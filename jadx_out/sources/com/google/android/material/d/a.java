package com.google.android.material.d;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class a {
    private a() {
    }

    public static int a(@ah Canvas canvas, float f, float f2, float f3, float f4, int i) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f, f2, f3, f4, i) : canvas.saveLayerAlpha(f, f2, f3, f4, i, 31);
    }

    public static int a(@ah Canvas canvas, @ai RectF rectF, int i) {
        return Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(rectF, i) : canvas.saveLayerAlpha(rectF, i, 31);
    }
}
