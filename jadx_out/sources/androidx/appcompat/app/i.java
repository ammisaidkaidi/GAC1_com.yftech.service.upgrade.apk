package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ac;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.w;

/* JADX INFO: loaded from: classes.dex */
public class i extends Dialog implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f78a;
    private final androidx.core.n.j.a b;

    public i(Context context) {
        this(context, 0);
    }

    public i(Context context, int i) {
        super(context, a(context, i));
        this.b = new androidx.core.n.j.a() { // from class: androidx.appcompat.app.i.1
            @Override // androidx.core.n.j.a
            public boolean a(KeyEvent keyEvent) {
                return i.this.a(keyEvent);
            }
        };
        g gVarC = c();
        gVarC.a(a(context, i));
        gVarC.a((Bundle) null);
    }

    protected i(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.b = new androidx.core.n.j.a() { // from class: androidx.appcompat.app.i.1
            @Override // androidx.core.n.j.a
            public boolean a(KeyEvent keyEvent) {
                return i.this.a(keyEvent);
            }
        };
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.a.b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.f
    @ai
    public androidx.appcompat.view.b a(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    @Override // androidx.appcompat.app.f
    public void a(androidx.appcompat.view.b bVar) {
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().b(view, layoutParams);
    }

    public a b() {
        return c().a();
    }

    @Override // androidx.appcompat.app.f
    public void b(androidx.appcompat.view.b bVar) {
    }

    public g c() {
        if (this.f78a == null) {
            this.f78a = g.a(this, this);
        }
        return this.f78a;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        c().g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.n.j.a(this.b, getWindow().getDecorView(), this, keyEvent);
    }

    public boolean e(int i) {
        return c().d(i);
    }

    @Override // android.app.Dialog
    @ai
    public <T extends View> T findViewById(@w int i) {
        return (T) c().b(i);
    }

    @Override // android.app.Dialog
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        c().f();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        c().i();
        super.onCreate(bundle);
        c().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        c().d();
    }

    @Override // android.app.Dialog
    public void setContentView(@ac int i) {
        c().c(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        c().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        c().a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().a(charSequence);
    }
}
