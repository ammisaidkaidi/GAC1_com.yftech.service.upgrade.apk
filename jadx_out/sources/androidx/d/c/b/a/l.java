package androidx.d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f667a = new int[2];

    public l(androidx.d.c.b.e eVar) {
        super(eVar);
        this.j.e = f.a.LEFT;
        this.k.e = f.a.RIGHT;
        this.h = 0;
    }

    private void a(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        switch (i5) {
            case -1:
                int i8 = (int) ((i7 * f) + 0.5f);
                int i9 = (int) ((i6 / f) + 0.5f);
                if (i8 <= i6 && i7 <= i7) {
                    iArr[0] = i8;
                    iArr[1] = i7;
                    break;
                } else if (i6 <= i6 && i9 <= i7) {
                    iArr[0] = i6;
                    iArr[1] = i9;
                    break;
                }
                break;
            case 0:
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                break;
            case 1:
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                break;
        }
    }

    @Override // androidx.d.c.b.a.p, androidx.d.c.b.a.d
    public void a(d dVar) {
        int iAc;
        switch (this.l) {
            case START:
                b(dVar);
                break;
            case END:
                c(dVar);
                break;
            case CENTER:
                a(dVar, this.d.T, this.d.V, 0);
                return;
        }
        if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
            switch (this.d.G) {
                case 2:
                    androidx.d.c.b.e eVarA = this.d.A();
                    if (eVarA != null && eVarA.l.g.j) {
                        this.g.a((int) ((eVarA.l.g.g * this.d.L) + 0.5f));
                    }
                    break;
                case 3:
                    if (this.d.H != 0 && this.d.H != 3) {
                        switch (this.d.ad()) {
                            case -1:
                                iAc = (int) ((this.d.m.g.g * this.d.ac()) + 0.5f);
                                break;
                            case 0:
                                iAc = (int) ((this.d.m.g.g / this.d.ac()) + 0.5f);
                                break;
                            case 1:
                                iAc = (int) ((this.d.m.g.g * this.d.ac()) + 0.5f);
                                break;
                            default:
                                iAc = 0;
                                break;
                        }
                        this.g.a(iAc);
                        break;
                    } else {
                        f fVar = this.d.m.j;
                        f fVar2 = this.d.m.k;
                        boolean z = this.d.T.c != null;
                        boolean z2 = this.d.U.c != null;
                        boolean z3 = this.d.V.c != null;
                        boolean z4 = this.d.W.c != null;
                        int iAd = this.d.ad();
                        if (z && z2 && z3 && z4) {
                            float fAc = this.d.ac();
                            if (fVar.j && fVar2.j) {
                                if (this.j.c && this.k.c) {
                                    a(f667a, this.j.l.get(0).g + this.j.f, this.k.l.get(0).g - this.k.f, fVar.g + fVar.f, fVar2.g - fVar2.f, fAc, iAd);
                                    this.g.a(f667a[0]);
                                    this.d.m.g.a(f667a[1]);
                                    return;
                                }
                                return;
                            }
                            if (this.j.j && this.k.j) {
                                if (!fVar.c || !fVar2.c) {
                                    return;
                                }
                                a(f667a, this.j.g + this.j.f, this.k.g - this.k.f, fVar.l.get(0).g + fVar.f, fVar2.l.get(0).g - fVar2.f, fAc, iAd);
                                this.g.a(f667a[0]);
                                this.d.m.g.a(f667a[1]);
                            }
                            if (!this.j.c || !this.k.c || !fVar.c || !fVar2.c) {
                                return;
                            }
                            a(f667a, this.j.l.get(0).g + this.j.f, this.k.l.get(0).g - this.k.f, fVar.l.get(0).g + fVar.f, fVar2.l.get(0).g - fVar2.f, fAc, iAd);
                            this.g.a(f667a[0]);
                            this.d.m.g.a(f667a[1]);
                            break;
                        } else if (z && z3) {
                            if (this.j.c && this.k.c) {
                                float fAc2 = this.d.ac();
                                int i = this.j.l.get(0).g + this.j.f;
                                int i2 = this.k.l.get(0).g - this.k.f;
                                switch (iAd) {
                                    case -1:
                                    case 0:
                                        int iA = a(i2 - i, 0);
                                        int i3 = (int) ((iA * fAc2) + 0.5f);
                                        int iA2 = a(i3, 1);
                                        if (i3 != iA2) {
                                            iA = (int) ((iA2 / fAc2) + 0.5f);
                                        }
                                        this.g.a(iA);
                                        this.d.m.g.a(iA2);
                                        break;
                                    case 1:
                                        int iA3 = a(i2 - i, 0);
                                        int i4 = (int) ((iA3 / fAc2) + 0.5f);
                                        int iA4 = a(i4, 1);
                                        if (i4 != iA4) {
                                            iA3 = (int) ((iA4 * fAc2) + 0.5f);
                                        }
                                        this.g.a(iA3);
                                        this.d.m.g.a(iA4);
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else if (z2 && z4) {
                            if (fVar.c && fVar2.c) {
                                float fAc3 = this.d.ac();
                                int i5 = fVar.l.get(0).g + fVar.f;
                                int i6 = fVar2.l.get(0).g - fVar2.f;
                                switch (iAd) {
                                    case -1:
                                    case 1:
                                        int iA5 = a(i6 - i5, 1);
                                        int i7 = (int) ((iA5 / fAc3) + 0.5f);
                                        int iA6 = a(i7, 0);
                                        if (i7 != iA6) {
                                            iA5 = (int) ((iA6 * fAc3) + 0.5f);
                                        }
                                        this.g.a(iA6);
                                        this.d.m.g.a(iA5);
                                        break;
                                    case 0:
                                        int iA7 = a(i6 - i5, 1);
                                        int i8 = (int) ((iA7 * fAc3) + 0.5f);
                                        int iA8 = a(i8, 0);
                                        if (i8 != iA8) {
                                            iA7 = (int) ((iA8 / fAc3) + 0.5f);
                                        }
                                        this.g.a(iA8);
                                        this.d.m.g.a(iA7);
                                        break;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    break;
            }
        }
        if (this.j.c && this.k.c) {
            if (this.j.j && this.k.j && this.g.j) {
                return;
            }
            if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.d.G == 0 && !this.d.al()) {
                f fVar3 = this.j.l.get(0);
                f fVar4 = this.k.l.get(0);
                int i9 = fVar3.g + this.j.f;
                int i10 = fVar4.g + this.k.f;
                this.j.a(i9);
                this.k.a(i10);
                this.g.a(i10 - i9);
                return;
            }
            if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.c == 1 && this.j.l.size() > 0 && this.k.l.size() > 0) {
                int iMin = Math.min((this.k.l.get(0).g + this.k.f) - (this.j.l.get(0).g + this.j.f), this.g.m);
                int i11 = this.d.K;
                int iMax = Math.max(this.d.J, iMin);
                if (i11 > 0) {
                    iMax = Math.min(i11, iMax);
                }
                this.g.a(iMax);
            }
            if (this.g.j) {
                f fVar5 = this.j.l.get(0);
                f fVar6 = this.k.l.get(0);
                int i12 = fVar5.g + this.j.f;
                int i13 = fVar6.g + this.k.f;
                float fW = this.d.W();
                if (fVar5 == fVar6) {
                    i12 = fVar5.g;
                    i13 = fVar6.g;
                    fW = 0.5f;
                }
                this.j.a((int) (i12 + 0.5f + (((i13 - i12) - this.g.g) * fW)));
                this.k.a(this.j.g + this.g.g);
            }
        }
    }

    @Override // androidx.d.c.b.a.p
    boolean a() {
        return this.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT || this.d.G == 0;
    }

    @Override // androidx.d.c.b.a.p
    void c() {
        this.e = null;
        this.j.b();
        this.k.b();
        this.g.b();
        this.i = false;
    }

    @Override // androidx.d.c.b.a.p
    void d() {
        this.i = false;
        this.j.b();
        this.j.j = false;
        this.k.b();
        this.k.j = false;
        this.g.j = false;
    }

    @Override // androidx.d.c.b.a.p
    public void e() {
        if (this.j.j) {
            this.d.n(this.j.g);
        }
    }

    @Override // androidx.d.c.b.a.p
    void f() {
        androidx.d.c.b.e eVarA;
        androidx.d.c.b.e eVarA2;
        if (this.d.h) {
            this.g.a(this.d.I());
        }
        if (!this.g.j) {
            this.f = this.d.aj();
            if (this.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                if (this.f == androidx.d.c.b.e.a.MATCH_PARENT && (((eVarA2 = this.d.A()) != null && eVarA2.aj() == androidx.d.c.b.e.a.FIXED) || eVarA2.aj() == androidx.d.c.b.e.a.MATCH_PARENT)) {
                    int I = (eVarA2.I() - this.d.T.j()) - this.d.V.j();
                    a(this.j, eVarA2.l.j, this.d.T.j());
                    a(this.k, eVarA2.l.k, -this.d.V.j());
                    this.g.a(I);
                    return;
                }
                if (this.f == androidx.d.c.b.e.a.FIXED) {
                    this.g.a(this.d.I());
                }
            }
        } else if (this.f == androidx.d.c.b.e.a.MATCH_PARENT && (((eVarA = this.d.A()) != null && eVarA.aj() == androidx.d.c.b.e.a.FIXED) || eVarA.aj() == androidx.d.c.b.e.a.MATCH_PARENT)) {
            a(this.j, eVarA.l.j, this.d.T.j());
            a(this.k, eVarA.l.k, -this.d.V.j());
            return;
        }
        if (this.g.j && this.d.h) {
            if (this.d.ag[0].c != null && this.d.ag[1].c != null) {
                if (this.d.al()) {
                    this.j.f = this.d.ag[0].j();
                    this.k.f = -this.d.ag[1].j();
                    return;
                }
                f fVarA = a(this.d.ag[0]);
                if (fVarA != null) {
                    a(this.j, fVarA, this.d.ag[0].j());
                }
                f fVarA2 = a(this.d.ag[1]);
                if (fVarA2 != null) {
                    a(this.k, fVarA2, -this.d.ag[1].j());
                }
                this.j.b = true;
                this.k.b = true;
                return;
            }
            if (this.d.ag[0].c != null) {
                f fVarA3 = a(this.d.ag[0]);
                if (fVarA3 != null) {
                    a(this.j, fVarA3, this.d.ag[0].j());
                    a(this.k, this.j, this.g.g);
                    return;
                }
                return;
            }
            if (this.d.ag[1].c != null) {
                f fVarA4 = a(this.d.ag[1]);
                if (fVarA4 != null) {
                    a(this.k, fVarA4, -this.d.ag[1].j());
                    a(this.j, this.k, -this.g.g);
                    return;
                }
                return;
            }
            if ((this.d instanceof androidx.d.c.b.i) || this.d.A() == null || this.d.a(androidx.d.c.b.d.a.CENTER).c != null) {
                return;
            }
            a(this.j, this.d.A().l.j, this.d.G());
            a(this.k, this.j, this.g.g);
            return;
        }
        if (this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
            switch (this.d.G) {
                case 2:
                    androidx.d.c.b.e eVarA3 = this.d.A();
                    if (eVarA3 != null) {
                        g gVar = eVarA3.m.g;
                        this.g.l.add(gVar);
                        gVar.k.add(this.g);
                        this.g.b = true;
                        this.g.k.add(this.j);
                        this.g.k.add(this.k);
                    }
                    break;
                case 3:
                    if (this.d.H != 3) {
                        g gVar2 = this.d.m.g;
                        this.g.l.add(gVar2);
                        gVar2.k.add(this.g);
                        this.d.m.j.k.add(this.g);
                        this.d.m.k.k.add(this.g);
                        this.g.b = true;
                        this.g.k.add(this.j);
                        this.g.k.add(this.k);
                        this.j.l.add(this.g);
                        this.k.l.add(this.g);
                    } else {
                        this.j.f663a = this;
                        this.k.f663a = this;
                        this.d.m.j.f663a = this;
                        this.d.m.k.f663a = this;
                        this.g.f663a = this;
                        if (this.d.an()) {
                            this.g.l.add(this.d.m.g);
                            this.d.m.g.k.add(this.g);
                            this.d.m.g.f663a = this;
                            this.g.l.add(this.d.m.j);
                            this.g.l.add(this.d.m.k);
                            this.d.m.j.k.add(this.g);
                            this.d.m.k.k.add(this.g);
                        } else if (!this.d.al()) {
                            this.d.m.g.l.add(this.g);
                        } else {
                            this.d.m.g.l.add(this.g);
                            this.g.k.add(this.d.m.g);
                        }
                    }
                    break;
            }
        }
        if (this.d.ag[0].c != null && this.d.ag[1].c != null) {
            if (this.d.al()) {
                this.j.f = this.d.ag[0].j();
                this.k.f = -this.d.ag[1].j();
                return;
            }
            f fVarA5 = a(this.d.ag[0]);
            f fVarA6 = a(this.d.ag[1]);
            fVarA5.b(this);
            fVarA6.b(this);
            this.l = p.a.CENTER;
            return;
        }
        if (this.d.ag[0].c != null) {
            f fVarA7 = a(this.d.ag[0]);
            if (fVarA7 != null) {
                a(this.j, fVarA7, this.d.ag[0].j());
                a(this.k, this.j, 1, this.g);
                return;
            }
            return;
        }
        if (this.d.ag[1].c != null) {
            f fVarA8 = a(this.d.ag[1]);
            if (fVarA8 != null) {
                a(this.k, fVarA8, -this.d.ag[1].j());
                a(this.j, this.k, -1, this.g);
                return;
            }
            return;
        }
        if ((this.d instanceof androidx.d.c.b.i) || this.d.A() == null) {
            return;
        }
        a(this.j, this.d.A().l.j, this.d.G());
        a(this.k, this.j, 1, this.g);
    }

    public String toString() {
        return "HorizontalRun " + this.d.F();
    }
}
