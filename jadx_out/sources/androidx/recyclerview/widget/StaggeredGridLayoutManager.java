package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.v.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f1017a = false;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 0;

    @Deprecated
    public static final int e = 1;
    public static final int f = 2;
    static final int g = Integer.MIN_VALUE;
    private static final String p = "StaggeredGridLManager";
    private static final float q = 0.33333334f;

    @androidx.annotation.ah
    private final p E;
    private BitSet F;
    private boolean H;
    private boolean I;
    private d J;
    private int K;
    private int[] P;
    e[] h;

    @androidx.annotation.ah
    w i;

    @androidx.annotation.ah
    w j;
    private int s;
    private int t;
    private int r = -1;
    boolean k = false;
    boolean l = false;
    int m = -1;
    int n = Integer.MIN_VALUE;
    c o = new c();
    private int G = 2;
    private final Rect L = new Rect();
    private final a M = new a();
    private boolean N = false;
    private boolean O = true;
    private final Runnable Q = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.b();
        }
    };

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1019a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            a();
        }

        void a() {
            this.f1019a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            if (this.f != null) {
                Arrays.fill(this.f, -1);
            }
        }

        void a(int i) {
            if (this.c) {
                this.b = StaggeredGridLayoutManager.this.i.e() - i;
            } else {
                this.b = StaggeredGridLayoutManager.this.i.d() + i;
            }
        }

        void a(e[] eVarArr) {
            int length = eVarArr.length;
            if (this.f == null || this.f.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.h.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].a(Integer.MIN_VALUE);
            }
        }

        void b() {
            this.b = this.c ? StaggeredGridLayoutManager.this.i.e() : StaggeredGridLayoutManager.this.i.d();
        }
    }

    public static class b extends RecyclerView.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f1020a = -1;
        e b;
        boolean c;

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(RecyclerView.j jVar) {
            super(jVar);
        }

        public void a(boolean z) {
            this.c = z;
        }

        public boolean a() {
            return this.c;
        }

        public final int b() {
            if (this.b == null) {
                return -1;
            }
            return this.b.f;
        }
    }

    static class c {
        private static final int c = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f1021a;
        List<a> b;

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.c.a.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i) {
                    return new a[i];
                }
            };

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f1022a;
            int b;
            int[] c;
            boolean d;

            a() {
            }

            a(Parcel parcel) {
                this.f1022a = parcel.readInt();
                this.b = parcel.readInt();
                this.d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.c = new int[i];
                    parcel.readIntArray(this.c);
                }
            }

            int a(int i) {
                if (this.c == null) {
                    return 0;
                }
                return this.c[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1022a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1022a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.d ? 1 : 0);
                if (this.c == null || this.c.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(this.c.length);
                    parcel.writeIntArray(this.c);
                }
            }
        }

        c() {
        }

        private void c(int i, int i2) {
            if (this.b == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.f1022a >= i) {
                    if (aVar.f1022a < i3) {
                        this.b.remove(size);
                    } else {
                        aVar.f1022a -= i2;
                    }
                }
            }
        }

        private void d(int i, int i2) {
            if (this.b == null) {
                return;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.f1022a >= i) {
                    aVar.f1022a += i2;
                }
            }
        }

        private int g(int i) {
            if (this.b == null) {
                return -1;
            }
            a aVarF = f(i);
            if (aVarF != null) {
                this.b.remove(aVarF);
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.b.get(i2).f1022a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.b.get(i2);
            this.b.remove(i2);
            return aVar.f1022a;
        }

        int a(int i) {
            if (this.b != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    if (this.b.get(size).f1022a >= i) {
                        this.b.remove(size);
                    }
                }
            }
            return b(i);
        }

        public a a(int i, int i2, int i3, boolean z) {
            if (this.b == null) {
                return null;
            }
            int size = this.b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.b.get(i4);
                if (aVar.f1022a >= i2) {
                    return null;
                }
                if (aVar.f1022a >= i && (i3 == 0 || aVar.b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }

        void a() {
            if (this.f1021a != null) {
                Arrays.fill(this.f1021a, -1);
            }
            this.b = null;
        }

        void a(int i, int i2) {
            if (this.f1021a == null || i >= this.f1021a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.f1021a, i3, this.f1021a, i, (this.f1021a.length - i) - i2);
            Arrays.fill(this.f1021a, this.f1021a.length - i2, this.f1021a.length, -1);
            c(i, i2);
        }

        void a(int i, e eVar) {
            e(i);
            this.f1021a[i] = eVar.f;
        }

        public void a(a aVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.b.get(i);
                if (aVar2.f1022a == aVar.f1022a) {
                    this.b.remove(i);
                }
                if (aVar2.f1022a >= aVar.f1022a) {
                    this.b.add(i, aVar);
                    return;
                }
            }
            this.b.add(aVar);
        }

        int b(int i) {
            if (this.f1021a == null || i >= this.f1021a.length) {
                return -1;
            }
            int iG = g(i);
            if (iG == -1) {
                Arrays.fill(this.f1021a, i, this.f1021a.length, -1);
                return this.f1021a.length;
            }
            int i2 = iG + 1;
            Arrays.fill(this.f1021a, i, i2, -1);
            return i2;
        }

        void b(int i, int i2) {
            if (this.f1021a == null || i >= this.f1021a.length) {
                return;
            }
            int i3 = i + i2;
            e(i3);
            System.arraycopy(this.f1021a, i, this.f1021a, i3, (this.f1021a.length - i) - i2);
            Arrays.fill(this.f1021a, i, i3, -1);
            d(i, i2);
        }

        int c(int i) {
            if (this.f1021a == null || i >= this.f1021a.length) {
                return -1;
            }
            return this.f1021a[i];
        }

        int d(int i) {
            int length = this.f1021a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void e(int i) {
            if (this.f1021a == null) {
                this.f1021a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f1021a, -1);
            } else if (i >= this.f1021a.length) {
                int[] iArr = this.f1021a;
                this.f1021a = new int[d(i)];
                System.arraycopy(iArr, 0, this.f1021a, 0, iArr.length);
                Arrays.fill(this.f1021a, iArr.length, this.f1021a.length, -1);
            }
        }

        public a f(int i) {
            if (this.b == null) {
                return null;
            }
            for (int size = this.b.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.f1022a == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @ap(a = {ap.a.LIBRARY})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1023a;
        int b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        public d() {
        }

        d(Parcel parcel) {
            this.f1023a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            if (this.c > 0) {
                this.d = new int[this.c];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            if (this.e > 0) {
                this.f = new int[this.e];
                parcel.readIntArray(this.f);
            }
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.f1023a = dVar.f1023a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }

        void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        void b() {
            this.d = null;
            this.c = 0;
            this.f1023a = -1;
            this.b = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1023a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }
    }

    class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f1024a = Integer.MIN_VALUE;
        ArrayList<View> b = new ArrayList<>();
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        int e = 0;
        final int f;

        e(int i) {
            this.f = i;
        }

        int a(int i) {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            if (this.b.size() == 0) {
                return i;
            }
            a();
            return this.c;
        }

        int a(int i, int i2, boolean z) {
            return a(i, i2, z, true, false);
        }

        int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iD = StaggeredGridLayoutManager.this.i.d();
            int iE = StaggeredGridLayoutManager.this.i.e();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.b.get(i);
                int iA = StaggeredGridLayoutManager.this.i.a(view);
                int iB = StaggeredGridLayoutManager.this.i.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iA >= iE : iA > iE;
                if (!z3 ? iB > iD : iB >= iD) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iA >= iD && iB <= iE) {
                            return StaggeredGridLayoutManager.this.e(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.e(view);
                        }
                        if (iA < iD || iB > iE) {
                            return StaggeredGridLayoutManager.this.e(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.b.size() - 1;
                while (size >= 0) {
                    View view2 = this.b.get(size);
                    if ((StaggeredGridLayoutManager.this.k && StaggeredGridLayoutManager.this.e(view2) >= i) || ((!StaggeredGridLayoutManager.this.k && StaggeredGridLayoutManager.this.e(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.b.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.b.get(i3);
                    if ((StaggeredGridLayoutManager.this.k && StaggeredGridLayoutManager.this.e(view3) <= i) || ((!StaggeredGridLayoutManager.this.k && StaggeredGridLayoutManager.this.e(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        void a() {
            c.a aVarF;
            View view = this.b.get(0);
            b bVarC = c(view);
            this.c = StaggeredGridLayoutManager.this.i.a(view);
            if (bVarC.c && (aVarF = StaggeredGridLayoutManager.this.o.f(bVarC.h())) != null && aVarF.b == -1) {
                this.c -= aVarF.a(this.f);
            }
        }

        void a(View view) {
            b bVarC = c(view);
            bVarC.b = this;
            this.b.add(0, view);
            this.c = Integer.MIN_VALUE;
            if (this.b.size() == 1) {
                this.d = Integer.MIN_VALUE;
            }
            if (bVarC.e() || bVarC.f()) {
                this.e += StaggeredGridLayoutManager.this.i.e(view);
            }
        }

        void a(boolean z, int i) {
            int iB = z ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (iB == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iB >= StaggeredGridLayoutManager.this.i.e()) {
                if (z || iB <= StaggeredGridLayoutManager.this.i.d()) {
                    if (i != Integer.MIN_VALUE) {
                        iB += i;
                    }
                    this.d = iB;
                    this.c = iB;
                }
            }
        }

        int b() {
            if (this.c != Integer.MIN_VALUE) {
                return this.c;
            }
            a();
            return this.c;
        }

        int b(int i) {
            if (this.d != Integer.MIN_VALUE) {
                return this.d;
            }
            if (this.b.size() == 0) {
                return i;
            }
            c();
            return this.d;
        }

        int b(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        void b(View view) {
            b bVarC = c(view);
            bVarC.b = this;
            this.b.add(view);
            this.d = Integer.MIN_VALUE;
            if (this.b.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (bVarC.e() || bVarC.f()) {
                this.e += StaggeredGridLayoutManager.this.i.e(view);
            }
        }

        b c(View view) {
            return (b) view.getLayoutParams();
        }

        void c() {
            c.a aVarF;
            View view = this.b.get(this.b.size() - 1);
            b bVarC = c(view);
            this.d = StaggeredGridLayoutManager.this.i.b(view);
            if (bVarC.c && (aVarF = StaggeredGridLayoutManager.this.o.f(bVarC.h())) != null && aVarF.b == 1) {
                this.d += aVarF.a(this.f);
            }
        }

        void c(int i) {
            this.c = i;
            this.d = i;
        }

        int d() {
            if (this.d != Integer.MIN_VALUE) {
                return this.d;
            }
            c();
            return this.d;
        }

        void d(int i) {
            if (this.c != Integer.MIN_VALUE) {
                this.c += i;
            }
            if (this.d != Integer.MIN_VALUE) {
                this.d += i;
            }
        }

        void e() {
            this.b.clear();
            f();
            this.e = 0;
        }

        void f() {
            this.c = Integer.MIN_VALUE;
            this.d = Integer.MIN_VALUE;
        }

        void g() {
            int size = this.b.size();
            View viewRemove = this.b.remove(size - 1);
            b bVarC = c(viewRemove);
            bVarC.b = null;
            if (bVarC.e() || bVarC.f()) {
                this.e -= StaggeredGridLayoutManager.this.i.e(viewRemove);
            }
            if (size == 1) {
                this.c = Integer.MIN_VALUE;
            }
            this.d = Integer.MIN_VALUE;
        }

        void h() {
            View viewRemove = this.b.remove(0);
            b bVarC = c(viewRemove);
            bVarC.b = null;
            if (this.b.size() == 0) {
                this.d = Integer.MIN_VALUE;
            }
            if (bVarC.e() || bVarC.f()) {
                this.e -= StaggeredGridLayoutManager.this.i.e(viewRemove);
            }
            this.c = Integer.MIN_VALUE;
        }

        public int i() {
            return this.e;
        }

        public int j() {
            return StaggeredGridLayoutManager.this.k ? a(this.b.size() - 1, -1, false) : a(0, this.b.size(), false);
        }

        public int k() {
            return StaggeredGridLayoutManager.this.k ? b(this.b.size() - 1, -1, true) : b(0, this.b.size(), true);
        }

        public int l() {
            return StaggeredGridLayoutManager.this.k ? a(this.b.size() - 1, -1, true) : a(0, this.b.size(), true);
        }

        public int m() {
            return StaggeredGridLayoutManager.this.k ? a(0, this.b.size(), false) : a(this.b.size() - 1, -1, false);
        }

        public int n() {
            return StaggeredGridLayoutManager.this.k ? b(0, this.b.size(), true) : b(this.b.size() - 1, -1, true);
        }

        public int o() {
            return StaggeredGridLayoutManager.this.k ? a(0, this.b.size(), true) : a(this.b.size() - 1, -1, true);
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.s = i2;
        a(i);
        this.E = new p();
        u();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b bVarA = a(context, attributeSet, i, i2);
        b(bVarA.f1006a);
        a(bVarA.b);
        a(bVarA.c);
        this.E = new p();
        u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a(RecyclerView.q qVar, p pVar, RecyclerView.w wVar) {
        int i;
        int iS;
        e eVarA;
        int iE;
        int i2;
        int iE2;
        int iE3;
        boolean z;
        ?? r9 = 0;
        this.F.set(0, this.r, true);
        if (this.E.n) {
            i = pVar.j == 1 ? ActivityChooserView.a.f166a : Integer.MIN_VALUE;
        } else {
            i = pVar.j == 1 ? pVar.l + pVar.g : pVar.k - pVar.g;
        }
        int i3 = i;
        b(pVar.j, i3);
        int iE4 = this.l ? this.i.e() : this.i.d();
        ?? r0 = false;
        while (pVar.a(wVar) && (this.E.n || !this.F.isEmpty())) {
            View viewA = pVar.a(qVar);
            b bVar = (b) viewA.getLayoutParams();
            int iH = bVar.h();
            int iC = this.o.c(iH);
            ?? r3 = iC == -1 ? 1 : r9;
            if (r3 != 0) {
                eVarA = bVar.c ? this.h[r9] : a(pVar);
                this.o.a(iH, eVarA);
            } else {
                eVarA = this.h[iC];
            }
            e eVar = eVarA;
            bVar.b = eVar;
            if (pVar.j == 1) {
                c(viewA);
            } else {
                b(viewA, r9);
            }
            a(viewA, bVar, r9);
            if (pVar.j == 1) {
                int iS2 = bVar.c ? s(iE4) : eVar.b(iE4);
                int iE5 = this.i.e(viewA) + iS2;
                if (r3 != 0 && bVar.c) {
                    c.a aVarO = o(iS2);
                    aVarO.b = -1;
                    aVarO.f1022a = iH;
                    this.o.a(aVarO);
                }
                i2 = iE5;
                iE = iS2;
            } else {
                int iR = bVar.c ? r(iE4) : eVar.a(iE4);
                iE = iR - this.i.e(viewA);
                if (r3 != 0 && bVar.c) {
                    c.a aVarP = p(iR);
                    aVarP.b = 1;
                    aVarP.f1022a = iH;
                    this.o.a(aVarP);
                }
                i2 = iR;
            }
            if (bVar.c && pVar.i == -1) {
                if (r3 != 0) {
                    this.N = true;
                } else {
                    if (!(pVar.j == 1 ? o() : p())) {
                        c.a aVarF = this.o.f(iH);
                        if (aVarF != null) {
                            aVarF.d = true;
                        }
                        this.N = true;
                    }
                }
            }
            a(viewA, bVar, pVar);
            if (l() && this.s == 1) {
                int iE6 = bVar.c ? this.j.e() : this.j.e() - (((this.r - 1) - eVar.f) * this.t);
                iE3 = iE6;
                iE2 = iE6 - this.j.e(viewA);
            } else {
                int iD = bVar.c ? this.j.d() : (eVar.f * this.t) + this.j.d();
                iE2 = iD;
                iE3 = this.j.e(viewA) + iD;
            }
            if (this.s == 1) {
                b(viewA, iE2, iE, iE3, i2);
            } else {
                b(viewA, iE, iE2, i2, iE3);
            }
            if (bVar.c) {
                b(this.E.j, i3);
            } else {
                a(eVar, this.E.j, i3);
            }
            a(qVar, this.E);
            if (!this.E.m || !viewA.hasFocusable()) {
                z = false;
            } else if (bVar.c) {
                this.F.clear();
                z = false;
            } else {
                z = false;
                this.F.set(eVar.f, false);
            }
            r9 = z;
            r0 = true;
        }
        ?? r4 = r9;
        if (r0 == false) {
            a(qVar, this.E);
        }
        if (this.E.j == -1) {
            iS = this.i.d() - r(this.i.d());
        } else {
            iS = s(this.i.e()) - this.i.e();
        }
        return iS > 0 ? Math.min(pVar.g, iS) : r4 == true ? 1 : 0;
    }

    private e a(p pVar) {
        int i;
        int i2;
        int i3 = -1;
        if (u(pVar.j)) {
            i = this.r - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.r;
            i2 = 1;
        }
        e eVar = null;
        if (pVar.j == 1) {
            int i4 = ActivityChooserView.a.f166a;
            int iD = this.i.d();
            while (i != i3) {
                e eVar2 = this.h[i];
                int iB = eVar2.b(iD);
                if (iB < i4) {
                    eVar = eVar2;
                    i4 = iB;
                }
                i += i2;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int iE = this.i.e();
        while (i != i3) {
            e eVar3 = this.h[i];
            int iA = eVar3.a(iE);
            if (iA > i5) {
                eVar = eVar3;
                i5 = iA;
            }
            i += i2;
        }
        return eVar;
    }

    private void a(View view, int i, int i2, boolean z) {
        b(view, this.L);
        b bVar = (b) view.getLayoutParams();
        int iB = b(i, bVar.leftMargin + this.L.left, bVar.rightMargin + this.L.right);
        int iB2 = b(i2, bVar.topMargin + this.L.top, bVar.bottomMargin + this.L.bottom);
        if (z ? a(view, iB, iB2, bVar) : b(view, iB, iB2, bVar)) {
            view.measure(iB, iB2);
        }
    }

    private void a(View view, b bVar, p pVar) {
        if (pVar.j == 1) {
            if (bVar.c) {
                w(view);
                return;
            } else {
                bVar.b.b(view);
                return;
            }
        }
        if (bVar.c) {
            x(view);
        } else {
            bVar.b.a(view);
        }
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.c) {
            if (this.s == 1) {
                a(view, this.K, a(L(), J(), N() + P(), bVar.height, true), z);
                return;
            } else {
                a(view, a(K(), I(), M() + O(), bVar.width, true), this.K, z);
                return;
            }
        }
        if (this.s == 1) {
            a(view, a(this.t, I(), 0, bVar.width, false), a(L(), J(), N() + P(), bVar.height, true), z);
        } else {
            a(view, a(K(), I(), M() + O(), bVar.width, true), a(this.t, J(), 0, bVar.height, false), z);
        }
    }

    private void a(RecyclerView.q qVar, int i) {
        while (H() > 0) {
            View viewJ = j(0);
            if (this.i.b(viewJ) > i || this.i.c(viewJ) > i) {
                return;
            }
            b bVar = (b) viewJ.getLayoutParams();
            if (bVar.c) {
                for (int i2 = 0; i2 < this.r; i2++) {
                    if (this.h[i2].b.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.r; i3++) {
                    this.h[i3].h();
                }
            } else if (bVar.b.b.size() == 1) {
                return;
            } else {
                bVar.b.h();
            }
            b(viewJ, qVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0166  */
    private void a(RecyclerView.q qVar, RecyclerView.w wVar, boolean z) {
        boolean z2;
        a aVar = this.M;
        if (!(this.J == null && this.m == -1) && wVar.h() == 0) {
            c(qVar);
            aVar.a();
            return;
        }
        boolean z3 = (aVar.e && this.m == -1 && this.J == null) ? false : true;
        if (z3) {
            aVar.a();
            if (this.J != null) {
                a(aVar);
            } else {
                v();
                aVar.c = this.l;
            }
            a(wVar, aVar);
            aVar.e = true;
        }
        if (this.J == null && this.m == -1 && (aVar.c != this.H || l() != this.I)) {
            this.o.a();
            aVar.d = true;
        }
        if (H() > 0 && (this.J == null || this.J.c < 1)) {
            if (aVar.d) {
                for (int i = 0; i < this.r; i++) {
                    this.h[i].e();
                    if (aVar.b != Integer.MIN_VALUE) {
                        this.h[i].c(aVar.b);
                    }
                }
            } else if (z3 || this.M.f == null) {
                for (int i2 = 0; i2 < this.r; i2++) {
                    this.h[i2].a(this.l, aVar.b);
                }
                this.M.a(this.h);
            } else {
                for (int i3 = 0; i3 < this.r; i3++) {
                    e eVar = this.h[i3];
                    eVar.e();
                    eVar.c(this.M.f[i3]);
                }
            }
        }
        a(qVar);
        this.E.f = false;
        this.N = false;
        g(this.j.g());
        b(aVar.f1019a, wVar);
        if (aVar.c) {
            n(-1);
            a(qVar, this.E, wVar);
            n(1);
            this.E.h = aVar.f1019a + this.E.i;
            a(qVar, this.E, wVar);
        } else {
            n(1);
            a(qVar, this.E, wVar);
            n(-1);
            this.E.h = aVar.f1019a + this.E.i;
            a(qVar, this.E, wVar);
        }
        w();
        if (H() > 0) {
            if (this.l) {
                b(qVar, wVar, true);
                c(qVar, wVar, false);
            } else {
                c(qVar, wVar, true);
                b(qVar, wVar, false);
            }
        }
        if (z && !wVar.b()) {
            if (this.G != 0 && H() > 0 && (this.N || c() != null)) {
                b(this.Q);
                z2 = b();
            }
        }
        if (wVar.b()) {
            this.M.a();
        }
        this.H = aVar.c;
        this.I = l();
        if (z2) {
            this.M.a();
            a(qVar, wVar, false);
        }
    }

    private void a(RecyclerView.q qVar, p pVar) {
        int iMin;
        if (!pVar.f || pVar.n) {
            return;
        }
        if (pVar.g == 0) {
            if (pVar.j == -1) {
                b(qVar, pVar.l);
                return;
            } else {
                a(qVar, pVar.k);
                return;
            }
        }
        if (pVar.j == -1) {
            int iQ = pVar.k - q(pVar.k);
            b(qVar, iQ < 0 ? pVar.l : pVar.l - Math.min(iQ, pVar.g));
            return;
        }
        int iT = t(pVar.l) - pVar.l;
        if (iT < 0) {
            iMin = pVar.k;
        } else {
            iMin = Math.min(iT, pVar.g) + pVar.k;
        }
        a(qVar, iMin);
    }

    private void a(a aVar) {
        if (this.J.c > 0) {
            if (this.J.c == this.r) {
                for (int i = 0; i < this.r; i++) {
                    this.h[i].e();
                    int iE = this.J.d[i];
                    if (iE != Integer.MIN_VALUE) {
                        iE = this.J.i ? iE + this.i.e() : iE + this.i.d();
                    }
                    this.h[i].c(iE);
                }
            } else {
                this.J.a();
                this.J.f1023a = this.J.b;
            }
        }
        this.I = this.J.j;
        a(this.J.h);
        v();
        if (this.J.f1023a != -1) {
            this.m = this.J.f1023a;
            aVar.c = this.J.i;
        } else {
            aVar.c = this.l;
        }
        if (this.J.e > 1) {
            this.o.f1021a = this.J.f;
            this.o.b = this.J.g;
        }
    }

    private void a(e eVar, int i, int i2) {
        int i3 = eVar.i();
        if (i == -1) {
            if (eVar.b() + i3 <= i2) {
                this.F.set(eVar.f, false);
            }
        } else if (eVar.d() - i3 >= i2) {
            this.F.set(eVar.f, false);
        }
    }

    private boolean a(e eVar) {
        if (this.l) {
            if (eVar.d() < this.i.e()) {
                return !eVar.c(eVar.b.get(eVar.b.size() - 1)).c;
            }
        } else if (eVar.b() > this.i.d()) {
            return !eVar.c(eVar.b.get(0)).c;
        }
        return false;
    }

    private int b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private void b(int i, int i2) {
        for (int i3 = 0; i3 < this.r; i3++) {
            if (!this.h[i3].b.isEmpty()) {
                a(this.h[i3], i, i2);
            }
        }
    }

    private void b(int i, RecyclerView.w wVar) {
        int iG;
        int iG2;
        int iE;
        boolean z = false;
        this.E.g = 0;
        this.E.h = i;
        if (!D() || (iE = wVar.e()) == -1) {
            iG = 0;
            iG2 = 0;
        } else {
            if (this.l == (iE < i)) {
                iG2 = this.i.g();
                iG = 0;
            } else {
                iG = this.i.g();
                iG2 = 0;
            }
        }
        if (C()) {
            this.E.k = this.i.d() - iG;
            this.E.l = this.i.e() + iG2;
        } else {
            this.E.l = this.i.f() + iG2;
            this.E.k = -iG;
        }
        this.E.m = false;
        this.E.f = true;
        p pVar = this.E;
        if (this.i.i() == 0 && this.i.f() == 0) {
            z = true;
        }
        pVar.n = z;
    }

    private void b(RecyclerView.q qVar, int i) {
        for (int iH = H() - 1; iH >= 0; iH--) {
            View viewJ = j(iH);
            if (this.i.a(viewJ) < i || this.i.d(viewJ) < i) {
                return;
            }
            b bVar = (b) viewJ.getLayoutParams();
            if (bVar.c) {
                for (int i2 = 0; i2 < this.r; i2++) {
                    if (this.h[i2].b.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.r; i3++) {
                    this.h[i3].g();
                }
            } else if (bVar.b.b.size() == 1) {
                return;
            } else {
                bVar.b.g();
            }
            b(viewJ, qVar);
        }
    }

    private void b(RecyclerView.q qVar, RecyclerView.w wVar, boolean z) {
        int iE;
        int iS = s(Integer.MIN_VALUE);
        if (iS != Integer.MIN_VALUE && (iE = this.i.e() - iS) > 0) {
            int i = iE - (-c(-iE, qVar, wVar));
            if (!z || i <= 0) {
                return;
            }
            this.i.a(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    private void c(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iQ;
        int iQ2 = this.l ? q() : r();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i5 = i + 1;
                i6 = i2;
            }
            this.o.b(i6);
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        this.o.b(i, i2);
                        break;
                    case 2:
                        this.o.a(i, i2);
                        break;
                }
            } else {
                this.o.a(i, 1);
                this.o.b(i2, 1);
            }
            if (i5 <= iQ2) {
                return;
            }
            if (this.l) {
                iQ = r();
            } else {
                iQ = q();
            }
            if (i6 <= iQ) {
                z();
            }
        }
        i4 = i + i2;
        i5 = i4;
        i6 = i;
        this.o.b(i6);
        if (i3 != 8) {
            switch (i3) {
                case 1:
                    this.o.b(i, i2);
                    break;
                case 2:
                    this.o.a(i, i2);
                    break;
            }
        } else {
            this.o.a(i, 1);
            this.o.b(i2, 1);
        }
        if (i5 <= iQ2) {
            return;
        }
        if (this.l) {
            iQ = r();
        } else {
            iQ = q();
        }
        if (i6 <= iQ) {
            z();
        }
    }

    private void c(RecyclerView.q qVar, RecyclerView.w wVar, boolean z) {
        int iD;
        int iR = r(ActivityChooserView.a.f166a);
        if (iR != Integer.MAX_VALUE && (iD = iR - this.i.d()) > 0) {
            int iC = iD - c(iD, qVar, wVar);
            if (!z || iC <= 0) {
                return;
            }
            this.i.a(-iC);
        }
    }

    private boolean c(RecyclerView.w wVar, a aVar) {
        aVar.f1019a = this.H ? x(wVar.h()) : w(wVar.h());
        aVar.b = Integer.MIN_VALUE;
        return true;
    }

    private int f(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        return z.a(wVar, this.i, b(!this.O), c(!this.O), this, this.O, this.l);
    }

    private int i(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        return z.a(wVar, this.i, b(!this.O), c(!this.O), this, this.O);
    }

    private int j(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        return z.b(wVar, this.i, b(!this.O), c(!this.O), this, this.O);
    }

    private void n(int i) {
        this.E.j = i;
        this.E.i = this.l != (i == -1) ? -1 : 1;
    }

    private c.a o(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.r];
        for (int i2 = 0; i2 < this.r; i2++) {
            aVar.c[i2] = i - this.h[i2].b(i);
        }
        return aVar;
    }

    private c.a p(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.r];
        for (int i2 = 0; i2 < this.r; i2++) {
            aVar.c[i2] = this.h[i2].a(i) - i;
        }
        return aVar;
    }

    private int q(int i) {
        int iA = this.h[0].a(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int iA2 = this.h[i2].a(i);
            if (iA2 > iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private int r(int i) {
        int iA = this.h[0].a(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int iA2 = this.h[i2].a(i);
            if (iA2 < iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private int s(int i) {
        int iB = this.h[0].b(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int iB2 = this.h[i2].b(i);
            if (iB2 > iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private int t(int i) {
        int iB = this.h[0].b(i);
        for (int i2 = 1; i2 < this.r; i2++) {
            int iB2 = this.h[i2].b(i);
            if (iB2 < iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private void u() {
        this.i = w.a(this, this.s);
        this.j = w.a(this, 1 - this.s);
    }

    private boolean u(int i) {
        if (this.s == 0) {
            return (i == -1) != this.l;
        }
        return ((i == -1) == this.l) == l();
    }

    private int v(int i) {
        if (H() == 0) {
            return this.l ? 1 : -1;
        }
        return (i < r()) != this.l ? -1 : 1;
    }

    private void v() {
        if (this.s == 1 || !l()) {
            this.l = this.k;
        } else {
            this.l = !this.k;
        }
    }

    private int w(int i) {
        int iH = H();
        for (int i2 = 0; i2 < iH; i2++) {
            int iE = e(j(i2));
            if (iE >= 0 && iE < i) {
                return iE;
            }
        }
        return 0;
    }

    private void w() {
        if (this.j.i() == 1073741824) {
            return;
        }
        int iH = H();
        float fMax = 0.0f;
        for (int i = 0; i < iH; i++) {
            View viewJ = j(i);
            float fE = this.j.e(viewJ);
            if (fE >= fMax) {
                if (((b) viewJ.getLayoutParams()).a()) {
                    fE = (fE * 1.0f) / this.r;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.t;
        int iRound = Math.round(fMax * this.r);
        if (this.j.i() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.j.g());
        }
        g(iRound);
        if (this.t == i2) {
            return;
        }
        for (int i3 = 0; i3 < iH; i3++) {
            View viewJ2 = j(i3);
            b bVar = (b) viewJ2.getLayoutParams();
            if (!bVar.c) {
                if (l() && this.s == 1) {
                    viewJ2.offsetLeftAndRight(((-((this.r - 1) - bVar.b.f)) * this.t) - ((-((this.r - 1) - bVar.b.f)) * i2));
                } else {
                    int i4 = bVar.b.f * this.t;
                    int i5 = bVar.b.f * i2;
                    if (this.s == 1) {
                        viewJ2.offsetLeftAndRight(i4 - i5);
                    } else {
                        viewJ2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void w(View view) {
        for (int i = this.r - 1; i >= 0; i--) {
            this.h[i].b(view);
        }
    }

    private int x(int i) {
        for (int iH = H() - 1; iH >= 0; iH--) {
            int iE = e(j(iH));
            if (iE >= 0 && iE < i) {
                return iE;
            }
        }
        return 0;
    }

    private void x(View view) {
        for (int i = this.r - 1; i >= 0; i--) {
            this.h[i].a(view);
        }
    }

    private int y(int i) {
        if (i == 17) {
            return this.s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.s == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.s == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.s != 1 && l()) ? 1 : -1;
            case 2:
                return (this.s != 1 && l()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        return c(i, qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.q qVar, RecyclerView.w wVar) {
        return this.s == 0 ? this.r : super.a(qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    @ai
    public View a(View view, int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        View viewG;
        View viewA;
        if (H() == 0 || (viewG = g(view)) == null) {
            return null;
        }
        v();
        int iY = y(i);
        if (iY == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) viewG.getLayoutParams();
        boolean z = bVar.c;
        e eVar = bVar.b;
        int iQ = iY == 1 ? q() : r();
        b(iQ, wVar);
        n(iY);
        this.E.h = this.E.i + iQ;
        this.E.g = (int) (this.i.g() * q);
        this.E.m = true;
        this.E.f = false;
        a(qVar, this.E, wVar);
        this.H = this.l;
        if (!z && (viewA = eVar.a(iQ, iY)) != null && viewA != viewG) {
            return viewA;
        }
        if (u(iY)) {
            for (int i2 = this.r - 1; i2 >= 0; i2--) {
                View viewA2 = this.h[i2].a(iQ, iY);
                if (viewA2 != null && viewA2 != viewG) {
                    return viewA2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.r; i3++) {
                View viewA3 = this.h[i3].a(iQ, iY);
                if (viewA3 != null && viewA3 != viewG) {
                    return viewA3;
                }
            }
        }
        boolean z2 = (this.k ^ true) == (iY == -1);
        if (!z) {
            View viewC = c(z2 ? eVar.k() : eVar.n());
            if (viewC != null && viewC != viewG) {
                return viewC;
            }
        }
        if (u(iY)) {
            for (int i4 = this.r - 1; i4 >= 0; i4--) {
                if (i4 != eVar.f) {
                    View viewC2 = c(z2 ? this.h[i4].k() : this.h[i4].n());
                    if (viewC2 != null && viewC2 != viewG) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.r; i5++) {
                View viewC3 = c(z2 ? this.h[i5].k() : this.h[i5].n());
                if (viewC3 != null && viewC3 != viewG) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        return this.s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public void a(int i) {
        a((String) null);
        if (i != this.r) {
            k();
            this.r = i;
            this.F = new BitSet(this.r);
            this.h = new e[this.r];
            for (int i2 = 0; i2 < this.r; i2++) {
                this.h[i2] = new e(i2);
            }
            z();
        }
    }

    public void a(int i, int i2) {
        if (this.J != null) {
            this.J.b();
        }
        this.m = i;
        this.n = i2;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    @ap(a = {ap.a.LIBRARY})
    public void a(int i, int i2, RecyclerView.w wVar, RecyclerView.i.a aVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (H() == 0 || i == 0) {
            return;
        }
        a(i, wVar);
        if (this.P == null || this.P.length < this.r) {
            this.P = new int[this.r];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.r; i4++) {
            int iA = this.E.i == -1 ? this.E.k - this.h[i4].a(this.E.k) : this.h[i4].b(this.E.l) - this.E.l;
            if (iA >= 0) {
                this.P[i3] = iA;
                i3++;
            }
        }
        Arrays.sort(this.P, 0, i3);
        for (int i5 = 0; i5 < i3 && this.E.a(wVar); i5++) {
            aVar.b(this.E.h, this.P[i5]);
            this.E.h += this.E.i;
        }
    }

    void a(int i, RecyclerView.w wVar) {
        int i2;
        int iR;
        if (i > 0) {
            iR = q();
            i2 = 1;
        } else {
            i2 = -1;
            iR = r();
        }
        this.E.f = true;
        b(iR, wVar);
        n(i2);
        this.E.h = iR + this.E.i;
        this.E.g = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        int iM = M() + O();
        int iN = N() + P();
        if (this.s == 1) {
            iA2 = a(i2, rect.height() + iN, Y());
            iA = a(i, (this.t * this.r) + iM, X());
        } else {
            iA = a(i, rect.width() + iM, X());
            iA2 = a(i2, (this.t * this.r) + iN, Y());
        }
        g(iA, iA2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.J = (d) parcelable;
            z();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (H() > 0) {
            View viewB = b(false);
            View viewC = c(false);
            if (viewB == null || viewC == null) {
                return;
            }
            int iE = e(viewB);
            int iE2 = e(viewC);
            if (iE < iE2) {
                accessibilityEvent.setFromIndex(iE);
                accessibilityEvent.setToIndex(iE2);
            } else {
                accessibilityEvent.setFromIndex(iE2);
                accessibilityEvent.setToIndex(iE);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.q qVar, RecyclerView.w wVar, View view, androidx.core.n.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.s == 0) {
            dVar.c(androidx.core.n.a.d.c.a(bVar.b(), bVar.c ? this.r : 1, -1, -1, false, false));
        } else {
            dVar.c(androidx.core.n.a.d.c.a(-1, -1, bVar.b(), bVar.c ? this.r : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.w wVar) {
        super.a(wVar);
        this.m = -1;
        this.n = Integer.MIN_VALUE;
        this.J = null;
        this.M.a();
    }

    void a(RecyclerView.w wVar, a aVar) {
        if (b(wVar, aVar) || c(wVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.f1019a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.o.a();
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.q qVar) {
        super.a(recyclerView, qVar);
        b(this.Q);
        for (int i = 0; i < this.r; i++) {
            this.h[i].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.w wVar, int i) {
        q qVar = new q(recyclerView.getContext());
        qVar.c(i);
        a(qVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.J == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a((String) null);
        if (this.J != null && this.J.h != z) {
            this.J.h = z;
        }
        this.k = z;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.r];
        } else if (iArr.length < this.r) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.r + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.r; i++) {
            iArr[i] = this.h[i].j();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        return c(i, qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.q qVar, RecyclerView.w wVar) {
        return this.s == 1 ? this.r : super.b(qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.w wVar) {
        return j(wVar);
    }

    View b(boolean z) {
        int iD = this.i.d();
        int iE = this.i.e();
        int iH = H();
        View view = null;
        for (int i = 0; i < iH; i++) {
            View viewJ = j(i);
            int iA = this.i.a(viewJ);
            if (this.i.b(viewJ) > iD && iA < iE) {
                if (iA >= iD || !z) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a((String) null);
        if (i == this.s) {
            return;
        }
        this.s = i;
        w wVar = this.i;
        this.i = this.j;
        this.j = wVar;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    boolean b() {
        int iR;
        int iQ;
        if (H() == 0 || this.G == 0 || !B()) {
            return false;
        }
        if (this.l) {
            iR = q();
            iQ = r();
        } else {
            iR = r();
            iQ = q();
        }
        if (iR == 0 && c() != null) {
            this.o.a();
            aa();
            z();
            return true;
        }
        if (!this.N) {
            return false;
        }
        int i = this.l ? -1 : 1;
        int i2 = iQ + 1;
        c.a aVarA = this.o.a(iR, i2, i, true);
        if (aVarA == null) {
            this.N = false;
            this.o.a(i2);
            return false;
        }
        c.a aVarA2 = this.o.a(iR, aVarA.f1022a, i * (-1), true);
        if (aVarA2 == null) {
            this.o.a(aVarA.f1022a);
        } else {
            this.o.a(aVarA2.f1022a + 1);
        }
        aa();
        z();
        return true;
    }

    boolean b(RecyclerView.w wVar, a aVar) {
        if (wVar.b() || this.m == -1) {
            return false;
        }
        if (this.m < 0 || this.m >= wVar.h()) {
            this.m = -1;
            this.n = Integer.MIN_VALUE;
            return false;
        }
        if (this.J == null || this.J.f1023a == -1 || this.J.c < 1) {
            View viewC = c(this.m);
            if (viewC != null) {
                aVar.f1019a = this.l ? q() : r();
                if (this.n != Integer.MIN_VALUE) {
                    if (aVar.c) {
                        aVar.b = (this.i.e() - this.n) - this.i.b(viewC);
                    } else {
                        aVar.b = (this.i.d() + this.n) - this.i.a(viewC);
                    }
                    return true;
                }
                if (this.i.e(viewC) > this.i.g()) {
                    aVar.b = aVar.c ? this.i.e() : this.i.d();
                    return true;
                }
                int iA = this.i.a(viewC) - this.i.d();
                if (iA < 0) {
                    aVar.b = -iA;
                    return true;
                }
                int iE = this.i.e() - this.i.b(viewC);
                if (iE < 0) {
                    aVar.b = iE;
                    return true;
                }
                aVar.b = Integer.MIN_VALUE;
            } else {
                aVar.f1019a = this.m;
                if (this.n == Integer.MIN_VALUE) {
                    aVar.c = v(aVar.f1019a) == 1;
                    aVar.b();
                } else {
                    aVar.a(this.n);
                }
                aVar.d = true;
            }
        } else {
            aVar.b = Integer.MIN_VALUE;
            aVar.f1019a = this.m;
        }
        return true;
    }

    public int[] b(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.r];
        } else if (iArr.length < this.r) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.r + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.r; i++) {
            iArr[i] = this.h[i].l();
        }
        return iArr;
    }

    int c(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        if (H() == 0 || i == 0) {
            return 0;
        }
        a(i, wVar);
        int iA = a(qVar, this.E, wVar);
        if (this.E.g >= iA) {
            i = i < 0 ? -iA : iA;
        }
        this.i.a(-i);
        this.H = this.l;
        this.E.g = 0;
        a(qVar, this.E);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.w wVar) {
        return j(wVar);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    View c() {
        int i;
        int i2;
        boolean z;
        int iH = H() - 1;
        BitSet bitSet = new BitSet(this.r);
        bitSet.set(0, this.r, true);
        byte b2 = (this.s == 1 && l()) ? (byte) 1 : (byte) -1;
        if (this.l) {
            i = -1;
        } else {
            i = iH + 1;
            iH = 0;
        }
        int i3 = iH < i ? 1 : -1;
        while (iH != i) {
            View viewJ = j(iH);
            b bVar = (b) viewJ.getLayoutParams();
            if (bitSet.get(bVar.b.f)) {
                if (a(bVar.b)) {
                    return viewJ;
                }
                bitSet.clear(bVar.b.f);
            }
            if (!bVar.c && (i2 = iH + i3) != i) {
                View viewJ2 = j(i2);
                if (this.l) {
                    int iB = this.i.b(viewJ);
                    int iB2 = this.i.b(viewJ2);
                    if (iB < iB2) {
                        return viewJ;
                    }
                    if (iB == iB2) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int iA = this.i.a(viewJ);
                    int iA2 = this.i.a(viewJ2);
                    if (iA > iA2) {
                        return viewJ;
                    }
                    if (iA == iA2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    if ((bVar.b.f - ((b) viewJ2.getLayoutParams()).b.f < 0) != (b2 < 0)) {
                        return viewJ;
                    }
                } else {
                    continue;
                }
            }
            iH += i3;
        }
        return null;
    }

    View c(boolean z) {
        int iD = this.i.d();
        int iE = this.i.e();
        View view = null;
        for (int iH = H() - 1; iH >= 0; iH--) {
            View viewJ = j(iH);
            int iA = this.i.a(viewJ);
            int iB = this.i.b(viewJ);
            if (iB > iD && iA < iE) {
                if (iB <= iE || !z) {
                    return viewJ;
                }
                if (view == null) {
                    view = viewJ;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.q qVar, RecyclerView.w wVar) {
        a(qVar, wVar, true);
    }

    public int[] c(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.r];
        } else if (iArr.length < this.r) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.r + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.r; i++) {
            iArr[i] = this.h[i].m();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.w wVar) {
        return f(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF d(int i) {
        int iV = v(i);
        PointF pointF = new PointF();
        if (iV == 0) {
            return null;
        }
        if (this.s == 0) {
            pointF.x = iV;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iV;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean d() {
        return this.J == null;
    }

    public int[] d(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.r];
        } else if (iArr.length < this.r) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.r + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.r; i++) {
            iArr[i] = this.h[i].o();
        }
        return iArr;
    }

    public int e() {
        return this.G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.w wVar) {
        return f(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        if (this.J != null && this.J.f1023a != i) {
            this.J.b();
        }
        this.m = i;
        this.n = Integer.MIN_VALUE;
        z();
    }

    public void f(int i) {
        a((String) null);
        if (i == this.G) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.G = i;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return this.G != 0;
    }

    public int g() {
        return this.r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.w wVar) {
        return i(wVar);
    }

    void g(int i) {
        this.t = i / this.r;
        this.K = View.MeasureSpec.makeMeasureSpec(i, this.j.i());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.w wVar) {
        return i(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable h() {
        int iA;
        if (this.J != null) {
            return new d(this.J);
        }
        d dVar = new d();
        dVar.h = this.k;
        dVar.i = this.H;
        dVar.j = this.I;
        if (this.o == null || this.o.f1021a == null) {
            dVar.e = 0;
        } else {
            dVar.f = this.o.f1021a;
            dVar.e = dVar.f.length;
            dVar.g = this.o.b;
        }
        if (H() > 0) {
            dVar.f1023a = this.H ? q() : r();
            dVar.b = n();
            dVar.c = this.r;
            dVar.d = new int[this.r];
            for (int i = 0; i < this.r; i++) {
                if (this.H) {
                    iA = this.h[i].b(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.i.e();
                    }
                } else {
                    iA = this.h[i].a(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iA -= this.i.d();
                    }
                }
                dVar.d[i] = iA;
            }
        } else {
            dVar.f1023a = -1;
            dVar.b = -1;
            dVar.c = 0;
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean i() {
        return this.s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean j() {
        return this.s == 1;
    }

    public void k() {
        this.o.a();
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void k(int i) {
        super.k(i);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.h[i2].d(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void l(int i) {
        super.l(i);
        for (int i2 = 0; i2 < this.r; i2++) {
            this.h[i2].d(i);
        }
    }

    boolean l() {
        return E() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void m(int i) {
        if (i == 0) {
            b();
        }
    }

    public boolean m() {
        return this.k;
    }

    int n() {
        View viewC = this.l ? c(true) : b(true);
        if (viewC == null) {
            return -1;
        }
        return e(viewC);
    }

    boolean o() {
        int iB = this.h[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.r; i++) {
            if (this.h[i].b(Integer.MIN_VALUE) != iB) {
                return false;
            }
        }
        return true;
    }

    boolean p() {
        int iA = this.h[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.r; i++) {
            if (this.h[i].a(Integer.MIN_VALUE) != iA) {
                return false;
            }
        }
        return true;
    }

    int q() {
        int iH = H();
        if (iH == 0) {
            return 0;
        }
        return e(j(iH - 1));
    }

    int r() {
        if (H() == 0) {
            return 0;
        }
        return e(j(0));
    }

    public int s() {
        return this.s;
    }
}
