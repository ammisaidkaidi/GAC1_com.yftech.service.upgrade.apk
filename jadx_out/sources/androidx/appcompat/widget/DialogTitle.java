package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class DialogTitle extends aa {
    public DialogTitle(@androidx.annotation.ah Context context) {
        super(context);
    }

    public DialogTitle(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DialogTitle(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.appcompat.widget.aa, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int lineCount;
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
            return;
        }
        setSingleLine(false);
        setMaxLines(2);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, androidx.appcompat.a.m.TextAppearance, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.a.m.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
        super.onMeasure(i, i2);
    }
}
