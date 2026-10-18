package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ai;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class y extends androidx.core.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RecyclerView f1102a;
    private final a b;

    public static class a extends androidx.core.n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final y f1103a;
        private Map<View, androidx.core.n.a> b = new WeakHashMap();

        public a(@androidx.annotation.ah y yVar) {
            this.f1103a = yVar;
        }

        @Override // androidx.core.n.a
        @ai
        public androidx.core.n.a.e a(@androidx.annotation.ah View view) {
            androidx.core.n.a aVar = this.b.get(view);
            return aVar != null ? aVar.a(view) : super.a(view);
        }

        @Override // androidx.core.n.a
        public void a(@androidx.annotation.ah View view, int i) {
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.a(view, i);
            } else {
                super.a(view, i);
            }
        }

        @Override // androidx.core.n.a
        public void a(@androidx.annotation.ah View view, @androidx.annotation.ah AccessibilityEvent accessibilityEvent) {
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.a(view, accessibilityEvent);
            } else {
                super.a(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.n.a
        public void a(View view, androidx.core.n.a.d dVar) {
            if (this.f1103a.b() || this.f1103a.f1102a.getLayoutManager() == null) {
                super.a(view, dVar);
                return;
            }
            this.f1103a.f1102a.getLayoutManager().a(view, dVar);
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.a(view, dVar);
            } else {
                super.a(view, dVar);
            }
        }

        @Override // androidx.core.n.a
        public boolean a(View view, int i, Bundle bundle) {
            if (this.f1103a.b() || this.f1103a.f1102a.getLayoutManager() == null) {
                return super.a(view, i, bundle);
            }
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                if (aVar.a(view, i, bundle)) {
                    return true;
                }
            } else if (super.a(view, i, bundle)) {
                return true;
            }
            return this.f1103a.f1102a.getLayoutManager().a(view, i, bundle);
        }

        @Override // androidx.core.n.a
        public boolean a(@androidx.annotation.ah ViewGroup viewGroup, @androidx.annotation.ah View view, @androidx.annotation.ah AccessibilityEvent accessibilityEvent) {
            androidx.core.n.a aVar = this.b.get(viewGroup);
            return aVar != null ? aVar.a(viewGroup, view, accessibilityEvent) : super.a(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.n.a
        public boolean b(@androidx.annotation.ah View view, @androidx.annotation.ah AccessibilityEvent accessibilityEvent) {
            androidx.core.n.a aVar = this.b.get(view);
            return aVar != null ? aVar.b(view, accessibilityEvent) : super.b(view, accessibilityEvent);
        }

        void c(View view) {
            androidx.core.n.a aVarE = androidx.core.n.af.e(view);
            if (aVarE == null || aVarE == this) {
                return;
            }
            this.b.put(view, aVarE);
        }

        @Override // androidx.core.n.a
        public void c(@androidx.annotation.ah View view, @androidx.annotation.ah AccessibilityEvent accessibilityEvent) {
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                super.c(view, accessibilityEvent);
            }
        }

        androidx.core.n.a d(View view) {
            return this.b.remove(view);
        }

        @Override // androidx.core.n.a
        public void d(@androidx.annotation.ah View view, @androidx.annotation.ah AccessibilityEvent accessibilityEvent) {
            androidx.core.n.a aVar = this.b.get(view);
            if (aVar != null) {
                aVar.d(view, accessibilityEvent);
            } else {
                super.d(view, accessibilityEvent);
            }
        }
    }

    public y(@androidx.annotation.ah RecyclerView recyclerView) {
        this.f1102a = recyclerView;
        androidx.core.n.a aVarC = c();
        if (aVarC == null || !(aVarC instanceof a)) {
            this.b = new a(this);
        } else {
            this.b = (a) aVarC;
        }
    }

    @Override // androidx.core.n.a
    public void a(View view, androidx.core.n.a.d dVar) {
        super.a(view, dVar);
        if (b() || this.f1102a.getLayoutManager() == null) {
            return;
        }
        this.f1102a.getLayoutManager().a(dVar);
    }

    @Override // androidx.core.n.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (b() || this.f1102a.getLayoutManager() == null) {
            return false;
        }
        return this.f1102a.getLayoutManager().a(i, bundle);
    }

    boolean b() {
        return this.f1102a.B();
    }

    @androidx.annotation.ah
    public androidx.core.n.a c() {
        return this.b;
    }

    @Override // androidx.core.n.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || b()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }
}
