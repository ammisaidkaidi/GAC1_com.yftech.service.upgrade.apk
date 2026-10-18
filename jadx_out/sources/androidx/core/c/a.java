package androidx.core.c;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private a() {
    }

    @ah
    public static CursorWindow a(@ai String str, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CursorWindow(str, j);
        }
        return Build.VERSION.SDK_INT >= 15 ? new CursorWindow(str) : new CursorWindow(false);
    }
}
