package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: loaded from: classes.dex */
public class u extends RatingBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f283a;

    public u(@androidx.annotation.ah Context context) {
        this(context, null);
    }

    public u(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.a.b.ratingBarStyle);
    }

    public u(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        av.a(this, getContext());
        this.f283a = new s(this);
        this.f283a.a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapA = this.f283a.a();
        if (bitmapA != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapA.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
