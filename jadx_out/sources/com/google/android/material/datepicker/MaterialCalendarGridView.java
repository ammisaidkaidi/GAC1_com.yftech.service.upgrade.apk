package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.core.n.af;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f1235a;

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1235a = y.c();
        if (l.b(getContext())) {
            setNextFocusLeftId(com.google.android.material.a.h.cancel_button);
            setNextFocusRightId(com.google.android.material.a.h.confirm_button);
        }
        af.a(this, new androidx.core.n.a() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.n.a
            public void a(View view, @ah androidx.core.n.a.d dVar) {
                super.a(view, dVar);
                dVar.b((Object) null);
            }
        });
    }

    private static int a(@ah View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private void a(int i, Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().b());
        } else if (i == 130) {
            setSelection(getAdapter().a());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private static boolean a(@ai Long l, @ai Long l2, @ai Long l3, @ai Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @ah
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public q getAdapter() {
        return (q) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@ah Canvas canvas) {
        int iC;
        int iA;
        int iC2;
        int iA2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        q adapter = getAdapter();
        f<?> fVar = adapter.c;
        c cVar = adapter.d;
        Long item = adapter.getItem(adapter.a());
        Long item2 = adapter.getItem(adapter.b());
        for (androidx.core.m.f<Long, Long> fVar2 : fVar.d()) {
            if (fVar2.f503a != null) {
                if (fVar2.b == null) {
                    continue;
                } else {
                    long jLongValue = fVar2.f503a.longValue();
                    long jLongValue2 = fVar2.b.longValue();
                    if (a(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        return;
                    }
                    if (jLongValue < item.longValue()) {
                        iC = adapter.a();
                        iA = adapter.e(iC) ? 0 : materialCalendarGridView.getChildAt(iC - 1).getRight();
                    } else {
                        materialCalendarGridView.f1235a.setTimeInMillis(jLongValue);
                        iC = adapter.c(materialCalendarGridView.f1235a.get(5));
                        iA = a(materialCalendarGridView.getChildAt(iC));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iC2 = Math.min(adapter.b(), getChildCount() - 1);
                        iA2 = adapter.f(iC2) ? getWidth() : materialCalendarGridView.getChildAt(iC2).getRight();
                    } else {
                        materialCalendarGridView.f1235a.setTimeInMillis(jLongValue2);
                        iC2 = adapter.c(materialCalendarGridView.f1235a.get(5));
                        iA2 = a(materialCalendarGridView.getChildAt(iC2));
                    }
                    int itemId = (int) adapter.getItemId(iC);
                    int itemId2 = (int) adapter.getItemId(iC2);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > iC ? 0 : iA, childAt.getTop() + cVar.f1240a.c(), iC2 > numColumns2 ? getWidth() : iA2, childAt.getBottom() - cVar.f1240a.d(), cVar.h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            a(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof q)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), q.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().a()) {
            super.setSelection(getAdapter().a());
        } else {
            super.setSelection(i);
        }
    }
}
