package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.annotation.ac;
import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.i;
import androidx.annotation.n;
import androidx.core.app.j;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import androidx.lifecycle.x;
import androidx.lifecycle.y;

/* JADX INFO: loaded from: classes.dex */
public class b extends j implements d, androidx.lifecycle.j, y, androidx.savedstate.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f21a;
    private final androidx.savedstate.c b;
    private x c;
    private final OnBackPressedDispatcher d;

    @ac
    private int e;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23a;
        x b;

        a() {
        }
    }

    public b() {
        this.f21a = new k(this);
        this.b = androidx.savedstate.c.a(this);
        this.d = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.super.onBackPressed();
            }
        });
        if (c() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            c().a(new h() { // from class: androidx.activity.ComponentActivity$2
                @Override // androidx.lifecycle.h
                public void a(@ah androidx.lifecycle.j jVar, @ah g.a aVar) {
                    if (aVar == g.a.ON_STOP) {
                        Window window = this.f15a.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        c().a(new h() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.h
            public void a(@ah androidx.lifecycle.j jVar, @ah g.a aVar) {
                if (aVar != g.a.ON_DESTROY || this.f16a.isChangingConfigurations()) {
                    return;
                }
                this.f16a.d().b();
            }
        });
        if (19 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 23) {
            return;
        }
        c().a(new ImmLeaksCleaner(this));
    }

    @n
    public b(@ac int i) {
        this();
        this.e = i;
    }

    @ai
    @Deprecated
    public Object a_() {
        return null;
    }

    @ai
    @Deprecated
    public Object b() {
        a aVar = (a) getLastNonConfigurationInstance();
        if (aVar != null) {
            return aVar.f23a;
        }
        return null;
    }

    @Override // androidx.core.app.j, androidx.lifecycle.j
    @ah
    public g c() {
        return this.f21a;
    }

    @Override // androidx.lifecycle.y
    @ah
    public x d() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.c == null) {
            a aVar = (a) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.c = aVar.b;
            }
            if (this.c == null) {
                this.c = new x();
            }
        }
        return this.c;
    }

    @Override // androidx.activity.d
    @ah
    public final OnBackPressedDispatcher e() {
        return this.d;
    }

    @Override // androidx.savedstate.d
    @ah
    public final androidx.savedstate.b f() {
        return this.b.a();
    }

    @Override // android.app.Activity
    @ae
    public void onBackPressed() {
        this.d.b();
    }

    @Override // androidx.core.app.j, android.app.Activity
    protected void onCreate(@ai Bundle bundle) {
        super.onCreate(bundle);
        this.b.a(bundle);
        t.a(this);
        if (this.e != 0) {
            setContentView(this.e);
        }
    }

    @Override // android.app.Activity
    @ai
    public final Object onRetainNonConfigurationInstance() {
        a aVar;
        Object objA_ = a_();
        x xVar = this.c;
        if (xVar == null && (aVar = (a) getLastNonConfigurationInstance()) != null) {
            xVar = aVar.b;
        }
        if (xVar == null && objA_ == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.f23a = objA_;
        aVar2.b = xVar;
        return aVar2;
    }

    @Override // androidx.core.app.j, android.app.Activity
    @i
    protected void onSaveInstanceState(@ah Bundle bundle) {
        g gVarC = c();
        if (gVarC instanceof k) {
            ((k) gVarC).b(g.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.b.b(bundle);
    }
}
