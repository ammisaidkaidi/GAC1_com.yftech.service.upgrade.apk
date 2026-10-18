package androidx.viewpager2.a;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ah;
import androidx.annotation.ak;
import androidx.core.m.i;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class e implements h.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1120a;

    public e(@ak int i) {
        i.a(i, "Margin must be non-negative");
        this.f1120a = i;
    }

    private h a(@ah View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof h)) {
            return (h) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.a.h.i
    public void a(@ah View view, float f) {
        h hVarA = a(view);
        float f2 = this.f1120a * f;
        if (hVarA.getOrientation() != 0) {
            view.setTranslationY(f2);
            return;
        }
        if (hVarA.b()) {
            f2 = -f2;
        }
        view.setTranslationX(f2);
    }
}
