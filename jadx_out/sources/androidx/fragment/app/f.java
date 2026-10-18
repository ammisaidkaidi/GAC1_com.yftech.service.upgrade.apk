package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    @ai
    public abstract View a(@androidx.annotation.w int i);

    @ah
    @Deprecated
    public d a(@ah Context context, @ah String str, @ai Bundle bundle) {
        return d.a(context, str, bundle);
    }

    public abstract boolean a();
}
