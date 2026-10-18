package androidx.core.widget;

import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public interface b {

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public static final boolean d;

    static {
        d = Build.VERSION.SDK_INT >= 27;
    }

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4);

    void setAutoSizeTextTypeUniformWithPresetSizes(@ah int[] iArr, int i);

    void setAutoSizeTextTypeWithDefaults(int i);
}
