package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.ah;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class l extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: com.google.android.material.internal.l.1
        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(@ah Parcel parcel) {
            int i = parcel.readInt();
            l lVar = new l(i);
            int[] iArr = new int[i];
            boolean[] zArr = new boolean[i];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i2 = 0; i2 < i; i2++) {
                lVar.put(iArr[i2], zArr[i2]);
            }
            return lVar;
        }

        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    };

    public l() {
    }

    public l(int i) {
        super(i);
    }

    public l(@ah SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            put(sparseBooleanArray.keyAt(i), sparseBooleanArray.valueAt(i));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@ah Parcel parcel, int i) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            zArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
