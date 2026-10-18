package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f958a;
    private final b.a b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f958a = obj;
        this.b = b.f961a.b(this.f958a.getClass());
    }

    @Override // androidx.lifecycle.h
    public void a(j jVar, g.a aVar) {
        this.b.a(jVar, aVar, this.f958a);
    }
}
