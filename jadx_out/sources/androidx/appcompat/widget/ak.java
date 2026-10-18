package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ak implements androidx.appcompat.view.menu.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f209a = "ListPopupWindow";
    private static final boolean b = false;
    static final int c = 250;
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = -1;
    public static final int l = -2;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    private static Method p;
    private static Method q;
    private static Method r;
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private View F;
    private int G;
    private DataSetObserver H;
    private View I;
    private Drawable J;
    private AdapterView.OnItemClickListener K;
    private AdapterView.OnItemSelectedListener L;
    private final d M;
    private final c N;
    private final a O;
    private Runnable P;
    private final Rect Q;
    private Rect R;
    private boolean S;
    ag d;
    int e;
    final e f;
    final Handler g;
    PopupWindow h;
    private Context s;
    private ListAdapter t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ak.this.t();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ak.this.e()) {
                ak.this.b_();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ak.this.d();
        }
    }

    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ak.this.u() || ak.this.h.getContentView() == null) {
                return;
            }
            ak.this.g.removeCallbacks(ak.this.f);
            ak.this.f.run();
        }
    }

    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ak.this.h != null && ak.this.h.isShowing() && x >= 0 && x < ak.this.h.getWidth() && y >= 0 && y < ak.this.h.getHeight()) {
                ak.this.g.postDelayed(ak.this.f, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ak.this.g.removeCallbacks(ak.this.f);
            return false;
        }
    }

    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ak.this.d == null || !androidx.core.n.af.ak(ak.this.d) || ak.this.d.getCount() <= ak.this.d.getChildCount() || ak.this.d.getChildCount() > ak.this.e) {
                return;
            }
            ak.this.h.setInputMethodMode(2);
            ak.this.b_();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                p = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i(f209a, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                r = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i(f209a, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                q = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i(f209a, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ak(@androidx.annotation.ah Context context) {
        this(context, null, androidx.appcompat.a.b.listPopupWindowStyle);
    }

    public ak(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.listPopupWindowStyle);
    }

    public ak(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, @androidx.annotation.f int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ak(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, @androidx.annotation.f int i2, @androidx.annotation.at int i3) {
        this.u = -2;
        this.v = -2;
        this.y = androidx.core.n.aa.d;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.e = ActivityChooserView.a.f166a;
        this.G = 0;
        this.f = new e();
        this.M = new d();
        this.N = new c();
        this.O = new a();
        this.Q = new Rect();
        this.s = context;
        this.g = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.ListPopupWindow, i2, i3);
        this.w = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.a.m.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.x = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.a.m.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.x != 0) {
            this.z = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.h = new r(context, attributeSet, i2, i3);
        this.h.setInputMethodMode(1);
    }

    private int a(View view, int i2, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.h.getMaxAvailableHeight(view, i2, z);
        }
        if (q != null) {
            try {
                return ((Integer) q.invoke(this.h, view, Integer.valueOf(i2), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i(f209a, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.h.getMaxAvailableHeight(view, i2);
    }

    private static boolean c(int i2) {
        return i2 == 66 || i2 == 23;
    }

    private void e(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            this.h.setIsClippedToScreen(z);
        } else if (p != null) {
            try {
                p.invoke(this.h, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i(f209a, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private void h() {
        if (this.F != null) {
            ViewParent parent = this.F.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.F);
            }
        }
    }

    private int z() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        View view;
        int i3;
        int i4;
        if (this.d == null) {
            Context context = this.s;
            this.P = new Runnable() { // from class: androidx.appcompat.widget.ak.2
                @Override // java.lang.Runnable
                public void run() {
                    View viewN = ak.this.n();
                    if (viewN == null || viewN.getWindowToken() == null) {
                        return;
                    }
                    ak.this.b_();
                }
            };
            this.d = a(context, !this.S);
            if (this.J != null) {
                this.d.setSelector(this.J);
            }
            this.d.setAdapter(this.t);
            this.d.setOnItemClickListener(this.K);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ak.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i5, long j2) {
                    ag agVar;
                    if (i5 == -1 || (agVar = ak.this.d) == null) {
                        return;
                    }
                    agVar.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.d.setOnScrollListener(this.N);
            if (this.L != null) {
                this.d.setOnItemSelectedListener(this.L);
            }
            ag agVar = this.d;
            View view2 = this.F;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.G) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(agVar, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(agVar, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e(f209a, "Invalid hint position " + this.G);
                        break;
                }
                if (this.v >= 0) {
                    i3 = this.v;
                    i4 = Integer.MIN_VALUE;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i3, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = agVar;
            }
            this.h.setContentView(view);
        } else {
            View view3 = this.F;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.h.getBackground();
        if (background != null) {
            background.getPadding(this.Q);
            i2 = this.Q.top + this.Q.bottom;
            if (!this.z) {
                this.x = -this.Q.top;
            }
        } else {
            this.Q.setEmpty();
            i2 = 0;
        }
        int iA = a(n(), this.x, this.h.getInputMethodMode() == 2);
        if (this.D || this.u == -1) {
            return iA + i2;
        }
        switch (this.v) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.s.getResources().getDisplayMetrics().widthPixels - (this.Q.left + this.Q.right), Integer.MIN_VALUE);
                break;
            case -1:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.s.getResources().getDisplayMetrics().widthPixels - (this.Q.left + this.Q.right), androidx.d.c.b.a.b.b);
                break;
            default:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.v, androidx.d.c.b.a.b.b);
                break;
        }
        int iA2 = this.d.a(iMakeMeasureSpec, 0, -1, iA - measuredHeight, -1);
        if (iA2 > 0) {
            measuredHeight += i2 + this.d.getPaddingTop() + this.d.getPaddingBottom();
        }
        return iA2 + measuredHeight;
    }

    @androidx.annotation.ah
    ag a(Context context, boolean z) {
        return new ag(context, z);
    }

    public void a(int i2) {
        this.x = i2;
        this.z = true;
    }

    public void a(@androidx.annotation.ai Rect rect) {
        this.R = rect != null ? new Rect(rect) : null;
    }

    public void a(@androidx.annotation.ai Drawable drawable) {
        this.h.setBackgroundDrawable(drawable);
    }

    public void a(@androidx.annotation.ai AdapterView.OnItemClickListener onItemClickListener) {
        this.K = onItemClickListener;
    }

    public void a(@androidx.annotation.ai AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.L = onItemSelectedListener;
    }

    public void a(@androidx.annotation.ai ListAdapter listAdapter) {
        if (this.H == null) {
            this.H = new b();
        } else if (this.t != null) {
            this.t.unregisterDataSetObserver(this.H);
        }
        this.t = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.H);
        }
        if (this.d != null) {
            this.d.setAdapter(this.t);
        }
    }

    public void a(@androidx.annotation.ai PopupWindow.OnDismissListener onDismissListener) {
        this.h.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.S = z;
        this.h.setFocusable(z);
    }

    public boolean a(int i2, @androidx.annotation.ah KeyEvent keyEvent) {
        int count;
        if (e() && i2 != 62 && (this.d.getSelectedItemPosition() >= 0 || !c(i2))) {
            int selectedItemPosition = this.d.getSelectedItemPosition();
            boolean z = !this.h.isAboveAnchor();
            ListAdapter listAdapter = this.t;
            int i3 = ActivityChooserView.a.f166a;
            if (listAdapter != null) {
                boolean zAreAllItemsEnabled = listAdapter.areAllItemsEnabled();
                int iA = zAreAllItemsEnabled ? 0 : this.d.a(0, true);
                count = zAreAllItemsEnabled ? listAdapter.getCount() - 1 : this.d.a(listAdapter.getCount() - 1, false);
                i3 = iA;
            } else {
                count = Integer.MIN_VALUE;
            }
            if ((z && i2 == 19 && selectedItemPosition <= i3) || (!z && i2 == 20 && selectedItemPosition >= count)) {
                t();
                this.h.setInputMethodMode(1);
                b_();
                return true;
            }
            this.d.setListSelectionHidden(false);
            if (this.d.onKeyDown(i2, keyEvent)) {
                this.h.setInputMethodMode(2);
                this.d.requestFocusFromTouch();
                b_();
                if (i2 != 23 && i2 != 66) {
                    switch (i2) {
                    }
                }
                return true;
            }
            if (z && i2 == 20) {
                if (selectedItemPosition == count) {
                    return true;
                }
            } else if (!z && i2 == 19 && selectedItemPosition == i3) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.ai
    public Drawable b() {
        return this.h.getBackground();
    }

    public void b(int i2) {
        this.w = i2;
    }

    public void b(Drawable drawable) {
        this.J = drawable;
    }

    public void b(@androidx.annotation.ai View view) {
        this.I = view;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void b(boolean z) {
        this.E = z;
    }

    public boolean b(int i2, @androidx.annotation.ah KeyEvent keyEvent) {
        if (!e() || this.d.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean zOnKeyUp = this.d.onKeyUp(i2, keyEvent);
        if (zOnKeyUp && c(i2)) {
            d();
        }
        return zOnKeyUp;
    }

    @Override // androidx.appcompat.view.menu.q
    public void b_() {
        int width;
        int width2;
        int iZ = z();
        boolean zU = u();
        androidx.core.widget.k.a(this.h, this.y);
        if (this.h.isShowing()) {
            if (androidx.core.n.af.ak(n())) {
                if (this.v == -1) {
                    width2 = -1;
                } else {
                    width2 = this.v == -2 ? n().getWidth() : this.v;
                }
                if (this.u == -1) {
                    if (!zU) {
                        iZ = -1;
                    }
                    if (zU) {
                        this.h.setWidth(this.v == -1 ? -1 : 0);
                        this.h.setHeight(0);
                    } else {
                        this.h.setWidth(this.v == -1 ? -1 : 0);
                        this.h.setHeight(-1);
                    }
                } else if (this.u != -2) {
                    iZ = this.u;
                }
                this.h.setOutsideTouchable((this.E || this.D) ? false : true);
                this.h.update(n(), this.w, this.x, width2 < 0 ? -1 : width2, iZ < 0 ? -1 : iZ);
                return;
            }
            return;
        }
        if (this.v == -1) {
            width = -1;
        } else {
            width = this.v == -2 ? n().getWidth() : this.v;
        }
        if (this.u == -1) {
            iZ = -1;
        } else if (this.u != -2) {
            iZ = this.u;
        }
        this.h.setWidth(width);
        this.h.setHeight(iZ);
        e(true);
        this.h.setOutsideTouchable((this.E || this.D) ? false : true);
        this.h.setTouchInterceptor(this.M);
        if (this.B) {
            androidx.core.widget.k.a(this.h, this.A);
        }
        if (Build.VERSION.SDK_INT > 28) {
            this.h.setEpicenterBounds(this.R);
        } else if (r != null) {
            try {
                r.invoke(this.h, this.R);
            } catch (Exception e2) {
                Log.e(f209a, "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        androidx.core.widget.k.a(this.h, n(), this.w, this.x, this.C);
        this.d.setSelection(-1);
        if (!this.S || this.d.isInTouchMode()) {
            t();
        }
        if (this.S) {
            return;
        }
        this.g.post(this.O);
    }

    public int c() {
        if (this.z) {
            return this.x;
        }
        return 0;
    }

    public void c(@androidx.annotation.ai View view) {
        boolean zE = e();
        if (zE) {
            h();
        }
        this.F = view;
        if (zE) {
            b_();
        }
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void c(boolean z) {
        this.D = z;
    }

    public boolean c(int i2, @androidx.annotation.ah KeyEvent keyEvent) {
        if (i2 != 4 || !e()) {
            return false;
        }
        View view = this.I;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        d();
        return true;
    }

    @Override // androidx.appcompat.view.menu.q
    @androidx.annotation.ai
    public ListView c_() {
        return this.d;
    }

    public View.OnTouchListener d(View view) {
        return new ai(view) { // from class: androidx.appcompat.widget.ak.1
            @Override // androidx.appcompat.widget.ai
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ak a() {
                return ak.this;
            }
        };
    }

    @Override // androidx.appcompat.view.menu.q
    public void d() {
        this.h.dismiss();
        h();
        this.h.setContentView(null);
        this.d = null;
        this.g.removeCallbacks(this.f);
    }

    public void d(int i2) {
        this.G = i2;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void d(boolean z) {
        this.B = true;
        this.A = z;
    }

    public void e(int i2) {
        this.h.setSoftInputMode(i2);
    }

    @Override // androidx.appcompat.view.menu.q
    public boolean e() {
        return this.h.isShowing();
    }

    public int f() {
        return this.w;
    }

    public void f(@androidx.annotation.at int i2) {
        this.h.setAnimationStyle(i2);
    }

    public void g(int i2) {
        this.C = i2;
    }

    public void h(int i2) {
        this.v = i2;
    }

    public int i() {
        return this.G;
    }

    public void i(int i2) {
        Drawable background = this.h.getBackground();
        if (background == null) {
            h(i2);
        } else {
            background.getPadding(this.Q);
            this.v = this.Q.left + this.Q.right + i2;
        }
    }

    public void j(int i2) {
        if (i2 < 0 && -2 != i2 && -1 != i2) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.u = i2;
    }

    public boolean j() {
        return this.S;
    }

    public void k(int i2) {
        this.y = i2;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public boolean k() {
        return this.D;
    }

    public int l() {
        return this.h.getSoftInputMode();
    }

    public void l(int i2) {
        this.h.setInputMethodMode(i2);
    }

    @androidx.annotation.at
    public int m() {
        return this.h.getAnimationStyle();
    }

    public void m(int i2) {
        ag agVar = this.d;
        if (!e() || agVar == null) {
            return;
        }
        agVar.setListSelectionHidden(false);
        agVar.setSelection(i2);
        if (agVar.getChoiceMode() != 0) {
            agVar.setItemChecked(i2, true);
        }
    }

    @androidx.annotation.ai
    public View n() {
        return this.I;
    }

    public boolean n(int i2) {
        if (!e()) {
            return false;
        }
        if (this.K == null) {
            return true;
        }
        ag agVar = this.d;
        this.K.onItemClick(agVar, agVar.getChildAt(i2 - agVar.getFirstVisiblePosition()), i2, agVar.getAdapter().getItemId(i2));
        return true;
    }

    @androidx.annotation.ai
    public Rect o() {
        if (this.R != null) {
            return new Rect(this.R);
        }
        return null;
    }

    void o(int i2) {
        this.e = i2;
    }

    public int p() {
        return this.v;
    }

    public int q() {
        return this.u;
    }

    public void r() {
        this.g.post(this.P);
    }

    public int s() {
        return this.h.getInputMethodMode();
    }

    public void t() {
        ag agVar = this.d;
        if (agVar != null) {
            agVar.setListSelectionHidden(true);
            agVar.requestLayout();
        }
    }

    public boolean u() {
        return this.h.getInputMethodMode() == 2;
    }

    @androidx.annotation.ai
    public Object v() {
        if (e()) {
            return this.d.getSelectedItem();
        }
        return null;
    }

    public int w() {
        if (e()) {
            return this.d.getSelectedItemPosition();
        }
        return -1;
    }

    public long x() {
        if (e()) {
            return this.d.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    @androidx.annotation.ai
    public View y() {
        if (e()) {
            return this.d.getSelectedView();
        }
        return null;
    }
}
