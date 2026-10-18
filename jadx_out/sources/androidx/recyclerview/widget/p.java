package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1090a = -1;
    static final int b = 1;
    static final int c = Integer.MIN_VALUE;
    static final int d = -1;
    static final int e = 1;
    int g;
    int h;
    int i;
    int j;
    boolean m;
    boolean n;
    boolean f = true;
    int k = 0;
    int l = 0;

    p() {
    }

    View a(RecyclerView.q qVar) {
        View viewC = qVar.c(this.h);
        this.h += this.i;
        return viewC;
    }

    boolean a(RecyclerView.w wVar) {
        return this.h >= 0 && this.h < wVar.h();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.g + ", mCurrentPosition=" + this.h + ", mItemDirection=" + this.i + ", mLayoutDirection=" + this.j + ", mStartLine=" + this.k + ", mEndLine=" + this.l + '}';
    }
}
