package androidx.d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {
    public int c;
    androidx.d.c.b.e d;
    m e;
    protected androidx.d.c.b.e.a f;
    g g = new g(this);
    public int h = 0;
    boolean i = false;
    public f j = new f(this);
    public f k = new f(this);
    protected a l = a.NONE;

    enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public p(androidx.d.c.b.e eVar) {
        this.d = eVar;
    }

    private void b(int i, int i2) {
        switch (this.c) {
            case 0:
                this.g.a(a(i2, i));
                break;
            case 1:
                this.g.a(Math.min(a(this.g.m, i), i2));
                break;
            case 2:
                androidx.d.c.b.e eVarA = this.d.A();
                if (eVarA != null) {
                    p pVar = i == 0 ? eVarA.l : eVarA.m;
                    if (pVar.g.j) {
                        this.g.a(a((int) ((pVar.g.g * (i == 0 ? this.d.L : this.d.O)) + 0.5f), i));
                    }
                }
                break;
            case 3:
                if (this.d.l.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT || this.d.l.c != 3 || this.d.m.f != androidx.d.c.b.e.a.MATCH_CONSTRAINT || this.d.m.c != 3) {
                    p pVar2 = i == 0 ? this.d.m : this.d.l;
                    if (pVar2.g.j) {
                        float fAc = this.d.ac();
                        this.g.a(i == 1 ? (int) ((pVar2.g.g / fAc) + 0.5f) : (int) ((fAc * pVar2.g.g) + 0.5f));
                    }
                }
                break;
        }
    }

    protected final int a(int i, int i2) {
        int iMax;
        if (i2 == 0) {
            int i3 = this.d.K;
            iMax = Math.max(this.d.J, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax == i) {
                return i;
            }
        } else {
            int i4 = this.d.N;
            iMax = Math.max(this.d.M, i);
            if (i4 > 0) {
                iMax = Math.min(i4, i);
            }
            if (iMax == i) {
                return i;
            }
        }
        return iMax;
    }

    public long a(int i) {
        if (!this.g.j) {
            return 0L;
        }
        long j = this.g.g;
        if (h()) {
            return j + ((long) (this.j.f - this.k.f));
        }
        return i == 0 ? j + ((long) this.j.f) : j - ((long) this.k.f);
    }

    protected final f a(androidx.d.c.b.d dVar) {
        if (dVar.c == null) {
            return null;
        }
        androidx.d.c.b.e eVar = dVar.c.f678a;
        switch (dVar.c.b) {
            case LEFT:
                return eVar.l.j;
            case RIGHT:
                return eVar.l.k;
            case TOP:
                return eVar.m.j;
            case BASELINE:
                return eVar.m.f670a;
            case BOTTOM:
                return eVar.m.k;
            default:
                return null;
        }
    }

    protected final f a(androidx.d.c.b.d dVar, int i) {
        if (dVar.c == null) {
            return null;
        }
        androidx.d.c.b.e eVar = dVar.c.f678a;
        p pVar = i == 0 ? eVar.l : eVar.m;
        int i2 = AnonymousClass1.f674a[dVar.c.b.ordinal()];
        if (i2 != 5) {
            switch (i2) {
                case 1:
                case 3:
                    return pVar.j;
                case 2:
                    break;
                default:
                    return null;
            }
        }
        return pVar.k;
    }

    @Override // androidx.d.c.b.a.d
    public void a(d dVar) {
    }

    protected void a(d dVar, androidx.d.c.b.d dVar2, androidx.d.c.b.d dVar3, int i) {
        f fVarA = a(dVar2);
        f fVarA2 = a(dVar3);
        if (fVarA.j && fVarA2.j) {
            int iJ = fVarA.g + dVar2.j();
            int iJ2 = fVarA2.g - dVar3.j();
            int i2 = iJ2 - iJ;
            if (!this.g.j && this.f == androidx.d.c.b.e.a.MATCH_CONSTRAINT) {
                b(i, i2);
            }
            if (this.g.j) {
                if (this.g.g == i2) {
                    this.j.a(iJ);
                    this.k.a(iJ2);
                    return;
                }
                float fW = i == 0 ? this.d.W() : this.d.X();
                if (fVarA == fVarA2) {
                    iJ = fVarA.g;
                    iJ2 = fVarA2.g;
                    fW = 0.5f;
                }
                this.j.a((int) (iJ + 0.5f + (((iJ2 - iJ) - this.g.g) * fW)));
                this.k.a(this.j.g + this.g.g);
            }
        }
    }

    protected final void a(f fVar, f fVar2, int i) {
        fVar.l.add(fVar2);
        fVar.f = i;
        fVar2.k.add(fVar);
    }

    protected final void a(f fVar, f fVar2, int i, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.g);
        fVar.h = i;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    abstract boolean a();

    public long b() {
        if (this.g.j) {
            return this.g.g;
        }
        return 0L;
    }

    protected void b(d dVar) {
    }

    abstract void c();

    protected void c(d dVar) {
    }

    abstract void d();

    abstract void e();

    abstract void f();

    public boolean g() {
        return this.g.j;
    }

    public boolean h() {
        int size = this.j.l.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.j.l.get(i2).d != this) {
                i++;
            }
        }
        int size2 = this.k.l.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (this.k.l.get(i3).d != this) {
                i++;
            }
        }
        return i >= 2;
    }

    public boolean i() {
        return this.i;
    }
}
