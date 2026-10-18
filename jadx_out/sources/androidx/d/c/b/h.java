package androidx.d.c.b;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f687a = 0;
    public static final int aY = -1;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    protected float aZ = -1.0f;
    protected int ba = -1;
    protected int bb = -1;
    private d bc = this.U;
    private int bd = 0;
    private int be = 0;
    private boolean bf;

    public h() {
        this.ah.clear();
        this.ah.add(this.bc);
        int length = this.ag.length;
        for (int i = 0; i < length; i++) {
            this.ag[i] = this.bc;
        }
    }

    public void B(int i) {
        e(i / 100.0f);
    }

    public void C(int i) {
        if (i > -1) {
            this.aZ = -1.0f;
            this.ba = i;
            this.bb = -1;
        }
    }

    @Override // androidx.d.c.b.e
    public String D() {
        return "Guideline";
    }

    public void D(int i) {
        if (i > -1) {
            this.aZ = -1.0f;
            this.ba = -1;
            this.bb = i;
        }
    }

    public void E(int i) {
        this.bc.a(i);
        this.bf = true;
    }

    @Override // androidx.d.c.b.e
    public d a(d.a aVar) {
        switch (aVar) {
            case LEFT:
            case RIGHT:
                if (this.bd == 1) {
                    return this.bc;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.bd == 0) {
                    return this.bc;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(aVar.name());
    }

    public void a(int i) {
        if (this.bd == i) {
            return;
        }
        this.bd = i;
        this.ah.clear();
        if (this.bd == 1) {
            this.bc = this.T;
        } else {
            this.bc = this.U;
        }
        this.ah.add(this.bc);
        int length = this.ag.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.ag[i2] = this.bc;
        }
    }

    @Override // androidx.d.c.b.e
    public void a(e eVar, HashMap<e, e> map) {
        super.a(eVar, map);
        h hVar = (h) eVar;
        this.aZ = hVar.aZ;
        this.ba = hVar.ba;
        this.bb = hVar.bb;
        a(hVar.bd);
    }

    @Override // androidx.d.c.b.e
    public void a(androidx.d.c.e eVar, boolean z) {
        f fVar = (f) A();
        if (fVar == null) {
            return;
        }
        d dVarA = fVar.a(d.a.LEFT);
        d dVarA2 = fVar.a(d.a.RIGHT);
        boolean z2 = this.al != null && this.al.ak[0] == e.a.WRAP_CONTENT;
        if (this.bd == 0) {
            dVarA = fVar.a(d.a.TOP);
            dVarA2 = fVar.a(d.a.BOTTOM);
            z2 = this.al != null && this.al.ak[1] == e.a.WRAP_CONTENT;
        }
        if (this.bf && this.bc.f()) {
            androidx.d.c.i iVarA = eVar.a(this.bc);
            eVar.a(iVarA, this.bc.d());
            if (this.ba != -1) {
                if (z2) {
                    eVar.a(eVar.a(dVarA2), iVarA, 0, 5);
                }
            } else if (this.bb != -1 && z2) {
                androidx.d.c.i iVarA2 = eVar.a(dVarA2);
                eVar.a(iVarA, eVar.a(dVarA), 0, 5);
                eVar.a(iVarA2, iVarA, 0, 5);
            }
            this.bf = false;
            return;
        }
        if (this.ba != -1) {
            androidx.d.c.i iVarA3 = eVar.a(this.bc);
            eVar.c(iVarA3, eVar.a(dVarA), this.ba, 8);
            if (z2) {
                eVar.a(eVar.a(dVarA2), iVarA3, 0, 5);
                return;
            }
            return;
        }
        if (this.bb == -1) {
            if (this.aZ != -1.0f) {
                eVar.a(androidx.d.c.e.a(eVar, eVar.a(this.bc), eVar.a(dVarA2), this.aZ));
                return;
            }
            return;
        }
        androidx.d.c.i iVarA4 = eVar.a(this.bc);
        androidx.d.c.i iVarA5 = eVar.a(dVarA2);
        eVar.c(iVarA4, iVarA5, -this.bb, 8);
        if (z2) {
            eVar.a(iVarA4, eVar.a(dVarA), 0, 5);
            eVar.a(iVarA5, iVarA4, 0, 5);
        }
    }

    @Override // androidx.d.c.b.e
    public boolean a() {
        return true;
    }

    void aq() {
        float fG = G() / A().I();
        if (this.bd == 0) {
            fG = H() / A().L();
        }
        e(fG);
    }

    void ar() {
        int iG = G();
        if (this.bd == 0) {
            iG = H();
        }
        C(iG);
    }

    void as() {
        int I = A().I() - G();
        if (this.bd == 0) {
            I = A().L() - H();
        }
        D(I);
    }

    public void at() {
        if (this.ba != -1) {
            aq();
        } else if (this.aZ != -1.0f) {
            as();
        } else if (this.bb != -1) {
            ar();
        }
    }

    public boolean au() {
        return this.aZ != -1.0f && this.ba == -1 && this.bb == -1;
    }

    public int b() {
        if (this.aZ != -1.0f) {
            return 0;
        }
        if (this.ba != -1) {
            return 1;
        }
        return this.bb != -1 ? 2 : -1;
    }

    public void b(int i) {
        this.be = i;
    }

    @Override // androidx.d.c.b.e
    public void b(androidx.d.c.e eVar, boolean z) {
        if (A() == null) {
            return;
        }
        int iB = eVar.b(this.bc);
        if (this.bd == 1) {
            n(iB);
            o(0);
            q(A().L());
            p(0);
            return;
        }
        n(0);
        o(iB);
        p(A().I());
        q(0);
    }

    public d c() {
        return this.bc;
    }

    @Override // androidx.d.c.b.e
    public boolean d() {
        return this.bf;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.aZ = f;
            this.ba = -1;
            this.bb = -1;
        }
    }

    @Override // androidx.d.c.b.e
    public boolean e() {
        return this.bf;
    }

    public int f() {
        return this.bd;
    }

    public float g() {
        return this.aZ;
    }

    public int h() {
        return this.ba;
    }

    public int i() {
        return this.bb;
    }
}
