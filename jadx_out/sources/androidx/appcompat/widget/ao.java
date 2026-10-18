package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public final class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f223a = "ResourceManagerInternal";
    private static final boolean b = false;
    private static final String d = "appcompat_skip_skip";
    private static final String e = "android.graphics.drawable.VectorDrawable";
    private static ao f;
    private WeakHashMap<Context, androidx.c.j<ColorStateList>> h;
    private androidx.c.i<String, d> i;
    private androidx.c.j<String> j;
    private final WeakHashMap<Context, androidx.c.f<WeakReference<Drawable.ConstantState>>> k = new WeakHashMap<>(0);
    private TypedValue l;
    private boolean m;
    private e n;
    private static final PorterDuff.Mode c = PorterDuff.Mode.SRC_IN;
    private static final c g = new c(6);

    @androidx.annotation.am(a = 11)
    static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.ao.d
        public Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah XmlPullParser xmlPullParser, @androidx.annotation.ah AttributeSet attributeSet, @androidx.annotation.ai Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    private static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.ao.d
        public Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah XmlPullParser xmlPullParser, @androidx.annotation.ah AttributeSet attributeSet, @androidx.annotation.ai Resources.Theme theme) {
            try {
                return androidx.k.b.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class c extends androidx.c.g<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    private interface d {
        Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah XmlPullParser xmlPullParser, @androidx.annotation.ah AttributeSet attributeSet, @androidx.annotation.ai Resources.Theme theme);
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    interface e {
        ColorStateList a(@androidx.annotation.ah Context context, @androidx.annotation.q int i);

        PorterDuff.Mode a(int i);

        Drawable a(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah Context context, @androidx.annotation.q int i);

        boolean a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, @androidx.annotation.ah Drawable drawable);

        boolean b(@androidx.annotation.ah Context context, @androidx.annotation.q int i, @androidx.annotation.ah Drawable drawable);
    }

    private static class f implements d {
        f() {
        }

        @Override // androidx.appcompat.widget.ao.d
        public Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah XmlPullParser xmlPullParser, @androidx.annotation.ah AttributeSet attributeSet, @androidx.annotation.ai Resources.Theme theme) {
            try {
                return androidx.k.b.a.i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        porterDuffColorFilterA = g.a(i, mode);
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i, mode);
            g.a(i, mode, porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, boolean z, @androidx.annotation.ah Drawable drawable) {
        ColorStateList colorStateListB = b(context, i);
        if (colorStateListB == null) {
            if ((this.n == null || !this.n.a(context, i, drawable)) && !a(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (af.c(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableG = androidx.core.graphics.drawable.a.g(drawable);
        androidx.core.graphics.drawable.a.a(drawableG, colorStateListB);
        PorterDuff.Mode modeA = a(i);
        if (modeA == null) {
            return drawableG;
        }
        androidx.core.graphics.drawable.a.a(drawableG, modeA);
        return drawableG;
    }

    private synchronized Drawable a(@androidx.annotation.ah Context context, long j) {
        androidx.c.f<WeakReference<Drawable.ConstantState>> fVar = this.k.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceA = fVar.a(j);
        if (weakReferenceA != null) {
            Drawable.ConstantState constantState = weakReferenceA.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.c(j);
        }
        return null;
    }

    public static synchronized ao a() {
        if (f == null) {
            f = new ao();
            a(f);
        }
        return f;
    }

    private void a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, @androidx.annotation.ah ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new WeakHashMap<>();
        }
        androidx.c.j<ColorStateList> jVar = this.h.get(context);
        if (jVar == null) {
            jVar = new androidx.c.j<>();
            this.h.put(context, jVar);
        }
        jVar.g(i, colorStateList);
    }

    static void a(Drawable drawable, ay ayVar, int[] iArr) {
        if (af.c(drawable) && drawable.mutate() != drawable) {
            Log.d(f223a, "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (ayVar.d || ayVar.c) {
            drawable.setColorFilter(a(ayVar.d ? ayVar.f241a : null, ayVar.c ? ayVar.b : c, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static void a(@androidx.annotation.ah ao aoVar) {
        if (Build.VERSION.SDK_INT < 24) {
            aoVar.a("vector", new f());
            aoVar.a("animated-vector", new b());
            aoVar.a("animated-selector", new a());
        }
    }

    private void a(@androidx.annotation.ah String str, @androidx.annotation.ah d dVar) {
        if (this.i == null) {
            this.i = new androidx.c.i<>();
        }
        this.i.put(str, dVar);
    }

    private synchronized boolean a(@androidx.annotation.ah Context context, long j, @androidx.annotation.ah Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.c.f<WeakReference<Drawable.ConstantState>> fVar = this.k.get(context);
        if (fVar == null) {
            fVar = new androidx.c.f<>();
            this.k.put(context, fVar);
        }
        fVar.d(j, new WeakReference<>(constantState));
        return true;
    }

    private static boolean a(@androidx.annotation.ah Drawable drawable) {
        return (drawable instanceof androidx.k.b.a.i) || e.equals(drawable.getClass().getName());
    }

    private void b(@androidx.annotation.ah Context context) {
        if (this.m) {
            return;
        }
        this.m = true;
        Drawable drawableA = a(context, androidx.appcompat.c.a.d.abc_vector_test);
        if (drawableA == null || !a(drawableA)) {
            this.m = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private Drawable c(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        if (this.l == null) {
            this.l = new TypedValue();
        }
        TypedValue typedValue = this.l;
        context.getResources().getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        Drawable drawableA2 = this.n == null ? null : this.n.a(this, context, i);
        if (drawableA2 != null) {
            drawableA2.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jA, drawableA2);
        }
        return drawableA2;
    }

    private Drawable d(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        int next;
        if (this.i == null || this.i.isEmpty()) {
            return null;
        }
        if (this.j != null) {
            String strA = this.j.a(i);
            if (d.equals(strA) || (strA != null && this.i.get(strA) == null)) {
                return null;
            }
        } else {
            this.j = new androidx.c.j<>();
        }
        if (this.l == null) {
            this.l = new TypedValue();
        }
        TypedValue typedValue = this.l;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.j.g(i, name);
                d dVar = this.i.get(name);
                if (dVar != null) {
                    drawableA = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jA, drawableA);
                }
            } catch (Exception e2) {
                Log.e(f223a, "Exception while inflating drawable", e2);
            }
        }
        if (drawableA == null) {
            this.j.g(i, d);
        }
        return drawableA;
    }

    private ColorStateList e(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        androidx.c.j<ColorStateList> jVar;
        if (this.h == null || (jVar = this.h.get(context)) == null) {
            return null;
        }
        return jVar.a(i);
    }

    PorterDuff.Mode a(int i) {
        if (this.n == null) {
            return null;
        }
        return this.n.a(i);
    }

    public synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        return a(context, i, false);
    }

    synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, boolean z) {
        Drawable drawableD;
        b(context);
        drawableD = d(context, i);
        if (drawableD == null) {
            drawableD = c(context, i);
        }
        if (drawableD == null) {
            drawableD = androidx.core.b.c.a(context, i);
        }
        if (drawableD != null) {
            drawableD = a(context, i, z, drawableD);
        }
        if (drawableD != null) {
            af.b(drawableD);
        }
        return drawableD;
    }

    synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah bf bfVar, @androidx.annotation.q int i) {
        Drawable drawableD = d(context, i);
        if (drawableD == null) {
            drawableD = bfVar.a(i);
        }
        if (drawableD == null) {
            return null;
        }
        return a(context, i, false, drawableD);
    }

    public synchronized void a(@androidx.annotation.ah Context context) {
        androidx.c.f<WeakReference<Drawable.ConstantState>> fVar = this.k.get(context);
        if (fVar != null) {
            fVar.d();
        }
    }

    public synchronized void a(e eVar) {
        this.n = eVar;
    }

    boolean a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, @androidx.annotation.ah Drawable drawable) {
        return this.n != null && this.n.b(context, i, drawable);
    }

    synchronized ColorStateList b(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        ColorStateList colorStateListE;
        colorStateListE = e(context, i);
        if (colorStateListE == null) {
            colorStateListE = this.n == null ? null : this.n.a(context, i);
            if (colorStateListE != null) {
                a(context, i, colorStateListE);
            }
        }
        return colorStateListE;
    }
}
