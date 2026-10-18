package androidx.d.c;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f693a = false;
    public static final boolean b = false;
    public static final boolean c = false;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g = true;
    public static boolean h = true;
    public static boolean i = false;
    public static f r = null;
    public static long s = 0;
    public static long t = 0;
    private static final boolean u = false;
    private static int v = 1000;
    private a E;
    androidx.d.c.b[] l;
    final c q;
    private a x;
    public boolean j = false;
    int k = 0;
    private HashMap<String, i> w = null;
    private int y = 32;
    private int z = this.y;
    public boolean m = false;
    public boolean n = false;
    private boolean[] A = new boolean[this.y];
    int o = 1;
    int p = 0;
    private int B = this.y;
    private i[] C = new i[v];
    private int D = 0;

    interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(e eVar, androidx.d.c.b bVar, boolean z);

        void a(e eVar, i iVar, boolean z);

        void c(e eVar);

        void d(i iVar);

        boolean f();

        void g();

        i h();
    }

    class b extends androidx.d.c.b {
        public b(c cVar) {
            this.e = new j(this, cVar);
        }
    }

    public e() {
        this.l = null;
        this.l = new androidx.d.c.b[this.y];
        q();
        this.q = new c();
        this.x = new h(this.q);
        if (i) {
            this.E = new b(this.q);
        } else {
            this.E = new androidx.d.c.b(this.q);
        }
    }

    private final int a(a aVar, boolean z) {
        if (r != null) {
            r.l++;
        }
        for (int i2 = 0; i2 < this.o; i2++) {
            this.A[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            if (r != null) {
                r.m++;
            }
            i3++;
            if (i3 >= this.o * 2) {
                return i3;
            }
            if (aVar.h() != null) {
                this.A[aVar.h().k] = true;
            }
            i iVarA = aVar.a(this, this.A);
            if (iVarA != null) {
                if (this.A[iVarA.k]) {
                    return i3;
                }
                this.A[iVarA.k] = true;
            }
            if (iVarA != null) {
                float f2 = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.p; i5++) {
                    androidx.d.c.b bVar = this.l[i5];
                    if (bVar.f657a.s != i.a.UNRESTRICTED && !bVar.f && bVar.a(iVarA)) {
                        float fC = bVar.e.c(iVarA);
                        if (fC < 0.0f) {
                            float f3 = (-bVar.b) / fC;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    androidx.d.c.b bVar2 = this.l[i4];
                    bVar2.f657a.l = -1;
                    if (r != null) {
                        r.n++;
                    }
                    bVar2.b(iVarA);
                    bVar2.f657a.l = i4;
                    bVar2.f657a.a(this, bVar2);
                }
            } else {
                z2 = true;
            }
        }
        return i3;
    }

    public static androidx.d.c.b a(e eVar, i iVar, i iVar2, float f2) {
        return eVar.c().a(iVar, iVar2, f2);
    }

    public static f a() {
        return r;
    }

    private i a(i.a aVar, String str) {
        i iVarA = this.q.c.a();
        if (iVarA == null) {
            iVarA = new i(aVar, str);
            iVarA.a(aVar, str);
        } else {
            iVarA.d();
            iVarA.a(aVar, str);
        }
        if (this.D >= v) {
            v *= 2;
            this.C = (i[]) Arrays.copyOf(this.C, v);
        }
        i[] iVarArr = this.C;
        int i2 = this.D;
        this.D = i2 + 1;
        iVarArr[i2] = iVarA;
        return iVarA;
    }

    private void a(androidx.d.c.b bVar, int i2) {
        a(bVar, i2, 0);
    }

    private int b(a aVar) {
        boolean z;
        int i2 = 0;
        while (true) {
            if (i2 >= this.p) {
                z = false;
                break;
            }
            if (this.l[i2].f657a.s != i.a.UNRESTRICTED && this.l[i2].b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            if (r != null) {
                r.o++;
            }
            i3++;
            float f2 = Float.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < this.p; i7++) {
                androidx.d.c.b bVar = this.l[i7];
                if (bVar.f657a.s != i.a.UNRESTRICTED && !bVar.f && bVar.b < 0.0f) {
                    int i8 = 9;
                    if (h) {
                        int iE = bVar.e.e();
                        int i9 = i6;
                        float f3 = f2;
                        int i10 = i5;
                        int i11 = i4;
                        int i12 = 0;
                        while (i12 < iE) {
                            i iVarD = bVar.e.d(i12);
                            float fC = bVar.e.c(iVarD);
                            if (fC > 0.0f) {
                                int i13 = i9;
                                int i14 = 0;
                                while (i14 < i8) {
                                    float f4 = iVarD.q[i14] / fC;
                                    if ((f4 < f3 && i14 == i13) || i14 > i13) {
                                        i11 = i7;
                                        i10 = iVarD.k;
                                        f3 = f4;
                                        i13 = i14;
                                    }
                                    i14++;
                                    i8 = 9;
                                }
                                i9 = i13;
                            }
                            i12++;
                            i8 = 9;
                        }
                        i4 = i11;
                        i5 = i10;
                        f2 = f3;
                        i6 = i9;
                    } else {
                        for (int i15 = 1; i15 < this.o; i15++) {
                            i iVar = this.q.d[i15];
                            float fC2 = bVar.e.c(iVar);
                            if (fC2 > 0.0f) {
                                for (int i16 = 0; i16 < 9; i16++) {
                                    float f5 = iVar.q[i16] / fC2;
                                    if ((f5 < f2 && i16 == i6) || i16 > i6) {
                                        i5 = i15;
                                        i4 = i7;
                                        i6 = i16;
                                        f2 = f5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i4 != -1) {
                androidx.d.c.b bVar2 = this.l[i4];
                bVar2.f657a.l = -1;
                if (r != null) {
                    r.n++;
                }
                bVar2.b(this.q.d[i5]);
                bVar2.f657a.l = i4;
                bVar2.f657a.a(this, bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.o / 2) {
                z2 = true;
            }
        }
        return i3;
    }

    private i b(String str, i.a aVar) {
        if (r != null) {
            r.p++;
        }
        if (this.o + 1 >= this.z) {
            p();
        }
        i iVarA = a(aVar, (String) null);
        iVarA.a(str);
        this.k++;
        this.o++;
        iVarA.k = this.k;
        if (this.w == null) {
            this.w = new HashMap<>();
        }
        this.w.put(str, iVarA);
        this.q.d[this.k] = iVarA;
        return iVarA;
    }

    private String b(int i2) {
        int i3 = i2 * 4;
        int i4 = i3 / 1024;
        int i5 = i4 / 1024;
        if (i5 > 0) {
            return com.yftech.service.upgrade.a.d + i5 + " Mb";
        }
        if (i4 > 0) {
            return com.yftech.service.upgrade.a.d + i4 + " Kb";
        }
        return com.yftech.service.upgrade.a.d + i3 + " bytes";
    }

    private String c(int i2) {
        if (i2 == 1) {
            return "LOW";
        }
        if (i2 == 2) {
            return "MEDIUM";
        }
        if (i2 == 3) {
            return "HIGH";
        }
        if (i2 == 4) {
            return "HIGHEST";
        }
        if (i2 == 5) {
            return "EQUALITY";
        }
        if (i2 == 8) {
            return "FIXED";
        }
        return i2 == 6 ? "BARRIER" : "NONE";
    }

    private void c(androidx.d.c.b bVar) {
        bVar.a(this, 0);
    }

    private final void d(androidx.d.c.b bVar) {
        if (f && bVar.f) {
            bVar.f657a.a(this, bVar.b);
        } else {
            this.l[this.p] = bVar;
            bVar.f657a.l = this.p;
            this.p++;
            bVar.f657a.a(this, bVar);
        }
        if (f && this.j) {
            int i2 = 0;
            while (i2 < this.p) {
                if (this.l[i2] == null) {
                    System.out.println("WTF");
                }
                if (this.l[i2] != null && this.l[i2].f) {
                    androidx.d.c.b bVar2 = this.l[i2];
                    bVar2.f657a.a(this, bVar2.b);
                    if (i) {
                        this.q.f692a.a(bVar2);
                    } else {
                        this.q.b.a(bVar2);
                    }
                    this.l[i2] = null;
                    int i3 = i2 + 1;
                    int i4 = i3;
                    while (i3 < this.p) {
                        int i5 = i3 - 1;
                        this.l[i5] = this.l[i3];
                        if (this.l[i5].f657a.l == i3) {
                            this.l[i5].f657a.l = i5;
                        }
                        i4 = i3;
                        i3++;
                    }
                    if (i4 < this.p) {
                        this.l[i4] = null;
                    }
                    this.p--;
                    i2--;
                }
                i2++;
            }
            this.j = false;
        }
    }

    private void p() {
        this.y *= 2;
        this.l = (androidx.d.c.b[]) Arrays.copyOf(this.l, this.y);
        this.q.d = (i[]) Arrays.copyOf(this.q.d, this.y);
        this.A = new boolean[this.y];
        this.z = this.y;
        this.B = this.y;
        if (r != null) {
            r.h++;
            r.t = Math.max(r.t, this.y);
            r.J = r.t;
        }
    }

    private void q() {
        int i2 = 0;
        if (i) {
            while (i2 < this.p) {
                androidx.d.c.b bVar = this.l[i2];
                if (bVar != null) {
                    this.q.f692a.a(bVar);
                }
                this.l[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.p) {
            androidx.d.c.b bVar2 = this.l[i2];
            if (bVar2 != null) {
                this.q.b.a(bVar2);
            }
            this.l[i2] = null;
            i2++;
        }
    }

    private void r() {
        for (int i2 = 0; i2 < this.p; i2++) {
            androidx.d.c.b bVar = this.l[i2];
            bVar.f657a.n = bVar.b;
        }
    }

    private void s() {
        t();
        String str = com.yftech.service.upgrade.a.d;
        for (int i2 = 0; i2 < this.p; i2++) {
            str = (str + this.l[i2]) + "\n";
        }
        System.out.println(str + this.x + "\n");
    }

    private void t() {
        System.out.println("Display Rows (" + this.p + "x" + this.o + ")\n");
    }

    float a(String str) {
        i iVarA = a(str, i.a.UNRESTRICTED);
        if (iVarA == null) {
            return 0.0f;
        }
        return iVarA.n;
    }

    androidx.d.c.b a(int i2) {
        return this.l[i2];
    }

    public i a(int i2, String str) {
        if (r != null) {
            r.q++;
        }
        if (this.o + 1 >= this.z) {
            p();
        }
        i iVarA = a(i.a.ERROR, str);
        this.k++;
        this.o++;
        iVarA.k = this.k;
        iVarA.m = i2;
        this.q.d[this.k] = iVarA;
        this.x.d(iVarA);
        return iVarA;
    }

    public i a(Object obj) {
        i iVarG = null;
        if (obj == null) {
            return null;
        }
        if (this.o + 1 >= this.z) {
            p();
        }
        if (obj instanceof androidx.d.c.b.d) {
            androidx.d.c.b.d dVar = (androidx.d.c.b.d) obj;
            iVarG = dVar.g();
            if (iVarG == null) {
                dVar.a(this.q);
                iVarG = dVar.g();
            }
            if (iVarG.k == -1 || iVarG.k > this.k || this.q.d[iVarG.k] == null) {
                if (iVarG.k != -1) {
                    iVarG.d();
                }
                this.k++;
                this.o++;
                iVarG.k = this.k;
                iVarG.s = i.a.UNRESTRICTED;
                this.q.d[this.k] = iVarG;
            }
        }
        return iVarG;
    }

    i a(String str, i.a aVar) {
        if (this.w == null) {
            this.w = new HashMap<>();
        }
        i iVar = this.w.get(str);
        return iVar == null ? b(str, aVar) : iVar;
    }

    public void a(androidx.d.c.b.e eVar, androidx.d.c.b.e eVar2, float f2, int i2) {
        i iVarA = a(eVar.a(androidx.d.c.b.d.a.LEFT));
        i iVarA2 = a(eVar.a(androidx.d.c.b.d.a.TOP));
        i iVarA3 = a(eVar.a(androidx.d.c.b.d.a.RIGHT));
        i iVarA4 = a(eVar.a(androidx.d.c.b.d.a.BOTTOM));
        i iVarA5 = a(eVar2.a(androidx.d.c.b.d.a.LEFT));
        i iVarA6 = a(eVar2.a(androidx.d.c.b.d.a.TOP));
        i iVarA7 = a(eVar2.a(androidx.d.c.b.d.a.RIGHT));
        i iVarA8 = a(eVar2.a(androidx.d.c.b.d.a.BOTTOM));
        androidx.d.c.b bVarC = c();
        double d2 = f2;
        double d3 = i2;
        bVarC.b(iVarA2, iVarA4, iVarA6, iVarA8, (float) (Math.sin(d2) * d3));
        a(bVarC);
        androidx.d.c.b bVarC2 = c();
        bVarC2.b(iVarA, iVarA3, iVarA5, iVarA7, (float) (Math.cos(d2) * d3));
        a(bVarC2);
    }

    public void a(androidx.d.c.b bVar) {
        i iVarC;
        if (bVar == null) {
            return;
        }
        if (r != null) {
            r.j++;
            if (bVar.f) {
                r.k++;
            }
        }
        if (this.p + 1 >= this.B || this.o + 1 >= this.z) {
            p();
        }
        boolean z = false;
        if (!bVar.f) {
            bVar.c(this);
            if (bVar.f()) {
                return;
            }
            bVar.e();
            if (bVar.a(this)) {
                i iVarE = e();
                bVar.f657a = iVarE;
                int i2 = this.p;
                d(bVar);
                if (this.p == i2 + 1) {
                    this.E.a(bVar);
                    a(this.E, true);
                    if (iVarE.l == -1) {
                        if (bVar.f657a == iVarE && (iVarC = bVar.c(iVarE)) != null) {
                            if (r != null) {
                                r.n++;
                            }
                            bVar.b(iVarC);
                        }
                        if (!bVar.f) {
                            bVar.f657a.a(this, bVar);
                        }
                        if (i) {
                            this.q.f692a.a(bVar);
                        } else {
                            this.q.b.a(bVar);
                        }
                        this.p--;
                    }
                    z = true;
                }
            }
            if (!bVar.a()) {
                return;
            }
        }
        if (z) {
            return;
        }
        d(bVar);
    }

    void a(androidx.d.c.b bVar, int i2, int i3) {
        bVar.c(a(i3, (String) null), i2);
    }

    void a(a aVar) {
        if (r != null) {
            r.z++;
            r.A = Math.max(r.A, this.o);
            r.B = Math.max(r.B, this.p);
        }
        b(aVar);
        a(aVar, false);
        r();
    }

    public void a(f fVar) {
        r = fVar;
    }

    public void a(i iVar, int i2) {
        if (e && iVar.l == -1) {
            float f2 = i2;
            iVar.a(this, f2);
            for (int i3 = 0; i3 < this.k + 1; i3++) {
                i iVar2 = this.q.d[i3];
                if (iVar2 != null && iVar2.w && iVar2.x == iVar.k) {
                    iVar2.a(this, iVar2.y + f2);
                }
            }
            return;
        }
        int i4 = iVar.l;
        if (iVar.l == -1) {
            androidx.d.c.b bVarC = c();
            bVarC.a(iVar, i2);
            a(bVarC);
            return;
        }
        androidx.d.c.b bVar = this.l[i4];
        if (bVar.f) {
            bVar.b = i2;
            return;
        }
        if (bVar.e.e() == 0) {
            bVar.f = true;
            bVar.b = i2;
        } else {
            androidx.d.c.b bVarC2 = c();
            bVarC2.b(iVar, i2);
            a(bVarC2);
        }
    }

    public void a(i iVar, i iVar2, int i2) {
        if (iVar.l != -1 || i2 != 0) {
            c(iVar, iVar2, i2, 8);
            return;
        }
        if (iVar2.w) {
            float f2 = iVar2.y;
            iVar2 = this.q.d[iVar2.x];
        }
        if (!iVar.w) {
            iVar.a(this, iVar2, 0.0f);
        } else {
            float f3 = iVar.y;
            i iVar3 = this.q.d[iVar.x];
        }
    }

    public void a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        androidx.d.c.b bVarC = c();
        bVarC.a(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 8) {
            bVarC.a(this, i4);
        }
        a(bVarC);
    }

    public void a(i iVar, i iVar2, int i2, int i3) {
        androidx.d.c.b bVarC = c();
        i iVarD = d();
        iVarD.m = 0;
        bVarC.a(iVar, iVar2, iVarD, i2);
        if (i3 != 8) {
            a(bVarC, (int) (bVarC.e.c(iVarD) * (-1.0f)), i3);
        }
        a(bVarC);
    }

    public void a(i iVar, i iVar2, int i2, boolean z) {
        androidx.d.c.b bVarC = c();
        i iVarD = d();
        iVarD.m = 0;
        bVarC.a(iVar, iVar2, iVarD, i2);
        a(bVarC);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        androidx.d.c.b bVarC = c();
        bVarC.a(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 8) {
            bVarC.a(this, i2);
        }
        a(bVarC);
    }

    public int b(Object obj) {
        i iVarG = ((androidx.d.c.b.d) obj).g();
        if (iVarG != null) {
            return (int) (iVarG.n + 0.5f);
        }
        return 0;
    }

    public void b() {
        for (int i2 = 0; i2 < this.q.d.length; i2++) {
            i iVar = this.q.d[i2];
            if (iVar != null) {
                iVar.d();
            }
        }
        this.q.c.a(this.C, this.D);
        this.D = 0;
        Arrays.fill(this.q.d, (Object) null);
        if (this.w != null) {
            this.w.clear();
        }
        this.k = 0;
        this.x.g();
        this.o = 1;
        for (int i3 = 0; i3 < this.p; i3++) {
            if (this.l[i3] != null) {
                this.l[i3].c = false;
            }
        }
        q();
        this.p = 0;
        if (i) {
            this.E = new b(this.q);
        } else {
            this.E = new androidx.d.c.b(this.q);
        }
    }

    public void b(androidx.d.c.b bVar) {
        if (!bVar.f || bVar.f657a == null) {
            return;
        }
        if (bVar.f657a.l != -1) {
            int i2 = bVar.f657a.l;
            while (i2 < this.p - 1) {
                int i3 = i2 + 1;
                i iVar = this.l[i3].f657a;
                if (iVar.l == i3) {
                    iVar.l = i2;
                }
                this.l[i2] = this.l[i3];
                i2 = i3;
            }
            this.p--;
        }
        if (!bVar.f657a.o) {
            bVar.f657a.a(this, bVar.b);
        }
        if (i) {
            this.q.f692a.a(bVar);
        } else {
            this.q.b.a(bVar);
        }
    }

    public void b(i iVar, i iVar2, int i2, int i3) {
        androidx.d.c.b bVarC = c();
        i iVarD = d();
        iVarD.m = 0;
        bVarC.b(iVar, iVar2, iVarD, i2);
        if (i3 != 8) {
            a(bVarC, (int) (bVarC.e.c(iVarD) * (-1.0f)), i3);
        }
        a(bVarC);
    }

    public void b(i iVar, i iVar2, int i2, boolean z) {
        androidx.d.c.b bVarC = c();
        i iVarD = d();
        iVarD.m = 0;
        bVarC.b(iVar, iVar2, iVarD, i2);
        a(bVarC);
    }

    public androidx.d.c.b c() {
        androidx.d.c.b bVarA;
        if (i) {
            bVarA = this.q.f692a.a();
            if (bVarA == null) {
                bVarA = new b(this.q);
                t++;
            } else {
                bVarA.c();
            }
        } else {
            bVarA = this.q.b.a();
            if (bVarA == null) {
                bVarA = new androidx.d.c.b(this.q);
                s++;
            } else {
                bVarA.c();
            }
        }
        i.a();
        return bVarA;
    }

    public androidx.d.c.b c(i iVar, i iVar2, int i2, int i3) {
        if (e && i3 == 8 && iVar2.o && iVar.l == -1) {
            iVar.a(this, iVar2.n + i2);
            return null;
        }
        androidx.d.c.b bVarC = c();
        bVarC.a(iVar, iVar2, i2);
        if (i3 != 8) {
            bVarC.a(this, i3);
        }
        a(bVarC);
        return bVarC;
    }

    public i d() {
        if (r != null) {
            r.r++;
        }
        if (this.o + 1 >= this.z) {
            p();
        }
        i iVarA = a(i.a.SLACK, (String) null);
        this.k++;
        this.o++;
        iVarA.k = this.k;
        this.q.d[this.k] = iVarA;
        return iVarA;
    }

    public i e() {
        if (r != null) {
            r.s++;
        }
        if (this.o + 1 >= this.z) {
            p();
        }
        i iVarA = a(i.a.SLACK, (String) null);
        this.k++;
        this.o++;
        iVarA.k = this.k;
        this.q.d[this.k] = iVarA;
        return iVarA;
    }

    a f() {
        return this.x;
    }

    public void g() {
        if (r != null) {
            r.i++;
        }
        if (this.x.f()) {
            r();
            return;
        }
        if (!this.m && !this.n) {
            a(this.x);
            return;
        }
        if (r != null) {
            r.v++;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.p) {
                z = true;
                break;
            } else if (!this.l[i2].f) {
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            a(this.x);
            return;
        }
        if (r != null) {
            r.u++;
        }
        r();
    }

    final void h() {
        int i2 = 0;
        while (i2 < this.p) {
            androidx.d.c.b bVar = this.l[i2];
            if (bVar.e.e() == 0) {
                bVar.f = true;
            }
            if (bVar.f) {
                bVar.f657a.n = bVar.b;
                bVar.f657a.b(bVar);
                int i3 = i2;
                while (i3 < this.p - 1) {
                    int i4 = i3 + 1;
                    this.l[i3] = this.l[i4];
                    i3 = i4;
                }
                this.l[this.p - 1] = null;
                this.p--;
                i2--;
                if (i) {
                    this.q.f692a.a(bVar);
                } else {
                    this.q.b.a(bVar);
                }
            }
            i2++;
        }
    }

    public void i() {
        t();
        String str = " num vars " + this.k + "\n";
        for (int i2 = 0; i2 < this.k + 1; i2++) {
            i iVar = this.q.d[i2];
            if (iVar != null && iVar.o) {
                str = str + " $[" + i2 + "] => " + iVar + " = " + iVar.n + "\n";
            }
        }
        String str2 = str + "\n";
        for (int i3 = 0; i3 < this.k + 1; i3++) {
            i iVar2 = this.q.d[i3];
            if (iVar2 != null && iVar2.w) {
                str2 = str2 + " ~[" + i3 + "] => " + iVar2 + " = " + this.q.d[iVar2.x] + " + " + iVar2.y + "\n";
            }
        }
        String str3 = str2 + "\n\n #  ";
        for (int i4 = 0; i4 < this.p; i4++) {
            str3 = (str3 + this.l[i4].b()) + "\n #  ";
        }
        if (this.x != null) {
            str3 = str3 + "Goal: " + this.x + "\n";
        }
        System.out.println(str3);
    }

    public void j() {
        t();
        String str = com.yftech.service.upgrade.a.d;
        for (int i2 = 0; i2 < this.p; i2++) {
            if (this.l[i2].f657a.s == i.a.UNRESTRICTED) {
                str = (str + this.l[i2].b()) + "\n";
            }
        }
        System.out.println(str + this.x + "\n");
    }

    public int k() {
        int iD = 0;
        for (int i2 = 0; i2 < this.p; i2++) {
            if (this.l[i2] != null) {
                iD += this.l[i2].d();
            }
        }
        return iD;
    }

    public int l() {
        return this.p;
    }

    public int m() {
        return this.k;
    }

    void n() {
        int iD = 0;
        for (int i2 = 0; i2 < this.y; i2++) {
            if (this.l[i2] != null) {
                iD += this.l[i2].d();
            }
        }
        int iD2 = 0;
        for (int i3 = 0; i3 < this.p; i3++) {
            if (this.l[i3] != null) {
                iD2 += this.l[i3].d();
            }
        }
        System.out.println("Linear System -> Table size: " + this.y + " (" + b(this.y * this.y) + ") -- row sizes: " + b(iD) + ", actual size: " + b(iD2) + " rows: " + this.p + "/" + this.B + " cols: " + this.o + "/" + this.z + " 0 occupied cells, " + b(0));
    }

    public c o() {
        return this.q;
    }
}
