package androidx.e.a;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
class b extends Filter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    a f739a;

    interface a {
        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence b(Cursor cursor);

        Cursor c();
    }

    b(a aVar) {
        this.f739a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f739a.b((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorA = this.f739a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorA != null) {
            filterResults.count = cursorA.getCount();
            filterResults.values = cursorA;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorC = this.f739a.c();
        if (filterResults.values == null || filterResults.values == cursorC) {
            return;
        }
        this.f739a.a((Cursor) filterResults.values);
    }
}
