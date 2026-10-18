package androidx.fragment.app;

import androidx.annotation.ai;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ai
    private final Collection<d> f777a;

    @ai
    private final Map<String, l> b;

    @ai
    private final Map<String, androidx.lifecycle.x> c;

    l(@ai Collection<d> collection, @ai Map<String, l> map, @ai Map<String, androidx.lifecycle.x> map2) {
        this.f777a = collection;
        this.b = map;
        this.c = map2;
    }

    @ai
    Collection<d> a() {
        return this.f777a;
    }

    boolean a(d dVar) {
        if (this.f777a == null) {
            return false;
        }
        return this.f777a.contains(dVar);
    }

    @ai
    Map<String, l> b() {
        return this.b;
    }

    @ai
    Map<String, androidx.lifecycle.x> c() {
        return this.c;
    }
}
