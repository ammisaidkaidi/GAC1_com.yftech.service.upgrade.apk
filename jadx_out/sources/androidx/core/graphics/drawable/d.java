package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f428a = "RoundedBitmapDrawableFa";

    private static class a extends b {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // androidx.core.graphics.drawable.b
        void a(int i, int i2, int i3, Rect rect, Rect rect2) {
            androidx.core.n.h.a(i, i2, i3, rect, rect2, 0);
        }

        @Override // androidx.core.graphics.drawable.b
        public void a(boolean z) {
            if (this.f427a != null) {
                androidx.core.graphics.a.a(this.f427a, z);
                invalidateSelf();
            }
        }

        @Override // androidx.core.graphics.drawable.b
        public boolean d() {
            return this.f427a != null && androidx.core.graphics.a.a(this.f427a);
        }
    }

    private d() {
    }

    @ah
    public static b a(@ah Resources resources, @ai Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 21 ? new c(resources, bitmap) : new a(resources, bitmap);
    }

    @ah
    public static b a(@ah Resources resources, @ah InputStream inputStream) {
        b bVarA = a(resources, BitmapFactory.decodeStream(inputStream));
        if (bVarA.b() == null) {
            Log.w(f428a, "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return bVarA;
    }

    @ah
    public static b a(@ah Resources resources, @ah String str) {
        b bVarA = a(resources, BitmapFactory.decodeFile(str));
        if (bVarA.b() == null) {
            Log.w(f428a, "RoundedBitmapDrawable cannot decode " + str);
        }
        return bVarA;
    }
}
