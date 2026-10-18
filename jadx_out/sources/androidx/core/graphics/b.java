package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private b() {
    }

    @ai
    public static ColorFilter a(int i, @ah c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode blendModeA = d.a(cVar);
            if (blendModeA != null) {
                return new BlendModeColorFilter(i, blendModeA);
            }
            return null;
        }
        PorterDuff.Mode modeB = d.b(cVar);
        if (modeB != null) {
            return new PorterDuffColorFilter(i, modeB);
        }
        return null;
    }
}
