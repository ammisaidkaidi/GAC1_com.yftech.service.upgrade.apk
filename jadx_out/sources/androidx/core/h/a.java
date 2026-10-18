package androidx.core.h;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ao;
import androidx.annotation.ap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f446a = 1;
    public static final int b = 2;
    public static final int c = 3;

    /* JADX INFO: renamed from: androidx.core.h.a$a, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface InterfaceC0031a {
    }

    private a() {
    }

    @ai
    @ao(a = "android.permission.ACCESS_NETWORK_STATE")
    @SuppressLint({"ReferencesDeprecated"})
    public static NetworkInfo a(@ah ConnectivityManager connectivityManager, @ah Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    @ao(a = "android.permission.ACCESS_NETWORK_STATE")
    public static boolean a(@ah ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            case 1:
            case 7:
            case 9:
                return false;
            case 8:
            default:
                return true;
        }
    }

    public static int b(@ah ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 24) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
        return 3;
    }
}
