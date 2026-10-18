package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    final b f1240a;

    @ah
    final b b;

    @ah
    final b c;

    @ah
    final b d;

    @ah
    final b e;

    @ah
    final b f;

    @ah
    final b g;

    @ah
    final Paint h;

    c(@ah Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.q.b.a(context, com.google.android.material.a.c.materialCalendarStyle, k.class.getCanonicalName()), com.google.android.material.a.o.MaterialCalendar);
        this.f1240a = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_dayInvalidStyle, 0));
        this.b = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_daySelectedStyle, 0));
        this.c = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = com.google.android.material.q.c.a(context, typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialCalendar_rangeFillColor);
        this.d = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_yearStyle, 0));
        this.e = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialCalendar_yearTodayStyle, 0));
        this.h = new Paint();
        this.h.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
