package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.ai;
import androidx.appcompat.widget.bc;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends aa implements View.OnClickListener, o.a, ActionMenuView.a {
    private static final String e = "ActionMenuItemView";
    private static final int m = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j f120a;
    g.b b;
    b c;
    private CharSequence f;
    private Drawable g;
    private ai h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int n;

    private class a extends ai {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ai
        public q a() {
            if (ActionMenuItemView.this.c != null) {
                return ActionMenuItemView.this.c.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ai
        protected boolean b() {
            q qVarA;
            return ActionMenuItemView.this.b != null && ActionMenuItemView.this.b.a(ActionMenuItemView.this.f120a) && (qVarA = a()) != null && qVarA.e();
        }
    }

    public static abstract class b {
        public abstract q a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.i = f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.ActionMenuItemView, i, 0);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.a.m.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.n = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.l = -1;
        setSaveEnabled(false);
    }

    private boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void g() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f);
        if (this.g != null && (!this.f120a.m() || (!this.i && !this.j))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f : null);
        CharSequence contentDescription = this.f120a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f120a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f120a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            bc.a(this, z3 ? null : this.f120a.getTitle());
        } else {
            bc.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void a(j jVar, int i) {
        this.f120a = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a((o.a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.h == null) {
            this.h = new a();
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void a(boolean z, char c) {
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean a() {
        return true;
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.o.a
    public boolean c() {
        return true;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean d() {
        return b() && this.f120a.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean e() {
        return b();
    }

    @Override // androidx.appcompat.view.menu.o.a
    public j getItemData() {
        return this.f120a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b != null) {
            this.b.a(this.f120a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.i = f();
        g();
    }

    @Override // androidx.appcompat.widget.aa, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean zB = b();
        if (zB && this.l >= 0) {
            super.setPadding(this.l, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.k) : this.k;
        if (mode != 1073741824 && this.k > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, androidx.d.c.b.a.b.b), i2);
        }
        if (zB || this.g == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.g.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f120a.hasSubMenu() && this.h != null && this.h.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setCheckable(boolean z) {
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.j != z) {
            this.j = z;
            if (this.f120a != null) {
                this.f120a.i();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setIcon(Drawable drawable) {
        this.g = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.n) {
                float f = this.n / intrinsicWidth;
                intrinsicWidth = this.n;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.n) {
                float f2 = this.n / intrinsicHeight;
                intrinsicHeight = this.n;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(g.b bVar) {
        this.b = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.l = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.c = bVar;
    }

    @Override // androidx.appcompat.view.menu.o.a
    public void setTitle(CharSequence charSequence) {
        this.f = charSequence;
        g();
    }
}
