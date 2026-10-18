package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@am(a = 24)
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
class m extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f440a = "TypefaceCompatApi24Impl";
    private static final String b = "android.graphics.FontFamily";
    private static final String c = "addFontWeightStyle";
    private static final String d = "createFromFamiliesWithDefault";
    private static final Class<?> e;
    private static final Constructor<?> f;
    private static final Method g;
    private static final Method h;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName(b);
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod(c, ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod(d, Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(f440a, e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f = constructor;
        e = cls;
        g = method2;
        h = method;
    }

    m() {
    }

    private static Typeface a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(e, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) h.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean a() {
        if (g == null) {
            Log.w(f440a, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return g != null;
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) g.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Object b() {
        try {
            return f.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i) {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        androidx.c.i iVar = new androidx.c.i();
        for (androidx.core.j.b.c cVar : cVarArr) {
            Uri uriA = cVar.a();
            ByteBuffer byteBufferA = (ByteBuffer) iVar.get(uriA);
            if (byteBufferA == null) {
                byteBufferA = r.a(context, cancellationSignal, uriA);
                iVar.put(uriA, byteBufferA);
            }
            if (byteBufferA == null || !a(objB, byteBufferA, cVar.b(), cVar.c(), cVar.d())) {
                return null;
            }
        }
        Typeface typefaceA = a(objB);
        if (typefaceA == null) {
            return null;
        }
        return Typeface.create(typefaceA, i);
    }

    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, androidx.core.b.b.d.c cVar, Resources resources, int i) {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        for (androidx.core.b.b.d.C0027d c0027d : cVar.a()) {
            ByteBuffer byteBufferA = r.a(context, resources, c0027d.f());
            if (byteBufferA == null || !a(objB, byteBufferA, c0027d.e(), c0027d.b(), c0027d.c())) {
                return null;
            }
        }
        return a(objB);
    }
}
