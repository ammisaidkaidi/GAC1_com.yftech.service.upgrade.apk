package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@am(a = 21)
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
class l extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f439a = "TypefaceCompatApi21Impl";
    private static final String b = "android.graphics.FontFamily";
    private static final String c = "addFontWeightStyle";
    private static final String d = "createFromFamiliesWithDefault";
    private static Class<?> e = null;
    private static Constructor<?> f = null;
    private static Method g = null;
    private static Method h = null;
    private static boolean i = false;

    l() {
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object objNewInstance = Array.newInstance(e, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) h.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File a(@ah ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
            return null;
        } catch (ErrnoException unused) {
            return null;
        }
    }

    private static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (i) {
            return;
        }
        i = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName(b);
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod(c, String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod(d, Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(f439a, e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f = constructor;
        e = cls;
        g = method2;
        h = method;
    }

    private static boolean a(Object obj, String str, int i2, boolean z) {
        a();
        try {
            return ((Boolean) g.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object b() {
        a();
        try {
            return f.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.core.graphics.q
    public Typeface a(Context context, CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i2) {
        if (cVarArr.length < 1) {
            return null;
        }
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
                File fileA = a(parcelFileDescriptorOpenFileDescriptor);
                if (fileA != null && fileA.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileA);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceA = super.a(context, fileInputStream);
                    fileInputStream.close();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceA;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.q
    public Typeface a(Context context, androidx.core.b.b.d.c cVar, Resources resources, int i2) {
        Object objB = b();
        for (androidx.core.b.b.d.C0027d c0027d : cVar.a()) {
            File fileA = r.a(context);
            if (fileA == null) {
                return null;
            }
            try {
                if (!r.a(fileA, resources, c0027d.f())) {
                    return null;
                }
                if (!a(objB, fileA.getPath(), c0027d.b(), c0027d.c())) {
                    return null;
                }
                fileA.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileA.delete();
            }
        }
        return a(objB);
    }
}
