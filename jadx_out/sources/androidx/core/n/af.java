package androidx.core.n;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.ap;
import androidx.annotation.aw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class af {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 4;
    public static final int D = 8;
    public static final int E = 16;
    public static final int F = 32;
    private static final String G = "ViewCompat";
    private static Field I = null;
    private static boolean J = false;
    private static Field K = null;
    private static boolean L = false;
    private static Method M = null;
    private static Method N = null;
    private static boolean O = false;
    private static WeakHashMap<View, String> P = null;
    private static Method R = null;
    private static Field S = null;
    private static ThreadLocal<Rect> U = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f526a = 0;

    @Deprecated
    public static final int b = 1;

    @Deprecated
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;

    @Deprecated
    public static final int k = 0;

    @Deprecated
    public static final int l = 1;

    @Deprecated
    public static final int m = 2;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;

    @Deprecated
    public static final int r = 16777215;

    @Deprecated
    public static final int s = -16777216;

    @Deprecated
    public static final int t = 16;

    @Deprecated
    public static final int u = 16777216;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 0;
    public static final int z = 1;
    private static final AtomicInteger H = new AtomicInteger(1);
    private static WeakHashMap<View, aj> Q = null;
    private static boolean T = false;
    private static final int[] V = {androidx.core.a.e.accessibility_custom_action_0, androidx.core.a.e.accessibility_custom_action_1, androidx.core.a.e.accessibility_custom_action_2, androidx.core.a.e.accessibility_custom_action_3, androidx.core.a.e.accessibility_custom_action_4, androidx.core.a.e.accessibility_custom_action_5, androidx.core.a.e.accessibility_custom_action_6, androidx.core.a.e.accessibility_custom_action_7, androidx.core.a.e.accessibility_custom_action_8, androidx.core.a.e.accessibility_custom_action_9, androidx.core.a.e.accessibility_custom_action_10, androidx.core.a.e.accessibility_custom_action_11, androidx.core.a.e.accessibility_custom_action_12, androidx.core.a.e.accessibility_custom_action_13, androidx.core.a.e.accessibility_custom_action_14, androidx.core.a.e.accessibility_custom_action_15, androidx.core.a.e.accessibility_custom_action_16, androidx.core.a.e.accessibility_custom_action_17, androidx.core.a.e.accessibility_custom_action_18, androidx.core.a.e.accessibility_custom_action_19, androidx.core.a.e.accessibility_custom_action_20, androidx.core.a.e.accessibility_custom_action_21, androidx.core.a.e.accessibility_custom_action_22, androidx.core.a.e.accessibility_custom_action_23, androidx.core.a.e.accessibility_custom_action_24, androidx.core.a.e.accessibility_custom_action_25, androidx.core.a.e.accessibility_custom_action_26, androidx.core.a.e.accessibility_custom_action_27, androidx.core.a.e.accessibility_custom_action_28, androidx.core.a.e.accessibility_custom_action_29, androidx.core.a.e.accessibility_custom_action_30, androidx.core.a.e.accessibility_custom_action_31};
    private static a W = new a();

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f529a = new WeakHashMap<>();

        a() {
        }

        @androidx.annotation.am(a = 19)
        private void a(View view, boolean z) {
            boolean z2 = view.getVisibility() == 0;
            if (z != z2) {
                if (z2) {
                    af.r(view, 16);
                }
                this.f529a.put(view, Boolean.valueOf(z2));
            }
        }

        @androidx.annotation.am(a = 19)
        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @androidx.annotation.am(a = 19)
        private void d(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @androidx.annotation.am(a = 19)
        void a(View view) {
            this.f529a.put(view, Boolean.valueOf(view.getVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        @androidx.annotation.am(a = 19)
        void b(View view) {
            this.f529a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            d(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @androidx.annotation.am(a = 19)
        public void onGlobalLayout() {
            for (Map.Entry<View, Boolean> entry : this.f529a.entrySet()) {
                a(entry.getKey(), entry.getValue().booleanValue());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        @androidx.annotation.am(a = 19)
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f530a;
        private final Class<T> b;
        private final int c;

        b(int i, Class<T> cls, int i2) {
            this(i, cls, 0, i2);
        }

        b(int i, Class<T> cls, int i2, int i3) {
            this.f530a = i;
            this.b = cls;
            this.c = i3;
        }

        private boolean a() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        abstract void a(View view, T t);

        boolean a(T t, T t2) {
            return !t2.equals(t);
        }

        abstract T b(View view);

        void b(View view, T t) {
            if (a()) {
                a(view, (Object) t);
            } else if (b() && a(c(view), t)) {
                af.f(view);
                view.setTag(this.f530a, t);
                af.r(view, 0);
            }
        }

        boolean b(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        T c(View view) {
            if (a()) {
                return b(view);
            }
            if (!b()) {
                return null;
            }
            T t = (T) view.getTag(this.f530a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }
    }

    @androidx.annotation.am(a = 21)
    private static class c {
        private c() {
        }

        static ao a(@androidx.annotation.ah View view, @androidx.annotation.ah ao aoVar, @androidx.annotation.ah Rect rect) {
            WindowInsets windowInsetsW = aoVar.w();
            if (windowInsetsW != null) {
                return ao.a(view.computeSystemWindowInsets(windowInsetsW, rect));
            }
            rect.setEmpty();
            return aoVar;
        }
    }

    @androidx.annotation.am(a = 23)
    private static class d {
        private d() {
        }

        public static WindowInsets a(View view) {
            return view.getRootWindowInsets();
        }
    }

    @androidx.annotation.am(a = 29)
    private static class e {
        private e() {
        }

        static void a(@androidx.annotation.ah View view, @androidx.annotation.ah Context context, @androidx.annotation.ah int[] iArr, @androidx.annotation.ai AttributeSet attributeSet, @androidx.annotation.ah TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface f {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface g {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface h {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface i {
    }

    public interface j {
        boolean a(View view, KeyEvent keyEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface k {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface l {
    }

    static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f531a = new ArrayList<>();

        @androidx.annotation.ai
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        m() {
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray<>();
            }
            return this.c;
        }

        static m a(View view) {
            m mVar = (m) view.getTag(androidx.core.a.e.tag_unhandled_key_event_manager);
            if (mVar != null) {
                return mVar;
            }
            m mVar2 = new m();
            view.setTag(androidx.core.a.e.tag_unhandled_key_event_manager, mVar2);
            return mVar2;
        }

        @androidx.annotation.ai
        private View b(View view, KeyEvent keyEvent) {
            if (this.b == null || !this.b.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewB = b(viewGroup.getChildAt(childCount), keyEvent);
                    if (viewB != null) {
                        return viewB;
                    }
                }
            }
            if (c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        private void b() {
            if (this.b != null) {
                this.b.clear();
            }
            if (f531a.isEmpty()) {
                return;
            }
            synchronized (f531a) {
                if (this.b == null) {
                    this.b = new WeakHashMap<>();
                }
                for (int size = f531a.size() - 1; size >= 0; size--) {
                    View view = f531a.get(size).get();
                    if (view == null) {
                        f531a.remove(size);
                    } else {
                        this.b.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.b.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        static void b(View view) {
            synchronized (f531a) {
                Iterator<WeakReference<View>> it = f531a.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                f531a.add(new WeakReference<>(view));
            }
        }

        static void c(View view) {
            synchronized (f531a) {
                for (int i = 0; i < f531a.size(); i++) {
                    if (f531a.get(i).get() == view) {
                        f531a.remove(i);
                        return;
                    }
                }
            }
        }

        private boolean c(@androidx.annotation.ah View view, @androidx.annotation.ah KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(androidx.core.a.e.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((j) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        boolean a(KeyEvent keyEvent) {
            int iIndexOfKey;
            if (this.d != null && this.d.get() == keyEvent) {
                return false;
            }
            this.d = new WeakReference<>(keyEvent);
            WeakReference<View> weakReferenceValueAt = null;
            SparseArray<WeakReference<View>> sparseArrayA = a();
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArrayA.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReferenceValueAt = sparseArrayA.valueAt(iIndexOfKey);
                sparseArrayA.removeAt(iIndexOfKey);
            }
            if (weakReferenceValueAt == null) {
                weakReferenceValueAt = sparseArrayA.get(keyEvent.getKeyCode());
            }
            if (weakReferenceValueAt == null) {
                return false;
            }
            View view = weakReferenceValueAt.get();
            if (view != null && af.ak(view)) {
                c(view, keyEvent);
            }
            return true;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            View viewB = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewB != null && !KeyEvent.isModifierKey(keyCode)) {
                    a().put(keyCode, new WeakReference<>(viewB));
                }
            }
            return viewB != null;
        }
    }

    protected af() {
    }

    @Deprecated
    public static float A(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float B(View view) {
        return view.getTranslationY();
    }

    @androidx.annotation.ai
    @Deprecated
    public static Matrix C(View view) {
        return view.getMatrix();
    }

    public static int D(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!J) {
            try {
                I = View.class.getDeclaredField("mMinWidth");
                I.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            J = true;
        }
        if (I == null) {
            return 0;
        }
        try {
            return ((Integer) I.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int E(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!L) {
            try {
                K = View.class.getDeclaredField("mMinHeight");
                K.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            L = true;
        }
        if (K == null) {
            return 0;
        }
        try {
            return ((Integer) K.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    @androidx.annotation.ah
    public static aj F(@androidx.annotation.ah View view) {
        if (Q == null) {
            Q = new WeakHashMap<>();
        }
        aj ajVar = Q.get(view);
        if (ajVar != null) {
            return ajVar;
        }
        aj ajVar2 = new aj(view);
        Q.put(view, ajVar2);
        return ajVar2;
    }

    @Deprecated
    public static float G(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float H(View view) {
        return view.getPivotY();
    }

    @Deprecated
    public static float I(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float J(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float K(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float L(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float M(View view) {
        return view.getScaleY();
    }

    @Deprecated
    public static float N(View view) {
        return view.getX();
    }

    @Deprecated
    public static float O(View view) {
        return view.getY();
    }

    public static float P(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static float Q(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    @androidx.annotation.ai
    public static String R(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (P == null) {
            return null;
        }
        return P.get(view);
    }

    public static int S(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void T(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean U(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void V(View view) {
        view.jumpDrawablesToCurrentState();
    }

    @androidx.annotation.ah
    public static List<Rect> W(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getSystemGestureExclusionRects() : Collections.emptyList();
    }

    @androidx.annotation.ai
    public static ao X(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ao.a(d.a(view));
        }
        return null;
    }

    public static boolean Y(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean Z(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = H.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!H.compareAndSet(i2, i3));
        return i2;
    }

    @Deprecated
    public static int a(int i2, int i3) {
        return View.combineMeasuredStates(i2, i3);
    }

    @Deprecated
    public static int a(int i2, int i3, int i4) {
        return View.resolveSizeAndState(i2, i3, i4);
    }

    @Deprecated
    public static int a(View view) {
        return view.getOverScrollMode();
    }

    public static int a(@androidx.annotation.ah View view, @androidx.annotation.ah CharSequence charSequence, @androidx.annotation.ah androidx.core.n.a.g gVar) {
        int iAz = az(view);
        if (iAz != -1) {
            a(view, new androidx.core.n.a.d.a(iAz, charSequence, gVar));
        }
        return iAz;
    }

    public static View a(@androidx.annotation.ah View view, View view2, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }
        return null;
    }

    @androidx.annotation.ah
    public static ao a(@androidx.annotation.ah View view, @androidx.annotation.ah ao aoVar) {
        WindowInsets windowInsetsW;
        if (Build.VERSION.SDK_INT >= 21 && (windowInsetsW = aoVar.w()) != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsetsW);
            if (!windowInsetsOnApplyWindowInsets.equals(windowInsetsW)) {
                return ao.a(windowInsetsOnApplyWindowInsets);
            }
        }
        return aoVar;
    }

    @androidx.annotation.ah
    public static ao a(@androidx.annotation.ah View view, @androidx.annotation.ah ao aoVar, @androidx.annotation.ah Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, aoVar, rect) : aoVar;
    }

    private static void a(int i2, View view) {
        List<androidx.core.n.a.d.a> listAA = aA(view);
        for (int i3 = 0; i3 < listAA.size(); i3++) {
            if (listAA.get(i3).a() == i2) {
                listAA.remove(i3);
                return;
            }
        }
    }

    @Deprecated
    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    public static void a(@androidx.annotation.ah View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@androidx.annotation.ah View view, int i2, int i3, int i4, int i5, @androidx.annotation.ai int[] iArr, int i6, @androidx.annotation.ah int[] iArr2) {
        if (view instanceof s) {
            ((s) view).a(i2, i3, i4, i5, iArr, i6, iArr2);
        } else {
            a(view, i2, i3, i4, i5, iArr, i6);
        }
    }

    @Deprecated
    public static void a(View view, int i2, Paint paint) {
        view.setLayerType(i2, paint);
    }

    public static void a(@androidx.annotation.ah View view, @SuppressLint({"ContextFirst"}) @androidx.annotation.ah Context context, @androidx.annotation.ah int[] iArr, @androidx.annotation.ai AttributeSet attributeSet, @androidx.annotation.ah TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@androidx.annotation.ah View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof ad) {
                ((ad) view).setSupportBackgroundTintList(colorStateList);
                return;
            }
            return;
        }
        view.setBackgroundTintList(colorStateList);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void a(@androidx.annotation.ah View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
        } else {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(@androidx.annotation.ah View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT < 21) {
            if (view instanceof ad) {
                ((ad) view).setSupportBackgroundTintMode(mode);
                return;
            }
            return;
        }
        view.setBackgroundTintMode(mode);
        if (Build.VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            boolean z2 = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
            if (background == null || !z2) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void a(@androidx.annotation.ah View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ai Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(@androidx.annotation.ah View view, View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @Deprecated
    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static void a(@androidx.annotation.ah View view, @androidx.annotation.ah androidx.core.n.a.d.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            f(view);
            a(aVar.a(), view);
            aA(view).add(aVar);
            r(view, 0);
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ah androidx.core.n.a.d.a aVar, @androidx.annotation.ai CharSequence charSequence, @androidx.annotation.ai androidx.core.n.a.g gVar) {
        if (gVar == null && charSequence == null) {
            f(view, aVar.a());
        } else {
            a(view, aVar.a(charSequence, gVar));
        }
    }

    public static void a(@androidx.annotation.ah View view, androidx.core.n.a.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.a());
    }

    public static void a(@androidx.annotation.ah View view, androidx.core.n.a aVar) {
        if (aVar == null && (ax(view) instanceof androidx.core.n.a.C0039a)) {
            aVar = new androidx.core.n.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    public static void a(@androidx.annotation.ah View view, aa aaVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (aaVar != null ? aaVar.a() : null));
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ah final j jVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            androidx.c.i iVar = (androidx.c.i) view.getTag(androidx.core.a.e.tag_unhandled_key_listeners);
            if (iVar == null) {
                iVar = new androidx.c.i();
                view.setTag(androidx.core.a.e.tag_unhandled_key_listeners, iVar);
            }
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.n.af.2
                @Override // android.view.View.OnUnhandledKeyEventListener
                public boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return jVar.a(view2, keyEvent);
                }
            };
            iVar.put(jVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(androidx.core.a.e.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(androidx.core.a.e.tag_unhandled_key_listeners, arrayList);
        }
        arrayList.add(jVar);
        if (arrayList.size() == 1) {
            m.b(view);
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ai final y yVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (yVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.core.n.af.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return yVar.a(view2, ao.a(windowInsets)).w();
                    }
                });
            }
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ai CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(@androidx.annotation.ah View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(@androidx.annotation.ah View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static void a(@androidx.annotation.ah View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (P == null) {
            P = new WeakHashMap<>();
        }
        P.put(view, str);
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ah Collection<View> collection, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.addKeyboardNavigationClusters(collection, i2);
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ah List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    public static void a(@androidx.annotation.ah View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z2);
        }
    }

    public static void a(@androidx.annotation.ah View view, @androidx.annotation.ai String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setAutofillHints(strArr);
        }
    }

    @Deprecated
    public static void a(ViewGroup viewGroup, boolean z2) {
        if (R == null) {
            try {
                R = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e2) {
                Log.e(G, "Unable to find childrenDrawingOrderEnabled", e2);
            }
            R.setAccessible(true);
        }
        try {
            R.invoke(viewGroup, Boolean.valueOf(z2));
        } catch (IllegalAccessException e3) {
            Log.e(G, "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (IllegalArgumentException e4) {
            Log.e(G, "Unable to invoke childrenDrawingOrderEnabled", e4);
        } catch (InvocationTargetException e5) {
            Log.e(G, "Unable to invoke childrenDrawingOrderEnabled", e5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreFling(f2, f3);
        }
        if (view instanceof q) {
            return ((q) view).dispatchNestedPreFling(f2, f3);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, float f2, float f3, boolean z2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedFling(f2, f3, z2);
        }
        if (view instanceof q) {
            return ((q) view).dispatchNestedFling(f2, f3, z2);
        }
        return false;
    }

    @Deprecated
    public static boolean a(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, int i2, int i3) {
        if (view instanceof r) {
            return ((r) view).a(i2, i3);
        }
        if (i3 == 0) {
            return k(view, i2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, int i2, int i3, int i4, int i5, @androidx.annotation.ai int[] iArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        if (view instanceof q) {
            return ((q) view).dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, int i2, int i3, int i4, int i5, @androidx.annotation.ai int[] iArr, int i6) {
        if (view instanceof r) {
            return ((r) view).a(i2, i3, i4, i5, iArr, i6);
        }
        if (i6 == 0) {
            return a(view, i2, i3, i4, i5, iArr);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, int i2, int i3, @androidx.annotation.ai int[] iArr, @androidx.annotation.ai int[] iArr2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        if (view instanceof q) {
            return ((q) view).dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(@androidx.annotation.ah View view, int i2, int i3, @androidx.annotation.ai int[] iArr, @androidx.annotation.ai int[] iArr2, int i4) {
        if (view instanceof r) {
            return ((r) view).a(i2, i3, iArr, iArr2, i4);
        }
        if (i4 == 0) {
            return a(view, i2, i3, iArr, iArr2);
        }
        return false;
    }

    public static boolean a(@androidx.annotation.ah View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static boolean a(@androidx.annotation.ah View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? view.startDragAndDrop(clipData, dragShadowBuilder, obj, i2) : view.startDrag(clipData, dragShadowBuilder, obj, i2);
    }

    @aw
    static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return m.a(view).a(keyEvent);
    }

    private static List<androidx.core.n.a.d.a> aA(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(androidx.core.a.e.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(androidx.core.a.e.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    private static void aB(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList aa(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof ad) {
            return ((ad) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode ab(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof ad) {
            return ((ad) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean ac(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof q) {
            return ((q) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ad(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof q) {
            ((q) view).stopNestedScroll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean ae(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.hasNestedScrollingParent();
        }
        if (view instanceof q) {
            return ((q) view).hasNestedScrollingParent();
        }
        return false;
    }

    public static boolean af(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean ag(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static boolean ah(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLayoutDirectionResolved();
        }
        return false;
    }

    public static float ai(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    @androidx.annotation.ai
    public static Rect aj(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean ak(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean al(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static int am(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getScrollIndicators();
        }
        return 0;
    }

    @androidx.annotation.ai
    public static Display an(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (ak(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static void ao(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.cancelDragAndDrop();
        }
    }

    public static int ap(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getNextClusterForwardId();
        }
        return -1;
    }

    public static boolean aq(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isKeyboardNavigationCluster();
        }
        return false;
    }

    public static boolean ar(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isFocusedByDefault();
        }
        return false;
    }

    public static boolean as(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 26 ? view.restoreDefaultFocus() : view.requestFocus();
    }

    public static boolean at(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 26 ? view.hasExplicitFocusable() : view.hasFocusable();
    }

    @aw
    public static boolean au(View view) {
        Boolean boolC = d().c(view);
        if (boolC == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    @aw
    public static CharSequence av(View view) {
        return e().c(view);
    }

    @aw
    public static boolean aw(View view) {
        Boolean boolC = f().c(view);
        if (boolC == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    @androidx.annotation.ai
    private static View.AccessibilityDelegate ax(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 29 ? view.getAccessibilityDelegate() : ay(view);
    }

    @androidx.annotation.ai
    private static View.AccessibilityDelegate ay(@androidx.annotation.ah View view) {
        if (T) {
            return null;
        }
        if (S == null) {
            try {
                S = View.class.getDeclaredField("mAccessibilityDelegate");
                S.setAccessible(true);
            } catch (Throwable unused) {
                T = true;
                return null;
            }
        }
        try {
            Object obj = S.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            T = true;
            return null;
        }
    }

    private static int az(View view) {
        List<androidx.core.n.a.d.a> listAA = aA(view);
        int i2 = -1;
        for (int i3 = 0; i3 < V.length && i2 == -1; i3++) {
            int i4 = V[i3];
            boolean z2 = true;
            for (int i5 = 0; i5 < listAA.size(); i5++) {
                z2 &= listAA.get(i5).a() != i4;
            }
            if (z2) {
                i2 = i4;
            }
        }
        return i2;
    }

    @SuppressLint({"InlinedApi"})
    public static int b(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    private static Rect b() {
        if (U == null) {
            U = new ThreadLocal<>();
        }
        Rect rect = U.get();
        if (rect == null) {
            rect = new Rect();
            U.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    @androidx.annotation.ah
    public static ao b(@androidx.annotation.ah View view, @androidx.annotation.ah ao aoVar) {
        WindowInsets windowInsetsW;
        return (Build.VERSION.SDK_INT < 21 || (windowInsetsW = aoVar.w()) == null || view.dispatchApplyWindowInsets(windowInsetsW).equals(windowInsetsW)) ? aoVar : ao.a(windowInsetsW);
    }

    @Deprecated
    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    public static void b(@androidx.annotation.ah View view, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, i3);
        }
    }

    public static void b(@androidx.annotation.ah View view, @androidx.annotation.ak int i2, @androidx.annotation.ak int i3, @androidx.annotation.ak int i4, @androidx.annotation.ak int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @Deprecated
    public static void b(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void b(@androidx.annotation.ah View view, @androidx.annotation.ah j jVar) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        if (Build.VERSION.SDK_INT >= 28) {
            androidx.c.i iVar = (androidx.c.i) view.getTag(androidx.core.a.e.tag_unhandled_key_listeners);
            if (iVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) iVar.get(jVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(androidx.core.a.e.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(jVar);
            if (arrayList.size() == 0) {
                m.c(view);
            }
        }
    }

    @aw
    public static void b(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            e().b(view, charSequence);
            if (charSequence != null) {
                W.a(view);
            } else {
                W.b(view);
            }
        }
    }

    @Deprecated
    public static void b(View view, boolean z2) {
        view.setFitsSystemWindows(z2);
    }

    @Deprecated
    public static boolean b(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    @aw
    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return m.a(view).a(view, keyEvent);
    }

    private static void c() {
        try {
            M = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            N = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e2) {
            Log.e(G, "Couldn't find method", e2);
        }
        O = true;
    }

    @Deprecated
    public static void c(View view, @androidx.annotation.r(a = 0.0d, b = 1.0d) float f2) {
        view.setAlpha(f2);
    }

    @Deprecated
    public static void c(View view, int i2) {
        view.setOverScrollMode(i2);
    }

    @Deprecated
    public static void c(View view, boolean z2) {
        view.setSaveFromParentEnabled(z2);
    }

    public static boolean c(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.isImportantForAutofill();
        }
        return true;
    }

    private static b<Boolean> d() {
        return new b<Boolean>(androidx.core.a.e.tag_screen_reader_focusable, Boolean.class, 28) { // from class: androidx.core.n.af.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            public void a(View view, Boolean bool) {
                view.setScreenReaderFocusable(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            public boolean a(Boolean bool, Boolean bool2) {
                return !b(bool, bool2);
            }
        };
    }

    @Deprecated
    public static void d(View view, float f2) {
        view.setX(f2);
    }

    public static void d(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i2);
        }
    }

    @Deprecated
    public static void d(View view, boolean z2) {
        view.setActivated(z2);
    }

    public static boolean d(@androidx.annotation.ah View view) {
        return ax(view) != null;
    }

    @androidx.annotation.ai
    public static androidx.core.n.a e(@androidx.annotation.ah View view) {
        View.AccessibilityDelegate accessibilityDelegateAx = ax(view);
        if (accessibilityDelegateAx == null) {
            return null;
        }
        return accessibilityDelegateAx instanceof androidx.core.n.a.C0039a ? ((androidx.core.n.a.C0039a) accessibilityDelegateAx).f509a : new androidx.core.n.a(accessibilityDelegateAx);
    }

    private static b<CharSequence> e() {
        return new b<CharSequence>(androidx.core.a.e.tag_accessibility_pane_title, CharSequence.class, 8, 28) { // from class: androidx.core.n.af.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CharSequence b(View view) {
                return view.getAccessibilityPaneTitle();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            public void a(View view, CharSequence charSequence) {
                view.setAccessibilityPaneTitle(charSequence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            public boolean a(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    @Deprecated
    public static void e(View view, float f2) {
        view.setY(f2);
    }

    public static void e(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            if (i2 == 4) {
                i2 = 2;
            }
            view.setImportantForAccessibility(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(@androidx.annotation.ah View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z2);
        } else if (view instanceof q) {
            ((q) view).setNestedScrollingEnabled(z2);
        }
    }

    static androidx.core.n.a f(@androidx.annotation.ah View view) {
        androidx.core.n.a aVarE = e(view);
        if (aVarE == null) {
            aVarE = new androidx.core.n.a();
        }
        a(view, aVarE);
        return aVarE;
    }

    private static b<Boolean> f() {
        return new b<Boolean>(androidx.core.a.e.tag_accessibility_heading, Boolean.class, 28) { // from class: androidx.core.n.af.5
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            @androidx.annotation.am(a = 28)
            public void a(View view, Boolean bool) {
                view.setAccessibilityHeading(bool.booleanValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.core.n.af.b
            public boolean a(Boolean bool, Boolean bool2) {
                return !b(bool, bool2);
            }
        };
    }

    @Deprecated
    public static void f(View view, float f2) {
        view.setRotation(f2);
    }

    public static void f(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            r(view, 0);
        }
    }

    public static void f(@androidx.annotation.ah View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setKeyboardNavigationCluster(z2);
        }
    }

    @Deprecated
    public static void g(View view, float f2) {
        view.setRotationX(f2);
    }

    public static void g(@androidx.annotation.ah View view, @androidx.annotation.w int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLabelFor(i2);
        }
    }

    public static void g(@androidx.annotation.ah View view, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setFocusedByDefault(z2);
        }
    }

    public static boolean g(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void h(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    @Deprecated
    public static void h(View view, float f2) {
        view.setRotationY(f2);
    }

    public static void h(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayoutDirection(i2);
        }
    }

    @aw
    public static void h(View view, boolean z2) {
        d().b(view, Boolean.valueOf(z2));
    }

    public static int i(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    @androidx.annotation.ah
    public static <T extends View> T i(@androidx.annotation.ah View view, @androidx.annotation.w int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) view.requireViewById(i2);
        }
        T t2 = (T) view.findViewById(i2);
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static void i(View view, float f2) {
        view.setScaleX(f2);
    }

    @aw
    public static void i(View view, boolean z2) {
        f().b(view, Boolean.valueOf(z2));
    }

    @Deprecated
    public static void j(View view, float f2) {
        view.setScaleY(f2);
    }

    public static void j(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i2);
        }
    }

    public static boolean j(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isImportantForAccessibility();
        }
        return true;
    }

    public static void k(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            f(view);
        }
    }

    @Deprecated
    public static void k(View view, float f2) {
        view.setPivotX(f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean k(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.startNestedScroll(i2);
        }
        if (view instanceof q) {
            return ((q) view).startNestedScroll(i2);
        }
        return false;
    }

    public static androidx.core.n.a.e l(@androidx.annotation.ah View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) == null) {
            return null;
        }
        return new androidx.core.n.a.e(accessibilityNodeProvider);
    }

    @Deprecated
    public static void l(View view, float f2) {
        view.setPivotY(f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(@androidx.annotation.ah View view, int i2) {
        if (view instanceof r) {
            ((r) view).a(i2);
        } else if (i2 == 0) {
            ad(view);
        }
    }

    @Deprecated
    public static float m(View view) {
        return view.getAlpha();
    }

    public static void m(@androidx.annotation.ah View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean m(@androidx.annotation.ah View view, int i2) {
        if (view instanceof r) {
            ((r) view).b(i2);
            return false;
        }
        if (i2 == 0) {
            return ae(view);
        }
        return false;
    }

    @Deprecated
    public static int n(View view) {
        return view.getLayerType();
    }

    public static void n(@androidx.annotation.ah View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static void n(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            s(view, i2);
            return;
        }
        Rect rectB = b();
        boolean z2 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        s(view, i2);
        if (z2 && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectB);
        }
    }

    public static int o(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLabelFor();
        }
        return 0;
    }

    public static void o(@androidx.annotation.ah View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static void o(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            t(view, i2);
            return;
        }
        Rect rectB = b();
        boolean z2 = false;
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectB.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z2 = !rectB.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        t(view, i2);
        if (z2 && rectB.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectB);
        }
    }

    public static int p(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static void p(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2);
        }
    }

    public static ViewParent q(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 16 ? view.getParentForAccessibility() : view.getParent();
    }

    public static void q(@androidx.annotation.ah View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setNextClusterForwardId(i2);
        }
    }

    @androidx.annotation.am(a = 19)
    static void r(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z2 = av(view) != null;
            if (v(view) != 0 || (z2 && view.getVisibility() == 0)) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z2 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e(G, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    @Deprecated
    public static boolean r(View view) {
        return view.isOpaque();
    }

    @Deprecated
    public static int s(View view) {
        return view.getMeasuredWidthAndState();
    }

    private static void s(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            aB(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                aB((View) parent);
            }
        }
    }

    @Deprecated
    public static int t(View view) {
        return view.getMeasuredHeightAndState();
    }

    private static void t(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            aB(view);
            Object parent = view.getParent();
            if (parent instanceof View) {
                aB((View) parent);
            }
        }
    }

    @Deprecated
    public static int u(View view) {
        return view.getMeasuredState();
    }

    public static int v(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    @androidx.annotation.ak
    public static int w(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    @androidx.annotation.ak
    public static int x(@androidx.annotation.ah View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static void y(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchStartTemporaryDetach();
            return;
        }
        if (!O) {
            c();
        }
        if (M == null) {
            view.onStartTemporaryDetach();
            return;
        }
        try {
            M.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.d(G, "Error calling dispatchStartTemporaryDetach", e2);
        }
    }

    public static void z(@androidx.annotation.ah View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            view.dispatchFinishTemporaryDetach();
            return;
        }
        if (!O) {
            c();
        }
        if (N == null) {
            view.onFinishTemporaryDetach();
            return;
        }
        try {
            N.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.d(G, "Error calling dispatchFinishTemporaryDetach", e2);
        }
    }
}
