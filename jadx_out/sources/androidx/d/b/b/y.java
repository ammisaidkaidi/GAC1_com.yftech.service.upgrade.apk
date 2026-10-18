package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
class y {
    private static final int A = 5;
    private static final int B = 0;
    private static final int C = 1;
    private static final int D = 2;
    private static final int E = 3;
    private static final int F = 4;
    private static final int G = 5;
    private static final int H = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f637a = 1;
    static final int b = 2;
    private static final String c = "TouchResponse";
    private static final boolean d = false;
    private static final float[][] t = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] u = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private static final int v = 0;
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 3;
    private static final int z = 4;
    private float q;
    private float r;
    private final s s;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = -1;
    private int i = -1;
    private int j = -1;
    private float k = 0.5f;
    private float l = 0.5f;
    private float m = 0.0f;
    private float n = 1.0f;
    private boolean o = false;
    private float[] p = new float[2];
    private float I = 4.0f;
    private float J = 1.2f;
    private boolean K = true;
    private float L = 1.0f;
    private int M = 0;
    private float N = 10.0f;

    y(Context context, s sVar, XmlPullParser xmlPullParser) {
        this.s = sVar;
        a(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.OnSwipe);
        a(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == androidx.d.e.m.C0052m.OnSwipe_touchAnchorId) {
                this.h = typedArray.getResourceId(index, this.h);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_touchAnchorSide) {
                this.e = typedArray.getInt(index, this.e);
                this.l = t[this.e][0];
                this.k = t[this.e][1];
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_dragDirection) {
                this.f = typedArray.getInt(index, this.f);
                this.m = u[this.f][0];
                this.n = u[this.f][1];
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_maxVelocity) {
                this.I = typedArray.getFloat(index, this.I);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_maxAcceleration) {
                this.J = typedArray.getFloat(index, this.J);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_moveWhenScrollAtTop) {
                this.K = typedArray.getBoolean(index, this.K);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_dragScale) {
                this.L = typedArray.getFloat(index, this.L);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_dragThreshold) {
                this.N = typedArray.getFloat(index, this.N);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_touchRegionId) {
                this.i = typedArray.getResourceId(index, this.i);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_onTouchUp) {
                this.g = typedArray.getInt(index, this.g);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_nestedScrollFlags) {
                this.M = typedArray.getInteger(index, 0);
            } else if (index == androidx.d.e.m.C0052m.OnSwipe_limitBoundsTo) {
                this.j = typedArray.getResourceId(index, 0);
            }
        }
    }

    RectF a(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        if (this.i == -1 || (viewFindViewById = viewGroup.findViewById(this.i)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    void a() {
        View viewFindViewById;
        if (this.h != -1) {
            viewFindViewById = this.s.findViewById(this.h);
            if (viewFindViewById == null) {
                Log.e(c, "cannot find TouchAnchorId @id/" + c.a(this.s.getContext(), this.h));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.d.b.b.y.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() { // from class: androidx.d.b.b.y.2
                @Override // androidx.core.widget.NestedScrollView.b
                public void a(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                }
            });
        }
    }

    public void a(float f) {
        this.I = f;
    }

    void a(float f, float f2) {
        this.q = f;
        this.r = f2;
        this.o = false;
    }

    public void a(int i) {
        this.h = i;
    }

    void a(MotionEvent motionEvent, s.d dVar, int i, u uVar) {
        dVar.a(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.q = motionEvent.getRawX();
                this.r = motionEvent.getRawY();
                this.o = false;
                break;
            case 1:
                this.o = false;
                dVar.a(1000);
                float fC = dVar.c();
                float fD = dVar.d();
                float progress = this.s.getProgress();
                if (this.h != -1) {
                    this.s.a(this.h, progress, this.l, this.k, this.p);
                } else {
                    float fMin = Math.min(this.s.getWidth(), this.s.getHeight());
                    this.p[1] = this.n * fMin;
                    this.p[0] = fMin * this.m;
                }
                float f = this.m;
                float f2 = this.p[0];
                float f3 = this.n;
                float f4 = this.p[1];
                float f5 = this.m != 0.0f ? fC / this.p[0] : fD / this.p[1];
                float f6 = !Float.isNaN(f5) ? (f5 / 3.0f) + progress : progress;
                if (f6 != 0.0f && f6 != 1.0f && this.g != 3) {
                    this.s.a(this.g, ((double) f6) < 0.5d ? 0.0f : 1.0f, f5);
                    if (0.0f >= progress || 1.0f <= progress) {
                        this.s.setState(s.h.FINISHED);
                    }
                } else if (0.0f >= f6 || 1.0f <= f6) {
                    this.s.setState(s.h.FINISHED);
                }
                break;
            case 2:
                float rawY = motionEvent.getRawY() - this.r;
                float rawX = motionEvent.getRawX() - this.q;
                if (Math.abs((this.m * rawX) + (this.n * rawY)) > this.N || this.o) {
                    float progress2 = this.s.getProgress();
                    if (!this.o) {
                        this.o = true;
                        this.s.setProgress(progress2);
                    }
                    if (this.h != -1) {
                        this.s.a(this.h, progress2, this.l, this.k, this.p);
                    } else {
                        float fMin2 = Math.min(this.s.getWidth(), this.s.getHeight());
                        this.p[1] = this.n * fMin2;
                        this.p[0] = fMin2 * this.m;
                    }
                    if (Math.abs(((this.m * this.p[0]) + (this.n * this.p[1])) * this.L) < 0.01d) {
                        this.p[0] = 0.01f;
                        this.p[1] = 0.01f;
                    }
                    float fMax = Math.max(Math.min(progress2 + (this.m != 0.0f ? rawX / this.p[0] : rawY / this.p[1]), 1.0f), 0.0f);
                    if (fMax != this.s.getProgress()) {
                        this.s.setProgress(fMax);
                        dVar.a(1000);
                        this.s.k = this.m != 0.0f ? dVar.c() / this.p[0] : dVar.d() / this.p[1];
                    } else {
                        this.s.k = 0.0f;
                    }
                    this.q = motionEvent.getRawX();
                    this.r = motionEvent.getRawY();
                }
                break;
        }
    }

    public void a(boolean z2) {
        if (z2) {
            u[4] = u[3];
            u[5] = u[2];
            t[5] = t[2];
            t[6] = t[1];
        } else {
            u[4] = u[2];
            u[5] = u[3];
            t[5] = t[1];
            t[6] = t[2];
        }
        this.l = t[this.e][0];
        this.k = t[this.e][1];
        this.m = u[this.f][0];
        this.n = u[this.f][1];
    }

    public int b() {
        return this.h;
    }

    RectF b(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        if (this.j == -1 || (viewFindViewById = viewGroup.findViewById(this.j)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public void b(float f) {
        this.J = f;
    }

    void b(float f, float f2) {
        this.q = f;
        this.r = f2;
    }

    float c() {
        return this.J;
    }

    float c(float f, float f2) {
        this.s.a(this.h, this.s.getProgress(), this.l, this.k, this.p);
        if (this.m != 0.0f) {
            if (this.p[0] == 0.0f) {
                this.p[0] = 1.0E-7f;
            }
            return (f * this.m) / this.p[0];
        }
        if (this.p[1] == 0.0f) {
            this.p[1] = 1.0E-7f;
        }
        return (f2 * this.n) / this.p[1];
    }

    public float d() {
        return this.I;
    }

    void d(float f, float f2) {
        this.o = false;
        float progress = this.s.getProgress();
        this.s.a(this.h, progress, this.l, this.k, this.p);
        float f3 = this.m;
        float f4 = this.p[0];
        float f5 = this.n;
        float f6 = this.p[1];
        float f7 = this.m != 0.0f ? (f * this.m) / this.p[0] : (f2 * this.n) / this.p[1];
        if (!Float.isNaN(f7)) {
            progress += f7 / 3.0f;
        }
        if (progress != 0.0f) {
            if ((this.g != 3) && (progress != 1.0f)) {
                this.s.a(this.g, ((double) progress) < 0.5d ? 0.0f : 1.0f, f7);
            }
        }
    }

    void e(float f, float f2) {
        float f3 = this.m;
        float f4 = this.n;
        float progress = this.s.getProgress();
        if (!this.o) {
            this.o = true;
            this.s.setProgress(progress);
        }
        this.s.a(this.h, progress, this.l, this.k, this.p);
        if (Math.abs((this.m * this.p[0]) + (this.n * this.p[1])) < 0.01d) {
            this.p[0] = 0.01f;
            this.p[1] = 0.01f;
        }
        float fMax = Math.max(Math.min(progress + (this.m != 0.0f ? (f * this.m) / this.p[0] : (f2 * this.n) / this.p[1]), 1.0f), 0.0f);
        if (fMax != this.s.getProgress()) {
            this.s.setProgress(fMax);
        }
    }

    boolean e() {
        return this.K;
    }

    int f() {
        return this.i;
    }

    public void f(float f, float f2) {
        this.l = f;
        this.k = f2;
    }

    float g(float f, float f2) {
        return (f * this.m) + (f2 * this.n);
    }

    int g() {
        return this.j;
    }

    public int h() {
        return this.M;
    }

    public String toString() {
        return this.m + " , " + this.n;
    }
}
