package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes.dex */
public class au extends CompoundButton {
    private static final int c = 250;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final String g = "android.widget.Switch";
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private CharSequence A;
    private boolean B;
    private int C;
    private int D;
    private float E;
    private float F;
    private VelocityTracker G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private final TextPaint P;
    private ColorStateList Q;
    private Layout R;
    private Layout S;
    private TransformationMethod T;
    private final z U;
    private final Rect V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f237a;
    ObjectAnimator b;
    private Drawable l;
    private ColorStateList m;
    private PorterDuff.Mode n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private ColorStateList r;
    private PorterDuff.Mode s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private CharSequence z;
    private static final Property<au, Float> k = new Property<au, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.au.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(au auVar) {
            return Float.valueOf(auVar.f237a);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(au auVar, Float f2) {
            auVar.setThumbPosition(f2.floatValue());
        }
    };
    private static final int[] W = {R.attr.state_checked};

    public au(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public au(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.switchStyle);
    }

    public au(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = false;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = false;
        this.G = VelocityTracker.obtain();
        this.V = new Rect();
        av.a(this, getContext());
        this.P = new TextPaint(1);
        Resources resources = getResources();
        this.P.density = resources.getDisplayMetrics().density;
        ba baVarA = ba.a(context, attributeSet, androidx.appcompat.a.m.SwitchCompat, i2, 0);
        androidx.core.n.af.a(this, context, androidx.appcompat.a.m.SwitchCompat, attributeSet, baVarA.a(), i2, 0);
        this.l = baVarA.a(androidx.appcompat.a.m.SwitchCompat_android_thumb);
        if (this.l != null) {
            this.l.setCallback(this);
        }
        this.q = baVarA.a(androidx.appcompat.a.m.SwitchCompat_track);
        if (this.q != null) {
            this.q.setCallback(this);
        }
        this.z = baVarA.d(androidx.appcompat.a.m.SwitchCompat_android_textOn);
        this.A = baVarA.d(androidx.appcompat.a.m.SwitchCompat_android_textOff);
        this.B = baVarA.a(androidx.appcompat.a.m.SwitchCompat_showText, true);
        this.v = baVarA.e(androidx.appcompat.a.m.SwitchCompat_thumbTextPadding, 0);
        this.w = baVarA.e(androidx.appcompat.a.m.SwitchCompat_switchMinWidth, 0);
        this.x = baVarA.e(androidx.appcompat.a.m.SwitchCompat_switchPadding, 0);
        this.y = baVarA.a(androidx.appcompat.a.m.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListG = baVarA.g(androidx.appcompat.a.m.SwitchCompat_thumbTint);
        if (colorStateListG != null) {
            this.m = colorStateListG;
            this.o = true;
        }
        PorterDuff.Mode modeA = af.a(baVarA.a(androidx.appcompat.a.m.SwitchCompat_thumbTintMode, -1), null);
        if (this.n != modeA) {
            this.n = modeA;
            this.p = true;
        }
        if (this.o || this.p) {
            b();
        }
        ColorStateList colorStateListG2 = baVarA.g(androidx.appcompat.a.m.SwitchCompat_trackTint);
        if (colorStateListG2 != null) {
            this.r = colorStateListG2;
            this.t = true;
        }
        PorterDuff.Mode modeA2 = af.a(baVarA.a(androidx.appcompat.a.m.SwitchCompat_trackTintMode, -1), null);
        if (this.s != modeA2) {
            this.s = modeA2;
            this.u = true;
        }
        if (this.t || this.u) {
            a();
        }
        int iG = baVarA.g(androidx.appcompat.a.m.SwitchCompat_switchTextAppearance, 0);
        if (iG != 0) {
            a(context, iG);
        }
        this.U = new z(this);
        this.U.a(attributeSet, i2);
        baVarA.f();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.D = viewConfiguration.getScaledTouchSlop();
        this.H = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float a(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    private Layout a(CharSequence charSequence) {
        if (this.T != null) {
            charSequence = this.T.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.P, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, this.P)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void a() {
        if (this.q != null) {
            if (this.t || this.u) {
                this.q = androidx.core.graphics.drawable.a.g(this.q).mutate();
                if (this.t) {
                    androidx.core.graphics.drawable.a.a(this.q, this.r);
                }
                if (this.u) {
                    androidx.core.graphics.drawable.a.a(this.q, this.s);
                }
                if (this.q.isStateful()) {
                    this.q.setState(getDrawableState());
                }
            }
        }
    }

    private void a(int i2, int i3) {
        Typeface typeface;
        switch (i2) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = null;
                break;
        }
        a(typeface, i3);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void a(boolean z) {
        this.b = ObjectAnimator.ofFloat(this, k, z ? 1.0f : 0.0f);
        this.b.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.b.setAutoCancel(true);
        }
        this.b.start();
    }

    private boolean a(float f2, float f3) {
        if (this.l == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.l.getPadding(this.V);
        int i2 = this.M - this.D;
        int i3 = (this.L + thumbOffset) - this.D;
        return f2 > ((float) i3) && f2 < ((float) ((((this.K + i3) + this.V.left) + this.V.right) + this.D)) && f3 > ((float) i2) && f3 < ((float) (this.O + this.D));
    }

    private void b() {
        if (this.l != null) {
            if (this.o || this.p) {
                this.l = androidx.core.graphics.drawable.a.g(this.l).mutate();
                if (this.o) {
                    androidx.core.graphics.drawable.a.a(this.l, this.m);
                }
                if (this.p) {
                    androidx.core.graphics.drawable.a.a(this.l, this.n);
                }
                if (this.l.isStateful()) {
                    this.l.setState(getDrawableState());
                }
            }
        }
    }

    private void b(MotionEvent motionEvent) {
        boolean targetCheckedState;
        this.C = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.G.computeCurrentVelocity(1000);
            float xVelocity = this.G.getXVelocity();
            if (Math.abs(xVelocity) > this.H) {
                if (!bg.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z = false;
                }
                targetCheckedState = z;
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        a(motionEvent);
    }

    private void c() {
        if (this.b != null) {
            this.b.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f237a > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((bg.a(this) ? 1.0f - this.f237a : this.f237a) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.q == null) {
            return 0;
        }
        Rect rect = this.V;
        this.q.getPadding(rect);
        Rect rectA = this.l != null ? af.a(this.l) : af.f201a;
        return ((((this.I - this.K) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    public void a(Context context, int i2) {
        ba baVarA = ba.a(context, i2, androidx.appcompat.a.m.TextAppearance);
        ColorStateList colorStateListG = baVarA.g(androidx.appcompat.a.m.TextAppearance_android_textColor);
        if (colorStateListG != null) {
            this.Q = colorStateListG;
        } else {
            this.Q = getTextColors();
        }
        int iE = baVarA.e(androidx.appcompat.a.m.TextAppearance_android_textSize, 0);
        if (iE != 0) {
            float f2 = iE;
            if (f2 != this.P.getTextSize()) {
                this.P.setTextSize(f2);
                requestLayout();
            }
        }
        a(baVarA.a(androidx.appcompat.a.m.TextAppearance_android_typeface, -1), baVarA.a(androidx.appcompat.a.m.TextAppearance_android_textStyle, -1));
        if (baVarA.a(androidx.appcompat.a.m.TextAppearance_textAllCaps, false)) {
            this.T = new androidx.appcompat.d.a(getContext());
        } else {
            this.T = null;
        }
        baVarA.f();
    }

    public void a(Typeface typeface, int i2) {
        if (i2 <= 0) {
            this.P.setFakeBoldText(false);
            this.P.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i3 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i2;
            this.P.setFakeBoldText((i3 & 1) != 0);
            this.P.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.V;
        int i4 = this.L;
        int i5 = this.M;
        int i6 = this.N;
        int i7 = this.O;
        int thumbOffset = getThumbOffset() + i4;
        Rect rectA = this.l != null ? af.a(this.l) : af.f201a;
        if (this.q != null) {
            this.q.getPadding(rect);
            thumbOffset += rect.left;
            if (rectA != null) {
                if (rectA.left > rect.left) {
                    i4 += rectA.left - rect.left;
                }
                i2 = rectA.top > rect.top ? (rectA.top - rect.top) + i5 : i5;
                if (rectA.right > rect.right) {
                    i6 -= rectA.right - rect.right;
                }
                if (rectA.bottom > rect.bottom) {
                    i3 = i7 - (rectA.bottom - rect.bottom);
                }
                this.q.setBounds(i4, i2, i6, i3);
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.q.setBounds(i4, i2, i6, i3);
        }
        if (this.l != null) {
            this.l.getPadding(rect);
            int i8 = thumbOffset - rect.left;
            int i9 = thumbOffset + this.K + rect.right;
            this.l.setBounds(i8, i5, i9, i7);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.a(background, i8, i5, i9, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        if (this.l != null) {
            androidx.core.graphics.drawable.a.a(this.l, f2, f3);
        }
        if (this.q != null) {
            androidx.core.graphics.drawable.a.a(this.q, f2, f3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.l;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.q;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!bg.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.x : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (bg.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.x : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.B;
    }

    public boolean getSplitTrack() {
        return this.y;
    }

    public int getSwitchMinWidth() {
        return this.w;
    }

    public int getSwitchPadding() {
        return this.x;
    }

    public CharSequence getTextOff() {
        return this.A;
    }

    public CharSequence getTextOn() {
        return this.z;
    }

    public Drawable getThumbDrawable() {
        return this.l;
    }

    public int getThumbTextPadding() {
        return this.v;
    }

    @androidx.annotation.ai
    public ColorStateList getThumbTintList() {
        return this.m;
    }

    @androidx.annotation.ai
    public PorterDuff.Mode getThumbTintMode() {
        return this.n;
    }

    public Drawable getTrackDrawable() {
        return this.q;
    }

    @androidx.annotation.ai
    public ColorStateList getTrackTintList() {
        return this.r;
    }

    @androidx.annotation.ai
    public PorterDuff.Mode getTrackTintMode() {
        return this.s;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.l != null) {
            this.l.jumpToCurrentState();
        }
        if (this.q != null) {
            this.q.jumpToCurrentState();
        }
        if (this.b == null || !this.b.isStarted()) {
            return;
        }
        this.b.end();
        this.b = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, W);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.V;
        Drawable drawable = this.q;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i2 = this.M;
        int i3 = this.O;
        int i4 = i2 + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.l;
        if (drawable != null) {
            if (!this.y || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectA = af.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectA.left;
                rect.right -= rectA.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.R : this.S;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.Q != null) {
                this.P.setColor(this.Q.getColorForState(drawableState, 0));
            }
            this.P.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i4 + i5) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(g);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(g);
        CharSequence charSequence = isChecked() ? this.z : this.A;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int width;
        int paddingLeft;
        int paddingTop;
        int height;
        super.onLayout(z, i2, i3, i4, i5);
        int i6 = 0;
        if (this.l != null) {
            Rect rect = this.V;
            if (this.q != null) {
                this.q.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectA = af.a(this.l);
            int iMax2 = Math.max(0, rectA.left - rect.left);
            iMax = Math.max(0, rectA.right - rect.right);
            i6 = iMax2;
        } else {
            iMax = 0;
        }
        if (bg.a(this)) {
            paddingLeft = getPaddingLeft() + i6;
            width = ((this.I + paddingLeft) - i6) - iMax;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax;
            paddingLeft = (width - this.I) + i6 + iMax;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.J / 2);
            height = this.J + paddingTop;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.J + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.J;
        }
        this.L = paddingLeft;
        this.M = paddingTop;
        this.O = height;
        this.N = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.B) {
            if (this.R == null) {
                this.R = a(this.z);
            }
            if (this.S == null) {
                this.S = a(this.A);
            }
        }
        Rect rect = this.V;
        int intrinsicHeight2 = 0;
        if (this.l != null) {
            this.l.getPadding(rect);
            intrinsicWidth = (this.l.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.l.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.K = Math.max(this.B ? Math.max(this.R.getWidth(), this.S.getWidth()) + (this.v * 2) : 0, intrinsicWidth);
        if (this.q != null) {
            this.q.getPadding(rect);
            intrinsicHeight2 = this.q.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        if (this.l != null) {
            Rect rectA = af.a(this.l);
            iMax = Math.max(iMax, rectA.left);
            iMax2 = Math.max(iMax2, rectA.right);
        }
        int iMax3 = Math.max(this.w, (this.K * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.I = iMax3;
        this.J = iMax4;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.z : this.A;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.G.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && a(x, y)) {
                    this.C = 1;
                    this.E = x;
                    this.F = y;
                }
                break;
            case 1:
            case 3:
                if (this.C == 2) {
                    b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.C = 0;
                this.G.clear();
                break;
            case 2:
                switch (this.C) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.E) > this.D || Math.abs(y2 - this.F) > this.D) {
                            this.C = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.E = x2;
                            this.F = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x3 - this.E;
                        float f3 = thumbScrollRange != 0 ? f2 / thumbScrollRange : f2 > 0.0f ? 1.0f : -1.0f;
                        if (bg.a(this)) {
                            f3 = -f3;
                        }
                        float fA = a(this.f237a + f3, 0.0f, 1.0f);
                        if (fA != this.f237a) {
                            this.E = x3;
                            setThumbPosition(fA);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && androidx.core.n.af.ag(this)) {
            a(zIsChecked);
        } else {
            c();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.m.b(this, callback));
    }

    public void setShowText(boolean z) {
        if (this.B != z) {
            this.B = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.y = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.w = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.x = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.P.getTypeface() == null || this.P.getTypeface().equals(typeface)) && (this.P.getTypeface() != null || typeface == null)) {
            return;
        }
        this.P.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        this.A = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.z = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.l != null) {
            this.l.setCallback(null);
        }
        this.l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f2) {
        this.f237a = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.v = i2;
        requestLayout();
    }

    public void setThumbTintList(@androidx.annotation.ai ColorStateList colorStateList) {
        this.m = colorStateList;
        this.o = true;
        b();
    }

    public void setThumbTintMode(@androidx.annotation.ai PorterDuff.Mode mode) {
        this.n = mode;
        this.p = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.q != null) {
            this.q.setCallback(null);
        }
        this.q = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setTrackTintList(@androidx.annotation.ai ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        a();
    }

    public void setTrackTintMode(@androidx.annotation.ai PorterDuff.Mode mode) {
        this.s = mode;
        this.u = true;
        a();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.l || drawable == this.q;
    }
}
