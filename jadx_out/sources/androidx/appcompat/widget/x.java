package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class x extends Spinner implements androidx.core.n.ad {
    private static final int[] c = {R.attr.spinnerMode};
    private static final int d = 15;
    private static final String e = "AppCompatSpinner";
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f286a;
    final Rect b;
    private final f i;
    private final Context j;
    private ai k;
    private SpinnerAdapter l;
    private final boolean m;
    private e n;

    @androidx.annotation.ax
    class a implements DialogInterface.OnClickListener, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @androidx.annotation.ax
        androidx.appcompat.app.d f289a;
        private ListAdapter c;
        private CharSequence d;

        a() {
        }

        @Override // androidx.appcompat.widget.x.e
        public CharSequence a() {
            return this.d;
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(int i) {
            Log.e(x.e, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(int i, int i2) {
            if (this.c == null) {
                return;
            }
            androidx.appcompat.app.d.a aVar = new androidx.appcompat.app.d.a(x.this.getPopupContext());
            if (this.d != null) {
                aVar.a(this.d);
            }
            this.f289a = aVar.a(this.c, x.this.getSelectedItemPosition(), this).b();
            ListView listViewA = this.f289a.a();
            if (Build.VERSION.SDK_INT >= 17) {
                listViewA.setTextDirection(i);
                listViewA.setTextAlignment(i2);
            }
            this.f289a.show();
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(Drawable drawable) {
            Log.e(x.e, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        @Override // androidx.appcompat.widget.x.e
        public Drawable b() {
            return null;
        }

        @Override // androidx.appcompat.widget.x.e
        public void b(int i) {
            Log.e(x.e, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.e
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.x.e
        public void c(int i) {
            Log.e(x.e, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.e
        public void d() {
            if (this.f289a != null) {
                this.f289a.dismiss();
                this.f289a = null;
            }
        }

        @Override // androidx.appcompat.widget.x.e
        public boolean e() {
            if (this.f289a != null) {
                return this.f289a.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.x.e
        public int f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.x.e
        public int g() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            x.this.setSelection(i);
            if (x.this.getOnItemClickListener() != null) {
                x.this.performItemClick(null, i, this.c.getItemId(i));
            }
            d();
        }
    }

    private static class b implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f290a;
        private ListAdapter b;

        public b(@androidx.annotation.ai SpinnerAdapter spinnerAdapter, @androidx.annotation.ai Resources.Theme theme) {
            this.f290a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof aw) {
                    aw awVar = (aw) spinnerAdapter;
                    if (awVar.a() == null) {
                        awVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f290a == null) {
                return 0;
            }
            return this.f290a.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f290a == null) {
                return null;
            }
            return this.f290a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f290a == null) {
                return null;
            }
            return this.f290a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f290a == null) {
                return -1L;
            }
            return this.f290a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f290a != null && this.f290a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f290a != null) {
                this.f290a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f290a != null) {
                this.f290a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @androidx.annotation.ax
    class c extends ak implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ListAdapter f291a;
        private CharSequence p;
        private final Rect q;
        private int r;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.q = new Rect();
            b(x.this);
            a(true);
            d(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.x.c.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    x.this.setSelection(i2);
                    if (x.this.getOnItemClickListener() != null) {
                        x.this.performItemClick(view, i2, c.this.f291a.getItemId(i2));
                    }
                    c.this.d();
                }
            });
        }

        @Override // androidx.appcompat.widget.x.e
        public CharSequence a() {
            return this.p;
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean zE = e();
            h();
            l(2);
            super.b_();
            ListView listViewC_ = c_();
            listViewC_.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                listViewC_.setTextDirection(i);
                listViewC_.setTextAlignment(i2);
            }
            m(x.this.getSelectedItemPosition());
            if (zE || (viewTreeObserver = x.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.x.c.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!c.this.a(x.this)) {
                        c.this.d();
                    } else {
                        c.this.h();
                        c.super.b_();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.x.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = x.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        @Override // androidx.appcompat.widget.ak, androidx.appcompat.widget.x.e
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f291a = listAdapter;
        }

        @Override // androidx.appcompat.widget.x.e
        public void a(CharSequence charSequence) {
            this.p = charSequence;
        }

        boolean a(View view) {
            return androidx.core.n.af.ak(view) && view.getGlobalVisibleRect(this.q);
        }

        @Override // androidx.appcompat.widget.x.e
        public void c(int i) {
            this.r = i;
        }

        @Override // androidx.appcompat.widget.x.e
        public int g() {
            return this.r;
        }

        void h() {
            Drawable drawableB = b();
            int i = 0;
            if (drawableB != null) {
                drawableB.getPadding(x.this.b);
                i = bg.a(x.this) ? x.this.b.right : -x.this.b.left;
            } else {
                Rect rect = x.this.b;
                x.this.b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = x.this.getPaddingLeft();
            int paddingRight = x.this.getPaddingRight();
            int width = x.this.getWidth();
            if (x.this.f286a == -2) {
                int iA = x.this.a((SpinnerAdapter) this.f291a, b());
                int i2 = (x.this.getContext().getResources().getDisplayMetrics().widthPixels - x.this.b.left) - x.this.b.right;
                if (iA > i2) {
                    iA = i2;
                }
                i(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (x.this.f286a == -1) {
                i((width - paddingLeft) - paddingRight);
            } else {
                i(x.this.f286a);
            }
            b(bg.a(x.this) ? i + (((width - paddingRight) - p()) - g()) : i + paddingLeft + g());
        }
    }

    static class d extends View.BaseSavedState {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: androidx.appcompat.widget.x.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f295a;

        d(Parcel parcel) {
            super(parcel);
            this.f295a = parcel.readByte() != 0;
        }

        d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f295a ? (byte) 1 : (byte) 0);
        }
    }

    @androidx.annotation.ax
    interface e {
        CharSequence a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        Drawable b();

        void b(int i);

        int c();

        void c(int i);

        void d();

        boolean e();

        int f();

        int g();
    }

    public x(@androidx.annotation.ah Context context) {
        this(context, (AttributeSet) null);
    }

    public x(@androidx.annotation.ah Context context, int i) {
        this(context, null, androidx.appcompat.a.b.spinnerStyle, i);
    }

    public x(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.spinnerStyle);
    }

    public x(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public x(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[PHI: r10 r11
      0x0052: PHI (r10v1 int) = (r10v0 int), (r10v2 int) binds: [B:25:0x0064, B:16:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r11v8 android.content.res.TypedArray) = (r11v7 android.content.res.TypedArray), (r11v10 android.content.res.TypedArray) binds: [B:25:0x0064, B:16:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    public x(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i, int i2, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.b = new Rect();
        av.a(this, getContext());
        ba baVarA = ba.a(context, attributeSet, androidx.appcompat.a.m.Spinner, i, 0);
        this.i = new f(this);
        if (theme != null) {
            this.j = new androidx.appcompat.view.d(context, theme);
        } else {
            int iG = baVarA.g(androidx.appcompat.a.m.Spinner_popupTheme, 0);
            if (iG != 0) {
                this.j = new androidx.appcompat.view.d(context, iG);
            } else {
                this.j = context;
            }
        }
        TypedArray typedArray = -1;
        try {
            if (i2 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
                    try {
                        i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        Log.i(e, "Could not read android:spinnerMode", e);
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th) {
                    th = th;
                    typedArray = 0;
                    if (typedArray != 0) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            }
            switch (i2) {
                case 0:
                    this.n = new a();
                    this.n.a(baVarA.e(androidx.appcompat.a.m.Spinner_android_prompt));
                    break;
                case 1:
                    final c cVar = new c(this.j, attributeSet, i);
                    ba baVarA2 = ba.a(this.j, attributeSet, androidx.appcompat.a.m.Spinner, i, 0);
                    this.f286a = baVarA2.f(androidx.appcompat.a.m.Spinner_android_dropDownWidth, -2);
                    cVar.a(baVarA2.a(androidx.appcompat.a.m.Spinner_android_popupBackground));
                    cVar.a(baVarA.e(androidx.appcompat.a.m.Spinner_android_prompt));
                    baVarA2.f();
                    this.n = cVar;
                    this.k = new ai(this) { // from class: androidx.appcompat.widget.x.1
                        @Override // androidx.appcompat.widget.ai
                        public androidx.appcompat.view.menu.q a() {
                            return cVar;
                        }

                        @Override // androidx.appcompat.widget.ai
                        @SuppressLint({"SyntheticAccessor"})
                        public boolean b() {
                            if (x.this.getInternalPopup().e()) {
                                return true;
                            }
                            x.this.a();
                            return true;
                        }
                    };
                    break;
            }
            CharSequence[] charSequenceArrH = baVarA.h(androidx.appcompat.a.m.Spinner_android_entries);
            if (charSequenceArrH != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrH);
                arrayAdapter.setDropDownViewResource(androidx.appcompat.a.j.support_simple_spinner_dropdown_item);
                setAdapter((SpinnerAdapter) arrayAdapter);
            }
            baVarA.f();
            this.m = true;
            if (this.l != null) {
                setAdapter(this.l);
                this.l = null;
            }
            this.i.a(attributeSet, i);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        int iMax2 = 0;
        View view = null;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.b);
        return iMax2 + this.b.left + this.b.right;
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.n.a(getTextDirection(), getTextAlignment());
        } else {
            this.n.a(-1, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.i != null) {
            this.i.c();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.n != null) {
            return this.n.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.n != null) {
            return this.n.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.n != null) {
            return this.f286a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @androidx.annotation.ax
    final e getInternalPopup() {
        return this.n;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.n != null) {
            return this.n.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.j;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.n != null ? this.n.a() : super.getPrompt();
    }

    @Override // androidx.core.n.ad
    @androidx.annotation.ai
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        if (this.i != null) {
            return this.i.a();
        }
        return null;
    }

    @Override // androidx.core.n.ad
    @androidx.annotation.ai
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.i != null) {
            return this.i.b();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.n == null || !this.n.e()) {
            return;
        }
        this.n.d();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.n == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        if (!dVar.f295a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.x.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!x.this.getInternalPopup().e()) {
                    x.this.a();
                }
                ViewTreeObserver viewTreeObserver2 = x.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        dVar.f295a = this.n != null && this.n.e();
        return dVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.k == null || !this.k.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.n == null) {
            return super.performClick();
        }
        if (this.n.e()) {
            return true;
        }
        a();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.m) {
            this.l = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.n != null) {
            this.n.a(new b(spinnerAdapter, (this.j == null ? getContext() : this.j).getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.i != null) {
            this.i.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@androidx.annotation.q int i) {
        super.setBackgroundResource(i);
        if (this.i != null) {
            this.i.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.n != null) {
            this.n.c(i);
            this.n.b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.n != null) {
            this.n.a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.n != null) {
            this.f286a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.n != null) {
            this.n.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@androidx.annotation.q int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.n != null) {
            this.n.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.n.ad
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@androidx.annotation.ai ColorStateList colorStateList) {
        if (this.i != null) {
            this.i.a(colorStateList);
        }
    }

    @Override // androidx.core.n.ad
    @androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@androidx.annotation.ai PorterDuff.Mode mode) {
        if (this.i != null) {
            this.i.a(mode);
        }
    }
}
