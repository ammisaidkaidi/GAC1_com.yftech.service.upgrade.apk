package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ao;
import androidx.annotation.ax;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f90a = "TwilightManager";
    private static final int b = 6;
    private static final int c = 22;
    private static p d;
    private final Context e;
    private final LocationManager f;
    private final a g = new a();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f91a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    @ax
    p(@ah Context context, @ah LocationManager locationManager) {
        this.e = context;
        this.f = locationManager;
    }

    @ao(c = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location a(String str) {
        try {
            if (this.f.isProviderEnabled(str)) {
                return this.f.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d(f90a, "Failed to get last known location", e);
            return null;
        }
    }

    static p a(@ah Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new p(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    private void a(@ah Location location) {
        long j;
        long j2;
        a aVar = this.g;
        long jCurrentTimeMillis = System.currentTimeMillis();
        o oVarA = o.a();
        oVarA.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = oVarA.c;
        oVarA.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = oVarA.e == 1;
        long j4 = oVarA.d;
        long j5 = oVarA.c;
        oVarA.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = oVarA.d;
        if (j4 == -1 || j5 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j5) {
                j2 = 0 + j6;
            } else {
                j2 = jCurrentTimeMillis > j4 ? 0 + j5 : 0 + j4;
            }
            j = j2 + 60000;
        }
        aVar.f91a = z;
        aVar.b = j3;
        aVar.c = j4;
        aVar.d = j5;
        aVar.e = j6;
        aVar.f = j;
    }

    @ax
    static void a(p pVar) {
        d = pVar;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationA = androidx.core.b.g.a(this.e, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        Location locationA2 = androidx.core.b.g.a(this.e, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        if (locationA2 == null || locationA == null) {
            return locationA2 != null ? locationA2 : locationA;
        }
        return locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
    }

    private boolean c() {
        return this.g.f > System.currentTimeMillis();
    }

    boolean a() {
        a aVar = this.g;
        if (c()) {
            return aVar.f91a;
        }
        Location locationB = b();
        if (locationB != null) {
            a(locationB);
            return aVar.f91a;
        }
        Log.i(f90a, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
