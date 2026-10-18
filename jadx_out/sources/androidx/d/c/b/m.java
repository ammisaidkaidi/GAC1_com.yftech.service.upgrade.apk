package androidx.d.c.b;

/* JADX INFO: loaded from: classes.dex */
public class m extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f691a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int aY = 0;
    private int aZ = 0;
    private int ba = 0;
    private boolean bb = false;
    private int bc = 0;
    private int bh = 0;
    protected androidx.d.c.b.a.b.a bf = new androidx.d.c.b.a.b.a();
    androidx.d.c.b.a.b.InterfaceC0050b bg = null;

    public void N(int i) {
        this.c = i;
        this.f691a = i;
        this.d = i;
        this.b = i;
        this.e = i;
        this.aY = i;
    }

    public void O(int i) {
        this.e = i;
        this.aZ = i;
        this.ba = i;
    }

    public void P(int i) {
        this.aY = i;
    }

    public void Q(int i) {
        this.c = i;
        this.aZ = i;
    }

    public void R(int i) {
        this.f691a = i;
    }

    public void S(int i) {
        this.d = i;
        this.ba = i;
    }

    public void T(int i) {
        this.b = i;
    }

    protected void a(e eVar, e.a aVar, int i, e.a aVar2, int i2) {
        while (this.bg == null && A() != null) {
            this.bg = ((f) A()).h();
        }
        this.bf.d = aVar;
        this.bf.e = aVar2;
        this.bf.f = i;
        this.bf.g = i2;
        this.bg.a(eVar, this.bf);
        eVar.p(this.bf.h);
        eVar.q(this.bf.i);
        eVar.c(this.bf.k);
        eVar.u(this.bf.j);
    }

    @Override // androidx.d.c.b.j, androidx.d.c.b.i
    public void a(f fVar) {
        i();
    }

    public void a(boolean z) {
        if (this.e > 0 || this.aY > 0) {
            if (z) {
                this.aZ = this.aY;
                this.ba = this.e;
            } else {
                this.aZ = this.e;
                this.ba = this.aY;
            }
        }
    }

    public int aq() {
        return this.bc;
    }

    public int ar() {
        return this.bh;
    }

    protected boolean as() {
        androidx.d.c.b.a.b.InterfaceC0050b interfaceC0050bH = this.al != null ? ((f) this.al).h() : null;
        if (interfaceC0050bH == null) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.be) {
                return true;
            }
            e eVar = this.bd[i];
            if (eVar != null && !(eVar instanceof h)) {
                e.a aVarY = eVar.y(0);
                e.a aVarY2 = eVar.y(1);
                if (!(aVarY == e.a.MATCH_CONSTRAINT && eVar.G != 1 && aVarY2 == e.a.MATCH_CONSTRAINT && eVar.H != 1)) {
                    if (aVarY == e.a.MATCH_CONSTRAINT) {
                        aVarY = e.a.WRAP_CONTENT;
                    }
                    if (aVarY2 == e.a.MATCH_CONSTRAINT) {
                        aVarY2 = e.a.WRAP_CONTENT;
                    }
                    this.bf.d = aVarY;
                    this.bf.e = aVarY2;
                    this.bf.f = eVar.I();
                    this.bf.g = eVar.L();
                    interfaceC0050bH.a(eVar, this.bf);
                    eVar.p(this.bf.h);
                    eVar.q(this.bf.i);
                    eVar.u(this.bf.j);
                }
            }
            i++;
        }
    }

    public int b() {
        return this.f691a;
    }

    public void b(int i, int i2, int i3, int i4) {
    }

    public int c() {
        return this.b;
    }

    public int f() {
        return this.aZ;
    }

    public int g() {
        return this.ba;
    }

    protected void h(boolean z) {
        this.bb = z;
    }

    public boolean h() {
        return this.bb;
    }

    public void i() {
        for (int i = 0; i < this.be; i++) {
            e eVar = this.bd[i];
            if (eVar != null) {
                eVar.b(true);
            }
        }
    }

    public void k(int i, int i2) {
        this.bc = i;
        this.bh = i2;
    }
}
