package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<?> f760a;

    private g(i<?> iVar) {
        this.f760a = iVar;
    }

    @ah
    public static g a(@ah i<?> iVar) {
        return new g((i) androidx.core.m.i.a(iVar, "callbacks == null"));
    }

    @ai
    public View a(@ai View view, @ah String str, @ah Context context, @ah AttributeSet attributeSet) {
        return this.f760a.b.onCreateView(view, str, context, attributeSet);
    }

    @ai
    public d a(@ah String str) {
        return this.f760a.b.b(str);
    }

    @ah
    public j a() {
        return this.f760a.b;
    }

    @ah
    public List<d> a(@SuppressLint({"UnknownNullness"}) List<d> list) {
        return this.f760a.b.m();
    }

    public void a(@ah Configuration configuration) {
        this.f760a.b.a(configuration);
    }

    public void a(@ai Parcelable parcelable) {
        if (!(this.f760a instanceof androidx.lifecycle.y)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        this.f760a.b.a(parcelable);
    }

    @Deprecated
    public void a(@ai Parcelable parcelable, @ai l lVar) {
        this.f760a.b.a(parcelable, lVar);
    }

    @Deprecated
    public void a(@ai Parcelable parcelable, @ai List<d> list) {
        this.f760a.b.a(parcelable, new l(list, null, null));
    }

    @Deprecated
    public void a(@SuppressLint({"UnknownNullness"}) androidx.c.i<String, androidx.i.a.a> iVar) {
    }

    public void a(@ai d dVar) {
        this.f760a.b.a(this.f760a, this.f760a, dVar);
    }

    @Deprecated
    public void a(@ah String str, @ai FileDescriptor fileDescriptor, @ah PrintWriter printWriter, @ai String[] strArr) {
    }

    public void a(boolean z) {
        this.f760a.b.b(z);
    }

    public boolean a(@ah Menu menu) {
        return this.f760a.b.a(menu);
    }

    public boolean a(@ah Menu menu, @ah MenuInflater menuInflater) {
        return this.f760a.b.a(menu, menuInflater);
    }

    public boolean a(@ah MenuItem menuItem) {
        return this.f760a.b.a(menuItem);
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public androidx.i.a.a b() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void b(@ah Menu menu) {
        this.f760a.b.b(menu);
    }

    public void b(boolean z) {
        this.f760a.b.c(z);
    }

    public boolean b(@ah MenuItem menuItem) {
        return this.f760a.b.b(menuItem);
    }

    public int c() {
        return this.f760a.b.n();
    }

    @Deprecated
    public void c(boolean z) {
    }

    public void d() {
        this.f760a.b.v();
    }

    @ai
    public Parcelable e() {
        return this.f760a.b.u();
    }

    @ai
    @Deprecated
    public List<d> f() {
        l lVarT = this.f760a.b.t();
        if (lVarT == null || lVarT.a() == null) {
            return null;
        }
        return new ArrayList(lVarT.a());
    }

    @ai
    @Deprecated
    public l g() {
        return this.f760a.b.t();
    }

    public void h() {
        this.f760a.b.w();
    }

    public void i() {
        this.f760a.b.x();
    }

    public void j() {
        this.f760a.b.y();
    }

    public void k() {
        this.f760a.b.z();
    }

    public void l() {
        this.f760a.b.A();
    }

    public void m() {
        this.f760a.b.B();
    }

    @Deprecated
    public void n() {
    }

    public void o() {
        this.f760a.b.C();
    }

    public void p() {
        this.f760a.b.D();
    }

    public void q() {
        this.f760a.b.E();
    }

    public boolean r() {
        return this.f760a.b.q();
    }

    @Deprecated
    public void s() {
    }

    @Deprecated
    public void t() {
    }

    @Deprecated
    public void u() {
    }

    @Deprecated
    public void v() {
    }

    @ai
    @Deprecated
    public androidx.c.i<String, androidx.i.a.a> w() {
        return null;
    }
}
