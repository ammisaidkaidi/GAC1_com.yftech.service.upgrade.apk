package androidx.d.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f736a;
    private boolean b;

    public o(Context context) {
        super(context);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public o(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.d.e.c
    protected void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.C0052m.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.ConstraintLayout_Layout_android_visibility) {
                    this.f736a = true;
                } else if (index == m.C0052m.ConstraintLayout_Layout_android_elevation) {
                    this.b = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void a(androidx.d.c.b.m mVar, int i, int i2) {
    }

    @Override // androidx.d.e.c, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f736a || this.b) && (parent = getParent()) != null && (parent instanceof d)) {
            d dVar = (d) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.q; i++) {
                View viewG = dVar.g(this.p[i]);
                if (viewG != null) {
                    if (this.f736a) {
                        viewG.setVisibility(visibility);
                    }
                    if (this.b && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        viewG.setTranslationZ(viewG.getTranslationZ() + elevation);
                    }
                }
            }
        }
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
