package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends androidx.l.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f780a = 0;
    public static final int b = 1;
    private static final String e = "FragmentPagerAdapter";
    private static final boolean f = false;
    private final j g;
    private final int h;
    private s i;
    private d j;

    @Deprecated
    public o(@ah j jVar) {
        this(jVar, 0);
    }

    public o(@ah j jVar, int i) {
        this.i = null;
        this.j = null;
        this.g = jVar;
        this.h = i;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // androidx.l.a.a
    @ai
    public Parcelable a() {
        return null;
    }

    @ah
    public abstract d a(int i);

    @Override // androidx.l.a.a
    @ah
    public Object a(@ah ViewGroup viewGroup, int i) {
        if (this.i == null) {
            this.i = this.g.a();
        }
        long jB = b(i);
        d dVarA = this.g.a(a(viewGroup.getId(), jB));
        if (dVarA != null) {
            this.i.f(dVarA);
        } else {
            dVarA = a(i);
            this.i.a(viewGroup.getId(), dVarA, a(viewGroup.getId(), jB));
        }
        if (dVarA != this.j) {
            dVarA.f(false);
            if (this.h == 1) {
                this.i.a(dVarA, androidx.lifecycle.g.b.STARTED);
            } else {
                dVarA.g(false);
            }
        }
        return dVarA;
    }

    @Override // androidx.l.a.a
    public void a(@ai Parcelable parcelable, @ai ClassLoader classLoader) {
    }

    @Override // androidx.l.a.a
    public void a(@ah ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.l.a.a
    public void a(@ah ViewGroup viewGroup, int i, @ah Object obj) {
        d dVar = (d) obj;
        if (this.i == null) {
            this.i = this.g.a();
        }
        this.i.d(dVar);
        if (dVar == this.j) {
            this.j = null;
        }
    }

    @Override // androidx.l.a.a
    public boolean a(@ah View view, @ah Object obj) {
        return ((d) obj).X() == view;
    }

    public long b(int i) {
        return i;
    }

    @Override // androidx.l.a.a
    public void b(@ah ViewGroup viewGroup) {
        if (this.i != null) {
            this.i.j();
            this.i = null;
        }
    }

    @Override // androidx.l.a.a
    public void b(@ah ViewGroup viewGroup, int i, @ah Object obj) {
        d dVar = (d) obj;
        if (dVar != this.j) {
            if (this.j != null) {
                this.j.f(false);
                if (this.h == 1) {
                    if (this.i == null) {
                        this.i = this.g.a();
                    }
                    this.i.a(this.j, androidx.lifecycle.g.b.STARTED);
                } else {
                    this.j.g(false);
                }
            }
            dVar.f(true);
            if (this.h == 1) {
                if (this.i == null) {
                    this.i = this.g.a();
                }
                this.i.a(dVar, androidx.lifecycle.g.b.RESUMED);
            } else {
                dVar.g(true);
            }
            this.j = dVar;
        }
    }
}
