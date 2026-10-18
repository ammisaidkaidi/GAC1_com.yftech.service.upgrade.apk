package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>() { // from class: androidx.fragment.app.m.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<p> f778a;
    ArrayList<String> b;
    b[] c;
    String d;
    int e;

    public m() {
        this.d = null;
    }

    public m(Parcel parcel) {
        this.d = null;
        this.f778a = parcel.createTypedArrayList(p.CREATOR);
        this.b = parcel.createStringArrayList();
        this.c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f778a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }
}
