package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.z;
import androidx.core.n.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f788a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    private static final v b;
    private static final v c;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f793a;
        public boolean b;
        public androidx.fragment.app.a c;
        public d d;
        public boolean e;
        public androidx.fragment.app.a f;

        a() {
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 21 ? new u() : null;
        c = b();
    }

    private t() {
    }

    static View a(androidx.c.a<String, View> aVar, a aVar2, Object obj, boolean z) {
        androidx.fragment.app.a aVar3 = aVar2.c;
        if (obj == null || aVar == null || aVar3.D == null || aVar3.D.isEmpty()) {
            return null;
        }
        return aVar.get(z ? aVar3.D.get(0) : aVar3.E.get(0));
    }

    private static androidx.c.a<String, String> a(int i, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        androidx.c.a<String, String> aVar = new androidx.c.a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (aVar2.b(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (aVar2.D != null) {
                    int size = aVar2.D.size();
                    if (zBooleanValue) {
                        arrayList3 = aVar2.D;
                        arrayList4 = aVar2.E;
                    } else {
                        ArrayList<String> arrayList5 = aVar2.D;
                        arrayList3 = aVar2.E;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = aVar.remove(str2);
                        if (strRemove != null) {
                            aVar.put(str, strRemove);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    static androidx.c.a<String, View> a(v vVar, androidx.c.a<String, String> aVar, Object obj, a aVar2) {
        z zVarAD;
        ArrayList<String> arrayList;
        String strA;
        d dVar = aVar2.f793a;
        View viewX = dVar.X();
        if (aVar.isEmpty() || obj == null || viewX == null) {
            aVar.clear();
            return null;
        }
        androidx.c.a<String, View> aVar3 = new androidx.c.a<>();
        vVar.a((Map<String, View>) aVar3, viewX);
        androidx.fragment.app.a aVar4 = aVar2.c;
        if (aVar2.b) {
            zVarAD = dVar.aE();
            arrayList = aVar4.D;
        } else {
            zVarAD = dVar.aD();
            arrayList = aVar4.E;
        }
        if (arrayList != null) {
            aVar3.c(arrayList);
            aVar3.c(aVar.values());
        }
        if (zVarAD != null) {
            zVarAD.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    String strA2 = a(aVar, str);
                    if (strA2 != null) {
                        aVar.remove(strA2);
                    }
                } else if (!str.equals(af.R(view)) && (strA = a(aVar, str)) != null) {
                    aVar.put(strA, af.R(view));
                }
            }
        } else {
            a(aVar, aVar3);
        }
        return aVar3;
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    private static v a(d dVar, d dVar2) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null) {
            Object objAg = dVar.ag();
            if (objAg != null) {
                arrayList.add(objAg);
            }
            Object objAf = dVar.af();
            if (objAf != null) {
                arrayList.add(objAf);
            }
            Object objAj = dVar.aj();
            if (objAj != null) {
                arrayList.add(objAj);
            }
        }
        if (dVar2 != null) {
            Object objAe = dVar2.ae();
            if (objAe != null) {
                arrayList.add(objAe);
            }
            Object objAh = dVar2.ah();
            if (objAh != null) {
                arrayList.add(objAh);
            }
            Object objAi = dVar2.ai();
            if (objAi != null) {
                arrayList.add(objAi);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (b != null && a(b, arrayList)) {
            return b;
        }
        if (c != null && a(c, arrayList)) {
            return c;
        }
        if (b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static Object a(final v vVar, ViewGroup viewGroup, View view, androidx.c.a<String, String> aVar, a aVar2, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final d dVar = aVar2.f793a;
        final d dVar2 = aVar2.d;
        if (dVar != null) {
            dVar.Y().setVisibility(0);
        }
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        Object objA = aVar.isEmpty() ? null : a(vVar, dVar, dVar2, z);
        androidx.c.a<String, View> aVarB = b(vVar, aVar, objA, aVar2);
        final androidx.c.a<String, View> aVarA = a(vVar, aVar, objA, aVar2);
        if (aVar.isEmpty()) {
            if (aVarB != null) {
                aVarB.clear();
            }
            if (aVarA != null) {
                aVarA.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, aVarB, aVar.keySet());
            a(arrayList2, aVarA, aVar.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, aVarB, true);
        if (obj3 != null) {
            arrayList2.add(view);
            vVar.a(obj3, view, arrayList);
            a(vVar, obj3, obj2, aVarB, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View viewA = a(aVarA, aVar2, obj, z);
            if (viewA != null) {
                vVar.a(obj, rect2);
            }
            rect = rect2;
            view2 = viewA;
        } else {
            view2 = null;
            rect = null;
        }
        androidx.core.n.z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.3
            @Override // java.lang.Runnable
            public void run() {
                t.a(dVar, dVar2, z, (androidx.c.a<String, View>) aVarA, false);
                if (view2 != null) {
                    vVar.a(view2, rect);
                }
            }
        });
        return obj3;
    }

    private static Object a(v vVar, d dVar, d dVar2, boolean z) {
        if (dVar == null || dVar2 == null) {
            return null;
        }
        return vVar.c(vVar.b(z ? dVar2.aj() : dVar.ai()));
    }

    private static Object a(v vVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return vVar.b(z ? dVar.ah() : dVar.ae());
    }

    private static Object a(v vVar, Object obj, Object obj2, Object obj3, d dVar, boolean z) {
        boolean zAl;
        if (obj == null || obj2 == null || dVar == null) {
            zAl = true;
        } else {
            zAl = z ? dVar.al() : dVar.ak();
        }
        return zAl ? vVar.a(obj2, obj, obj3) : vVar.b(obj2, obj, obj3);
    }

    private static String a(androidx.c.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(aVar.c(i))) {
                return aVar.b(i);
            }
        }
        return null;
    }

    static ArrayList<View> a(v vVar, Object obj, d dVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewX = dVar.X();
        if (viewX != null) {
            vVar.a(arrayList2, viewX);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        vVar.a(obj, arrayList2);
        return arrayList2;
    }

    private static void a(androidx.c.a<String, String> aVar, androidx.c.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.c(size))) {
                aVar.d(size);
            }
        }
    }

    public static void a(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.p.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.p.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x006c  */
    /* JADX WARN: Code duplicated, block: B:47:0x006e  */
    /* JADX WARN: Code duplicated, block: B:54:0x007d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x007f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0082  */
    /* JADX WARN: Code duplicated, block: B:60:0x008a  */
    /* JADX WARN: Code duplicated, block: B:61:0x008c  */
    private static void a(androidx.fragment.app.a aVar, s.a aVar2, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        d dVar = aVar2.b;
        if (dVar == null || (i = dVar.O) == 0) {
            return;
        }
        int i2 = z ? f788a[aVar2.f787a] : aVar2.f787a;
        boolean z8 = false;
        if (i2 != 1) {
            switch (i2) {
                case 3:
                case 6:
                    if (!z2 ? !(!dVar.C || dVar.Q) : !(dVar.C || dVar.X == null || dVar.X.getVisibility() != 0 || dVar.af < 0.0f)) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    z5 = z7;
                    z6 = false;
                    z4 = true;
                    break;
                case 4:
                    if (!z2 ? !(!dVar.C || dVar.Q) : dVar.ae && dVar.C && dVar.Q) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    z5 = z7;
                    z6 = false;
                    z4 = true;
                    break;
                case 5:
                    if (!z2) {
                        z3 = dVar.Q;
                    } else if (dVar.ae && !dVar.Q && dVar.C) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = false;
                    z5 = false;
                    z8 = z3;
                    z6 = true;
                    break;
                case 7:
                    if (z2) {
                        z3 = dVar.ad;
                    } else if (!dVar.C || dVar.Q) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z4 = false;
                    z5 = false;
                    z8 = z3;
                    z6 = true;
                    break;
                default:
                    z6 = false;
                    z4 = false;
                    z5 = false;
                    break;
            }
        } else {
            if (z2) {
                z3 = dVar.ad;
            } else {
                if (dVar.C) {
                }
                z3 = false;
            }
            z4 = false;
            z5 = false;
            z8 = z3;
            z6 = true;
        }
        a aVarA = sparseArray.get(i);
        if (z8) {
            aVarA = a(aVarA, sparseArray, i);
            aVarA.f793a = dVar;
            aVarA.b = z;
            aVarA.c = aVar;
        }
        a aVarA2 = aVarA;
        if (!z2 && z6) {
            if (aVarA2 != null && aVarA2.d == dVar) {
                aVarA2.d = null;
            }
            k kVar = aVar.b;
            if (dVar.t < 1 && kVar.s >= 1 && !aVar.F) {
                kVar.l(dVar);
                kVar.a(dVar, 1, 0, 0, false);
            }
        }
        if (z5 && (aVarA2 == null || aVarA2.d == null)) {
            aVarA2 = a(aVarA2, sparseArray, i);
            aVarA2.d = dVar;
            aVarA2.e = z;
            aVarA2.f = aVar;
        }
        if (z2 || !z4 || aVarA2 == null || aVarA2.f793a != dVar) {
            return;
        }
        aVarA2.f793a = null;
    }

    static void a(d dVar, d dVar2, boolean z, androidx.c.a<String, View> aVar, boolean z2) {
        z zVarAD = z ? dVar2.aD() : dVar.aD();
        if (zVarAD != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(aVar.b(i));
                arrayList.add(aVar.c(i));
            }
            if (z2) {
                zVarAD.a(arrayList2, arrayList, (List<View>) null);
            } else {
                zVarAD.b(arrayList2, arrayList, null);
            }
        }
    }

    private static void a(k kVar, int i, a aVar, View view, androidx.c.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        v vVarA;
        Object obj;
        ViewGroup viewGroup = kVar.u.a() ? (ViewGroup) kVar.u.a(i) : null;
        if (viewGroup == null || (vVarA = a((dVar2 = aVar.d), (dVar = aVar.f793a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objA = a(vVarA, dVar, z);
        Object objB = b(vVarA, dVar2, z2);
        Object objA2 = a(vVarA, viewGroup, view, aVar2, aVar, arrayList2, arrayList, objA, objB);
        if (objA == null && objA2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(vVarA, obj, dVar2, arrayList2, view);
        ArrayList<View> arrayListA2 = a(vVarA, objA, dVar, arrayList, view);
        a(arrayListA2, 4);
        Object objA3 = a(vVarA, objA, obj, objA2, dVar, z);
        if (objA3 != null) {
            a(vVarA, obj, dVar2, arrayListA);
            ArrayList<String> arrayListA3 = vVarA.a(arrayList);
            vVarA.a(objA3, objA, arrayListA2, obj, arrayListA, objA2, arrayList);
            vVarA.a(viewGroup, objA3);
            vVarA.a(viewGroup, arrayList2, arrayList, arrayListA3, aVar2);
            a(arrayListA2, 0);
            vVarA.a(objA2, arrayList2, arrayList);
        }
    }

    static void a(k kVar, ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (kVar.s < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            androidx.fragment.app.a aVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                b(aVar, (SparseArray<a>) sparseArray, z);
            } else {
                a(aVar, (SparseArray<a>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(kVar.t.l());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                androidx.c.a<String, String> aVarA = a(iKeyAt, arrayList, arrayList2, i, i2);
                a aVar2 = (a) sparseArray.valueAt(i4);
                if (z) {
                    a(kVar, iKeyAt, aVar2, view, aVarA);
                } else {
                    b(kVar, iKeyAt, aVar2, view, aVarA);
                }
            }
        }
    }

    private static void a(final v vVar, ViewGroup viewGroup, final d dVar, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        androidx.core.n.z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    vVar.c(obj, view);
                    arrayList2.addAll(t.a(vVar, obj, dVar, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        vVar.b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void a(v vVar, Object obj, d dVar, final ArrayList<View> arrayList) {
        if (dVar != null && obj != null && dVar.C && dVar.Q && dVar.ae) {
            dVar.o(true);
            vVar.b(obj, dVar.X(), arrayList);
            androidx.core.n.z.a(dVar.W, new Runnable() { // from class: androidx.fragment.app.t.1
                @Override // java.lang.Runnable
                public void run() {
                    t.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void a(v vVar, Object obj, Object obj2, androidx.c.a<String, View> aVar, boolean z, androidx.fragment.app.a aVar2) {
        if (aVar2.D == null || aVar2.D.isEmpty()) {
            return;
        }
        View view = aVar.get(z ? aVar2.E.get(0) : aVar2.D.get(0));
        vVar.a(obj, view);
        if (obj2 != null) {
            vVar.a(obj2, view);
        }
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static void a(ArrayList<View> arrayList, androidx.c.a<String, View> aVar, Collection<String> collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewC = aVar.c(size);
            if (collection.contains(af.R(viewC))) {
                arrayList.add(viewC);
            }
        }
    }

    static boolean a() {
        return (b == null && c == null) ? false : true;
    }

    private static boolean a(v vVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!vVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static androidx.c.a<String, View> b(v vVar, androidx.c.a<String, String> aVar, Object obj, a aVar2) {
        z zVarAE;
        ArrayList<String> arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        d dVar = aVar2.d;
        androidx.c.a<String, View> aVar3 = new androidx.c.a<>();
        vVar.a((Map<String, View>) aVar3, dVar.Y());
        androidx.fragment.app.a aVar4 = aVar2.f;
        if (aVar2.e) {
            zVarAE = dVar.aD();
            arrayList = aVar4.E;
        } else {
            zVarAE = dVar.aE();
            arrayList = aVar4.D;
        }
        aVar3.c(arrayList);
        if (zVarAE != null) {
            zVarAE.a(arrayList, aVar3);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = aVar3.get(str);
                if (view == null) {
                    aVar.remove(str);
                } else if (!str.equals(af.R(view))) {
                    aVar.put(af.R(view), aVar.remove(str));
                }
            }
        } else {
            aVar.c(aVar3.keySet());
        }
        return aVar3;
    }

    private static v b() {
        try {
            return (v) Class.forName("androidx.j.n").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object b(final v vVar, ViewGroup viewGroup, final View view, final androidx.c.a<String, String> aVar, final a aVar2, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object obj3;
        Rect rect;
        final d dVar = aVar2.f793a;
        final d dVar2 = aVar2.d;
        if (dVar == null || dVar2 == null) {
            return null;
        }
        final boolean z = aVar2.b;
        Object objA = aVar.isEmpty() ? null : a(vVar, dVar, dVar2, z);
        androidx.c.a<String, View> aVarB = b(vVar, aVar, objA, aVar2);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(aVarB.values());
            obj3 = objA;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        a(dVar, dVar2, z, aVarB, true);
        if (obj3 != null) {
            rect = new Rect();
            vVar.a(obj3, view, arrayList);
            a(vVar, obj3, obj2, aVarB, aVar2.e, aVar2.f);
            if (obj != null) {
                vVar.a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        androidx.core.n.z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.t.4
            @Override // java.lang.Runnable
            public void run() {
                androidx.c.a<String, View> aVarA = t.a(vVar, (androidx.c.a<String, String>) aVar, obj4, aVar2);
                if (aVarA != null) {
                    arrayList2.addAll(aVarA.values());
                    arrayList2.add(view);
                }
                t.a(dVar, dVar2, z, aVarA, false);
                if (obj4 != null) {
                    vVar.a(obj4, arrayList, arrayList2);
                    View viewA = t.a(aVarA, aVar2, obj, z);
                    if (viewA != null) {
                        vVar.a(viewA, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static Object b(v vVar, d dVar, boolean z) {
        if (dVar == null) {
            return null;
        }
        return vVar.b(z ? dVar.af() : dVar.ag());
    }

    public static void b(androidx.fragment.app.a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.b.u.a()) {
            for (int size = aVar.p.size() - 1; size >= 0; size--) {
                a(aVar, aVar.p.get(size), sparseArray, true, z);
            }
        }
    }

    private static void b(k kVar, int i, a aVar, View view, androidx.c.a<String, String> aVar2) {
        d dVar;
        d dVar2;
        v vVarA;
        Object obj;
        ViewGroup viewGroup = kVar.u.a() ? (ViewGroup) kVar.u.a(i) : null;
        if (viewGroup == null || (vVarA = a((dVar2 = aVar.d), (dVar = aVar.f793a))) == null) {
            return;
        }
        boolean z = aVar.b;
        boolean z2 = aVar.e;
        Object objA = a(vVarA, dVar, z);
        Object objB = b(vVarA, dVar2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objB2 = b(vVarA, viewGroup, view, aVar2, aVar, arrayList, arrayList2, objA, objB);
        if (objA == null && objB2 == null) {
            obj = objB;
            if (obj == null) {
                return;
            }
        } else {
            obj = objB;
        }
        ArrayList<View> arrayListA = a(vVarA, obj, dVar2, (ArrayList<View>) arrayList, view);
        Object obj2 = (arrayListA == null || arrayListA.isEmpty()) ? null : obj;
        vVarA.b(objA, view);
        Object objA2 = a(vVarA, objA, obj2, objB2, dVar, aVar.b);
        if (objA2 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            vVarA.a(objA2, objA, arrayList3, obj2, arrayListA, objB2, arrayList2);
            a(vVarA, viewGroup, dVar, view, arrayList2, objA, arrayList3, obj2, arrayListA);
            vVarA.a((View) viewGroup, arrayList2, (Map<String, String>) aVar2);
            vVarA.a(viewGroup, objA2);
            vVarA.a(viewGroup, arrayList2, (Map<String, String>) aVar2);
        }
    }
}
