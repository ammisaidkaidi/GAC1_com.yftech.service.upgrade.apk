package android.support.v4.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: android.support.v4.a.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f4a;
    final Handler b;
    android.support.v4.a.a c;

    class a extends android.support.v4.a.a.b {
        a() {
        }

        @Override // android.support.v4.a.a
        public void a(int i, Bundle bundle) {
            if (b.this.b != null) {
                b.this.b.post(b.this.new RunnableC0002b(i, bundle));
            } else {
                b.this.b(i, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.a.b$b, reason: collision with other inner class name */
    class RunnableC0002b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f5a;
        final Bundle b;

        RunnableC0002b(int i, Bundle bundle) {
            this.f5a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f5a, this.b);
        }
    }

    public b(Handler handler) {
        this.f4a = true;
        this.b = handler;
    }

    b(Parcel parcel) {
        this.f4a = false;
        this.b = null;
        this.c = android.support.v4.a.a.b.a(parcel.readStrongBinder());
    }

    public void a(int i, Bundle bundle) {
        if (this.f4a) {
            if (this.b != null) {
                this.b.post(new RunnableC0002b(i, bundle));
                return;
            } else {
                b(i, bundle);
                return;
            }
        }
        if (this.c != null) {
            try {
                this.c.a(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    protected void b(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
