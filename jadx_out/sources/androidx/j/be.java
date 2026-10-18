package androidx.j;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f874a = "ViewUtilsBase";
    private static Method b = null;
    private static boolean c = false;
    private static Field d = null;
    private static boolean e = false;
    private static final int f = 12;
    private float[] g;

    be() {
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (c) {
            return;
        }
        try {
            b = View.class.getDeclaredMethod("setFrame", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            b.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(f874a, "Failed to retrieve setFrame method", e2);
        }
        c = true;
    }

    public float a(@androidx.annotation.ah View view) {
        Float f2 = (Float) view.getTag(aa.e.save_non_transition_alpha);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public void a(@androidx.annotation.ah View view, float f2) {
        Float f3 = (Float) view.getTag(aa.e.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public void a(@androidx.annotation.ah View view, int i) {
        if (!e) {
            try {
                d = View.class.getDeclaredField("mViewFlags");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(f874a, "fetchViewFlagsField: ");
            }
            e = true;
        }
        if (d != null) {
            try {
                d.setInt(view, (d.getInt(view) & (-13)) | i);
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void a(@androidx.annotation.ah View view, int i, int i2, int i3, int i4) {
        a();
        if (b != null) {
            try {
                b.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void a(@androidx.annotation.ah View view, @androidx.annotation.ah Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void b(@androidx.annotation.ah View view) {
        if (view.getTag(aa.e.save_non_transition_alpha) == null) {
            view.setTag(aa.e.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void b(@androidx.annotation.ah View view, @androidx.annotation.ah Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void c(@androidx.annotation.ah View view) {
        if (view.getVisibility() == 0) {
            view.setTag(aa.e.save_non_transition_alpha, null);
        }
    }

    public void c(@androidx.annotation.ah View view, @androidx.annotation.ai Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.g;
        if (fArr == null) {
            fArr = new float[9];
            this.g = fArr;
        }
        matrix.getValues(fArr);
        float f2 = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f2 * f2))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f2, fSqrt));
        float f3 = fArr[0] / fSqrt;
        float f4 = fArr[4] / fSqrt;
        float f5 = fArr[2];
        float f6 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        view.setRotation(degrees);
        view.setScaleX(f3);
        view.setScaleY(f4);
    }
}
