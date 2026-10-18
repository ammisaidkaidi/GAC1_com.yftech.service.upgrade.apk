package androidx.core.n;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    private n() {
    }

    @SuppressLint({"NewApi"})
    public static void a(Menu menu, boolean z) {
        if (menu instanceof androidx.core.e.a.a) {
            ((androidx.core.e.a.a) menu).setGroupDividerEnabled(z);
        } else if (Build.VERSION.SDK_INT >= 28) {
            menu.setGroupDividerEnabled(z);
        }
    }

    @Deprecated
    public static void a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }
}
