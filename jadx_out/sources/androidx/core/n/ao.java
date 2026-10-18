package androidx.core.n;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.ap;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static final ao f540a = new a().a().q().o().i();
    private static final String b = "WindowInsetsCompat";
    private final e c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f541a;

        public a() {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f541a = new d();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f541a = new c();
            } else {
                this.f541a = new b();
            }
        }

        public a(@androidx.annotation.ah ao aoVar) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f541a = new d(aoVar);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.f541a = new c(aoVar);
            } else {
                this.f541a = new b(aoVar);
            }
        }

        @androidx.annotation.ah
        public a a(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f541a.a(fVar);
            return this;
        }

        @androidx.annotation.ah
        public a a(@androidx.annotation.ai androidx.core.n.d dVar) {
            this.f541a.a(dVar);
            return this;
        }

        @androidx.annotation.ah
        public ao a() {
            return this.f541a.a();
        }

        @androidx.annotation.ah
        public a b(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f541a.b(fVar);
            return this;
        }

        @androidx.annotation.ah
        public a c(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f541a.c(fVar);
            return this;
        }

        @androidx.annotation.ah
        public a d(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f541a.d(fVar);
            return this;
        }

        @androidx.annotation.ah
        public a e(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f541a.e(fVar);
            return this;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ao f542a;

        b() {
            this(new ao((ao) null));
        }

        b(@androidx.annotation.ah ao aoVar) {
            this.f542a = aoVar;
        }

        @androidx.annotation.ah
        ao a() {
            return this.f542a;
        }

        void a(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        }

        void a(@androidx.annotation.ai androidx.core.n.d dVar) {
        }

        void b(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        }

        void c(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        }

        void d(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        }

        void e(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        }
    }

    @androidx.annotation.am(b = 20)
    private static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f543a = null;
        private static boolean b = false;
        private static Constructor<WindowInsets> c = null;
        private static boolean d = false;
        private WindowInsets e;

        c() {
            this.e = b();
        }

        c(@androidx.annotation.ah ao aoVar) {
            this.e = aoVar.w();
        }

        @androidx.annotation.ai
        private static WindowInsets b() {
            if (!b) {
                try {
                    f543a = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i(ao.b, "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                b = true;
            }
            if (f543a != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) f543a.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i(ao.b, "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!d) {
                try {
                    c = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e3) {
                    Log.i(ao.b, "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                d = true;
            }
            if (c != null) {
                try {
                    return c.newInstance(new Rect());
                } catch (ReflectiveOperationException e4) {
                    Log.i(ao.b, "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }

        @Override // androidx.core.n.ao.b
        @androidx.annotation.ah
        ao a() {
            return ao.a(this.e);
        }

        @Override // androidx.core.n.ao.b
        void a(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            if (this.e != null) {
                this.e = this.e.replaceSystemWindowInsets(fVar.b, fVar.c, fVar.d, fVar.e);
            }
        }
    }

    @androidx.annotation.am(b = 29)
    private static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowInsets.Builder f544a;

        d() {
            this.f544a = new WindowInsets.Builder();
        }

        d(@androidx.annotation.ah ao aoVar) {
            WindowInsets windowInsetsW = aoVar.w();
            this.f544a = windowInsetsW != null ? new WindowInsets.Builder(windowInsetsW) : new WindowInsets.Builder();
        }

        @Override // androidx.core.n.ao.b
        @androidx.annotation.ah
        ao a() {
            return ao.a(this.f544a.build());
        }

        @Override // androidx.core.n.ao.b
        void a(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f544a.setSystemWindowInsets(fVar.a());
        }

        @Override // androidx.core.n.ao.b
        void a(@androidx.annotation.ai androidx.core.n.d dVar) {
            this.f544a.setDisplayCutout(dVar != null ? dVar.f() : null);
        }

        @Override // androidx.core.n.ao.b
        void b(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f544a.setSystemGestureInsets(fVar.a());
        }

        @Override // androidx.core.n.ao.b
        void c(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f544a.setMandatorySystemGestureInsets(fVar.a());
        }

        @Override // androidx.core.n.ao.b
        void d(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f544a.setTappableElementInsets(fVar.a());
        }

        @Override // androidx.core.n.ao.b
        void e(@androidx.annotation.ah androidx.core.graphics.f fVar) {
            this.f544a.setStableInsets(fVar.a());
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ao f545a;

        e(@androidx.annotation.ah ao aoVar) {
            this.f545a = aoVar;
        }

        @androidx.annotation.ah
        ao a(int i, int i2, int i3, int i4) {
            return ao.f540a;
        }

        boolean a() {
            return false;
        }

        boolean b() {
            return false;
        }

        @androidx.annotation.ah
        ao c() {
            return this.f545a;
        }

        @androidx.annotation.ah
        ao d() {
            return this.f545a;
        }

        @androidx.annotation.ai
        androidx.core.n.d e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return a() == eVar.a() && b() == eVar.b() && androidx.core.m.e.a(g(), eVar.g()) && androidx.core.m.e.a(h(), eVar.h()) && androidx.core.m.e.a(e(), eVar.e());
        }

        @androidx.annotation.ah
        ao f() {
            return this.f545a;
        }

        @androidx.annotation.ah
        androidx.core.graphics.f g() {
            return androidx.core.graphics.f.f432a;
        }

        @androidx.annotation.ah
        androidx.core.graphics.f h() {
            return androidx.core.graphics.f.f432a;
        }

        public int hashCode() {
            return androidx.core.m.e.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }

        @androidx.annotation.ah
        androidx.core.graphics.f i() {
            return g();
        }

        @androidx.annotation.ah
        androidx.core.graphics.f j() {
            return g();
        }

        @androidx.annotation.ah
        androidx.core.graphics.f k() {
            return g();
        }
    }

    @androidx.annotation.am(a = 20)
    private static class f extends e {

        @androidx.annotation.ah
        final WindowInsets b;
        private androidx.core.graphics.f c;

        f(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah WindowInsets windowInsets) {
            super(aoVar);
            this.c = null;
            this.b = windowInsets;
        }

        f(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah f fVar) {
            this(aoVar, new WindowInsets(fVar.b));
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        ao a(int i, int i2, int i3, int i4) {
            a aVar = new a(ao.a(this.b));
            aVar.a(ao.a(g(), i, i2, i3, i4));
            aVar.e(ao.a(h(), i, i2, i3, i4));
            return aVar.a();
        }

        @Override // androidx.core.n.ao.e
        boolean a() {
            return this.b.isRound();
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        final androidx.core.graphics.f g() {
            if (this.c == null) {
                this.c = androidx.core.graphics.f.a(this.b.getSystemWindowInsetLeft(), this.b.getSystemWindowInsetTop(), this.b.getSystemWindowInsetRight(), this.b.getSystemWindowInsetBottom());
            }
            return this.c;
        }
    }

    @androidx.annotation.am(a = 21)
    private static class g extends f {
        private androidx.core.graphics.f c;

        g(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah WindowInsets windowInsets) {
            super(aoVar, windowInsets);
            this.c = null;
        }

        g(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah g gVar) {
            super(aoVar, gVar);
            this.c = null;
        }

        @Override // androidx.core.n.ao.e
        boolean b() {
            return this.b.isConsumed();
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        ao c() {
            return ao.a(this.b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        ao d() {
            return ao.a(this.b.consumeStableInsets());
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        final androidx.core.graphics.f h() {
            if (this.c == null) {
                this.c = androidx.core.graphics.f.a(this.b.getStableInsetLeft(), this.b.getStableInsetTop(), this.b.getStableInsetRight(), this.b.getStableInsetBottom());
            }
            return this.c;
        }
    }

    @androidx.annotation.am(a = 28)
    private static class h extends g {
        h(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah WindowInsets windowInsets) {
            super(aoVar, windowInsets);
        }

        h(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah h hVar) {
            super(aoVar, hVar);
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ai
        androidx.core.n.d e() {
            return androidx.core.n.d.a(this.b.getDisplayCutout());
        }

        @Override // androidx.core.n.ao.e
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                return Objects.equals(this.b, ((h) obj).b);
            }
            return false;
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        ao f() {
            return ao.a(this.b.consumeDisplayCutout());
        }

        @Override // androidx.core.n.ao.e
        public int hashCode() {
            return this.b.hashCode();
        }
    }

    @androidx.annotation.am(a = 29)
    private static class i extends h {
        private androidx.core.graphics.f c;
        private androidx.core.graphics.f d;
        private androidx.core.graphics.f e;

        i(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah WindowInsets windowInsets) {
            super(aoVar, windowInsets);
            this.c = null;
            this.d = null;
            this.e = null;
        }

        i(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah i iVar) {
            super(aoVar, iVar);
            this.c = null;
            this.d = null;
            this.e = null;
        }

        @Override // androidx.core.n.ao.f, androidx.core.n.ao.e
        @androidx.annotation.ah
        ao a(int i, int i2, int i3, int i4) {
            return ao.a(this.b.inset(i, i2, i3, i4));
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        androidx.core.graphics.f i() {
            if (this.c == null) {
                this.c = androidx.core.graphics.f.b(this.b.getSystemGestureInsets());
            }
            return this.c;
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        androidx.core.graphics.f j() {
            if (this.d == null) {
                this.d = androidx.core.graphics.f.b(this.b.getMandatorySystemGestureInsets());
            }
            return this.d;
        }

        @Override // androidx.core.n.ao.e
        @androidx.annotation.ah
        androidx.core.graphics.f k() {
            if (this.e == null) {
                this.e = androidx.core.graphics.f.b(this.b.getTappableElementInsets());
            }
            return this.e;
        }
    }

    @androidx.annotation.am(a = 20)
    private ao(@androidx.annotation.ah WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.c = new i(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.c = new h(this, windowInsets);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = new g(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.c = new f(this, windowInsets);
        } else {
            this.c = new e(this);
        }
    }

    public ao(@androidx.annotation.ai ao aoVar) {
        if (aoVar == null) {
            this.c = new e(this);
            return;
        }
        e eVar = aoVar.c;
        if (Build.VERSION.SDK_INT >= 29 && (eVar instanceof i)) {
            this.c = new i(this, (i) eVar);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && (eVar instanceof h)) {
            this.c = new h(this, (h) eVar);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21 && (eVar instanceof g)) {
            this.c = new g(this, (g) eVar);
        } else if (Build.VERSION.SDK_INT < 20 || !(eVar instanceof f)) {
            this.c = new e(this);
        } else {
            this.c = new f(this, (f) eVar);
        }
    }

    static androidx.core.graphics.f a(androidx.core.graphics.f fVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, fVar.b - i2);
        int iMax2 = Math.max(0, fVar.c - i3);
        int iMax3 = Math.max(0, fVar.d - i4);
        int iMax4 = Math.max(0, fVar.e - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? fVar : androidx.core.graphics.f.a(iMax, iMax2, iMax3, iMax4);
    }

    @androidx.annotation.am(a = 20)
    @androidx.annotation.ah
    public static ao a(@androidx.annotation.ah WindowInsets windowInsets) {
        return new ao((WindowInsets) androidx.core.m.i.a(windowInsets));
    }

    public int a() {
        return r().b;
    }

    @androidx.annotation.ah
    @Deprecated
    public ao a(int i2, int i3, int i4, int i5) {
        return new a(this).a(androidx.core.graphics.f.a(i2, i3, i4, i5)).a();
    }

    @androidx.annotation.ah
    @Deprecated
    public ao a(@androidx.annotation.ah Rect rect) {
        return new a(this).a(androidx.core.graphics.f.a(rect)).a();
    }

    @androidx.annotation.ah
    public ao a(@androidx.annotation.ah androidx.core.graphics.f fVar) {
        return b(fVar.b, fVar.c, fVar.d, fVar.e);
    }

    public int b() {
        return r().c;
    }

    @androidx.annotation.ah
    public ao b(@androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i2, @androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i3, @androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i4, @androidx.annotation.z(a = FabTransformationScrimBehavior.c) int i5) {
        return this.c.a(i2, i3, i4, i5);
    }

    public int c() {
        return r().d;
    }

    public int d() {
        return r().e;
    }

    public boolean e() {
        return !r().equals(androidx.core.graphics.f.f432a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ao) {
            return androidx.core.m.e.a(this.c, ((ao) obj).c);
        }
        return false;
    }

    public boolean f() {
        return (!e() && !n() && p() == null && v().equals(androidx.core.graphics.f.f432a) && t().equals(androidx.core.graphics.f.f432a) && u().equals(androidx.core.graphics.f.f432a)) ? false : true;
    }

    public boolean g() {
        return this.c.b();
    }

    public boolean h() {
        return this.c.a();
    }

    public int hashCode() {
        if (this.c == null) {
            return 0;
        }
        return this.c.hashCode();
    }

    @androidx.annotation.ah
    public ao i() {
        return this.c.c();
    }

    public int j() {
        return s().c;
    }

    public int k() {
        return s().b;
    }

    public int l() {
        return s().d;
    }

    public int m() {
        return s().e;
    }

    public boolean n() {
        return !s().equals(androidx.core.graphics.f.f432a);
    }

    @androidx.annotation.ah
    public ao o() {
        return this.c.d();
    }

    @androidx.annotation.ai
    public androidx.core.n.d p() {
        return this.c.e();
    }

    @androidx.annotation.ah
    public ao q() {
        return this.c.f();
    }

    @androidx.annotation.ah
    public androidx.core.graphics.f r() {
        return this.c.g();
    }

    @androidx.annotation.ah
    public androidx.core.graphics.f s() {
        return this.c.h();
    }

    @androidx.annotation.ah
    public androidx.core.graphics.f t() {
        return this.c.j();
    }

    @androidx.annotation.ah
    public androidx.core.graphics.f u() {
        return this.c.k();
    }

    @androidx.annotation.ah
    public androidx.core.graphics.f v() {
        return this.c.i();
    }

    @androidx.annotation.ai
    @androidx.annotation.am(a = 20)
    public WindowInsets w() {
        if (this.c instanceof f) {
            return ((f) this.c).b;
        }
        return null;
    }
}
