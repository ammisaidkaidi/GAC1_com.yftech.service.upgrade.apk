package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a implements v.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1025a = 0;
    static final int b = 1;
    private static final boolean i = false;
    private static final String j = "AHT";
    final ArrayList<b> c;
    final ArrayList<b> d;
    final InterfaceC0074a e;
    Runnable f;
    final boolean g;
    final v h;
    private androidx.core.m.h.a<b> k;
    private int l;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0074a {
        RecyclerView.z a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f1026a = 1;
        static final int b = 2;
        static final int c = 4;
        static final int d = 8;
        static final int e = 30;
        int f;
        int g;
        Object h;
        int i;

        b(int i, int i2, int i3, Object obj) {
            this.f = i;
            this.g = i2;
            this.i = i3;
            this.h = obj;
        }

        String a() {
            int i = this.f;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f != bVar.f) {
                return false;
            }
            if (this.f == 8 && Math.abs(this.i - this.g) == 1 && this.i == bVar.g && this.g == bVar.i) {
                return true;
            }
            if (this.i != bVar.i || this.g != bVar.g) {
                return false;
            }
            if (this.h != null) {
                if (!this.h.equals(bVar.h)) {
                    return false;
                }
            } else if (bVar.h != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f * 31) + this.g) * 31) + this.i;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.g + "c:" + this.i + ",p:" + this.h + "]";
        }
    }

    a(InterfaceC0074a interfaceC0074a) {
        this(interfaceC0074a, false);
    }

    a(InterfaceC0074a interfaceC0074a, boolean z) {
        this.k = new androidx.core.m.h.b(30);
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.l = 0;
        this.e = interfaceC0074a;
        this.g = z;
        this.h = new v(this);
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        boolean z;
        byte b2;
        int i2 = bVar.g;
        int i3 = bVar.g + bVar.i;
        int i4 = bVar.g;
        byte b3 = -1;
        int i5 = 0;
        while (i4 < i3) {
            if (this.e.a(i4) != null || d(i4)) {
                if (b3 == 0) {
                    e(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    g(a(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            b3 = b2;
        }
        if (i5 != bVar.i) {
            a(bVar);
            bVar = a(2, i2, i5, null);
        }
        if (b3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private int d(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.d.size() - 1; size >= 0; size--) {
            b bVar = this.d.get(size);
            if (bVar.f == 8) {
                if (bVar.g < bVar.i) {
                    i4 = bVar.g;
                    i5 = bVar.i;
                } else {
                    i4 = bVar.i;
                    i5 = bVar.g;
                }
                if (i2 < i4 || i2 > i5) {
                    if (i2 < bVar.g) {
                        if (i3 == 1) {
                            bVar.g++;
                            bVar.i++;
                        } else if (i3 == 2) {
                            bVar.g--;
                            bVar.i--;
                        }
                    }
                } else if (i4 == bVar.g) {
                    if (i3 == 1) {
                        bVar.i++;
                    } else if (i3 == 2) {
                        bVar.i--;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.g++;
                    } else if (i3 == 2) {
                        bVar.g--;
                    }
                    i2--;
                }
            } else if (bVar.g <= i2) {
                if (bVar.f == 1) {
                    i2 -= bVar.i;
                } else if (bVar.f == 2) {
                    i2 += bVar.i;
                }
            } else if (i3 == 1) {
                bVar.g++;
            } else if (i3 == 2) {
                bVar.g--;
            }
        }
        for (int size2 = this.d.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.d.get(size2);
            if (bVar2.f == 8) {
                if (bVar2.i == bVar2.g || bVar2.i < 0) {
                    this.d.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.i <= 0) {
                this.d.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    private void d(b bVar) {
        int i2 = bVar.g;
        int i3 = bVar.g + bVar.i;
        byte b2 = -1;
        int i4 = i2;
        int i5 = 0;
        for (int i6 = bVar.g; i6 < i3; i6++) {
            if (this.e.a(i6) != null || d(i6)) {
                if (b2 == 0) {
                    e(a(4, i4, i5, bVar.h));
                    i4 = i6;
                    i5 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    g(a(4, i4, i5, bVar.h));
                    i4 = i6;
                    i5 = 0;
                }
                b2 = 0;
            }
            i5++;
        }
        if (i5 != bVar.i) {
            Object obj = bVar.h;
            a(bVar);
            bVar = a(4, i4, i5, obj);
        }
        if (b2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i2) {
        int size = this.d.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.d.get(i3);
            if (bVar.f == 8) {
                if (a(bVar.i, i3 + 1) == i2) {
                    return true;
                }
            } else if (bVar.f == 1) {
                int i4 = bVar.g + bVar.i;
                for (int i5 = bVar.g; i5 < i4; i5++) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        int i2;
        if (bVar.f == 1 || bVar.f == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iD = d(bVar.g, bVar.f);
        int i3 = bVar.g;
        int i4 = bVar.f;
        if (i4 == 2) {
            i2 = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i2 = 1;
        }
        int i5 = iD;
        int i6 = i3;
        int i7 = 1;
        for (int i8 = 1; i8 < bVar.i; i8++) {
            int iD2 = d(bVar.g + (i2 * i8), bVar.f);
            int i9 = bVar.f;
            if (i9 == 2 ? iD2 == i5 : i9 == 4 && iD2 == i5 + 1) {
                i7++;
            } else {
                b bVarA = a(bVar.f, i5, i7, bVar.h);
                a(bVarA, i6);
                a(bVarA);
                if (bVar.f == 4) {
                    i6 += i7;
                }
                i7 = 1;
                i5 = iD2;
            }
        }
        Object obj = bVar.h;
        a(bVar);
        if (i7 > 0) {
            b bVarA2 = a(bVar.f, i5, i7, obj);
            a(bVarA2, i6);
            a(bVarA2);
        }
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.d.add(bVar);
        int i2 = bVar.f;
        if (i2 == 4) {
            this.e.a(bVar.g, bVar.i, bVar.h);
            return;
        }
        if (i2 == 8) {
            this.e.d(bVar.g, bVar.i);
            return;
        }
        switch (i2) {
            case 1:
                this.e.c(bVar.g, bVar.i);
                return;
            case 2:
                this.e.b(bVar.g, bVar.i);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    int a(int i2, int i3) {
        int size = this.d.size();
        while (i3 < size) {
            b bVar = this.d.get(i3);
            if (bVar.f == 8) {
                if (bVar.g == i2) {
                    i2 = bVar.i;
                } else {
                    if (bVar.g < i2) {
                        i2--;
                    }
                    if (bVar.i <= i2) {
                        i2++;
                    }
                }
            } else if (bVar.g > i2) {
                continue;
            } else if (bVar.f == 2) {
                if (i2 < bVar.g + bVar.i) {
                    return -1;
                }
                i2 -= bVar.i;
            } else if (bVar.f == 1) {
                i2 += bVar.i;
            }
            i3++;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.v.a
    public b a(int i2, int i3, int i4, Object obj) {
        b bVarA = this.k.a();
        if (bVarA == null) {
            return new b(i2, i3, i4, obj);
        }
        bVarA.f = i2;
        bVarA.g = i3;
        bVarA.i = i4;
        bVarA.h = obj;
        return bVarA;
    }

    a a(b... bVarArr) {
        Collections.addAll(this.c, bVarArr);
        return this;
    }

    void a() {
        a(this.c);
        a(this.d);
        this.l = 0;
    }

    @Override // androidx.recyclerview.widget.v.a
    public void a(b bVar) {
        if (this.g) {
            return;
        }
        bVar.h = null;
        this.k.a(bVar);
    }

    void a(b bVar, int i2) {
        this.e.a(bVar);
        int i3 = bVar.f;
        if (i3 == 2) {
            this.e.a(i2, bVar.i);
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.e.a(i2, bVar.i, bVar.h);
        }
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    boolean a(int i2) {
        return (this.l & i2) != 0;
    }

    boolean a(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.c.add(a(8, i2, i3, null));
        this.l |= 8;
        return this.c.size() == 1;
    }

    boolean a(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.c.add(a(4, i2, i3, obj));
        this.l |= 4;
        return this.c.size() == 1;
    }

    int b(int i2) {
        return a(i2, 0);
    }

    void b() {
        this.h.a(this.c);
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            int i3 = bVar.f;
            if (i3 == 4) {
                d(bVar);
            } else if (i3 != 8) {
                switch (i3) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            if (this.f != null) {
                this.f.run();
            }
        }
        this.c.clear();
    }

    boolean b(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.c.add(a(1, i2, i3, null));
        this.l |= 1;
        return this.c.size() == 1;
    }

    public int c(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.c.get(i3);
            int i4 = bVar.f;
            if (i4 != 8) {
                switch (i4) {
                    case 1:
                        if (bVar.g <= i2) {
                            i2 += bVar.i;
                        }
                        break;
                    case 2:
                        if (bVar.g > i2) {
                            continue;
                        } else {
                            if (bVar.g + bVar.i > i2) {
                                return -1;
                            }
                            i2 -= bVar.i;
                        }
                        break;
                }
            } else if (bVar.g == i2) {
                i2 = bVar.i;
            } else {
                if (bVar.g < i2) {
                    i2--;
                }
                if (bVar.i <= i2) {
                    i2++;
                }
            }
        }
        return i2;
    }

    void c() {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.e.b(this.d.get(i2));
        }
        a(this.d);
        this.l = 0;
    }

    boolean c(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.c.add(a(2, i2, i3, null));
        this.l |= 2;
        return this.c.size() == 1;
    }

    boolean d() {
        return this.c.size() > 0;
    }

    void e() {
        c();
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            int i3 = bVar.f;
            if (i3 == 4) {
                this.e.b(bVar);
                this.e.a(bVar.g, bVar.i, bVar.h);
            } else if (i3 != 8) {
                switch (i3) {
                    case 1:
                        this.e.b(bVar);
                        this.e.c(bVar.g, bVar.i);
                        break;
                    case 2:
                        this.e.b(bVar);
                        this.e.a(bVar.g, bVar.i);
                        break;
                }
            } else {
                this.e.b(bVar);
                this.e.d(bVar.g, bVar.i);
            }
            if (this.f != null) {
                this.f.run();
            }
        }
        a(this.c);
        this.l = 0;
    }

    boolean f() {
        return (this.d.isEmpty() || this.c.isEmpty()) ? false : true;
    }
}
