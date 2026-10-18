package androidx.viewpager2.a;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f1115a = new ViewGroup.MarginLayoutParams(-1, -1);
    private LinearLayoutManager b;

    static {
        f1115a.setMargins(0, 0, 0, 0);
    }

    a(@ah LinearLayoutManager linearLayoutManager) {
        this.b = linearLayoutManager;
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b() {
        int bottom;
        int i;
        int iH = this.b.H();
        if (iH == 0) {
            return true;
        }
        boolean z = this.b.l() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, iH, 2);
        for (int i2 = 0; i2 < iH; i2++) {
            View viewJ = this.b.j(i2);
            if (viewJ == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = viewJ.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f1115a;
            iArr[i2][0] = z ? viewJ.getLeft() - marginLayoutParams.leftMargin : viewJ.getTop() - marginLayoutParams.topMargin;
            int[] iArr2 = iArr[i2];
            if (z) {
                bottom = viewJ.getRight();
                i = marginLayoutParams.rightMargin;
            } else {
                bottom = viewJ.getBottom();
                i = marginLayoutParams.bottomMargin;
            }
            iArr2[1] = bottom + i;
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.a.a.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(int[] iArr3, int[] iArr4) {
                return iArr3[0] - iArr4[0];
            }
        });
        for (int i3 = 1; i3 < iH; i3++) {
            if (iArr[i3 - 1][1] != iArr[i3][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[iH - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean c() {
        int iH = this.b.H();
        for (int i = 0; i < iH; i++) {
            if (a(this.b.j(i))) {
                return true;
            }
        }
        return false;
    }

    boolean a() {
        return (!b() || this.b.H() <= 1) && c();
    }
}
