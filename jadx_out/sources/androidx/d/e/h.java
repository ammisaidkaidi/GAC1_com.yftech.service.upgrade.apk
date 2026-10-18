package androidx.d.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class h extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f731a = "Constraints";
    g b;

    public static class a extends d.a {
        public float aH;
        public boolean aI;
        public float aJ;
        public float aK;
        public float aL;
        public float aM;
        public float aN;
        public float aO;
        public float aP;
        public float aQ;
        public float aR;
        public float aS;
        public float aT;

        public a(int i, int i2) {
            super(i, i2);
            this.aH = 1.0f;
            this.aI = false;
            this.aJ = 0.0f;
            this.aK = 0.0f;
            this.aL = 0.0f;
            this.aM = 0.0f;
            this.aN = 1.0f;
            this.aO = 1.0f;
            this.aP = 0.0f;
            this.aQ = 0.0f;
            this.aR = 0.0f;
            this.aS = 0.0f;
            this.aT = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aH = 1.0f;
            this.aI = false;
            this.aJ = 0.0f;
            this.aK = 0.0f;
            this.aL = 0.0f;
            this.aM = 0.0f;
            this.aN = 1.0f;
            this.aO = 1.0f;
            this.aP = 0.0f;
            this.aQ = 0.0f;
            this.aR = 0.0f;
            this.aS = 0.0f;
            this.aT = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.C0052m.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.ConstraintSet_android_alpha) {
                    this.aH = typedArrayObtainStyledAttributes.getFloat(index, this.aH);
                } else if (index == m.C0052m.ConstraintSet_android_elevation) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.aJ = typedArrayObtainStyledAttributes.getFloat(index, this.aJ);
                        this.aI = true;
                    }
                } else if (index == m.C0052m.ConstraintSet_android_rotationX) {
                    this.aL = typedArrayObtainStyledAttributes.getFloat(index, this.aL);
                } else if (index == m.C0052m.ConstraintSet_android_rotationY) {
                    this.aM = typedArrayObtainStyledAttributes.getFloat(index, this.aM);
                } else if (index == m.C0052m.ConstraintSet_android_rotation) {
                    this.aK = typedArrayObtainStyledAttributes.getFloat(index, this.aK);
                } else if (index == m.C0052m.ConstraintSet_android_scaleX) {
                    this.aN = typedArrayObtainStyledAttributes.getFloat(index, this.aN);
                } else if (index == m.C0052m.ConstraintSet_android_scaleY) {
                    this.aO = typedArrayObtainStyledAttributes.getFloat(index, this.aO);
                } else if (index == m.C0052m.ConstraintSet_android_transformPivotX) {
                    this.aP = typedArrayObtainStyledAttributes.getFloat(index, this.aP);
                } else if (index == m.C0052m.ConstraintSet_android_transformPivotY) {
                    this.aQ = typedArrayObtainStyledAttributes.getFloat(index, this.aQ);
                } else if (index == m.C0052m.ConstraintSet_android_translationX) {
                    this.aR = typedArrayObtainStyledAttributes.getFloat(index, this.aR);
                } else if (index == m.C0052m.ConstraintSet_android_translationY) {
                    this.aS = typedArrayObtainStyledAttributes.getFloat(index, this.aS);
                } else if (index == m.C0052m.ConstraintSet_android_translationZ && Build.VERSION.SDK_INT >= 21) {
                    this.aT = typedArrayObtainStyledAttributes.getFloat(index, this.aT);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(a aVar) {
            super((d.a) aVar);
            this.aH = 1.0f;
            this.aI = false;
            this.aJ = 0.0f;
            this.aK = 0.0f;
            this.aL = 0.0f;
            this.aM = 0.0f;
            this.aN = 1.0f;
            this.aO = 1.0f;
            this.aP = 0.0f;
            this.aQ = 0.0f;
            this.aR = 0.0f;
            this.aS = 0.0f;
            this.aT = 0.0f;
        }
    }

    public h(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
        super.setVisibility(8);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet);
        super.setVisibility(8);
    }

    private void b(AttributeSet attributeSet) {
        Log.v(f731a, " ################# init");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new d.a(layoutParams);
    }

    public g getConstraintSet() {
        if (this.b == null) {
            this.b = new g();
        }
        this.b.a(this);
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
