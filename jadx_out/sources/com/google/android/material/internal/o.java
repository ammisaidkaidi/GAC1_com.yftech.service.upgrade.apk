package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public final class o {
    private final ArrayList<a> b = new ArrayList<>();

    @ai
    private a c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ai
    ValueAnimator f1343a = null;
    private final Animator.AnimatorListener d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.o.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (o.this.f1343a == animator) {
                o.this.f1343a = null;
            }
        }
    };

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f1345a;
        final ValueAnimator b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f1345a = iArr;
            this.b = valueAnimator;
        }
    }

    private void a(@ah a aVar) {
        this.f1343a = aVar.b;
        this.f1343a.start();
    }

    private void b() {
        if (this.f1343a != null) {
            this.f1343a.cancel();
            this.f1343a = null;
        }
    }

    public void a() {
        if (this.f1343a != null) {
            this.f1343a.end();
            this.f1343a = null;
        }
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (StateSet.stateSetMatches(aVar.f1345a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        if (aVar == this.c) {
            return;
        }
        if (this.c != null) {
            b();
        }
        this.c = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add(aVar);
    }
}
