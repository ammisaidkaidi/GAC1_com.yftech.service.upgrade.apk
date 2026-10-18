package androidx.core.m;

import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.z;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public final class i {
    private i() {
    }

    @z(a = FabTransformationScrimBehavior.c)
    public static int a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static int a(int i, int i2, int i3, @ah String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i <= i3) {
            return i;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    @z(a = FabTransformationScrimBehavior.c)
    public static int a(int i, @ai String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    @ah
    public static <T> T a(@ai T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @ah
    public static <T> T a(@ai T t, @ah Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(boolean z, @ah Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, @ai String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void b(boolean z) {
        a(z, (String) null);
    }
}
