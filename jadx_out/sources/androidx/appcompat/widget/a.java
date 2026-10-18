package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends ViewGroup {
    private static final int g = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0017a f195a;
    protected final Context b;
    protected ActionMenuView c;
    protected c d;
    protected int e;
    protected androidx.core.n.aj f;
    private boolean h;
    private boolean i;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0017a implements androidx.core.n.ak {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f197a;
        private boolean c = false;

        protected C0017a() {
        }

        public C0017a a(androidx.core.n.aj ajVar, int i) {
            a.this.f = ajVar;
            this.f197a = i;
            return this;
        }

        @Override // androidx.core.n.ak
        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        @Override // androidx.core.n.ak
        public void b(View view) {
            if (this.c) {
                return;
            }
            a.this.f = null;
            a.super.setVisibility(this.f197a);
        }

        @Override // androidx.core.n.ak
        public void c(View view) {
            this.c = true;
        }
    }

    a(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    a(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f195a = new C0017a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.appcompat.a.b.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public androidx.core.n.aj a(int i, long j) {
        if (this.f != null) {
            this.f.d();
        }
        if (i != 0) {
            androidx.core.n.aj ajVarA = androidx.core.n.af.F(this).a(0.0f);
            ajVarA.a(j);
            ajVarA.a(this.f195a.a(ajVarA, i));
            return ajVarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.n.aj ajVarA2 = androidx.core.n.af.F(this).a(1.0f);
        ajVarA2.a(j);
        ajVarA2.a(this.f195a.a(ajVarA2, i));
        return ajVarA2;
    }

    public void a(int i) {
        a(i, 200L).e();
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.e();
        }
        return false;
    }

    public void b() {
        post(new Runnable() { // from class: androidx.appcompat.widget.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
            }
        });
    }

    public boolean c() {
        if (this.d != null) {
            return this.d.g();
        }
        return false;
    }

    public boolean d() {
        if (this.d != null) {
            return this.d.j();
        }
        return false;
    }

    public boolean e() {
        if (this.d != null) {
            return this.d.k();
        }
        return false;
    }

    public boolean f() {
        return this.d != null && this.d.l();
    }

    public boolean g() {
        return f() && getVisibility() == 0;
    }

    public int getAnimatedVisibility() {
        return this.f != null ? this.f195a.f197a : getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    public void h() {
        if (this.d != null) {
            this.d.h();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, androidx.appcompat.a.m.ActionBar, androidx.appcompat.a.b.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(androidx.appcompat.a.m.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.e = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f != null) {
                this.f.d();
            }
            super.setVisibility(i);
        }
    }
}
