package androidx.viewpager2.a;

import android.view.View;
import androidx.annotation.ai;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class f extends h.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f1121a;
    private h.i b;

    f(LinearLayoutManager linearLayoutManager) {
        this.f1121a = linearLayoutManager;
    }

    h.i a() {
        return this.b;
    }

    @Override // androidx.viewpager2.a.h.f
    public void a(int i) {
    }

    @Override // androidx.viewpager2.a.h.f
    public void a(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f1121a.H(); i3++) {
            View viewJ = this.f1121a.j(i3);
            if (viewJ == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f1121a.H())));
            }
            this.b.a(viewJ, (this.f1121a.e(viewJ) - i) + f2);
        }
    }

    void a(@ai h.i iVar) {
        this.b = iVar;
    }

    @Override // androidx.viewpager2.a.h.f
    public void b(int i) {
    }
}
