package androidx.j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.am(a = 23)
class bc extends bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f873a = true;

    bc() {
    }

    @Override // androidx.j.be
    @SuppressLint({"NewApi"})
    public void a(@androidx.annotation.ah View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.a(view, i);
        } else if (f873a) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f873a = false;
            }
        }
    }
}
