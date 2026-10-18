package androidx.d.b.b;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f619a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    private static final String u = "MotionController";
    private static final boolean v = false;
    private static final boolean w = false;
    private androidx.d.b.a.b[] C;
    private androidx.d.b.a.b D;
    private int[] E;
    private double[] F;
    private double[] G;
    private String[] H;
    private int[] I;
    private HashMap<String, x> O;
    private HashMap<String, w> P;
    private HashMap<String, i> Q;
    private n[] R;
    View n;
    int o;
    String p;
    String[] t;
    private int x = -1;
    private t y = new t();
    private t z = new t();
    private o A = new o();
    private o B = new o();
    float q = Float.NaN;
    float r = 0.0f;
    float s = 1.0f;
    private int J = 4;
    private float[] K = new float[this.J];
    private ArrayList<t> L = new ArrayList<>();
    private float[] M = new float[1];
    private ArrayList<e> N = new ArrayList<>();
    private int S = e.f606a;

    p(View view) {
        a(view);
    }

    private float a(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else if (this.s != 1.0d) {
            if (f2 < this.r) {
                f2 = 0.0f;
            }
            if (f2 > this.r && f2 < 1.0d) {
                f2 = (f2 - this.r) * this.s;
            }
        }
        androidx.d.b.a.c cVar = this.y.n;
        float f4 = Float.NaN;
        for (t tVar : this.L) {
            if (tVar.n != null) {
                if (tVar.p < f2) {
                    cVar = tVar.n;
                    f3 = tVar.p;
                } else if (Float.isNaN(f4)) {
                    f4 = tVar.p;
                }
            }
        }
        if (cVar == null) {
            return f2;
        }
        float f5 = (Float.isNaN(f4) ? 1.0f : f4) - f3;
        double d2 = (f2 - f3) / f5;
        float fA = f3 + (((float) cVar.a(d2)) * f5);
        if (fArr != null) {
            fArr[0] = (float) cVar.b(d2);
        }
        return fA;
    }

    private void a(t tVar) {
        int iBinarySearch = Collections.binarySearch(this.L, tVar);
        if (iBinarySearch == 0) {
            Log.e(u, " KeyPath positon \"" + tVar.q + "\" outside of range");
        }
        this.L.add((-iBinarySearch) - 1, tVar);
    }

    private void b(t tVar) {
        tVar.a((int) this.n.getX(), (int) this.n.getY(), this.n.getWidth(), this.n.getHeight());
    }

    private float g() {
        float[] fArr = new float[2];
        float f2 = 1.0f / 99;
        double d2 = 0.0d;
        double d3 = 0.0d;
        float fHypot = 0.0f;
        for (int i2 = 0; i2 < 100; i2++) {
            float f3 = i2 * f2;
            double dA = f3;
            androidx.d.b.a.c cVar = this.y.n;
            float f4 = Float.NaN;
            float f5 = 0.0f;
            for (t tVar : this.L) {
                if (tVar.n != null) {
                    if (tVar.p < f3) {
                        androidx.d.b.a.c cVar2 = tVar.n;
                        f5 = tVar.p;
                        cVar = cVar2;
                    } else if (Float.isNaN(f4)) {
                        f4 = tVar.p;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                float f6 = f4 - f5;
                dA = (((float) cVar.a((f3 - f5) / f6)) * f6) + f5;
            }
            this.C[0].a(dA, this.F);
            this.y.a(this.E, this.F, fArr, 0);
            if (i2 > 0) {
                fHypot = (float) (((double) fHypot) + Math.hypot(d2 - ((double) fArr[1]), d3 - ((double) fArr[0])));
            }
            d3 = fArr[0];
            d2 = fArr[1];
        }
        return fHypot;
    }

    float a() {
        return this.y.r;
    }

    float a(int i2, float f2, float f3) {
        float f4 = this.z.r - this.y.r;
        float f5 = this.z.s - this.y.s;
        float f6 = this.y.r + (this.y.t / 2.0f);
        float f7 = this.y.s + (this.y.u / 2.0f);
        float fHypot = (float) Math.hypot(f4, f5);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f8 = f2 - f6;
        float f9 = f3 - f7;
        if (((float) Math.hypot(f8, f9)) == 0.0f) {
            return 0.0f;
        }
        float f10 = (f8 * f4) + (f9 * f5);
        switch (i2) {
            case 0:
                return f10 / fHypot;
            case 1:
                return (float) Math.sqrt((fHypot * fHypot) - (f10 * f10));
            case 2:
                return f8 / f4;
            case 3:
                return f9 / f4;
            case 4:
                return f8 / f5;
            case 5:
                return f9 / f5;
            default:
                return 0.0f;
        }
    }

    public int a(int i2, int[] iArr) {
        float[] fArr = new float[2];
        int i3 = 0;
        int i4 = 0;
        for (e eVar : this.N) {
            if (eVar.e == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i5 = i4 + 1;
                iArr[i5] = eVar.e;
                int i6 = i5 + 1;
                iArr[i6] = eVar.b;
                this.C[0].a(eVar.b / 100.0f, this.F);
                this.y.a(this.E, this.F, fArr, 0);
                int i7 = i6 + 1;
                iArr[i7] = Float.floatToIntBits(fArr[0]);
                int i8 = i7 + 1;
                iArr[i8] = Float.floatToIntBits(fArr[1]);
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    int i9 = i8 + 1;
                    iArr[i9] = kVar.L;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(kVar.E);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(kVar.F);
                }
                int i11 = i8 + 1;
                iArr[i4] = i11 - i4;
                i3++;
                i4 = i11;
            }
        }
        return i3;
    }

    int a(String str, float[] fArr, int i2) {
        w wVar = this.P.get(str);
        if (wVar == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = wVar.a(i3 / (fArr.length - 1));
        }
        return fArr.length;
    }

    int a(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrA = this.C[0].a();
        if (iArr != null) {
            Iterator<t> it = this.L.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().z;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : dArrA) {
            this.C[0].a(d2, this.F);
            this.y.a(this.E, this.F, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public int a(int[] iArr, float[] fArr) {
        int i2 = 0;
        int i3 = 0;
        for (e eVar : this.N) {
            iArr[i2] = eVar.b + (eVar.e * 1000);
            this.C[0].a(eVar.b / 100.0f, this.F);
            this.y.a(this.E, this.F, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    l a(int i2, int i3, float f2, float f3) {
        RectF rectF = new RectF();
        rectF.left = this.y.r;
        rectF.top = this.y.s;
        rectF.right = rectF.left + this.y.t;
        rectF.bottom = rectF.top + this.y.u;
        RectF rectF2 = new RectF();
        rectF2.left = this.z.r;
        rectF2.top = this.z.s;
        rectF2.right = rectF2.left + this.z.t;
        rectF2.bottom = rectF2.top + this.z.u;
        for (e eVar : this.N) {
            if (eVar instanceof l) {
                l lVar = (l) eVar;
                if (lVar.a(i2, i3, rectF, rectF2, f2, f3)) {
                    return lVar;
                }
            }
        }
        return null;
    }

    t a(int i2) {
        return this.L.get(i2);
    }

    void a(float f2, float f3, float f4, float[] fArr) {
        float fA = a(f2, this.M);
        if (this.C == null) {
            float f5 = this.z.r - this.y.r;
            float f6 = this.z.s - this.y.s;
            float f7 = (this.z.t - this.y.t) + f5;
            float f8 = (this.z.u - this.y.u) + f6;
            fArr[0] = (f5 * (1.0f - f3)) + (f7 * f3);
            fArr[1] = (f6 * (1.0f - f4)) + (f8 * f4);
            return;
        }
        double d2 = fA;
        this.C[0].b(d2, this.G);
        this.C[0].a(d2, this.F);
        float f9 = this.M[0];
        for (int i2 = 0; i2 < this.G.length; i2++) {
            double[] dArr = this.G;
            dArr[i2] = dArr[i2] * ((double) f9);
        }
        if (this.D == null) {
            this.y.a(f3, f4, fArr, this.E, this.G, this.F);
        } else if (this.F.length > 0) {
            this.D.a(d2, this.F);
            this.D.b(d2, this.G);
            this.y.a(f3, f4, fArr, this.E, this.G, this.F);
        }
    }

    void a(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float fA = a(f2, this.M);
        w wVar = this.P == null ? null : this.P.get("translationX");
        w wVar2 = this.P == null ? null : this.P.get("translationY");
        w wVar3 = this.P == null ? null : this.P.get("rotation");
        w wVar4 = this.P == null ? null : this.P.get("scaleX");
        w wVar5 = this.P == null ? null : this.P.get("scaleY");
        i iVar = this.Q == null ? null : this.Q.get("translationX");
        i iVar2 = this.Q == null ? null : this.Q.get("translationY");
        i iVar3 = this.Q == null ? null : this.Q.get("rotation");
        i iVar4 = this.Q == null ? null : this.Q.get("scaleX");
        i iVar5 = this.Q != null ? this.Q.get("scaleY") : null;
        androidx.d.b.a.i iVar6 = new androidx.d.b.a.i();
        iVar6.a();
        iVar6.a(wVar3, fA);
        iVar6.a(wVar, wVar2, fA);
        iVar6.b(wVar4, wVar5, fA);
        iVar6.a(iVar3, fA);
        iVar6.a(iVar, iVar2, fA);
        iVar6.b(iVar4, iVar5, fA);
        i iVar7 = iVar5;
        if (this.D != null) {
            if (this.F.length > 0) {
                double d2 = fA;
                this.D.a(d2, this.F);
                this.D.b(d2, this.G);
                this.y.a(f3, f4, fArr, this.E, this.G, this.F);
            }
            iVar6.a(f3, f4, i2, i3, fArr);
            return;
        }
        if (this.C != null) {
            double dA = a(fA, this.M);
            this.C[0].b(dA, this.G);
            this.C[0].a(dA, this.F);
            float f5 = this.M[0];
            for (int i4 = 0; i4 < this.G.length; i4++) {
                double[] dArr = this.G;
                dArr[i4] = dArr[i4] * ((double) f5);
            }
            this.y.a(f3, f4, fArr, this.E, this.G, this.F);
            iVar6.a(f3, f4, i2, i3, fArr);
            return;
        }
        i iVar8 = iVar4;
        float f6 = this.z.r - this.y.r;
        i iVar9 = iVar;
        float f7 = this.z.s - this.y.s;
        i iVar10 = iVar2;
        float f8 = (this.z.t - this.y.t) + f6;
        float f9 = (this.z.u - this.y.u) + f7;
        fArr[0] = (f6 * (1.0f - f3)) + (f8 * f3);
        fArr[1] = (f7 * (1.0f - f4)) + (f9 * f4);
        iVar6.a();
        iVar6.a(wVar3, fA);
        iVar6.a(wVar, wVar2, fA);
        iVar6.b(wVar4, wVar5, fA);
        iVar6.a(iVar3, fA);
        iVar6.a(iVar9, iVar10, fA);
        iVar6.b(iVar8, iVar7, fA);
        iVar6.a(f3, f4, i2, i3, fArr);
    }

    void a(float f2, float[] fArr, int i2) {
        this.C[0].a(a(f2, (float[]) null), this.F);
        this.y.c(this.E, this.F, fArr, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    public void a(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        x xVarA;
        androidx.d.e.b bVar;
        w wVarB;
        androidx.d.e.b bVar2;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (this.S != e.f606a) {
            this.y.x = this.S;
        }
        this.A.a(this.B, hashSet2);
        double[][] dArr = null;
        if (this.N != null) {
            arrayList = null;
            for (e eVar : this.N) {
                if (eVar instanceof k) {
                    k kVar = (k) eVar;
                    a(new t(i2, i3, kVar, this.y, this.z));
                    if (kVar.O != e.f606a) {
                        this.x = kVar.O;
                    }
                } else if (eVar instanceof h) {
                    eVar.a(hashSet3);
                } else if (eVar instanceof m) {
                    eVar.a(hashSet);
                } else if (eVar instanceof n) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((n) eVar);
                } else {
                    eVar.b(map);
                    eVar.a(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.R = (n[]) arrayList.toArray(new n[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.P = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    for (e eVar2 : this.N) {
                        if (eVar2.f != null && (bVar2 = eVar2.f.get(str2)) != null) {
                            sparseArray.append(eVar2.b, bVar2);
                        }
                    }
                    wVarB = w.a(str, (SparseArray<androidx.d.e.b>) sparseArray);
                } else {
                    wVarB = w.b(str);
                }
                if (wVarB != null) {
                    wVarB.a(str);
                    this.P.put(str, wVarB);
                }
            }
            if (this.N != null) {
                for (e eVar3 : this.N) {
                    if (eVar3 instanceof f) {
                        eVar3.a(this.P);
                    }
                }
            }
            this.A.a(this.P, 0);
            this.B.a(this.P, 100);
            for (String str3 : this.P.keySet()) {
                this.P.get(str3).a(map.containsKey(str3) ? map.get(str3).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.O == null) {
                this.O = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.O.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        for (e eVar4 : this.N) {
                            if (eVar4.f != null && (bVar = eVar4.f.get(str5)) != null) {
                                sparseArray2.append(eVar4.b, bVar);
                            }
                        }
                        xVarA = x.a(str4, (SparseArray<androidx.d.e.b>) sparseArray2);
                    } else {
                        xVarA = x.a(str4, j2);
                    }
                    if (xVarA != null) {
                        xVarA.a(str4);
                        this.O.put(str4, xVarA);
                    }
                }
            }
            if (this.N != null) {
                for (e eVar5 : this.N) {
                    if (eVar5 instanceof m) {
                        ((m) eVar5).c(this.O);
                    }
                }
            }
            for (String str6 : this.O.keySet()) {
                this.O.get(str6).a(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        t[] tVarArr = new t[this.L.size() + 2];
        tVarArr[0] = this.y;
        tVarArr[tVarArr.length - 1] = this.z;
        if (this.L.size() > 0 && this.x == -1) {
            this.x = 0;
        }
        Iterator<t> it = this.L.iterator();
        int i4 = 1;
        while (it.hasNext()) {
            tVarArr[i4] = it.next();
            i4++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.z.y.keySet()) {
            if (this.y.y.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        this.H = (String[]) hashSet4.toArray(new String[0]);
        this.I = new int[this.H.length];
        for (int i5 = 0; i5 < this.H.length; i5++) {
            String str8 = this.H[i5];
            this.I[i5] = 0;
            for (int i6 = 0; i6 < tVarArr.length; i6++) {
                if (tVarArr[i6].y.containsKey(str8)) {
                    int[] iArr = this.I;
                    iArr[i5] = iArr[i5] + tVarArr[i6].y.get(str8).b();
                    break;
                }
            }
        }
        boolean z = tVarArr[0].x != e.f606a;
        boolean[] zArr = new boolean[18 + this.H.length];
        for (int i7 = 1; i7 < tVarArr.length; i7++) {
            tVarArr[i7].a(tVarArr[i7 - 1], zArr, this.H, z);
        }
        int i8 = 0;
        for (int i9 = 1; i9 < zArr.length; i9++) {
            if (zArr[i9]) {
                i8++;
            }
        }
        this.E = new int[i8];
        this.F = new double[this.E.length];
        this.G = new double[this.E.length];
        int i10 = 0;
        for (int i11 = 1; i11 < zArr.length; i11++) {
            if (zArr[i11]) {
                this.E[i10] = i11;
                i10++;
            }
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, tVarArr.length, this.E.length);
        double[] dArr3 = new double[tVarArr.length];
        for (int i12 = 0; i12 < tVarArr.length; i12++) {
            tVarArr[i12].a(dArr2[i12], this.E);
            dArr3[i12] = tVarArr[i12].p;
        }
        for (int i13 = 0; i13 < this.E.length; i13++) {
            if (this.E[i13] < t.m.length) {
                String str9 = t.m[this.E[i13]] + " [";
                for (int i14 = 0; i14 < tVarArr.length; i14++) {
                    str9 = str9 + dArr2[i14][i13];
                }
            }
        }
        this.C = new androidx.d.b.a.b[this.H.length + 1];
        int i15 = 0;
        while (i15 < this.H.length) {
            String str10 = this.H[i15];
            int i16 = 0;
            double[] dArr4 = dArr;
            double[][] dArr5 = dArr;
            int i17 = 0;
            while (i17 < tVarArr.length) {
                if (tVarArr[i17].a(str10)) {
                    if (dArr5 == null) {
                        double[] dArr6 = new double[tVarArr.length];
                        dArr5 = (double[][]) Array.newInstance((Class<?>) double.class, tVarArr.length, tVarArr[i17].b(str10));
                        dArr4 = dArr6;
                    }
                    dArr4[i16] = tVarArr[i17].p;
                    tVarArr[i17].a(str10, dArr5[i16], 0);
                    i16++;
                } else {
                    dArr4 = dArr4;
                }
                i17++;
                dArr3 = dArr3;
                dArr4 = dArr4;
            }
            i15++;
            this.C[i15] = androidx.d.b.a.b.a(this.x, Arrays.copyOf(dArr4, i16), (double[][]) Arrays.copyOf(dArr5, i16));
            dArr3 = dArr3;
            dArr = null;
        }
        this.C[0] = androidx.d.b.a.b.a(this.x, dArr3, dArr2);
        if (tVarArr[0].x != e.f606a) {
            int length = tVarArr.length;
            int[] iArr2 = new int[length];
            double[] dArr7 = new double[length];
            double[][] dArr8 = (double[][]) Array.newInstance((Class<?>) double.class, length, 2);
            for (int i18 = 0; i18 < length; i18++) {
                iArr2[i18] = tVarArr[i18].x;
                dArr7[i18] = tVarArr[i18].p;
                dArr8[i18][0] = tVarArr[i18].r;
                dArr8[i18][1] = tVarArr[i18].s;
            }
            this.D = androidx.d.b.a.b.a(iArr2, dArr7, dArr8);
        }
        float fG = Float.NaN;
        this.Q = new HashMap<>();
        if (this.N != null) {
            for (String str11 : hashSet3) {
                i iVarB = i.b(str11);
                if (iVarB != null) {
                    if (iVarB.a() && Float.isNaN(fG)) {
                        fG = g();
                    }
                    iVarB.a(str11);
                    this.Q.put(str11, iVarB);
                }
            }
            for (e eVar6 : this.N) {
                if (eVar6 instanceof h) {
                    ((h) eVar6).c(this.Q);
                }
            }
            Iterator<i> it2 = this.Q.values().iterator();
            while (it2.hasNext()) {
                it2.next().c(fG);
            }
        }
    }

    public void a(View view) {
        this.n = view;
        this.o = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof androidx.d.e.d.a) {
            this.p = ((androidx.d.e.d.a) layoutParams).d();
        }
    }

    void a(View view, l lVar, float f2, float f3, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        rectF.left = this.y.r;
        rectF.top = this.y.s;
        rectF.right = rectF.left + this.y.t;
        rectF.bottom = rectF.top + this.y.u;
        RectF rectF2 = new RectF();
        rectF2.left = this.z.r;
        rectF2.top = this.z.s;
        rectF2.right = rectF2.left + this.z.t;
        rectF2.bottom = rectF2.top + this.z.u;
        lVar.a(view, rectF, rectF2, f2, f3, strArr, fArr);
    }

    void a(e eVar) {
        this.N.add(eVar);
    }

    void a(androidx.d.c.b.e eVar, androidx.d.e.g gVar) {
        this.y.p = 0.0f;
        this.y.q = 0.0f;
        b(this.y);
        this.y.a(eVar.G(), eVar.H(), eVar.I(), eVar.L());
        androidx.d.e.g.a aVarA = gVar.a(this.o);
        this.y.a(aVarA);
        this.q = aVarA.c.f;
        this.A.a(eVar, gVar, this.o);
    }

    void a(ArrayList<e> arrayList) {
        this.N.addAll(arrayList);
    }

    void a(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / (i3 - 1);
        w wVar = this.P == null ? null : this.P.get("translationX");
        w wVar2 = this.P == null ? null : this.P.get("translationY");
        i iVar = this.Q == null ? null : this.Q.get("translationX");
        i iVar2 = this.Q != null ? this.Q.get("translationY") : null;
        int i4 = 0;
        while (i4 < i3) {
            float f4 = i4 * f3;
            float f5 = 0.0f;
            if (this.s != f2) {
                if (f4 < this.r) {
                    f4 = 0.0f;
                }
                if (f4 > this.r && f4 < 1.0d) {
                    f4 = (f4 - this.r) * this.s;
                }
            }
            double dA = f4;
            androidx.d.b.a.c cVar = this.y.n;
            float f6 = Float.NaN;
            for (t tVar : this.L) {
                if (tVar.n != null) {
                    if (tVar.p < f4) {
                        cVar = tVar.n;
                        f5 = tVar.p;
                    } else if (Float.isNaN(f6)) {
                        f6 = tVar.p;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                float f7 = f6 - f5;
                dA = (((float) cVar.a((f4 - f5) / f7)) * f7) + f5;
            }
            this.C[0].a(dA, this.F);
            if (this.D != null && this.F.length > 0) {
                this.D.a(dA, this.F);
            }
            int i5 = i4 * 2;
            this.y.a(this.E, this.F, fArr, i5);
            if (iVar != null) {
                fArr[i5] = fArr[i5] + iVar.a(f4);
            } else if (wVar != null) {
                fArr[i5] = fArr[i5] + wVar.a(f4);
            }
            if (iVar2 != null) {
                int i6 = i5 + 1;
                fArr[i6] = fArr[i6] + iVar2.a(f4);
            } else if (wVar2 != null) {
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] + wVar2.a(f4);
            }
            i4++;
            i3 = i2;
            f2 = 1.0f;
        }
    }

    boolean a(View view, float f2, long j2, g gVar) {
        x.d dVar;
        boolean zA;
        float fA = a(f2, (float[]) null);
        if (this.P != null) {
            Iterator<w> it = this.P.values().iterator();
            while (it.hasNext()) {
                it.next().a(view, fA);
            }
        }
        if (this.O != null) {
            dVar = null;
            boolean zA2 = false;
            for (x xVar : this.O.values()) {
                if (xVar instanceof x.d) {
                    dVar = (x.d) xVar;
                } else {
                    zA2 |= xVar.a(view, fA, j2, gVar);
                }
            }
            zA = zA2;
        } else {
            dVar = null;
            zA = false;
        }
        if (this.C != null) {
            double d2 = fA;
            this.C[0].a(d2, this.F);
            this.C[0].b(d2, this.G);
            if (this.D != null && this.F.length > 0) {
                this.D.a(d2, this.F);
                this.D.b(d2, this.G);
            }
            this.y.a(view, this.E, this.F, this.G, (double[]) null);
            if (this.P != null) {
                for (w wVar : this.P.values()) {
                    if (wVar instanceof w.d) {
                        ((w.d) wVar).a(view, fA, this.G[0], this.G[1]);
                    }
                    d2 = d2;
                }
            }
            double d3 = d2;
            if (dVar != null) {
                zA = dVar.a(view, gVar, fA, j2, this.G[0], this.G[1]) | zA;
            }
            for (int i2 = 1; i2 < this.C.length; i2++) {
                this.C[i2].a(d3, this.K);
                this.y.y.get(this.H[i2 - 1]).a(view, this.K);
            }
            if (this.A.c == 0) {
                if (fA <= 0.0f) {
                    view.setVisibility(this.A.d);
                } else if (fA >= 1.0f) {
                    view.setVisibility(this.B.d);
                } else if (this.B.d != this.A.d) {
                    view.setVisibility(0);
                }
            }
            if (this.R != null) {
                for (int i3 = 0; i3 < this.R.length; i3++) {
                    this.R[i3].a(fA, view);
                }
            }
        } else {
            float f3 = this.y.r + ((this.z.r - this.y.r) * fA);
            float f4 = this.y.s + ((this.z.s - this.y.s) * fA);
            float f5 = f3 + 0.5f;
            int i4 = (int) f5;
            float f6 = f4 + 0.5f;
            int i5 = (int) f6;
            int i6 = (int) (f5 + this.y.t + ((this.z.t - this.y.t) * fA));
            int i7 = (int) (f6 + this.y.u + ((this.z.u - this.y.u) * fA));
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (this.z.t != this.y.t || this.z.u != this.y.u) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i8, androidx.d.c.b.a.b.b), View.MeasureSpec.makeMeasureSpec(i9, androidx.d.c.b.a.b.b));
            }
            view.layout(i4, i5, i6, i7);
        }
        if (this.Q != null) {
            for (i iVar : this.Q.values()) {
                if (iVar instanceof i.g) {
                    ((i.g) iVar).a(view, fA, this.G[0], this.G[1]);
                } else {
                    iVar.a(view, fA);
                }
            }
        }
        return zA;
    }

    float b() {
        return this.y.s;
    }

    int b(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrA = this.C[0].a();
        if (iArr != null) {
            Iterator<t> it = this.L.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().z;
                i2++;
            }
        }
        int i3 = 0;
        for (double d2 : dArrA) {
            this.C[0].a(d2, this.F);
            this.y.b(this.E, this.F, fArr, i3);
            i3 += 2;
        }
        return i3 / 2;
    }

    public void b(int i2) {
        this.S = i2;
    }

    void b(View view) {
        this.y.p = 0.0f;
        this.y.q = 0.0f;
        this.y.a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.A.b(view);
    }

    void b(androidx.d.c.b.e eVar, androidx.d.e.g gVar) {
        this.z.p = 1.0f;
        this.z.q = 1.0f;
        b(this.z);
        this.z.a(eVar.G(), eVar.H(), eVar.I(), eVar.L());
        this.z.a(gVar.a(this.o));
        this.B.a(eVar, gVar, this.o);
    }

    void b(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        if (this.P != null) {
            this.P.get("translationX");
        }
        if (this.P != null) {
            this.P.get("translationY");
        }
        if (this.Q != null) {
            this.Q.get("translationX");
        }
        if (this.Q != null) {
            this.Q.get("translationY");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f3 = i3 * f2;
            float f4 = 0.0f;
            if (this.s != 1.0f) {
                if (f3 < this.r) {
                    f3 = 0.0f;
                }
                if (f3 > this.r && f3 < 1.0d) {
                    f3 = (f3 - this.r) * this.s;
                }
            }
            double dA = f3;
            androidx.d.b.a.c cVar = this.y.n;
            float f5 = Float.NaN;
            for (t tVar : this.L) {
                if (tVar.n != null) {
                    if (tVar.p < f3) {
                        cVar = tVar.n;
                        f4 = tVar.p;
                    } else if (Float.isNaN(f5)) {
                        f5 = tVar.p;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                float f6 = f5 - f4;
                dA = (((float) cVar.a((f3 - f4) / f6)) * f6) + f4;
            }
            this.C[0].a(dA, this.F);
            if (this.D != null && this.F.length > 0) {
                this.D.a(dA, this.F);
            }
            this.y.b(this.E, this.F, fArr, i3 * 2);
        }
    }

    float c() {
        return this.z.r;
    }

    public void c(int i2) {
        this.y.o = i2;
    }

    void c(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            this.C[0].a(a(i3 * f2, (float[]) null), this.F);
            this.y.c(this.E, this.F, fArr, i3 * 8);
        }
    }

    float d() {
        return this.z.s;
    }

    public int e() {
        int iMax = this.y.o;
        Iterator<t> it = this.L.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().o);
        }
        return Math.max(iMax, this.z.o);
    }

    String f() {
        return this.n.getContext().getResources().getResourceEntryName(this.n.getId());
    }

    public String toString() {
        return " start: x: " + this.y.r + " y: " + this.y.s + " end: x: " + this.z.r + " y: " + this.z.s;
    }
}
