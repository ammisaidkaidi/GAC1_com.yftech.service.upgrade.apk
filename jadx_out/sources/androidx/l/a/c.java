package androidx.l.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.k;
import androidx.annotation.r;
import androidx.core.n.af;
import androidx.core.widget.m;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@d.a
public class c extends ViewGroup {
    private static final int[] n = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    private static final int[] o = {R.attr.textAllCaps};
    private static final float p = 0.6f;
    private static final int q = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f939a;
    TextView b;
    TextView c;
    TextView d;
    float e;
    int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final a l;
    private WeakReference<androidx.l.a.a> m;
    private int r;

    private class a extends DataSetObserver implements d.e, d.f {
        private int b;

        a() {
        }

        @Override // androidx.l.a.d.f
        public void a(int i) {
            if (this.b == 0) {
                c.this.a(c.this.f939a.getCurrentItem(), c.this.f939a.getAdapter());
                c.this.a(c.this.f939a.getCurrentItem(), c.this.e >= 0.0f ? c.this.e : 0.0f, true);
            }
        }

        @Override // androidx.l.a.d.f
        public void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            c.this.a(i, f, false);
        }

        @Override // androidx.l.a.d.e
        public void a(d dVar, androidx.l.a.a aVar, androidx.l.a.a aVar2) {
            c.this.a(aVar, aVar2);
        }

        @Override // androidx.l.a.d.f
        public void b(int i) {
            this.b = i;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            c.this.a(c.this.f939a.getCurrentItem(), c.this.f939a.getAdapter());
            c.this.a(c.this.f939a.getCurrentItem(), c.this.e >= 0.0f ? c.this.e : 0.0f, true);
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Locale f941a;

        b(Context context) {
            this.f941a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f941a);
            }
            return null;
        }
    }

    public c(@ah Context context) {
        this(context, null);
    }

    public c(@ah Context context, @ai AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.e = -1.0f;
        this.l = new a();
        TextView textView = new TextView(context);
        this.b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n);
        boolean z = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            m.a(this.b, resourceId);
            m.a(this.c, resourceId);
            m.a(this.d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(color);
            this.c.setTextColor(color);
            this.d.setTextColor(color);
        }
        this.i = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f = this.c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(p);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, o);
            z = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.b);
            setSingleLineAllCaps(this.c);
            setSingleLineAllCaps(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i, float f) {
        this.b.setTextSize(i, f);
        this.c.setTextSize(i, f);
        this.d.setTextSize(i, f);
    }

    void a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.g) {
            a(i, this.f939a.getAdapter());
        } else if (!z && f == this.e) {
            return;
        }
        this.k = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i5 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + i5;
        int i7 = (width - (paddingLeft + i5)) - i6;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i8 = ((width - i6) - ((int) (i7 * f2))) - i5;
        int i9 = measuredWidth2 + i8;
        int baseline = this.b.getBaseline();
        int baseline2 = this.c.getBaseline();
        int baseline3 = this.d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = iMax - baseline;
        int i11 = iMax - baseline2;
        int i12 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.b.getMeasuredHeight() + i10, this.c.getMeasuredHeight() + i11), this.d.getMeasuredHeight() + i12);
        int i13 = this.i & 112;
        if (i13 == 16) {
            int i14 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
            i2 = i10 + i14;
            i3 = i11 + i14;
            i4 = i14 + i12;
        } else if (i13 != 80) {
            i2 = i10 + paddingTop;
            i3 = i11 + paddingTop;
            i4 = paddingTop + i12;
        } else {
            int i15 = (height - paddingBottom) - iMax2;
            i2 = i10 + i15;
            i3 = i11 + i15;
            i4 = i15 + i12;
        }
        this.c.layout(i8, i3, i9, this.c.getMeasuredHeight() + i3);
        int iMin = Math.min(paddingLeft, (i8 - this.h) - measuredWidth);
        this.b.layout(iMin, i2, measuredWidth + iMin, this.b.getMeasuredHeight() + i2);
        int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i9 + this.h);
        this.d.layout(iMax3, i4, iMax3 + measuredWidth3, this.d.getMeasuredHeight() + i4);
        this.e = f;
        this.k = false;
    }

    void a(int i, androidx.l.a.a aVar) {
        int iB = aVar != null ? aVar.b() : 0;
        this.j = true;
        CharSequence charSequenceC = null;
        this.b.setText((i < 1 || aVar == null) ? null : aVar.c(i - 1));
        this.c.setText((aVar == null || i >= iB) ? null : aVar.c(i));
        int i2 = i + 1;
        if (i2 < iB && aVar != null) {
            charSequenceC = aVar.c(i2);
        }
        this.d.setText(charSequenceC);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.g = i;
        if (!this.k) {
            a(i, this.e, false);
        }
        this.j = false;
    }

    void a(androidx.l.a.a aVar, androidx.l.a.a aVar2) {
        if (aVar != null) {
            aVar.b(this.l);
            this.m = null;
        }
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) this.l);
            this.m = new WeakReference<>(aVar2);
        }
        if (this.f939a != null) {
            this.g = -1;
            this.e = -1.0f;
            a(this.f939a.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof d)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        d dVar = (d) parent;
        androidx.l.a.a adapter = dVar.getAdapter();
        dVar.c(this.l);
        dVar.a((d.e) this.l);
        this.f939a = dVar;
        a(this.m != null ? this.m.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f939a != null) {
            a(this.f939a.getAdapter(), (androidx.l.a.a) null);
            this.f939a.c((d.f) null);
            this.f939a.b((d.e) this.l);
            this.f939a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f939a != null) {
            a(this.g, this.e >= 0.0f ? this.e : 0.0f, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (size * 0.2f), -2);
        this.b.measure(childMeasureSpec2, childMeasureSpec);
        this.c.measure(childMeasureSpec2, childMeasureSpec);
        this.d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i2);
        } else {
            iMax = Math.max(getMinHeight(), this.c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i2, this.c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.j) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i) {
        this.i = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@r(a = 0.0d, b = 1.0d) float f) {
        this.r = ((int) (f * 255.0f)) & 255;
        int i = (this.r << 24) | (this.f & af.r);
        this.b.setTextColor(i);
        this.d.setTextColor(i);
    }

    public void setTextColor(@k int i) {
        this.f = i;
        this.c.setTextColor(i);
        int i2 = (this.r << 24) | (this.f & af.r);
        this.b.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    public void setTextSpacing(int i) {
        this.h = i;
        requestLayout();
    }
}
