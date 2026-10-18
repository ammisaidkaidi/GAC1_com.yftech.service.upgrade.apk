package androidx.d.e;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class j extends c {
    public j(Context context) {
        super(context);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.d.e.c
    protected void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.t = false;
    }

    @Override // androidx.d.e.c
    public void b(d dVar) {
        d.a aVar = (d.a) getLayoutParams();
        aVar.aF.p(0);
        aVar.aF.q(0);
    }

    @Override // androidx.d.e.c, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        d();
    }
}
