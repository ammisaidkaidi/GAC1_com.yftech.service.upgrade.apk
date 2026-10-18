package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.at;
import androidx.core.n.af;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    private final Rect f1239a;
    private final ColorStateList b;
    private final ColorStateList c;
    private final ColorStateList d;
    private final int e;
    private final com.google.android.material.t.o f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, com.google.android.material.t.o oVar, @ah Rect rect) {
        androidx.core.m.i.a(rect.left);
        androidx.core.m.i.a(rect.top);
        androidx.core.m.i.a(rect.right);
        androidx.core.m.i.a(rect.bottom);
        this.f1239a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = oVar;
    }

    @ah
    static b a(@ah Context context, @at int i) {
        androidx.core.m.i.a(i != 0, (Object) "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.a.o.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.a.o.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.a.o.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.a.o.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.a.o.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = com.google.android.material.q.c.a(context, typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = com.google.android.material.q.c.a(context, typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = com.google.android.material.q.c.a(context, typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.a.o.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.t.o oVarA = com.google.android.material.t.o.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, oVarA, rect);
    }

    int a() {
        return this.f1239a.left;
    }

    void a(@ah TextView textView) {
        com.google.android.material.t.j jVar = new com.google.android.material.t.j();
        com.google.android.material.t.j jVar2 = new com.google.android.material.t.j();
        jVar.setShapeAppearanceModel(this.f);
        jVar2.setShapeAppearanceModel(this.f);
        jVar.g(this.c);
        jVar.a(this.e, this.d);
        textView.setTextColor(this.b);
        af.a(textView, new InsetDrawable(Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.b.withAlpha(30), jVar, jVar2) : jVar, this.f1239a.left, this.f1239a.top, this.f1239a.right, this.f1239a.bottom));
    }

    int b() {
        return this.f1239a.right;
    }

    int c() {
        return this.f1239a.top;
    }

    int d() {
        return this.f1239a.bottom;
    }
}
