package androidx.core.f;

import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
    }

    public static boolean a(@ah LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return locationManager.isLocationEnabled();
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }
}
