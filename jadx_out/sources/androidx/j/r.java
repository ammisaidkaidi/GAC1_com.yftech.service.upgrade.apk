package androidx.j;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class r extends ViewGroup implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewGroup f912a;
    View b;
    final View c;
    int d;

    @androidx.annotation.ai
    private Matrix e;
    private final ViewTreeObserver.OnPreDrawListener f;

    r(View view) {
        super(view.getContext());
        this.f = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.j.r.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                androidx.core.n.af.h(r.this);
                if (r.this.f912a == null || r.this.b == null) {
                    return true;
                }
                r.this.f912a.endViewTransition(r.this.b);
                androidx.core.n.af.h(r.this.f912a);
                r.this.f912a = null;
                r.this.b = null;
                return true;
            }
        };
        this.c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static r a(View view) {
        return (r) view.getTag(aa.e.ghost_view);
    }

    static void a(View view, View view2) {
        ay.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static void a(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        ay.a(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        ay.b(viewGroup, matrix);
    }

    static void a(@androidx.annotation.ah View view, @androidx.annotation.ai r rVar) {
        view.setTag(aa.e.ghost_view, rVar);
    }

    static r b(View view, ViewGroup viewGroup, Matrix matrix) {
        p pVar;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        p pVarA = p.a(viewGroup);
        r rVarA = a(view);
        int i = 0;
        if (rVarA != null && (pVar = (p) rVarA.getParent()) != pVarA) {
            i = rVarA.d;
            pVar.removeView(rVarA);
            rVarA = null;
        }
        if (rVarA == null) {
            if (matrix == null) {
                matrix = new Matrix();
                a(view, viewGroup, matrix);
            }
            rVarA = new r(view);
            rVarA.a(matrix);
            if (pVarA == null) {
                pVarA = new p(viewGroup);
            } else {
                pVarA.a();
            }
            a((View) viewGroup, (View) pVarA);
            a((View) viewGroup, (View) rVarA);
            pVarA.a(rVarA);
            rVarA.d = i;
        } else if (matrix != null) {
            rVarA.a(matrix);
        }
        rVarA.d++;
        return rVarA;
    }

    static void b(View view) {
        r rVarA = a(view);
        if (rVarA != null) {
            rVarA.d--;
            if (rVarA.d <= 0) {
                ((p) rVarA.getParent()).removeView(rVarA);
            }
        }
    }

    void a(@androidx.annotation.ah Matrix matrix) {
        this.e = matrix;
    }

    @Override // androidx.j.o
    public void a(ViewGroup viewGroup, View view) {
        this.f912a = viewGroup;
        this.b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.c, this);
        this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
        ay.a(this.c, 4);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        ay.a(this.c, 0);
        a(this.c, (r) null);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d.a(canvas, true);
        canvas.setMatrix(this.e);
        ay.a(this.c, 0);
        this.c.invalidate();
        ay.a(this.c, 4);
        drawChild(canvas, this.c, getDrawingTime());
        d.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, androidx.j.o
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (a(this.c) == this) {
            ay.a(this.c, i == 0 ? 4 : 0);
        }
    }
}
