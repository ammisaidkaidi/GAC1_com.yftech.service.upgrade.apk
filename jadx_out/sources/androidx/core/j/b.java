package androidx.core.j;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.annotation.ax;
import androidx.annotation.u;
import androidx.annotation.z;
import androidx.c.g;
import androidx.c.i;
import androidx.core.graphics.k;
import androidx.core.graphics.r;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static final String f457a = "font_results";

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    static final int b = -1;

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    static final int c = -2;
    static final g<String, Typeface> d = new g<>(16);
    private static final int g = 10000;
    private static final androidx.core.j.c h = new androidx.core.j.c("fonts", 10, g);
    static final Object e = new Object();

    @u(a = "sLock")
    static final i<String, ArrayList<androidx.core.j.c.a<e>>> f = new i<>();
    private static final Comparator<byte[]> i = new Comparator<byte[]>() { // from class: androidx.core.j.b.5
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return bArr[i2] - bArr2[i2];
                }
            }
            return 0;
        }
    };

    public static final class a implements BaseColumns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f471a = "file_id";
        public static final String b = "font_ttc_index";
        public static final String c = "font_variation_settings";
        public static final String d = "font_weight";
        public static final String e = "font_italic";
        public static final String f = "result_code";
        public static final int g = 0;
        public static final int h = 1;
        public static final int i = 2;
        public static final int j = 3;
    }

    /* JADX INFO: renamed from: androidx.core.j.b$b, reason: collision with other inner class name */
    public static class C0033b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f472a = 0;
        public static final int b = 1;
        public static final int c = 2;
        private final int d;
        private final c[] e;

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public C0033b(int i, @ai c[] cVarArr) {
            this.d = i;
            this.e = cVarArr;
        }

        public int a() {
            return this.d;
        }

        public c[] b() {
            return this.e;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f473a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public c(@ah Uri uri, @z(a = FabTransformationScrimBehavior.c) int i, @z(a = 1, b = 1000) int i2, boolean z, int i3) {
            this.f473a = (Uri) androidx.core.m.i.a(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        @ah
        public Uri a() {
            return this.f473a;
        }

        @z(a = FabTransformationScrimBehavior.c)
        public int b() {
            return this.b;
        }

        @z(a = 1, b = 1000)
        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public static final int f474a = 0;
        public static final int b = -1;
        public static final int c = -2;
        public static final int d = -3;
        public static final int e = -4;
        public static final int f = 1;
        public static final int g = 2;
        public static final int h = 3;

        @Retention(RetentionPolicy.SOURCE)
        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public @interface a {
        }

        public void a(int i) {
        }

        public void a(Typeface typeface) {
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f475a;
        final int b;

        e(@ai Typeface typeface, int i) {
            this.f475a = typeface;
            this.b = i;
        }
    }

    private b() {
    }

    @ai
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    @ax
    public static ProviderInfo a(@ah PackageManager packageManager, @ah androidx.core.j.a aVar, @ai Resources resources) throws PackageManager.NameNotFoundException {
        String strA = aVar.a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strA, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strA);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(aVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strA + ", but package was not " + aVar.b());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, i);
        List<List<byte[]>> listA2 = a(aVar, resources);
        for (int i2 = 0; i2 < listA2.size(); i2++) {
            ArrayList arrayList = new ArrayList(listA2.get(i2));
            Collections.sort(arrayList, i);
            if (a(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    @ai
    public static Typeface a(@ah Context context, @ai CancellationSignal cancellationSignal, @ah c[] cVarArr) {
        return k.a(context, cancellationSignal, cVarArr, 0);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Typeface a(final Context context, final androidx.core.j.a aVar, @ai final androidx.core.b.b.g.a aVar2, @ai final Handler handler, boolean z, int i2, final int i3) {
        final String str = aVar.f() + "-" + i3;
        Typeface typefaceA = d.a(str);
        if (typefaceA != null) {
            if (aVar2 != null) {
                aVar2.a(typefaceA);
            }
            return typefaceA;
        }
        if (z && i2 == -1) {
            e eVarA = a(context, aVar, i3);
            if (aVar2 != null) {
                if (eVarA.b == 0) {
                    aVar2.a(eVarA.f475a, handler);
                } else {
                    aVar2.a(eVarA.b, handler);
                }
            }
            return eVarA.f475a;
        }
        Callable<e> callable = new Callable<e>() { // from class: androidx.core.j.b.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e call() {
                e eVarA2 = b.a(context, aVar, i3);
                if (eVarA2.f475a != null) {
                    b.d.a(str, eVarA2.f475a);
                }
                return eVarA2;
            }
        };
        if (z) {
            try {
                return ((e) h.a(callable, i2)).f475a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        androidx.core.j.c.a<e> aVar3 = aVar2 == null ? null : new androidx.core.j.c.a<e>() { // from class: androidx.core.j.b.2
            @Override // androidx.core.j.c.a
            public void a(e eVar) {
                if (eVar == null) {
                    aVar2.a(1, handler);
                } else if (eVar.b == 0) {
                    aVar2.a(eVar.f475a, handler);
                } else {
                    aVar2.a(eVar.b, handler);
                }
            }
        };
        synchronized (e) {
            ArrayList<androidx.core.j.c.a<e>> arrayList = f.get(str);
            if (arrayList != null) {
                if (aVar3 != null) {
                    arrayList.add(aVar3);
                }
                return null;
            }
            if (aVar3 != null) {
                ArrayList<androidx.core.j.c.a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(aVar3);
                f.put(str, arrayList2);
            }
            h.a(callable, new androidx.core.j.c.a<e>() { // from class: androidx.core.j.b.3
                @Override // androidx.core.j.c.a
                public void a(e eVar) {
                    synchronized (b.e) {
                        ArrayList<androidx.core.j.c.a<e>> arrayList3 = b.f.get(str);
                        if (arrayList3 == null) {
                            return;
                        }
                        b.f.remove(str);
                        for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                            arrayList3.get(i4).a(eVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    @ah
    public static C0033b a(@ah Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.a aVar) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoA = a(context.getPackageManager(), aVar, context.getResources());
        return providerInfoA == null ? new C0033b(1, null) : new C0033b(0, a(context, aVar, providerInfoA.authority, cancellationSignal));
    }

    @ah
    static e a(Context context, androidx.core.j.a aVar, int i2) {
        try {
            C0033b c0033bA = a(context, (CancellationSignal) null, aVar);
            if (c0033bA.a() != 0) {
                return new e(null, c0033bA.a() == 1 ? -2 : -3);
            }
            Typeface typefaceA = k.a(context, null, c0033bA.b(), i2);
            return new e(typefaceA, typefaceA != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(null, -1);
        }
    }

    private static List<List<byte[]>> a(androidx.core.j.a aVar, Resources resources) {
        return aVar.d() != null ? aVar.d() : androidx.core.b.b.d.a(resources, aVar.e());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    @am(a = 19)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> a(Context context, c[] cVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (c cVar : cVarArr) {
            if (cVar.e() == 0) {
                Uri uriA = cVar.a();
                if (!map.containsKey(uriA)) {
                    map.put(uriA, r.a(context, cancellationSignal, uriA));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static void a() {
        d.a();
    }

    public static void a(@ah Context context, @ah androidx.core.j.a aVar, @ah d dVar, @ah Handler handler) {
        b(context.getApplicationContext(), aVar, dVar, handler);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @ah
    @ax
    static c[] a(Context context, androidx.core.j.a aVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            cursorQuery = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, new String[]{"_id", a.f471a, a.b, a.c, a.d, a.e, a.f}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, new String[]{"_id", a.f471a, a.b, a.c, a.d, a.e, a.f}, "query = ?", new String[]{aVar.c()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex(a.f);
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex(a.f471a);
                int columnIndex4 = cursorQuery.getColumnIndex(a.b);
                int columnIndex5 = cursorQuery.getColumnIndex(a.d);
                int columnIndex6 = cursorQuery.getColumnIndex(a.e);
                while (cursorQuery.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    arrayList2.add(new c(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i2));
                }
                arrayList = arrayList2;
            }
            return (c[]) arrayList.toArray(new c[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private static void b(@ah final Context context, @ah final androidx.core.j.a aVar, @ah final d dVar, @ah Handler handler) {
        final Handler handler2 = new Handler();
        handler.post(new Runnable() { // from class: androidx.core.j.b.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0033b c0033bA = b.a(context, (CancellationSignal) null, aVar);
                    if (c0033bA.a() != 0) {
                        switch (c0033bA.a()) {
                            case 1:
                                handler2.post(new Runnable() { // from class: androidx.core.j.b.4.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.a(-2);
                                    }
                                });
                                break;
                            case 2:
                                handler2.post(new Runnable() { // from class: androidx.core.j.b.4.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.a(-3);
                                    }
                                });
                                break;
                            default:
                                handler2.post(new Runnable() { // from class: androidx.core.j.b.4.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.a(-3);
                                    }
                                });
                                break;
                        }
                        return;
                    }
                    c[] cVarArrB = c0033bA.b();
                    if (cVarArrB == null || cVarArrB.length == 0) {
                        handler2.post(new Runnable() { // from class: androidx.core.j.b.4.5
                            @Override // java.lang.Runnable
                            public void run() {
                                dVar.a(1);
                            }
                        });
                        return;
                    }
                    for (c cVar : cVarArrB) {
                        if (cVar.e() != 0) {
                            final int iE = cVar.e();
                            if (iE < 0) {
                                handler2.post(new Runnable() { // from class: androidx.core.j.b.4.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.a(-3);
                                    }
                                });
                                return;
                            } else {
                                handler2.post(new Runnable() { // from class: androidx.core.j.b.4.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.a(iE);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    final Typeface typefaceA = b.a(context, (CancellationSignal) null, cVarArrB);
                    if (typefaceA == null) {
                        handler2.post(new Runnable() { // from class: androidx.core.j.b.4.8
                            @Override // java.lang.Runnable
                            public void run() {
                                dVar.a(-3);
                            }
                        });
                    } else {
                        handler2.post(new Runnable() { // from class: androidx.core.j.b.4.9
                            @Override // java.lang.Runnable
                            public void run() {
                                dVar.a(typefaceA);
                            }
                        });
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    handler2.post(new Runnable() { // from class: androidx.core.j.b.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            dVar.a(-1);
                        }
                    });
                }
            }
        });
    }
}
