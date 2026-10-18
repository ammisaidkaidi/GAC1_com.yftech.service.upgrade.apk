package androidx.d.c.a.a;

/* JADX INFO: loaded from: classes.dex */
public class d extends androidx.d.c.a.c {
    protected float d;
    protected androidx.d.c.a.e.a e;

    public d(androidx.d.c.a.e eVar, androidx.d.c.a.e.d dVar) {
        super(eVar, dVar);
        this.d = 0.5f;
        this.e = androidx.d.c.a.e.a.SPREAD;
    }

    public void a(float f) {
        this.d = f;
    }

    public void a(androidx.d.c.a.e.a aVar) {
        this.e = aVar;
    }

    public androidx.d.c.a.e.a d() {
        return androidx.d.c.a.e.a.SPREAD;
    }

    public float e() {
        return this.d;
    }
}
