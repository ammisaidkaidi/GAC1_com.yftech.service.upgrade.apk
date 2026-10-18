package androidx.j;

import android.graphics.Rect;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class j extends bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f900a = 3.0f;

    private static float a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // androidx.j.ak
    public long a(ViewGroup viewGroup, ag agVar, an anVar, an anVar2) {
        int i;
        int iRound;
        int iCenterX;
        if (anVar == null && anVar2 == null) {
            return 0L;
        }
        if (anVar2 == null || b(anVar) == 0) {
            i = -1;
        } else {
            anVar = anVar2;
            i = 1;
        }
        int iC = c(anVar);
        int iD = d(anVar);
        Rect rectQ = agVar.q();
        if (rectQ != null) {
            iCenterX = rectQ.centerX();
            iRound = rectQ.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int iRound2 = Math.round(iArr[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(iArr[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fA = a(iC, iD, iCenterX, iRound) / a(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jD = agVar.d();
        if (jD < 0) {
            jD = 300;
        }
        return Math.round(((jD * ((long) i)) / this.f900a) * fA);
    }

    public void a(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.f900a = f;
    }
}
