package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ax;
import androidx.annotation.h;
import androidx.annotation.w;
import androidx.core.n.af;
import androidx.core.n.m;
import com.google.android.material.internal.s;
import com.google.android.material.internal.z;
import com.google.android.material.t.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1212a = "b";
    private static final int b = com.google.android.material.a.n.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private final List<C0084b> c;
    private final a d;
    private final d e;
    private final LinkedHashSet<c> f;
    private final Comparator<MaterialButton> g;
    private Integer[] h;
    private boolean i;
    private boolean j;
    private boolean k;

    @w
    private int l;

    private class a implements MaterialButton.b {
        private a() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@ah MaterialButton materialButton, boolean z) {
            if (b.this.i) {
                return;
            }
            if (b.this.j) {
                b.this.l = z ? materialButton.getId() : -1;
            }
            if (b.this.b(materialButton.getId(), z)) {
                b.this.c(materialButton.getId(), materialButton.isChecked());
            }
            b.this.invalidate();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.button.b$b, reason: collision with other inner class name */
    private static class C0084b {
        private static final com.google.android.material.t.d e = new com.google.android.material.t.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.t.d f1216a;
        com.google.android.material.t.d b;
        com.google.android.material.t.d c;
        com.google.android.material.t.d d;

        C0084b(com.google.android.material.t.d dVar, com.google.android.material.t.d dVar2, com.google.android.material.t.d dVar3, com.google.android.material.t.d dVar4) {
            this.f1216a = dVar;
            this.b = dVar3;
            this.c = dVar4;
            this.d = dVar2;
        }

        public static C0084b a(C0084b c0084b) {
            return new C0084b(c0084b.f1216a, c0084b.d, e, e);
        }

        public static C0084b a(C0084b c0084b, View view) {
            return z.a(view) ? b(c0084b) : a(c0084b);
        }

        public static C0084b b(C0084b c0084b) {
            return new C0084b(e, e, c0084b.b, c0084b.c);
        }

        public static C0084b b(C0084b c0084b, View view) {
            return z.a(view) ? a(c0084b) : b(c0084b);
        }

        public static C0084b c(C0084b c0084b) {
            return new C0084b(c0084b.f1216a, e, c0084b.b, e);
        }

        public static C0084b d(C0084b c0084b) {
            return new C0084b(e, c0084b.d, e, c0084b.c);
        }
    }

    public interface c {
        void a(b bVar, @w int i, boolean z);
    }

    private class d implements MaterialButton.c {
        private d() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(@ah MaterialButton materialButton, boolean z) {
            b.this.invalidate();
        }
    }

    public b(@ah Context context) {
        this(context, null);
    }

    public b(@ah Context context, @ai AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.a.c.materialButtonToggleGroupStyle);
    }

    public b(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i, b), attributeSet, i);
        this.c = new ArrayList();
        this.d = new a();
        this.e = new d();
        this.f = new LinkedHashSet<>();
        this.g = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.b.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(b.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(b.this.indexOfChild(materialButton2)));
            }
        };
        this.i = false;
        TypedArray typedArrayA = s.a(getContext(), attributeSet, com.google.android.material.a.o.MaterialButtonToggleGroup, i, b, new int[0]);
        setSingleSelection(typedArrayA.getBoolean(com.google.android.material.a.o.MaterialButtonToggleGroup_singleSelection, false));
        this.l = typedArrayA.getResourceId(com.google.android.material.a.o.MaterialButtonToggleGroup_checkedButton, -1);
        this.k = typedArrayA.getBoolean(com.google.android.material.a.o.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayA.recycle();
        af.e((View) this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(@ai View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof MaterialButton) && e(i2)) {
                i++;
            }
        }
        return -1;
    }

    @ai
    private C0084b a(int i, int i2, int i3) {
        C0084b c0084b = this.c.get(i);
        if (i2 == i3) {
            return c0084b;
        }
        boolean z = getOrientation() == 0;
        if (i == i2) {
            return z ? C0084b.a(c0084b, this) : C0084b.c(c0084b);
        }
        if (i == i3) {
            return z ? C0084b.b(c0084b, this) : C0084b.d(c0084b);
        }
        return null;
    }

    private void a(@w int i, boolean z) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof MaterialButton) {
            this.i = true;
            ((MaterialButton) viewFindViewById).setChecked(z);
            this.i = false;
        }
    }

    private static void a(o.a aVar, @ai C0084b c0084b) {
        if (c0084b == null) {
            aVar.a(0.0f);
        } else {
            aVar.b(c0084b.f1216a).e(c0084b.d).c(c0084b.b).d(c0084b.c);
        }
    }

    @ah
    private LinearLayout.LayoutParams b(@ah View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.k && checkedButtonIds.isEmpty()) {
            a(i, true);
            this.l = i;
            return false;
        }
        if (z && this.j) {
            checkedButtonIds.remove(Integer.valueOf(i));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                a(iIntValue, false);
                c(iIntValue, false);
            }
        }
        return true;
    }

    private MaterialButton c(int i) {
        return (MaterialButton) getChildAt(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@w int i, boolean z) {
        Iterator<c> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a(this, i, z);
        }
    }

    private void d(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            m.b(layoutParams, 0);
            m.a(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private boolean e(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private void f() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButtonC = c(i);
            int iMin = Math.min(materialButtonC.getStrokeWidth(), c(i - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsB = b(materialButtonC);
            if (getOrientation() == 0) {
                m.b(layoutParamsB, 0);
                m.a(layoutParamsB, -iMin);
            } else {
                layoutParamsB.bottomMargin = 0;
                layoutParamsB.topMargin = -iMin;
            }
            materialButtonC.setLayoutParams(layoutParamsB);
        }
        d(firstVisibleChildIndex);
    }

    private void f(int i) {
        a(i, true);
        b(i, true);
        setCheckedId(i);
    }

    private void g() {
        TreeMap treeMap = new TreeMap(this.g);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(c(i), Integer.valueOf(i));
        }
        this.h = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (e(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (e(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && e(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        this.l = i;
        c(i, true);
    }

    private void setGeneratedIdIfNeeded(@ah MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(af.a());
        }
    }

    private void setupButtonChild(@ah MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.d);
        materialButton.setOnPressedChangeListenerInternal(this.e);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void a() {
        this.i = true;
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButtonC = c(i);
            materialButtonC.setChecked(false);
            c(materialButtonC.getId(), false);
        }
        this.i = false;
        setCheckedId(-1);
    }

    public void a(@w int i) {
        if (i == this.l) {
            return;
        }
        f(i);
    }

    public void a(@ah c cVar) {
        this.f.add(cVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f1212a, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            b(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        o shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.c.add(new C0084b(shapeAppearanceModel.f(), shapeAppearanceModel.i(), shapeAppearanceModel.g(), shapeAppearanceModel.h()));
        af.a(materialButton, new androidx.core.n.a() { // from class: com.google.android.material.button.b.2
            @Override // androidx.core.n.a
            public void a(View view2, @ah androidx.core.n.a.d dVar) {
                super.a(view2, dVar);
                dVar.c(androidx.core.n.a.d.c.a(0, 1, b.this.a(view2), 1, false, ((MaterialButton) view2).isChecked()));
            }
        });
    }

    public void b() {
        this.f.clear();
    }

    public void b(@w int i) {
        a(i, false);
        b(i, false);
        this.l = -1;
        c(i, false);
    }

    public void b(@ah c cVar) {
        this.f.remove(cVar);
    }

    public boolean c() {
        return this.j;
    }

    public boolean d() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@ah Canvas canvas) {
        g();
        super.dispatchDraw(canvas);
    }

    @ax
    void e() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButtonC = c(i);
            if (materialButtonC.getVisibility() != 8) {
                o.a aVarN = materialButtonC.getShapeAppearanceModel().n();
                a(aVarN, a(i, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonC.setShapeAppearanceModel(aVarN.a());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @ah
    public CharSequence getAccessibilityClassName() {
        return b.class.getName();
    }

    @w
    public int getCheckedButtonId() {
        if (this.j) {
            return this.l;
        }
        return -1;
    }

    @ah
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButtonC = c(i);
            if (materialButtonC.isChecked()) {
                arrayList.add(Integer.valueOf(materialButtonC.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.h != null && i2 < this.h.length) {
            return this.h[i2].intValue();
        }
        Log.w(f1212a, "Child order wasn't updated");
        return i2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.l != -1) {
            f(this.l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@ah AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.n.a.d.a(accessibilityNodeInfo).b(androidx.core.n.a.d.b.a(1, getVisibleButtonCount(), false, c() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        e();
        f();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.b(this.d);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.c.remove(iIndexOfChild);
        }
        e();
        f();
    }

    public void setSelectionRequired(boolean z) {
        this.k = z;
    }

    public void setSingleSelection(@h int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.j != z) {
            this.j = z;
            a();
        }
    }
}
