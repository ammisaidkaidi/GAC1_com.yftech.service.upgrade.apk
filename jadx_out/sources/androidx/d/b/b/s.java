package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.core.n.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class s extends androidx.d.e.d implements androidx.core.n.w {
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f621a = 0;
    private static final float aP = 1.0E-5f;
    private static final boolean am = false;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    static final String g = "MotionLayout";
    public static boolean h = false;
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 2;
    static final int w = 50;
    int A;
    int B;
    int C;
    boolean D;
    float E;
    float F;
    long G;
    float H;
    boolean I;
    protected boolean N;
    int O;
    int P;
    int Q;
    int R;
    int S;
    int T;
    float U;
    h V;
    c W;
    private androidx.d.b.a.h aA;
    private a aB;
    private androidx.d.b.b.d aC;
    private boolean aD;
    private ArrayList<q> aE;
    private ArrayList<q> aF;
    private ArrayList<g> aG;
    private int aH;
    private long aI;
    private float aJ;
    private int aK;
    private float aL;
    private androidx.d.b.b.g aM;
    private boolean aN;
    private f aO;
    private boolean aQ;
    private RectF aR;
    private View aS;
    ArrayList<Integer> aa;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private boolean ar;
    private long as;
    private float at;
    private long au;
    private boolean av;
    private g aw;
    private float ax;
    private float ay;
    private boolean az;
    u i;
    Interpolator j;
    float k;
    int l;
    HashMap<View, p> m;
    float n;
    float o;
    float p;
    boolean q;
    boolean r;
    int v;
    b x;
    boolean y;
    int z;

    class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f624a = 0.0f;
        float b = 0.0f;
        float c;

        a() {
        }

        @Override // androidx.d.b.b.r
        public float a() {
            return s.this.k;
        }

        public void a(float f, float f2, float f3) {
            this.f624a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // androidx.d.b.b.r, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (this.f624a > 0.0f) {
                if (this.f624a / this.c < f) {
                    f = this.f624a / this.c;
                }
                s.this.k = this.f624a - (this.c * f);
                return ((this.f624a * f) - (((this.c * f) * f) / 2.0f)) + this.b;
            }
            if ((-this.f624a) / this.c < f) {
                f = (-this.f624a) / this.c;
            }
            s.this.k = this.f624a + (this.c * f);
            return (this.f624a * f) + (((this.c * f) * f) / 2.0f) + this.b;
        }
    }

    private class b {
        private static final int u = 16;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f625a;
        int[] b;
        float[] c;
        Path d;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        DashPathEffect o;
        int p;
        int s;
        private float[] v;
        final int j = -21965;
        final int k = -2067046;
        final int l = -13391360;
        final int m = 1996488704;
        final int n = 10;
        Rect q = new Rect();
        boolean r = false;
        Paint e = new Paint();

        public b() {
            this.s = 1;
            this.e.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            this.f = new Paint();
            this.f.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            this.g = new Paint();
            this.g.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            this.h = new Paint();
            this.h.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(s.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.v = new float[8];
            this.i = new Paint();
            this.i.setAntiAlias(true);
            this.o = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.g.setPathEffect(this.o);
            this.c = new float[100];
            this.b = new int[50];
            if (this.r) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.s = 4;
            }
        }

        private void a(Canvas canvas) {
            canvas.drawLines(this.f625a, this.e);
        }

        private void a(Canvas canvas, float f, float f2) {
            float f3 = this.f625a[0];
            float f4 = this.f625a[1];
            float f5 = this.f625a[this.f625a.length - 2];
            float f6 = this.f625a[this.f625a.length - 1];
            float fHypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (fHypot * fHypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float fHypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            String str = com.yftech.service.upgrade.a.d + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            a(str, this.h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.q.width() / 2), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        private void a(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.g);
            canvas.drawLine(f, f2, f3, f4, this.g);
        }

        private void a(Canvas canvas, float f, float f2, int i, int i2) {
            String str = com.yftech.service.upgrade.a.d + (((int) (((double) (((f - (i / 2)) * 100.0f) / (s.this.getWidth() - i))) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((f / 2.0f) - (this.q.width() / 2)) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            String str2 = com.yftech.service.upgrade.a.d + (((int) (((double) (((f2 - (i2 / 2)) * 100.0f) / (s.this.getHeight() - i2))) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        private void a(Canvas canvas, p pVar) {
            this.d.reset();
            for (int i = 0; i <= 50; i++) {
                pVar.a(i / 50, this.v, 0);
                this.d.moveTo(this.v[0], this.v[1]);
                this.d.lineTo(this.v[2], this.v[3]);
                this.d.lineTo(this.v[4], this.v[5]);
                this.d.lineTo(this.v[6], this.v[7]);
                this.d.close();
            }
            this.e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.d, this.e);
            canvas.translate(-2.0f, -2.0f);
            this.e.setColor(androidx.core.e.a.a.f);
            canvas.drawPath(this.d, this.e);
        }

        private void b(Canvas canvas) {
            canvas.drawLine(this.f625a[0], this.f625a[1], this.f625a[this.f625a.length - 2], this.f625a[this.f625a.length - 1], this.g);
        }

        private void b(Canvas canvas, float f, float f2) {
            float f3 = this.f625a[0];
            float f4 = this.f625a[1];
            float f5 = this.f625a[this.f625a.length - 2];
            float f6 = this.f625a[this.f625a.length - 1];
            float fMin = Math.min(f3, f5);
            float fMax = Math.max(f4, f6);
            float fMin2 = f - Math.min(f3, f5);
            float fMax2 = Math.max(f4, f6) - f2;
            String str = com.yftech.service.upgrade.a.d + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.q.width() / 2)) + fMin, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            String str2 = com.yftech.service.upgrade.a.d + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, fMax - ((fMax2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        private void b(Canvas canvas, int i, int i2, p pVar) {
            int width;
            int height;
            if (pVar.n != null) {
                width = pVar.n.getWidth();
                height = pVar.n.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            int i3 = 1;
            int i4 = 1;
            while (true) {
                int i5 = 2;
                if (i4 >= i2 - 1) {
                    break;
                }
                if (i != 4 || this.b[i4 - 1] != 0) {
                    int i6 = i4 * 2;
                    float f = this.c[i6];
                    float f2 = this.c[i6 + i3];
                    this.d.reset();
                    this.d.moveTo(f, f2 + 10.0f);
                    this.d.lineTo(f + 10.0f, f2);
                    this.d.lineTo(f, f2 - 10.0f);
                    this.d.lineTo(f - 10.0f, f2);
                    this.d.close();
                    int i7 = i4 - 1;
                    pVar.a(i7);
                    if (i == 4) {
                        if (this.b[i7] == i3) {
                            a(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (this.b[i7] == 2) {
                            b(canvas, f - 0.0f, f2 - 0.0f);
                        } else {
                            if (this.b[i7] == 3) {
                                a(canvas, f - 0.0f, f2 - 0.0f, width, height);
                            }
                            canvas.drawPath(this.d, this.i);
                        }
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f2 = f2;
                        f = f;
                        i5 = 2;
                    }
                    if (i == i5) {
                        a(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 3) {
                        b(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 6) {
                        a(canvas, f - 0.0f, f2 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.d, this.i);
                }
                i4++;
                i3 = 1;
            }
            if (this.f625a.length > 1) {
                canvas.drawCircle(this.f625a[0], this.f625a[1], 8.0f, this.f);
                canvas.drawCircle(this.f625a[this.f625a.length - 2], this.f625a[this.f625a.length - 1], 8.0f, this.f);
            }
        }

        private void c(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.p; i++) {
                if (this.b[i] == 1) {
                    z = true;
                }
                if (this.b[i] == 2) {
                    z2 = true;
                }
            }
            if (z) {
                b(canvas);
            }
            if (z2) {
                d(canvas);
            }
        }

        private void d(Canvas canvas) {
            float f = this.f625a[0];
            float f2 = this.f625a[1];
            float f3 = this.f625a[this.f625a.length - 2];
            float f4 = this.f625a[this.f625a.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        public void a(Canvas canvas, int i, int i2, p pVar) {
            if (i == 4) {
                c(canvas);
            }
            if (i == 2) {
                b(canvas);
            }
            if (i == 3) {
                d(canvas);
            }
            a(canvas);
            b(canvas, i, i2, pVar);
        }

        public void a(Canvas canvas, HashMap<View, p> map, int i, int i2) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!s.this.isInEditMode() && (i2 & 1) == 2) {
                String str = s.this.getContext().getResources().getResourceName(s.this.ao) + ":" + s.this.getProgress();
                canvas.drawText(str, 10.0f, s.this.getHeight() - 30, this.h);
                canvas.drawText(str, 11.0f, s.this.getHeight() - 29, this.e);
            }
            for (p pVar : map.values()) {
                int iE = pVar.e();
                if (i2 > 0 && iE == 0) {
                    iE = 1;
                }
                if (iE != 0) {
                    this.p = pVar.a(this.c, this.b);
                    if (iE >= 1) {
                        int i3 = i / 16;
                        if (this.f625a == null || this.f625a.length != i3 * 2) {
                            this.f625a = new float[i3 * 2];
                            this.d = new Path();
                        }
                        canvas.translate(this.s, this.s);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        pVar.a(this.f625a, i3);
                        a(canvas, iE, this.p, pVar);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        canvas.translate(-this.s, -this.s);
                        a(canvas, iE, this.p, pVar);
                        if (iE == 5) {
                            a(canvas, pVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.q);
        }
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.d.c.b.f f626a = new androidx.d.c.b.f();
        androidx.d.c.b.f b = new androidx.d.c.b.f();
        androidx.d.e.g c = null;
        androidx.d.e.g d = null;
        int e;
        int f;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void a(androidx.d.c.b.f fVar, androidx.d.e.g gVar) {
            SparseArray<androidx.d.c.b.e> sparseArray = new SparseArray<>();
            androidx.d.e.h.a aVar = new androidx.d.e.h.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, fVar);
            sparseArray.put(s.this.getId(), fVar);
            for (androidx.d.c.b.e eVar : fVar.ay()) {
                sparseArray.put(((View) eVar.aa()).getId(), eVar);
            }
            for (androidx.d.c.b.e eVar2 : fVar.ay()) {
                View view = (View) eVar2.aa();
                gVar.a(view.getId(), aVar);
                eVar2.p(gVar.f(view.getId()));
                eVar2.q(gVar.e(view.getId()));
                if (view instanceof androidx.d.e.c) {
                    gVar.a((androidx.d.e.c) view, eVar2, aVar, sparseArray);
                    if (view instanceof androidx.d.e.a) {
                        ((androidx.d.e.a) view).c();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar.resolveLayoutDirection(s.this.getLayoutDirection());
                } else {
                    aVar.resolveLayoutDirection(0);
                }
                s.this.a(false, view, eVar2, (androidx.d.e.d.a) aVar, sparseArray);
                if (gVar.c(view.getId()) == 1) {
                    eVar2.k(view.getVisibility());
                } else {
                    eVar2.k(gVar.d(view.getId()));
                }
            }
            for (androidx.d.c.b.e eVar3 : fVar.ay()) {
                if (eVar3 instanceof androidx.d.c.b.m) {
                    androidx.d.e.c cVar = (androidx.d.e.c) eVar3.aa();
                    androidx.d.c.b.i iVar = (androidx.d.c.b.i) eVar3;
                    cVar.a(fVar, iVar, sparseArray);
                    ((androidx.d.c.b.m) iVar).i();
                }
            }
        }

        private void a(String str, androidx.d.c.b.e eVar) {
            String string;
            String string2;
            String string3;
            String string4;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            if (eVar.U.c != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("T");
                sb2.append(eVar.U.c.b == androidx.d.c.b.d.a.TOP ? "T" : "B");
                string = sb2.toString();
            } else {
                string = "__";
            }
            sb.append(string);
            String string5 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string5);
            if (eVar.W.c != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("B");
                sb4.append(eVar.W.c.b == androidx.d.c.b.d.a.TOP ? "T" : "B");
                string2 = sb4.toString();
            } else {
                string2 = "__";
            }
            sb3.append(string2);
            String string6 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string6);
            if (eVar.T.c != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("L");
                sb6.append(eVar.T.c.b == androidx.d.c.b.d.a.LEFT ? "L" : "R");
                string3 = sb6.toString();
            } else {
                string3 = "__";
            }
            sb5.append(string3);
            String string7 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string7);
            if (eVar.V.c != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("R");
                sb8.append(eVar.V.c.b == androidx.d.c.b.d.a.LEFT ? "L" : "R");
                string4 = sb8.toString();
            } else {
                string4 = "__";
            }
            sb7.append(string4);
            Log.v(s.g, str + sb7.toString() + " ---  " + eVar);
        }

        private void a(String str, androidx.d.c.b.f fVar) {
            String str2 = str + " " + androidx.d.b.b.c.a((View) fVar.aa());
            Log.v(s.g, str2 + "  ========= " + fVar);
            int size = fVar.ay().size();
            for (int i = 0; i < size; i++) {
                String str3 = str2 + "[" + i + "] ";
                androidx.d.c.b.e eVar = fVar.ay().get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(com.yftech.service.upgrade.a.d);
                sb.append(eVar.U.c != null ? "T" : "_");
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(eVar.W.c != null ? "B" : "_");
                String string2 = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string2);
                sb3.append(eVar.T.c != null ? "L" : "_");
                String string3 = sb3.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string3);
                sb4.append(eVar.V.c != null ? "R" : "_");
                String string4 = sb4.toString();
                View view = (View) eVar.aa();
                String strA = androidx.d.b.b.c.a(view);
                if (view instanceof TextView) {
                    strA = strA + "(" + ((Object) ((TextView) view).getText()) + ")";
                }
                Log.v(s.g, str3 + "  " + strA + " " + eVar + " " + string4);
            }
            Log.v(s.g, str2 + " done. ");
        }

        private void a(String str, androidx.d.e.d.a aVar) {
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            sb.append(aVar.I != -1 ? "SS" : "__");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(aVar.H != -1 ? "|SE" : "|__");
            String string2 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(string2);
            sb3.append(aVar.J != -1 ? "|ES" : "|__");
            String string3 = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(string3);
            sb4.append(aVar.K != -1 ? "|EE" : "|__");
            String string4 = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string4);
            sb5.append(aVar.v != -1 ? "|LL" : "|__");
            String string5 = sb5.toString();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(string5);
            sb6.append(aVar.w != -1 ? "|LR" : "|__");
            String string6 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(string6);
            sb7.append(aVar.x != -1 ? "|RL" : "|__");
            String string7 = sb7.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(string7);
            sb8.append(aVar.y != -1 ? "|RR" : "|__");
            String string8 = sb8.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(string8);
            sb9.append(aVar.z != -1 ? "|TT" : "|__");
            String string9 = sb9.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(string9);
            sb10.append(aVar.A != -1 ? "|TB" : "|__");
            String string10 = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(string10);
            sb11.append(aVar.B != -1 ? "|BT" : "|__");
            String string11 = sb11.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append(string11);
            sb12.append(aVar.C != -1 ? "|BB" : "|__");
            Log.v(s.g, str + sb12.toString());
        }

        androidx.d.c.b.e a(androidx.d.c.b.f fVar, View view) {
            if (fVar.aa() == view) {
                return fVar;
            }
            ArrayList<androidx.d.c.b.e> arrayListAy = fVar.ay();
            int size = arrayListAy.size();
            for (int i = 0; i < size; i++) {
                androidx.d.c.b.e eVar = arrayListAy.get(i);
                if (eVar.aa() == view) {
                    return eVar;
                }
            }
            return null;
        }

        public void a() {
            a(s.this.ap, s.this.aq);
            s.this.l();
        }

        public void a(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            s.this.S = mode;
            s.this.T = mode2;
            int optimizationLevel = s.this.getOptimizationLevel();
            if (s.this.l == s.this.getStartState()) {
                s.this.a(this.b, optimizationLevel, i, i2);
                if (this.c != null) {
                    s.this.a(this.f626a, optimizationLevel, i, i2);
                }
            } else {
                if (this.c != null) {
                    s.this.a(this.f626a, optimizationLevel, i, i2);
                }
                s.this.a(this.b, optimizationLevel, i, i2);
            }
            if (((s.this.getParent() instanceof s) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                s.this.S = mode;
                s.this.T = mode2;
                if (s.this.l == s.this.getStartState()) {
                    s.this.a(this.b, optimizationLevel, i, i2);
                    if (this.c != null) {
                        s.this.a(this.f626a, optimizationLevel, i, i2);
                    }
                } else {
                    if (this.c != null) {
                        s.this.a(this.f626a, optimizationLevel, i, i2);
                    }
                    s.this.a(this.b, optimizationLevel, i, i2);
                }
                s.this.O = this.f626a.I();
                s.this.P = this.f626a.L();
                s.this.Q = this.b.I();
                s.this.R = this.b.L();
                s.this.N = (s.this.O == s.this.Q && s.this.P == s.this.R) ? false : true;
            }
            int i3 = s.this.O;
            int i4 = s.this.P;
            if (s.this.S == Integer.MIN_VALUE || s.this.S == 0) {
                i3 = (int) (s.this.O + (s.this.U * (s.this.Q - s.this.O)));
            }
            int i5 = i3;
            if (s.this.T == Integer.MIN_VALUE || s.this.T == 0) {
                i4 = (int) (s.this.P + (s.this.U * (s.this.R - s.this.P)));
            }
            s.this.a(i, i2, i5, i4, this.f626a.aq() || this.b.aq(), this.f626a.ar() || this.b.ar());
        }

        void a(androidx.d.c.b.f fVar, androidx.d.c.b.f fVar2) {
            androidx.d.c.b.e jVar;
            ArrayList<androidx.d.c.b.e> arrayListAy = fVar.ay();
            HashMap<androidx.d.c.b.e, androidx.d.c.b.e> map = new HashMap<>();
            map.put(fVar, fVar2);
            fVar2.ay().clear();
            fVar2.a(fVar, map);
            for (androidx.d.c.b.e eVar : arrayListAy) {
                if (eVar instanceof androidx.d.c.b.a) {
                    jVar = new androidx.d.c.b.a();
                } else if (eVar instanceof androidx.d.c.b.h) {
                    jVar = new androidx.d.c.b.h();
                } else if (eVar instanceof androidx.d.c.b.g) {
                    jVar = new androidx.d.c.b.g();
                } else {
                    jVar = eVar instanceof androidx.d.c.b.i ? new androidx.d.c.b.j() : new androidx.d.c.b.e();
                }
                fVar2.b(jVar);
                map.put(eVar, jVar);
            }
            for (androidx.d.c.b.e eVar2 : arrayListAy) {
                map.get(eVar2).a(eVar2, map);
            }
        }

        void a(androidx.d.c.b.f fVar, androidx.d.e.g gVar, androidx.d.e.g gVar2) {
            this.c = gVar;
            this.d = gVar2;
            this.f626a = new androidx.d.c.b.f();
            this.b = new androidx.d.c.b.f();
            this.f626a.a(s.this.ad.h());
            this.b.a(s.this.ad.h());
            this.f626a.aA();
            this.b.aA();
            a(s.this.ad, this.f626a);
            a(s.this.ad, this.b);
            if (s.this.o > 0.5d) {
                if (gVar != null) {
                    a(this.f626a, gVar);
                }
                a(this.b, gVar2);
            } else {
                a(this.b, gVar2);
                if (gVar != null) {
                    a(this.f626a, gVar);
                }
            }
            this.f626a.i(s.this.j());
            this.f626a.g();
            this.b.i(s.this.j());
            this.b.g();
            ViewGroup.LayoutParams layoutParams = s.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.f626a.a(androidx.d.c.b.e.a.WRAP_CONTENT);
                    this.b.a(androidx.d.c.b.e.a.WRAP_CONTENT);
                }
                if (layoutParams.height == -2) {
                    this.f626a.b(androidx.d.c.b.e.a.WRAP_CONTENT);
                    this.b.b(androidx.d.c.b.e.a.WRAP_CONTENT);
                }
            }
        }

        public void b() {
            int childCount = s.this.getChildCount();
            s.this.m.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = s.this.getChildAt(i);
                s.this.m.put(childAt, new p(childAt));
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = s.this.getChildAt(i2);
                p pVar = s.this.m.get(childAt2);
                if (pVar != null) {
                    if (this.c != null) {
                        androidx.d.c.b.e eVarA = a(this.f626a, childAt2);
                        if (eVarA != null) {
                            pVar.a(eVarA, this.c);
                        } else if (s.this.v != 0) {
                            Log.e(s.g, androidx.d.b.b.c.a() + "no widget for  " + androidx.d.b.b.c.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.d != null) {
                        androidx.d.c.b.e eVarA2 = a(this.b, childAt2);
                        if (eVarA2 != null) {
                            pVar.b(eVarA2, this.d);
                        } else if (s.this.v != 0) {
                            Log.e(s.g, androidx.d.b.b.c.a() + "no widget for  " + androidx.d.b.b.c.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        public void b(int i, int i2) {
            this.e = i;
            this.f = i2;
        }

        public boolean c(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }
    }

    protected interface d {
        void a();

        void a(int i);

        void a(int i, float f);

        void a(MotionEvent motionEvent);

        float b(int i);

        void b();

        float c();

        float c(int i);

        float d();
    }

    private static class e implements d {
        private static e b = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        VelocityTracker f627a;

        private e() {
        }

        public static e e() {
            b.f627a = VelocityTracker.obtain();
            return b;
        }

        @Override // androidx.d.b.b.s.d
        public void a() {
            if (this.f627a != null) {
                this.f627a.recycle();
                this.f627a = null;
            }
        }

        @Override // androidx.d.b.b.s.d
        public void a(int i) {
            if (this.f627a != null) {
                this.f627a.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.d.b.b.s.d
        public void a(int i, float f) {
            if (this.f627a != null) {
                this.f627a.computeCurrentVelocity(i, f);
            }
        }

        @Override // androidx.d.b.b.s.d
        public void a(MotionEvent motionEvent) {
            if (this.f627a != null) {
                this.f627a.addMovement(motionEvent);
            }
        }

        @Override // androidx.d.b.b.s.d
        public float b(int i) {
            if (this.f627a != null) {
                return this.f627a.getXVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.d.b.b.s.d
        public void b() {
            if (this.f627a != null) {
                this.f627a.clear();
            }
        }

        @Override // androidx.d.b.b.s.d
        public float c() {
            if (this.f627a != null) {
                return this.f627a.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.d.b.b.s.d
        public float c(int i) {
            if (this.f627a != null) {
                return c(i);
            }
            return 0.0f;
        }

        @Override // androidx.d.b.b.s.d
        public float d() {
            if (this.f627a != null) {
                return this.f627a.getYVelocity();
            }
            return 0.0f;
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f628a = Float.NaN;
        float b = Float.NaN;
        int c = -1;
        int d = -1;
        final String e = "motion.progress";
        final String f = "motion.velocity";
        final String g = "motion.StartState";
        final String h = "motion.EndState";

        f() {
        }

        void a() {
            if (this.c != -1 || this.d != -1) {
                if (this.c == -1) {
                    s.this.b(this.d);
                } else if (this.d == -1) {
                    s.this.a(this.c, -1, -1);
                } else {
                    s.this.a(this.c, this.d);
                }
                s.this.setState(h.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.f628a)) {
                    return;
                }
                s.this.setProgress(this.f628a);
            } else {
                s.this.a(this.f628a, this.b);
                this.f628a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            }
        }

        public void a(float f) {
            this.f628a = f;
        }

        public void a(int i) {
            this.d = i;
        }

        public void a(Bundle bundle) {
            this.f628a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f628a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void b(float f) {
            this.b = f;
        }

        public void b(int i) {
            this.c = i;
        }

        public void c() {
            this.d = s.this.ao;
            this.c = s.this.an;
            this.b = s.this.getVelocity();
            this.f628a = s.this.getProgress();
        }
    }

    public interface g {
        void a(s sVar, int i);

        void a(s sVar, int i, int i2);

        void a(s sVar, int i, int i2, float f);

        void a(s sVar, int i, boolean z, float f);
    }

    enum h {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public s(@ah Context context) {
        super(context);
        this.k = 0.0f;
        this.an = -1;
        this.l = -1;
        this.ao = -1;
        this.ap = 0;
        this.aq = 0;
        this.ar = true;
        this.m = new HashMap<>();
        this.as = 0L;
        this.at = 1.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = false;
        this.r = false;
        this.v = 0;
        this.az = false;
        this.aA = new androidx.d.b.a.h();
        this.aB = new a();
        this.y = true;
        this.D = false;
        this.aD = false;
        this.aE = null;
        this.aF = null;
        this.aG = null;
        this.aH = 0;
        this.aI = -1L;
        this.aJ = 0.0f;
        this.aK = 0;
        this.aL = 0.0f;
        this.I = false;
        this.N = false;
        this.aM = new androidx.d.b.b.g();
        this.aN = false;
        this.V = h.UNDEFINED;
        this.W = new c();
        this.aQ = false;
        this.aR = new RectF();
        this.aS = null;
        this.aa = new ArrayList<>();
        b((AttributeSet) null);
    }

    public s(@ah Context context, @ai AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0.0f;
        this.an = -1;
        this.l = -1;
        this.ao = -1;
        this.ap = 0;
        this.aq = 0;
        this.ar = true;
        this.m = new HashMap<>();
        this.as = 0L;
        this.at = 1.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = false;
        this.r = false;
        this.v = 0;
        this.az = false;
        this.aA = new androidx.d.b.a.h();
        this.aB = new a();
        this.y = true;
        this.D = false;
        this.aD = false;
        this.aE = null;
        this.aF = null;
        this.aG = null;
        this.aH = 0;
        this.aI = -1L;
        this.aJ = 0.0f;
        this.aK = 0;
        this.aL = 0.0f;
        this.I = false;
        this.N = false;
        this.aM = new androidx.d.b.b.g();
        this.aN = false;
        this.V = h.UNDEFINED;
        this.W = new c();
        this.aQ = false;
        this.aR = new RectF();
        this.aS = null;
        this.aa = new ArrayList<>();
        b(attributeSet);
    }

    public s(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0.0f;
        this.an = -1;
        this.l = -1;
        this.ao = -1;
        this.ap = 0;
        this.aq = 0;
        this.ar = true;
        this.m = new HashMap<>();
        this.as = 0L;
        this.at = 1.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = false;
        this.r = false;
        this.v = 0;
        this.az = false;
        this.aA = new androidx.d.b.a.h();
        this.aB = new a();
        this.y = true;
        this.D = false;
        this.aD = false;
        this.aE = null;
        this.aF = null;
        this.aG = null;
        this.aH = 0;
        this.aI = -1L;
        this.aJ = 0.0f;
        this.aK = 0;
        this.aL = 0.0f;
        this.I = false;
        this.N = false;
        this.aM = new androidx.d.b.b.g();
        this.aN = false;
        this.V = h.UNDEFINED;
        this.W = new c();
        this.aQ = false;
        this.aR = new RectF();
        this.aS = null;
        this.aa = new ArrayList<>();
        b(attributeSet);
    }

    private void a(s sVar, int i, int i2) {
        if (this.aw != null) {
            this.aw.a(this, i, i2);
        }
        if (this.aG != null) {
            Iterator<g> it = this.aG.iterator();
            while (it.hasNext()) {
                it.next().a(sVar, i, i2);
            }
        }
    }

    private void a(u.a aVar) {
        Log.v(g, "CHECK: transition = " + aVar.a(getContext()));
        Log.v(g, "CHECK: transition.setDuration = " + aVar.f());
        if (aVar.e() == aVar.d()) {
            Log.e(g, "CHECK: start and end constraint set should not be the same!");
        }
    }

    private static boolean a(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    private boolean a(float f2, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(view.getLeft() + f2, view.getTop() + f3, viewGroup.getChildAt(i), motionEvent)) {
                    return true;
                }
            }
        }
        this.aR.set(view.getLeft() + f2, view.getTop() + f3, f2 + view.getRight(), f3 + view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (this.aR.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent)) {
                return true;
            }
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void b(int i, androidx.d.e.g gVar) {
        String strA = androidx.d.b.b.c.a(getContext(), i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            if (id == -1) {
                Log.w(g, "CHECK: " + strA + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (gVar.k(id) == null) {
                Log.w(g, "CHECK: " + strA + " NO CONSTRAINTS for " + androidx.d.b.b.c.a(childAt));
            }
        }
        int[] iArrB = gVar.b();
        for (int i3 = 0; i3 < iArrB.length; i3++) {
            int i4 = iArrB[i3];
            String strA2 = androidx.d.b.b.c.a(getContext(), i4);
            if (findViewById(iArrB[i3]) == null) {
                Log.w(g, "CHECK: " + strA + " NO View matches id " + strA2);
            }
            if (gVar.e(i4) == -1) {
                Log.w(g, "CHECK: " + strA + "(" + strA2 + ") no LAYOUT_HEIGHT");
            }
            if (gVar.f(i4) == -1) {
                Log.w(g, "CHECK: " + strA + "(" + strA2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void b(AttributeSet attributeSet) {
        h = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == androidx.d.e.m.C0052m.MotionLayout_layoutDescription) {
                    this.i = new u(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == androidx.d.e.m.C0052m.MotionLayout_currentState) {
                    this.l = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == androidx.d.e.m.C0052m.MotionLayout_motionProgress) {
                    this.p = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.q = true;
                } else if (index == androidx.d.e.m.C0052m.MotionLayout_applyMotionScene) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                } else if (index == androidx.d.e.m.C0052m.MotionLayout_showPaths) {
                    if (this.v == 0) {
                        this.v = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == androidx.d.e.m.C0052m.MotionLayout_motionDebug) {
                    this.v = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.i == null) {
                Log.e(g, "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.i = null;
            }
        }
        if (this.v != 0) {
            p();
        }
        if (this.l != -1 || this.i == null) {
            return;
        }
        this.l = this.i.d();
        this.an = this.i.d();
        this.ao = this.i.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int childCount = getChildCount();
        this.W.b();
        boolean z = true;
        this.q = true;
        int width = getWidth();
        int height = getHeight();
        int iH = this.i.h();
        int i = 0;
        if (iH != -1) {
            for (int i2 = 0; i2 < childCount; i2++) {
                p pVar = this.m.get(getChildAt(i2));
                if (pVar != null) {
                    pVar.b(iH);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            p pVar2 = this.m.get(getChildAt(i3));
            if (pVar2 != null) {
                this.i.a(pVar2);
                pVar2.a(width, height, this.at, getNanoTime());
            }
        }
        float fI = this.i.i();
        if (fI != 0.0f) {
            boolean z2 = ((double) fI) < 0.0d;
            float fAbs = Math.abs(fI);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    z = false;
                    break;
                }
                p pVar3 = this.m.get(getChildAt(i4));
                if (!Float.isNaN(pVar3.q)) {
                    break;
                }
                float fC = pVar3.c();
                float fD = pVar3.d();
                float f2 = z2 ? fD - fC : fD + fC;
                fMin2 = Math.min(fMin2, f2);
                fMax2 = Math.max(fMax2, f2);
                i4++;
            }
            if (!z) {
                while (i < childCount) {
                    p pVar4 = this.m.get(getChildAt(i));
                    float fC2 = pVar4.c();
                    float fD2 = pVar4.d();
                    float f3 = z2 ? fD2 - fC2 : fD2 + fC2;
                    pVar4.s = 1.0f / (1.0f - fAbs);
                    pVar4.r = fAbs - (((f3 - fMin2) * fAbs) / (fMax2 - fMin2));
                    i++;
                }
                return;
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                p pVar5 = this.m.get(getChildAt(i5));
                if (!Float.isNaN(pVar5.q)) {
                    fMin = Math.min(fMin, pVar5.q);
                    fMax = Math.max(fMax, pVar5.q);
                }
            }
            while (i < childCount) {
                p pVar6 = this.m.get(getChildAt(i));
                if (!Float.isNaN(pVar6.q)) {
                    pVar6.s = 1.0f / (1.0f - fAbs);
                    if (z2) {
                        pVar6.r = fAbs - (((fMax - pVar6.q) / (fMax - fMin)) * fAbs);
                    } else {
                        pVar6.r = fAbs - (((pVar6.q - fMin) * fAbs) / (fMax - fMin));
                    }
                }
                i++;
            }
        }
    }

    private void m() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            p pVar = this.m.get(childAt);
            if (pVar != null) {
                pVar.b(childAt);
            }
        }
    }

    private void n() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.v(g, " " + androidx.d.b.b.c.a() + " " + androidx.d.b.b.c.a((View) this) + " " + androidx.d.b.b.c.a(getContext(), this.l) + " " + androidx.d.b.b.c.a(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void o() {
        boolean z;
        float fSignum = Math.signum(this.p - this.o);
        long nanoTime = getNanoTime();
        float interpolation = this.o + (!(this.j instanceof androidx.d.b.a.h) ? (((nanoTime - this.au) * fSignum) * 1.0E-9f) / this.at : 0.0f);
        if (this.av) {
            interpolation = this.p;
        }
        if ((fSignum <= 0.0f || interpolation < this.p) && (fSignum > 0.0f || interpolation > this.p)) {
            z = false;
        } else {
            interpolation = this.p;
            z = true;
        }
        if (this.j != null && !z) {
            interpolation = this.az ? this.j.getInterpolation((nanoTime - this.as) * 1.0E-9f) : this.j.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.p) || (fSignum <= 0.0f && interpolation <= this.p)) {
            interpolation = this.p;
        }
        this.U = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            p pVar = this.m.get(childAt);
            if (pVar != null) {
                pVar.a(childAt, interpolation, nanoTime2, this.aM);
            }
        }
        if (this.N) {
            requestLayout();
        }
    }

    private void p() {
        if (this.i == null) {
            Log.e(g, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        b(this.i.d(), this.i.c(this.i.d()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        for (u.a aVar : this.i.a()) {
            if (aVar == this.i.f) {
                Log.v(g, "CHECK: CURRENT");
            }
            a(aVar);
            int iE = aVar.e();
            int iD = aVar.d();
            String strA = androidx.d.b.b.c.a(getContext(), iE);
            String strA2 = androidx.d.b.b.c.a(getContext(), iD);
            if (sparseIntArray.get(iE) == iD) {
                Log.e(g, "CHECK: two transitions with the same start and end " + strA + "->" + strA2);
            }
            if (sparseIntArray2.get(iD) == iE) {
                Log.e(g, "CHECK: you can't have reverse transitions" + strA + "->" + strA2);
            }
            sparseIntArray.put(iE, iD);
            sparseIntArray2.put(iD, iE);
            if (this.i.c(iE) == null) {
                Log.e(g, " no such constraintSetStart " + strA);
            }
            if (this.i.c(iD) == null) {
                Log.e(g, " no such constraintSetEnd " + strA);
            }
        }
    }

    private void q() {
        if ((this.aw == null && (this.aG == null || this.aG.isEmpty())) || this.aL == this.n) {
            return;
        }
        if (this.aK != -1) {
            if (this.aw != null) {
                this.aw.a(this, this.an, this.ao);
            }
            if (this.aG != null) {
                Iterator<g> it = this.aG.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.an, this.ao);
                }
            }
            this.I = true;
        }
        this.aK = -1;
        this.aL = this.n;
        if (this.aw != null) {
            this.aw.a(this, this.an, this.ao, this.n);
        }
        if (this.aG != null) {
            Iterator<g> it2 = this.aG.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.an, this.ao, this.n);
            }
        }
        this.I = true;
    }

    private void r() {
        if (this.aw == null && (this.aG == null || this.aG.isEmpty())) {
            return;
        }
        this.I = false;
        for (Integer num : this.aa) {
            if (this.aw != null) {
                this.aw.a(this, num.intValue());
            }
            if (this.aG != null) {
                Iterator<g> it = this.aG.iterator();
                while (it.hasNext()) {
                    it.next().a(this, num.intValue());
                }
            }
        }
        this.aa.clear();
    }

    int a(String str) {
        if (this.i == null) {
            return 0;
        }
        return this.i.b(str);
    }

    protected d a() {
        return e.e();
    }

    void a(float f2) {
        if (this.i == null) {
            return;
        }
        if (this.o != this.n && this.av) {
            this.o = this.n;
        }
        if (this.o == f2) {
            return;
        }
        this.az = false;
        float f3 = this.o;
        this.p = f2;
        this.at = this.i.g() / 1000.0f;
        setProgress(this.p);
        this.j = this.i.f();
        this.av = false;
        this.as = getNanoTime();
        this.q = true;
        this.n = f3;
        this.o = f3;
        invalidate();
    }

    public void a(float f2, float f3) {
        if (isAttachedToWindow()) {
            setProgress(f2);
            setState(h.MOVING);
            this.k = f3;
            a(1.0f);
            return;
        }
        if (this.aO == null) {
            this.aO = new f();
        }
        this.aO.a(f2);
        this.aO.b(f3);
    }

    @Override // androidx.d.e.d
    public void a(int i) {
        if (i == 0) {
            this.i = null;
            return;
        }
        try {
            this.i = new u(getContext(), this, i);
            if (Build.VERSION.SDK_INT < 19 || isAttachedToWindow()) {
                this.i.b(this);
                this.W.a(this.ad, this.i.c(this.an), this.i.c(this.ao));
                g();
                this.i.a(j());
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e2);
        }
    }

    public void a(int i, float f2, float f3) {
        if (this.i == null || this.o == f2) {
            return;
        }
        this.az = true;
        this.as = getNanoTime();
        this.at = this.i.g() / 1000.0f;
        this.p = f2;
        this.q = true;
        switch (i) {
            case 0:
            case 1:
            case 2:
                if (i == 1) {
                    f2 = 0.0f;
                } else if (i == 2) {
                    f2 = 1.0f;
                }
                this.aA.a(this.o, f2, f3, this.at, this.i.j(), this.i.k());
                int i2 = this.l;
                this.p = f2;
                this.l = i2;
                this.j = this.aA;
                break;
            case 4:
                this.aB.a(f3, this.o, this.i.j());
                this.j = this.aB;
                break;
            case 5:
                if (!a(f3, this.o, this.i.j())) {
                    this.aA.a(this.o, f2, f3, this.at, this.i.j(), this.i.k());
                    this.k = 0.0f;
                    int i3 = this.l;
                    this.p = f2;
                    this.l = i3;
                    this.j = this.aA;
                } else {
                    this.aB.a(f3, this.o, this.i.j());
                    this.j = this.aB;
                }
                break;
        }
        this.av = false;
        this.as = getNanoTime();
        invalidate();
    }

    void a(int i, float f2, float f3, float f4, float[] fArr) {
        String resourceName;
        HashMap<View, p> map = this.m;
        View viewG = g(i);
        p pVar = map.get(viewG);
        if (pVar != null) {
            pVar.a(f2, f3, f4, fArr);
            float y = viewG.getY();
            float f5 = f2 - this.ax;
            float f6 = this.ay;
            int i2 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            this.ax = f2;
            this.ay = y;
            return;
        }
        if (viewG == null) {
            resourceName = com.yftech.service.upgrade.a.d + i;
        } else {
            resourceName = viewG.getContext().getResources().getResourceName(i);
        }
        Log.w(g, "WARNING could not find view id " + resourceName);
    }

    public void a(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.aO == null) {
                this.aO = new f();
            }
            this.aO.b(i);
            this.aO.a(i2);
            return;
        }
        if (this.i != null) {
            this.an = i;
            this.ao = i2;
            this.i.a(i, i2);
            this.W.a(this.ad, this.i.c(i), this.i.c(i2));
            g();
            this.o = 0.0f;
            b();
        }
    }

    @Override // androidx.d.e.d
    public void a(int i, int i2, int i3) {
        setState(h.SETUP);
        this.l = i;
        this.an = -1;
        this.ao = -1;
        if (this.af != null) {
            this.af.b(i, i2, i3);
        } else if (this.i != null) {
            this.i.c(i).c(this);
        }
    }

    public void a(int i, androidx.d.e.g gVar) {
        if (this.i != null) {
            this.i.a(i, gVar);
        }
        h();
        if (this.l == i) {
            gVar.c(this);
        }
    }

    public void a(int i, boolean z) {
        u.a aVarE = e(i);
        if (z) {
            aVarE.a(true);
            return;
        }
        if (aVarE == this.i.f) {
            for (u.a aVar : this.i.a(this.l)) {
                if (aVar.l()) {
                    this.i.f = aVar;
                    break;
                }
            }
        }
        aVarE.a(false);
    }

    public void a(int i, boolean z, float f2) {
        if (this.aw != null) {
            this.aw.a(this, i, z, f2);
        }
        if (this.aG != null) {
            Iterator<g> it = this.aG.iterator();
            while (it.hasNext()) {
                it.next().a(this, i, z, f2);
            }
        }
    }

    public void a(View view, float f2, float f3, float[] fArr, int i) {
        float fA;
        float f4;
        float f5 = this.k;
        float f6 = this.o;
        if (this.j != null) {
            float fSignum = Math.signum(this.p - this.o);
            float interpolation = this.j.getInterpolation(this.o + aP);
            float interpolation2 = this.j.getInterpolation(this.o);
            fA = (fSignum * ((interpolation - interpolation2) / aP)) / this.at;
            f4 = interpolation2;
        } else {
            fA = f5;
            f4 = f6;
        }
        if (this.j instanceof r) {
            fA = ((r) this.j).a();
        }
        float f7 = fA;
        p pVar = this.m.get(view);
        if ((i & 1) == 0) {
            pVar.a(f4, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            pVar.a(f4, f2, f3, fArr);
        }
        if (i < 2) {
            fArr[0] = fArr[0] * f7;
            fArr[1] = fArr[1] * f7;
        }
    }

    @Override // androidx.core.n.v
    public void a(View view, int i) {
        if (this.i == null) {
            return;
        }
        this.i.b(this.E / this.H, this.F / this.H);
    }

    @Override // androidx.core.n.v
    public void a(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.n.w
    public void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.D || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.D = false;
    }

    @Override // androidx.core.n.v
    public void a(final View view, int i, int i2, int[] iArr, int i3) {
        y yVarJ;
        int iF;
        if (this.i == null || this.i.f == null || !this.i.f.l()) {
            return;
        }
        u.a aVar = this.i.f;
        if (aVar == null || !aVar.l() || (yVarJ = aVar.j()) == null || (iF = yVarJ.f()) == -1 || view.getId() == iF) {
            if (this.i != null && this.i.m() && ((this.n == 1.0f || this.n == 0.0f) && view.canScrollVertically(-1))) {
                return;
            }
            if (aVar.j() != null && (this.i.f.j().h() & 1) != 0) {
                float fC = this.i.c(i, i2);
                if ((this.o <= 0.0f && fC < 0.0f) || (this.o >= 1.0f && fC > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() { // from class: androidx.d.b.b.s.1
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            float f2 = this.n;
            long nanoTime = getNanoTime();
            float f3 = i;
            this.E = f3;
            float f4 = i2;
            this.F = f4;
            this.H = (float) ((nanoTime - this.G) * 1.0E-9d);
            this.G = nanoTime;
            this.i.a(f3, f4);
            if (f2 != this.n) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            a(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.D = true;
        }
    }

    public void a(g gVar) {
        if (this.aG == null) {
            this.aG = new ArrayList<>();
        }
        this.aG.add(gVar);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00de A[PHI: r9
      0x00de: PHI (r9v8 float) = (r9v7 float), (r9v9 float), (r9v9 float) binds: [B:42:0x00aa, B:52:0x00d2, B:54:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    void a(boolean z) {
        float f2;
        boolean z2;
        boolean z3;
        if (this.au == -1) {
            this.au = getNanoTime();
        }
        if (this.o > 0.0f && this.o < 1.0f) {
            this.l = -1;
        }
        if (this.aD || (this.q && (z || this.p != this.o))) {
            float fSignum = Math.signum(this.p - this.o);
            long nanoTime = getNanoTime();
            if (this.j instanceof r) {
                f2 = 0.0f;
            } else {
                f2 = (((nanoTime - this.au) * fSignum) * 1.0E-9f) / this.at;
                this.k = f2;
            }
            float f3 = this.o + f2;
            if (this.av) {
                f3 = this.p;
            }
            if ((fSignum <= 0.0f || f3 < this.p) && (fSignum > 0.0f || f3 > this.p)) {
                z2 = false;
            } else {
                f3 = this.p;
                this.q = false;
                z2 = true;
            }
            this.o = f3;
            this.n = f3;
            this.au = nanoTime;
            if (this.j != null && !z2) {
                if (this.az) {
                    float interpolation = this.j.getInterpolation((nanoTime - this.as) * 1.0E-9f);
                    this.o = interpolation;
                    this.au = nanoTime;
                    if (this.j instanceof r) {
                        float fA = ((r) this.j).a();
                        this.k = fA;
                        if (Math.abs(fA) * this.at <= aP) {
                            this.q = false;
                        }
                        if (fA > 0.0f && interpolation >= 1.0f) {
                            this.o = 1.0f;
                            this.q = false;
                            interpolation = 1.0f;
                        }
                        if (fA >= 0.0f || interpolation > 0.0f) {
                            f3 = interpolation;
                        } else {
                            this.o = 0.0f;
                            this.q = false;
                            f3 = 0.0f;
                        }
                    } else {
                        f3 = interpolation;
                    }
                } else {
                    float interpolation2 = this.j.getInterpolation(f3);
                    if (this.j instanceof r) {
                        this.k = ((r) this.j).a();
                    } else {
                        this.k = ((this.j.getInterpolation(f3 + f2) - interpolation2) * fSignum) / f2;
                    }
                    f3 = interpolation2;
                }
            }
            if (Math.abs(this.k) > aP) {
                setState(h.MOVING);
            }
            if ((fSignum > 0.0f && f3 >= this.p) || (fSignum <= 0.0f && f3 <= this.p)) {
                f3 = this.p;
                this.q = false;
            }
            if (f3 >= 1.0f || f3 <= 0.0f) {
                this.q = false;
                setState(h.FINISHED);
            }
            int childCount = getChildCount();
            this.aD = false;
            long nanoTime2 = getNanoTime();
            this.U = f3;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                p pVar = this.m.get(childAt);
                if (pVar != null) {
                    this.aD = pVar.a(childAt, f3, nanoTime2, this.aM) | this.aD;
                }
            }
            boolean z4 = (fSignum > 0.0f && f3 >= this.p) || (fSignum <= 0.0f && f3 <= this.p);
            if (!this.aD && !this.q && z4) {
                setState(h.FINISHED);
            }
            if (this.N) {
                requestLayout();
            }
            this.aD = (!z4) | this.aD;
            if (f3 > 0.0f || this.an == -1 || this.l == this.an) {
                z3 = false;
            } else {
                this.l = this.an;
                this.i.c(this.an).e(this);
                setState(h.FINISHED);
                z3 = true;
            }
            if (f3 >= 1.0d && this.l != this.ao) {
                this.l = this.ao;
                this.i.c(this.ao).e(this);
                setState(h.FINISHED);
                z3 = true;
            }
            if (this.aD || this.q) {
                invalidate();
            } else if ((fSignum > 0.0f && f3 == 1.0f) || (fSignum < 0.0f && f3 == 0.0f)) {
                setState(h.FINISHED);
            }
            if ((!this.aD && this.q && fSignum > 0.0f && f3 == 1.0f) || (fSignum < 0.0f && f3 == 0.0f)) {
                d();
            }
        } else {
            z3 = false;
        }
        if (this.o >= 1.0f) {
            if (this.l != this.ao) {
                z3 = true;
            }
            this.l = this.ao;
        } else if (this.o <= 0.0f) {
            if (this.l != this.an) {
                z3 = true;
            }
            this.l = this.an;
        }
        this.aQ |= z3;
        if (z3 && !this.aN) {
            requestLayout();
        }
        this.n = this.o;
    }

    @Override // androidx.core.n.v
    public boolean a(View view, View view2, int i, int i2) {
        return (this.i == null || this.i.f == null || this.i.f.j() == null || (this.i.f.j().h() & 2) != 0) ? false : true;
    }

    public void b() {
        a(0.0f);
    }

    public void b(int i) {
        if (isAttachedToWindow()) {
            b(i, -1, -1);
            return;
        }
        if (this.aO == null) {
            this.aO = new f();
        }
        this.aO.a(i);
    }

    public void b(int i, int i2, int i3) {
        int iA;
        if (this.i != null && this.i.e != null && (iA = this.i.e.a(this.l, i, i2, i3)) != -1) {
            i = iA;
        }
        if (this.l == i) {
            return;
        }
        if (this.an == i) {
            a(0.0f);
            return;
        }
        if (this.ao == i) {
            a(1.0f);
            return;
        }
        this.ao = i;
        if (this.l != -1) {
            a(this.l, i);
            a(1.0f);
            this.o = 0.0f;
            c();
            return;
        }
        this.az = false;
        this.p = 1.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.au = getNanoTime();
        this.as = getNanoTime();
        this.av = false;
        this.j = null;
        this.at = this.i.g() / 1000.0f;
        this.an = -1;
        this.i.a(this.an, this.ao);
        this.i.d();
        int childCount = getChildCount();
        this.m.clear();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            this.m.put(childAt, new p(childAt));
        }
        this.q = true;
        this.W.a(this.ad, null, this.i.c(i));
        g();
        this.W.b();
        m();
        int width = getWidth();
        int height = getHeight();
        for (int i5 = 0; i5 < childCount; i5++) {
            p pVar = this.m.get(getChildAt(i5));
            this.i.a(pVar);
            pVar.a(width, height, this.at, getNanoTime());
        }
        float fI = this.i.i();
        if (fI != 0.0f) {
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            for (int i6 = 0; i6 < childCount; i6++) {
                p pVar2 = this.m.get(getChildAt(i6));
                float fD = pVar2.d() + pVar2.c();
                fMin = Math.min(fMin, fD);
                fMax = Math.max(fMax, fD);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                p pVar3 = this.m.get(getChildAt(i7));
                float fC = pVar3.c();
                float fD2 = pVar3.d();
                pVar3.s = 1.0f / (1.0f - fI);
                pVar3.r = fI - ((((fC + fD2) - fMin) * fI) / (fMax - fMin));
            }
        }
        this.n = 0.0f;
        this.o = 0.0f;
        this.q = true;
        invalidate();
    }

    @Override // androidx.core.n.v
    public void b(View view, View view2, int i, int i2) {
    }

    public void b(boolean z) {
        this.v = z ? 2 : 1;
        invalidate();
    }

    public boolean b(g gVar) {
        if (this.aG == null) {
            return false;
        }
        return this.aG.remove(gVar);
    }

    public void c() {
        a(1.0f);
    }

    @Override // androidx.d.e.d
    protected void c(int i) {
        this.af = null;
    }

    void c(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.b(z);
    }

    public androidx.d.e.g d(int i) {
        if (this.i == null) {
            return null;
        }
        return this.i.c(i);
    }

    void d() {
        if (this.i == null) {
            return;
        }
        if (this.i.b(this, this.l)) {
            requestLayout();
            return;
        }
        if (this.l != -1) {
            this.i.a(this, this.l);
        }
        if (this.i.c()) {
            this.i.l();
        }
    }

    @Override // androidx.d.e.d, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(false);
        super.dispatchDraw(canvas);
        if (this.i == null) {
            return;
        }
        if ((this.v & 1) == 1 && !isInEditMode()) {
            this.aH++;
            long nanoTime = getNanoTime();
            if (this.aI != -1) {
                long j = nanoTime - this.aI;
                if (j > 200000000) {
                    this.aJ = ((int) ((this.aH / (j * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.aH = 0;
                    this.aI = nanoTime;
                }
            } else {
                this.aI = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float progress = ((int) (getProgress() * 1000.0f)) / 10.0f;
            String str = this.aJ + " fps " + androidx.d.b.b.c.a(this, this.an) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(androidx.d.b.b.c.a(this, this.ao));
            sb.append(" (progress: ");
            sb.append(progress);
            sb.append(" ) state=");
            sb.append(this.l == -1 ? "undefined" : androidx.d.b.b.c.a(this, this.l));
            String string = sb.toString();
            paint.setColor(af.s);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.v > 1) {
            if (this.x == null) {
                this.x = new b();
            }
            this.x.a(canvas, this.m, this.i.g(), this.v);
        }
    }

    public u.a e(int i) {
        return this.i.b(i);
    }

    protected void e() {
        if ((this.aw != null || (this.aG != null && !this.aG.isEmpty())) && this.aK == -1) {
            this.aK = this.l;
            if ((!this.aa.isEmpty() ? this.aa.get(this.aa.size() - 1).intValue() : -1) != this.l && this.l != -1) {
                this.aa.add(Integer.valueOf(this.l));
            }
        }
        r();
    }

    String f(int i) {
        if (this.i == null) {
            return null;
        }
        return this.i.f(i);
    }

    @Deprecated
    public void f() {
        Log.e(g, "This method is deprecated. Please call rebuildScene() instead.");
        g();
    }

    public void g() {
        this.W.a();
        invalidate();
    }

    public int[] getConstraintSetIds() {
        if (this.i == null) {
            return null;
        }
        return this.i.b();
    }

    public int getCurrentState() {
        return this.l;
    }

    public ArrayList<u.a> getDefinedTransitions() {
        if (this.i == null) {
            return null;
        }
        return this.i.a();
    }

    public androidx.d.b.b.d getDesignTool() {
        if (this.aC == null) {
            this.aC = new androidx.d.b.b.d(this);
        }
        return this.aC;
    }

    public int getEndState() {
        return this.ao;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.o;
    }

    public int getStartState() {
        return this.an;
    }

    public float getTargetPosition() {
        return this.p;
    }

    public Bundle getTransitionState() {
        if (this.aO == null) {
            this.aO = new f();
        }
        this.aO.c();
        return this.aO.b();
    }

    public long getTransitionTimeMs() {
        if (this.i != null) {
            this.at = this.i.g() / 1000.0f;
        }
        return (long) (this.at * 1000.0f);
    }

    public float getVelocity() {
        return this.k;
    }

    public void h() {
        this.W.a(this.ad, this.i.c(this.an), this.i.c(this.ao));
        g();
    }

    public boolean i() {
        return this.ar;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        return getWindowToken() != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i != null && this.l != -1) {
            androidx.d.e.g gVarC = this.i.c(this.l);
            this.i.b(this);
            if (gVarC != null) {
                gVarC.c(this);
            }
            this.an = this.l;
        }
        d();
        if (this.aO != null) {
            this.aO.a();
            return;
        }
        if (this.i == null || this.i.f == null || this.i.f.b() != 4) {
            return;
        }
        c();
        setState(h.SETUP);
        setState(h.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        u.a aVar;
        y yVarJ;
        int iF;
        RectF rectFA;
        if (this.i != null && this.ar && (aVar = this.i.f) != null && aVar.l() && (yVarJ = aVar.j()) != null && ((motionEvent.getAction() != 0 || (rectFA = yVarJ.a(this, new RectF())) == null || rectFA.contains(motionEvent.getX(), motionEvent.getY())) && (iF = yVarJ.f()) != -1)) {
            if (this.aS == null || this.aS.getId() != iF) {
                this.aS = findViewById(iF);
            }
            if (this.aS != null) {
                this.aR.set(this.aS.getLeft(), this.aS.getTop(), this.aS.getRight(), this.aS.getBottom());
                if (this.aR.contains(motionEvent.getX(), motionEvent.getY()) && !a(0.0f, 0.0f, this.aS, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    @Override // androidx.d.e.d, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.aN = true;
        try {
            if (this.i == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.B != i5 || this.C != i6) {
                g();
                a(true);
            }
            this.B = i5;
            this.C = i6;
            this.z = i5;
            this.A = i6;
        } finally {
            this.aN = false;
        }
    }

    @Override // androidx.d.e.d, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.i == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z = false;
        boolean z2 = (this.ap == i && this.aq == i2) ? false : true;
        if (this.aQ) {
            this.aQ = false;
            d();
            r();
            z2 = true;
        }
        if (this.ae) {
            z2 = true;
        }
        this.ap = i;
        this.aq = i2;
        int iD = this.i.d();
        int iE = this.i.e();
        if ((z2 || this.W.c(iD, iE)) && this.an != -1) {
            super.onMeasure(i, i2);
            this.W.a(this.ad, this.i.c(iD), this.i.c(iE));
            this.W.a();
            this.W.b(iD, iE);
        } else {
            z = true;
        }
        if (this.N || z) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int I = this.ad.I() + getPaddingLeft() + getPaddingRight();
            int iL = this.ad.L() + paddingTop;
            if (this.S == Integer.MIN_VALUE || this.S == 0) {
                I = (int) (this.O + (this.U * (this.Q - this.O)));
                requestLayout();
            }
            if (this.T == Integer.MIN_VALUE || this.T == 0) {
                iL = (int) (this.P + (this.U * (this.R - this.P)));
                requestLayout();
            }
            setMeasuredDimension(I, iL);
        }
        o();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (this.i != null) {
            this.i.a(j());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i == null || !this.ar || !this.i.c()) {
            return super.onTouchEvent(motionEvent);
        }
        u.a aVar = this.i.f;
        if (aVar != null && !aVar.l()) {
            return super.onTouchEvent(motionEvent);
        }
        this.i.a(motionEvent, getCurrentState(), this);
        return true;
    }

    @Override // androidx.d.e.d, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof q) {
            q qVar = (q) view;
            if (this.aG == null) {
                this.aG = new ArrayList<>();
            }
            this.aG.add(qVar);
            if (qVar.a()) {
                if (this.aE == null) {
                    this.aE = new ArrayList<>();
                }
                this.aE.add(qVar);
            }
            if (qVar.b()) {
                if (this.aF == null) {
                    this.aF = new ArrayList<>();
                }
                this.aF.add(qVar);
            }
        }
    }

    @Override // androidx.d.e.d, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.aE != null) {
            this.aE.remove(view);
        }
        if (this.aF != null) {
            this.aF.remove(view);
        }
    }

    @Override // androidx.d.e.d, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.N || this.l != -1 || this.i == null || this.i.f == null || this.i.f.a() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i) {
        this.v = i;
        invalidate();
    }

    public void setInteractionEnabled(boolean z) {
        this.ar = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.i != null) {
            setState(h.MOVING);
            Interpolator interpolatorF = this.i.f();
            if (interpolatorF != null) {
                setProgress(interpolatorF.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        if (this.aF != null) {
            int size = this.aF.size();
            for (int i = 0; i < size; i++) {
                this.aF.get(i).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        if (this.aE != null) {
            int size = this.aE.size();
            for (int i = 0; i < size; i++) {
                this.aE.get(i).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            Log.w(g, "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.aO == null) {
                this.aO = new f();
            }
            this.aO.a(f2);
            return;
        }
        if (f2 <= 0.0f) {
            this.l = this.an;
            if (this.o == 0.0f) {
                setState(h.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            this.l = this.ao;
            if (this.o == 1.0f) {
                setState(h.FINISHED);
            }
        } else {
            this.l = -1;
            setState(h.MOVING);
        }
        if (this.i == null) {
            return;
        }
        this.av = true;
        this.p = f2;
        this.n = f2;
        this.au = -1L;
        this.as = -1L;
        this.j = null;
        this.q = true;
        invalidate();
    }

    public void setScene(u uVar) {
        this.i = uVar;
        this.i.a(j());
        g();
    }

    void setState(h hVar) {
        if (hVar == h.FINISHED && this.l == -1) {
        }
        h hVar2 = this.V;
        this.V = hVar;
        if (hVar2 == h.MOVING && hVar == h.MOVING) {
            q();
        }
        switch (hVar2) {
            case UNDEFINED:
            case SETUP:
                if (hVar == h.MOVING) {
                    q();
                }
                if (hVar == h.FINISHED) {
                    e();
                }
                break;
            case MOVING:
                if (hVar == h.FINISHED) {
                    e();
                }
                break;
        }
    }

    public void setTransition(int i) {
        if (this.i != null) {
            u.a aVarE = e(i);
            int i2 = this.l;
            this.an = aVarE.e();
            this.ao = aVarE.d();
            if (!isAttachedToWindow()) {
                if (this.aO == null) {
                    this.aO = new f();
                }
                this.aO.b(this.an);
                this.aO.a(this.ao);
                return;
            }
            float f2 = Float.NaN;
            if (this.l == this.an) {
                f2 = 0.0f;
            } else if (this.l == this.ao) {
                f2 = 1.0f;
            }
            this.i.c(aVarE);
            this.W.a(this.ad, this.i.c(this.an), this.i.c(this.ao));
            g();
            this.o = Float.isNaN(f2) ? 0.0f : f2;
            if (!Float.isNaN(f2)) {
                setProgress(f2);
                return;
            }
            Log.v(g, androidx.d.b.b.c.a() + " transitionToStart ");
            b();
        }
    }

    protected void setTransition(u.a aVar) {
        this.i.c(aVar);
        setState(h.SETUP);
        if (this.l == this.i.e()) {
            this.o = 1.0f;
            this.n = 1.0f;
            this.p = 1.0f;
        } else {
            this.o = 0.0f;
            this.n = 0.0f;
            this.p = 0.0f;
        }
        this.au = aVar.d(1) ? -1L : getNanoTime();
        int iD = this.i.d();
        int iE = this.i.e();
        if (iD == this.an && iE == this.ao) {
            return;
        }
        this.an = iD;
        this.ao = iE;
        this.i.a(this.an, this.ao);
        this.W.a(this.ad, this.i.c(this.an), this.i.c(this.ao));
        this.W.b(this.an, this.ao);
        this.W.a();
        g();
    }

    public void setTransitionDuration(int i) {
        if (this.i == null) {
            Log.e(g, "MotionScene not defined");
        } else {
            this.i.e(i);
        }
    }

    public void setTransitionListener(g gVar) {
        this.aw = gVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.aO == null) {
            this.aO = new f();
        }
        this.aO.a(bundle);
        if (isAttachedToWindow()) {
            this.aO.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.d.b.b.c.a(context, this.an) + "->" + androidx.d.b.b.c.a(context, this.ao) + " (pos:" + this.o + " Dpos/Dt:" + this.k;
    }
}
