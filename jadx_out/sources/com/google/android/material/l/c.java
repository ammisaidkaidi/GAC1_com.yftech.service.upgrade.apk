package com.google.android.material.l;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ah;
import androidx.annotation.w;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    private final View f1361a;
    private boolean b = false;

    @w
    private int c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public c(b bVar) {
        this.f1361a = (View) bVar;
    }

    private void d() {
        ViewParent parent = this.f1361a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).b(this.f1361a);
        }
    }

    public void a(@w int i) {
        this.c = i;
    }

    public void a(@ah Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            d();
        }
    }

    public boolean a() {
        return this.b;
    }

    public boolean a(boolean z) {
        if (this.b == z) {
            return false;
        }
        this.b = z;
        d();
        return true;
    }

    @ah
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    @w
    public int c() {
        return this.c;
    }
}
