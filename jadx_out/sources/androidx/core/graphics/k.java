package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q f438a;
    private static final androidx.c.g<String, Typeface> b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f438a = new p();
        } else if (Build.VERSION.SDK_INT >= 28) {
            f438a = new o();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f438a = new n();
        } else if (Build.VERSION.SDK_INT >= 24 && m.a()) {
            f438a = new m();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f438a = new l();
        } else {
            f438a = new q();
        }
        b = new androidx.c.g<>(16);
    }

    private k() {
    }

    @ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Typeface a(@ah Context context, @ah Resources resources, int i, String str, int i2) {
        Typeface typefaceA = f438a.a(context, resources, i, str, i2);
        if (typefaceA != null) {
            b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    @ah
    public static Typeface a(@ah Context context, @ai Typeface typeface, int i) {
        Typeface typefaceB;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceB = b(context, typeface, i)) == null) ? Typeface.create(typeface, i) : typefaceB;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Typeface a(@ah Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i) {
        return f438a.a(context, cancellationSignal, cVarArr, i);
    }

    @ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Typeface a(@ah Context context, @ah androidx.core.b.b.d.a aVar, @ah Resources resources, int i, int i2, @ai androidx.core.b.b.g.a aVar2, @ai Handler handler, boolean z) {
        Typeface typefaceA;
        if (aVar instanceof androidx.core.b.b.d.e) {
            androidx.core.b.b.d.e eVar = (androidx.core.b.b.d.e) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : eVar.b() == 0) {
                z2 = true;
            }
            typefaceA = androidx.core.j.b.a(context, eVar.a(), aVar2, handler, z2, z ? eVar.c() : -1, i2);
        } else {
            typefaceA = f438a.a(context, (androidx.core.b.b.d.c) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceA != null) {
                    aVar2.a(typefaceA, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    @ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Typeface a(@ah Resources resources, int i, int i2) {
        return b.a(b(resources, i, i2));
    }

    @ai
    private static Typeface b(Context context, Typeface typeface, int i) {
        androidx.core.b.b.d.c cVarA = f438a.a(typeface);
        if (cVarA == null) {
            return null;
        }
        return f438a.a(context, cVarA, context.getResources(), i);
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
