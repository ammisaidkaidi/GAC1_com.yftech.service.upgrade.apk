package androidx.core.n;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f548a = 3840;
    private static final int b = 2160;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Display.Mode f549a;
        private final Point b;
        private final boolean c;

        a(@androidx.annotation.ah Point point) {
            androidx.core.m.i.a(point, "physicalDisplaySize == null");
            this.c = true;
            this.b = point;
            this.f549a = null;
        }

        @androidx.annotation.am(a = 23)
        a(@androidx.annotation.ah Display.Mode mode, boolean z) {
            androidx.core.m.i.a(mode, "Display.Mode == null, can't wrap a null reference");
            this.c = z;
            this.b = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.f549a = mode;
        }

        public int a() {
            return this.b.x;
        }

        public int b() {
            return this.b.y;
        }

        @androidx.annotation.ai
        @androidx.annotation.am(a = 23)
        public Display.Mode c() {
            return this.f549a;
        }

        public boolean d() {
            return this.c;
        }
    }

    private c() {
    }

    private static Point a(@androidx.annotation.ah String str) {
        String[] strArrSplit = str.trim().split("x", -1);
        if (strArrSplit.length == 2) {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            if (i > 0 && i2 > 0) {
                return new Point(i, i2);
            }
        }
        throw new NumberFormatException();
    }

    @androidx.annotation.ai
    private static Point a(@androidx.annotation.ah String str, @androidx.annotation.ah Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            return a(strB);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean a(@androidx.annotation.ah Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    @androidx.annotation.am(a = 23)
    private static boolean a(Display.Mode mode, Point point) {
        return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
    }

    @SuppressLint({"ArrayReturn"})
    @androidx.annotation.ah
    public static a[] a(@androidx.annotation.ah Context context, @androidx.annotation.ah Display display) {
        Point pointB = b(context, display);
        if (Build.VERSION.SDK_INT < 23) {
            return new a[]{new a(pointB)};
        }
        Display.Mode[] supportedModes = display.getSupportedModes();
        ArrayList arrayList = new ArrayList(supportedModes.length);
        boolean z = false;
        for (int i = 0; i < supportedModes.length; i++) {
            if (a(supportedModes[i], pointB)) {
                arrayList.add(i, new a(supportedModes[i], true));
                z = true;
            } else {
                arrayList.add(i, new a(supportedModes[i], false));
            }
        }
        if (!z) {
            arrayList.add(new a(pointB));
        }
        return (a[]) arrayList.toArray(new a[0]);
    }

    private static Point b(@androidx.annotation.ah Context context, @androidx.annotation.ah Display display) {
        Point pointA = Build.VERSION.SDK_INT < 28 ? a("sys.display-size", display) : a("vendor.display-size", display);
        if (pointA != null) {
            return pointA;
        }
        if (b(context)) {
            return new Point(f548a, b);
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
        } else if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        return point;
    }

    @androidx.annotation.ai
    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean b(@androidx.annotation.ah Context context) {
        return a(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }
}
