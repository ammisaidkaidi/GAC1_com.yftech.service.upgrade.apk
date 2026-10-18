package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.lifecycle.f;
import androidx.lifecycle.g;
import androidx.lifecycle.j;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class b {
    private static final String b = "androidx.lifecycle.BundlableSavedStateRegistry.key";

    @ai
    private Bundle d;
    private boolean e;
    private Recreator.a f;
    private androidx.a.a.b.b<String, InterfaceC0077b> c = new androidx.a.a.b.b<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1107a = true;

    public interface a {
        void a(@ah d dVar);
    }

    /* JADX INFO: renamed from: androidx.savedstate.b$b, reason: collision with other inner class name */
    public interface InterfaceC0077b {
        @ah
        Bundle a();
    }

    b() {
    }

    @ae
    @ai
    public Bundle a(@ah String str) {
        if (!this.e) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        if (this.d == null) {
            return null;
        }
        Bundle bundle = this.d.getBundle(str);
        this.d.remove(str);
        if (this.d.isEmpty()) {
            this.d = null;
        }
        return bundle;
    }

    @ae
    void a(@ah Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (this.d != null) {
            bundle2.putAll(this.d);
        }
        androidx.a.a.b.b<String, InterfaceC0077b>.d dVarC = this.c.c();
        while (dVarC.hasNext()) {
            Map.Entry next = dVarC.next();
            bundle2.putBundle((String) next.getKey(), ((InterfaceC0077b) next.getValue()).a());
        }
        bundle.putBundle(b, bundle2);
    }

    @ae
    void a(@ah g gVar, @ai Bundle bundle) {
        if (this.e) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.d = bundle.getBundle(b);
        }
        gVar.a(new f() { // from class: androidx.savedstate.SavedStateRegistry$1
            @Override // androidx.lifecycle.h
            public void a(j jVar, g.a aVar) {
                if (aVar == g.a.ON_START) {
                    this.f1106a.f1107a = true;
                } else if (aVar == g.a.ON_STOP) {
                    this.f1106a.f1107a = false;
                }
            }
        });
        this.e = true;
    }

    @ae
    public void a(@ah Class<? extends a> cls) {
        if (!this.f1107a) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f == null) {
            this.f = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f.a(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @ae
    public void a(@ah String str, @ah InterfaceC0077b interfaceC0077b) {
        if (this.c.a(str, interfaceC0077b) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    @ae
    public boolean a() {
        return this.e;
    }

    @ae
    public void b(@ah String str) {
        this.c.b(str);
    }
}
