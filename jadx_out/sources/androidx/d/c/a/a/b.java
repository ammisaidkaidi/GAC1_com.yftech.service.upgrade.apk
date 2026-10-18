package androidx.d.c.a.a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b extends androidx.d.c.a.c {
    private float d;
    private Object e;
    private Object f;
    private Object g;
    private Object h;

    public b(androidx.d.c.a.e eVar) {
        super(eVar, androidx.d.c.a.e.d.ALIGN_VERTICALLY);
        this.d = 0.5f;
    }

    public void a(float f) {
        this.d = f;
    }

    public void a(Object obj) {
        this.e = obj;
    }

    public void b(Object obj) {
        this.f = obj;
    }

    @Override // androidx.d.c.a.c
    public void c() {
        Iterator<Object> it = this.c.iterator();
        while (it.hasNext()) {
            androidx.d.c.a.a aVarD = this.f650a.d(it.next());
            aVarD.g();
            if (this.e != null) {
                aVarD.k(this.e);
            } else if (this.f != null) {
                aVarD.l(this.f);
            } else {
                aVarD.k(androidx.d.c.a.e.g);
            }
            if (this.g != null) {
                aVarD.m(this.g);
            } else if (this.h != null) {
                aVarD.n(this.h);
            } else {
                aVarD.n(androidx.d.c.a.e.g);
            }
            if (this.d != 0.5f) {
                aVarD.b(this.d);
            }
        }
    }

    public void c(Object obj) {
        this.g = obj;
    }

    public void d(Object obj) {
        this.h = obj;
    }
}
