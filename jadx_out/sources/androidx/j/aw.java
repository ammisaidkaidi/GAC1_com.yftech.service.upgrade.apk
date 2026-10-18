package androidx.j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.am(a = 18)
class aw implements ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f867a;

    aw(@androidx.annotation.ah View view) {
        this.f867a = view.getOverlay();
    }

    @Override // androidx.j.ax
    public void a(@androidx.annotation.ah Drawable drawable) {
        this.f867a.add(drawable);
    }

    @Override // androidx.j.ax
    public void b(@androidx.annotation.ah Drawable drawable) {
        this.f867a.remove(drawable);
    }
}
