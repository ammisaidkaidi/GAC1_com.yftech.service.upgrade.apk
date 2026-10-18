package com.google.android.material.datepicker;

import android.os.Build;
import androidx.annotation.ai;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class g {
    private g() {
    }

    static androidx.core.m.f<String, String> a(@ai Long l, @ai Long l2) {
        return a(l, l2, null);
    }

    static androidx.core.m.f<String, String> a(@ai Long l, @ai Long l2, @ai SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return androidx.core.m.f.a(null, null);
        }
        if (l == null) {
            return androidx.core.m.f.a(null, a(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return androidx.core.m.f.a(a(l.longValue(), simpleDateFormat), null);
        }
        Calendar calendarB = y.b();
        Calendar calendarC = y.c();
        calendarC.setTimeInMillis(l.longValue());
        Calendar calendarC2 = y.c();
        calendarC2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.m.f.a(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        if (calendarC.get(1) == calendarC2.get(1)) {
            return calendarC.get(1) == calendarB.get(1) ? androidx.core.m.f.a(b(l.longValue(), Locale.getDefault()), b(l2.longValue(), Locale.getDefault())) : androidx.core.m.f.a(b(l.longValue(), Locale.getDefault()), a(l2.longValue(), Locale.getDefault()));
        }
        return androidx.core.m.f.a(a(l.longValue(), Locale.getDefault()), a(l2.longValue(), Locale.getDefault()));
    }

    static String a(long j) {
        return a(j, Locale.getDefault());
    }

    static String a(long j, @ai SimpleDateFormat simpleDateFormat) {
        Calendar calendarB = y.b();
        Calendar calendarC = y.c();
        calendarC.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        return calendarB.get(1) == calendarC.get(1) ? b(j) : a(j);
    }

    static String a(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.a(locale).format(new Date(j)) : y.e(locale).format(new Date(j));
    }

    static String b(long j) {
        return b(j, Locale.getDefault());
    }

    static String b(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.b(locale).format(new Date(j)) : y.f(locale).format(new Date(j));
    }

    static String c(long j) {
        return c(j, Locale.getDefault());
    }

    static String c(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.c(locale).format(new Date(j)) : y.g(locale).format(new Date(j));
    }

    static String d(long j) {
        return d(j, Locale.getDefault());
    }

    static String d(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.d(locale).format(new Date(j)) : y.g(locale).format(new Date(j));
    }

    static String e(long j) {
        return a(j, (SimpleDateFormat) null);
    }
}
