package androidx.d.c.b;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class g extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f685a = 0;
    public static final int aY = 2;
    public static final int aZ = 3;
    public static final int b = 1;
    public static final int ba = 0;
    public static final int bb = 1;
    public static final int bc = 2;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    private e[] bE;
    private int bh = -1;
    private int bi = -1;
    private int bj = -1;
    private int bk = -1;
    private int bl = -1;
    private int bm = -1;
    private float bn = 0.5f;
    private float bo = 0.5f;
    private float bp = 0.5f;
    private float bq = 0.5f;
    private float br = 0.5f;
    private float bs = 0.5f;
    private int bt = 0;
    private int bu = 0;
    private int bv = 2;
    private int bw = 2;
    private int bx = 0;
    private int by = -1;
    private int bz = 0;
    private ArrayList<a> bA = new ArrayList<>();
    private e[] bB = null;
    private e[] bC = null;
    private int[] bD = null;
    private int bF = 0;

    private class a {
        private int c;
        private d e;
        private d f;
        private d g;
        private d h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int r;
        private e d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f686a = 0;
        private int m = 0;
        private int n = 0;
        private int o = 0;
        private int p = 0;
        private int q = 0;

        public a(int i, d dVar, d dVar2, d dVar3, d dVar4, int i2) {
            this.c = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.r = 0;
            this.c = i;
            this.e = dVar;
            this.f = dVar2;
            this.g = dVar3;
            this.h = dVar4;
            this.i = g.this.f();
            this.j = g.this.b();
            this.k = g.this.g();
            this.l = g.this.c();
            this.r = i2;
        }

        private void d() {
            this.m = 0;
            this.n = 0;
            this.d = null;
            this.f686a = 0;
            int i = this.p;
            for (int i2 = 0; i2 < i && this.o + i2 < g.this.bF; i2++) {
                e eVar = g.this.bE[this.o + i2];
                if (this.c == 0) {
                    int I = eVar.I();
                    int i3 = g.this.bt;
                    if (eVar.E() == 8) {
                        i3 = 0;
                    }
                    this.m += I + i3;
                    int iB = g.this.b(eVar, this.r);
                    if (this.d == null || this.f686a < iB) {
                        this.d = eVar;
                        this.f686a = iB;
                        this.n = iB;
                    }
                } else {
                    int iA = g.this.a(eVar, this.r);
                    int iB2 = g.this.b(eVar, this.r);
                    int i4 = g.this.bu;
                    if (eVar.E() == 8) {
                        i4 = 0;
                    }
                    this.n += iB2 + i4;
                    if (this.d == null || this.f686a < iA) {
                        this.d = eVar;
                        this.f686a = iA;
                        this.m = iA;
                    }
                }
            }
        }

        public void a() {
            this.f686a = 0;
            this.d = null;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
        }

        public void a(int i) {
            this.o = i;
        }

        public void a(int i, d dVar, d dVar2, d dVar3, d dVar4, int i2, int i3, int i4, int i5, int i6) {
            this.c = i;
            this.e = dVar;
            this.f = dVar2;
            this.g = dVar3;
            this.h = dVar4;
            this.i = i2;
            this.j = i3;
            this.k = i4;
            this.l = i5;
            this.r = i6;
        }

        public void a(e eVar) {
            if (this.c == 0) {
                int iA = g.this.a(eVar, this.r);
                if (eVar.aj() == e.a.MATCH_CONSTRAINT) {
                    this.q++;
                    iA = 0;
                }
                this.m += iA + (eVar.E() != 8 ? g.this.bt : 0);
                int iB = g.this.b(eVar, this.r);
                if (this.d == null || this.f686a < iB) {
                    this.d = eVar;
                    this.f686a = iB;
                    this.n = iB;
                }
            } else {
                int iA2 = g.this.a(eVar, this.r);
                int iB2 = g.this.b(eVar, this.r);
                if (eVar.ak() == e.a.MATCH_CONSTRAINT) {
                    this.q++;
                    iB2 = 0;
                }
                this.n += iB2 + (eVar.E() != 8 ? g.this.bu : 0);
                if (this.d == null || this.f686a < iA2) {
                    this.d = eVar;
                    this.f686a = iA2;
                    this.m = iA2;
                }
            }
            this.p++;
        }

        /* JADX WARN: Code duplicated, block: B:171:0x0361 A[FALL_THROUGH] */
        /* JADX WARN: Switch 'out' block B:171:0x0361 for B:158:0x02fa already processed. Defaulting to fallback option. */
        /* JADX WARN: Switch 'out' block B:171:0x0361 for B:164:0x0326 already processed. Defaulting to fallback option. */
        public void a(boolean z, int i, boolean z2) {
            int i2;
            e eVar;
            char c;
            int i3;
            int i4 = this.p;
            for (int i5 = 0; i5 < i4 && this.o + i5 < g.this.bF; i5++) {
                e eVar2 = g.this.bE[this.o + i5];
                if (eVar2 != null) {
                    eVar2.ai();
                }
            }
            if (i4 == 0 || this.d == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i6 = -1;
            int i7 = -1;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = z ? (i4 - 1) - i8 : i8;
                if (this.o + i9 >= g.this.bF) {
                    break;
                }
                if (g.this.bE[this.o + i9].E() == 0) {
                    if (i6 == -1) {
                        i6 = i8;
                    }
                    i7 = i8;
                }
            }
            if (this.c != 0) {
                e eVar3 = this.d;
                eVar3.w(g.this.bh);
                int i10 = this.i;
                if (i > 0) {
                    i10 += g.this.bt;
                }
                if (z) {
                    eVar3.V.a(this.g, i10);
                    if (z2) {
                        eVar3.T.a(this.e, this.k);
                    }
                    if (i > 0) {
                        this.g.f678a.T.a(eVar3.V, 0);
                    }
                } else {
                    eVar3.T.a(this.e, i10);
                    if (z2) {
                        eVar3.V.a(this.g, this.k);
                    }
                    if (i > 0) {
                        this.e.f678a.V.a(eVar3.T, 0);
                    }
                }
                int i11 = 0;
                e eVar4 = null;
                while (i11 < i4 && this.o + i11 < g.this.bF) {
                    e eVar5 = g.this.bE[this.o + i11];
                    if (i11 == 0) {
                        eVar5.a(eVar5.U, this.f, this.j);
                        int i12 = g.this.bi;
                        float f = g.this.bo;
                        if (this.o == 0) {
                            i2 = -1;
                            if (g.this.bk != -1) {
                                i12 = g.this.bk;
                                f = g.this.bq;
                            }
                            eVar5.x(i12);
                            eVar5.b(f);
                        } else {
                            i2 = -1;
                        }
                        if (z2 && g.this.bm != i2) {
                            i12 = g.this.bm;
                            f = g.this.bs;
                        }
                        eVar5.x(i12);
                        eVar5.b(f);
                    }
                    if (i11 == i4 - 1) {
                        eVar5.a(eVar5.W, this.h, this.l);
                    }
                    if (eVar4 != null) {
                        eVar5.U.a(eVar4.W, g.this.bu);
                        if (i11 == i6) {
                            eVar5.U.c(this.j);
                        }
                        eVar4.W.a(eVar5.U, 0);
                        if (i11 == i7 + 1) {
                            eVar4.W.c(this.l);
                        }
                    }
                    if (eVar5 != eVar3) {
                        if (!z) {
                            switch (g.this.bv) {
                                case 0:
                                    eVar5.T.a(eVar3.T, 0);
                                    continue;
                                case 1:
                                    eVar5.V.a(eVar3.V, 0);
                                    continue;
                                case 2:
                                    if (!z3) {
                                        eVar5.T.a(eVar3.T, 0);
                                        eVar5.V.a(eVar3.V, 0);
                                        break;
                                    } else {
                                        eVar5.T.a(this.e, this.i);
                                        eVar5.V.a(this.g, this.k);
                                        break;
                                    }
                                default:
                                    break;
                            }
                        } else {
                            switch (g.this.bv) {
                                case 0:
                                    eVar5.V.a(eVar3.V, 0);
                                    break;
                                case 1:
                                    eVar5.T.a(eVar3.T, 0);
                                    break;
                                case 2:
                                    eVar5.T.a(eVar3.T, 0);
                                    eVar5.V.a(eVar3.V, 0);
                                    break;
                            }
                        }
                    }
                    i11++;
                    eVar4 = eVar5;
                }
                return;
            }
            e eVar6 = this.d;
            eVar6.x(g.this.bi);
            int i13 = this.j;
            if (i > 0) {
                i13 += g.this.bu;
            }
            eVar6.U.a(this.f, i13);
            if (z2) {
                eVar6.W.a(this.h, this.l);
            }
            if (i > 0) {
                this.f.f678a.W.a(eVar6.U, 0);
            }
            if (g.this.bw != 3 || eVar6.Y()) {
                eVar = eVar6;
                break;
            }
            int i14 = 0;
            while (true) {
                if (i14 < i4) {
                    int i15 = z ? (i4 - 1) - i14 : i14;
                    if (this.o + i15 < g.this.bF) {
                        eVar = g.this.bE[this.o + i15];
                        if (eVar.Y()) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                }
                eVar = eVar6;
                break;
            }
            int i16 = 0;
            e eVar7 = null;
            while (i16 < i4) {
                int i17 = z ? (i4 - 1) - i16 : i16;
                if (this.o + i17 >= g.this.bF) {
                    return;
                }
                e eVar8 = g.this.bE[this.o + i17];
                if (i16 == 0) {
                    eVar8.a(eVar8.T, this.e, this.i);
                }
                if (i17 == 0) {
                    int i18 = g.this.bh;
                    float f2 = g.this.bn;
                    if (this.o == 0) {
                        i3 = -1;
                        if (g.this.bj != -1) {
                            i18 = g.this.bj;
                            f2 = g.this.bp;
                        }
                        eVar8.w(i18);
                        eVar8.a(f2);
                    } else {
                        i3 = -1;
                    }
                    if (z2 && g.this.bl != i3) {
                        i18 = g.this.bl;
                        f2 = g.this.br;
                    }
                    eVar8.w(i18);
                    eVar8.a(f2);
                }
                if (i16 == i4 - 1) {
                    eVar8.a(eVar8.V, this.g, this.k);
                }
                if (eVar7 != null) {
                    eVar8.T.a(eVar7.V, g.this.bt);
                    if (i16 == i6) {
                        eVar8.T.c(this.i);
                    }
                    eVar7.V.a(eVar8.T, 0);
                    if (i16 == i7 + 1) {
                        eVar7.V.c(this.k);
                    }
                }
                if (eVar8 != eVar6) {
                    c = 3;
                    if (g.this.bw != 3 || !eVar.Y() || eVar8 == eVar || !eVar8.Y()) {
                        switch (g.this.bw) {
                            case 0:
                                eVar8.U.a(eVar6.U, 0);
                                break;
                            case 1:
                                eVar8.W.a(eVar6.W, 0);
                                break;
                            default:
                                if (z3) {
                                    eVar8.U.a(this.f, this.j);
                                    eVar8.W.a(this.h, this.l);
                                } else {
                                    eVar8.U.a(eVar6.U, 0);
                                    eVar8.W.a(eVar6.W, 0);
                                }
                                break;
                        }
                    } else {
                        eVar8.X.a(eVar.X, 0);
                    }
                } else {
                    c = 3;
                }
                i16++;
                eVar7 = eVar8;
            }
        }

        public int b() {
            return this.c == 0 ? this.m - g.this.bt : this.m;
        }

        public void b(int i) {
            if (this.q == 0) {
                return;
            }
            int i2 = this.p;
            int i3 = i / this.q;
            for (int i4 = 0; i4 < i2 && this.o + i4 < g.this.bF; i4++) {
                e eVar = g.this.bE[this.o + i4];
                if (this.c == 0) {
                    if (eVar != null && eVar.aj() == e.a.MATCH_CONSTRAINT && eVar.G == 0) {
                        g.this.a(eVar, e.a.FIXED, i3, eVar.ak(), eVar.L());
                    }
                } else if (eVar != null && eVar.ak() == e.a.MATCH_CONSTRAINT && eVar.H == 0) {
                    g.this.a(eVar, eVar.aj(), eVar.I(), e.a.FIXED, i3);
                }
            }
            d();
        }

        public int c() {
            return this.c == 1 ? this.n - g.this.bu : this.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a(e eVar, int i) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.aj() == e.a.MATCH_CONSTRAINT) {
            if (eVar.G == 0) {
                return 0;
            }
            if (eVar.G == 2) {
                int i2 = (int) (eVar.L * i);
                if (i2 != eVar.I()) {
                    eVar.e(true);
                    a(eVar, e.a.FIXED, i2, eVar.ak(), eVar.L());
                }
                return i2;
            }
            if (eVar.G == 1) {
                return eVar.I();
            }
            if (eVar.G == 3) {
                return (int) ((eVar.L() * eVar.ao) + 0.5f);
            }
        }
        return eVar.I();
    }

    private void a(e[] eVarArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        if (i == 0) {
            return;
        }
        this.bA.clear();
        a aVar = new a(i2, this.T, this.U, this.V, this.W, i3);
        this.bA.add(aVar);
        if (i2 == 0) {
            a aVar2 = aVar;
            i4 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < i) {
                e eVar = eVarArr[i7];
                int iA = a(eVar, i3);
                if (eVar.aj() == e.a.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i8 = i4;
                boolean z = (i6 == i3 || (this.bt + i6) + iA > i3) && aVar2.d != null;
                if (!z && i7 > 0 && this.by > 0 && i7 % this.by == 0) {
                    z = true;
                }
                if (z) {
                    i5 = i8;
                    a aVar3 = new a(i2, this.T, this.U, this.V, this.W, i3);
                    aVar3.a(i7);
                    this.bA.add(aVar3);
                    i6 = iA;
                    aVar2 = aVar3;
                } else {
                    i5 = i8;
                    i6 = i7 > 0 ? i6 + this.bt + iA : iA;
                }
                aVar2.a(eVar);
                i7++;
                i4 = i5;
            }
        } else {
            a aVar4 = aVar;
            i4 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i) {
                e eVar2 = eVarArr[i10];
                int iB = b(eVar2, i3);
                if (eVar2.ak() == e.a.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i11 = i4;
                boolean z2 = (i9 == i3 || (this.bu + i9) + iB > i3) && aVar4.d != null;
                if (!z2 && i10 > 0 && this.by > 0 && i10 % this.by == 0) {
                    z2 = true;
                }
                if (z2) {
                    a aVar5 = new a(i2, this.T, this.U, this.V, this.W, i3);
                    aVar5.a(i10);
                    this.bA.add(aVar5);
                    aVar4 = aVar5;
                } else {
                    if (i10 > 0) {
                        i9 += this.bu + iB;
                    }
                    aVar4.a(eVar2);
                    i10++;
                    i4 = i11;
                }
                i9 = iB;
                aVar4.a(eVar2);
                i10++;
                i4 = i11;
            }
        }
        int size = this.bA.size();
        d dVar = this.T;
        d dVar2 = this.U;
        d dVar3 = this.V;
        d dVar4 = this.W;
        int iF = f();
        int iB2 = b();
        int iG = g();
        int iC = c();
        boolean z3 = aj() == e.a.WRAP_CONTENT || ak() == e.a.WRAP_CONTENT;
        if (i4 > 0 && z3) {
            for (int i12 = 0; i12 < size; i12++) {
                a aVar6 = this.bA.get(i12);
                if (i2 == 0) {
                    aVar6.b(i3 - aVar6.b());
                } else {
                    aVar6.b(i3 - aVar6.c());
                }
            }
        }
        d dVar5 = dVar4;
        int i13 = iB2;
        int iG2 = iG;
        int iC2 = iC;
        d dVar6 = dVar2;
        int i14 = iF;
        int iMax = 0;
        d dVar7 = dVar3;
        d dVar8 = dVar;
        int iB3 = 0;
        for (int i15 = 0; i15 < size; i15++) {
            a aVar7 = this.bA.get(i15);
            if (i2 == 0) {
                if (i15 < size - 1) {
                    dVar5 = this.bA.get(i15 + 1).d.U;
                    iC2 = 0;
                } else {
                    dVar5 = this.W;
                    iC2 = c();
                }
                dVar6 = aVar7.d.W;
                aVar7.a(i2, dVar8, dVar6, dVar7, dVar5, i14, i13, iG2, iC2, i3);
                iB3 = Math.max(iB3, aVar7.b());
                iMax += aVar7.c();
                if (i15 > 0) {
                    iMax += this.bu;
                }
                i13 = 0;
            } else {
                if (i15 < size - 1) {
                    dVar7 = this.bA.get(i15 + 1).d.T;
                    iG2 = 0;
                } else {
                    dVar7 = this.V;
                    iG2 = g();
                }
                dVar8 = aVar7.d.V;
                aVar7.a(i2, dVar8, dVar6, dVar7, dVar5, i14, i13, iG2, iC2, i3);
                iB3 += aVar7.b();
                iMax = Math.max(iMax, aVar7.c());
                if (i15 > 0) {
                    iB3 += this.bt;
                }
                i14 = 0;
            }
        }
        iArr[0] = iB3;
        iArr[1] = iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(e eVar, int i) {
        if (eVar == null) {
            return 0;
        }
        if (eVar.ak() == e.a.MATCH_CONSTRAINT) {
            if (eVar.H == 0) {
                return 0;
            }
            if (eVar.H == 2) {
                int i2 = (int) (eVar.O * i);
                if (i2 != eVar.L()) {
                    eVar.e(true);
                    a(eVar, eVar.aj(), eVar.I(), e.a.FIXED, i2);
                }
                return i2;
            }
            if (eVar.H == 1) {
                return eVar.L();
            }
            if (eVar.H == 3) {
                return (int) ((eVar.I() * eVar.ao) + 0.5f);
            }
        }
        return eVar.L();
    }

    private void b(e[] eVarArr, int i, int i2, int i3, int[] iArr) {
        a aVar;
        if (i == 0) {
            return;
        }
        if (this.bA.size() == 0) {
            aVar = new a(i2, this.T, this.U, this.V, this.W, i3);
            this.bA.add(aVar);
        } else {
            a aVar2 = this.bA.get(0);
            aVar2.a();
            aVar = aVar2;
            aVar.a(i2, this.T, this.U, this.V, this.W, f(), b(), g(), c(), i3);
        }
        for (int i4 = 0; i4 < i; i4++) {
            aVar.a(eVarArr[i4]);
        }
        iArr[0] = aVar.b();
        iArr[1] = aVar.c();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0107  */
    /* JADX WARN: Code duplicated, block: B:102:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x010f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0122 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:112:0x012a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:120:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x005b A[ADDED_TO_REGION, EDGE_INSN: B:122:0x005b->B:45:0x005b BREAK  A[LOOP:1: B:47:0x005f->B:127:0x005f], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x005b A[ADDED_TO_REGION, EDGE_INSN: B:125:0x005b->B:45:0x005b BREAK  A[LOOP:1: B:47:0x005f->B:127:0x005f], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x00e6 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0063  */
    /* JADX WARN: Code duplicated, block: B:50:0x006d  */
    /* JADX WARN: Code duplicated, block: B:53:0x007b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0087  */
    /* JADX WARN: Code duplicated, block: B:60:0x008f  */
    /* JADX WARN: Code duplicated, block: B:64:0x009b  */
    /* JADX WARN: Code duplicated, block: B:67:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:75:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:85:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:94:0x00f6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x00f8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0120 -> B:45:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0122 -> B:45:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x0128 -> B:45:0x005b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x012a -> B:45:0x005b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:85:0x00d8
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void c(androidx.d.c.b.e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.d.c.b.g.c(androidx.d.c.b.e[], int, int, int, int[]):void");
    }

    private void i(boolean z) {
        e eVar;
        if (this.bD == null || this.bC == null || this.bB == null) {
            return;
        }
        for (int i = 0; i < this.bF; i++) {
            this.bE[i].ai();
        }
        int i2 = this.bD[0];
        int i3 = this.bD[1];
        e eVar2 = null;
        for (int i4 = 0; i4 < i2; i4++) {
            e eVar3 = this.bC[z ? (i2 - i4) - 1 : i4];
            if (eVar3 != null && eVar3.E() != 8) {
                if (i4 == 0) {
                    eVar3.a(eVar3.T, this.T, f());
                    eVar3.w(this.bh);
                    eVar3.a(this.bn);
                }
                if (i4 == i2 - 1) {
                    eVar3.a(eVar3.V, this.V, g());
                }
                if (i4 > 0) {
                    eVar3.a(eVar3.T, eVar2.V, this.bt);
                    eVar2.a(eVar2.V, eVar3.T, 0);
                }
                eVar2 = eVar3;
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            e eVar4 = this.bB[i5];
            if (eVar4 != null && eVar4.E() != 8) {
                if (i5 == 0) {
                    eVar4.a(eVar4.U, this.U, b());
                    eVar4.x(this.bi);
                    eVar4.b(this.bo);
                }
                if (i5 == i3 - 1) {
                    eVar4.a(eVar4.W, this.W, c());
                }
                if (i5 > 0) {
                    eVar4.a(eVar4.U, eVar2.W, this.bu);
                    eVar2.a(eVar2.W, eVar4.U, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i2) + i6;
                if (this.bz == 1) {
                    i8 = (i6 * i3) + i7;
                }
                if (i8 < this.bE.length && (eVar = this.bE[i8]) != null && eVar.E() != 8) {
                    e eVar5 = this.bC[i6];
                    e eVar6 = this.bB[i7];
                    if (eVar != eVar5) {
                        eVar.a(eVar.T, eVar5.T, 0);
                        eVar.a(eVar.V, eVar5.V, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.a(eVar.U, eVar6.U, 0);
                        eVar.a(eVar.W, eVar6.W, 0);
                    }
                }
            }
        }
    }

    public void B(int i) {
        this.bk = i;
    }

    public void C(int i) {
        this.bl = i;
    }

    public void D(int i) {
        this.bm = i;
    }

    public void E(int i) {
        this.bh = i;
    }

    public void F(int i) {
        this.bi = i;
    }

    public void G(int i) {
        this.bv = i;
    }

    public void H(int i) {
        this.bw = i;
    }

    public void I(int i) {
        this.bx = i;
    }

    public void J(int i) {
        this.bt = i;
    }

    public void K(int i) {
        this.bu = i;
    }

    public void L(int i) {
        this.by = i;
    }

    public void a(int i) {
        this.bz = i;
    }

    @Override // androidx.d.c.b.j, androidx.d.c.b.e
    public void a(e eVar, HashMap<e, e> map) {
        super.a(eVar, map);
        g gVar = (g) eVar;
        this.bh = gVar.bh;
        this.bi = gVar.bi;
        this.bj = gVar.bj;
        this.bk = gVar.bk;
        this.bl = gVar.bl;
        this.bm = gVar.bm;
        this.bn = gVar.bn;
        this.bo = gVar.bo;
        this.bp = gVar.bp;
        this.bq = gVar.bq;
        this.br = gVar.br;
        this.bs = gVar.bs;
        this.bt = gVar.bt;
        this.bu = gVar.bu;
        this.bv = gVar.bv;
        this.bw = gVar.bw;
        this.bx = gVar.bx;
        this.by = gVar.by;
        this.bz = gVar.bz;
    }

    @Override // androidx.d.c.b.e
    public void a(androidx.d.c.e eVar, boolean z) {
        super.a(eVar, z);
        boolean zAs = A() != null ? ((f) A()).as() : false;
        switch (this.bx) {
            case 0:
                if (this.bA.size() > 0) {
                    this.bA.get(0).a(zAs, 0, true);
                }
                break;
            case 1:
                int size = this.bA.size();
                int i = 0;
                while (i < size) {
                    this.bA.get(i).a(zAs, i, i == size + (-1));
                    i++;
                }
                break;
            case 2:
                i(zAs);
                break;
        }
        h(false);
    }

    public void b(int i) {
        this.bj = i;
    }

    @Override // androidx.d.c.b.m
    public void b(int i, int i2, int i3, int i4) {
        int i5;
        boolean z;
        if (this.be > 0 && !as()) {
            k(0, 0);
            h(false);
            return;
        }
        int iF = f();
        int iG = g();
        int iB = b();
        int iC = c();
        int[] iArr = new int[2];
        int i6 = (i2 - iF) - iG;
        if (this.bz == 1) {
            i6 = (i4 - iB) - iC;
        }
        int i7 = i6;
        if (this.bz == 0) {
            if (this.bh == -1) {
                this.bh = 0;
            }
            if (this.bi == -1) {
                this.bi = 0;
            }
        } else {
            if (this.bh == -1) {
                this.bh = 0;
            }
            if (this.bi == -1) {
                this.bi = 0;
            }
        }
        e[] eVarArr = this.bd;
        int i8 = 0;
        for (int i9 = 0; i9 < this.be; i9++) {
            if (this.bd[i9].E() == 8) {
                i8++;
            }
        }
        int i10 = this.be;
        if (i8 > 0) {
            eVarArr = new e[this.be - i8];
            i5 = 0;
            for (int i11 = 0; i11 < this.be; i11++) {
                e eVar = this.bd[i11];
                if (eVar.E() != 8) {
                    eVarArr[i5] = eVar;
                    i5++;
                }
            }
        } else {
            i5 = i10;
        }
        e[] eVarArr2 = eVarArr;
        this.bE = eVarArr2;
        this.bF = i5;
        switch (this.bx) {
            case 0:
                z = true;
                b(eVarArr2, i5, this.bz, i7, iArr);
                break;
            case 1:
                z = true;
                a(eVarArr2, i5, this.bz, i7, iArr);
                break;
            case 2:
                z = true;
                c(eVarArr2, i5, this.bz, i7, iArr);
                break;
            default:
                z = true;
                break;
        }
        int iMin = iArr[0] + iF + iG;
        int iMin2 = iArr[z ? 1 : 0] + iB + iC;
        if (i == 1073741824) {
            iMin = i2;
        } else if (i == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i2);
        } else if (i != 0) {
            iMin = 0;
        }
        if (i3 == 1073741824) {
            iMin2 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i4);
        } else if (i3 != 0) {
            iMin2 = 0;
        }
        k(iMin, iMin2);
        p(iMin);
        q(iMin2);
        if (this.be <= 0) {
            z = false;
        }
        h(z);
    }

    public void e(float f) {
        this.bn = f;
    }

    public void f(float f) {
        this.bo = f;
    }

    public void g(float f) {
        this.bp = f;
    }

    public void h(float f) {
        this.bq = f;
    }

    public void i(float f) {
        this.br = f;
    }

    public void j(float f) {
        this.bs = f;
    }
}
