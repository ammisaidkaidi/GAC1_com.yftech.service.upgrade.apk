package androidx.d.c.a.a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    private Object f;
    private Object g;
    private Object h;
    private Object i;

    public f(androidx.d.c.a.e eVar) {
        super(eVar, androidx.d.c.a.e.d.HORIZONTAL_CHAIN);
    }

    public void a(Object obj) {
        this.f = obj;
    }

    public void b(Object obj) {
        this.g = obj;
    }

    @Override // androidx.d.c.a.c
    public void c() {
        Iterator<Object> it = this.c.iterator();
        while (it.hasNext()) {
            this.f650a.d(it.next()).h();
        }
        Iterator<Object> it2 = this.c.iterator();
        androidx.d.c.a.a aVar = null;
        androidx.d.c.a.a aVar2 = null;
        while (it2.hasNext()) {
            androidx.d.c.a.a aVarD = this.f650a.d(it2.next());
            if (aVar == null) {
                if (this.f != null) {
                    aVarD.g(this.f);
                } else if (this.g != null) {
                    aVarD.h(this.g);
                } else {
                    aVarD.g(androidx.d.c.a.e.g);
                }
                aVar = aVarD;
            }
            if (aVar2 != null) {
                aVar2.i(aVarD.a());
                aVarD.h(aVar2.a());
            }
            aVar2 = aVarD;
        }
        if (aVar2 != null) {
            if (this.h != null) {
                aVar2.i(this.h);
            } else if (this.i != null) {
                aVar2.j(this.i);
            } else {
                aVar2.j(androidx.d.c.a.e.g);
            }
        }
        if (aVar != null && this.d != 0.5f) {
            aVar.a(this.d);
        }
        switch (this.e) {
            case SPREAD:
                aVar.a(0);
                break;
            case SPREAD_INSIDE:
                aVar.a(1);
                break;
            case PACKED:
                aVar.a(2);
                break;
        }
    }

    public void c(Object obj) {
        this.h = obj;
    }

    public void d(Object obj) {
        this.i = obj;
    }
}
