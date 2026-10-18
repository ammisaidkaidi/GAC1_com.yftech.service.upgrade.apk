package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean E = false;
    private static final String F = "GridLayoutManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f984a = -1;
    private boolean G;
    boolean b;
    int c;
    int[] d;
    View[] e;
    final SparseIntArray f;
    final SparseIntArray g;
    c h;
    final Rect i;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int a(int i) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int a(int i, int i2) {
            return i % i2;
        }
    }

    public static class b extends RecyclerView.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f985a = -1;
        int b;
        int c;

        public b(int i, int i2) {
            super(i, i2);
            this.b = -1;
            this.c = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = -1;
            this.c = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = -1;
            this.c = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = -1;
            this.c = 0;
        }

        public b(RecyclerView.j jVar) {
            super(jVar);
            this.b = -1;
            this.c = 0;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SparseIntArray f986a = new SparseIntArray();
        final SparseIntArray b = new SparseIntArray();
        private boolean c = false;
        private boolean d = false;

        static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public abstract int a(int i);

        public int a(int i, int i2) {
            int i3;
            int iA;
            int iA2;
            int iA3 = a(i);
            if (iA3 == i2) {
                return 0;
            }
            if (!this.c || (iA2 = a(this.f986a, i)) < 0) {
                i3 = 0;
                iA = 0;
            } else {
                iA = this.f986a.get(iA2) + a(iA2);
                i3 = iA2 + 1;
            }
            while (i3 < i) {
                int iA4 = a(i3);
                iA += iA4;
                if (iA == i2) {
                    iA = 0;
                } else if (iA > i2) {
                    iA = iA4;
                }
                i3++;
            }
            if (iA3 + iA <= i2) {
                return iA;
            }
            return 0;
        }

        public void a() {
            this.f986a.clear();
        }

        public void a(boolean z) {
            if (!z) {
                this.b.clear();
            }
            this.c = z;
        }

        int b(int i, int i2) {
            if (!this.c) {
                return a(i, i2);
            }
            int i3 = this.f986a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iA = a(i, i2);
            this.f986a.put(i, iA);
            return iA;
        }

        public void b() {
            this.b.clear();
        }

        public void b(boolean z) {
            if (!z) {
                this.b.clear();
            }
            this.d = z;
        }

        int c(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d(i, i2);
            this.b.put(i, iD);
            return iD;
        }

        public boolean c() {
            return this.c;
        }

        public int d(int i, int i2) {
            int iA;
            int i3;
            int i4;
            int iA2;
            if (!this.d || (iA2 = a(this.b, i)) == -1) {
                iA = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i3 = this.b.get(iA2);
                i4 = iA2 + 1;
                iA = a(iA2) + b(iA2, i2);
                if (iA == i2) {
                    i3++;
                    iA = 0;
                }
            }
            int iA3 = a(i);
            while (i4 < i) {
                int iA4 = a(i4);
                iA += iA4;
                if (iA == i2) {
                    i3++;
                    iA = 0;
                } else if (iA > i2) {
                    i3++;
                    iA = iA4;
                }
                i4++;
            }
            return iA + iA3 > i2 ? i3 + 1 : i3;
        }

        public boolean d() {
            return this.d;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new a();
        this.i = new Rect();
        a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new a();
        this.i = new Rect();
        a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new a();
        this.i = new Rect();
        a(a(context, attributeSet, i, i2).b);
    }

    private int a(RecyclerView.q qVar, RecyclerView.w wVar, int i) {
        if (!wVar.b()) {
            return this.h.c(i, this.c);
        }
        int iB = qVar.b(i);
        if (iB != -1) {
            return this.h.c(iB, this.c);
        }
        Log.w(F, "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void a(float f, int i) {
        n(Math.max(Math.round(f * this.c), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z ? a(view, i, i2, jVar) : b(view, i, i2, jVar)) {
            view.measure(i, i2);
        }
    }

    private void a(View view, int i, boolean z) {
        int iA;
        int iA2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.e;
        int i2 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i3 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int iA3 = a(bVar.b, bVar.c);
        if (this.n == 1) {
            iA2 = a(iA3, i, i3, bVar.width, false);
            iA = a(this.o.g(), J(), i2, bVar.height, true);
        } else {
            int iA4 = a(iA3, i, i2, bVar.height, false);
            int iA5 = a(this.o.g(), I(), i3, bVar.width, true);
            iA = iA4;
            iA2 = iA5;
        }
        a(view, iA2, iA, z);
    }

    private void a(RecyclerView.q qVar, RecyclerView.w wVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = -1;
        int i5 = 0;
        if (z) {
            i3 = 1;
            i4 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View view = this.e[i2];
            b bVar = (b) view.getLayoutParams();
            bVar.c = c(qVar, wVar, e(view));
            bVar.b = i5;
            i5 += bVar.c;
            i2 += i3;
        }
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private void ac() {
        this.f.clear();
        this.g.clear();
    }

    private void ad() {
        int iH = H();
        for (int i = 0; i < iH; i++) {
            b bVar = (b) j(i).getLayoutParams();
            int iH2 = bVar.h();
            this.f.put(iH2, bVar.b());
            this.g.put(iH2, bVar.a());
        }
    }

    private void ae() {
        n(l() == 1 ? (K() - O()) - M() : (L() - P()) - N());
    }

    private void af() {
        if (this.e == null || this.e.length != this.c) {
            this.e = new View[this.c];
        }
    }

    private int b(RecyclerView.q qVar, RecyclerView.w wVar, int i) {
        if (!wVar.b()) {
            return this.h.b(i, this.c);
        }
        int i2 = this.g.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = qVar.b(i);
        if (iB != -1) {
            return this.h.b(iB, this.c);
        }
        Log.w(F, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void b(RecyclerView.q qVar, RecyclerView.w wVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iB = b(qVar, wVar, aVar.b);
        if (z) {
            while (iB > 0 && aVar.b > 0) {
                aVar.b--;
                iB = b(qVar, wVar, aVar.b);
            }
            return;
        }
        int iH = wVar.h() - 1;
        int i2 = aVar.b;
        while (i2 < iH) {
            int i3 = i2 + 1;
            int iB2 = b(qVar, wVar, i3);
            if (iB2 <= iB) {
                break;
            }
            i2 = i3;
            iB = iB2;
        }
        aVar.b = i2;
    }

    private int c(RecyclerView.q qVar, RecyclerView.w wVar, int i) {
        if (!wVar.b()) {
            return this.h.a(i);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iB = qVar.b(i);
        if (iB != -1) {
            return this.h.a(iB);
        }
        Log.w(F, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private int i(RecyclerView.w wVar) {
        if (H() == 0 || wVar.h() == 0) {
            return 0;
        }
        o();
        View viewA = a(!q(), true);
        View viewB = b(!q(), true);
        if (viewA == null || viewB == null) {
            return 0;
        }
        if (!q()) {
            return this.h.c(wVar.h() - 1, this.c) + 1;
        }
        return (int) (((this.o.b(viewB) - this.o.a(viewA)) / ((this.h.c(e(viewB), this.c) - this.h.c(e(viewA), this.c)) + 1)) * (this.h.c(wVar.h() - 1, this.c) + 1));
    }

    private int j(RecyclerView.w wVar) {
        if (H() == 0 || wVar.h() == 0) {
            return 0;
        }
        o();
        boolean zQ = q();
        View viewA = a(!zQ, true);
        View viewB = b(!zQ, true);
        if (viewA == null || viewB == null) {
            return 0;
        }
        int iC = this.h.c(e(viewA), this.c);
        int iC2 = this.h.c(e(viewB), this.c);
        int iMax = this.p ? Math.max(0, ((this.h.c(wVar.h() - 1, this.c) + 1) - Math.max(iC, iC2)) - 1) : Math.max(0, Math.min(iC, iC2));
        if (zQ) {
            return Math.round((iMax * (Math.abs(this.o.b(viewB) - this.o.a(viewA)) / ((this.h.c(e(viewB), this.c) - this.h.c(e(viewA), this.c)) + 1))) + (this.o.d() - this.o.a(viewA)));
        }
        return iMax;
    }

    private void n(int i) {
        this.d = a(this.d, this.c, i);
    }

    int a(int i, int i2) {
        return (this.n == 1 && n()) ? this.d[this.c - i] - this.d[(this.c - i) - i2] : this.d[i2 + i] - this.d[i];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int a(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        ae();
        af();
        return super.a(i, qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int a(RecyclerView.q qVar, RecyclerView.w wVar) {
        if (this.n == 0) {
            return this.c;
        }
        if (wVar.h() < 1) {
            return 0;
        }
        return a(qVar, wVar, wVar.h() - 1) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d8, code lost:
    
        if (r13 == (r2 > r8)) goto L48;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View a(View view, int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        int iH;
        int i2;
        int iH2;
        View view2;
        int i3;
        int i4;
        View view3;
        int i5;
        int i6;
        boolean z;
        RecyclerView.q qVar2 = qVar;
        RecyclerView.w wVar2 = wVar;
        View viewG = g(view);
        View view4 = null;
        if (viewG == null) {
            return null;
        }
        b bVar = (b) viewG.getLayoutParams();
        int i7 = bVar.b;
        int i8 = bVar.b + bVar.c;
        if (super.a(view, i, qVar, wVar) == null) {
            return null;
        }
        if ((g(i) == 1) != this.p) {
            iH2 = H() - 1;
            iH = -1;
            i2 = -1;
        } else {
            iH = H();
            i2 = 1;
            iH2 = 0;
        }
        boolean z2 = this.n == 1 && n();
        int iA = a(qVar2, wVar2, iH2);
        int i9 = -1;
        int i10 = -1;
        int iMin = 0;
        int iMin2 = 0;
        View view5 = null;
        while (iH2 != iH) {
            int iA2 = a(qVar2, wVar2, iH2);
            View viewJ = j(iH2);
            if (viewJ == viewG) {
                break;
            }
            if (!viewJ.hasFocusable() || iA2 == iA) {
                b bVar2 = (b) viewJ.getLayoutParams();
                int i11 = bVar2.b;
                view2 = viewG;
                i3 = iH;
                int i12 = bVar2.b + bVar2.c;
                if (viewJ.hasFocusable() && i11 == i7 && i12 == i8) {
                    return viewJ;
                }
                if (!(viewJ.hasFocusable() && view4 == null) && (viewJ.hasFocusable() || view5 != null)) {
                    int iMin3 = Math.min(i12, i8) - Math.max(i11, i7);
                    if (viewJ.hasFocusable()) {
                        if (iMin3 <= iMin) {
                            if (iMin3 == iMin) {
                            }
                        }
                        i4 = i9;
                        view3 = view5;
                        i5 = iMin2;
                        i6 = i10;
                        z = true;
                    } else {
                        if (view4 == null) {
                            i4 = i9;
                            view3 = view5;
                            if (a(viewJ, false, true)) {
                                i5 = iMin2;
                                if (iMin3 > i5) {
                                    i6 = i10;
                                } else {
                                    if (iMin3 == i5) {
                                        i6 = i10;
                                        if (z2 == (i11 > i6)) {
                                        }
                                    }
                                    z = false;
                                }
                                z = true;
                            }
                            i6 = i10;
                            z = false;
                        }
                        i5 = iMin2;
                        i6 = i10;
                        z = false;
                    }
                    i4 = i9;
                    view3 = view5;
                    i5 = iMin2;
                    i6 = i10;
                    z = false;
                } else {
                    i4 = i9;
                    view3 = view5;
                    i5 = iMin2;
                    i6 = i10;
                    z = true;
                }
                if (z) {
                    if (viewJ.hasFocusable()) {
                        int i13 = bVar2.b;
                        iMin = Math.min(i12, i8) - Math.max(i11, i7);
                        iMin2 = i5;
                        i10 = i6;
                        view5 = view3;
                        i9 = i13;
                        view4 = viewJ;
                    } else {
                        int i14 = bVar2.b;
                        view5 = viewJ;
                        iMin2 = Math.min(i12, i8) - Math.max(i11, i7);
                        i10 = i14;
                        i9 = i4;
                    }
                }
                iH2 += i2;
                viewG = view2;
                iH = i3;
                qVar2 = qVar;
                wVar2 = wVar;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewG;
                i4 = i9;
                view3 = view5;
                i3 = iH;
                i5 = iMin2;
                i6 = i10;
            }
            iMin2 = i5;
            i10 = i6;
            i9 = i4;
            view5 = view3;
            iH2 += i2;
            viewG = view2;
            iH = i3;
            qVar2 = qVar;
            wVar2 = wVar;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (iE2 >= 0 && iE2 < i3 && b(qVar, wVar, iE2) == 0) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public RecyclerView.j a() {
        return this.n == 0 ? new b(-2, -1) : new b(-1, -2);
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
        if (i == this.c) {
            return;
        }
        this.b = true;
        if (i >= 1) {
            this.c = i;
            this.h.a();
            z();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        if (this.d == null) {
            super.a(rect, i, i2);
        }
        int iM = M() + O();
        int iN = N() + P();
        if (this.n == 1) {
            iA2 = a(i2, rect.height() + iN, Y());
            iA = a(i, this.d[this.d.length - 1] + iM, X());
        } else {
            iA = a(i, rect.width() + iM, X());
            iA2 = a(i2, this.d[this.d.length - 1] + iN, Y());
        }
        g(iA, iA2);
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.q qVar, RecyclerView.w wVar, View view, androidx.core.n.a.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iA = a(qVar, wVar, bVar.h());
        if (this.n == 0) {
            dVar.c(androidx.core.n.a.d.c.a(bVar.a(), bVar.b(), iA, 1, false, false));
        } else {
            dVar.c(androidx.core.n.a.d.c.a(iA, 1, bVar.a(), bVar.b(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.q qVar, RecyclerView.w wVar, LinearLayoutManager.a aVar, int i) {
        super.a(qVar, wVar, aVar, i);
        ae();
        if (wVar.h() > 0 && !wVar.b()) {
            b(qVar, wVar, aVar, i);
        }
        af();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.q qVar, RecyclerView.w wVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iF;
        int i5;
        int iF2;
        int iF3;
        int iA;
        int iA2;
        View viewA;
        int iJ = this.o.j();
        ?? r5 = 0;
        boolean z = iJ != 1073741824;
        int i6 = H() > 0 ? this.d[this.c] : 0;
        if (z) {
            ae();
        }
        boolean z2 = cVar.l == 1;
        int iB = this.c;
        if (!z2) {
            iB = b(qVar, wVar, cVar.k) + c(qVar, wVar, cVar.k);
        }
        int i7 = iB;
        int i8 = 0;
        while (i8 < this.c && cVar.a(wVar) && i7 > 0) {
            int i9 = cVar.k;
            int iC = c(qVar, wVar, i9);
            if (iC > this.c) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iC + " spans but GridLayoutManager has only " + this.c + " spans.");
            }
            i7 -= iC;
            if (i7 < 0 || (viewA = cVar.a(qVar)) == null) {
                break;
            }
            this.e[i8] = viewA;
            i8++;
        }
        if (i8 == 0) {
            bVar.b = true;
            return;
        }
        float f = 0.0f;
        a(qVar, wVar, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.e[i10];
            if (cVar.s == null) {
                if (z2) {
                    c(view);
                } else {
                    b(view, (int) r5);
                }
            } else if (z2) {
                b(view);
            } else {
                a(view, (int) r5);
            }
            b(view, this.i);
            a(view, iJ, (boolean) r5);
            int iE = this.o.e(view);
            if (iE > i11) {
                i11 = iE;
            }
            float f2 = (this.o.f(view) * 1.0f) / ((b) view.getLayoutParams()).c;
            if (f2 > f) {
                f = f2;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            a(f, i6);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.e[i12];
                a(view2, androidx.d.c.b.a.b.b, true);
                int iE2 = this.o.e(view2);
                if (iE2 > i11) {
                    i11 = iE2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.e[i13];
            if (this.o.e(view3) != i11) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.e;
                int i14 = rect.top + rect.bottom + bVar2.topMargin + bVar2.bottomMargin;
                int i15 = rect.left + rect.right + bVar2.leftMargin + bVar2.rightMargin;
                int iA3 = a(bVar2.b, bVar2.c);
                if (this.n == 1) {
                    iA2 = a(iA3, androidx.d.c.b.a.b.b, i15, bVar2.width, false);
                    iA = View.MeasureSpec.makeMeasureSpec(i11 - i14, androidx.d.c.b.a.b.b);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, androidx.d.c.b.a.b.b);
                    iA = a(iA3, androidx.d.c.b.a.b.b, i14, bVar2.height, false);
                    iA2 = iMakeMeasureSpec;
                }
                a(view3, iA2, iA, true);
            }
        }
        int i16 = 0;
        bVar.f989a = i11;
        if (this.n == 1) {
            if (cVar.m == -1) {
                int i17 = cVar.i;
                i = i17 - i11;
                i2 = i17;
            } else {
                int i18 = cVar.i;
                i2 = i18 + i11;
                i = i18;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar.m == -1) {
            i3 = cVar.i;
            i4 = i3 - i11;
            i = 0;
            i2 = 0;
        } else {
            int i19 = cVar.i;
            int i20 = i19 + i11;
            i = 0;
            i2 = 0;
            i3 = i20;
            i4 = i19;
        }
        while (i16 < i8) {
            View view4 = this.e[i16];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.n != 1) {
                int iN = N() + this.d[bVar3.b];
                iF = i4;
                i5 = iN;
                iF2 = this.o.f(view4) + iN;
                iF3 = i3;
            } else if (n()) {
                int iM = M() + this.d[this.c - bVar3.b];
                iF3 = iM;
                i5 = i;
                iF2 = i2;
                iF = iM - this.o.f(view4);
            } else {
                int iM2 = M() + this.d[bVar3.b];
                iF = iM2;
                i5 = i;
                iF2 = i2;
                iF3 = this.o.f(view4) + iM2;
            }
            b(view4, iF, i5, iF3, iF2);
            if (bVar3.e() || bVar3.f()) {
                bVar.c = true;
            }
            bVar.d |= view4.hasFocusable();
            i16++;
            i4 = iF;
            i = i5;
            i3 = iF3;
            i2 = iF2;
        }
        Arrays.fill(this.e, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView.w wVar) {
        super.a(wVar);
        this.b = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void a(RecyclerView.w wVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int iA = this.c;
        for (int i = 0; i < this.c && cVar.a(wVar) && iA > 0; i++) {
            int i2 = cVar.k;
            aVar.b(i2, Math.max(0, cVar.n));
            iA -= this.h.a(i2);
            cVar.k += cVar.l;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView) {
        this.h.a();
        this.h.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2) {
        this.h.a();
        this.h.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.h.a();
        this.h.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.h.a();
        this.h.b();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.a(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(int i, RecyclerView.q qVar, RecyclerView.w wVar) {
        ae();
        af();
        return super.b(i, qVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.q qVar, RecyclerView.w wVar) {
        if (this.n == 1) {
            return this.c;
        }
        if (wVar.h() < 1) {
            return 0;
        }
        return a(qVar, wVar, wVar.h() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int b(RecyclerView.w wVar) {
        return this.G ? i(wVar) : super.b(wVar);
    }

    public c b() {
        return this.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.h.a();
        this.h.b();
    }

    public void b(boolean z) {
        this.G = z;
    }

    public int c() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int c(RecyclerView.w wVar) {
        return this.G ? i(wVar) : super.c(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public void c(RecyclerView.q qVar, RecyclerView.w wVar) {
        if (wVar.b()) {
            ad();
        }
        super.c(qVar, wVar);
        ac();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int d(RecyclerView.w wVar) {
        return this.G ? j(wVar) : super.d(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public boolean d() {
        return this.s == null && !this.b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i
    public int e(RecyclerView.w wVar) {
        return this.G ? j(wVar) : super.e(wVar);
    }

    public boolean e() {
        return this.G;
    }
}
