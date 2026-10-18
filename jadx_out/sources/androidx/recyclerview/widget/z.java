package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class z {
    private z() {
    }

    static int a(RecyclerView.w wVar, w wVar2, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.H() == 0 || wVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.e(view) - iVar.e(view2)) + 1;
        }
        return Math.min(wVar2.g(), wVar2.b(view2) - wVar2.a(view));
    }

    static int a(RecyclerView.w wVar, w wVar2, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        if (iVar.H() == 0 || wVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (wVar.h() - Math.max(iVar.e(view), iVar.e(view2))) - 1) : Math.max(0, Math.min(iVar.e(view), iVar.e(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(wVar2.b(view2) - wVar2.a(view)) / (Math.abs(iVar.e(view) - iVar.e(view2)) + 1))) + (wVar2.d() - wVar2.a(view)));
        }
        return iMax;
    }

    static int b(RecyclerView.w wVar, w wVar2, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.H() == 0 || wVar.h() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return wVar.h();
        }
        return (int) (((wVar2.b(view2) - wVar2.a(view)) / (Math.abs(iVar.e(view) - iVar.e(view2)) + 1)) * wVar.h());
    }
}
