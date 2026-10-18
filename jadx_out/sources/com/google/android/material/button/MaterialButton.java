package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.annotation.q;
import androidx.appcompat.widget.g;
import androidx.core.n.af;
import androidx.core.widget.m;
import com.google.android.material.internal.z;
import com.google.android.material.t.k;
import com.google.android.material.t.o;
import com.google.android.material.t.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends g implements Checkable, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1209a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int e = 4;
    private static final String h = "MaterialButton";

    @ah
    private final com.google.android.material.button.a j;

    @ah
    private final LinkedHashSet<b> k;

    @ai
    private c l;

    @ai
    private PorterDuff.Mode m;

    @ai
    private ColorStateList n;

    @ai
    private Drawable o;

    @ak
    private int p;

    @ak
    private int q;

    @ak
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private static final int[] f = {R.attr.state_checkable};
    private static final int[] g = {R.attr.state_checked};
    private static final int i = com.google.android.material.a.n.Widget_MaterialComponents_Button;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    interface c {
        void a(MaterialButton materialButton, boolean z);
    }

    static class d extends androidx.f.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: com.google.android.material.button.MaterialButton.d.1
            @Override // android.os.Parcelable.Creator
            @ah
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(@ah Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @ah
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(@ah Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @ah
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1210a;

        public d(@ah Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@ah Parcel parcel) {
            this.f1210a = parcel.readInt() == 1;
        }

        @Override // androidx.f.a.a, android.os.Parcelable
        public void writeToParcel(@ah Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1210a ? 1 : 0);
        }
    }

    public MaterialButton(@ah Context context) {
        this(context, null);
    }

    public MaterialButton(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.materialButtonStyle);
    }

    public MaterialButton(@ah Context context, @ai AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, i), attributeSet, i2);
        this.k = new LinkedHashSet<>();
        this.s = false;
        this.t = false;
        Context context2 = getContext();
        TypedArray typedArrayA = com.google.android.material.internal.s.a(context2, attributeSet, com.google.android.material.a.o.MaterialButton, i2, i, new int[0]);
        this.r = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialButton_iconPadding, 0);
        this.m = z.a(typedArrayA.getInt(com.google.android.material.a.o.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.n = com.google.android.material.q.c.a(getContext(), typedArrayA, com.google.android.material.a.o.MaterialButton_iconTint);
        this.o = com.google.android.material.q.c.b(getContext(), typedArrayA, com.google.android.material.a.o.MaterialButton_icon);
        this.u = typedArrayA.getInteger(com.google.android.material.a.o.MaterialButton_iconGravity, 1);
        this.p = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.MaterialButton_iconSize, 0);
        this.j = new com.google.android.material.button.a(this, o.a(context2, attributeSet, i2, i).a());
        this.j.a(typedArrayA);
        typedArrayA.recycle();
        setCompoundDrawablePadding(this.r);
        a(this.o != null);
    }

    private void a(boolean z) {
        boolean z2 = false;
        if (this.o != null) {
            this.o = androidx.core.graphics.drawable.a.g(this.o).mutate();
            androidx.core.graphics.drawable.a.a(this.o, this.n);
            if (this.m != null) {
                androidx.core.graphics.drawable.a.a(this.o, this.m);
            }
            this.o.setBounds(this.q, 0, this.q + (this.p != 0 ? this.p : this.o.getIntrinsicWidth()), this.p != 0 ? this.p : this.o.getIntrinsicHeight());
        }
        boolean z3 = this.u == 1 || this.u == 2;
        if (z) {
            b(z3);
            return;
        }
        Drawable[] drawableArrC = m.c(this);
        Drawable drawable = drawableArrC[0];
        Drawable drawable2 = drawableArrC[2];
        if ((z3 && drawable != this.o) || (!z3 && drawable2 != this.o)) {
            z2 = true;
        }
        if (z2) {
            b(z3);
        }
    }

    private void b(boolean z) {
        if (z) {
            m.a(this, this.o, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            m.a(this, (Drawable) null, (Drawable) null, this.o, (Drawable) null);
        }
    }

    private void c() {
        if (this.o == null || getLayout() == null) {
            return;
        }
        if (this.u == 1 || this.u == 3) {
            this.q = 0;
            a(false);
            return;
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        int measuredWidth = (((((getMeasuredWidth() - Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth())) - af.x(this)) - (this.p == 0 ? this.o.getIntrinsicWidth() : this.p)) - this.r) - af.w(this)) / 2;
        if (d() != (this.u == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.q != measuredWidth) {
            this.q = measuredWidth;
            a(false);
        }
    }

    private boolean d() {
        return af.p(this) == 1;
    }

    private boolean e() {
        return (this.j == null || this.j.b()) ? false : true;
    }

    @ah
    private String getA11yClassName() {
        return (b() ? CompoundButton.class : Button.class).getName();
    }

    public void a() {
        this.k.clear();
    }

    public void a(@ah b bVar) {
        this.k.add(bVar);
    }

    public void b(@ah b bVar) {
        this.k.remove(bVar);
    }

    public boolean b() {
        return this.j != null && this.j.j();
    }

    @Override // android.view.View
    @ai
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @ai
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @ak
    public int getCornerRadius() {
        if (e()) {
            return this.j.h();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.o;
    }

    public int getIconGravity() {
        return this.u;
    }

    @ak
    public int getIconPadding() {
        return this.r;
    }

    @ak
    public int getIconSize() {
        return this.p;
    }

    public ColorStateList getIconTint() {
        return this.n;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    @ai
    public ColorStateList getRippleColor() {
        if (e()) {
            return this.j.e();
        }
        return null;
    }

    @Override // com.google.android.material.t.s
    @ah
    public o getShapeAppearanceModel() {
        if (e()) {
            return this.j.l();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.j.f();
        }
        return null;
    }

    @ak
    public int getStrokeWidth() {
        if (e()) {
            return this.j.g();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.g, androidx.core.n.ad
    @ai
    @ap(a = {ap.a.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return e() ? this.j.c() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.g, androidx.core.n.ad
    @ai
    @ap(a = {ap.a.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return e() ? this.j.d() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.s;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            k.a(this, this.j.i());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (b()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f);
        }
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void onInitializeAccessibilityEvent(@ah AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(b());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.g, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || this.j == null) {
            return;
        }
        this.j.a(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@ai Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        setChecked(dVar.f1210a);
    }

    @Override // android.widget.TextView, android.view.View
    @ah
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f1210a = this.s;
        return dVar;
    }

    @Override // androidx.appcompat.widget.g, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        c();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@ah Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@androidx.annotation.k int i2) {
        if (e()) {
            this.j.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundDrawable(@ah Drawable drawable) {
        if (!e()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w(h, "Do not set the background; MaterialButton manages its own background drawable.");
            this.j.a();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.g, android.view.View
    public void setBackgroundResource(@q int i2) {
        setBackgroundDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@ai ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@ai PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.j.b(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (b() && isEnabled() && this.s != z) {
            this.s = z;
            refreshDrawableState();
            if (this.t) {
                return;
            }
            this.t = true;
            Iterator<b> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.s);
            }
            this.t = false;
        }
    }

    public void setCornerRadius(@ak int i2) {
        if (e()) {
            this.j.c(i2);
        }
    }

    public void setCornerRadiusResource(@androidx.annotation.o int i2) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @am(a = 21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (e()) {
            this.j.i().r(f2);
        }
    }

    public void setIcon(@ai Drawable drawable) {
        if (this.o != drawable) {
            this.o = drawable;
            a(true);
        }
    }

    public void setIconGravity(int i2) {
        if (this.u != i2) {
            this.u = i2;
            c();
        }
    }

    public void setIconPadding(@ak int i2) {
        if (this.r != i2) {
            this.r = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@q int i2) {
        setIcon(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(@ak int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.p != i2) {
            this.p = i2;
            a(true);
        }
    }

    public void setIconTint(@ai ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            a(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.m != mode) {
            this.m = mode;
            a(false);
        }
    }

    public void setIconTintResource(@androidx.annotation.m int i2) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(@ai c cVar) {
        this.l = cVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.l != null) {
            this.l.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(@ai ColorStateList colorStateList) {
        if (e()) {
            this.j.b(colorStateList);
        }
    }

    public void setRippleColorResource(@androidx.annotation.m int i2) {
        if (e()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    @Override // com.google.android.material.t.s
    public void setShapeAppearanceModel(@ah o oVar) {
        if (!e()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.j.a(oVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            this.j.a(z);
        }
    }

    public void setStrokeColor(@ai ColorStateList colorStateList) {
        if (e()) {
            this.j.c(colorStateList);
        }
    }

    public void setStrokeColorResource(@androidx.annotation.m int i2) {
        if (e()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(@ak int i2) {
        if (e()) {
            this.j.b(i2);
        }
    }

    public void setStrokeWidthResource(@androidx.annotation.o int i2) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.g, androidx.core.n.ad
    @ap(a = {ap.a.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@ai ColorStateList colorStateList) {
        if (e()) {
            this.j.a(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.g, androidx.core.n.ad
    @ap(a = {ap.a.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@ai PorterDuff.Mode mode) {
        if (e()) {
            this.j.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.s);
    }
}
