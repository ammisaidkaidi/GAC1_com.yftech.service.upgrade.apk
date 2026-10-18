package androidx.d.c.a;

import androidx.d.c.b.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final e f650a;
    final e.d b;
    protected ArrayList<Object> c = new ArrayList<>();
    private j d;

    public c(e eVar, e.d dVar) {
        this.f650a = eVar;
        this.b = dVar;
    }

    public c a(Object... objArr) {
        for (Object obj : objArr) {
            this.c.add(obj);
        }
        return this;
    }

    public e.d a() {
        return this.b;
    }

    public void a(j jVar) {
        this.d = jVar;
    }

    public j b() {
        return this.d;
    }

    public void c() {
    }
}
