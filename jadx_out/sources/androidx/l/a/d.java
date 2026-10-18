package androidx.l.a;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.q;
import androidx.core.n.af;
import androidx.core.n.ao;
import androidx.core.n.y;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends ViewGroup {
    private static final int W = -1;
    private static final int af = 2;
    private static final int au = 0;
    private static final int av = 1;
    private static final int aw = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    private static final String g = "ViewPager";
    private static final boolean h = false;
    private static final boolean i = false;
    private static final int j = 1;
    private static final int k = 600;
    private static final int l = 25;
    private static final int m = 16;
    private static final int n = 400;
    private int A;
    private Drawable B;
    private int C;
    private int D;
    private float E;
    private float F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private int V;
    private final Runnable aA;
    private int aB;
    private VelocityTracker aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private boolean ag;
    private long ah;
    private EdgeEffect ai;
    private EdgeEffect aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private int an;
    private List<f> ao;
    private f ap;
    private f aq;
    private List<e> ar;
    private g as;
    private int at;
    private int ax;
    private ArrayList<View> ay;
    androidx.l.a.a b;
    int c;
    private int o;
    private final ArrayList<b> r;
    private final b s;
    private final Rect t;
    private int u;
    private Parcelable v;
    private ClassLoader w;
    private Scroller x;
    private boolean y;
    private h z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f942a = {R.attr.layout_gravity};
    private static final Comparator<b> p = new Comparator<b>() { // from class: androidx.l.a.d.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.b - bVar2.b;
        }
    };
    private static final Interpolator q = new Interpolator() { // from class: androidx.l.a.d.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final k az = new k();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f945a;
        int b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f946a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f942a);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.l.a.d$d, reason: collision with other inner class name */
    class C0071d extends androidx.core.n.a {
        C0071d() {
        }

        private boolean b() {
            return d.this.b != null && d.this.b.b() > 1;
        }

        @Override // androidx.core.n.a
        public void a(View view, androidx.core.n.a.d dVar) {
            super.a(view, dVar);
            dVar.b((CharSequence) d.class.getName());
            dVar.l(b());
            if (d.this.canScrollHorizontally(1)) {
                dVar.d(4096);
            }
            if (d.this.canScrollHorizontally(-1)) {
                dVar.d(8192);
            }
        }

        @Override // androidx.core.n.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!d.this.canScrollHorizontally(1)) {
                    return false;
                }
                d.this.setCurrentItem(d.this.c + 1);
                return true;
            }
            if (i != 8192 || !d.this.canScrollHorizontally(-1)) {
                return false;
            }
            d.this.setCurrentItem(d.this.c - 1);
            return true;
        }

        @Override // androidx.core.n.a
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(d.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || d.this.b == null) {
                return;
            }
            accessibilityEvent.setItemCount(d.this.b.b());
            accessibilityEvent.setFromIndex(d.this.c);
            accessibilityEvent.setToIndex(d.this.c);
        }
    }

    public interface e {
        void a(@ah d dVar, @ai androidx.l.a.a aVar, @ai androidx.l.a.a aVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f, @ak int i2);

        void b(int i);
    }

    public interface g {
        void a(@ah View view, float f);
    }

    private class h extends DataSetObserver {
        h() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            d.this.c();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            d.this.c();
        }
    }

    public static class i extends androidx.f.a.a {
        public static final Parcelable.Creator<i> CREATOR = new Parcelable.ClassLoaderCreator<i>() { // from class: androidx.l.a.d.i.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i) {
                return new i[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f949a;
        Parcelable b;
        ClassLoader d;

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f949a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }

        public i(@ah Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f949a + "}";
        }

        @Override // androidx.f.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f949a);
            parcel.writeParcelable(this.b, i);
        }
    }

    public static class j implements f {
        @Override // androidx.l.a.d.f
        public void a(int i) {
        }

        @Override // androidx.l.a.d.f
        public void a(int i, float f, int i2) {
        }

        @Override // androidx.l.a.d.f
        public void b(int i) {
        }
    }

    static class k implements Comparator<View> {
        k() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.f946a != cVar2.f946a) {
                return cVar.f946a ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }

    public d(@ah Context context) {
        super(context);
        this.r = new ArrayList<>();
        this.s = new b();
        this.t = new Rect();
        this.u = -1;
        this.v = null;
        this.w = null;
        this.E = -3.4028235E38f;
        this.F = Float.MAX_VALUE;
        this.L = 1;
        this.V = -1;
        this.ak = true;
        this.al = false;
        this.aA = new Runnable() { // from class: androidx.l.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.setScrollState(0);
                d.this.d();
            }
        };
        this.aB = 0;
        a();
    }

    public d(@ah Context context, @ai AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new ArrayList<>();
        this.s = new b();
        this.t = new Rect();
        this.u = -1;
        this.v = null;
        this.w = null;
        this.E = -3.4028235E38f;
        this.F = Float.MAX_VALUE;
        this.L = 1;
        this.V = -1;
        this.ak = true;
        this.al = false;
        this.aA = new Runnable() { // from class: androidx.l.a.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.setScrollState(0);
                d.this.d();
            }
        };
        this.aB = 0;
        a();
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.ad || Math.abs(i3) <= this.ab) {
            i2 += (int) (f2 + (i2 >= this.c ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.r.size() > 0) {
            return Math.max(this.r.get(0).b, Math.min(i2, this.r.get(this.r.size() - 1).b));
        }
        return i2;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.r.isEmpty()) {
            if (!this.x.isFinished()) {
                this.x.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        b bVarB = b(this.c);
        int iMin = (int) ((bVarB != null ? Math.min(bVarB.e, this.F) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            a(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void a(int i2, boolean z, int i3, boolean z2) {
        b bVarB = b(i2);
        int clientWidth = bVarB != null ? (int) (getClientWidth() * Math.max(this.E, Math.min(bVarB.e, this.F))) : 0;
        if (z) {
            a(clientWidth, 0, i3);
            if (z2) {
                e(i2);
                return;
            }
            return;
        }
        if (z2) {
            e(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.V) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.R = motionEvent.getX(i2);
            this.V = motionEvent.getPointerId(i2);
            if (this.aa != null) {
                this.aa.clear();
            }
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int iB = this.b.b();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.A / clientWidth : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.b;
            if (i3 < bVar.b) {
                float fD = bVar2.e + bVar2.d + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.b && i5 < this.r.size()) {
                    b bVar5 = this.r.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.b || i5 >= this.r.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.r.get(i5);
                    }
                    while (i4 < bVar4.b) {
                        fD += this.b.d(i4) + f2;
                        i4++;
                    }
                    bVar4.e = fD;
                    fD += bVar4.d + f2;
                    i4++;
                }
            } else if (i3 > bVar.b) {
                int size = this.r.size() - 1;
                float fD2 = bVar2.e;
                while (true) {
                    i3--;
                    if (i3 < bVar.b || size < 0) {
                        break;
                    }
                    b bVar6 = this.r.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i3 >= bVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.r.get(size);
                    }
                    while (i3 > bVar3.b) {
                        fD2 -= this.b.d(i3) + f2;
                        i3--;
                    }
                    fD2 -= bVar3.d + f2;
                    bVar3.e = fD2;
                }
            }
        }
        int size2 = this.r.size();
        float fD3 = bVar.e;
        int i6 = bVar.b - 1;
        this.E = bVar.b == 0 ? bVar.e : -3.4028235E38f;
        int i7 = iB - 1;
        this.F = bVar.b == i7 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar7 = this.r.get(i8);
            while (i6 > bVar7.b) {
                fD3 -= this.b.d(i6) + f2;
                i6--;
            }
            fD3 -= bVar7.d + f2;
            bVar7.e = fD3;
            if (bVar7.b == 0) {
                this.E = fD3;
            }
            i8--;
            i6--;
        }
        float fD4 = bVar.e + bVar.d + f2;
        int i9 = bVar.b + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar8 = this.r.get(i10);
            while (i9 < bVar8.b) {
                fD4 += this.b.d(i9) + f2;
                i9++;
            }
            if (bVar8.b == i7) {
                this.F = (bVar8.d + fD4) - 1.0f;
            }
            bVar8.e = fD4;
            fD4 += bVar8.d + f2;
            i10++;
            i9++;
        }
        this.al = false;
    }

    private void a(boolean z) {
        boolean z2 = this.aB == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.x.isFinished()) {
                this.x.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.x.getCurrX();
                int currY = this.x.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.K = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            b bVar = this.r.get(i2);
            if (bVar.c) {
                bVar.c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                af.a(this, this.aA);
            } else {
                this.aA.run();
            }
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.P) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.P)) && f3 < 0.0f);
    }

    private void b(int i2, float f2, int i3) {
        if (this.ap != null) {
            this.ap.a(i2, f2, i3);
        }
        if (this.ao != null) {
            int size = this.ao.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.ao.get(i4);
                if (fVar != null) {
                    fVar.a(i2, f2, i3);
                }
            }
        }
        if (this.aq != null) {
            this.aq.a(i2, f2, i3);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.at : 0, null);
        }
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean c(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.R - f2;
        this.R = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.E * clientWidth;
        float f5 = this.F * clientWidth;
        boolean z3 = false;
        b bVar = this.r.get(0);
        b bVar2 = this.r.get(this.r.size() - 1);
        if (bVar.b != 0) {
            f4 = bVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.b != this.b.b() - 1) {
            f5 = bVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.ai.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.aj.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.R += scrollX - i2;
        scrollTo(i2, getScrollY());
        d(i2);
        return z3;
    }

    private static boolean c(@ah View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private boolean d(int i2) {
        if (this.r.size() == 0) {
            if (this.ak) {
                return false;
            }
            this.am = false;
            a(0, 0.0f, 0);
            if (this.am) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bVarM = m();
        int clientWidth = getClientWidth();
        int i3 = this.A + clientWidth;
        float f2 = clientWidth;
        float f3 = this.A / f2;
        int i4 = bVarM.b;
        float f4 = ((i2 / f2) - bVarM.e) / (bVarM.d + f3);
        this.am = false;
        a(i4, f4, (int) (i3 * f4));
        if (this.am) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void e(int i2) {
        if (this.ap != null) {
            this.ap.a(i2);
        }
        if (this.ao != null) {
            int size = this.ao.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.ao.get(i3);
                if (fVar != null) {
                    fVar.a(i2);
                }
            }
        }
        if (this.aq != null) {
            this.aq.a(i2);
        }
    }

    private void f(int i2) {
        if (this.ap != null) {
            this.ap.b(i2);
        }
        if (this.ao != null) {
            int size = this.ao.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar = this.ao.get(i3);
                if (fVar != null) {
                    fVar.b(i2);
                }
            }
        }
        if (this.aq != null) {
            this.aq.b(i2);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void j() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f946a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void k() {
        if (this.ax != 0) {
            if (this.ay == null) {
                this.ay = new ArrayList<>();
            } else {
                this.ay.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ay.add(getChildAt(i2));
            }
            Collections.sort(this.ay, az);
        }
    }

    private boolean l() {
        this.V = -1;
        n();
        this.ai.onRelease();
        this.aj.onRelease();
        return this.ai.isFinished() || this.aj.isFinished();
    }

    private b m() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.A / clientWidth : 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        b bVar = null;
        boolean z = true;
        while (i3 < this.r.size()) {
            b bVar2 = this.r.get(i3);
            if (!z && bVar2.b != (i2 = i4 + 1)) {
                bVar2 = this.s;
                bVar2.e = f3 + f4 + f2;
                bVar2.b = i2;
                bVar2.d = this.b.d(bVar2.b);
                i3--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.r.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.b;
            f4 = bVar2.d;
            i3++;
            z = false;
            bVar = bVar2;
        }
        return bVar;
    }

    private void n() {
        this.M = false;
        this.N = false;
        if (this.aa != null) {
            this.aa.recycle();
            this.aa = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.J != z) {
            this.J = z;
        }
    }

    float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    b a(View view) {
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            b bVar = this.r.get(i2);
            if (this.b.a(view, bVar.f945a)) {
                return bVar;
            }
        }
        return null;
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.x = new Scroller(context, q);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.Q = viewConfiguration.getScaledPagingTouchSlop();
        this.ab = (int) (400.0f * f2);
        this.ac = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ai = new EdgeEffect(context);
        this.aj = new EdgeEffect(context);
        this.ad = (int) (25.0f * f2);
        this.ae = (int) (2.0f * f2);
        this.O = (int) (f2 * 16.0f);
        af.a(this, new C0071d());
        if (af.i(this) == 0) {
            af.e((View) this, 1);
        }
        af.a(this, new y() { // from class: androidx.l.a.d.4
            private final Rect b = new Rect();

            @Override // androidx.core.n.y
            public ao a(View view, ao aoVar) {
                ao aoVarA = af.a(view, aoVar);
                if (aoVarA.g()) {
                    return aoVarA;
                }
                Rect rect = this.b;
                rect.left = aoVarA.a();
                rect.top = aoVarA.b();
                rect.right = aoVarA.c();
                rect.bottom = aoVarA.d();
                int childCount = d.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    ao aoVarB = af.b(d.this.getChildAt(i2), aoVarA);
                    rect.left = Math.min(aoVarB.a(), rect.left);
                    rect.top = Math.min(aoVarB.b(), rect.top);
                    rect.right = Math.min(aoVarB.c(), rect.right);
                    rect.bottom = Math.min(aoVarB.d(), rect.bottom);
                }
                return aoVarA.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00ff A[PHI: r7 r10 r15
      0x00ff: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r10v7 int) = (r10v1 int), (r10v6 int), (r10v10 int) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r15v6 int) = (r15v5 int), (r15v4 int), (r15v9 int) binds: [B:63:0x00f4, B:60:0x00de, B:54:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    void a(int i2) {
        b bVarB;
        String hexString;
        b bVarB2;
        b bVarA;
        b bVar;
        if (this.c != i2) {
            bVarB = b(this.c);
            this.c = i2;
        } else {
            bVarB = null;
        }
        if (this.b == null) {
            k();
            return;
        }
        if (this.K) {
            k();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.b.a((ViewGroup) this);
        int i3 = this.L;
        int iMax = Math.max(0, this.c - i3);
        int iB = this.b.b();
        int iMin = Math.min(iB - 1, this.c + i3);
        if (iB != this.o) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.o + ", found: " + iB + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.b.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.r.size()) {
                bVarB2 = this.r.get(i4);
                if (bVarB2.b >= this.c) {
                    if (bVarB2.b != this.c) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            bVarB2 = null;
            break;
        }
        if (bVarB2 == null && iB > 0) {
            bVarB2 = b(this.c, i4);
        }
        if (bVarB2 != null) {
            int i5 = i4 - 1;
            b bVar2 = i5 >= 0 ? this.r.get(i5) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - bVarB2.d) + (getPaddingLeft() / clientWidth);
            int i6 = i4;
            float f2 = 0.0f;
            for (int i7 = this.c - 1; i7 >= 0; i7--) {
                if (f2 < paddingLeft || i7 >= iMax) {
                    if (bVar2 == null || i7 != bVar2.b) {
                        f2 += b(i7, i5 + 1).d;
                        i6++;
                        if (i5 >= 0) {
                            bVar = this.r.get(i5);
                        } else {
                            bVar = null;
                        }
                    } else {
                        f2 += bVar2.d;
                        i5--;
                        if (i5 >= 0) {
                            bVar = this.r.get(i5);
                        } else {
                            bVar = null;
                        }
                    }
                    bVar2 = bVar;
                } else {
                    if (bVar2 == null) {
                        break;
                    }
                    if (i7 == bVar2.b && !bVar2.c) {
                        this.r.remove(i5);
                        this.b.a((ViewGroup) this, i7, bVar2.f945a);
                        i5--;
                        i6--;
                        if (i5 >= 0) {
                            bVar = this.r.get(i5);
                        } else {
                            bVar = null;
                        }
                        bVar2 = bVar;
                    }
                }
            }
            float f3 = bVarB2.d;
            int i8 = i6 + 1;
            if (f3 < 2.0f) {
                b bVar3 = i8 < this.r.size() ? this.r.get(i8) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i9 = this.c;
                while (true) {
                    i9++;
                    if (i9 >= iB) {
                        break;
                    }
                    if (f3 >= paddingRight && i9 > iMin) {
                        if (bVar3 == null) {
                            break;
                        }
                        if (i9 == bVar3.b && !bVar3.c) {
                            this.r.remove(i8);
                            this.b.a((ViewGroup) this, i9, bVar3.f945a);
                            if (i8 < this.r.size()) {
                                bVar3 = this.r.get(i8);
                            }
                        }
                    } else if (bVar3 == null || i9 != bVar3.b) {
                        b bVarB3 = b(i9, i8);
                        i8++;
                        f3 += bVarB3.d;
                        bVar3 = i8 < this.r.size() ? this.r.get(i8) : null;
                    } else {
                        f3 += bVar3.d;
                        i8++;
                        if (i8 < this.r.size()) {
                            bVar3 = this.r.get(i8);
                        }
                    }
                }
            }
            a(bVarB2, i6, bVarB);
            this.b.b((ViewGroup) this, this.c, bVarB2.f945a);
        }
        this.b.b((ViewGroup) this);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c cVar = (c) childAt.getLayoutParams();
            cVar.f = i10;
            if (!cVar.f946a && cVar.c == 0.0f && (bVarA = a(childAt)) != null) {
                cVar.c = bVarA.d;
                cVar.e = bVarA.b;
            }
        }
        k();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            b bVarB4 = viewFindFocus != null ? b(viewFindFocus) : null;
            if (bVarB4 == null || bVarB4.b != this.c) {
                for (int i11 = 0; i11 < getChildCount(); i11++) {
                    View childAt2 = getChildAt(i11);
                    b bVarA2 = a(childAt2);
                    if (bVarA2 != null && bVarA2.b == this.c && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0066  */
    @androidx.annotation.i
    protected void a(int i2, float f2, int i3) {
        int iMax;
        int width;
        int left;
        if (this.an > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            int measuredWidth = paddingRight;
            int i4 = paddingLeft;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f946a) {
                    int i6 = cVar.b & 7;
                    if (i6 != 1) {
                        if (i6 == 3) {
                            width = childAt.getWidth() + i4;
                        } else if (i6 != 5) {
                            width = i4;
                        } else {
                            iMax = (width2 - measuredWidth) - childAt.getMeasuredWidth();
                            measuredWidth += childAt.getMeasuredWidth();
                        }
                        left = (i4 + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        i4 = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, i4);
                    }
                    int i7 = iMax;
                    width = i4;
                    i4 = i7;
                    left = (i4 + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    i4 = width;
                }
            }
        }
        b(i2, f2, i3);
        if (this.as != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((c) childAt2.getLayoutParams()).f946a) {
                    this.as.a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.am = true;
    }

    void a(int i2, int i3) {
        a(i2, i3, 0);
    }

    void a(int i2, int i3, int i4) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.x == null || this.x.isFinished()) ? false : true) {
            scrollX = this.y ? this.x.getCurrX() : this.x.getStartX();
            this.x.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            a(false);
            d();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fA = f3 + (a(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs2 = Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fA / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i6) / ((f2 * this.b.d(this.c)) + this.A)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, k);
        this.y = false;
        this.x.startScroll(i5, scrollY, i6, i7, iMin);
        af.h(this);
    }

    public void a(int i2, boolean z) {
        this.K = false;
        a(i2, z, false);
    }

    void a(int i2, boolean z, boolean z2) {
        a(i2, z, z2, 0);
    }

    void a(int i2, boolean z, boolean z2, int i3) {
        if (this.b == null || this.b.b() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.c == i2 && this.r.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.b.b()) {
            i2 = this.b.b() - 1;
        }
        int i4 = this.L;
        if (i2 > this.c + i4 || i2 < this.c - i4) {
            for (int i5 = 0; i5 < this.r.size(); i5++) {
                this.r.get(i5).c = true;
            }
        }
        boolean z3 = this.c != i2;
        if (!this.ak) {
            a(i2);
            a(i2, z, i3, z3);
        } else {
            this.c = i2;
            if (z3) {
                e(i2);
            }
            requestLayout();
        }
    }

    public void a(@ah e eVar) {
        if (this.ar == null) {
            this.ar = new ArrayList();
        }
        this.ar.add(eVar);
    }

    public void a(@ah f fVar) {
        if (this.ao == null) {
            this.ao = new ArrayList();
        }
        this.ao.add(fVar);
    }

    public void a(boolean z, @ai g gVar) {
        a(z, gVar, 2);
    }

    public void a(boolean z, @ai g gVar, int i2) {
        boolean z2 = gVar != null;
        boolean z3 = z2 != (this.as != null);
        this.as = gVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.ax = z ? 2 : 1;
            this.at = i2;
        } else {
            this.ax = 0;
        }
        if (z3) {
            d();
        }
    }

    public boolean a(@ah KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        return keyEvent.hasModifiers(2) ? h() : c(17);
                    case 22:
                        return keyEvent.hasModifiers(2) ? i() : c(66);
                }
            }
            if (keyEvent.hasNoModifiers()) {
                return c(2);
            }
            if (keyEvent.hasModifiers(1)) {
                return c(1);
            }
        }
        return false;
    }

    protected boolean a(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b bVarA;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.b == this.c) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bVarA;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.b == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f946a |= c(view);
        if (!this.I) {
            super.addView(view, i2, layoutParams);
        } else {
            if (cVar != null && cVar.f946a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    b b(int i2) {
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            b bVar = this.r.get(i3);
            if (bVar.b == i2) {
                return bVar;
            }
        }
        return null;
    }

    b b(int i2, int i3) {
        b bVar = new b();
        bVar.b = i2;
        bVar.f945a = this.b.a((ViewGroup) this, i2);
        bVar.d = this.b.d(i2);
        if (i3 < 0 || i3 >= this.r.size()) {
            this.r.add(bVar);
        } else {
            this.r.add(i3, bVar);
        }
        return bVar;
    }

    b b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public void b() {
        if (this.ao != null) {
            this.ao.clear();
        }
    }

    public void b(float f2) {
        if (!this.ag) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.b == null) {
            return;
        }
        this.R += f2;
        float scrollX = getScrollX() - f2;
        float clientWidth = getClientWidth();
        float f3 = this.E * clientWidth;
        float f4 = this.F * clientWidth;
        b bVar = this.r.get(0);
        b bVar2 = this.r.get(this.r.size() - 1);
        if (bVar.b != 0) {
            f3 = bVar.e * clientWidth;
        }
        if (bVar2.b != this.b.b() - 1) {
            f4 = bVar2.e * clientWidth;
        }
        if (scrollX < f3) {
            scrollX = f3;
        } else if (scrollX > f4) {
            scrollX = f4;
        }
        int i2 = (int) scrollX;
        this.R += scrollX - i2;
        scrollTo(i2, getScrollY());
        d(i2);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.ah, SystemClock.uptimeMillis(), 2, this.R, 0.0f, 0);
        this.aa.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    public void b(@ah e eVar) {
        if (this.ar != null) {
            this.ar.remove(eVar);
        }
    }

    public void b(@ah f fVar) {
        if (this.ao != null) {
            this.ao.remove(fVar);
        }
    }

    f c(f fVar) {
        f fVar2 = this.aq;
        this.aq = fVar;
        return fVar2;
    }

    void c() {
        int iB = this.b.b();
        this.o = iB;
        boolean z = this.r.size() < (this.L * 2) + 1 && this.r.size() < iB;
        int iMax = this.c;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.r.size()) {
            b bVar = this.r.get(i2);
            int iA = this.b.a(bVar.f945a);
            if (iA != -1) {
                if (iA == -2) {
                    this.r.remove(i2);
                    i2--;
                    if (!z2) {
                        this.b.a((ViewGroup) this);
                        z2 = true;
                    }
                    this.b.a((ViewGroup) this, bVar.b, bVar.f945a);
                    if (this.c == bVar.b) {
                        iMax = Math.max(0, Math.min(this.c, iB - 1));
                    }
                } else if (bVar.b != iA) {
                    if (bVar.b == this.c) {
                        iMax = iA;
                    }
                    bVar.b = iA;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.b.b((ViewGroup) this);
        }
        Collections.sort(this.r, p);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                if (!cVar.f946a) {
                    cVar.c = 0.0f;
                }
            }
            a(iMax, false, true);
            requestLayout();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0068  */
    public boolean c(int i2) {
        boolean zRequestFocus;
        boolean z;
        View viewFindFocus = findFocus();
        boolean zH = false;
        View view = null;
        if (viewFindFocus != this) {
            if (viewFindFocus != null) {
                ViewParent parent = viewFindFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    }
                    if (parent == this) {
                        z = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (z) {
                    view = viewFindFocus;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(viewFindFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e(g, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            } else {
                view = viewFindFocus;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (viewFindNextFocus != null && viewFindNextFocus != view) {
            if (i2 == 17) {
                zRequestFocus = (view == null || a(this.t, viewFindNextFocus).left < a(this.t, view).left) ? viewFindNextFocus.requestFocus() : h();
            } else if (i2 == 66) {
                zRequestFocus = (view == null || a(this.t, viewFindNextFocus).left > a(this.t, view).left) ? viewFindNextFocus.requestFocus() : i();
            }
            zH = zRequestFocus;
        } else if (i2 == 17 || i2 == 1) {
            zH = h();
        } else if (i2 == 66 || i2 == 2) {
            zH = i();
        }
        if (zH) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zH;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.E));
        }
        return i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.F));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.y = true;
        if (this.x.isFinished() || !this.x.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.x.getCurrX();
        int currY = this.x.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.x.abortAnimation();
                scrollTo(0, currY);
            }
        }
        af.h(this);
    }

    void d() {
        a(this.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bVarA;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && this.b != null && this.b.b() > 1)) {
            if (!this.ai.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.E * width);
                this.ai.setSize(height, width);
                zDraw = false | this.ai.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.aj.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.F + 1.0f)) * width2);
                this.aj.setSize(height2, width2);
                zDraw |= this.aj.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.ai.finish();
            this.aj.finish();
        }
        if (zDraw) {
            af.h(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.B;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public boolean e() {
        if (this.M) {
            return false;
        }
        this.ag = true;
        setScrollState(1);
        this.R = 0.0f;
        this.T = 0.0f;
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        } else {
            this.aa.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, 0.0f, 0.0f, 0);
        this.aa.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.ah = jUptimeMillis;
        return true;
    }

    public void f() {
        if (!this.ag) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.b != null) {
            VelocityTracker velocityTracker = this.aa;
            velocityTracker.computeCurrentVelocity(1000, this.ac);
            int xVelocity = (int) velocityTracker.getXVelocity(this.V);
            this.K = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b bVarM = m();
            a(a(bVarM.b, ((scrollX / clientWidth) - bVarM.e) / bVarM.d, xVelocity, (int) (this.R - this.T)), true, true, xVelocity);
        }
        n();
        this.ag = false;
    }

    public boolean g() {
        return this.ag;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @ai
    public androidx.l.a.a getAdapter() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.ax == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ay.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.c;
    }

    public int getOffscreenPageLimit() {
        return this.L;
    }

    public int getPageMargin() {
        return this.A;
    }

    boolean h() {
        if (this.c <= 0) {
            return false;
        }
        a(this.c - 1, true);
        return true;
    }

    boolean i() {
        if (this.b == null || this.c >= this.b.b() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ak = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.aA);
        if (this.x != null && !this.x.isFinished()) {
            this.x.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.A <= 0 || this.B == null || this.r.size() <= 0 || this.b == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f4 = width;
        float f5 = this.A / f4;
        int i2 = 0;
        b bVar = this.r.get(0);
        float f6 = bVar.e;
        int size = this.r.size();
        int i3 = bVar.b;
        int i4 = this.r.get(size - 1).b;
        while (i3 < i4) {
            while (i3 > bVar.b && i2 < size) {
                i2++;
                bVar = this.r.get(i2);
            }
            if (i3 == bVar.b) {
                f3 = (bVar.e + bVar.d) * f4;
                f2 = bVar.e + bVar.d + f5;
            } else {
                float fD = this.b.d(i3);
                float f7 = (f6 + fD) * f4;
                f2 = f6 + fD + f5;
                f3 = f7;
            }
            if (this.A + f3 > scrollX) {
                this.B.setBounds(Math.round(f3), this.C, Math.round(this.A + f3), this.D);
                this.B.draw(canvas);
            }
            if (f3 > scrollX + width) {
                return;
            }
            i3++;
            f6 = f2;
            f5 = f5;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            l();
            return false;
        }
        if (action != 0) {
            if (this.M) {
                return true;
            }
            if (this.N) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.T = x;
            this.R = x;
            float y = motionEvent.getY();
            this.U = y;
            this.S = y;
            this.V = motionEvent.getPointerId(0);
            this.N = false;
            this.y = true;
            this.x.computeScrollOffset();
            if (this.aB != 2 || Math.abs(this.x.getFinalX() - this.x.getCurrX()) <= this.ae) {
                a(false);
                this.M = false;
            } else {
                this.x.abortAnimation();
                this.K = false;
                d();
                this.M = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.V;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.R;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.U);
                if (f2 != 0.0f && !a(this.R, f2) && a(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.R = x2;
                    this.S = y2;
                    this.N = true;
                    return false;
                }
                if (fAbs > this.Q && fAbs * 0.5f > fAbs2) {
                    this.M = true;
                    c(true);
                    setScrollState(1);
                    this.R = f2 > 0.0f ? this.T + this.Q : this.T - this.Q;
                    this.S = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.Q) {
                    this.N = true;
                }
                if (this.M && c(x2)) {
                    af.h(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        }
        this.aa.addMovement(motionEvent);
        return this.M;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        b bVarA;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i8 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f946a) {
                    int i10 = cVar.b & 7;
                    int i11 = cVar.b & 112;
                    if (i10 == 1) {
                        iMax = Math.max((i6 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i10 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i10 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i11 == 16) {
                        iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i11 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i11 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i7 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i12 = iMax + scrollX;
                    childAt.layout(i12, iMax2, childAt.getMeasuredWidth() + i12, iMax2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i13 = (i6 - measuredWidth) - paddingRight;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f946a && (bVarA = a(childAt2)) != null) {
                    float f2 = i13;
                    int i15 = ((int) (bVarA.e * f2)) + measuredWidth;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.c), androidx.d.c.b.a.b.b), View.MeasureSpec.makeMeasureSpec((i7 - measuredHeight2) - measuredHeight, androidx.d.c.b.a.b.b));
                    }
                    childAt2.layout(i15, measuredHeight2, childAt2.getMeasuredWidth() + i15, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.C = measuredHeight2;
        this.D = i7 - measuredHeight;
        this.an = i8;
        if (this.ak) {
            z2 = false;
            a(this.c, false, 0, false);
        } else {
            z2 = false;
        }
        this.ak = z2;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.P = Math.min(measuredWidth / 10, this.O);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int measuredHeight2 = measuredHeight;
        int measuredWidth2 = paddingLeft;
        int i7 = 0;
        while (true) {
            boolean z2 = true;
            int i8 = androidx.d.c.b.a.b.b;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.f946a) {
                int i9 = cVar2.b & 7;
                int i10 = cVar2.b & 112;
                boolean z3 = (i10 == 48 || i10 == 80) ? true : z;
                if (i9 != 3 && i9 != 5) {
                    z2 = z;
                }
                int i11 = Integer.MIN_VALUE;
                if (z3) {
                    i4 = Integer.MIN_VALUE;
                    i11 = 1073741824;
                } else {
                    i4 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (cVar2.width != -2) {
                    i5 = cVar2.width != -1 ? cVar2.width : measuredWidth2;
                    i11 = 1073741824;
                } else {
                    i5 = measuredWidth2;
                }
                if (cVar2.height != -2) {
                    i6 = cVar2.height != -1 ? cVar2.height : measuredHeight2;
                } else {
                    i6 = measuredHeight2;
                    i8 = i4;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i11), View.MeasureSpec.makeMeasureSpec(i6, i8));
                if (z3) {
                    measuredHeight2 -= childAt.getMeasuredHeight();
                } else if (z2) {
                    measuredWidth2 -= childAt.getMeasuredWidth();
                }
            }
            i7++;
            z = false;
        }
        this.G = View.MeasureSpec.makeMeasureSpec(measuredWidth2, androidx.d.c.b.a.b.b);
        this.H = View.MeasureSpec.makeMeasureSpec(measuredHeight2, androidx.d.c.b.a.b.b);
        this.I = true;
        d();
        this.I = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.f946a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (measuredWidth2 * cVar.c), androidx.d.c.b.a.b.b), this.H);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b bVarA;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarA = a(childAt)) != null && bVarA.b == this.c && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        if (this.b != null) {
            this.b.a(iVar.b, iVar.d);
            a(iVar.f949a, false, true);
        } else {
            this.u = iVar.f949a;
            this.v = iVar.b;
            this.w = iVar.d;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f949a = this.c;
        if (this.b != null) {
            iVar.b = this.b.a();
        }
        return iVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            a(i2, i4, this.A, this.A);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00d5  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ag) {
            return true;
        }
        boolean zL = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.b == null || this.b.b() == 0) {
            return false;
        }
        if (this.aa == null) {
            this.aa = VelocityTracker.obtain();
        }
        this.aa.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.x.abortAnimation();
                this.K = false;
                d();
                float x = motionEvent.getX();
                this.T = x;
                this.R = x;
                float y = motionEvent.getY();
                this.U = y;
                this.S = y;
                this.V = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.M) {
                    VelocityTracker velocityTracker = this.aa;
                    velocityTracker.computeCurrentVelocity(1000, this.ac);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.V);
                    this.K = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    b bVarM = m();
                    float f2 = clientWidth;
                    a(a(bVarM.b, ((scrollX / f2) - bVarM.e) / (bVarM.d + (this.A / f2)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.V)) - this.T)), true, true, xVelocity);
                    zL = l();
                }
                break;
            case 2:
                if (!this.M) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.V);
                    if (iFindPointerIndex != -1) {
                        float x2 = motionEvent.getX(iFindPointerIndex);
                        float fAbs = Math.abs(x2 - this.R);
                        float y2 = motionEvent.getY(iFindPointerIndex);
                        float fAbs2 = Math.abs(y2 - this.S);
                        if (fAbs > this.Q && fAbs > fAbs2) {
                            this.M = true;
                            c(true);
                            this.R = x2 - this.T > 0.0f ? this.T + this.Q : this.T - this.Q;
                            this.S = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        if (this.M) {
                            zL = false | c(motionEvent.getX(motionEvent.findPointerIndex(this.V)));
                        }
                    } else {
                        zL = l();
                    }
                } else if (this.M) {
                    zL = false | c(motionEvent.getX(motionEvent.findPointerIndex(this.V)));
                }
                break;
            case 3:
                if (this.M) {
                    a(this.c, true, 0, false);
                    zL = l();
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.R = motionEvent.getX(actionIndex);
                this.V = motionEvent.getPointerId(actionIndex);
                break;
            case 6:
                a(motionEvent);
                this.R = motionEvent.getX(motionEvent.findPointerIndex(this.V));
                break;
        }
        if (zL) {
            af.h(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.I) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@ai androidx.l.a.a aVar) {
        if (this.b != null) {
            this.b.c((DataSetObserver) null);
            this.b.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                b bVar = this.r.get(i2);
                this.b.a((ViewGroup) this, bVar.b, bVar.f945a);
            }
            this.b.b((ViewGroup) this);
            this.r.clear();
            j();
            this.c = 0;
            scrollTo(0, 0);
        }
        androidx.l.a.a aVar2 = this.b;
        this.b = aVar;
        this.o = 0;
        if (this.b != null) {
            if (this.z == null) {
                this.z = new h();
            }
            this.b.c(this.z);
            this.K = false;
            boolean z = this.ak;
            this.ak = true;
            this.o = this.b.b();
            if (this.u >= 0) {
                this.b.a(this.v, this.w);
                a(this.u, false, true);
                this.u = -1;
                this.v = null;
                this.w = null;
            } else if (z) {
                requestLayout();
            } else {
                d();
            }
        }
        if (this.ar == null || this.ar.isEmpty()) {
            return;
        }
        int size = this.ar.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.ar.get(i3).a(this, aVar2, aVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.K = false;
        a(i2, !this.ak, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(g, "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.L) {
            this.L = i2;
            d();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ap = fVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.A;
        this.A = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(@q int i2) {
        setPageMarginDrawable(androidx.core.b.c.a(getContext(), i2));
    }

    public void setPageMarginDrawable(@ai Drawable drawable) {
        this.B = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i2) {
        if (this.aB == i2) {
            return;
        }
        this.aB = i2;
        if (this.as != null) {
            b(i2 != 0);
        }
        f(i2);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.B;
    }
}
