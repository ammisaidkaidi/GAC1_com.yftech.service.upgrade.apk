package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.ah;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class m extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: com.google.android.material.internal.m.1
        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(@ah Parcel parcel) {
            int i = parcel.readInt();
            m mVar = new m(i);
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i2 = 0; i2 < i; i2++) {
                mVar.put(iArr[i2], iArr2[i2]);
            }
            return mVar;
        }

        @Override // android.os.Parcelable.Creator
        @ah
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    };

    public m() {
    }

    public m(int i) {
        super(i);
    }

    public m(@ah SparseIntArray sparseIntArray) {
        for (int i = 0; i < sparseIntArray.size(); i++) {
            put(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@ah Parcel parcel, int i) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            iArr2[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
