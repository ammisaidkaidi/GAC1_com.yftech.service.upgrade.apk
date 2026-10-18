package androidx.i.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.core.i.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b extends a<Cursor> {
    final c<Cursor>.a h;
    Uri i;
    String[] j;
    String k;
    String[] l;
    String m;
    Cursor n;
    androidx.core.i.b o;

    public b(@ah Context context) {
        super(context);
        this.h = new c.a();
    }

    public b(@ah Context context, @ah Uri uri, @ai String[] strArr, @ai String str, @ai String[] strArr2, @ai String str2) {
        super(context);
        this.h = new c.a();
        this.i = uri;
        this.j = strArr;
        this.k = str;
        this.l = strArr2;
        this.m = str2;
    }

    @Override // androidx.i.b.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(Cursor cursor) {
        if (w()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.n;
        this.n = cursor;
        if (u()) {
            super.b(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    public void a(@ah Uri uri) {
        this.i = uri;
    }

    public void a(@ai String str) {
        this.k = str;
    }

    @Override // androidx.i.b.a, androidx.i.b.c
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.i);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.l));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.m);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.w);
    }

    public void a(@ai String[] strArr) {
        this.j = strArr;
    }

    @Override // androidx.i.b.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public void b(@ai String str) {
        this.m = str;
    }

    public void b(@ai String[] strArr) {
        this.l = strArr;
    }

    @Override // androidx.i.b.a
    public void f() {
        super.f();
        synchronized (this) {
            if (this.o != null) {
                this.o.c();
            }
        }
    }

    @Override // androidx.i.b.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Cursor d() {
        synchronized (this) {
            if (g()) {
                throw new k();
            }
            this.o = new androidx.core.i.b();
        }
        try {
            Cursor cursorA = androidx.core.b.b.a(s().getContentResolver(), this.i, this.j, this.k, this.l, this.m, this.o);
            if (cursorA != null) {
                try {
                    cursorA.getCount();
                    cursorA.registerContentObserver(this.h);
                } catch (RuntimeException e) {
                    cursorA.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.o = null;
            }
            return cursorA;
        } catch (Throwable th) {
            synchronized (this) {
                this.o = null;
                throw th;
            }
        }
    }

    @Override // androidx.i.b.c
    protected void j() {
        if (this.n != null) {
            b(this.n);
        }
        if (E() || this.n == null) {
            z();
        }
    }

    @Override // androidx.i.b.c
    protected void k() {
        y();
    }

    @Override // androidx.i.b.c
    protected void l() {
        super.l();
        k();
        if (this.n != null && !this.n.isClosed()) {
            this.n.close();
        }
        this.n = null;
    }

    @ah
    public Uri m() {
        return this.i;
    }

    @ai
    public String[] n() {
        return this.j;
    }

    @ai
    public String o() {
        return this.k;
    }

    @ai
    public String[] p() {
        return this.l;
    }

    @ai
    public String q() {
        return this.m;
    }
}
