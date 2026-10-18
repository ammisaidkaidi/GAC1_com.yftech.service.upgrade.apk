package androidx.core.b.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private b() {
    }

    public static long a(@ah PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }
}
