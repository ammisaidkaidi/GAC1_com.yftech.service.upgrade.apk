package androidx.fragment.app;

import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
class w implements androidx.lifecycle.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.lifecycle.k f801a = null;

    w() {
    }

    void a() {
        if (this.f801a == null) {
            this.f801a = new androidx.lifecycle.k(this);
        }
    }

    void a(@ah androidx.lifecycle.g.a aVar) {
        this.f801a.a(aVar);
    }

    boolean b() {
        return this.f801a != null;
    }

    @Override // androidx.lifecycle.j
    @ah
    public androidx.lifecycle.g c() {
        a();
        return this.f801a;
    }
}
