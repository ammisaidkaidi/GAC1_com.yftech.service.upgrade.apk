package com.google.android.material.z;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.j.an;
import androidx.j.bf;
import com.google.android.material.z.v;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
abstract class q<P extends v> extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P f1559a;

    @ai
    private v b;

    protected q(P p, @ai v vVar) {
        this.f1559a = p;
        this.b = vVar;
        a(com.google.android.material.a.a.b);
    }

    private Animator a(ViewGroup viewGroup, View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        Animator animatorA = z ? this.f1559a.a(viewGroup, view) : this.f1559a.b(viewGroup, view);
        if (animatorA != null) {
            arrayList.add(animatorA);
        }
        if (this.b != null) {
            Animator animatorA2 = z ? this.b.a(viewGroup, view) : this.b.b(viewGroup, view);
            if (animatorA2 != null) {
                arrayList.add(animatorA2);
            }
        }
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // androidx.j.bf
    public Animator a(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return a(viewGroup, view, true);
    }

    public void a(@ai v vVar) {
        this.b = vVar;
    }

    @Override // androidx.j.bf
    public Animator b(ViewGroup viewGroup, View view, an anVar, an anVar2) {
        return a(viewGroup, view, false);
    }

    @ai
    public v u() {
        return this.b;
    }

    @ah
    public P w() {
        return this.f1559a;
    }
}
