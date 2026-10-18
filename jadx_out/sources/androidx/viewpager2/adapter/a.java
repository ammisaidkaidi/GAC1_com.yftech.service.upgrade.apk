package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.i;
import androidx.c.f;
import androidx.core.n.af;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.j;
import androidx.fragment.app.s;
import androidx.lifecycle.g;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.a.h;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends RecyclerView.a<androidx.viewpager2.adapter.b> implements c {
    private static final String e = "f#";
    private static final String f = "s#";
    private static final long g = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f1139a;
    final j b;
    final f<d> c;
    boolean d;
    private final f<d.C0058d> h;
    private final f<Integer> i;
    private b j;
    private boolean k;

    /* JADX INFO: renamed from: androidx.viewpager2.adapter.a$a, reason: collision with other inner class name */
    private static abstract class AbstractC0080a extends RecyclerView.c {
        private AbstractC0080a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2, @ai Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void c(int i, int i2) {
            a();
        }
    }

    class b {
        private h.f b;
        private RecyclerView.c c;
        private androidx.lifecycle.h d;
        private h e;
        private long f = -1;

        b() {
        }

        @ah
        private h c(@ah RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof h) {
                return (h) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void a(@ah RecyclerView recyclerView) {
            this.e = c(recyclerView);
            this.b = new h.f() { // from class: androidx.viewpager2.adapter.a.b.1
                @Override // androidx.viewpager2.a.h.f
                public void a(int i) {
                    b.this.a(false);
                }

                @Override // androidx.viewpager2.a.h.f
                public void b(int i) {
                    b.this.a(false);
                }
            };
            this.e.a(this.b);
            this.c = new AbstractC0080a() { // from class: androidx.viewpager2.adapter.a.b.2
                @Override // androidx.viewpager2.adapter.a.AbstractC0080a, androidx.recyclerview.widget.RecyclerView.c
                public void a() {
                    b.this.a(true);
                }
            };
            a.this.a(this.c);
            this.d = new androidx.lifecycle.h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3
                @Override // androidx.lifecycle.h
                public void a(@ah androidx.lifecycle.j jVar, @ah g.a aVar) {
                    this.f1138a.a(false);
                }
            };
            a.this.f1139a.a(this.d);
        }

        void a(boolean z) {
            int currentItem;
            d dVarA;
            if (a.this.f() || this.e.getScrollState() != 0 || a.this.c.c() || a.this.a() == 0 || (currentItem = this.e.getCurrentItem()) >= a.this.a()) {
                return;
            }
            long jC = a.this.c(currentItem);
            if ((jC != this.f || z) && (dVarA = a.this.c.a(jC)) != null && dVarA.K()) {
                this.f = jC;
                s sVarA = a.this.b.a();
                d dVar = null;
                for (int i = 0; i < a.this.c.b(); i++) {
                    long jB = a.this.c.b(i);
                    d dVarC = a.this.c.c(i);
                    if (dVarC.K()) {
                        if (jB != this.f) {
                            sVarA.a(dVarC, g.b.STARTED);
                        } else {
                            dVar = dVarC;
                        }
                        dVarC.f(jB == this.f);
                    }
                }
                if (dVar != null) {
                    sVarA.a(dVar, g.b.RESUMED);
                }
                if (sVarA.n()) {
                    return;
                }
                sVarA.i();
            }
        }

        void b(@ah RecyclerView recyclerView) {
            c(recyclerView).b(this.b);
            a.this.b(this.c);
            a.this.f1139a.b(this.d);
            this.e = null;
        }
    }

    public a(@ah d dVar) {
        this(dVar.H(), dVar.c());
    }

    public a(@ah e eVar) {
        this(eVar.q(), eVar.c());
    }

    public a(@ah j jVar, @ah g gVar) {
        this.c = new f<>();
        this.h = new f<>();
        this.i = new f<>();
        this.d = false;
        this.k = false;
        this.b = jVar;
        this.f1139a = gVar;
        super.a(true);
    }

    @ah
    private static String a(@ah String str, long j) {
        return str + j;
    }

    private void a(final d dVar, @ah final FrameLayout frameLayout) {
        this.b.a(new j.b() { // from class: androidx.viewpager2.adapter.a.2
            @Override // androidx.fragment.app.j.b
            public void a(@ah j jVar, @ah d dVar2, @ah View view, @ai Bundle bundle) {
                if (dVar2 == dVar) {
                    jVar.a(this);
                    a.this.a(view, frameLayout);
                }
            }
        }, false);
    }

    private static boolean a(@ah String str, @ah String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private static long b(@ah String str, @ah String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private boolean b(long j) {
        View viewX;
        if (this.i.e(j)) {
            return true;
        }
        d dVarA = this.c.a(j);
        return (dVarA == null || (viewX = dVarA.X()) == null || viewX.getParent() == null) ? false : true;
    }

    private void c(long j) {
        ViewParent parent;
        d dVarA = this.c.a(j);
        if (dVarA == null) {
            return;
        }
        if (dVarA.X() != null && (parent = dVarA.X().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!a(j)) {
            this.h.c(j);
        }
        if (!dVarA.K()) {
            this.c.c(j);
            return;
        }
        if (f()) {
            this.k = true;
            return;
        }
        if (dVarA.K() && a(j)) {
            this.h.d(j, this.b.a(dVarA));
        }
        this.b.a().a(dVarA).i();
        this.c.c(j);
    }

    private Long g(int i) {
        Long lValueOf = null;
        for (int i2 = 0; i2 < this.i.b(); i2++) {
            if (this.i.c(i2).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.i.b(i2));
            }
        }
        return lValueOf;
    }

    private void h() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: androidx.viewpager2.adapter.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.d = false;
                a.this.b();
            }
        };
        this.f1139a.a(new androidx.lifecycle.h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$5
            @Override // androidx.lifecycle.h
            public void a(@ah androidx.lifecycle.j jVar, @ah g.a aVar) {
                if (aVar == g.a.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    jVar.c().b(this);
                }
            }
        });
        handler.postDelayed(runnable, g);
    }

    private void h(int i) {
        long jC = c(i);
        if (this.c.e(jC)) {
            return;
        }
        d dVarA = a(i);
        dVarA.a(this.h.a(jC));
        this.c.d(jC, dVarA);
    }

    @ah
    public abstract d a(int i);

    @Override // androidx.viewpager2.adapter.c
    public final void a(@ah Parcelable parcelable) {
        if (!this.h.c() || !this.c.c()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (a(str, e)) {
                this.c.d(b(str, e), this.b.a(bundle, str));
            } else {
                if (!a(str, f)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jB = b(str, f);
                d.C0058d c0058d = (d.C0058d) bundle.getParcelable(str);
                if (a(jB)) {
                    this.h.d(jB, c0058d);
                }
            }
        }
        if (this.c.c()) {
            return;
        }
        this.k = true;
        this.d = true;
        b();
        h();
    }

    void a(@ah View view, @ah FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    @i
    public void a(@ah RecyclerView recyclerView) {
        androidx.core.m.i.a(this.j == null);
        this.j = new b();
        this.j.a(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void c(@ah androidx.viewpager2.adapter.b bVar) {
        b(bVar);
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void a(@ah final androidx.viewpager2.adapter.b bVar, int i) {
        long jH = bVar.h();
        int id = bVar.D().getId();
        Long lG = g(id);
        if (lG != null && lG.longValue() != jH) {
            c(lG.longValue());
            this.i.c(lG.longValue());
        }
        this.i.d(jH, Integer.valueOf(id));
        h(i);
        final FrameLayout frameLayoutD = bVar.D();
        if (af.ak(frameLayoutD)) {
            if (frameLayoutD.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutD.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.a.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (frameLayoutD.getParent() != null) {
                        frameLayoutD.removeOnLayoutChangeListener(this);
                        a.this.b(bVar);
                    }
                }
            });
        }
        b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void a(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean a(long j) {
        return j >= 0 && j < ((long) a());
    }

    void b() {
        if (!this.k || f()) {
            return;
        }
        androidx.c.b bVar = new androidx.c.b();
        for (int i = 0; i < this.c.b(); i++) {
            long jB = this.c.b(i);
            if (!a(jB)) {
                bVar.add(Long.valueOf(jB));
                this.i.c(jB);
            }
        }
        if (!this.d) {
            this.k = false;
            for (int i2 = 0; i2 < this.c.b(); i2++) {
                long jB2 = this.c.b(i2);
                if (!b(jB2)) {
                    bVar.add(Long.valueOf(jB2));
                }
            }
        }
        Iterator<E> it = bVar.iterator();
        while (it.hasNext()) {
            c(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    @i
    public void b(@ah RecyclerView recyclerView) {
        this.j.b(recyclerView);
        this.j = null;
    }

    void b(@ah final androidx.viewpager2.adapter.b bVar) {
        d dVarA = this.c.a(bVar.h());
        if (dVarA == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutD = bVar.D();
        View viewX = dVarA.X();
        if (!dVarA.K() && viewX != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (dVarA.K() && viewX == null) {
            a(dVarA, frameLayoutD);
            return;
        }
        if (dVarA.K() && viewX.getParent() != null) {
            if (viewX.getParent() != frameLayoutD) {
                a(viewX, frameLayoutD);
                return;
            }
            return;
        }
        if (dVarA.K()) {
            a(viewX, frameLayoutD);
            return;
        }
        if (f()) {
            if (this.b.h()) {
                return;
            }
            this.f1139a.a(new androidx.lifecycle.h() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$2
                @Override // androidx.lifecycle.h
                public void a(@ah androidx.lifecycle.j jVar, @ah g.a aVar) {
                    if (this.b.f()) {
                        return;
                    }
                    jVar.c().b(this);
                    if (af.ak(bVar.D())) {
                        this.b.b(bVar);
                    }
                }
            });
            return;
        }
        a(dVarA, frameLayoutD);
        this.b.a().a(dVarA, "f" + bVar.h()).a(dVarA, g.b.STARTED).i();
        this.j.a(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long c(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    @ah
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.b a(@ah ViewGroup viewGroup, int i) {
        return androidx.viewpager2.adapter.b.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void a(@ah androidx.viewpager2.adapter.b bVar) {
        Long lG = g(bVar.D().getId());
        if (lG != null) {
            c(lG.longValue());
            this.i.c(lG.longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final boolean b(@ah androidx.viewpager2.adapter.b bVar) {
        return true;
    }

    boolean f() {
        return this.b.k();
    }

    @Override // androidx.viewpager2.adapter.c
    @ah
    public final Parcelable g() {
        Bundle bundle = new Bundle(this.c.b() + this.h.b());
        for (int i = 0; i < this.c.b(); i++) {
            long jB = this.c.b(i);
            d dVarA = this.c.a(jB);
            if (dVarA != null && dVarA.K()) {
                this.b.a(bundle, a(e, jB), dVarA);
            }
        }
        for (int i2 = 0; i2 < this.h.b(); i2++) {
            long jB2 = this.h.b(i2);
            if (a(jB2)) {
                bundle.putParcelable(a(f, jB2), this.h.a(jB2));
            }
        }
        return bundle;
    }
}
