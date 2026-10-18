package androidx.recyclerview.widget;

import androidx.annotation.ai;
import androidx.recyclerview.widget.RecyclerView.z;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s<T, VH extends RecyclerView.z> extends RecyclerView.a<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d<T> f1092a;
    private final d.a<T> b = new d.a<T>() { // from class: androidx.recyclerview.widget.s.1
        @Override // androidx.recyclerview.widget.d.a
        public void a(@androidx.annotation.ah List<T> list, @androidx.annotation.ah List<T> list2) {
            s.this.a(list, list2);
        }
    };

    protected s(@androidx.annotation.ah c<T> cVar) {
        this.f1092a = new d<>(new b(this), cVar);
        this.f1092a.a(this.b);
    }

    protected s(@androidx.annotation.ah i.c<T> cVar) {
        this.f1092a = new d<>(new b(this), new c.a(cVar).a());
        this.f1092a.a(this.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f1092a.a().size();
    }

    protected T a(int i) {
        return this.f1092a.a().get(i);
    }

    public void a(@ai List<T> list) {
        this.f1092a.a(list);
    }

    public void a(@ai List<T> list, @ai Runnable runnable) {
        this.f1092a.a(list, runnable);
    }

    public void a(@androidx.annotation.ah List<T> list, @androidx.annotation.ah List<T> list2) {
    }

    @androidx.annotation.ah
    public List<T> b() {
        return this.f1092a.a();
    }
}
