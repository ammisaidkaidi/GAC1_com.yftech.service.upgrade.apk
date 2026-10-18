package androidx.j;

import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
class bh implements bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f880a;

    bh(IBinder iBinder) {
        this.f880a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof bh) && ((bh) obj).f880a.equals(this.f880a);
    }

    public int hashCode() {
        return this.f880a.hashCode();
    }
}
