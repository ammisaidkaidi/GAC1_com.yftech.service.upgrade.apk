package androidx.d.c;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class j implements b.a {
    private static final boolean j = false;
    private static final boolean k = true;
    private static float l = 0.001f;
    protected final c i;
    private final b p;
    private final int m = -1;
    private int n = 16;
    private int o = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f702a = new int[this.n];
    int[] b = new int[this.n];
    int[] c = new int[this.n];
    float[] d = new float[this.n];
    int[] e = new int[this.n];
    int[] f = new int[this.n];
    int g = 0;
    int h = -1;

    j(b bVar, c cVar) {
        this.p = bVar;
        this.i = cVar;
        a();
    }

    private void a(int i, i iVar, float f) {
        this.c[i] = iVar.k;
        this.d[i] = f;
        this.e[i] = -1;
        this.f[i] = -1;
        iVar.a(this.p);
        iVar.v++;
        this.g++;
    }

    private void a(i iVar, int i) {
        int i2 = iVar.k % this.o;
        int i3 = this.f702a[i2];
        if (i3 == -1) {
            this.f702a[i2] = i;
        } else {
            while (this.b[i3] != -1) {
                i3 = this.b[i3];
            }
            this.b[i3] = i;
        }
        this.b[i] = -1;
    }

    private void b() {
        int i = this.n * 2;
        this.c = Arrays.copyOf(this.c, i);
        this.d = Arrays.copyOf(this.d, i);
        this.e = Arrays.copyOf(this.e, i);
        this.f = Arrays.copyOf(this.f, i);
        this.b = Arrays.copyOf(this.b, i);
        for (int i2 = this.n; i2 < i; i2++) {
            this.c[i2] = -1;
            this.b[i2] = -1;
        }
        this.n = i;
    }

    private void b(int i, i iVar, float f) {
        int iF = f();
        a(iF, iVar, f);
        if (i != -1) {
            this.e[iF] = i;
            this.f[iF] = this.f[i];
            this.f[i] = iF;
        } else {
            this.e[iF] = -1;
            if (this.g > 0) {
                this.f[iF] = this.h;
                this.h = iF;
            } else {
                this.f[iF] = -1;
            }
        }
        if (this.f[iF] != -1) {
            this.e[this.f[iF]] = iF;
        }
        a(iVar, iF);
    }

    private void d() {
        for (int i = 0; i < this.o; i++) {
            if (this.f702a[i] != -1) {
                String str = hashCode() + " hash [" + i + "] => ";
                int i2 = this.f702a[i];
                String str2 = str;
                boolean z = false;
                while (!z) {
                    str2 = str2 + " " + this.c[i2];
                    if (this.b[i2] != -1) {
                        i2 = this.b[i2];
                    } else {
                        z = k;
                    }
                }
                System.out.println(str2);
            }
        }
    }

    private void d(i iVar) {
        int i = iVar.k % this.o;
        int i2 = this.f702a[i];
        if (i2 == -1) {
            return;
        }
        int i3 = iVar.k;
        if (this.c[i2] == i3) {
            this.f702a[i] = this.b[i2];
            this.b[i2] = -1;
            return;
        }
        while (this.b[i2] != -1 && this.c[this.b[i2]] != i3) {
            i2 = this.b[i2];
        }
        int i4 = this.b[i2];
        if (i4 == -1 || this.c[i4] != i3) {
            return;
        }
        this.b[i2] = this.b[i4];
        this.b[i4] = -1;
    }

    private int f() {
        for (int i = 0; i < this.n; i++) {
            if (this.c[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.d.c.b.a
    public float a(b bVar, boolean z) {
        float fC = c(bVar.f657a);
        a(bVar.f657a, z);
        j jVar = (j) bVar.e;
        int iE = jVar.e();
        int i = jVar.h;
        int i2 = 0;
        int i3 = 0;
        while (i2 < iE) {
            if (jVar.c[i3] != -1) {
                a(this.i.d[jVar.c[i3]], jVar.d[i3] * fC, z);
                i2++;
            }
            i3++;
        }
        return fC;
    }

    @Override // androidx.d.c.b.a
    public float a(i iVar, boolean z) {
        int iB = b(iVar);
        if (iB == -1) {
            return 0.0f;
        }
        d(iVar);
        float f = this.d[iB];
        if (this.h == iB) {
            this.h = this.f[iB];
        }
        this.c[iB] = -1;
        if (this.e[iB] != -1) {
            this.f[this.e[iB]] = this.f[iB];
        }
        if (this.f[iB] != -1) {
            this.e[this.f[iB]] = this.e[iB];
        }
        this.g--;
        iVar.v--;
        if (z) {
            iVar.b(this.p);
        }
        return f;
    }

    @Override // androidx.d.c.b.a
    public void a() {
        int i = this.g;
        for (int i2 = 0; i2 < i; i2++) {
            i iVarD = d(i2);
            if (iVarD != null) {
                iVarD.b(this.p);
            }
        }
        for (int i3 = 0; i3 < this.n; i3++) {
            this.c[i3] = -1;
            this.b[i3] = -1;
        }
        for (int i4 = 0; i4 < this.o; i4++) {
            this.f702a[i4] = -1;
        }
        this.g = 0;
        this.h = -1;
    }

    @Override // androidx.d.c.b.a
    public void a(float f) {
        int i = this.g;
        int i2 = this.h;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.d;
            fArr[i2] = fArr[i2] / f;
            i2 = this.f[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.d.c.b.a
    public void a(i iVar, float f) {
        if (f > (-l) && f < l) {
            a(iVar, k);
            return;
        }
        if (this.g == 0) {
            a(0, iVar, f);
            a(iVar, 0);
            this.h = 0;
            return;
        }
        int iB = b(iVar);
        if (iB != -1) {
            this.d[iB] = f;
            return;
        }
        if (this.g + 1 >= this.n) {
            b();
        }
        int i = this.g;
        int i2 = this.h;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            if (this.c[i2] == iVar.k) {
                this.d[i2] = f;
                return;
            }
            if (this.c[i2] < iVar.k) {
                i3 = i2;
            }
            i2 = this.f[i2];
            if (i2 == -1) {
                break;
            }
        }
        b(i3, iVar, f);
    }

    @Override // androidx.d.c.b.a
    public void a(i iVar, float f, boolean z) {
        if (f <= (-l) || f >= l) {
            int iB = b(iVar);
            if (iB == -1) {
                a(iVar, f);
                return;
            }
            float[] fArr = this.d;
            fArr[iB] = fArr[iB] + f;
            if (this.d[iB] <= (-l) || this.d[iB] >= l) {
                return;
            }
            this.d[iB] = 0.0f;
            a(iVar, z);
        }
    }

    @Override // androidx.d.c.b.a
    public boolean a(i iVar) {
        if (b(iVar) != -1) {
            return k;
        }
        return false;
    }

    @Override // androidx.d.c.b.a
    public int b(i iVar) {
        if (this.g == 0 || iVar == null) {
            return -1;
        }
        int i = iVar.k;
        int i2 = this.f702a[i % this.o];
        if (i2 == -1) {
            return -1;
        }
        if (this.c[i2] == i) {
            return i2;
        }
        while (this.b[i2] != -1 && this.c[this.b[i2]] != i) {
            i2 = this.b[i2];
        }
        if (this.b[i2] != -1 && this.c[this.b[i2]] == i) {
            return this.b[i2];
        }
        return -1;
    }

    @Override // androidx.d.c.b.a
    public float c(i iVar) {
        int iB = b(iVar);
        if (iB != -1) {
            return this.d[iB];
        }
        return 0.0f;
    }

    @Override // androidx.d.c.b.a
    public void c() {
        int i = this.g;
        int i2 = this.h;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.d;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    @Override // androidx.d.c.b.a
    public i d(int i) {
        int i2 = this.g;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.h;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.i.d[this.c[i3]];
            }
            i3 = this.f[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.d.c.b.a
    public float e(int i) {
        int i2 = this.g;
        int i3 = this.h;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.d[i3];
            }
            i3 = this.f[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.d.c.b.a
    public int e() {
        return this.g;
    }

    @Override // androidx.d.c.b.a
    public int g() {
        return 0;
    }

    @Override // androidx.d.c.b.a
    public void h() {
        int i = this.g;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            i iVarD = d(i2);
            if (iVarD != null) {
                System.out.print(iVarD + " = " + e(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i = this.g;
        for (int i2 = 0; i2 < i; i2++) {
            i iVarD = d(i2);
            if (iVarD != null) {
                String str2 = str + iVarD + " = " + e(i2) + " ";
                int iB = b(iVarD);
                String str3 = str2 + "[p: ";
                String str4 = (this.e[iB] != -1 ? str3 + this.i.d[this.c[this.e[iB]]] : str3 + "none") + ", n: ";
                str = (this.f[iB] != -1 ? str4 + this.i.d[this.c[this.f[iB]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
