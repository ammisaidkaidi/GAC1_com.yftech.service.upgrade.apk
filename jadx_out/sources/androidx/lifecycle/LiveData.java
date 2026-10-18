package androidx.lifecycle;

import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    static final int c = -1;
    static final Object d = new Object();
    private boolean i;
    private boolean j;
    final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.a.a.b.b<q<? super T>, LiveData<T>.b> f954a = new androidx.a.a.b.b<>();
    int e = 0;
    private volatile Object g = d;
    volatile Object f = d;
    private int h = -1;
    private final Runnable k = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.b) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.d;
            }
            LiveData.this.b(obj);
        }
    };

    class LifecycleBoundObserver extends LiveData<T>.b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ah
        final j f956a;

        LifecycleBoundObserver(@ah j jVar, q<? super T> qVar) {
            super(qVar);
            this.f956a = jVar;
        }

        @Override // androidx.lifecycle.h
        public void a(j jVar, g.a aVar) {
            if (this.f956a.c().a() == g.b.DESTROYED) {
                LiveData.this.b((q) this.c);
            } else {
                a(a());
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return this.f956a.c().a().a(g.b.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a(j jVar) {
            return this.f956a == jVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        void b() {
            this.f956a.c().b(this);
        }
    }

    private class a extends LiveData<T>.b {
        a(q<? super T> qVar) {
            super(qVar);
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return true;
        }
    }

    private abstract class b {
        final q<? super T> c;
        boolean d;
        int e = -1;

        b(q<? super T> qVar) {
            this.c = qVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            boolean z2 = LiveData.this.e == 0;
            LiveData.this.e += this.d ? 1 : -1;
            if (z2 && this.d) {
                LiveData.this.a();
            }
            if (LiveData.this.e == 0 && !this.d) {
                LiveData.this.d();
            }
            if (this.d) {
                LiveData.this.a(this);
            }
        }

        abstract boolean a();

        boolean a(j jVar) {
            return false;
        }

        void b() {
        }
    }

    private static void a(String str) {
        if (androidx.a.a.a.a.a().d()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.d) {
            if (!bVar.a()) {
                bVar.a(false);
            } else {
                if (bVar.e >= this.h) {
                    return;
                }
                bVar.e = this.h;
                bVar.c.a((Object) this.g);
            }
        }
    }

    protected void a() {
    }

    void a(@ai LiveData<T>.b bVar) {
        if (this.i) {
            this.j = true;
            return;
        }
        this.i = true;
        do {
            this.j = false;
            if (bVar != null) {
                b((b) bVar);
                bVar = null;
            } else {
                androidx.a.a.b.b<q<? super T>, LiveData<T>.b>.d dVarC = this.f954a.c();
                while (dVarC.hasNext()) {
                    b((b) dVarC.next().getValue());
                    if (this.j) {
                        break;
                    }
                }
            }
        } while (this.j);
        this.i = false;
    }

    @ae
    public void a(@ah j jVar) {
        a("removeObservers");
        for (Map.Entry<q<? super T>, LiveData<T>.b> entry : this.f954a) {
            if (entry.getValue().a(jVar)) {
                b((q) entry.getKey());
            }
        }
    }

    @ae
    public void a(@ah j jVar, @ah q<? super T> qVar) {
        a("observe");
        if (jVar.c().a() == g.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(jVar, qVar);
        LiveData<T>.b bVarA = this.f954a.a(qVar, lifecycleBoundObserver);
        if (bVarA != null && !bVarA.a(jVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (bVarA != null) {
            return;
        }
        jVar.c().a(lifecycleBoundObserver);
    }

    @ae
    public void a(@ah q<? super T> qVar) {
        a("observeForever");
        a aVar = new a(qVar);
        LiveData<T>.b bVarA = this.f954a.a(qVar, aVar);
        if (bVarA != null && (bVarA instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (bVarA != null) {
            return;
        }
        aVar.a(true);
    }

    protected void a(T t) {
        boolean z;
        synchronized (this.b) {
            z = this.f == d;
            this.f = t;
        }
        if (z) {
            androidx.a.a.a.a.a().b(this.k);
        }
    }

    @ai
    public T b() {
        T t = (T) this.g;
        if (t != d) {
            return t;
        }
        return null;
    }

    @ae
    public void b(@ah q<? super T> qVar) {
        a("removeObserver");
        LiveData<T>.b bVarB = this.f954a.b(qVar);
        if (bVarB == null) {
            return;
        }
        bVarB.b();
        bVarB.a(false);
    }

    @ae
    protected void b(T t) {
        a("setValue");
        this.h++;
        this.g = t;
        a((b) null);
    }

    int c() {
        return this.h;
    }

    protected void d() {
    }

    public boolean e() {
        return this.f954a.a() > 0;
    }

    public boolean f() {
        return this.e > 0;
    }
}
