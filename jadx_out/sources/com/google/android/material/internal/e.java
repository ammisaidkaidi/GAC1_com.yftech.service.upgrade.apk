package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.n.af;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class e extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1333a;
    private int b;
    private boolean c;
    private int d;

    public e(@ah Context context) {
        this(context, null);
    }

    public e(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        a(context, attributeSet);
    }

    @TargetApi(21)
    public e(@ah Context context, @ai AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = false;
        a(context, attributeSet);
    }

    private static int a(int i, int i2, int i3) {
        if (i2 != Integer.MIN_VALUE) {
            return i2 != 1073741824 ? i3 : i;
        }
        return Math.min(i3, i);
    }

    private void a(@ah Context context, @ai AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.material.a.o.FlowLayout, 0, 0);
        this.f1333a = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.a.o.FlowLayout_lineSpacing, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.google.android.material.a.o.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int b(@ah View view) {
        Object tag = view.getTag(com.google.android.material.a.h.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean b() {
        return this.c;
    }

    protected int getItemSpacing() {
        return this.b;
    }

    protected int getLineSpacing() {
        return this.f1333a;
    }

    protected int getRowCount() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iB;
        int iA;
        if (getChildCount() == 0) {
            this.d = 0;
            return;
        }
        this.d = 1;
        boolean z2 = af.p(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i5 = (i3 - i) - paddingLeft;
        int measuredWidth = paddingRight;
        int i6 = paddingTop;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(com.google.android.material.a.h.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iA = androidx.core.n.m.a(marginLayoutParams);
                    iB = androidx.core.n.m.b(marginLayoutParams);
                } else {
                    iB = 0;
                    iA = 0;
                }
                int measuredWidth2 = measuredWidth + iA + childAt.getMeasuredWidth();
                if (!this.c && measuredWidth2 > i5) {
                    i6 = paddingTop + this.f1333a;
                    this.d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(com.google.android.material.a.h.row_index_key, Integer.valueOf(this.d - 1));
                int i8 = measuredWidth + iA;
                int measuredWidth3 = childAt.getMeasuredWidth() + i8;
                int measuredHeight = childAt.getMeasuredHeight() + i6;
                if (z2) {
                    childAt.layout(i5 - measuredWidth3, i6, (i5 - measuredWidth) - iA, measuredHeight);
                } else {
                    childAt.layout(i8, i6, measuredWidth3, measuredHeight);
                }
                measuredWidth += iA + iB + childAt.getMeasuredWidth() + this.b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : ActivityChooserView.a.f166a;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i5 - getPaddingRight();
        int i6 = paddingLeft;
        int i7 = paddingTop;
        int i8 = i7;
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i3 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                int i11 = i6;
                if (i6 + i3 + childAt.getMeasuredWidth() > paddingRight && !b()) {
                    int paddingLeft2 = getPaddingLeft();
                    i8 = this.f1333a + i7;
                    i11 = paddingLeft2;
                }
                int measuredWidth = i11 + i3 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                if (measuredWidth > i9) {
                    i9 = measuredWidth;
                }
                int measuredWidth2 = i11 + i3 + i4 + childAt.getMeasuredWidth() + this.b;
                if (i10 == getChildCount() - 1) {
                    i9 += i4;
                }
                i7 = measuredHeight;
                i6 = measuredWidth2;
            }
        }
        setMeasuredDimension(a(size, mode, i9 + getPaddingRight()), a(size2, mode2, i7 + getPaddingBottom()));
    }

    protected void setItemSpacing(int i) {
        this.b = i;
    }

    protected void setLineSpacing(int i) {
        this.f1333a = i;
    }

    public void setSingleLine(boolean z) {
        this.c = z;
    }
}
