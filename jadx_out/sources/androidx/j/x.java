package androidx.j;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class x<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f916a;
    private final PathMeasure b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;

    x(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.f916a = property;
        this.b = new PathMeasure(path, false);
        this.c = this.b.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.b.getPosTan(this.c * f.floatValue(), this.d, null);
        this.e.x = this.d[0];
        this.e.y = this.d[1];
        this.f916a.set(t, this.e);
    }
}
