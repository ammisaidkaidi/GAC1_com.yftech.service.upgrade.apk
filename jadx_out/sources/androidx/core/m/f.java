package androidx.core.m;

import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class f<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ai
    public final F f503a;

    @ai
    public final S b;

    public f(@ai F f, @ai S s) {
        this.f503a = f;
        this.b = s;
    }

    @ah
    public static <A, B> f<A, B> a(@ai A a2, @ai B b) {
        return new f<>(a2, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return e.a(fVar.f503a, this.f503a) && e.a(fVar.b, this.b);
    }

    public int hashCode() {
        return (this.f503a == null ? 0 : this.f503a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    @ah
    public String toString() {
        return "Pair{" + String.valueOf(this.f503a) + " " + String.valueOf(this.b) + "}";
    }
}
