package androidx.recyclerview.widget;

import androidx.annotation.ai;
import androidx.annotation.ax;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<f> f1065a = new Comparator<f>() { // from class: androidx.recyclerview.widget.i.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            int i = fVar.f1069a - fVar2.f1069a;
            return i == 0 ? fVar.b - fVar2.b : i;
        }
    };

    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i, int i2);

        public abstract int b();

        public abstract boolean b(int i, int i2);

        @ai
        public Object c(int i, int i2) {
            return null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1066a = -1;
        private static final int b = 1;
        private static final int c = 2;
        private static final int d = 4;
        private static final int e = 8;
        private static final int f = 16;
        private static final int g = 5;
        private static final int h = 31;
        private final List<f> i;
        private final int[] j;
        private final int[] k;
        private final a l;
        private final int m;
        private final int n;
        private final boolean o;

        b(a aVar, List<f> list, int[] iArr, int[] iArr2, boolean z) {
            this.i = list;
            this.j = iArr;
            this.k = iArr2;
            Arrays.fill(this.j, 0);
            Arrays.fill(this.k, 0);
            this.l = aVar;
            this.m = aVar.a();
            this.n = aVar.b();
            this.o = z;
            b();
            c();
        }

        private static d a(List<d> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = list.get(size);
                if (dVar.f1067a == i && dVar.c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).b += z ? 1 : -1;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        private void a(int i, int i2, int i3) {
            if (this.j[i - 1] != 0) {
                return;
            }
            a(i, i2, i3, false);
        }

        private void a(List<d> list, t tVar, int i, int i2, int i3) {
            if (!this.o) {
                tVar.a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.k[i5] & 31;
                if (i6 == 0) {
                    tVar.a(i, 1);
                    Iterator<d> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.k[i5] >> 5;
                    tVar.c(a(list, i7, true).b, i);
                    if (i6 == 4) {
                        tVar.a(i, 1, this.l.c(i7, i5));
                    }
                } else {
                    if (i6 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                    }
                    list.add(new d(i5, i, false));
                }
            }
        }

        private boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                f fVar = this.i.get(i3);
                int i7 = fVar.f1069a + fVar.c;
                int i8 = fVar.b + fVar.c;
                if (z) {
                    for (int i9 = i4 - 1; i9 >= i7; i9--) {
                        if (this.l.a(i9, i5)) {
                            i6 = this.l.b(i9, i5) ? 8 : 4;
                            this.k[i5] = (i9 << 5) | 16;
                            this.j[i9] = (i5 << 5) | i6;
                            return true;
                        }
                    }
                } else {
                    for (int i10 = i2 - 1; i10 >= i8; i10--) {
                        if (this.l.a(i5, i10)) {
                            i6 = this.l.b(i5, i10) ? 8 : 4;
                            int i11 = i - 1;
                            this.j[i11] = (i10 << 5) | 16;
                            this.k[i10] = (i11 << 5) | i6;
                            return true;
                        }
                    }
                }
                i4 = fVar.f1069a;
                i2 = fVar.b;
                i3--;
            }
            return false;
        }

        private void b() {
            f fVar = this.i.isEmpty() ? null : this.i.get(0);
            if (fVar != null && fVar.f1069a == 0 && fVar.b == 0) {
                return;
            }
            f fVar2 = new f();
            fVar2.f1069a = 0;
            fVar2.b = 0;
            fVar2.d = false;
            fVar2.c = 0;
            fVar2.e = false;
            this.i.add(0, fVar2);
        }

        private void b(int i, int i2, int i3) {
            if (this.k[i2 - 1] != 0) {
                return;
            }
            a(i, i2, i3, true);
        }

        private void b(List<d> list, t tVar, int i, int i2, int i3) {
            if (!this.o) {
                tVar.b(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.j[i5] & 31;
                if (i6 == 0) {
                    tVar.b(i + i4, 1);
                    Iterator<d> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.j[i5] >> 5;
                    d dVarA = a(list, i7, false);
                    tVar.c(i + i4, dVarA.b - 1);
                    if (i6 == 4) {
                        tVar.a(dVarA.b - 1, 1, this.l.c(i5, i7));
                    }
                } else {
                    if (i6 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                    }
                    list.add(new d(i5, i + i4, true));
                }
            }
        }

        private void c() {
            int i = this.m;
            int i2 = this.n;
            for (int size = this.i.size() - 1; size >= 0; size--) {
                f fVar = this.i.get(size);
                int i3 = fVar.f1069a + fVar.c;
                int i4 = fVar.b + fVar.c;
                if (this.o) {
                    while (i > i3) {
                        a(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        b(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < fVar.c; i5++) {
                    int i6 = fVar.f1069a + i5;
                    int i7 = fVar.b + i5;
                    int i8 = this.l.b(i6, i7) ? 1 : 2;
                    this.j[i6] = (i7 << 5) | i8;
                    this.k[i7] = (i6 << 5) | i8;
                }
                i = fVar.f1069a;
                i2 = fVar.b;
            }
        }

        public int a(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
            if (i >= 0 && i < this.m) {
                int i2 = this.j[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.m);
        }

        @ax
        List<f> a() {
            return this.i;
        }

        public void a(@androidx.annotation.ah RecyclerView.a aVar) {
            a(new androidx.recyclerview.widget.b(aVar));
        }

        public void a(@androidx.annotation.ah t tVar) {
            androidx.recyclerview.widget.f fVar = tVar instanceof androidx.recyclerview.widget.f ? (androidx.recyclerview.widget.f) tVar : new androidx.recyclerview.widget.f(tVar);
            List<d> arrayList = new ArrayList<>();
            int i = this.m;
            int i2 = this.n;
            for (int size = this.i.size() - 1; size >= 0; size--) {
                f fVar2 = this.i.get(size);
                int i3 = fVar2.c;
                int i4 = fVar2.f1069a + i3;
                int i5 = fVar2.b + i3;
                if (i4 < i) {
                    b(arrayList, fVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, fVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.j[fVar2.f1069a + i6] & 31) == 2) {
                        fVar.a(fVar2.f1069a + i6, 1, this.l.c(fVar2.f1069a + i6, fVar2.b + i6));
                    }
                }
                i = fVar2.f1069a;
                i2 = fVar2.b;
            }
            fVar.a();
        }

        public int b(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i) {
            if (i >= 0 && i < this.n) {
                int i2 = this.k[i];
                if ((i2 & 31) == 0) {
                    return -1;
                }
                return i2 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.n);
        }
    }

    public static abstract class c<T> {
        public abstract boolean a(@androidx.annotation.ah T t, @androidx.annotation.ah T t2);

        public abstract boolean b(@androidx.annotation.ah T t, @androidx.annotation.ah T t2);

        @ai
        public Object c(@androidx.annotation.ah T t, @androidx.annotation.ah T t2) {
            return null;
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1067a;
        int b;
        boolean c;

        public d(int i, int i2, boolean z) {
            this.f1067a = i;
            this.b = i2;
            this.c = z;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1068a;
        int b;
        int c;
        int d;

        public e() {
        }

        public e(int i, int i2, int i3, int i4) {
            this.f1068a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1069a;
        int b;
        int c;
        boolean d;
        boolean e;

        f() {
        }
    }

    private i() {
    }

    @androidx.annotation.ah
    public static b a(@androidx.annotation.ah a aVar) {
        return a(aVar, true);
    }

    @androidx.annotation.ah
    public static b a(@androidx.annotation.ah a aVar, boolean z) {
        int iA = aVar.a();
        int iB = aVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(0, iA, 0, iB));
        int iAbs = Math.abs(iA - iB) + iA + iB;
        int i = iAbs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar = (e) arrayList2.remove(arrayList2.size() - 1);
            f fVarA = a(aVar, eVar.f1068a, eVar.b, eVar.c, eVar.d, iArr, iArr2, iAbs);
            if (fVarA != null) {
                if (fVarA.c > 0) {
                    arrayList.add(fVarA);
                }
                fVarA.f1069a += eVar.f1068a;
                fVarA.b += eVar.c;
                e eVar2 = arrayList3.isEmpty() ? new e() : (e) arrayList3.remove(arrayList3.size() - 1);
                eVar2.f1068a = eVar.f1068a;
                eVar2.c = eVar.c;
                if (fVarA.e) {
                    eVar2.b = fVarA.f1069a;
                    eVar2.d = fVarA.b;
                } else if (fVarA.d) {
                    eVar2.b = fVarA.f1069a - 1;
                    eVar2.d = fVarA.b;
                } else {
                    eVar2.b = fVarA.f1069a;
                    eVar2.d = fVarA.b - 1;
                }
                arrayList2.add(eVar2);
                if (!fVarA.e) {
                    eVar.f1068a = fVarA.f1069a + fVarA.c;
                    eVar.c = fVarA.b + fVarA.c;
                } else if (fVarA.d) {
                    eVar.f1068a = fVarA.f1069a + fVarA.c + 1;
                    eVar.c = fVarA.b + fVarA.c;
                } else {
                    eVar.f1068a = fVarA.f1069a + fVarA.c;
                    eVar.c = fVarA.b + fVarA.c + 1;
                }
                arrayList2.add(eVar);
            } else {
                arrayList3.add(eVar);
            }
        }
        Collections.sort(arrayList, f1065a);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:23:0x0062
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static androidx.recyclerview.widget.i.f a(androidx.recyclerview.widget.i.a r21, int r22, int r23, int r24, int r25, int[] r26, int[] r27, int r28) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.a(androidx.recyclerview.widget.i$a, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.i$f");
    }
}
