package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.ap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f135a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f135a = gVar;
        this.f = i;
        c();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j getItem(int i) {
        ArrayList<j> arrayListN = this.d ? this.f135a.n() : this.f135a.k();
        if (this.b >= 0 && i >= this.b) {
            i++;
        }
        return arrayListN.get(i);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    public g b() {
        return this.f135a;
    }

    void c() {
        j jVarT = this.f135a.t();
        if (jVarT != null) {
            ArrayList<j> arrayListN = this.f135a.n();
            int size = arrayListN.size();
            for (int i = 0; i < size; i++) {
                if (arrayListN.get(i) == jVarT) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<j> arrayListN = this.d ? this.f135a.n() : this.f135a.k();
        return this.b < 0 ? arrayListN.size() : arrayListN.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f135a.b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        o.a aVar = (o.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        c();
        super.notifyDataSetChanged();
    }
}
