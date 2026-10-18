package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.n.af;
import androidx.core.n.ao;
import androidx.core.n.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class c extends d<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Rect f1170a;
    final Rect b;
    private int c;
    private int d;

    public c() {
        this.f1170a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1170a = new Rect();
        this.b = new Rect();
        this.c = 0;
    }

    private static int d(int i) {
        return i == 0 ? com.google.android.material.b.a.b : i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah View view, int i, int i2, int i3, int i4) {
        View viewB;
        ao lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewB = b(coordinatorLayout.c(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (af.U(viewB) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.b() + lastWindowInsets.d();
        }
        int iC = size + c(viewB);
        int measuredHeight = viewB.getMeasuredHeight();
        if (b()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iC -= measuredHeight;
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec(iC, i5 == -1 ? androidx.d.c.b.a.b.b : Integer.MIN_VALUE), i4);
        return true;
    }

    float b(View view) {
        return 1.0f;
    }

    @ai
    abstract View b(List<View> list);

    @Override // com.google.android.material.appbar.d
    protected void b(@ah CoordinatorLayout coordinatorLayout, @ah View view, int i) {
        View viewB = b(coordinatorLayout.c(view));
        if (viewB == null) {
            super.b(coordinatorLayout, view, i);
            this.c = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.f1170a;
        rect.set(coordinatorLayout.getPaddingLeft() + fVar.leftMargin, viewB.getBottom() + fVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - fVar.rightMargin, ((coordinatorLayout.getHeight() + viewB.getBottom()) - coordinatorLayout.getPaddingBottom()) - fVar.bottomMargin);
        ao lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && af.U(coordinatorLayout) && !af.U(view)) {
            rect.left += lastWindowInsets.a();
            rect.right -= lastWindowInsets.c();
        }
        Rect rect2 = this.b;
        h.a(d(fVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int iD = d(viewB);
        view.layout(rect2.left, rect2.top - iD, rect2.right, rect2.bottom - iD);
        this.c = rect2.top - viewB.getBottom();
    }

    protected boolean b() {
        return false;
    }

    final int c() {
        return this.c;
    }

    int c(@ah View view) {
        return view.getMeasuredHeight();
    }

    public final void c(int i) {
        this.d = i;
    }

    final int d(View view) {
        if (this.d == 0) {
            return 0;
        }
        return androidx.core.g.a.a((int) (b(view) * this.d), 0, this.d);
    }

    public final int h() {
        return this.d;
    }
}
