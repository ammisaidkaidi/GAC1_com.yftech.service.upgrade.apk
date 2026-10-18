package androidx.a.a.b;

import androidx.annotation.ah;
import androidx.annotation.ap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> b = new HashMap<>();

    @Override // androidx.a.a.b.b
    protected b.c<K, V> a(K k) {
        return this.b.get(k);
    }

    @Override // androidx.a.a.b.b
    public V a(@ah K k, @ah V v) {
        b.c<K, V> cVarA = a(k);
        if (cVarA != null) {
            return cVarA.b;
        }
        this.b.put(k, b(k, v));
        return null;
    }

    @Override // androidx.a.a.b.b
    public V b(@ah K k) {
        V v = (V) super.b(k);
        this.b.remove(k);
        return v;
    }

    public boolean c(K k) {
        return this.b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.b.get(k).d;
        }
        return null;
    }
}
