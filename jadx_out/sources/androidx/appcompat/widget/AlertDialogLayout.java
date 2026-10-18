package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends aj {
    public AlertDialogLayout(@androidx.annotation.ai Context context) {
        super(context);
    }

    public AlertDialogLayout(@androidx.annotation.ai Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private static int c(View view) {
        int iE = androidx.core.n.af.E(view);
        if (iE > 0) {
            return iE;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean c(int i, int i2) {
        int iCombineMeasuredStates;
        int iC;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == androidx.appcompat.a.g.topPanel) {
                    view = childAt;
                } else if (id == androidx.appcompat.a.g.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != androidx.appcompat.a.g.contentPanel && id != androidx.appcompat.a.g.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            iC = c(view2);
            measuredHeight = view2.getMeasuredHeight() - iC;
            paddingTop += iC;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iC = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i4 = size - paddingTop;
        if (view2 != null) {
            int i5 = paddingTop - iC;
            int iMin = Math.min(i4, measuredHeight);
            if (iMin > 0) {
                i4 -= iMin;
                iC += iMin;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(iC, androidx.d.c.b.a.b.b));
            paddingTop = i5 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i4 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i4, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        d(childCount, i2);
        return true;
    }

    private void d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), androidx.d.c.b.a.b.b);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                aj.b bVar = (aj.b) childAt.getLayoutParams();
                if (bVar.width == -1) {
                    int i4 = bVar.height;
                    bVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i2, 0);
                    bVar.height = i4;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.aj, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i6 = gravity & 112;
        int i7 = gravity & androidx.core.n.h.d;
        int paddingTop = i6 != 16 ? i6 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - measuredHeight : (((i4 - i2) - measuredHeight) / 2) + getPaddingTop();
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                aj.b bVar = (aj.b) childAt.getLayoutParams();
                int i9 = bVar.h;
                if (i9 < 0) {
                    i9 = i7;
                }
                int iA = androidx.core.n.h.a(i9, androidx.core.n.af.p(this)) & 7;
                int i10 = iA != 1 ? iA != 5 ? bVar.leftMargin + paddingLeft : (paddingRight - measuredWidth) - bVar.rightMargin : ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + bVar.leftMargin) - bVar.rightMargin;
                if (c(i8)) {
                    paddingTop += intrinsicHeight;
                }
                int i11 = paddingTop + bVar.topMargin;
                a(childAt, i10, i11, measuredWidth, measuredHeight2);
                paddingTop = i11 + measuredHeight2 + bVar.bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.aj, android.view.View
    protected void onMeasure(int i, int i2) {
        if (c(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}
