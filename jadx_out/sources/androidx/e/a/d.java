package androidx.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ap(a = {ap.a.LIBRARY_GROUP})
    protected int[] f741a;

    @ap(a = {ap.a.LIBRARY_GROUP})
    protected int[] b;
    String[] c;
    private int d;
    private a p;
    private b q;

    public interface a {
        CharSequence a(Cursor cursor);
    }

    public interface b {
        boolean a(View view, Cursor cursor, int i);
    }

    @Deprecated
    public d(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.d = -1;
        this.b = iArr;
        this.c = strArr;
        a(cursor, strArr);
    }

    public d(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.d = -1;
        this.b = iArr;
        this.c = strArr;
        a(cursor, strArr);
    }

    private void a(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.f741a = null;
            return;
        }
        int length = strArr.length;
        if (this.f741a == null || this.f741a.length != length) {
            this.f741a = new int[length];
        }
        for (int i = 0; i < length; i++) {
            this.f741a[i] = cursor.getColumnIndexOrThrow(strArr[i]);
        }
    }

    public b a() {
        return this.q;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(Cursor cursor, String[] strArr, int[] iArr) {
        this.c = strArr;
        this.b = iArr;
        a(cursor, this.c);
        super.a(cursor);
    }

    @Override // androidx.e.a.a
    public void a(View view, Context context, Cursor cursor) {
        b bVar = this.q;
        int length = this.b.length;
        int[] iArr = this.f741a;
        int[] iArr2 = this.b;
        for (int i = 0; i < length; i++) {
            View viewFindViewById = view.findViewById(iArr2[i]);
            if (viewFindViewById != null) {
                if (bVar != null ? bVar.a(viewFindViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = com.yftech.service.upgrade.a.d;
                    }
                    if (viewFindViewById instanceof TextView) {
                        a((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        a((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    public void a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void a(TextView textView, String str) {
        textView.setText(str);
    }

    public void a(a aVar) {
        this.p = aVar;
    }

    public void a(b bVar) {
        this.q = bVar;
    }

    public int b() {
        return this.d;
    }

    @Override // androidx.e.a.a, androidx.e.a.b.a
    public CharSequence b(Cursor cursor) {
        if (this.p != null) {
            return this.p.a(cursor);
        }
        return this.d > -1 ? cursor.getString(this.d) : super.b(cursor);
    }

    @Override // androidx.e.a.a
    public Cursor c(Cursor cursor) {
        a(cursor, this.c);
        return super.c(cursor);
    }

    public a f() {
        return this.p;
    }
}
