package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public interface p {
    @ai
    ColorStateList getSupportImageTintList();

    @ai
    PorterDuff.Mode getSupportImageTintMode();

    void setSupportImageTintList(@ai ColorStateList colorStateList);

    void setSupportImageTintMode(@ai PorterDuff.Mode mode);
}
