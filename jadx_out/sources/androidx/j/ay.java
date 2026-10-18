package androidx.j;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Property<View, Float> f868a;
    static final Property<View, Rect> b;
    private static final be c;
    private static final String d = "ViewUtils";

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            c = new bd();
        } else if (Build.VERSION.SDK_INT >= 23) {
            c = new bc();
        } else if (Build.VERSION.SDK_INT >= 22) {
            c = new bb();
        } else if (Build.VERSION.SDK_INT >= 21) {
            c = new ba();
        } else if (Build.VERSION.SDK_INT >= 19) {
            c = new az();
        } else {
            c = new be();
        }
        f868a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.j.ay.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ay.c(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f) {
                ay.a(view, f.floatValue());
            }
        };
        b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.j.ay.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return androidx.core.n.af.aj(view);
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                androidx.core.n.af.a(view, rect);
            }
        };
    }

    private ay() {
    }

    static ax a(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 18 ? new aw(view) : av.d(view);
    }

    static void a(@androidx.annotation.ah View view, float f) {
        c.a(view, f);
    }

    static void a(@androidx.annotation.ah View view, int i) {
        c.a(view, i);
    }

    static void a(@androidx.annotation.ah View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }

    static void a(@androidx.annotation.ah View view, @androidx.annotation.ah Matrix matrix) {
        c.a(view, matrix);
    }

    static bj b(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 18 ? new bi(view) : new bh(view.getWindowToken());
    }

    static void b(@androidx.annotation.ah View view, @androidx.annotation.ah Matrix matrix) {
        c.b(view, matrix);
    }

    static float c(@androidx.annotation.ah View view) {
        return c.a(view);
    }

    static void c(@androidx.annotation.ah View view, @androidx.annotation.ai Matrix matrix) {
        c.c(view, matrix);
    }

    static void d(@androidx.annotation.ah View view) {
        c.b(view);
    }

    static void e(@androidx.annotation.ah View view) {
        c.c(view);
    }
}
