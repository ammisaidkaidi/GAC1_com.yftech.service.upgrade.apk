package androidx.core.n;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f558a;

    private e(Object obj) {
        this.f558a = obj;
    }

    @androidx.annotation.ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static e a(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions dragAndDropPermissionsRequestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT < 24 || (dragAndDropPermissionsRequestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent)) == null) {
            return null;
        }
        return new e(dragAndDropPermissionsRequestDragAndDropPermissions);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            ((DragAndDropPermissions) this.f558a).release();
        }
    }
}
