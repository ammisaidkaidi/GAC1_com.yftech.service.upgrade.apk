package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.ac;
import androidx.appcompat.widget.ax;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.x;
import androidx.core.n.af;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String d = "AppCompatViewInflater";
    private final Object[] f = new Object[2];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f80a = {Context.class, AttributeSet.class};
    private static final int[] b = {R.attr.onClick};
    private static final String[] c = {"android.widget.", "android.view.", "android.webkit."};
    private static final androidx.c.i<String, Constructor<? extends View>> e = new androidx.c.i<>();

    private static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f81a;
        private final String b;
        private Method c;
        private Context d;

        public a(@ah View view, @ah String str) {
            this.f81a = view;
            this.b = str;
        }

        private void a(@ai Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.b, View.class)) != null) {
                        this.c = method;
                        this.d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f81a.getId();
            if (id == -1) {
                str = com.yftech.service.upgrade.a.d;
            } else {
                str = " with id '" + this.f81a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f81a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@ah View view) {
            if (this.c == null) {
                a(this.f81a.getContext());
            }
            try {
                this.c.invoke(this.d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.a.m.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.a.m.View_theme, 0)) != 0) {
            Log.i(d, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            return ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).getThemeResId() == resourceId) ? context : new androidx.appcompat.view.d(context, resourceId);
        }
        return context;
    }

    private View a(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = e.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f80a);
            e.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f);
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || af.al(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f[0] = context;
            this.f[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return a(context, str, (String) null);
            }
            for (int i = 0; i < c.length; i++) {
                View viewA = a(context, str, c[i]);
                if (viewA != null) {
                    return viewA;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            this.f[0] = null;
            this.f[1] = null;
        }
    }

    @ai
    protected View a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View a(View view, String str, @ah Context context, @ah AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View viewA;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = ax.a(context2);
        }
        switch (str) {
            case "TextView":
                viewA = a(context2, attributeSet);
                a(viewA, str);
                break;
            case "ImageView":
                viewA = b(context2, attributeSet);
                a(viewA, str);
                break;
            case "Button":
                viewA = c(context2, attributeSet);
                a(viewA, str);
                break;
            case "EditText":
                viewA = d(context2, attributeSet);
                a(viewA, str);
                break;
            case "Spinner":
                viewA = e(context2, attributeSet);
                a(viewA, str);
                break;
            case "ImageButton":
                viewA = f(context2, attributeSet);
                a(viewA, str);
                break;
            case "CheckBox":
                viewA = g(context2, attributeSet);
                a(viewA, str);
                break;
            case "RadioButton":
                viewA = h(context2, attributeSet);
                a(viewA, str);
                break;
            case "CheckedTextView":
                viewA = i(context2, attributeSet);
                a(viewA, str);
                break;
            case "AutoCompleteTextView":
                viewA = j(context2, attributeSet);
                a(viewA, str);
                break;
            case "MultiAutoCompleteTextView":
                viewA = k(context2, attributeSet);
                a(viewA, str);
                break;
            case "RatingBar":
                viewA = l(context2, attributeSet);
                a(viewA, str);
                break;
            case "SeekBar":
                viewA = m(context2, attributeSet);
                a(viewA, str);
                break;
            case "ToggleButton":
                viewA = n(context2, attributeSet);
                a(viewA, str);
                break;
            default:
                viewA = a(context2, str, attributeSet);
                break;
        }
        if (viewA == null && context != context2) {
            viewA = b(context2, str, attributeSet);
        }
        if (viewA != null) {
            a(viewA, attributeSet);
        }
        return viewA;
    }

    @ah
    protected aa a(Context context, AttributeSet attributeSet) {
        return new aa(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.p b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.p(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.g c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.l d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.l(context, attributeSet);
    }

    @ah
    protected x e(Context context, AttributeSet attributeSet) {
        return new x(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.n f(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.n(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.h g(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.h(context, attributeSet);
    }

    @ah
    protected t h(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.i i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.i(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.e j(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.e(context, attributeSet);
    }

    @ah
    protected androidx.appcompat.widget.q k(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.q(context, attributeSet);
    }

    @ah
    protected u l(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @ah
    protected v m(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @ah
    protected ac n(Context context, AttributeSet attributeSet) {
        return new ac(context, attributeSet);
    }
}
