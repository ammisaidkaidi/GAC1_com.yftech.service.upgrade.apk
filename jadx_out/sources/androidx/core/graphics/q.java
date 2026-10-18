package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f442a = "TypefaceCompatBaseImpl";
    private static final int b = 0;
    private ConcurrentHashMap<Long, androidx.core.b.b.d.c> c = new ConcurrentHashMap<>();

    private interface a<T> {
        boolean a(T t);

        int b(T t);
    }

    q() {
    }

    private androidx.core.b.b.d.C0027d a(androidx.core.b.b.d.c cVar, int i) {
        return (androidx.core.b.b.d.C0027d) a(cVar.a(), i, new a<androidx.core.b.b.d.C0027d>() { // from class: androidx.core.graphics.q.2
            @Override // androidx.core.graphics.q.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(androidx.core.b.b.d.C0027d c0027d) {
                return c0027d.b();
            }

            @Override // androidx.core.graphics.q.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(androidx.core.b.b.d.C0027d c0027d) {
                return c0027d.c();
            }
        });
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(aVar.b(t2) - i2) * 2) + (aVar.a(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    private void a(Typeface typeface, androidx.core.b.b.d.c cVar) {
        long jB = b(typeface);
        if (jB != 0) {
            this.c.put(Long.valueOf(jB), cVar);
        }
    }

    private static long b(@ai Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e(f442a, "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e(f442a, "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    @ai
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File fileA = r.a(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (r.a(fileA, resources, i)) {
                return Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    @ai
    public Typeface a(Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (cVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(a(cVarArr, i).a());
            try {
                Typeface typefaceA = a(context, inputStreamOpenInputStream);
                r.a(inputStreamOpenInputStream);
                return typefaceA;
            } catch (IOException unused) {
                r.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                r.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @ai
    public Typeface a(Context context, androidx.core.b.b.d.c cVar, Resources resources, int i) {
        androidx.core.b.b.d.C0027d c0027dA = a(cVar, i);
        if (c0027dA == null) {
            return null;
        }
        Typeface typefaceA = k.a(context, resources, c0027dA.f(), c0027dA.a(), i);
        a(typefaceA, cVar);
        return typefaceA;
    }

    protected Typeface a(Context context, InputStream inputStream) {
        File fileA = r.a(context);
        if (fileA == null) {
            return null;
        }
        try {
            if (r.a(fileA, inputStream)) {
                return Typeface.createFromFile(fileA.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileA.delete();
        }
    }

    @ai
    androidx.core.b.b.d.c a(Typeface typeface) {
        long jB = b(typeface);
        if (jB == 0) {
            return null;
        }
        return this.c.get(Long.valueOf(jB));
    }

    protected androidx.core.j.b.c a(androidx.core.j.b.c[] cVarArr, int i) {
        return (androidx.core.j.b.c) a(cVarArr, i, new a<androidx.core.j.b.c>() { // from class: androidx.core.graphics.q.1
            @Override // androidx.core.graphics.q.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int b(androidx.core.j.b.c cVar) {
                return cVar.c();
            }

            @Override // androidx.core.graphics.q.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean a(androidx.core.j.b.c cVar) {
                return cVar.d();
            }
        });
    }
}
