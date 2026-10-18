package androidx.core.n.b;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private b() {
    }

    public static Interpolator a(float f, float f2) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f, f2) : new a(f, f2);
    }

    public static Interpolator a(float f, float f2, float f3, float f4) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f, f2, f3, f4) : new a(f, f2, f3, f4);
    }

    public static Interpolator a(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(path) : new a(path);
    }
}
