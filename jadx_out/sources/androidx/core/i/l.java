package androidx.core.i;

import android.os.Parcel;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private l() {
    }

    public static void a(@ah Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static boolean a(@ah Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
