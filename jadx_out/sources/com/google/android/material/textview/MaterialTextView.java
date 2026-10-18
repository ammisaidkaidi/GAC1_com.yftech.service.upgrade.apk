package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.au;
import androidx.appcompat.widget.aa;
import com.google.android.material.q.b;
import com.google.android.material.q.c;
import com.google.android.material.theme.a.a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends aa {
    public MaterialTextView(@ah Context context) {
        this(context, null);
    }

    public MaterialTextView(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(@ah Context context, @ai AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MaterialTextView(@ah Context context, @ai AttributeSet attributeSet, int i, int i2) {
        int iA;
        super(a.a(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        if (a(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (a(context2, theme, attributeSet, i, i2) || (iA = a(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            a(theme, iA);
        }
    }

    private static int a(@ah Context context, @ah TypedArray typedArray, @au @ah int... iArr) {
        int iA = -1;
        for (int i = 0; i < iArr.length && iA < 0; i++) {
            iA = c.a(context, typedArray, iArr[i], -1);
        }
        return iA;
    }

    private static int a(@ah Resources.Theme theme, @ai AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.MaterialTextView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialTextView_android_textAppearance, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void a(@ah Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, com.google.android.material.a.o.MaterialTextAppearance);
        int iA = a(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialTextAppearance_android_lineHeight, com.google.android.material.a.o.MaterialTextAppearance_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        if (iA >= 0) {
            setLineHeight(iA);
        }
    }

    private static boolean a(Context context) {
        return b.a(context, com.google.android.material.a.c.textAppearanceLineHeightEnabled, true);
    }

    private static boolean a(@ah Context context, @ah Resources.Theme theme, @ai AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.MaterialTextView, i, i2);
        int iA = a(context, typedArrayObtainStyledAttributes, com.google.android.material.a.o.MaterialTextView_android_lineHeight, com.google.android.material.a.o.MaterialTextView_lineHeight);
        typedArrayObtainStyledAttributes.recycle();
        return iA != -1;
    }

    @Override // androidx.appcompat.widget.aa, android.widget.TextView
    public void setTextAppearance(@ah Context context, int i) {
        super.setTextAppearance(context, i);
        if (a(context)) {
            a(context.getTheme(), i);
        }
    }
}
