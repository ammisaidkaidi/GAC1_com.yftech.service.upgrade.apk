package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.appcompat.widget.ak;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes.dex */
public class g extends androidx.appcompat.widget.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1463a = 15;

    @ah
    private final ak b;

    @ai
    private final AccessibilityManager c;

    @ah
    private final Rect d;

    public g(@ah Context context) {
        this(context, null);
    }

    public g(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.autoCompleteTextViewStyle);
    }

    public g(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, 0), attributeSet, i);
        this.d = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayA = s.a(context2, attributeSet, com.google.android.material.a.o.MaterialAutoCompleteTextView, i, com.google.android.material.a.n.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayA.hasValue(com.google.android.material.a.o.MaterialAutoCompleteTextView_android_inputType) && typedArrayA.getInt(com.google.android.material.a.o.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.c = (AccessibilityManager) context2.getSystemService("accessibility");
        this.b = new ak(context2);
        this.b.a(true);
        this.b.b(this);
        this.b.l(2);
        this.b.a(getAdapter());
        this.b.a(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.g.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                g.this.a(i2 < 0 ? g.this.b.v() : g.this.getAdapter().getItem(i2));
                AdapterView.OnItemClickListener onItemClickListener = g.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i2 < 0) {
                        view = g.this.b.y();
                        i2 = g.this.b.w();
                        j = g.this.b.x();
                    }
                    onItemClickListener.onItemClick(g.this.b.c_(), view, i2, j);
                }
                g.this.b.d();
            }
        });
        typedArrayA.recycle();
    }

    private int a() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutB = b();
        int i = 0;
        if (adapter == null || textInputLayoutB == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.b.w()) + 15);
        int iMax = 0;
        View view = null;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutB);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableB = this.b.b();
        if (drawableB != null) {
            drawableB.getPadding(this.d);
            iMax += this.d.left + this.d.right;
        }
        return iMax + textInputLayoutB.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @ai
    private TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    @ai
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.b()) ? super.getHint() : textInputLayoutB.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.b() && super.getHint() == null && com.google.android.material.internal.g.a()) {
            setHint(com.yftech.service.upgrade.a.d);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@ai T t) {
        super.setAdapter(t);
        this.b.a(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (getInputType() == 0 && this.c != null && this.c.isTouchExplorationEnabled()) {
            this.b.b_();
        } else {
            super.showDropDown();
        }
    }
}
