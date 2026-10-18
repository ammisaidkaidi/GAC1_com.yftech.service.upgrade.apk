package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i implements a.b {
    public static final Parcelable.Creator<i> CREATOR = new Parcelable.Creator<i>() { // from class: com.google.android.material.datepicker.i.1
        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(@ah Parcel parcel) {
            return new i(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i) {
            return new i[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1244a;

    private i(long j) {
        this.f1244a = j;
    }

    @ah
    public static i a() {
        return b(y.b().getTimeInMillis());
    }

    @ah
    public static i b(long j) {
        return new i(j);
    }

    @Override // com.google.android.material.datepicker.a.b
    public boolean a(long j) {
        return j >= this.f1244a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f1244a == ((i) obj).f1244a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f1244a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@ah Parcel parcel, int i) {
        parcel.writeLong(this.f1244a);
    }
}
