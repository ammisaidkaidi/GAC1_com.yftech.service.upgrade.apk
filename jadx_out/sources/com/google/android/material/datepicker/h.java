package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class h implements a.b {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: com.google.android.material.datepicker.h.1
        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(@ah Parcel parcel) {
            return new h(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i) {
            return new h[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f1243a;

    private h(long j) {
        this.f1243a = j;
    }

    @ah
    public static h a() {
        return b(y.b().getTimeInMillis());
    }

    @ah
    public static h b(long j) {
        return new h(j);
    }

    @Override // com.google.android.material.datepicker.a.b
    public boolean a(long j) {
        return j <= this.f1243a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f1243a == ((h) obj).f1243a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f1243a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@ah Parcel parcel, int i) {
        parcel.writeLong(this.f1243a);
    }
}
