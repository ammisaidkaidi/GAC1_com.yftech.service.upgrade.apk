package androidx.core.b;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.k;
import androidx.annotation.m;
import androidx.annotation.q;
import androidx.core.app.p;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f410a = "ContextCompat";
    private static final Object b = new Object();
    private static TypedValue c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<Class<?>, String> f411a = new HashMap<>();

        static {
            if (Build.VERSION.SDK_INT >= 22) {
                f411a.put(SubscriptionManager.class, "telephony_subscription_service");
                f411a.put(UsageStatsManager.class, "usagestats");
            }
            if (Build.VERSION.SDK_INT >= 21) {
                f411a.put(AppWidgetManager.class, "appwidget");
                f411a.put(BatteryManager.class, "batterymanager");
                f411a.put(CameraManager.class, "camera");
                f411a.put(JobScheduler.class, "jobscheduler");
                f411a.put(LauncherApps.class, "launcherapps");
                f411a.put(MediaProjectionManager.class, "media_projection");
                f411a.put(MediaSessionManager.class, "media_session");
                f411a.put(RestrictionsManager.class, "restrictions");
                f411a.put(TelecomManager.class, "telecom");
                f411a.put(TvInputManager.class, "tv_input");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                f411a.put(AppOpsManager.class, "appops");
                f411a.put(CaptioningManager.class, "captioning");
                f411a.put(ConsumerIrManager.class, "consumer_ir");
                f411a.put(PrintManager.class, "print");
            }
            if (Build.VERSION.SDK_INT >= 18) {
                f411a.put(BluetoothManager.class, "bluetooth");
            }
            if (Build.VERSION.SDK_INT >= 17) {
                f411a.put(DisplayManager.class, "display");
                f411a.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT >= 16) {
                f411a.put(InputManager.class, "input");
                f411a.put(MediaRouter.class, "media_router");
                f411a.put(NsdManager.class, "servicediscovery");
            }
            f411a.put(AccessibilityManager.class, "accessibility");
            f411a.put(AccountManager.class, "account");
            f411a.put(ActivityManager.class, "activity");
            f411a.put(AlarmManager.class, p.ak);
            f411a.put(AudioManager.class, "audio");
            f411a.put(ClipboardManager.class, "clipboard");
            f411a.put(ConnectivityManager.class, "connectivity");
            f411a.put(DevicePolicyManager.class, "device_policy");
            f411a.put(DownloadManager.class, "download");
            f411a.put(DropBoxManager.class, "dropbox");
            f411a.put(InputMethodManager.class, "input_method");
            f411a.put(KeyguardManager.class, "keyguard");
            f411a.put(LayoutInflater.class, "layout_inflater");
            f411a.put(LocationManager.class, "location");
            f411a.put(NfcManager.class, "nfc");
            f411a.put(NotificationManager.class, "notification");
            f411a.put(PowerManager.class, "power");
            f411a.put(SearchManager.class, "search");
            f411a.put(SensorManager.class, "sensor");
            f411a.put(StorageManager.class, "storage");
            f411a.put(TelephonyManager.class, "phone");
            f411a.put(TextServicesManager.class, "textservices");
            f411a.put(UiModeManager.class, "uimode");
            f411a.put(UsbManager.class, "usb");
            f411a.put(Vibrator.class, "vibrator");
            f411a.put(WallpaperManager.class, "wallpaper");
            f411a.put(WifiP2pManager.class, "wifip2p");
            f411a.put(WifiManager.class, "wifi");
            f411a.put(WindowManager.class, "window");
        }

        private a() {
        }
    }

    private static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f412a;

        b(@ah Handler handler) {
            this.f412a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f412a.post(runnable)) {
                return;
            }
            throw new RejectedExecutionException(this.f412a + " is shutting down");
        }
    }

    protected c() {
    }

    @ai
    public static Drawable a(@ah Context context, @q int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (b) {
            if (c == null) {
                c = new TypedValue();
            }
            context.getResources().getValue(i, c, true);
            i2 = c.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    @ai
    public static File a(@ah Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir();
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    private static synchronized File a(File file) {
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        if (file.exists()) {
            return file;
        }
        Log.w(f410a, "Unable to create files subdir " + file.getPath());
        return null;
    }

    @ai
    public static <T> T a(@ah Context context, @ah Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) context.getSystemService(cls);
        }
        String strB = b(context, (Class<?>) cls);
        if (strB != null) {
            return (T) context.getSystemService(strB);
        }
        return null;
    }

    public static void a(@ah Context context, @ah Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void a(@ah Context context, @ah Intent intent, @ai Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivity(intent, bundle);
        } else {
            context.startActivity(intent);
        }
    }

    public static boolean a(@ah Context context, @ah Intent[] intentArr) {
        return a(context, intentArr, (Bundle) null);
    }

    public static boolean a(@ah Context context, @ah Intent[] intentArr, @ai Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    @ah
    public static File[] a(@ah Context context, @ai String str) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new File[]{context.getExternalFilesDir(str)};
    }

    public static int b(@ah Context context, @ah String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    @ai
    public static ColorStateList b(@ah Context context, @m int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    @ai
    public static String b(@ah Context context, @ah Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? context.getSystemServiceName(cls) : a.f411a.get(cls);
    }

    @ah
    public static File[] b(@ah Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getObbDirs() : new File[]{context.getObbDir()};
    }

    @k
    public static int c(@ah Context context, @m int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    @ah
    public static File[] c(@ah Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    @ai
    public static File d(@ah Context context) {
        return Build.VERSION.SDK_INT >= 21 ? context.getNoBackupFilesDir() : a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public static File e(@ah Context context) {
        return Build.VERSION.SDK_INT >= 21 ? context.getCodeCacheDir() : a(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    @ai
    public static Context f(@ah Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext();
        }
        return null;
    }

    public static boolean g(@ah Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static Executor h(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? context.getMainExecutor() : new b(new Handler(context.getMainLooper()));
    }
}
