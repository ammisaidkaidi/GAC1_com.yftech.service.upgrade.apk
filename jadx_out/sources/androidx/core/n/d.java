package androidx.core.n;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f557a;

    public d(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
    }

    private d(Object obj) {
        this.f557a = obj;
    }

    static d a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f557a).getSafeInsetTop();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f557a).getSafeInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f557a).getSafeInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f557a).getSafeInsetRight();
        }
        return 0;
    }

    public List<Rect> e() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f557a).getBoundingRects();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f557a == null) {
            return dVar.f557a == null;
        }
        return this.f557a.equals(dVar.f557a);
    }

    @androidx.annotation.am(b = 28)
    DisplayCutout f() {
        return (DisplayCutout) this.f557a;
    }

    public int hashCode() {
        if (this.f557a == null) {
            return 0;
        }
        return this.f557a.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f557a + "}";
    }
}
