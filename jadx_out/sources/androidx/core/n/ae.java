package androidx.core.n;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ae {
    private ae() {
    }

    @Deprecated
    public static float a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity(i);
    }

    @Deprecated
    public static float b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity(i);
    }
}
