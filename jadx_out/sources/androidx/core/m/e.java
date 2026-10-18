package androidx.core.m;

import android.os.Build;
import androidx.annotation.ai;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private e() {
    }

    public static int a(@ai Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int a(@ai Object... objArr) {
        return Build.VERSION.SDK_INT >= 19 ? Objects.hash(objArr) : Arrays.hashCode(objArr);
    }

    public static boolean a(@ai Object obj, @ai Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
