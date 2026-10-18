package androidx.d.c.b.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f659a = 0;
    public static final int b = 1073741824;
    public static final int c = Integer.MIN_VALUE;
    public static final int d = -1;
    public static final int e = -2;
    public static final int f = -3;
    private static final boolean g = false;
    private static final int h = 30;
    private final ArrayList<androidx.d.c.b.e> i = new ArrayList<>();
    private a j = new a();
    private androidx.d.c.b.f k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f660a = 0;
        public static int b = 1;
        public static int c = 2;
        public androidx.d.c.b.e.a d;
        public androidx.d.c.b.e.a e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public int m;
    }

    /* JADX INFO: renamed from: androidx.d.c.b.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0050b {
        void a();

        void a(androidx.d.c.b.e eVar, a aVar);
    }

    public b(androidx.d.c.b.f fVar) {
        this.k = fVar;
    }

    private void a(androidx.d.c.b.f fVar, String str, int i, int i2) {
        int iO = fVar.O();
        int iP = fVar.P();
        fVar.r(0);
        fVar.s(0);
        fVar.p(i);
        fVar.q(i2);
        fVar.r(iO);
        fVar.s(iP);
        this.k.at();
    }

    private boolean a(InterfaceC0050b interfaceC0050b, androidx.d.c.b.e eVar, int i) {
        this.j.d = eVar.aj();
        this.j.e = eVar.ak();
        this.j.f = eVar.I();
        this.j.g = eVar.L();
        this.j.l = false;
        this.j.m = i;
        boolean z = this.j.d == androidx.d.c.b.e.a.MATCH_CONSTRAINT;
        boolean z2 = this.j.e == androidx.d.c.b.e.a.MATCH_CONSTRAINT;
        boolean z3 = z && eVar.ao > 0.0f;
        boolean z4 = z2 && eVar.ao > 0.0f;
        if (z3 && eVar.I[0] == 4) {
            this.j.d = androidx.d.c.b.e.a.FIXED;
        }
        if (z4 && eVar.I[1] == 4) {
            this.j.e = androidx.d.c.b.e.a.FIXED;
        }
        interfaceC0050b.a(eVar, this.j);
        eVar.p(this.j.h);
        eVar.q(this.j.i);
        eVar.c(this.j.k);
        eVar.u(this.j.j);
        this.j.m = a.f660a;
        return this.j.l;
    }

    private void b(androidx.d.c.b.f fVar) {
        int size = fVar.bq.size();
        boolean zB = fVar.b(64);
        InterfaceC0050b interfaceC0050bH = fVar.h();
        for (int i = 0; i < size; i++) {
            androidx.d.c.b.e eVar = fVar.bq.get(i);
            if (!(eVar instanceof androidx.d.c.b.h) && !(eVar instanceof androidx.d.c.b.a) && !eVar.m() && (!zB || eVar.l == null || eVar.m == null || !eVar.l.g.j || !eVar.m.g.j)) {
                androidx.d.c.b.e.a aVarY = eVar.y(0);
                androidx.d.c.b.e.a aVarY2 = eVar.y(1);
                boolean z = aVarY == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.G != 1 && aVarY2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.H != 1;
                if (!z && fVar.b(1) && !(eVar instanceof androidx.d.c.b.m)) {
                    if (aVarY == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.G == 0 && aVarY2 != androidx.d.c.b.e.a.MATCH_CONSTRAINT && !eVar.al()) {
                        z = true;
                    }
                    if (aVarY2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.H == 0 && aVarY != androidx.d.c.b.e.a.MATCH_CONSTRAINT && !eVar.al()) {
                        z = true;
                    }
                    if ((aVarY == androidx.d.c.b.e.a.MATCH_CONSTRAINT || aVarY2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) && eVar.ao > 0.0f) {
                        z = true;
                    }
                }
                if (!z) {
                    a(interfaceC0050bH, eVar, a.f660a);
                    if (fVar.e != null) {
                        fVar.e.c++;
                    }
                }
            }
        }
        interfaceC0050bH.a();
    }

    public long a(androidx.d.c.b.f fVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean zA;
        int i10;
        int i11;
        boolean zA2;
        boolean z;
        boolean z2;
        InterfaceC0050b interfaceC0050bH = fVar.h();
        int size = fVar.bq.size();
        int I = fVar.I();
        int iL = fVar.L();
        boolean zA3 = androidx.d.c.b.k.a(i, 128);
        boolean z3 = zA3 || androidx.d.c.b.k.a(i, 64);
        if (z3) {
            for (int i12 = 0; i12 < size; i12++) {
                androidx.d.c.b.e eVar = fVar.bq.get(i12);
                boolean z4 = (eVar.aj() == androidx.d.c.b.e.a.MATCH_CONSTRAINT) && (eVar.ak() == androidx.d.c.b.e.a.MATCH_CONSTRAINT) && eVar.ac() > 0.0f;
                if ((eVar.al() && z4) || ((eVar.an() && z4) || (eVar instanceof androidx.d.c.b.m) || eVar.al() || eVar.an())) {
                    z3 = false;
                    break;
                }
            }
        }
        if (z3 && androidx.d.c.e.r != null) {
            androidx.d.c.e.r.e++;
        }
        boolean z5 = z3 & ((i4 == 1073741824 && i6 == 1073741824) || zA3);
        int i13 = 2;
        if (z5) {
            int iMin = Math.min(fVar.o(), i5);
            int iMin2 = Math.min(fVar.n(), i7);
            if (i4 == 1073741824 && fVar.I() != iMin) {
                fVar.p(iMin);
                fVar.b();
            }
            if (i6 == 1073741824 && fVar.L() != iMin2) {
                fVar.q(iMin2);
                fVar.b();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                zA = fVar.a(zA3);
                i10 = 2;
            } else {
                boolean zH = fVar.h(zA3);
                if (i4 == 1073741824) {
                    zH &= fVar.a(zA3, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    zA = fVar.a(zA3, 1) & zH;
                    i10++;
                } else {
                    zA = zH;
                }
            }
            if (zA) {
                fVar.a(i4 == 1073741824, i6 == 1073741824);
            }
        } else {
            zA = false;
            i10 = 0;
        }
        if (zA && i10 == 2) {
            return 0L;
        }
        int i14 = fVar.i();
        if (size > 0) {
            b(fVar);
        }
        a(fVar);
        int size2 = this.i.size();
        if (size > 0) {
            a(fVar, "First pass", I, iL);
        }
        if (size2 > 0) {
            boolean z6 = fVar.aj() == androidx.d.c.b.e.a.WRAP_CONTENT;
            boolean z7 = fVar.ak() == androidx.d.c.b.e.a.WRAP_CONTENT;
            int iMax = Math.max(fVar.I(), this.k.O());
            int iMax2 = Math.max(fVar.L(), this.k.P());
            int i15 = 0;
            boolean zH2 = false;
            while (i15 < size2) {
                androidx.d.c.b.e eVar2 = this.i.get(i15);
                if (eVar2 instanceof androidx.d.c.b.m) {
                    int I2 = eVar2.I();
                    int iL2 = eVar2.L();
                    boolean zA4 = a(interfaceC0050bH, eVar2, a.b) | zH2;
                    if (fVar.e != null) {
                        fVar.e.d++;
                    }
                    int I3 = eVar2.I();
                    int iL3 = eVar2.L();
                    if (I3 != I2) {
                        eVar2.p(I3);
                        if (z6 && eVar2.S() > iMax) {
                            iMax = Math.max(iMax, eVar2.S() + eVar2.a(androidx.d.c.b.d.a.RIGHT).j());
                        }
                        zA4 = true;
                    }
                    if (iL3 != iL2) {
                        eVar2.q(iL3);
                        if (z7 && eVar2.T() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.T() + eVar2.a(androidx.d.c.b.d.a.BOTTOM).j());
                        }
                        zA4 = true;
                    }
                    zH2 = zA4 | ((androidx.d.c.b.m) eVar2).h();
                } else {
                    iL = iL;
                }
                i15++;
                i14 = i14;
                I = I;
                iL = iL;
                i13 = 2;
            }
            int i16 = i14;
            int i17 = I;
            int i18 = iL;
            int i19 = i13;
            int i20 = 0;
            while (true) {
                if (i20 >= i19) {
                    zA2 = zH2;
                    break;
                }
                zA2 = zH2;
                int i21 = 0;
                while (i21 < size2) {
                    androidx.d.c.b.e eVar3 = this.i.get(i21);
                    if (((eVar3 instanceof androidx.d.c.b.i) && !(eVar3 instanceof androidx.d.c.b.m)) || (eVar3 instanceof androidx.d.c.b.h) || eVar3.E() == 8 || ((z5 && eVar3.l.g.j && eVar3.m.g.j) || (eVar3 instanceof androidx.d.c.b.m))) {
                        z2 = z5;
                        size2 = size2;
                        interfaceC0050bH = interfaceC0050bH;
                    } else {
                        int I4 = eVar3.I();
                        int iL4 = eVar3.L();
                        int iZ = eVar3.Z();
                        int i22 = a.b;
                        z2 = z5;
                        if (i20 == 1) {
                            i22 = a.c;
                        }
                        zA2 |= a(interfaceC0050bH, eVar3, i22);
                        if (fVar.e != null) {
                            fVar.e.d++;
                        }
                        int I5 = eVar3.I();
                        int iL5 = eVar3.L();
                        if (I5 != I4) {
                            eVar3.p(I5);
                            if (z6 && eVar3.S() > iMax) {
                                iMax = Math.max(iMax, eVar3.S() + eVar3.a(androidx.d.c.b.d.a.RIGHT).j());
                            }
                            zA2 = true;
                        }
                        if (iL5 != iL4) {
                            eVar3.q(iL5);
                            if (z7 && eVar3.T() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.T() + eVar3.a(androidx.d.c.b.d.a.BOTTOM).j());
                            }
                            zA2 = true;
                        }
                        if (eVar3.Y() && iZ != eVar3.Z()) {
                            zA2 = true;
                        }
                    }
                    i21++;
                    z5 = z2;
                    interfaceC0050bH = interfaceC0050bH;
                    size2 = size2;
                }
                boolean z8 = z5;
                int i23 = size2;
                InterfaceC0050b interfaceC0050b = interfaceC0050bH;
                if (!zA2) {
                    break;
                }
                a(fVar, "intermediate pass", i17, i18);
                i20++;
                z5 = z8;
                interfaceC0050bH = interfaceC0050b;
                size2 = i23;
                i19 = 2;
                zH2 = false;
            }
            if (zA2) {
                a(fVar, "2nd pass", i17, i18);
                if (fVar.I() < iMax) {
                    fVar.p(iMax);
                    z = true;
                } else {
                    z = false;
                }
                if (fVar.L() < iMax2) {
                    fVar.q(iMax2);
                    z = true;
                }
                if (z) {
                    a(fVar, "3rd pass", i17, i18);
                }
            }
            i11 = i16;
        } else {
            i11 = i14;
        }
        fVar.a(i11);
        return 0L;
    }

    public void a(androidx.d.c.b.f fVar) {
        this.i.clear();
        int size = fVar.bq.size();
        for (int i = 0; i < size; i++) {
            androidx.d.c.b.e eVar = fVar.bq.get(i);
            if (eVar.aj() == androidx.d.c.b.e.a.MATCH_CONSTRAINT || eVar.ak() == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                this.i.add(eVar);
            }
        }
        fVar.b();
    }
}
