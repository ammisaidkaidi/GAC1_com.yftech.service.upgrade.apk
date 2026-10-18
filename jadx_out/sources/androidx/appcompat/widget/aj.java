package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class aj extends ViewGroup {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 4;
    private static final int q = 4;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    private static final String v = "androidx.appcompat.widget.LinearLayoutCompat";
    private int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f208a;
    private int b;
    private int c;
    private int d;
    private int k;
    private int l;
    private float m;
    private boolean n;
    private int[] o;
    private int[] p;
    private Drawable w;
    private int x;
    private int y;
    private int z;

    @Retention(RetentionPolicy.SOURCE)
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public @interface a {
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public b(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public b(int i, int i2, float f) {
            super(i, i2);
            this.h = -1;
            this.g = f;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.LinearLayoutCompat_Layout);
            this.g = typedArrayObtainStyledAttributes.getFloat(androidx.appcompat.a.m.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.a.m.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.h = -1;
        }

        public b(b bVar) {
            super((ViewGroup.MarginLayoutParams) bVar);
            this.h = -1;
            this.g = bVar.g;
            this.h = bVar.h;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public aj(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public aj(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aj(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f208a = true;
        this.b = -1;
        this.c = 0;
        this.k = com.google.android.material.b.a.b;
        ba baVarA = ba.a(context, attributeSet, androidx.appcompat.a.m.LinearLayoutCompat, i2, 0);
        androidx.core.n.af.a(this, context, androidx.appcompat.a.m.LinearLayoutCompat, attributeSet, baVarA.a(), i2, 0);
        int iA = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_android_orientation, -1);
        if (iA >= 0) {
            setOrientation(iA);
        }
        int iA2 = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_android_gravity, -1);
        if (iA2 >= 0) {
            setGravity(iA2);
        }
        boolean zA = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.m = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.n = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_divider));
        this.z = baVarA.a(androidx.appcompat.a.m.LinearLayoutCompat_showDividers, 0);
        this.A = baVarA.e(androidx.appcompat.a.m.LinearLayoutCompat_dividerPadding, 0);
        baVarA.f();
    }

    private void a(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void c(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), androidx.d.c.b.a.b.b);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewB = b(i4);
            if (viewB.getVisibility() != 8) {
                b bVar = (b) viewB.getLayoutParams();
                if (bVar.width == -1) {
                    int i5 = bVar.height;
                    bVar.height = viewB.getMeasuredHeight();
                    measureChildWithMargins(viewB, iMakeMeasureSpec, 0, i3, 0);
                    bVar.height = i5;
                }
            }
        }
    }

    private void d(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), androidx.d.c.b.a.b.b);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewB = b(i4);
            if (viewB.getVisibility() != 8) {
                b bVar = (b) viewB.getLayoutParams();
                if (bVar.height == -1) {
                    int i5 = bVar.width;
                    bVar.width = viewB.getMeasuredWidth();
                    measureChildWithMargins(viewB, i3, 0, iMakeMeasureSpec, 0);
                    bVar.width = i5;
                }
            }
        }
    }

    int a(View view) {
        return 0;
    }

    int a(View view, int i2) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0337  */
    /* JADX WARN: Code duplicated, block: B:156:0x0346  */
    void a(int i2, int i3) {
        int i4;
        int i5;
        int iCombineMeasuredStates;
        int iMax;
        float f2;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax2;
        int i14;
        int i15;
        View view;
        int iMax3;
        boolean z3;
        int iMax4;
        this.l = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i16 = this.b;
        boolean z4 = this.n;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int iA = 0;
        boolean z5 = false;
        boolean z6 = false;
        float f3 = 0.0f;
        boolean z7 = true;
        while (true) {
            int i22 = 8;
            int i23 = i20;
            if (iA >= virtualChildCount) {
                int i24 = i17;
                int i25 = i19;
                int i26 = i21;
                int i27 = virtualChildCount;
                int i28 = mode2;
                int iMax5 = i18;
                if (this.l > 0) {
                    i4 = i27;
                    if (c(i4)) {
                        this.l += this.y;
                    }
                } else {
                    i4 = i27;
                }
                if (z4) {
                    i5 = i28;
                    if (i5 == Integer.MIN_VALUE || i5 == 0) {
                        this.l = 0;
                        int iA2 = 0;
                        while (iA2 < i4) {
                            View viewB = b(iA2);
                            if (viewB == null) {
                                this.l += d(iA2);
                            } else if (viewB.getVisibility() == i22) {
                                iA2 += a(viewB, iA2);
                            } else {
                                b bVar = (b) viewB.getLayoutParams();
                                int i29 = this.l;
                                this.l = Math.max(i29, i29 + i25 + bVar.topMargin + bVar.bottomMargin + b(viewB));
                            }
                            iA2++;
                            i22 = 8;
                        }
                    }
                } else {
                    i5 = i28;
                }
                this.l += getPaddingTop() + getPaddingBottom();
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.l, getSuggestedMinimumHeight()), i3, 0);
                int i30 = (16777215 & iResolveSizeAndState) - this.l;
                if (z5 || (i30 != 0 && f3 > 0.0f)) {
                    if (this.m > 0.0f) {
                        f3 = this.m;
                    }
                    this.l = 0;
                    float f4 = f3;
                    int i31 = 0;
                    int i32 = i26;
                    iCombineMeasuredStates = i24;
                    while (i31 < i4) {
                        View viewB2 = b(i31);
                        if (viewB2.getVisibility() == 8) {
                            i6 = i5;
                            f2 = f4;
                        } else {
                            b bVar2 = (b) viewB2.getLayoutParams();
                            float f5 = bVar2.g;
                            if (f5 > 0.0f) {
                                int i33 = (int) ((i30 * f5) / f4);
                                float f6 = f4 - f5;
                                int i34 = i30 - i33;
                                int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + bVar2.leftMargin + bVar2.rightMargin, bVar2.width);
                                if (bVar2.height == 0) {
                                    i8 = androidx.d.c.b.a.b.b;
                                    if (i5 == 1073741824) {
                                        if (i33 <= 0) {
                                            i33 = 0;
                                        }
                                        viewB2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i33, androidx.d.c.b.a.b.b));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewB2.getMeasuredState() & androidx.core.n.i.u);
                                    i30 = i34;
                                    f2 = f6;
                                } else {
                                    i8 = androidx.d.c.b.a.b.b;
                                }
                                int measuredHeight = viewB2.getMeasuredHeight() + i33;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewB2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewB2.getMeasuredState() & androidx.core.n.i.u);
                                i30 = i34;
                                f2 = f6;
                            } else {
                                f2 = f4;
                            }
                            int i35 = iCombineMeasuredStates;
                            int i36 = bVar2.leftMargin + bVar2.rightMargin;
                            int measuredWidth = viewB2.getMeasuredWidth() + i36;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            if (mode != 1073741824) {
                                i6 = i5;
                                i7 = -1;
                                z = bVar2.width == -1;
                                if (!z) {
                                    i36 = measuredWidth;
                                }
                                int iMax6 = Math.max(i32, i36);
                                if (z7 || bVar2.width != i7) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                int i37 = this.l;
                                this.l = Math.max(i37, i37 + viewB2.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin + b(viewB2));
                                z7 = z2;
                                i32 = iMax6;
                                iCombineMeasuredStates = i35;
                            } else {
                                i6 = i5;
                                i7 = -1;
                            }
                            if (!z) {
                                i36 = measuredWidth;
                            }
                            int iMax7 = Math.max(i32, i36);
                            if (z7) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            int i38 = this.l;
                            this.l = Math.max(i38, i38 + viewB2.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin + b(viewB2));
                            z7 = z2;
                            i32 = iMax7;
                            iCombineMeasuredStates = i35;
                        }
                        i31++;
                        f4 = f2;
                        i5 = i6;
                    }
                    this.l += getPaddingTop() + getPaddingBottom();
                    iMax = i32;
                } else {
                    iMax = Math.max(i26, i23);
                    if (z4 && i5 != 1073741824) {
                        for (int i39 = 0; i39 < i4; i39++) {
                            View viewB3 = b(i39);
                            if (viewB3 != null && viewB3.getVisibility() != 8 && ((b) viewB3.getLayoutParams()).g > 0.0f) {
                                viewB3.measure(View.MeasureSpec.makeMeasureSpec(viewB3.getMeasuredWidth(), androidx.d.c.b.a.b.b), View.MeasureSpec.makeMeasureSpec(i25, androidx.d.c.b.a.b.b));
                            }
                        }
                    }
                    iCombineMeasuredStates = i24;
                }
                if (z7 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates), iResolveSizeAndState);
                if (z6) {
                    c(i4, i3);
                    return;
                }
                return;
            }
            View viewB4 = b(iA);
            if (viewB4 == null) {
                this.l += d(iA);
                i12 = virtualChildCount;
                i13 = mode2;
                i20 = i23;
            } else {
                int i40 = i17;
                if (viewB4.getVisibility() == 8) {
                    iA += a(viewB4, iA);
                    i12 = virtualChildCount;
                    i13 = mode2;
                    i20 = i23;
                    i17 = i40;
                } else {
                    if (c(iA)) {
                        this.l += this.y;
                    }
                    b bVar3 = (b) viewB4.getLayoutParams();
                    float f7 = f3 + bVar3.g;
                    if (mode2 == 1073741824 && bVar3.height == 0 && bVar3.g > 0.0f) {
                        int i41 = this.l;
                        this.l = Math.max(i41, bVar3.topMargin + i41 + bVar3.bottomMargin);
                        iMax3 = i19;
                        view = viewB4;
                        i14 = i21;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        z5 = true;
                        iMax2 = i23;
                        i10 = i40;
                        i11 = i18;
                        i15 = iA;
                    } else {
                        int i42 = i18;
                        if (bVar3.height != 0 || bVar3.g <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            bVar3.height = -2;
                            i9 = 0;
                        }
                        i10 = i40;
                        int i43 = i9;
                        i11 = i42;
                        int i44 = i19;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        iMax2 = i23;
                        i14 = i21;
                        i15 = iA;
                        a(viewB4, iA, i2, 0, i3, f7 == 0.0f ? this.l : 0);
                        if (i43 != Integer.MIN_VALUE) {
                            bVar3.height = i43;
                        }
                        int measuredHeight2 = viewB4.getMeasuredHeight();
                        int i45 = this.l;
                        view = viewB4;
                        this.l = Math.max(i45, i45 + measuredHeight2 + bVar3.topMargin + bVar3.bottomMargin + b(view));
                        iMax3 = z4 ? Math.max(measuredHeight2, i44) : i44;
                    }
                    if (i16 >= 0 && i16 == i15 + 1) {
                        this.c = this.l;
                    }
                    if (i15 < i16 && bVar3.g > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || bVar3.width != -1) {
                        z3 = false;
                    } else {
                        z3 = true;
                        z6 = true;
                    }
                    int i46 = bVar3.leftMargin + bVar3.rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i46;
                    int iMax8 = Math.max(i11, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                    boolean z8 = z7 && bVar3.width == -1;
                    if (bVar3.g > 0.0f) {
                        if (!z3) {
                            i46 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i46);
                        iMax4 = i14;
                    } else {
                        if (!z3) {
                            i46 = measuredWidth2;
                        }
                        iMax4 = Math.max(i14, i46);
                    }
                    int iA3 = a(view, i15) + i15;
                    i19 = iMax3;
                    z7 = z8;
                    i20 = iMax2;
                    f3 = f7;
                    i21 = iMax4;
                    i17 = iCombineMeasuredStates2;
                    iA = iA3;
                    i18 = iMax8;
                }
            }
            iA++;
            mode2 = i13;
            virtualChildCount = i12;
        }
    }

    void a(int i2, int i3, int i4, int i5) {
        int paddingTop;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i4 - i2;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.k & 112;
        int i10 = this.k & androidx.core.n.h.d;
        if (i9 != 16) {
            paddingTop = i9 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.l;
        } else {
            paddingTop = (((i5 - i3) - this.l) / 2) + getPaddingTop();
        }
        int iA = 0;
        while (iA < virtualChildCount) {
            View viewB = b(iA);
            if (viewB == null) {
                paddingTop += d(iA);
            } else {
                if (viewB.getVisibility() != 8) {
                    int measuredWidth = viewB.getMeasuredWidth();
                    int measuredHeight = viewB.getMeasuredHeight();
                    b bVar = (b) viewB.getLayoutParams();
                    int i11 = bVar.h;
                    if (i11 < 0) {
                        i11 = i10;
                    }
                    int iA2 = androidx.core.n.h.a(i11, androidx.core.n.af.p(this)) & 7;
                    if (iA2 != 1) {
                        i6 = iA2 != 5 ? bVar.leftMargin + paddingLeft : (paddingRight - measuredWidth) - bVar.rightMargin;
                    } else {
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + bVar.leftMargin) - bVar.rightMargin;
                    }
                    int i12 = i6;
                    if (c(iA)) {
                        paddingTop += this.y;
                    }
                    int i13 = paddingTop + bVar.topMargin;
                    a(viewB, i12, i13 + a(viewB), measuredWidth, measuredHeight);
                    int iB = i13 + measuredHeight + bVar.bottomMargin + b(viewB);
                    iA += a(viewB, iA);
                    paddingTop = iB;
                    i7 = 1;
                }
                iA += i7;
            }
            i7 = 1;
            iA += i7;
        }
    }

    void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewB = b(i2);
            if (viewB != null && viewB.getVisibility() != 8 && c(i2)) {
                a(canvas, (viewB.getTop() - ((b) viewB.getLayoutParams()).topMargin) - this.y);
            }
        }
        if (c(virtualChildCount)) {
            View viewB2 = b(virtualChildCount - 1);
            a(canvas, viewB2 == null ? (getHeight() - getPaddingBottom()) - this.y : viewB2.getBottom() + ((b) viewB2.getLayoutParams()).bottomMargin);
        }
    }

    void a(Canvas canvas, int i2) {
        this.w.setBounds(getPaddingLeft() + this.A, i2, (getWidth() - getPaddingRight()) - this.A, this.y + i2);
        this.w.draw(canvas);
    }

    void a(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    int b(View view) {
        return 0;
    }

    View b(int i2) {
        return getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    /* JADX WARN: Code duplicated, block: B:201:0x047c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0174  */
    /* JADX WARN: Code duplicated, block: B:67:0x0196  */
    /* JADX WARN: Code duplicated, block: B:68:0x0199  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:83:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e0  */
    void b(int i2, int i3) {
        int[] iArr;
        int i4;
        int iMax;
        int i5;
        int i6;
        int baseline;
        int i7;
        byte b2;
        int i8;
        int i9;
        boolean z;
        boolean z2;
        View view;
        int i10;
        boolean z3;
        int i11;
        int measuredHeight;
        boolean z4;
        int baseline2;
        int i12;
        this.l = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.o == null || this.p == null) {
            this.o = new int[4];
            this.p = new int[4];
        }
        int[] iArr2 = this.o;
        int[] iArr3 = this.p;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.f208a;
        boolean z6 = this.n;
        int i13 = androidx.d.c.b.a.b.b;
        boolean z7 = mode == 1073741824;
        int iA = 0;
        int iMax2 = 0;
        int i14 = 0;
        boolean z8 = false;
        int iMax3 = 0;
        int iMax4 = 0;
        int i15 = 0;
        boolean z9 = false;
        boolean z10 = true;
        float f2 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iA >= virtualChildCount) {
                break;
            }
            View viewB = b(iA);
            if (viewB == null) {
                this.l += d(iA);
            } else {
                if (viewB.getVisibility() == 8) {
                    iA += a(viewB, iA);
                } else {
                    if (c(iA)) {
                        this.l += this.x;
                    }
                    b bVar = (b) viewB.getLayoutParams();
                    float f3 = f2 + bVar.g;
                    if (mode == i13 && bVar.width == 0 && bVar.g > 0.0f) {
                        if (z7) {
                            this.l += bVar.leftMargin + bVar.rightMargin;
                        } else {
                            int i16 = this.l;
                            this.l = Math.max(i16, bVar.leftMargin + i16 + bVar.rightMargin);
                        }
                        if (z5) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i9 = iA;
                            z = z6;
                            z2 = z5;
                            view = viewB;
                        } else {
                            i9 = iA;
                            z = z6;
                            z2 = z5;
                            view = viewB;
                            z8 = true;
                            i10 = androidx.d.c.b.a.b.b;
                        }
                        if (mode2 == i10 && bVar.height == -1) {
                            z3 = true;
                            z9 = true;
                        } else {
                            z3 = false;
                        }
                        i11 = bVar.topMargin + bVar.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i11;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i15, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            if (bVar.h < 0) {
                                i12 = this.k;
                            } else {
                                i12 = bVar.h;
                            }
                            int i17 = (((i12 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i17] = Math.max(iArr2[i17], baseline2);
                            iArr[i17] = Math.max(iArr[i17], measuredHeight - baseline2);
                        }
                        int iMax5 = Math.max(i14, measuredHeight);
                        if (z10 || bVar.height != -1) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        if (bVar.g > 0.0f) {
                            if (!z3) {
                                i11 = measuredHeight;
                            }
                            iMax4 = Math.max(iMax4, i11);
                        } else {
                            int i18 = iMax4;
                            if (z3) {
                                measuredHeight = i11;
                            }
                            iMax3 = Math.max(iMax3, measuredHeight);
                            iMax4 = i18;
                        }
                        int i19 = i9;
                        i14 = iMax5;
                        i15 = iCombineMeasuredStates;
                        z10 = z4;
                        iA = a(view, i19) + i19;
                        f2 = f3;
                    } else {
                        if (bVar.width != 0 || bVar.g <= 0.0f) {
                            b2 = -2;
                            i8 = Integer.MIN_VALUE;
                        } else {
                            b2 = -2;
                            bVar.width = -2;
                            i8 = 0;
                        }
                        i9 = iA;
                        int i20 = i8;
                        z = z6;
                        z2 = z5;
                        a(viewB, i9, i2, f3 == 0.0f ? this.l : 0, i3, 0);
                        if (i20 != Integer.MIN_VALUE) {
                            bVar.width = i20;
                        }
                        int measuredWidth = viewB.getMeasuredWidth();
                        if (z7) {
                            view = viewB;
                            this.l += bVar.leftMargin + measuredWidth + bVar.rightMargin + b(view);
                        } else {
                            view = viewB;
                            int i21 = this.l;
                            this.l = Math.max(i21, i21 + measuredWidth + bVar.leftMargin + bVar.rightMargin + b(view));
                        }
                        if (z) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    i10 = androidx.d.c.b.a.b.b;
                    if (mode2 == i10) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    i11 = bVar.topMargin + bVar.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i11;
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i15, view.getMeasuredState());
                    if (z2) {
                        if (bVar.h < 0) {
                            i12 = this.k;
                        } else {
                            i12 = bVar.h;
                        }
                        int i110 = (((i12 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i110] = Math.max(iArr2[i110], baseline2);
                        iArr[i110] = Math.max(iArr[i110], measuredHeight - baseline2);
                    }
                    int iMax6 = Math.max(i14, measuredHeight);
                    if (z10) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (bVar.g > 0.0f) {
                        if (!z3) {
                            i11 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i11);
                    } else {
                        int i111 = iMax4;
                        if (z3) {
                            measuredHeight = i11;
                        }
                        iMax3 = Math.max(iMax3, measuredHeight);
                        iMax4 = i111;
                    }
                    int i112 = i9;
                    i14 = iMax6;
                    i15 = iCombineMeasuredStates2;
                    z10 = z4;
                    iA = a(view, i112) + i112;
                    f2 = f3;
                }
                iA++;
                iArr3 = iArr;
                z6 = z;
                z5 = z2;
                i13 = androidx.d.c.b.a.b.b;
            }
            z = z6;
            z2 = z5;
            iA++;
            iArr3 = iArr;
            z6 = z;
            z5 = z2;
            i13 = androidx.d.c.b.a.b.b;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int iMax7 = i14;
        int i22 = iMax3;
        int i23 = iMax4;
        int i24 = i15;
        if (this.l > 0 && c(virtualChildCount)) {
            this.l += this.x;
        }
        if (iArr2[1] != -1 || iArr2[0] != -1 || iArr2[2] != -1 || iArr2[3] != -1) {
            iMax7 = Math.max(iMax7, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.l = 0;
            int iA2 = 0;
            while (iA2 < virtualChildCount) {
                View viewB2 = b(iA2);
                if (viewB2 == null) {
                    this.l += d(iA2);
                } else if (viewB2.getVisibility() == 8) {
                    iA2 += a(viewB2, iA2);
                } else {
                    b bVar2 = (b) viewB2.getLayoutParams();
                    if (z7) {
                        this.l += bVar2.leftMargin + iMax2 + bVar2.rightMargin + b(viewB2);
                    } else {
                        int i25 = this.l;
                        this.l = Math.max(i25, i25 + iMax2 + bVar2.leftMargin + bVar2.rightMargin + b(viewB2));
                    }
                    iA2++;
                    iMax7 = iMax7;
                }
                iA2++;
                iMax7 = iMax7;
            }
        }
        int iMax8 = iMax7;
        this.l += getPaddingLeft() + getPaddingRight();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.l, getSuggestedMinimumWidth()), i2, 0);
        int i26 = (16777215 & iResolveSizeAndState) - this.l;
        if (z8 || (i26 != 0 && f2 > 0.0f)) {
            if (this.m > 0.0f) {
                f2 = this.m;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.l = 0;
            int i27 = i22;
            int iMax9 = -1;
            int iCombineMeasuredStates3 = i24;
            float f4 = f2;
            int i28 = 0;
            while (i28 < virtualChildCount) {
                View viewB3 = b(i28);
                if (viewB3 == null || viewB3.getVisibility() == 8) {
                    i5 = i26;
                    virtualChildCount = virtualChildCount;
                } else {
                    b bVar3 = (b) viewB3.getLayoutParams();
                    float f5 = bVar3.g;
                    if (f5 > 0.0f) {
                        int i29 = (int) ((i26 * f5) / f4);
                        float f6 = f4 - f5;
                        int i30 = i26 - i29;
                        int childMeasureSpec = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + bVar3.topMargin + bVar3.bottomMargin, bVar3.height);
                        if (bVar3.width == 0) {
                            i7 = androidx.d.c.b.a.b.b;
                            if (mode == 1073741824) {
                                if (i29 <= 0) {
                                    i29 = 0;
                                }
                                viewB3.measure(View.MeasureSpec.makeMeasureSpec(i29, androidx.d.c.b.a.b.b), childMeasureSpec);
                            }
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, viewB3.getMeasuredState() & androidx.core.n.af.s);
                            f4 = f6;
                            i5 = i30;
                        } else {
                            i7 = androidx.d.c.b.a.b.b;
                        }
                        int measuredWidth2 = viewB3.getMeasuredWidth() + i29;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewB3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i7), childMeasureSpec);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, viewB3.getMeasuredState() & androidx.core.n.af.s);
                        f4 = f6;
                        i5 = i30;
                    } else {
                        i5 = i26;
                    }
                    if (z7) {
                        this.l += viewB3.getMeasuredWidth() + bVar3.leftMargin + bVar3.rightMargin + b(viewB3);
                    } else {
                        int i31 = this.l;
                        this.l = Math.max(i31, viewB3.getMeasuredWidth() + i31 + bVar3.leftMargin + bVar3.rightMargin + b(viewB3));
                    }
                    boolean z13 = mode2 != 1073741824 && bVar3.height == -1;
                    int i32 = bVar3.topMargin + bVar3.bottomMargin;
                    int measuredHeight2 = viewB3.getMeasuredHeight() + i32;
                    iMax9 = Math.max(iMax9, measuredHeight2);
                    if (!z13) {
                        i32 = measuredHeight2;
                    }
                    int iMax10 = Math.max(i27, i32);
                    if (z10) {
                        i6 = -1;
                        boolean z14 = bVar3.height == -1;
                        if (!z12 && (baseline = viewB3.getBaseline()) != i6) {
                            int i33 = ((((bVar3.h < 0 ? this.k : bVar3.h) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i33] = Math.max(iArr2[i33], baseline);
                            iArr[i33] = Math.max(iArr[i33], measuredHeight2 - baseline);
                        }
                        i27 = iMax10;
                        z10 = z14;
                        f4 = f4;
                    } else {
                        i6 = -1;
                    }
                    if (!z12) {
                    }
                    i27 = iMax10;
                    z10 = z14;
                    f4 = f4;
                }
                i28++;
                i26 = i5;
                virtualChildCount = virtualChildCount;
            }
            i4 = virtualChildCount;
            this.l += getPaddingLeft() + getPaddingRight();
            iMax8 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax9 : Math.max(iMax9, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i24 = iCombineMeasuredStates3;
            iMax = i27;
        } else {
            iMax = Math.max(i22, i23);
            if (z11 && mode != 1073741824) {
                for (int i34 = 0; i34 < virtualChildCount; i34++) {
                    View viewB4 = b(i34);
                    if (viewB4 != null && viewB4.getVisibility() != 8 && ((b) viewB4.getLayoutParams()).g > 0.0f) {
                        viewB4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, androidx.d.c.b.a.b.b), View.MeasureSpec.makeMeasureSpec(viewB4.getMeasuredHeight(), androidx.d.c.b.a.b.b));
                    }
                }
            }
            i4 = virtualChildCount;
        }
        if (!z10 && mode2 != 1073741824) {
            iMax8 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | (i24 & androidx.core.n.af.s), View.resolveSizeAndState(Math.max(iMax8 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i24 << 16));
        if (z9) {
            d(i4, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:51:0x010a  */
    void b(int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        boolean z;
        int i8;
        int baseline;
        int i9;
        int i10;
        int i11;
        int i12;
        int measuredHeight;
        boolean zA = bg.a(this);
        int paddingTop = getPaddingTop();
        int i13 = i5 - i3;
        int paddingBottom = i13 - getPaddingBottom();
        int paddingBottom2 = (i13 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i14 = this.k & androidx.core.n.h.d;
        int i15 = this.k & 112;
        boolean z2 = this.f208a;
        int[] iArr = this.o;
        int[] iArr2 = this.p;
        int iA = androidx.core.n.h.a(i14, androidx.core.n.af.p(this));
        boolean z3 = true;
        if (iA != 1) {
            paddingLeft = iA != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.l;
        } else {
            paddingLeft = (((i4 - i2) - this.l) / 2) + getPaddingLeft();
        }
        if (zA) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int iA2 = 0;
        while (iA2 < virtualChildCount) {
            int i16 = i6 + (i7 * iA2);
            View viewB = b(i16);
            if (viewB == null) {
                paddingLeft += d(i16);
                z = z3;
            } else {
                if (viewB.getVisibility() != 8) {
                    int measuredWidth = viewB.getMeasuredWidth();
                    int measuredHeight2 = viewB.getMeasuredHeight();
                    b bVar = (b) viewB.getLayoutParams();
                    if (z2) {
                        i8 = iA2;
                        virtualChildCount = virtualChildCount;
                        baseline = bVar.height != -1 ? viewB.getBaseline() : -1;
                        i9 = bVar.h;
                        if (i9 < 0) {
                            i9 = i15;
                        }
                        i10 = i9 & 112;
                        i15 = i15;
                        if (i10 != 16) {
                            z = true;
                            i11 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + bVar.topMargin) - bVar.bottomMargin;
                        } else if (i10 != 48) {
                            if (i10 != 80) {
                                i11 = paddingTop;
                            } else {
                                measuredHeight = (paddingBottom - measuredHeight2) - bVar.bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight -= iArr2[2] - (viewB.getMeasuredHeight() - baseline);
                                }
                                i11 = measuredHeight;
                            }
                            z = true;
                        } else {
                            i12 = bVar.topMargin + paddingTop;
                            if (baseline != -1) {
                                z = true;
                                i12 += iArr[1] - baseline;
                            } else {
                                z = true;
                            }
                            i11 = i12;
                        }
                        if (c(i16)) {
                            paddingLeft += this.x;
                        }
                        int i17 = bVar.leftMargin + paddingLeft;
                        paddingTop = paddingTop;
                        a(viewB, i17 + a(viewB), i11, measuredWidth, measuredHeight2);
                        int iB = i17 + measuredWidth + bVar.rightMargin + b(viewB);
                        iA2 = i8 + a(viewB, i16);
                        paddingLeft = iB;
                    } else {
                        i8 = iA2;
                        virtualChildCount = virtualChildCount;
                    }
                    i9 = bVar.h;
                    if (i9 < 0) {
                        i9 = i15;
                    }
                    i10 = i9 & 112;
                    i15 = i15;
                    if (i10 != 16) {
                        z = true;
                        i11 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + bVar.topMargin) - bVar.bottomMargin;
                    } else if (i10 != 48) {
                        if (i10 != 80) {
                            i11 = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - bVar.bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewB.getMeasuredHeight() - baseline);
                            }
                            i11 = measuredHeight;
                        }
                        z = true;
                    } else {
                        i12 = bVar.topMargin + paddingTop;
                        if (baseline != -1) {
                            z = true;
                            i12 += iArr[1] - baseline;
                        } else {
                            z = true;
                        }
                        i11 = i12;
                    }
                    if (c(i16)) {
                        paddingLeft += this.x;
                    }
                    int i18 = bVar.leftMargin + paddingLeft;
                    paddingTop = paddingTop;
                    a(viewB, i18 + a(viewB), i11, measuredWidth, measuredHeight2);
                    int iB2 = i18 + measuredWidth + bVar.rightMargin + b(viewB);
                    iA2 = i8 + a(viewB, i16);
                    paddingLeft = iB2;
                } else {
                    z = true;
                }
                iA2++;
                z3 = z;
                virtualChildCount = virtualChildCount;
                i15 = i15;
                paddingTop = paddingTop;
            }
            iA2++;
            z3 = z;
            virtualChildCount = virtualChildCount;
            i15 = i15;
            paddingTop = paddingTop;
        }
    }

    void b(Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean zA = bg.a(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewB = b(i2);
            if (viewB != null && viewB.getVisibility() != 8 && c(i2)) {
                b bVar = (b) viewB.getLayoutParams();
                b(canvas, zA ? viewB.getRight() + bVar.rightMargin : (viewB.getLeft() - bVar.leftMargin) - this.x);
            }
        }
        if (c(virtualChildCount)) {
            View viewB2 = b(virtualChildCount - 1);
            if (viewB2 == null) {
                left = zA ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.x;
            } else {
                b bVar2 = (b) viewB2.getLayoutParams();
                left = zA ? (viewB2.getLeft() - bVar2.leftMargin) - this.x : viewB2.getRight() + bVar2.rightMargin;
            }
            b(canvas, left);
        }
    }

    void b(Canvas canvas, int i2) {
        this.w.setBounds(i2, getPaddingTop() + this.A, this.x + i2, (getHeight() - getPaddingBottom()) - this.A);
        this.w.draw(canvas);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY})
    protected boolean c(int i2) {
        if (i2 == 0) {
            return (this.z & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.z & 4) != 0;
        }
        if ((this.z & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    int d(int i2) {
        return 0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.c;
        if (this.d == 1 && (i2 = this.k & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.l) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.l;
            }
        }
        return bottom + ((b) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.w;
    }

    public int getDividerPadding() {
        return this.A;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.x;
    }

    public int getGravity() {
        return this.k;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.z;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new b(-2, -2);
        }
        if (this.d == 1) {
            return new b(-1, -2);
        }
        return null;
    }

    public boolean k() {
        return this.f208a;
    }

    public boolean l() {
        return this.n;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.w == null) {
            return;
        }
        if (this.d == 1) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(v);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(v);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.d == 1) {
            a(i2, i3, i4, i5);
        } else {
            b(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.d == 1) {
            a(i2, i3);
        } else {
            b(i2, i3);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f208a = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.w) {
            return;
        }
        this.w = drawable;
        if (drawable != null) {
            this.x = drawable.getIntrinsicWidth();
            this.y = drawable.getIntrinsicHeight();
        } else {
            this.x = 0;
            this.y = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.A = i2;
    }

    public void setGravity(int i2) {
        if (this.k != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= androidx.core.n.h.b;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.k = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & androidx.core.n.h.d;
        if ((8388615 & this.k) != i3) {
            this.k = i3 | (this.k & (-8388616));
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.n = z;
    }

    public void setOrientation(int i2) {
        if (this.d != i2) {
            this.d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.z) {
            requestLayout();
        }
        this.z = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        if ((this.k & 112) != i3) {
            this.k = i3 | (this.k & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.m = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
