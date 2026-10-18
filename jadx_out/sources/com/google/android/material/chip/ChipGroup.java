package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.h;
import androidx.annotation.o;
import androidx.annotation.p;
import androidx.annotation.w;
import androidx.core.n.af;
import com.google.android.material.internal.e;
import com.google.android.material.internal.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1232a = com.google.android.material.a.n.Widget_MaterialComponents_ChipGroup;

    @p
    private int b;

    @p
    private int c;
    private boolean d;
    private boolean e;

    @ai
    private c f;
    private final a g;

    @ah
    private d h;

    @w
    private int i;
    private boolean j;

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@ah CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.j) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.e) {
                ChipGroup.this.b(compoundButton.getId(), true);
                ChipGroup.this.a(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z) {
                if (ChipGroup.this.i == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.i != -1 && ChipGroup.this.i != id && ChipGroup.this.d) {
                    ChipGroup.this.b(ChipGroup.this.i, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public b(int i, int i2) {
            super(i, i2);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface c {
        void a(ChipGroup chipGroup, @w int i);
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener b;

        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(Build.VERSION.SDK_INT >= 17 ? View.generateViewId() : view2.hashCode());
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.g);
            }
            if (this.b != null) {
                this.b.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            if (this.b != null) {
                this.b.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, f1232a), attributeSet, i);
        this.g = new a();
        this.h = new d();
        this.i = -1;
        this.j = false;
        TypedArray typedArrayA = s.a(getContext(), attributeSet, com.google.android.material.a.o.ChipGroup, i, f1232a, new int[0]);
        int dimensionPixelOffset = typedArrayA.getDimensionPixelOffset(com.google.android.material.a.o.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayA.getDimensionPixelOffset(com.google.android.material.a.o.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayA.getDimensionPixelOffset(com.google.android.material.a.o.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayA.getBoolean(com.google.android.material.a.o.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayA.getBoolean(com.google.android.material.a.o.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayA.getBoolean(com.google.android.material.a.o.ChipGroup_selectionRequired, false));
        int resourceId = typedArrayA.getResourceId(com.google.android.material.a.o.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.i = resourceId;
        }
        typedArrayA.recycle();
        super.setOnHierarchyChangeListener(this.h);
        af.e((View) this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        this.i = i;
        if (this.f != null && this.d && z) {
            this.f.a(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@w int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof Chip) {
            this.j = true;
            ((Chip) viewFindViewById).setChecked(z);
            this.j = false;
        }
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i) {
        a(i, true);
    }

    int a(@ai View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                if (((Chip) getChildAt(i2)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public void a() {
        this.j = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.j = false;
        setCheckedId(-1);
    }

    public void a(@w int i) {
        if (i == this.i) {
            return;
        }
        if (this.i != -1 && this.d) {
            b(this.i, false);
        }
        if (i != -1) {
            b(i, true);
        }
        setCheckedId(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                if (this.i != -1 && this.d) {
                    b(this.i, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Override // com.google.android.material.internal.e
    public boolean b() {
        return super.b();
    }

    public boolean c() {
        return this.d;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public boolean d() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    @ah
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    @ah
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    @ah
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @w
    public int getCheckedChipId() {
        if (this.d) {
            return this.i;
        }
        return -1;
    }

    @ah
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.d) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @p
    public int getChipSpacingHorizontal() {
        return this.b;
    }

    @p
    public int getChipSpacingVertical() {
        return this.c;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.i != -1) {
            b(this.i, true);
            setCheckedId(this.i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.n.a.d.a(accessibilityNodeInfo).b(androidx.core.n.a.d.b.a(getRowCount(), b() ? getChipCount() : -1, false, c() ? 1 : 2));
    }

    public void setChipSpacing(@p int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(@p int i) {
        if (this.b != i) {
            this.b = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@o int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(@o int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(@p int i) {
        if (this.c != i) {
            this.c = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@o int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@ai Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.f = cVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.h.b = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.e = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(@h int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // com.google.android.material.internal.e
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(@h int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.d != z) {
            this.d = z;
            a();
        }
    }
}
