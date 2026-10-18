package com.google.android.material.z;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ai;
import androidx.j.an;

/* JADX INFO: loaded from: classes.dex */
public final class m extends q<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f1555a = 0.85f;
    private final boolean b;

    public m(boolean z) {
        super(a(z), v());
        this.b = z;
    }

    private static r a(boolean z) {
        r rVar = new r(z);
        rVar.b(f1555a);
        rVar.c(f1555a);
        return rVar;
    }

    private static v v() {
        return new d();
    }

    @Override // com.google.android.material.z.q, androidx.j.bf
    public /* bridge */ /* synthetic */ Animator a(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return super.a(viewGroup, view, anVar, anVar2);
    }

    @Override // com.google.android.material.z.q
    public /* bridge */ /* synthetic */ void a(@ai v vVar) {
        super.a(vVar);
    }

    @Override // com.google.android.material.z.q, androidx.j.bf
    public /* bridge */ /* synthetic */ Animator b(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return super.b(viewGroup, view, anVar, anVar2);
    }

    public boolean b() {
        return this.b;
    }

    @Override // com.google.android.material.z.q
    @ai
    public /* bridge */ /* synthetic */ v u() {
        return super.u();
    }
}
