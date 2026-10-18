package androidx.d.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.n.af;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f716a = "ConstraintLayout";
    public static final String ab = "ConstraintLayout-2.0.4";
    public static final int ak = 0;
    private static final boolean b = true;
    private static final boolean c = false;
    private static final boolean d = false;
    private static final boolean e = false;
    SparseArray<View> ac;
    protected androidx.d.c.b.f ad;
    protected boolean ae;
    protected e af;
    int ag;
    int ah;
    int ai;
    int aj;
    b al;
    private ArrayList<c> f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private g l;
    private int m;
    private HashMap<String, Integer> n;
    private int o;
    private int p;
    private SparseArray<androidx.d.c.b.e> q;
    private i r;
    private androidx.d.c.f s;
    private int t;
    private int u;

    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f718a = 0;
        public static final int b = 0;
        public static final int c = -1;
        public static final int d = 0;
        public static final int e = 1;
        public static final int f = 1;
        public static final int g = 2;
        public static final int h = 3;
        public static final int i = 4;
        public static final int j = 5;
        public static final int k = 6;
        public static final int l = 7;
        public static final int m = 1;
        public static final int n = 0;
        public static final int o = 2;
        public static final int p = 0;
        public static final int q = 1;
        public static final int r = 2;
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public float G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public String T;
        float U;
        int V;
        public float W;
        public float X;
        public int Y;
        public int Z;
        int aA;
        float aB;
        int aC;
        int aD;
        float aE;
        androidx.d.c.b.e aF;
        public boolean aG;
        public int aa;
        public int ab;
        public int ac;
        public int ad;
        public int ae;
        public int af;
        public float ag;
        public float ah;
        public int ai;
        public int aj;
        public int ak;
        public boolean al;
        public boolean am;
        public String an;
        boolean ao;
        boolean ap;
        boolean aq;
        boolean ar;
        boolean as;
        boolean at;
        boolean au;
        int av;
        int aw;
        int ax;
        int ay;
        int az;
        public int s;
        public int t;
        public float u;
        public int v;
        public int w;
        public int x;
        public int y;
        public int z;

        /* JADX INFO: renamed from: androidx.d.e.d$a$a, reason: collision with other inner class name */
        private static class C0051a {
            public static final int A = 26;
            public static final int B = 27;
            public static final int C = 28;
            public static final int D = 29;
            public static final int E = 30;
            public static final int F = 31;
            public static final int G = 32;
            public static final int H = 33;
            public static final int I = 34;
            public static final int J = 35;
            public static final int K = 36;
            public static final int L = 37;
            public static final int M = 38;
            public static final int N = 39;
            public static final int O = 40;
            public static final int P = 41;
            public static final int Q = 42;
            public static final int R = 43;
            public static final int S = 44;
            public static final int T = 45;
            public static final int U = 46;
            public static final int V = 47;
            public static final int W = 48;
            public static final int X = 49;
            public static final int Y = 50;
            public static final int Z = 51;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f719a = 0;
            public static final SparseIntArray aa = new SparseIntArray();
            public static final int b = 1;
            public static final int c = 2;
            public static final int d = 3;
            public static final int e = 4;
            public static final int f = 5;
            public static final int g = 6;
            public static final int h = 7;
            public static final int i = 8;
            public static final int j = 9;
            public static final int k = 10;
            public static final int l = 11;
            public static final int m = 12;
            public static final int n = 13;
            public static final int o = 14;
            public static final int p = 15;
            public static final int q = 16;
            public static final int r = 17;
            public static final int s = 18;
            public static final int t = 19;
            public static final int u = 20;
            public static final int v = 21;
            public static final int w = 22;
            public static final int x = 23;
            public static final int y = 24;
            public static final int z = 25;

            static {
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintCircle, 2);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                aa.append(m.C0052m.ConstraintLayout_Layout_android_orientation, 1);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                aa.append(m.C0052m.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            private C0051a() {
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.s = -1;
            this.t = -1;
            this.u = -1.0f;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
            this.G = 0.0f;
            this.H = -1;
            this.I = -1;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = -1;
            this.R = 0.5f;
            this.S = 0.5f;
            this.T = null;
            this.U = 0.0f;
            this.V = 1;
            this.W = -1.0f;
            this.X = -1.0f;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 0;
            this.ag = 1.0f;
            this.ah = 1.0f;
            this.ai = -1;
            this.aj = -1;
            this.ak = -1;
            this.al = false;
            this.am = false;
            this.an = null;
            this.ao = d.b;
            this.ap = d.b;
            this.aq = false;
            this.ar = false;
            this.as = false;
            this.at = false;
            this.au = false;
            this.av = -1;
            this.aw = -1;
            this.ax = -1;
            this.ay = -1;
            this.az = -1;
            this.aA = -1;
            this.aB = 0.5f;
            this.aF = new androidx.d.c.b.e();
            this.aG = false;
        }

        public a(Context context, AttributeSet attributeSet) {
            int i2;
            super(context, attributeSet);
            this.s = -1;
            this.t = -1;
            this.u = -1.0f;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
            this.G = 0.0f;
            this.H = -1;
            this.I = -1;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = -1;
            this.R = 0.5f;
            this.S = 0.5f;
            this.T = null;
            this.U = 0.0f;
            this.V = 1;
            this.W = -1.0f;
            this.X = -1.0f;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 0;
            this.ag = 1.0f;
            this.ah = 1.0f;
            this.ai = -1;
            this.aj = -1;
            this.ak = -1;
            this.al = false;
            this.am = false;
            this.an = null;
            this.ao = d.b;
            this.ap = d.b;
            this.aq = false;
            this.ar = false;
            this.as = false;
            this.at = false;
            this.au = false;
            this.av = -1;
            this.aw = -1;
            this.ax = -1;
            this.ay = -1;
            this.az = -1;
            this.aA = -1;
            this.aB = 0.5f;
            this.aF = new androidx.d.c.b.e();
            this.aG = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.C0052m.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (C0051a.aa.get(index)) {
                    case 1:
                        this.ak = typedArrayObtainStyledAttributes.getInt(index, this.ak);
                        break;
                    case 2:
                        this.E = typedArrayObtainStyledAttributes.getResourceId(index, this.E);
                        if (this.E == -1) {
                            this.E = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 4:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G) % 360.0f;
                        if (this.G < 0.0f) {
                            this.G = (360.0f - this.G) % 360.0f;
                        }
                        break;
                    case 5:
                        this.s = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.s);
                        break;
                    case 6:
                        this.t = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.t);
                        break;
                    case 7:
                        this.u = typedArrayObtainStyledAttributes.getFloat(index, this.u);
                        break;
                    case 8:
                        this.v = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                        if (this.v == -1) {
                            this.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        this.w = typedArrayObtainStyledAttributes.getResourceId(index, this.w);
                        if (this.w == -1) {
                            this.w = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        this.x = typedArrayObtainStyledAttributes.getResourceId(index, this.x);
                        if (this.x == -1) {
                            this.x = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        this.y = typedArrayObtainStyledAttributes.getResourceId(index, this.y);
                        if (this.y == -1) {
                            this.y = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        this.z = typedArrayObtainStyledAttributes.getResourceId(index, this.z);
                        if (this.z == -1) {
                            this.z = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        this.A = typedArrayObtainStyledAttributes.getResourceId(index, this.A);
                        if (this.A == -1) {
                            this.A = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        this.B = typedArrayObtainStyledAttributes.getResourceId(index, this.B);
                        if (this.B == -1) {
                            this.B = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        this.C = typedArrayObtainStyledAttributes.getResourceId(index, this.C);
                        if (this.C == -1) {
                            this.C = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        this.D = typedArrayObtainStyledAttributes.getResourceId(index, this.D);
                        if (this.D == -1) {
                            this.D = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        this.H = typedArrayObtainStyledAttributes.getResourceId(index, this.H);
                        if (this.H == -1) {
                            this.H = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        this.I = typedArrayObtainStyledAttributes.getResourceId(index, this.I);
                        if (this.I == -1) {
                            this.I = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        this.J = typedArrayObtainStyledAttributes.getResourceId(index, this.J);
                        if (this.J == -1) {
                            this.J = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        this.K = typedArrayObtainStyledAttributes.getResourceId(index, this.K);
                        if (this.K == -1) {
                            this.K = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 22:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 23:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 24:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 25:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 26:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 27:
                        this.al = typedArrayObtainStyledAttributes.getBoolean(index, this.al);
                        break;
                    case 28:
                        this.am = typedArrayObtainStyledAttributes.getBoolean(index, this.am);
                        break;
                    case 29:
                        this.R = typedArrayObtainStyledAttributes.getFloat(index, this.R);
                        break;
                    case 30:
                        this.S = typedArrayObtainStyledAttributes.getFloat(index, this.S);
                        break;
                    case 31:
                        this.aa = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.aa == 1) {
                            Log.e(d.f716a, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        this.ab = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.ab == 1) {
                            Log.e(d.f716a, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.ac = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ac);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.ac) == -2) {
                                this.ac = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.ae = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ae);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.ae) == -2) {
                                this.ae = -2;
                            }
                        }
                        break;
                    case 35:
                        this.ag = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.ag));
                        this.aa = 2;
                        break;
                    case 36:
                        try {
                            this.ad = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ad);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.ad) == -2) {
                                this.ad = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.af = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.af);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.af) == -2) {
                                this.af = -2;
                            }
                        }
                        break;
                    case 38:
                        this.ah = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.ah));
                        this.ab = 2;
                        break;
                    case 44:
                        this.T = typedArrayObtainStyledAttributes.getString(index);
                        this.U = Float.NaN;
                        this.V = -1;
                        if (this.T != null) {
                            int length = this.T.length();
                            int iIndexOf = this.T.indexOf(44);
                            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                i2 = 0;
                            } else {
                                String strSubstring = this.T.substring(0, iIndexOf);
                                if (strSubstring.equalsIgnoreCase("W")) {
                                    this.V = 0;
                                } else if (strSubstring.equalsIgnoreCase("H")) {
                                    this.V = 1;
                                }
                                i2 = iIndexOf + 1;
                            }
                            int iIndexOf2 = this.T.indexOf(58);
                            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                String strSubstring2 = this.T.substring(i2);
                                if (strSubstring2.length() > 0) {
                                    this.U = Float.parseFloat(strSubstring2);
                                }
                            } else {
                                String strSubstring3 = this.T.substring(i2, iIndexOf2);
                                String strSubstring4 = this.T.substring(iIndexOf2 + 1);
                                if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                    try {
                                        float f2 = Float.parseFloat(strSubstring3);
                                        float f3 = Float.parseFloat(strSubstring4);
                                        if (f2 > 0.0f && f3 > 0.0f) {
                                            if (this.V == 1) {
                                                this.U = Math.abs(f3 / f2);
                                            } else {
                                                this.U = Math.abs(f2 / f3);
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                    }
                                }
                            }
                        }
                        break;
                    case 45:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 46:
                        this.X = typedArrayObtainStyledAttributes.getFloat(index, this.X);
                        break;
                    case 47:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.Z = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.ai = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.ai);
                        break;
                    case 50:
                        this.aj = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.aj);
                        break;
                    case 51:
                        this.an = typedArrayObtainStyledAttributes.getString(index);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            c();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.s = -1;
            this.t = -1;
            this.u = -1.0f;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
            this.G = 0.0f;
            this.H = -1;
            this.I = -1;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = -1;
            this.R = 0.5f;
            this.S = 0.5f;
            this.T = null;
            this.U = 0.0f;
            this.V = 1;
            this.W = -1.0f;
            this.X = -1.0f;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 0;
            this.ag = 1.0f;
            this.ah = 1.0f;
            this.ai = -1;
            this.aj = -1;
            this.ak = -1;
            this.al = false;
            this.am = false;
            this.an = null;
            this.ao = d.b;
            this.ap = d.b;
            this.aq = false;
            this.ar = false;
            this.as = false;
            this.at = false;
            this.au = false;
            this.av = -1;
            this.aw = -1;
            this.ax = -1;
            this.ay = -1;
            this.az = -1;
            this.aA = -1;
            this.aB = 0.5f;
            this.aF = new androidx.d.c.b.e();
            this.aG = false;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.s = -1;
            this.t = -1;
            this.u = -1.0f;
            this.v = -1;
            this.w = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
            this.G = 0.0f;
            this.H = -1;
            this.I = -1;
            this.J = -1;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = -1;
            this.R = 0.5f;
            this.S = 0.5f;
            this.T = null;
            this.U = 0.0f;
            this.V = 1;
            this.W = -1.0f;
            this.X = -1.0f;
            this.Y = 0;
            this.Z = 0;
            this.aa = 0;
            this.ab = 0;
            this.ac = 0;
            this.ad = 0;
            this.ae = 0;
            this.af = 0;
            this.ag = 1.0f;
            this.ah = 1.0f;
            this.ai = -1;
            this.aj = -1;
            this.ak = -1;
            this.al = false;
            this.am = false;
            this.an = null;
            this.ao = d.b;
            this.ap = d.b;
            this.aq = false;
            this.ar = false;
            this.as = false;
            this.at = false;
            this.au = false;
            this.av = -1;
            this.aw = -1;
            this.ax = -1;
            this.ay = -1;
            this.az = -1;
            this.aA = -1;
            this.aB = 0.5f;
            this.aF = new androidx.d.c.b.e();
            this.aG = false;
            this.s = aVar.s;
            this.t = aVar.t;
            this.u = aVar.u;
            this.v = aVar.v;
            this.w = aVar.w;
            this.x = aVar.x;
            this.y = aVar.y;
            this.z = aVar.z;
            this.A = aVar.A;
            this.B = aVar.B;
            this.C = aVar.C;
            this.D = aVar.D;
            this.E = aVar.E;
            this.F = aVar.F;
            this.G = aVar.G;
            this.H = aVar.H;
            this.I = aVar.I;
            this.J = aVar.J;
            this.K = aVar.K;
            this.L = aVar.L;
            this.M = aVar.M;
            this.N = aVar.N;
            this.O = aVar.O;
            this.P = aVar.P;
            this.Q = aVar.Q;
            this.R = aVar.R;
            this.S = aVar.S;
            this.T = aVar.T;
            this.U = aVar.U;
            this.V = aVar.V;
            this.W = aVar.W;
            this.X = aVar.X;
            this.Y = aVar.Y;
            this.Z = aVar.Z;
            this.al = aVar.al;
            this.am = aVar.am;
            this.aa = aVar.aa;
            this.ab = aVar.ab;
            this.ac = aVar.ac;
            this.ae = aVar.ae;
            this.ad = aVar.ad;
            this.af = aVar.af;
            this.ag = aVar.ag;
            this.ah = aVar.ah;
            this.ai = aVar.ai;
            this.aj = aVar.aj;
            this.ak = aVar.ak;
            this.ao = aVar.ao;
            this.ap = aVar.ap;
            this.aq = aVar.aq;
            this.ar = aVar.ar;
            this.av = aVar.av;
            this.aw = aVar.aw;
            this.ax = aVar.ax;
            this.ay = aVar.ay;
            this.az = aVar.az;
            this.aA = aVar.aA;
            this.aB = aVar.aB;
            this.an = aVar.an;
            this.aF = aVar.aF;
        }

        public androidx.d.c.b.e a() {
            return this.aF;
        }

        public void a(String str) {
            this.aF.b(str);
        }

        public void b() {
            if (this.aF != null) {
                this.aF.w();
            }
        }

        public void c() {
            this.ar = false;
            this.ao = d.b;
            this.ap = d.b;
            if (this.width == -2 && this.al) {
                this.ao = false;
                if (this.aa == 0) {
                    this.aa = 1;
                }
            }
            if (this.height == -2 && this.am) {
                this.ap = false;
                if (this.ab == 0) {
                    this.ab = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.ao = false;
                if (this.width == 0 && this.aa == 1) {
                    this.width = -2;
                    this.al = d.b;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.ap = false;
                if (this.height == 0 && this.ab == 1) {
                    this.height = -2;
                    this.am = d.b;
                }
            }
            if (this.u == -1.0f && this.s == -1 && this.t == -1) {
                return;
            }
            this.ar = d.b;
            this.ao = d.b;
            this.ap = d.b;
            if (!(this.aF instanceof androidx.d.c.b.h)) {
                this.aF = new androidx.d.c.b.h();
            }
            ((androidx.d.c.b.h) this.aF).a(this.ak);
        }

        public String d() {
            return this.an;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0056  */
        /* JADX WARN: Code duplicated, block: B:22:0x005f  */
        /* JADX WARN: Code duplicated, block: B:25:0x0068  */
        /* JADX WARN: Code duplicated, block: B:28:0x0070  */
        /* JADX WARN: Code duplicated, block: B:31:0x0078  */
        /* JADX WARN: Code duplicated, block: B:38:0x008e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0098  */
        /* JADX WARN: Code duplicated, block: B:41:0x009c  */
        /* JADX WARN: Code duplicated, block: B:42:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:44:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:7:0x0017  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int i2) {
            boolean z;
            int i3 = this.leftMargin;
            int i4 = this.rightMargin;
            boolean z2 = false;
            if (Build.VERSION.SDK_INT >= 17) {
                super.resolveLayoutDirection(i2);
                if (1 == getLayoutDirection()) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.ax = -1;
            this.ay = -1;
            this.av = -1;
            this.aw = -1;
            this.az = -1;
            this.aA = -1;
            this.az = this.L;
            this.aA = this.N;
            this.aB = this.R;
            this.aC = this.s;
            this.aD = this.t;
            this.aE = this.u;
            if (z) {
                if (this.H != -1) {
                    this.ax = this.H;
                } else if (this.I != -1) {
                    this.ay = this.I;
                } else {
                    if (this.J != -1) {
                        this.aw = this.J;
                        z2 = true;
                    }
                    if (this.K != -1) {
                        this.av = this.K;
                        z2 = true;
                    }
                    if (this.P != -1) {
                        this.aA = this.P;
                    }
                    if (this.Q != -1) {
                        this.az = this.Q;
                    }
                    if (z2) {
                        this.aB = 1.0f - this.R;
                    }
                    if (this.ar && this.ak == 1) {
                        if (this.u != -1.0f) {
                            this.aE = 1.0f - this.u;
                            this.aC = -1;
                            this.aD = -1;
                        } else if (this.s != -1) {
                            this.aD = this.s;
                            this.aC = -1;
                            this.aE = -1.0f;
                        } else if (this.t != -1) {
                            this.aC = this.t;
                            this.aD = -1;
                            this.aE = -1.0f;
                        }
                    }
                }
                z2 = true;
                if (this.J != -1) {
                    this.aw = this.J;
                    z2 = true;
                }
                if (this.K != -1) {
                    this.av = this.K;
                    z2 = true;
                }
                if (this.P != -1) {
                    this.aA = this.P;
                }
                if (this.Q != -1) {
                    this.az = this.Q;
                }
                if (z2) {
                    this.aB = 1.0f - this.R;
                }
                if (this.ar) {
                    if (this.u != -1.0f) {
                        this.aE = 1.0f - this.u;
                        this.aC = -1;
                        this.aD = -1;
                    } else if (this.s != -1) {
                        this.aD = this.s;
                        this.aC = -1;
                        this.aE = -1.0f;
                    } else if (this.t != -1) {
                        this.aC = this.t;
                        this.aD = -1;
                        this.aE = -1.0f;
                    }
                }
            } else {
                if (this.H != -1) {
                    this.aw = this.H;
                }
                if (this.I != -1) {
                    this.av = this.I;
                }
                if (this.J != -1) {
                    this.ax = this.J;
                }
                if (this.K != -1) {
                    this.ay = this.K;
                }
                if (this.P != -1) {
                    this.az = this.P;
                }
                if (this.Q != -1) {
                    this.aA = this.Q;
                }
            }
            if (this.J == -1 && this.K == -1 && this.I == -1 && this.H == -1) {
                if (this.x != -1) {
                    this.ax = this.x;
                    if (this.rightMargin <= 0 && i4 > 0) {
                        this.rightMargin = i4;
                    }
                } else if (this.y != -1) {
                    this.ay = this.y;
                    if (this.rightMargin <= 0 && i4 > 0) {
                        this.rightMargin = i4;
                    }
                }
                if (this.v != -1) {
                    this.av = this.v;
                    if (this.leftMargin > 0 || i3 <= 0) {
                        return;
                    }
                    this.leftMargin = i3;
                    return;
                }
                if (this.w != -1) {
                    this.aw = this.w;
                    if (this.leftMargin > 0 || i3 <= 0) {
                        return;
                    }
                    this.leftMargin = i3;
                }
            }
        }
    }

    class b implements androidx.d.c.b.a.b.InterfaceC0050b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d f720a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public b(d dVar) {
            this.f720a = dVar;
        }

        private boolean a(int i, int i2, int i3) {
            if (i == i2) {
                return d.b;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size) {
                return d.b;
            }
            return false;
        }

        @Override // androidx.d.c.b.a.b.InterfaceC0050b
        public final void a() {
            int childCount = this.f720a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f720a.getChildAt(i);
                if (childAt instanceof l) {
                    ((l) childAt).b(this.f720a);
                }
            }
            int size = this.f720a.f.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) this.f720a.f.get(i2)).f(this.f720a);
                }
            }
        }

        public void a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = i;
            this.g = i2;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x0099  */
        @Override // androidx.d.c.b.a.b.InterfaceC0050b
        @SuppressLint({"WrongCall"})
        public final void a(androidx.d.c.b.e eVar, androidx.d.c.b.a.b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int iMax;
            int measuredWidth;
            int i;
            int iMakeMeasureSpec3;
            int baseline;
            int i2;
            if (eVar == null) {
                return;
            }
            if (eVar.E() == 8 && !eVar.s()) {
                aVar.h = 0;
                aVar.i = 0;
                aVar.j = 0;
                return;
            }
            if (eVar.A() == null) {
                return;
            }
            androidx.d.c.b.e.a aVar2 = aVar.d;
            androidx.d.c.b.e.a aVar3 = aVar.e;
            int i3 = aVar.f;
            int i4 = aVar.g;
            int i5 = this.b + this.c;
            int i6 = this.d;
            View view = (View) eVar.aa();
            switch (aVar2) {
                case FIXED:
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, androidx.d.c.b.a.b.b);
                    break;
                case WRAP_CONTENT:
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6, -2);
                    break;
                case MATCH_PARENT:
                    iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6 + eVar.U(), -1);
                    break;
                case MATCH_CONSTRAINT:
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i6, -2);
                    boolean z = eVar.G == 1;
                    if (aVar.m != androidx.d.c.b.a.b.a.b && aVar.m != androidx.d.c.b.a.b.a.c) {
                        iMakeMeasureSpec = childMeasureSpec;
                    } else if (!((aVar.m == androidx.d.c.b.a.b.a.c || !z || (z && (view.getMeasuredHeight() == eVar.L())) || (view instanceof l) || eVar.d()) ? d.b : false)) {
                        iMakeMeasureSpec = childMeasureSpec;
                    } else {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.I(), androidx.d.c.b.a.b.b);
                    }
                    break;
                default:
                    iMakeMeasureSpec = 0;
                    break;
            }
            switch (aVar3) {
                case FIXED:
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, androidx.d.c.b.a.b.b);
                    break;
                case WRAP_CONTENT:
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5, -2);
                    break;
                case MATCH_PARENT:
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5 + eVar.V(), -1);
                    break;
                case MATCH_CONSTRAINT:
                    iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i5, -2);
                    boolean z2 = eVar.H == 1 ? d.b : false;
                    if (aVar.m == androidx.d.c.b.a.b.a.b || aVar.m == androidx.d.c.b.a.b.a.c) {
                        if ((aVar.m == androidx.d.c.b.a.b.a.c || !z2 || (z2 && (view.getMeasuredWidth() == eVar.I() ? d.b : false)) || (view instanceof l) || eVar.e()) ? d.b : false) {
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.L(), androidx.d.c.b.a.b.b);
                        }
                    }
                    break;
                default:
                    iMakeMeasureSpec2 = 0;
                    break;
            }
            androidx.d.c.b.f fVar = (androidx.d.c.b.f) eVar.A();
            if (fVar != null && androidx.d.c.b.k.a(d.this.k, 256) && view.getMeasuredWidth() == eVar.I() && view.getMeasuredWidth() < fVar.I() && view.getMeasuredHeight() == eVar.L() && view.getMeasuredHeight() < fVar.L() && view.getBaseline() == eVar.Z() && !eVar.t()) {
                if ((a(eVar.u(), iMakeMeasureSpec, eVar.I()) && a(eVar.v(), iMakeMeasureSpec2, eVar.L())) ? d.b : false) {
                    aVar.h = eVar.I();
                    aVar.i = eVar.L();
                    aVar.j = eVar.Z();
                    return;
                }
            }
            boolean z3 = aVar2 == androidx.d.c.b.e.a.MATCH_CONSTRAINT ? d.b : false;
            boolean z4 = aVar3 == androidx.d.c.b.e.a.MATCH_CONSTRAINT ? d.b : false;
            boolean z5 = (aVar3 == androidx.d.c.b.e.a.MATCH_PARENT || aVar3 == androidx.d.c.b.e.a.FIXED) ? d.b : false;
            boolean z6 = (aVar2 == androidx.d.c.b.e.a.MATCH_PARENT || aVar2 == androidx.d.c.b.e.a.FIXED) ? d.b : false;
            boolean z7 = (!z3 || eVar.ao <= 0.0f) ? false : d.b;
            boolean z8 = (!z4 || eVar.ao <= 0.0f) ? false : d.b;
            if (view == null) {
                return;
            }
            a aVar4 = (a) view.getLayoutParams();
            if (aVar.m != androidx.d.c.b.a.b.a.b && aVar.m != androidx.d.c.b.a.b.a.c && z3 && eVar.G == 0 && z4 && eVar.H == 0) {
                i2 = -1;
                baseline = 0;
                measuredWidth = 0;
                iMax = 0;
            } else {
                if ((view instanceof o) && (eVar instanceof androidx.d.c.b.m)) {
                    ((o) view).a((androidx.d.c.b.m) eVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                eVar.c(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int baseline2 = view.getBaseline();
                int iMax2 = eVar.J > 0 ? Math.max(eVar.J, measuredWidth2) : measuredWidth2;
                if (eVar.K > 0) {
                    iMax2 = Math.min(eVar.K, iMax2);
                }
                iMax = eVar.M > 0 ? Math.max(eVar.M, measuredHeight) : measuredHeight;
                if (eVar.N > 0) {
                    iMax = Math.min(eVar.N, iMax);
                }
                if (androidx.d.c.b.k.a(d.this.k, 1)) {
                    measuredWidth = iMax2;
                } else if (z7 && z5) {
                    measuredWidth = (int) ((iMax * eVar.ao) + 0.5f);
                } else {
                    if (z8 && z6) {
                        iMax = (int) ((iMax2 / eVar.ao) + 0.5f);
                    }
                    measuredWidth = iMax2;
                }
                if (measuredWidth2 == measuredWidth && measuredHeight == iMax) {
                    baseline = baseline2;
                } else {
                    if (measuredWidth2 != measuredWidth) {
                        i = androidx.d.c.b.a.b.b;
                        iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, androidx.d.c.b.a.b.b);
                    } else {
                        i = androidx.d.c.b.a.b.b;
                    }
                    if (measuredHeight != iMax) {
                        iMakeMeasureSpec3 = iMakeMeasureSpec;
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax, i);
                    }
                    iMakeMeasureSpec3 = iMakeMeasureSpec;
                    view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    eVar.c(iMakeMeasureSpec3, iMakeMeasureSpec2);
                    measuredWidth = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    iMax = measuredHeight2;
                }
                i2 = -1;
            }
            boolean z9 = baseline != i2 ? d.b : false;
            aVar.l = (measuredWidth == aVar.f && iMax == aVar.g) ? false : d.b;
            if (aVar4.aq) {
                z9 = d.b;
            }
            if (z9 && baseline != -1 && eVar.Z() != baseline) {
                aVar.l = d.b;
            }
            aVar.h = measuredWidth;
            aVar.i = iMax;
            aVar.k = z9;
            aVar.j = baseline;
        }
    }

    public d(@ah Context context) {
        super(context);
        this.ac = new SparseArray<>();
        this.f = new ArrayList<>(4);
        this.ad = new androidx.d.c.b.f();
        this.g = 0;
        this.h = 0;
        this.i = ActivityChooserView.a.f166a;
        this.j = ActivityChooserView.a.f166a;
        this.ae = b;
        this.k = 257;
        this.l = null;
        this.af = null;
        this.m = -1;
        this.n = new HashMap<>();
        this.o = -1;
        this.p = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = 0;
        this.aj = 0;
        this.q = new SparseArray<>();
        this.al = new b(this);
        this.t = 0;
        this.u = 0;
        a((AttributeSet) null, 0, 0);
    }

    public d(@ah Context context, @ai AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ac = new SparseArray<>();
        this.f = new ArrayList<>(4);
        this.ad = new androidx.d.c.b.f();
        this.g = 0;
        this.h = 0;
        this.i = ActivityChooserView.a.f166a;
        this.j = ActivityChooserView.a.f166a;
        this.ae = b;
        this.k = 257;
        this.l = null;
        this.af = null;
        this.m = -1;
        this.n = new HashMap<>();
        this.o = -1;
        this.p = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = 0;
        this.aj = 0;
        this.q = new SparseArray<>();
        this.al = new b(this);
        this.t = 0;
        this.u = 0;
        a(attributeSet, 0, 0);
    }

    public d(@ah Context context, @ai AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ac = new SparseArray<>();
        this.f = new ArrayList<>(4);
        this.ad = new androidx.d.c.b.f();
        this.g = 0;
        this.h = 0;
        this.i = ActivityChooserView.a.f166a;
        this.j = ActivityChooserView.a.f166a;
        this.ae = b;
        this.k = 257;
        this.l = null;
        this.af = null;
        this.m = -1;
        this.n = new HashMap<>();
        this.o = -1;
        this.p = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = 0;
        this.aj = 0;
        this.q = new SparseArray<>();
        this.al = new b(this);
        this.t = 0;
        this.u = 0;
        a(attributeSet, i, 0);
    }

    @TargetApi(21)
    public d(@ah Context context, @ai AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.ac = new SparseArray<>();
        this.f = new ArrayList<>(4);
        this.ad = new androidx.d.c.b.f();
        this.g = 0;
        this.h = 0;
        this.i = ActivityChooserView.a.f166a;
        this.j = ActivityChooserView.a.f166a;
        this.ae = b;
        this.k = 257;
        this.l = null;
        this.af = null;
        this.m = -1;
        this.n = new HashMap<>();
        this.o = -1;
        this.p = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = 0;
        this.aj = 0;
        this.q = new SparseArray<>();
        this.al = new b(this);
        this.t = 0;
        this.u = 0;
        a(attributeSet, i, i2);
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        this.ad.a(this);
        this.ad.a((androidx.d.c.b.a.b.InterfaceC0050b) this.al);
        this.ac.put(getId(), this);
        this.l = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.C0052m.ConstraintLayout_Layout, i, i2);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == m.C0052m.ConstraintLayout_Layout_android_minWidth) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == m.C0052m.ConstraintLayout_Layout_android_minHeight) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == m.C0052m.ConstraintLayout_Layout_android_maxWidth) {
                    this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == m.C0052m.ConstraintLayout_Layout_android_maxHeight) {
                    this.j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.j);
                } else if (index == m.C0052m.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.k = typedArrayObtainStyledAttributes.getInt(index, this.k);
                } else if (index == m.C0052m.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            c(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.af = null;
                        }
                    }
                } else if (index == m.C0052m.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.l = new g();
                        this.l.b(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.l = null;
                    }
                    this.m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.ad.a(this.k);
    }

    private boolean a() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                z = b;
                break;
            }
        }
        if (z) {
            b();
        }
        return z;
    }

    private final androidx.d.c.b.e b(int i) {
        if (i == 0) {
            return this.ad;
        }
        View viewFindViewById = this.ac.get(i);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.ad;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((a) viewFindViewById.getLayoutParams()).aF;
    }

    private void b() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            androidx.d.c.b.e eVarA = a(getChildAt(i));
            if (eVarA != null) {
                eVarA.w();
            }
        }
        if (zIsInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    a(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    b(childAt.getId()).b(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.m != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.m && (childAt2 instanceof h)) {
                    this.l = ((h) childAt2).getConstraintSet();
                }
            }
        }
        if (this.l != null) {
            this.l.a(this, b);
        }
        this.ad.aA();
        int size = this.f.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                this.f.get(i4).d(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt3 = getChildAt(i5);
            if (childAt3 instanceof l) {
                ((l) childAt3).a(this);
            }
        }
        this.q.clear();
        this.q.put(0, this.ad);
        this.q.put(getId(), this.ad);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.q.put(childAt4.getId(), a(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            androidx.d.c.b.e eVarA2 = a(childAt5);
            if (eVarA2 != null) {
                a aVar = (a) childAt5.getLayoutParams();
                this.ad.b(eVarA2);
                a(zIsInEditMode, childAt5, eVarA2, aVar, this.q);
            }
        }
    }

    private void c() {
        this.ae = b;
        this.o = -1;
        this.p = -1;
        this.ag = -1;
        this.ah = -1;
        this.ai = 0;
        this.aj = 0;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd()) : 0;
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public final androidx.d.c.b.e a(View view) {
        if (view == this) {
            return this.ad;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).aF;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public Object a(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.n == null || !this.n.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    public void a(int i) {
        if (i == 0) {
            this.af = null;
            return;
        }
        try {
            this.af = new e(getContext(), this, i);
        } catch (Resources.NotFoundException unused) {
            this.af = null;
        }
    }

    public void a(int i, int i2, int i3) {
        if (this.af != null) {
            this.af.b(i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int i5 = this.al.e;
        int i6 = i3 + this.al.d;
        int i7 = i4 + i5;
        if (Build.VERSION.SDK_INT < 11) {
            setMeasuredDimension(i6, i7);
            this.o = i6;
            this.p = i7;
            return;
        }
        int iResolveSizeAndState = resolveSizeAndState(i6, i, 0);
        int iResolveSizeAndState2 = resolveSizeAndState(i7, i2, 0);
        int i8 = iResolveSizeAndState & af.r;
        int i9 = iResolveSizeAndState2 & af.r;
        int iMin = Math.min(this.i, i8);
        int iMin2 = Math.min(this.j, i9);
        if (z) {
            iMin |= 16777216;
        }
        if (z2) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.o = iMin;
        this.p = iMin2;
    }

    public void a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.n.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(androidx.d.c.b.f fVar, int i, int i2, int i3) {
        int iMax;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int iMax2 = Math.max(0, getPaddingTop());
        int iMax3 = Math.max(0, getPaddingBottom());
        int i4 = iMax2 + iMax3;
        int paddingWidth = getPaddingWidth();
        this.al.a(i2, i3, iMax2, iMax3, paddingWidth, i4);
        if (Build.VERSION.SDK_INT >= 17) {
            int iMax4 = Math.max(0, getPaddingStart());
            int iMax5 = Math.max(0, getPaddingEnd());
            if (iMax4 <= 0 && iMax5 <= 0) {
                iMax4 = Math.max(0, getPaddingLeft());
            } else if (j()) {
                iMax4 = iMax5;
            }
            iMax = iMax4;
        } else {
            iMax = Math.max(0, getPaddingLeft());
        }
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        a(fVar, mode, i5, mode2, i6);
        fVar.a(i, mode, i5, mode2, i6, this.o, this.p, iMax, iMax2);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040 A[PHI: r3
      0x0040: PHI (r3v4 androidx.d.c.b.e$a) = (r3v3 androidx.d.c.b.e$a), (r3v0 androidx.d.c.b.e$a) binds: [B:20:0x004c, B:16:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:6:0x001b A[PHI: r2
      0x001b: PHI (r2v4 androidx.d.c.b.e$a) = (r2v3 androidx.d.c.b.e$a), (r2v0 androidx.d.c.b.e$a) binds: [B:9:0x0027, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    protected void a(androidx.d.c.b.f fVar, int i, int i2, int i3, int i4) {
        int i5 = this.al.e;
        int i6 = this.al.d;
        androidx.d.c.b.e.a aVar = androidx.d.c.b.e.a.FIXED;
        androidx.d.c.b.e.a aVar2 = androidx.d.c.b.e.a.FIXED;
        int childCount = getChildCount();
        if (i == Integer.MIN_VALUE) {
            aVar = androidx.d.c.b.e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.g);
            }
        } else if (i == 0) {
            aVar = androidx.d.c.b.e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.g);
            } else {
                i2 = 0;
            }
        } else if (i != 1073741824) {
            i2 = 0;
        } else {
            i2 = Math.min(this.i - i6, i2);
        }
        if (i3 == Integer.MIN_VALUE) {
            aVar2 = androidx.d.c.b.e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.h);
            }
        } else if (i3 == 0) {
            aVar2 = androidx.d.c.b.e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.h);
            } else {
                i4 = 0;
            }
        } else if (i3 != 1073741824) {
            i4 = 0;
        } else {
            i4 = Math.min(this.j - i5, i4);
        }
        if (i2 != fVar.I() || i4 != fVar.L()) {
            fVar.c();
        }
        fVar.n(0);
        fVar.o(0);
        fVar.h(this.i - i6);
        fVar.i(this.j - i5);
        fVar.r(0);
        fVar.s(0);
        fVar.a(aVar);
        fVar.p(i2);
        fVar.b(aVar2);
        fVar.q(i4);
        fVar.r(this.g - i6);
        fVar.s(this.h - i5);
    }

    public void a(androidx.d.c.f fVar) {
        this.s = fVar;
        this.ad.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, View view, androidx.d.c.b.e eVar, a aVar, SparseArray<androidx.d.c.b.e> sparseArray) {
        int i;
        int i2;
        int i3;
        float f;
        androidx.d.c.b.e eVar2;
        androidx.d.c.b.e eVar3;
        androidx.d.c.b.e eVar4;
        androidx.d.c.b.e eVar5;
        aVar.c();
        aVar.aG = false;
        eVar.k(view.getVisibility());
        if (aVar.at) {
            eVar.d(b);
            eVar.k(8);
        }
        eVar.a(view);
        if (view instanceof c) {
            ((c) view).a(eVar, this.ad.as());
        }
        if (aVar.ar) {
            androidx.d.c.b.h hVar = (androidx.d.c.b.h) eVar;
            int i4 = aVar.aC;
            int i5 = aVar.aD;
            float f2 = aVar.aE;
            if (Build.VERSION.SDK_INT < 17) {
                i4 = aVar.s;
                i5 = aVar.t;
                f2 = aVar.u;
            }
            if (f2 != -1.0f) {
                hVar.e(f2);
                return;
            } else if (i4 != -1) {
                hVar.C(i4);
                return;
            } else {
                if (i5 != -1) {
                    hVar.D(i5);
                    return;
                }
                return;
            }
        }
        int i6 = aVar.av;
        int i7 = aVar.aw;
        int i8 = aVar.ax;
        int i9 = aVar.ay;
        int i10 = aVar.az;
        int i11 = aVar.aA;
        float f3 = aVar.aB;
        if (Build.VERSION.SDK_INT < 17) {
            i6 = aVar.v;
            i = aVar.w;
            int i12 = aVar.x;
            i9 = aVar.y;
            int i13 = aVar.L;
            int i14 = aVar.N;
            f3 = aVar.R;
            if (i6 == -1 && i == -1) {
                if (aVar.I != -1) {
                    i6 = aVar.I;
                } else if (aVar.H != -1) {
                    i = aVar.H;
                }
            }
            if (i12 == -1 && i9 == -1) {
                if (aVar.J != -1) {
                    i12 = aVar.J;
                } else if (aVar.K != -1) {
                    i9 = aVar.K;
                }
            }
            i3 = i12;
            i2 = i14;
            i10 = i13;
        } else {
            i = i7;
            i2 = i11;
            i3 = i8;
        }
        float f4 = f3;
        int i15 = i9;
        if (aVar.E != -1) {
            androidx.d.c.b.e eVar6 = sparseArray.get(aVar.E);
            if (eVar6 != null) {
                eVar.a(eVar6, aVar.G, aVar.F);
            }
        } else {
            if (i6 != -1) {
                androidx.d.c.b.e eVar7 = sparseArray.get(i6);
                if (eVar7 != null) {
                    f = f4;
                    eVar.a(androidx.d.c.b.d.a.LEFT, eVar7, androidx.d.c.b.d.a.LEFT, aVar.leftMargin, i10);
                } else {
                    f = f4;
                }
            } else {
                f = f4;
                if (i != -1 && (eVar2 = sparseArray.get(i)) != null) {
                    eVar.a(androidx.d.c.b.d.a.LEFT, eVar2, androidx.d.c.b.d.a.RIGHT, aVar.leftMargin, i10);
                }
            }
            if (i3 != -1) {
                androidx.d.c.b.e eVar8 = sparseArray.get(i3);
                if (eVar8 != null) {
                    eVar.a(androidx.d.c.b.d.a.RIGHT, eVar8, androidx.d.c.b.d.a.LEFT, aVar.rightMargin, i2);
                }
            } else if (i15 != -1 && (eVar3 = sparseArray.get(i15)) != null) {
                eVar.a(androidx.d.c.b.d.a.RIGHT, eVar3, androidx.d.c.b.d.a.RIGHT, aVar.rightMargin, i2);
            }
            if (aVar.z != -1) {
                androidx.d.c.b.e eVar9 = sparseArray.get(aVar.z);
                if (eVar9 != null) {
                    eVar.a(androidx.d.c.b.d.a.TOP, eVar9, androidx.d.c.b.d.a.TOP, aVar.topMargin, aVar.M);
                }
            } else if (aVar.A != -1 && (eVar4 = sparseArray.get(aVar.A)) != null) {
                eVar.a(androidx.d.c.b.d.a.TOP, eVar4, androidx.d.c.b.d.a.BOTTOM, aVar.topMargin, aVar.M);
            }
            if (aVar.B != -1) {
                androidx.d.c.b.e eVar10 = sparseArray.get(aVar.B);
                if (eVar10 != null) {
                    eVar.a(androidx.d.c.b.d.a.BOTTOM, eVar10, androidx.d.c.b.d.a.TOP, aVar.bottomMargin, aVar.O);
                }
            } else if (aVar.C != -1 && (eVar5 = sparseArray.get(aVar.C)) != null) {
                eVar.a(androidx.d.c.b.d.a.BOTTOM, eVar5, androidx.d.c.b.d.a.BOTTOM, aVar.bottomMargin, aVar.O);
            }
            if (aVar.D != -1) {
                View view2 = this.ac.get(aVar.D);
                androidx.d.c.b.e eVar11 = sparseArray.get(aVar.D);
                if (eVar11 != null && view2 != null && (view2.getLayoutParams() instanceof a)) {
                    a aVar2 = (a) view2.getLayoutParams();
                    aVar.aq = b;
                    aVar2.aq = b;
                    eVar.a(androidx.d.c.b.d.a.BASELINE).a(eVar11.a(androidx.d.c.b.d.a.BASELINE), 0, -1, b);
                    eVar.c(b);
                    aVar2.aF.c(b);
                    eVar.a(androidx.d.c.b.d.a.TOP).l();
                    eVar.a(androidx.d.c.b.d.a.BOTTOM).l();
                }
            }
            float f5 = f;
            if (f5 >= 0.0f) {
                eVar.a(f5);
            }
            if (aVar.S >= 0.0f) {
                eVar.b(aVar.S);
            }
        }
        if (z && (aVar.ai != -1 || aVar.aj != -1)) {
            eVar.d(aVar.ai, aVar.aj);
        }
        if (aVar.ao) {
            eVar.a(androidx.d.c.b.e.a.FIXED);
            eVar.p(aVar.width);
            if (aVar.width == -2) {
                eVar.a(androidx.d.c.b.e.a.WRAP_CONTENT);
            }
        } else if (aVar.width == -1) {
            if (aVar.al) {
                eVar.a(androidx.d.c.b.e.a.MATCH_CONSTRAINT);
            } else {
                eVar.a(androidx.d.c.b.e.a.MATCH_PARENT);
            }
            eVar.a(androidx.d.c.b.d.a.LEFT).d = aVar.leftMargin;
            eVar.a(androidx.d.c.b.d.a.RIGHT).d = aVar.rightMargin;
        } else {
            eVar.a(androidx.d.c.b.e.a.MATCH_CONSTRAINT);
            eVar.p(0);
        }
        if (aVar.ap) {
            eVar.b(androidx.d.c.b.e.a.FIXED);
            eVar.q(aVar.height);
            if (aVar.height == -2) {
                eVar.b(androidx.d.c.b.e.a.WRAP_CONTENT);
            }
        } else if (aVar.height == -1) {
            if (aVar.am) {
                eVar.b(androidx.d.c.b.e.a.MATCH_CONSTRAINT);
            } else {
                eVar.b(androidx.d.c.b.e.a.MATCH_PARENT);
            }
            eVar.a(androidx.d.c.b.d.a.TOP).d = aVar.topMargin;
            eVar.a(androidx.d.c.b.d.a.BOTTOM).d = aVar.bottomMargin;
        } else {
            eVar.b(androidx.d.c.b.e.a.MATCH_CONSTRAINT);
            eVar.q(0);
        }
        eVar.c(aVar.T);
        eVar.c(aVar.W);
        eVar.d(aVar.X);
        eVar.w(aVar.Y);
        eVar.x(aVar.Z);
        eVar.a(aVar.aa, aVar.ac, aVar.ae, aVar.ag);
        eVar.b(aVar.ab, aVar.ad, aVar.af, aVar.ah);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    protected void c(int i) {
        this.af = new e(getContext(), this, i);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        if (this.f != null && (size = this.f.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        int i8 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(androidx.core.e.a.a.f);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + i8;
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        c();
        super.forceLayout();
    }

    public View g(int i) {
        return this.ac.get(i);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int getMaxHeight() {
        return this.j;
    }

    public int getMaxWidth() {
        return this.i;
    }

    public int getMinHeight() {
        return this.h;
    }

    public int getMinWidth() {
        return this.g;
    }

    public int getOptimizationLevel() {
        return this.ad.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection()) {
            return b;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            androidx.d.c.b.e eVar = aVar.aF;
            if ((childAt.getVisibility() != 8 || aVar.ar || aVar.as || aVar.au || zIsInEditMode) && !aVar.at) {
                int iG = eVar.G();
                int iH = eVar.H();
                int I = eVar.I() + iG;
                int iL = eVar.L() + iH;
                childAt.layout(iG, iH, I, iL);
                if ((childAt instanceof l) && (content = ((l) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iG, iH, I, iL);
                }
            }
        }
        int size = this.f.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f.get(i6).b(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.ae) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (getChildAt(i3).isLayoutRequested()) {
                    this.ae = b;
                    break;
                }
            }
        }
        if (!this.ae) {
            if (this.t == i && this.u == i2) {
                a(i, i2, this.ad.I(), this.ad.L(), this.ad.aq(), this.ad.ar());
                return;
            }
            if (this.t == i && View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.u) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) >= this.ad.L()) {
                this.t = i;
                this.u = i2;
                a(i, i2, this.ad.I(), this.ad.L(), this.ad.aq(), this.ad.ar());
                return;
            }
        }
        this.t = i;
        this.u = i2;
        this.ad.i(j());
        if (this.ae) {
            this.ae = false;
            if (a()) {
                this.ad.g();
            }
        }
        a(this.ad, this.k, i, i2);
        a(i, i2, this.ad.I(), this.ad.L(), this.ad.aq(), this.ad.ar());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        androidx.d.c.b.e eVarA = a(view);
        if ((view instanceof k) && !(eVarA instanceof androidx.d.c.b.h)) {
            a aVar = (a) view.getLayoutParams();
            aVar.aF = new androidx.d.c.b.h();
            aVar.ar = b;
            ((androidx.d.c.b.h) aVar.aF).a(aVar.ak);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.c();
            ((a) view.getLayoutParams()).as = b;
            if (!this.f.contains(cVar)) {
                this.f.add(cVar);
            }
        }
        this.ac.put(view.getId(), view);
        this.ae = b;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.ac.remove(view.getId());
        this.ad.c(a(view));
        this.f.remove(view);
        this.ae = b;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        c();
        super.requestLayout();
    }

    public void setConstraintSet(g gVar) {
        this.l = gVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        this.ac.remove(getId());
        super.setId(i);
        this.ac.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.j) {
            return;
        }
        this.j = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(i iVar) {
        this.r = iVar;
        if (this.af != null) {
            this.af.a(iVar);
        }
    }

    public void setOptimizationLevel(int i) {
        this.k = i;
        this.ad.a(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
