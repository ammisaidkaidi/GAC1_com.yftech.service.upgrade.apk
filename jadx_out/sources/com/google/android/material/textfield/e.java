package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.ah;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextInputLayout f1460a;
    Context b;
    CheckableImageButton c;

    e(@ah TextInputLayout textInputLayout) {
        this.f1460a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    abstract void a();

    void a(boolean z) {
    }

    boolean a(int i) {
        return true;
    }

    boolean b() {
        return false;
    }
}
