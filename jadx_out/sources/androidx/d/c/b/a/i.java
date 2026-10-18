package androidx.d.c.b.a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f666a = false;
    private static final boolean b = false;

    public static o a(androidx.d.c.b.e eVar, int i, ArrayList<o> arrayList, o oVar) {
        int iM;
        int i2 = i == 0 ? eVar.aW : eVar.aX;
        if (i2 != -1 && (oVar == null || i2 != oVar.c)) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                o oVar2 = arrayList.get(i3);
                if (oVar2.b() == i2) {
                    if (oVar != null) {
                        oVar.a(i, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                    break;
                }
            }
        } else if (i2 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof androidx.d.c.b.j) && (iM = ((androidx.d.c.b.j) eVar).M(i)) != -1) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    o oVar3 = arrayList.get(i4);
                    if (oVar3.b() == iM) {
                        oVar = oVar3;
                        break;
                    }
                }
            }
            if (oVar == null) {
                oVar = new o(i);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof androidx.d.c.b.h) {
                androidx.d.c.b.h hVar = (androidx.d.c.b.h) eVar;
                hVar.c().a(hVar.f() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i == 0) {
                eVar.aW = oVar.b();
                eVar.T.a(i, arrayList, oVar);
                eVar.V.a(i, arrayList, oVar);
            } else {
                eVar.aX = oVar.b();
                eVar.U.a(i, arrayList, oVar);
                eVar.X.a(i, arrayList, oVar);
                eVar.W.a(i, arrayList, oVar);
            }
            eVar.aa.a(i, arrayList, oVar);
        }
        return oVar;
    }

    private static o a(ArrayList<o> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = arrayList.get(i2);
            if (i == oVar.c) {
                return oVar;
            }
        }
        return null;
    }

    public static boolean a(androidx.d.c.b.e.a aVar, androidx.d.c.b.e.a aVar2, androidx.d.c.b.e.a aVar3, androidx.d.c.b.e.a aVar4) {
        return (aVar3 == androidx.d.c.b.e.a.FIXED || aVar3 == androidx.d.c.b.e.a.WRAP_CONTENT || (aVar3 == androidx.d.c.b.e.a.MATCH_PARENT && aVar != androidx.d.c.b.e.a.WRAP_CONTENT)) || (aVar4 == androidx.d.c.b.e.a.FIXED || aVar4 == androidx.d.c.b.e.a.WRAP_CONTENT || (aVar4 == androidx.d.c.b.e.a.MATCH_PARENT && aVar2 != androidx.d.c.b.e.a.WRAP_CONTENT));
    }

    /* JADX WARN: Code duplicated, block: B:179:0x0349  */
    public static boolean a(androidx.d.c.b.f fVar, b.InterfaceC0050b interfaceC0050b) {
        o oVar;
        boolean z;
        o oVar2;
        ArrayList<androidx.d.c.b.e> arrayListAy = fVar.ay();
        int size = arrayListAy.size();
        for (int i = 0; i < size; i++) {
            androidx.d.c.b.e eVar = arrayListAy.get(i);
            if (!a(fVar.aj(), fVar.ak(), eVar.aj(), eVar.ak()) || (eVar instanceof androidx.d.c.b.g)) {
                return false;
            }
        }
        if (fVar.e != null) {
            fVar.e.Q++;
        }
        ArrayList arrayList = null;
        ArrayList<androidx.d.c.b.j> arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList<androidx.d.c.b.j> arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        for (int i2 = 0; i2 < size; i2++) {
            androidx.d.c.b.e eVar2 = arrayListAy.get(i2);
            if (!a(fVar.aj(), fVar.ak(), eVar2.aj(), eVar2.ak())) {
                androidx.d.c.b.f.a(eVar2, interfaceC0050b, fVar.bo, b.a.f660a);
            }
            boolean z2 = eVar2 instanceof androidx.d.c.b.h;
            if (z2) {
                androidx.d.c.b.h hVar = (androidx.d.c.b.h) eVar2;
                if (hVar.f() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(hVar);
                }
                if (hVar.f() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(hVar);
                }
            }
            if (eVar2 instanceof androidx.d.c.b.j) {
                if (eVar2 instanceof androidx.d.c.b.a) {
                    androidx.d.c.b.a aVar = (androidx.d.c.b.a) eVar2;
                    if (aVar.h() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.h() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    androidx.d.c.b.j jVar = (androidx.d.c.b.j) eVar2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(jVar);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(jVar);
                }
            }
            if (eVar2.T.c == null && eVar2.V.c == null && !z2 && !(eVar2 instanceof androidx.d.c.b.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(eVar2);
            }
            if (eVar2.U.c == null && eVar2.W.c == null && eVar2.X.c == null && !z2 && !(eVar2 instanceof androidx.d.c.b.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(eVar2);
            }
        }
        ArrayList<o> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((androidx.d.c.b.h) it.next(), 0, arrayList7, (o) null);
            }
        }
        o oVar3 = null;
        int i3 = 0;
        if (arrayList2 != null) {
            for (androidx.d.c.b.j jVar2 : arrayList2) {
                o oVarA = a(jVar2, i3, arrayList7, oVar3);
                jVar2.a(arrayList7, i3, oVarA);
                oVarA.a(arrayList7);
                oVar3 = null;
                i3 = 0;
            }
        }
        androidx.d.c.b.d dVarA = fVar.a(androidx.d.c.b.d.a.LEFT);
        if (dVarA.a() != null) {
            Iterator<androidx.d.c.b.d> it2 = dVarA.a().iterator();
            while (it2.hasNext()) {
                a(it2.next().f678a, 0, arrayList7, (o) null);
            }
        }
        androidx.d.c.b.d dVarA2 = fVar.a(androidx.d.c.b.d.a.RIGHT);
        if (dVarA2.a() != null) {
            Iterator<androidx.d.c.b.d> it3 = dVarA2.a().iterator();
            while (it3.hasNext()) {
                a(it3.next().f678a, 0, arrayList7, (o) null);
            }
        }
        androidx.d.c.b.d dVarA3 = fVar.a(androidx.d.c.b.d.a.CENTER);
        if (dVarA3.a() != null) {
            Iterator<androidx.d.c.b.d> it4 = dVarA3.a().iterator();
            while (it4.hasNext()) {
                a(it4.next().f678a, 0, arrayList7, (o) null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                a((androidx.d.c.b.e) it5.next(), 0, arrayList7, (o) null);
            }
        }
        if (arrayList3 != null) {
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a((androidx.d.c.b.h) it6.next(), 1, arrayList7, (o) null);
            }
        }
        if (arrayList4 != null) {
            for (androidx.d.c.b.j jVar3 : arrayList4) {
                o oVarA2 = a(jVar3, 1, arrayList7, oVar4);
                jVar3.a(arrayList7, 1, oVarA2);
                oVarA2.a(arrayList7);
                oVar4 = null;
            }
        }
        androidx.d.c.b.d dVarA4 = fVar.a(androidx.d.c.b.d.a.TOP);
        if (dVarA4.a() != null) {
            Iterator<androidx.d.c.b.d> it7 = dVarA4.a().iterator();
            while (it7.hasNext()) {
                a(it7.next().f678a, 1, arrayList7, (o) null);
            }
        }
        androidx.d.c.b.d dVarA5 = fVar.a(androidx.d.c.b.d.a.BASELINE);
        if (dVarA5.a() != null) {
            Iterator<androidx.d.c.b.d> it8 = dVarA5.a().iterator();
            while (it8.hasNext()) {
                a(it8.next().f678a, 1, arrayList7, (o) null);
            }
        }
        androidx.d.c.b.d dVarA6 = fVar.a(androidx.d.c.b.d.a.BOTTOM);
        if (dVarA6.a() != null) {
            Iterator<androidx.d.c.b.d> it9 = dVarA6.a().iterator();
            while (it9.hasNext()) {
                a(it9.next().f678a, 1, arrayList7, (o) null);
            }
        }
        androidx.d.c.b.d dVarA7 = fVar.a(androidx.d.c.b.d.a.CENTER);
        if (dVarA7.a() != null) {
            Iterator<androidx.d.c.b.d> it10 = dVarA7.a().iterator();
            while (it10.hasNext()) {
                a(it10.next().f678a, 1, arrayList7, (o) null);
            }
        }
        if (arrayList6 != null) {
            Iterator it11 = arrayList6.iterator();
            while (it11.hasNext()) {
                a((androidx.d.c.b.e) it11.next(), 1, arrayList7, (o) null);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            androidx.d.c.b.e eVar3 = arrayListAy.get(i4);
            if (eVar3.x()) {
                o oVarA3 = a(arrayList7, eVar3.aW);
                o oVarA4 = a(arrayList7, eVar3.aX);
                if (oVarA3 != null && oVarA4 != null) {
                    oVarA3.a(0, oVarA4);
                    oVarA4.a(2);
                    arrayList7.remove(oVarA3);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (fVar.aj() == androidx.d.c.b.e.a.WRAP_CONTENT) {
            oVar = null;
            int i5 = 0;
            for (o oVar5 : arrayList7) {
                if (oVar5.a() != 1) {
                    oVar5.a(false);
                    int iA = oVar5.a(fVar.ax(), 0);
                    if (iA > i5) {
                        oVar = oVar5;
                        i5 = iA;
                    }
                }
            }
            if (oVar != null) {
                fVar.a(androidx.d.c.b.e.a.FIXED);
                fVar.p(i5);
                oVar.a(true);
            } else {
                oVar = null;
            }
        } else {
            oVar = null;
        }
        if (fVar.ak() == androidx.d.c.b.e.a.WRAP_CONTENT) {
            oVar2 = null;
            int i6 = 0;
            for (o oVar6 : arrayList7) {
                if (oVar6.a() != 0) {
                    oVar6.a(false);
                    int iA2 = oVar6.a(fVar.ax(), 1);
                    if (iA2 > i6) {
                        oVar2 = oVar6;
                        i6 = iA2;
                    }
                }
            }
            z = false;
            if (oVar2 != null) {
                fVar.b(androidx.d.c.b.e.a.FIXED);
                fVar.q(i6);
                oVar2.a(true);
            }
            if (oVar != null && oVar2 == null) {
                return z;
            }
        }
        z = false;
        oVar2 = null;
        return oVar != null ? true : true;
    }
}
