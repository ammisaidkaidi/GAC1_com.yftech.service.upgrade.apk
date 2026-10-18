package androidx.c;

import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f314a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.f314a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int c(K k, V v) {
        int iB = b(k, v);
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    @ai
    public final V a(@ah K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f314a.get(k);
            if (v != null) {
                this.g++;
                return v;
            }
            this.h++;
            V vC = c(k);
            if (vC == null) {
                return null;
            }
            synchronized (this) {
                this.e++;
                vPut = this.f314a.put(k, vC);
                if (vPut != null) {
                    this.f314a.put(k, vPut);
                } else {
                    this.b += c(k, vC);
                }
            }
            if (vPut != null) {
                a(false, k, vC, vPut);
                return vPut;
            }
            b(this.c);
            return vC;
        }
    }

    @ai
    public final V a(@ah K k, @ah V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.b += c(k, v);
            vPut = this.f314a.put(k, v);
            if (vPut != null) {
                this.b -= c(k, vPut);
            }
        }
        if (vPut != null) {
            a(false, k, vPut, v);
        }
        b(this.c);
        return vPut;
    }

    public final void a() {
        b(-1);
    }

    public void a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.c = i;
        }
        b(i);
    }

    protected void a(boolean z, @ah K k, @ah V v, @ai V v2) {
    }

    public final synchronized int b() {
        return this.b;
    }

    protected int b(@ah K k, @ah V v) {
        return 1;
    }

    @ai
    public final V b(@ah K k) {
        V vRemove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.f314a.remove(k);
            if (vRemove != null) {
                this.b -= c(k, vRemove);
            }
        }
        if (vRemove != null) {
            a(false, k, vRemove, null);
        }
        return vRemove;
    }

    public void b(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.b < 0 || (this.f314a.isEmpty() && this.b != 0)) {
                    break;
                }
                if (this.b > i && !this.f314a.isEmpty()) {
                    Map.Entry<K, V> next = this.f314a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f314a.remove(key);
                    this.b -= c(key, value);
                    this.f++;
                }
                return;
            }
            a(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized int c() {
        return this.c;
    }

    @ai
    protected V c(@ah K k) {
        return null;
    }

    public final synchronized int d() {
        return this.g;
    }

    public final synchronized int e() {
        return this.h;
    }

    public final synchronized int f() {
        return this.e;
    }

    public final synchronized int g() {
        return this.d;
    }

    public final synchronized int h() {
        return this.f;
    }

    public final synchronized Map<K, V> i() {
        return new LinkedHashMap(this.f314a);
    }

    public final synchronized String toString() {
        int i;
        i = this.g + this.h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
    }
}
