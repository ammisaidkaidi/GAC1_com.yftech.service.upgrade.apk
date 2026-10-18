package androidx.d.b.b;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f605a = new HashMap<>();
    static final HashMap<String, String> b = new HashMap<>();
    private static final boolean c = false;
    private static final String d = "DesignTool";
    private final s e;
    private u f;
    private String g = null;
    private String h = null;
    private int i = -1;
    private int j = -1;

    static {
        f605a.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        f605a.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        f605a.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        f605a.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        f605a.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        f605a.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        f605a.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        f605a.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        f605a.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        f605a.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        f605a.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        f605a.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        f605a.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        b.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        b.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        b.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        b.put("layout_constraintTop_toTopOf", "layout_marginTop");
        b.put("layout_constraintStart_toStartOf", "layout_marginStart");
        b.put("layout_constraintStart_toEndOf", "layout_marginStart");
        b.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        b.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        b.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        b.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        b.put("layout_constraintRight_toRightOf", "layout_marginRight");
        b.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public d(s sVar) {
        this.e = sVar;
    }

    private static int a(int i, String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, iIndexOf)).intValue() * i) / 160.0f);
    }

    private static void a(int i, androidx.d.e.g gVar, View view, HashMap<String, String> map) {
        String str = map.get("layout_editor_absoluteX");
        if (str != null) {
            gVar.g(view.getId(), a(i, str));
        }
        String str2 = map.get("layout_editor_absoluteY");
        if (str2 != null) {
            gVar.h(view.getId(), a(i, str2));
        }
    }

    private static void a(int i, androidx.d.e.g gVar, View view, HashMap<String, String> map, int i2) {
        String str = map.get(i2 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int iA = str.equalsIgnoreCase("wrap_content") ? -2 : a(i, str);
            if (i2 == 0) {
                gVar.j(view.getId(), iA);
            } else {
                gVar.i(view.getId(), iA);
            }
        }
    }

    private static void a(int i, androidx.d.e.g gVar, View view, HashMap<String, String> map, int i2, int i3) {
        String str = f605a.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = map.get(str);
        if (str2 != null) {
            String str3 = b.get(str);
            int iA = str3 != null ? a(i, map.get(str3)) : 0;
            gVar.a(view.getId(), i2, Integer.parseInt(str2), i3, iA);
        }
    }

    private static void a(androidx.d.e.g gVar, View view, HashMap<String, String> map, int i) {
        String str = map.get(i == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (i == 0) {
                gVar.a(view.getId(), Float.parseFloat(str));
            } else if (i == 1) {
                gVar.b(view.getId(), Float.parseFloat(str));
            }
        }
    }

    @Override // androidx.d.b.b.v
    public float a(Object obj, int i, float f, float f2) {
        return this.e.m.get((View) obj).a(i, f, f2);
    }

    @Override // androidx.d.b.b.v
    public int a(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        p pVar;
        View view = (View) obj;
        if (i == 0) {
            pVar = null;
        } else if (this.e.i == null || view == null || (pVar = this.e.m.get(view)) == null) {
            return -1;
        }
        switch (i) {
            case 0:
                return 1;
            case 1:
                int iG = this.e.i.g() / 16;
                pVar.a(fArr2, iG);
                return iG;
            case 2:
                int iG2 = this.e.i.g() / 16;
                pVar.a(fArr2, (int[]) null);
                return iG2;
            case 3:
                int iG3 = this.e.i.g() / 16;
                return pVar.a(str, fArr2, i3);
            default:
                return -1;
        }
    }

    public int a(Object obj, int i, int[] iArr) {
        p pVar = this.e.m.get((View) obj);
        if (pVar == null) {
            return 0;
        }
        return pVar.a(i, iArr);
    }

    public int a(Object obj, float[] fArr, int i) {
        if (this.e.i == null) {
            return -1;
        }
        p pVar = this.e.m.get(obj);
        if (pVar == null) {
            return 0;
        }
        pVar.a(fArr, i);
        return i;
    }

    public int a(Object obj, int[] iArr, float[] fArr) {
        p pVar = this.e.m.get((View) obj);
        if (pVar == null) {
            return 0;
        }
        return pVar.a(iArr, fArr);
    }

    @Override // androidx.d.b.b.v
    public Boolean a(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        if (!(obj instanceof l)) {
            return false;
        }
        View view = (View) obj2;
        this.e.m.get(view).a(view, (l) obj, f, f2, strArr, fArr);
        this.e.g();
        this.e.q = true;
        return true;
    }

    public Object a(int i, int i2, int i3) {
        if (this.e.i == null) {
            return null;
        }
        return this.e.i.a(this.e.getContext(), i, i2, i3);
    }

    @Override // androidx.d.b.b.v
    public Object a(Object obj, float f, float f2) {
        p pVar;
        View view = (View) obj;
        if (this.e.i == null) {
            return -1;
        }
        if (view == null || (pVar = this.e.m.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return pVar.a(viewGroup.getWidth(), viewGroup.getHeight(), f, f2);
    }

    public Object a(Object obj, int i, int i2) {
        if (this.e.i == null) {
            return null;
        }
        return this.e.i.a(this.e.getContext(), i, ((View) obj).getId(), i2);
    }

    public String a() {
        int startState = this.e.getStartState();
        if (this.i == startState) {
            return this.g;
        }
        String strF = this.e.f(startState);
        if (strF != null) {
            this.g = strF;
            this.i = startState;
        }
        return this.e.f(startState);
    }

    @Override // androidx.d.b.b.v
    public void a(float f) {
        if (this.e.i == null) {
            this.e.i = this.f;
        }
        this.e.setProgress(f);
        this.e.a(true);
        this.e.requestLayout();
        this.e.invalidate();
    }

    @Override // androidx.d.b.b.v
    public void a(int i, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap map = (HashMap) obj2;
        int iA = this.e.a(str);
        androidx.d.e.g gVarC = this.e.i.c(iA);
        if (gVarC == null) {
            return;
        }
        gVarC.b(view.getId());
        a(i, gVarC, view, (HashMap<String, String>) map, 0);
        a(i, gVarC, view, (HashMap<String, String>) map, 1);
        a(i, gVarC, view, (HashMap<String, String>) map, 6, 6);
        a(i, gVarC, view, (HashMap<String, String>) map, 6, 7);
        a(i, gVarC, view, (HashMap<String, String>) map, 7, 7);
        a(i, gVarC, view, (HashMap<String, String>) map, 7, 6);
        a(i, gVarC, view, (HashMap<String, String>) map, 1, 1);
        a(i, gVarC, view, (HashMap<String, String>) map, 1, 2);
        a(i, gVarC, view, (HashMap<String, String>) map, 2, 2);
        a(i, gVarC, view, (HashMap<String, String>) map, 2, 1);
        a(i, gVarC, view, (HashMap<String, String>) map, 3, 3);
        a(i, gVarC, view, (HashMap<String, String>) map, 3, 4);
        a(i, gVarC, view, (HashMap<String, String>) map, 4, 3);
        a(i, gVarC, view, (HashMap<String, String>) map, 4, 4);
        a(i, gVarC, view, (HashMap<String, String>) map, 5, 5);
        a(gVarC, view, (HashMap<String, String>) map, 0);
        a(gVarC, view, (HashMap<String, String>) map, 1);
        a(i, gVarC, view, (HashMap<String, String>) map);
        this.e.a(iA, gVarC);
        this.e.requestLayout();
    }

    public void a(Object obj, int i) {
        p pVar = this.e.m.get(obj);
        if (pVar != null) {
            pVar.c(i);
            this.e.invalidate();
        }
    }

    @Override // androidx.d.b.b.v
    public void a(Object obj, int i, String str, Object obj2) {
        if (this.e.i != null) {
            this.e.i.a((View) obj, i, str, obj2);
            this.e.p = i / 100.0f;
            this.e.o = 0.0f;
            this.e.g();
            this.e.a(true);
        }
    }

    public void a(Object obj, String str, Object obj2) {
        if (obj instanceof e) {
            ((e) obj).a(str, obj2);
            this.e.g();
            this.e.q = true;
        }
    }

    public void a(Object obj, float[] fArr) {
        if (this.e.i == null) {
            return;
        }
        int iG = this.e.i.g() / 16;
        p pVar = this.e.m.get(obj);
        if (pVar == null) {
            return;
        }
        pVar.c(fArr, iG);
    }

    public void a(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.g == str) {
            return;
        }
        this.g = str;
        this.h = null;
        if (this.e.i == null) {
            this.e.i = this.f;
        }
        int iA = str != null ? this.e.a(str) : androidx.d.e.m.g.motion_base;
        this.i = iA;
        if (iA != 0) {
            if (iA == this.e.getStartState()) {
                this.e.setProgress(0.0f);
            } else if (iA == this.e.getEndState()) {
                this.e.setProgress(1.0f);
            } else {
                this.e.b(iA);
                this.e.setProgress(1.0f);
            }
        }
        this.e.requestLayout();
    }

    public void a(String str, String str2) {
        if (this.e.i == null) {
            this.e.i = this.f;
        }
        int iA = this.e.a(str);
        int iA2 = this.e.a(str2);
        this.e.a(iA, iA2);
        this.i = iA;
        this.j = iA2;
        this.g = str;
        this.h = str2;
    }

    public void a(boolean z) {
        this.e.c(z);
    }

    @Override // androidx.d.b.b.v
    public boolean a(Object obj, int i, int i2, float f, float f2) {
        if (this.e.i == null) {
            return false;
        }
        p pVar = this.e.m.get(obj);
        int i3 = (int) (this.e.n * 100.0f);
        if (pVar == null) {
            return false;
        }
        View view = (View) obj;
        if (!this.e.i.a(view, i3)) {
            return false;
        }
        float fA = pVar.a(2, f, f2);
        float fA2 = pVar.a(5, f, f2);
        this.e.i.a(view, i3, "motion:percentX", Float.valueOf(fA));
        this.e.i.a(view, i3, "motion:percentY", Float.valueOf(fA2));
        this.e.g();
        this.e.a(true);
        this.e.invalidate();
        return true;
    }

    public int b(Object obj, float[] fArr) {
        if (this.e.i == null) {
            return -1;
        }
        int iG = this.e.i.g() / 16;
        p pVar = this.e.m.get(obj);
        if (pVar == null) {
            return 0;
        }
        pVar.a(fArr, (int[]) null);
        return iG;
    }

    public String b() {
        int endState = this.e.getEndState();
        if (this.j == endState) {
            return this.h;
        }
        String strF = this.e.f(endState);
        if (strF != null) {
            this.h = strF;
            this.j = endState;
        }
        return strF;
    }

    public void b(String str) {
        if (this.e.i == null) {
            this.e.i = this.f;
        }
        int iA = this.e.a(str);
        System.out.println(" dumping  " + str + " (" + iA + ")");
        try {
            this.e.i.c(iA).a(this.e.i, new int[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float c() {
        return this.e.getProgress();
    }

    public String d() {
        if (this.g != null && this.h != null) {
            float fC = c();
            if (fC <= 0.01f) {
                return this.g;
            }
            if (fC >= 0.99f) {
                return this.h;
            }
        }
        return this.g;
    }

    public boolean e() {
        return (this.g == null || this.h == null) ? false : true;
    }

    @Override // androidx.d.b.b.v
    public long f() {
        return this.e.getTransitionTimeMs();
    }
}
