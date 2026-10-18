package androidx.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class y extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f917a;
    private final Path b = new Path();
    private final Matrix c = new Matrix();

    public y() {
        this.b.lineTo(1.0f, 0.0f);
        this.f917a = this.b;
    }

    @SuppressLint({"RestrictedApi"})
    public y(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, af.k);
        try {
            String strA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strA == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            a(androidx.core.graphics.h.a(strA));
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public y(Path path) {
        a(path);
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public Path a() {
        return this.f917a;
    }

    @Override // androidx.j.w
    public Path a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float fA = a(f5, f6);
        double dAtan2 = Math.atan2(f6, f5);
        this.c.setScale(fA, fA);
        this.c.postRotate((float) Math.toDegrees(dAtan2));
        this.c.postTranslate(f, f2);
        Path path = new Path();
        this.b.transform(this.c, path);
        return path;
    }

    public void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.c.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fA = 1.0f / a(f5, f6);
        this.c.postScale(fA, fA);
        this.c.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.c, this.b);
        this.f917a = path;
    }
}
