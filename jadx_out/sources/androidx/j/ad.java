package androidx.j;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ad extends bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f832a = 3.0f;
    private int b = 80;

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    private int a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        if (this.b == 8388611) {
            if (androidx.core.n.af.p(view) == 1) {
                i9 = 5;
            } else {
                i9 = 3;
            }
        } else if (this.b == 8388613) {
            if (androidx.core.n.af.p(view) == 1) {
                i9 = 3;
            } else {
                i9 = 5;
            }
        } else {
            i9 = this.b;
        }
        if (i9 == 3) {
            return (i7 - i) + Math.abs(i4 - i2);
        }
        if (i9 == 5) {
            return (i - i5) + Math.abs(i4 - i2);
        }
        if (i9 == 48) {
            return (i8 - i2) + Math.abs(i3 - i);
        }
        if (i9 != 80) {
            return 0;
        }
        return (i2 - i6) + Math.abs(i3 - i);
    }

    private int a(ViewGroup viewGroup) {
        int i = this.b;
        return (i == 3 || i == 5 || i == 8388611 || i == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.j.ak
    public long a(ViewGroup viewGroup, ag agVar, an anVar, an anVar2) {
        int i;
        int iCenterX;
        int iCenterY;
        an anVar3 = anVar;
        if (anVar3 == null && anVar2 == null) {
            return 0L;
        }
        Rect rectQ = agVar.q();
        if (anVar2 == null || b(anVar3) == 0) {
            i = -1;
        } else {
            anVar3 = anVar2;
            i = 1;
        }
        int iC = c(anVar3);
        int iD = d(anVar3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectQ != null) {
            iCenterX = rectQ.centerX();
            iCenterY = rectQ.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fA = a(viewGroup, iC, iD, iCenterX, iCenterY, iRound, iRound2, width, height) / a(viewGroup);
        long jD = agVar.d();
        if (jD < 0) {
            jD = 300;
        }
        return Math.round(((jD * ((long) i)) / this.f832a) * fA);
    }

    public void a(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f832a = f;
    }

    public void a(int i) {
        this.b = i;
    }
}
