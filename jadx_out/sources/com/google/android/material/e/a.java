package com.google.android.material.e;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.k;
import androidx.annotation.m;
import androidx.annotation.p;
import androidx.annotation.q;
import androidx.annotation.r;
import com.google.android.material.t.o;
import com.google.android.material.t.s;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.b.a.a implements Checkable, s {
    private static final int[] e = {R.attr.state_checkable};
    private static final int[] f = {R.attr.state_checked};
    private static final int[] g = {com.google.android.material.a.c.state_dragged};
    private static final int h = com.google.android.material.a.n.Widget_MaterialComponents_CardView;
    private static final String i = "MaterialCardView";
    private static final String j = "androidx.cardview.widget.CardView";

    @ah
    private final b k;
    private boolean l;
    private boolean m;
    private boolean n;
    private InterfaceC0087a o;

    /* JADX INFO: renamed from: com.google.android.material.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0087a {
        void a(a aVar, boolean z);
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.materialCardViewStyle);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, h), attributeSet, i2);
        this.m = false;
        this.n = false;
        this.l = true;
        TypedArray typedArrayA = com.google.android.material.internal.s.a(getContext(), attributeSet, com.google.android.material.a.o.MaterialCardView, i2, h, new int[0]);
        this.k = new b(this, attributeSet, i2, h);
        this.k.b(super.getCardBackgroundColor());
        this.k.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.k.a(typedArrayA);
        typedArrayA.recycle();
    }

    private void c() {
        if (Build.VERSION.SDK_INT > 26) {
            this.k.t();
        }
    }

    @ah
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.k.e().getBounds());
        return rectF;
    }

    @Override // androidx.b.a.a
    public void a(int i2, int i3, int i4, int i5) {
        this.k.a(i2, i3, i4, i5);
    }

    void b(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
    }

    public boolean e_() {
        return this.n;
    }

    public boolean f_() {
        return this.k != null && this.k.p();
    }

    @Override // androidx.b.a.a
    @ah
    public ColorStateList getCardBackgroundColor() {
        return this.k.f();
    }

    @ah
    public ColorStateList getCardForegroundColor() {
        return this.k.g();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    @ai
    public Drawable getCheckedIcon() {
        return this.k.s();
    }

    @ai
    public ColorStateList getCheckedIconTint() {
        return this.k.q();
    }

    @Override // androidx.b.a.a
    public int getContentPaddingBottom() {
        return this.k.h().bottom;
    }

    @Override // androidx.b.a.a
    public int getContentPaddingLeft() {
        return this.k.h().left;
    }

    @Override // androidx.b.a.a
    public int getContentPaddingRight() {
        return this.k.h().right;
    }

    @Override // androidx.b.a.a
    public int getContentPaddingTop() {
        return this.k.h().top;
    }

    @r(a = 0.0d, b = 1.0d)
    public float getProgress() {
        return this.k.k();
    }

    @Override // androidx.b.a.a
    public float getRadius() {
        return this.k.j();
    }

    public ColorStateList getRippleColor() {
        return this.k.r();
    }

    @Override // com.google.android.material.t.s
    @ah
    public o getShapeAppearanceModel() {
        return this.k.u();
    }

    @k
    @Deprecated
    public int getStrokeColor() {
        return this.k.b();
    }

    @ai
    public ColorStateList getStrokeColorStateList() {
        return this.k.c();
    }

    @p
    public int getStrokeWidth() {
        return this.k.d();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.t.k.a(this, this.k.e());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (f_()) {
            mergeDrawableStates(iArrOnCreateDrawableState, e);
        }
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f);
        }
        if (e_()) {
            mergeDrawableStates(iArrOnCreateDrawableState, g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@ah AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(j);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(j);
        accessibilityNodeInfo.setCheckable(f_());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.b.a.a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.k.a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.l) {
            if (!this.k.a()) {
                Log.i(i, "Setting a custom background is not supported.");
                this.k.a(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.b.a.a
    public void setCardBackgroundColor(@k int i2) {
        this.k.b(ColorStateList.valueOf(i2));
    }

    @Override // androidx.b.a.a
    public void setCardBackgroundColor(@ai ColorStateList colorStateList) {
        this.k.b(colorStateList);
    }

    @Override // androidx.b.a.a
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.k.l();
    }

    public void setCardForegroundColor(@ai ColorStateList colorStateList) {
        this.k.c(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.k.b(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.m != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@ai Drawable drawable) {
        this.k.a(drawable);
    }

    public void setCheckedIconResource(@q int i2) {
        this.k.a(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setCheckedIconTint(@ai ColorStateList colorStateList) {
        this.k.e(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.k != null) {
            this.k.i();
        }
    }

    public void setDragged(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
            c();
            invalidate();
        }
    }

    @Override // androidx.b.a.a
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.k.m();
    }

    public void setOnCheckedChangeListener(@ai InterfaceC0087a interfaceC0087a) {
        this.o = interfaceC0087a;
    }

    @Override // androidx.b.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.k.m();
        this.k.o();
    }

    public void setProgress(@r(a = 0.0d, b = 1.0d) float f2) {
        this.k.b(f2);
    }

    @Override // androidx.b.a.a
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.k.a(f2);
    }

    public void setRippleColor(@ai ColorStateList colorStateList) {
        this.k.d(colorStateList);
    }

    public void setRippleColorResource(@m int i2) {
        this.k.d(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    @Override // com.google.android.material.t.s
    public void setShapeAppearanceModel(@ah o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(oVar.a(getBoundsAsRectF()));
        }
        this.k.a(oVar);
    }

    public void setStrokeColor(@k int i2) {
        this.k.a(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.k.a(colorStateList);
    }

    public void setStrokeWidth(@p int i2) {
        this.k.a(i2);
    }

    @Override // androidx.b.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.k.m();
        this.k.o();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (f_() && isEnabled()) {
            this.m = !this.m;
            refreshDrawableState();
            c();
            if (this.o != null) {
                this.o.a(this, this.m);
            }
        }
    }
}
