package androidx.core.b.a;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY})
    public @interface a {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY})
    public @interface b {
    }

    private c() {
    }

    @SuppressLint({"WrongConstant"})
    public static int a(@ah PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? permissionInfo.getProtection() : permissionInfo.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@ah PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? permissionInfo.getProtectionFlags() : permissionInfo.protectionLevel & (-16);
    }
}
