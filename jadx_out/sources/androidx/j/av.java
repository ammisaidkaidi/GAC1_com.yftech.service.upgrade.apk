package androidx.j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class av implements ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f865a;

    static class a extends ViewGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Method f866a;
        ViewGroup b;
        View c;
        ArrayList<Drawable> d;
        av e;
        private boolean f;

        static {
            try {
                f866a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, av avVar) {
            super(context);
            this.d = null;
            this.b = viewGroup;
            this.c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.e = avVar;
        }

        private void a() {
            if (this.f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.b.getLocationOnScreen(iArr2);
            this.c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        private void b() {
            if (getChildCount() == 0) {
                if (this.d == null || this.d.size() == 0) {
                    this.f = true;
                    this.b.removeView(this);
                }
            }
        }

        @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
        protected ViewParent a(int i, int i2, Rect rect) {
            if (!(this.b instanceof ViewGroup) || f866a == null) {
                return null;
            }
            try {
                a(new int[2]);
                f866a.invoke(this.b, Integer.valueOf(i), Integer.valueOf(i2), rect);
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public void a(Drawable drawable) {
            a();
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            if (this.d.contains(drawable)) {
                return;
            }
            this.d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void a(View view) {
            a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.b && viewGroup.getParent() != null && androidx.core.n.af.ak(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.b.getLocationOnScreen(iArr2);
                    androidx.core.n.af.o(view, iArr[0] - iArr2[0]);
                    androidx.core.n.af.n(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        public void b(Drawable drawable) {
            if (this.d != null) {
                this.d.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                b();
            }
        }

        public void b(View view) {
            super.removeView(view);
            b();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.b.getLocationOnScreen(iArr);
            this.c.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.d == null ? 0 : this.d.size();
            for (int i = 0; i < size; i++) {
                this.d.get(i).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.b instanceof ViewGroup)) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            a(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@androidx.annotation.ah Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@androidx.annotation.ah Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.d != null && this.d.contains(drawable));
        }
    }

    av(Context context, ViewGroup viewGroup, View view) {
        this.f865a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    static av d(View view) {
        ViewGroup viewGroupC = c(view);
        if (viewGroupC == null) {
            return null;
        }
        int childCount = viewGroupC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroupC.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).e;
            }
        }
        return new aq(viewGroupC.getContext(), viewGroupC, view);
    }

    @Override // androidx.j.ax
    public void a(@androidx.annotation.ah Drawable drawable) {
        this.f865a.a(drawable);
    }

    @Override // androidx.j.ax
    public void b(@androidx.annotation.ah Drawable drawable) {
        this.f865a.b(drawable);
    }
}
