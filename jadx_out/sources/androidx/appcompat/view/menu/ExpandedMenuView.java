package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.ap;
import androidx.appcompat.widget.ba;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, g.b, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f122a = {R.attr.background, R.attr.divider};
    private g b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ba baVarA = ba.a(context, attributeSet, f122a, i, 0);
        if (baVarA.j(0)) {
            setBackgroundDrawable(baVarA.a(0));
        }
        if (baVarA.j(1)) {
            setDivider(baVarA.a(1));
        }
        baVarA.f();
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(g gVar) {
        this.b = gVar;
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(j jVar) {
        return this.b.a(jVar, 0);
    }

    @Override // androidx.appcompat.view.menu.o
    public int getWindowAnimations() {
        return this.c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((j) getAdapter().getItem(i));
    }
}
