package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
    }

    public static void a(@ah Bitmap bitmap, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            bitmap.setHasMipMap(z);
        }
    }

    public static boolean a(@ah Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bitmap.hasMipMap();
        }
        return false;
    }

    public static int b(@ah Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 19 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
    }
}
