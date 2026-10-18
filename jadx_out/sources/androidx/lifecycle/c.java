package androidx.lifecycle;

import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ap;
import androidx.annotation.ax;
import androidx.annotation.ay;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f964a;
    final LiveData<T> b;
    final AtomicBoolean c;
    final AtomicBoolean d;

    @ax
    final Runnable e;

    @ax
    final Runnable f;

    public c() {
        this(androidx.a.a.a.a.c());
    }

    public c(@ah Executor executor) {
        this.c = new AtomicBoolean(true);
        this.d = new AtomicBoolean(false);
        this.e = new Runnable() { // from class: androidx.lifecycle.c.2
            @Override // java.lang.Runnable
            @ay
            public void run() {
                boolean z;
                do {
                    if (c.this.d.compareAndSet(false, true)) {
                        Object objC = null;
                        z = false;
                        while (c.this.c.compareAndSet(true, false)) {
                            try {
                                objC = c.this.c();
                                z = true;
                            } catch (Throwable th) {
                                c.this.d.set(false);
                                throw th;
                            }
                        }
                        if (z) {
                            c.this.b.a((T) objC);
                        }
                        c.this.d.set(false);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                } while (c.this.c.get());
            }
        };
        this.f = new Runnable() { // from class: androidx.lifecycle.c.3
            @Override // java.lang.Runnable
            @ae
            public void run() {
                boolean zF = c.this.b.f();
                if (c.this.c.compareAndSet(false, true) && zF) {
                    c.this.f964a.execute(c.this.e);
                }
            }
        };
        this.f964a = executor;
        this.b = new LiveData<T>() { // from class: androidx.lifecycle.c.1
            @Override // androidx.lifecycle.LiveData
            protected void a() {
                c.this.f964a.execute(c.this.e);
            }
        };
    }

    @ah
    public LiveData<T> a() {
        return this.b;
    }

    public void b() {
        androidx.a.a.a.a.a().c(this.f);
    }

    @ay
    protected abstract T c();
}
