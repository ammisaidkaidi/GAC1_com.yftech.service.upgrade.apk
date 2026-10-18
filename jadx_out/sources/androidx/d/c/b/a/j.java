package androidx.d.c.b.a;

/* JADX INFO: loaded from: classes.dex */
class j extends p {
    public j(androidx.d.c.b.e eVar) {
        super(eVar);
        eVar.l.c();
        eVar.m.c();
        this.h = ((androidx.d.c.b.h) eVar).f();
    }

    private void a(f fVar) {
        this.j.k.add(fVar);
        fVar.l.add(this.j);
    }

    @Override // androidx.d.c.b.a.p, androidx.d.c.b.a.d
    public void a(d dVar) {
        if (this.j.c && !this.j.j) {
            this.j.a((int) ((this.j.l.get(0).g * ((androidx.d.c.b.h) this.d).g()) + 0.5f));
        }
    }

    @Override // androidx.d.c.b.a.p
    boolean a() {
        return false;
    }

    @Override // androidx.d.c.b.a.p
    void c() {
        this.j.b();
    }

    @Override // androidx.d.c.b.a.p
    void d() {
        this.j.j = false;
        this.k.j = false;
    }

    @Override // androidx.d.c.b.a.p
    public void e() {
        if (((androidx.d.c.b.h) this.d).f() == 1) {
            this.d.n(this.j.g);
        } else {
            this.d.o(this.j.g);
        }
    }

    @Override // androidx.d.c.b.a.p
    void f() {
        androidx.d.c.b.h hVar = (androidx.d.c.b.h) this.d;
        int iH = hVar.h();
        int i = hVar.i();
        hVar.g();
        if (hVar.f() == 1) {
            if (iH != -1) {
                this.j.l.add(this.d.al.l.j);
                this.d.al.l.j.k.add(this.j);
                this.j.f = iH;
            } else if (i != -1) {
                this.j.l.add(this.d.al.l.k);
                this.d.al.l.k.k.add(this.j);
                this.j.f = -i;
            } else {
                this.j.b = true;
                this.j.l.add(this.d.al.l.k);
                this.d.al.l.k.k.add(this.j);
            }
            a(this.d.l.j);
            a(this.d.l.k);
            return;
        }
        if (iH != -1) {
            this.j.l.add(this.d.al.m.j);
            this.d.al.m.j.k.add(this.j);
            this.j.f = iH;
        } else if (i != -1) {
            this.j.l.add(this.d.al.m.k);
            this.d.al.m.k.k.add(this.j);
            this.j.f = -i;
        } else {
            this.j.b = true;
            this.j.l.add(this.d.al.m.k);
            this.d.al.m.k.k.add(this.j);
        }
        a(this.d.m.j);
        a(this.d.m.k);
    }
}
