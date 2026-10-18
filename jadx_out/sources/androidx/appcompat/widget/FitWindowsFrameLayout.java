package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class FitWindowsFrameLayout extends FrameLayout implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah.a f170a;

    public FitWindowsFrameLayout(@androidx.annotation.ah Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f170a != null) {
            this.f170a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.ah
    public void setOnFitSystemWindowsListener(ah.a aVar) {
        this.f170a = aVar;
    }
}
