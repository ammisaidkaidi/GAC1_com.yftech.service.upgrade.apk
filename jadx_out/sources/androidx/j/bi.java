package androidx.j;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.am(a = 18)
class bi implements bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowId f881a;

    bi(@androidx.annotation.ah View view) {
        this.f881a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof bi) && ((bi) obj).f881a.equals(this.f881a);
    }

    public int hashCode() {
        return this.f881a.hashCode();
    }
}
