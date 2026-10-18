package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f857a = 1048576;
    private static final boolean b;
    private static final boolean c;
    private static final boolean d;

    static class a implements TypeEvaluator<Matrix> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float[] f858a = new float[9];
        final float[] b = new float[9];
        final Matrix c = new Matrix();

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f858a);
            matrix2.getValues(this.b);
            for (int i = 0; i < 9; i++) {
                this.b[i] = this.f858a[i] + ((this.b[i] - this.f858a[i]) * f);
            }
            this.c.setValues(this.b);
            return this.c;
        }
    }

    static {
        b = Build.VERSION.SDK_INT >= 19;
        c = Build.VERSION.SDK_INT >= 18;
        d = Build.VERSION.SDK_INT >= 28;
    }

    private am() {
    }

    static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }

    private static Bitmap a(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean zIsAttachedToWindow;
        int iIndexOfChild;
        ViewGroup viewGroup2;
        if (b) {
            z = !view.isAttachedToWindow();
            zIsAttachedToWindow = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z = false;
            zIsAttachedToWindow = false;
        }
        Bitmap bitmapCreateBitmap = null;
        if (!c || !z) {
            iIndexOfChild = 0;
            viewGroup2 = null;
        } else {
            if (!zIsAttachedToWindow) {
                return null;
            }
            viewGroup2 = (ViewGroup) view.getParent();
            iIndexOfChild = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        if (iRound > 0 && iRound2 > 0) {
            float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            int iRound3 = Math.round(iRound * fMin);
            int iRound4 = Math.round(iRound2 * fMin);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin, fMin);
            if (d) {
                Picture picture = new Picture();
                Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                canvasBeginRecording.concat(matrix);
                view.draw(canvasBeginRecording);
                picture.endRecording();
                bitmapCreateBitmap = Bitmap.createBitmap(picture);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (c && z) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, iIndexOfChild);
        }
        return bitmapCreateBitmap;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        ay.a(view, matrix);
        ay.b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapA = a(view, matrix, rectF, viewGroup);
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, androidx.d.c.b.a.b.b), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, androidx.d.c.b.a.b.b));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }
}
