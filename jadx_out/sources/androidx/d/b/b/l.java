package androidx.d.b.b;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
abstract class l extends e {
    protected static final float N = 20.0f;
    int O = f606a;

    l() {
    }

    abstract float a();

    abstract void a(int i, int i2, float f, float f2, float f3, float f4);

    abstract void a(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr);

    @Override // androidx.d.b.b.e
    void a(HashSet<String> hashSet) {
    }

    public abstract boolean a(int i, int i2, RectF rectF, RectF rectF2, float f, float f2);

    abstract float b();
}
