package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.am;
import androidx.annotation.as;
import androidx.annotation.at;
import androidx.annotation.i;
import androidx.annotation.m;
import androidx.annotation.p;
import androidx.annotation.q;
import androidx.appcompat.widget.h;
import androidx.core.n.a.d;
import androidx.core.n.aa;
import androidx.core.n.af;
import com.google.android.material.internal.z;
import com.google.android.material.q.c;
import com.google.android.material.q.f;
import com.google.android.material.r.b;
import com.google.android.material.t.k;
import com.google.android.material.t.o;
import com.google.android.material.t.s;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends h implements com.google.android.material.chip.a.InterfaceC0085a, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1229a = "Chip";
    private static final int c = 0;
    private static final int d = 1;
    private static final String h = "http://schemas.android.com/apk/res/android";
    private static final int i = 48;
    private static final String v = "android.widget.Button";
    private static final String w = "android.widget.CompoundButton";
    private static final String x = "android.view.View";
    private final RectF A;
    private final f B;

    @ai
    private com.google.android.material.chip.a j;

    @ai
    private InsetDrawable k;

    @ai
    private RippleDrawable l;

    @ai
    private View.OnClickListener m;

    @ai
    private CompoundButton.OnCheckedChangeListener n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;

    @p(a = 1)
    private int u;

    @ah
    private final a y;
    private final Rect z;
    private static final int b = com.google.android.material.a.n.Widget_MaterialComponents_Chip_Action;
    private static final Rect e = new Rect();
    private static final int[] f = {R.attr.state_selected};
    private static final int[] g = {R.attr.state_checkable};

    private class a extends androidx.f.b.a {
        a(Chip chip) {
            super(chip);
        }

        @Override // androidx.f.b.a
        protected int a(float f, float f2) {
            return (Chip.this.s() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
        }

        @Override // androidx.f.b.a
        protected void a(int i, @ah d dVar) {
            if (i != 1) {
                dVar.e(com.yftech.service.upgrade.a.d);
                dVar.b(Chip.e);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                dVar.e(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i2 = com.google.android.material.a.m.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(text)) {
                    text = com.yftech.service.upgrade.a.d;
                }
                objArr[0] = text;
                dVar.e(context.getString(i2, objArr).trim());
            }
            dVar.b(Chip.this.getCloseIconTouchBoundsInt());
            dVar.a(d.a.e);
            dVar.j(Chip.this.isEnabled());
        }

        @Override // androidx.f.b.a
        protected void a(int i, boolean z) {
            if (i == 1) {
                Chip.this.r = z;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // androidx.f.b.a
        protected void a(@ah d dVar) {
            dVar.a(Chip.this.g());
            dVar.h(Chip.this.isClickable());
            if (Chip.this.g() || Chip.this.isClickable()) {
                dVar.b((CharSequence) (Chip.this.g() ? Chip.w : Chip.v));
            } else {
                dVar.b(Chip.x);
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                dVar.c(text);
            } else {
                dVar.e(text);
            }
        }

        @Override // androidx.f.b.a
        protected void a(@ah List<Integer> list) {
            list.add(0);
            if (Chip.this.s() && Chip.this.e() && Chip.this.m != null) {
                list.add(1);
            }
        }

        @Override // androidx.f.b.a
        protected boolean b(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return Chip.this.performClick();
            }
            if (i == 1) {
                return Chip.this.b();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, b), attributeSet, i2);
        this.z = new Rect();
        this.A = new RectF();
        this.B = new f() { // from class: com.google.android.material.chip.Chip.1
            @Override // com.google.android.material.q.f
            public void a(int i3) {
            }

            @Override // com.google.android.material.q.f
            public void a(@ah Typeface typeface, boolean z) {
                Chip.this.setText(Chip.this.j.S() ? Chip.this.j.o() : Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }
        };
        Context context2 = getContext();
        a(attributeSet);
        com.google.android.material.chip.a aVarA = com.google.android.material.chip.a.a(context2, attributeSet, i2, b);
        a(context2, attributeSet, i2);
        setChipDrawable(aVarA);
        aVarA.r(af.P(this));
        TypedArray typedArrayA = com.google.android.material.internal.s.a(context2, attributeSet, com.google.android.material.a.o.Chip, i2, b, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(c.a(context2, typedArrayA, com.google.android.material.a.o.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayA.hasValue(com.google.android.material.a.o.Chip_shapeAppearance);
        typedArrayA.recycle();
        this.y = new a(this);
        l();
        if (!zHasValue) {
            n();
        }
        setChecked(this.o);
        setText(aVarA.o());
        setEllipsize(aVarA.q());
        t();
        if (!this.j.S()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        m();
        if (j()) {
            setMinHeight(this.u);
        }
        this.t = af.p(this);
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.k = new InsetDrawable((Drawable) this.j, i2, i3, i4, i5);
    }

    private void a(Context context, @ai AttributeSet attributeSet, int i2) {
        TypedArray typedArrayA = com.google.android.material.internal.s.a(context, attributeSet, com.google.android.material.a.o.Chip, i2, b, new int[0]);
        this.s = typedArrayA.getBoolean(com.google.android.material.a.o.Chip_ensureMinTouchTargetSize, false);
        this.u = (int) Math.ceil(typedArrayA.getDimension(com.google.android.material.a.o.Chip_chipMinTouchTargetSize, (float) Math.ceil(z.a(getContext(), 48))));
        typedArrayA.recycle();
    }

    private void a(@ai AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(h, "background") != null) {
            Log.w(f1229a, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(h, "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(h, "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue(h, "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue(h, "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue(h, "singleLine", true) || attributeSet.getAttributeIntValue(h, "lines", 1) != 1 || attributeSet.getAttributeIntValue(h, "minLines", 1) != 1 || attributeSet.getAttributeIntValue(h, "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue(h, "gravity", 8388627) != 8388627) {
            Log.w(f1229a, "Chip text must be vertically center and start aligned");
        }
    }

    private void a(@ai com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.a((com.google.android.material.chip.a.InterfaceC0085a) null);
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(@ah MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.f.b.a.class.getDeclaredField("n");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.y)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.f.b.a.class.getDeclaredMethod("f", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.y, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e(f1229a, "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e(f1229a, "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e(f1229a, "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e(f1229a, "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    private void b(@ah com.google.android.material.chip.a aVar) {
        aVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ah
    public RectF getCloseIconTouchBounds() {
        this.A.setEmpty();
        if (s()) {
            this.j.b(this.A);
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ah
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.z.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.z;
    }

    @ai
    private com.google.android.material.q.d getTextAppearance() {
        if (this.j != null) {
            return this.j.p();
        }
        return null;
    }

    private void l() {
        if (s() && e() && this.m != null) {
            af.a(this, this.y);
        } else {
            af.a(this, (androidx.core.n.a) null);
        }
    }

    private void m() {
        if (TextUtils.isEmpty(getText()) || this.j == null) {
            return;
        }
        int iQ = (int) (this.j.Q() + this.j.N() + this.j.d());
        int iJ = (int) (this.j.J() + this.j.M() + this.j.c());
        if (this.k != null) {
            Rect rect = new Rect();
            this.k.getPadding(rect);
            iJ += rect.left;
            iQ += rect.right;
        }
        af.b(this, iJ, getPaddingTop(), iQ, getPaddingBottom());
    }

    private void n() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, @ah Outline outline) {
                    if (Chip.this.j != null) {
                        Chip.this.j.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
    }

    private void o() {
        if (b.f1376a) {
            q();
            return;
        }
        this.j.a(true);
        af.a(this, getBackgroundDrawable());
        m();
        p();
    }

    private void p() {
        if (getBackgroundDrawable() == this.k && this.j.getCallback() == null) {
            this.j.setCallback(this.k);
        }
    }

    private void q() {
        this.l = new RippleDrawable(b.b(this.j.n()), getBackgroundDrawable(), null);
        this.j.a(false);
        af.a(this, this.l);
        m();
    }

    @ah
    private int[] r() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.r) {
            i3++;
        }
        if (this.q) {
            i3++;
        }
        if (this.p) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.r) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.q) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.p) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        return (this.j == null || this.j.y() == null) ? false : true;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.q != z) {
            this.q = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.p != z) {
            this.p = z;
            refreshDrawableState();
        }
    }

    private void t() {
        TextPaint paint = getPaint();
        if (this.j != null) {
            paint.drawableState = this.j.getState();
        }
        com.google.android.material.q.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.B);
        }
    }

    private void u() {
        if (this.k != null) {
            this.k = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            o();
        }
    }

    @Override // com.google.android.material.chip.a.InterfaceC0085a
    public void a() {
        a(this.u);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public boolean a(@p int i2) {
        this.u = i2;
        if (!j()) {
            if (this.k != null) {
                u();
            } else {
                o();
            }
            return false;
        }
        int iMax = Math.max(0, i2 - this.j.getIntrinsicHeight());
        int iMax2 = Math.max(0, i2 - this.j.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.k != null) {
                u();
            } else {
                o();
            }
            return false;
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.k != null) {
            Rect rect = new Rect();
            this.k.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                o();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        a(i3, i4, i3, i4);
        o();
        return true;
    }

    @i
    public boolean b() {
        boolean z = false;
        playSoundEffect(0);
        if (this.m != null) {
            this.m.onClick(this);
            z = true;
        }
        this.y.a(1, 1);
        return z;
    }

    public boolean c() {
        return this.j != null && this.j.r();
    }

    @Deprecated
    public boolean d() {
        return c();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@ah MotionEvent motionEvent) {
        return a(motionEvent) || this.y.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.y.a(keyEvent) || this.y.c() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.h, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.j == null || !this.j.f()) ? false : this.j.a(r())) {
            invalidate();
        }
    }

    public boolean e() {
        return this.j != null && this.j.w();
    }

    @Deprecated
    public boolean f() {
        return e();
    }

    public boolean g() {
        return this.j != null && this.j.C();
    }

    @ai
    public Drawable getBackgroundDrawable() {
        return this.k == null ? this.j : this.k;
    }

    @ai
    public Drawable getCheckedIcon() {
        if (this.j != null) {
            return this.j.F();
        }
        return null;
    }

    @ai
    public ColorStateList getCheckedIconTint() {
        if (this.j != null) {
            return this.j.G();
        }
        return null;
    }

    @ai
    public ColorStateList getChipBackgroundColor() {
        if (this.j != null) {
            return this.j.h();
        }
        return null;
    }

    public float getChipCornerRadius() {
        if (this.j != null) {
            return Math.max(0.0f, this.j.k());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.j;
    }

    public float getChipEndPadding() {
        if (this.j != null) {
            return this.j.Q();
        }
        return 0.0f;
    }

    @ai
    public Drawable getChipIcon() {
        if (this.j != null) {
            return this.j.t();
        }
        return null;
    }

    public float getChipIconSize() {
        if (this.j != null) {
            return this.j.v();
        }
        return 0.0f;
    }

    @ai
    public ColorStateList getChipIconTint() {
        if (this.j != null) {
            return this.j.u();
        }
        return null;
    }

    public float getChipMinHeight() {
        if (this.j != null) {
            return this.j.j();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        if (this.j != null) {
            return this.j.J();
        }
        return 0.0f;
    }

    @ai
    public ColorStateList getChipStrokeColor() {
        if (this.j != null) {
            return this.j.l();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        if (this.j != null) {
            return this.j.m();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @ai
    public Drawable getCloseIcon() {
        if (this.j != null) {
            return this.j.y();
        }
        return null;
    }

    @ai
    public CharSequence getCloseIconContentDescription() {
        if (this.j != null) {
            return this.j.B();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        if (this.j != null) {
            return this.j.P();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        if (this.j != null) {
            return this.j.A();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        if (this.j != null) {
            return this.j.O();
        }
        return 0.0f;
    }

    @ai
    public ColorStateList getCloseIconTint() {
        if (this.j != null) {
            return this.j.z();
        }
        return null;
    }

    @Override // android.widget.TextView
    @ai
    public TextUtils.TruncateAt getEllipsize() {
        if (this.j != null) {
            return this.j.q();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@ah Rect rect) {
        if (this.y.c() == 1 || this.y.b() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @ai
    public com.google.android.material.a.h getHideMotionSpec() {
        if (this.j != null) {
            return this.j.I();
        }
        return null;
    }

    public float getIconEndPadding() {
        if (this.j != null) {
            return this.j.L();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        if (this.j != null) {
            return this.j.K();
        }
        return 0.0f;
    }

    @ai
    public ColorStateList getRippleColor() {
        if (this.j != null) {
            return this.j.n();
        }
        return null;
    }

    @Override // com.google.android.material.t.s
    @ah
    public o getShapeAppearanceModel() {
        return this.j.getShapeAppearanceModel();
    }

    @ai
    public com.google.android.material.a.h getShowMotionSpec() {
        if (this.j != null) {
            return this.j.H();
        }
        return null;
    }

    public float getTextEndPadding() {
        if (this.j != null) {
            return this.j.N();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        if (this.j != null) {
            return this.j.M();
        }
        return 0.0f;
    }

    public boolean h() {
        return this.j != null && this.j.D();
    }

    @Deprecated
    public boolean i() {
        return h();
    }

    public boolean j() {
        return this.s;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.a(this, this.j);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f);
        }
        if (g()) {
            mergeDrawableStates(iArrOnCreateDrawableState, g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.y.a(z, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@ah MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (g() || isClickable()) {
            accessibilityNodeInfo.setClassName(g() ? w : v);
        } else {
            accessibilityNodeInfo.setClassName(x);
        }
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            d.a(accessibilityNodeInfo).c(d.c.a(chipGroup.b(this), 1, chipGroup.b() ? chipGroup.a(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @ai
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@ah MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), aa.d);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.t != i2) {
            this.t = i2;
            m();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@ah MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        switch (actionMasked) {
            case 0:
                if (!zContains) {
                    z = false;
                } else {
                    setCloseIconPressed(true);
                    z = true;
                }
                break;
            case 1:
                if (this.p) {
                    b();
                    z = true;
                } else {
                    z = false;
                }
                setCloseIconPressed(false);
                break;
            case 2:
                if (!this.p) {
                    z = false;
                } else {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z = true;
                }
                break;
            case 3:
                z = false;
                setCloseIconPressed(false);
                break;
            default:
                z = false;
                break;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.l) {
            super.setBackground(drawable);
        } else {
            Log.w(f1229a, "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w(f1229a, "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.h, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.l) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w(f1229a, "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.h, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w(f1229a, "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@ai ColorStateList colorStateList) {
        Log.w(f1229a, "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@ai PorterDuff.Mode mode) {
        Log.w(f1229a, "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        if (this.j != null) {
            this.j.f(z);
        }
    }

    public void setCheckableResource(@androidx.annotation.h int i2) {
        if (this.j != null) {
            this.j.s(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.j == null) {
            this.o = z;
            return;
        }
        if (this.j.C()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || this.n == null) {
                return;
            }
            this.n.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(@ai Drawable drawable) {
        if (this.j != null) {
            this.j.c(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@androidx.annotation.h int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@q int i2) {
        if (this.j != null) {
            this.j.v(i2);
        }
    }

    public void setCheckedIconTint(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.f(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@m int i2) {
        if (this.j != null) {
            this.j.w(i2);
        }
    }

    public void setCheckedIconVisible(@androidx.annotation.h int i2) {
        if (this.j != null) {
            this.j.t(i2);
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.j != null) {
            this.j.g(z);
        }
    }

    public void setChipBackgroundColor(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.a(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@m int i2) {
        if (this.j != null) {
            this.j.a(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        if (this.j != null) {
            this.j.b(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.c(i2);
        }
    }

    public void setChipDrawable(@ah com.google.android.material.chip.a aVar) {
        if (this.j != aVar) {
            a(this.j);
            this.j = aVar;
            this.j.i(false);
            b(this.j);
            a(this.u);
        }
    }

    public void setChipEndPadding(float f2) {
        if (this.j != null) {
            this.j.m(f2);
        }
    }

    public void setChipEndPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.G(i2);
        }
    }

    public void setChipIcon(@ai Drawable drawable) {
        if (this.j != null) {
            this.j.a(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@androidx.annotation.h int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@q int i2) {
        if (this.j != null) {
            this.j.k(i2);
        }
    }

    public void setChipIconSize(float f2) {
        if (this.j != null) {
            this.j.d(f2);
        }
    }

    public void setChipIconSizeResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.m(i2);
        }
    }

    public void setChipIconTint(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.d(colorStateList);
        }
    }

    public void setChipIconTintResource(@m int i2) {
        if (this.j != null) {
            this.j.l(i2);
        }
    }

    public void setChipIconVisible(@androidx.annotation.h int i2) {
        if (this.j != null) {
            this.j.i(i2);
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.j != null) {
            this.j.b(z);
        }
    }

    public void setChipMinHeight(float f2) {
        if (this.j != null) {
            this.j.a(f2);
        }
    }

    public void setChipMinHeightResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.b(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        if (this.j != null) {
            this.j.f(f2);
        }
    }

    public void setChipStartPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.z(i2);
        }
    }

    public void setChipStrokeColor(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.b(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@m int i2) {
        if (this.j != null) {
            this.j.d(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        if (this.j != null) {
            this.j.c(f2);
        }
    }

    public void setChipStrokeWidthResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.e(i2);
        }
    }

    @Deprecated
    public void setChipText(@ai CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@as int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@ai Drawable drawable) {
        if (this.j != null) {
            this.j.b(drawable);
        }
        l();
    }

    public void setCloseIconContentDescription(@ai CharSequence charSequence) {
        if (this.j != null) {
            this.j.b(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@androidx.annotation.h int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        if (this.j != null) {
            this.j.l(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.F(i2);
        }
    }

    public void setCloseIconResource(@q int i2) {
        if (this.j != null) {
            this.j.p(i2);
        }
        l();
    }

    public void setCloseIconSize(float f2) {
        if (this.j != null) {
            this.j.e(f2);
        }
    }

    public void setCloseIconSizeResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.r(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        if (this.j != null) {
            this.j.k(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.E(i2);
        }
    }

    public void setCloseIconTint(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.e(colorStateList);
        }
    }

    public void setCloseIconTintResource(@m int i2) {
        if (this.j != null) {
            this.j.q(i2);
        }
    }

    public void setCloseIconVisible(@androidx.annotation.h int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z) {
        if (this.j != null) {
            this.j.d(z);
        }
        l();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@ai Drawable drawable, @ai Drawable drawable2, @ai Drawable drawable3, @ai Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@ai Drawable drawable, @ai Drawable drawable2, @ai Drawable drawable3, @ai Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@ai Drawable drawable, @ai Drawable drawable2, @ai Drawable drawable3, @ai Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@ai Drawable drawable, @ai Drawable drawable2, @ai Drawable drawable3, @ai Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.view.View
    @am(a = 21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (this.j != null) {
            this.j.r(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.j == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        if (this.j != null) {
            this.j.a(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.s = z;
        a(this.u);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w(f1229a, "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@ai com.google.android.material.a.h hVar) {
        if (this.j != null) {
            this.j.b(hVar);
        }
    }

    public void setHideMotionSpecResource(@androidx.annotation.b int i2) {
        if (this.j != null) {
            this.j.y(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        if (this.j != null) {
            this.j.h(f2);
        }
    }

    public void setIconEndPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.B(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        if (this.j != null) {
            this.j.g(f2);
        }
    }

    public void setIconStartPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.A(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.j != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@ak int i2) {
        super.setMaxWidth(i2);
        if (this.j != null) {
            this.j.H(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.n = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
        l();
    }

    public void setRippleColor(@ai ColorStateList colorStateList) {
        if (this.j != null) {
            this.j.c(colorStateList);
        }
        if (this.j.a()) {
            return;
        }
        q();
    }

    public void setRippleColorResource(@m int i2) {
        if (this.j != null) {
            this.j.f(i2);
            if (this.j.a()) {
                return;
            }
            q();
        }
    }

    @Override // com.google.android.material.t.s
    public void setShapeAppearanceModel(@ah o oVar) {
        this.j.setShapeAppearanceModel(oVar);
    }

    public void setShowMotionSpec(@ai com.google.android.material.a.h hVar) {
        if (this.j != null) {
            this.j.a(hVar);
        }
    }

    public void setShowMotionSpecResource(@androidx.annotation.b int i2) {
        if (this.j != null) {
            this.j.x(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.j == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = com.yftech.service.upgrade.a.d;
        }
        super.setText(this.j.S() ? null : charSequence, bufferType);
        if (this.j != null) {
            this.j.a(charSequence);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        if (this.j != null) {
            this.j.h(i2);
        }
        t();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (this.j != null) {
            this.j.h(i2);
        }
        t();
    }

    public void setTextAppearance(@ai com.google.android.material.q.d dVar) {
        if (this.j != null) {
            this.j.a(dVar);
        }
        t();
    }

    public void setTextAppearanceResource(@at int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        if (this.j != null) {
            this.j.j(f2);
        }
    }

    public void setTextEndPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.D(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        if (this.j != null) {
            this.j.i(f2);
        }
    }

    public void setTextStartPaddingResource(@androidx.annotation.o int i2) {
        if (this.j != null) {
            this.j.C(i2);
        }
    }
}
