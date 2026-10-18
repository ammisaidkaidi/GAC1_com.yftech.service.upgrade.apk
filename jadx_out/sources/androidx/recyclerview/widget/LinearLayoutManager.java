package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ap;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.i implements RecyclerView.v.b, m.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f987a = "LinearLayoutManager";
    private static final float b = 0.33333334f;
    static final boolean j = false;
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = Integer.MIN_VALUE;
    private int E;
    private int[] F;
    private c c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private final b i;
    int n;
    w o;
    boolean p;
    int q;
    int r;
    d s;
    final a t;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        w f988a;
        int b;
        int c;
        boolean d;
        boolean e;

        a() {
            a();
        }

        void a() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public void a(View view, int i) {
            int iC = this.f988a.c();
            if (iC >= 0) {
                b(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int iE = (this.f988a.e() - iC) - this.f988a.b(view);
                this.c = this.f988a.e() - iE;
                if (iE > 0) {
                    int iE2 = this.c - this.f988a.e(view);
                    int iD = this.f988a.d();
                    int iMin = iE2 - (iD + Math.min(this.f988a.a(view) - iD, 0));
                    if (iMin < 0) {
                        this.c += Math.min(iE, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iA = this.f988a.a(view);
            int iD2 = iA - this.f988a.d();
            this.c = iA;
            if (iD2 > 0) {
                int iE3 = (this.f988a.e() - Math.min(0, (this.f988a.e() - iC) - this.f988a.b(view))) - (iA + this.f988a.e(view));
                if (iE3 < 0) {
                    this.c -= Math.min(iD2, -iE3);
                }
            }
        }

        boolean a(View view, RecyclerView.w wVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.e() && jVar.h() >= 0 && jVar.h() < wVar.h();
        }

        void b() {
            this.c = this.d ? this.f988a.e() : this.f988a.d();
        }

        public void b(View view, int i) {
            if (this.d) {
                this.c = this.f988a.b(view) + this.f988a.c();
            } else {
                this.c = this.f988a.a(view);
            }
            this.b = i;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    protected static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f989a;
        public boolean b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        void a() {
            this.f989a = 0;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f990a = "LLM#LayoutState";
        static final int b = -1;
        static final int c = 1;
        static final int d = Integer.MIN_VALUE;
        static final int e = -1;
        static final int f = 1;
        static final int g = Integer.MIN_VALUE;
        int i;
        int j;
        int k;
        int l;
        int m;
        int n;
        int r;
        boolean t;
        boolean h = true;
        int o = 0;
        int p = 0;
        boolean q = false;
        List<RecyclerView.z> s = null;

        c() {
        }

        private View c() {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                View view = this.s.get(i).f1016a;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.e() && this.k == jVar.h()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        View a(RecyclerView.q qVar) {
            if (this.s != null) {
                return c();
            }
            View viewC = qVar.c(this.k);
            this.k += this.l;
            return viewC;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View viewB = b(view);
            if (viewB == null) {
                this.k = -1;
            } else {
                this.k = ((RecyclerView.j) viewB.getLayoutParams()).h();
            }
        }

        boolean a(RecyclerView.w wVar) {
            return this.k >= 0 && this.k < wVar.h();
        }

        public View b(View view) {
            int iH;
            int size = this.s.size();
            View view2 = null;
            int i = ActivityChooserView.a.f166a;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.s.get(i2).f1016a;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.e() && (iH = (jVar.h() - this.k) * this.l) >= 0 && iH < i) {
                    if (iH == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = iH;
                }
            }
            return view2;
        }

        void b() {
            Log.d(f990a, "avail:" + this.j + ", ind:" + this.k + ", dir:" + this.l + ", offset:" + this.i + ", layoutDir:" + this.m);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @ap(a = {ap.a.LIBRARY})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.d.1
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
        int f991a;
        int b;
        boolean c;

        public d() {
        }

        d(Parcel parcel) {
            this.f991a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f991a = dVar.f991a;
            this.b = dVar.b;
            this.c = dVar.c;
        }

        boolean a() {
            return this.f991a >= 0;
        }

        void b() {
            this.f991a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f991a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.n = 1;
        this.e = false;
        this.p = false;
        this.f = false;
        this.g = true;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = null;
        this.t = new a();
        this.i = new b();
        this.E = 2;
        this.F = new int[2];
        b(i);
        d(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.n = 1;
        this.e = false;
        this.p = false;
        this.f = false;
        this.g = true;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = null;
        this.t = new a();
        this.i = new b();
        this.E = 2;
        this.F = new int[2];
        RecyclerView.i.b bVarA = a(context, attributeSet, i, i2);
        b(bVarA.f1006a);
        d(bVarA.c);
        a(bVarA.d);
    }

    private int a(int i, RecyclerView.q qVar, RecyclerView.w wVar, boolean z) {
        int iE;
        int iE2 = this.o.e() - i;
        if (iE2 <= 0) {
            return 0;
        }
        int i2 = -c(-iE2, qVar, wVar);
        int i3 = i + i2;
        if (!z || (iE = this.o.e() - i3) <= 0) {
            return i2;
        }
        this.o.a(iE);
        return iE + i2;
    }

    private void a(int i, int i2) {
        this.c.j = this.o.e() - i2;
        this.c.l = this.p ? -1 : 1;
        this.c.k = i;
        this.c.m = 1;
        this.c.i = i2;
        this.c.n = Integer.MIN_VALUE;
    }

    private void a(int i, int i2, boolean z, RecyclerView.w wVar) {
        int iD;
        this.c.t = r();
        this.c.m = i;
        this.F[0] = 0;
        this.F[1] = 0;
        a(wVar, this.F);
        int iMax = Math.max(0, this.F[0]);
        int iMax2 = Math.max(0, this.F[1]);
        boolean z2 = i == 1;
        this.c.o = z2 ? iMax2 : iMax;
        c cVar = this.c;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.p = iMax;
        if (z2) {
            this.c.o += this.o.h();
            View viewE = e();
            this.c.l = this.p ? -1 : 1;
            this.c.k = e(viewE) + this.c.l;
            this.c.i = this.o.b(viewE);
            iD = this.o.b(viewE) - this.o.e();
        } else {
            View viewC = c();
            this.c.o += this.o.d();
            this.c.l = this.p ? 1 : -1;
            this.c.k = e(viewC) + this.c.l;
            this.c.i = this.o.a(viewC);
            iD = (-this.o.a(viewC)) + this.o.d();
        }
        this.c.j = i2;
        if (z) {
            this.c.j -= iD;
        }
        this.c.n = iD;
    }

    private void a(a aVar) {
        a(aVar.b, aVar.c);
    }

    private void a(RecyclerView.q qVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                b(i, qVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                b(i3, qVar);
            }
        }
    }

    private void a(RecyclerView.q qVar, c cVar) {
        if (!cVar.h || cVar.t) {
            return;
        }
        int i = cVar.n;
        int i2 = cVar.p;
        if (cVar.m == -1) {
            c(qVar, i, i2);
        } else {
            b(qVar, i, i2);
        }
    }

    private void a(RecyclerView.q qVar, RecyclerView.w wVar, a aVar) {
        if (a(wVar, aVar) || b(qVar, wVar, aVar)) {
            return;
        }
        aVar.b();
        aVar.b = this.f ? wVar.h() - 1 : 0;
    }

    private boolean a(RecyclerView.w wVar, a aVar) {
        if (wVar.b() || this.q == -1) {
            return false;
        }
        if (this.q < 0 || this.q >= wVar.h()) {
            this.q = -1;
            this.r = Integer.MIN_VALUE;
            return false;
        }
        aVar.b = this.q;
        if (this.s != null && this.s.a()) {
            aVar.d = this.s.c;
            if (aVar.d) {
                aVar.c = this.o.e() - this.s.b;
            } else {
                aVar.c = this.o.d() + this.s.b;
            }
            return true;
        }
        if (this.r != Integer.MIN_VALUE) {
            aVar.d = this.p;
            if (this.p) {
                aVar.c = this.o.e() - this.r;
            } else {
                aVar.c = this.o.d() + this.r;
            }
            return true;
        }
        View viewC = c(this.q);
        if (viewC == null) {
            if (H() > 0) {
                aVar.d = (this.q < e(j(0))) == this.p;
            }
            aVar.b();
        } else {
            if (this.o.e(viewC) > this.o.g()) {
                aVar.b();
                return true;
            }
            if (this.o.a(viewC) - this.o.d() < 0) {
                aVar.c = this.o.d();
                aVar.d = false;
                return true;
            }
            if (this.o.e() - this.o.b(viewC) < 0) {
                aVar.c = this.o.e();
                aVar.d = true;
                return true;
            }
            aVar.c = aVar.d ? this.o.b(viewC) + this.o.c() : this.o.a(viewC);
        }
        return true;
    }

    private View ac() {
        return this.p ? ae() : af();
    }

    private View ad() {
        return this.p ? af() : ae();
    }

    private View ae() {
        return c(0, H());
    }

    private View af() {
        return c(H() - 1, -1);
    }

    private void ag() {
        Log.d(f987a, "internal representation of views on the screen");
        for (int i = 0; i < H(); i++) {
            View viewJ = j(i);
            Log.d(f987a, "item " + e(viewJ) + ", coord:" + this.o.a(viewJ));
        }
        Log.d(f987a, "==============");
    }

    private int b(int i, RecyclerView.q qVar, RecyclerView.w wVar, boolean z) {
        int iD;
        int iD2 = i - this.o.d();
        if (iD2 <= 0) {
            return 0;
        }
        int i2 = -c(iD2, qVar, wVar);
        int i3 = i + i2;
        if (!z || (iD = i3 - this.o.d()) <= 0) {
            return i2;
        }
        this.o.a(-iD);
        return i2 - iD;
    }

    private void b() {
        if (this.n == 1 || !n()) {
            this.p = this.e;
        } else {
            this.p = !this.e;
        }
    }

    private void b(a aVar) {
        h(aVar.b, aVar.c);
    }

    private void b(RecyclerView.q qVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iH = H();
        if (!this.p) {
            for (int i4 = 0; i4 < iH; i4++) {
                View viewJ = j(i4);
                if (this.o.b(viewJ) > i3 || this.o.c(viewJ) > i3) {
                    a(qVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iH - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewJ2 = j(i6);
            if (this.o.b(viewJ2) > i3 || this.o.c(viewJ2) > i3) {
                a(qVar, i5, i6);
                return;
            }
        }
    }

    private void b(RecyclerView.q qVar, RecyclerView.w wVar, int i, int i2) {
        if (!wVar.c() || H() == 0 || wVar.b() || !d()) {
            return;
        }
        List<RecyclerView.z> listC = qVar.c();
        int size = listC.size();
        int iE = e(j(0));
        int iE2 = 0;
        int iE3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.z zVar = listC.get(i3);
            if (!zVar.s()) {
                if (((zVar.e() < iE) != this.p ? (byte) -1 : (byte) 1) == -1) {
                    iE2 += this.o.e(zVar.f1016a);
                } else {
                    iE3 += this.o.e(zVar.f1016a);
                }
            }
        }
        this.c.s = listC;
        if (iE2 > 0) {
            h(e(c()), i);
            this.c.o = iE2;
            this.c.j = 0;
            this.c.a();
            a(qVar, this.c, wVar, false);
        }
        if (iE3 > 0) {
            a(e(e()), i2);
            this.c.o = iE3;
            this.c.j = 0;
            this.c.a();
            a(qVar, this.c, wVar, false);
        }
        this.c.s = null;
    }

    private boolean b(RecyclerView.q qVar, RecyclerView.w wVar, a aVar) {
        if (H() == 0) {
            return false;
        }
        View viewU = U();
        if (viewU != null && aVar.a(viewU, wVar)) {
            aVar.a(viewU, e(viewU));
            return true;
        }
        if (this.d != this.f) {
            return false;
        }
        View viewF = aVar.d ? f(qVar, wVar) : g(qVar, wVar);
        if (viewF == null) {
            return false;
        }
        aVar.b(viewF, e(viewF));
        if (!wVar.b() && d()) {
            if (this.o.a(viewF) >= this.o.e() || this.o.b(viewF) < this.o.d()) {
                aVar.c = aVar.d ? this.o.e() : this.o.d();
            }
        }
        return true;
    }

    private View c() {
        return j(this.p ? H() - 1 : 0);
    }

    private void c(RecyclerView.q qVar, int i, int i2) {
        int iH = H();
        if (i < 0) {
            return;
        }
        int iF = (this.o.f() - i) + i2;
        if (this.p) {
            for (int i3 = 0; i3 < iH; i3++) {
                View viewJ = j(i3);
                if (this.o.a(viewJ) < iF || this.o.d(viewJ) < iF) {
                    a(qVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iH - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewJ2 = j(i5);
            if (this.o.a(viewJ2) < iF || this.o.d(viewJ2) < iF) {
                a(qVar, i4, i5);
                return;
            }
        }
    }

    private View e() {
        return j(this.p ? 0 : H() - 1);
    }

    private View f(RecyclerView.q qVar, RecyclerView.w wVar) {
        return this.p ? h(qVar, wVar) : i(qVar, wVar);
    }

    private View g(RecyclerView.q qVar, RecyclerView.w wVar) {
        return this.p ? i(qVar, wVar) : h(qVar, wVar);
    }

    private View h(RecyclerView.q qVar, RecyclerView.w wVar) {
        return a(qVar, wVar, 0, H(), wVar.h());
    }

    private void h(int i, int i2) {
        this.c.j = i2 - this.o.d();
        this.c.k = i;
        this.c.l = this.p ? 1 : -1;
        this.c.m = -1;
        this.c.i = i2;
        this.c.n = Integer.MIN_VALUE;
    }

    private int i(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        o();
        return z.a(wVar, this.o, a(!this.g, true), b(!this.g, true), this, this.g, this.p);
    }

    private View i(RecyclerView.q qVar, RecyclerView.w wVar) {
        return a(qVar, wVar, H() - 1, -1, wVar.h());
    }

    private int j(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        o();
        return z.a(wVar, this.o, a(!this.g, true), b(!this.g, true), this, this.g);
    }

    private int k(RecyclerView.w wVar) {
        if (H() == 0) {
            return 0;
        }
        o();
        return z.b(wVar, this.o, a(!this.g, true), b(!this.g, true), this, this.g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        if (this.n == 1) {
            return 0;
        }
        return c(i, qVar, wVar);
    }

    int a(RecyclerView.q qVar, c cVar, RecyclerView.w wVar, boolean z) {
        int i = cVar.j;
        if (cVar.n != Integer.MIN_VALUE) {
            if (cVar.j < 0) {
                cVar.n += cVar.j;
            }
            a(qVar, cVar);
        }
        int i2 = cVar.j + cVar.o;
        b bVar = this.i;
        while (true) {
            if ((!cVar.t && i2 <= 0) || !cVar.a(wVar)) {
                break;
            }
            bVar.a();
            a(qVar, wVar, cVar, bVar);
            if (!bVar.b) {
                cVar.i += bVar.f989a * cVar.m;
                if (!bVar.c || cVar.s != null || !wVar.b()) {
                    cVar.j -= bVar.f989a;
                    i2 -= bVar.f989a;
                }
                if (cVar.n != Integer.MIN_VALUE) {
                    cVar.n += bVar.f989a;
                    if (cVar.j < 0) {
                        cVar.n += cVar.j;
                    }
                    a(qVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.j;
    }

    View a(int i, int i2, boolean z, boolean z2) {
        o();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.n == 0 ? this.w.a(i, i2, i3, i4) : this.x.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View a(View view, int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        int iG;
        b();
        if (H() == 0 || (iG = g(i)) == Integer.MIN_VALUE) {
            return null;
        }
        o();
        a(iG, (int) (this.o.g() * b), false, wVar);
        this.c.n = Integer.MIN_VALUE;
        this.c.h = false;
        a(qVar, this.c, wVar, true);
        View viewAd = iG == -1 ? ad() : ac();
        View viewC = iG == -1 ? c() : e();
        if (!viewC.hasFocusable()) {
            return viewAd;
        }
        if (viewAd == null) {
            return null;
        }
        return viewC;
    }

    View a(RecyclerView.q qVar, RecyclerView.w wVar, int i, int i2, int i3) {
        o();
        int iD = this.o.d();
        int iE = this.o.e();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewJ = j(i);
            int iE2 = e(viewJ);
            if (iE2 >= 0 && iE2 < i3) {
                if (((RecyclerView.j) viewJ.getLayoutParams()).e()) {
                    if (view2 == null) {
                        view2 = viewJ;
                    }
                } else {
                    if (this.o.a(viewJ) < iE && this.o.b(viewJ) >= iD) {
                        return viewJ;
                    }
                    if (view == null) {
                        view = viewJ;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    View a(boolean z, boolean z2) {
        return this.p ? a(H() - 1, -1, z, z2) : a(0, H(), z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        return new RecyclerView.j(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, int i2, RecyclerView.w wVar, RecyclerView.i.a aVar) {
        if (this.n != 0) {
            i = i2;
        }
        if (H() == 0 || i == 0) {
            return;
        }
        o();
        a(i > 0 ? 1 : -1, Math.abs(i), true, wVar);
        a(wVar, this.c, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(int i, RecyclerView.i.a aVar) {
        boolean z;
        int i2;
        if (this.s == null || !this.s.a()) {
            b();
            z = this.p;
            i2 = this.q == -1 ? z ? i - 1 : 0 : this.q;
        } else {
            z = this.s.c;
            i2 = this.s.f991a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.E && i2 >= 0 && i2 < i; i4++) {
            aVar.b(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.s = (d) parcelable;
            z();
        }
    }

    @Override // androidx.recyclerview.widget.m.e
    public void a(@androidx.annotation.ah View view, @androidx.annotation.ah View view2, int i, int i2) {
        a("Cannot drop a view during a scroll or layout calculation");
        o();
        b();
        int iE = e(view);
        int iE2 = e(view2);
        byte b2 = iE < iE2 ? (byte) 1 : (byte) -1;
        if (this.p) {
            if (b2 == 1) {
                b(iE2, this.o.e() - (this.o.a(view2) + this.o.e(view)));
                return;
            } else {
                b(iE2, this.o.e() - this.o.b(view2));
                return;
            }
        }
        if (b2 == -1) {
            b(iE2, this.o.a(view2));
        } else {
            b(iE2, this.o.b(view2) - this.o.e(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (H() > 0) {
            accessibilityEvent.setFromIndex(u());
            accessibilityEvent.setToIndex(w());
        }
    }

    void a(RecyclerView.q qVar, RecyclerView.w wVar, a aVar, int i) {
    }

    void a(RecyclerView.q qVar, RecyclerView.w wVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int iM;
        int iF;
        View viewA = cVar.a(qVar);
        if (viewA == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) viewA.getLayoutParams();
        if (cVar.s == null) {
            if (this.p == (cVar.m == -1)) {
                c(viewA);
            } else {
                b(viewA, 0);
            }
        } else {
            if (this.p == (cVar.m == -1)) {
                b(viewA);
            } else {
                a(viewA, 0);
            }
        }
        b(viewA, 0, 0);
        bVar.f989a = this.o.e(viewA);
        if (this.n == 1) {
            if (n()) {
                iF = K() - O();
                iM = iF - this.o.f(viewA);
            } else {
                iM = M();
                iF = this.o.f(viewA) + iM;
            }
            if (cVar.m == -1) {
                int i4 = cVar.i;
                i2 = cVar.i - bVar.f989a;
                i = iF;
                i3 = i4;
            } else {
                int i5 = cVar.i;
                i3 = cVar.i + bVar.f989a;
                i = iF;
                i2 = i5;
            }
        } else {
            int iN = N();
            int iF2 = this.o.f(viewA) + iN;
            if (cVar.m == -1) {
                i2 = iN;
                i = cVar.i;
                i3 = iF2;
                iM = cVar.i - bVar.f989a;
            } else {
                int i6 = cVar.i;
                i = cVar.i + bVar.f989a;
                i2 = iN;
                i3 = iF2;
                iM = i6;
            }
        }
        b(viewA, iM, i2, i, i3);
        if (jVar.e() || jVar.f()) {
            bVar.c = true;
        }
        bVar.d = viewA.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.w wVar) {
        super.a(wVar);
        this.s = null;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.t.a();
    }

    void a(RecyclerView.w wVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.k;
        if (i < 0 || i >= wVar.h()) {
            return;
        }
        aVar.b(i, Math.max(0, cVar.n));
    }

    protected void a(@androidx.annotation.ah RecyclerView.w wVar, @androidx.annotation.ah int[] iArr) {
        int i;
        int iF = f(wVar);
        if (this.c.m == -1) {
            i = 0;
        } else {
            i = iF;
            iF = 0;
        }
        iArr[0] = iF;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.q qVar) {
        super.a(recyclerView, qVar);
        if (this.h) {
            c(qVar);
            qVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, RecyclerView.w wVar, int i) {
        q qVar = new q(recyclerView.getContext());
        qVar.c(i);
        a(qVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(String str) {
        if (this.s == null) {
            super.a(str);
        }
    }

    public void a(boolean z) {
        a((String) null);
        if (this.f == z) {
            return;
        }
        this.f = z;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        if (this.n == 0) {
            return 0;
        }
        return c(i, qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.w wVar) {
        return k(wVar);
    }

    View b(boolean z, boolean z2) {
        return this.p ? a(0, H(), z, z2) : a(H() - 1, -1, z, z2);
    }

    public void b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        a((String) null);
        if (i != this.n || this.o == null) {
            this.o = w.a(this, i);
            this.t.f988a = this.o;
            this.n = i;
            z();
        }
    }

    public void b(int i, int i2) {
        this.q = i;
        this.r = i2;
        if (this.s != null) {
            this.s.b();
        }
        z();
    }

    int c(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        if (H() == 0 || i == 0) {
            return 0;
        }
        o();
        this.c.h = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        a(i2, iAbs, true, wVar);
        int iA = this.c.n + a(qVar, this.c, wVar, false);
        if (iA < 0) {
            return 0;
        }
        if (iAbs > iA) {
            i = i2 * iA;
        }
        this.o.a(-i);
        this.c.r = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.w wVar) {
        return k(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public View c(int i) {
        int iH = H();
        if (iH == 0) {
            return null;
        }
        int iE = i - e(j(0));
        if (iE >= 0 && iE < iH) {
            View viewJ = j(iE);
            if (e(viewJ) == i) {
                return viewJ;
            }
        }
        return super.c(i);
    }

    View c(int i, int i2) {
        byte b2;
        int i3;
        int i4;
        o();
        if (i2 > i) {
            b2 = 1;
        } else {
            b2 = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b2 == 0) {
            return j(i);
        }
        if (this.o.a(j(i)) < this.o.d()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = androidx.fragment.app.s.L;
        }
        return this.n == 0 ? this.w.a(i, i2, i3, i4) : this.x.a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.q qVar, RecyclerView.w wVar) {
        int i;
        int i2;
        View viewC;
        int i3 = -1;
        if (!(this.s == null && this.q == -1) && wVar.h() == 0) {
            c(qVar);
            return;
        }
        if (this.s != null && this.s.a()) {
            this.q = this.s.f991a;
        }
        o();
        this.c.h = false;
        b();
        View viewU = U();
        if (!this.t.e || this.q != -1 || this.s != null) {
            this.t.a();
            this.t.d = this.p ^ this.f;
            a(qVar, wVar, this.t);
            this.t.e = true;
        } else if (viewU != null && (this.o.a(viewU) >= this.o.e() || this.o.b(viewU) <= this.o.d())) {
            this.t.a(viewU, e(viewU));
        }
        this.c.m = this.c.r >= 0 ? 1 : -1;
        this.F[0] = 0;
        this.F[1] = 0;
        a(wVar, this.F);
        int iMax = Math.max(0, this.F[0]) + this.o.d();
        int iMax2 = Math.max(0, this.F[1]) + this.o.h();
        if (wVar.b() && this.q != -1 && this.r != Integer.MIN_VALUE && (viewC = c(this.q)) != null) {
            int iE = this.p ? (this.o.e() - this.o.b(viewC)) - this.r : this.r - (this.o.a(viewC) - this.o.d());
            if (iE > 0) {
                iMax += iE;
            } else {
                iMax2 -= iE;
            }
        }
        if (!this.t.d ? !this.p : this.p) {
            i3 = 1;
        }
        a(qVar, wVar, this.t, i3);
        a(qVar);
        this.c.t = r();
        this.c.q = wVar.b();
        this.c.p = 0;
        if (this.t.d) {
            b(this.t);
            this.c.o = iMax;
            a(qVar, this.c, wVar, false);
            i2 = this.c.i;
            int i4 = this.c.k;
            if (this.c.j > 0) {
                iMax2 += this.c.j;
            }
            a(this.t);
            this.c.o = iMax2;
            this.c.k += this.c.l;
            a(qVar, this.c, wVar, false);
            i = this.c.i;
            if (this.c.j > 0) {
                int i5 = this.c.j;
                h(i4, i2);
                this.c.o = i5;
                a(qVar, this.c, wVar, false);
                i2 = this.c.i;
            }
        } else {
            a(this.t);
            this.c.o = iMax2;
            a(qVar, this.c, wVar, false);
            i = this.c.i;
            int i6 = this.c.k;
            if (this.c.j > 0) {
                iMax += this.c.j;
            }
            b(this.t);
            this.c.o = iMax;
            this.c.k += this.c.l;
            a(qVar, this.c, wVar, false);
            i2 = this.c.i;
            if (this.c.j > 0) {
                int i7 = this.c.j;
                a(i6, i);
                this.c.o = i7;
                a(qVar, this.c, wVar, false);
                i = this.c.i;
            }
        }
        if (H() > 0) {
            if (this.p ^ this.f) {
                int iA = a(i, qVar, wVar, true);
                int i8 = i2 + iA;
                int i9 = i + iA;
                int iB = b(i8, qVar, wVar, false);
                i2 = i8 + iB;
                i = i9 + iB;
            } else {
                int iB2 = b(i2, qVar, wVar, true);
                int i10 = i2 + iB2;
                int i11 = i + iB2;
                int iA2 = a(i11, qVar, wVar, false);
                i2 = i10 + iA2;
                i = i11 + iA2;
            }
        }
        b(qVar, wVar, i2, i);
        if (wVar.b()) {
            this.t.a();
        } else {
            this.o.b();
        }
        this.d = this.f;
    }

    public void c(boolean z) {
        this.h = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.w wVar) {
        return i(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF d(int i) {
        if (H() == 0) {
            return null;
        }
        int i2 = (i < e(j(0))) != this.p ? -1 : 1;
        return this.n == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public void d(boolean z) {
        a((String) null);
        if (z == this.e) {
            return;
        }
        this.e = z;
        z();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean d() {
        return this.s == null && this.d == this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.w wVar) {
        return i(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(int i) {
        this.q = i;
        this.r = Integer.MIN_VALUE;
        if (this.s != null) {
            this.s.b();
        }
        z();
    }

    public void e(boolean z) {
        this.g = z;
    }

    @Deprecated
    protected int f(RecyclerView.w wVar) {
        if (wVar.f()) {
            return this.o.g();
        }
        return 0;
    }

    public void f(int i) {
        this.E = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean f() {
        return true;
    }

    int g(int i) {
        if (i == 17) {
            return this.n == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.n == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.n == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i == 130) {
            return this.n == 1 ? 1 : Integer.MIN_VALUE;
        }
        switch (i) {
            case 1:
                return (this.n != 1 && n()) ? 1 : -1;
            case 2:
                return (this.n != 1 && n()) ? -1 : 1;
            default:
                return Integer.MIN_VALUE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int g(RecyclerView.w wVar) {
        return j(wVar);
    }

    public boolean g() {
        return this.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int h(RecyclerView.w wVar) {
        return j(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public Parcelable h() {
        if (this.s != null) {
            return new d(this.s);
        }
        d dVar = new d();
        if (H() > 0) {
            o();
            boolean z = this.d ^ this.p;
            dVar.c = z;
            if (z) {
                View viewE = e();
                dVar.b = this.o.e() - this.o.b(viewE);
                dVar.f991a = e(viewE);
            } else {
                View viewC = c();
                dVar.f991a = e(viewC);
                dVar.b = this.o.a(viewC) - this.o.d();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean i() {
        return this.n == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean j() {
        return this.n == 1;
    }

    public boolean k() {
        return this.f;
    }

    public int l() {
        return this.n;
    }

    public boolean m() {
        return this.e;
    }

    protected boolean n() {
        return E() == 1;
    }

    void o() {
        if (this.c == null) {
            this.c = p();
        }
    }

    c p() {
        return new c();
    }

    public boolean q() {
        return this.g;
    }

    boolean r() {
        return this.o.i() == 0 && this.o.f() == 0;
    }

    public int s() {
        return this.E;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    boolean t() {
        return (J() == 1073741824 || I() == 1073741824 || !ab()) ? false : true;
    }

    public int u() {
        View viewA = a(0, H(), false, true);
        if (viewA == null) {
            return -1;
        }
        return e(viewA);
    }

    public int v() {
        View viewA = a(0, H(), true, false);
        if (viewA == null) {
            return -1;
        }
        return e(viewA);
    }

    public int w() {
        View viewA = a(H() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return e(viewA);
    }

    public int x() {
        View viewA = a(H() - 1, -1, true, false);
        if (viewA == null) {
            return -1;
        }
        return e(viewA);
    }

    void y() {
        Log.d(f987a, "validating child count " + H());
        if (H() < 1) {
            return;
        }
        int iE = e(j(0));
        int iA = this.o.a(j(0));
        if (this.p) {
            for (int i = 1; i < H(); i++) {
                View viewJ = j(i);
                int iE2 = e(viewJ);
                int iA2 = this.o.a(viewJ);
                if (iE2 < iE) {
                    ag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(iA2 < iA);
                    throw new RuntimeException(sb.toString());
                }
                if (iA2 > iA) {
                    ag();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < H(); i2++) {
            View viewJ2 = j(i2);
            int iE3 = e(viewJ2);
            int iA3 = this.o.a(viewJ2);
            if (iE3 < iE) {
                ag();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(iA3 < iA);
                throw new RuntimeException(sb2.toString());
            }
            if (iA3 < iA) {
                ag();
                throw new RuntimeException("detected invalid location");
            }
        }
    }
}
