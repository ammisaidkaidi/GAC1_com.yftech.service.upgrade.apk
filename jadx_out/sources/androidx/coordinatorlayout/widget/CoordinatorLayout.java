package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.ax;
import androidx.annotation.k;
import androidx.annotation.q;
import androidx.annotation.r;
import androidx.core.n.af;
import androidx.core.n.ao;
import androidx.core.n.v;
import androidx.core.n.w;
import androidx.core.n.x;
import androidx.core.n.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements v, w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f322a = "CoordinatorLayout";
    static final String b;
    static final Class<?>[] c;
    static final ThreadLocal<Map<String, Constructor<b>>> d;
    static final int e = 0;
    static final int f = 1;
    static final int g = 2;
    static final Comparator<View> h;
    private static final int j = 0;
    private static final int k = 1;
    private static final androidx.core.m.h.a<Rect> l;
    private ao A;
    private boolean B;
    private Drawable C;
    private y D;
    private final x E;
    ViewGroup.OnHierarchyChangeListener i;
    private final List<View> m;
    private final androidx.coordinatorlayout.widget.a<View> n;
    private final List<View> o;
    private final List<View> p;
    private Paint q;
    private final int[] r;
    private final int[] s;
    private boolean t;
    private boolean u;
    private int[] v;
    private View w;
    private View x;
    private g y;
    private boolean z;

    public interface a {
        @ah
        b getBehavior();
    }

    public static abstract class b<V extends View> {
        public b() {
        }

        public b(Context context, AttributeSet attributeSet) {
        }

        @ai
        public static Object a(@ah View view) {
            return ((f) view.getLayoutParams()).n;
        }

        public static void a(@ah View view, @ai Object obj) {
            ((f) view.getLayoutParams()).n = obj;
        }

        @k
        public int a(@ah CoordinatorLayout coordinatorLayout, @ah V v) {
            return af.s;
        }

        @ah
        public ao a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah ao aoVar) {
            return aoVar;
        }

        public void a() {
        }

        public void a(@ah f fVar) {
        }

        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah Parcelable parcelable) {
        }

        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i, int i2, int i3, int i4, int i5, @ah int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            a(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        @Deprecated
        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i, int i2, @ah int[] iArr) {
        }

        public void a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, int i, int i2, @ah int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, int i) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah Rect rect) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah Rect rect, boolean z) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah MotionEvent motionEvent) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, float f, float f2) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, @ah View view2, int i) {
            return false;
        }

        public boolean a(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, @ah View view2, int i, int i2) {
            if (i2 == 0) {
                return a(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        @r(a = 0.0d, b = 1.0d)
        public float b(@ah CoordinatorLayout coordinatorLayout, @ah V v) {
            return 0.0f;
        }

        @Deprecated
        public void b(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, @ah View view2, int i) {
        }

        public void b(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view, @ah View view2, int i, int i2) {
            if (i2 == 0) {
                b(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean b(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah MotionEvent motionEvent) {
            return false;
        }

        public boolean b(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view) {
            return false;
        }

        public void c(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view) {
        }

        public boolean c(@ah CoordinatorLayout coordinatorLayout, @ah V v) {
            return b(coordinatorLayout, v) > 0.0f;
        }

        @ai
        public Parcelable d(@ah CoordinatorLayout coordinatorLayout, @ah V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(@ah CoordinatorLayout coordinatorLayout, @ah V v, @ah View view) {
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface c {
        Class<? extends b> a();
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface d {
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.i != null) {
                CoordinatorLayout.this.i.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.i != null) {
                CoordinatorLayout.this.i.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f325a;
        boolean b;
        public int c;
        public int d;
        public int e;
        int f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        final Rect m;
        Object n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;

        public f(int i, int i2) {
            super(i, i2);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        f(@ah Context context, @ai AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout);
            this.c = typedArrayObtainStyledAttributes.getInteger(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_anchor, -1);
            this.d = typedArrayObtainStyledAttributes.getInteger(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.e = typedArrayObtainStyledAttributes.getInteger(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = typedArrayObtainStyledAttributes.getInt(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = typedArrayObtainStyledAttributes.getInt(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.b = typedArrayObtainStyledAttributes.hasValue(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_behavior);
            if (this.b) {
                this.f325a = CoordinatorLayout.a(context, attributeSet, typedArrayObtainStyledAttributes.getString(androidx.coordinatorlayout.a.j.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f325a != null) {
                this.f325a.a(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.m = new Rect();
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f);
            if (this.k == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f) + " to anchor view " + view);
            }
            if (this.k == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.l = null;
                this.k = null;
                return;
            }
            View view2 = this.k;
            for (ViewParent parent = this.k.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.l = null;
                    this.k = null;
                    return;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
        }

        private boolean a(View view, int i) {
            int iA = androidx.core.n.h.a(((f) view.getLayoutParams()).g, i);
            return iA != 0 && (androidx.core.n.h.a(this.h, i) & iA) == iA;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = this.k.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
            return true;
        }

        @androidx.annotation.w
        public int a() {
            return this.f;
        }

        public void a(@androidx.annotation.w int i) {
            i();
            this.f = i;
        }

        void a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.p = z;
                    break;
                case 1:
                    this.q = z;
                    break;
            }
        }

        void a(Rect rect) {
            this.m.set(rect);
        }

        public void a(@ai b bVar) {
            if (this.f325a != bVar) {
                if (this.f325a != null) {
                    this.f325a.a();
                }
                this.f325a = bVar;
                this.n = null;
                this.b = true;
                if (bVar != null) {
                    bVar.a(this);
                }
            }
        }

        void a(boolean z) {
            this.r = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.o) {
                return true;
            }
            boolean zC = (this.f325a != null ? this.f325a.c(coordinatorLayout, view) : false) | this.o;
            this.o = zC;
            return zC;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.l || a(view2, af.p(coordinatorLayout)) || (this.f325a != null && this.f325a.a(coordinatorLayout, view, view2));
        }

        View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        @ai
        public b b() {
            return this.f325a;
        }

        void b(int i) {
            a(i, false);
        }

        Rect c() {
            return this.m;
        }

        boolean c(int i) {
            switch (i) {
                case 0:
                    return this.p;
                case 1:
                    return this.q;
                default:
                    return false;
            }
        }

        boolean d() {
            return this.k == null && this.f != -1;
        }

        boolean e() {
            if (this.f325a == null) {
                this.o = false;
            }
            return this.o;
        }

        void f() {
            this.o = false;
        }

        boolean g() {
            return this.r;
        }

        void h() {
            this.r = false;
        }

        void i() {
            this.l = null;
            this.k = null;
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    protected static class h extends androidx.f.a.a {
        public static final Parcelable.Creator<h> CREATOR = new Parcelable.ClassLoaderCreator<h>() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.h.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<Parcelable> f327a;

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f327a = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f327a.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.f.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f327a != null ? this.f327a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f327a.keyAt(i2);
                parcelableArr[i2] = this.f327a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fAi = af.ai(view);
            float fAi2 = af.ai(view2);
            if (fAi > fAi2) {
                return -1;
            }
            return fAi < fAi2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        b = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            h = new i();
        } else {
            h = null;
        }
        c = new Class[]{Context.class, AttributeSet.class};
        d = new ThreadLocal<>();
        l = new androidx.core.m.h.c(12);
    }

    public CoordinatorLayout(@ah Context context) {
        this(context, null);
    }

    public CoordinatorLayout(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.coordinatorlayout.a.C0021a.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(@ah Context context, @ai AttributeSet attributeSet, @androidx.annotation.f int i2) {
        super(context, attributeSet, i2);
        this.m = new ArrayList();
        this.n = new androidx.coordinatorlayout.widget.a<>();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new int[2];
        this.s = new int[2];
        this.E = new x(this);
        TypedArray typedArrayObtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.a.j.CoordinatorLayout, 0, androidx.coordinatorlayout.a.i.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, androidx.coordinatorlayout.a.j.CoordinatorLayout, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, androidx.coordinatorlayout.a.j.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, androidx.coordinatorlayout.a.i.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, androidx.coordinatorlayout.a.j.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.coordinatorlayout.a.j.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.v = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.v.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.v[i3] = (int) (this.v[i3] * f2);
            }
        }
        this.C = typedArrayObtainStyledAttributes.getDrawable(androidx.coordinatorlayout.a.j.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new e());
        if (af.i(this) == 0) {
            af.e((View) this, 1);
        }
    }

    private static int a(int i2, int i3, int i4) {
        if (i2 < i3) {
            return i3;
        }
        return i2 > i4 ? i4 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static b a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(b)) {
            str = b + '.' + str;
        }
        try {
            Map<String, Constructor<b>> map = d.get();
            if (map == null) {
                map = new HashMap<>();
                d.set(map);
            }
            Constructor<b> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(c);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private static void a(@ah Rect rect) {
        rect.setEmpty();
        l.a(rect);
    }

    private void a(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int iWidth;
        int iHeight;
        int iA = androidx.core.n.h.a(e(fVar.c), i2);
        int iA2 = androidx.core.n.h.a(c(fVar.d), i2);
        int i5 = iA & 7;
        int i6 = iA & 112;
        int i7 = iA2 & 7;
        int i8 = iA2 & 112;
        if (i7 != 1) {
            iWidth = i7 != 5 ? rect.left : rect.right;
        } else {
            iWidth = rect.left + (rect.width() / 2);
        }
        if (i8 != 16) {
            iHeight = i8 != 80 ? rect.top : rect.bottom;
        } else {
            iHeight = rect.top + (rect.height() / 2);
        }
        if (i5 == 1) {
            iWidth -= i3 / 2;
        } else if (i5 != 5) {
            iWidth -= i3;
        }
        if (i6 == 16) {
            iHeight -= i4 / 2;
        } else if (i6 != 80) {
            iHeight -= i4;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i4 + iHeight);
    }

    private void a(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i3;
        int height;
        int i4;
        if (af.ag(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            b bVarB = fVar.b();
            Rect rectE = e();
            Rect rectE2 = e();
            rectE2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (bVarB == null || !bVarB.a(this, view, rectE)) {
                rectE.set(rectE2);
            } else if (!rectE2.contains(rectE)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectE.toShortString() + " | Bounds:" + rectE2.toShortString());
            }
            a(rectE2);
            if (rectE.isEmpty()) {
                a(rectE);
                return;
            }
            int iA = androidx.core.n.h.a(fVar.h, i2);
            if ((iA & 48) != 48 || (i4 = (rectE.top - fVar.topMargin) - fVar.j) >= rect.top) {
                z = false;
            } else {
                f(view, rect.top - i4);
                z = true;
            }
            if ((iA & 80) == 80 && (height = ((getHeight() - rectE.bottom) - fVar.bottomMargin) + fVar.j) < rect.bottom) {
                f(view, height - rect.bottom);
                z = true;
            }
            if (!z) {
                f(view, 0);
            }
            if ((iA & 3) != 3 || (i3 = (rectE.left - fVar.leftMargin) - fVar.i) >= rect.left) {
                z2 = false;
            } else {
                e(view, rect.left - i3);
                z2 = true;
            }
            if ((iA & 5) == 5 && (width = ((getWidth() - rectE.right) - fVar.rightMargin) + fVar.i) < rect.right) {
                e(view, width - rect.right);
                z2 = true;
            }
            if (!z2) {
                e(view, 0);
            }
            a(rectE);
        }
    }

    private void a(View view, View view2, int i2) {
        Rect rectE = e();
        Rect rectE2 = e();
        try {
            a(view2, rectE);
            a(view, i2, rectE, rectE2);
            view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        } finally {
            a(rectE);
            a(rectE2);
        }
    }

    private void a(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - fVar.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - fVar.bottomMargin));
        rect.set(iMax, iMax2, i2 + iMax, i3 + iMax2);
    }

    private void a(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        if (h != null) {
            Collections.sort(list, h);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            b bVarB = ((f) childAt.getLayoutParams()).b();
            if (bVarB != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    bVarB.a(this, childAt, motionEventObtain);
                } else {
                    bVarB.b(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).f();
        }
        this.w = null;
        this.t = false;
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.o;
        a(list);
        int size = list.size();
        boolean zA = false;
        boolean z = false;
        MotionEvent motionEventObtain = null;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            b bVarB = fVar.b();
            if (!(zA || z) || actionMasked == 0) {
                if (!zA && bVarB != null) {
                    switch (i2) {
                        case 0:
                            zA = bVarB.a(this, view, motionEvent);
                            break;
                        case 1:
                            zA = bVarB.b(this, view, motionEvent);
                            break;
                    }
                    if (zA) {
                        this.w = view;
                    }
                }
                boolean zE = fVar.e();
                boolean zA2 = fVar.a(this, view);
                z = zA2 && !zE;
                if (zA2 && !z) {
                    list.clear();
                    return zA;
                }
            } else if (bVarB != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                switch (i2) {
                    case 0:
                        bVarB.a(this, view, motionEventObtain);
                        break;
                    case 1:
                        bVarB.b(this, view, motionEventObtain);
                        break;
                }
            }
        }
        list.clear();
        return zA;
    }

    private int b(int i2) {
        if (this.v == null) {
            Log.e(f322a, "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        }
        if (i2 >= 0 && i2 < this.v.length) {
            return this.v[i2];
        }
        Log.e(f322a, "Keyline index " + i2 + " out of range for " + this);
        return 0;
    }

    private ao b(ao aoVar) {
        b bVarB;
        if (aoVar.g()) {
            return aoVar;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (af.U(childAt) && (bVarB = ((f) childAt.getLayoutParams()).b()) != null) {
                aoVar = bVarB.a(this, childAt, aoVar);
                if (aoVar.g()) {
                    break;
                }
            }
        }
        return aoVar;
    }

    private void b(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int iA = androidx.core.n.h.a(d(fVar.c), i3);
        int i4 = iA & 7;
        int i5 = iA & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int iB = b(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            iB += measuredWidth / 2;
        } else if (i4 == 5) {
            iB += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + fVar.leftMargin, Math.min(iB, ((width - getPaddingRight()) - measuredWidth) - fVar.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + fVar.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - fVar.bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private static int c(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= androidx.core.n.h.b;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int d(int i2) {
        return i2 == 0 ? com.google.android.material.b.a.f1174a : i2;
    }

    private void d(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect rectE = e();
        rectE.set(getPaddingLeft() + fVar.leftMargin, getPaddingTop() + fVar.topMargin, (getWidth() - getPaddingRight()) - fVar.rightMargin, (getHeight() - getPaddingBottom()) - fVar.bottomMargin);
        if (this.A != null && af.U(this) && !af.U(view)) {
            rectE.left += this.A.a();
            rectE.top += this.A.b();
            rectE.right -= this.A.c();
            rectE.bottom -= this.A.d();
        }
        Rect rectE2 = e();
        androidx.core.n.h.a(c(fVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectE, rectE2, i2);
        view.layout(rectE2.left, rectE2.top, rectE2.right, rectE2.bottom);
        a(rectE);
        a(rectE2);
    }

    private static int e(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    @ah
    private static Rect e() {
        Rect rectA = l.a();
        return rectA == null ? new Rect() : rectA;
    }

    private void e(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.i != i2) {
            af.o(view, i2 - fVar.i);
            fVar.i = i2;
        }
    }

    private boolean e(View view) {
        return this.n.e(view);
    }

    private void f() {
        this.m.clear();
        this.n.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f fVarA = a(childAt);
            fVarA.b(this, childAt);
            this.n.a(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (fVarA.a(this, childAt, childAt2)) {
                        if (!this.n.b(childAt2)) {
                            this.n.a(childAt2);
                        }
                        this.n.a(childAt2, childAt);
                    }
                }
            }
        }
        this.m.addAll(this.n.b());
        Collections.reverse(this.m);
    }

    private void f(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.j != i2) {
            af.n(view, i2 - fVar.j);
            fVar.j = i2;
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!af.U(this)) {
            af.a(this, (y) null);
            return;
        }
        if (this.D == null) {
            this.D = new y() { // from class: androidx.coordinatorlayout.widget.CoordinatorLayout.1
                @Override // androidx.core.n.y
                public ao a(View view, ao aoVar) {
                    return CoordinatorLayout.this.a(aoVar);
                }
            };
        }
        af.a(this, this.D);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    f a(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.b) {
            if (view instanceof a) {
                b behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e(f322a, "Attached behavior class is null");
                }
                fVar.a(behavior);
                fVar.b = true;
            } else {
                c cVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    cVar = (c) superclass.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        fVar.a(cVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e(f322a, "Default behavior class " + cVar.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.b = true;
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    final ao a(ao aoVar) {
        if (androidx.core.m.e.a(this.A, aoVar)) {
            return aoVar;
        }
        this.A = aoVar;
        this.B = aoVar != null && aoVar.b() > 0;
        setWillNotDraw(!this.B && getBackground() == null);
        ao aoVarB = b(aoVar);
        requestLayout();
        return aoVarB;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    final void a(int i2) {
        int i3;
        b bVarB;
        boolean zB;
        int iP = af.p(this);
        int size = this.m.size();
        Rect rectE = e();
        Rect rectE2 = e();
        Rect rectE3 = e();
        for (int i4 = 0; i4 < size; i4++) {
            View view = this.m.get(i4);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (fVar.l == this.m.get(i5)) {
                        c(view, iP);
                    }
                }
                a(view, true, rectE2);
                if (fVar.g != 0 && !rectE2.isEmpty()) {
                    int iA = androidx.core.n.h.a(fVar.g, iP);
                    int i6 = iA & 112;
                    if (i6 == 48) {
                        rectE.top = Math.max(rectE.top, rectE2.bottom);
                    } else if (i6 == 80) {
                        rectE.bottom = Math.max(rectE.bottom, getHeight() - rectE2.top);
                    }
                    int i7 = iA & 7;
                    if (i7 == 3) {
                        rectE.left = Math.max(rectE.left, rectE2.right);
                    } else if (i7 == 5) {
                        rectE.right = Math.max(rectE.right, getWidth() - rectE2.left);
                    }
                }
                if (fVar.h != 0 && view.getVisibility() == 0) {
                    a(view, rectE, iP);
                }
                if (i2 != 2) {
                    c(view, rectE3);
                    if (!rectE3.equals(rectE2)) {
                        b(view, rectE2);
                        for (i3 = i4 + 1; i3 < size; i3++) {
                            View view2 = this.m.get(i3);
                            f fVar2 = (f) view2.getLayoutParams();
                            bVarB = fVar2.b();
                            if (bVarB == null && bVarB.a(this, view2, view)) {
                                if (i2 == 0 && fVar2.g()) {
                                    fVar2.h();
                                } else {
                                    if (i2 != 2) {
                                        zB = bVarB.b(this, view2, view);
                                    } else {
                                        bVarB.c(this, view2, view);
                                        zB = true;
                                    }
                                    if (i2 == 1) {
                                        fVar2.a(zB);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    while (i3 < size) {
                        View view3 = this.m.get(i3);
                        f fVar3 = (f) view3.getLayoutParams();
                        bVarB = fVar3.b();
                        if (bVarB == null) {
                        }
                    }
                }
            }
        }
        a(rectE);
        a(rectE2);
        a(rectE3);
    }

    @Override // androidx.core.n.v
    public void a(View view, int i2) {
        this.E.a(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.c(i2)) {
                b bVarB = fVar.b();
                if (bVarB != null) {
                    bVarB.a(this, childAt, view, i2);
                }
                fVar.b(i2);
                fVar.h();
            }
        }
        this.x = null;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // androidx.core.n.v
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(view, i2, i3, i4, i5, 0, this.s);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // androidx.core.n.w
    public void a(@ah View view, int i2, int i3, int i4, int i5, int i6, @ah int[] iArr) {
        b bVarB;
        boolean z;
        int iMin;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i7 = i7;
            } else {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.c(i6) && (bVarB = fVar.b()) != null) {
                    this.r[0] = 0;
                    this.r[1] = 0;
                    int i10 = i7;
                    bVarB.a(this, childAt, view, i2, i3, i4, i5, i6, this.r);
                    int iMax = i4 > 0 ? Math.max(i8, this.r[0]) : Math.min(i8, this.r[0]);
                    if (i5 > 0) {
                        z = true;
                        iMin = Math.max(i10, this.r[1]);
                    } else {
                        z = true;
                        iMin = Math.min(i10, this.r[1]);
                    }
                    i8 = iMax;
                    i7 = iMin;
                    z2 = z;
                } else {
                    i7 = i7;
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i7;
        if (z2) {
            a(1);
        }
    }

    @Override // androidx.core.n.v
    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        b bVarB;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.c(i4) && (bVarB = fVar.b()) != null) {
                    this.r[0] = 0;
                    this.r[1] = 0;
                    bVarB.a(this, childAt, view, i2, i3, this.r, i4);
                    iMax = i2 > 0 ? Math.max(iMax, this.r[0]) : Math.min(iMax, this.r[0]);
                    iMax2 = i3 > 0 ? Math.max(iMax2, this.r[1]) : Math.min(iMax2, this.r[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            a(1);
        }
    }

    void a(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        a(fVar, rect2, measuredWidth, measuredHeight);
    }

    void a(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.b(this, view, rect);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean a(@ah View view, int i2, int i3) {
        Rect rectE = e();
        a(view, rectE);
        try {
            return rectE.contains(i2, i3);
        } finally {
            a(rectE);
        }
    }

    public boolean a(@ah View view, @ah View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectE = e();
        a(view, view.getParent() != this, rectE);
        Rect rectE2 = e();
        a(view2, view2.getParent() != this, rectE2);
        try {
            if (rectE.left <= rectE2.right && rectE.top <= rectE2.bottom && rectE.right >= rectE2.left && rectE.bottom >= rectE2.top) {
                z = true;
            }
            return z;
        } finally {
            a(rectE);
            a(rectE2);
        }
    }

    @Override // androidx.core.n.v
    public boolean a(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                b bVarB = fVar.b();
                if (bVarB != null) {
                    boolean zA = bVarB.a(this, childAt, view, view2, i2, i3);
                    fVar.a(i3, zA);
                    z |= zA;
                } else {
                    fVar.a(i3, false);
                }
            }
        }
        return z;
    }

    void b() {
        if (this.u) {
            if (this.y == null) {
                this.y = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.y);
        }
        this.z = true;
    }

    public void b(@ah View view) {
        List listC = this.n.c(view);
        if (listC == null || listC.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < listC.size(); i2++) {
            View view2 = (View) listC.get(i2);
            b bVarB = ((f) view2.getLayoutParams()).b();
            if (bVarB != null) {
                bVarB.b(this, view2, view);
            }
        }
    }

    public void b(@ah View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (fVar.k != null) {
            a(view, fVar.k, i2);
        } else if (fVar.e >= 0) {
            b(view, fVar.e, i2);
        } else {
            d(view, i2);
        }
    }

    void b(View view, Rect rect) {
        ((f) view.getLayoutParams()).a(rect);
    }

    @Override // androidx.core.n.v
    public void b(View view, View view2, int i2, int i3) {
        b bVarB;
        this.E.a(view, view2, i2, i3);
        this.x = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.c(i3) && (bVarB = fVar.b()) != null) {
                bVarB.b(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @ah
    public List<View> c(@ah View view) {
        List<View> listD = this.n.d(view);
        this.p.clear();
        if (listD != null) {
            this.p.addAll(listD);
        }
        return this.p;
    }

    void c(View view, int i2) {
        b bVarB;
        f fVar = (f) view.getLayoutParams();
        if (fVar.k != null) {
            Rect rectE = e();
            Rect rectE2 = e();
            Rect rectE3 = e();
            a(fVar.k, rectE);
            a(view, false, rectE2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i2, rectE, rectE3, fVar, measuredWidth, measuredHeight);
            boolean z = (rectE3.left == rectE2.left && rectE3.top == rectE2.top) ? false : true;
            a(fVar, rectE3, measuredWidth, measuredHeight);
            int i3 = rectE3.left - rectE2.left;
            int i4 = rectE3.top - rectE2.top;
            if (i3 != 0) {
                af.o(view, i3);
            }
            if (i4 != 0) {
                af.n(view, i4);
            }
            if (z && (bVarB = fVar.b()) != null) {
                bVarB.b(this, view, fVar.k);
            }
            a(rectE);
            a(rectE2);
            a(rectE3);
        }
    }

    void c(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).c());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @ah
    public List<View> d(@ah View view) {
        List listC = this.n.c(view);
        this.p.clear();
        if (listC != null) {
            this.p.addAll(listC);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.f325a != null) {
            float fB = fVar.f325a.b(this, view);
            if (fB > 0.0f) {
                if (this.q == null) {
                    this.q = new Paint();
                }
                this.q.setColor(fVar.f325a.a(this, view));
                this.q.setAlpha(a(Math.round(fB * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.q);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @ax
    final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.m);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public final ao getLastWindowInsets() {
        return this.A;
    }

    @Override // android.view.ViewGroup, androidx.core.n.u
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    @ai
    public Drawable getStatusBarBackground() {
        return this.C;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    void h_() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (e(getChildAt(i2))) {
                z = true;
                break;
            }
        }
        if (z != this.z) {
            if (z) {
                b();
            } else {
                i_();
            }
        }
    }

    void i_() {
        if (this.u && this.y != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.y);
        }
        this.z = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.z) {
            if (this.y == null) {
                this.y = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.y);
        }
        if (this.A == null && af.U(this)) {
            af.T(this);
        }
        this.u = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.z && this.y != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.y);
        }
        if (this.x != null) {
            onStopNestedScroll(this.x);
        }
        this.u = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.B || this.C == null) {
            return;
        }
        int iB = this.A != null ? this.A.b() : 0;
        if (iB > 0) {
            this.C.setBounds(0, 0, getWidth(), iB);
            this.C.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean zA = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVarB;
        int iP = af.p(this);
        int size = this.m.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.m.get(i6);
            if (view.getVisibility() != 8 && ((bVarB = ((f) view.getLayoutParams()).b()) == null || !bVarB.a(this, view, iP))) {
                b(view, iP);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x011c  */
    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int iMax;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        b bVarB;
        f fVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        f();
        h_();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iP = af.p(this);
        boolean z = iP == 1;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i10 = paddingLeft + paddingRight;
        int i11 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        boolean z2 = this.A != null && af.U(this);
        int size3 = this.m.size();
        int i12 = suggestedMinimumWidth;
        int i13 = suggestedMinimumHeight;
        int iCombineMeasuredStates = 0;
        int i14 = 0;
        while (i14 < size3) {
            View view = this.m.get(i14);
            if (view.getVisibility() == 8) {
                i9 = i14;
                i7 = size3;
            } else {
                f fVar2 = (f) view.getLayoutParams();
                if (fVar2.e < 0 || mode == 0) {
                    i4 = i13;
                } else {
                    int iB = b(fVar2.e);
                    int iA = androidx.core.n.h.a(d(fVar2.c), iP) & 7;
                    i4 = i13;
                    if ((iA == 3 && !z) || (iA == 5 && z)) {
                        iMax = Math.max(0, (size - paddingRight) - iB);
                    } else if ((iA == 5 && !z) || (iA == 3 && z)) {
                        iMax = Math.max(0, iB - paddingLeft);
                    }
                    if (z2 || af.U(view)) {
                        iMakeMeasureSpec = i2;
                        iMakeMeasureSpec2 = i3;
                    } else {
                        int iA2 = this.A.a() + this.A.c();
                        int iB2 = this.A.b() + this.A.d();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iA2, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iB2, mode2);
                    }
                    bVarB = fVar2.b();
                    if (bVarB != null) {
                        fVar = fVar2;
                        i8 = i4;
                        i5 = iCombineMeasuredStates;
                        i6 = i12;
                        i9 = i14;
                        i7 = size3;
                        if (!bVarB.a(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                        }
                        f fVar3 = fVar;
                        int iMax2 = Math.max(i6, i10 + view.getMeasuredWidth() + fVar3.leftMargin + fVar3.rightMargin);
                        int iMax3 = Math.max(i8, i11 + view.getMeasuredHeight() + fVar3.topMargin + fVar3.bottomMargin);
                        i12 = iMax2;
                        iCombineMeasuredStates = View.combineMeasuredStates(i5, view.getMeasuredState());
                        i13 = iMax3;
                    } else {
                        fVar = fVar2;
                        i5 = iCombineMeasuredStates;
                        i6 = i12;
                        i7 = size3;
                        i8 = i4;
                        i9 = i14;
                    }
                    a(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                    f fVar4 = fVar;
                    int iMax4 = Math.max(i6, i10 + view.getMeasuredWidth() + fVar4.leftMargin + fVar4.rightMargin);
                    int iMax5 = Math.max(i8, i11 + view.getMeasuredHeight() + fVar4.topMargin + fVar4.bottomMargin);
                    i12 = iMax4;
                    iCombineMeasuredStates = View.combineMeasuredStates(i5, view.getMeasuredState());
                    i13 = iMax5;
                }
                iMax = 0;
                if (z2) {
                    iMakeMeasureSpec = i2;
                    iMakeMeasureSpec2 = i3;
                } else {
                    iMakeMeasureSpec = i2;
                    iMakeMeasureSpec2 = i3;
                }
                bVarB = fVar2.b();
                if (bVarB != null) {
                    fVar = fVar2;
                    i8 = i4;
                    i5 = iCombineMeasuredStates;
                    i6 = i12;
                    i9 = i14;
                    i7 = size3;
                    if (!bVarB.a(this, view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0)) {
                    }
                    f fVar5 = fVar;
                    int iMax6 = Math.max(i6, i10 + view.getMeasuredWidth() + fVar5.leftMargin + fVar5.rightMargin);
                    int iMax7 = Math.max(i8, i11 + view.getMeasuredHeight() + fVar5.topMargin + fVar5.bottomMargin);
                    i12 = iMax6;
                    iCombineMeasuredStates = View.combineMeasuredStates(i5, view.getMeasuredState());
                    i13 = iMax7;
                } else {
                    fVar = fVar2;
                    i5 = iCombineMeasuredStates;
                    i6 = i12;
                    i7 = size3;
                    i8 = i4;
                    i9 = i14;
                }
                a(view, iMakeMeasureSpec, iMax, iMakeMeasureSpec2, 0);
                f fVar6 = fVar;
                int iMax8 = Math.max(i6, i10 + view.getMeasuredWidth() + fVar6.leftMargin + fVar6.rightMargin);
                int iMax9 = Math.max(i8, i11 + view.getMeasuredHeight() + fVar6.topMargin + fVar6.bottomMargin);
                i12 = iMax8;
                iCombineMeasuredStates = View.combineMeasuredStates(i5, view.getMeasuredState());
                i13 = iMax9;
            }
            i14 = i9 + 1;
            size3 = i7;
        }
        int i15 = iCombineMeasuredStates;
        setMeasuredDimension(View.resolveSizeAndState(i12, i2, (-16777216) & i15), View.resolveSizeAndState(i13, i3, i15 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        b bVarB;
        int childCount = getChildCount();
        boolean zA = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.c(0) && (bVarB = fVar.b()) != null) {
                    zA |= bVarB.a(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (zA) {
            a(1);
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onNestedPreFling(View view, float f2, float f3) {
        b bVarB;
        int childCount = getChildCount();
        boolean zA = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.c(0) && (bVarB = fVar.b()) != null) {
                    zA |= bVarB.a(this, childAt, view, f2, f3);
                }
            }
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        SparseArray<Parcelable> sparseArray = hVar.f327a;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b bVarB = a(childAt).b();
            if (id != -1 && bVarB != null && (parcelable2 = sparseArray.get(id)) != null) {
                bVarB.a(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableD;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            b bVarB = ((f) childAt.getLayoutParams()).b();
            if (id != -1 && bVarB != null && (parcelableD = bVarB.d(this, childAt)) != null) {
                sparseArray.append(id, parcelableD);
            }
        }
        hVar.f327a = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.n.u
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0024, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zA;
        boolean zB;
        MotionEvent motionEventObtain;
        int actionMasked = motionEvent.getActionMasked();
        if (this.w == null) {
            zA = a(motionEvent, 1);
            if (!zA) {
                zB = false;
            }
            motionEventObtain = null;
            if (this.w == null) {
                zB |= super.onTouchEvent(motionEvent);
            } else if (zA) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEventObtain);
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
            if (actionMasked != 1 || actionMasked == 3) {
                a(false);
            }
            return zB;
        }
        zA = false;
        b bVarB = ((f) this.w.getLayoutParams()).b();
        if (bVarB != null) {
            zB = bVarB.b(this, this.w, motionEvent);
        } else {
            zB = false;
        }
        motionEventObtain = null;
        if (this.w == null) {
            zB |= super.onTouchEvent(motionEvent);
        } else if (zA) {
            long jUptimeMillis2 = SystemClock.uptimeMillis();
            motionEventObtain = MotionEvent.obtain(jUptimeMillis2, jUptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEventObtain);
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        if (actionMasked != 1) {
            a(false);
        } else {
            a(false);
        }
        return zB;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        b bVarB = ((f) view.getLayoutParams()).b();
        if (bVarB == null || !bVarB.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.t) {
            return;
        }
        a(false);
        this.t = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        g();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.i = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@ai Drawable drawable) {
        if (this.C != drawable) {
            if (this.C != null) {
                this.C.setCallback(null);
            }
            this.C = drawable != null ? drawable.mutate() : null;
            if (this.C != null) {
                if (this.C.isStateful()) {
                    this.C.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.C, af.p(this));
                this.C.setVisible(getVisibility() == 0, false);
                this.C.setCallback(this);
            }
            af.h(this);
        }
    }

    public void setStatusBarBackgroundColor(@k int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(@q int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.b.c.a(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        if (this.C == null || this.C.isVisible() == z) {
            return;
        }
        this.C.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.C;
    }
}
