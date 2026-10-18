package androidx.b.a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.k;

/* JADX INFO: loaded from: classes.dex */
public class a extends FrameLayout {
    private static final int[] e = {R.attr.colorBackground};
    private static final f f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f299a;
    int b;
    final Rect c;
    final Rect d;
    private boolean g;
    private boolean h;
    private final e i;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f = new c();
        } else if (Build.VERSION.SDK_INT >= 17) {
            f = new b();
        } else {
            f = new d();
        }
        f.a();
    }

    public a(@ah Context context) {
        this(context, null);
    }

    public a(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.b.a.C0020a.cardViewStyle);
    }

    public a(@ah Context context, @ai AttributeSet attributeSet, int i) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        this.c = new Rect();
        this.d = new Rect();
        this.i = new e() { // from class: androidx.b.a.a.1
            private Drawable b;

            @Override // androidx.b.a.e
            public void a(int i2, int i3) {
                if (i2 > a.this.f299a) {
                    a.super.setMinimumWidth(i2);
                }
                if (i3 > a.this.b) {
                    a.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.b.a.e
            public void a(int i2, int i3, int i4, int i5) {
                a.this.d.set(i2, i3, i4, i5);
                a.super.setPadding(i2 + a.this.c.left, i3 + a.this.c.top, i4 + a.this.c.right, i5 + a.this.c.bottom);
            }

            @Override // androidx.b.a.e
            public void a(Drawable drawable) {
                this.b = drawable;
                a.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.b.a.e
            public boolean a() {
                return a.this.getUseCompatPadding();
            }

            @Override // androidx.b.a.e
            public boolean b() {
                return a.this.getPreventCornerOverlap();
            }

            @Override // androidx.b.a.e
            public Drawable c() {
                return this.b;
            }

            @Override // androidx.b.a.e
            public View d() {
                return a.this;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.b.a.e.CardView, i, androidx.b.a.d.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(androidx.b.a.e.CardView_cardBackgroundColor)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(androidx.b.a.e.CardView_cardBackgroundColor);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(e);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(androidx.b.a.b.cardview_light_background) : getResources().getColor(androidx.b.a.b.cardview_dark_background));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.b.a.e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.b.a.e.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.b.a.e.CardView_cardMaxElevation, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getBoolean(androidx.b.a.e.CardView_cardUseCompatPadding, false);
        this.h = typedArrayObtainStyledAttributes.getBoolean(androidx.b.a.e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_contentPadding, 0);
        this.c.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.c.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_contentPaddingTop, dimensionPixelSize);
        this.c.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_contentPaddingRight, dimensionPixelSize);
        this.c.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f299a = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_android_minWidth, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.b.a.e.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f.a(this.i, context, colorStateList, dimension, dimension2, f2);
    }

    public void a(@ak int i, @ak int i2, @ak int i3, @ak int i4) {
        this.c.set(i, i2, i3, i4);
        f.f(this.i);
    }

    @ah
    public ColorStateList getCardBackgroundColor() {
        return f.i(this.i);
    }

    public float getCardElevation() {
        return f.e(this.i);
    }

    @ak
    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    @ak
    public int getContentPaddingLeft() {
        return this.c.left;
    }

    @ak
    public int getContentPaddingRight() {
        return this.c.right;
    }

    @ak
    public int getContentPaddingTop() {
        return this.c.top;
    }

    public float getMaxCardElevation() {
        return f.a(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public float getRadius() {
        return f.d(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (f instanceof c) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f.b(this.i)), View.MeasureSpec.getSize(i)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f.c(this.i)), View.MeasureSpec.getSize(i2)), mode2);
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(@k int i) {
        f.a(this.i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(@ai ColorStateList colorStateList) {
        f.a(this.i, colorStateList);
    }

    public void setCardElevation(float f2) {
        f.c(this.i, f2);
    }

    public void setMaxCardElevation(float f2) {
        f.b(this.i, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.b = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f299a = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            f.h(this.i);
        }
    }

    public void setRadius(float f2) {
        f.a(this.i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            f.g(this.i);
        }
    }
}
