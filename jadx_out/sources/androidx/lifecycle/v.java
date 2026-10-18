package androidx.lifecycle;

import androidx.annotation.ae;
import androidx.annotation.ai;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ai
    private final Map<String, Object> f980a = new HashMap();
    private volatile boolean b = false;

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    <T> T a(String str) {
        T t;
        synchronized (this.f980a) {
            t = (T) this.f980a.get(str);
        }
        return t;
    }

    <T> T a(String str, T t) {
        Object obj;
        synchronized (this.f980a) {
            obj = this.f980a.get(str);
            if (obj == null) {
                this.f980a.put(str, t);
            }
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (this.b) {
            a(t);
        }
        return t;
    }

    protected void a() {
    }

    @ae
    final void e() {
        this.b = true;
        if (this.f980a != null) {
            synchronized (this.f980a) {
                Iterator<Object> it = this.f980a.values().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
        a();
    }
}
