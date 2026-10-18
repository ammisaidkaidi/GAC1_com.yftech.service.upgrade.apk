package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.am;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@am(a = 16)
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f377a = "NotificationCompat";
    static final String b = "android.support.dataRemoteInputs";
    static final String c = "android.support.allowGeneratedReplies";
    private static final String d = "icon";
    private static final String e = "title";
    private static final String f = "actionIntent";
    private static final String g = "extras";
    private static final String h = "remoteInputs";
    private static final String i = "dataOnlyRemoteInputs";
    private static final String j = "resultKey";
    private static final String k = "label";
    private static final String l = "choices";
    private static final String m = "allowFreeFormInput";
    private static final String n = "allowedDataTypes";
    private static final String o = "semanticAction";
    private static final String p = "showsUserInterface";
    private static Field r;
    private static boolean s;
    private static Field u;
    private static Field v;
    private static Field w;
    private static Field x;
    private static boolean y;
    private static final Object q = new Object();
    private static final Object t = new Object();

    private s() {
    }

    public static Bundle a(Notification.Builder builder, p.a aVar) {
        IconCompat iconCompatB = aVar.b();
        builder.addAction(iconCompatB != null ? iconCompatB.c() : 0, aVar.c(), aVar.d());
        Bundle bundle = new Bundle(aVar.e());
        if (aVar.g() != null) {
            bundle.putParcelableArray(r.f, a(aVar.g()));
        }
        if (aVar.j() != null) {
            bundle.putParcelableArray(b, a(aVar.j()));
        }
        bundle.putBoolean(c, aVar.f());
        return bundle;
    }

    public static Bundle a(Notification notification) {
        synchronized (q) {
            if (s) {
                return null;
            }
            try {
                if (r == null) {
                    Field declaredField = Notification.class.getDeclaredField(g);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(f377a, "Notification.extras field is not of type Bundle");
                        s = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    r = declaredField;
                }
                Bundle bundle = (Bundle) r.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    r.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e(f377a, "Unable to access notification extras", e2);
                s = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e(f377a, "Unable to access notification extras", e3);
                s = true;
                return null;
            }
        }
    }

    static Bundle a(p.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatB = aVar.b();
        bundle.putInt(d, iconCompatB != null ? iconCompatB.c() : 0);
        bundle.putCharSequence(e, aVar.c());
        bundle.putParcelable(f, aVar.d());
        Bundle bundle2 = aVar.e() != null ? new Bundle(aVar.e()) : new Bundle();
        bundle2.putBoolean(c, aVar.f());
        bundle.putBundle(g, bundle2);
        bundle.putParcelableArray(h, a(aVar.g()));
        bundle.putBoolean(p, aVar.k());
        bundle.putInt(o, aVar.h());
        return bundle;
    }

    private static Bundle a(w wVar) {
        Bundle bundle = new Bundle();
        bundle.putString(j, wVar.a());
        bundle.putCharSequence(k, wVar.b());
        bundle.putCharSequenceArray(l, wVar.c());
        bundle.putBoolean(m, wVar.f());
        bundle.putBundle(g, wVar.h());
        Set<String> setD = wVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList(n, arrayList);
        }
        return bundle;
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    public static p.a a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        w[] wVarArrA;
        w[] wVarArrA2;
        boolean z;
        if (bundle != null) {
            wVarArrA = a(a(bundle, r.f));
            wVarArrA2 = a(a(bundle, b));
            z = bundle.getBoolean(c);
        } else {
            wVarArrA = null;
            wVarArrA2 = null;
            z = false;
        }
        return new p.a(i2, charSequence, pendingIntent, bundle, wVarArrA, wVarArrA2, z, 0, true, false);
    }

    public static p.a a(Notification notification, int i2) {
        SparseArray sparseParcelableArray;
        synchronized (t) {
            try {
                try {
                    Object[] objArrC = c(notification);
                    if (objArrC != null) {
                        Object obj = objArrC[i2];
                        Bundle bundleA = a(notification);
                        return a(v.getInt(obj), (CharSequence) w.get(obj), (PendingIntent) x.get(obj), (bundleA == null || (sparseParcelableArray = bundleA.getSparseParcelableArray(r.e)) == null) ? null : (Bundle) sparseParcelableArray.get(i2));
                    }
                } catch (IllegalAccessException e2) {
                    Log.e(f377a, "Unable to access notification actions", e2);
                    y = true;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static p.a a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(g);
        return new p.a(bundle.getInt(d), bundle.getCharSequence(e), (PendingIntent) bundle.getParcelable(f), bundle.getBundle(g), a(a(bundle, h)), a(a(bundle, i)), bundle2 != null ? bundle2.getBoolean(c, false) : false, bundle.getInt(o), bundle.getBoolean(p), false);
    }

    private static boolean a() {
        if (y) {
            return false;
        }
        try {
            if (u == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                v = cls.getDeclaredField(d);
                w = cls.getDeclaredField(e);
                x = cls.getDeclaredField(f);
                u = Notification.class.getDeclaredField("actions");
                u.setAccessible(true);
            }
        } catch (ClassNotFoundException e2) {
            Log.e(f377a, "Unable to access notification actions", e2);
            y = true;
        } catch (NoSuchFieldException e3) {
            Log.e(f377a, "Unable to access notification actions", e3);
            y = true;
        }
        return true ^ y;
    }

    private static Bundle[] a(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    private static Bundle[] a(w[] wVarArr) {
        if (wVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[wVarArr.length];
        for (int i2 = 0; i2 < wVarArr.length; i2++) {
            bundleArr[i2] = a(wVarArr[i2]);
        }
        return bundleArr;
    }

    private static w[] a(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        w[] wVarArr = new w[bundleArr.length];
        for (int i2 = 0; i2 < bundleArr.length; i2++) {
            wVarArr[i2] = b(bundleArr[i2]);
        }
        return wVarArr;
    }

    public static int b(Notification notification) {
        int length;
        synchronized (t) {
            Object[] objArrC = c(notification);
            length = objArrC != null ? objArrC.length : 0;
        }
        return length;
    }

    private static w b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(n);
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new w(bundle.getString(j), bundle.getCharSequence(k), bundle.getCharSequenceArray(l), bundle.getBoolean(m), 0, bundle.getBundle(g), hashSet);
    }

    private static Object[] c(Notification notification) {
        synchronized (t) {
            if (!a()) {
                return null;
            }
            try {
                return (Object[]) u.get(notification);
            } catch (IllegalAccessException e2) {
                Log.e(f377a, "Unable to access notification actions", e2);
                y = true;
                return null;
            }
        }
    }
}
