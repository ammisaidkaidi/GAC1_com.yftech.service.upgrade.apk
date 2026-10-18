package androidx.core.b.b;

import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private c() {
    }

    public static int a(@ah Resources resources) {
        return Build.VERSION.SDK_INT >= 17 ? resources.getConfiguration().densityDpi : resources.getDisplayMetrics().densityDpi;
    }
}
