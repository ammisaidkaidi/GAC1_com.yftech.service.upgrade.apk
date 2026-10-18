package androidx.lifecycle;

import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class k extends g {
    private final WeakReference<j> d;
    private androidx.a.a.b.a<i, a> b = new androidx.a.a.b.a<>();
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private ArrayList<g.b> h = new ArrayList<>();
    private g.b c = g.b.INITIALIZED;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g.b f971a;
        h b;

        a(i iVar, g.b bVar) {
            this.b = m.b(iVar);
            this.f971a = bVar;
        }

        void a(j jVar, g.a aVar) {
            g.b bVarB = k.b(aVar);
            this.f971a = k.a(this.f971a, bVarB);
            this.b.a(jVar, aVar);
            this.f971a = bVarB;
        }
    }

    public k(@ah j jVar) {
        this.d = new WeakReference<>(jVar);
    }

    static g.b a(@ah g.b bVar, @ai g.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void a(j jVar) {
        androidx.a.a.b.b<i, a>.d dVarC = this.b.c();
        while (dVarC.hasNext() && !this.g) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f971a.compareTo(this.c) < 0 && !this.g && this.b.c((i) next.getKey())) {
                d(aVar.f971a);
                aVar.a(jVar, f(aVar.f971a));
                d();
            }
        }
    }

    static g.b b(g.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return g.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return g.b.STARTED;
            case ON_RESUME:
                return g.b.RESUMED;
            case ON_DESTROY:
                return g.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void b(j jVar) {
        Iterator<Map.Entry<i, a>> itB = this.b.b();
        while (itB.hasNext() && !this.g) {
            Map.Entry<i, a> next = itB.next();
            a value = next.getValue();
            while (value.f971a.compareTo(this.c) > 0 && !this.g && this.b.c(next.getKey())) {
                g.a aVarE = e(value.f971a);
                d(b(aVarE));
                value.a(jVar, aVarE);
                d();
            }
        }
    }

    private g.b c(i iVar) {
        Map.Entry<i, a> entryD = this.b.d(iVar);
        return a(a(this.c, entryD != null ? entryD.getValue().f971a : null), this.h.isEmpty() ? null : this.h.get(this.h.size() - 1));
    }

    private void c(g.b bVar) {
        if (this.c == bVar) {
            return;
        }
        this.c = bVar;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        e();
        this.f = false;
    }

    private boolean c() {
        if (this.b.a() == 0) {
            return true;
        }
        g.b bVar = this.b.d().getValue().f971a;
        g.b bVar2 = this.b.e().getValue().f971a;
        return bVar == bVar2 && this.c == bVar2;
    }

    private void d() {
        this.h.remove(this.h.size() - 1);
    }

    private void d(g.b bVar) {
        this.h.add(bVar);
    }

    private static g.a e(g.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return g.a.ON_DESTROY;
            case STARTED:
                return g.a.ON_STOP;
            case RESUMED:
                return g.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private void e() {
        j jVar = this.d.get();
        if (jVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!c()) {
            this.g = false;
            if (this.c.compareTo(this.b.d().getValue().f971a) < 0) {
                b(jVar);
            }
            Map.Entry<i, a> entryE = this.b.e();
            if (!this.g && entryE != null && this.c.compareTo(entryE.getValue().f971a) > 0) {
                a(jVar);
            }
        }
        this.g = false;
    }

    private static g.a f(g.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return g.a.ON_CREATE;
            case CREATED:
                return g.a.ON_START;
            case STARTED:
                return g.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    @Override // androidx.lifecycle.g
    @ah
    public g.b a() {
        return this.c;
    }

    public void a(@ah g.a aVar) {
        c(b(aVar));
    }

    @ae
    @Deprecated
    public void a(@ah g.b bVar) {
        b(bVar);
    }

    @Override // androidx.lifecycle.g
    public void a(@ah i iVar) {
        j jVar;
        a aVar = new a(iVar, this.c == g.b.DESTROYED ? g.b.DESTROYED : g.b.INITIALIZED);
        if (this.b.a(iVar, aVar) == null && (jVar = this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            g.b bVarC = c(iVar);
            this.e++;
            while (aVar.f971a.compareTo(bVarC) < 0 && this.b.c(iVar)) {
                d(aVar.f971a);
                aVar.a(jVar, f(aVar.f971a));
                d();
                bVarC = c(iVar);
            }
            if (!z) {
                e();
            }
            this.e--;
        }
    }

    public int b() {
        return this.b.a();
    }

    @ae
    public void b(@ah g.b bVar) {
        c(bVar);
    }

    @Override // androidx.lifecycle.g
    public void b(@ah i iVar) {
        this.b.b(iVar);
    }
}
