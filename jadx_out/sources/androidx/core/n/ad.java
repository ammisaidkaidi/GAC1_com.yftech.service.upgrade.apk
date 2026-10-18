package androidx.core.n;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* JADX INFO: loaded from: classes.dex */
public interface ad {
    @androidx.annotation.ai
    ColorStateList getSupportBackgroundTintList();

    @androidx.annotation.ai
    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(@androidx.annotation.ai ColorStateList colorStateList);

    void setSupportBackgroundTintMode(@androidx.annotation.ai PorterDuff.Mode mode);
}
