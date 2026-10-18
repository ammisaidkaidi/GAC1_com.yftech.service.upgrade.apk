package androidx.core.n.a;

import android.R;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.z;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String A = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String B = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String C = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final String D = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String E = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String F = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String G = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String H = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final int I = 1;
    public static final int J = 2;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 4;
    public static final int N = 8;
    public static final int O = 16;
    private static final String P = "AccessibilityNodeInfo.roleDescription";
    private static final String Q = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String R = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String S = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    private static final String T = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final String U = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String V = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String W = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String X = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String Y = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final int Z = 1;
    private static final int aa = 2;
    private static final int ab = 4;
    private static final int ac = 8;
    private static int af = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;
    public static final int f = 16;
    public static final int g = 32;
    public static final int h = 64;
    public static final int i = 128;
    public static final int j = 256;
    public static final int k = 512;
    public static final int l = 1024;
    public static final int m = 2048;
    public static final int n = 4096;
    public static final int o = 8192;
    public static final int p = 16384;
    public static final int q = 32768;
    public static final int r = 65536;
    public static final int s = 131072;
    public static final int t = 262144;
    public static final int u = 524288;
    public static final int v = 1048576;
    public static final int w = 2097152;
    public static final String x = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String y = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String z = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    private final AccessibilityNodeInfo ad;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public int f514a = -1;
    private int ae = -1;

    public static class a {
        public static final a A;
        public static final a B;

        @ah
        public static final a C;

        @ah
        public static final a D;

        @ah
        public static final a E;

        @ah
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        private static final String N = "A11yActionCompat";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f515a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, (CharSequence) null, (Class<? extends g.a>) g.b.class);
        public static final a j = new a(512, (CharSequence) null, (Class<? extends g.a>) g.b.class);
        public static final a k = new a(1024, (CharSequence) null, (Class<? extends g.a>) g.c.class);
        public static final a l = new a(2048, (CharSequence) null, (Class<? extends g.a>) g.c.class);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, (CharSequence) null, (Class<? extends g.a>) g.C0042g.class);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, (CharSequence) null, (Class<? extends g.a>) g.h.class);
        public static final a w;
        public static final a x;
        public static final a y;
        public static final a z;
        final Object L;

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        protected final g M;
        private final int O;
        private final Class<? extends g.a> P;

        static {
            w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, R.id.accessibilityActionShowOnScreen, null, null, null);
            x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);
            y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, R.id.accessibilityActionScrollUp, null, null, null);
            z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, R.id.accessibilityActionScrollLeft, null, null, null);
            A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, R.id.accessibilityActionScrollDown, null, null, null);
            B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, R.id.accessibilityActionScrollRight, null, null, null);
            C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, R.id.accessibilityActionContextClick, null, null, null);
            H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, R.id.accessibilityActionSetProgress, null, null, g.f.class);
            I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, g.d.class);
            J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            K = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public a(int i2, CharSequence charSequence, g gVar) {
            this(null, i2, charSequence, gVar, null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.O = i2;
            this.M = gVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.L = obj;
            } else {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.P = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public a a(CharSequence charSequence, g gVar) {
            return new a(null, this.O, charSequence, gVar, this.P);
        }

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public boolean a(View view, Bundle bundle) {
            if (this.M == null) {
                return false;
            }
            g.a aVar = null;
            if (this.P != null) {
                try {
                    g.a aVarNewInstance = this.P.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        aVarNewInstance.a(bundle);
                        aVar = aVarNewInstance;
                    } catch (Exception e2) {
                        e = e2;
                        aVar = aVarNewInstance;
                        Log.e(N, "Failed to execute command with argument class ViewCommandArgument: " + (this.P == null ? "null" : this.P.getName()), e);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            return this.M.a(view, aVar);
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        public boolean equals(@ai Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.L == null) {
                return aVar.L == null;
            }
            return this.L.equals(aVar.L);
        }

        public int hashCode() {
            if (this.L != null) {
                return this.L.hashCode();
            }
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f516a = 0;
        public static final int b = 1;
        public static final int c = 2;
        final Object d;

        b(Object obj) {
            this.d = obj;
        }

        public static b a(int i, int i2, boolean z) {
            return Build.VERSION.SDK_INT >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new b(null);
        }

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            return Build.VERSION.SDK_INT >= 19 ? new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new b(null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.d).getColumnCount();
            }
            return -1;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.d).getRowCount();
            }
            return -1;
        }

        public boolean c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.d).isHierarchical();
            }
            return false;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionInfo) this.d).getSelectionMode();
            }
            return 0;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f517a;

        c(Object obj) {
            this.f517a = obj;
        }

        public static c a(int i, int i2, int i3, int i4, boolean z) {
            return Build.VERSION.SDK_INT >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new c(null);
        }

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            return Build.VERSION.SDK_INT >= 19 ? new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new c(null);
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).getColumnIndex();
            }
            return 0;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).getRowSpan();
            }
            return 0;
        }

        @Deprecated
        public boolean e() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).isHeading();
            }
            return false;
        }

        public boolean f() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f517a).isSelected();
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: androidx.core.n.a.d$d, reason: collision with other inner class name */
    public static class C0041d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f518a = 0;
        public static final int b = 1;
        public static final int c = 2;
        final Object d;

        C0041d(Object obj) {
            this.d = obj;
        }

        public static C0041d a(int i, float f, float f2, float f3) {
            return Build.VERSION.SDK_INT >= 19 ? new C0041d(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3)) : new C0041d(null);
        }

        public float a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.d).getCurrent();
            }
            return 0.0f;
        }

        public float b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.d).getMax();
            }
            return 0.0f;
        }

        public float c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.d).getMin();
            }
            return 0.0f;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.RangeInfo) this.d).getType();
            }
            return 0;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AccessibilityNodeInfo.TouchDelegateInfo f519a;

        e(@ah AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f519a = touchDelegateInfo;
        }

        public e(@ah Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f519a = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.f519a = null;
            }
        }

        @z(a = FabTransformationScrimBehavior.c)
        public int a() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f519a.getRegionCount();
            }
            return 0;
        }

        @ai
        public Region a(@z(a = FabTransformationScrimBehavior.c) int i) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f519a.getRegionAt(i);
            }
            return null;
        }

        @ai
        public d a(@ah Region region) {
            AccessibilityNodeInfo targetForRegion;
            if (Build.VERSION.SDK_INT < 29 || (targetForRegion = this.f519a.getTargetForRegion(region)) == null) {
                return null;
            }
            return d.a(targetForRegion);
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.ad = accessibilityNodeInfo;
    }

    @Deprecated
    public d(Object obj) {
        this.ad = (AccessibilityNodeInfo) obj;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (clickableSpan.equals(sparseArray.valueAt(i2).get())) {
                    return sparseArray.keyAt(i2);
                }
            }
        }
        int i3 = af;
        af = i3 + 1;
        return i3;
    }

    public static d a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static d a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a((Object) AccessibilityNodeInfo.obtain(view, i2));
        }
        return null;
    }

    public static d a(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.ad));
    }

    static d a(Object obj) {
        if (obj != null) {
            return new d(obj);
        }
        return null;
    }

    private void a(int i2, boolean z2) {
        Bundle bundleO = O();
        if (bundleO != null) {
            int i3 = bundleO.getInt(T, 0) & (~i2);
            if (!z2) {
                i2 = 0;
            }
            bundleO.putInt(T, i2 | i3);
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i2) {
        d(V).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        d(W).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        d(X).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        d(U).add(Integer.valueOf(i2));
    }

    private boolean ai() {
        return !d(V).isEmpty();
    }

    private void aj() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.getExtras().remove(V);
            this.ad.getExtras().remove(W);
            this.ad.getExtras().remove(X);
            this.ad.getExtras().remove(U);
        }
    }

    public static d c() {
        return a(AccessibilityNodeInfo.obtain());
    }

    private List<Integer> d(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.ad.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.ad.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> j(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayK = k(view);
        if (sparseArrayK != null) {
            return sparseArrayK;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(androidx.core.a.e.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> k(View view) {
        return (SparseArray) view.getTag(androidx.core.a.e.tag_accessibility_clickable_spans);
    }

    private boolean k(int i2) {
        Bundle bundleO = O();
        return bundleO != null && (bundleO.getInt(T, 0) & i2) == i2;
    }

    private static String l(int i2) {
        switch (i2) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            default:
                switch (i2) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i2) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                switch (i2) {
                                    case 4:
                                        return "ACTION_SELECT";
                                    case 8:
                                        return "ACTION_CLEAR_SELECTION";
                                    case 16:
                                        return "ACTION_CLICK";
                                    case 32:
                                        return "ACTION_LONG_CLICK";
                                    case 64:
                                        return "ACTION_ACCESSIBILITY_FOCUS";
                                    case 128:
                                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                                    case 256:
                                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                                    case 512:
                                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                                    case 1024:
                                        return "ACTION_NEXT_HTML_ELEMENT";
                                    case 2048:
                                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                                    case 4096:
                                        return "ACTION_SCROLL_FORWARD";
                                    case 8192:
                                        return "ACTION_SCROLL_BACKWARD";
                                    case 16384:
                                        return "ACTION_COPY";
                                    case 32768:
                                        return "ACTION_PASTE";
                                    case 65536:
                                        return "ACTION_CUT";
                                    case 131072:
                                        return "ACTION_SET_SELECTION";
                                    case 262144:
                                        return "ACTION_EXPAND";
                                    case 524288:
                                        return "ACTION_COLLAPSE";
                                    case 2097152:
                                        return "ACTION_SET_TEXT";
                                    case R.id.accessibilityActionMoveWindow:
                                        return "ACTION_MOVE_WINDOW";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private void l(View view) {
        SparseArray<WeakReference<ClickableSpan>> sparseArrayK = k(view);
        if (sparseArrayK != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArrayK.size(); i2++) {
                if (sparseArrayK.valueAt(i2).get() == null) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sparseArrayK.remove(((Integer) arrayList.get(i3)).intValue());
            }
        }
    }

    public String A() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.ad.getViewIdResourceName();
        }
        return null;
    }

    public int B() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getLiveRegion();
        }
        return 0;
    }

    public int C() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.ad.getDrawingOrder();
        }
        return 0;
    }

    public b D() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionInfo = this.ad.getCollectionInfo()) == null) {
            return null;
        }
        return new b(collectionInfo);
    }

    public c E() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.ad.getCollectionItemInfo()) == null) {
            return null;
        }
        return new c(collectionItemInfo);
    }

    public C0041d F() {
        AccessibilityNodeInfo.RangeInfo rangeInfo;
        if (Build.VERSION.SDK_INT < 19 || (rangeInfo = this.ad.getRangeInfo()) == null) {
            return null;
        }
        return new C0041d(rangeInfo);
    }

    public List<a> G() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.ad.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new a(actionList.get(i2)));
        }
        return arrayList;
    }

    public boolean H() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.isContentInvalid();
        }
        return false;
    }

    public boolean I() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.ad.isContextClickable();
        }
        return false;
    }

    @ai
    public CharSequence J() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.ad.getHintText();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getExtras().getCharSequence(S);
        }
        return null;
    }

    public CharSequence K() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.ad.getError();
        }
        return null;
    }

    public d L() {
        if (Build.VERSION.SDK_INT >= 17) {
            return a((Object) this.ad.getLabelFor());
        }
        return null;
    }

    public d M() {
        if (Build.VERSION.SDK_INT >= 17) {
            return a((Object) this.ad.getLabeledBy());
        }
        return null;
    }

    public boolean N() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.canOpenPopup();
        }
        return false;
    }

    public Bundle O() {
        return Build.VERSION.SDK_INT >= 19 ? this.ad.getExtras() : new Bundle();
    }

    public int P() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getInputType();
        }
        return 0;
    }

    public int Q() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.ad.getMaxTextLength();
        }
        return -1;
    }

    public int R() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.ad.getTextSelectionStart();
        }
        return -1;
    }

    public int S() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.ad.getTextSelectionEnd();
        }
        return -1;
    }

    public d T() {
        if (Build.VERSION.SDK_INT >= 22) {
            return a((Object) this.ad.getTraversalBefore());
        }
        return null;
    }

    public d U() {
        if (Build.VERSION.SDK_INT >= 22) {
            return a((Object) this.ad.getTraversalAfter());
        }
        return null;
    }

    public h V() {
        if (Build.VERSION.SDK_INT >= 21) {
            return h.a(this.ad.getWindow());
        }
        return null;
    }

    public boolean W() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.isDismissable();
        }
        return false;
    }

    public boolean X() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.ad.isEditable();
        }
        return false;
    }

    public boolean Y() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.isMultiLine();
        }
        return false;
    }

    @ai
    public CharSequence Z() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.ad.getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getExtras().getCharSequence(R);
        }
        return null;
    }

    public AccessibilityNodeInfo a() {
        return this.ad;
    }

    public d a(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a((Object) this.ad.findFocus(i2));
        }
        return null;
    }

    public List<d> a(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByText = this.ad.findAccessibilityNodeInfosByText(str);
        int size = listFindAccessibilityNodeInfosByText.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(a(listFindAccessibilityNodeInfosByText.get(i2)));
        }
        return arrayList;
    }

    public void a(int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ad.setTextSelection(i2, i3);
        }
    }

    @Deprecated
    public void a(Rect rect) {
        this.ad.getBoundsInParent(rect);
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.ad.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public void a(C0041d c0041d) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setRangeInfo((AccessibilityNodeInfo.RangeInfo) c0041d.d);
        }
    }

    public void a(@ah e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.ad.setTouchDelegateInfo(eVar.f519a);
        }
    }

    public void a(CharSequence charSequence) {
        this.ad.setPackageName(charSequence);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        aj();
        l(view);
        ClickableSpan[] clickableSpanArrD = d(charSequence);
        if (clickableSpanArrD == null || clickableSpanArrD.length <= 0) {
            return;
        }
        O().putInt(Y, androidx.core.a.e.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArrayJ = j(view);
        for (int i2 = 0; clickableSpanArrD != null && i2 < clickableSpanArrD.length; i2++) {
            int iA = a(clickableSpanArrD[i2], sparseArrayJ);
            sparseArrayJ.put(iA, new WeakReference<>(clickableSpanArrD[i2]));
            a(clickableSpanArrD[i2], (Spanned) charSequence, iA);
        }
    }

    public void a(boolean z2) {
        this.ad.setCheckable(z2);
    }

    public boolean a(int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.ad.performAction(i2, bundle);
        }
        return false;
    }

    @ai
    public CharSequence aa() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.ad.getPaneTitle();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getExtras().getCharSequence(Q);
        }
        return null;
    }

    public boolean ab() {
        return Build.VERSION.SDK_INT >= 28 ? this.ad.isScreenReaderFocusable() : k(1);
    }

    public boolean ac() {
        return Build.VERSION.SDK_INT >= 26 ? this.ad.isShowingHintText() : k(4);
    }

    public boolean ad() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.ad.isHeading();
        }
        if (k(2)) {
            return true;
        }
        c cVarE = E();
        return cVarE != null && cVarE.e();
    }

    public boolean ae() {
        return Build.VERSION.SDK_INT >= 29 ? this.ad.isTextEntryKey() : k(8);
    }

    public boolean af() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.ad.refresh();
        }
        return false;
    }

    @ai
    public CharSequence ag() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.ad.getExtras().getCharSequence(P);
        }
        return null;
    }

    @ai
    public e ah() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT < 29 || (touchDelegateInfo = this.ad.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new e(touchDelegateInfo);
    }

    public d b(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            return a((Object) this.ad.focusSearch(i2));
        }
        return null;
    }

    @Deprecated
    public Object b() {
        return this.ad;
    }

    @Deprecated
    public void b(Rect rect) {
        this.ad.setBoundsInParent(rect);
    }

    public void b(View view) {
        this.ae = -1;
        this.ad.setSource(view);
    }

    public void b(View view, int i2) {
        this.ae = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.setSource(view, i2);
        }
    }

    public void b(CharSequence charSequence) {
        this.ad.setClassName(charSequence);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).d);
        }
    }

    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ad.setViewIdResourceName(str);
        }
    }

    public void b(boolean z2) {
        this.ad.setChecked(z2);
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.ad.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public d c(int i2) {
        return a((Object) this.ad.getChild(i2));
    }

    public List<d> c(String str) {
        if (Build.VERSION.SDK_INT < 18) {
            return Collections.emptyList();
        }
        List<AccessibilityNodeInfo> listFindAccessibilityNodeInfosByViewId = this.ad.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        Iterator<AccessibilityNodeInfo> it = listFindAccessibilityNodeInfosByViewId.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public void c(Rect rect) {
        this.ad.getBoundsInScreen(rect);
    }

    public void c(View view) {
        this.ad.addChild(view);
    }

    public void c(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.addChild(view, i2);
        }
    }

    public void c(CharSequence charSequence) {
        this.ad.setText(charSequence);
    }

    public void c(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f517a);
        }
    }

    public void c(boolean z2) {
        this.ad.setFocusable(z2);
    }

    public int d() {
        return this.ad.getWindowId();
    }

    public void d(int i2) {
        this.ad.addAction(i2);
    }

    public void d(Rect rect) {
        this.ad.setBoundsInScreen(rect);
    }

    public void d(boolean z2) {
        this.ad.setFocused(z2);
    }

    public boolean d(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.ad.removeChild(view);
        }
        return false;
    }

    public boolean d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.ad.removeChild(view, i2);
        }
        return false;
    }

    public int e() {
        return this.ad.getChildCount();
    }

    public void e(View view) {
        this.f514a = -1;
        this.ad.setParent(view);
    }

    public void e(View view, int i2) {
        this.f514a = i2;
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.setParent(view, i2);
        }
    }

    public void e(CharSequence charSequence) {
        this.ad.setContentDescription(charSequence);
    }

    public void e(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.setVisibleToUser(z2);
        }
    }

    public boolean e(int i2) {
        return this.ad.performAction(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.ad == null) {
            if (dVar.ad != null) {
                return false;
            }
        } else if (!this.ad.equals(dVar.ad)) {
            return false;
        }
        return this.ae == dVar.ae && this.f514a == dVar.f514a;
    }

    public int f() {
        return this.ad.getActions();
    }

    public void f(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.setMovementGranularities(i2);
        }
    }

    public void f(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.ad.setLabelFor(view);
        }
    }

    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.ad.setLabelFor(view, i2);
        }
    }

    public void f(@ai CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.ad.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.ad.getExtras().putCharSequence(S, charSequence);
        }
    }

    public void f(boolean z2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.ad.setAccessibilityFocused(z2);
        }
    }

    public int g() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.ad.getMovementGranularities();
        }
        return 0;
    }

    public void g(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setLiveRegion(i2);
        }
    }

    public void g(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.ad.setLabeledBy(view);
        }
    }

    public void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.ad.setLabeledBy(view, i2);
        }
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.ad.setError(charSequence);
        }
    }

    public void g(boolean z2) {
        this.ad.setSelected(z2);
    }

    public d h() {
        return a((Object) this.ad.getParent());
    }

    public void h(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.ad.setDrawingOrder(i2);
        }
    }

    public void h(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.ad.setTraversalBefore(view);
        }
    }

    public void h(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.ad.setTraversalBefore(view, i2);
        }
    }

    public void h(@ai CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ad.setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.ad.getExtras().putCharSequence(R, charSequence);
        }
    }

    public void h(boolean z2) {
        this.ad.setClickable(z2);
    }

    public int hashCode() {
        if (this.ad == null) {
            return 0;
        }
        return this.ad.hashCode();
    }

    public void i(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setInputType(i2);
        }
    }

    public void i(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.ad.setTraversalAfter(view);
        }
    }

    public void i(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.ad.setTraversalAfter(view, i2);
        }
    }

    public void i(@ai CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ad.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.ad.getExtras().putCharSequence(Q, charSequence);
        }
    }

    public void i(boolean z2) {
        this.ad.setLongClickable(z2);
    }

    public boolean i() {
        return this.ad.isCheckable();
    }

    public void j(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.ad.setMaxTextLength(i2);
        }
    }

    public void j(@ai CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.getExtras().putCharSequence(P, charSequence);
        }
    }

    public void j(boolean z2) {
        this.ad.setEnabled(z2);
    }

    public boolean j() {
        return this.ad.isChecked();
    }

    public void k(boolean z2) {
        this.ad.setPassword(z2);
    }

    public boolean k() {
        return this.ad.isFocusable();
    }

    public void l(boolean z2) {
        this.ad.setScrollable(z2);
    }

    public boolean l() {
        return this.ad.isFocused();
    }

    public void m(boolean z2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.ad.setImportantForAccessibility(z2);
        }
    }

    public boolean m() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.ad.isVisibleToUser();
        }
        return false;
    }

    public void n(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setContentInvalid(z2);
        }
    }

    public boolean n() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.ad.isAccessibilityFocused();
        }
        return false;
    }

    public void o(boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.ad.setContextClickable(z2);
        }
    }

    public boolean o() {
        return this.ad.isSelected();
    }

    public void p(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setCanOpenPopup(z2);
        }
    }

    public boolean p() {
        return this.ad.isClickable();
    }

    public void q(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setDismissable(z2);
        }
    }

    public boolean q() {
        return this.ad.isLongClickable();
    }

    public void r(boolean z2) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.ad.setEditable(z2);
        }
    }

    public boolean r() {
        return this.ad.isEnabled();
    }

    public void s(boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.ad.setMultiLine(z2);
        }
    }

    public boolean s() {
        return this.ad.isPassword();
    }

    public void t(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ad.setScreenReaderFocusable(z2);
        } else {
            a(1, z2);
        }
    }

    public boolean t() {
        return this.ad.isScrollable();
    }

    @ah
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(v());
        sb.append("; className: ");
        sb.append(w());
        sb.append("; text: ");
        sb.append(x());
        sb.append("; contentDescription: ");
        sb.append(y());
        sb.append("; viewId: ");
        sb.append(A());
        sb.append("; checkable: ");
        sb.append(i());
        sb.append("; checked: ");
        sb.append(j());
        sb.append("; focusable: ");
        sb.append(k());
        sb.append("; focused: ");
        sb.append(l());
        sb.append("; selected: ");
        sb.append(o());
        sb.append("; clickable: ");
        sb.append(p());
        sb.append("; longClickable: ");
        sb.append(q());
        sb.append("; enabled: ");
        sb.append(r());
        sb.append("; password: ");
        sb.append(s());
        sb.append("; scrollable: " + t());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> listG = G();
            for (int i2 = 0; i2 < listG.size(); i2++) {
                a aVar = listG.get(i2);
                String strL = l(aVar.a());
                if (strL.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    strL = aVar.b().toString();
                }
                sb.append(strL);
                if (i2 != listG.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int iF = f();
            while (iF != 0) {
                int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iF);
                iF &= ~iNumberOfTrailingZeros;
                sb.append(l(iNumberOfTrailingZeros));
                if (iF != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void u(boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.ad.setShowingHintText(z2);
        } else {
            a(4, z2);
        }
    }

    public boolean u() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.ad.isImportantForAccessibility();
        }
        return true;
    }

    public CharSequence v() {
        return this.ad.getPackageName();
    }

    public void v(boolean z2) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ad.setHeading(z2);
        } else {
            a(2, z2);
        }
    }

    public CharSequence w() {
        return this.ad.getClassName();
    }

    public void w(boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.ad.setTextEntryKey(z2);
        } else {
            a(8, z2);
        }
    }

    public CharSequence x() {
        if (!ai()) {
            return this.ad.getText();
        }
        List<Integer> listD = d(V);
        List<Integer> listD2 = d(W);
        List<Integer> listD3 = d(X);
        List<Integer> listD4 = d(U);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.ad.getText(), 0, this.ad.getText().length()));
        for (int i2 = 0; i2 < listD.size(); i2++) {
            spannableString.setSpan(new androidx.core.n.a.a(listD4.get(i2).intValue(), this, O().getInt(Y)), listD.get(i2).intValue(), listD2.get(i2).intValue(), listD3.get(i2).intValue());
        }
        return spannableString;
    }

    public CharSequence y() {
        return this.ad.getContentDescription();
    }

    public void z() {
        this.ad.recycle();
    }
}
