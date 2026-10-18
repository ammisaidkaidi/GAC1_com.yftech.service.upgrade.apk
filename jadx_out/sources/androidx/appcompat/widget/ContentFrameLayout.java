package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY})
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TypedValue f169a;
    private TypedValue b;
    private TypedValue c;
    private TypedValue d;
    private TypedValue e;
    private TypedValue f;
    private final Rect g;
    private a h;

    public interface a {
        void a();

        void b();
    }

    public ContentFrameLayout(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public ContentFrameLayout(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new Rect();
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(int i, int i2, int i3, int i4) {
        this.g.set(i, i2, i3, i4);
        if (androidx.core.n.af.ag(this)) {
            requestLayout();
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        return this.e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f == null) {
            this.f = new TypedValue();
        }
        return this.f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return this.c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f169a == null) {
            this.f169a = new TypedValue();
        }
        return this.f169a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.b == null) {
            this.b = new TypedValue();
        }
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h != null) {
            this.h.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.h != null) {
            this.h.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f8  */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int fraction;
        int fraction2;
        int fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            TypedValue typedValue = z3 ? this.d : this.c;
            if (typedValue == null || typedValue.type == 0) {
                iMakeMeasureSpec = i;
                z = false;
            } else {
                if (typedValue.type == 5) {
                    fraction3 = (int) typedValue.getDimension(displayMetrics);
                } else {
                    fraction3 = typedValue.type == 6 ? (int) typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                }
                if (fraction3 > 0) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(fraction3 - (this.g.left + this.g.right), View.MeasureSpec.getSize(i)), androidx.d.c.b.a.b.b);
                    z = true;
                } else {
                    iMakeMeasureSpec = i;
                    z = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.e : this.f;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction2 = (int) typedValue2.getDimension(displayMetrics);
                } else {
                    fraction2 = typedValue2.type == 6 ? (int) typedValue2.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels) : 0;
                }
                if (fraction2 > 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.min(fraction2 - (this.g.top + this.g.bottom), View.MeasureSpec.getSize(i2)), androidx.d.c.b.a.b.b);
                }
            }
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, androidx.d.c.b.a.b.b);
        if (z || mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue3 = z3 ? this.b : this.f169a;
            if (typedValue3 == null || typedValue3.type == 0) {
                z2 = false;
            } else {
                if (typedValue3.type == 5) {
                    fraction = (int) typedValue3.getDimension(displayMetrics);
                } else {
                    fraction = typedValue3.type == 6 ? (int) typedValue3.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels) : 0;
                }
                if (fraction > 0) {
                    fraction -= this.g.left + this.g.right;
                }
                if (measuredWidth < fraction) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(fraction, androidx.d.c.b.a.b.b);
                } else {
                    z2 = false;
                }
            }
        }
        if (z2) {
            super.onMeasure(iMakeMeasureSpec2, i2);
        }
    }

    public void setAttachListener(a aVar) {
        this.h = aVar;
    }
}
