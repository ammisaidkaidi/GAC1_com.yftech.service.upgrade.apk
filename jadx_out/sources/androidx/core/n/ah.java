package androidx.core.n;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f533a = 0;
    public static final int b = 1;

    private ah() {
    }

    public static int a(@androidx.annotation.ah ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return viewGroup.getLayoutMode();
        }
        return 0;
    }

    public static void a(@androidx.annotation.ah ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            viewGroup.setLayoutMode(i);
        }
    }

    @Deprecated
    public static void a(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    @Deprecated
    public static boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void b(@androidx.annotation.ah ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            viewGroup.setTransitionGroup(z);
        } else {
            viewGroup.setTag(androidx.core.a.e.tag_transition_group, Boolean.valueOf(z));
        }
    }

    public static boolean b(@androidx.annotation.ah ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(androidx.core.a.e.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && af.R(viewGroup) == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(@androidx.annotation.ah ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.getNestedScrollAxes();
        }
        if (viewGroup instanceof u) {
            return ((u) viewGroup).getNestedScrollAxes();
        }
        return 0;
    }
}
