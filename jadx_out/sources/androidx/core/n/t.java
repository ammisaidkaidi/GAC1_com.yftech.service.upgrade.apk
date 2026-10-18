package androidx.core.n;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f574a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public t(@androidx.annotation.ah View view) {
        this.c = view;
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f574a = viewParent;
                break;
            case 1:
                this.b = viewParent;
                break;
        }
    }

    private boolean b(int i, int i2, int i3, int i4, @androidx.annotation.ai int[] iArr, int i5, @androidx.annotation.ai int[] iArr2) {
        ViewParent viewParentD;
        int i6;
        int i7;
        int[] iArr3;
        if (!a() || (viewParentD = d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] iArrE = e();
            iArrE[0] = 0;
            iArrE[1] = 0;
            iArr3 = iArrE;
        } else {
            iArr3 = iArr2;
        }
        ai.a(viewParentD, this.c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    private ViewParent d(int i) {
        switch (i) {
            case 0:
                return this.f574a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }

    private int[] e() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    public void a(int i, int i2, int i3, int i4, @androidx.annotation.ai int[] iArr, int i5, @androidx.annotation.ai int[] iArr2) {
        b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public void a(@androidx.annotation.ah View view) {
        af.ad(this.c);
    }

    public void a(boolean z) {
        if (this.d) {
            af.ad(this.c);
        }
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(float f, float f2) {
        ViewParent viewParentD;
        if (!a() || (viewParentD = d(0)) == null) {
            return false;
        }
        return ai.a(viewParentD, this.c, f, f2);
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent viewParentD;
        if (!a() || (viewParentD = d(0)) == null) {
            return false;
        }
        return ai.a(viewParentD, this.c, f, f2, z);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.c;
        for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
            if (ai.a(parent, view, this.c, i, i2)) {
                a(i2, parent);
                ai.b(parent, view, this.c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, @androidx.annotation.ai int[] iArr) {
        return b(i, i2, i3, i4, iArr, 0, null);
    }

    public boolean a(int i, int i2, int i3, int i4, @androidx.annotation.ai int[] iArr, int i5) {
        return b(i, i2, i3, i4, iArr, i5, null);
    }

    public boolean a(int i, int i2, @androidx.annotation.ai int[] iArr, @androidx.annotation.ai int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, @androidx.annotation.ai int[] iArr, @androidx.annotation.ai int[] iArr2, int i3) {
        ViewParent viewParentD;
        int i4;
        int i5;
        if (!a() || (viewParentD = d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            iArr = e();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ai.a(viewParentD, this.c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean b() {
        return a(0);
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent viewParentD = d(i);
        if (viewParentD != null) {
            ai.a(viewParentD, this.c, i);
            a(i, (ViewParent) null);
        }
    }

    public void d() {
        af.ad(this.c);
    }
}
