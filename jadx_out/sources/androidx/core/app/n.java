package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f357a = "android.support.PARENT_ACTIVITY";
    private static final String b = "NavUtils";

    private n() {
    }

    @ai
    public static Intent a(@ah Context context, @ah ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strB = b(context, componentName);
        if (strB == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strB);
        return b(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @ai
    public static Intent a(@ah Context context, @ah Class<?> cls) throws PackageManager.NameNotFoundException {
        String strB = b(context, new ComponentName(context, cls));
        if (strB == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, strB);
        return b(context, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    public static void a(@ah Activity activity) {
        Intent intentB = b(activity);
        if (intentB != null) {
            b(activity, intentB);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static boolean a(@ah Activity activity, @ah Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    @ai
    public static Intent b(@ah Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT >= 16 && (parentActivityIntent = activity.getParentActivityIntent()) != null) {
            return parentActivityIntent;
        }
        String strC = c(activity);
        if (strC == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strC);
        try {
            return b(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(b, "getParentActivityIntent: bad parentActivityName '" + strC + "' in manifest");
            return null;
        }
    }

    @ai
    public static String b(@ah Context context, @ah ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        String str;
        PackageManager packageManager = context.getPackageManager();
        int i = Build.VERSION.SDK_INT;
        int i2 = 640;
        if (Build.VERSION.SDK_INT >= 29) {
            i2 = 269222528;
        } else if (Build.VERSION.SDK_INT >= 24) {
            i2 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
        if (Build.VERSION.SDK_INT >= 16 && (str = activityInfo.parentActivityName) != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString(f357a)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void b(@ah Activity activity, @ah Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    @ai
    public static String c(@ah Activity activity) {
        try {
            return b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
