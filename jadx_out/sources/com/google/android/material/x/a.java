package com.google.android.material.x;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ba;

/* JADX INFO: loaded from: classes.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f1489a;
    public final Drawable b;
    public final int c;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ba baVarA = ba.a(context, attributeSet, com.google.android.material.a.o.TabItem);
        this.f1489a = baVarA.d(com.google.android.material.a.o.TabItem_android_text);
        this.b = baVarA.a(com.google.android.material.a.o.TabItem_android_icon);
        this.c = baVarA.g(com.google.android.material.a.o.TabItem_android_layout, 0);
        baVarA.f();
    }
}
