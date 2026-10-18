package androidx.core.n;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f532a = "ViewConfigCompat";
    private static Method b;

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                b = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
                Log.i(f532a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private ag() {
    }

    public static float a(@androidx.annotation.ah ViewConfiguration viewConfiguration, @androidx.annotation.ah Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : d(viewConfiguration, context);
    }

    @Deprecated
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float b(@androidx.annotation.ah ViewConfiguration viewConfiguration, @androidx.annotation.ah Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : d(viewConfiguration, context);
    }

    @Deprecated
    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static int c(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static boolean c(ViewConfiguration viewConfiguration, @androidx.annotation.ah Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return identifier != 0 && resources.getBoolean(identifier);
    }

    private static float d(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 25 && b != null) {
            try {
                return ((Integer) b.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i(f532a, "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }
}
