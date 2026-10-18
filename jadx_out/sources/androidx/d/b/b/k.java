package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class k extends l {
    public static final int I = 2;
    public static final int J = 1;
    public static final int K = 0;
    static final int M = 2;
    private static final String P = "KeyPosition";
    private static final String S = "percentY";
    private static final String T = "percentX";
    static final String y = "KeyPosition";
    String z = null;
    int A = f606a;
    int B = 0;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    int L = 0;
    private float Q = Float.NaN;
    private float R = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f615a = 1;
        private static final int b = 2;
        private static final int c = 3;
        private static final int d = 4;
        private static final int e = 5;
        private static final int f = 6;
        private static final int g = 7;
        private static final int h = 8;
        private static final int i = 9;
        private static final int j = 10;
        private static final int k = 11;
        private static final int l = 12;
        private static SparseIntArray m = new SparseIntArray();

        static {
            m.append(androidx.d.e.m.C0052m.KeyPosition_motionTarget, 1);
            m.append(androidx.d.e.m.C0052m.KeyPosition_framePosition, 2);
            m.append(androidx.d.e.m.C0052m.KeyPosition_transitionEasing, 3);
            m.append(androidx.d.e.m.C0052m.KeyPosition_curveFit, 4);
            m.append(androidx.d.e.m.C0052m.KeyPosition_drawPath, 5);
            m.append(androidx.d.e.m.C0052m.KeyPosition_percentX, 6);
            m.append(androidx.d.e.m.C0052m.KeyPosition_percentY, 7);
            m.append(androidx.d.e.m.C0052m.KeyPosition_keyPositionType, 9);
            m.append(androidx.d.e.m.C0052m.KeyPosition_sizePercent, 8);
            m.append(androidx.d.e.m.C0052m.KeyPosition_percentWidth, 11);
            m.append(androidx.d.e.m.C0052m.KeyPosition_percentHeight, 12);
            m.append(androidx.d.e.m.C0052m.KeyPosition_pathMotionArc, 10);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(k kVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (m.get(index)) {
                    case 1:
                        if (s.h) {
                            kVar.c = typedArray.getResourceId(index, kVar.c);
                            if (kVar.c == -1) {
                                kVar.d = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.d = typedArray.getString(index);
                        } else {
                            kVar.c = typedArray.getResourceId(index, kVar.c);
                        }
                        break;
                    case 2:
                        kVar.b = typedArray.getInt(index, kVar.b);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            kVar.z = typedArray.getString(index);
                        } else {
                            kVar.z = androidx.d.b.a.c.c[typedArray.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        kVar.O = typedArray.getInteger(index, kVar.O);
                        break;
                    case 5:
                        kVar.B = typedArray.getInt(index, kVar.B);
                        break;
                    case 6:
                        kVar.E = typedArray.getFloat(index, kVar.E);
                        break;
                    case 7:
                        kVar.F = typedArray.getFloat(index, kVar.F);
                        break;
                    case 8:
                        float f2 = typedArray.getFloat(index, kVar.D);
                        kVar.C = f2;
                        kVar.D = f2;
                        break;
                    case 9:
                        kVar.L = typedArray.getInt(index, kVar.L);
                        break;
                    case 10:
                        kVar.A = typedArray.getInt(index, kVar.A);
                        break;
                    case 11:
                        kVar.C = typedArray.getFloat(index, kVar.C);
                        break;
                    case 12:
                        kVar.D = typedArray.getFloat(index, kVar.D);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + m.get(index));
                        break;
                }
            }
            if (kVar.b == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public k() {
        this.e = 2;
    }

    private void a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        this.Q = f + (this.E * f5) + ((-f6) * this.F);
        this.R = f2 + (f6 * this.E) + (f5 * this.F);
    }

    private void a(int i, int i2) {
        float f = 0;
        this.Q = ((i - 0) * this.E) + f;
        this.R = ((i2 - 0) * this.E) + f;
    }

    private void b(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = Float.isNaN(this.E) ? 0.0f : this.E;
        float f8 = Float.isNaN(this.H) ? 0.0f : this.H;
        float f9 = Float.isNaN(this.F) ? 0.0f : this.F;
        this.Q = (int) (f + (f7 * f5) + ((Float.isNaN(this.G) ? 0.0f : this.G) * f6));
        this.R = (int) (f2 + (f5 * f8) + (f6 * f9));
    }

    @Override // androidx.d.b.b.l
    float a() {
        return this.Q;
    }

    @Override // androidx.d.b.b.l
    void a(int i, int i2, float f, float f2, float f3, float f4) {
        switch (this.L) {
            case 1:
                a(f, f2, f3, f4);
                break;
            case 2:
                a(i, i2);
                break;
            default:
                b(f, f2, f3, f4);
                break;
        }
    }

    @Override // androidx.d.b.b.e
    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.KeyPosition));
    }

    void a(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = fCenterX2 / fHypot;
        float f4 = fCenterY2 / fHypot;
        float f5 = f2 - fCenterY;
        float f6 = f - fCenterX;
        float f7 = ((f3 * f5) - (f6 * f4)) / fHypot;
        float f8 = ((f3 * f6) + (f4 * f5)) / fHypot;
        if (strArr[0] != null) {
            if (T.equals(strArr[0])) {
                fArr[0] = f8;
                fArr[1] = f7;
                return;
            }
            return;
        }
        strArr[0] = T;
        strArr[1] = S;
        fArr[0] = f8;
        fArr[1] = f7;
    }

    @Override // androidx.d.b.b.l
    public void a(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        switch (this.L) {
            case 1:
                a(rectF, rectF2, f, f2, strArr, fArr);
                break;
            case 2:
                b(view, rectF, rectF2, f, f2, strArr, fArr);
                break;
            default:
                b(rectF, rectF2, f, f2, strArr, fArr);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    @Override // androidx.d.b.b.e
    public void a(String str, Object obj) {
        switch (str) {
            case "transitionEasing":
                this.z = obj.toString();
                break;
            case "drawPath":
                this.B = b(obj);
                break;
            case "percentWidth":
                this.C = a(obj);
                break;
            case "percentHeight":
                this.D = a(obj);
                break;
            case "sizePercent":
                float fA = a(obj);
                this.C = fA;
                this.D = fA;
                break;
            case "percentX":
                this.E = a(obj);
                break;
            case "percentY":
                this.F = a(obj);
                break;
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashMap<String, w> map) {
    }

    @Override // androidx.d.b.b.l
    public boolean a(int i, int i2, RectF rectF, RectF rectF2, float f, float f2) {
        a(i, i2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f - this.Q) < 20.0f && Math.abs(f2 - this.R) < 20.0f;
    }

    @Override // androidx.d.b.b.l
    float b() {
        return this.R;
    }

    void b(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        float fCenterX2 = rectF2.centerX() - fCenterX;
        float fCenterY2 = rectF2.centerY() - fCenterY;
        if (strArr[0] == null) {
            strArr[0] = T;
            fArr[0] = (f - fCenterX) / fCenterX2;
            strArr[1] = S;
            fArr[1] = (f2 - fCenterY) / fCenterY2;
            return;
        }
        if (T.equals(strArr[0])) {
            fArr[0] = (f - fCenterX) / fCenterX2;
            fArr[1] = (f2 - fCenterY) / fCenterY2;
        } else {
            fArr[1] = (f - fCenterX) / fCenterX2;
            fArr[0] = (f2 - fCenterY) / fCenterY2;
        }
    }

    void b(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (strArr[0] == null) {
            strArr[0] = T;
            fArr[0] = f / width;
            strArr[1] = S;
            fArr[1] = f2 / height;
            return;
        }
        if (T.equals(strArr[0])) {
            fArr[0] = f / width;
            fArr[1] = f2 / height;
        } else {
            fArr[1] = f / width;
            fArr[0] = f2 / height;
        }
    }
}
