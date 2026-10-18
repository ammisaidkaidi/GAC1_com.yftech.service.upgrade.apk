package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e[] f950a;

    CompositeGeneratedAdaptersObserver(e[] eVarArr) {
        this.f950a = eVarArr;
    }

    @Override // androidx.lifecycle.h
    public void a(j jVar, g.a aVar) {
        o oVar = new o();
        for (e eVar : this.f950a) {
            eVar.a(jVar, aVar, false, oVar);
        }
        for (e eVar2 : this.f950a) {
            eVar2.a(jVar, aVar, true, oVar);
        }
    }
}
