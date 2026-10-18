package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f159a;
    final FrameLayout b;
    final FrameLayout c;
    androidx.core.n.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final Drawable k;
    private final ImageView l;
    private final ImageView m;
    private final int n;
    private final ViewTreeObserver.OnGlobalLayoutListener o;
    private ak p;
    private boolean q;
    private int r;

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f165a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ba baVarA = ba.a(context, attributeSet, f165a);
            setBackgroundDrawable(baVarA.a(0));
            baVarA.f();
        }
    }

    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f166a = Integer.MAX_VALUE;
        public static final int b = 4;
        private static final int d = 0;
        private static final int e = 1;
        private static final int f = 3;
        private d g;
        private int h = 4;
        private boolean i;
        private boolean j;
        private boolean k;

        a() {
        }

        public int a() {
            int i = this.h;
            this.h = f166a;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            View view = null;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.h = i;
            return iMax;
        }

        public void a(int i) {
            if (this.h != i) {
                this.h = i;
                notifyDataSetChanged();
            }
        }

        public void a(d dVar) {
            d dVarE = ActivityChooserView.this.f159a.e();
            if (dVarE != null && ActivityChooserView.this.isShown()) {
                dVarE.unregisterObserver(ActivityChooserView.this.e);
            }
            this.g = dVar;
            if (dVar != null && ActivityChooserView.this.isShown()) {
                dVar.registerObserver(ActivityChooserView.this.e);
            }
            notifyDataSetChanged();
        }

        public void a(boolean z) {
            if (this.k != z) {
                this.k = z;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z, boolean z2) {
            if (this.i == z && this.j == z2) {
                return;
            }
            this.i = z;
            this.j = z2;
            notifyDataSetChanged();
        }

        public ResolveInfo b() {
            return this.g.c();
        }

        public int c() {
            return this.g.b();
        }

        public int d() {
            return this.g.e();
        }

        public d e() {
            return this.g;
        }

        public boolean f() {
            return this.i;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iB = this.g.b();
            if (!this.i && this.g.c() != null) {
                iB--;
            }
            int iMin = Math.min(iB, this.h);
            return this.k ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.i && this.g.c() != null) {
                        i++;
                    }
                    return this.g.a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.k && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != androidx.appcompat.a.g.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.a.j.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(androidx.appcompat.a.g.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(androidx.appcompat.a.g.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.i && i == 0 && this.j) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.a.j.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(androidx.appcompat.a.g.title)).setText(ActivityChooserView.this.getContext().getString(androidx.appcompat.a.k.abc_activity_chooser_view_see_all));
                    return viewInflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        b() {
        }

        private void a() {
            if (ActivityChooserView.this.f != null) {
                ActivityChooserView.this.f.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != ActivityChooserView.this.c) {
                if (view != ActivityChooserView.this.b) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.g = false;
                ActivityChooserView.this.a(ActivityChooserView.this.h);
                return;
            }
            ActivityChooserView.this.b();
            Intent intentB = ActivityChooserView.this.f159a.e().b(ActivityChooserView.this.f159a.e().a(ActivityChooserView.this.f159a.b()));
            if (intentB != null) {
                intentB.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentB);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            if (ActivityChooserView.this.d != null) {
                ActivityChooserView.this.d.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.b();
                    if (ActivityChooserView.this.g) {
                        if (i > 0) {
                            ActivityChooserView.this.f159a.e().c(i);
                            return;
                        }
                        return;
                    }
                    if (!ActivityChooserView.this.f159a.f()) {
                        i++;
                    }
                    Intent intentB = ActivityChooserView.this.f159a.e().b(i);
                    if (intentB != null) {
                        intentB.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(intentB);
                        return;
                    }
                    return;
                case 1:
                    ActivityChooserView.this.a(a.f166a);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view != ActivityChooserView.this.c) {
                throw new IllegalArgumentException();
            }
            if (ActivityChooserView.this.f159a.getCount() > 0) {
                ActivityChooserView.this.g = true;
                ActivityChooserView.this.a(ActivityChooserView.this.h);
            }
            return true;
        }
    }

    public ActivityChooserView(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public ActivityChooserView(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f159a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f159a.notifyDataSetInvalidated();
            }
        };
        this.o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.ActivityChooserView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.c()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().d();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().b_();
                    if (ActivityChooserView.this.d != null) {
                        ActivityChooserView.this.d.a(true);
                    }
                }
            }
        };
        this.h = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.ActivityChooserView, i, 0);
        androidx.core.n.af.a(this, context, androidx.appcompat.a.m.ActivityChooserView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        this.h = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.a.m.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.a.m.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.a.j.abc_activity_chooser_view, (ViewGroup) this, true);
        this.i = new b();
        this.j = findViewById(androidx.appcompat.a.g.activity_chooser_view_content);
        this.k = this.j.getBackground();
        this.c = (FrameLayout) findViewById(androidx.appcompat.a.g.default_activity_button);
        this.c.setOnClickListener(this.i);
        this.c.setOnLongClickListener(this.i);
        this.m = (ImageView) this.c.findViewById(androidx.appcompat.a.g.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.a.g.expand_activities_button);
        frameLayout.setOnClickListener(this.i);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: androidx.appcompat.widget.ActivityChooserView.3
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                androidx.core.n.a.d.a(accessibilityNodeInfo).p(true);
            }
        });
        frameLayout.setOnTouchListener(new ai(frameLayout) { // from class: androidx.appcompat.widget.ActivityChooserView.4
            @Override // androidx.appcompat.widget.ai
            public androidx.appcompat.view.menu.q a() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // androidx.appcompat.widget.ai
            protected boolean b() {
                ActivityChooserView.this.a();
                return true;
            }

            @Override // androidx.appcompat.widget.ai
            protected boolean c() {
                ActivityChooserView.this.b();
                return true;
            }
        });
        this.b = frameLayout;
        this.l = (ImageView) frameLayout.findViewById(androidx.appcompat.a.g.image);
        this.l.setImageDrawable(drawable);
        this.f159a = new a();
        this.f159a.registerDataSetObserver(new DataSetObserver() { // from class: androidx.appcompat.widget.ActivityChooserView.5
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.d();
            }
        });
        Resources resources = context.getResources();
        this.n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.a.e.abc_config_prefDialogWidth));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
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
    void a(int i) {
        if (this.f159a.e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        ?? r0 = this.c.getVisibility() == 0 ? 1 : 0;
        int iC = this.f159a.c();
        if (i == Integer.MAX_VALUE || iC <= i + r0) {
            this.f159a.a(false);
            this.f159a.a(i);
        } else {
            this.f159a.a(true);
            this.f159a.a(i - 1);
        }
        ak listPopupWindow = getListPopupWindow();
        if (listPopupWindow.e()) {
            return;
        }
        if (this.g || r0 == 0) {
            this.f159a.a(true, r0);
        } else {
            this.f159a.a(false, false);
        }
        listPopupWindow.i(Math.min(this.f159a.a(), this.n));
        listPopupWindow.b_();
        if (this.d != null) {
            this.d.a(true);
        }
        listPopupWindow.c_().setContentDescription(getContext().getString(androidx.appcompat.a.k.abc_activitychooserview_choose_application));
        listPopupWindow.c_().setSelector(new ColorDrawable(0));
    }

    public boolean a() {
        if (c() || !this.q) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().d();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.o);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().e();
    }

    void d() {
        if (this.f159a.getCount() > 0) {
            this.b.setEnabled(true);
        } else {
            this.b.setEnabled(false);
        }
        int iC = this.f159a.c();
        int iD = this.f159a.d();
        if (iC == 1 || (iC > 1 && iD > 0)) {
            this.c.setVisibility(0);
            ResolveInfo resolveInfoB = this.f159a.b();
            PackageManager packageManager = getContext().getPackageManager();
            this.m.setImageDrawable(resolveInfoB.loadIcon(packageManager));
            if (this.r != 0) {
                this.c.setContentDescription(getContext().getString(this.r, resolveInfoB.loadLabel(packageManager)));
            }
        } else {
            this.c.setVisibility(8);
        }
        if (this.c.getVisibility() == 0) {
            this.j.setBackgroundDrawable(this.k);
        } else {
            this.j.setBackgroundDrawable(null);
        }
    }

    public d getDataModel() {
        return this.f159a.e();
    }

    ak getListPopupWindow() {
        if (this.p == null) {
            this.p = new ak(getContext());
            this.p.a(this.f159a);
            this.p.b(this);
            this.p.a(true);
            this.p.a((AdapterView.OnItemClickListener) this.i);
            this.p.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVarE = this.f159a.e();
        if (dVarE != null) {
            dVarE.registerObserver(this.e);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVarE = this.f159a.e();
        if (dVarE != null) {
            dVarE.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.o);
        }
        if (c()) {
            b();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.j.layout(0, 0, i3 - i, i4 - i2);
        if (c()) {
            return;
        }
        b();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), androidx.d.c.b.a.b.b);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.d.a
    public void setActivityChooserModel(d dVar) {
        this.f159a.a(dVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.l.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.l.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.h = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setProvider(androidx.core.n.b bVar) {
        this.d = bVar;
    }
}
