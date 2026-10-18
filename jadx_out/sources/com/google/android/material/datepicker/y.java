package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f1277a = "UTC";
    static AtomicReference<x> b = new AtomicReference<>();

    private y() {
    }

    private static int a(@ah String str, @ah String str2, int i, int i2) {
        while (i2 >= 0 && i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            if (str.charAt(i2) == '\'') {
                i2 += i;
                while (i2 >= 0 && i2 < str.length() && str.charAt(i2) != '\'') {
                    i2 += i;
                }
            }
            i2 += i;
        }
        return i2;
    }

    static long a(long j) {
        Calendar calendarC = c();
        calendarC.setTimeInMillis(j);
        return b(calendarC).getTimeInMillis();
    }

    @TargetApi(24)
    private static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(j());
        return instanceForSkeleton;
    }

    @TargetApi(24)
    static DateFormat a(Locale locale) {
        return a("yMMMd", locale);
    }

    static x a() {
        x xVar = b.get();
        return xVar == null ? x.a() : xVar;
    }

    static String a(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(com.google.android.material.a.m.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(com.google.android.material.a.m.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(com.google.android.material.a.m.mtrl_picker_text_input_year_abbr));
    }

    private static java.text.DateFormat a(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(i());
        return dateInstance;
    }

    static SimpleDateFormat a(String str) {
        return b(str, Locale.getDefault());
    }

    static Calendar a(@ai Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(i());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    static void a(@ai x xVar) {
        b.set(xVar);
    }

    @TargetApi(24)
    static DateFormat b(Locale locale) {
        return a("MMMd", locale);
    }

    @ah
    private static String b(@ah String str) {
        int iA = a(str, "yY", 1, 0);
        if (iA >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int iA2 = a(str, "EMd", 1, iA);
        if (iA2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(a(str, str2, -1, iA) + 1, iA2), " ").trim();
    }

    private static SimpleDateFormat b(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(i());
        return simpleDateFormat;
    }

    static Calendar b() {
        Calendar calendarB = a().b();
        calendarB.set(11, 0);
        calendarB.set(12, 0);
        calendarB.set(13, 0);
        calendarB.set(14, 0);
        calendarB.setTimeZone(i());
        return calendarB;
    }

    static Calendar b(Calendar calendar) {
        Calendar calendarA = a(calendar);
        Calendar calendarC = c();
        calendarC.set(calendarA.get(1), calendarA.get(2), calendarA.get(5));
        return calendarC;
    }

    @TargetApi(24)
    static DateFormat c(Locale locale) {
        return a("MMMEd", locale);
    }

    static Calendar c() {
        return a((Calendar) null);
    }

    @TargetApi(24)
    static DateFormat d(Locale locale) {
        return a("yMMMEd", locale);
    }

    static SimpleDateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", com.yftech.service.upgrade.a.d), Locale.getDefault());
        simpleDateFormat.setTimeZone(i());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static java.text.DateFormat e() {
        return e(Locale.getDefault());
    }

    static java.text.DateFormat e(Locale locale) {
        return a(2, locale);
    }

    static java.text.DateFormat f() {
        return f(Locale.getDefault());
    }

    static java.text.DateFormat f(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) e(locale);
        simpleDateFormat.applyPattern(b(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    static java.text.DateFormat g() {
        return g(Locale.getDefault());
    }

    static java.text.DateFormat g(Locale locale) {
        return a(0, locale);
    }

    static SimpleDateFormat h() {
        return h(Locale.getDefault());
    }

    private static SimpleDateFormat h(Locale locale) {
        return b("LLLL, yyyy", locale);
    }

    private static TimeZone i() {
        return TimeZone.getTimeZone(f1277a);
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone j() {
        return android.icu.util.TimeZone.getTimeZone(f1277a);
    }
}
