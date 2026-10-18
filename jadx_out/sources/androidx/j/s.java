package androidx.j;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class s {
    private s() {
    }

    @androidx.annotation.ai
    static o a(@androidx.annotation.ah View view, @androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ai Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? q.a(view, viewGroup, matrix) : r.b(view, viewGroup, matrix);
    }

    static void a(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            q.a(view);
        } else {
            r.b(view);
        }
    }
}
