package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ah;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
final class p implements Parcelable, Comparable<p> {
    public static final Parcelable.Creator<p> CREATOR = new Parcelable.Creator<p>() { // from class: com.google.android.material.datepicker.p.1
        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(@ah Parcel parcel) {
            return p.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i) {
            return new p[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f1266a;
    final int b;
    final int c;
    final int d;
    final long e;

    @ah
    private final Calendar f;

    @ah
    private final String g;

    private p(@ah Calendar calendar) {
        calendar.set(5, 1);
        this.f = y.b(calendar);
        this.f1266a = this.f.get(2);
        this.b = this.f.get(1);
        this.c = this.f.getMaximum(7);
        this.d = this.f.getActualMaximum(5);
        this.g = y.h().format(this.f.getTime());
        this.e = this.f.getTimeInMillis();
    }

    @ah
    static p a() {
        return new p(y.b());
    }

    @ah
    static p a(int i, int i2) {
        Calendar calendarC = y.c();
        calendarC.set(1, i);
        calendarC.set(2, i2);
        return new p(calendarC);
    }

    @ah
    static p a(long j) {
        Calendar calendarC = y.c();
        calendarC.setTimeInMillis(j);
        return new p(calendarC);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@ah p pVar) {
        return this.f.compareTo(pVar.f);
    }

    long a(int i) {
        Calendar calendarB = y.b(this.f);
        calendarB.set(5, i);
        return calendarB.getTimeInMillis();
    }

    int b() {
        int firstDayOfWeek = this.f.get(7) - this.f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.c : firstDayOfWeek;
    }

    int b(@ah p pVar) {
        if (this.f instanceof GregorianCalendar) {
            return ((pVar.b - this.b) * 12) + (pVar.f1266a - this.f1266a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @ah
    p b(int i) {
        Calendar calendarB = y.b(this.f);
        calendarB.add(2, i);
        return new p(calendarB);
    }

    long c() {
        return this.f.getTimeInMillis();
    }

    @ah
    String d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1266a == pVar.f1266a && this.b == pVar.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1266a), Integer.valueOf(this.b)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@ah Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.f1266a);
    }
}
