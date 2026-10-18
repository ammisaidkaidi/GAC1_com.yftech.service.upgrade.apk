package androidx.d.c.a;

import androidx.d.c.a.a.f;
import androidx.d.c.a.a.g;
import androidx.d.c.b.j;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    static final int c = -1;
    static final int d = 0;
    static final int e = 1;
    static final int f = 2;
    public static final Integer g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap<Object, androidx.d.c.a.d> f651a = new HashMap<>();
    protected HashMap<Object, androidx.d.c.a.c> b = new HashMap<>();
    public final androidx.d.c.a.a h = new androidx.d.c.a.a(this);
    private int i = 0;

    public enum a {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum b {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY
    }

    public enum c {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum d {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public e() {
        this.f651a.put(g, this.h);
    }

    private String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.i;
        this.i = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    public int a(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public androidx.d.c.a.a.c a(Object obj, c cVar) {
        androidx.d.c.a.a.c cVar2 = (androidx.d.c.a.a.c) a(obj, d.BARRIER);
        cVar2.a(cVar);
        return cVar2;
    }

    public androidx.d.c.a.a.e a(Object obj, int i) {
        androidx.d.c.a.d dVar = this.f651a.get(obj);
        Object obj2 = dVar;
        if (dVar == null) {
            androidx.d.c.a.a.e eVar = new androidx.d.c.a.a.e(this);
            eVar.a(i);
            eVar.a(obj);
            this.f651a.put(obj, eVar);
            obj2 = eVar;
        }
        return (androidx.d.c.a.a.e) obj2;
    }

    public g a(Object... objArr) {
        g gVar = (g) a((Object) null, d.VERTICAL_CHAIN);
        gVar.a(objArr);
        return gVar;
    }

    public androidx.d.c.a.c a(Object obj, d dVar) {
        androidx.d.c.a.c fVar;
        if (obj == null) {
            obj = c();
        }
        androidx.d.c.a.c cVar = this.b.get(obj);
        if (cVar == null) {
            switch (dVar) {
                case HORIZONTAL_CHAIN:
                    fVar = new f(this);
                    cVar = fVar;
                    break;
                case VERTICAL_CHAIN:
                    fVar = new g(this);
                    cVar = fVar;
                    break;
                case ALIGN_HORIZONTALLY:
                    fVar = new androidx.d.c.a.a.a(this);
                    cVar = fVar;
                    break;
                case ALIGN_VERTICALLY:
                    fVar = new androidx.d.c.a.a.b(this);
                    cVar = fVar;
                    break;
                case BARRIER:
                    fVar = new androidx.d.c.a.a.c(this);
                    cVar = fVar;
                    break;
                default:
                    cVar = new androidx.d.c.a.c(this, dVar);
                    break;
            }
            this.b.put(obj, cVar);
        }
        return cVar;
    }

    public e a(androidx.d.c.a.b bVar) {
        return c(bVar);
    }

    public void a() {
        this.b.clear();
    }

    public void a(androidx.d.c.b.f fVar) {
        fVar.aA();
        this.h.p().a(this, fVar, 0);
        this.h.q().a(this, fVar, 1);
        for (Object obj : this.b.keySet()) {
            j jVarB = this.b.get(obj).b();
            if (jVarB != null) {
                androidx.d.c.a.d dVarD = this.f651a.get(obj);
                if (dVarD == null) {
                    dVarD = d(obj);
                }
                dVarD.a((androidx.d.c.b.e) jVarB);
            }
        }
        Iterator<Object> it = this.f651a.keySet().iterator();
        while (it.hasNext()) {
            androidx.d.c.a.d dVar = this.f651a.get(it.next());
            if (dVar != this.h) {
                androidx.d.c.b.e eVarC = dVar.c();
                eVarC.a_(null);
                if (dVar instanceof androidx.d.c.a.a.e) {
                    dVar.s();
                }
                fVar.b(eVarC);
            } else {
                dVar.a((androidx.d.c.b.e) fVar);
            }
        }
        Iterator<Object> it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            androidx.d.c.a.c cVar = this.b.get(it2.next());
            if (cVar.b() != null) {
                Iterator<Object> it3 = cVar.c.iterator();
                while (it3.hasNext()) {
                    cVar.b().a(this.f651a.get(it3.next()).c());
                }
                cVar.c();
            }
        }
        Iterator<Object> it4 = this.f651a.keySet().iterator();
        while (it4.hasNext()) {
            this.f651a.get(it4.next()).s();
        }
    }

    public void a(Object obj, Object obj2) {
        d(obj).b(obj2);
    }

    public f b(Object... objArr) {
        f fVar = (f) a((Object) null, d.HORIZONTAL_CHAIN);
        fVar.a(objArr);
        return fVar;
    }

    public androidx.d.c.a.a b(Object obj) {
        return new androidx.d.c.a.a(this);
    }

    public e b(androidx.d.c.a.b bVar) {
        return d(bVar);
    }

    public void b() {
        for (Object obj : this.f651a.keySet()) {
            d(obj).b(obj);
        }
    }

    public androidx.d.c.a.a.a c(Object... objArr) {
        androidx.d.c.a.a.a aVar = (androidx.d.c.a.a.a) a((Object) null, d.ALIGN_HORIZONTALLY);
        aVar.a(objArr);
        return aVar;
    }

    androidx.d.c.a.d c(Object obj) {
        return this.f651a.get(obj);
    }

    public e c(androidx.d.c.a.b bVar) {
        this.h.c(bVar);
        return this;
    }

    public androidx.d.c.a.a.b d(Object... objArr) {
        androidx.d.c.a.a.b bVar = (androidx.d.c.a.a.b) a((Object) null, d.ALIGN_VERTICALLY);
        bVar.a(objArr);
        return bVar;
    }

    public androidx.d.c.a.a d(Object obj) {
        androidx.d.c.a.d dVarB = this.f651a.get(obj);
        if (dVarB == null) {
            dVarB = b(obj);
            this.f651a.put(obj, dVarB);
            dVarB.a(obj);
        }
        if (dVarB instanceof androidx.d.c.a.a) {
            return (androidx.d.c.a.a) dVarB;
        }
        return null;
    }

    public e d(androidx.d.c.a.b bVar) {
        this.h.d(bVar);
        return this;
    }

    public androidx.d.c.a.a.e e(Object obj) {
        return a(obj, 0);
    }

    public androidx.d.c.a.a.e f(Object obj) {
        return a(obj, 1);
    }
}
