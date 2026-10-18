package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.core.n.af;
import androidx.core.n.ao;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class z {

    public interface a {
        ao a(View view, ao aoVar, b bVar);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1359a;
        public int b;
        public int c;
        public int d;

        public b(int i, int i2, int i3, int i4) {
            this.f1359a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public b(@ah b bVar) {
            this.f1359a = bVar.f1359a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
        }

        public void a(View view) {
            af.b(view, this.f1359a, this.b, this.c, this.d);
        }
    }

    private z() {
    }

    public static float a(@ah Context context, @androidx.annotation.p(a = 0) int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void a(@ah View view, @ai AttributeSet attributeSet, int i, int i2) {
        a(view, attributeSet, i, i2, null);
    }

    public static void a(@ah View view, @ai AttributeSet attributeSet, int i, int i2, @ai final a aVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.a.o.Insets, i, i2);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.a.o.Insets_paddingBottomSystemWindowInsets, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.a.o.Insets_paddingLeftSystemWindowInsets, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(com.google.android.material.a.o.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        a(view, new a() { // from class: com.google.android.material.internal.z.2
            @Override // com.google.android.material.internal.z.a
            @ah
            public ao a(View view2, @ah ao aoVar, @ah b bVar) {
                if (z) {
                    bVar.d += aoVar.d();
                }
                boolean zA = z.a(view2);
                if (z2) {
                    if (zA) {
                        bVar.c += aoVar.a();
                    } else {
                        bVar.f1359a += aoVar.a();
                    }
                }
                if (z3) {
                    if (zA) {
                        bVar.f1359a += aoVar.c();
                    } else {
                        bVar.c += aoVar.c();
                    }
                }
                bVar.a(view2);
                return aVar != null ? aVar.a(view2, aoVar, bVar) : aoVar;
            }
        });
    }

    public static void a(@ah View view, @ah final a aVar) {
        final b bVar = new b(af.w(view), view.getPaddingTop(), af.x(view), view.getPaddingBottom());
        af.a(view, new androidx.core.n.y() { // from class: com.google.android.material.internal.z.3
            @Override // androidx.core.n.y
            public ao a(View view2, ao aoVar) {
                return aVar.a(view2, aoVar, new b(bVar));
            }
        });
        c(view);
    }

    public static boolean a(View view) {
        return af.p(view) == 1;
    }

    public static void b(@ah final View view) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.z.1
            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static void c(@ah View view) {
        if (af.ak(view)) {
            af.T(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.z.4
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@ah View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    af.T(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static float d(@ah View view) {
        float fP = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fP += af.P((View) parent);
        }
        return fP;
    }

    @ai
    public static y e(@ai View view) {
        if (view == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 18 ? new x(view) : w.c(view);
    }

    @ai
    public static ViewGroup f(@ai View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @ai
    public static y g(@ah View view) {
        return e(f(view));
    }
}
