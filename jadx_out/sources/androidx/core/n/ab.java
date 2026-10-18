package androidx.core.n;

import android.os.Build;
import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes.dex */
public final class ab {
    private ab() {
    }

    public static void a(ScaleGestureDetector scaleGestureDetector, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }
    }

    @Deprecated
    public static void a(Object obj, boolean z) {
        a((ScaleGestureDetector) obj, z);
    }

    public static boolean a(ScaleGestureDetector scaleGestureDetector) {
        if (Build.VERSION.SDK_INT >= 19) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }
        return false;
    }

    @Deprecated
    public static boolean a(Object obj) {
        return a((ScaleGestureDetector) obj);
    }
}
