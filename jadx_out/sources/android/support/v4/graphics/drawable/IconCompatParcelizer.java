package android.support.v4.graphics.drawable;

import androidx.annotation.ap;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.e;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY})
public final class IconCompatParcelizer extends androidx.core.graphics.drawable.IconCompatParcelizer {
    public static IconCompat read(e eVar) {
        return androidx.core.graphics.drawable.IconCompatParcelizer.read(eVar);
    }

    public static void write(IconCompat iconCompat, e eVar) {
        androidx.core.graphics.drawable.IconCompatParcelizer.write(iconCompat, eVar);
    }
}
