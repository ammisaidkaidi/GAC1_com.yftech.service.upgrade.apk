package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class ar extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final String g = "ScrollingTabContainerView";
    private static final Interpolator m = new DecelerateInterpolator();
    private static final int n = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f226a;
    aj b;
    int c;
    int d;
    protected ViewPropertyAnimator e;
    protected final d f;
    private b h;
    private Spinner i;
    private boolean j;
    private int k;
    private int l;

    private class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ar.this.b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) ar.this.b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ar.this.a((androidx.appcompat.app.a.f) getItem(i), true);
            }
            ((c) view).a((androidx.appcompat.app.a.f) getItem(i));
            return view;
        }
    }

    private class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().f();
            int childCount = ar.this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ar.this.b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class c extends LinearLayout {
        private static final String g = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] b;
        private androidx.appcompat.app.a.f c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, androidx.appcompat.app.a.f fVar, boolean z) {
            super(context, null, androidx.appcompat.a.b.actionBarTabStyle);
            this.b = new int[]{R.attr.background};
            this.c = fVar;
            ba baVarA = ba.a(context, null, this.b, androidx.appcompat.a.b.actionBarTabStyle, 0);
            if (baVarA.j(0)) {
                setBackgroundDrawable(baVarA.a(0));
            }
            baVarA.f();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a() {
            androidx.appcompat.app.a.f fVar = this.c;
            View viewD = fVar.d();
            if (viewD != null) {
                ViewParent parent = viewD.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewD);
                    }
                    addView(viewD);
                }
                this.f = viewD;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable drawableB = fVar.b();
            CharSequence charSequenceC = fVar.c();
            if (drawableB != null) {
                if (this.e == null) {
                    p pVar = new p(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    pVar.setLayoutParams(layoutParams);
                    addView(pVar, 0);
                    this.e = pVar;
                }
                this.e.setImageDrawable(drawableB);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceC);
            if (z) {
                if (this.d == null) {
                    aa aaVar = new aa(getContext(), null, androidx.appcompat.a.b.actionBarTabTextStyle);
                    aaVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    aaVar.setLayoutParams(layoutParams2);
                    addView(aaVar);
                    this.d = aaVar;
                }
                this.d.setText(charSequenceC);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText((CharSequence) null);
            }
            if (this.e != null) {
                this.e.setContentDescription(fVar.g());
            }
            bc.a(this, z ? null : fVar.g());
        }

        public void a(androidx.appcompat.app.a.f fVar) {
            this.c = fVar;
            a();
        }

        public androidx.appcompat.app.a.f b() {
            return this.c;
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
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ar.this.c <= 0 || getMeasuredWidth() <= ar.this.c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ar.this.c, androidx.d.c.b.a.b.b), i2);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class d extends AnimatorListenerAdapter {
        private boolean b = false;
        private int c;

        protected d() {
        }

        public d a(ViewPropertyAnimator viewPropertyAnimator, int i) {
            this.c = i;
            ar.this.e = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.b) {
                return;
            }
            ar.this.e = null;
            ar.this.setVisibility(this.c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ar.this.setVisibility(0);
            this.b = false;
        }
    }

    public ar(@androidx.annotation.ah Context context) {
        super(context);
        this.f = new d();
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(context);
        setContentHeight(aVarA.e());
        this.d = aVarA.g();
        this.b = e();
        addView(this.b, new ViewGroup.LayoutParams(-2, -1));
    }

    private boolean b() {
        return this.i != null && this.i.getParent() == this;
    }

    private void c() {
        if (b()) {
            return;
        }
        if (this.i == null) {
            this.i = f();
        }
        removeView(this.b);
        addView(this.i, new ViewGroup.LayoutParams(-2, -1));
        if (this.i.getAdapter() == null) {
            this.i.setAdapter((SpinnerAdapter) new a());
        }
        if (this.f226a != null) {
            removeCallbacks(this.f226a);
            this.f226a = null;
        }
        this.i.setSelection(this.l);
    }

    private boolean d() {
        if (!b()) {
            return false;
        }
        removeView(this.i);
        addView(this.b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.i.getSelectedItemPosition());
        return false;
    }

    private aj e() {
        aj ajVar = new aj(getContext(), null, androidx.appcompat.a.b.actionBarTabBarStyle);
        ajVar.setMeasureWithLargestChildEnabled(true);
        ajVar.setGravity(17);
        ajVar.setLayoutParams(new aj.b(-2, -1));
        return ajVar;
    }

    private Spinner f() {
        x xVar = new x(getContext(), null, androidx.appcompat.a.b.actionDropDownStyle);
        xVar.setLayoutParams(new aj.b(-2, -1));
        xVar.setOnItemSelectedListener(this);
        return xVar;
    }

    c a(androidx.appcompat.app.a.f fVar, boolean z) {
        c cVar = new c(getContext(), fVar, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.k));
        } else {
            cVar.setFocusable(true);
            if (this.h == null) {
                this.h = new b();
            }
            cVar.setOnClickListener(this.h);
        }
        return cVar;
    }

    public void a() {
        this.b.removeAllViews();
        if (this.i != null) {
            ((a) this.i.getAdapter()).notifyDataSetChanged();
        }
        if (this.j) {
            requestLayout();
        }
    }

    public void a(int i) {
        if (this.e != null) {
            this.e.cancel();
        }
        if (i != 0) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(0.0f);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(m);
            viewPropertyAnimatorAlpha.setListener(this.f.a(viewPropertyAnimatorAlpha, i));
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(m);
        viewPropertyAnimatorAlpha2.setListener(this.f.a(viewPropertyAnimatorAlpha2, i));
        viewPropertyAnimatorAlpha2.start();
    }

    public void a(androidx.appcompat.app.a.f fVar, int i, boolean z) {
        c cVarA = a(fVar, false);
        this.b.addView(cVarA, i, new aj.b(0, -1, 1.0f));
        if (this.i != null) {
            ((a) this.i.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            cVarA.setSelected(true);
        }
        if (this.j) {
            requestLayout();
        }
    }

    public void b(int i) {
        final View childAt = this.b.getChildAt(i);
        if (this.f226a != null) {
            removeCallbacks(this.f226a);
        }
        this.f226a = new Runnable() { // from class: androidx.appcompat.widget.ar.1
            @Override // java.lang.Runnable
            public void run() {
                ar.this.smoothScrollTo(childAt.getLeft() - ((ar.this.getWidth() - childAt.getWidth()) / 2), 0);
                ar.this.f226a = null;
            }
        };
        post(this.f226a);
    }

    public void b(androidx.appcompat.app.a.f fVar, boolean z) {
        c cVarA = a(fVar, false);
        this.b.addView(cVarA, new aj.b(0, -1, 1.0f));
        if (this.i != null) {
            ((a) this.i.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            cVarA.setSelected(true);
        }
        if (this.j) {
            requestLayout();
        }
    }

    public void c(int i) {
        ((c) this.b.getChildAt(i)).a();
        if (this.i != null) {
            ((a) this.i.getAdapter()).notifyDataSetChanged();
        }
        if (this.j) {
            requestLayout();
        }
    }

    public void d(int i) {
        this.b.removeViewAt(i);
        if (this.i != null) {
            ((a) this.i.getAdapter()).notifyDataSetChanged();
        }
        if (this.j) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f226a != null) {
            post(this.f226a);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(getContext());
        setContentHeight(aVarA.e());
        this.d = aVarA.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f226a != null) {
            removeCallbacks(this.f226a);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).b().f();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.c = -1;
        } else {
            if (childCount > 2) {
                this.c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.k, androidx.d.c.b.a.b.b);
        if (!z && this.j) {
            this.b.measure(0, iMakeMeasureSpec);
            if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                c();
            } else {
                d();
            }
        } else {
            d();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.l);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.j = z;
    }

    public void setContentHeight(int i) {
        this.k = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.l = i;
        int childCount = this.b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                b(i);
            }
            i2++;
        }
        if (this.i == null || i < 0) {
            return;
        }
        this.i.setSelection(i);
    }
}
