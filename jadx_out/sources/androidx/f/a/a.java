package androidx.f.a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Parcelable f742a;
    public static final a c = new a() { // from class: androidx.f.a.a.1
    };
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>() { // from class: androidx.f.a.a.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.c;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    };

    private a() {
        this.f742a = null;
    }

    protected a(@ah Parcel parcel) {
        this(parcel, null);
    }

    protected a(@ah Parcel parcel, @ai ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f742a = parcelable == null ? c : parcelable;
    }

    protected a(@ah Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f742a = parcelable == c ? null : parcelable;
    }

    @ai
    public final Parcelable a() {
        return this.f742a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f742a, i);
    }
}
