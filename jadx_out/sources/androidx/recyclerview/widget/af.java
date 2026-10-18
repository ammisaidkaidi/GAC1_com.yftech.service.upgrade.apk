package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class af<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1033a;
    a<T> b;
    private final SparseArray<a<T>> c = new SparseArray<>(10);

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f1034a;
        public int b;
        public int c;
        a<T> d;

        public a(Class<T> cls, int i) {
            this.f1034a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }

        boolean a(int i) {
            return this.b <= i && i < this.b + this.c;
        }

        T b(int i) {
            return this.f1034a[i - this.b];
        }
    }

    public af(int i) {
        this.f1033a = i;
    }

    public int a() {
        return this.c.size();
    }

    public a<T> a(a<T> aVar) {
        int iIndexOfKey = this.c.indexOfKey(aVar.b);
        if (iIndexOfKey < 0) {
            this.c.put(aVar.b, aVar);
            return null;
        }
        a<T> aVarValueAt = this.c.valueAt(iIndexOfKey);
        this.c.setValueAt(iIndexOfKey, aVar);
        if (this.b == aVarValueAt) {
            this.b = aVar;
        }
        return aVarValueAt;
    }

    public T a(int i) {
        if (this.b == null || !this.b.a(i)) {
            int iIndexOfKey = this.c.indexOfKey(i - (i % this.f1033a));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.b = this.c.valueAt(iIndexOfKey);
        }
        return this.b.b(i);
    }

    public a<T> b(int i) {
        return this.c.valueAt(i);
    }

    public void b() {
        this.c.clear();
    }

    public a<T> c(int i) {
        a<T> aVar = this.c.get(i);
        if (this.b == aVar) {
            this.b = null;
        }
        this.c.delete(i);
        return aVar;
    }
}
