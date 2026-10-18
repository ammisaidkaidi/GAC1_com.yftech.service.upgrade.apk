package androidx.d.c.b.a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f669a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static int d;
    p g;
    p h;
    int j;
    int k;
    public int e = 0;
    public boolean f = false;
    ArrayList<p> i = new ArrayList<>();

    public m(p pVar, int i) {
        this.g = null;
        this.h = null;
        this.j = 0;
        this.j = d;
        d++;
        this.g = pVar;
        this.h = pVar;
        this.k = i;
    }

    private long a(f fVar, long j) {
        p pVar = fVar.d;
        if (pVar instanceof k) {
            return j;
        }
        int size = fVar.k.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            d dVar = fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != pVar) {
                    jMax = Math.max(jMax, a(fVar2, ((long) fVar2.f) + j));
                }
            }
        }
        if (fVar != pVar.j) {
            return jMax;
        }
        long jB = j + pVar.b();
        return Math.max(Math.max(jMax, a(pVar.k, jB)), jB - ((long) pVar.k.f));
    }

    private boolean a(p pVar, int i) {
        if (!pVar.d.n[i]) {
            return false;
        }
        for (d dVar : pVar.j.k) {
            if (dVar instanceof f) {
                f fVar = (f) dVar;
                if (fVar.d != pVar && fVar == fVar.d.j) {
                    if (pVar instanceof c) {
                        Iterator<p> it = ((c) pVar).f661a.iterator();
                        while (it.hasNext()) {
                            a(it.next(), i);
                        }
                    } else if (!(pVar instanceof k)) {
                        pVar.d.n[i] = false;
                    }
                    a(fVar.d, i);
                }
            }
        }
        for (d dVar2 : pVar.k.k) {
            if (dVar2 instanceof f) {
                f fVar2 = (f) dVar2;
                if (fVar2.d != pVar && fVar2 == fVar2.d.j) {
                    if (pVar instanceof c) {
                        Iterator<p> it2 = ((c) pVar).f661a.iterator();
                        while (it2.hasNext()) {
                            a(it2.next(), i);
                        }
                    } else if (!(pVar instanceof k)) {
                        pVar.d.n[i] = false;
                    }
                    a(fVar2.d, i);
                }
            }
        }
        return false;
    }

    private long b(f fVar, long j) {
        p pVar = fVar.d;
        if (pVar instanceof k) {
            return j;
        }
        int size = fVar.k.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            d dVar = fVar.k.get(i);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.d != pVar) {
                    jMin = Math.min(jMin, b(fVar2, ((long) fVar2.f) + j));
                }
            }
        }
        if (fVar != pVar.k) {
            return jMin;
        }
        long jB = j - pVar.b();
        return Math.min(Math.min(jMin, b(pVar.j, jB)), jB - ((long) pVar.j.f));
    }

    public long a(androidx.d.c.b.f fVar, int i) {
        if (this.g instanceof c) {
            if (((c) this.g).h != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(this.g instanceof l)) {
                return 0L;
            }
        } else if (!(this.g instanceof n)) {
            return 0L;
        }
        f fVar2 = i == 0 ? fVar.l.j : fVar.m.j;
        f fVar3 = i == 0 ? fVar.l.k : fVar.m.k;
        boolean zContains = this.g.j.l.contains(fVar2);
        boolean zContains2 = this.g.k.l.contains(fVar3);
        long jB = this.g.b();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(a(this.g.j, this.g.j.f), ((long) this.g.j.f) + jB);
            }
            if (!zContains2) {
                return (((long) this.g.j.f) + this.g.b()) - ((long) this.g.k.f);
            }
            return Math.max(-b(this.g.k, this.g.k.f), ((long) (-this.g.k.f)) + jB);
        }
        long jA = a(this.g.j, 0L);
        long jB2 = b(this.g.k, 0L);
        long j = jA - jB;
        if (j >= (-this.g.k.f)) {
            j += (long) this.g.k.f;
        }
        long j2 = ((-jB2) - jB) - ((long) this.g.j.f);
        if (j2 >= this.g.j.f) {
            j2 -= (long) this.g.j.f;
        }
        float fM = this.g.d.m(i);
        float f = fM > 0.0f ? (long) ((j2 / fM) + (j / (1.0f - fM))) : 0L;
        return (((long) this.g.j.f) + ((((long) ((f * fM) + 0.5f)) + jB) + ((long) ((f * (1.0f - fM)) + 0.5f)))) - ((long) this.g.k.f);
    }

    public void a(p pVar) {
        this.i.add(pVar);
        this.h = pVar;
    }

    public void a(boolean z, boolean z2) {
        if (z && (this.g instanceof l)) {
            a(this.g, 0);
        }
        if (z2 && (this.g instanceof n)) {
            a(this.g, 1);
        }
    }
}
