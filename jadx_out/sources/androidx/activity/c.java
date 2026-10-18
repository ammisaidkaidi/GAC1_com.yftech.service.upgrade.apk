package androidx.activity;

import androidx.annotation.ae;
import androidx.annotation.ah;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f24a;
    private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public c(boolean z) {
        this.f24a = z;
    }

    void a(@ah a aVar) {
        this.b.add(aVar);
    }

    @ae
    public final void a(boolean z) {
        this.f24a = z;
    }

    @ae
    public final boolean a() {
        return this.f24a;
    }

    @ae
    public final void b() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    void b(@ah a aVar) {
        this.b.remove(aVar);
    }

    @ae
    public abstract void c();
}
