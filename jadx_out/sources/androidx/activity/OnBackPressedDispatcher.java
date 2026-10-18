package androidx.activity;

import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayDeque<c> f18a;

    @ai
    private final Runnable b;

    private class LifecycleOnBackPressedCancellable implements androidx.activity.a, h {
        private final g b;
        private final c c;

        @ai
        private androidx.activity.a d;

        LifecycleOnBackPressedCancellable(@ah g gVar, @ah c cVar) {
            this.b = gVar;
            this.c = cVar;
            gVar.a(this);
        }

        @Override // androidx.activity.a
        public void a() {
            this.b.b(this);
            this.c.b(this);
            if (this.d != null) {
                this.d.a();
                this.d = null;
            }
        }

        @Override // androidx.lifecycle.h
        public void a(@ah j jVar, @ah g.a aVar) {
            if (aVar == g.a.ON_START) {
                this.d = OnBackPressedDispatcher.this.b(this.c);
                return;
            }
            if (aVar == g.a.ON_STOP) {
                if (this.d != null) {
                    this.d.a();
                }
            } else if (aVar == g.a.ON_DESTROY) {
                a();
            }
        }
    }

    private class a implements androidx.activity.a {
        private final c b;

        a(c cVar) {
            this.b = cVar;
        }

        @Override // androidx.activity.a
        public void a() {
            OnBackPressedDispatcher.this.f18a.remove(this.b);
            this.b.b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(@ai Runnable runnable) {
        this.f18a = new ArrayDeque<>();
        this.b = runnable;
    }

    @ae
    public void a(@ah c cVar) {
        b(cVar);
    }

    @ae
    public void a(@ah j jVar, @ah c cVar) {
        g gVarC = jVar.c();
        if (gVarC.a() == g.b.DESTROYED) {
            return;
        }
        cVar.a(new LifecycleOnBackPressedCancellable(gVarC, cVar));
    }

    @ae
    public boolean a() {
        Iterator<c> itDescendingIterator = this.f18a.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            if (itDescendingIterator.next().a()) {
                return true;
            }
        }
        return false;
    }

    @ae
    @ah
    androidx.activity.a b(@ah c cVar) {
        this.f18a.add(cVar);
        a aVar = new a(cVar);
        cVar.a(aVar);
        return aVar;
    }

    @ae
    public void b() {
        Iterator<c> itDescendingIterator = this.f18a.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            c next = itDescendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        if (this.b != null) {
            this.b.run();
        }
    }
}
