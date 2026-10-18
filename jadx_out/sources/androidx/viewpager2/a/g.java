package androidx.viewpager2.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class g extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1122a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final int f = -1;
    private h.f g;

    @ah
    private final h h;

    @ah
    private final RecyclerView i;

    @ah
    private final LinearLayoutManager j;
    private int k;
    private int l;
    private a m = new a();
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1123a;
        float b;
        int c;

        a() {
        }

        void a() {
            this.f1123a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    g(@ah h hVar) {
        this.h = hVar;
        this.i = this.h.j;
        this.j = (LinearLayoutManager) this.i.getLayoutManager();
        i();
    }

    private void a(int i) {
        if ((this.k == 3 && this.l == 0) || this.l == i) {
            return;
        }
        this.l = i;
        if (this.g != null) {
            this.g.a(i);
        }
    }

    private void a(int i, float f2, int i2) {
        if (this.g != null) {
            this.g.a(i, f2, i2);
        }
    }

    private void a(boolean z) {
        this.s = z;
        this.k = z ? 4 : 1;
        if (this.o != -1) {
            this.n = this.o;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    private void b(int i) {
        if (this.g != null) {
            this.g.b(i);
        }
    }

    private void i() {
        this.k = 0;
        this.l = 0;
        this.m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    private void j() {
        int top;
        a aVar = this.m;
        aVar.f1123a = this.j.u();
        if (aVar.f1123a == -1) {
            aVar.a();
            return;
        }
        View viewC = this.j.c(aVar.f1123a);
        if (viewC == null) {
            aVar.a();
            return;
        }
        int iU = this.j.u(viewC);
        int iV = this.j.v(viewC);
        int iS = this.j.s(viewC);
        int iT = this.j.t(viewC);
        ViewGroup.LayoutParams layoutParams = viewC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iU += marginLayoutParams.leftMargin;
            iV += marginLayoutParams.rightMargin;
            iS += marginLayoutParams.topMargin;
            iT += marginLayoutParams.bottomMargin;
        }
        int height = viewC.getHeight() + iS + iT;
        int width = iV + viewC.getWidth() + iU;
        if (this.j.l() == 0) {
            top = (viewC.getLeft() - iU) - this.i.getPaddingLeft();
            if (this.h.b()) {
                top = -top;
            }
        } else {
            top = (viewC.getTop() - iS) - this.i.getPaddingTop();
            width = height;
        }
        aVar.c = -top;
        if (aVar.c >= 0) {
            aVar.b = width == 0 ? 0.0f : aVar.c / width;
        } else {
            if (!new androidx.viewpager2.a.a(this.j).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        return this.k == 1 || this.k == 4;
    }

    private int l() {
        return this.j.u();
    }

    void a() {
        this.r = true;
    }

    void a(int i, boolean z) {
        this.k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i;
        this.o = i;
        a(2);
        if (z2) {
            b(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(@ah RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.k == 1 && this.l == 1) && i == 1) {
            a(false);
            return;
        }
        if (k() && i == 2) {
            if (this.q) {
                a(2);
                this.p = true;
                return;
            }
            return;
        }
        if (k() && i == 0) {
            j();
            if (this.q) {
                if (this.m.c != 0) {
                    z = false;
                } else if (this.n != this.m.f1123a) {
                    b(this.m.f1123a);
                }
            } else if (this.m.f1123a != -1) {
                a(this.m.f1123a, 0.0f, 0);
            }
            if (z) {
                a(0);
                i();
            }
        }
        if (this.k == 2 && i == 0 && this.r) {
            j();
            if (this.m.c == 0) {
                if (this.o != this.m.f1123a) {
                    b(this.m.f1123a == -1 ? 0 : this.m.f1123a);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(@ah RecyclerView recyclerView, int i, int i2) {
        boolean z;
        this.q = true;
        j();
        if (this.p) {
            this.p = false;
            if (i2 > 0) {
                z = true;
            } else {
                if (i2 == 0) {
                    if ((i < 0) == this.h.b()) {
                        z = true;
                    }
                }
                z = false;
            }
            this.o = (!z || this.m.c == 0) ? this.m.f1123a : this.m.f1123a + 1;
            if (this.n != this.o) {
                b(this.o);
            }
        } else if (this.k == 0) {
            int i3 = this.m.f1123a;
            if (i3 == -1) {
                i3 = 0;
            }
            b(i3);
        }
        a(this.m.f1123a == -1 ? 0 : this.m.f1123a, this.m.b, this.m.c);
        if ((this.m.f1123a == this.o || this.o == -1) && this.m.c == 0 && this.l != 1) {
            a(0);
            i();
        }
    }

    void a(h.f fVar) {
        this.g = fVar;
    }

    void b() {
        this.k = 4;
        a(true);
    }

    void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            if (this.m.c != 0) {
                a(2);
                return;
            }
            if (this.m.f1123a != this.n) {
                b(this.m.f1123a);
            }
            a(0);
            i();
        }
    }

    int d() {
        return this.l;
    }

    boolean e() {
        return this.l == 0;
    }

    boolean f() {
        return this.l == 1;
    }

    boolean g() {
        return this.s;
    }

    double h() {
        j();
        return ((double) this.m.f1123a) + ((double) this.m.b);
    }
}
