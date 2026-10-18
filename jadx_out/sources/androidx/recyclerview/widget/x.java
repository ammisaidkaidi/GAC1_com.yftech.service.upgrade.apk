package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.ai;
import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public class x extends ab {
    private static final int c = 100;

    @ai
    private w d;

    @ai
    private w e;

    private int a(@androidx.annotation.ah RecyclerView.i iVar, @androidx.annotation.ah View view, w wVar) {
        return (wVar.a(view) + (wVar.e(view) / 2)) - (wVar.d() + (wVar.g() / 2));
    }

    @ai
    private View a(RecyclerView.i iVar, w wVar) {
        int iH = iVar.H();
        View view = null;
        if (iH == 0) {
            return null;
        }
        int iD = wVar.d() + (wVar.g() / 2);
        int i = ActivityChooserView.a.f166a;
        for (int i2 = 0; i2 < iH; i2++) {
            View viewJ = iVar.j(i2);
            int iAbs = Math.abs((wVar.a(viewJ) + (wVar.e(viewJ) / 2)) - iD);
            if (iAbs < i) {
                view = viewJ;
                i = iAbs;
            }
        }
        return view;
    }

    private boolean b(RecyclerView.i iVar, int i, int i2) {
        if (iVar.i()) {
            return i > 0;
        }
        return i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean d(RecyclerView.i iVar) {
        PointF pointFD;
        int iV = iVar.V();
        if (!(iVar instanceof RecyclerView.v.b) || (pointFD = ((RecyclerView.v.b) iVar).d(iV - 1)) == null) {
            return false;
        }
        return pointFD.x < 0.0f || pointFD.y < 0.0f;
    }

    @ai
    private w e(RecyclerView.i iVar) {
        if (iVar.j()) {
            return f(iVar);
        }
        if (iVar.i()) {
            return g(iVar);
        }
        return null;
    }

    @androidx.annotation.ah
    private w f(@androidx.annotation.ah RecyclerView.i iVar) {
        if (this.d == null || this.d.f1101a != iVar) {
            this.d = w.b(iVar);
        }
        return this.d;
    }

    @androidx.annotation.ah
    private w g(@androidx.annotation.ah RecyclerView.i iVar) {
        if (this.e == null || this.e.f1101a != iVar) {
            this.e = w.a(iVar);
        }
        return this.e;
    }

    @Override // androidx.recyclerview.widget.ab
    public int a(RecyclerView.i iVar, int i, int i2) {
        w wVarE;
        int iV = iVar.V();
        if (iV == 0 || (wVarE = e(iVar)) == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int iH = iVar.H();
        View view = null;
        int i4 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < iH; i5++) {
            View viewJ = iVar.j(i5);
            if (viewJ != null) {
                int iA = a(iVar, viewJ, wVarE);
                if (iA <= 0 && iA > i3) {
                    view2 = viewJ;
                    i3 = iA;
                }
                if (iA >= 0 && iA < i4) {
                    view = viewJ;
                    i4 = iA;
                }
            }
        }
        boolean zB = b(iVar, i, i2);
        if (zB && view != null) {
            return iVar.e(view);
        }
        if (!zB && view2 != null) {
            return iVar.e(view2);
        }
        if (!zB) {
            view2 = view;
        }
        if (view2 == null) {
            return -1;
        }
        int iE = iVar.e(view2) + (d(iVar) == zB ? -1 : 1);
        if (iE < 0 || iE >= iV) {
            return -1;
        }
        return iE;
    }

    @Override // androidx.recyclerview.widget.ab
    @ai
    public View a(RecyclerView.i iVar) {
        if (iVar.j()) {
            return a(iVar, f(iVar));
        }
        if (iVar.i()) {
            return a(iVar, g(iVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.ab
    @ai
    public int[] a(@androidx.annotation.ah RecyclerView.i iVar, @androidx.annotation.ah View view) {
        int[] iArr = new int[2];
        if (iVar.i()) {
            iArr[0] = a(iVar, view, g(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.j()) {
            iArr[1] = a(iVar, view, f(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.ab
    protected q b(RecyclerView.i iVar) {
        if (iVar instanceof RecyclerView.v.b) {
            return new q(this.b.getContext()) { // from class: androidx.recyclerview.widget.x.1
                @Override // androidx.recyclerview.widget.q
                protected float a(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.v
                protected void a(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
                    int[] iArrA = x.this.a(x.this.b.getLayoutManager(), view);
                    int i = iArrA[0];
                    int i2 = iArrA[1];
                    int iA = a(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iA > 0) {
                        aVar.a(i, i2, iA, this.e);
                    }
                }

                @Override // androidx.recyclerview.widget.q
                protected int b(int i) {
                    return Math.min(100, super.b(i));
                }
            };
        }
        return null;
    }
}
