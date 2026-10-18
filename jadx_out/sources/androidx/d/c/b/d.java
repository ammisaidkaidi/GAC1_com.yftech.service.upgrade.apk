package androidx.d.c.b;

import androidx.d.c.b.a.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final boolean g = false;
    private static final int k = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f678a;
    public final a b;
    public d c;
    androidx.d.c.i f;
    private int i;
    private boolean j;
    private HashSet<d> h = null;
    public int d = 0;
    int e = -1;

    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, a aVar) {
        this.f678a = eVar;
        this.b = aVar;
    }

    private boolean a(e eVar, HashSet<e> hashSet) {
        if (hashSet.contains(eVar)) {
            return false;
        }
        hashSet.add(eVar);
        if (eVar == h()) {
            return true;
        }
        ArrayList<d> arrayListAb = eVar.ab();
        int size = arrayListAb.size();
        for (int i = 0; i < size; i++) {
            d dVar = arrayListAb.get(i);
            if (dVar.b(this) && dVar.m() && a(dVar.k().h(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public HashSet<d> a() {
        return this.h;
    }

    public void a(int i) {
        this.i = i;
        this.j = true;
    }

    public void a(int i, ArrayList<o> arrayList, o oVar) {
        if (this.h != null) {
            Iterator<d> it = this.h.iterator();
            while (it.hasNext()) {
                androidx.d.c.b.a.i.a(it.next().f678a, i, arrayList, oVar);
            }
        }
    }

    public void a(d dVar, HashMap<e, e> map) {
        if (this.c != null && this.c.h != null) {
            this.c.h.remove(this);
        }
        if (dVar.c != null) {
            this.c = map.get(dVar.c.f678a).a(dVar.c.i());
        } else {
            this.c = null;
        }
        if (this.c != null) {
            if (this.c.h == null) {
                this.c.h = new HashSet<>();
            }
            this.c.h.add(this);
        }
        this.d = dVar.d;
        this.e = dVar.e;
    }

    public void a(androidx.d.c.c cVar) {
        if (this.f == null) {
            this.f = new androidx.d.c.i(androidx.d.c.i.a.UNRESTRICTED, (String) null);
        } else {
            this.f.d();
        }
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        a aVarI = dVar.i();
        if (aVarI == this.b) {
            return this.b != a.BASELINE || (dVar.h().Y() && h().Y());
        }
        switch (this.b) {
            case CENTER:
                return (aVarI == a.BASELINE || aVarI == a.CENTER_X || aVarI == a.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z = aVarI == a.LEFT || aVarI == a.RIGHT;
                if (dVar.h() instanceof h) {
                    return z || aVarI == a.CENTER_X;
                }
                return z;
            case TOP:
            case BOTTOM:
                boolean z2 = aVarI == a.TOP || aVarI == a.BOTTOM;
                if (dVar.h() instanceof h) {
                    return z2 || aVarI == a.CENTER_Y;
                }
                return z2;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public boolean a(d dVar, int i) {
        return a(dVar, i, -1, false);
    }

    public boolean a(d dVar, int i, int i2, boolean z) {
        if (dVar == null) {
            l();
            return true;
        }
        if (!z && !a(dVar)) {
            return false;
        }
        this.c = dVar;
        if (this.c.h == null) {
            this.c.h = new HashSet<>();
        }
        if (this.c.h != null) {
            this.c.h.add(this);
        }
        if (i > 0) {
            this.d = i;
        } else {
            this.d = 0;
        }
        this.e = i2;
        return true;
    }

    public boolean a(e eVar) {
        if (a(eVar, new HashSet<>())) {
            return false;
        }
        e eVarA = h().A();
        return eVarA == eVar || eVar.A() == eVarA;
    }

    public boolean a(e eVar, d dVar) {
        return a(eVar);
    }

    public void b(int i) {
        if (m()) {
            this.d = i;
        }
    }

    public boolean b() {
        return this.h != null && this.h.size() > 0;
    }

    public boolean b(d dVar) {
        a aVarI = dVar.i();
        if (aVarI == this.b) {
            return true;
        }
        switch (this.b) {
            case CENTER:
                return aVarI != a.BASELINE;
            case LEFT:
            case RIGHT:
            case CENTER_X:
                return aVarI == a.LEFT || aVarI == a.RIGHT || aVarI == a.CENTER_X;
            case TOP:
            case BOTTOM:
            case BASELINE:
            case CENTER_Y:
                return aVarI == a.TOP || aVarI == a.BOTTOM || aVarI == a.CENTER_Y || aVarI == a.BASELINE;
            case NONE:
                return false;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public void c(int i) {
        if (m()) {
            this.e = i;
        }
    }

    public boolean c() {
        if (this.h == null) {
            return false;
        }
        Iterator<d> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().p().m()) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        if (this.j) {
            return this.i;
        }
        return 0;
    }

    public void e() {
        this.j = false;
        this.i = 0;
    }

    public boolean f() {
        return this.j;
    }

    public androidx.d.c.i g() {
        return this.f;
    }

    public e h() {
        return this.f678a;
    }

    public a i() {
        return this.b;
    }

    public int j() {
        if (this.f678a.E() == 8) {
            return 0;
        }
        return (this.e <= -1 || this.c == null || this.c.f678a.E() != 8) ? this.d : this.e;
    }

    public d k() {
        return this.c;
    }

    public void l() {
        if (this.c != null && this.c.h != null) {
            this.c.h.remove(this);
            if (this.c.h.size() == 0) {
                this.c.h = null;
            }
        }
        this.h = null;
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.j = false;
        this.i = 0;
    }

    public boolean m() {
        return this.c != null;
    }

    public boolean n() {
        switch (this.b) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            case LEFT:
            case RIGHT:
            case TOP:
            case BOTTOM:
                return true;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public boolean o() {
        switch (this.b) {
            case CENTER:
            case LEFT:
            case RIGHT:
            case CENTER_X:
                return false;
            case TOP:
            case BOTTOM:
            case BASELINE:
            case CENTER_Y:
            case NONE:
                return true;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public final d p() {
        switch (this.b) {
            case CENTER:
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
            case LEFT:
                return this.f678a.V;
            case RIGHT:
                return this.f678a.T;
            case TOP:
                return this.f678a.W;
            case BOTTOM:
                return this.f678a.U;
            default:
                throw new AssertionError(this.b.name());
        }
    }

    public String toString() {
        return this.f678a.F() + ":" + this.b.toString();
    }
}
