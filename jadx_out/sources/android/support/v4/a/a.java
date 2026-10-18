package android.support.v4.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.a.a$a, reason: collision with other inner class name */
    public static class C0000a implements a {
        @Override // android.support.v4.a.a
        public void a(int i, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class b extends Binder implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f2a = 1;
        private static final String b = "android.support.v4.os.IResultReceiver";

        /* JADX INFO: renamed from: android.support.v4.a.a$b$a, reason: collision with other inner class name */
        private static class C0001a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static a f3a;
            private IBinder b;

            C0001a(IBinder iBinder) {
                this.b = iBinder;
            }

            public String a() {
                return b.b;
            }

            @Override // android.support.v4.a.a
            public void a(int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(b.b);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (this.b.transact(1, parcelObtain, null, 1) || b.a() == null) {
                        return;
                    }
                    b.a().a(i, bundle);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public b() {
            attachInterface(this, b);
        }

        public static a a() {
            return C0001a.f3a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(b);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0001a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0001a.f3a != null || aVar == null) {
                return false;
            }
            C0001a.f3a = aVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(b);
                a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(b);
            return true;
        }
    }

    void a(int i, Bundle bundle);
}
