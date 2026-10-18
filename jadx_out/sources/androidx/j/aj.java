package androidx.j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class aj {
    private static final String b = "TransitionManager";
    private androidx.c.a<ac, ag> d = new androidx.c.a<>();
    private androidx.c.a<ac, androidx.c.a<ac, ag>> e = new androidx.c.a<>();
    private static ag c = new c();
    private static ThreadLocal<WeakReference<androidx.c.a<ViewGroup, ArrayList<ag>>>> f = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ArrayList<ViewGroup> f851a = new ArrayList<>();

    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ag f852a;
        ViewGroup b;

        a(ag agVar, ViewGroup viewGroup) {
            this.f852a = agVar;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!aj.f851a.remove(this.b)) {
                return true;
            }
            final androidx.c.a<ViewGroup, ArrayList<ag>> aVarA = aj.a();
            ArrayList<ag> arrayList = aVarA.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarA.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f852a);
            this.f852a.a(new ai() { // from class: androidx.j.aj.a.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.j.ai, androidx.j.ag.e
                public void b(@androidx.annotation.ah ag agVar) {
                    ((ArrayList) aVarA.get(a.this.b)).remove(agVar);
                    agVar.b(this);
                }
            });
            this.f852a.a(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((ag) it.next()).f(this.b);
                }
            }
            this.f852a.a(this.b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            aj.f851a.remove(this.b);
            ArrayList<ag> arrayList = aj.a().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ag> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().f(this.b);
                }
            }
            this.f852a.c(true);
        }
    }

    static androidx.c.a<ViewGroup, ArrayList<ag>> a() {
        androidx.c.a<ViewGroup, ArrayList<ag>> aVar;
        WeakReference<androidx.c.a<ViewGroup, ArrayList<ag>>> weakReference = f.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.c.a<ViewGroup, ArrayList<ag>> aVar2 = new androidx.c.a<>();
        f.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    public static void a(@androidx.annotation.ah ViewGroup viewGroup) {
        a(viewGroup, (ag) null);
    }

    public static void a(@androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ai ag agVar) {
        if (f851a.contains(viewGroup) || !androidx.core.n.af.ag(viewGroup)) {
            return;
        }
        f851a.add(viewGroup);
        if (agVar == null) {
            agVar = c;
        }
        ag agVarClone = agVar.clone();
        c(viewGroup, agVarClone);
        ac.a(viewGroup, null);
        b(viewGroup, agVarClone);
    }

    public static void b(ViewGroup viewGroup) {
        f851a.remove(viewGroup);
        ArrayList<ag> arrayList = a().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ((ag) arrayList2.get(size)).b(viewGroup);
        }
    }

    private static void b(ViewGroup viewGroup, ag agVar) {
        if (agVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(agVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void b(@androidx.annotation.ah ac acVar) {
        c(acVar, c);
    }

    public static void b(@androidx.annotation.ah ac acVar, @androidx.annotation.ai ag agVar) {
        c(acVar, agVar);
    }

    private ag c(ac acVar) {
        ac acVarA;
        androidx.c.a<ac, ag> aVar;
        ag agVar;
        ViewGroup viewGroupA = acVar.a();
        if (viewGroupA != null && (acVarA = ac.a(viewGroupA)) != null && (aVar = this.e.get(acVar)) != null && (agVar = aVar.get(acVarA)) != null) {
            return agVar;
        }
        ag agVar2 = this.d.get(acVar);
        return agVar2 != null ? agVar2 : c;
    }

    private static void c(ViewGroup viewGroup, ag agVar) {
        ArrayList<ag> arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<ag> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().e(viewGroup);
            }
        }
        if (agVar != null) {
            agVar.a(viewGroup, true);
        }
        ac acVarA = ac.a(viewGroup);
        if (acVarA != null) {
            acVarA.b();
        }
    }

    private static void c(ac acVar, ag agVar) {
        ViewGroup viewGroupA = acVar.a();
        if (f851a.contains(viewGroupA)) {
            return;
        }
        ac acVarA = ac.a(viewGroupA);
        if (agVar == null) {
            if (acVarA != null) {
                acVarA.b();
            }
            acVar.c();
            return;
        }
        f851a.add(viewGroupA);
        ag agVarClone = agVar.clone();
        agVarClone.c(viewGroupA);
        if (acVarA != null && acVarA.d()) {
            agVarClone.d(true);
        }
        c(viewGroupA, agVarClone);
        acVar.c();
        b(viewGroupA, agVarClone);
    }

    public void a(@androidx.annotation.ah ac acVar) {
        c(acVar, c(acVar));
    }

    public void a(@androidx.annotation.ah ac acVar, @androidx.annotation.ah ac acVar2, @androidx.annotation.ai ag agVar) {
        androidx.c.a<ac, ag> aVar = this.e.get(acVar2);
        if (aVar == null) {
            aVar = new androidx.c.a<>();
            this.e.put(acVar2, aVar);
        }
        aVar.put(acVar, agVar);
    }

    public void a(@androidx.annotation.ah ac acVar, @androidx.annotation.ai ag agVar) {
        this.d.put(acVar, agVar);
    }
}
