package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.ah;
import androidx.annotation.am;

/* JADX INFO: loaded from: classes.dex */
@am(a = 18)
class u implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f1352a;

    u(@ah ViewGroup viewGroup) {
        this.f1352a = viewGroup.getOverlay();
    }

    @Override // com.google.android.material.internal.y
    public void a(@ah Drawable drawable) {
        this.f1352a.add(drawable);
    }

    @Override // com.google.android.material.internal.v
    public void a(@ah View view) {
        this.f1352a.add(view);
    }

    @Override // com.google.android.material.internal.y
    public void b(@ah Drawable drawable) {
        this.f1352a.remove(drawable);
    }

    @Override // com.google.android.material.internal.v
    public void b(@ah View view) {
        this.f1352a.remove(view);
    }
}
