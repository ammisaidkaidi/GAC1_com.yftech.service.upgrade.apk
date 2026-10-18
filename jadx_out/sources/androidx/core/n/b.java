package androidx.core.n;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f546a = "ActionProvider(support)";
    private final Context b;
    private a c;
    private InterfaceC0043b d;

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public interface a {
        void d(boolean z);
    }

    /* JADX INFO: renamed from: androidx.core.n.b$b, reason: collision with other inner class name */
    public interface InterfaceC0043b {
        void a(boolean z);
    }

    public b(Context context) {
        this.b = context;
    }

    public abstract View a();

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(SubMenu subMenu) {
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(InterfaceC0043b interfaceC0043b) {
        if (this.d != null && interfaceC0043b != null) {
            Log.w(f546a, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.d = interfaceC0043b;
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public void a(boolean z) {
        if (this.c != null) {
            this.c.d(z);
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public void f() {
        if (this.d == null || !d()) {
            return;
        }
        this.d.a(e());
    }

    public Context g() {
        return this.b;
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public void h() {
        this.d = null;
        this.c = null;
    }
}
