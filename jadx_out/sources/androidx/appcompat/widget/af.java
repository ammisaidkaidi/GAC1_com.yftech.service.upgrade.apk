package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class af {
    private static final String d = "DrawableUtils";
    private static Class<?> e = null;
    private static final String f = "android.graphics.drawable.VectorDrawable";
    private static final int[] b = {R.attr.state_checked};
    private static final int[] c = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f201a = new Rect();

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                e = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    private af() {
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    public static Rect a(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = opticalInsets.left;
            rect.right = opticalInsets.right;
            rect.top = opticalInsets.top;
            rect.bottom = opticalInsets.bottom;
            return rect;
        }
        if (e != null) {
            try {
                Drawable drawableH = androidx.core.graphics.drawable.a.h(drawable);
                Object objInvoke = drawableH.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawableH, new Object[0]);
                if (objInvoke != null) {
                    Rect rect2 = new Rect();
                    for (Field field : e.getFields()) {
                        switch (field.getName()) {
                            case "left":
                                rect2.left = field.getInt(objInvoke);
                                break;
                            case "top":
                                rect2.top = field.getInt(objInvoke);
                                break;
                            case "right":
                                rect2.right = field.getInt(objInvoke);
                                break;
                            case "bottom":
                                rect2.bottom = field.getInt(objInvoke);
                                break;
                        }
                    }
                    return rect2;
                }
            } catch (Exception unused) {
                Log.e(d, "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f201a;
    }

    static void b(@androidx.annotation.ah Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && f.equals(drawable.getClass().getName())) {
            d(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(@androidx.annotation.ah Drawable drawable) {
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (drawable instanceof androidx.core.graphics.drawable.f) {
                return c(((androidx.core.graphics.drawable.f) drawable).a());
            }
            if (drawable instanceof androidx.appcompat.b.a.c) {
                return c(((androidx.appcompat.b.a.c) drawable).a());
            }
            if (drawable instanceof ScaleDrawable) {
                return c(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
            if (!c(drawable2)) {
                return false;
            }
        }
        return true;
    }

    private static void d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(b);
        } else {
            drawable.setState(c);
        }
        drawable.setState(state);
    }
}
