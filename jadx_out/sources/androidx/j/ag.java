package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public abstract class ag implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f846a = "Transition";
    private static final int b = 1;
    static final boolean c = false;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    private static final int o = 4;
    private static final String p = "instance";
    private static final String q = "name";
    private static final String r = "id";
    private static final String s = "itemId";
    private ArrayList<an> K;
    private ArrayList<an> L;
    private c T;
    private androidx.c.a<String, String> U;
    ak n;
    private static final int[] t = {2, 1, 3, 4};
    private static final w u = new w() { // from class: androidx.j.ag.1
        @Override // androidx.j.w
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<androidx.c.a<Animator, a>> M = new ThreadLocal<>();
    private String v = getClass().getName();
    private long w = -1;
    long h = -1;
    private TimeInterpolator x = null;
    ArrayList<Integer> i = new ArrayList<>();
    ArrayList<View> j = new ArrayList<>();
    private ArrayList<String> y = null;
    private ArrayList<Class<?>> z = null;
    private ArrayList<Integer> A = null;
    private ArrayList<View> B = null;
    private ArrayList<Class<?>> C = null;
    private ArrayList<String> D = null;
    private ArrayList<Integer> E = null;
    private ArrayList<View> F = null;
    private ArrayList<Class<?>> G = null;
    private ao H = new ao();
    private ao I = new ao();
    al k = null;
    private int[] J = t;
    private ViewGroup N = null;
    boolean l = false;
    ArrayList<Animator> m = new ArrayList<>();
    private int O = 0;
    private boolean P = false;
    private boolean Q = false;
    private ArrayList<e> R = null;
    private ArrayList<Animator> S = new ArrayList<>();
    private w V = u;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f849a;
        String b;
        an c;
        bj d;
        ag e;

        a(View view, String str, ag agVar, bj bjVar, an anVar) {
            this.f849a = view;
            this.b = str;
            this.c = anVar;
            this.d = bjVar;
            this.e = agVar;
        }
    }

    private static class b {
        private b() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class c {
        public abstract Rect a(@androidx.annotation.ah ag agVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public @interface d {
    }

    public interface e {
        void a(@androidx.annotation.ah ag agVar);

        void b(@androidx.annotation.ah ag agVar);

        void c(@androidx.annotation.ah ag agVar);

        void d(@androidx.annotation.ah ag agVar);

        void e(@androidx.annotation.ah ag agVar);
    }

    public ag() {
    }

    @SuppressLint({"RestrictedApi"})
    public ag(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, "duration", 1, -1);
        if (jA >= 0) {
            a(jA);
        }
        long jA2 = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (jA2 > 0) {
            b(jA2);
        }
        int iC = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iC > 0) {
            a(AnimationUtils.loadInterpolator(context, iC));
        }
        String strA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strA != null) {
            a(d(strA));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private ArrayList<Integer> a(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            return z ? b.a(arrayList, Integer.valueOf(i)) : b.b(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    private ArrayList<View> a(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            return z ? b.a(arrayList, view) : b.b(arrayList, view);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> a(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            return z ? b.a(arrayList, cls) : b.b(arrayList, cls);
        }
        return arrayList;
    }

    private static <T> ArrayList<T> a(ArrayList<T> arrayList, T t2, boolean z) {
        if (t2 != null) {
            return z ? b.a(arrayList, t2) : b.b(arrayList, t2);
        }
        return arrayList;
    }

    private void a(Animator animator, final androidx.c.a<Animator, a> aVar) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.j.ag.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    aVar.remove(animator2);
                    ag.this.m.remove(animator2);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    ag.this.m.add(animator2);
                }
            });
            a(animator);
        }
    }

    private void a(androidx.c.a<View, an> aVar, androidx.c.a<View, an> aVar2) {
        an anVarRemove;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View viewB = aVar.b(size);
            if (viewB != null && b(viewB) && (anVarRemove = aVar2.remove(viewB)) != null && b(anVarRemove.b)) {
                this.K.add(aVar.d(size));
                this.L.add(anVarRemove);
            }
        }
    }

    private void a(androidx.c.a<View, an> aVar, androidx.c.a<View, an> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && b(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && b(view)) {
                an anVar = aVar.get(viewValueAt);
                an anVar2 = aVar2.get(view);
                if (anVar != null && anVar2 != null) {
                    this.K.add(anVar);
                    this.L.add(anVar2);
                    aVar.remove(viewValueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(androidx.c.a<View, an> aVar, androidx.c.a<View, an> aVar2, androidx.c.a<String, View> aVar3, androidx.c.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i = 0; i < size; i++) {
            View viewC = aVar3.c(i);
            if (viewC != null && b(viewC) && (view = aVar4.get(aVar3.b(i))) != null && b(view)) {
                an anVar = aVar.get(viewC);
                an anVar2 = aVar2.get(view);
                if (anVar != null && anVar2 != null) {
                    this.K.add(anVar);
                    this.L.add(anVar2);
                    aVar.remove(viewC);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void a(androidx.c.a<View, an> aVar, androidx.c.a<View, an> aVar2, androidx.c.f<View> fVar, androidx.c.f<View> fVar2) {
        View viewA;
        int iB = fVar.b();
        for (int i = 0; i < iB; i++) {
            View viewC = fVar.c(i);
            if (viewC != null && b(viewC) && (viewA = fVar2.a(fVar.b(i))) != null && b(viewA)) {
                an anVar = aVar.get(viewC);
                an anVar2 = aVar2.get(viewA);
                if (anVar != null && anVar2 != null) {
                    this.K.add(anVar);
                    this.L.add(anVar2);
                    aVar.remove(viewC);
                    aVar2.remove(viewA);
                }
            }
        }
    }

    private static void a(ao aoVar, View view, an anVar) {
        aoVar.f860a.put(view, anVar);
        int id = view.getId();
        if (id >= 0) {
            if (aoVar.b.indexOfKey(id) >= 0) {
                aoVar.b.put(id, null);
            } else {
                aoVar.b.put(id, view);
            }
        }
        String strR = androidx.core.n.af.R(view);
        if (strR != null) {
            if (aoVar.d.containsKey(strR)) {
                aoVar.d.put(strR, null);
            } else {
                aoVar.d.put(strR, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (aoVar.c.d(itemIdAtPosition) < 0) {
                    androidx.core.n.af.a(view, true);
                    aoVar.c.d(itemIdAtPosition, view);
                    return;
                }
                View viewA = aoVar.c.a(itemIdAtPosition);
                if (viewA != null) {
                    androidx.core.n.af.a(viewA, false);
                    aoVar.c.d(itemIdAtPosition, null);
                }
            }
        }
    }

    private void a(ao aoVar, ao aoVar2) {
        androidx.c.a<View, an> aVar = new androidx.c.a<>(aoVar.f860a);
        androidx.c.a<View, an> aVar2 = new androidx.c.a<>(aoVar2.f860a);
        for (int i = 0; i < this.J.length; i++) {
            switch (this.J[i]) {
                case 1:
                    a(aVar, aVar2);
                    break;
                case 2:
                    a(aVar, aVar2, aoVar.d, aoVar2.d);
                    break;
                case 3:
                    a(aVar, aVar2, aoVar.b, aoVar2.b);
                    break;
                case 4:
                    a(aVar, aVar2, aoVar.c, aoVar2.c);
                    break;
            }
        }
        b(aVar, aVar2);
    }

    private static boolean a(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean a(an anVar, an anVar2, String str) {
        Object obj = anVar.f859a.get(str);
        Object obj2 = anVar2.f859a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private static boolean a(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private static androidx.c.a<Animator, a> b() {
        androidx.c.a<Animator, a> aVar = M.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.c.a<Animator, a> aVar2 = new androidx.c.a<>();
        M.set(aVar2);
        return aVar2;
    }

    private void b(androidx.c.a<View, an> aVar, androidx.c.a<View, an> aVar2) {
        for (int i = 0; i < aVar.size(); i++) {
            an anVarC = aVar.c(i);
            if (b(anVarC.b)) {
                this.K.add(anVarC);
                this.L.add(null);
            }
        }
        for (int i2 = 0; i2 < aVar2.size(); i2++) {
            an anVarC2 = aVar2.c(i2);
            if (b(anVarC2.b)) {
                this.L.add(anVarC2);
                this.K.add(null);
            }
        }
    }

    private static int[] d(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if (r.equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if (p.equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if (q.equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if (s.equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            }
            i++;
        }
        return iArr;
    }

    private void e(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (this.A == null || !this.A.contains(Integer.valueOf(id))) {
            if (this.B == null || !this.B.contains(view)) {
                if (this.C != null) {
                    int size = this.C.size();
                    for (int i = 0; i < size; i++) {
                        if (this.C.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    an anVar = new an(view);
                    if (z) {
                        a(anVar);
                    } else {
                        b(anVar);
                    }
                    anVar.c.add(this);
                    c(anVar);
                    if (z) {
                        a(this.H, view, anVar);
                    } else {
                        a(this.I, view, anVar);
                    }
                }
                if (view instanceof ViewGroup) {
                    if (this.E == null || !this.E.contains(Integer.valueOf(id))) {
                        if (this.F == null || !this.F.contains(view)) {
                            if (this.G != null) {
                                int size2 = this.G.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.G.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                e(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    @androidx.annotation.ai
    public Animator a(@androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ai an anVar, @androidx.annotation.ai an anVar2) {
        return null;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.w int i, boolean z) {
        this.A = a(this.A, i, z);
        return this;
    }

    @androidx.annotation.ah
    public ag a(long j) {
        this.h = j;
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ai TimeInterpolator timeInterpolator) {
        this.x = timeInterpolator;
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah View view, boolean z) {
        this.B = a(this.B, view, z);
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah e eVar) {
        if (this.R == null) {
            this.R = new ArrayList<>();
        }
        this.R.add(eVar);
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah Class<?> cls) {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.add(cls);
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah Class<?> cls, boolean z) {
        this.C = a(this.C, cls, z);
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah String str) {
        if (this.y == null) {
            this.y = new ArrayList<>();
        }
        this.y.add(str);
        return this;
    }

    @androidx.annotation.ah
    public ag a(@androidx.annotation.ah String str, boolean z) {
        this.D = a(this.D, str, z);
        return this;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void a(Animator animator) {
        if (animator == null) {
            m();
            return;
        }
        if (d() >= 0) {
            animator.setDuration(d());
        }
        if (e() >= 0) {
            animator.setStartDelay(e() + animator.getStartDelay());
        }
        if (f() != null) {
            animator.setInterpolator(f());
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.j.ag.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ag.this.m();
                animator2.removeListener(this);
            }
        });
        animator.start();
    }

    void a(ViewGroup viewGroup) {
        a aVar;
        this.K = new ArrayList<>();
        this.L = new ArrayList<>();
        a(this.H, this.I);
        androidx.c.a<Animator, a> aVarB = b();
        int size = aVarB.size();
        bj bjVarB = ay.b(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorB = aVarB.b(i);
            if (animatorB != null && (aVar = aVarB.get(animatorB)) != null && aVar.f849a != null && bjVarB.equals(aVar.d)) {
                an anVar = aVar.c;
                View view = aVar.f849a;
                an anVarC = c(view, true);
                an anVarD = d(view, true);
                if (anVarC == null && anVarD == null) {
                    anVarD = this.I.f860a.get(view);
                }
                if (!(anVarC == null && anVarD == null) && aVar.e.a(anVar, anVarD)) {
                    if (animatorB.isRunning() || animatorB.isStarted()) {
                        animatorB.cancel();
                    } else {
                        aVarB.remove(animatorB);
                    }
                }
            }
        }
        a(viewGroup, this.H, this.I, this.K, this.L);
        g();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void a(ViewGroup viewGroup, ao aoVar, ao aoVar2, ArrayList<an> arrayList, ArrayList<an> arrayList2) {
        Animator animatorA;
        int i;
        int i2;
        View view;
        Animator animator;
        an anVar;
        Animator animator2;
        an anVar2;
        androidx.c.a<Animator, a> aVarB = b();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            an anVar3 = arrayList.get(i3);
            an anVar4 = arrayList2.get(i3);
            if (anVar3 != null && !anVar3.c.contains(this)) {
                anVar3 = null;
            }
            if (anVar4 != null && !anVar4.c.contains(this)) {
                anVar4 = null;
            }
            if (anVar3 == null && anVar4 == null) {
                i = size;
                i2 = i3;
            } else if (!(anVar3 == null || anVar4 == null || a(anVar3, anVar4)) || (animatorA = a(viewGroup, anVar3, anVar4)) == null) {
                i = size;
                i2 = i3;
            } else {
                if (anVar4 != null) {
                    view = anVar4.b;
                    String[] strArrA = a();
                    if (strArrA != null && strArrA.length > 0) {
                        anVar2 = new an(view);
                        i = size;
                        an anVar5 = aoVar2.f860a.get(view);
                        if (anVar5 != null) {
                            int i4 = 0;
                            while (i4 < strArrA.length) {
                                anVar2.f859a.put(strArrA[i4], anVar5.f859a.get(strArrA[i4]));
                                i4++;
                                i3 = i3;
                                anVar5 = anVar5;
                            }
                        }
                        i2 = i3;
                        int size2 = aVarB.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size2) {
                                animator2 = animatorA;
                                break;
                            }
                            a aVar = aVarB.get(aVarB.b(i5));
                            if (aVar.c != null && aVar.f849a == view && aVar.b.equals(t()) && aVar.c.equals(anVar2)) {
                                animator2 = null;
                                break;
                            }
                            i5++;
                        }
                    } else {
                        i = size;
                        i2 = i3;
                        animator2 = animatorA;
                        anVar2 = null;
                    }
                    animator = animator2;
                    anVar = anVar2;
                } else {
                    i = size;
                    i2 = i3;
                    view = anVar3.b;
                    animator = animatorA;
                    anVar = null;
                }
                if (animator != null) {
                    if (this.n != null) {
                        long jA = this.n.a(viewGroup, this, anVar3, anVar4);
                        sparseIntArray.put(this.S.size(), (int) jA);
                        jMin = Math.min(jA, jMin);
                    }
                    aVarB.put(animator, new a(view, t(), this, ay.b(viewGroup), anVar));
                    this.S.add(animator);
                    jMin = jMin;
                }
            }
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.S.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i6)) - jMin) + animator3.getStartDelay());
            }
        }
    }

    void a(ViewGroup viewGroup, boolean z) {
        c(z);
        if ((this.i.size() > 0 || this.j.size() > 0) && ((this.y == null || this.y.isEmpty()) && (this.z == null || this.z.isEmpty()))) {
            for (int i = 0; i < this.i.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.i.get(i).intValue());
                if (viewFindViewById != null) {
                    an anVar = new an(viewFindViewById);
                    if (z) {
                        a(anVar);
                    } else {
                        b(anVar);
                    }
                    anVar.c.add(this);
                    c(anVar);
                    if (z) {
                        a(this.H, viewFindViewById, anVar);
                    } else {
                        a(this.I, viewFindViewById, anVar);
                    }
                }
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                View view = this.j.get(i2);
                an anVar2 = new an(view);
                if (z) {
                    a(anVar2);
                } else {
                    b(anVar2);
                }
                anVar2.c.add(this);
                c(anVar2);
                if (z) {
                    a(this.H, view, anVar2);
                } else {
                    a(this.I, view, anVar2);
                }
            }
        } else {
            e(viewGroup, z);
        }
        if (z || this.U == null) {
            return;
        }
        int size = this.U.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(this.H.d.remove(this.U.b(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList.get(i4);
            if (view2 != null) {
                this.H.d.put(this.U.c(i4), view2);
            }
        }
    }

    public void a(@androidx.annotation.ai c cVar) {
        this.T = cVar;
    }

    public void a(@androidx.annotation.ai ak akVar) {
        this.n = akVar;
    }

    public abstract void a(@androidx.annotation.ah an anVar);

    public void a(@androidx.annotation.ai w wVar) {
        if (wVar == null) {
            this.V = u;
        } else {
            this.V = wVar;
        }
    }

    public void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.J = t;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!a(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (a(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.J = (int[]) iArr.clone();
    }

    public boolean a(@androidx.annotation.ai an anVar, @androidx.annotation.ai an anVar2) {
        if (anVar == null || anVar2 == null) {
            return false;
        }
        String[] strArrA = a();
        if (strArrA == null) {
            Iterator<String> it = anVar.f859a.keySet().iterator();
            while (it.hasNext()) {
                if (a(anVar, anVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrA) {
            if (!a(anVar, anVar2, str)) {
            }
        }
        return false;
        return true;
    }

    @androidx.annotation.ai
    public String[] a() {
        return null;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.w int i) {
        if (i != 0) {
            this.i.add(Integer.valueOf(i));
        }
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.w int i, boolean z) {
        this.E = a(this.E, i, z);
        return this;
    }

    @androidx.annotation.ah
    public ag b(long j) {
        this.w = j;
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.ah View view, boolean z) {
        this.F = a(this.F, view, z);
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.ah e eVar) {
        if (this.R == null) {
            return this;
        }
        this.R.remove(eVar);
        if (this.R.size() == 0) {
            this.R = null;
        }
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.ah Class<?> cls) {
        if (this.z != null) {
            this.z.remove(cls);
        }
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.ah Class<?> cls, boolean z) {
        this.G = a(this.G, cls, z);
        return this;
    }

    @androidx.annotation.ah
    public ag b(@androidx.annotation.ah String str) {
        if (this.y != null) {
            this.y.remove(str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    void b(ViewGroup viewGroup) {
        androidx.c.a<Animator, a> aVarB = b();
        int size = aVarB.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        bj bjVarB = ay.b(viewGroup);
        androidx.c.a aVar = new androidx.c.a(aVarB);
        aVarB.clear();
        for (int i = size - 1; i >= 0; i--) {
            a aVar2 = (a) aVar.c(i);
            if (aVar2.f849a != null && bjVarB != null && bjVarB.equals(aVar2.d)) {
                ((Animator) aVar.b(i)).end();
            }
        }
    }

    public abstract void b(@androidx.annotation.ah an anVar);

    boolean b(View view) {
        int id = view.getId();
        if (this.A != null && this.A.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.B != null && this.B.contains(view)) {
            return false;
        }
        if (this.C != null) {
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                if (this.C.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.D != null && androidx.core.n.af.R(view) != null && this.D.contains(androidx.core.n.af.R(view))) {
            return false;
        }
        if ((this.i.size() == 0 && this.j.size() == 0 && ((this.z == null || this.z.isEmpty()) && (this.y == null || this.y.isEmpty()))) || this.i.contains(Integer.valueOf(id)) || this.j.contains(view)) {
            return true;
        }
        if (this.y != null && this.y.contains(androidx.core.n.af.R(view))) {
            return true;
        }
        if (this.z != null) {
            for (int i2 = 0; i2 < this.z.size(); i2++) {
                if (this.z.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @androidx.annotation.ah
    public ag c(@androidx.annotation.w int i) {
        if (i != 0) {
            this.i.remove(Integer.valueOf(i));
        }
        return this;
    }

    @androidx.annotation.ah
    public ag c(@androidx.annotation.ah View view) {
        this.j.add(view);
        return this;
    }

    ag c(ViewGroup viewGroup) {
        this.N = viewGroup;
        return this;
    }

    @androidx.annotation.ai
    public an c(@androidx.annotation.ah View view, boolean z) {
        if (this.k != null) {
            return this.k.c(view, z);
        }
        return (z ? this.H : this.I).f860a.get(view);
    }

    String c(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.h != -1) {
            str2 = str2 + "dur(" + this.h + ") ";
        }
        if (this.w != -1) {
            str2 = str2 + "dly(" + this.w + ") ";
        }
        if (this.x != null) {
            str2 = str2 + "interp(" + this.x + ") ";
        }
        if (this.i.size() <= 0 && this.j.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.i.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.i.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.i.get(i);
            }
            str3 = str4;
        }
        if (this.j.size() > 0) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.j.get(i2);
            }
        }
        return str3 + ")";
    }

    void c(an anVar) {
        String[] strArrA;
        if (this.n == null || anVar.f859a.isEmpty() || (strArrA = this.n.a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrA.length) {
                z = true;
                break;
            } else if (!anVar.f859a.containsKey(strArrA[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.n.a(anVar);
    }

    void c(boolean z) {
        if (z) {
            this.H.f860a.clear();
            this.H.b.clear();
            this.H.c.d();
        } else {
            this.I.f860a.clear();
            this.I.b.clear();
            this.I.c.d();
        }
    }

    public long d() {
        return this.h;
    }

    @androidx.annotation.ah
    public ag d(@androidx.annotation.ah View view) {
        this.j.remove(view);
        return this;
    }

    an d(View view, boolean z) {
        if (this.k != null) {
            return this.k.d(view, z);
        }
        ArrayList<an> arrayList = z ? this.K : this.L;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            an anVar = arrayList.get(i2);
            if (anVar == null) {
                return null;
            }
            if (anVar.b == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            return (z ? this.L : this.K).get(i);
        }
        return null;
    }

    void d(boolean z) {
        this.l = z;
    }

    public long e() {
        return this.w;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void e(View view) {
        if (this.Q) {
            return;
        }
        androidx.c.a<Animator, a> aVarB = b();
        int size = aVarB.size();
        bj bjVarB = ay.b(view);
        for (int i = size - 1; i >= 0; i--) {
            a aVarC = aVarB.c(i);
            if (aVarC.f849a != null && bjVarB.equals(aVarC.d)) {
                androidx.j.a.a(aVarB.b(i));
            }
        }
        if (this.R != null && this.R.size() > 0) {
            ArrayList arrayList = (ArrayList) this.R.clone();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((e) arrayList.get(i2)).c(this);
            }
        }
        this.P = true;
    }

    @androidx.annotation.ai
    public TimeInterpolator f() {
        return this.x;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void f(View view) {
        if (this.P) {
            if (!this.Q) {
                androidx.c.a<Animator, a> aVarB = b();
                int size = aVarB.size();
                bj bjVarB = ay.b(view);
                for (int i = size - 1; i >= 0; i--) {
                    a aVarC = aVarB.c(i);
                    if (aVarC.f849a != null && bjVarB.equals(aVarC.d)) {
                        androidx.j.a.b(aVarB.b(i));
                    }
                }
                if (this.R != null && this.R.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.R.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((e) arrayList.get(i2)).d(this);
                    }
                }
            }
            this.P = false;
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void g() {
        l();
        androidx.c.a<Animator, a> aVarB = b();
        for (Animator animator : this.S) {
            if (aVarB.containsKey(animator)) {
                l();
                a(animator, aVarB);
            }
        }
        this.S.clear();
        m();
    }

    @androidx.annotation.ah
    public List<Integer> h() {
        return this.i;
    }

    @androidx.annotation.ah
    public List<View> i() {
        return this.j;
    }

    @androidx.annotation.ai
    public List<String> j() {
        return this.y;
    }

    @androidx.annotation.ai
    public List<Class<?>> k() {
        return this.z;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void l() {
        if (this.O == 0) {
            if (this.R != null && this.R.size() > 0) {
                ArrayList arrayList = (ArrayList) this.R.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((e) arrayList.get(i)).e(this);
                }
            }
            this.Q = false;
        }
        this.O++;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void m() {
        this.O--;
        if (this.O == 0) {
            if (this.R != null && this.R.size() > 0) {
                ArrayList arrayList = (ArrayList) this.R.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((e) arrayList.get(i)).b(this);
                }
            }
            for (int i2 = 0; i2 < this.H.c.b(); i2++) {
                View viewC = this.H.c.c(i2);
                if (viewC != null) {
                    androidx.core.n.af.a(viewC, false);
                }
            }
            for (int i3 = 0; i3 < this.I.c.b(); i3++) {
                View viewC2 = this.I.c.c(i3);
                if (viewC2 != null) {
                    androidx.core.n.af.a(viewC2, false);
                }
            }
            this.Q = true;
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    protected void n() {
        for (int size = this.m.size() - 1; size >= 0; size--) {
            this.m.get(size).cancel();
        }
        if (this.R == null || this.R.size() <= 0) {
            return;
        }
        ArrayList arrayList = (ArrayList) this.R.clone();
        int size2 = arrayList.size();
        for (int i = 0; i < size2; i++) {
            ((e) arrayList.get(i)).a(this);
        }
    }

    @androidx.annotation.ah
    public w o() {
        return this.V;
    }

    @androidx.annotation.ai
    public c p() {
        return this.T;
    }

    @androidx.annotation.ai
    public Rect q() {
        if (this.T == null) {
            return null;
        }
        return this.T.a(this);
    }

    @androidx.annotation.ai
    public ak r() {
        return this.n;
    }

    @Override // 
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ag clone() {
        try {
            ag agVar = (ag) super.clone();
            agVar.S = new ArrayList<>();
            agVar.H = new ao();
            agVar.I = new ao();
            agVar.K = null;
            agVar.L = null;
            return agVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @androidx.annotation.ah
    public String t() {
        return this.v;
    }

    public String toString() {
        return c(com.yftech.service.upgrade.a.d);
    }
}
