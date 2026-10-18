package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements AdapterView.OnItemClickListener, n, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f144a;

    l() {
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup frameLayout = viewGroup;
        int i2 = 0;
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    protected static f a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (f) listAdapter;
    }

    protected static boolean b(g gVar) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public o a(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public abstract void a(int i);

    @Override // androidx.appcompat.view.menu.n
    public void a(@ah Context context, @ai g gVar) {
    }

    public void a(Rect rect) {
        this.f144a = rect;
    }

    public abstract void a(View view);

    public abstract void a(PopupWindow.OnDismissListener onDismissListener);

    public abstract void a(g gVar);

    @Override // androidx.appcompat.view.menu.n
    public boolean a(g gVar, j jVar) {
        return false;
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    @Override // androidx.appcompat.view.menu.n
    public boolean b(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public int c() {
        return 0;
    }

    public abstract void c(int i);

    public abstract void c(boolean z);

    protected boolean h() {
        return true;
    }

    public Rect i() {
        return this.f144a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f135a.a((MenuItem) listAdapter.getItem(i), this, h() ? 0 : 4);
    }
}
