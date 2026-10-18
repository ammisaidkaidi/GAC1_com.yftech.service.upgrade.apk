package androidx.j;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f864a = "ViewGroupUtilsApi14";
    private static final int b = 4;
    private static LayoutTransition c;
    private static Field d;
    private static boolean e;
    private static Method f;
    private static boolean g;

    private au() {
    }

    private static void a(LayoutTransition layoutTransition) {
        if (!g) {
            try {
                f = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(f864a, "Failed to access cancel method by reflection");
            }
            g = true;
        }
        if (f != null) {
            try {
                f.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(f864a, "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i(f864a, "Failed to invoke cancel method by reflection");
            }
        }
    }

    static void a(@androidx.annotation.ah ViewGroup viewGroup, boolean z) {
        boolean z2 = false;
        if (c == null) {
            c = new LayoutTransition() { // from class: androidx.j.au.1
                @Override // android.animation.LayoutTransition
                public boolean isChangingLayout() {
                    return true;
                }
            };
            c.setAnimator(2, null);
            c.setAnimator(0, null);
            c.setAnimator(1, null);
            c.setAnimator(3, null);
            c.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != c) {
                    viewGroup.setTag(aa.e.transition_layout_save, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(c);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!e) {
            try {
                d = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(f864a, "Failed to access mLayoutSuppressed field by reflection");
            }
            e = true;
        }
        if (d != null) {
            try {
                boolean z3 = d.getBoolean(viewGroup);
                if (z3) {
                    try {
                        d.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                        Log.i(f864a, "Failed to get mLayoutSuppressed field by reflection");
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        LayoutTransition layoutTransition2 = (LayoutTransition) viewGroup.getTag(aa.e.transition_layout_save);
        if (layoutTransition2 != null) {
            viewGroup.setTag(aa.e.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition2);
        }
    }
}
