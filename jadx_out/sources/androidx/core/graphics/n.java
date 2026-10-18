package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@am(a = 26)
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class n extends l {
    private static final String h = "TypefaceCompatApi26Impl";
    private static final String i = "android.graphics.FontFamily";
    private static final String j = "addFontFromAssetManager";
    private static final String k = "addFontFromBuffer";
    private static final String l = "createFromFamiliesWithDefault";
    private static final String m = "freeze";
    private static final String n = "abortCreation";
    private static final int o = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f441a;
    protected final Constructor<?> b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public n() {
        Constructor<?> constructorA;
        Method methodB;
        Method methodC;
        Method methodD;
        Method methodE;
        Method methodF;
        Class<?> cls = null;
        try {
            Class<?> clsA = a();
            constructorA = a(clsA);
            methodB = b(clsA);
            methodC = c(clsA);
            methodD = d(clsA);
            methodE = e(clsA);
            methodF = f(clsA);
            cls = clsA;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(h, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            constructorA = null;
            methodB = null;
            methodC = null;
            methodD = null;
            methodE = null;
            methodF = null;
        }
        this.f441a = cls;
        this.b = constructorA;
        this.c = methodB;
        this.d = methodC;
        this.e = methodD;
        this.f = methodE;
        this.g = methodF;
    }

    private boolean a(Context context, Object obj, String str, int i2, int i3, int i4, @ai FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean b() {
        if (this.c == null) {
            Log.w(h, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    @ai
    private Object c() {
        try {
            return this.b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void c(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!b()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object objC = c();
        if (objC == null) {
            return null;
        }
        if (!a(context, objC, str, 0, -1, -1, null)) {
            c(objC);
            return null;
        }
        if (b(objC)) {
            return a(objC);
        }
        return null;
    }

    @Override // androidx.core.graphics.l, androidx.core.graphics.q
    @ai
    public Typeface a(Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i2) {
        Typeface typefaceA;
        if (cVarArr.length < 1) {
            return null;
        }
        if (!b()) {
            androidx.core.j.b.c cVarA = a(cVarArr, i2);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(cVarA.a(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(cVarA.c()).setItalic(cVarA.d()).build();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceBuild;
                } catch (Throwable th) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapA = androidx.core.j.b.a(context, cVarArr, cancellationSignal);
        Object objC = c();
        if (objC == null) {
            return null;
        }
        boolean z = false;
        for (androidx.core.j.b.c cVar : cVarArr) {
            ByteBuffer byteBuffer = mapA.get(cVar.a());
            if (byteBuffer != null) {
                if (!a(objC, byteBuffer, cVar.b(), cVar.c(), cVar.d() ? 1 : 0)) {
                    c(objC);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            c(objC);
            return null;
        }
        if (b(objC) && (typefaceA = a(objC)) != null) {
            return Typeface.create(typefaceA, i2);
        }
        return null;
    }

    @Override // androidx.core.graphics.l, androidx.core.graphics.q
    @ai
    public Typeface a(Context context, androidx.core.b.b.d.c cVar, Resources resources, int i2) {
        if (!b()) {
            return super.a(context, cVar, resources, i2);
        }
        Object objC = c();
        if (objC == null) {
            return null;
        }
        for (androidx.core.b.b.d.C0027d c0027d : cVar.a()) {
            if (!a(context, objC, c0027d.a(), c0027d.e(), c0027d.b(), c0027d.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0027d.d()))) {
                c(objC);
                return null;
            }
        }
        if (b(objC)) {
            return a(objC);
        }
        return null;
    }

    @ai
    protected Typeface a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f441a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Class<?> a() {
        return Class.forName(i);
    }

    protected Constructor<?> a(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class<?> cls) {
        return cls.getMethod(j, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method c(Class<?> cls) {
        return cls.getMethod(k, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method d(Class<?> cls) {
        return cls.getMethod(m, new Class[0]);
    }

    protected Method e(Class<?> cls) {
        return cls.getMethod(n, new Class[0]);
    }

    protected Method f(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod(l, Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
