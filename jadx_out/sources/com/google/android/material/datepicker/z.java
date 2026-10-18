package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class z extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<?> f1278a;

    public static class a extends RecyclerView.z {
        final TextView E;

        a(TextView textView) {
            super(textView);
            this.E = textView;
        }
    }

    z(k<?> kVar) {
        this.f1278a = kVar;
    }

    @ah
    private View.OnClickListener h(final int i) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.z.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.f1278a.a(z.this.f1278a.b().a(p.a(i, z.this.f1278a.a().f1266a)));
                z.this.f1278a.a(k.a.DAY);
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f1278a.b().f();
    }

    int a(int i) {
        return i - this.f1278a.b().b().b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(@ah a aVar, int i) {
        int iG = g(i);
        String string = aVar.E.getContext().getString(com.google.android.material.a.m.mtrl_picker_navigate_to_year_description);
        aVar.E.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iG)));
        aVar.E.setContentDescription(String.format(string, Integer.valueOf(iG)));
        c cVarG = this.f1278a.g();
        Calendar calendarB = y.b();
        b bVar = calendarB.get(1) == iG ? cVarG.f : cVarG.d;
        Iterator<Long> it = this.f1278a.e().c().iterator();
        while (it.hasNext()) {
            calendarB.setTimeInMillis(it.next().longValue());
            if (calendarB.get(1) == iG) {
                bVar = cVarG.e;
            }
        }
        bVar.a(aVar.E);
        aVar.E.setOnClickListener(h(iG));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    @ah
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a(@ah ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.a.k.mtrl_calendar_year, viewGroup, false));
    }

    int g(int i) {
        return this.f1278a.b().b().b + i;
    }
}
