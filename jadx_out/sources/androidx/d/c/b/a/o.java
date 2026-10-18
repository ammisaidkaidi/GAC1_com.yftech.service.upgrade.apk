package androidx.d.c.b.a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class o {
    static int b = 0;
    private static final boolean g = false;
    int c;
    int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<androidx.d.c.b.e> f672a = new ArrayList<>();
    boolean d = false;
    ArrayList<a> f = null;
    private int h = -1;

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<androidx.d.c.b.e> f673a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public a(androidx.d.c.b.e eVar, androidx.d.c.e eVar2, int i) {
            this.f673a = new WeakReference<>(eVar);
            this.b = eVar2.b(eVar.T);
            this.c = eVar2.b(eVar.U);
            this.d = eVar2.b(eVar.V);
            this.e = eVar2.b(eVar.W);
            this.f = eVar2.b(eVar.X);
            this.g = i;
        }

        public void a() {
            androidx.d.c.b.e eVar = this.f673a.get();
            if (eVar != null) {
                eVar.a(this.b, this.c, this.d, this.e, this.f, this.g);
            }
        }
    }

    public o(int i) {
        this.c = -1;
        this.e = 0;
        int i2 = b;
        b = i2 + 1;
        this.c = i2;
        this.e = i;
    }

    private int a(int i, androidx.d.c.b.e eVar) {
        androidx.d.c.b.e.a aVarY = eVar.y(i);
        if (aVarY == androidx.d.c.b.e.a.WRAP_CONTENT || aVarY == androidx.d.c.b.e.a.MATCH_PARENT || aVarY == androidx.d.c.b.e.a.FIXED) {
            return i == 0 ? eVar.I() : eVar.L();
        }
        return -1;
    }

    private int a(androidx.d.c.e eVar, ArrayList<androidx.d.c.b.e> arrayList, int i) {
        androidx.d.c.b.f fVar = (androidx.d.c.b.f) arrayList.get(0).A();
        eVar.b();
        fVar.a(eVar, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).a(eVar, false);
        }
        if (i == 0 && fVar.bd > 0) {
            androidx.d.c.b.b.a(fVar, eVar, arrayList, 0);
        }
        if (i == 1 && fVar.be > 0) {
            androidx.d.c.b.b.a(fVar, eVar, arrayList, 1);
        }
        try {
            eVar.g();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f.add(new a(arrayList.get(i3), eVar, i));
        }
        if (i == 0) {
            int iB = eVar.b(fVar.T);
            int iB2 = eVar.b(fVar.V);
            eVar.b();
            return iB2 - iB;
        }
        int iB3 = eVar.b(fVar.U);
        int iB4 = eVar.b(fVar.W);
        eVar.b();
        return iB4 - iB3;
    }

    private boolean b(androidx.d.c.b.e eVar) {
        return this.f672a.contains(eVar);
    }

    private String g() {
        if (this.e == 0) {
            return "Horizontal";
        }
        if (this.e == 1) {
            return "Vertical";
        }
        return this.e == 2 ? "Both" : "Unknown";
    }

    public int a() {
        return this.e;
    }

    public int a(androidx.d.c.e eVar, int i) {
        if (this.f672a.size() == 0) {
            return 0;
        }
        return a(eVar, this.f672a, i);
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(int i, o oVar) {
        for (androidx.d.c.b.e eVar : this.f672a) {
            oVar.a(eVar);
            if (i == 0) {
                eVar.aW = oVar.b();
            } else {
                eVar.aX = oVar.b();
            }
        }
        this.h = oVar.c;
    }

    public void a(ArrayList<o> arrayList) {
        int size = this.f672a.size();
        if (this.h != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                o oVar = arrayList.get(i);
                if (this.h == oVar.c) {
                    a(this.e, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a(o oVar) {
        for (int i = 0; i < this.f672a.size(); i++) {
            if (oVar.b(this.f672a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(androidx.d.c.b.e eVar) {
        if (this.f672a.contains(eVar)) {
            return false;
        }
        this.f672a.add(eVar);
        return true;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public void d() {
        this.f672a.clear();
    }

    public void e() {
        if (this.f != null && this.d) {
            for (int i = 0; i < this.f.size(); i++) {
                this.f.get(i).a();
            }
        }
    }

    public int f() {
        return this.f672a.size();
    }

    public String toString() {
        String str = g() + " [" + this.c + "] <";
        Iterator<androidx.d.c.b.e> it = this.f672a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().F();
        }
        return str + " >";
    }
}
