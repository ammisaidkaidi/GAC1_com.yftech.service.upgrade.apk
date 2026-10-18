package androidx.viewpager2.a;

import androidx.annotation.ah;
import androidx.annotation.ak;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends h.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    private final List<h.f> f1117a;

    b(int i) {
        this.f1117a = new ArrayList(i);
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.a.h.f
    public void a(int i) {
        try {
            Iterator<h.f> it = this.f1117a.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // androidx.viewpager2.a.h.f
    public void a(int i, float f, @ak int i2) {
        try {
            Iterator<h.f> it = this.f1117a.iterator();
            while (it.hasNext()) {
                it.next().a(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    void a(h.f fVar) {
        this.f1117a.add(fVar);
    }

    @Override // androidx.viewpager2.a.h.f
    public void b(int i) {
        try {
            Iterator<h.f> it = this.f1117a.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    void b(h.f fVar) {
        this.f1117a.remove(fVar);
    }
}
