package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class FitWindowsLinearLayout extends LinearLayout implements ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah.a f171a;

    public FitWindowsLinearLayout(@androidx.annotation.ah Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(@androidx.annotation.ah Context context, @androidx.annotation.ai AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f171a != null) {
            this.f171a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.ah
    public void setOnFitSystemWindowsListener(ah.a aVar) {
        this.f171a = aVar;
    }
}
