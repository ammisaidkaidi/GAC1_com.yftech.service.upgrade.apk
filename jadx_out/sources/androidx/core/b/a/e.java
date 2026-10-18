package androidx.core.b.a;

import androidx.annotation.ap;
import androidx.annotation.ay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public abstract class e<T> {

    @ap(a = {ap.a.LIBRARY})
    public static class a extends e<Void> {
        @Override // androidx.core.b.a.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void a() {
            return null;
        }

        @Override // androidx.core.b.a.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void a(List<d> list) {
            return null;
        }

        @Override // androidx.core.b.a.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void b(List<String> list) {
            return null;
        }
    }

    @androidx.annotation.d
    public abstract T a();

    @androidx.annotation.d
    public abstract T a(List<d> list);

    @androidx.annotation.d
    public abstract T b(List<String> list);

    @ay
    public List<d> b() {
        return new ArrayList();
    }
}
