package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class q extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1091a = -1;
    public static final int b = 1;
    public static final int c = 0;
    private static final boolean i = false;
    private static final float j = 25.0f;
    private static final int k = 10000;
    private static final float l = 1.2f;
    protected PointF f;
    private final DisplayMetrics m;
    private float o;
    protected final LinearInterpolator d = new LinearInterpolator();
    protected final DecelerateInterpolator e = new DecelerateInterpolator();
    private boolean n = false;
    protected int g = 0;
    protected int h = 0;

    public q(Context context) {
        this.m = context.getResources().getDisplayMetrics();
    }

    private int b(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    private float k() {
        if (!this.n) {
            this.o = a(this.m);
            this.n = true;
        }
        return this.o;
    }

    protected float a(DisplayMetrics displayMetrics) {
        return j / displayMetrics.densityDpi;
    }

    protected int a(int i2) {
        return (int) Math.ceil(((double) b(i2)) / 0.3356d);
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        switch (i6) {
            case -1:
                return i4 - i2;
            case 0:
                int i7 = i4 - i2;
                if (i7 > 0) {
                    return i7;
                }
                int i8 = i5 - i3;
                if (i8 < 0) {
                    return i8;
                }
                return 0;
            case 1:
                return i5 - i3;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int a(View view, int i2) {
        RecyclerView.i iVarE = e();
        if (iVarE == null || !iVarE.j()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(iVarE.p(view) - jVar.topMargin, iVarE.r(view) + jVar.bottomMargin, iVarE.N(), iVarE.L() - iVarE.P(), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    protected void a() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    protected void a(int i2, int i3, RecyclerView.w wVar, RecyclerView.v.a aVar) {
        if (j() == 0) {
            f();
            return;
        }
        this.g = b(this.g, i2);
        this.h = b(this.h, i3);
        if (this.g == 0 && this.h == 0) {
            a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    protected void a(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
        int iB = b(view, c());
        int iA = a(view, d());
        int iA2 = a((int) Math.sqrt((iB * iB) + (iA * iA)));
        if (iA2 > 0) {
            aVar.a(-iB, -iA, iA2, this.e);
        }
    }

    protected void a(RecyclerView.v.a aVar) {
        PointF pointFD = d(i());
        if (pointFD == null || (pointFD.x == 0.0f && pointFD.y == 0.0f)) {
            aVar.a(i());
            f();
            return;
        }
        a(pointFD);
        this.f = pointFD;
        this.g = (int) (pointFD.x * 10000.0f);
        this.h = (int) (pointFD.y * 10000.0f);
        aVar.a((int) (this.g * l), (int) (this.h * l), (int) (b(k) * l), this.d);
    }

    protected int b(int i2) {
        return (int) Math.ceil(Math.abs(i2) * k());
    }

    public int b(View view, int i2) {
        RecyclerView.i iVarE = e();
        if (iVarE == null || !iVarE.i()) {
            return 0;
        }
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return a(iVarE.o(view) - jVar.leftMargin, iVarE.q(view) + jVar.rightMargin, iVarE.M(), iVarE.K() - iVarE.O(), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v
    protected void b() {
        this.h = 0;
        this.g = 0;
        this.f = null;
    }

    protected int c() {
        if (this.f == null || this.f.x == 0.0f) {
            return 0;
        }
        return this.f.x > 0.0f ? 1 : -1;
    }

    protected int d() {
        if (this.f == null || this.f.y == 0.0f) {
            return 0;
        }
        return this.f.y > 0.0f ? 1 : -1;
    }
}
