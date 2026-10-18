package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ax;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.n.a.d;
import androidx.core.n.a.g;
import androidx.core.n.af;
import androidx.f.b.c;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1179a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private static final float m = 0.5f;
    private static final float n = 0.0f;
    private static final float o = 0.5f;
    c g;
    a h;
    private boolean p;
    private boolean r;
    private float q = 0.0f;
    int i = 2;
    float j = 0.5f;
    float k = 0.0f;
    float l = 0.5f;
    private final c.a s = new c.a() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private static final int b = -1;
        private int c;
        private int d = -1;

        private boolean a(@ah View view, float f2) {
            if (f2 == 0.0f) {
                return Math.abs(view.getLeft() - this.c) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.j);
            }
            boolean z = af.p(view) == 1;
            if (SwipeDismissBehavior.this.i == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.i == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (f2 <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (SwipeDismissBehavior.this.i != 1) {
                return false;
            }
            if (z) {
                if (f2 <= 0.0f) {
                    return false;
                }
            } else if (f2 >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // androidx.f.b.c.a
        public int a(@ah View view) {
            return view.getWidth();
        }

        @Override // androidx.f.b.c.a
        public int a(@ah View view, int i, int i2) {
            int width;
            int width2;
            boolean z = af.p(view) == 1;
            if (SwipeDismissBehavior.this.i == 0) {
                if (z) {
                    width = this.c - view.getWidth();
                    width2 = this.c;
                } else {
                    width = this.c;
                    width2 = this.c + view.getWidth();
                }
            } else if (SwipeDismissBehavior.this.i != 1) {
                width = this.c - view.getWidth();
                width2 = this.c + view.getWidth();
            } else if (z) {
                width = this.c;
                width2 = this.c + view.getWidth();
            } else {
                width = this.c - view.getWidth();
                width2 = this.c;
            }
            return SwipeDismissBehavior.a(width, i, width2);
        }

        @Override // androidx.f.b.c.a
        public void a(int i) {
            if (SwipeDismissBehavior.this.h != null) {
                SwipeDismissBehavior.this.h.a(i);
            }
        }

        @Override // androidx.f.b.c.a
        public void a(@ah View view, float f2, float f3) {
            int i;
            boolean z;
            this.d = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                i = view.getLeft() < this.c ? this.c - width : this.c + width;
                z = true;
            } else {
                i = this.c;
                z = false;
            }
            if (SwipeDismissBehavior.this.g.a(i, view.getTop())) {
                af.a(view, new b(view, z));
            } else {
                if (!z || SwipeDismissBehavior.this.h == null) {
                    return;
                }
                SwipeDismissBehavior.this.h.a(view);
            }
        }

        @Override // androidx.f.b.c.a
        public void a(@ah View view, int i) {
            this.d = i;
            this.c = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.f.b.c.a
        public void a(@ah View view, int i, int i2, int i3, int i4) {
            float width = this.c + (view.getWidth() * SwipeDismissBehavior.this.k);
            float width2 = this.c + (view.getWidth() * SwipeDismissBehavior.this.l);
            float f2 = i;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }

        @Override // androidx.f.b.c.a
        public int b(@ah View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.f.b.c.a
        public boolean b(View view, int i) {
            return (this.d == -1 || this.d == i) && SwipeDismissBehavior.this.b(view);
        }
    };

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {
        private final View b;
        private final boolean c;

        b(View view, boolean z) {
            this.b = view;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.g != null && SwipeDismissBehavior.this.g.a(true)) {
                af.a(this.b, this);
            } else {
                if (!this.c || SwipeDismissBehavior.this.h == null) {
                    return;
                }
                SwipeDismissBehavior.this.h.a(this.b);
            }
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void a(ViewGroup viewGroup) {
        if (this.g == null) {
            this.g = this.r ? c.a(viewGroup, this.q, this.s) : c.a(viewGroup, this.s);
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void c(View view) {
        af.f(view, 1048576);
        if (b(view)) {
            af.a(view, d.a.u, (CharSequence) null, new g() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // androidx.core.n.a.g
                public boolean a(@ah View view2, @ai g.a aVar) {
                    boolean z = false;
                    if (!SwipeDismissBehavior.this.b(view2)) {
                        return false;
                    }
                    boolean z2 = af.p(view2) == 1;
                    if ((SwipeDismissBehavior.this.i == 0 && z2) || (SwipeDismissBehavior.this.i == 1 && !z2)) {
                        z = true;
                    }
                    af.o(view2, z ? -view2.getWidth() : view2.getWidth());
                    view2.setAlpha(0.0f);
                    if (SwipeDismissBehavior.this.h != null) {
                        SwipeDismissBehavior.this.h.a(view2);
                    }
                    return true;
                }
            });
        }
    }

    public void a(float f2) {
        this.j = a(0.0f, f2, 1.0f);
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(@ai a aVar) {
        this.h = aVar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, int i) {
        boolean zA = super.a(coordinatorLayout, v, i);
        if (af.i(v) == 0) {
            af.e((View) v, 1);
            c(v);
        }
        return zA;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah MotionEvent motionEvent) {
        boolean z = this.p;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    this.p = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                    z = this.p;
                    break;
                case 1:
                    this.p = false;
                    break;
            }
        } else {
            this.p = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.g.a(motionEvent);
    }

    @ai
    @ax
    public a b() {
        return this.h;
    }

    public void b(float f2) {
        this.k = a(0.0f, f2, 1.0f);
    }

    public boolean b(@ah View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.g == null) {
            return false;
        }
        this.g.b(motionEvent);
        return true;
    }

    public int c() {
        if (this.g != null) {
            return this.g.b();
        }
        return 0;
    }

    public void c(float f2) {
        this.l = a(0.0f, f2, 1.0f);
    }

    public void d(float f2) {
        this.q = f2;
        this.r = true;
    }
}
