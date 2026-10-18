package androidx.d.c.b;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class f extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f684a = false;
    static int bp = 0;
    private static final int br = 8;
    private static final boolean bs = false;
    private static final boolean bt = false;
    protected androidx.d.c.e aY;
    int aZ;
    androidx.d.c.b.a.b b;
    private WeakReference<d> bA;
    private WeakReference<d> bB;
    int ba;
    int bb;
    int bc;
    public int bd;
    public int be;
    c[] bf;
    c[] bg;
    public boolean bh;
    public boolean bi;
    public boolean bj;
    public int bk;
    public int bl;
    public boolean bm;
    int bn;
    public androidx.d.c.b.a.b.a bo;
    private boolean bu;
    private int bv;
    private boolean bw;
    private boolean bx;
    private WeakReference<d> by;
    private WeakReference<d> bz;
    public androidx.d.c.b.a.e c;
    protected androidx.d.c.b.a.b.InterfaceC0050b d;
    public androidx.d.c.f e;

    public f() {
        this.b = new androidx.d.c.b.a.b(this);
        this.c = new androidx.d.c.b.a.e(this);
        this.d = null;
        this.bu = false;
        this.aY = new androidx.d.c.e();
        this.bd = 0;
        this.be = 0;
        this.bf = new c[4];
        this.bg = new c[4];
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = 0;
        this.bl = 0;
        this.bv = 257;
        this.bm = false;
        this.bw = false;
        this.bx = false;
        this.bn = 0;
        this.by = null;
        this.bz = null;
        this.bA = null;
        this.bB = null;
        this.bo = new androidx.d.c.b.a.b.a();
    }

    public f(int i, int i2) {
        super(i, i2);
        this.b = new androidx.d.c.b.a.b(this);
        this.c = new androidx.d.c.b.a.e(this);
        this.d = null;
        this.bu = false;
        this.aY = new androidx.d.c.e();
        this.bd = 0;
        this.be = 0;
        this.bf = new c[4];
        this.bg = new c[4];
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = 0;
        this.bl = 0;
        this.bv = 257;
        this.bm = false;
        this.bw = false;
        this.bx = false;
        this.bn = 0;
        this.by = null;
        this.bz = null;
        this.bA = null;
        this.bB = null;
        this.bo = new androidx.d.c.b.a.b.a();
    }

    public f(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.b = new androidx.d.c.b.a.b(this);
        this.c = new androidx.d.c.b.a.e(this);
        this.d = null;
        this.bu = false;
        this.aY = new androidx.d.c.e();
        this.bd = 0;
        this.be = 0;
        this.bf = new c[4];
        this.bg = new c[4];
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = 0;
        this.bl = 0;
        this.bv = 257;
        this.bm = false;
        this.bw = false;
        this.bx = false;
        this.bn = 0;
        this.by = null;
        this.bz = null;
        this.bA = null;
        this.bB = null;
        this.bo = new androidx.d.c.b.a.b.a();
    }

    public f(String str, int i, int i2) {
        super(i, i2);
        this.b = new androidx.d.c.b.a.b(this);
        this.c = new androidx.d.c.b.a.e(this);
        this.d = null;
        this.bu = false;
        this.aY = new androidx.d.c.e();
        this.bd = 0;
        this.be = 0;
        this.bf = new c[4];
        this.bg = new c[4];
        this.bh = false;
        this.bi = false;
        this.bj = false;
        this.bk = 0;
        this.bl = 0;
        this.bv = 257;
        this.bm = false;
        this.bw = false;
        this.bx = false;
        this.bn = 0;
        this.by = null;
        this.bz = null;
        this.bA = null;
        this.bB = null;
        this.bo = new androidx.d.c.b.a.b.a();
        b(str);
    }

    private void a(d dVar, androidx.d.c.i iVar) {
        this.aY.a(this.aY.a(dVar), iVar, 0, 5);
    }

    public static boolean a(e eVar, androidx.d.c.b.a.b.InterfaceC0050b interfaceC0050b, androidx.d.c.b.a.b.a aVar, int i) {
        int i2;
        int i3;
        if (interfaceC0050b == null) {
            return false;
        }
        aVar.d = eVar.aj();
        aVar.e = eVar.ak();
        aVar.f = eVar.I();
        aVar.g = eVar.L();
        aVar.l = false;
        aVar.m = i;
        boolean z = aVar.d == e.a.MATCH_CONSTRAINT;
        boolean z2 = aVar.e == e.a.MATCH_CONSTRAINT;
        boolean z3 = z && eVar.ao > 0.0f;
        boolean z4 = z2 && eVar.ao > 0.0f;
        if (z && eVar.g(0) && eVar.G == 0 && !z3) {
            aVar.d = e.a.WRAP_CONTENT;
            if (z2 && eVar.H == 0) {
                aVar.d = e.a.FIXED;
            }
            z = false;
        }
        if (z2 && eVar.g(1) && eVar.H == 0 && !z4) {
            aVar.e = e.a.WRAP_CONTENT;
            if (z && eVar.G == 0) {
                aVar.e = e.a.FIXED;
            }
            z2 = false;
        }
        if (eVar.d()) {
            aVar.d = e.a.FIXED;
            z = false;
        }
        if (eVar.e()) {
            aVar.e = e.a.FIXED;
            z2 = false;
        }
        if (z3) {
            if (eVar.I[0] == 4) {
                aVar.d = e.a.FIXED;
            } else if (!z2) {
                if (aVar.e == e.a.FIXED) {
                    i3 = aVar.g;
                } else {
                    aVar.d = e.a.WRAP_CONTENT;
                    interfaceC0050b.a(eVar, aVar);
                    i3 = aVar.i;
                }
                aVar.d = e.a.FIXED;
                if (eVar.ap == 0 || eVar.ap == -1) {
                    aVar.f = (int) (eVar.ac() * i3);
                } else {
                    aVar.f = (int) (eVar.ac() / i3);
                }
            }
        }
        if (z4) {
            if (eVar.I[1] == 4) {
                aVar.e = e.a.FIXED;
            } else if (!z) {
                if (aVar.d == e.a.FIXED) {
                    i2 = aVar.f;
                } else {
                    aVar.e = e.a.WRAP_CONTENT;
                    interfaceC0050b.a(eVar, aVar);
                    i2 = aVar.h;
                }
                aVar.e = e.a.FIXED;
                if (eVar.ap == 0 || eVar.ap == -1) {
                    aVar.g = (int) (i2 / eVar.ac());
                } else {
                    aVar.g = (int) (i2 * eVar.ac());
                }
            }
        }
        interfaceC0050b.a(eVar, aVar);
        eVar.p(aVar.h);
        eVar.q(aVar.i);
        eVar.c(aVar.k);
        eVar.u(aVar.j);
        aVar.m = androidx.d.c.b.a.b.a.f660a;
        return aVar.l;
    }

    private void aB() {
        this.bd = 0;
        this.be = 0;
    }

    private void b(d dVar, androidx.d.c.i iVar) {
        this.aY.a(iVar, this.aY.a(dVar), 0, 5);
    }

    private void d(e eVar) {
        if (this.bd + 1 >= this.bg.length) {
            this.bg = (c[]) Arrays.copyOf(this.bg, this.bg.length * 2);
        }
        this.bg[this.bd] = new c(eVar, 0, as());
        this.bd++;
    }

    private void e(e eVar) {
        if (this.be + 1 >= this.bf.length) {
            this.bf = (c[]) Arrays.copyOf(this.bf, this.bf.length * 2);
        }
        this.bf[this.be] = new c(eVar, 1, as());
        this.be++;
    }

    @Override // androidx.d.c.b.e
    public String D() {
        return "ConstraintLayout";
    }

    public long a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.aZ = i8;
        this.ba = i9;
        return this.b.a(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public void a(int i) {
        this.bv = i;
        androidx.d.c.e eVar = this.aY;
        androidx.d.c.e.d = b(512);
    }

    public void a(androidx.d.c.b.a.b.InterfaceC0050b interfaceC0050b) {
        this.d = interfaceC0050b;
        this.c.a(interfaceC0050b);
    }

    void a(e eVar, int i) {
        if (i == 0) {
            d(eVar);
        } else if (i == 1) {
            e(eVar);
        }
    }

    public void a(androidx.d.c.e eVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zB = b(64);
        b(eVar, zB);
        int size = this.bq.size();
        for (int i = 0; i < size; i++) {
            this.bq.get(i).b(eVar, zB);
        }
    }

    public void a(androidx.d.c.f fVar) {
        this.e = fVar;
        this.aY.a(fVar);
    }

    @Override // androidx.d.c.b.e
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        int size = this.bq.size();
        for (int i = 0; i < size; i++) {
            this.bq.get(i).a(z, z2);
        }
    }

    public boolean a(boolean z) {
        return this.c.a(z);
    }

    public boolean a(boolean z, int i) {
        return this.c.a(z, i);
    }

    public boolean aq() {
        return this.bw;
    }

    public boolean ar() {
        return this.bx;
    }

    public boolean as() {
        return this.bu;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x0328 A[PHI: r0 r6
      0x0328: PHI (r0v22 ??) = (r0v21 ??), (r0v24 ??), (r0v24 ??), (r0v24 ??) binds: [B:150:0x02ea, B:158:0x0310, B:159:0x0312, B:161:0x0318] A[DONT_GENERATE, DONT_INLINE]
      0x0328: PHI (r6v7 boolean) = (r6v6 boolean), (r6v9 boolean), (r6v9 boolean), (r6v9 boolean) binds: [B:150:0x02ea, B:158:0x0310, B:159:0x0312, B:161:0x0318] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r2v35, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.d.c.b.n
    public void at() {
        int i;
        int i2;
        boolean z;
        ?? B;
        boolean z2;
        boolean z3;
        ?? r8;
        boolean z4;
        ?? r0;
        ?? r13;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3 = 0;
        this.aq = 0;
        this.ar = 0;
        this.bw = false;
        this.bx = false;
        int size = this.bq.size();
        int iMax = Math.max(0, I());
        int iMax2 = Math.max(0, L());
        e.a aVar = this.ak[1];
        e.a aVar2 = this.ak[0];
        if (this.e != null) {
            this.e.P++;
        }
        if (k.a(this.bv, 1)) {
            androidx.d.c.b.a.h.a(this, h());
            for (int i4 = 0; i4 < size; i4++) {
                e eVar = this.bq.get(i4);
                if (eVar.t() && !(eVar instanceof h) && !(eVar instanceof a) && !(eVar instanceof m) && !eVar.m()) {
                    if (!(eVar.y(0) == e.a.MATCH_CONSTRAINT && eVar.G != 1 && eVar.y(1) == e.a.MATCH_CONSTRAINT && eVar.H != 1)) {
                        a(eVar, this.d, new androidx.d.c.b.a.b.a(), androidx.d.c.b.a.b.a.f660a);
                    }
                }
            }
        }
        if (size <= 2 || !((aVar2 == e.a.WRAP_CONTENT || aVar == e.a.WRAP_CONTENT) && k.a(this.bv, 1024) && androidx.d.c.b.a.i.a(this, h()))) {
            i = iMax2;
            i2 = iMax;
            z = false;
        } else {
            if (aVar2 == e.a.WRAP_CONTENT) {
                if (iMax >= I() || iMax <= 0) {
                    iMax = I();
                } else {
                    p(iMax);
                    this.bw = true;
                }
            }
            if (aVar == e.a.WRAP_CONTENT) {
                if (iMax2 >= L() || iMax2 <= 0) {
                    iMax2 = L();
                } else {
                    q(iMax2);
                    this.bx = true;
                }
            }
            i = iMax2;
            i2 = iMax;
            z = true;
        }
        boolean z8 = b(64) || b(128);
        this.aY.m = false;
        this.aY.n = false;
        if (this.bv != 0 && z8) {
            this.aY.n = true;
        }
        ArrayList<e> arrayList = this.bq;
        boolean z9 = aj() == e.a.WRAP_CONTENT || ak() == e.a.WRAP_CONTENT;
        aB();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar2 = this.bq.get(i5);
            if (eVar2 instanceof n) {
                ((n) eVar2).at();
            }
        }
        boolean zB = b(64);
        boolean z10 = z;
        int i6 = 0;
        ?? r14 = 1;
        while (r14 != 0) {
            int i7 = i6 + 1;
            try {
                this.aY.b();
                aB();
                a(this.aY);
                for (int i8 = i3; i8 < size; i8++) {
                    this.bq.get(i8).a(this.aY);
                }
                B = b(this.aY);
                try {
                    if (this.by != null && this.by.get() != null) {
                        a(this.by.get(), this.aY.a(this.U));
                        this.by = null;
                    }
                    if (this.bA != null && this.bA.get() != null) {
                        b(this.bA.get(), this.aY.a(this.W));
                        this.bA = null;
                    }
                    if (this.bz != null && this.bz.get() != null) {
                        a(this.bz.get(), this.aY.a(this.T));
                        this.bz = null;
                    }
                    if (this.bB != null && this.bB.get() != null) {
                        b(this.bB.get(), this.aY.a(this.V));
                        this.bB = null;
                    }
                    if (B != 0) {
                        this.aY.g();
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    System.out.println("EXCEPTION : " + e);
                }
            } catch (Exception e2) {
                e = e2;
                B = r14;
            }
            if (B != 0) {
                a(this.aY, k.n);
            } else {
                b(this.aY, zB);
                for (int i9 = 0; i9 < size; i9++) {
                    this.bq.get(i9).b(this.aY, zB);
                }
            }
            if (z9 && i7 < 8 && k.n[2]) {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    e eVar3 = this.bq.get(i10);
                    iMax3 = Math.max(iMax3, eVar3.aq + eVar3.I());
                    iMax4 = Math.max(iMax4, eVar3.ar + eVar3.L());
                }
                int iMax5 = Math.max(this.ax, iMax3);
                int iMax6 = Math.max(this.ay, iMax4);
                if (aVar2 != e.a.WRAP_CONTENT || I() >= iMax5) {
                    z6 = false;
                    z7 = z10;
                } else {
                    p(iMax5);
                    this.ak[0] = e.a.WRAP_CONTENT;
                    z6 = true;
                    z7 = true;
                }
                if (aVar != e.a.WRAP_CONTENT || L() >= iMax6) {
                    z2 = z7;
                    z3 = z6;
                } else {
                    q(iMax6);
                    this.ak[1] = e.a.WRAP_CONTENT;
                    z3 = true;
                    z2 = true;
                }
            } else {
                z2 = z10 ? 1 : 0;
                z3 = false;
            }
            int iMax7 = Math.max(this.ax, I());
            boolean z11 = z3;
            boolean z12 = z2;
            if (iMax7 > I()) {
                p(iMax7);
                this.ak[0] = e.a.FIXED;
                z11 = true;
                z12 = true;
            }
            int iMax8 = Math.max(this.ay, L());
            if (iMax8 > L()) {
                q(iMax8);
                r8 = 1;
                this.ak[1] = e.a.FIXED;
                r0 = 1;
                z4 = true;
            } else {
                r8 = 1;
            }
            if (z4) {
                r0 = z11;
                z4 = z12;
                r13 = r0;
                z5 = z4;
            } else {
                r0 = z11;
                z4 = z12;
                if (this.ak[0] == e.a.WRAP_CONTENT && i2 > 0) {
                    r0 = r0;
                    z4 = z4;
                    if (I() > i2) {
                        this.bw = r8;
                        this.ak[0] = e.a.FIXED;
                        p(i2);
                        ?? r1 = r8;
                        z4 = r1 == true ? 1 : 0;
                        r0 = r1;
                    }
                }
                r0 = r0;
                r0 = r0;
                z4 = z4;
                z4 = z4;
                if (this.ak[r8] != e.a.WRAP_CONTENT || i <= 0 || L() <= i) {
                    r0 = z11;
                    z4 = z12;
                    r13 = r0;
                    z5 = z4;
                } else {
                    this.bx = r8;
                    this.ak[r8] = e.a.FIXED;
                    q(i);
                    r13 = 1;
                    z5 = true;
                }
            }
            i6 = i7;
            i3 = 0;
            r14 = r13;
            z10 = z5;
        }
        this.bq = arrayList;
        if (z10) {
            this.ak[0] = aVar2;
            this.ak[1] = aVar;
        }
        a(this.aY.o());
    }

    public boolean au() {
        return false;
    }

    public ArrayList<h> av() {
        ArrayList<h> arrayList = new ArrayList<>();
        int size = this.bq.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.bq.get(i);
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                if (hVar.f() == 1) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<h> aw() {
        ArrayList<h> arrayList = new ArrayList<>();
        int size = this.bq.size();
        for (int i = 0; i < size; i++) {
            e eVar = this.bq.get(i);
            if (eVar instanceof h) {
                h hVar = (h) eVar;
                if (hVar.f() == 0) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    public androidx.d.c.e ax() {
        return this.aY;
    }

    public void b() {
        this.c.b();
    }

    public void b(int i, int i2, int i3, int i4) {
        this.aZ = i;
        this.ba = i2;
        this.bb = i3;
        this.bc = i4;
    }

    void b(d dVar) {
        if (this.by == null || this.by.get() == null || dVar.d() > this.by.get().d()) {
            this.by = new WeakReference<>(dVar);
        }
    }

    public boolean b(int i) {
        return (this.bv & i) == i;
    }

    public boolean b(androidx.d.c.e eVar) {
        boolean zB = b(64);
        a(eVar, zB);
        int size = this.bq.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            e eVar2 = this.bq.get(i);
            eVar2.a(0, false);
            eVar2.a(1, false);
            if (eVar2 instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                e eVar3 = this.bq.get(i2);
                if (eVar3 instanceof a) {
                    ((a) eVar3).f();
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            e eVar4 = this.bq.get(i3);
            if (eVar4.ap()) {
                eVar4.a(eVar, zB);
            }
        }
        if (androidx.d.c.e.d) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i4 = 0; i4 < size; i4++) {
                e eVar5 = this.bq.get(i4);
                if (!eVar5.ap()) {
                    hashSet.add(eVar5);
                }
            }
            a(this, eVar, hashSet, aj() == e.a.WRAP_CONTENT ? 0 : 1, false);
            for (e eVar6 : hashSet) {
                k.a(this, eVar, eVar6);
                eVar6.a(eVar, zB);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                e eVar7 = this.bq.get(i5);
                if (eVar7 instanceof f) {
                    e.a aVar = eVar7.ak[0];
                    e.a aVar2 = eVar7.ak[1];
                    if (aVar == e.a.WRAP_CONTENT) {
                        eVar7.a(e.a.FIXED);
                    }
                    if (aVar2 == e.a.WRAP_CONTENT) {
                        eVar7.b(e.a.FIXED);
                    }
                    eVar7.a(eVar, zB);
                    if (aVar == e.a.WRAP_CONTENT) {
                        eVar7.a(aVar);
                    }
                    if (aVar2 == e.a.WRAP_CONTENT) {
                        eVar7.b(aVar2);
                    }
                } else {
                    k.a(this, eVar, eVar7);
                    if (!eVar7.ap()) {
                        eVar7.a(eVar, zB);
                    }
                }
            }
        }
        if (this.bd > 0) {
            b.a(this, eVar, null, 0);
        }
        if (this.be > 0) {
            b.a(this, eVar, null, 1);
        }
        return true;
    }

    public void c() {
        this.c.c();
    }

    public void c(d dVar) {
        if (this.bz == null || this.bz.get() == null || dVar.d() > this.bz.get().d()) {
            this.bz = new WeakReference<>(dVar);
        }
    }

    void d(d dVar) {
        if (this.bA == null || this.bA.get() == null || dVar.d() > this.bA.get().d()) {
            this.bA = new WeakReference<>(dVar);
        }
    }

    public void e(d dVar) {
        if (this.bB == null || this.bB.get() == null || dVar.d() > this.bB.get().d()) {
            this.bB = new WeakReference<>(dVar);
        }
    }

    public void f() {
        this.c.a(aj(), ak());
    }

    public void g() {
        this.b.a(this);
    }

    public androidx.d.c.b.a.b.InterfaceC0050b h() {
        return this.d;
    }

    public boolean h(boolean z) {
        return this.c.b(z);
    }

    public int i() {
        return this.bv;
    }

    public void i(boolean z) {
        this.bu = z;
    }

    @Override // androidx.d.c.b.n, androidx.d.c.b.e
    public void w() {
        this.aY.b();
        this.aZ = 0;
        this.bb = 0;
        this.ba = 0;
        this.bc = 0;
        this.bm = false;
        super.w();
    }
}
