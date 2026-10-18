package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.core.n.af;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class r extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    private final com.google.android.material.datepicker.a f1268a;
    private final f<?> b;
    private final k.b c;
    private final int d;

    public static class a extends RecyclerView.z {
        final TextView E;
        final MaterialCalendarGridView F;

        a(@ah LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.E = (TextView) linearLayout.findViewById(com.google.android.material.a.h.month_title);
            af.i((View) this.E, true);
            this.F = (MaterialCalendarGridView) linearLayout.findViewById(com.google.android.material.a.h.month_grid);
            if (z) {
                return;
            }
            this.E.setVisibility(8);
        }
    }

    r(@ah Context context, f<?> fVar, @ah com.google.android.material.datepicker.a aVar, k.b bVar) {
        p pVarB = aVar.b();
        p pVarC = aVar.c();
        p pVarD = aVar.d();
        if (pVarB.compareTo(pVarD) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (pVarD.compareTo(pVarC) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.d = (q.f1267a * k.b(context)) + (l.b(context) ? k.b(context) : 0);
        this.f1268a = aVar;
        this.b = fVar;
        this.c = bVar;
        a(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f1268a.e();
    }

    int a(@ah p pVar) {
        return this.f1268a.b().b(pVar);
    }

    @ah
    CharSequence a(int i) {
        return g(i).d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(@ah a aVar, int i) {
        p pVarB = this.f1268a.b().b(i);
        aVar.E.setText(pVarB.d());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.F.findViewById(com.google.android.material.a.h.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !pVarB.equals(materialCalendarGridView.getAdapter().b)) {
            q qVar = new q(pVarB, this.b, this.f1268a);
            materialCalendarGridView.setNumColumns(pVarB.c);
            materialCalendarGridView.setAdapter((ListAdapter) qVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.r.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (materialCalendarGridView.getAdapter().d(i2)) {
                    r.this.c.a(materialCalendarGridView.getAdapter().getItem(i2).longValue());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long c(int i) {
        return this.f1268a.b().b(i).c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    @ah
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a(@ah ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.a.k.mtrl_calendar_month_labeled, viewGroup, false);
        if (!l.b(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.j(-1, this.d));
        return new a(linearLayout, true);
    }

    @ah
    p g(int i) {
        return this.f1268a.b().b(i);
    }
}
