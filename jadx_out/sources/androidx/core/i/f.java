package androidx.core.i;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.aq;
import androidx.annotation.z;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f450a = a(new Locale[0]);
    private h b;

    private f(h hVar) {
        this.b = hVar;
    }

    @am(a = 24)
    @ah
    public static f a(@ah LocaleList localeList) {
        return new f(new i(localeList));
    }

    @am(a = 24)
    @Deprecated
    public static f a(Object obj) {
        return a((LocaleList) obj);
    }

    @ah
    public static f a(@ai String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(",", -1);
        Locale[] localeArr = new Locale[strArrSplit.length];
        for (int i = 0; i < localeArr.length; i++) {
            localeArr[i] = Build.VERSION.SDK_INT >= 21 ? Locale.forLanguageTag(strArrSplit[i]) : b(strArrSplit[i]);
        }
        return a(localeArr);
    }

    @ah
    public static f a(@ah Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? a(new LocaleList(localeArr)) : new f(new g(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @ah
    public static f e() {
        return f450a;
    }

    @aq(b = 1)
    @ah
    public static f f() {
        return Build.VERSION.SDK_INT >= 24 ? a(LocaleList.getAdjustedDefault()) : a(Locale.getDefault());
    }

    @aq(b = 1)
    @ah
    public static f g() {
        return Build.VERSION.SDK_INT >= 24 ? a(LocaleList.getDefault()) : a(Locale.getDefault());
    }

    @z(a = RecyclerView.m)
    public int a(Locale locale) {
        return this.b.a(locale);
    }

    @ai
    public Object a() {
        return this.b.a();
    }

    public Locale a(int i) {
        return this.b.a(i);
    }

    @ai
    public Locale a(@ah String[] strArr) {
        return this.b.a(strArr);
    }

    public boolean b() {
        return this.b.b();
    }

    @z(a = FabTransformationScrimBehavior.c)
    public int c() {
        return this.b.c();
    }

    @ah
    public String d() {
        return this.b.d();
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.b.equals(((f) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString();
    }
}
