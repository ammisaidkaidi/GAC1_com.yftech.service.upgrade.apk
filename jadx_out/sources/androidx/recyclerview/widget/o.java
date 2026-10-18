package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final n f1089a = new o();

    o() {
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float fP = androidx.core.n.af.P(childAt);
                if (fP > f) {
                    f = fP;
                }
            }
        }
        return f;
    }

    @Override // androidx.recyclerview.widget.n
    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(androidx.recyclerview.a.e.item_touch_helper_previous_elevation) == null) {
            Float fValueOf = Float.valueOf(androidx.core.n.af.P(view));
            androidx.core.n.af.m(view, a(recyclerView, view) + 1.0f);
            view.setTag(androidx.recyclerview.a.e.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // androidx.recyclerview.widget.n
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(androidx.recyclerview.a.e.item_touch_helper_previous_elevation);
            if (tag instanceof Float) {
                androidx.core.n.af.m(view, ((Float) tag).floatValue());
            }
            view.setTag(androidx.recyclerview.a.e.item_touch_helper_previous_elevation, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
    }

    @Override // androidx.recyclerview.widget.n
    public void b(View view) {
    }
}
