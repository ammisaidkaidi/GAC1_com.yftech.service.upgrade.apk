package androidx.d.b.b;

import android.os.Build;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class o implements Comparable<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f618a = "MotionPaths";
    public static final boolean b = false;
    static final int f = 1;
    static final int g = 2;
    static String[] h = {"position", "x", "y", "width", "height", "pathRotate"};
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    int d;
    private androidx.d.b.a.c y;
    private float m = 1.0f;
    int c = 0;
    private boolean n = false;
    private float o = 0.0f;
    private float p = 0.0f;
    private float q = 0.0f;
    public float e = 0.0f;
    private float r = 1.0f;
    private float s = 1.0f;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;
    private int z = 0;
    private float F = Float.NaN;
    private float G = Float.NaN;
    LinkedHashMap<String, androidx.d.e.b> i = new LinkedHashMap<>();
    int j = 0;
    double[] k = new double[18];
    double[] l = new double[18];

    private boolean a(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            return Float.isNaN(f2) != Float.isNaN(f3);
        }
        return Math.abs(f2 - f3) > 1.0E-6f;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(o oVar) {
        return Float.compare(this.A, oVar.A);
    }

    int a(String str, double[] dArr, int i) {
        androidx.d.e.b bVar = this.i.get(str);
        if (bVar.b() == 1) {
            dArr[i] = bVar.c();
            return 1;
        }
        int iB = bVar.b();
        float[] fArr = new float[iB];
        bVar.a(fArr);
        int i2 = 0;
        while (i2 < iB) {
            dArr[i] = fArr[i2];
            i2++;
            i++;
        }
        return iB;
    }

    void a(float f2, float f3, float f4, float f5) {
        this.B = f2;
        this.C = f3;
        this.D = f4;
        this.E = f5;
    }

    public void a(View view) {
        this.d = view.getVisibility();
        this.m = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.n = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.o = view.getElevation();
        }
        this.p = view.getRotation();
        this.q = view.getRotationX();
        this.e = view.getRotationY();
        this.r = view.getScaleX();
        this.s = view.getScaleY();
        this.t = view.getPivotX();
        this.u = view.getPivotY();
        this.v = view.getTranslationX();
        this.w = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.x = view.getTranslationZ();
        }
    }

    void a(o oVar, HashSet<String> hashSet) {
        if (a(this.m, oVar.m)) {
            hashSet.add("alpha");
        }
        if (a(this.o, oVar.o)) {
            hashSet.add("elevation");
        }
        if (this.d != oVar.d && this.c == 0 && (this.d == 0 || oVar.d == 0)) {
            hashSet.add("alpha");
        }
        if (a(this.p, oVar.p)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.F) || !Float.isNaN(oVar.F)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.G) || !Float.isNaN(oVar.G)) {
            hashSet.add(androidx.core.app.p.al);
        }
        if (a(this.q, oVar.q)) {
            hashSet.add("rotationX");
        }
        if (a(this.e, oVar.e)) {
            hashSet.add("rotationY");
        }
        if (a(this.t, oVar.t)) {
            hashSet.add("transformPivotX");
        }
        if (a(this.u, oVar.u)) {
            hashSet.add("transformPivotY");
        }
        if (a(this.r, oVar.r)) {
            hashSet.add("scaleX");
        }
        if (a(this.s, oVar.s)) {
            hashSet.add("scaleY");
        }
        if (a(this.v, oVar.v)) {
            hashSet.add("translationX");
        }
        if (a(this.w, oVar.w)) {
            hashSet.add("translationY");
        }
        if (a(this.x, oVar.x)) {
            hashSet.add("translationZ");
        }
    }

    void a(o oVar, boolean[] zArr, String[] strArr) {
        zArr[0] = zArr[0] | a(this.A, oVar.A);
        zArr[1] = zArr[1] | a(this.B, oVar.B);
        zArr[2] = zArr[2] | a(this.C, oVar.C);
        zArr[3] = zArr[3] | a(this.D, oVar.D);
        zArr[4] = a(this.E, oVar.E) | zArr[4];
    }

    public void a(androidx.d.c.b.e eVar, androidx.d.e.g gVar, int i) {
        a(eVar.G(), eVar.H(), eVar.I(), eVar.L());
        a(gVar.a(i));
    }

    public void a(androidx.d.e.g.a aVar) {
        this.c = aVar.b.c;
        this.d = aVar.b.b;
        this.m = (aVar.b.b == 0 || this.c != 0) ? aVar.b.d : 0.0f;
        this.n = aVar.e.l;
        this.o = aVar.e.m;
        this.p = aVar.e.b;
        this.q = aVar.e.c;
        this.e = aVar.e.d;
        this.r = aVar.e.e;
        this.s = aVar.e.f;
        this.t = aVar.e.g;
        this.u = aVar.e.h;
        this.v = aVar.e.i;
        this.w = aVar.e.j;
        this.x = aVar.e.k;
        this.y = androidx.d.b.a.c.a(aVar.c.c);
        this.F = aVar.c.g;
        this.z = aVar.c.e;
        this.G = aVar.b.e;
        for (String str : aVar.f.keySet()) {
            androidx.d.e.b bVar = aVar.f.get(str);
            if (bVar.a() != androidx.d.e.b.a.STRING_TYPE) {
                this.i.put(str, bVar);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(HashMap<String, w> map, int i) {
        for (String str : map.keySet()) {
            w wVar = map.get(str);
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        b2 = 3;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        b2 = 4;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        b2 = 11;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        b2 = 12;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        b2 = 13;
                    }
                    break;
                case -1001078227:
                    if (str.equals(androidx.core.app.p.al)) {
                        b2 = 8;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        b2 = 9;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        b2 = 10;
                    }
                    break;
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        b2 = 5;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        b2 = 6;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        b2 = 2;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        b2 = 1;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        b2 = 7;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        b2 = 0;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    wVar.a(i, Float.isNaN(this.m) ? 1.0f : this.m);
                    break;
                case 1:
                    wVar.a(i, Float.isNaN(this.o) ? 0.0f : this.o);
                    break;
                case 2:
                    wVar.a(i, Float.isNaN(this.p) ? 0.0f : this.p);
                    break;
                case 3:
                    wVar.a(i, Float.isNaN(this.q) ? 0.0f : this.q);
                    break;
                case 4:
                    wVar.a(i, Float.isNaN(this.e) ? 0.0f : this.e);
                    break;
                case 5:
                    wVar.a(i, Float.isNaN(this.t) ? 0.0f : this.t);
                    break;
                case 6:
                    wVar.a(i, Float.isNaN(this.u) ? 0.0f : this.u);
                    break;
                case 7:
                    wVar.a(i, Float.isNaN(this.F) ? 0.0f : this.F);
                    break;
                case 8:
                    wVar.a(i, Float.isNaN(this.G) ? 0.0f : this.G);
                    break;
                case 9:
                    wVar.a(i, Float.isNaN(this.r) ? 1.0f : this.r);
                    break;
                case 10:
                    wVar.a(i, Float.isNaN(this.s) ? 1.0f : this.s);
                    break;
                case 11:
                    wVar.a(i, Float.isNaN(this.v) ? 0.0f : this.v);
                    break;
                case 12:
                    wVar.a(i, Float.isNaN(this.w) ? 0.0f : this.w);
                    break;
                case 13:
                    wVar.a(i, Float.isNaN(this.x) ? 0.0f : this.x);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.i.containsKey(str2)) {
                            androidx.d.e.b bVar = this.i.get(str2);
                            if (wVar instanceof w.b) {
                                ((w.b) wVar).a(i, bVar);
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i + ", value" + bVar.c() + wVar);
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                    }
                    break;
            }
        }
    }

    void a(double[] dArr, int[] iArr) {
        float[] fArr = {this.A, this.B, this.C, this.D, this.E, this.m, this.o, this.p, this.q, this.e, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.F};
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < fArr.length) {
                dArr[i] = fArr[iArr[i2]];
                i++;
            }
        }
    }

    boolean a(String str) {
        return this.i.containsKey(str);
    }

    int b(String str) {
        return this.i.get(str).b();
    }

    public void b(View view) {
        a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        a(view);
    }
}
