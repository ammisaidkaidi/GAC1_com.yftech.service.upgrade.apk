package androidx.d.c.a.a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.d.c.a.c {
    private float d;
    private Object e;
    private Object f;
    private Object g;
    private Object h;

    public a(androidx.d.c.a.e eVar) {
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
            aVarD.h();
            if (this.e != null) {
                aVarD.g(this.e);
            } else if (this.f != null) {
                aVarD.h(this.f);
            } else {
                aVarD.g(androidx.d.c.a.e.g);
            }
            if (this.g != null) {
                aVarD.i(this.g);
            } else if (this.h != null) {
                aVarD.j(this.h);
            } else {
                aVarD.j(androidx.d.c.a.e.g);
            }
            if (this.d != 0.5f) {
                aVarD.a(this.d);
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
