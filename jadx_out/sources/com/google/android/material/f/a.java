package com.google.android.material.f;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ai;
import androidx.appcompat.widget.h;
import androidx.core.widget.c;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes.dex */
public class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1282a = com.google.android.material.a.n.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] b = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @ai
    private ColorStateList c;
    private boolean d;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.checkboxStyle);
    }

    public a(Context context, @ai AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, f1282a), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, com.google.android.material.a.o.MaterialCheckBox, i, f1282a, new int[0]);
        if (typedArrayA.hasValue(com.google.android.material.a.o.MaterialCheckBox_buttonTint)) {
            c.a(this, com.google.android.material.q.c.a(context2, typedArrayA, com.google.android.material.a.o.MaterialCheckBox_buttonTint));
        }
        this.d = typedArrayA.getBoolean(com.google.android.material.a.o.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayA.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.c == null) {
            int[] iArr = new int[b.length];
            int iA = com.google.android.material.h.a.a(this, com.google.android.material.a.c.colorControlActivated);
            int iA2 = com.google.android.material.h.a.a(this, com.google.android.material.a.c.colorSurface);
            int iA3 = com.google.android.material.h.a.a(this, com.google.android.material.a.c.colorOnSurface);
            iArr[0] = com.google.android.material.h.a.a(iA2, iA, 1.0f);
            iArr[1] = com.google.android.material.h.a.a(iA2, iA3, 0.54f);
            iArr[2] = com.google.android.material.h.a.a(iA2, iA3, 0.38f);
            iArr[3] = com.google.android.material.h.a.a(iA2, iA3, 0.38f);
            this.c = new ColorStateList(b, iArr);
        }
        return this.c;
    }

    public boolean a() {
        return this.d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d && c.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.d = z;
        if (z) {
            c.a(this, getMaterialThemeColorsTintList());
        } else {
            c.a(this, (ColorStateList) null);
        }
    }
}
