package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.ai;
import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public class r extends ab {
    private static final float c = 1.0f;

    @ai
    private w d;

    @ai
    private w e;

    private int a(@androidx.annotation.ah RecyclerView.i iVar, @androidx.annotation.ah View view, w wVar) {
        return (wVar.a(view) + (wVar.e(view) / 2)) - (wVar.d() + (wVar.g() / 2));
    }

    private int a(RecyclerView.i iVar, w wVar, int i, int i2) {
        int[] iArrB = b(i, i2);
        float fB = b(iVar, wVar);
        if (fB <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArrB[0]) > Math.abs(iArrB[1]) ? iArrB[0] : iArrB[1]) / fB);
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

    private float b(RecyclerView.i iVar, w wVar) {
        int iH = iVar.H();
        if (iH == 0) {
            return 1.0f;
        }
        View view = null;
        int i = ActivityChooserView.a.f166a;
        int i2 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i3 = 0; i3 < iH; i3++) {
            View viewJ = iVar.j(i3);
            int iE = iVar.e(viewJ);
            if (iE != -1) {
                if (iE < i) {
                    view = viewJ;
                    i = iE;
                }
                if (iE > i2) {
                    view2 = viewJ;
                    i2 = iE;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int iMax = Math.max(wVar.b(view), wVar.b(view2)) - Math.min(wVar.a(view), wVar.a(view2));
        if (iMax == 0) {
            return 1.0f;
        }
        return (iMax * 1.0f) / ((i2 - i) + 1);
    }

    @androidx.annotation.ah
    private w d(@androidx.annotation.ah RecyclerView.i iVar) {
        if (this.d == null || this.d.f1101a != iVar) {
            this.d = w.b(iVar);
        }
        return this.d;
    }

    @androidx.annotation.ah
    private w e(@androidx.annotation.ah RecyclerView.i iVar) {
        if (this.e == null || this.e.f1101a != iVar) {
            this.e = w.a(iVar);
        }
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ab
    public int a(RecyclerView.i iVar, int i, int i2) {
        int iV;
        View viewA;
        int iE;
        int i3;
        PointF pointFD;
        int iA;
        int iA2;
        if (!(iVar instanceof RecyclerView.v.b) || (iV = iVar.V()) == 0 || (viewA = a(iVar)) == null || (iE = iVar.e(viewA)) == -1 || (pointFD = ((RecyclerView.v.b) iVar).d((i3 = iV - 1))) == null) {
            return -1;
        }
        if (iVar.i()) {
            iA = a(iVar, e(iVar), i, 0);
            if (pointFD.x < 0.0f) {
                iA = -iA;
            }
        } else {
            iA = 0;
        }
        if (iVar.j()) {
            iA2 = a(iVar, d(iVar), 0, i2);
            if (pointFD.y < 0.0f) {
                iA2 = -iA2;
            }
        } else {
            iA2 = 0;
        }
        if (!iVar.j()) {
            iA2 = iA;
        }
        if (iA2 == 0) {
            return -1;
        }
        int i4 = iE + iA2;
        if (i4 < 0) {
            i4 = 0;
        }
        return i4 >= iV ? i3 : i4;
    }

    @Override // androidx.recyclerview.widget.ab
    public View a(RecyclerView.i iVar) {
        if (iVar.j()) {
            return a(iVar, d(iVar));
        }
        if (iVar.i()) {
            return a(iVar, e(iVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.ab
    public int[] a(@androidx.annotation.ah RecyclerView.i iVar, @androidx.annotation.ah View view) {
        int[] iArr = new int[2];
        if (iVar.i()) {
            iArr[0] = a(iVar, view, e(iVar));
        } else {
            iArr[0] = 0;
        }
        if (iVar.j()) {
            iArr[1] = a(iVar, view, d(iVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
