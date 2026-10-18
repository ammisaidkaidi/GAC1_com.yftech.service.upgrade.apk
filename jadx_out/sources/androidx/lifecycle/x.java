package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, v> f983a = new HashMap<>();

    final v a(String str) {
        return this.f983a.get(str);
    }

    Set<String> a() {
        return new HashSet(this.f983a.keySet());
    }

    final void a(String str, v vVar) {
        v vVarPut = this.f983a.put(str, vVar);
        if (vVarPut != null) {
            vVarPut.a();
        }
    }

    public final void b() {
        Iterator<v> it = this.f983a.values().iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        this.f983a.clear();
    }
}
