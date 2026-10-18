package androidx.j;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class bg extends ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f879a = "android:visibilityPropagation:visibility";
    private static final String b = "android:visibilityPropagation:center";
    private static final String[] c = {f879a, b};

    private static int a(an anVar, int i) {
        int[] iArr;
        if (anVar == null || (iArr = (int[]) anVar.f859a.get(b)) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // androidx.j.ak
    public void a(an anVar) {
        View view = anVar.b;
        Integer numValueOf = (Integer) anVar.f859a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        anVar.f859a.put(f879a, numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        anVar.f859a.put(b, iArr);
    }

    @Override // androidx.j.ak
    public String[] a() {
        return c;
    }

    public int b(an anVar) {
        Integer num;
        if (anVar == null || (num = (Integer) anVar.f859a.get(f879a)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int c(an anVar) {
        return a(anVar, 0);
    }

    public int d(an anVar) {
        return a(anVar, 1);
    }
}
