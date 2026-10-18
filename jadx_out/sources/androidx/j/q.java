package androidx.j;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.am(a = 21)
class q implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f911a = "GhostViewApi21";
    private static Class<?> b;
    private static boolean c;
    private static Method d;
    private static boolean e;
    private static Method f;
    private static boolean g;
    private final View h;

    private q(@androidx.annotation.ah View view) {
        this.h = view;
    }

    static o a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        if (d != null) {
            try {
                return new q((View) d.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void a() {
        if (c) {
            return;
        }
        try {
            b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i(f911a, "Failed to retrieve GhostView class", e2);
        }
        c = true;
    }

    static void a(View view) {
        c();
        if (f != null) {
            try {
                f.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    private static void b() {
        if (e) {
            return;
        }
        try {
            a();
            d = b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            d.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(f911a, "Failed to retrieve addGhost method", e2);
        }
        e = true;
    }

    private static void c() {
        if (g) {
            return;
        }
        try {
            a();
            f = b.getDeclaredMethod("removeGhost", View.class);
            f.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(f911a, "Failed to retrieve removeGhost method", e2);
        }
        g = true;
    }

    @Override // androidx.j.o
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.j.o
    public void setVisibility(int i) {
        this.h.setVisibility(i);
    }
}
