package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private k() {
    }

    @ah
    public static View a(@ah Dialog dialog, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return dialog.requireViewById(i);
        }
        View viewFindViewById = dialog.findViewById(i);
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }
}
