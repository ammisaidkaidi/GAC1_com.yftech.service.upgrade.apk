package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class j extends Activity implements androidx.core.n.j.a, androidx.lifecycle.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.c.i<Class<? extends a>, a> f346a = new androidx.c.i<>();
    private androidx.lifecycle.k b = new androidx.lifecycle.k(this);

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static class a {
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T extends a> T a(Class<T> cls) {
        return (T) this.f346a.get(cls);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void a(a aVar) {
        this.f346a.put((Class<? extends a>) aVar.getClass(), aVar);
    }

    @Override // androidx.core.n.j.a
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @ah
    public androidx.lifecycle.g c() {
        return this.b;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.n.j.a(decorView, keyEvent)) {
            return androidx.core.n.j.a(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.n.j.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(@ai Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.t.a(this);
    }

    @Override // android.app.Activity
    @androidx.annotation.i
    protected void onSaveInstanceState(@ah Bundle bundle) {
        this.b.a(androidx.lifecycle.g.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
