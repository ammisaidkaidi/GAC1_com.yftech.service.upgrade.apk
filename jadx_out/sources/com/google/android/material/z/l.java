package com.google.android.material.z;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.at;
import androidx.annotation.w;
import androidx.core.n.af;
import androidx.j.ag;
import androidx.j.an;
import com.google.android.material.internal.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class l extends ag {
    private static final d B;
    private static final d D;
    private static final float E = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1547a = 0;
    public static final int b = 1;
    public static final int o = 2;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    private static final String w = "l";
    private boolean F = false;
    private boolean G = false;

    @w
    private int H = R.id.content;

    @w
    private int I = -1;

    @w
    private int J = -1;

    @androidx.annotation.k
    private int K = 0;

    @androidx.annotation.k
    private int L = 0;

    @androidx.annotation.k
    private int M = 0;

    @androidx.annotation.k
    private int N = 1375731712;
    private int O = 0;
    private int P = 0;
    private int Q = 0;

    @ai
    private View R;

    @ai
    private View S;

    @ai
    private com.google.android.material.t.o T;

    @ai
    private com.google.android.material.t.o U;

    @ai
    private c V;

    @ai
    private c W;

    @ai
    private c X;

    @ai
    private c Y;
    private boolean Z;
    private float aa;
    private float ab;
    private static final String x = "materialContainerTransition:bounds";
    private static final String y = "materialContainerTransition:shapeAppearance";
    private static final String[] z = {x, y};
    private static final d A = new d(new c(0.0f, 0.25f), new c(0.0f, 1.0f), new c(0.0f, 1.0f), new c(0.0f, 0.75f));
    private static final d C = new d(new c(0.1f, 0.4f), new c(0.1f, 1.0f), new c(0.1f, 1.0f), new c(0.1f, 0.9f));

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @androidx.annotation.r(a = 0.0d, b = 1.0d)
        private final float f1550a;

        @androidx.annotation.r(a = 0.0d, b = 1.0d)
        private final float b;

        public c(@androidx.annotation.r(a = 0.0d, b = 1.0d) float f, @androidx.annotation.r(a = 0.0d, b = 1.0d) float f2) {
            this.f1550a = f;
            this.b = f2;
        }

        @androidx.annotation.r(a = 0.0d, b = 1.0d)
        public float a() {
            return this.f1550a;
        }

        @androidx.annotation.r(a = 0.0d, b = 1.0d)
        public float b() {
            return this.b;
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ah
        private final c f1551a;

        @ah
        private final c b;

        @ah
        private final c c;

        @ah
        private final c d;

        private d(@ah c cVar, @ah c cVar2, @ah c cVar3, @ah c cVar4) {
            this.f1551a = cVar;
            this.b = cVar2;
            this.c = cVar3;
            this.d = cVar4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP})
    public @interface e {
    }

    private static final class f extends Drawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f1552a = 754974720;
        private static final int b = -7829368;
        private static final float c = 0.3f;
        private static final float d = 1.5f;
        private final RectF A;
        private final RectF B;
        private final RectF C;
        private final RectF D;
        private final d E;
        private final com.google.android.material.z.a F;
        private final com.google.android.material.z.f G;
        private final boolean H;
        private final Paint I;
        private final Path J;
        private com.google.android.material.z.c K;
        private h L;
        private RectF M;
        private float N;
        private float O;
        private float P;
        private final View e;
        private final RectF f;
        private final com.google.android.material.t.o g;
        private final float h;
        private final View i;
        private final RectF j;
        private final com.google.android.material.t.o k;
        private final float l;
        private final Paint m;
        private final Paint n;
        private final Paint o;
        private final Paint p;
        private final Paint q;
        private final j r;
        private final PathMeasure s;
        private final float t;
        private final float[] u;
        private final boolean v;
        private final float w;
        private final float x;
        private final boolean y;
        private final com.google.android.material.t.j z;

        private f(androidx.j.w wVar, View view, RectF rectF, com.google.android.material.t.o oVar, float f, View view2, RectF rectF2, com.google.android.material.t.o oVar2, float f2, @androidx.annotation.k int i, @androidx.annotation.k int i2, @androidx.annotation.k int i3, int i4, boolean z, boolean z2, com.google.android.material.z.a aVar, com.google.android.material.z.f fVar, d dVar, boolean z3) {
            this.m = new Paint();
            this.n = new Paint();
            this.o = new Paint();
            this.p = new Paint();
            this.q = new Paint();
            this.r = new j();
            this.u = new float[2];
            this.z = new com.google.android.material.t.j();
            this.I = new Paint();
            this.J = new Path();
            this.e = view;
            this.f = rectF;
            this.g = oVar;
            this.h = f;
            this.i = view2;
            this.j = rectF2;
            this.k = oVar2;
            this.l = f2;
            this.v = z;
            this.y = z2;
            this.F = aVar;
            this.G = fVar;
            this.E = dVar;
            this.H = z3;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.w = displayMetrics.widthPixels;
            this.x = displayMetrics.heightPixels;
            this.m.setColor(i);
            this.n.setColor(i2);
            this.o.setColor(i3);
            this.z.g(ColorStateList.valueOf(0));
            this.z.J(2);
            this.z.k(false);
            this.z.O(b);
            this.A = new RectF(rectF);
            this.B = new RectF(this.A);
            this.C = new RectF(this.A);
            this.D = new RectF(this.C);
            PointF pointFA = a(rectF);
            PointF pointFA2 = a(rectF2);
            this.s = new PathMeasure(wVar.a(pointFA.x, pointFA.y, pointFA2.x, pointFA2.y), false);
            this.t = this.s.getLength();
            this.u[0] = rectF.centerX();
            this.u[1] = rectF.top;
            this.q.setStyle(Paint.Style.FILL);
            this.q.setShader(u.a(i4));
            this.I.setStyle(Paint.Style.STROKE);
            this.I.setStrokeWidth(10.0f);
            b(0.0f);
        }

        private static float a(RectF rectF, float f) {
            return ((rectF.centerX() / (f / 2.0f)) - 1.0f) * c;
        }

        private static PointF a(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f) {
            if (this.P != f) {
                b(f);
            }
        }

        private void a(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.r.a(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                b(canvas);
            } else {
                c(canvas);
            }
            canvas.restore();
        }

        private void a(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        private void a(Canvas canvas, RectF rectF, @androidx.annotation.k int i) {
            this.I.setColor(i);
            canvas.drawRect(rectF, this.I);
        }

        private void a(Canvas canvas, RectF rectF, Path path, @androidx.annotation.k int i) {
            PointF pointFA = a(rectF);
            if (this.P == 0.0f) {
                path.reset();
                path.moveTo(pointFA.x, pointFA.y);
            } else {
                path.lineTo(pointFA.x, pointFA.y);
                this.I.setColor(i);
                canvas.drawPath(path, this.I);
            }
        }

        private static float b(RectF rectF, float f) {
            return (rectF.centerY() / f) * d;
        }

        private void b(float f) {
            this.P = f;
            this.q.setAlpha((int) (this.v ? u.a(0.0f, 255.0f, f) : u.a(255.0f, 0.0f, f)));
            this.s.getPosTan(this.t * f, this.u, null);
            float f2 = this.u[0];
            float f3 = this.u[1];
            this.L = this.G.a(f, ((Float) androidx.core.m.i.a(Float.valueOf(this.E.b.f1550a))).floatValue(), ((Float) androidx.core.m.i.a(Float.valueOf(this.E.b.b))).floatValue(), this.f.width(), this.f.height(), this.j.width(), this.j.height());
            this.A.set(f2 - (this.L.c / 2.0f), f3, (this.L.c / 2.0f) + f2, this.L.d + f3);
            this.C.set(f2 - (this.L.e / 2.0f), f3, f2 + (this.L.e / 2.0f), this.L.f + f3);
            this.B.set(this.A);
            this.D.set(this.C);
            float fFloatValue = ((Float) androidx.core.m.i.a(Float.valueOf(this.E.c.f1550a))).floatValue();
            float fFloatValue2 = ((Float) androidx.core.m.i.a(Float.valueOf(this.E.c.b))).floatValue();
            boolean zA = this.G.a(this.L);
            RectF rectF = zA ? this.B : this.D;
            float fA = u.a(0.0f, 1.0f, fFloatValue, fFloatValue2, f);
            if (!zA) {
                fA = 1.0f - fA;
            }
            this.G.a(rectF, fA, this.L);
            this.M = new RectF(Math.min(this.B.left, this.D.left), Math.min(this.B.top, this.D.top), Math.max(this.B.right, this.D.right), Math.max(this.B.bottom, this.D.bottom));
            this.r.a(f, this.g, this.k, this.A, this.B, this.D, this.E.d);
            this.N = u.a(this.h, this.l, f);
            float fA2 = a(this.M, this.w);
            float fB = b(this.M, this.x);
            float f4 = (int) (this.N * fA2);
            this.O = (int) (this.N * fB);
            this.p.setShadowLayer(this.N, f4, this.O, f1552a);
            this.K = this.F.a(f, ((Float) androidx.core.m.i.a(Float.valueOf(this.E.f1551a.f1550a))).floatValue(), ((Float) androidx.core.m.i.a(Float.valueOf(this.E.f1551a.b))).floatValue());
            if (this.n.getColor() != 0) {
                this.n.setAlpha(this.K.f1539a);
            }
            if (this.o.getColor() != 0) {
                this.o.setAlpha(this.K.b);
            }
            invalidateSelf();
        }

        private void b(Canvas canvas) {
            com.google.android.material.t.o oVarB = this.r.b();
            if (!oVarB.a(this.M)) {
                canvas.drawPath(this.r.a(), this.p);
            } else {
                float fA = oVarB.f().a(this.M);
                canvas.drawRoundRect(this.M, fA, fA, this.p);
            }
        }

        private void c(Canvas canvas) {
            this.z.setBounds((int) this.M.left, (int) this.M.top, (int) this.M.right, (int) this.M.bottom);
            this.z.r(this.N);
            this.z.L((int) this.O);
            this.z.setShapeAppearanceModel(this.r.b());
            this.z.draw(canvas);
        }

        private void d(Canvas canvas) {
            a(canvas, this.n);
            u.a(canvas, getBounds(), this.A.left, this.A.top, this.L.f1545a, this.K.f1539a, new u.a() { // from class: com.google.android.material.z.l.f.1
                @Override // com.google.android.material.z.u.a
                public void a(Canvas canvas2) {
                    f.this.e.draw(canvas2);
                }
            });
        }

        private void e(Canvas canvas) {
            a(canvas, this.o);
            u.a(canvas, getBounds(), this.C.left, this.C.top, this.L.b, this.K.b, new u.a() { // from class: com.google.android.material.z.l.f.2
                @Override // com.google.android.material.z.u.a
                public void a(Canvas canvas2) {
                    f.this.i.draw(canvas2);
                }
            });
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@ah Canvas canvas) {
            if (this.q.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.q);
            }
            int iSave = this.H ? canvas.save() : -1;
            if (this.y && this.N > 0.0f) {
                a(canvas);
            }
            this.r.a(canvas);
            a(canvas, this.m);
            if (this.K.c) {
                d(canvas);
                e(canvas);
            } else {
                e(canvas);
                d(canvas);
            }
            if (this.H) {
                canvas.restoreToCount(iSave);
                a(canvas, this.A, this.J, -65281);
                a(canvas, this.B, androidx.core.n.i.u);
                a(canvas, this.A, -16711936);
                a(canvas, this.D, -16711681);
                a(canvas, this.C, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@ai ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    static {
        B = new d(new c(0.6f, 0.9f), new c(0.0f, 1.0f), new c(0.0f, 0.9f), new c(0.3f, 0.9f));
        D = new d(new c(0.6f, 0.9f), new c(0.0f, 0.9f), new c(0.0f, 0.9f), new c(0.2f, 0.9f));
    }

    public l() {
        this.Z = Build.VERSION.SDK_INT >= 28;
        this.aa = E;
        this.ab = E;
        a(com.google.android.material.a.a.b);
    }

    private static float a(float f2, View view) {
        return f2 != E ? f2 : af.P(view);
    }

    @at
    private static int a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.a.c.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static RectF a(View view, @ai View view2, float f2, float f3) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFC = u.c(view2);
        rectFC.offset(f2, f3);
        return rectFC;
    }

    private static com.google.android.material.t.o a(@ah View view, @ah RectF rectF, @ai com.google.android.material.t.o oVar) {
        return u.a(a(view, oVar), rectF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.t.o a(@ah View view, @ai com.google.android.material.t.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        if (view.getTag(com.google.android.material.a.h.mtrl_motion_snapshot_view) instanceof com.google.android.material.t.o) {
            return (com.google.android.material.t.o) view.getTag(com.google.android.material.a.h.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int iA = a(context);
        if (iA != -1) {
            return com.google.android.material.t.o.a(context, iA, 0).a();
        }
        return view instanceof com.google.android.material.t.s ? ((com.google.android.material.t.s) view).getShapeAppearanceModel() : com.google.android.material.t.o.a().a();
    }

    private d a(boolean z2, d dVar, d dVar2) {
        if (!z2) {
            dVar = dVar2;
        }
        return new d((c) u.a(this.V, dVar.f1551a), (c) u.a(this.W, dVar.b), (c) u.a(this.X, dVar.c), (c) u.a(this.Y, dVar.d));
    }

    private static void a(@ah an anVar, @ai View view, @w int i, @ai com.google.android.material.t.o oVar) {
        if (i != -1) {
            anVar.b = u.a(anVar.b, i);
        } else if (view != null) {
            anVar.b = view;
        } else if (anVar.b.getTag(com.google.android.material.a.h.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) anVar.b.getTag(com.google.android.material.a.h.mtrl_motion_snapshot_view);
            anVar.b.setTag(com.google.android.material.a.h.mtrl_motion_snapshot_view, null);
            anVar.b = view2;
        }
        View view3 = anVar.b;
        if (!af.ag(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        RectF rectFA = view3.getParent() == null ? u.a(view3) : u.c(view3);
        anVar.f859a.put(x, rectFA);
        anVar.f859a.put(y, a(view3, rectFA, oVar));
    }

    private boolean a(@ah RectF rectF, @ah RectF rectF2) {
        switch (this.O) {
            case 0:
                return u.a(rectF2) > u.a(rectF);
            case 1:
                return true;
            case 2:
                return false;
            default:
                throw new IllegalArgumentException("Invalid transition direction: " + this.O);
        }
    }

    private d f(boolean z2) {
        androidx.j.w wVarO = o();
        return ((wVarO instanceof androidx.j.b) || (wVarO instanceof k)) ? a(z2, C, D) : a(z2, A, B);
    }

    public float A() {
        return this.ab;
    }

    @w
    public int B() {
        return this.H;
    }

    @androidx.annotation.k
    public int C() {
        return this.K;
    }

    @androidx.annotation.k
    public int D() {
        return this.L;
    }

    @androidx.annotation.k
    public int E() {
        return this.M;
    }

    @androidx.annotation.k
    public int F() {
        return this.N;
    }

    public int G() {
        return this.O;
    }

    public int H() {
        return this.P;
    }

    public int I() {
        return this.Q;
    }

    @ai
    public c J() {
        return this.V;
    }

    @ai
    public c K() {
        return this.W;
    }

    @ai
    public c L() {
        return this.X;
    }

    @ai
    public c M() {
        return this.Y;
    }

    public boolean N() {
        return this.G;
    }

    public boolean O() {
        return this.F;
    }

    @Override // androidx.j.ag
    @ai
    public Animator a(@ah ViewGroup viewGroup, @ai an anVar, @ai an anVar2) {
        final View viewB;
        if (anVar == null || anVar2 == null) {
            return null;
        }
        RectF rectF = (RectF) anVar.f859a.get(x);
        com.google.android.material.t.o oVar = (com.google.android.material.t.o) anVar.f859a.get(y);
        if (rectF == null || oVar == null) {
            Log.w(w, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            return null;
        }
        RectF rectF2 = (RectF) anVar2.f859a.get(x);
        com.google.android.material.t.o oVar2 = (com.google.android.material.t.o) anVar2.f859a.get(y);
        if (rectF2 == null || oVar2 == null) {
            Log.w(w, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
            return null;
        }
        final View view = anVar.b;
        final View view2 = anVar2.b;
        View view3 = view2.getParent() != null ? view2 : view;
        if (this.H == view3.getId()) {
            viewB = (View) view3.getParent();
        } else {
            viewB = u.b(view3, this.H);
            view3 = null;
        }
        RectF rectFC = u.c(viewB);
        float f2 = -rectFC.left;
        float f3 = -rectFC.top;
        RectF rectFA = a(viewB, view3, f2, f3);
        rectF.offset(f2, f3);
        rectF2.offset(f2, f3);
        boolean zA = a(rectF, rectF2);
        final f fVar = new f(o(), view, rectF, oVar, a(this.aa, view), view2, rectF2, oVar2, a(this.ab, view2), this.K, this.L, this.M, this.N, zA, this.Z, com.google.android.material.z.b.a(this.P, zA), g.a(this.Q, zA, rectF, rectF2), f(zA), this.F);
        fVar.setBounds(Math.round(rectFA.left), Math.round(rectFA.top), Math.round(rectFA.right), Math.round(rectFA.bottom));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.z.l.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                fVar.a(valueAnimator.getAnimatedFraction());
            }
        });
        a(new t() { // from class: com.google.android.material.z.l.2
            @Override // com.google.android.material.z.t, androidx.j.ag.e
            public void b(@ah ag agVar) {
                l.this.b(this);
                if (l.this.G) {
                    return;
                }
                view.setAlpha(1.0f);
                view2.setAlpha(1.0f);
                z.e(viewB).b(fVar);
            }

            @Override // com.google.android.material.z.t, androidx.j.ag.e
            public void e(@ah ag agVar) {
                z.e(viewB).a(fVar);
                view.setAlpha(0.0f);
                view2.setAlpha(0.0f);
            }
        });
        return valueAnimatorOfFloat;
    }

    public void a(float f2) {
        this.aa = f2;
    }

    public void a(@w int i) {
        this.I = i;
    }

    public void a(@ai View view) {
        this.R = view;
    }

    @Override // androidx.j.ag
    public void a(@ah an anVar) {
        a(anVar, this.R, this.I, this.T);
    }

    public void a(@ai com.google.android.material.t.o oVar) {
        this.T = oVar;
    }

    public void a(@ai c cVar) {
        this.V = cVar;
    }

    public void a(boolean z2) {
        this.Z = z2;
    }

    @Override // androidx.j.ag
    @ai
    public String[] a() {
        return z;
    }

    @w
    public int b() {
        return this.I;
    }

    public void b(float f2) {
        this.ab = f2;
    }

    @Override // androidx.j.ag
    public void b(@ah an anVar) {
        a(anVar, this.S, this.J, this.U);
    }

    public void b(@ai com.google.android.material.t.o oVar) {
        this.U = oVar;
    }

    public void b(@ai c cVar) {
        this.W = cVar;
    }

    public void b(boolean z2) {
        this.G = z2;
    }

    @w
    public int c() {
        return this.J;
    }

    public void c(@ai c cVar) {
        this.X = cVar;
    }

    public void d(@w int i) {
        this.J = i;
    }

    public void d(@ai c cVar) {
        this.Y = cVar;
    }

    public void e(@w int i) {
        this.H = i;
    }

    public void e(boolean z2) {
        this.F = z2;
    }

    public void f(@androidx.annotation.k int i) {
        this.K = i;
    }

    public void g(@androidx.annotation.k int i) {
        this.L = i;
    }

    public void g(@ai View view) {
        this.S = view;
    }

    public void h(@androidx.annotation.k int i) {
        this.M = i;
    }

    public void i(@androidx.annotation.k int i) {
        this.K = i;
        this.L = i;
        this.M = i;
    }

    public void j(@androidx.annotation.k int i) {
        this.N = i;
    }

    public void k(int i) {
        this.O = i;
    }

    public void l(int i) {
        this.P = i;
    }

    public void m(int i) {
        this.Q = i;
    }

    @ai
    public View u() {
        return this.R;
    }

    @ai
    public View v() {
        return this.S;
    }

    @ai
    public com.google.android.material.t.o w() {
        return this.T;
    }

    @ai
    public com.google.android.material.t.o x() {
        return this.U;
    }

    public boolean y() {
        return this.Z;
    }

    public float z() {
        return this.aa;
    }
}
