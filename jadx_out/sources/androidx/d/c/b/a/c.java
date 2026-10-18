package androidx.d.c.b.a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<p> f661a;
    private int b;

    public c(androidx.d.c.b.e eVar, int i) {
        super(eVar);
        this.f661a = new ArrayList<>();
        this.h = i;
        j();
    }

    private void j() {
        androidx.d.c.b.e eVar;
        androidx.d.c.b.e eVar2 = this.d;
        androidx.d.c.b.e eVarZ = eVar2.z(this.h);
        while (true) {
            androidx.d.c.b.e eVar3 = eVarZ;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            } else {
                eVarZ = eVar2.z(this.h);
            }
        }
        this.d = eVar;
        this.f661a.add(eVar.c(this.h));
        androidx.d.c.b.e eVarA = eVar.A(this.h);
        while (eVarA != null) {
            this.f661a.add(eVarA.c(this.h));
            eVarA = eVarA.A(this.h);
        }
        for (p pVar : this.f661a) {
            if (this.h == 0) {
                pVar.d.j = this;
            } else if (this.h == 1) {
                pVar.d.k = this;
            }
        }
        if ((this.h == 0 && ((androidx.d.c.b.f) this.d.A()).as()) && this.f661a.size() > 1) {
            this.d = this.f661a.get(this.f661a.size() - 1).d;
        }
        this.b = this.h == 0 ? this.d.af() : this.d.ag();
    }

    private androidx.d.c.b.e k() {
        for (int i = 0; i < this.f661a.size(); i++) {
            p pVar = this.f661a.get(i);
            if (pVar.d.E() != 8) {
                return pVar.d;
            }
        }
        return null;
    }

    private androidx.d.c.b.e l() {
        for (int size = this.f661a.size() - 1; size >= 0; size--) {
            p pVar = this.f661a.get(size);
            if (pVar.d.E() != 8) {
                return pVar.d;
            }
        }
        return null;
    }

    @Override // androidx.d.c.b.a.p, androidx.d.c.b.a.d
    public void a(d dVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        int iMin;
        if (this.j.j && this.k.j) {
            androidx.d.c.b.e eVarA = this.d.A();
            boolean zAs = (eVarA == null || !(eVarA instanceof androidx.d.c.b.f)) ? false : ((androidx.d.c.b.f) eVarA).as();
            int i11 = this.k.g - this.j.g;
            int size = this.f661a.size();
            int i12 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i12 >= size) {
                    i12 = -1;
                    break;
                } else if (this.f661a.get(i12).d.E() != 8) {
                    break;
                } else {
                    i12++;
                }
            }
            int i13 = size - 1;
            for (int i14 = i13; i14 >= 0; i14--) {
                if (this.f661a.get(i14).d.E() != 8) {
                    i = i14;
                    break;
                }
            }
            int i15 = 0;
            while (true) {
                if (i15 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i16 = 0;
                i4 = 0;
                i5 = 0;
                int i17 = 0;
                f = 0.0f;
                while (i16 < size) {
                    p pVar = this.f661a.get(i16);
                    if (pVar.d.E() != i2) {
                        i5++;
                        if (i16 > 0 && i16 >= i12) {
                            i4 += pVar.j.f;
                        }
                        int i18 = pVar.g.g;
                        boolean z = pVar.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT;
                        if (!z) {
                            if (pVar.c == 1 && i15 == 0) {
                                i18 = pVar.g.m;
                                i17++;
                            } else if (pVar.g.j) {
                            }
                            z = true;
                        } else {
                            if (this.h == 0 && !pVar.d.l.g.j) {
                                return;
                            }
                            if (this.h == 1 && !pVar.d.m.g.j) {
                                return;
                            }
                        }
                        if (z) {
                            i4 += i18;
                        } else {
                            i17++;
                            float f3 = pVar.d.aR[this.h];
                            if (f3 >= 0.0f) {
                                f += f3;
                            }
                        }
                        if (i16 < i13 && i16 < i) {
                            i4 += -pVar.k.f;
                        }
                    }
                    i16++;
                    i2 = 8;
                }
                if (i4 < i11 || i17 == 0) {
                    i3 = i17;
                    break;
                } else {
                    i15++;
                    i2 = 8;
                }
            }
            int i19 = this.j.g;
            if (zAs) {
                i19 = this.k.g;
            }
            if (i4 > i11) {
                i19 = zAs ? i19 + ((int) (((i4 - i11) / 2.0f) + 0.5f)) : i19 - ((int) (((i4 - i11) / 2.0f) + 0.5f));
            }
            if (i3 > 0) {
                float f4 = i11 - i4;
                int i20 = (int) ((f4 / i3) + 0.5f);
                int i21 = 0;
                int i22 = 0;
                while (i21 < size) {
                    p pVar2 = this.f661a.get(i21);
                    int i23 = i20;
                    if (pVar2.d.E() == 8 || pVar2.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT || pVar2.g.j) {
                        i9 = i19;
                        f2 = f4;
                        i10 = i4;
                    } else {
                        int i24 = f > 0.0f ? (int) (((pVar2.d.aR[this.h] * f4) / f) + 0.5f) : i23;
                        if (this.h == 0) {
                            int i25 = pVar2.d.K;
                            f2 = f4;
                            i10 = i4;
                            i9 = i19;
                            iMin = Math.max(pVar2.d.J, pVar2.c == 1 ? Math.min(i24, pVar2.g.m) : i24);
                            if (i25 > 0) {
                                iMin = Math.min(i25, iMin);
                            }
                            if (iMin != i24) {
                                i22++;
                                i24 = iMin;
                            }
                        } else {
                            i9 = i19;
                            f2 = f4;
                            i10 = i4;
                            int i26 = pVar2.d.N;
                            int iMax = Math.max(pVar2.d.M, pVar2.c == 1 ? Math.min(i24, pVar2.g.m) : i24);
                            iMin = i26 > 0 ? Math.min(i26, iMax) : iMax;
                            if (iMin != i24) {
                                i22++;
                                i24 = iMin;
                            }
                        }
                        pVar2.g.a(i24);
                    }
                    i21++;
                    i20 = i23;
                    f4 = f2;
                    i4 = i10;
                    i19 = i9;
                }
                i6 = i19;
                int i27 = i4;
                if (i22 > 0) {
                    i3 -= i22;
                    int i28 = 0;
                    for (int i29 = 0; i29 < size; i29++) {
                        p pVar3 = this.f661a.get(i29);
                        if (pVar3.d.E() != 8) {
                            if (i29 > 0 && i29 >= i12) {
                                i28 += pVar3.j.f;
                            }
                            i28 += pVar3.g.g;
                            if (i29 < i13 && i29 < i) {
                                i28 += -pVar3.k.f;
                            }
                        }
                    }
                    i4 = i28;
                } else {
                    i4 = i27;
                }
                i8 = 2;
                if (this.b == 2 && i22 == 0) {
                    i7 = 0;
                    this.b = 0;
                } else {
                    i7 = 0;
                }
            } else {
                i6 = i19;
                i7 = 0;
                i8 = 2;
            }
            if (i4 > i11) {
                this.b = i8;
            }
            if (i5 > 0 && i3 == 0 && i12 == i) {
                this.b = i8;
            }
            if (this.b == 1) {
                int i30 = i5 > 1 ? (i11 - i4) / (i5 - 1) : i5 == 1 ? (i11 - i4) / 2 : i7;
                if (i3 > 0) {
                    i30 = i7;
                }
                int i31 = i6;
                while (i7 < size) {
                    p pVar4 = this.f661a.get(zAs ? size - (i7 + 1) : i7);
                    if (pVar4.d.E() == 8) {
                        pVar4.j.a(i31);
                        pVar4.k.a(i31);
                    } else {
                        if (i7 > 0) {
                            i31 = zAs ? i31 - i30 : i31 + i30;
                        }
                        if (i7 > 0 && i7 >= i12) {
                            i31 = zAs ? i31 - pVar4.j.f : i31 + pVar4.j.f;
                        }
                        if (zAs) {
                            pVar4.k.a(i31);
                        } else {
                            pVar4.j.a(i31);
                        }
                        int i32 = pVar4.g.g;
                        if (pVar4.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && pVar4.c == 1) {
                            i32 = pVar4.g.m;
                        }
                        i31 = zAs ? i31 - i32 : i31 + i32;
                        if (zAs) {
                            pVar4.j.a(i31);
                        } else {
                            pVar4.k.a(i31);
                        }
                        pVar4.i = true;
                        if (i7 < i13 && i7 < i) {
                            i31 = zAs ? i31 - (-pVar4.k.f) : i31 + (-pVar4.k.f);
                        }
                    }
                    i7++;
                }
                return;
            }
            if (this.b == 0) {
                int i33 = (i11 - i4) / (i5 + 1);
                if (i3 > 0) {
                    i33 = i7;
                }
                int i34 = i6;
                while (i7 < size) {
                    p pVar5 = this.f661a.get(zAs ? size - (i7 + 1) : i7);
                    if (pVar5.d.E() == 8) {
                        pVar5.j.a(i34);
                        pVar5.k.a(i34);
                    } else {
                        int i35 = zAs ? i34 - i33 : i34 + i33;
                        if (i7 > 0 && i7 >= i12) {
                            i35 = zAs ? i35 - pVar5.j.f : i35 + pVar5.j.f;
                        }
                        if (zAs) {
                            pVar5.k.a(i35);
                        } else {
                            pVar5.j.a(i35);
                        }
                        int iMin2 = pVar5.g.g;
                        if (pVar5.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && pVar5.c == 1) {
                            iMin2 = Math.min(iMin2, pVar5.g.m);
                        }
                        i34 = zAs ? i35 - iMin2 : i35 + iMin2;
                        if (zAs) {
                            pVar5.j.a(i34);
                        } else {
                            pVar5.k.a(i34);
                        }
                        if (i7 < i13 && i7 < i) {
                            i34 = zAs ? i34 - (-pVar5.k.f) : i34 + (-pVar5.k.f);
                        }
                    }
                    i7++;
                }
                return;
            }
            if (this.b == 2) {
                float fW = this.h == 0 ? this.d.W() : this.d.X();
                if (zAs) {
                    fW = 1.0f - fW;
                }
                int i36 = (int) (((i11 - i4) * fW) + 0.5f);
                if (i36 < 0 || i3 > 0) {
                    i36 = i7;
                }
                int i37 = zAs ? i6 - i36 : i6 + i36;
                while (i7 < size) {
                    p pVar6 = this.f661a.get(zAs ? size - (i7 + 1) : i7);
                    if (pVar6.d.E() == 8) {
                        pVar6.j.a(i37);
                        pVar6.k.a(i37);
                    } else {
                        if (i7 > 0 && i7 >= i12) {
                            i37 = zAs ? i37 - pVar6.j.f : i37 + pVar6.j.f;
                        }
                        if (zAs) {
                            pVar6.k.a(i37);
                        } else {
                            pVar6.j.a(i37);
                        }
                        int i38 = pVar6.g.g;
                        if (pVar6.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && pVar6.c == 1) {
                            i38 = pVar6.g.m;
                        }
                        i37 = zAs ? i37 - i38 : i37 + i38;
                        if (zAs) {
                            pVar6.j.a(i37);
                        } else {
                            pVar6.k.a(i37);
                        }
                        if (i7 < i13 && i7 < i) {
                            i37 = zAs ? i37 - (-pVar6.k.f) : i37 + (-pVar6.k.f);
                        }
                    }
                    i7++;
                }
            }
        }
    }

    @Override // androidx.d.c.b.a.p
    boolean a() {
        int size = this.f661a.size();
        for (int i = 0; i < size; i++) {
            if (!this.f661a.get(i).a()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.d.c.b.a.p
    public long b() {
        int size = this.f661a.size();
        long jB = 0;
        for (int i = 0; i < size; i++) {
            p pVar = this.f661a.get(i);
            jB = jB + ((long) pVar.j.f) + pVar.b() + ((long) pVar.k.f);
        }
        return jB;
    }

    @Override // androidx.d.c.b.a.p
    void c() {
        this.e = null;
        Iterator<p> it = this.f661a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // androidx.d.c.b.a.p
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    @Override // androidx.d.c.b.a.p
    public void e() {
        for (int i = 0; i < this.f661a.size(); i++) {
            this.f661a.get(i).e();
        }
    }

    @Override // androidx.d.c.b.a.p
    void f() {
        Iterator<p> it = this.f661a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        int size = this.f661a.size();
        if (size < 1) {
            return;
        }
        androidx.d.c.b.e eVar = this.f661a.get(0).d;
        androidx.d.c.b.e eVar2 = this.f661a.get(size - 1).d;
        if (this.h == 0) {
            androidx.d.c.b.d dVar = eVar.T;
            androidx.d.c.b.d dVar2 = eVar2.V;
            f fVarA = a(dVar, 0);
            int iJ = dVar.j();
            androidx.d.c.b.e eVarK = k();
            if (eVarK != null) {
                iJ = eVarK.T.j();
            }
            if (fVarA != null) {
                a(this.j, fVarA, iJ);
            }
            f fVarA2 = a(dVar2, 0);
            int iJ2 = dVar2.j();
            androidx.d.c.b.e eVarL = l();
            if (eVarL != null) {
                iJ2 = eVarL.V.j();
            }
            if (fVarA2 != null) {
                a(this.k, fVarA2, -iJ2);
            }
        } else {
            androidx.d.c.b.d dVar3 = eVar.U;
            androidx.d.c.b.d dVar4 = eVar2.W;
            f fVarA3 = a(dVar3, 1);
            int iJ3 = dVar3.j();
            androidx.d.c.b.e eVarK2 = k();
            if (eVarK2 != null) {
                iJ3 = eVarK2.U.j();
            }
            if (fVarA3 != null) {
                a(this.j, fVarA3, iJ3);
            }
            f fVarA4 = a(dVar4, 1);
            int iJ4 = dVar4.j();
            androidx.d.c.b.e eVarL2 = l();
            if (eVarL2 != null) {
                iJ4 = eVarL2.W.j();
            }
            if (fVarA4 != null) {
                a(this.k, fVarA4, -iJ4);
            }
        }
        this.j.f663a = this;
        this.k.f663a = this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.h == 0 ? "horizontal : " : "vertical : ");
        String string = sb.toString();
        Iterator<p> it = this.f661a.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + it.next()) + "> ";
        }
        return string;
    }
}
