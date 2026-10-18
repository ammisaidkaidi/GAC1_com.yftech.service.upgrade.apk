package com.google.android.material.datepicker;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class t<S> extends androidx.fragment.app.d {
    protected final LinkedHashSet<s<S>> e = new LinkedHashSet<>();

    t() {
    }

    boolean a(s<S> sVar) {
        return this.e.add(sVar);
    }

    boolean b(s<S> sVar) {
        return this.e.remove(sVar);
    }

    abstract f<S> e();

    void j() {
        this.e.clear();
    }
}
