package androidx.coordinatorlayout.widget;

import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.c.i;
import androidx.core.m.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY})
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h.a<ArrayList<T>> f328a = new h.b(10);
    private final i<T, ArrayList<T>> b = new i<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.b.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                a(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }

    private void a(@ah ArrayList<T> arrayList) {
        arrayList.clear();
        this.f328a.a(arrayList);
    }

    @ah
    private ArrayList<T> d() {
        ArrayList<T> arrayListA = this.f328a.a();
        return arrayListA == null ? new ArrayList<>() : arrayListA;
    }

    public void a() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null) {
                a((ArrayList) arrayListC);
            }
        }
        this.b.clear();
    }

    public void a(@ah T t) {
        if (this.b.containsKey(t)) {
            return;
        }
        this.b.put(t, null);
    }

    public void a(@ah T t, @ah T t2) {
        if (!this.b.containsKey(t) || !this.b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListD = this.b.get(t);
        if (arrayListD == null) {
            arrayListD = d();
            this.b.put(t, arrayListD);
        }
        arrayListD.add(t2);
    }

    @ah
    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a(this.b.b(i), this.c, this.d);
        }
        return this.c;
    }

    public boolean b(@ah T t) {
        return this.b.containsKey(t);
    }

    int c() {
        return this.b.size();
    }

    @ai
    public List c(@ah T t) {
        return this.b.get(t);
    }

    @ai
    public List<T> d(@ah T t) {
        int size = this.b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(@ah T t) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> arrayListC = this.b.c(i);
            if (arrayListC != null && arrayListC.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
