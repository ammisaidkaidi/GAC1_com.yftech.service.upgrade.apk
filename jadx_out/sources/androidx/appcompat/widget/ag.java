package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ag extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f202a = -1;
    public static final int b = -1;
    b c;
    private final Rect d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Field j;
    private a k;
    private boolean l;
    private boolean m;
    private boolean n;
    private androidx.core.n.aj o;
    private androidx.core.widget.h p;

    private static class a extends androidx.appcompat.b.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f203a;

        a(Drawable drawable) {
            super(drawable);
            this.f203a = true;
        }

        void a(boolean z) {
            this.f203a = z;
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f203a) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f203a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f203a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f203a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.b.a.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f203a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void a() {
            ag.this.c = null;
            ag.this.removeCallbacks(this);
        }

        public void b() {
            ag.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            ag.this.c = null;
            ag.this.drawableStateChanged();
        }
    }

    ag(@androidx.annotation.ah Context context, boolean z) {
        super(context, null, androidx.appcompat.a.b.dropDownListViewStyle);
        this.d = new Rect();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.m = z;
        setCacheColorHint(0);
        try {
            this.j = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.j.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z) {
            Rect rect = this.d;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.a(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void a(int i, View view, float f, float f2) {
        a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.a(selector, f, f2);
    }

    private void a(Canvas canvas) {
        Drawable selector;
        if (this.d.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.d);
        selector.draw(canvas);
    }

    private void a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void a(View view, int i, float f, float f2) {
        View childAt;
        this.n = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.i != -1 && (childAt = getChildAt(this.i - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.i = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void b() {
        this.n = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.i - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.o != null) {
            this.o.d();
            this.o = null;
        }
    }

    private void b(int i, View view) {
        Rect rect = this.d;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.e;
        rect.top -= this.f;
        rect.right += this.g;
        rect.bottom += this.h;
        try {
            boolean z = this.j.getBoolean(this);
            if (view.isEnabled() != z) {
                this.j.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private boolean c() {
        return this.n;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.k != null) {
            this.k.a(z);
        }
    }

    public int a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        View view = null;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, androidx.d.c.b.a.b.b) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    public int a(int i, boolean z) {
        int iMin;
        ListAdapter adapter = getAdapter();
        if (adapter == null || isInTouchMode()) {
            return -1;
        }
        int count = adapter.getCount();
        if (getAdapter().areAllItemsEnabled()) {
            if (i < 0 || i >= count) {
                return -1;
            }
            return i;
        }
        if (z) {
            iMin = Math.max(0, i);
            while (iMin < count && !adapter.isEnabled(iMin)) {
                iMin++;
            }
        } else {
            iMin = Math.min(i, count - 1);
            while (iMin >= 0 && !adapter.isEnabled(iMin)) {
                iMin--;
            }
        }
        if (iMin < 0 || iMin >= count) {
            return -1;
        }
        return iMin;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:13:0x002a  */
    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:5:0x000c  */
    public boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        int iFindPointerIndex;
        int x;
        int y;
        int iPointToPosition;
        View childAt;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                iFindPointerIndex = motionEvent.findPointerIndex(i);
                if (iFindPointerIndex < 0) {
                    x = (int) motionEvent.getX(iFindPointerIndex);
                    y = (int) motionEvent.getY(iFindPointerIndex);
                    iPointToPosition = pointToPosition(x, y);
                    if (iPointToPosition == -1) {
                        childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                        a(childAt, iPointToPosition, x, y);
                        if (actionMasked == 1) {
                            a(childAt, iPointToPosition);
                        }
                        z2 = false;
                        z = true;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                break;
            case 2:
                z = true;
                iFindPointerIndex = motionEvent.findPointerIndex(i);
                if (iFindPointerIndex < 0) {
                    x = (int) motionEvent.getX(iFindPointerIndex);
                    y = (int) motionEvent.getY(iFindPointerIndex);
                    iPointToPosition = pointToPosition(x, y);
                    if (iPointToPosition == -1) {
                        childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                        a(childAt, iPointToPosition, x, y);
                        if (actionMasked == 1) {
                            a(childAt, iPointToPosition);
                        }
                        z2 = false;
                        z = true;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                break;
            case 3:
                z2 = false;
                z = false;
                break;
            default:
                z2 = false;
                z = true;
                break;
        }
        if (!z || z2) {
            b();
        }
        if (z) {
            if (this.p == null) {
                this.p = new androidx.core.widget.h(this);
            }
            this.p.a(true);
            this.p.onTouch(this, motionEvent);
        } else if (this.p != null) {
            this.p.a(false);
        }
        return z;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.c != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.m || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.m || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.m && this.l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.c = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(@androidx.annotation.ah MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.c == null) {
            this.c = new b();
            this.c.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.i = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.c != null) {
            this.c.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.l = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.k = drawable != null ? new a(drawable) : null;
        super.setSelector(this.k);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.e = rect.left;
        this.f = rect.top;
        this.g = rect.right;
        this.h = rect.bottom;
    }
}
