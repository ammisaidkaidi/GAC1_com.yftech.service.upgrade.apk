package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ap;
import androidx.core.n.af;
import androidx.core.n.ah;
import androidx.core.n.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public abstract class v {
    static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    protected static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public abstract Object a(Object obj, Object obj2, Object obj3);

    ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(af.R(view));
            af.a(view, (String) null);
        }
        return arrayList2;
    }

    protected void a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    void a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String strR = af.R(view2);
            arrayList4.add(strR);
            if (strR != null) {
                af.a(view2, (String) null);
                String str = map.get(strR);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        af.a(arrayList2.get(i2), strR);
                        break;
                    }
                }
            }
        }
        z.a(view, new Runnable() { // from class: androidx.fragment.app.v.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    af.a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    af.a((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    void a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        z.a(view, new Runnable() { // from class: androidx.fragment.app.v.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String strR = af.R(view2);
                    if (strR != null) {
                        af.a(view2, v.a((Map<String, String>) map, strR));
                    }
                }
            }
        });
    }

    public abstract void a(ViewGroup viewGroup, Object obj);

    void a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        z.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.v.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    af.a(view, (String) map.get(af.R(view)));
                }
            }
        });
    }

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (ah.b(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(arrayList, viewGroup.getChildAt(i));
            }
        }
    }

    void a(Map<String, View> map, @androidx.annotation.ah View view) {
        if (view.getVisibility() == 0) {
            String strR = af.R(view);
            if (strR != null) {
                map.put(strR, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object c(Object obj);

    public abstract void c(Object obj, View view);
}
