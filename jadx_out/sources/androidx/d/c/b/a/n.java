package androidx.d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f670a;
    g b;

    public n(androidx.d.c.b.e eVar) {
        super(eVar);
        this.f670a = new f(this);
        this.b = null;
        this.j.e = f.a.TOP;
        this.k.e = f.a.BOTTOM;
        this.f670a.e = f.a.BASELINE;
        this.h = 1;
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
                a(dVar, this.d.U, this.d.W, 1);
                return;
        }
        if (this.g.c && !this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
            switch (this.d.H) {
                case 2:
                    androidx.d.c.b.e eVarA = this.d.A();
                    if (eVarA != null && eVarA.m.g.j) {
                        this.g.a((int) ((eVarA.m.g.g * this.d.O) + 0.5f));
                    }
                    break;
                case 3:
                    if (this.d.l.g.j) {
                        switch (this.d.ad()) {
                            case -1:
                                iAc = (int) ((this.d.l.g.g / this.d.ac()) + 0.5f);
                                break;
                            case 0:
                                iAc = (int) ((this.d.l.g.g * this.d.ac()) + 0.5f);
                                break;
                            case 1:
                                iAc = (int) ((this.d.l.g.g / this.d.ac()) + 0.5f);
                                break;
                            default:
                                iAc = 0;
                                break;
                        }
                        this.g.a(iAc);
                    }
                    break;
            }
        }
        if (this.j.c && this.k.c) {
            if (this.j.j && this.k.j && this.g.j) {
                return;
            }
            if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.d.G == 0 && !this.d.an()) {
                f fVar = this.j.l.get(0);
                f fVar2 = this.k.l.get(0);
                int i = fVar.g + this.j.f;
                int i2 = fVar2.g + this.k.f;
                this.j.a(i);
                this.k.a(i2);
                this.g.a(i2 - i);
                return;
            }
            if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.c == 1 && this.j.l.size() > 0 && this.k.l.size() > 0) {
                int i3 = (this.k.l.get(0).g + this.k.f) - (this.j.l.get(0).g + this.j.f);
                if (i3 < this.g.m) {
                    this.g.a(i3);
                } else {
                    this.g.a(this.g.m);
                }
            }
            if (this.g.j && this.j.l.size() > 0 && this.k.l.size() > 0) {
                f fVar3 = this.j.l.get(0);
                f fVar4 = this.k.l.get(0);
                int i4 = fVar3.g + this.j.f;
                int i5 = fVar4.g + this.k.f;
                float fX = this.d.X();
                if (fVar3 == fVar4) {
                    i4 = fVar3.g;
                    i5 = fVar4.g;
                    fX = 0.5f;
                }
                this.j.a((int) (i4 + 0.5f + (((i5 - i4) - this.g.g) * fX)));
                this.k.a(this.j.g + this.g.g);
            }
        }
    }

    @Override // androidx.d.c.b.a.p
    boolean a() {
        return this.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT || this.d.H == 0;
    }

    @Override // androidx.d.c.b.a.p
    void c() {
        this.e = null;
        this.j.b();
        this.k.b();
        this.f670a.b();
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
        this.f670a.b();
        this.f670a.j = false;
        this.g.j = false;
    }

    @Override // androidx.d.c.b.a.p
    public void e() {
        if (this.j.j) {
            this.d.o(this.j.g);
        }
    }

    @Override // androidx.d.c.b.a.p
    void f() {
        androidx.d.c.b.e eVarA;
        androidx.d.c.b.e eVarA2;
        if (this.d.h) {
            this.g.a(this.d.L());
        }
        if (!this.g.j) {
            this.f = this.d.ak();
            if (this.d.Y()) {
                this.b = new a(this);
            }
            if (this.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                if (this.f == androidx.d.c.b.e.a.MATCH_PARENT && (eVarA2 = this.d.A()) != null && eVarA2.ak() == androidx.d.c.b.e.a.FIXED) {
                    int iL = (eVarA2.L() - this.d.U.j()) - this.d.W.j();
                    a(this.j, eVarA2.m.j, this.d.U.j());
                    a(this.k, eVarA2.m.k, -this.d.W.j());
                    this.g.a(iL);
                    return;
                }
                if (this.f == androidx.d.c.b.e.a.FIXED) {
                    this.g.a(this.d.L());
                }
            }
        } else if (this.f == androidx.d.c.b.e.a.MATCH_PARENT && (eVarA = this.d.A()) != null && eVarA.ak() == androidx.d.c.b.e.a.FIXED) {
            a(this.j, eVarA.m.j, this.d.U.j());
            a(this.k, eVarA.m.k, -this.d.W.j());
            return;
        }
        if (this.g.j && this.d.h) {
            if (this.d.ag[2].c != null && this.d.ag[3].c != null) {
                if (this.d.an()) {
                    this.j.f = this.d.ag[2].j();
                    this.k.f = -this.d.ag[3].j();
                } else {
                    f fVarA = a(this.d.ag[2]);
                    if (fVarA != null) {
                        a(this.j, fVarA, this.d.ag[2].j());
                    }
                    f fVarA2 = a(this.d.ag[3]);
                    if (fVarA2 != null) {
                        a(this.k, fVarA2, -this.d.ag[3].j());
                    }
                    this.j.b = true;
                    this.k.b = true;
                }
                if (this.d.Y()) {
                    a(this.f670a, this.j, this.d.Z());
                    return;
                }
                return;
            }
            if (this.d.ag[2].c != null) {
                f fVarA3 = a(this.d.ag[2]);
                if (fVarA3 != null) {
                    a(this.j, fVarA3, this.d.ag[2].j());
                    a(this.k, this.j, this.g.g);
                    if (this.d.Y()) {
                        a(this.f670a, this.j, this.d.Z());
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.d.ag[3].c != null) {
                f fVarA4 = a(this.d.ag[3]);
                if (fVarA4 != null) {
                    a(this.k, fVarA4, -this.d.ag[3].j());
                    a(this.j, this.k, -this.g.g);
                }
                if (this.d.Y()) {
                    a(this.f670a, this.j, this.d.Z());
                    return;
                }
                return;
            }
            if (this.d.ag[4].c != null) {
                f fVarA5 = a(this.d.ag[4]);
                if (fVarA5 != null) {
                    a(this.f670a, fVarA5, 0);
                    a(this.j, this.f670a, -this.d.Z());
                    a(this.k, this.j, this.g.g);
                    return;
                }
                return;
            }
            if ((this.d instanceof androidx.d.c.b.i) || this.d.A() == null || this.d.a(androidx.d.c.b.d.a.CENTER).c != null) {
                return;
            }
            a(this.j, this.d.A().m.j, this.d.H());
            a(this.k, this.j, this.g.g);
            if (this.d.Y()) {
                a(this.f670a, this.j, this.d.Z());
                return;
            }
            return;
        }
        if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
            switch (this.d.H) {
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
                    if (!this.d.an() && this.d.G != 3) {
                        g gVar2 = this.d.l.g;
                        this.g.l.add(gVar2);
                        gVar2.k.add(this.g);
                        this.g.b = true;
                        this.g.k.add(this.j);
                        this.g.k.add(this.k);
                    }
                    break;
            }
        } else {
            this.g.b(this);
        }
        if (this.d.ag[2].c != null && this.d.ag[3].c != null) {
            if (this.d.an()) {
                this.j.f = this.d.ag[2].j();
                this.k.f = -this.d.ag[3].j();
            } else {
                f fVarA6 = a(this.d.ag[2]);
                f fVarA7 = a(this.d.ag[3]);
                fVarA6.b(this);
                fVarA7.b(this);
                this.l = p.a.CENTER;
            }
            if (this.d.Y()) {
                a(this.f670a, this.j, 1, this.b);
            }
        } else if (this.d.ag[2].c != null) {
            f fVarA8 = a(this.d.ag[2]);
            if (fVarA8 != null) {
                a(this.j, fVarA8, this.d.ag[2].j());
                a(this.k, this.j, 1, this.g);
                if (this.d.Y()) {
                    a(this.f670a, this.j, 1, this.b);
                }
                if (this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.d.ac() > 0.0f && this.d.l.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                    this.d.l.g.k.add(this.g);
                    this.g.l.add(this.d.l.g);
                    this.g.f663a = this;
                }
            }
        } else if (this.d.ag[3].c != null) {
            f fVarA9 = a(this.d.ag[3]);
            if (fVarA9 != null) {
                a(this.k, fVarA9, -this.d.ag[3].j());
                a(this.j, this.k, -1, this.g);
                if (this.d.Y()) {
                    a(this.f670a, this.j, 1, this.b);
                }
            }
        } else if (this.d.ag[4].c != null) {
            f fVarA10 = a(this.d.ag[4]);
            if (fVarA10 != null) {
                a(this.f670a, fVarA10, 0);
                a(this.j, this.f670a, -1, this.b);
                a(this.k, this.j, 1, this.g);
            }
        } else if (!(this.d instanceof androidx.d.c.b.i) && this.d.A() != null) {
            a(this.j, this.d.A().m.j, this.d.H());
            a(this.k, this.j, 1, this.g);
            if (this.d.Y()) {
                a(this.f670a, this.j, 1, this.b);
            }
            if (this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT && this.d.ac() > 0.0f && this.d.l.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                this.d.l.g.k.add(this.g);
                this.g.l.add(this.d.l.g);
                this.g.f663a = this;
            }
        }
        if (this.g.l.size() == 0) {
            this.g.c = true;
        }
    }

    public String toString() {
        return "VerticalRun " + this.d.F();
    }
}
