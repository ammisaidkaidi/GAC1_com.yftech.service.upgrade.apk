package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Drawable f150a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.n.af.a(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.ActionBar);
        this.f150a = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.a.m.ActionBar_background);
        this.b = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.a.m.ActionBar_backgroundStacked);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.a.m.ActionBar_height, -1);
        if (getId() == androidx.appcompat.a.g.split_action_bar) {
            this.d = true;
            this.c = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.a.m.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.d ? !(this.f150a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f150a != null && this.f150a.isStateful()) {
            this.f150a.setState(getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
        if (this.c == null || !this.c.isStateful()) {
            return;
        }
        this.c.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f150a != null) {
            this.f150a.jumpToCurrentState();
        }
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = findViewById(androidx.appcompat.a.g.action_bar);
        this.i = findViewById(androidx.appcompat.a.g.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004c A[PHI: r0
      0x004c: PHI (r0v8 boolean) = (r0v1 boolean), (r0v1 boolean), (r0v0 boolean) binds: [B:31:0x00ab, B:33:0x00af, B:15:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.d) {
            if (this.f150a != null) {
                if (this.h.getVisibility() == 0) {
                    this.f150a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                } else if (this.i == null || this.i.getVisibility() != 0) {
                    this.f150a.setBounds(0, 0, 0, 0);
                } else {
                    this.f150a.setBounds(this.i.getLeft(), this.i.getTop(), this.i.getRight(), this.i.getBottom());
                }
                z3 = true;
            }
            this.e = z4;
            if (!z4 || this.b == null) {
                z2 = z3;
            } else {
                this.b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.c != null) {
            this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = z3;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iB;
        if (this.h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (this.g == null || this.g.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (a(this.h)) {
            iB = !a(this.i) ? b(this.i) : 0;
        } else {
            iB = b(this.h);
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iB + b(this.g), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : ActivityChooserView.a.f166a));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.f150a != null) {
            this.f150a.setCallback(null);
            unscheduleDrawable(this.f150a);
        }
        this.f150a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.h != null) {
                this.f150a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
            }
        }
        boolean z = false;
        if (!this.d ? !(this.f150a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
            unscheduleDrawable(this.c);
        }
        this.c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.d && this.c != null) {
                this.c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.d ? !(this.f150a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
            unscheduleDrawable(this.b);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.e && this.b != null) {
                this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
            }
        }
        boolean z = false;
        if (!this.d ? !(this.f150a != null || this.b != null) : this.c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(ar arVar) {
        if (this.g != null) {
            removeView(this.g);
        }
        this.g = arVar;
        if (arVar != null) {
            addView(arVar);
            ViewGroup.LayoutParams layoutParams = arVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            arVar.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f150a != null) {
            this.f150a.setVisible(z, false);
        }
        if (this.b != null) {
            this.b.setVisible(z, false);
        }
        if (this.c != null) {
            this.c.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f150a && !this.d) || (drawable == this.b && this.e) || ((drawable == this.c && this.d) || super.verifyDrawable(drawable));
    }
}
