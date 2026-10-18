package com.google.android.material.x;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ac;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.annotation.as;
import androidx.annotation.p;
import androidx.annotation.q;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.bc;
import androidx.core.n.aa;
import androidx.core.n.af;
import com.google.android.material.internal.s;
import com.google.android.material.internal.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@androidx.l.a.d.a
public class b extends HorizontalScrollView {

    @p(a = 0)
    private static final int M = 72;

    @p(a = 0)
    private static final int N = 48;

    @p(a = 0)
    private static final int O = 56;

    @p(a = 0)
    private static final int P = 24;
    private static final int Q = -1;
    private static final int R = 300;
    private static final String T = "TabLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p(a = 0)
    static final int f1490a = 8;

    @p(a = 0)
    static final int b = 16;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    float A;
    final int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    boolean H;
    boolean I;
    boolean J;

    @ai
    androidx.l.a.d K;
    private final ArrayList<h> U;

    @ai
    private h V;
    private final RectF W;
    private final int aa;
    private final int ab;
    private final int ac;
    private int ad;

    @ai
    private InterfaceC0097b ae;
    private final ArrayList<InterfaceC0097b> af;

    @ai
    private InterfaceC0097b ag;
    private ValueAnimator ah;

    @ai
    private androidx.l.a.a ai;
    private DataSetObserver aj;
    private k ak;
    private a al;
    private boolean am;
    private final androidx.core.m.h.a<l> an;

    @ah
    final g o;
    int p;
    int q;
    int r;
    int s;
    int t;
    ColorStateList u;
    ColorStateList v;
    ColorStateList w;

    @ai
    Drawable x;
    PorterDuff.Mode y;
    float z;
    private static final int L = com.google.android.material.a.n.Widget_Design_TabLayout;
    private static final androidx.core.m.h.a<h> S = new androidx.core.m.h.c(16);

    private class a implements androidx.l.a.d.e {
        private boolean b;

        a() {
        }

        @Override // androidx.l.a.d.e
        public void a(@ah androidx.l.a.d dVar, @ai androidx.l.a.a aVar, @ai androidx.l.a.a aVar2) {
            if (b.this.K == dVar) {
                b.this.a(aVar2, this.b);
            }
        }

        void a(boolean z) {
            this.b = z;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.x.b$b, reason: collision with other inner class name */
    @Deprecated
    public interface InterfaceC0097b<T extends h> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface d {
    }

    public interface e extends InterfaceC0097b<h> {
    }

    private class f extends DataSetObserver {
        f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            b.this.h();
        }
    }

    class g extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1494a;
        float b;
        int c;
        int d;
        ValueAnimator e;
        private int g;

        @ah
        private final Paint h;

        @ah
        private final GradientDrawable i;
        private int j;
        private int k;
        private int l;

        g(Context context) {
            super(context);
            this.f1494a = -1;
            this.j = -1;
            this.c = -1;
            this.d = -1;
            this.k = -1;
            this.l = -1;
            setWillNotDraw(false);
            this.h = new Paint();
            this.i = new GradientDrawable();
        }

        private void a(@ah l lVar, @ah RectF rectF) {
            int contentWidth = lVar.getContentWidth();
            int iA = (int) z.a(getContext(), 24);
            if (contentWidth >= iA) {
                iA = contentWidth;
            }
            int left = (lVar.getLeft() + lVar.getRight()) / 2;
            int i = iA / 2;
            rectF.set(left - i, 0.0f, left + i, 0.0f);
        }

        private void a(boolean z, final int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                c();
                return;
            }
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (!b.this.I && (childAt instanceof l)) {
                a((l) childAt, b.this.W);
                left = (int) b.this.W.left;
                right = (int) b.this.W.right;
            }
            int i3 = this.c;
            int i4 = this.d;
            if (i3 == left && i4 == right) {
                return;
            }
            if (z) {
                this.k = i3;
                this.l = i4;
            }
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.x.b.g.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@ah ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    g.this.a(com.google.android.material.a.a.a(g.this.k, left, animatedFraction), com.google.android.material.a.a.a(g.this.l, right, animatedFraction));
                }
            };
            if (!z) {
                this.e.removeAllUpdateListeners();
                this.e.addUpdateListener(animatorUpdateListener);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.e = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.a.a.b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(animatorUpdateListener);
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.x.b.g.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    g.this.f1494a = i;
                    g.this.b = 0.0f;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    g.this.f1494a = i;
                }
            });
            valueAnimator.start();
        }

        private void c() {
            int left;
            int right;
            View childAt = getChildAt(this.f1494a);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                if (!b.this.I && (childAt instanceof l)) {
                    a((l) childAt, b.this.W);
                    left = (int) b.this.W.left;
                    right = (int) b.this.W.right;
                }
                if (this.b > 0.0f && this.f1494a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f1494a + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    if (!b.this.I && (childAt2 instanceof l)) {
                        a((l) childAt2, b.this.W);
                        left2 = (int) b.this.W.left;
                        right2 = (int) b.this.W.right;
                    }
                    left = (int) ((this.b * left2) + ((1.0f - this.b) * left));
                    right = (int) ((this.b * right2) + ((1.0f - this.b) * right));
                }
            }
            a(left, right);
        }

        void a(int i) {
            if (this.h.getColor() != i) {
                this.h.setColor(i);
                af.h(this);
            }
        }

        void a(int i, float f) {
            if (this.e != null && this.e.isRunning()) {
                this.e.cancel();
            }
            this.f1494a = i;
            this.b = f;
            c();
        }

        void a(int i, int i2) {
            if (i == this.c && i2 == this.d) {
                return;
            }
            this.c = i;
            this.d = i2;
            af.h(this);
        }

        boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float b() {
            return this.f1494a + this.b;
        }

        void b(int i) {
            if (this.g != i) {
                this.g = i;
                af.h(this);
            }
        }

        void b(int i, int i2) {
            if (this.e != null && this.e.isRunning()) {
                this.e.cancel();
            }
            a(true, i, i2);
        }

        @Override // android.view.View
        public void draw(@ah Canvas canvas) {
            int height = 0;
            int intrinsicHeight = b.this.x != null ? b.this.x.getIntrinsicHeight() : 0;
            if (this.g >= 0) {
                intrinsicHeight = this.g;
            }
            switch (b.this.F) {
                case 0:
                    height = getHeight() - intrinsicHeight;
                    intrinsicHeight = getHeight();
                    break;
                case 1:
                    height = (getHeight() - intrinsicHeight) / 2;
                    intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
                    break;
                case 2:
                    break;
                case 3:
                    intrinsicHeight = getHeight();
                    break;
                default:
                    intrinsicHeight = 0;
                    break;
            }
            if (this.c >= 0 && this.d > this.c) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.g(b.this.x != null ? b.this.x : this.i).mutate();
                drawableMutate.setBounds(this.c, height, this.d, intrinsicHeight);
                if (this.h != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        drawableMutate.setColorFilter(this.h.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(drawableMutate, this.h.getColor());
                    }
                }
                drawableMutate.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.e == null || !this.e.isRunning()) {
                c();
            } else {
                a(false, this.f1494a, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            boolean z;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            if (b.this.D == 1 || b.this.G == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) z.a(getContext(), 16)) * 2)) {
                    z = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z = true;
                        }
                    }
                } else {
                    b.this.D = 0;
                    b.this.a(false);
                    z = true;
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.j == i) {
                return;
            }
            requestLayout();
            this.j = i;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1497a = -1;

        @ai
        public b b;

        @ah
        public l c;

        @ai
        private Object d;

        @ai
        private Drawable e;

        @ai
        private CharSequence f;

        @ai
        private CharSequence g;

        @ai
        private View i;
        private int h = -1;

        @c
        private int j = 1;

        @ah
        public h a(@ac int i) {
            return a(LayoutInflater.from(this.c.getContext()).inflate(i, (ViewGroup) this.c, false));
        }

        @ah
        public h a(@ai Drawable drawable) {
            this.e = drawable;
            if (this.b.D == 1 || this.b.G == 2) {
                this.b.a(true);
            }
            m();
            if (com.google.android.material.b.b.f1176a && this.c.j() && this.c.f.isVisible()) {
                this.c.invalidate();
            }
            return this;
        }

        @ah
        public h a(@ai View view) {
            this.i = view;
            m();
            return this;
        }

        @ah
        public h a(@ai CharSequence charSequence) {
            if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(charSequence)) {
                this.c.setContentDescription(charSequence);
            }
            this.f = charSequence;
            m();
            return this;
        }

        @ah
        public h a(@ai Object obj) {
            this.d = obj;
            return this;
        }

        @ai
        public Object a() {
            return this.d;
        }

        @ai
        public View b() {
            return this.i;
        }

        @ah
        public h b(@ai CharSequence charSequence) {
            this.g = charSequence;
            m();
            return this;
        }

        void b(int i) {
            this.h = i;
        }

        @ai
        public Drawable c() {
            return this.e;
        }

        @ah
        public h c(@q int i) {
            if (this.b != null) {
                return a(androidx.appcompat.a.a.a.b(this.b.getContext(), i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public int d() {
            return this.h;
        }

        @ah
        public h d(@as int i) {
            if (this.b != null) {
                return a(this.b.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @ah
        public h e(@c int i) {
            this.j = i;
            if (this.b.D == 1 || this.b.G == 2) {
                this.b.a(true);
            }
            m();
            if (com.google.android.material.b.b.f1176a && this.c.j() && this.c.f.isVisible()) {
                this.c.invalidate();
            }
            return this;
        }

        @ai
        public CharSequence e() {
            return this.f;
        }

        @ah
        public com.google.android.material.b.a f() {
            return this.c.getOrCreateBadge();
        }

        @ah
        public h f(@as int i) {
            if (this.b != null) {
                return b(this.b.getResources().getText(i));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void g() {
            this.c.g();
        }

        @ai
        public com.google.android.material.b.a h() {
            return this.c.getBadge();
        }

        @c
        public int i() {
            return this.j;
        }

        public void j() {
            if (this.b == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.b.d(this);
        }

        public boolean k() {
            if (this.b != null) {
                return this.b.getSelectedTabPosition() == this.h;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @ai
        public CharSequence l() {
            if (this.c == null) {
                return null;
            }
            return this.c.getContentDescription();
        }

        void m() {
            if (this.c != null) {
                this.c.b();
            }
        }

        void n() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = -1;
            this.i = null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface i {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface j {
    }

    public static class k implements androidx.l.a.d.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ah
        private final WeakReference<b> f1498a;
        private int b;
        private int c;

        public k(b bVar) {
            this.f1498a = new WeakReference<>(bVar);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.l.a.d.f
        public void a(int i) {
            b bVar = this.f1498a.get();
            if (bVar == null || bVar.getSelectedTabPosition() == i || i >= bVar.getTabCount()) {
                return;
            }
            bVar.b(bVar.a(i), this.c == 0 || (this.c == 2 && this.b == 0));
        }

        @Override // androidx.l.a.d.f
        public void a(int i, float f, int i2) {
            b bVar = this.f1498a.get();
            if (bVar != null) {
                bVar.a(i, f, this.c != 2 || this.b == 1, (this.c == 2 && this.b == 0) ? false : true);
            }
        }

        @Override // androidx.l.a.d.f
        public void b(int i) {
            this.b = this.c;
            this.c = i;
        }
    }

    public final class l extends LinearLayout {
        private h b;
        private TextView c;
        private ImageView d;

        @ai
        private View e;

        @ai
        private com.google.android.material.b.a f;

        @ai
        private View g;

        @ai
        private TextView h;

        @ai
        private ImageView i;

        @ai
        private Drawable j;
        private int k;

        public l(@ah Context context) {
            super(context);
            this.k = 2;
            a(context);
            af.b(this, b.this.p, b.this.q, b.this.r, b.this.s);
            setGravity(17);
            setOrientation(!b.this.H ? 1 : 0);
            setClickable(true);
            af.a(this, aa.a(getContext(), aa.d));
        }

        private float a(@ah Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context) {
            if (b.this.B != 0) {
                this.j = androidx.appcompat.a.a.a.b(context, b.this.B);
                if (this.j != null && this.j.isStateful()) {
                    this.j.setState(getDrawableState());
                }
            } else {
                this.j = null;
            }
            Drawable gradientDrawable = new GradientDrawable();
            ((GradientDrawable) gradientDrawable).setColor(0);
            if (b.this.w != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListA = com.google.android.material.r.b.a(b.this.w);
                if (Build.VERSION.SDK_INT >= 21) {
                    if (b.this.J) {
                        gradientDrawable = null;
                    }
                    if (b.this.J) {
                        gradientDrawable2 = null;
                    }
                    gradientDrawable = new RippleDrawable(colorStateListA, gradientDrawable, gradientDrawable2);
                } else {
                    Drawable drawableG = androidx.core.graphics.drawable.a.g(gradientDrawable2);
                    androidx.core.graphics.drawable.a.a(drawableG, colorStateListA);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableG});
                }
            }
            af.a(this, gradientDrawable);
            b.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(@ah Canvas canvas) {
            if (this.j != null) {
                this.j.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.j.draw(canvas);
            }
        }

        private void a(@ai final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.x.b.l.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (view.getVisibility() == 0) {
                        l.this.c(view);
                    }
                }
            });
        }

        private void a(@ai TextView textView, @ai ImageView imageView) {
            Drawable drawableMutate = (this.b == null || this.b.c() == null) ? null : androidx.core.graphics.drawable.a.g(this.b.c()).mutate();
            CharSequence charSequenceE = this.b != null ? this.b.e() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequenceE);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequenceE);
                    if (this.b.j == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iA = (z && imageView.getVisibility() == 0) ? (int) z.a(getContext(), 8) : 0;
                if (b.this.H) {
                    if (iA != androidx.core.n.m.b(marginLayoutParams)) {
                        androidx.core.n.m.b(marginLayoutParams, iA);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iA != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iA;
                    androidx.core.n.m.b(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            CharSequence charSequence = this.b != null ? this.b.g : null;
            if (z) {
                charSequence = null;
            }
            bc.a(this, charSequence);
        }

        private void a(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        private void b(@ai View view) {
            if (j() && view != null) {
                a(false);
                com.google.android.material.b.b.a(this.f, view, d(view));
                this.e = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(@ah View view) {
            if (j() && view == this.e) {
                com.google.android.material.b.b.c(this.f, view, d(view));
            }
        }

        @ai
        private FrameLayout d(@ah View view) {
            if ((view == this.d || view == this.c) && com.google.android.material.b.b.f1176a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        private void d() {
            FrameLayout frameLayoutF;
            if (com.google.android.material.b.b.f1176a) {
                frameLayoutF = f();
                addView(frameLayoutF, 0);
            } else {
                frameLayoutF = this;
            }
            this.d = (ImageView) LayoutInflater.from(getContext()).inflate(com.google.android.material.a.k.design_layout_tab_icon, (ViewGroup) frameLayoutF, false);
            frameLayoutF.addView(this.d, 0);
        }

        private void e() {
            FrameLayout frameLayoutF;
            if (com.google.android.material.b.b.f1176a) {
                frameLayoutF = f();
                addView(frameLayoutF);
            } else {
                frameLayoutF = this;
            }
            this.c = (TextView) LayoutInflater.from(getContext()).inflate(com.google.android.material.a.k.design_layout_tab_text, (ViewGroup) frameLayoutF, false);
            frameLayoutF.addView(this.c);
        }

        @ah
        private FrameLayout f() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            if (this.e != null) {
                i();
            }
            this.f = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ai
        public com.google.android.material.b.a getBadge() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (View view : new View[]{this.c, this.d, this.g}) {
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @ah
        public com.google.android.material.b.a getOrCreateBadge() {
            if (this.f == null) {
                this.f = com.google.android.material.b.a.a(getContext());
            }
            h();
            if (this.f != null) {
                return this.f;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h() {
            if (j()) {
                if (this.g != null) {
                    i();
                    return;
                }
                if (this.d != null && this.b != null && this.b.c() != null) {
                    if (this.e == this.d) {
                        c(this.d);
                        return;
                    } else {
                        i();
                        b(this.d);
                        return;
                    }
                }
                if (this.c == null || this.b == null || this.b.i() != 1) {
                    i();
                } else if (this.e == this.c) {
                    c(this.c);
                } else {
                    i();
                    b(this.c);
                }
            }
        }

        private void i() {
            if (j()) {
                a(true);
                if (this.e != null) {
                    com.google.android.material.b.b.b(this.f, this.e, d(this.e));
                    this.e = null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j() {
            return this.f != null;
        }

        void a() {
            setTab(null);
            setSelected(false);
        }

        final void b() {
            h hVar = this.b;
            Drawable drawableMutate = null;
            View viewB = hVar != null ? hVar.b() : null;
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.g = viewB;
                if (this.c != null) {
                    this.c.setVisibility(8);
                }
                if (this.d != null) {
                    this.d.setVisibility(8);
                    this.d.setImageDrawable(null);
                }
                this.h = (TextView) viewB.findViewById(R.id.text1);
                if (this.h != null) {
                    this.k = androidx.core.widget.m.a(this.h);
                }
                this.i = (ImageView) viewB.findViewById(R.id.icon);
            } else {
                if (this.g != null) {
                    removeView(this.g);
                    this.g = null;
                }
                this.h = null;
                this.i = null;
            }
            if (this.g == null) {
                if (this.d == null) {
                    d();
                }
                if (hVar != null && hVar.c() != null) {
                    drawableMutate = androidx.core.graphics.drawable.a.g(hVar.c()).mutate();
                }
                if (drawableMutate != null) {
                    androidx.core.graphics.drawable.a.a(drawableMutate, b.this.v);
                    if (b.this.y != null) {
                        androidx.core.graphics.drawable.a.a(drawableMutate, b.this.y);
                    }
                }
                if (this.c == null) {
                    e();
                    this.k = androidx.core.widget.m.a(this.c);
                }
                androidx.core.widget.m.a(this.c, b.this.t);
                if (b.this.u != null) {
                    this.c.setTextColor(b.this.u);
                }
                a(this.c, this.d);
                h();
                a(this.d);
                a(this.c);
            } else if (this.h != null || this.i != null) {
                a(this.h, this.i);
            }
            if (hVar != null && !TextUtils.isEmpty(hVar.g)) {
                setContentDescription(hVar.g);
            }
            setSelected(hVar != null && hVar.k());
        }

        final void c() {
            setOrientation(!b.this.H ? 1 : 0);
            if (this.h == null && this.i == null) {
                a(this.c, this.d);
            } else {
                a(this.h, this.i);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            boolean state = false;
            if (this.j != null && this.j.isStateful()) {
                state = false | this.j.setState(drawableState);
            }
            if (state) {
                invalidate();
                b.this.invalidate();
            }
        }

        @ai
        public h getTab() {
            return this.b;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (this.f != null && this.f.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f.j()));
            }
            androidx.core.n.a.d dVarA = androidx.core.n.a.d.a(accessibilityNodeInfo);
            dVarA.c(androidx.core.n.a.d.c.a(0, 1, this.b.d(), 1, false, isSelected()));
            if (isSelected()) {
                dVarA.h(false);
                dVarA.b(androidx.core.n.a.d.a.e);
            }
            dVarA.j("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = b.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(b.this.C, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.c != null) {
                float f = b.this.z;
                int i3 = this.k;
                boolean z = true;
                if (this.d != null && this.d.getVisibility() == 0) {
                    i3 = 1;
                } else if (this.c != null && this.c.getLineCount() > 1) {
                    f = b.this.A;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int iA = androidx.core.widget.m.a(this.c);
                if (f != textSize || (iA >= 0 && i3 != iA)) {
                    if (b.this.G == 1 && f > textSize && lineCount == 1 && ((layout = this.c.getLayout()) == null || a(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.c.setTextSize(0, f);
                        this.c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.b == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.b.j();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.c != null) {
                this.c.setSelected(z);
            }
            if (this.d != null) {
                this.d.setSelected(z);
            }
            if (this.g != null) {
                this.g.setSelected(z);
            }
        }

        void setTab(@ai h hVar) {
            if (hVar != this.b) {
                this.b = hVar;
                b();
            }
        }
    }

    public static class m implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.l.a.d f1501a;

        public m(androidx.l.a.d dVar) {
            this.f1501a = dVar;
        }

        @Override // com.google.android.material.x.b.InterfaceC0097b
        public void a(@ah h hVar) {
            this.f1501a.setCurrentItem(hVar.d());
        }

        @Override // com.google.android.material.x.b.InterfaceC0097b
        public void b(h hVar) {
        }

        @Override // com.google.android.material.x.b.InterfaceC0097b
        public void c(h hVar) {
        }
    }

    public b(@ah Context context) {
        this(context, null);
    }

    public b(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.tabStyle);
    }

    public b(@ah Context context, @ai AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, L), attributeSet, i2);
        this.U = new ArrayList<>();
        this.W = new RectF();
        this.C = ActivityChooserView.a.f166a;
        this.af = new ArrayList<>();
        this.an = new androidx.core.m.h.b(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        this.o = new g(context2);
        super.addView(this.o, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayA = s.a(context2, attributeSet, com.google.android.material.a.o.TabLayout, i2, L, com.google.android.material.a.o.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            com.google.android.material.t.j jVar = new com.google.android.material.t.j();
            jVar.g(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.b(context2);
            jVar.r(af.P(this));
            af.a(this, jVar);
        }
        this.o.b(typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabIndicatorHeight, -1));
        this.o.a(typedArrayA.getColor(com.google.android.material.a.o.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.q.c.b(context2, typedArrayA, com.google.android.material.a.o.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayA.getInt(com.google.android.material.a.o.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayA.getBoolean(com.google.android.material.a.o.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabPadding, 0);
        this.s = dimensionPixelSize;
        this.r = dimensionPixelSize;
        this.q = dimensionPixelSize;
        this.p = dimensionPixelSize;
        this.p = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabPaddingStart, this.p);
        this.q = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabPaddingTop, this.q);
        this.r = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabPaddingEnd, this.r);
        this.s = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabPaddingBottom, this.s);
        this.t = typedArrayA.getResourceId(com.google.android.material.a.o.TabLayout_tabTextAppearance, com.google.android.material.a.n.TextAppearance_Design_Tab);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(this.t, androidx.appcompat.a.m.TextAppearance);
        try {
            this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.a.m.TextAppearance_android_textSize, 0);
            this.u = com.google.android.material.q.c.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.a.m.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayA.hasValue(com.google.android.material.a.o.TabLayout_tabTextColor)) {
                this.u = com.google.android.material.q.c.a(context2, typedArrayA, com.google.android.material.a.o.TabLayout_tabTextColor);
            }
            if (typedArrayA.hasValue(com.google.android.material.a.o.TabLayout_tabSelectedTextColor)) {
                this.u = b(this.u.getDefaultColor(), typedArrayA.getColor(com.google.android.material.a.o.TabLayout_tabSelectedTextColor, 0));
            }
            this.v = com.google.android.material.q.c.a(context2, typedArrayA, com.google.android.material.a.o.TabLayout_tabIconTint);
            this.y = z.a(typedArrayA.getInt(com.google.android.material.a.o.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.w = com.google.android.material.q.c.a(context2, typedArrayA, com.google.android.material.a.o.TabLayout_tabRippleColor);
            this.E = typedArrayA.getInt(com.google.android.material.a.o.TabLayout_tabIndicatorAnimationDuration, R);
            this.aa = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabMinWidth, -1);
            this.ab = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabMaxWidth, -1);
            this.B = typedArrayA.getResourceId(com.google.android.material.a.o.TabLayout_tabBackground, 0);
            this.ad = typedArrayA.getDimensionPixelSize(com.google.android.material.a.o.TabLayout_tabContentStart, 0);
            this.G = typedArrayA.getInt(com.google.android.material.a.o.TabLayout_tabMode, 1);
            this.D = typedArrayA.getInt(com.google.android.material.a.o.TabLayout_tabGravity, 0);
            this.H = typedArrayA.getBoolean(com.google.android.material.a.o.TabLayout_tabInlineLabel, false);
            this.J = typedArrayA.getBoolean(com.google.android.material.a.o.TabLayout_tabUnboundedRipple, false);
            typedArrayA.recycle();
            Resources resources = getResources();
            this.A = resources.getDimensionPixelSize(com.google.android.material.a.f.design_tab_text_size_2line);
            this.ac = resources.getDimensionPixelSize(com.google.android.material.a.f.design_tab_scrollable_min_width);
            l();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int a(int i2, float f2) {
        if (this.G != 0 && this.G != 2) {
            return 0;
        }
        View childAt = this.o.getChildAt(i2);
        int i3 = i2 + 1;
        View childAt2 = i3 < this.o.getChildCount() ? this.o.getChildAt(i3) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f2);
        return af.p(this) == 0 ? left + i4 : left - i4;
    }

    private void a(View view) {
        if (!(view instanceof com.google.android.material.x.a)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        a((com.google.android.material.x.a) view);
    }

    private void a(@ah LinearLayout.LayoutParams layoutParams) {
        if (this.G == 1 && this.D == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private void a(@ai androidx.l.a.d dVar, boolean z, boolean z2) {
        if (this.K != null) {
            if (this.ak != null) {
                this.K.b(this.ak);
            }
            if (this.al != null) {
                this.K.b(this.al);
            }
        }
        if (this.ag != null) {
            b(this.ag);
            this.ag = null;
        }
        if (dVar != null) {
            this.K = dVar;
            if (this.ak == null) {
                this.ak = new k(this);
            }
            this.ak.a();
            dVar.a(this.ak);
            this.ag = new m(dVar);
            a(this.ag);
            androidx.l.a.a adapter = dVar.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.al == null) {
                this.al = new a();
            }
            this.al.a(z);
            dVar.a(this.al);
            a(dVar.getCurrentItem(), 0.0f, true);
        } else {
            this.K = null;
            a((androidx.l.a.a) null, false);
        }
        this.am = z2;
    }

    private void a(@ah com.google.android.material.x.a aVar) {
        h hVarB = b();
        if (aVar.f1489a != null) {
            hVarB.a(aVar.f1489a);
        }
        if (aVar.b != null) {
            hVarB.a(aVar.b);
        }
        if (aVar.c != 0) {
            hVarB.a(aVar.c);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            hVarB.b(aVar.getContentDescription());
        }
        a(hVarB);
    }

    @ah
    private static ColorStateList b(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void b(@ah h hVar, int i2) {
        hVar.b(i2);
        this.U.add(i2, hVar);
        int size = this.U.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.U.get(i2).b(i2);
            }
        }
    }

    private void c(int i2) {
        l lVar = (l) this.o.getChildAt(i2);
        this.o.removeViewAt(i2);
        if (lVar != null) {
            lVar.a();
            this.an.a(lVar);
        }
        requestLayout();
    }

    private void d(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !af.ag(this) || this.o.a()) {
            a(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iA = a(i2, 0.0f);
        if (scrollX != iA) {
            k();
            this.ah.setIntValues(scrollX, iA);
            this.ah.start();
        }
        this.o.b(i2, this.E);
    }

    @ah
    private l e(@ah h hVar) {
        l lVarA = this.an != null ? this.an.a() : null;
        if (lVarA == null) {
            lVarA = new l(getContext());
        }
        lVarA.setTab(hVar);
        lVarA.setFocusable(true);
        lVarA.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(hVar.g)) {
            lVarA.setContentDescription(hVar.f);
        } else {
            lVarA.setContentDescription(hVar.g);
        }
        return lVarA;
    }

    private void e(int i2) {
        switch (i2) {
            case 0:
                Log.w(T, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
                break;
            case 1:
                this.o.setGravity(1);
                return;
            case 2:
                break;
            default:
                return;
        }
        this.o.setGravity(androidx.core.n.h.b);
    }

    private void f(@ah h hVar) {
        l lVar = hVar.c;
        lVar.setSelected(false);
        lVar.setActivated(false);
        this.o.addView(lVar, hVar.d(), j());
    }

    private void g(@ah h hVar) {
        for (int size = this.af.size() - 1; size >= 0; size--) {
            this.af.get(size).a(hVar);
        }
    }

    @p(a = 0)
    private int getDefaultHeight() {
        int size = this.U.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.U.get(i2);
            if (hVar != null && hVar.c() != null && !TextUtils.isEmpty(hVar.e())) {
                z = true;
                break;
            }
        }
        return (!z || this.H) ? 48 : 72;
    }

    private int getTabMinWidth() {
        if (this.aa != -1) {
            return this.aa;
        }
        if (this.G == 0 || this.G == 2) {
            return this.ac;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.o.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(@ah h hVar) {
        for (int size = this.af.size() - 1; size >= 0; size--) {
            this.af.get(size).b(hVar);
        }
    }

    private void i() {
        int size = this.U.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.U.get(i2).m();
        }
    }

    private void i(@ah h hVar) {
        for (int size = this.af.size() - 1; size >= 0; size--) {
            this.af.get(size).c(hVar);
        }
    }

    @ah
    private LinearLayout.LayoutParams j() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void k() {
        if (this.ah == null) {
            this.ah = new ValueAnimator();
            this.ah.setInterpolator(com.google.android.material.a.a.b);
            this.ah.setDuration(this.E);
            this.ah.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.x.b.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@ah ValueAnimator valueAnimator) {
                    b.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void l() {
        af.b(this.o, (this.G == 0 || this.G == 2) ? Math.max(0, this.ad - this.p) : 0, 0, 0, 0);
        switch (this.G) {
            case 0:
                e(this.D);
                break;
            case 1:
            case 2:
                if (this.D == 2) {
                    Log.w(T, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.o.setGravity(1);
                break;
        }
        a(true);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.o.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.o.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    @ai
    public h a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.U.get(i2);
    }

    public void a() {
        this.af.clear();
    }

    public void a(int i2, float f2, boolean z) {
        a(i2, f2, z, true);
    }

    public void a(int i2, float f2, boolean z, boolean z2) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.o.getChildCount()) {
            return;
        }
        if (z2) {
            this.o.a(i2, f2);
        }
        if (this.ah != null && this.ah.isRunning()) {
            this.ah.cancel();
        }
        scrollTo(a(i2, f2), 0);
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void a(int i2, int i3) {
        setTabTextColors(b(i2, i3));
    }

    void a(@ai androidx.l.a.a aVar, boolean z) {
        if (this.ai != null && this.aj != null) {
            this.ai.b(this.aj);
        }
        this.ai = aVar;
        if (z && aVar != null) {
            if (this.aj == null) {
                this.aj = new f();
            }
            aVar.a(this.aj);
        }
        h();
    }

    public void a(@ai androidx.l.a.d dVar, boolean z) {
        a(dVar, z, false);
    }

    @Deprecated
    public void a(@ai InterfaceC0097b interfaceC0097b) {
        if (this.af.contains(interfaceC0097b)) {
            return;
        }
        this.af.add(interfaceC0097b);
    }

    public void a(@ah e eVar) {
        a((InterfaceC0097b) eVar);
    }

    public void a(@ah h hVar) {
        a(hVar, this.U.isEmpty());
    }

    public void a(@ah h hVar, int i2) {
        a(hVar, i2, this.U.isEmpty());
    }

    public void a(@ah h hVar, int i2, boolean z) {
        if (hVar.b != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        b(hVar, i2);
        f(hVar);
        if (z) {
            hVar.j();
        }
    }

    public void a(@ah h hVar, boolean z) {
        a(hVar, this.U.size(), z);
    }

    void a(boolean z) {
        for (int i2 = 0; i2 < this.o.getChildCount(); i2++) {
            View childAt = this.o.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    @ah
    public h b() {
        h hVarC = c();
        hVarC.b = this;
        hVarC.c = e(hVarC);
        return hVarC;
    }

    public void b(int i2) {
        int iD = this.V != null ? this.V.d() : 0;
        c(i2);
        h hVarRemove = this.U.remove(i2);
        if (hVarRemove != null) {
            hVarRemove.n();
            b(hVarRemove);
        }
        int size = this.U.size();
        for (int i3 = i2; i3 < size; i3++) {
            this.U.get(i3).b(i3);
        }
        if (iD == i2) {
            d(this.U.isEmpty() ? null : this.U.get(Math.max(0, i2 - 1)));
        }
    }

    @Deprecated
    public void b(@ai InterfaceC0097b interfaceC0097b) {
        this.af.remove(interfaceC0097b);
    }

    public void b(@ah e eVar) {
        b((InterfaceC0097b) eVar);
    }

    public void b(@ai h hVar, boolean z) {
        h hVar2 = this.V;
        if (hVar2 == hVar) {
            if (hVar2 != null) {
                i(hVar);
                d(hVar.d());
                return;
            }
            return;
        }
        int iD = hVar != null ? hVar.d() : -1;
        if (z) {
            if ((hVar2 == null || hVar2.d() == -1) && iD != -1) {
                a(iD, 0.0f, true);
            } else {
                d(iD);
            }
            if (iD != -1) {
                setSelectedTabView(iD);
            }
        }
        this.V = hVar;
        if (hVar2 != null) {
            h(hVar2);
        }
        if (hVar != null) {
            g(hVar);
        }
    }

    protected boolean b(h hVar) {
        return S.a(hVar);
    }

    protected h c() {
        h hVarA = S.a();
        return hVarA == null ? new h() : hVarA;
    }

    public void c(@ah h hVar) {
        if (hVar.b != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        b(hVar.d());
    }

    public void d() {
        for (int childCount = this.o.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator<h> it = this.U.iterator();
        while (it.hasNext()) {
            h next = it.next();
            it.remove();
            next.n();
            b(next);
        }
        this.V = null;
    }

    public void d(@ai h hVar) {
        b(hVar, true);
    }

    public boolean e() {
        return this.I;
    }

    public boolean f() {
        return this.H;
    }

    public boolean g() {
        return this.J;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        if (this.V != null) {
            return this.V.d();
        }
        return -1;
    }

    public int getTabCount() {
        return this.U.size();
    }

    public int getTabGravity() {
        return this.D;
    }

    @ai
    public ColorStateList getTabIconTint() {
        return this.v;
    }

    public int getTabIndicatorGravity() {
        return this.F;
    }

    int getTabMaxWidth() {
        return this.C;
    }

    public int getTabMode() {
        return this.G;
    }

    @ai
    public ColorStateList getTabRippleColor() {
        return this.w;
    }

    @ai
    public Drawable getTabSelectedIndicator() {
        return this.x;
    }

    @ai
    public ColorStateList getTabTextColors() {
        return this.u;
    }

    void h() {
        int currentItem;
        d();
        if (this.ai != null) {
            int iB = this.ai.b();
            for (int i2 = 0; i2 < iB; i2++) {
                a(b().a(this.ai.c(i2)), false);
            }
            if (this.K == null || iB <= 0 || (currentItem = this.K.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            d(a(currentItem));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.t.k.a(this);
        if (this.K == null) {
            ViewParent parent = getParent();
            if (parent instanceof androidx.l.a.d) {
                a((androidx.l.a.d) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.am) {
            setupWithViewPager(null);
            this.am = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@ah Canvas canvas) {
        for (int i2 = 0; i2 < this.o.getChildCount(); i2++) {
            View childAt = this.o.getChildAt(i2);
            if (childAt instanceof l) {
                ((l) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.n.a.d.a(accessibilityNodeInfo).b(androidx.core.n.a.d.b.a(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iRound = Math.round(z.a(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        boolean z = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(iRound + getPaddingTop() + getPaddingBottom(), androidx.d.c.b.a.b.b);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            this.C = this.ab > 0 ? this.ab : (int) (size - z.a(getContext(), 56));
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.G) {
                case 0:
                case 2:
                    if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                        z = true;
                    }
                    break;
                case 1:
                    if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
                        z = true;
                    }
                    break;
            }
            if (z) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), androidx.d.c.b.a.b.b), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    @Override // android.view.View
    @am(a = 21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.t.k.a(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.H != z) {
            this.H = z;
            for (int i2 = 0; i2 < this.o.getChildCount(); i2++) {
                View childAt = this.o.getChildAt(i2);
                if (childAt instanceof l) {
                    ((l) childAt).c();
                }
            }
            l();
        }
    }

    public void setInlineLabelResource(@androidx.annotation.h int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@ai InterfaceC0097b interfaceC0097b) {
        if (this.ae != null) {
            b(this.ae);
        }
        this.ae = interfaceC0097b;
        if (interfaceC0097b != null) {
            a(interfaceC0097b);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@ai e eVar) {
        setOnTabSelectedListener((InterfaceC0097b) eVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        k();
        this.ah.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@q int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setSelectedTabIndicator(@ai Drawable drawable) {
        if (this.x != drawable) {
            this.x = drawable;
            af.h(this.o);
        }
    }

    public void setSelectedTabIndicatorColor(@androidx.annotation.k int i2) {
        this.o.a(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.F != i2) {
            this.F = i2;
            af.h(this.o);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.o.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.D != i2) {
            this.D = i2;
            l();
        }
    }

    public void setTabIconTint(@ai ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            i();
        }
    }

    public void setTabIconTintResource(@androidx.annotation.m int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.I = z;
        af.h(this.o);
    }

    public void setTabMode(int i2) {
        if (i2 != this.G) {
            this.G = i2;
            l();
        }
    }

    public void setTabRippleColor(@ai ColorStateList colorStateList) {
        if (this.w != colorStateList) {
            this.w = colorStateList;
            for (int i2 = 0; i2 < this.o.getChildCount(); i2++) {
                View childAt = this.o.getChildAt(i2);
                if (childAt instanceof l) {
                    ((l) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@androidx.annotation.m int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public void setTabTextColors(@ai ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            i();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@ai androidx.l.a.a aVar) {
        a(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.J != z) {
            this.J = z;
            for (int i2 = 0; i2 < this.o.getChildCount(); i2++) {
                View childAt = this.o.getChildAt(i2);
                if (childAt instanceof l) {
                    ((l) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@androidx.annotation.h int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@ai androidx.l.a.d dVar) {
        a(dVar, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
