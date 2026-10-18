package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.core.n.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
final class k extends j implements LayoutInflater.Factory2 {
    static final Interpolator J = new DecelerateInterpolator(2.5f);
    static final Interpolator K = new DecelerateInterpolator(1.5f);
    static final int L = 220;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 4;
    public static final int Q = 5;
    public static final int R = 6;
    static boolean c = false;
    static final String d = "FragmentManager";
    static final String e = "android:target_req_state";
    static final String f = "android:target_state";
    static final String g = "android:view_state";
    static final String h = "android:user_visible_hint";
    boolean A;
    boolean B;
    ArrayList<androidx.fragment.app.a> C;
    ArrayList<Boolean> D;
    ArrayList<androidx.fragment.app.d> E;
    ArrayList<g> H;
    private OnBackPressedDispatcher S;
    private n V;
    ArrayList<e> i;
    boolean j;
    ArrayList<androidx.fragment.app.a> n;
    ArrayList<androidx.fragment.app.d> o;
    ArrayList<androidx.fragment.app.a> p;
    ArrayList<Integer> q;
    ArrayList<j.c> r;
    i t;
    androidx.fragment.app.f u;
    androidx.fragment.app.d v;

    @ai
    androidx.fragment.app.d w;
    boolean x;
    boolean y;
    boolean z;
    int k = 0;
    final ArrayList<androidx.fragment.app.d> l = new ArrayList<>();
    final HashMap<String, androidx.fragment.app.d> m = new HashMap<>();
    private final androidx.activity.c T = new androidx.activity.c(false) { // from class: androidx.fragment.app.k.1
        @Override // androidx.activity.c
        public void c() {
            k.this.l();
        }
    };
    private final CopyOnWriteArrayList<c> U = new CopyOnWriteArrayList<>();
    int s = 0;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    Runnable I = new Runnable() { // from class: androidx.fragment.app.k.2
        @Override // java.lang.Runnable
        public void run() {
            k.this.q();
        }
    };

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f771a;
        public final Animator b;

        a(Animator animator) {
            this.f771a = null;
            this.b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        a(Animation animation) {
            this.f771a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f772a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;

        b(@ah Animation animation, @ah ViewGroup viewGroup, @ah View view) {
            super(false);
            this.e = true;
            this.f772a = viewGroup;
            this.b = view;
            addAnimation(animation);
            this.f772a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                z.a(this.f772a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                z.a(this.f772a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c || !this.e) {
                this.f772a.endViewTransition(this.b);
                this.d = true;
            } else {
                this.e = false;
                this.f772a.post(this);
            }
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final j.b f773a;
        final boolean b;

        c(j.b bVar, boolean z) {
            this.f773a = bVar;
            this.b = z;
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f774a = {R.attr.name, R.attr.id, R.attr.tag};
        public static final int b = 1;
        public static final int c = 0;
        public static final int d = 2;

        private d() {
        }
    }

    interface e {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f775a;
        final int b;
        final int c;

        f(String str, int i, int i2) {
            this.f775a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.k.e
        public boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            if (k.this.w == null || this.b >= 0 || this.f775a != null || !k.this.w.H().e()) {
                return k.this.a(arrayList, arrayList2, this.f775a, this.b, this.c);
            }
            return false;
        }
    }

    static class g implements androidx.fragment.app.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f776a;
        final androidx.fragment.app.a b;
        private int c;

        g(androidx.fragment.app.a aVar, boolean z) {
            this.f776a = z;
            this.b = aVar;
        }

        @Override // androidx.fragment.app.d.c
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.b.b.p();
        }

        @Override // androidx.fragment.app.d.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        public void d() {
            boolean z = this.c > 0;
            k kVar = this.b.b;
            int size = kVar.l.size();
            for (int i = 0; i < size; i++) {
                androidx.fragment.app.d dVar = kVar.l.get(i);
                dVar.a((androidx.fragment.app.d.c) null);
                if (z && dVar.aI()) {
                    dVar.an();
                }
            }
            this.b.b.a(this.b, this.f776a, !z, true);
        }

        public void e() {
            this.b.b.a(this.b, this.f776a, false, false);
        }
    }

    k() {
    }

    private void I() {
        if (this.i == null || this.i.isEmpty()) {
            this.T.a(f() > 0 && b(this.v));
        } else {
            this.T.a(true);
        }
    }

    private void J() {
        if (k()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void K() {
        this.j = false;
        this.D.clear();
        this.C.clear();
    }

    private void L() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                this.H.remove(0).d();
            }
        }
    }

    private void M() {
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null) {
                if (dVar.aF() != null) {
                    int iAH = dVar.aH();
                    View viewAF = dVar.aF();
                    Animation animation = viewAF.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewAF.clearAnimation();
                    }
                    dVar.c((View) null);
                    a(dVar, iAH, 0, 0, false);
                } else if (dVar.aG() != null) {
                    dVar.aG().end();
                }
            }
        }
    }

    private void N() {
        this.m.values().removeAll(Collections.singleton(null));
    }

    private int a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, androidx.c.b<androidx.fragment.app.d> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.l() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                g gVar = new g(aVar, zBooleanValue);
                this.H.add(gVar);
                aVar.a(gVar);
                if (zBooleanValue) {
                    aVar.k();
                } else {
                    aVar.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    static a a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        return new a(alphaAnimation);
    }

    static a a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(J);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(K);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new a(animationSet);
    }

    private void a(androidx.c.b<androidx.fragment.app.d> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.d dVarB = bVar.b(i);
            if (!dVarB.C) {
                View viewY = dVarB.Y();
                dVarB.af = viewY.getAlpha();
                viewY.setAlpha(0.0f);
            }
        }
    }

    private void a(@ah final androidx.fragment.app.d dVar, @ah a aVar, int i) {
        final View view = dVar.X;
        final ViewGroup viewGroup = dVar.W;
        viewGroup.startViewTransition(view);
        dVar.d(i);
        if (aVar.f771a != null) {
            b bVar = new b(aVar.f771a, viewGroup, view);
            dVar.c(dVar.X);
            bVar.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.k.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.k.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (dVar.aF() != null) {
                                dVar.c((View) null);
                                k.this.a(dVar, dVar.aH(), 0, 0, false);
                            }
                        }
                    });
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            dVar.X.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.b;
        dVar.a(aVar.b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.k.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animatorAG = dVar.aG();
                dVar.a((Animator) null);
                if (animatorAG == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                k.this.a(dVar, dVar.aH(), 0, 0, false);
            }
        });
        animator.setTarget(dVar.X);
        animator.start();
    }

    private void a(RuntimeException runtimeException) {
        Log.e(d, runtimeException.getMessage());
        Log.e(d, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.m.d(d));
        if (this.t != null) {
            try {
                this.t.a("  ", (FileDescriptor) null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e(d, "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e(d, "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        int size = this.H == null ? 0 : this.H.size();
        int i = 0;
        while (i < size) {
            g gVar = this.H.get(i);
            if (arrayList != null && !gVar.f776a && (iIndexOf2 = arrayList.indexOf(gVar.b)) != -1 && arrayList2.get(iIndexOf2).booleanValue()) {
                this.H.remove(i);
                i--;
                size--;
                gVar.e();
            } else if (gVar.c() || (arrayList != null && gVar.b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i);
                i--;
                size--;
                if (arrayList == null || gVar.f776a || (iIndexOf = arrayList.indexOf(gVar.b)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                    gVar.d();
                } else {
                    gVar.e();
                }
            }
            i++;
        }
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).F;
        if (this.E == null) {
            this.E = new ArrayList<>();
        } else {
            this.E.clear();
        }
        this.E.addAll(this.l);
        androidx.fragment.app.d dVarI = i();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            dVarI = !arrayList2.get(i5).booleanValue() ? aVar.a(this.E, dVarI) : aVar.b(this.E, dVarI);
            z2 = z2 || aVar.w;
        }
        this.E.clear();
        if (!z) {
            t.a(this, arrayList, arrayList2, i, i2, false);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            androidx.c.b<androidx.fragment.app.d> bVar = new androidx.c.b<>();
            b(bVar);
            int iA = a(arrayList, arrayList2, i, i2, bVar);
            a(bVar);
            i3 = iA;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            t.a(this, arrayList, arrayList2, i, i3, true);
            a(this.s, true);
        }
        while (i4 < i2) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && aVar2.d >= 0) {
                d(aVar2.d);
                aVar2.d = -1;
            }
            aVar2.f();
            i4++;
        }
        if (z2) {
            s();
        }
    }

    private boolean a(String str, int i, int i2) {
        q();
        d(true);
        if (this.w != null && i < 0 && str == null && this.w.H().e()) {
            return true;
        }
        boolean zA = a(this.C, this.D, str, i, i2);
        if (zA) {
            this.j = true;
            try {
                b(this.C, this.D);
                K();
            } catch (Throwable th) {
                K();
                throw th;
            }
        }
        I();
        r();
        N();
        return zA;
    }

    public static int b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    private void b(androidx.c.b<androidx.fragment.app.d> bVar) {
        if (this.s < 1) {
            return;
        }
        int iMin = Math.min(this.s, 3);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar.t < iMin) {
                a(dVar, iMin, dVar.aA(), dVar.aB(), false);
                if (dVar.X != null && !dVar.Q && dVar.ad) {
                    bVar.add(dVar);
                }
            }
        }
    }

    private void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).F) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).F) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    private static void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.a aVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                aVar.b(i == i2 + (-1));
            } else {
                aVar.a(1);
                aVar.k();
            }
            i++;
        }
    }

    private boolean c(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.i != null && this.i.size() != 0) {
                int size = this.i.size();
                boolean zA = false;
                for (int i = 0; i < size; i++) {
                    zA |= this.i.get(i).a(arrayList, arrayList2);
                }
                this.i.clear();
                this.t.m().removeCallbacks(this.I);
                return zA;
            }
            return false;
        }
    }

    private void d(boolean z) {
        if (this.j) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.t == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.t.m().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            J();
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
            this.D = new ArrayList<>();
        }
        this.j = true;
        try {
            a((ArrayList<androidx.fragment.app.a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.j = false;
        }
    }

    public static int e(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i == 4099) {
            return s.N;
        }
        if (i != 8194) {
            return 0;
        }
        return s.L;
    }

    private void f(int i) {
        try {
            this.j = true;
            a(i, false);
            this.j = false;
            q();
        } catch (Throwable th) {
            this.j = false;
            throw th;
        }
    }

    private androidx.fragment.app.d v(androidx.fragment.app.d dVar) {
        ViewGroup viewGroup = dVar.W;
        View view = dVar.X;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int iIndexOf = this.l.indexOf(dVar) - 1; iIndexOf >= 0; iIndexOf--) {
            androidx.fragment.app.d dVar2 = this.l.get(iIndexOf);
            if (dVar2.W == viewGroup && dVar2.X != null) {
                return dVar2;
            }
        }
        return null;
    }

    private void w(@ai androidx.fragment.app.d dVar) {
        if (dVar == null || this.m.get(dVar.x) != dVar) {
            return;
        }
        dVar.at();
    }

    private boolean x(androidx.fragment.app.d dVar) {
        return (dVar.U && dVar.V) || dVar.L.G();
    }

    public void A() {
        f(3);
    }

    public void B() {
        this.z = true;
        f(2);
    }

    public void C() {
        f(1);
    }

    public void D() {
        this.A = true;
        q();
        f(0);
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.S != null) {
            this.T.b();
            this.S = null;
        }
    }

    public void E() {
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null) {
                dVar.au();
            }
        }
    }

    void F() {
        I();
        w(this.w);
    }

    boolean G() {
        boolean zX = false;
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null) {
                zX = x(dVar);
            }
            if (zX) {
                return true;
            }
        }
        return false;
    }

    LayoutInflater.Factory2 H() {
        return this;
    }

    public int a(androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.q != null && this.q.size() > 0) {
                int iIntValue = this.q.remove(this.q.size() - 1).intValue();
                if (c) {
                    Log.v(d, "Adding back stack index " + iIntValue + " with " + aVar);
                }
                this.p.set(iIntValue, aVar);
                return iIntValue;
            }
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            int size = this.p.size();
            if (c) {
                Log.v(d, "Setting back stack index " + size + " to " + aVar);
            }
            this.p.add(aVar);
            return size;
        }
    }

    @Override // androidx.fragment.app.j
    @ai
    public androidx.fragment.app.d.C0058d a(@ah androidx.fragment.app.d dVar) {
        Bundle bundleT;
        if (dVar.J != this) {
            a(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        if (dVar.t <= 0 || (bundleT = t(dVar)) == null) {
            return null;
        }
        return new androidx.fragment.app.d.C0058d(bundleT);
    }

    @Override // androidx.fragment.app.j
    @ai
    public androidx.fragment.app.d a(int i) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.l.get(size);
            if (dVar != null && dVar.N == i) {
                return dVar;
            }
        }
        for (androidx.fragment.app.d dVar2 : this.m.values()) {
            if (dVar2 != null && dVar2.N == i) {
                return dVar2;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.j
    @ai
    public androidx.fragment.app.d a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        androidx.fragment.app.d dVar = this.m.get(string);
        if (dVar == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return dVar;
    }

    @Override // androidx.fragment.app.j
    @ai
    public androidx.fragment.app.d a(@ai String str) {
        if (str != null) {
            for (int size = this.l.size() - 1; size >= 0; size--) {
                androidx.fragment.app.d dVar = this.l.get(size);
                if (dVar != null && str.equals(dVar.P)) {
                    return dVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (androidx.fragment.app.d dVar2 : this.m.values()) {
            if (dVar2 != null && str.equals(dVar2.P)) {
                return dVar2;
            }
        }
        return null;
    }

    a a(androidx.fragment.app.d dVar, int i, boolean z, int i2) {
        int iB;
        int iAA = dVar.aA();
        boolean z2 = false;
        dVar.c(0);
        if (dVar.W != null && dVar.W.getLayoutTransition() != null) {
            return null;
        }
        Animation animationA = dVar.a(i, z, iAA);
        if (animationA != null) {
            return new a(animationA);
        }
        Animator animatorB = dVar.b(i, z, iAA);
        if (animatorB != null) {
            return new a(animatorB);
        }
        if (iAA != 0) {
            boolean zEquals = "anim".equals(this.t.l().getResources().getResourceTypeName(iAA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.t.l(), iAA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.t.l(), iAA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.t.l(), iAA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iB = b(i, z)) < 0) {
            return null;
        }
        switch (iB) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(0.0f, 1.0f);
            case 6:
                return a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.t.h()) {
                    i2 = this.t.i();
                }
                return i2 == 0 ? null : null;
        }
    }

    @Override // androidx.fragment.app.j
    @ah
    public s a() {
        return new androidx.fragment.app.a(this);
    }

    @Override // androidx.fragment.app.j
    public void a(int i, int i2) {
        if (i >= 0) {
            a((e) new f(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public void a(int i, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            int size = this.p.size();
            if (i < size) {
                if (c) {
                    Log.v(d, "Setting back stack index " + i + " to " + aVar);
                }
                this.p.set(i, aVar);
            } else {
                while (size < i) {
                    this.p.add(null);
                    if (this.q == null) {
                        this.q = new ArrayList<>();
                    }
                    if (c) {
                        Log.v(d, "Adding available back stack index " + size);
                    }
                    this.q.add(Integer.valueOf(size));
                    size++;
                }
                if (c) {
                    Log.v(d, "Adding back stack index " + i + " with " + aVar);
                }
                this.p.add(aVar);
            }
        }
    }

    void a(int i, boolean z) {
        if (this.t == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.s) {
            this.s = i;
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                k(this.l.get(i2));
            }
            for (androidx.fragment.app.d dVar : this.m.values()) {
                if (dVar != null && (dVar.D || dVar.R)) {
                    if (!dVar.ad) {
                        k(dVar);
                    }
                }
            }
            o();
            if (this.x && this.t != null && this.s == 4) {
                this.t.g();
                this.x = false;
            }
        }
    }

    public void a(@ah Configuration configuration) {
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null) {
                dVar.a(configuration);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public void a(Bundle bundle, String str, androidx.fragment.app.d dVar) {
        if (dVar.J != this) {
            a(new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, dVar.x);
    }

    void a(Parcelable parcelable) {
        p next;
        if (parcelable == null) {
            return;
        }
        m mVar = (m) parcelable;
        if (mVar.f778a == null) {
            return;
        }
        for (androidx.fragment.app.d dVar : this.V.c()) {
            if (c) {
                Log.v(d, "restoreSaveState: re-attaching retained " + dVar);
            }
            Iterator<p> it = mVar.f778a.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.b.equals(dVar.x));
            if (next == null) {
                if (c) {
                    Log.v(d, "Discarding retained Fragment " + dVar + " that was not found in the set of active Fragments " + mVar.f778a);
                }
                a(dVar, 1, 0, 0, false);
                dVar.D = true;
                a(dVar, 0, 0, 0, false);
            } else {
                next.n = dVar;
                dVar.v = null;
                dVar.I = 0;
                dVar.F = false;
                dVar.C = false;
                dVar.A = dVar.z != null ? dVar.z.x : null;
                dVar.z = null;
                if (next.m != null) {
                    next.m.setClassLoader(this.t.l().getClassLoader());
                    dVar.v = next.m.getSparseParcelableArray(g);
                    dVar.u = next.m;
                }
            }
        }
        this.m.clear();
        for (p pVar : mVar.f778a) {
            if (pVar != null) {
                androidx.fragment.app.d dVarA = pVar.a(this.t.l().getClassLoader(), j());
                dVarA.J = this;
                if (c) {
                    Log.v(d, "restoreSaveState: active (" + dVarA.x + "): " + dVarA);
                }
                this.m.put(dVarA.x, dVarA);
                pVar.n = null;
            }
        }
        this.l.clear();
        if (mVar.b != null) {
            for (String str : mVar.b) {
                androidx.fragment.app.d dVar2 = this.m.get(str);
                if (dVar2 == null) {
                    a(new IllegalStateException("No instantiated fragment for (" + str + ")"));
                }
                dVar2.C = true;
                if (c) {
                    Log.v(d, "restoreSaveState: added (" + str + "): " + dVar2);
                }
                if (this.l.contains(dVar2)) {
                    throw new IllegalStateException("Already added " + dVar2);
                }
                synchronized (this.l) {
                    this.l.add(dVar2);
                }
            }
        }
        if (mVar.c != null) {
            this.n = new ArrayList<>(mVar.c.length);
            for (int i = 0; i < mVar.c.length; i++) {
                androidx.fragment.app.a aVarA = mVar.c[i].a(this);
                if (c) {
                    Log.v(d, "restoreAllState: back stack #" + i + " (index " + aVarA.d + "): " + aVarA);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.m.d(d));
                    aVarA.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.n.add(aVarA);
                if (aVarA.d >= 0) {
                    a(aVarA.d, aVarA);
                }
            }
        } else {
            this.n = null;
        }
        if (mVar.d != null) {
            this.w = this.m.get(mVar.d);
            w(this.w);
        }
        this.k = mVar.e;
    }

    void a(Parcelable parcelable, l lVar) {
        if (this.t instanceof androidx.lifecycle.y) {
            a(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.V.a(lVar);
        a(parcelable);
    }

    void a(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.k();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            t.a(this, (ArrayList<androidx.fragment.app.a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.s, true);
        }
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null && dVar.X != null && dVar.ad && aVar.b(dVar.O)) {
                if (dVar.af > 0.0f) {
                    dVar.X.setAlpha(dVar.af);
                }
                if (z3) {
                    dVar.af = 0.0f;
                } else {
                    dVar.af = -1.0f;
                    dVar.ad = false;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:255:0x04e8 A[FALL_THROUGH, PHI: r11
      0x04e8: PHI (r11v1 int) = 
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v0 int)
      (r11v2 int)
      (r11v2 int)
     binds: [B:153:0x032e, B:155:0x0332, B:202:0x0411, B:241:0x04b4, B:253:0x04e0, B:247:0x04c9, B:249:0x04d5, B:251:0x04db, B:252:0x04dd, B:45:0x007d, B:147:0x0304, B:151:0x0320] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:258:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:258:0x04ed, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    void a(androidx.fragment.app.d dVar, int i, int i2, int i3, boolean z) {
        int i4;
        androidx.fragment.app.d dVar2;
        ViewGroup viewGroup;
        String resourceName;
        int i5 = 1;
        boolean zIsChangingConfigurations = true;
        if (!dVar.C || dVar.R) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (dVar.D && i4 > dVar.t) {
            i4 = (dVar.t == 0 && dVar.q()) ? 1 : dVar.t;
        }
        if (dVar.Z && dVar.t < 3 && i4 > 2) {
            i4 = 2;
        }
        int iMin = dVar.ai == androidx.lifecycle.g.b.CREATED ? Math.min(i4, 1) : Math.min(i4, dVar.ai.ordinal());
        if (dVar.t > iMin) {
            if (dVar.t > iMin) {
                switch (dVar.t) {
                    case 4:
                        if (iMin < 4) {
                            if (c) {
                                Log.v(d, "movefrom RESUMED: " + dVar);
                            }
                            dVar.av();
                            d(dVar, false);
                            break;
                        }
                    case 3:
                        if (iMin < 3) {
                            if (c) {
                                Log.v(d, "movefrom STARTED: " + dVar);
                            }
                            dVar.aw();
                            e(dVar, false);
                            break;
                        }
                    case 2:
                        if (iMin < 2) {
                            if (c) {
                                Log.v(d, "movefrom ACTIVITY_CREATED: " + dVar);
                            }
                            if (dVar.X != null && this.t.a(dVar) && dVar.v == null) {
                                s(dVar);
                            }
                            dVar.ax();
                            f(dVar, false);
                            if (dVar.X != null && dVar.W != null) {
                                dVar.W.endViewTransition(dVar.X);
                                dVar.X.clearAnimation();
                                if (dVar.I() == null || !dVar.I().D) {
                                    a aVarA = (this.s <= 0 || this.A || dVar.X.getVisibility() != 0 || dVar.af < 0.0f) ? null : a(dVar, i2, false, i3);
                                    dVar.af = 0.0f;
                                    if (aVarA != null) {
                                        a(dVar, aVarA, iMin);
                                    }
                                    dVar.W.removeView(dVar.X);
                                }
                            }
                            dVar.W = null;
                            dVar.X = null;
                            dVar.ak = null;
                            dVar.al.b((androidx.lifecycle.j) null);
                            dVar.Y = null;
                            dVar.F = false;
                            break;
                        }
                    case 1:
                        if (iMin < 1) {
                            if (this.A) {
                                if (dVar.aF() != null) {
                                    View viewAF = dVar.aF();
                                    dVar.c((View) null);
                                    viewAF.clearAnimation();
                                } else if (dVar.aG() != null) {
                                    Animator animatorAG = dVar.aG();
                                    dVar.a((Animator) null);
                                    animatorAG.cancel();
                                }
                            }
                            if (dVar.aF() == null && dVar.aG() == null) {
                                if (c) {
                                    Log.v(d, "movefrom CREATED: " + dVar);
                                }
                                Object[] objArr = dVar.D && !dVar.q();
                                if (objArr == true || this.V.b(dVar)) {
                                    if (this.t instanceof androidx.lifecycle.y) {
                                        zIsChangingConfigurations = this.V.b();
                                    } else if (this.t.l() instanceof Activity) {
                                        zIsChangingConfigurations = true ^ ((Activity) this.t.l()).isChangingConfigurations();
                                    }
                                    if (objArr != false || zIsChangingConfigurations) {
                                        this.V.f(dVar);
                                    }
                                    dVar.ay();
                                    g(dVar, false);
                                } else {
                                    dVar.t = 0;
                                }
                                dVar.az();
                                h(dVar, false);
                                if (!z) {
                                    if (objArr == true || this.V.b(dVar)) {
                                        m(dVar);
                                    } else {
                                        dVar.K = null;
                                        dVar.M = null;
                                        dVar.J = null;
                                        if (dVar.A != null && (dVar2 = this.m.get(dVar.A)) != null && dVar2.T()) {
                                            dVar.z = dVar2;
                                        }
                                    }
                                }
                            } else {
                                dVar.d(iMin);
                            }
                            break;
                        }
                    default:
                        i5 = iMin;
                        break;
                }
            }
            if (dVar.t != i5) {
                Log.w(d, "moveToState: Fragment state for " + dVar + " not updated inline; expected state " + i5 + " found " + dVar.t);
                dVar.t = i5;
            }
        }
        if (dVar.E && !dVar.F) {
            return;
        }
        if (dVar.aF() != null || dVar.aG() != null) {
            dVar.c((View) null);
            dVar.a((Animator) null);
            a(dVar, dVar.aH(), 0, 0, true);
        }
        switch (dVar.t) {
            case 0:
                if (iMin > 0) {
                    if (c) {
                        Log.v(d, "moveto CREATED: " + dVar);
                    }
                    if (dVar.u != null) {
                        dVar.u.setClassLoader(this.t.l().getClassLoader());
                        dVar.v = dVar.u.getSparseParcelableArray(g);
                        androidx.fragment.app.d dVarA = a(dVar.u, f);
                        dVar.A = dVarA != null ? dVarA.x : null;
                        if (dVar.A != null) {
                            dVar.B = dVar.u.getInt(e, 0);
                        }
                        if (dVar.w != null) {
                            dVar.aa = dVar.w.booleanValue();
                            dVar.w = null;
                        } else {
                            dVar.aa = dVar.u.getBoolean(h, true);
                        }
                        if (!dVar.aa) {
                            dVar.Z = true;
                            if (iMin > 2) {
                                iMin = 2;
                            }
                        }
                    }
                    dVar.K = this.t;
                    dVar.M = this.v;
                    dVar.J = this.v != null ? this.v.L : this.t.b;
                    if (dVar.z != null) {
                        if (this.m.get(dVar.z.x) != dVar.z) {
                            throw new IllegalStateException("Fragment " + dVar + " declared target fragment " + dVar.z + " that does not belong to this FragmentManager!");
                        }
                        if (dVar.z.t < 1) {
                            a(dVar.z, 1, 0, 0, true);
                        }
                        dVar.A = dVar.z.x;
                        dVar.z = null;
                    }
                    if (dVar.A != null) {
                        androidx.fragment.app.d dVar3 = this.m.get(dVar.A);
                        if (dVar3 == null) {
                            throw new IllegalStateException("Fragment " + dVar + " declared target fragment " + dVar.A + " that does not belong to this FragmentManager!");
                        }
                        if (dVar3.t < 1) {
                            a(dVar3, 1, 0, 0, true);
                        }
                    }
                    a(dVar, this.t.l(), false);
                    dVar.ap();
                    if (dVar.M == null) {
                        this.t.b(dVar);
                    } else {
                        dVar.M.a(dVar);
                    }
                    b(dVar, this.t.l(), false);
                    if (!dVar.ah) {
                        a(dVar, dVar.u, false);
                        dVar.l(dVar.u);
                        b(dVar, dVar.u, false);
                    } else {
                        dVar.j(dVar.u);
                        dVar.t = 1;
                    }
                    break;
                }
            case 1:
                if (iMin > 0) {
                    i(dVar);
                }
                if (iMin > 1) {
                    if (c) {
                        Log.v(d, "moveto ACTIVITY_CREATED: " + dVar);
                    }
                    if (!dVar.E) {
                        if (dVar.O != 0) {
                            if (dVar.O == -1) {
                                a(new IllegalArgumentException("Cannot create fragment " + dVar + " for a container view with no id"));
                            }
                            viewGroup = (ViewGroup) this.u.a(dVar.O);
                            if (viewGroup == null && !dVar.G) {
                                try {
                                    resourceName = dVar.E().getResourceName(dVar.O);
                                } catch (Resources.NotFoundException unused) {
                                    resourceName = androidx.core.i.d.f448a;
                                }
                                a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(dVar.O) + " (" + resourceName + ") for fragment " + dVar));
                            }
                        } else {
                            viewGroup = null;
                        }
                        dVar.W = viewGroup;
                        dVar.b(dVar.h(dVar.u), viewGroup, dVar.u);
                        if (dVar.X != null) {
                            dVar.Y = dVar.X;
                            dVar.X.setSaveFromParentEnabled(false);
                            if (viewGroup != null) {
                                viewGroup.addView(dVar.X);
                            }
                            if (dVar.Q) {
                                dVar.X.setVisibility(8);
                            }
                            dVar.a(dVar.X, dVar.u);
                            a(dVar, dVar.X, dVar.u, false);
                            dVar.ad = dVar.X.getVisibility() == 0 && dVar.W != null;
                        } else {
                            dVar.Y = null;
                        }
                    }
                    dVar.m(dVar.u);
                    c(dVar, dVar.u, false);
                    if (dVar.X != null) {
                        dVar.f(dVar.u);
                    }
                    dVar.u = null;
                    break;
                }
            case 2:
                if (iMin > 2) {
                    if (c) {
                        Log.v(d, "moveto STARTED: " + dVar);
                    }
                    dVar.aq();
                    b(dVar, false);
                    break;
                }
            case 3:
                if (iMin > 3) {
                    if (c) {
                        Log.v(d, "moveto RESUMED: " + dVar);
                    }
                    dVar.ar();
                    c(dVar, false);
                    dVar.u = null;
                    dVar.v = null;
                    break;
                }
            default:
                i5 = iMin;
                if (dVar.t != i5) {
                    Log.w(d, "moveToState: Fragment state for " + dVar + " not updated inline; expected state " + i5 + " found " + dVar.t);
                    dVar.t = i5;
                }
        }
        i5 = iMin;
        if (dVar.t != i5) {
            Log.w(d, "moveToState: Fragment state for " + dVar + " not updated inline; expected state " + i5 + " found " + dVar.t);
            dVar.t = i5;
        }
    }

    void a(@ah androidx.fragment.app.d dVar, @ah Context context, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).a(dVar, context, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.a(this, dVar, context);
            }
        }
    }

    void a(@ah androidx.fragment.app.d dVar, @ai Bundle bundle, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).a(dVar, bundle, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.a(this, dVar, bundle);
            }
        }
    }

    void a(@ah androidx.fragment.app.d dVar, @ah View view, @ai Bundle bundle, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).a(dVar, view, bundle, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.a(this, dVar, view, bundle);
            }
        }
    }

    public void a(androidx.fragment.app.d dVar, androidx.lifecycle.g.b bVar) {
        if (this.m.get(dVar.x) == dVar && (dVar.K == null || dVar.F() == this)) {
            dVar.ai = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    public void a(androidx.fragment.app.d dVar, boolean z) {
        if (c) {
            Log.v(d, "add: " + dVar);
        }
        l(dVar);
        if (dVar.R) {
            return;
        }
        if (this.l.contains(dVar)) {
            throw new IllegalStateException("Fragment already added: " + dVar);
        }
        synchronized (this.l) {
            this.l.add(dVar);
        }
        dVar.C = true;
        dVar.D = false;
        if (dVar.X == null) {
            dVar.ae = false;
        }
        if (x(dVar)) {
            this.x = true;
        }
        if (z) {
            h(dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(@ah i iVar, @ah androidx.fragment.app.f fVar, @ai androidx.fragment.app.d dVar) {
        androidx.lifecycle.j jVar;
        if (this.t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.t = iVar;
        this.u = fVar;
        this.v = dVar;
        if (this.v != null) {
            I();
        }
        if (iVar instanceof androidx.activity.d) {
            androidx.activity.d dVar2 = (androidx.activity.d) iVar;
            this.S = dVar2.e();
            if (dVar != null) {
                jVar = dVar2;
                jVar = dVar;
            }
            jVar = dVar2;
            this.S.a(jVar, this.T);
        }
        if (dVar != null) {
            this.V = dVar.J.d(dVar);
        } else if (iVar instanceof androidx.lifecycle.y) {
            this.V = n.a(((androidx.lifecycle.y) iVar).d());
        } else {
            this.V = new n(false);
        }
    }

    @Override // androidx.fragment.app.j
    public void a(@ah j.b bVar) {
        synchronized (this.U) {
            int size = this.U.size();
            for (int i = 0; i < size; i++) {
                if (this.U.get(i).f773a == bVar) {
                    this.U.remove(i);
                    break;
                }
            }
        }
    }

    @Override // androidx.fragment.app.j
    public void a(@ah j.b bVar, boolean z) {
        this.U.add(new c(bVar, z));
    }

    @Override // androidx.fragment.app.j
    public void a(j.c cVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(cVar);
    }

    public void a(e eVar, boolean z) {
        if (!z) {
            J();
        }
        synchronized (this) {
            if (!this.A && this.t != null) {
                if (this.i == null) {
                    this.i = new ArrayList<>();
                }
                this.i.add(eVar);
                p();
                return;
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    @Override // androidx.fragment.app.j
    public void a(@ai String str, int i) {
        a((e) new f(str, -1, i), false);
    }

    @Override // androidx.fragment.app.j
    public void a(@ah String str, @ai FileDescriptor fileDescriptor, @ah PrintWriter printWriter, @ai String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.m.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (androidx.fragment.app.d dVar : this.m.values()) {
                printWriter.print(str);
                printWriter.println(dVar);
                if (dVar != null) {
                    dVar.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.l.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                androidx.fragment.app.d dVar2 = this.l.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(dVar2.toString());
            }
        }
        if (this.o != null && (size4 = this.o.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                androidx.fragment.app.d dVar3 = this.o.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(dVar3.toString());
            }
        }
        if (this.n != null && (size3 = this.n.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                androidx.fragment.app.a aVar = this.n.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.p != null && (size2 = this.p.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj = (androidx.fragment.app.a) this.p.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.q != null && this.q.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.q.toArray()));
            }
        }
        if (this.i != null && (size = this.i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = (e) this.i.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.y);
        printWriter.print(" mStopped=");
        printWriter.print(this.z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.A);
        if (this.x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.x);
        }
    }

    public boolean a(@ah Menu menu) {
        if (this.s < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null && dVar.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean a(@ah Menu menu, @ah MenuInflater menuInflater) {
        if (this.s < 1) {
            return false;
        }
        ArrayList<androidx.fragment.app.d> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null && dVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z = true;
            }
        }
        if (this.o != null) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                androidx.fragment.app.d dVar2 = this.o.get(i2);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.ad();
                }
            }
        }
        this.o = arrayList;
        return z;
    }

    public boolean a(@ah MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null && dVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        if (this.n == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = this.n.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.n.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.n.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.a aVar = this.n.get(size);
                    if ((str != null && str.equals(aVar.m())) || (i >= 0 && i == aVar.d)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        androidx.fragment.app.a aVar2 = this.n.get(size);
                        if ((str == null || !str.equals(aVar2.m())) && (i < 0 || i != aVar2.d)) {
                            break;
                        }
                        size--;
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.n.size() - 1) {
                return false;
            }
            for (int size3 = this.n.size() - 1; size3 > size; size3--) {
                arrayList.add(this.n.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    public androidx.fragment.app.d b(@ah String str) {
        androidx.fragment.app.d dVarB;
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null && (dVarB = dVar.b(str)) != null) {
                return dVarB;
            }
        }
        return null;
    }

    @Override // androidx.fragment.app.j
    public j.a b(int i) {
        return this.n.get(i);
    }

    public void b(@ah Menu menu) {
        if (this.s < 1) {
            return;
        }
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null) {
                dVar.d(menu);
            }
        }
    }

    void b(androidx.fragment.app.a aVar) {
        if (this.n == null) {
            this.n = new ArrayList<>();
        }
        this.n.add(aVar);
    }

    void b(@ah androidx.fragment.app.d dVar, @ah Context context, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).b(dVar, context, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.b(this, dVar, context);
            }
        }
    }

    void b(@ah androidx.fragment.app.d dVar, @ai Bundle bundle, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).b(dVar, bundle, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.b(this, dVar, bundle);
            }
        }
    }

    void b(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).b(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.a(this, dVar);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public void b(j.c cVar) {
        if (this.r != null) {
            this.r.remove(cVar);
        }
    }

    public void b(e eVar, boolean z) {
        if (z && (this.t == null || this.A)) {
            return;
        }
        d(z);
        if (eVar.a(this.C, this.D)) {
            this.j = true;
            try {
                b(this.C, this.D);
                K();
            } catch (Throwable th) {
                K();
                throw th;
            }
        }
        I();
        r();
        N();
    }

    public void b(boolean z) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.l.get(size);
            if (dVar != null) {
                dVar.m(z);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public boolean b(int i, int i2) {
        J();
        q();
        if (i >= 0) {
            return a((String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public boolean b(@ah MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (int i = 0; i < this.l.size(); i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null && dVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean b(@ai androidx.fragment.app.d dVar) {
        if (dVar == null) {
            return true;
        }
        k kVar = dVar.J;
        return dVar == kVar.i() && b(kVar.v);
    }

    @Override // androidx.fragment.app.j
    public boolean b(@ai String str, int i) {
        J();
        return a(str, -1, i);
    }

    @ah
    androidx.lifecycle.x c(@ah androidx.fragment.app.d dVar) {
        return this.V.e(dVar);
    }

    void c(@ah androidx.fragment.app.d dVar, @ai Bundle bundle, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).c(dVar, bundle, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.c(this, dVar, bundle);
            }
        }
    }

    void c(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).c(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.b(this, dVar);
            }
        }
    }

    public void c(boolean z) {
        for (int size = this.l.size() - 1; size >= 0; size--) {
            androidx.fragment.app.d dVar = this.l.get(size);
            if (dVar != null) {
                dVar.n(z);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public boolean c() {
        boolean zQ = q();
        L();
        return zQ;
    }

    boolean c(int i) {
        return this.s >= i;
    }

    @ah
    n d(@ah androidx.fragment.app.d dVar) {
        return this.V.d(dVar);
    }

    @Override // androidx.fragment.app.j
    public void d() {
        a((e) new f(null, -1, 0), false);
    }

    public void d(int i) {
        synchronized (this) {
            this.p.set(i, null);
            if (this.q == null) {
                this.q = new ArrayList<>();
            }
            if (c) {
                Log.v(d, "Freeing back stack index " + i);
            }
            this.q.add(Integer.valueOf(i));
        }
    }

    void d(@ah androidx.fragment.app.d dVar, @ah Bundle bundle, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).d(dVar, bundle, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.d(this, dVar, bundle);
            }
        }
    }

    void d(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).d(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.c(this, dVar);
            }
        }
    }

    void e(@ah androidx.fragment.app.d dVar) {
        if (k()) {
            if (c) {
                Log.v(d, "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.V.a(dVar) && c) {
            Log.v(d, "Updating retained Fragments: Added " + dVar);
        }
    }

    void e(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).e(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.d(this, dVar);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public boolean e() {
        J();
        return a((String) null, -1, 0);
    }

    @Override // androidx.fragment.app.j
    public int f() {
        if (this.n != null) {
            return this.n.size();
        }
        return 0;
    }

    void f(@ah androidx.fragment.app.d dVar) {
        if (k()) {
            if (c) {
                Log.v(d, "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.V.c(dVar) && c) {
            Log.v(d, "Updating retained Fragments: Removed " + dVar);
        }
    }

    void f(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).f(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.e(this, dVar);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public List<androidx.fragment.app.d> g() {
        List<androidx.fragment.app.d> list;
        if (this.l.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.l) {
            list = (List) this.l.clone();
        }
        return list;
    }

    public void g(androidx.fragment.app.d dVar) {
        if (dVar.Z) {
            if (this.j) {
                this.B = true;
            } else {
                dVar.Z = false;
                a(dVar, this.s, 0, 0, false);
            }
        }
    }

    void g(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).g(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.f(this, dVar);
            }
        }
    }

    void h(androidx.fragment.app.d dVar) {
        a(dVar, this.s, 0, 0, false);
    }

    void h(@ah androidx.fragment.app.d dVar, boolean z) {
        if (this.v != null) {
            j jVarF = this.v.F();
            if (jVarF instanceof k) {
                ((k) jVarF).h(dVar, true);
            }
        }
        for (c cVar : this.U) {
            if (!z || cVar.b) {
                cVar.f773a.g(this, dVar);
            }
        }
    }

    @Override // androidx.fragment.app.j
    public boolean h() {
        return this.A;
    }

    @Override // androidx.fragment.app.j
    @ai
    public androidx.fragment.app.d i() {
        return this.w;
    }

    void i(androidx.fragment.app.d dVar) {
        if (!dVar.E || dVar.H) {
            return;
        }
        dVar.b(dVar.h(dVar.u), (ViewGroup) null, dVar.u);
        if (dVar.X == null) {
            dVar.Y = null;
            return;
        }
        dVar.Y = dVar.X;
        dVar.X.setSaveFromParentEnabled(false);
        if (dVar.Q) {
            dVar.X.setVisibility(8);
        }
        dVar.a(dVar.X, dVar.u);
        a(dVar, dVar.X, dVar.u, false);
    }

    @Override // androidx.fragment.app.j
    @ah
    public h j() {
        if (super.j() == f763a) {
            if (this.v != null) {
                return this.v.J.j();
            }
            a(new h() { // from class: androidx.fragment.app.k.6
                @Override // androidx.fragment.app.h
                @ah
                public androidx.fragment.app.d c(@ah ClassLoader classLoader, @ah String str) {
                    return k.this.t.a(k.this.t.l(), str, (Bundle) null);
                }
            });
        }
        return super.j();
    }

    void j(final androidx.fragment.app.d dVar) {
        if (dVar.X != null) {
            a aVarA = a(dVar, dVar.aB(), !dVar.Q, dVar.aC());
            if (aVarA == null || aVarA.b == null) {
                if (aVarA != null) {
                    dVar.X.startAnimation(aVarA.f771a);
                    aVarA.f771a.start();
                }
                dVar.X.setVisibility((!dVar.Q || dVar.aJ()) ? 0 : 8);
                if (dVar.aJ()) {
                    dVar.o(false);
                }
            } else {
                aVarA.b.setTarget(dVar.X);
                if (!dVar.Q) {
                    dVar.X.setVisibility(0);
                } else if (dVar.aJ()) {
                    dVar.o(false);
                } else {
                    final ViewGroup viewGroup = dVar.W;
                    final View view = dVar.X;
                    viewGroup.startViewTransition(view);
                    aVarA.b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.k.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (dVar.X == null || !dVar.Q) {
                                return;
                            }
                            dVar.X.setVisibility(8);
                        }
                    });
                }
                aVarA.b.start();
            }
        }
        if (dVar.C && x(dVar)) {
            this.x = true;
        }
        dVar.ae = false;
        dVar.c(dVar.Q);
    }

    void k(androidx.fragment.app.d dVar) {
        if (dVar == null) {
            return;
        }
        if (!this.m.containsKey(dVar.x)) {
            if (c) {
                Log.v(d, "Ignoring moving " + dVar + " to state " + this.s + "since it is not added to " + this);
                return;
            }
            return;
        }
        int iMin = this.s;
        if (dVar.D) {
            iMin = dVar.q() ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        a(dVar, iMin, dVar.aB(), dVar.aC(), false);
        if (dVar.X != null) {
            androidx.fragment.app.d dVarV = v(dVar);
            if (dVarV != null) {
                View view = dVarV.X;
                ViewGroup viewGroup = dVar.W;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(dVar.X);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(dVar.X, iIndexOfChild);
                }
            }
            if (dVar.ad && dVar.W != null) {
                if (dVar.af > 0.0f) {
                    dVar.X.setAlpha(dVar.af);
                }
                dVar.af = 0.0f;
                dVar.ad = false;
                a aVarA = a(dVar, dVar.aB(), true, dVar.aC());
                if (aVarA != null) {
                    if (aVarA.f771a != null) {
                        dVar.X.startAnimation(aVarA.f771a);
                    } else {
                        aVarA.b.setTarget(dVar.X);
                        aVarA.b.start();
                    }
                }
            }
        }
        if (dVar.ae) {
            j(dVar);
        }
    }

    @Override // androidx.fragment.app.j
    public boolean k() {
        return this.y || this.z;
    }

    void l() {
        q();
        if (this.T.a()) {
            e();
        } else {
            this.S.b();
        }
    }

    void l(androidx.fragment.app.d dVar) {
        if (this.m.get(dVar.x) != null) {
            return;
        }
        this.m.put(dVar.x, dVar);
        if (dVar.T) {
            if (dVar.S) {
                e(dVar);
            } else {
                f(dVar);
            }
            dVar.T = false;
        }
        if (c) {
            Log.v(d, "Added fragment to active set " + dVar);
        }
    }

    @ah
    List<androidx.fragment.app.d> m() {
        return new ArrayList(this.m.values());
    }

    void m(androidx.fragment.app.d dVar) {
        if (this.m.get(dVar.x) == null) {
            return;
        }
        if (c) {
            Log.v(d, "Removed fragment from active set " + dVar);
        }
        for (androidx.fragment.app.d dVar2 : this.m.values()) {
            if (dVar2 != null && dVar.x.equals(dVar2.A)) {
                dVar2.z = dVar;
                dVar2.A = null;
            }
        }
        this.m.put(dVar.x, null);
        f(dVar);
        if (dVar.A != null) {
            dVar.z = this.m.get(dVar.A);
        }
        dVar.ac();
    }

    int n() {
        return this.m.size();
    }

    public void n(androidx.fragment.app.d dVar) {
        if (c) {
            Log.v(d, "remove: " + dVar + " nesting=" + dVar.I);
        }
        boolean z = !dVar.q();
        if (!dVar.R || z) {
            synchronized (this.l) {
                this.l.remove(dVar);
            }
            if (x(dVar)) {
                this.x = true;
            }
            dVar.C = false;
            dVar.D = true;
        }
    }

    void o() {
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null) {
                g(dVar);
            }
        }
    }

    public void o(androidx.fragment.app.d dVar) {
        if (c) {
            Log.v(d, "hide: " + dVar);
        }
        if (dVar.Q) {
            return;
        }
        dVar.Q = true;
        dVar.ae = true ^ dVar.ae;
    }

    @Override // android.view.LayoutInflater.Factory2
    @ai
    public View onCreateView(@ai View view, @ah String str, @ah Context context, @ah AttributeSet attributeSet) {
        androidx.fragment.app.d dVar;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f774a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (str2 == null || !h.a(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        androidx.fragment.app.d dVarA = resourceId != -1 ? a(resourceId) : null;
        if (dVarA == null && string != null) {
            dVarA = a(string);
        }
        if (dVarA == null && id != -1) {
            dVarA = a(id);
        }
        if (c) {
            Log.v(d, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + dVarA);
        }
        if (dVarA == null) {
            androidx.fragment.app.d dVarC = j().c(context.getClassLoader(), str2);
            dVarC.E = true;
            dVarC.N = resourceId != 0 ? resourceId : id;
            dVarC.O = id;
            dVarC.P = string;
            dVarC.F = true;
            dVarC.J = this;
            dVarC.K = this.t;
            dVarC.a(this.t.l(), attributeSet, dVarC.u);
            a(dVarC, true);
            dVar = dVarC;
        } else {
            if (dVarA.F) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            dVarA.F = true;
            dVarA.K = this.t;
            dVarA.a(this.t.l(), attributeSet, dVarA.u);
            dVar = dVarA;
        }
        if (this.s >= 1 || !dVar.E) {
            h(dVar);
        } else {
            a(dVar, 1, 0, 0, false);
        }
        if (dVar.X != null) {
            if (resourceId != 0) {
                dVar.X.setId(resourceId);
            }
            if (dVar.X.getTag() == null) {
                dVar.X.setTag(string);
            }
            return dVar.X;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    void p() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.H == null || this.H.isEmpty()) ? false : true;
            if (this.i != null && this.i.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.t.m().removeCallbacks(this.I);
                this.t.m().post(this.I);
                I();
            }
        }
    }

    public void p(androidx.fragment.app.d dVar) {
        if (c) {
            Log.v(d, "show: " + dVar);
        }
        if (dVar.Q) {
            dVar.Q = false;
            dVar.ae = !dVar.ae;
        }
    }

    public void q(androidx.fragment.app.d dVar) {
        if (c) {
            Log.v(d, "detach: " + dVar);
        }
        if (dVar.R) {
            return;
        }
        dVar.R = true;
        if (dVar.C) {
            if (c) {
                Log.v(d, "remove from detach: " + dVar);
            }
            synchronized (this.l) {
                this.l.remove(dVar);
            }
            if (x(dVar)) {
                this.x = true;
            }
            dVar.C = false;
        }
    }

    public boolean q() {
        d(true);
        boolean z = false;
        while (c(this.C, this.D)) {
            this.j = true;
            try {
                b(this.C, this.D);
                K();
                z = true;
            } catch (Throwable th) {
                K();
                throw th;
            }
        }
        I();
        r();
        N();
        return z;
    }

    void r() {
        if (this.B) {
            this.B = false;
            o();
        }
    }

    public void r(androidx.fragment.app.d dVar) {
        if (c) {
            Log.v(d, "attach: " + dVar);
        }
        if (dVar.R) {
            dVar.R = false;
            if (dVar.C) {
                return;
            }
            if (this.l.contains(dVar)) {
                throw new IllegalStateException("Fragment already added: " + dVar);
            }
            if (c) {
                Log.v(d, "add from attach: " + dVar);
            }
            synchronized (this.l) {
                this.l.add(dVar);
            }
            dVar.C = true;
            if (x(dVar)) {
                this.x = true;
            }
        }
    }

    void s() {
        if (this.r != null) {
            for (int i = 0; i < this.r.size(); i++) {
                this.r.get(i).a();
            }
        }
    }

    void s(androidx.fragment.app.d dVar) {
        if (dVar.Y == null) {
            return;
        }
        if (this.G == null) {
            this.G = new SparseArray<>();
        } else {
            this.G.clear();
        }
        dVar.Y.saveHierarchyState(this.G);
        if (this.G.size() > 0) {
            dVar.v = this.G;
            this.G = null;
        }
    }

    Bundle t(androidx.fragment.app.d dVar) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        dVar.n(this.F);
        d(dVar, this.F, false);
        if (this.F.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.F;
            this.F = null;
        }
        if (dVar.X != null) {
            s(dVar);
        }
        if (dVar.v != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(g, dVar.v);
        }
        if (!dVar.aa) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(h, dVar.aa);
        }
        return bundle;
    }

    @Deprecated
    l t() {
        if (this.t instanceof androidx.lifecycle.y) {
            a(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.V.d();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.v != null) {
            androidx.core.m.c.a(this.v, sb);
        } else {
            androidx.core.m.c.a(this.t, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    Parcelable u() {
        ArrayList<String> arrayList;
        int size;
        L();
        M();
        q();
        this.y = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.m.isEmpty()) {
            return null;
        }
        ArrayList<p> arrayList2 = new ArrayList<>(this.m.size());
        boolean z = false;
        for (androidx.fragment.app.d dVar : this.m.values()) {
            if (dVar != null) {
                if (dVar.J != this) {
                    a(new IllegalStateException("Failure saving state: active " + dVar + " was removed from the FragmentManager"));
                }
                p pVar = new p(dVar);
                arrayList2.add(pVar);
                if (dVar.t <= 0 || pVar.m != null) {
                    pVar.m = dVar.u;
                } else {
                    pVar.m = t(dVar);
                    if (dVar.A != null) {
                        androidx.fragment.app.d dVar2 = this.m.get(dVar.A);
                        if (dVar2 == null) {
                            a(new IllegalStateException("Failure saving state: " + dVar + " has target not in fragment manager: " + dVar.A));
                        }
                        if (pVar.m == null) {
                            pVar.m = new Bundle();
                        }
                        a(pVar.m, f, dVar2);
                        if (dVar.B != 0) {
                            pVar.m.putInt(e, dVar.B);
                        }
                    }
                }
                if (c) {
                    Log.v(d, "Saved state of " + dVar + ": " + pVar.m);
                }
                z = true;
            }
        }
        if (!z) {
            if (c) {
                Log.v(d, "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.l.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            for (androidx.fragment.app.d dVar3 : this.l) {
                arrayList.add(dVar3.x);
                if (dVar3.J != this) {
                    a(new IllegalStateException("Failure saving state: active " + dVar3 + " was removed from the FragmentManager"));
                }
                if (c) {
                    Log.v(d, "saveAllState: adding fragment (" + dVar3.x + "): " + dVar3);
                }
            }
        } else {
            arrayList = null;
        }
        if (this.n != null && (size = this.n.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i = 0; i < size; i++) {
                bVarArr[i] = new androidx.fragment.app.b(this.n.get(i));
                if (c) {
                    Log.v(d, "saveAllState: adding back stack #" + i + ": " + this.n.get(i));
                }
            }
        }
        m mVar = new m();
        mVar.f778a = arrayList2;
        mVar.b = arrayList;
        mVar.c = bVarArr;
        if (this.w != null) {
            mVar.d = this.w.x;
        }
        mVar.e = this.k;
        return mVar;
    }

    public void u(androidx.fragment.app.d dVar) {
        if (dVar == null || (this.m.get(dVar.x) == dVar && (dVar.K == null || dVar.F() == this))) {
            androidx.fragment.app.d dVar2 = this.w;
            this.w = dVar;
            w(dVar2);
            w(this.w);
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    public void v() {
        this.y = false;
        this.z = false;
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.d dVar = this.l.get(i);
            if (dVar != null) {
                dVar.as();
            }
        }
    }

    public void w() {
        this.y = false;
        this.z = false;
        f(1);
    }

    public void x() {
        this.y = false;
        this.z = false;
        f(2);
    }

    public void y() {
        this.y = false;
        this.z = false;
        f(3);
    }

    public void z() {
        this.y = false;
        this.z = false;
        f(4);
    }
}
