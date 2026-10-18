package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class q extends androidx.d.e.c implements a, s.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected View[] f620a;
    private boolean b;
    private boolean c;
    private float d;

    public q(Context context) {
        super(context);
        this.b = false;
        this.c = false;
    }

    public q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.c = false;
        a(attributeSet);
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.c = false;
        a(attributeSet);
    }

    @Override // androidx.d.e.c
    protected void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == androidx.d.e.m.C0052m.MotionHelper_onShow) {
                    this.b = typedArrayObtainStyledAttributes.getBoolean(index, this.b);
                } else if (index == androidx.d.e.m.C0052m.MotionHelper_onHide) {
                    this.c = typedArrayObtainStyledAttributes.getBoolean(index, this.c);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void a(View view, float f) {
    }

    @Override // androidx.d.b.b.s.g
    public void a(s sVar, int i) {
    }

    @Override // androidx.d.b.b.s.g
    public void a(s sVar, int i, int i2) {
    }

    @Override // androidx.d.b.b.s.g
    public void a(s sVar, int i, int i2, float f) {
    }

    @Override // androidx.d.b.b.s.g
    public void a(s sVar, int i, boolean z, float f) {
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    @Override // androidx.d.b.b.a
    public float getProgress() {
        return this.d;
    }

    @Override // androidx.d.b.b.a
    public void setProgress(float f) {
        this.d = f;
        int i = 0;
        if (this.q > 0) {
            this.f620a = e((androidx.d.e.d) getParent());
            while (i < this.q) {
                a(this.f620a[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof q)) {
                a(childAt, f);
            }
            i++;
        }
    }
}
