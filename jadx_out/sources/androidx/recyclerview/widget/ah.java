package androidx.recyclerview.widget;

import androidx.annotation.ai;
import androidx.annotation.ax;

/* JADX INFO: loaded from: classes.dex */
class ah {
    private static final boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ax
    final androidx.c.i<RecyclerView.z, a> f1037a = new androidx.c.i<>();

    @ax
    final androidx.c.f<RecyclerView.z> b = new androidx.c.f<>();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f1038a = 1;
        static final int b = 2;
        static final int c = 4;
        static final int d = 8;
        static final int e = 3;
        static final int f = 12;
        static final int g = 14;
        static androidx.core.m.h.a<a> k = new androidx.core.m.h.b(20);
        int h;

        @ai
        RecyclerView.f.d i;

        @ai
        RecyclerView.f.d j;

        private a() {
        }

        static a a() {
            a aVarA = k.a();
            return aVarA == null ? new a() : aVarA;
        }

        static void a(a aVar) {
            aVar.h = 0;
            aVar.i = null;
            aVar.j = null;
            k.a(aVar);
        }

        static void b() {
            while (k.a() != null) {
            }
        }
    }

    interface b {
        void a(RecyclerView.z zVar);

        void a(RecyclerView.z zVar, @androidx.annotation.ah RecyclerView.f.d dVar, @ai RecyclerView.f.d dVar2);

        void b(RecyclerView.z zVar, @ai RecyclerView.f.d dVar, RecyclerView.f.d dVar2);

        void c(RecyclerView.z zVar, @androidx.annotation.ah RecyclerView.f.d dVar, @androidx.annotation.ah RecyclerView.f.d dVar2);
    }

    ah() {
    }

    private RecyclerView.f.d a(RecyclerView.z zVar, int i) {
        a aVarC;
        RecyclerView.f.d dVar;
        int iA = this.f1037a.a(zVar);
        if (iA < 0 || (aVarC = this.f1037a.c(iA)) == null || (aVarC.h & i) == 0) {
            return null;
        }
        aVarC.h &= ~i;
        if (i == 4) {
            dVar = aVarC.i;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            dVar = aVarC.j;
        }
        if ((aVarC.h & 12) == 0) {
            this.f1037a.d(iA);
            a.a(aVarC);
        }
        return dVar;
    }

    RecyclerView.z a(long j) {
        return this.b.a(j);
    }

    void a() {
        this.f1037a.clear();
        this.b.d();
    }

    void a(long j, RecyclerView.z zVar) {
        this.b.d(j, zVar);
    }

    void a(RecyclerView.z zVar, RecyclerView.f.d dVar) {
        a aVarA = this.f1037a.get(zVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1037a.put(zVar, aVarA);
        }
        aVarA.i = dVar;
        aVarA.h |= 4;
    }

    void a(b bVar) {
        for (int size = this.f1037a.size() - 1; size >= 0; size--) {
            RecyclerView.z zVarB = this.f1037a.b(size);
            a aVarD = this.f1037a.d(size);
            if ((aVarD.h & 3) == 3) {
                bVar.a(zVarB);
            } else if ((aVarD.h & 1) != 0) {
                if (aVarD.i == null) {
                    bVar.a(zVarB);
                } else {
                    bVar.a(zVarB, aVarD.i, aVarD.j);
                }
            } else if ((aVarD.h & 14) == 14) {
                bVar.b(zVarB, aVarD.i, aVarD.j);
            } else if ((aVarD.h & 12) == 12) {
                bVar.c(zVarB, aVarD.i, aVarD.j);
            } else if ((aVarD.h & 4) != 0) {
                bVar.a(zVarB, aVarD.i, null);
            } else if ((aVarD.h & 8) != 0) {
                bVar.b(zVarB, aVarD.i, aVarD.j);
            } else {
                int i = aVarD.h;
            }
            a.a(aVarD);
        }
    }

    boolean a(RecyclerView.z zVar) {
        a aVar = this.f1037a.get(zVar);
        return (aVar == null || (aVar.h & 1) == 0) ? false : true;
    }

    @ai
    RecyclerView.f.d b(RecyclerView.z zVar) {
        return a(zVar, 4);
    }

    void b() {
        a.b();
    }

    void b(RecyclerView.z zVar, RecyclerView.f.d dVar) {
        a aVarA = this.f1037a.get(zVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1037a.put(zVar, aVarA);
        }
        aVarA.h |= 2;
        aVarA.i = dVar;
    }

    @ai
    RecyclerView.f.d c(RecyclerView.z zVar) {
        return a(zVar, 8);
    }

    void c(RecyclerView.z zVar, RecyclerView.f.d dVar) {
        a aVarA = this.f1037a.get(zVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1037a.put(zVar, aVarA);
        }
        aVarA.j = dVar;
        aVarA.h |= 8;
    }

    boolean d(RecyclerView.z zVar) {
        a aVar = this.f1037a.get(zVar);
        return (aVar == null || (aVar.h & 4) == 0) ? false : true;
    }

    void e(RecyclerView.z zVar) {
        a aVarA = this.f1037a.get(zVar);
        if (aVarA == null) {
            aVarA = a.a();
            this.f1037a.put(zVar, aVarA);
        }
        aVarA.h |= 1;
    }

    void f(RecyclerView.z zVar) {
        a aVar = this.f1037a.get(zVar);
        if (aVar == null) {
            return;
        }
        aVar.h &= -2;
    }

    void g(RecyclerView.z zVar) {
        for (int iB = this.b.b() - 1; iB >= 0; iB--) {
            if (zVar == this.b.c(iB)) {
                this.b.a(iB);
                break;
            }
        }
        a aVarRemove = this.f1037a.remove(zVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    public void h(RecyclerView.z zVar) {
        f(zVar);
    }
}
