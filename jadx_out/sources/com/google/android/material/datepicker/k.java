package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ak;
import androidx.annotation.ap;
import androidx.annotation.ax;
import androidx.core.n.af;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public final class k<S> extends t<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ax
    static final Object f1246a = "MONTHS_VIEW_GROUP_TAG";

    @ax
    static final Object b = "NAVIGATION_PREV_TAG";

    @ax
    static final Object c = "NAVIGATION_NEXT_TAG";

    @ax
    static final Object d = "SELECTOR_TOGGLE_TAG";
    private static final String f = "THEME_RES_ID_KEY";
    private static final String g = "GRID_SELECTOR_KEY";
    private static final String h = "CALENDAR_CONSTRAINTS_KEY";
    private static final String i = "CURRENT_MONTH_KEY";
    private static final int j = 3;

    @ai
    private p an;
    private a ao;
    private c ap;
    private RecyclerView aq;
    private RecyclerView ar;
    private View as;
    private View at;
    private int k;

    @ai
    private f<S> l;

    @ai
    private com.google.android.material.datepicker.a m;

    enum a {
        DAY,
        YEAR
    }

    interface b {
        void a(long j);
    }

    @ah
    static <T> k<T> a(f<T> fVar, int i2, @ah com.google.android.material.datepicker.a aVar) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f, i2);
        bundle.putParcelable(g, fVar);
        bundle.putParcelable(h, aVar);
        bundle.putParcelable(i, aVar.d());
        kVar.g(bundle);
        return kVar;
    }

    private void a(@ah View view, @ah final r rVar) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(com.google.android.material.a.h.month_navigation_fragment_toggle);
        materialButton.setTag(d);
        af.a(materialButton, new androidx.core.n.a() { // from class: com.google.android.material.datepicker.k.6
            @Override // androidx.core.n.a
            public void a(View view2, @ah androidx.core.n.a.d dVar) {
                super.a(view2, dVar);
                dVar.f(k.this.at.getVisibility() == 0 ? k.this.b(com.google.android.material.a.m.mtrl_picker_toggle_to_year_selection) : k.this.b(com.google.android.material.a.m.mtrl_picker_toggle_to_day_selection));
            }
        });
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(com.google.android.material.a.h.month_navigation_previous);
        materialButton2.setTag(b);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(com.google.android.material.a.h.month_navigation_next);
        materialButton3.setTag(c);
        this.as = view.findViewById(com.google.android.material.a.h.mtrl_calendar_year_selector_frame);
        this.at = view.findViewById(com.google.android.material.a.h.mtrl_calendar_day_selector_frame);
        a(a.DAY);
        materialButton.setText(this.an.d());
        this.ar.a(new RecyclerView.n() { // from class: com.google.android.material.datepicker.k.7
            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void a(@ah RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    CharSequence text = materialButton.getText();
                    if (Build.VERSION.SDK_INT >= 16) {
                        recyclerView.announceForAccessibility(text);
                    } else {
                        recyclerView.sendAccessibilityEvent(2048);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void a(@ah RecyclerView recyclerView, int i2, int i3) {
                int iU = i2 < 0 ? k.this.i().u() : k.this.i().w();
                k.this.an = rVar.g(iU);
                materialButton.setText(rVar.a(iU));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.h();
            }
        });
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iU = k.this.i().u() + 1;
                if (iU < k.this.ar.getAdapter().a()) {
                    k.this.a(rVar.g(iU));
                }
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iW = k.this.i().w() - 1;
                if (iW >= 0) {
                    k.this.a(rVar.g(iW));
                }
            }
        });
    }

    @ah
    private RecyclerView.h aK() {
        return new RecyclerView.h() { // from class: com.google.android.material.datepicker.k.5
            private final Calendar b = y.c();
            private final Calendar c = y.c();

            @Override // androidx.recyclerview.widget.RecyclerView.h
            public void a(@ah Canvas canvas, @ah RecyclerView recyclerView, @ah RecyclerView.w wVar) {
                if ((recyclerView.getAdapter() instanceof z) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    z zVar = (z) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (androidx.core.m.f<Long, Long> fVar : k.this.l.d()) {
                        if (fVar.f503a != null && fVar.b != null) {
                            this.b.setTimeInMillis(fVar.f503a.longValue());
                            this.c.setTimeInMillis(fVar.b.longValue());
                            int iA = zVar.a(this.b.get(1));
                            int iA2 = zVar.a(this.c.get(1));
                            View viewC = gridLayoutManager.c(iA);
                            View viewC2 = gridLayoutManager.c(iA2);
                            int iC = iA / gridLayoutManager.c();
                            int iC2 = iA2 / gridLayoutManager.c();
                            int i2 = iC;
                            while (i2 <= iC2) {
                                View viewC3 = gridLayoutManager.c(gridLayoutManager.c() * i2);
                                if (viewC3 != null) {
                                    canvas.drawRect(i2 == iC ? viewC.getLeft() + (viewC.getWidth() / 2) : 0, viewC3.getTop() + k.this.ap.d.c(), i2 == iC2 ? viewC2.getLeft() + (viewC2.getWidth() / 2) : recyclerView.getWidth(), viewC3.getBottom() - k.this.ap.d.d(), k.this.ap.h);
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        };
    }

    @ak
    static int b(@ah Context context) {
        return context.getResources().getDimensionPixelSize(com.google.android.material.a.f.mtrl_calendar_day_height);
    }

    private void e(final int i2) {
        this.ar.post(new Runnable() { // from class: com.google.android.material.datepicker.k.2
            @Override // java.lang.Runnable
            public void run() {
                k.this.ar.g(i2);
            }
        });
    }

    @Override // androidx.fragment.app.d
    @ah
    public View a(@ah LayoutInflater layoutInflater, @ai ViewGroup viewGroup, @ai Bundle bundle) {
        int i2;
        final int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(y(), this.k);
        this.ap = new c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        p pVarB = this.m.b();
        if (l.b((Context) contextThemeWrapper)) {
            i2 = com.google.android.material.a.k.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = com.google.android.material.a.k.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(com.google.android.material.a.h.mtrl_calendar_days_of_week);
        af.a(gridView, new androidx.core.n.a() { // from class: com.google.android.material.datepicker.k.1
            @Override // androidx.core.n.a
            public void a(View view, @ah androidx.core.n.a.d dVar) {
                super.a(view, dVar);
                dVar.b((Object) null);
            }
        });
        gridView.setAdapter((ListAdapter) new j());
        gridView.setNumColumns(pVarB.c);
        gridView.setEnabled(false);
        this.ar = (RecyclerView) viewInflate.findViewById(com.google.android.material.a.h.mtrl_calendar_months);
        this.ar.setLayoutManager(new w(y(), i3, false) { // from class: com.google.android.material.datepicker.k.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected void a(@ah RecyclerView.w wVar, @ah int[] iArr) {
                if (i3 == 0) {
                    iArr[0] = k.this.ar.getWidth();
                    iArr[1] = k.this.ar.getWidth();
                } else {
                    iArr[0] = k.this.ar.getHeight();
                    iArr[1] = k.this.ar.getHeight();
                }
            }
        });
        this.ar.setTag(f1246a);
        r rVar = new r(contextThemeWrapper, this.l, this.m, new b() { // from class: com.google.android.material.datepicker.k.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.material.datepicker.k.b
            public void a(long j2) {
                if (k.this.m.a().a(j2)) {
                    k.this.l.a(j2);
                    Iterator<s<S>> it = k.this.e.iterator();
                    while (it.hasNext()) {
                        it.next().a(k.this.l.a());
                    }
                    k.this.ar.getAdapter().e();
                    if (k.this.aq != null) {
                        k.this.aq.getAdapter().e();
                    }
                }
            }
        });
        this.ar.setAdapter(rVar);
        int integer = contextThemeWrapper.getResources().getInteger(com.google.android.material.a.i.mtrl_calendar_year_selector_span);
        this.aq = (RecyclerView) viewInflate.findViewById(com.google.android.material.a.h.mtrl_calendar_year_selector_frame);
        if (this.aq != null) {
            this.aq.setHasFixedSize(true);
            this.aq.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.aq.setAdapter(new z(this));
            this.aq.a(aK());
        }
        if (viewInflate.findViewById(com.google.android.material.a.h.month_navigation_fragment_toggle) != null) {
            a(viewInflate, rVar);
        }
        if (!l.b((Context) contextThemeWrapper)) {
            new androidx.recyclerview.widget.r().a(this.ar);
        }
        this.ar.e(rVar.a(this.an));
        return viewInflate;
    }

    @ai
    p a() {
        return this.an;
    }

    void a(a aVar) {
        this.ao = aVar;
        if (aVar == a.YEAR) {
            this.aq.getLayoutManager().e(((z) this.aq.getAdapter()).a(this.an.b));
            this.as.setVisibility(0);
            this.at.setVisibility(8);
        } else if (aVar == a.DAY) {
            this.as.setVisibility(8);
            this.at.setVisibility(0);
            a(this.an);
        }
    }

    void a(p pVar) {
        r rVar = (r) this.ar.getAdapter();
        int iA = rVar.a(pVar);
        int iA2 = iA - rVar.a(this.an);
        boolean z = Math.abs(iA2) > 3;
        boolean z2 = iA2 > 0;
        this.an = pVar;
        if (z && z2) {
            this.ar.e(iA - 3);
            e(iA);
        } else if (!z) {
            e(iA);
        } else {
            this.ar.e(iA + 3);
            e(iA);
        }
    }

    @ai
    com.google.android.material.datepicker.a b() {
        return this.m;
    }

    @Override // androidx.fragment.app.d
    public void b(@ai Bundle bundle) {
        super.b(bundle);
        if (bundle == null) {
            bundle = t();
        }
        this.k = bundle.getInt(f);
        this.l = (f) bundle.getParcelable(g);
        this.m = (com.google.android.material.datepicker.a) bundle.getParcelable(h);
        this.an = (p) bundle.getParcelable(i);
    }

    @Override // com.google.android.material.datepicker.t
    @ai
    public f<S> e() {
        return this.l;
    }

    @Override // androidx.fragment.app.d
    public void e(@ah Bundle bundle) {
        super.e(bundle);
        bundle.putInt(f, this.k);
        bundle.putParcelable(g, this.l);
        bundle.putParcelable(h, this.m);
        bundle.putParcelable(i, this.an);
    }

    c g() {
        return this.ap;
    }

    void h() {
        if (this.ao == a.YEAR) {
            a(a.DAY);
        } else if (this.ao == a.DAY) {
            a(a.YEAR);
        }
    }

    @ah
    LinearLayoutManager i() {
        return (LinearLayoutManager) this.ar.getLayoutManager();
    }
}
