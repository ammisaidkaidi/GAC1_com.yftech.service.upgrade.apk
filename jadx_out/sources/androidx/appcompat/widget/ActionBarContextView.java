package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public ActionBarContextView(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.actionModeStyle);
    }

    public ActionBarContextView(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ba baVarA = ba.a(context, attributeSet, androidx.appcompat.a.m.ActionMode, i, 0);
        androidx.core.n.af.a(this, baVarA.a(androidx.appcompat.a.m.ActionMode_background));
        this.n = baVarA.g(androidx.appcompat.a.m.ActionMode_titleTextStyle, 0);
        this.o = baVarA.g(androidx.appcompat.a.m.ActionMode_subtitleTextStyle, 0);
        this.e = baVarA.f(androidx.appcompat.a.m.ActionMode_height, 0);
        this.q = baVarA.g(androidx.appcompat.a.m.ActionMode_closeItemLayout, androidx.appcompat.a.j.abc_action_mode_close_item_material);
        baVarA.f();
    }

    private void l() {
        if (this.k == null) {
            LayoutInflater.from(getContext()).inflate(androidx.appcompat.a.j.abc_action_bar_title_item, this);
            this.k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.l = (TextView) this.k.findViewById(androidx.appcompat.a.g.action_bar_title);
            this.m = (TextView) this.k.findViewById(androidx.appcompat.a.g.action_bar_subtitle);
            if (this.n != 0) {
                this.l.setTextAppearance(getContext(), this.n);
            }
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
        }
        this.l.setText(this.g);
        this.m.setText(this.h);
        boolean z = !TextUtils.isEmpty(this.g);
        boolean z2 = !TextUtils.isEmpty(this.h);
        this.m.setVisibility(z2 ? 0 : 8);
        this.k.setVisibility((z || z2) ? 0 : 8);
        if (this.k.getParent() == null) {
            addView(this.k);
        }
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ androidx.core.n.aj a(int i, long j) {
        return super.a(i, j);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void a(int i) {
        super.a(i);
    }

    public void a(final androidx.appcompat.view.b bVar) {
        if (this.i == null) {
            this.i = LayoutInflater.from(getContext()).inflate(this.q, (ViewGroup) this, false);
            addView(this.i);
        } else if (this.i.getParent() == null) {
            addView(this.i);
        }
        this.i.findViewById(androidx.appcompat.a.g.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bVar.c();
            }
        });
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.b();
        if (this.d != null) {
            this.d.h();
        }
        this.d = new c(getContext());
        this.d.b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.a(this.d, this.b);
        this.c = (ActionMenuView) this.d.a(this);
        androidx.core.n.af.a(this.c, (Drawable) null);
        addView(this.c, layoutParams);
    }

    @Override // androidx.appcompat.widget.a
    public boolean a() {
        if (this.d != null) {
            return this.d.e();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // androidx.appcompat.widget.a
    public boolean c() {
        if (this.d != null) {
            return this.d.g();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public boolean d() {
        if (this.d != null) {
            return this.d.j();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public void i() {
        if (this.i == null) {
            j();
        }
    }

    public void j() {
        removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean k() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.g();
            this.d.i();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.g);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        boolean zA = bg.a(this);
        int paddingRight = zA ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.i == null || this.i.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            int i5 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = a(paddingRight, i5, zA);
            iA = a(iA2 + a(this.i, iA2, paddingTop, paddingTop2, zA), i6, zA);
        }
        if (this.k != null && this.j == null && this.k.getVisibility() != 8) {
            iA += a(this.k, iA, paddingTop, paddingTop2, zA);
        }
        int i7 = iA;
        if (this.j != null) {
            a(this.j, i7, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a(this.c, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = androidx.d.c.b.a.b.b;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.e > 0 ? this.e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        if (this.i != null) {
            int iA = a(this.i, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.c != null && this.c.getParent() == this) {
            paddingLeft = a(this.c, paddingLeft, iMakeMeasureSpec, 0);
        }
        if (this.k != null && this.j == null) {
            if (this.p) {
                this.k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(this.k, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        if (this.j != null) {
            ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
            int i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            if (layoutParams.height == -2) {
                i3 = Integer.MIN_VALUE;
            }
            if (layoutParams.height >= 0) {
                iMin = Math.min(layoutParams.height, iMin);
            }
            this.j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(iMin, i3));
        }
        if (this.e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i5) {
                i5 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i5);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            removeView(this.j);
        }
        this.j = view;
        if (view != null && this.k != null) {
            removeView(this.k);
            this.k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        l();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        l();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.p) {
            requestLayout();
        }
        this.p = z;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
