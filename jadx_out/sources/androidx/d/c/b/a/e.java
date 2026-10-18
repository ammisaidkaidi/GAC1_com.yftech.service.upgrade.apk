package androidx.d.c.b.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final boolean b = true;
    private androidx.d.c.b.f c;
    private androidx.d.c.b.f f;
    private boolean d = b;
    private boolean e = b;
    private ArrayList<p> g = new ArrayList<>();
    private ArrayList<m> h = new ArrayList<>();
    private b.InterfaceC0050b i = null;
    private b.a j = new b.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<m> f662a = new ArrayList<>();

    public e(androidx.d.c.b.f fVar) {
        this.c = fVar;
        this.f = fVar;
    }

    private int a(androidx.d.c.b.f fVar, int i) {
        int size = this.f662a.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jMax = Math.max(jMax, this.f662a.get(i2).a(fVar, i));
        }
        return (int) jMax;
    }

    private String a(c cVar, String str) {
        int i = cVar.h;
        String str2 = "cluster_" + cVar.d.F();
        String str3 = "subgraph " + (i == 0 ? str2 + "_h" : str2 + "_v") + " {\n";
        String strA = com.yftech.service.upgrade.a.d;
        for (p pVar : cVar.f661a) {
            String strF = pVar.d.F();
            str3 = str3 + (i == 0 ? strF + "_HORIZONTAL" : strF + "_VERTICAL") + ";\n";
            strA = a(pVar, strA);
        }
        return str + strA + (str3 + "}\n");
    }

    private String a(f fVar, boolean z, String str) {
        for (f fVar2 : fVar.l) {
            String str2 = ("\n" + fVar.a()) + " -> " + fVar2.a();
            if (fVar.f > 0 || z || (fVar.d instanceof k)) {
                String str3 = str2 + "[";
                if (fVar.f > 0) {
                    str3 = str3 + "label=\"" + fVar.f + "\"";
                    if (z) {
                        str3 = str3 + ",";
                    }
                }
                if (z) {
                    str3 = str3 + " style=dashed ";
                }
                if (fVar.d instanceof k) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            str = str + (str2 + "\n");
        }
        return str;
    }

    private String a(p pVar) {
        String str;
        String str2;
        String str3;
        boolean z = pVar instanceof n;
        boolean z2 = z;
        String strF = pVar.d.F();
        androidx.d.c.b.e.a aVarAj = !z2 ? pVar.d.aj() : pVar.d.ak();
        m mVar = pVar.e;
        if (z2) {
            str = strF + "_VERTICAL";
        } else {
            str = strF + "_HORIZONTAL";
        }
        String str4 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
        if (z2) {
            String str5 = str4 + "    <TD ";
            if (pVar.j.j) {
                str5 = str5 + " BGCOLOR=\"green\"";
            }
            str2 = str5 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        } else {
            String str6 = str4 + "    <TD ";
            if (pVar.j.j) {
                str6 = str6 + " BGCOLOR=\"green\"";
            }
            str2 = str6 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        }
        String str7 = str2 + "    <TD BORDER=\"1\" ";
        if (pVar.g.j && !pVar.d.h) {
            str7 = str7 + " BGCOLOR=\"green\" ";
        } else if (pVar.g.j && pVar.d.h) {
            str7 = str7 + " BGCOLOR=\"lightgray\" ";
        } else if (!pVar.g.j && pVar.d.h) {
            str7 = str7 + " BGCOLOR=\"yellow\" ";
        }
        if (aVarAj == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
            str7 = str7 + "style=\"dashed\"";
        }
        String str8 = com.yftech.service.upgrade.a.d;
        if (mVar != null) {
            str8 = " [" + (mVar.j + 1) + "/" + m.d + "]";
        }
        String str9 = str7 + ">" + strF + str8 + " </TD>";
        if (z2) {
            String str10 = str9 + "    <TD ";
            if (z && ((n) pVar).f670a.j) {
                str10 = str10 + " BGCOLOR=\"green\"";
            }
            String str11 = (str10 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
            if (pVar.k.j) {
                str11 = str11 + " BGCOLOR=\"green\"";
            }
            str3 = str11 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        } else {
            String str12 = str9 + "    <TD ";
            if (pVar.k.j) {
                str12 = str12 + " BGCOLOR=\"green\"";
            }
            str3 = str12 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        }
        return (str3 + "  </TR></TABLE>") + ">];\n";
    }

    private String a(p pVar, String str) {
        boolean z;
        f fVar = pVar.j;
        f fVar2 = pVar.k;
        if (!(pVar instanceof k) && fVar.k.isEmpty() && (fVar2.k.isEmpty() && fVar.l.isEmpty()) && fVar2.l.isEmpty()) {
            return str;
        }
        String str2 = str + a(pVar);
        boolean zA = a(fVar, fVar2);
        String strA = a(fVar2, zA, a(fVar, zA, str2));
        boolean z2 = pVar instanceof n;
        if (z2) {
            strA = a(((n) pVar).f670a, zA, strA);
        }
        if ((pVar instanceof l) || (((z = pVar instanceof c)) && ((c) pVar).h == 0)) {
            androidx.d.c.b.e.a aVarAj = pVar.d.aj();
            if (aVarAj == androidx.d.c.b.e.a.FIXED || aVarAj == androidx.d.c.b.e.a.WRAP_CONTENT) {
                if (!fVar.l.isEmpty() && fVar2.l.isEmpty()) {
                    strA = strA + ("\n" + fVar2.a() + " -> " + fVar.a() + "\n");
                } else if (fVar.l.isEmpty() && !fVar2.l.isEmpty()) {
                    strA = strA + ("\n" + fVar.a() + " -> " + fVar2.a() + "\n");
                }
            } else if (aVarAj == androidx.d.c.b.e.a.MATCH_CONSTRAINT && pVar.d.ac() > 0.0f) {
                String strF = pVar.d.F();
                String str3 = "\n" + strF + "_HORIZONTAL -> " + strF + "_VERTICAL;\n";
            }
        } else if (z2 || (z && ((c) pVar).h == 1)) {
            androidx.d.c.b.e.a aVarAk = pVar.d.ak();
            if (aVarAk == androidx.d.c.b.e.a.FIXED || aVarAk == androidx.d.c.b.e.a.WRAP_CONTENT) {
                if (!fVar.l.isEmpty() && fVar2.l.isEmpty()) {
                    strA = strA + ("\n" + fVar2.a() + " -> " + fVar.a() + "\n");
                } else if (fVar.l.isEmpty() && !fVar2.l.isEmpty()) {
                    strA = strA + ("\n" + fVar.a() + " -> " + fVar2.a() + "\n");
                }
            } else if (aVarAk == androidx.d.c.b.e.a.MATCH_CONSTRAINT && pVar.d.ac() > 0.0f) {
                String strF2 = pVar.d.F();
                String str4 = "\n" + strF2 + "_VERTICAL -> " + strF2 + "_HORIZONTAL;\n";
            }
        }
        return pVar instanceof c ? a((c) pVar, strA) : strA;
    }

    private void a(f fVar, int i, int i2, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.d;
        if (pVar.e != null || pVar == this.c.l || pVar == this.c.m) {
            return;
        }
        if (mVar == null) {
            mVar = new m(pVar, i2);
            arrayList.add(mVar);
        }
        pVar.e = mVar;
        mVar.a(pVar);
        for (d dVar : pVar.j.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, fVar2, arrayList, mVar);
            }
        }
        for (d dVar2 : pVar.k.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, fVar2, arrayList, mVar);
            }
        }
        if (i == 1 && (pVar instanceof n)) {
            for (d dVar3 : ((n) pVar).f670a.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, fVar2, arrayList, mVar);
                }
            }
        }
        for (f fVar3 : pVar.j.l) {
            if (fVar3 == fVar2) {
                mVar.f = b;
            }
            a(fVar3, i, 0, fVar2, arrayList, mVar);
        }
        for (f fVar4 : pVar.k.l) {
            if (fVar4 == fVar2) {
                mVar.f = b;
            }
            a(fVar4, i, 1, fVar2, arrayList, mVar);
        }
        if (i == 1 && (pVar instanceof n)) {
            Iterator<f> it = ((n) pVar).f670a.l.iterator();
            while (it.hasNext()) {
                a(it.next(), i, 2, fVar2, arrayList, mVar);
            }
        }
    }

    private void a(p pVar, int i, ArrayList<m> arrayList) {
        for (d dVar : pVar.j.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, pVar.k, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).j, i, 0, pVar.k, arrayList, null);
            }
        }
        for (d dVar2 : pVar.k.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, pVar.j, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).k, i, 1, pVar.j, arrayList, null);
            }
        }
        if (i == 1) {
            for (d dVar3 : ((n) pVar).f670a.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    private void a(androidx.d.c.b.e eVar, androidx.d.c.b.e.a aVar, int i, androidx.d.c.b.e.a aVar2, int i2) {
        this.j.d = aVar;
        this.j.e = aVar2;
        this.j.f = i;
        this.j.g = i2;
        this.i.a(eVar, this.j);
        eVar.p(this.j.h);
        eVar.q(this.j.i);
        eVar.c(this.j.k);
        eVar.u(this.j.j);
    }

    private boolean a(f fVar, f fVar2) {
        Iterator<f> it = fVar.l.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != fVar2) {
                i++;
            }
        }
        Iterator<f> it2 = fVar2.l.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            if (it2.next() != fVar) {
                i2++;
            }
        }
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        return b;
    }

    private boolean a(androidx.d.c.b.f fVar) {
        int I;
        androidx.d.c.b.e.a aVar;
        int iL;
        for (androidx.d.c.b.e eVar : fVar.bq) {
            androidx.d.c.b.e.a aVar2 = eVar.ak[0];
            androidx.d.c.b.e.a aVar3 = eVar.ak[1];
            if (eVar.E() == 8) {
                eVar.h = b;
            } else {
                if (eVar.L < 1.0f && aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                    eVar.G = 2;
                }
                if (eVar.O < 1.0f && aVar3 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                    eVar.H = 2;
                }
                if (eVar.ac() > 0.0f) {
                    if (aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && (aVar3 == androidx.d.c.b.e.a.WRAP_CONTENT || aVar3 == androidx.d.c.b.e.a.FIXED)) {
                        eVar.G = 3;
                    } else if (aVar3 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && (aVar2 == androidx.d.c.b.e.a.WRAP_CONTENT || aVar2 == androidx.d.c.b.e.a.FIXED)) {
                        eVar.H = 3;
                    } else if (aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && aVar3 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                        if (eVar.G == 0) {
                            eVar.G = 3;
                        }
                        if (eVar.H == 0) {
                            eVar.H = 3;
                        }
                    }
                }
                if (aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.G == 1 && (eVar.T.c == null || eVar.V.c == null)) {
                    aVar2 = androidx.d.c.b.e.a.WRAP_CONTENT;
                }
                androidx.d.c.b.e.a aVar4 = aVar2;
                androidx.d.c.b.e.a aVar5 = (aVar3 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && eVar.H == 1 && (eVar.U.c == null || eVar.W.c == null)) ? androidx.d.c.b.e.a.WRAP_CONTENT : aVar3;
                eVar.l.f = aVar4;
                eVar.l.c = eVar.G;
                eVar.m.f = aVar5;
                eVar.m.c = eVar.H;
                if ((aVar4 == androidx.d.c.b.e.a.MATCH_PARENT || aVar4 == androidx.d.c.b.e.a.FIXED || aVar4 == androidx.d.c.b.e.a.WRAP_CONTENT) && (aVar5 == androidx.d.c.b.e.a.MATCH_PARENT || aVar5 == androidx.d.c.b.e.a.FIXED || aVar5 == androidx.d.c.b.e.a.WRAP_CONTENT)) {
                    int I2 = eVar.I();
                    if (aVar4 == androidx.d.c.b.e.a.MATCH_PARENT) {
                        I = (fVar.I() - eVar.T.d) - eVar.V.d;
                        aVar4 = androidx.d.c.b.e.a.FIXED;
                    } else {
                        I = I2;
                    }
                    int iL2 = eVar.L();
                    if (aVar5 == androidx.d.c.b.e.a.MATCH_PARENT) {
                        iL = (fVar.L() - eVar.U.d) - eVar.W.d;
                        aVar = androidx.d.c.b.e.a.FIXED;
                    } else {
                        aVar = aVar5;
                        iL = iL2;
                    }
                    a(eVar, aVar4, I, aVar, iL);
                    eVar.l.g.a(eVar.I());
                    eVar.m.g.a(eVar.L());
                    eVar.h = b;
                } else {
                    if (aVar4 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && (aVar5 == androidx.d.c.b.e.a.WRAP_CONTENT || aVar5 == androidx.d.c.b.e.a.FIXED)) {
                        if (eVar.G == 3) {
                            if (aVar5 == androidx.d.c.b.e.a.WRAP_CONTENT) {
                                a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, androidx.d.c.b.e.a.WRAP_CONTENT, 0);
                            }
                            int iL3 = eVar.L();
                            a(eVar, androidx.d.c.b.e.a.FIXED, (int) ((iL3 * eVar.ao) + 0.5f), androidx.d.c.b.e.a.FIXED, iL3);
                            eVar.l.g.a(eVar.I());
                            eVar.m.g.a(eVar.L());
                            eVar.h = b;
                        } else if (eVar.G == 1) {
                            a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, aVar5, 0);
                            eVar.l.g.m = eVar.I();
                        } else if (eVar.G == 2) {
                            if (fVar.ak[0] == androidx.d.c.b.e.a.FIXED || fVar.ak[0] == androidx.d.c.b.e.a.MATCH_PARENT) {
                                a(eVar, androidx.d.c.b.e.a.FIXED, (int) ((eVar.L * fVar.I()) + 0.5f), aVar5, eVar.L());
                                eVar.l.g.a(eVar.I());
                                eVar.m.g.a(eVar.L());
                                eVar.h = b;
                            }
                        } else if (eVar.ag[0].c == null || eVar.ag[1].c == null) {
                            a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, aVar5, 0);
                            eVar.l.g.a(eVar.I());
                            eVar.m.g.a(eVar.L());
                            eVar.h = b;
                        }
                    }
                    if (aVar5 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && (aVar4 == androidx.d.c.b.e.a.WRAP_CONTENT || aVar4 == androidx.d.c.b.e.a.FIXED)) {
                        if (eVar.H == 3) {
                            if (aVar4 == androidx.d.c.b.e.a.WRAP_CONTENT) {
                                a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, androidx.d.c.b.e.a.WRAP_CONTENT, 0);
                            }
                            int I3 = eVar.I();
                            float f = eVar.ao;
                            if (eVar.ad() == -1) {
                                f = 1.0f / f;
                            }
                            a(eVar, androidx.d.c.b.e.a.FIXED, I3, androidx.d.c.b.e.a.FIXED, (int) ((I3 * f) + 0.5f));
                            eVar.l.g.a(eVar.I());
                            eVar.m.g.a(eVar.L());
                            eVar.h = b;
                        } else if (eVar.H == 1) {
                            a(eVar, aVar4, 0, androidx.d.c.b.e.a.WRAP_CONTENT, 0);
                            eVar.m.g.m = eVar.L();
                        } else if (eVar.H == 2) {
                            if (fVar.ak[1] == androidx.d.c.b.e.a.FIXED || fVar.ak[1] == androidx.d.c.b.e.a.MATCH_PARENT) {
                                a(eVar, aVar4, eVar.I(), androidx.d.c.b.e.a.FIXED, (int) ((eVar.O * fVar.L()) + 0.5f));
                                eVar.l.g.a(eVar.I());
                                eVar.m.g.a(eVar.L());
                                eVar.h = b;
                            }
                        } else if (eVar.ag[2].c == null || eVar.ag[3].c == null) {
                            a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, aVar5, 0);
                            eVar.l.g.a(eVar.I());
                            eVar.m.g.a(eVar.L());
                            eVar.h = b;
                        }
                    }
                    if (aVar4 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && aVar5 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                        if (eVar.G == 1 || eVar.H == 1) {
                            a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, 0, androidx.d.c.b.e.a.WRAP_CONTENT, 0);
                            eVar.l.g.m = eVar.I();
                            eVar.m.g.m = eVar.L();
                        } else if (eVar.H == 2 && eVar.G == 2 && (fVar.ak[0] == androidx.d.c.b.e.a.FIXED || fVar.ak[0] == androidx.d.c.b.e.a.FIXED)) {
                            if (fVar.ak[1] == androidx.d.c.b.e.a.FIXED || fVar.ak[1] == androidx.d.c.b.e.a.FIXED) {
                                a(eVar, androidx.d.c.b.e.a.FIXED, (int) ((eVar.L * fVar.I()) + 0.5f), androidx.d.c.b.e.a.FIXED, (int) ((eVar.O * fVar.L()) + 0.5f));
                                eVar.l.g.a(eVar.I());
                                eVar.m.g.a(eVar.L());
                                eVar.h = b;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void e() {
        String strA = "digraph {\n";
        Iterator<p> it = this.g.iterator();
        while (it.hasNext()) {
            strA = a(it.next(), strA);
        }
        String str = strA + "\n}\n";
        System.out.println("content:<<\n" + str + "\n>>");
    }

    public void a() {
        for (androidx.d.c.b.e eVar : this.c.bq) {
            if (!eVar.h) {
                boolean z = false;
                androidx.d.c.b.e.a aVar = eVar.ak[0];
                androidx.d.c.b.e.a aVar2 = eVar.ak[1];
                int i = eVar.G;
                int i2 = eVar.H;
                boolean z2 = aVar == androidx.d.c.b.e.a.WRAP_CONTENT || (aVar == androidx.d.c.b.e.a.MATCH_CONSTRAINT && i == 1);
                if (aVar2 == androidx.d.c.b.e.a.WRAP_CONTENT || (aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                boolean z3 = eVar.l.g.j;
                boolean z4 = eVar.m.g.j;
                if (z3 && z4) {
                    a(eVar, androidx.d.c.b.e.a.FIXED, eVar.l.g.g, androidx.d.c.b.e.a.FIXED, eVar.m.g.g);
                    eVar.h = b;
                } else if (z3 && z) {
                    a(eVar, androidx.d.c.b.e.a.FIXED, eVar.l.g.g, androidx.d.c.b.e.a.WRAP_CONTENT, eVar.m.g.g);
                    if (aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                        eVar.m.g.m = eVar.L();
                    } else {
                        eVar.m.g.a(eVar.L());
                        eVar.h = b;
                    }
                } else if (z4 && z2) {
                    a(eVar, androidx.d.c.b.e.a.WRAP_CONTENT, eVar.l.g.g, androidx.d.c.b.e.a.FIXED, eVar.m.g.g);
                    if (aVar == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                        eVar.l.g.m = eVar.I();
                    } else {
                        eVar.l.g.a(eVar.I());
                        eVar.h = b;
                    }
                }
                if (eVar.h && eVar.m.b != null) {
                    eVar.m.b.a(eVar.Z());
                }
            }
        }
    }

    public void a(b.InterfaceC0050b interfaceC0050b) {
        this.i = interfaceC0050b;
    }

    public void a(androidx.d.c.b.e.a aVar, androidx.d.c.b.e.a aVar2) {
        if (this.d) {
            d();
            boolean z = false;
            for (androidx.d.c.b.e eVar : this.c.bq) {
                eVar.n[0] = b;
                eVar.n[1] = b;
                if (eVar instanceof androidx.d.c.b.a) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Iterator<m> it = this.f662a.iterator();
            while (it.hasNext()) {
                it.next().a(aVar == androidx.d.c.b.e.a.WRAP_CONTENT, aVar2 == androidx.d.c.b.e.a.WRAP_CONTENT);
            }
        }
    }

    public void a(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f.l.c();
        this.f.m.c();
        arrayList.add(this.f.l);
        arrayList.add(this.f.m);
        HashSet hashSet = null;
        for (androidx.d.c.b.e eVar : this.f.bq) {
            if (eVar instanceof androidx.d.c.b.h) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.al()) {
                    if (eVar.j == null) {
                        eVar.j = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.j);
                } else {
                    arrayList.add(eVar.l);
                }
                if (eVar.an()) {
                    if (eVar.k == null) {
                        eVar.k = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.k);
                } else {
                    arrayList.add(eVar.m);
                }
                if (eVar instanceof androidx.d.c.b.j) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        for (p pVar : arrayList) {
            if (pVar.d != this.f) {
                pVar.f();
            }
        }
    }

    public boolean a(boolean z) {
        boolean z2;
        boolean z3 = z & b;
        boolean z4 = false;
        if (this.d || this.e) {
            for (androidx.d.c.b.e eVar : this.c.bq) {
                eVar.y();
                eVar.h = false;
                eVar.l.d();
                eVar.m.d();
            }
            this.c.y();
            this.c.h = false;
            this.c.l.d();
            this.c.m.d();
            this.e = false;
        }
        if (a(this.f)) {
            return false;
        }
        this.c.n(0);
        this.c.o(0);
        androidx.d.c.b.e.a aVarY = this.c.y(0);
        androidx.d.c.b.e.a aVarY2 = this.c.y(1);
        if (this.d) {
            d();
        }
        int iG = this.c.G();
        int iH = this.c.H();
        this.c.l.j.a(iG);
        this.c.m.j.a(iH);
        a();
        if (aVarY == androidx.d.c.b.e.a.WRAP_CONTENT || aVarY2 == androidx.d.c.b.e.a.WRAP_CONTENT) {
            if (z3) {
                Iterator<p> it = this.g.iterator();
                while (it.hasNext()) {
                    if (!it.next().a()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3 && aVarY == androidx.d.c.b.e.a.WRAP_CONTENT) {
                this.c.a(androidx.d.c.b.e.a.FIXED);
                this.c.p(a(this.c, 0));
                this.c.l.g.a(this.c.I());
            }
            if (z3 && aVarY2 == androidx.d.c.b.e.a.WRAP_CONTENT) {
                this.c.b(androidx.d.c.b.e.a.FIXED);
                this.c.q(a(this.c, 1));
                this.c.m.g.a(this.c.L());
            }
        }
        if (this.c.ak[0] == androidx.d.c.b.e.a.FIXED || this.c.ak[0] == androidx.d.c.b.e.a.MATCH_PARENT) {
            int I = this.c.I() + iG;
            this.c.l.k.a(I);
            this.c.l.g.a(I - iG);
            a();
            if (this.c.ak[1] == androidx.d.c.b.e.a.FIXED || this.c.ak[1] == androidx.d.c.b.e.a.MATCH_PARENT) {
                int iL = this.c.L() + iH;
                this.c.m.k.a(iL);
                this.c.m.g.a(iL - iH);
            }
            a();
            z2 = true;
        } else {
            z2 = false;
        }
        for (p pVar : this.g) {
            if (pVar.d != this.c || pVar.i) {
                pVar.e();
            }
        }
        for (p pVar2 : this.g) {
            if (z2 || pVar2.d != this.c) {
                if (!pVar2.j.j || ((!pVar2.k.j && !(pVar2 instanceof j)) || (!pVar2.g.j && !(pVar2 instanceof c) && !(pVar2 instanceof j)))) {
                    this.c.a(aVarY);
                    this.c.b(aVarY2);
                    return z4;
                }
            }
        }
        z4 = true;
        this.c.a(aVarY);
        this.c.b(aVarY2);
        return z4;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00da  */
    public boolean a(boolean z, int i) {
        boolean z2;
        boolean z3 = z & b;
        boolean z4 = false;
        androidx.d.c.b.e.a aVarY = this.c.y(0);
        androidx.d.c.b.e.a aVarY2 = this.c.y(1);
        int iG = this.c.G();
        int iH = this.c.H();
        if (z3 && (aVarY == androidx.d.c.b.e.a.WRAP_CONTENT || aVarY2 == androidx.d.c.b.e.a.WRAP_CONTENT)) {
            for (p pVar : this.g) {
                if (pVar.h == i && !pVar.a()) {
                    z3 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z3 && aVarY == androidx.d.c.b.e.a.WRAP_CONTENT) {
                    this.c.a(androidx.d.c.b.e.a.FIXED);
                    this.c.p(a(this.c, 0));
                    this.c.l.g.a(this.c.I());
                }
            } else if (z3 && aVarY2 == androidx.d.c.b.e.a.WRAP_CONTENT) {
                this.c.b(androidx.d.c.b.e.a.FIXED);
                this.c.q(a(this.c, 1));
                this.c.m.g.a(this.c.L());
            }
        }
        if (i == 0) {
            if (this.c.ak[0] == androidx.d.c.b.e.a.FIXED || this.c.ak[0] == androidx.d.c.b.e.a.MATCH_PARENT) {
                int I = this.c.I() + iG;
                this.c.l.k.a(I);
                this.c.l.g.a(I - iG);
                z2 = true;
            } else {
                z2 = false;
            }
        } else if (this.c.ak[1] == androidx.d.c.b.e.a.FIXED || this.c.ak[1] == androidx.d.c.b.e.a.MATCH_PARENT) {
            int iL = this.c.L() + iH;
            this.c.m.k.a(iL);
            this.c.m.g.a(iL - iH);
            z2 = true;
        } else {
            z2 = false;
        }
        a();
        for (p pVar2 : this.g) {
            if (pVar2.h == i && (pVar2.d != this.c || pVar2.i)) {
                pVar2.e();
            }
        }
        for (p pVar3 : this.g) {
            if (pVar3.h == i && (z2 || pVar3.d != this.c)) {
                if (!pVar3.j.j || !pVar3.k.j || (!(pVar3 instanceof c) && !pVar3.g.j)) {
                    this.c.a(aVarY);
                    this.c.b(aVarY2);
                    return z4;
                }
            }
        }
        z4 = true;
        this.c.a(aVarY);
        this.c.b(aVarY2);
        return z4;
    }

    public void b() {
        this.d = b;
    }

    public boolean b(boolean z) {
        if (this.d) {
            for (androidx.d.c.b.e eVar : this.c.bq) {
                eVar.y();
                eVar.h = false;
                eVar.l.g.j = false;
                eVar.l.i = false;
                eVar.l.d();
                eVar.m.g.j = false;
                eVar.m.i = false;
                eVar.m.d();
            }
            this.c.y();
            this.c.h = false;
            this.c.l.g.j = false;
            this.c.l.i = false;
            this.c.l.d();
            this.c.m.g.j = false;
            this.c.m.i = false;
            this.c.m.d();
            d();
        }
        if (a(this.f)) {
            return false;
        }
        this.c.n(0);
        this.c.o(0);
        this.c.l.j.a(0);
        this.c.m.j.a(0);
        return b;
    }

    public void c() {
        this.e = b;
    }

    public void d() {
        a(this.g);
        this.f662a.clear();
        m.d = 0;
        a(this.c.l, 0, this.f662a);
        a(this.c.m, 1, this.f662a);
        this.d = false;
    }
}
