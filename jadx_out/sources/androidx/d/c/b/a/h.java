package androidx.d.c.b.a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f665a = false;
    private static final boolean b = false;
    private static b.a c = new b.a();

    private static void a(b.InterfaceC0050b interfaceC0050b, androidx.d.c.b.e eVar) {
        float fX = eVar.X();
        int iD = eVar.U.c.d();
        int iD2 = eVar.W.c.d();
        int iJ = eVar.U.j() + iD;
        int iJ2 = iD2 - eVar.W.j();
        if (iD == iD2) {
            fX = 0.5f;
        } else {
            iD = iJ;
            iD2 = iJ2;
        }
        int iL = eVar.L();
        int i = (iD2 - iD) - iL;
        if (iD > iD2) {
            i = (iD - iD2) - iL;
        }
        int i2 = (int) ((fX * i) + 0.5f);
        int i3 = iD + i2;
        int i4 = i3 + iL;
        if (iD > iD2) {
            i3 = iD - i2;
            i4 = i3 - iL;
        }
        eVar.b(i3, i4);
        a(eVar, interfaceC0050b);
    }

    private static void a(b.InterfaceC0050b interfaceC0050b, androidx.d.c.b.e eVar, boolean z) {
        float fW = eVar.W();
        int iD = eVar.T.c.d();
        int iD2 = eVar.V.c.d();
        int iJ = eVar.T.j() + iD;
        int iJ2 = iD2 - eVar.V.j();
        if (iD == iD2) {
            fW = 0.5f;
        } else {
            iD = iJ;
            iD2 = iJ2;
        }
        int I = eVar.I();
        int i = (iD2 - iD) - I;
        if (iD > iD2) {
            i = (iD - iD2) - I;
        }
        int i2 = ((int) ((fW * i) + 0.5f)) + iD;
        int i3 = i2 + I;
        if (iD > iD2) {
            i3 = i2 - I;
        }
        eVar.a(i2, i3);
        a(eVar, interfaceC0050b, z);
    }

    private static void a(androidx.d.c.b.a aVar, b.InterfaceC0050b interfaceC0050b, int i, boolean z) {
        if (aVar.i()) {
            if (i == 0) {
                a(aVar, interfaceC0050b, z);
            } else {
                a(aVar, interfaceC0050b);
            }
        }
    }

    private static void a(androidx.d.c.b.e eVar, b.InterfaceC0050b interfaceC0050b) {
        if (!(eVar instanceof androidx.d.c.b.f) && eVar.t() && a(eVar)) {
            androidx.d.c.b.f.a(eVar, interfaceC0050b, new b.a(), b.a.f660a);
        }
        androidx.d.c.b.d dVarA = eVar.a(androidx.d.c.b.d.a.TOP);
        androidx.d.c.b.d dVarA2 = eVar.a(androidx.d.c.b.d.a.BOTTOM);
        int iD = dVarA.d();
        int iD2 = dVarA2.d();
        if (dVarA.a() != null && dVarA.f()) {
            Iterator<androidx.d.c.b.d> it = dVarA.a().iterator();
            while (it.hasNext()) {
                androidx.d.c.b.d next = it.next();
                androidx.d.c.b.e eVar2 = next.f678a;
                boolean zA = a(eVar2);
                if (eVar2.t() && zA) {
                    androidx.d.c.b.f.a(eVar2, interfaceC0050b, new b.a(), b.a.f660a);
                }
                if (eVar2.ak() != androidx.d.c.b.e.a.MATCH_CONSTRAINT || zA) {
                    if (!eVar2.t()) {
                        if (next == eVar2.U && eVar2.W.c == null) {
                            int iJ = eVar2.U.j() + iD;
                            eVar2.b(iJ, eVar2.L() + iJ);
                            a(eVar2, interfaceC0050b);
                        } else if (next == eVar2.W && eVar2.W.c == null) {
                            int iJ2 = iD - eVar2.W.j();
                            eVar2.b(iJ2 - eVar2.L(), iJ2);
                            a(eVar2, interfaceC0050b);
                        } else if (next == eVar2.U && eVar2.W.c != null && eVar2.W.c.f()) {
                            a(interfaceC0050b, eVar2);
                        }
                    }
                } else if (eVar2.ak() == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar2.N >= 0 && eVar2.M >= 0 && (eVar2.E() == 8 || (eVar2.H == 0 && eVar2.ac() == 0.0f))) {
                    if (!eVar2.an() && !eVar2.m()) {
                        if (((next == eVar2.U && eVar2.W.c != null && eVar2.W.c.f()) || (next == eVar2.W && eVar2.U.c != null && eVar2.U.c.f())) && !eVar2.an()) {
                            a(eVar, interfaceC0050b, eVar2);
                        }
                    }
                }
            }
        }
        if (eVar instanceof androidx.d.c.b.h) {
            return;
        }
        if (dVarA2.a() != null && dVarA2.f()) {
            Iterator<androidx.d.c.b.d> it2 = dVarA2.a().iterator();
            while (it2.hasNext()) {
                androidx.d.c.b.d next2 = it2.next();
                androidx.d.c.b.e eVar3 = next2.f678a;
                boolean zA2 = a(eVar3);
                if (eVar3.t() && zA2) {
                    androidx.d.c.b.f.a(eVar3, interfaceC0050b, new b.a(), b.a.f660a);
                }
                boolean z = (next2 == eVar3.U && eVar3.W.c != null && eVar3.W.c.f()) || (next2 == eVar3.W && eVar3.U.c != null && eVar3.U.c.f());
                if (eVar3.ak() != androidx.d.c.b.e.a.MATCH_CONSTRAINT || zA2) {
                    if (!eVar3.t()) {
                        if (next2 == eVar3.U && eVar3.W.c == null) {
                            int iJ3 = eVar3.U.j() + iD2;
                            eVar3.b(iJ3, eVar3.L() + iJ3);
                            a(eVar3, interfaceC0050b);
                        } else if (next2 == eVar3.W && eVar3.U.c == null) {
                            int iJ4 = iD2 - eVar3.W.j();
                            eVar3.b(iJ4 - eVar3.L(), iJ4);
                            a(eVar3, interfaceC0050b);
                        } else if (z && !eVar3.an()) {
                            a(interfaceC0050b, eVar3);
                        }
                    }
                } else if (eVar3.ak() == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar3.N >= 0 && eVar3.M >= 0 && (eVar3.E() == 8 || (eVar3.H == 0 && eVar3.ac() == 0.0f))) {
                    if (!eVar3.an() && !eVar3.m() && z && !eVar3.an()) {
                        a(eVar, interfaceC0050b, eVar3);
                    }
                }
            }
        }
        androidx.d.c.b.d dVarA3 = eVar.a(androidx.d.c.b.d.a.BASELINE);
        if (dVarA3.a() == null || !dVarA3.f()) {
            return;
        }
        int iD3 = dVarA3.d();
        for (androidx.d.c.b.d dVar : dVarA3.a()) {
            androidx.d.c.b.e eVar4 = dVar.f678a;
            boolean zA3 = a(eVar4);
            if (eVar4.t() && zA3) {
                androidx.d.c.b.f.a(eVar4, interfaceC0050b, new b.a(), b.a.f660a);
            }
            if (eVar4.ak() != androidx.d.c.b.e.a.MATCH_CONSTRAINT || zA3) {
                if (!eVar4.t() && dVar == eVar4.X) {
                    eVar4.f(iD3);
                    a(eVar4, interfaceC0050b);
                }
            }
        }
    }

    private static void a(androidx.d.c.b.e eVar, b.InterfaceC0050b interfaceC0050b, androidx.d.c.b.e eVar2) {
        float fX = eVar2.X();
        int iD = eVar2.U.c.d() + eVar2.U.j();
        int iD2 = eVar2.W.c.d() - eVar2.W.j();
        if (iD2 >= iD) {
            int iL = eVar2.L();
            if (eVar2.E() != 8) {
                if (eVar2.H == 2) {
                    iL = (int) (fX * 0.5f * (eVar instanceof androidx.d.c.b.f ? eVar.L() : eVar.A().L()));
                } else if (eVar2.H == 0) {
                    iL = iD2 - iD;
                }
                iL = Math.max(eVar2.M, iL);
                if (eVar2.N > 0) {
                    iL = Math.min(eVar2.N, iL);
                }
            }
            int i = iD + ((int) ((fX * ((iD2 - iD) - iL)) + 0.5f));
            eVar2.b(i, iL + i);
            a(eVar2, interfaceC0050b);
        }
    }

    private static void a(androidx.d.c.b.e eVar, b.InterfaceC0050b interfaceC0050b, androidx.d.c.b.e eVar2, boolean z) {
        float fW = eVar2.W();
        int iD = eVar2.T.c.d() + eVar2.T.j();
        int iD2 = eVar2.V.c.d() - eVar2.V.j();
        if (iD2 >= iD) {
            int I = eVar2.I();
            if (eVar2.E() != 8) {
                if (eVar2.G == 2) {
                    I = (int) (eVar2.W() * 0.5f * (eVar instanceof androidx.d.c.b.f ? eVar.I() : eVar.A().I()));
                } else if (eVar2.G == 0) {
                    I = iD2 - iD;
                }
                I = Math.max(eVar2.J, I);
                if (eVar2.K > 0) {
                    I = Math.min(eVar2.K, I);
                }
            }
            int i = iD + ((int) ((fW * ((iD2 - iD) - I)) + 0.5f));
            eVar2.a(i, I + i);
            a(eVar2, interfaceC0050b, z);
        }
    }

    private static void a(androidx.d.c.b.e eVar, b.InterfaceC0050b interfaceC0050b, boolean z) {
        if (!(eVar instanceof androidx.d.c.b.f) && eVar.t() && a(eVar)) {
            androidx.d.c.b.f.a(eVar, interfaceC0050b, new b.a(), b.a.f660a);
        }
        androidx.d.c.b.d dVarA = eVar.a(androidx.d.c.b.d.a.LEFT);
        androidx.d.c.b.d dVarA2 = eVar.a(androidx.d.c.b.d.a.RIGHT);
        int iD = dVarA.d();
        int iD2 = dVarA2.d();
        if (dVarA.a() != null && dVarA.f()) {
            Iterator<androidx.d.c.b.d> it = dVarA.a().iterator();
            while (it.hasNext()) {
                androidx.d.c.b.d next = it.next();
                androidx.d.c.b.e eVar2 = next.f678a;
                boolean zA = a(eVar2);
                if (eVar2.t() && zA) {
                    androidx.d.c.b.f.a(eVar2, interfaceC0050b, new b.a(), b.a.f660a);
                }
                if (eVar2.aj() != androidx.d.c.b.e.a.MATCH_CONSTRAINT || zA) {
                    if (!eVar2.t()) {
                        if (next == eVar2.T && eVar2.V.c == null) {
                            int iJ = eVar2.T.j() + iD;
                            eVar2.a(iJ, eVar2.I() + iJ);
                            a(eVar2, interfaceC0050b, z);
                        } else if (next == eVar2.V && eVar2.T.c == null) {
                            int iJ2 = iD - eVar2.V.j();
                            eVar2.a(iJ2 - eVar2.I(), iJ2);
                            a(eVar2, interfaceC0050b, z);
                        } else if (next == eVar2.T && eVar2.V.c != null && eVar2.V.c.f() && !eVar2.al()) {
                            a(interfaceC0050b, eVar2, z);
                        }
                    }
                } else if (eVar2.aj() == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar2.K >= 0 && eVar2.J >= 0 && (eVar2.E() == 8 || (eVar2.G == 0 && eVar2.ac() == 0.0f))) {
                    if (!eVar2.al() && !eVar2.m()) {
                        if (((next == eVar2.T && eVar2.V.c != null && eVar2.V.c.f()) || (next == eVar2.V && eVar2.T.c != null && eVar2.T.c.f())) && !eVar2.al()) {
                            a(eVar, interfaceC0050b, eVar2, z);
                        }
                    }
                }
            }
        }
        if ((eVar instanceof androidx.d.c.b.h) || dVarA2.a() == null || !dVarA2.f()) {
            return;
        }
        Iterator<androidx.d.c.b.d> it2 = dVarA2.a().iterator();
        while (it2.hasNext()) {
            androidx.d.c.b.d next2 = it2.next();
            androidx.d.c.b.e eVar3 = next2.f678a;
            boolean zA2 = a(eVar3);
            if (eVar3.t() && zA2) {
                androidx.d.c.b.f.a(eVar3, interfaceC0050b, new b.a(), b.a.f660a);
            }
            boolean z2 = (next2 == eVar3.T && eVar3.V.c != null && eVar3.V.c.f()) || (next2 == eVar3.V && eVar3.T.c != null && eVar3.T.c.f());
            if (eVar3.aj() != androidx.d.c.b.e.a.MATCH_CONSTRAINT || zA2) {
                if (!eVar3.t()) {
                    if (next2 == eVar3.T && eVar3.V.c == null) {
                        int iJ3 = eVar3.T.j() + iD2;
                        eVar3.a(iJ3, eVar3.I() + iJ3);
                        a(eVar3, interfaceC0050b, z);
                    } else if (next2 == eVar3.V && eVar3.T.c == null) {
                        int iJ4 = iD2 - eVar3.V.j();
                        eVar3.a(iJ4 - eVar3.I(), iJ4);
                        a(eVar3, interfaceC0050b, z);
                    } else if (z2 && !eVar3.al()) {
                        a(interfaceC0050b, eVar3, z);
                    }
                }
            } else if (eVar3.aj() == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar3.K >= 0 && eVar3.J >= 0 && (eVar3.E() == 8 || (eVar3.G == 0 && eVar3.ac() == 0.0f))) {
                if (!eVar3.al() && !eVar3.m() && z2 && !eVar3.al()) {
                    a(eVar, interfaceC0050b, eVar3, z);
                }
            }
        }
    }

    public static void a(androidx.d.c.b.f fVar, b.InterfaceC0050b interfaceC0050b) {
        androidx.d.c.b.e.a aVarAj = fVar.aj();
        androidx.d.c.b.e.a aVarAk = fVar.ak();
        fVar.d_();
        ArrayList<androidx.d.c.b.e> arrayListAy = fVar.ay();
        int size = arrayListAy.size();
        for (int i = 0; i < size; i++) {
            arrayListAy.get(i).d_();
        }
        boolean zAs = fVar.as();
        if (aVarAj == androidx.d.c.b.e.a.FIXED) {
            fVar.a(0, fVar.I());
        } else {
            fVar.d(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.d.c.b.e eVar = arrayListAy.get(i2);
            if (eVar instanceof androidx.d.c.b.h) {
                androidx.d.c.b.h hVar = (androidx.d.c.b.h) eVar;
                if (hVar.f() == 1) {
                    if (hVar.h() != -1) {
                        hVar.E(hVar.h());
                    } else if (hVar.i() != -1 && fVar.d()) {
                        hVar.E(fVar.I() - hVar.i());
                    } else if (fVar.d()) {
                        hVar.E((int) ((hVar.g() * fVar.I()) + 0.5f));
                    }
                    z = true;
                }
            } else if ((eVar instanceof androidx.d.c.b.a) && ((androidx.d.c.b.a) eVar).h() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                androidx.d.c.b.e eVar2 = arrayListAy.get(i3);
                if (eVar2 instanceof androidx.d.c.b.h) {
                    androidx.d.c.b.h hVar2 = (androidx.d.c.b.h) eVar2;
                    if (hVar2.f() == 1) {
                        a(hVar2, interfaceC0050b, zAs);
                    }
                }
            }
        }
        a(fVar, interfaceC0050b, zAs);
        if (z2) {
            for (int i4 = 0; i4 < size; i4++) {
                androidx.d.c.b.e eVar3 = arrayListAy.get(i4);
                if (eVar3 instanceof androidx.d.c.b.a) {
                    androidx.d.c.b.a aVar = (androidx.d.c.b.a) eVar3;
                    if (aVar.h() == 0) {
                        a(aVar, interfaceC0050b, 0, zAs);
                    }
                }
            }
        }
        if (aVarAk == androidx.d.c.b.e.a.FIXED) {
            fVar.b(0, fVar.L());
        } else {
            fVar.e(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            androidx.d.c.b.e eVar4 = arrayListAy.get(i5);
            if (eVar4 instanceof androidx.d.c.b.h) {
                androidx.d.c.b.h hVar3 = (androidx.d.c.b.h) eVar4;
                if (hVar3.f() == 0) {
                    if (hVar3.h() != -1) {
                        hVar3.E(hVar3.h());
                    } else if (hVar3.i() != -1 && fVar.e()) {
                        hVar3.E(fVar.L() - hVar3.i());
                    } else if (fVar.e()) {
                        hVar3.E((int) ((hVar3.g() * fVar.L()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((eVar4 instanceof androidx.d.c.b.a) && ((androidx.d.c.b.a) eVar4).h() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i6 = 0; i6 < size; i6++) {
                androidx.d.c.b.e eVar5 = arrayListAy.get(i6);
                if (eVar5 instanceof androidx.d.c.b.h) {
                    androidx.d.c.b.h hVar4 = (androidx.d.c.b.h) eVar5;
                    if (hVar4.f() == 0) {
                        a(hVar4, interfaceC0050b);
                    }
                }
            }
        }
        a((androidx.d.c.b.e) fVar, interfaceC0050b);
        if (z4) {
            for (int i7 = 0; i7 < size; i7++) {
                androidx.d.c.b.e eVar6 = arrayListAy.get(i7);
                if (eVar6 instanceof androidx.d.c.b.a) {
                    androidx.d.c.b.a aVar2 = (androidx.d.c.b.a) eVar6;
                    if (aVar2.h() == 1) {
                        a(aVar2, interfaceC0050b, 1, zAs);
                    }
                }
            }
        }
        for (int i8 = 0; i8 < size; i8++) {
            androidx.d.c.b.e eVar7 = arrayListAy.get(i8);
            if (eVar7.t() && a(eVar7)) {
                androidx.d.c.b.f.a(eVar7, interfaceC0050b, c, b.a.f660a);
                a(eVar7, interfaceC0050b, zAs);
                a(eVar7, interfaceC0050b);
            }
        }
    }

    private static boolean a(androidx.d.c.b.e eVar) {
        androidx.d.c.b.e.a aVarAj = eVar.aj();
        androidx.d.c.b.e.a aVarAk = eVar.ak();
        androidx.d.c.b.f fVar = eVar.A() != null ? (androidx.d.c.b.f) eVar.A() : null;
        if (fVar != null) {
            fVar.aj();
            androidx.d.c.b.e.a aVar = androidx.d.c.b.e.a.FIXED;
        }
        if (fVar != null) {
            fVar.ak();
            androidx.d.c.b.e.a aVar2 = androidx.d.c.b.e.a.FIXED;
        }
        boolean z = aVarAj == androidx.d.c.b.e.a.FIXED || aVarAj == androidx.d.c.b.e.a.WRAP_CONTENT || (aVarAj == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.G == 0 && eVar.ao == 0.0f && eVar.g(0)) || eVar.d();
        boolean z2 = aVarAk == androidx.d.c.b.e.a.FIXED || aVarAk == androidx.d.c.b.e.a.WRAP_CONTENT || (aVarAk == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.H == 0 && eVar.ao == 0.0f && eVar.g(1)) || eVar.e();
        if (eVar.ao <= 0.0f || !(z || z2)) {
            return z && z2;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:106:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x01f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x01f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:115:0x021e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0243 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:119:0x0245 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x012b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0130  */
    /* JADX WARN: Code duplicated, block: B:81:0x013e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0147  */
    /* JADX WARN: Code duplicated, block: B:85:0x015a  */
    /* JADX WARN: Code duplicated, block: B:87:0x015e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0164  */
    /* JADX WARN: Code duplicated, block: B:91:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0172  */
    /* JADX WARN: Code duplicated, block: B:93:0x017d  */
    /* JADX WARN: Code duplicated, block: B:95:0x018b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0196  */
    /* JADX WARN: Code duplicated, block: B:98:0x01ab  */
    public static boolean a(androidx.d.c.b.f fVar, androidx.d.c.e eVar, int i, int i2, androidx.d.c.b.c cVar, boolean z, boolean z2, boolean z3) {
        int i3;
        int iJ;
        androidx.d.c.b.e eVar2;
        boolean z4;
        int iJ2;
        int iL;
        androidx.d.c.b.d dVar;
        androidx.d.c.b.e eVar3;
        float fX;
        int i4;
        if (z3) {
            return false;
        }
        if (i == 0) {
            if (!fVar.d()) {
                return false;
            }
        } else if (!fVar.e()) {
            return false;
        }
        boolean zAs = fVar.as();
        androidx.d.c.b.e eVarA = cVar.a();
        androidx.d.c.b.e eVarC = cVar.c();
        androidx.d.c.b.e eVarB = cVar.b();
        androidx.d.c.b.e eVarD = cVar.d();
        androidx.d.c.b.e eVarE = cVar.e();
        androidx.d.c.b.d dVar2 = eVarA.ag[i2];
        int i5 = i2 + 1;
        androidx.d.c.b.d dVar3 = eVarC.ag[i5];
        if (dVar2.c == null || dVar3.c == null) {
            return false;
        }
        if (!dVar2.c.f() || !dVar3.c.f()) {
            return false;
        }
        if (eVarB == null || eVarD == null) {
            return false;
        }
        int iD = dVar2.c.d() + eVarB.ag[i2].j();
        int iD2 = dVar3.c.d() - eVarD.ag[i5].j();
        int i6 = iD2 - iD;
        if (i6 <= 0) {
            return false;
        }
        b.a aVar = new b.a();
        boolean z5 = false;
        int i7 = 0;
        int I = 0;
        androidx.d.c.b.e eVar4 = eVarA;
        int i8 = 0;
        while (true) {
            androidx.d.c.b.e eVar5 = null;
            if (z5) {
                if (i8 == 0 || i8 != i7 || i6 < I) {
                    return false;
                }
                int i9 = i6 - I;
                if (!z) {
                    if (z2 && i8 > 2) {
                        i3 = 1;
                        i9 = (i9 / i8) - 1;
                    }
                    if (i8 == i3) {
                        if (i == 0) {
                            fX = eVarE.W();
                        } else {
                            fX = eVarE.X();
                        }
                        i4 = (int) (iD + 0.5f + (i9 * fX));
                        if (i == 0) {
                            eVarB.a(i4, eVarB.I() + i4);
                        } else {
                            eVarB.b(i4, eVarB.L() + i4);
                        }
                        a(eVarB, fVar.h(), zAs);
                        return true;
                    }
                    if (z) {
                        if (z2) {
                            return true;
                        }
                        if (i8 == 2) {
                            return false;
                        }
                        if (i == 0) {
                            eVarB.a(iD, eVarB.I() + iD);
                            eVarD.a(iD2 - eVarD.I(), iD2);
                            a(eVarB, fVar.h(), zAs);
                            a(eVarD, fVar.h(), zAs);
                            return true;
                        }
                        eVarB.b(iD, eVarB.L() + iD);
                        eVarD.b(iD2 - eVarD.L(), iD2);
                        a(eVarB, fVar.h());
                        a(eVarD, fVar.h());
                        return true;
                    }
                    iJ = iD + i9;
                    eVar2 = eVarA;
                    z4 = false;
                    while (!z4) {
                        androidx.d.c.b.d dVar4 = eVar2.ag[i2];
                        if (eVar2.E() == 8) {
                            iJ2 = iJ + eVar2.ag[i2].j();
                            if (i == 0) {
                                eVar2.a(iJ2, eVar2.I() + iJ2);
                                a(eVar2, fVar.h(), zAs);
                                iL = iJ2 + eVar2.I();
                            } else {
                                eVar2.b(iJ2, eVar2.L() + iJ2);
                                a(eVar2, fVar.h());
                                iL = iJ2 + eVar2.L();
                            }
                            iJ = iL + eVar2.ag[i5].j() + i9;
                        } else if (i == 0) {
                            eVar2.a(iJ, iJ);
                            a(eVar2, fVar.h(), zAs);
                        } else {
                            eVar2.b(iJ, iJ);
                            a(eVar2, fVar.h());
                        }
                        eVar2.a(eVar, false);
                        dVar = eVar2.ag[i5].c;
                        if (dVar != null) {
                            eVar3 = dVar.f678a;
                            if (eVar3.ag[i2].c != null || eVar3.ag[i2].c.f678a != eVar2) {
                                eVar3 = null;
                            }
                        } else {
                            eVar3 = null;
                        }
                        if (eVar3 != null) {
                            eVar2 = eVar3;
                        } else {
                            z4 = true;
                        }
                    }
                    return true;
                }
                i9 /= i8 + 1;
                i3 = 1;
                if (i8 == i3) {
                    if (i == 0) {
                        fX = eVarE.W();
                    } else {
                        fX = eVarE.X();
                    }
                    i4 = (int) (iD + 0.5f + (i9 * fX));
                    if (i == 0) {
                        eVarB.a(i4, eVarB.I() + i4);
                    } else {
                        eVarB.b(i4, eVarB.L() + i4);
                    }
                    a(eVarB, fVar.h(), zAs);
                    return true;
                }
                if (z) {
                    if (z2) {
                        return true;
                    }
                    if (i8 == 2) {
                        return false;
                    }
                    if (i == 0) {
                        eVarB.a(iD, eVarB.I() + iD);
                        eVarD.a(iD2 - eVarD.I(), iD2);
                        a(eVarB, fVar.h(), zAs);
                        a(eVarD, fVar.h(), zAs);
                        return true;
                    }
                    eVarB.b(iD, eVarB.L() + iD);
                    eVarD.b(iD2 - eVarD.L(), iD2);
                    a(eVarB, fVar.h());
                    a(eVarD, fVar.h());
                    return true;
                }
                iJ = iD + i9;
                eVar2 = eVarA;
                z4 = false;
                while (!z4) {
                    androidx.d.c.b.d dVar5 = eVar2.ag[i2];
                    if (eVar2.E() == 8) {
                        iJ2 = iJ + eVar2.ag[i2].j();
                        if (i == 0) {
                            eVar2.a(iJ2, eVar2.I() + iJ2);
                            a(eVar2, fVar.h(), zAs);
                            iL = iJ2 + eVar2.I();
                        } else {
                            eVar2.b(iJ2, eVar2.L() + iJ2);
                            a(eVar2, fVar.h());
                            iL = iJ2 + eVar2.L();
                        }
                        iJ = iL + eVar2.ag[i5].j() + i9;
                    } else if (i == 0) {
                        eVar2.a(iJ, iJ);
                        a(eVar2, fVar.h(), zAs);
                    } else {
                        eVar2.b(iJ, iJ);
                        a(eVar2, fVar.h());
                    }
                    eVar2.a(eVar, false);
                    dVar = eVar2.ag[i5].c;
                    if (dVar != null) {
                        eVar3 = dVar.f678a;
                        if (eVar3.ag[i2].c != null) {
                            eVar3 = null;
                        } else {
                            eVar3 = null;
                        }
                    } else {
                        eVar3 = null;
                    }
                    if (eVar3 != null) {
                        eVar2 = eVar3;
                    } else {
                        z4 = true;
                    }
                }
                return true;
            }
            androidx.d.c.b.d dVar6 = eVar4.ag[i2];
            if (!a(eVar4)) {
                return false;
            }
            boolean z6 = z5;
            if (eVar4.ak[i] == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                return false;
            }
            if (eVar4.t()) {
                androidx.d.c.b.f.a(eVar4, fVar.h(), aVar, b.a.f660a);
            }
            int iJ3 = I + eVar4.ag[i2].j();
            I = (i == 0 ? iJ3 + eVar4.I() : iJ3 + eVar4.L()) + eVar4.ag[i5].j();
            i7++;
            if (eVar4.E() != 8) {
                i8++;
            }
            androidx.d.c.b.d dVar7 = eVar4.ag[i5].c;
            if (dVar7 != null) {
                androidx.d.c.b.e eVar6 = dVar7.f678a;
                if (eVar6.ag[i2].c != null && eVar6.ag[i2].c.f678a == eVar4) {
                    eVar5 = eVar6;
                }
            }
            if (eVar5 != null) {
                eVar4 = eVar5;
                z5 = z6;
            } else {
                z5 = true;
            }
        }
    }
}
