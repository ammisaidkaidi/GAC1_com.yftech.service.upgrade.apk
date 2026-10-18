package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class q extends androidx.l.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f782a = 0;
    public static final int b = 1;
    private static final String e = "FragmentStatePagerAdapt";
    private static final boolean f = false;
    private final j g;
    private final int h;
    private s i;
    private ArrayList<d.C0058d> j;
    private ArrayList<d> k;
    private d l;

    @Deprecated
    public q(@ah j jVar) {
        this(jVar, 0);
    }

    public q(@ah j jVar, int i) {
        this.i = null;
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = null;
        this.g = jVar;
        this.h = i;
    }

    @Override // androidx.l.a.a
    @ai
    public Parcelable a() {
        Bundle bundle;
        if (this.j.size() > 0) {
            bundle = new Bundle();
            d.C0058d[] c0058dArr = new d.C0058d[this.j.size()];
            this.j.toArray(c0058dArr);
            bundle.putParcelableArray("states", c0058dArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.k.size(); i++) {
            d dVar = this.k.get(i);
            if (dVar != null && dVar.K()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.g.a(bundle, "f" + i, dVar);
            }
        }
        return bundle;
    }

    @ah
    public abstract d a(int i);

    @Override // androidx.l.a.a
    @ah
    public Object a(@ah ViewGroup viewGroup, int i) {
        d.C0058d c0058d;
        d dVar;
        if (this.k.size() > i && (dVar = this.k.get(i)) != null) {
            return dVar;
        }
        if (this.i == null) {
            this.i = this.g.a();
        }
        d dVarA = a(i);
        if (this.j.size() > i && (c0058d = this.j.get(i)) != null) {
            dVarA.a(c0058d);
        }
        while (this.k.size() <= i) {
            this.k.add(null);
        }
        dVarA.f(false);
        if (this.h == 0) {
            dVarA.g(false);
        }
        this.k.set(i, dVarA);
        this.i.a(viewGroup.getId(), dVarA);
        if (this.h == 1) {
            this.i.a(dVarA, androidx.lifecycle.g.b.STARTED);
        }
        return dVarA;
    }

    @Override // androidx.l.a.a
    public void a(@ai Parcelable parcelable, @ai ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.j.clear();
            this.k.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.j.add((d.C0058d) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    d dVarA = this.g.a(bundle, str);
                    if (dVarA != null) {
                        while (this.k.size() <= i) {
                            this.k.add(null);
                        }
                        dVarA.f(false);
                        this.k.set(i, dVarA);
                    } else {
                        Log.w(e, "Bad fragment at key " + str);
                    }
                }
            }
        }
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
        while (this.j.size() <= i) {
            this.j.add(null);
        }
        this.j.set(i, dVar.K() ? this.g.a(dVar) : null);
        this.k.set(i, null);
        this.i.a(dVar);
        if (dVar == this.l) {
            this.l = null;
        }
    }

    @Override // androidx.l.a.a
    public boolean a(@ah View view, @ah Object obj) {
        return ((d) obj).X() == view;
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
        if (dVar != this.l) {
            if (this.l != null) {
                this.l.f(false);
                if (this.h == 1) {
                    if (this.i == null) {
                        this.i = this.g.a();
                    }
                    this.i.a(this.l, androidx.lifecycle.g.b.STARTED);
                } else {
                    this.l.g(false);
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
            this.l = dVar;
        }
    }
}
