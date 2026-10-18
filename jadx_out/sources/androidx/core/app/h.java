package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f344a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    private h() {
    }

    public static int a(@ah Context context, @ah String str, int i, @ah String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i, str2);
        }
        return 1;
    }

    public static int a(@ah Context context, @ah String str, @ah String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
        return 1;
    }

    @ai
    public static String a(@ah String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public static int b(@ah Context context, @ah String str, int i, @ah String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i, str2);
        }
        return 1;
    }

    public static int b(@ah Context context, @ah String str, @ah String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }
}
