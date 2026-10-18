package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.ac;
import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.as;
import androidx.core.app.z;
import androidx.lifecycle.LiveData;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class d implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.j, androidx.lifecycle.y, androidx.savedstate.d {
    static final Object n = new Object();
    static final int o = 0;
    static final int p = 1;
    static final int q = 2;
    static final int r = 3;
    static final int s = 4;
    String A;
    int B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    int I;
    k J;
    i K;

    @ah
    k L;
    d M;
    int N;
    int O;
    String P;
    boolean Q;
    boolean R;
    boolean S;
    boolean T;
    boolean U;
    boolean V;
    ViewGroup W;
    View X;
    View Y;
    boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f752a;
    boolean aa;
    a ab;
    Runnable ac;
    boolean ad;
    boolean ae;
    float af;
    LayoutInflater ag;
    boolean ah;
    androidx.lifecycle.g.b ai;
    androidx.lifecycle.k aj;

    @ai
    w ak;
    androidx.lifecycle.p<androidx.lifecycle.j> al;
    androidx.savedstate.c am;
    private boolean b;

    @ac
    private int c;
    int t;
    Bundle u;
    SparseArray<Parcelable> v;

    @ai
    Boolean w;

    @ah
    String x;
    Bundle y;
    d z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f756a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        Boolean m;
        Boolean n;
        boolean q;
        c r;
        boolean s;
        Object g = null;
        Object h = d.n;
        Object i = null;
        Object j = d.n;
        Object k = null;
        Object l = d.n;
        z o = null;
        z p = null;

        a() {
        }
    }

    public static class b extends RuntimeException {
        public b(@ah String str, @ai Exception exc) {
            super(str, exc);
        }
    }

    interface c {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    @SuppressLint({"BanParcelableUsage"})
    public static class C0058d implements Parcelable {

        @ah
        public static final Parcelable.Creator<C0058d> CREATOR = new Parcelable.ClassLoaderCreator<C0058d>() { // from class: androidx.fragment.app.d.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0058d createFromParcel(Parcel parcel) {
                return new C0058d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0058d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0058d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0058d[] newArray(int i) {
                return new C0058d[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f757a;

        C0058d(Bundle bundle) {
            this.f757a = bundle;
        }

        C0058d(@ah Parcel parcel, @ai ClassLoader classLoader) {
            this.f757a = parcel.readBundle();
            if (classLoader == null || this.f757a == null) {
                return;
            }
            this.f757a.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@ah Parcel parcel, int i) {
            parcel.writeBundle(this.f757a);
        }
    }

    public d() {
        this.t = 0;
        this.x = UUID.randomUUID().toString();
        this.A = null;
        this.f752a = null;
        this.L = new k();
        this.V = true;
        this.aa = true;
        this.ac = new Runnable() { // from class: androidx.fragment.app.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.an();
            }
        };
        this.ai = androidx.lifecycle.g.b.RESUMED;
        this.al = new androidx.lifecycle.p<>();
        a();
    }

    @androidx.annotation.n
    public d(@ac int i) {
        this();
        this.c = i;
    }

    @ah
    @Deprecated
    public static d a(@ah Context context, @ah String str) {
        return a(context, str, (Bundle) null);
    }

    @ah
    @Deprecated
    public static d a(@ah Context context, @ah String str, @ai Bundle bundle) {
        try {
            d dVarNewInstance = h.b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(dVarNewInstance.getClass().getClassLoader());
                dVarNewInstance.g(bundle);
            }
            return dVarNewInstance;
        } catch (IllegalAccessException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    private void a() {
        this.aj = new androidx.lifecycle.k(this);
        this.am = androidx.savedstate.c.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.aj.a(new androidx.lifecycle.h() { // from class: androidx.fragment.app.Fragment$2
                @Override // androidx.lifecycle.h
                public void a(@ah androidx.lifecycle.j jVar, @ah androidx.lifecycle.g.a aVar) {
                    if (aVar != androidx.lifecycle.g.a.ON_STOP || this.f747a.X == null) {
                        return;
                    }
                    this.f747a.X.cancelPendingInputEvents();
                }
            });
        }
    }

    private a b() {
        if (this.ab == null) {
            this.ab = new a();
        }
        return this.ab;
    }

    @ai
    public final e A() {
        if (this.K == null) {
            return null;
        }
        return (e) this.K.k();
    }

    @ah
    public final e B() {
        e eVarA = A();
        if (eVarA != null) {
            return eVarA;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @ai
    public final Object C() {
        if (this.K == null) {
            return null;
        }
        return this.K.j();
    }

    @ah
    public final Object D() {
        Object objC = C();
        if (objC != null) {
            return objC;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @ah
    public final Resources E() {
        return z().getResources();
    }

    @ai
    public final j F() {
        return this.J;
    }

    @ah
    public final j G() {
        j jVarF = F();
        if (jVarF != null) {
            return jVarF;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @ah
    public final j H() {
        if (this.K != null) {
            return this.L;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @ai
    public final d I() {
        return this.M;
    }

    @ah
    public final d J() {
        d dVarI = I();
        if (dVarI != null) {
            return dVarI;
        }
        if (y() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + y());
    }

    public final boolean K() {
        return this.K != null && this.C;
    }

    public final boolean L() {
        return this.R;
    }

    public final boolean M() {
        return this.D;
    }

    public final boolean N() {
        return this.F;
    }

    public final boolean O() {
        return this.t >= 4;
    }

    public final boolean P() {
        return (!K() || Q() || this.X == null || this.X.getWindowToken() == null || this.X.getVisibility() != 0) ? false : true;
    }

    public final boolean Q() {
        return this.Q;
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public final boolean R() {
        return this.U;
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public final boolean S() {
        return this.V;
    }

    public final boolean T() {
        return this.S;
    }

    @Deprecated
    public boolean U() {
        return this.aa;
    }

    @ah
    @Deprecated
    public androidx.i.a.a V() {
        return androidx.i.a.a.a(this);
    }

    @ah
    public final LayoutInflater W() {
        return this.ag == null ? h((Bundle) null) : this.ag;
    }

    @ai
    public View X() {
        return this.X;
    }

    @ah
    public final View Y() {
        View viewX = X();
        if (viewX != null) {
            return viewX;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    @androidx.annotation.i
    public void Z() {
        this.b = true;
    }

    @ai
    public View a(@ah LayoutInflater layoutInflater, @ai ViewGroup viewGroup, @ai Bundle bundle) {
        if (this.c != 0) {
            return layoutInflater.inflate(this.c, viewGroup, false);
        }
        return null;
    }

    @ai
    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    @ah
    public final CharSequence a(@as int i) {
        return E().getText(i);
    }

    @ah
    public final String a(@as int i, @ai Object... objArr) {
        return E().getString(i, objArr);
    }

    public void a(int i, int i2, @ai Intent intent) {
    }

    public void a(int i, @ah String[] strArr, @ah int[] iArr) {
    }

    public final void a(long j, @ah TimeUnit timeUnit) {
        b().q = true;
        Handler handlerM = this.J != null ? this.J.t.m() : new Handler(Looper.getMainLooper());
        handlerM.removeCallbacks(this.ac);
        handlerM.postDelayed(this.ac, timeUnit.toMillis(j));
    }

    void a(Animator animator) {
        b().b = animator;
    }

    @androidx.annotation.i
    @Deprecated
    public void a(@ah Activity activity) {
        this.b = true;
    }

    @androidx.annotation.i
    @Deprecated
    public void a(@ah Activity activity, @ah AttributeSet attributeSet, @ai Bundle bundle) {
        this.b = true;
    }

    @androidx.annotation.i
    public void a(@ah Context context) {
        this.b = true;
        Activity activityK = this.K == null ? null : this.K.k();
        if (activityK != null) {
            this.b = false;
            a(activityK);
        }
    }

    @androidx.annotation.i
    public void a(@ah Context context, @ah AttributeSet attributeSet, @ai Bundle bundle) {
        this.b = true;
        Activity activityK = this.K == null ? null : this.K.k();
        if (activityK != null) {
            this.b = false;
            a(activityK, attributeSet, bundle);
        }
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent) {
        a(intent, (Bundle) null);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        a(intent, i, (Bundle) null);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, int i, @ai Bundle bundle) {
        if (this.K != null) {
            this.K.a(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, @ai Bundle bundle) {
        if (this.K != null) {
            this.K.a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public void a(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, @ai Intent intent, int i2, int i3, int i4, @ai Bundle bundle) {
        if (this.K != null) {
            this.K.a(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    void a(@ah Configuration configuration) {
        onConfigurationChanged(configuration);
        this.L.a(configuration);
    }

    public void a(@ah Menu menu) {
    }

    public void a(@ah Menu menu, @ah MenuInflater menuInflater) {
    }

    public void a(@ah View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void a(@ah View view, @ai Bundle bundle) {
    }

    public void a(@ai z zVar) {
        b().o = zVar;
    }

    void a(c cVar) {
        b();
        if (cVar == this.ab.r) {
            return;
        }
        if (cVar != null && this.ab.r != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.ab.q) {
            this.ab.r = cVar;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(@ai C0058d c0058d) {
        if (this.J != null) {
            throw new IllegalStateException("Fragment already added");
        }
        this.u = (c0058d == null || c0058d.f757a == null) ? null : c0058d.f757a;
    }

    public void a(@ah d dVar) {
    }

    public void a(@ai d dVar, int i) {
        j jVarF = F();
        j jVarF2 = dVar != null ? dVar.F() : null;
        if (jVarF != null && jVarF2 != null && jVarF != jVarF2) {
            throw new IllegalArgumentException("Fragment " + dVar + " must share the same FragmentManager to be set as a target fragment");
        }
        for (d dVarW = dVar; dVarW != null; dVarW = dVarW.w()) {
            if (dVarW == this) {
                throw new IllegalArgumentException("Setting " + dVar + " as the target of " + this + " would create a target cycle");
            }
        }
        if (dVar == null) {
            this.A = null;
            this.z = null;
        } else if (this.J == null || dVar.J == null) {
            this.A = null;
            this.z = dVar;
        } else {
            this.A = dVar.x;
            this.z = null;
        }
        this.B = i;
    }

    public void a(@ai Object obj) {
        b().g = obj;
    }

    public void a(@ah String str, @ai FileDescriptor fileDescriptor, @ah PrintWriter printWriter, @ai String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.N));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.O));
        printWriter.print(" mTag=");
        printWriter.println(this.P);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.t);
        printWriter.print(" mWho=");
        printWriter.print(this.x);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.I);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.C);
        printWriter.print(" mRemoving=");
        printWriter.print(this.D);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.E);
        printWriter.print(" mInLayout=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.Q);
        printWriter.print(" mDetached=");
        printWriter.print(this.R);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.V);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.U);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.S);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.aa);
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.K);
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.M);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.y);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.u);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.v);
        }
        d dVarW = w();
        if (dVarW != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(dVarW);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.B);
        }
        if (aA() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(aA());
        }
        if (this.W != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.W);
        }
        if (this.X != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.X);
        }
        if (this.Y != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.X);
        }
        if (aF() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(aF());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(aH());
        }
        if (y() != null) {
            androidx.i.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.L + ":");
        this.L.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final void a(@ah String[] strArr, int i) {
        if (this.K != null) {
            this.K.a(this, strArr, i);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public boolean a(@ah MenuItem menuItem) {
        return false;
    }

    public boolean a(@ah String str) {
        if (this.K != null) {
            return this.K.a(str);
        }
        return false;
    }

    int aA() {
        if (this.ab == null) {
            return 0;
        }
        return this.ab.d;
    }

    int aB() {
        if (this.ab == null) {
            return 0;
        }
        return this.ab.e;
    }

    int aC() {
        if (this.ab == null) {
            return 0;
        }
        return this.ab.f;
    }

    z aD() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.o;
    }

    z aE() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.p;
    }

    View aF() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.f756a;
    }

    Animator aG() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.b;
    }

    int aH() {
        if (this.ab == null) {
            return 0;
        }
        return this.ab.c;
    }

    boolean aI() {
        if (this.ab == null) {
            return false;
        }
        return this.ab.q;
    }

    boolean aJ() {
        if (this.ab == null) {
            return false;
        }
        return this.ab.s;
    }

    @androidx.annotation.i
    public void aa() {
        this.b = true;
    }

    @androidx.annotation.i
    public void ab() {
        this.b = true;
    }

    void ac() {
        a();
        this.x = UUID.randomUUID().toString();
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = 0;
        this.J = null;
        this.L = new k();
        this.K = null;
        this.N = 0;
        this.O = 0;
        this.P = null;
        this.Q = false;
        this.R = false;
    }

    public void ad() {
    }

    @ai
    public Object ae() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.g;
    }

    @ai
    public Object af() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.h == n ? ae() : this.ab.h;
    }

    @ai
    public Object ag() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.i;
    }

    @ai
    public Object ah() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.j == n ? ag() : this.ab.j;
    }

    @ai
    public Object ai() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.k;
    }

    @ai
    public Object aj() {
        if (this.ab == null) {
            return null;
        }
        return this.ab.l == n ? ai() : this.ab.l;
    }

    public boolean ak() {
        if (this.ab == null || this.ab.n == null) {
            return true;
        }
        return this.ab.n.booleanValue();
    }

    public boolean al() {
        if (this.ab == null || this.ab.m == null) {
            return true;
        }
        return this.ab.m.booleanValue();
    }

    public void am() {
        b().q = true;
    }

    public void an() {
        if (this.J == null || this.J.t == null) {
            b().q = false;
        } else if (Looper.myLooper() != this.J.t.m().getLooper()) {
            this.J.t.m().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ao();
                }
            });
        } else {
            ao();
        }
    }

    void ao() {
        c cVar;
        if (this.ab == null) {
            cVar = null;
        } else {
            this.ab.q = false;
            cVar = this.ab.r;
            this.ab.r = null;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    void ap() {
        this.L.a(this.K, new f() { // from class: androidx.fragment.app.d.3
            @Override // androidx.fragment.app.f
            @ai
            public View a(int i) {
                if (d.this.X != null) {
                    return d.this.X.findViewById(i);
                }
                throw new IllegalStateException("Fragment " + this + " does not have a view");
            }

            @Override // androidx.fragment.app.f
            public boolean a() {
                return d.this.X != null;
            }
        }, this);
        this.b = false;
        a(this.K.l());
        if (this.b) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onAttach()");
    }

    void aq() {
        this.L.v();
        this.L.q();
        this.t = 3;
        this.b = false;
        l();
        if (this.b) {
            this.aj.a(androidx.lifecycle.g.a.ON_START);
            if (this.X != null) {
                this.ak.a(androidx.lifecycle.g.a.ON_START);
            }
            this.L.y();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStart()");
    }

    void ar() {
        this.L.v();
        this.L.q();
        this.t = 4;
        this.b = false;
        Z();
        if (!this.b) {
            throw new y("Fragment " + this + " did not call through to super.onResume()");
        }
        this.aj.a(androidx.lifecycle.g.a.ON_RESUME);
        if (this.X != null) {
            this.ak.a(androidx.lifecycle.g.a.ON_RESUME);
        }
        this.L.z();
        this.L.q();
    }

    void as() {
        this.L.v();
    }

    void at() {
        boolean zB = this.J.b(this);
        if (this.f752a == null || this.f752a.booleanValue() != zB) {
            this.f752a = Boolean.valueOf(zB);
            j(zB);
            this.L.F();
        }
    }

    void au() {
        onLowMemory();
        this.L.E();
    }

    void av() {
        this.L.A();
        if (this.X != null) {
            this.ak.a(androidx.lifecycle.g.a.ON_PAUSE);
        }
        this.aj.a(androidx.lifecycle.g.a.ON_PAUSE);
        this.t = 3;
        this.b = false;
        aa();
        if (this.b) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onPause()");
    }

    void aw() {
        this.L.B();
        if (this.X != null) {
            this.ak.a(androidx.lifecycle.g.a.ON_STOP);
        }
        this.aj.a(androidx.lifecycle.g.a.ON_STOP);
        this.t = 2;
        this.b = false;
        m();
        if (this.b) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onStop()");
    }

    void ax() {
        this.L.C();
        if (this.X != null) {
            this.ak.a(androidx.lifecycle.g.a.ON_DESTROY);
        }
        this.t = 1;
        this.b = false;
        n();
        if (this.b) {
            androidx.i.a.a.a(this).a();
            this.H = false;
        } else {
            throw new y("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void ay() {
        this.L.D();
        this.aj.a(androidx.lifecycle.g.a.ON_DESTROY);
        this.t = 0;
        this.b = false;
        this.ah = false;
        ab();
        if (this.b) {
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void az() {
        this.b = false;
        k();
        this.ag = null;
        if (this.b) {
            if (this.L.h()) {
                return;
            }
            this.L.D();
            this.L = new k();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onDetach()");
    }

    @ai
    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    @ai
    d b(@ah String str) {
        return str.equals(this.x) ? this : this.L.b(str);
    }

    @ah
    public final String b(@as int i) {
        return E().getString(i);
    }

    void b(int i, int i2) {
        if (this.ab == null && i == 0 && i2 == 0) {
            return;
        }
        b();
        this.ab.e = i;
        this.ab.f = i2;
    }

    @androidx.annotation.i
    public void b(@ai Bundle bundle) {
        this.b = true;
        j(bundle);
        if (this.L.c(1)) {
            return;
        }
        this.L.w();
    }

    void b(@ah LayoutInflater layoutInflater, @ai ViewGroup viewGroup, @ai Bundle bundle) {
        this.L.v();
        this.H = true;
        this.ak = new w();
        this.X = a(layoutInflater, viewGroup, bundle);
        if (this.X != null) {
            this.ak.a();
            this.al.b(this.ak);
        } else {
            if (this.ak.b()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.ak = null;
        }
    }

    public void b(@ah Menu menu) {
    }

    public void b(@ah View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public void b(@ai z zVar) {
        b().p = zVar;
    }

    public void b(@ai Object obj) {
        b().h = obj;
    }

    boolean b(@ah Menu menu, @ah MenuInflater menuInflater) {
        boolean z = false;
        if (this.Q) {
            return false;
        }
        if (this.U && this.V) {
            z = true;
            a(menu, menuInflater);
        }
        return z | this.L.a(menu, menuInflater);
    }

    public boolean b(@ah MenuItem menuItem) {
        return false;
    }

    @ah
    public LayoutInflater c(@ai Bundle bundle) {
        return i(bundle);
    }

    @Override // androidx.lifecycle.j
    @ah
    public androidx.lifecycle.g c() {
        return this.aj;
    }

    void c(int i) {
        if (this.ab == null && i == 0) {
            return;
        }
        b().d = i;
    }

    void c(View view) {
        b().f756a = view;
    }

    public void c(@ai Object obj) {
        b().i = obj;
    }

    public void c(boolean z) {
    }

    boolean c(@ah Menu menu) {
        boolean z = false;
        if (this.Q) {
            return false;
        }
        if (this.U && this.V) {
            z = true;
            a(menu);
        }
        return z | this.L.a(menu);
    }

    boolean c(@ah MenuItem menuItem) {
        if (this.Q) {
            return false;
        }
        return (this.U && this.V && a(menuItem)) || this.L.a(menuItem);
    }

    @Override // androidx.lifecycle.y
    @ah
    public androidx.lifecycle.x d() {
        if (this.J != null) {
            return this.J.c(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    void d(int i) {
        b().c = i;
    }

    @androidx.annotation.i
    public void d(@ai Bundle bundle) {
        this.b = true;
    }

    void d(@ah Menu menu) {
        if (this.Q) {
            return;
        }
        if (this.U && this.V) {
            b(menu);
        }
        this.L.b(menu);
    }

    public void d(@ai Object obj) {
        b().j = obj;
    }

    public void d(boolean z) {
        this.S = z;
        if (this.J == null) {
            this.T = true;
        } else if (z) {
            this.J.e(this);
        } else {
            this.J.f(this);
        }
    }

    boolean d(@ah MenuItem menuItem) {
        if (this.Q) {
            return false;
        }
        return b(menuItem) || this.L.b(menuItem);
    }

    public void e(@ah Bundle bundle) {
    }

    public void e(@ai Object obj) {
        b().k = obj;
    }

    public void e(boolean z) {
        if (this.U != z) {
            this.U = z;
            if (!K() || Q()) {
                return;
            }
            this.K.g();
        }
    }

    public final boolean equals(@ai Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.savedstate.d
    @ah
    public final androidx.savedstate.b f() {
        return this.am.a();
    }

    final void f(Bundle bundle) {
        if (this.v != null) {
            this.Y.restoreHierarchyState(this.v);
            this.v = null;
        }
        this.b = false;
        k(bundle);
        if (this.b) {
            if (this.X != null) {
                this.ak.a(androidx.lifecycle.g.a.ON_CREATE);
            }
        } else {
            throw new y("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void f(@ai Object obj) {
        b().l = obj;
    }

    public void f(boolean z) {
        if (this.V != z) {
            this.V = z;
            if (this.U && K() && !Q()) {
                this.K.g();
            }
        }
    }

    public void g(@ai Bundle bundle) {
        if (this.J != null && v()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.y = bundle;
    }

    @Deprecated
    public void g(boolean z) {
        if (!this.aa && z && this.t < 3 && this.J != null && K() && this.ah) {
            this.J.g(this);
        }
        this.aa = z;
        this.Z = this.t < 3 && !z;
        if (this.u != null) {
            this.w = Boolean.valueOf(z);
        }
    }

    @ah
    LayoutInflater h(@ai Bundle bundle) {
        this.ag = c(bundle);
        return this.ag;
    }

    public void h(boolean z) {
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @ah
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public LayoutInflater i(@ai Bundle bundle) {
        if (this.K == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterB = this.K.b();
        androidx.core.n.k.a(layoutInflaterB, this.L.H());
        return layoutInflaterB;
    }

    public void i(boolean z) {
    }

    void j(@ai Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.L.a(parcelable);
        this.L.w();
    }

    public void j(boolean z) {
    }

    @androidx.annotation.i
    public void k() {
        this.b = true;
    }

    @androidx.annotation.i
    public void k(@ai Bundle bundle) {
        this.b = true;
    }

    public void k(boolean z) {
        b().n = Boolean.valueOf(z);
    }

    @androidx.annotation.i
    public void l() {
        this.b = true;
    }

    void l(Bundle bundle) {
        this.L.v();
        this.t = 1;
        this.b = false;
        this.am.a(bundle);
        b(bundle);
        this.ah = true;
        if (this.b) {
            this.aj.a(androidx.lifecycle.g.a.ON_CREATE);
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onCreate()");
    }

    public void l(boolean z) {
        b().m = Boolean.valueOf(z);
    }

    @androidx.annotation.i
    public void m() {
        this.b = true;
    }

    void m(Bundle bundle) {
        this.L.v();
        this.t = 2;
        this.b = false;
        d(bundle);
        if (this.b) {
            this.L.x();
            return;
        }
        throw new y("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    void m(boolean z) {
        h(z);
        this.L.b(z);
    }

    @androidx.annotation.i
    public void n() {
        this.b = true;
    }

    void n(Bundle bundle) {
        e(bundle);
        this.am.b(bundle);
        Parcelable parcelableU = this.L.u();
        if (parcelableU != null) {
            bundle.putParcelable("android:support:fragments", parcelableU);
        }
    }

    void n(boolean z) {
        i(z);
        this.L.c(z);
    }

    @ae
    @ah
    public androidx.lifecycle.j o() {
        if (this.ak != null) {
            return this.ak;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    void o(boolean z) {
        b().s = z;
    }

    @Override // android.content.ComponentCallbacks
    @androidx.annotation.i
    public void onConfigurationChanged(@ah Configuration configuration) {
        this.b = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(@ah ContextMenu contextMenu, @ah View view, @ai ContextMenu.ContextMenuInfo contextMenuInfo) {
        B().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    @androidx.annotation.i
    public void onLowMemory() {
        this.b = true;
    }

    @ah
    public LiveData<androidx.lifecycle.j> p() {
        return this.al;
    }

    final boolean q() {
        return this.I > 0;
    }

    public final int r() {
        return this.N;
    }

    @ai
    public final String s() {
        return this.P;
    }

    @ai
    public final Bundle t() {
        return this.y;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        androidx.core.m.c.a(this, sb);
        sb.append(" (");
        sb.append(this.x);
        sb.append(")");
        if (this.N != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.N));
        }
        if (this.P != null) {
            sb.append(" ");
            sb.append(this.P);
        }
        sb.append('}');
        return sb.toString();
    }

    @ah
    public final Bundle u() {
        Bundle bundleT = t();
        if (bundleT != null) {
            return bundleT;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public final boolean v() {
        if (this.J == null) {
            return false;
        }
        return this.J.k();
    }

    @ai
    public final d w() {
        if (this.z != null) {
            return this.z;
        }
        if (this.J == null || this.A == null) {
            return null;
        }
        return this.J.m.get(this.A);
    }

    public final int x() {
        return this.B;
    }

    @ai
    public Context y() {
        if (this.K == null) {
            return null;
        }
        return this.K.l();
    }

    @ah
    public final Context z() {
        Context contextY = y();
        if (contextY != null) {
            return contextY;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }
}
