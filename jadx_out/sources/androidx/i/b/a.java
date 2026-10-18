package androidx.i.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.core.i.k;
import androidx.core.m.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends c<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f820a = "AsyncTaskLoader";
    static final boolean b = false;
    volatile a<D>.RunnableC0064a c;
    volatile a<D>.RunnableC0064a d;
    long e;
    long f;
    Handler g;
    private final Executor h;

    /* JADX INFO: renamed from: androidx.i.b.a$a, reason: collision with other inner class name */
    final class RunnableC0064a extends d<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f821a;
        private final CountDownLatch f = new CountDownLatch(1);

        RunnableC0064a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.i.b.d
        public D a(Void... voidArr) {
            try {
                return (D) a.this.e();
            } catch (k e) {
                if (e()) {
                    return null;
                }
                throw e;
            }
        }

        public void a() {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // androidx.i.b.d
        protected void a(D d) {
            try {
                a.this.b(this, d);
            } finally {
                this.f.countDown();
            }
        }

        @Override // androidx.i.b.d
        protected void b(D d) {
            try {
                a.this.a(this, d);
            } finally {
                this.f.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f821a = false;
            a.this.c();
        }
    }

    public a(@ah Context context) {
        this(context, d.c);
    }

    private a(@ah Context context, @ah Executor executor) {
        super(context);
        this.f = -10000L;
        this.h = executor;
    }

    @Override // androidx.i.b.c
    protected void a() {
        super.a();
        y();
        this.c = new RunnableC0064a();
        c();
    }

    public void a(long j) {
        this.e = j;
        if (j != 0) {
            this.g = new Handler();
        }
    }

    void a(a<D>.RunnableC0064a runnableC0064a, D d) {
        a(d);
        if (this.d == runnableC0064a) {
            G();
            this.f = SystemClock.uptimeMillis();
            this.d = null;
            r();
            c();
        }
    }

    public void a(@ai D d) {
    }

    @Override // androidx.i.b.c
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.c);
            printWriter.print(" waiting=");
            printWriter.println(this.c.f821a);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.d);
            printWriter.print(" waiting=");
            printWriter.println(this.d.f821a);
        }
        if (this.e != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            l.a(this.e, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            l.a(this.f, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void b(a<D>.RunnableC0064a runnableC0064a, D d) {
        if (this.c != runnableC0064a) {
            a(runnableC0064a, d);
            return;
        }
        if (v()) {
            a(d);
            return;
        }
        F();
        this.f = SystemClock.uptimeMillis();
        this.c = null;
        b(d);
    }

    @Override // androidx.i.b.c
    protected boolean b() {
        if (this.c == null) {
            return false;
        }
        if (!this.t) {
            this.w = true;
        }
        if (this.d != null) {
            if (this.c.f821a) {
                this.c.f821a = false;
                this.g.removeCallbacks(this.c);
            }
            this.c = null;
            return false;
        }
        if (this.c.f821a) {
            this.c.f821a = false;
            this.g.removeCallbacks(this.c);
            this.c = null;
            return false;
        }
        boolean zA = this.c.a(false);
        if (zA) {
            this.d = this.c;
            f();
        }
        this.c = null;
        return zA;
    }

    void c() {
        if (this.d != null || this.c == null) {
            return;
        }
        if (this.c.f821a) {
            this.c.f821a = false;
            this.g.removeCallbacks(this.c);
        }
        if (this.e <= 0 || SystemClock.uptimeMillis() >= this.f + this.e) {
            this.c.a(this.h, (Void[]) null);
        } else {
            this.c.f821a = true;
            this.g.postAtTime(this.c, this.f + this.e);
        }
    }

    @ai
    public abstract D d();

    @ai
    protected D e() {
        return d();
    }

    public void f() {
    }

    public boolean g() {
        return this.d != null;
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public void h() {
        a<D>.RunnableC0064a runnableC0064a = this.c;
        if (runnableC0064a != null) {
            runnableC0064a.a();
        }
    }
}
