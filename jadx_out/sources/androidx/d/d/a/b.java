package androidx.d.d.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.am;
import androidx.appcompat.widget.p;
import androidx.d.e.m;

/* JADX INFO: loaded from: classes.dex */
public class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewOutlineProvider f706a;
    RectF b;
    Drawable[] c;
    LayerDrawable d;
    private a e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private Path j;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f709a = new float[20];
        ColorMatrix b = new ColorMatrix();
        ColorMatrix c = new ColorMatrix();
        float d = 1.0f;
        float e = 1.0f;
        float f = 1.0f;
        float g = 1.0f;

        a() {
        }

        private void a(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            this.f709a[0] = f3 + f;
            this.f709a[1] = f4;
            this.f709a[2] = f5;
            this.f709a[3] = 0.0f;
            this.f709a[4] = 0.0f;
            this.f709a[5] = f3;
            this.f709a[6] = f4 + f;
            this.f709a[7] = f5;
            this.f709a[8] = 0.0f;
            this.f709a[9] = 0.0f;
            this.f709a[10] = f3;
            this.f709a[11] = f4;
            this.f709a[12] = f5 + f;
            this.f709a[13] = 0.0f;
            this.f709a[14] = 0.0f;
            this.f709a[15] = 0.0f;
            this.f709a[16] = 0.0f;
            this.f709a[17] = 0.0f;
            this.f709a[18] = 1.0f;
            this.f709a[19] = 0.0f;
        }

        private void b(float f) {
            float fLog;
            float fPow;
            float fLog2;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            float f2 = (5000.0f / f) / 100.0f;
            if (f2 > 66.0f) {
                double d = f2 - 60.0f;
                fPow = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f2)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            if (f2 < 66.0f) {
                fLog2 = f2 > 19.0f ? (((float) Math.log(f2 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
            } else {
                fLog2 = 255.0f;
            }
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            this.f709a[0] = fMin / fMin4;
            this.f709a[1] = 0.0f;
            this.f709a[2] = 0.0f;
            this.f709a[3] = 0.0f;
            this.f709a[4] = 0.0f;
            this.f709a[5] = 0.0f;
            this.f709a[6] = fMin2 / fMin5;
            this.f709a[7] = 0.0f;
            this.f709a[8] = 0.0f;
            this.f709a[9] = 0.0f;
            this.f709a[10] = 0.0f;
            this.f709a[11] = 0.0f;
            this.f709a[12] = fMin6;
            this.f709a[13] = 0.0f;
            this.f709a[14] = 0.0f;
            this.f709a[15] = 0.0f;
            this.f709a[16] = 0.0f;
            this.f709a[17] = 0.0f;
            this.f709a[18] = 1.0f;
            this.f709a[19] = 0.0f;
        }

        private void c(float f) {
            this.f709a[0] = f;
            this.f709a[1] = 0.0f;
            this.f709a[2] = 0.0f;
            this.f709a[3] = 0.0f;
            this.f709a[4] = 0.0f;
            this.f709a[5] = 0.0f;
            this.f709a[6] = f;
            this.f709a[7] = 0.0f;
            this.f709a[8] = 0.0f;
            this.f709a[9] = 0.0f;
            this.f709a[10] = 0.0f;
            this.f709a[11] = 0.0f;
            this.f709a[12] = f;
            this.f709a[13] = 0.0f;
            this.f709a[14] = 0.0f;
            this.f709a[15] = 0.0f;
            this.f709a[16] = 0.0f;
            this.f709a[17] = 0.0f;
            this.f709a[18] = 1.0f;
            this.f709a[19] = 0.0f;
        }

        void a(ImageView imageView) {
            boolean z;
            this.b.reset();
            if (this.e != 1.0f) {
                a(this.e);
                this.b.set(this.f709a);
                z = true;
            } else {
                z = false;
            }
            if (this.f != 1.0f) {
                this.c.setScale(this.f, this.f, this.f, 1.0f);
                this.b.postConcat(this.c);
                z = true;
            }
            if (this.g != 1.0f) {
                b(this.g);
                this.c.set(this.f709a);
                this.b.postConcat(this.c);
                z = true;
            }
            if (this.d != 1.0f) {
                c(this.d);
                this.c.set(this.f709a);
                this.b.postConcat(this.c);
                z = true;
            }
            if (z) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public b(Context context) {
        super(context);
        this.e = new a();
        this.f = true;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = Float.NaN;
        a(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new a();
        this.f = true;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = Float.NaN;
        a(context, attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new a();
        this.f = true;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = Float.NaN;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.C0052m.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(m.C0052m.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.ImageFilterView_crossfade) {
                    this.g = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == m.C0052m.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == m.C0052m.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == m.C0052m.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == m.C0052m.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == m.C0052m.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == m.C0052m.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (drawable != null) {
                this.c = new Drawable[2];
                this.c[0] = getDrawable();
                this.c[1] = drawable;
                this.d = new LayerDrawable(this.c);
                this.d.getDrawable(1).setAlpha((int) (this.g * 255.0f));
                super.setImageDrawable(this.d);
            }
        }
    }

    private void setOverlay(boolean z) {
        this.f = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.h == 0.0f || this.j == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.j);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.e.d;
    }

    public float getContrast() {
        return this.e.f;
    }

    public float getCrossfade() {
        return this.g;
    }

    public float getRound() {
        return this.i;
    }

    public float getRoundPercent() {
        return this.h;
    }

    public float getSaturation() {
        return this.e.e;
    }

    public float getWarmth() {
        return this.e.g;
    }

    public void setBrightness(float f) {
        this.e.d = f;
        this.e.a(this);
    }

    public void setContrast(float f) {
        this.e.f = f;
        this.e.a(this);
    }

    public void setCrossfade(float f) {
        this.g = f;
        if (this.c != null) {
            if (!this.f) {
                this.d.getDrawable(0).setAlpha((int) ((1.0f - this.g) * 255.0f));
            }
            this.d.getDrawable(1).setAlpha((int) (this.g * 255.0f));
            super.setImageDrawable(this.d);
        }
    }

    @am(a = 21)
    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.i = f;
            float f2 = this.h;
            this.h = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.i != f;
        this.i = f;
        if (this.i != 0.0f) {
            if (this.j == null) {
                this.j = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f706a == null) {
                    this.f706a = new ViewOutlineProvider() { // from class: androidx.d.d.a.b.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, b.this.getWidth(), b.this.getHeight(), b.this.i);
                        }
                    };
                    setOutlineProvider(this.f706a);
                }
                setClipToOutline(true);
            }
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.j.reset();
            this.j.addRoundRect(this.b, this.i, this.i, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    @am(a = 21)
    public void setRoundPercent(float f) {
        boolean z = this.h != f;
        this.h = f;
        if (this.h != 0.0f) {
            if (this.j == null) {
                this.j = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f706a == null) {
                    this.f706a = new ViewOutlineProvider() { // from class: androidx.d.d.a.b.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = b.this.getWidth();
                            int height = b.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * b.this.h) / 2.0f);
                        }
                    };
                    setOutlineProvider(this.f706a);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.h) / 2.0f;
            this.b.set(0.0f, 0.0f, width, height);
            this.j.reset();
            this.j.addRoundRect(this.b, fMin, fMin, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setSaturation(float f) {
        this.e.e = f;
        this.e.a(this);
    }

    public void setWarmth(float f) {
        this.e.g = f;
        this.e.a(this);
    }
}
