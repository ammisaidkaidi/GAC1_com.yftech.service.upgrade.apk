package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class n extends androidx.lifecycle.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.lifecycle.w.b f779a = new androidx.lifecycle.w.b() { // from class: androidx.fragment.app.n.1
        @Override // androidx.lifecycle.w.b
        @ah
        public <T extends androidx.lifecycle.v> T a(@ah Class<T> cls) {
            return new n(true);
        }
    };
    private final boolean e;
    private final HashSet<d> b = new HashSet<>();
    private final HashMap<String, n> c = new HashMap<>();
    private final HashMap<String, androidx.lifecycle.x> d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    n(boolean z) {
        this.e = z;
    }

    @ah
    static n a(androidx.lifecycle.x xVar) {
        return (n) new androidx.lifecycle.w(xVar, f779a).a(n.class);
    }

    @Override // androidx.lifecycle.v
    protected void a() {
        if (k.c) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    @Deprecated
    void a(@ai l lVar) {
        this.b.clear();
        this.c.clear();
        this.d.clear();
        if (lVar != null) {
            Collection<d> collectionA = lVar.a();
            if (collectionA != null) {
                this.b.addAll(collectionA);
            }
            Map<String, l> mapB = lVar.b();
            if (mapB != null) {
                for (Map.Entry<String, l> entry : mapB.entrySet()) {
                    n nVar = new n(this.e);
                    nVar.a(entry.getValue());
                    this.c.put(entry.getKey(), nVar);
                }
            }
            Map<String, androidx.lifecycle.x> mapC = lVar.c();
            if (mapC != null) {
                this.d.putAll(mapC);
            }
        }
        this.g = false;
    }

    boolean a(@ah d dVar) {
        return this.b.add(dVar);
    }

    boolean b() {
        return this.f;
    }

    boolean b(@ah d dVar) {
        if (this.b.contains(dVar)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    @ah
    Collection<d> c() {
        return this.b;
    }

    boolean c(@ah d dVar) {
        return this.b.remove(dVar);
    }

    @ai
    @Deprecated
    l d() {
        if (this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, n> entry : this.c.entrySet()) {
            l lVarD = entry.getValue().d();
            if (lVarD != null) {
                map.put(entry.getKey(), lVarD);
            }
        }
        this.g = true;
        if (this.b.isEmpty() && map.isEmpty() && this.d.isEmpty()) {
            return null;
        }
        return new l(new ArrayList(this.b), map, new HashMap(this.d));
    }

    @ah
    n d(@ah d dVar) {
        n nVar = this.c.get(dVar.x);
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this.e);
        this.c.put(dVar.x, nVar2);
        return nVar2;
    }

    @ah
    androidx.lifecycle.x e(@ah d dVar) {
        androidx.lifecycle.x xVar = this.d.get(dVar.x);
        if (xVar != null) {
            return xVar;
        }
        androidx.lifecycle.x xVar2 = new androidx.lifecycle.x();
        this.d.put(dVar.x, xVar2);
        return xVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.b.equals(nVar.b) && this.c.equals(nVar.c) && this.d.equals(nVar.d);
    }

    void f(@ah d dVar) {
        if (k.c) {
            Log.d("FragmentManager", "Clearing non-config state for " + dVar);
        }
        n nVar = this.c.get(dVar.x);
        if (nVar != null) {
            nVar.a();
            this.c.remove(dVar.x);
        }
        androidx.lifecycle.x xVar = this.d.get(dVar.x);
        if (xVar != null) {
            xVar.b();
            this.d.remove(dVar.x);
        }
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @ah
    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<d> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
