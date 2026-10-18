package androidx.appcompat.b.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ap;
import androidx.annotation.k;
import androidx.annotation.r;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f106a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final float f = (float) Math.toRadians(45.0d);
    private float g;
    private float h;
    private float i;
    private float j;
    private boolean k;
    private final int m;
    private float o;
    private float p;
    private final Paint e = new Paint();
    private final Path l = new Path();
    private boolean n = false;
    private int q = 2;

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface a {
    }

    public d(Context context) {
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeJoin(Paint.Join.MITER);
        this.e.setStrokeCap(Paint.Cap.BUTT);
        this.e.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, androidx.appcompat.a.m.DrawerArrowToggle, androidx.appcompat.a.b.drawerArrowStyle, androidx.appcompat.a.l.Base_Widget_AppCompat_DrawerArrowToggle);
        a(typedArrayObtainStyledAttributes.getColor(androidx.appcompat.a.m.DrawerArrowToggle_color, 0));
        d(typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.a.m.DrawerArrowToggle_thickness, 0.0f));
        a(typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.a.m.DrawerArrowToggle_spinBars, true));
        e(Math.round(typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.a.m.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.a.m.DrawerArrowToggle_drawableSize, 0);
        this.h = Math.round(typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.a.m.DrawerArrowToggle_barLength, 0.0f));
        this.g = Math.round(typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.a.m.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.i = typedArrayObtainStyledAttributes.getDimension(androidx.appcompat.a.m.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public float a() {
        return this.g;
    }

    public void a(float f2) {
        if (this.g != f2) {
            this.g = f2;
            invalidateSelf();
        }
    }

    public void a(@k int i) {
        if (i != this.e.getColor()) {
            this.e.setColor(i);
            invalidateSelf();
        }
    }

    public void a(boolean z) {
        if (this.k != z) {
            this.k = z;
            invalidateSelf();
        }
    }

    public float b() {
        return this.i;
    }

    public void b(float f2) {
        if (this.i != f2) {
            this.i = f2;
            invalidateSelf();
        }
    }

    public void b(int i) {
        if (i != this.q) {
            this.q = i;
            invalidateSelf();
        }
    }

    public void b(boolean z) {
        if (this.n != z) {
            this.n = z;
            invalidateSelf();
        }
    }

    public float c() {
        return this.h;
    }

    public void c(float f2) {
        if (this.h != f2) {
            this.h = f2;
            invalidateSelf();
        }
    }

    @k
    public int d() {
        return this.e.getColor();
    }

    public void d(float f2) {
        if (this.e.getStrokeWidth() != f2) {
            this.e.setStrokeWidth(f2);
            this.p = (float) (((double) (f2 / 2.0f)) * Math.cos(f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.q;
        boolean z = false;
        if (i != 3) {
            switch (i) {
                case 0:
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    if (androidx.core.graphics.drawable.a.i(this) == 1) {
                        z = true;
                    }
                    break;
            }
        } else if (androidx.core.graphics.drawable.a.i(this) == 0) {
            z = true;
        }
        float fA = a(this.h, (float) Math.sqrt(this.g * this.g * 2.0f), this.o);
        float fA2 = a(this.h, this.i, this.o);
        float fRound = Math.round(a(0.0f, this.p, this.o));
        float fA3 = a(0.0f, f, this.o);
        float fA4 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.o);
        double d2 = fA;
        double d3 = fA3;
        boolean z2 = z;
        float fRound2 = Math.round(Math.cos(d3) * d2);
        float fRound3 = Math.round(d2 * Math.sin(d3));
        this.l.rewind();
        float fA5 = a(this.j + this.e.getStrokeWidth(), -this.p, this.o);
        float f2 = (-fA2) / 2.0f;
        this.l.moveTo(f2 + fRound, 0.0f);
        this.l.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.l.moveTo(f2, fA5);
        this.l.rLineTo(fRound2, fRound3);
        this.l.moveTo(f2, -fA5);
        this.l.rLineTo(fRound2, -fRound3);
        this.l.close();
        canvas.save();
        float strokeWidth = this.e.getStrokeWidth();
        canvas.translate(bounds.centerX(), ((((int) ((bounds.height() - (3.0f * strokeWidth)) - (this.j * 2.0f))) / 4) * 2) + (strokeWidth * 1.5f) + this.j);
        if (this.k) {
            canvas.rotate(fA4 * (this.n ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.l, this.e);
        canvas.restore();
    }

    public float e() {
        return this.e.getStrokeWidth();
    }

    public void e(float f2) {
        if (f2 != this.j) {
            this.j = f2;
            invalidateSelf();
        }
    }

    public float f() {
        return this.j;
    }

    public void f(@r(a = 0.0d, b = 1.0d) float f2) {
        if (this.o != f2) {
            this.o = f2;
            invalidateSelf();
        }
    }

    public boolean g() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.q;
    }

    @r(a = 0.0d, b = 1.0d)
    public float i() {
        return this.o;
    }

    public final Paint j() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.e.getAlpha()) {
            this.e.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
