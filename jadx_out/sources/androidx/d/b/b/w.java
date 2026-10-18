package androidx.d.b.b;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    private static final String d = "SplineSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected androidx.d.b.a.b f635a;
    protected int[] b = new int[10];
    protected float[] c = new float[10];
    private int e;
    private String f;

    static class a extends w {
        a() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setAlpha(a(f));
        }
    }

    static class b extends w {
        String d;
        SparseArray<androidx.d.e.b> e;
        float[] f;

        public b(String str, SparseArray<androidx.d.e.b> sparseArray) {
            this.d = str.split(",")[1];
            this.e = sparseArray;
        }

        @Override // androidx.d.b.b.w
        public void a(int i) {
            int size = this.e.size();
            int iB = this.e.valueAt(0).b();
            double[] dArr = new double[size];
            this.f = new float[iB];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, size, iB);
            for (int i2 = 0; i2 < size; i2++) {
                int iKeyAt = this.e.keyAt(i2);
                androidx.d.e.b bVarValueAt = this.e.valueAt(i2);
                dArr[i2] = ((double) iKeyAt) * 0.01d;
                bVarValueAt.a(this.f);
                for (int i3 = 0; i3 < this.f.length; i3++) {
                    dArr2[i2][i3] = this.f[i3];
                }
            }
            this.f635a = androidx.d.b.a.b.a(i, dArr, dArr2);
        }

        @Override // androidx.d.b.b.w
        public void a(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void a(int i, androidx.d.e.b bVar) {
            this.e.append(i, bVar);
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            this.f635a.a(f, this.f);
            this.e.valueAt(0).a(view, this.f);
        }
    }

    static class c extends w {
        c() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f));
            }
        }
    }

    static class d extends w {
        d() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
        }

        public void a(View view, float f, double d, double d2) {
            view.setRotation(a(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    static class e extends w {
        e() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setPivotX(a(f));
        }
    }

    static class f extends w {
        f() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setPivotY(a(f));
        }
    }

    static class g extends w {
        boolean d = false;

        g() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) throws NoSuchMethodException {
            if (view instanceof s) {
                ((s) view).setProgress(a(f));
                return;
            }
            if (this.d) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.d = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f)));
                } catch (IllegalAccessException e) {
                    Log.e(w.d, "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e(w.d, "unable to setProgress", e2);
                }
            }
        }
    }

    static class h extends w {
        h() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setRotation(a(f));
        }
    }

    static class i extends w {
        i() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setRotationX(a(f));
        }
    }

    static class j extends w {
        j() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setRotationY(a(f));
        }
    }

    static class k extends w {
        k() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setScaleX(a(f));
        }
    }

    static class l extends w {
        l() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setScaleY(a(f));
        }
    }

    private static class m {
        private m() {
        }

        static void a(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int iB = b(iArr, fArr, i5, i6);
                    int i7 = i3 + 1;
                    iArr2[i3] = iB - 1;
                    int i8 = i7 + 1;
                    iArr2[i7] = i5;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    i3 = i9 + 1;
                    iArr2[i9] = iB + 1;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            c(iArr, fArr, i4, i2);
            return i4;
        }

        private static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    static class n extends w {
        n() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setTranslationX(a(f));
        }
    }

    static class o extends w {
        o() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            view.setTranslationY(a(f));
        }
    }

    static class p extends w {
        p() {
        }

        @Override // androidx.d.b.b.w
        public void a(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f));
            }
        }
    }

    static w a(String str, SparseArray<androidx.d.e.b> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00b8  */
    static w b(String str) {
        switch (str) {
            case "alpha":
                return new a();
            case "elevation":
                return new c();
            case "rotation":
                return new h();
            case "rotationX":
                return new i();
            case "rotationY":
                return new j();
            case "transformPivotX":
                return new e();
            case "transformPivotY":
                return new f();
            case "transitionPathRotate":
                return new d();
            case "scaleX":
                return new k();
            case "scaleY":
                return new l();
            case "waveOffset":
                return new a();
            case "waveVariesBy":
                return new a();
            case "translationX":
                return new n();
            case "translationY":
                return new o();
            case "translationZ":
                return new p();
            case "progress":
                return new g();
            default:
                return null;
        }
    }

    public float a(float f2) {
        return (float) this.f635a.a(f2, 0);
    }

    public androidx.d.b.a.b a() {
        return this.f635a;
    }

    public void a(int i2) {
        if (this.e == 0) {
            return;
        }
        m.a(this.b, this.c, 0, this.e - 1);
        int i3 = 1;
        for (int i4 = 1; i4 < this.e; i4++) {
            if (this.b[i4 - 1] != this.b[i4]) {
                i3++;
            }
        }
        double[] dArr = new double[i3];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) double.class, i3, 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.e; i6++) {
            if (i6 <= 0 || this.b[i6] != this.b[i6 - 1]) {
                dArr[i5] = ((double) this.b[i6]) * 0.01d;
                dArr2[i5][0] = this.c[i6];
                i5++;
            }
        }
        this.f635a = androidx.d.b.a.b.a(i2, dArr, dArr2);
    }

    public void a(int i2, float f2) {
        if (this.b.length < this.e + 1) {
            this.b = Arrays.copyOf(this.b, this.b.length * 2);
            this.c = Arrays.copyOf(this.c, this.c.length * 2);
        }
        this.b[this.e] = i2;
        this.c[this.e] = f2;
        this.e++;
    }

    public abstract void a(View view, float f2);

    public void a(String str) {
        this.f = str;
    }

    public float b(float f2) {
        return (float) this.f635a.b(f2, 0);
    }

    public String toString() {
        String str = this.f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.e; i2++) {
            str = str + "[" + this.b[i2] + " , " + decimalFormat.format(this.c[i2]) + "] ";
        }
        return str;
    }
}
