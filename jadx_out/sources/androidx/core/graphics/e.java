package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ah;
import androidx.annotation.am;
import androidx.annotation.ax;
import androidx.annotation.z;
import androidx.core.n.af;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f431a = 95.047d;
    private static final double b = 100.0d;
    private static final double c = 108.883d;
    private static final double d = 0.008856d;
    private static final double e = 903.3d;
    private static final int f = 10;
    private static final int g = 1;
    private static final ThreadLocal<double[]> h = new ThreadLocal<>();

    private e() {
    }

    private static double a(double d2) {
        return d2 > d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * e) + 16.0d) / 116.0d;
    }

    @androidx.annotation.r(a = 0.0d, b = 1.0d)
    public static double a(@androidx.annotation.k int i) {
        double[] dArrA = a();
        b(i, dArrA);
        return dArrA[1] / b;
    }

    public static double a(@ah double[] dArr, @ah double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    @ax
    static float a(float f2, float f3, float f4) {
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (f2 + ((f3 - f2) * f4)) % 360.0f;
    }

    @androidx.annotation.k
    public static int a(@androidx.annotation.r(a = 0.0d, b = f431a) double d2, @androidx.annotation.r(a = 0.0d, b = b) double d3, @androidx.annotation.r(a = 0.0d, b = c) double d4) {
        double d5 = (((3.2406d * d2) + ((-1.5372d) * d3)) + ((-0.4986d) * d4)) / b;
        double d6 = ((((-0.9689d) * d2) + (1.8758d * d3)) + (0.0415d * d4)) / b;
        double d7 = (((d2 * 0.0557d) + (d3 * (-0.204d))) + (1.057d * d4)) / b;
        return Color.rgb(a((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), a((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), a((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255));
    }

    public static int a(@androidx.annotation.k int i, @androidx.annotation.k int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iD = d(iAlpha2, iAlpha);
        return Color.argb(iD, a(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iD), a(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iD), a(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iD));
    }

    public static int a(@androidx.annotation.k int i, @androidx.annotation.k int i2, float f2) {
        int i3 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        double d2 = f2;
        if (b(c(i, 255), i2) < d2) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
            int i6 = (i4 + i3) / 2;
            if (b(c(i, i6), i2) < d2) {
                i4 = i6;
            } else {
                i3 = i6;
            }
        }
        return i3;
    }

    private static int a(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    @androidx.annotation.k
    public static int a(@ah float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float fAbs = (1.0f - Math.abs((f4 * 2.0f) - 1.0f)) * f3;
        float f5 = f4 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f2) / 60) {
            case 0:
                iRound = Math.round((fAbs + f5) * 255.0f);
                iRound2 = Math.round((fAbs2 + f5) * 255.0f);
                iRound3 = Math.round(f5 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f5) * 255.0f);
                iRound2 = Math.round((fAbs + f5) * 255.0f);
                iRound3 = Math.round(f5 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f5 * 255.0f);
                iRound2 = Math.round((fAbs + f5) * 255.0f);
                iRound3 = Math.round((fAbs2 + f5) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f5 * 255.0f);
                iRound2 = Math.round((fAbs2 + f5) * 255.0f);
                iRound3 = Math.round((fAbs + f5) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f5) * 255.0f);
                iRound2 = Math.round(f5 * 255.0f);
                iRound3 = Math.round((fAbs + f5) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f5) * 255.0f);
                iRound2 = Math.round(f5 * 255.0f);
                iRound3 = Math.round((fAbs2 + f5) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(a(iRound, 0, 255), a(iRound2, 0, 255), a(iRound3, 0, 255));
    }

    @am(a = 26)
    @ah
    public static Color a(@ah Color color, @ah Color color2) {
        if (!Objects.equals(color.getModel(), color2.getModel())) {
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
        if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
            color = color.convert(color2.getColorSpace());
        }
        float[] components = color.getComponents();
        float[] components2 = color2.getComponents();
        float fAlpha = color.alpha();
        float fAlpha2 = color2.alpha() * (1.0f - fAlpha);
        int componentCount = color2.getComponentCount() - 1;
        components2[componentCount] = fAlpha + fAlpha2;
        if (components2[componentCount] > 0.0f) {
            fAlpha /= components2[componentCount];
            fAlpha2 /= components2[componentCount];
        }
        for (int i = 0; i < componentCount; i++) {
            components2[i] = (components[i] * fAlpha) + (components2[i] * fAlpha2);
        }
        return Color.valueOf(components2, color2.getColorSpace());
    }

    public static void a(@androidx.annotation.r(a = 0.0d, b = f431a) double d2, @androidx.annotation.r(a = 0.0d, b = b) double d3, @androidx.annotation.r(a = 0.0d, b = c) double d4, @ah double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dA = a(d2 / f431a);
        double dA2 = a(d3 / b);
        double dA3 = a(d4 / c);
        dArr[0] = Math.max(0.0d, (116.0d * dA2) - 16.0d);
        dArr[1] = (dA - dA2) * 500.0d;
        dArr[2] = (dA2 - dA3) * 200.0d;
    }

    public static void a(@z(a = FabTransformationScrimBehavior.c, b = 255) int i, @z(a = FabTransformationScrimBehavior.c, b = 255) int i2, @z(a = FabTransformationScrimBehavior.c, b = 255) int i3, @ah double[] dArr) {
        b(i, i2, i3, dArr);
        a(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void a(@z(a = FabTransformationScrimBehavior.c, b = 255) int i, @z(a = FabTransformationScrimBehavior.c, b = 255) int i2, @z(a = FabTransformationScrimBehavior.c, b = 255) int i3, @ah float[] fArr) {
        float f2;
        float fAbs;
        float f3 = i / 255.0f;
        float f4 = i2 / 255.0f;
        float f5 = i3 / 255.0f;
        float fMax = Math.max(f3, Math.max(f4, f5));
        float fMin = Math.min(f3, Math.min(f4, f5));
        float f6 = fMax - fMin;
        float f7 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f2 = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f3) {
                f2 = ((f4 - f5) / f6) % 6.0f;
            } else {
                f2 = fMax == f4 ? ((f5 - f3) / f6) + 2.0f : ((f3 - f4) / f6) + 4.0f;
            }
            fAbs = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (f2 * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = b(f8, 0.0f, 360.0f);
        fArr[1] = b(fAbs, 0.0f, 1.0f);
        fArr[2] = b(f7, 0.0f, 1.0f);
    }

    public static void a(@androidx.annotation.k int i, @ah double[] dArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void a(@androidx.annotation.k int i, @ah float[] fArr) {
        a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void a(@ah double[] dArr, @ah double[] dArr2, @androidx.annotation.r(a = 0.0d, b = 1.0d) double d2, @ah double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d3 = 1.0d - d2;
        dArr3[0] = (dArr[0] * d3) + (dArr2[0] * d2);
        dArr3[1] = (dArr[1] * d3) + (dArr2[1] * d2);
        dArr3[2] = (dArr[2] * d3) + (dArr2[2] * d2);
    }

    public static void a(@ah float[] fArr, @ah float[] fArr2, @androidx.annotation.r(a = 0.0d, b = 1.0d) float f2, @ah float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f3 = 1.0f - f2;
        fArr3[0] = a(fArr[0], fArr2[0], f2);
        fArr3[1] = (fArr[1] * f3) + (fArr2[1] * f2);
        fArr3[2] = (fArr[2] * f3) + (fArr2[2] * f2);
    }

    private static double[] a() {
        double[] dArr = h.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        h.set(dArr2);
        return dArr2;
    }

    public static double b(@androidx.annotation.k int i, @androidx.annotation.k int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < 255) {
            i = a(i, i2);
        }
        double dA = a(i) + 0.05d;
        double dA2 = a(i2) + 0.05d;
        return Math.max(dA, dA2) / Math.min(dA, dA2);
    }

    private static float b(float f2, float f3, float f4) {
        if (f2 < f3) {
            return f3;
        }
        return f2 > f4 ? f4 : f2;
    }

    @androidx.annotation.k
    public static int b(@androidx.annotation.r(a = 0.0d, b = b) double d2, @androidx.annotation.r(a = -128.0d, b = 127.0d) double d3, @androidx.annotation.r(a = -128.0d, b = 127.0d) double d4) {
        double[] dArrA = a();
        b(d2, d3, d4, dArrA);
        return a(dArrA[0], dArrA[1], dArrA[2]);
    }

    @androidx.annotation.k
    public static int b(@androidx.annotation.k int i, @androidx.annotation.k int i2, @androidx.annotation.r(a = 0.0d, b = 1.0d) float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f3) + (Color.blue(i2) * f2)));
    }

    public static void b(@androidx.annotation.r(a = 0.0d, b = b) double d2, @androidx.annotation.r(a = -128.0d, b = 127.0d) double d3, @androidx.annotation.r(a = -128.0d, b = 127.0d) double d4, @ah double[] dArr) {
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = (d3 / 500.0d) + d5;
        double d7 = d5 - (d4 / 200.0d);
        double dPow = Math.pow(d6, 3.0d);
        if (dPow <= d) {
            dPow = ((d6 * 116.0d) - 16.0d) / e;
        }
        double dPow2 = d2 > 7.9996247999999985d ? Math.pow(d5, 3.0d) : d2 / e;
        double dPow3 = Math.pow(d7, 3.0d);
        if (dPow3 <= d) {
            dPow3 = ((d7 * 116.0d) - 16.0d) / e;
        }
        dArr[0] = dPow * f431a;
        dArr[1] = dPow2 * b;
        dArr[2] = dPow3 * c;
    }

    public static void b(@z(a = FabTransformationScrimBehavior.c, b = 255) int i, @z(a = FabTransformationScrimBehavior.c, b = 255) int i2, @z(a = FabTransformationScrimBehavior.c, b = 255) int i3, @ah double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d2 = ((double) i) / 255.0d;
        double dPow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) i2) / 255.0d;
        double dPow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = ((double) i3) / 255.0d;
        double dPow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * b;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * b;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * b;
    }

    public static void b(@androidx.annotation.k int i, @ah double[] dArr) {
        b(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    @androidx.annotation.k
    public static int c(@androidx.annotation.k int i, @z(a = FabTransformationScrimBehavior.c, b = 255) int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & af.r) | (i2 << 24);
    }

    private static int d(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }
}
