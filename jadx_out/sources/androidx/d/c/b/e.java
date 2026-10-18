package androidx.d.c.b;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.d.c.b.a.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final int A = 8;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f681a = false;
    public static final int ab = 0;
    public static final int ac = 1;
    public static final int ad = 2;
    public static final int ae = 3;
    public static final int af = 4;
    static final int ai = 0;
    static final int aj = 1;
    public static float az = 0.5f;
    private static final boolean b = false;
    private static final int ba = -2;
    protected static final int f = 1;
    protected static final int g = 2;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 4;
    public static final int u = -1;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 0;
    public static final int z = 4;
    public int E;
    public int F;
    public int G;
    public int H;
    public int[] I;
    public int J;
    public int K;
    public float L;
    public int M;
    public int N;
    public float O;
    public boolean P;
    public boolean Q;
    int R;
    float S;
    public d T;
    public d U;
    public d V;
    public d W;
    public d X;
    d Y;
    d Z;
    float aA;
    float aB;
    int aC;
    int aD;
    int aE;
    int aF;
    boolean aG;
    boolean aH;
    boolean aI;
    boolean aJ;
    boolean aK;
    boolean aL;
    boolean aM;
    int aN;
    int aO;
    boolean aP;
    boolean aQ;
    public float[] aR;
    protected e[] aS;
    protected e[] aT;
    e aU;
    e aV;
    public int aW;
    public int aX;
    private boolean aY;
    private boolean aZ;
    public d aa;
    public d[] ag;
    protected ArrayList<d> ah;
    public a[] ak;
    public e al;
    int am;
    int an;
    public float ao;
    protected int ap;
    protected int aq;
    protected int ar;
    int as;
    int at;
    protected int au;
    protected int av;
    int aw;
    protected int ax;
    protected int ay;
    private int[] bb;
    private float bc;
    private boolean bd;
    private boolean be;
    private boolean bf;
    private int bg;
    private int bh;
    private boolean[] bi;
    private Object bj;
    private int bk;
    private int bl;
    private String bm;
    private String bn;
    private boolean c;
    private boolean d;
    private boolean e;
    public boolean h;
    public p[] i;
    public androidx.d.c.b.a.c j;
    public androidx.d.c.b.a.c k;
    public androidx.d.c.b.a.l l;
    public androidx.d.c.b.a.n m;
    public boolean[] n;
    boolean o;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public e() {
        this.h = false;
        this.i = new p[2];
        this.l = null;
        this.m = null;
        this.n = new boolean[]{true, true};
        this.o = false;
        this.c = true;
        this.d = false;
        this.e = true;
        this.aY = false;
        this.aZ = false;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = new int[2];
        this.J = 0;
        this.K = 0;
        this.L = 1.0f;
        this.M = 0;
        this.N = 0;
        this.O = 1.0f;
        this.R = -1;
        this.S = 1.0f;
        this.bb = new int[]{ActivityChooserView.a.f166a, ActivityChooserView.a.f166a};
        this.bc = 0.0f;
        this.bd = false;
        this.bf = false;
        this.bg = 0;
        this.bh = 0;
        this.T = new d(this, d.a.LEFT);
        this.U = new d(this, d.a.TOP);
        this.V = new d(this, d.a.RIGHT);
        this.W = new d(this, d.a.BOTTOM);
        this.X = new d(this, d.a.BASELINE);
        this.Y = new d(this, d.a.CENTER_X);
        this.Z = new d(this, d.a.CENTER_Y);
        this.aa = new d(this, d.a.CENTER);
        this.ag = new d[]{this.T, this.V, this.U, this.W, this.X, this.aa};
        this.ah = new ArrayList<>();
        this.bi = new boolean[2];
        this.ak = new a[]{a.FIXED, a.FIXED};
        this.al = null;
        this.am = 0;
        this.an = 0;
        this.ao = 0.0f;
        this.ap = -1;
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.aA = az;
        this.aB = az;
        this.bk = 0;
        this.bl = 0;
        this.bm = null;
        this.bn = null;
        this.aM = false;
        this.aN = 0;
        this.aO = 0;
        this.aR = new float[]{-1.0f, -1.0f};
        this.aS = new e[]{null, null};
        this.aT = new e[]{null, null};
        this.aU = null;
        this.aV = null;
        this.aW = -1;
        this.aX = -1;
        b();
    }

    public e(int i, int i2) {
        this(0, 0, i, i2);
    }

    public e(int i, int i2, int i3, int i4) {
        this.h = false;
        this.i = new p[2];
        this.l = null;
        this.m = null;
        this.n = new boolean[]{true, true};
        this.o = false;
        this.c = true;
        this.d = false;
        this.e = true;
        this.aY = false;
        this.aZ = false;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = new int[2];
        this.J = 0;
        this.K = 0;
        this.L = 1.0f;
        this.M = 0;
        this.N = 0;
        this.O = 1.0f;
        this.R = -1;
        this.S = 1.0f;
        this.bb = new int[]{ActivityChooserView.a.f166a, ActivityChooserView.a.f166a};
        this.bc = 0.0f;
        this.bd = false;
        this.bf = false;
        this.bg = 0;
        this.bh = 0;
        this.T = new d(this, d.a.LEFT);
        this.U = new d(this, d.a.TOP);
        this.V = new d(this, d.a.RIGHT);
        this.W = new d(this, d.a.BOTTOM);
        this.X = new d(this, d.a.BASELINE);
        this.Y = new d(this, d.a.CENTER_X);
        this.Z = new d(this, d.a.CENTER_Y);
        this.aa = new d(this, d.a.CENTER);
        this.ag = new d[]{this.T, this.V, this.U, this.W, this.X, this.aa};
        this.ah = new ArrayList<>();
        this.bi = new boolean[2];
        this.ak = new a[]{a.FIXED, a.FIXED};
        this.al = null;
        this.am = 0;
        this.an = 0;
        this.ao = 0.0f;
        this.ap = -1;
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.aA = az;
        this.aB = az;
        this.bk = 0;
        this.bl = 0;
        this.bm = null;
        this.bn = null;
        this.aM = false;
        this.aN = 0;
        this.aO = 0;
        this.aR = new float[]{-1.0f, -1.0f};
        this.aS = new e[]{null, null};
        this.aT = new e[]{null, null};
        this.aU = null;
        this.aV = null;
        this.aW = -1;
        this.aX = -1;
        this.aq = i;
        this.ar = i2;
        this.am = i3;
        this.an = i4;
        b();
    }

    public e(String str) {
        this.h = false;
        this.i = new p[2];
        this.l = null;
        this.m = null;
        this.n = new boolean[]{true, true};
        this.o = false;
        this.c = true;
        this.d = false;
        this.e = true;
        this.aY = false;
        this.aZ = false;
        this.E = -1;
        this.F = -1;
        this.G = 0;
        this.H = 0;
        this.I = new int[2];
        this.J = 0;
        this.K = 0;
        this.L = 1.0f;
        this.M = 0;
        this.N = 0;
        this.O = 1.0f;
        this.R = -1;
        this.S = 1.0f;
        this.bb = new int[]{ActivityChooserView.a.f166a, ActivityChooserView.a.f166a};
        this.bc = 0.0f;
        this.bd = false;
        this.bf = false;
        this.bg = 0;
        this.bh = 0;
        this.T = new d(this, d.a.LEFT);
        this.U = new d(this, d.a.TOP);
        this.V = new d(this, d.a.RIGHT);
        this.W = new d(this, d.a.BOTTOM);
        this.X = new d(this, d.a.BASELINE);
        this.Y = new d(this, d.a.CENTER_X);
        this.Z = new d(this, d.a.CENTER_Y);
        this.aa = new d(this, d.a.CENTER);
        this.ag = new d[]{this.T, this.V, this.U, this.W, this.X, this.aa};
        this.ah = new ArrayList<>();
        this.bi = new boolean[2];
        this.ak = new a[]{a.FIXED, a.FIXED};
        this.al = null;
        this.am = 0;
        this.an = 0;
        this.ao = 0.0f;
        this.ap = -1;
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.aA = az;
        this.aB = az;
        this.bk = 0;
        this.bl = 0;
        this.bm = null;
        this.bn = null;
        this.aM = false;
        this.aN = 0;
        this.aO = 0;
        this.aR = new float[]{-1.0f, -1.0f};
        this.aS = new e[]{null, null};
        this.aT = new e[]{null, null};
        this.aU = null;
        this.aV = null;
        this.aW = -1;
        this.aX = -1;
        b();
        b(str);
    }

    public e(String str, int i, int i2) {
        this(i, i2);
        b(str);
    }

    public e(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        b(str);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:126:0x0231  */
    /* JADX WARN: Code duplicated, block: B:128:0x023a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:175:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:176:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:215:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:217:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:223:0x03da  */
    /* JADX WARN: Code duplicated, block: B:225:0x040c  */
    /* JADX WARN: Code duplicated, block: B:232:0x0430 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:233:0x0432  */
    /* JADX WARN: Code duplicated, block: B:241:0x0445  */
    /* JADX WARN: Code duplicated, block: B:244:0x0461  */
    /* JADX WARN: Code duplicated, block: B:252:0x0479  */
    /* JADX WARN: Code duplicated, block: B:254:0x0481  */
    /* JADX WARN: Code duplicated, block: B:276:0x04af  */
    /* JADX WARN: Code duplicated, block: B:278:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:286:0x04d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:287:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:288:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:290:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:299:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:303:0x04fe A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:322:0x0531  */
    /* JADX WARN: Code duplicated, block: B:352:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    private void a(androidx.d.c.e eVar, boolean z2, boolean z3, boolean z4, boolean z5, androidx.d.c.i iVar, androidx.d.c.i iVar2, a aVar, boolean z6, d dVar, d dVar2, int i, int i2, int i3, int i4, float f2, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i5, int i6, int i7, int i8, float f3, boolean z12) {
        boolean z13;
        int iMin;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z14;
        androidx.d.c.i iVarA;
        androidx.d.c.i iVar3;
        int i14;
        char c;
        int i15;
        androidx.d.c.i iVar4;
        boolean z15;
        int i16;
        boolean z16;
        boolean z17;
        int i17;
        boolean z18;
        int i18;
        boolean z19;
        e eVar2;
        androidx.d.c.i iVar5;
        boolean z20;
        int i19;
        boolean z21;
        androidx.d.c.i iVar6;
        androidx.d.c.i iVar7;
        androidx.d.c.i iVar8;
        int iMin2;
        int i20;
        int iJ;
        e eVar3;
        int i21;
        boolean z22;
        int i22;
        int i23;
        boolean z23;
        int i24;
        int i25 = i7;
        int i26 = i8;
        androidx.d.c.i iVarA2 = eVar.a(dVar);
        androidx.d.c.i iVarA3 = eVar.a(dVar2);
        androidx.d.c.i iVarA4 = eVar.a(dVar.k());
        androidx.d.c.i iVarA5 = eVar.a(dVar2.k());
        if (androidx.d.c.e.a() != null) {
            androidx.d.c.e.a().H++;
        }
        boolean zM = dVar.m();
        boolean zM2 = dVar2.m();
        boolean zM3 = this.aa.m();
        int i27 = zM ? 1 : 0;
        if (zM2) {
            i27++;
        }
        if (zM3) {
            i27++;
        }
        int i28 = i27;
        int i29 = z7 ? 3 : i5;
        switch (aVar) {
            case MATCH_CONSTRAINT:
                if (i29 != 4) {
                    z13 = true;
                    break;
                }
            case FIXED:
            case WRAP_CONTENT:
            case MATCH_PARENT:
            default:
                z13 = false;
                break;
        }
        if (this.bl == 8) {
            iMin = 0;
            z13 = false;
        } else {
            iMin = i2;
        }
        if (z12) {
            if (!zM && !zM2 && !zM3) {
                eVar.a(iVarA2, i);
            } else if (zM && !zM2) {
                i9 = 8;
                eVar.c(iVarA2, iVarA4, dVar.j(), 8);
            }
            i9 = 8;
        } else {
            i9 = 8;
        }
        if (z13) {
            i10 = i28;
            if (i10 == 2 || z7 || !(i29 == 1 || i29 == 0)) {
                if (i25 == -2) {
                    i25 = iMin;
                }
                if (i26 == -2) {
                    i26 = iMin;
                }
                if (iMin > 0 && i29 != 1) {
                    iMin = 0;
                }
                if (i25 > 0) {
                    eVar.a(iVarA3, iVarA2, i25, 8);
                    iMin = Math.max(iMin, i25);
                }
                if (i26 > 0) {
                    if ((z3 && i29 == 1) ? false : true) {
                        i11 = 8;
                        eVar.b(iVarA3, iVarA2, i26, 8);
                    } else {
                        i11 = 8;
                    }
                    iMin = Math.min(iMin, i26);
                } else {
                    i11 = 8;
                }
                if (i29 == 1) {
                    if (z3) {
                        eVar.c(iVarA3, iVarA2, iMin, i11);
                        i12 = 4;
                    } else {
                        i12 = 4;
                        if (z9) {
                            eVar.c(iVarA3, iVarA2, iMin, 5);
                            eVar.b(iVarA3, iVarA2, iMin, i11);
                        } else {
                            eVar.c(iVarA3, iVarA2, iMin, 5);
                            eVar.b(iVarA3, iVarA2, iMin, i11);
                        }
                    }
                    i13 = i25;
                } else {
                    i12 = 4;
                    if (i29 == 2) {
                        if (dVar.i() == d.a.TOP || dVar.i() == d.a.BOTTOM) {
                            this = this;
                            androidx.d.c.i iVarA6 = eVar.a(this.al.a(d.a.TOP));
                            iVarA = eVar.a(this.al.a(d.a.BOTTOM));
                            iVar3 = iVarA6;
                        } else {
                            this = this;
                            androidx.d.c.i iVarA7 = eVar.a(this.al.a(d.a.LEFT));
                            iVarA = eVar.a(this.al.a(d.a.RIGHT));
                            iVar3 = iVarA7;
                        }
                        eVar.a(eVar.c().a(iVarA3, iVarA2, iVarA, iVar3, f3));
                        z14 = z5;
                        i13 = i25;
                        z13 = false;
                    } else {
                        this = this;
                        i13 = i25;
                        z13 = z13;
                        z14 = true;
                    }
                }
            } else {
                int iMax = Math.max(i25, iMin);
                if (i26 > 0) {
                    iMax = Math.min(i26, iMax);
                }
                eVar.c(iVarA3, iVarA2, iMax, 8);
                z14 = z5;
                i13 = i25;
                this = this;
                z13 = false;
                i12 = 4;
            }
            if (z12) {
                i14 = 8;
                c = 1;
                i15 = 2;
            } else {
                if (z9) {
                    if ((!zM || zM2 || zM3) && (!zM || zM2)) {
                        if (!zM || !zM2) {
                            iVar4 = iVarA5;
                            if (!zM && zM2) {
                                e eVar4 = dVar.c.f678a;
                                e eVar5 = dVar2.c.f678a;
                                e eVarA = A();
                                int i30 = 6;
                                if (z13) {
                                    if (i29 == 0) {
                                        if (i26 != 0 || i13 != 0) {
                                            z16 = true;
                                            z23 = false;
                                            z17 = true;
                                            i18 = 5;
                                            i17 = 5;
                                        } else if (iVarA4.o && iVar4.o) {
                                            eVar.c(iVarA2, iVarA4, dVar.j(), 8);
                                            eVar.c(iVarA3, iVar4, -dVar2.j(), 8);
                                            return;
                                        } else {
                                            i18 = 8;
                                            i17 = 8;
                                            z16 = false;
                                            z23 = true;
                                            z17 = false;
                                        }
                                        if ((eVar4 instanceof androidx.d.c.b.a) || (eVar5 instanceof androidx.d.c.b.a)) {
                                            i17 = i12;
                                        }
                                        z15 = true;
                                        iVar2 = iVar2;
                                        i16 = 8;
                                        z18 = z23;
                                        i30 = 6;
                                    } else {
                                        i16 = 8;
                                        if (i29 == 1) {
                                            iVarA3 = iVarA3;
                                            i30 = 6;
                                            i18 = 8;
                                            i17 = i12;
                                            z16 = true;
                                            z15 = true;
                                            iVar2 = iVar2;
                                            z18 = false;
                                        } else if (i29 != 3) {
                                            z15 = true;
                                            iVarA3 = iVarA3;
                                            i30 = 6;
                                            i17 = i12;
                                            z16 = false;
                                            iVar2 = iVar2;
                                            z18 = false;
                                            i18 = 5;
                                            z17 = false;
                                        } else if (this.R == -1) {
                                            if (z10) {
                                                if (z3) {
                                                    iVarA3 = iVarA3;
                                                    i18 = 8;
                                                    z16 = true;
                                                    z15 = true;
                                                    i30 = 5;
                                                } else {
                                                    i18 = 8;
                                                    i30 = i12;
                                                }
                                                z18 = true;
                                                i17 = 5;
                                            } else {
                                                i30 = 8;
                                                i18 = 8;
                                            }
                                            z16 = true;
                                            z15 = true;
                                            z18 = true;
                                            i17 = 5;
                                        } else {
                                            if (z7) {
                                                if (i6 != 2) {
                                                    z15 = true;
                                                    if (i6 != 1) {
                                                        z22 = false;
                                                    }
                                                    if (z22) {
                                                        i22 = i12;
                                                        i23 = 5;
                                                    } else {
                                                        i23 = 8;
                                                        i22 = 5;
                                                    }
                                                    i18 = i23;
                                                    i17 = i22;
                                                    z16 = z15;
                                                    z18 = z16;
                                                    z17 = z18;
                                                } else {
                                                    z15 = true;
                                                }
                                                z22 = z15;
                                                if (z22) {
                                                    i23 = 8;
                                                    i22 = 5;
                                                } else {
                                                    i22 = i12;
                                                    i23 = 5;
                                                }
                                                i18 = i23;
                                                i17 = i22;
                                                z16 = z15;
                                                z18 = z16;
                                                z17 = z18;
                                            } else {
                                                z15 = true;
                                                if (i26 > 0) {
                                                    z16 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                    iVarA3 = iVarA3;
                                                    i30 = 6;
                                                    iVar2 = iVar2;
                                                    i18 = 5;
                                                    i17 = 5;
                                                } else if (i26 != 0 || i13 != 0) {
                                                    z16 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                    i17 = i12;
                                                } else if (z10) {
                                                    i18 = (eVar4 == eVarA || eVar5 == eVarA) ? 5 : i12;
                                                    z16 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                    i17 = i12;
                                                } else {
                                                    z16 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                    i17 = 8;
                                                }
                                            }
                                            iVar2 = iVar2;
                                        }
                                        z17 = true;
                                    }
                                    if (z17 || iVarA4 != iVar4 || eVar4 == eVarA) {
                                        z19 = z15;
                                    } else {
                                        z19 = false;
                                        z17 = false;
                                    }
                                    if (z16) {
                                        if (z13 && !z8 && !z10 && iVarA4 == iVar && iVar4 == iVar2) {
                                            i30 = i16;
                                            i19 = i30;
                                            z21 = false;
                                            z20 = false;
                                        } else {
                                            z20 = z19;
                                            i19 = i18;
                                            z21 = z3;
                                        }
                                        iVar5 = iVarA3;
                                        eVar2 = eVarA;
                                        eVar.a(iVarA2, iVarA4, dVar.j(), f2, iVar4, iVar5, dVar2.j(), i30);
                                    } else {
                                        eVar2 = eVarA;
                                        iVar5 = iVarA3;
                                        z20 = z19;
                                        i19 = i18;
                                        z21 = z3;
                                    }
                                    if (this.bl != i16 && !dVar2.b()) {
                                        return;
                                    }
                                    if (z17) {
                                        if (z21) {
                                            iVar6 = iVarA4;
                                            iVar7 = iVar4;
                                            if (iVar6 == iVar7 && !z13 && ((eVar4 instanceof androidx.d.c.b.a) || (eVar5 instanceof androidx.d.c.b.a))) {
                                                i21 = 6;
                                            }
                                            iVar8 = iVarA2;
                                            eVar.a(iVar8, iVar6, dVar.j(), i21);
                                            iVarA3 = iVar5;
                                            eVar.b(iVarA3, iVar7, -dVar2.j(), i21);
                                            i19 = i21;
                                        } else {
                                            iVar6 = iVarA4;
                                            iVar7 = iVar4;
                                        }
                                        i21 = i19;
                                        iVar8 = iVarA2;
                                        eVar.a(iVar8, iVar6, dVar.j(), i21);
                                        iVarA3 = iVar5;
                                        eVar.b(iVarA3, iVar7, -dVar2.j(), i21);
                                        i19 = i21;
                                    } else {
                                        iVar6 = iVarA4;
                                        iVarA3 = iVar5;
                                        iVar7 = iVar4;
                                        iVar8 = iVarA2;
                                    }
                                    if (z21 || !z11 || (eVar4 instanceof androidx.d.c.b.a) || (eVar5 instanceof androidx.d.c.b.a)) {
                                        iMin2 = i17;
                                        i20 = i19;
                                        z15 = z20;
                                    } else {
                                        iMin2 = 6;
                                        i20 = 6;
                                    }
                                    if (z15) {
                                        if (z18 || (z10 && !z4)) {
                                            eVar3 = eVar2;
                                        } else {
                                            eVar3 = eVar2;
                                            if (eVar4 != eVar3 && eVar5 != eVar3) {
                                                i30 = iMin2;
                                            }
                                            if ((eVar4 instanceof h) || (eVar5 instanceof h)) {
                                                i30 = 5;
                                            }
                                            if ((eVar4 instanceof androidx.d.c.b.a) || (eVar5 instanceof androidx.d.c.b.a)) {
                                                i30 = 5;
                                            }
                                            iMin2 = Math.max(z10 ? 5 : i30, iMin2);
                                        }
                                        if (z21) {
                                            iMin2 = Math.min(i20, iMin2);
                                            if (z7 && !z10 && (eVar4 == eVar3 || eVar5 == eVar3)) {
                                                iMin2 = i12;
                                            }
                                        }
                                        eVar.c(iVar8, iVar6, dVar.j(), iMin2);
                                        eVar.c(iVarA3, iVar7, -dVar2.j(), iMin2);
                                    }
                                    if (z21) {
                                        if (iVar == iVar6) {
                                            iJ = dVar.j();
                                        } else {
                                            iJ = 0;
                                        }
                                        if (iVar6 != iVar) {
                                            eVar.a(iVar8, iVar, iJ, 5);
                                        }
                                    }
                                    if (z21 && z13 && i3 == 0 && i13 == 0) {
                                        if (z13 || i29 != 3) {
                                            eVar.a(iVarA3, iVar8, 0, 5);
                                        } else {
                                            eVar.a(iVarA3, iVar8, 0, i16);
                                        }
                                    }
                                } else {
                                    z15 = true;
                                    i16 = 8;
                                    if (iVarA4.o && iVar4.o) {
                                        eVar.a(iVarA2, iVarA4, dVar.j(), f2, iVar4, iVarA3, dVar2.j(), 8);
                                        if (z3 && z14) {
                                            int iJ2 = dVar2.c != null ? dVar2.j() : 0;
                                            if (iVar4 != iVar2) {
                                                eVar.a(iVar2, iVarA3, iJ2, 5);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    iVarA3 = iVarA3;
                                    z16 = true;
                                    z17 = true;
                                    i30 = 6;
                                    i17 = i12;
                                    z18 = false;
                                }
                                i18 = 5;
                                if (z17) {
                                    z19 = z15;
                                } else {
                                    z19 = z15;
                                }
                                if (z16) {
                                    if (z13) {
                                        z20 = z19;
                                        i19 = i18;
                                        z21 = z3;
                                    } else {
                                        z20 = z19;
                                        i19 = i18;
                                        z21 = z3;
                                    }
                                    iVar5 = iVarA3;
                                    eVar2 = eVarA;
                                    eVar.a(iVarA2, iVarA4, dVar.j(), f2, iVar4, iVar5, dVar2.j(), i30);
                                } else {
                                    eVar2 = eVarA;
                                    iVar5 = iVarA3;
                                    z20 = z19;
                                    i19 = i18;
                                    z21 = z3;
                                }
                                if (this.bl != i16) {
                                }
                                if (z17) {
                                    if (z21) {
                                        iVar6 = iVarA4;
                                        iVar7 = iVar4;
                                        if (iVar6 == iVar7) {
                                        }
                                        iVar8 = iVarA2;
                                        eVar.a(iVar8, iVar6, dVar.j(), i21);
                                        iVarA3 = iVar5;
                                        eVar.b(iVarA3, iVar7, -dVar2.j(), i21);
                                        i19 = i21;
                                    } else {
                                        iVar6 = iVarA4;
                                        iVar7 = iVar4;
                                    }
                                    i21 = i19;
                                    iVar8 = iVarA2;
                                    eVar.a(iVar8, iVar6, dVar.j(), i21);
                                    iVarA3 = iVar5;
                                    eVar.b(iVarA3, iVar7, -dVar2.j(), i21);
                                    i19 = i21;
                                } else {
                                    iVar6 = iVarA4;
                                    iVarA3 = iVar5;
                                    iVar7 = iVar4;
                                    iVar8 = iVarA2;
                                }
                                if (z21) {
                                    iMin2 = i17;
                                    i20 = i19;
                                    z15 = z20;
                                } else {
                                    iMin2 = i17;
                                    i20 = i19;
                                    z15 = z20;
                                }
                                if (z15) {
                                    if (z18) {
                                        eVar3 = eVar2;
                                    } else {
                                        eVar3 = eVar2;
                                    }
                                    if (z21) {
                                        iMin2 = Math.min(i20, iMin2);
                                        if (z7) {
                                            iMin2 = i12;
                                        }
                                    }
                                    eVar.c(iVar8, iVar6, dVar.j(), iMin2);
                                    eVar.c(iVarA3, iVar7, -dVar2.j(), iMin2);
                                }
                                if (z21) {
                                    if (iVar == iVar6) {
                                        iJ = dVar.j();
                                    } else {
                                        iJ = 0;
                                    }
                                    if (iVar6 != iVar) {
                                        eVar.a(iVar8, iVar, iJ, 5);
                                    }
                                }
                                if (z21) {
                                    if (z13) {
                                        eVar.a(iVarA3, iVar8, 0, 5);
                                    } else {
                                        eVar.a(iVarA3, iVar8, 0, 5);
                                    }
                                }
                            }
                            if (z21 || !z14) {
                                return;
                            }
                            int iJ3 = dVar2.c != null ? dVar2.j() : 0;
                            if (iVar7 != iVar2) {
                                if (!this.d || !iVarA3.o || this.al == null) {
                                    eVar.a(iVar2, iVarA3, iJ3, 5);
                                    return;
                                }
                                f fVar = (f) this.al;
                                if (z2) {
                                    fVar.e(dVar2);
                                    return;
                                } else {
                                    fVar.d(dVar2);
                                    return;
                                }
                            }
                            return;
                        }
                        iVar4 = iVarA5;
                        eVar.c(iVarA3, iVar4, -dVar2.j(), 8);
                        if (z3) {
                            if (this.d && iVarA2.o && this.al != null) {
                                f fVar2 = (f) this.al;
                                if (z2) {
                                    fVar2.c(dVar);
                                } else {
                                    fVar2.b(dVar);
                                }
                            } else {
                                eVar.a(iVarA2, iVar, 0, 5);
                            }
                        }
                        iVar7 = iVar4;
                    } else {
                        iVar7 = iVarA5;
                    }
                    z21 = z3;
                    if (z21) {
                        return;
                    } else {
                        return;
                    }
                }
                i14 = 8;
                i15 = 2;
                c = 1;
            }
            if (i10 >= i15 && z3 && z14) {
                eVar.a(iVarA2, iVar, 0, i14);
                char c2 = (z2 || this.X.c == null) ? c : (char) 0;
                if (z2 || this.X.c == null) {
                    c = c2;
                } else {
                    e eVar6 = this.X.c.f678a;
                    if (eVar6.ao == 0.0f || eVar6.ak[0] != a.MATCH_CONSTRAINT || eVar6.ak[c] != a.MATCH_CONSTRAINT) {
                        c = 0;
                    }
                }
                if (c != 0) {
                    eVar.a(iVar2, iVarA3, 0, i14);
                    return;
                }
                return;
            }
            return;
        }
        if (z6) {
            eVar.c(iVarA3, iVarA2, 0, 3);
            if (i3 > 0) {
                i24 = 8;
                eVar.a(iVarA3, iVarA2, i3, 8);
            } else {
                i24 = 8;
            }
            if (i4 < Integer.MAX_VALUE) {
                eVar.b(iVarA3, iVarA2, i4, i24);
            }
        } else {
            eVar.c(iVarA3, iVarA2, iMin, i9);
        }
        i13 = i25;
        i10 = i28;
        i12 = 4;
        z14 = z5;
        if (z12) {
            i14 = 8;
            c = 1;
            i15 = 2;
        } else {
            if (z9) {
                if (zM) {
                    if (!zM) {
                        iVar4 = iVarA5;
                        if (!zM) {
                        }
                        iVar7 = iVar4;
                        z21 = z3;
                    } else {
                        iVar4 = iVarA5;
                        if (!zM) {
                        }
                        iVar7 = iVar4;
                        z21 = z3;
                    }
                } else if (!zM) {
                    iVar4 = iVarA5;
                    if (!zM) {
                    }
                    iVar7 = iVar4;
                    z21 = z3;
                } else {
                    iVar4 = iVarA5;
                    if (!zM) {
                    }
                    iVar7 = iVar4;
                    z21 = z3;
                }
                if (z21) {
                    return;
                } else {
                    return;
                }
            }
            i14 = 8;
            i15 = 2;
            c = 1;
        }
        if (i10 >= i15) {
        }
    }

    private boolean a(int i) {
        int i2 = i * 2;
        if (this.ag[i2].c != null && this.ag[i2].c.c != this.ag[i2]) {
            int i3 = i2 + 1;
            if (this.ag[i3].c != null && this.ag[i3].c.c == this.ag[i3]) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        this.ah.add(this.T);
        this.ah.add(this.U);
        this.ah.add(this.V);
        this.ah.add(this.W);
        this.ah.add(this.Y);
        this.ah.add(this.Z);
        this.ah.add(this.aa);
        this.ah.add(this.X);
    }

    public e A() {
        return this.al;
    }

    public e A(int i) {
        if (i == 0) {
            if (this.V.c == null || this.V.c.c != this.V) {
                return null;
            }
            return this.V.c.f678a;
        }
        if (i == 1 && this.W.c != null && this.W.c.c == this.W) {
            return this.W.c.f678a;
        }
        return null;
    }

    public boolean B() {
        return this.P;
    }

    public boolean C() {
        return this.Q;
    }

    public String D() {
        return this.bn;
    }

    public int E() {
        return this.bl;
    }

    public String F() {
        return this.bm;
    }

    public int G() {
        return (this.al == null || !(this.al instanceof f)) ? this.aq : ((f) this.al).aZ + this.aq;
    }

    public int H() {
        return (this.al == null || !(this.al instanceof f)) ? this.ar : ((f) this.al).ba + this.ar;
    }

    public int I() {
        if (this.bl == 8) {
            return 0;
        }
        return this.am;
    }

    public int J() {
        int iMax;
        int i = this.am;
        if (this.ak[0] != a.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.G == 1) {
            iMax = Math.max(this.J, i);
        } else if (this.J > 0) {
            iMax = this.J;
            this.am = iMax;
        } else {
            iMax = 0;
        }
        return (this.K <= 0 || this.K >= iMax) ? iMax : this.K;
    }

    public int K() {
        int iMax;
        int i = this.an;
        if (this.ak[1] != a.MATCH_CONSTRAINT) {
            return i;
        }
        if (this.H == 1) {
            iMax = Math.max(this.M, i);
        } else if (this.M > 0) {
            iMax = this.M;
            this.an = iMax;
        } else {
            iMax = 0;
        }
        return (this.N <= 0 || this.N >= iMax) ? iMax : this.N;
    }

    public int L() {
        if (this.bl == 8) {
            return 0;
        }
        return this.an;
    }

    protected int M() {
        return this.aq + this.au;
    }

    protected int N() {
        return this.ar + this.av;
    }

    public int O() {
        return this.ax;
    }

    public int P() {
        return this.ay;
    }

    public int Q() {
        return G();
    }

    public int R() {
        return H();
    }

    public int S() {
        return G() + this.am;
    }

    public int T() {
        return H() + this.an;
    }

    public int U() {
        int i = this.T != null ? 0 + this.T.d : 0;
        return this.V != null ? i + this.V.d : i;
    }

    public int V() {
        int i = this.T != null ? 0 + this.U.d : 0;
        return this.V != null ? i + this.W.d : i;
    }

    public float W() {
        return this.aA;
    }

    public float X() {
        return this.aB;
    }

    public boolean Y() {
        return this.bd;
    }

    public int Z() {
        return this.aw;
    }

    public d a(d.a aVar) {
        switch (aVar) {
            case LEFT:
                return this.T;
            case TOP:
                return this.U;
            case RIGHT:
                return this.V;
            case BOTTOM:
                return this.W;
            case BASELINE:
                return this.X;
            case CENTER:
                return this.aa;
            case CENTER_X:
                return this.Y;
            case CENTER_Y:
                return this.Z;
            case NONE:
                return null;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public void a(float f2) {
        this.aA = f2;
    }

    public void a(float f2, int i) {
        this.ao = f2;
        this.ap = i;
    }

    public void a(int i, int i2) {
        this.T.a(i);
        this.V.a(i2);
        this.aq = i;
        this.am = i2 - i;
        this.aY = true;
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 0) {
            h(i, i2);
        } else if (i3 == 1) {
            i(i, i2);
        }
    }

    public void a(int i, int i2, int i3, float f2) {
        this.G = i;
        this.J = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.K = i3;
        this.L = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || this.G != 0) {
            return;
        }
        this.G = 2;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.aq = i;
        this.ar = i2;
        if (this.bl == 8) {
            this.am = 0;
            this.an = 0;
            return;
        }
        if (this.ak[0] == a.FIXED && i5 < this.am) {
            i5 = this.am;
        }
        if (this.ak[1] == a.FIXED && i6 < this.an) {
            i6 = this.an;
        }
        this.am = i5;
        this.an = i6;
        if (this.an < this.ay) {
            this.an = this.ay;
        }
        if (this.am < this.ax) {
            this.am = this.ax;
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        a(i, i2, i3, i4);
        u(i5);
        if (i6 == 0) {
            this.aY = true;
            this.aZ = false;
        } else if (i6 == 1) {
            this.aY = false;
            this.aZ = true;
        } else if (i6 == 2) {
            this.aY = true;
            this.aZ = true;
        } else {
            this.aY = false;
            this.aZ = false;
        }
    }

    protected void a(int i, boolean z2) {
        this.bi[i] = z2;
    }

    public void a(d.a aVar, int i) {
        switch (aVar) {
            case LEFT:
                this.T.e = i;
                break;
            case TOP:
                this.U.e = i;
                break;
            case RIGHT:
                this.V.e = i;
                break;
            case BOTTOM:
                this.W.e = i;
                break;
        }
    }

    public void a(d.a aVar, e eVar, d.a aVar2) {
        a(aVar, eVar, aVar2, 0);
    }

    public void a(d.a aVar, e eVar, d.a aVar2, int i) {
        boolean z2;
        if (aVar == d.a.CENTER) {
            if (aVar2 != d.a.CENTER) {
                if (aVar2 == d.a.LEFT || aVar2 == d.a.RIGHT) {
                    a(d.a.LEFT, eVar, aVar2, 0);
                    a(d.a.RIGHT, eVar, aVar2, 0);
                    a(d.a.CENTER).a(eVar.a(aVar2), 0);
                    return;
                } else {
                    if (aVar2 == d.a.TOP || aVar2 == d.a.BOTTOM) {
                        a(d.a.TOP, eVar, aVar2, 0);
                        a(d.a.BOTTOM, eVar, aVar2, 0);
                        a(d.a.CENTER).a(eVar.a(aVar2), 0);
                        return;
                    }
                    return;
                }
            }
            d dVarA = a(d.a.LEFT);
            d dVarA2 = a(d.a.RIGHT);
            d dVarA3 = a(d.a.TOP);
            d dVarA4 = a(d.a.BOTTOM);
            boolean z3 = true;
            if ((dVarA == null || !dVarA.m()) && (dVarA2 == null || !dVarA2.m())) {
                a(d.a.LEFT, eVar, d.a.LEFT, 0);
                a(d.a.RIGHT, eVar, d.a.RIGHT, 0);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((dVarA3 == null || !dVarA3.m()) && (dVarA4 == null || !dVarA4.m())) {
                a(d.a.TOP, eVar, d.a.TOP, 0);
                a(d.a.BOTTOM, eVar, d.a.BOTTOM, 0);
            } else {
                z3 = false;
            }
            if (z2 && z3) {
                a(d.a.CENTER).a(eVar.a(d.a.CENTER), 0);
                return;
            } else if (z2) {
                a(d.a.CENTER_X).a(eVar.a(d.a.CENTER_X), 0);
                return;
            } else {
                if (z3) {
                    a(d.a.CENTER_Y).a(eVar.a(d.a.CENTER_Y), 0);
                    return;
                }
                return;
            }
        }
        if (aVar == d.a.CENTER_X && (aVar2 == d.a.LEFT || aVar2 == d.a.RIGHT)) {
            d dVarA5 = a(d.a.LEFT);
            d dVarA6 = eVar.a(aVar2);
            d dVarA7 = a(d.a.RIGHT);
            dVarA5.a(dVarA6, 0);
            dVarA7.a(dVarA6, 0);
            a(d.a.CENTER_X).a(dVarA6, 0);
            return;
        }
        if (aVar == d.a.CENTER_Y && (aVar2 == d.a.TOP || aVar2 == d.a.BOTTOM)) {
            d dVarA8 = eVar.a(aVar2);
            a(d.a.TOP).a(dVarA8, 0);
            a(d.a.BOTTOM).a(dVarA8, 0);
            a(d.a.CENTER_Y).a(dVarA8, 0);
            return;
        }
        if (aVar == d.a.CENTER_X && aVar2 == d.a.CENTER_X) {
            a(d.a.LEFT).a(eVar.a(d.a.LEFT), 0);
            a(d.a.RIGHT).a(eVar.a(d.a.RIGHT), 0);
            a(d.a.CENTER_X).a(eVar.a(aVar2), 0);
            return;
        }
        if (aVar == d.a.CENTER_Y && aVar2 == d.a.CENTER_Y) {
            a(d.a.TOP).a(eVar.a(d.a.TOP), 0);
            a(d.a.BOTTOM).a(eVar.a(d.a.BOTTOM), 0);
            a(d.a.CENTER_Y).a(eVar.a(aVar2), 0);
            return;
        }
        d dVarA9 = a(aVar);
        d dVarA10 = eVar.a(aVar2);
        if (dVarA9.a(dVarA10)) {
            if (aVar == d.a.BASELINE) {
                d dVarA11 = a(d.a.TOP);
                d dVarA12 = a(d.a.BOTTOM);
                if (dVarA11 != null) {
                    dVarA11.l();
                }
                if (dVarA12 != null) {
                    dVarA12.l();
                }
                i = 0;
            } else if (aVar == d.a.TOP || aVar == d.a.BOTTOM) {
                d dVarA13 = a(d.a.BASELINE);
                if (dVarA13 != null) {
                    dVarA13.l();
                }
                d dVarA14 = a(d.a.CENTER);
                if (dVarA14.k() != dVarA10) {
                    dVarA14.l();
                }
                d dVarP = a(aVar).p();
                d dVarA15 = a(d.a.CENTER_Y);
                if (dVarA15.m()) {
                    dVarP.l();
                    dVarA15.l();
                }
            } else if (aVar == d.a.LEFT || aVar == d.a.RIGHT) {
                d dVarA16 = a(d.a.CENTER);
                if (dVarA16.k() != dVarA10) {
                    dVarA16.l();
                }
                d dVarP2 = a(aVar).p();
                d dVarA17 = a(d.a.CENTER_X);
                if (dVarA17.m()) {
                    dVarP2.l();
                    dVarA17.l();
                }
            }
            dVarA9.a(dVarA10, i);
        }
    }

    public void a(d.a aVar, e eVar, d.a aVar2, int i, int i2) {
        a(aVar).a(eVar.a(aVar2), i, i2, true);
    }

    public void a(d dVar) {
        if (A() != null && (A() instanceof f) && ((f) A()).au()) {
            return;
        }
        d dVarA = a(d.a.LEFT);
        d dVarA2 = a(d.a.RIGHT);
        d dVarA3 = a(d.a.TOP);
        d dVarA4 = a(d.a.BOTTOM);
        d dVarA5 = a(d.a.CENTER);
        d dVarA6 = a(d.a.CENTER_X);
        d dVarA7 = a(d.a.CENTER_Y);
        if (dVar == dVarA5) {
            if (dVarA.m() && dVarA2.m() && dVarA.k() == dVarA2.k()) {
                dVarA.l();
                dVarA2.l();
            }
            if (dVarA3.m() && dVarA4.m() && dVarA3.k() == dVarA4.k()) {
                dVarA3.l();
                dVarA4.l();
            }
            this.aA = 0.5f;
            this.aB = 0.5f;
        } else if (dVar == dVarA6) {
            if (dVarA.m() && dVarA2.m() && dVarA.k().h() == dVarA2.k().h()) {
                dVarA.l();
                dVarA2.l();
            }
            this.aA = 0.5f;
        } else if (dVar == dVarA7) {
            if (dVarA3.m() && dVarA4.m() && dVarA3.k().h() == dVarA4.k().h()) {
                dVarA3.l();
                dVarA4.l();
            }
            this.aB = 0.5f;
        } else if (dVar == dVarA || dVar == dVarA2) {
            if (dVarA.m() && dVarA.k() == dVarA2.k()) {
                dVarA5.l();
            }
        } else if ((dVar == dVarA3 || dVar == dVarA4) && dVarA3.m() && dVarA3.k() == dVarA4.k()) {
            dVarA5.l();
        }
        dVar.l();
    }

    public void a(d dVar, d dVar2, int i) {
        if (dVar.h() == this) {
            a(dVar.i(), dVar2.h(), dVar2.i(), i);
        }
    }

    public void a(a aVar) {
        this.ak[0] = aVar;
    }

    public void a(e eVar, float f2, int i) {
        a(d.a.CENTER, eVar, d.a.CENTER, i, 0);
        this.bc = f2;
    }

    public void a(e eVar, HashMap<e, e> map) {
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.I[0] = eVar.I[0];
        this.I[1] = eVar.I[1];
        this.J = eVar.J;
        this.K = eVar.K;
        this.M = eVar.M;
        this.N = eVar.N;
        this.O = eVar.O;
        this.P = eVar.P;
        this.Q = eVar.Q;
        this.R = eVar.R;
        this.S = eVar.S;
        this.bb = Arrays.copyOf(eVar.bb, eVar.bb.length);
        this.bc = eVar.bc;
        this.bd = eVar.bd;
        this.be = eVar.be;
        this.T.l();
        this.U.l();
        this.V.l();
        this.W.l();
        this.X.l();
        this.Y.l();
        this.Z.l();
        this.aa.l();
        this.ak = (a[]) Arrays.copyOf(this.ak, 2);
        this.al = this.al == null ? null : map.get(eVar.al);
        this.am = eVar.am;
        this.an = eVar.an;
        this.ao = eVar.ao;
        this.ap = eVar.ap;
        this.aq = eVar.aq;
        this.ar = eVar.ar;
        this.as = eVar.as;
        this.at = eVar.at;
        this.au = eVar.au;
        this.av = eVar.av;
        this.aw = eVar.aw;
        this.ax = eVar.ax;
        this.ay = eVar.ay;
        this.aA = eVar.aA;
        this.aB = eVar.aB;
        this.bj = eVar.bj;
        this.bk = eVar.bk;
        this.bl = eVar.bl;
        this.bm = eVar.bm;
        this.bn = eVar.bn;
        this.aC = eVar.aC;
        this.aD = eVar.aD;
        this.aE = eVar.aE;
        this.aF = eVar.aF;
        this.aG = eVar.aG;
        this.aH = eVar.aH;
        this.aI = eVar.aI;
        this.aJ = eVar.aJ;
        this.aK = eVar.aK;
        this.aL = eVar.aL;
        this.aN = eVar.aN;
        this.aO = eVar.aO;
        this.aP = eVar.aP;
        this.aQ = eVar.aQ;
        this.aR[0] = eVar.aR[0];
        this.aR[1] = eVar.aR[1];
        this.aS[0] = eVar.aS[0];
        this.aS[1] = eVar.aS[1];
        this.aT[0] = eVar.aT[0];
        this.aT[1] = eVar.aT[1];
        this.aU = eVar.aU == null ? null : map.get(eVar.aU);
        this.aV = eVar.aV != null ? map.get(eVar.aV) : null;
    }

    public void a(f fVar, androidx.d.c.e eVar, HashSet<e> hashSet, int i, boolean z2) {
        if (z2) {
            if (!hashSet.contains(this)) {
                return;
            }
            k.a(fVar, eVar, this);
            hashSet.remove(this);
            a(eVar, fVar.b(64));
        }
        if (i == 0) {
            HashSet<d> hashSetA = this.T.a();
            if (hashSetA != null) {
                Iterator<d> it = hashSetA.iterator();
                while (it.hasNext()) {
                    it.next().f678a.a(fVar, eVar, hashSet, i, true);
                }
            }
            HashSet<d> hashSetA2 = this.V.a();
            if (hashSetA2 != null) {
                Iterator<d> it2 = hashSetA2.iterator();
                while (it2.hasNext()) {
                    it2.next().f678a.a(fVar, eVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<d> hashSetA3 = this.U.a();
        if (hashSetA3 != null) {
            Iterator<d> it3 = hashSetA3.iterator();
            while (it3.hasNext()) {
                it3.next().f678a.a(fVar, eVar, hashSet, i, true);
            }
        }
        HashSet<d> hashSetA4 = this.W.a();
        if (hashSetA4 != null) {
            Iterator<d> it4 = hashSetA4.iterator();
            while (it4.hasNext()) {
                it4.next().f678a.a(fVar, eVar, hashSet, i, true);
            }
        }
        HashSet<d> hashSetA5 = this.X.a();
        if (hashSetA5 != null) {
            Iterator<d> it5 = hashSetA5.iterator();
            while (it5.hasNext()) {
                it5.next().f678a.a(fVar, eVar, hashSet, i, true);
            }
        }
    }

    public void a(androidx.d.c.c cVar) {
        this.T.a(cVar);
        this.U.a(cVar);
        this.V.a(cVar);
        this.W.a(cVar);
        this.X.a(cVar);
        this.aa.a(cVar);
        this.Y.a(cVar);
        this.Z.a(cVar);
    }

    public void a(androidx.d.c.e eVar) {
        eVar.a(this.T);
        eVar.a(this.U);
        eVar.a(this.V);
        eVar.a(this.W);
        if (this.aw > 0) {
            eVar.a(this.X);
        }
    }

    public void a(androidx.d.c.e eVar, String str) {
        this.bm = str;
        androidx.d.c.i iVarA = eVar.a(this.T);
        androidx.d.c.i iVarA2 = eVar.a(this.U);
        androidx.d.c.i iVarA3 = eVar.a(this.V);
        androidx.d.c.i iVarA4 = eVar.a(this.W);
        iVarA.a(str + ".left");
        iVarA2.a(str + ".top");
        iVarA3.a(str + ".right");
        iVarA4.a(str + ".bottom");
        eVar.a(this.X).a(str + ".baseline");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15981. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void a(androidx.d.c.e r53, boolean r54) {
        /*
            Method dump skipped, instruction units count: 1598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.d.c.b.e.a(androidx.d.c.e, boolean):void");
    }

    public void a(Object obj) {
        this.bj = obj;
    }

    public void a(String str) {
        this.bn = str;
    }

    public void a(boolean z2, boolean z3) {
        boolean zI = z2 & this.l.i();
        boolean zI2 = z3 & this.m.i();
        int i = this.l.j.g;
        int i2 = this.m.j.g;
        int i3 = this.l.k.g;
        int i4 = this.m.k.g;
        int i5 = i4 - i2;
        if (i3 - i < 0 || i5 < 0 || i == Integer.MIN_VALUE || i == Integer.MAX_VALUE || i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i6 = i3 - i;
        int i7 = i4 - i2;
        if (zI) {
            this.aq = i;
        }
        if (zI2) {
            this.ar = i2;
        }
        if (this.bl == 8) {
            this.am = 0;
            this.an = 0;
            return;
        }
        if (zI) {
            if (this.ak[0] == a.FIXED && i6 < this.am) {
                i6 = this.am;
            }
            this.am = i6;
            if (this.am < this.ax) {
                this.am = this.ax;
            }
        }
        if (zI2) {
            if (this.ak[1] == a.FIXED && i7 < this.an) {
                i7 = this.an;
            }
            this.an = i7;
            if (this.an < this.ay) {
                this.an = this.ay;
            }
        }
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.R == -1) {
            if (z4 && !z5) {
                this.R = 0;
            } else if (!z4 && z5) {
                this.R = 1;
                if (this.ap == -1) {
                    this.S = 1.0f / this.S;
                }
            }
        }
        if (this.R == 0 && (!this.U.m() || !this.W.m())) {
            this.R = 1;
        } else if (this.R == 1 && (!this.T.m() || !this.V.m())) {
            this.R = 0;
        }
        if (this.R == -1 && (!this.U.m() || !this.W.m() || !this.T.m() || !this.V.m())) {
            if (this.U.m() && this.W.m()) {
                this.R = 0;
            } else if (this.T.m() && this.V.m()) {
                this.S = 1.0f / this.S;
                this.R = 1;
            }
        }
        if (this.R == -1) {
            if (this.J > 0 && this.M == 0) {
                this.R = 0;
            } else {
                if (this.J != 0 || this.M <= 0) {
                    return;
                }
                this.S = 1.0f / this.S;
                this.R = 1;
            }
        }
    }

    public boolean a() {
        return this.bl != 8;
    }

    public void a_(e eVar) {
        this.al = eVar;
    }

    public Object aa() {
        return this.bj;
    }

    public ArrayList<d> ab() {
        return this.ah;
    }

    public float ac() {
        return this.ao;
    }

    public int ad() {
        return this.ap;
    }

    public int ae() {
        return this.bk;
    }

    public int af() {
        return this.aN;
    }

    public int ag() {
        return this.aO;
    }

    public void ah() {
        ai();
        b(az);
        a(az);
    }

    public void ai() {
        e eVarA = A();
        if (eVarA != null && (eVarA instanceof f) && ((f) A()).au()) {
            return;
        }
        int size = this.ah.size();
        for (int i = 0; i < size; i++) {
            this.ah.get(i).l();
        }
    }

    public a aj() {
        return this.ak[0];
    }

    public a ak() {
        return this.ak[1];
    }

    public boolean al() {
        if (this.T.c == null || this.T.c.c != this.T) {
            return this.V.c != null && this.V.c.c == this.V;
        }
        return true;
    }

    public e am() {
        if (!al()) {
            return null;
        }
        e eVar = this;
        e eVar2 = null;
        while (eVar2 == null && eVar != null) {
            d dVarA = eVar.a(d.a.LEFT);
            d dVarK = dVarA == null ? null : dVarA.k();
            e eVarH = dVarK == null ? null : dVarK.h();
            if (eVarH == A()) {
                return eVar;
            }
            d dVarK2 = eVarH == null ? null : eVarH.a(d.a.RIGHT).k();
            if (dVarK2 == null || dVarK2.h() == eVar) {
                eVar = eVarH;
            } else {
                eVar2 = eVar;
            }
        }
        return eVar2;
    }

    public boolean an() {
        if (this.U.c == null || this.U.c.c != this.U) {
            return this.W.c != null && this.W.c.c == this.W;
        }
        return true;
    }

    public e ao() {
        if (!an()) {
            return null;
        }
        e eVar = this;
        e eVar2 = null;
        while (eVar2 == null && eVar != null) {
            d dVarA = eVar.a(d.a.TOP);
            d dVarK = dVarA == null ? null : dVarA.k();
            e eVarH = dVarK == null ? null : dVarK.h();
            if (eVarH == A()) {
                return eVar;
            }
            d dVarK2 = eVarH == null ? null : eVarH.a(d.a.BOTTOM).k();
            if (dVarK2 == null || dVarK2.h() == eVar) {
                eVar = eVarH;
            } else {
                eVar2 = eVar;
            }
        }
        return eVar2;
    }

    boolean ap() {
        return (this instanceof m) || (this instanceof h);
    }

    public void b(float f2) {
        this.aB = f2;
    }

    public void b(int i, int i2) {
        this.U.a(i);
        this.W.a(i2);
        this.ar = i;
        this.an = i2 - i;
        if (this.bd) {
            this.X.a(i + this.aw);
        }
        this.aZ = true;
    }

    public void b(int i, int i2, int i3, float f2) {
        this.H = i;
        this.M = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.N = i3;
        this.O = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || this.H != 0) {
            return;
        }
        this.H = 2;
    }

    public void b(a aVar) {
        this.ak[1] = aVar;
    }

    public void b(androidx.d.c.e eVar, boolean z2) {
        int iB = eVar.b(this.T);
        int iB2 = eVar.b(this.U);
        int iB3 = eVar.b(this.V);
        int iB4 = eVar.b(this.W);
        if (z2 && this.l != null && this.l.j.j && this.l.k.j) {
            iB = this.l.j.g;
            iB3 = this.l.k.g;
        }
        if (z2 && this.m != null && this.m.j.j && this.m.k.j) {
            iB2 = this.m.j.g;
            iB4 = this.m.k.g;
        }
        int i = iB4 - iB2;
        if (iB3 - iB < 0 || i < 0 || iB == Integer.MIN_VALUE || iB == Integer.MAX_VALUE || iB2 == Integer.MIN_VALUE || iB2 == Integer.MAX_VALUE || iB3 == Integer.MIN_VALUE || iB3 == Integer.MAX_VALUE || iB4 == Integer.MIN_VALUE || iB4 == Integer.MAX_VALUE) {
            iB4 = 0;
            iB = 0;
            iB2 = 0;
            iB3 = 0;
        }
        a(iB, iB2, iB3, iB4);
    }

    public void b(String str) {
        this.bm = str;
    }

    public void b(boolean z2) {
        this.bf = z2;
    }

    public p c(int i) {
        if (i == 0) {
            return this.l;
        }
        if (i == 1) {
            return this.m;
        }
        return null;
    }

    public void c(float f2) {
        this.aR[0] = f2;
    }

    public void c(int i, int i2) {
        this.bg = i;
        this.bh = i2;
        e(false);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0084 A[PHI: r0
      0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:45:0x0084, B:35:0x007d, B:23:0x004f, B:25:0x0055, B:27:0x0061, B:29:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void c(String str) {
        float fAbs;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.ao = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i3 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i3);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i;
                }
            } else {
                String strSubstring3 = str.substring(i3, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i;
                } else {
                    float f2 = Float.parseFloat(strSubstring3);
                    float f3 = Float.parseFloat(strSubstring4);
                    if (f2 <= 0.0f || f3 <= 0.0f) {
                        fAbs = i;
                    } else {
                        fAbs = i2 == 1 ? Math.abs(f3 / f2) : Math.abs(f2 / f3);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i = (fAbs > i ? 1 : (fAbs == i ? 0 : -1));
        if (i > 0) {
            this.ao = fAbs;
            this.ap = i2;
        }
    }

    public void c(boolean z2) {
        this.bd = z2;
    }

    public void d(float f2) {
        this.aR[1] = f2;
    }

    public void d(int i) {
        this.T.a(i);
        this.aq = i;
    }

    public void d(int i, int i2) {
        this.aq = i;
        this.ar = i2;
    }

    public void d(boolean z2) {
        this.be = z2;
    }

    public boolean d() {
        return this.aY || (this.T.f() && this.V.f());
    }

    public void d_() {
        this.aY = false;
        this.aZ = false;
        int size = this.ah.size();
        for (int i = 0; i < size; i++) {
            this.ah.get(i).e();
        }
    }

    public void e(int i) {
        this.U.a(i);
        this.ar = i;
    }

    public void e(int i, int i2) {
        this.au = i;
        this.av = i2;
    }

    public void e(boolean z2) {
        this.c = z2;
    }

    public boolean e() {
        return this.aZ || (this.U.f() && this.W.f());
    }

    public void f(int i) {
        if (this.bd) {
            int i2 = i - this.aw;
            int i3 = this.an + i2;
            this.ar = i2;
            this.U.a(i2);
            this.W.a(i3);
            this.X.a(i);
            this.aZ = true;
        }
    }

    public void f(int i, int i2) {
        if (i2 == 0) {
            p(i);
        } else if (i2 == 1) {
            q(i);
        }
    }

    public void f(boolean z2) {
        this.P = z2;
    }

    public void g(int i, int i2) {
        this.am = i;
        if (this.am < this.ax) {
            this.am = this.ax;
        }
        this.an = i2;
        if (this.an < this.ay) {
            this.an = this.ay;
        }
    }

    public void g(boolean z2) {
        this.Q = z2;
    }

    public boolean g(int i) {
        if (i == 0) {
            return (this.T.c != null ? 1 : 0) + (this.V.c != null ? 1 : 0) < 2;
        }
        return ((this.U.c != null ? 1 : 0) + (this.W.c != null ? 1 : 0)) + (this.X.c != null ? 1 : 0) < 2;
    }

    public void h(int i) {
        this.bb[0] = i;
    }

    public void h(int i, int i2) {
        this.aq = i;
        this.am = i2 - i;
        if (this.am < this.ax) {
            this.am = this.ax;
        }
    }

    public void i(int i) {
        this.bb[1] = i;
    }

    public void i(int i, int i2) {
        this.ar = i;
        this.an = i2 - i;
        if (this.an < this.ay) {
            this.an = this.ay;
        }
    }

    void j(int i, int i2) {
        if (i2 == 0) {
            this.as = i;
        } else if (i2 == 1) {
            this.at = i;
        }
    }

    public boolean j(int i) {
        return this.ak[i] == a.MATCH_CONSTRAINT && this.ak[i == 0 ? (char) 1 : (char) 0] == a.MATCH_CONSTRAINT;
    }

    public void k() {
        this.c = true;
    }

    public void k(int i) {
        this.bl = i;
    }

    public int l(int i) {
        if (i == 0) {
            return I();
        }
        if (i == 1) {
            return L();
        }
        return 0;
    }

    public boolean l() {
        int size = this.ah.size();
        for (int i = 0; i < size; i++) {
            if (this.ah.get(i).b()) {
                return true;
            }
        }
        return false;
    }

    public float m(int i) {
        if (i == 0) {
            return this.aA;
        }
        if (i == 1) {
            return this.aB;
        }
        return -1.0f;
    }

    public boolean m() {
        return this.bf;
    }

    public int n() {
        return this.bb[1];
    }

    public void n(int i) {
        this.aq = i;
    }

    public int o() {
        return this.bb[0];
    }

    public void o(int i) {
        this.ar = i;
    }

    public void p(int i) {
        this.am = i;
        if (this.am < this.ax) {
            this.am = this.ax;
        }
    }

    public boolean p() {
        return this.G == 0 && this.ao == 0.0f && this.J == 0 && this.K == 0 && this.ak[0] == a.MATCH_CONSTRAINT;
    }

    public void q(int i) {
        this.an = i;
        if (this.an < this.ay) {
            this.an = this.ay;
        }
    }

    public boolean q() {
        return this.H == 0 && this.ao == 0.0f && this.M == 0 && this.N == 0 && this.ak[1] == a.MATCH_CONSTRAINT;
    }

    public void r(int i) {
        if (i < 0) {
            this.ax = 0;
        } else {
            this.ax = i;
        }
    }

    public boolean r() {
        return this.bd;
    }

    public void s(int i) {
        if (i < 0) {
            this.ay = 0;
        } else {
            this.ay = i;
        }
    }

    public boolean s() {
        return this.be;
    }

    int t(int i) {
        if (i == 0) {
            return this.as;
        }
        if (i == 1) {
            return this.at;
        }
        return 0;
    }

    public boolean t() {
        return this.c && this.bl != 8;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.bn != null) {
            str = "type: " + this.bn + " ";
        } else {
            str = com.yftech.service.upgrade.a.d;
        }
        sb.append(str);
        if (this.bm != null) {
            str2 = "id: " + this.bm + " ";
        } else {
            str2 = com.yftech.service.upgrade.a.d;
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.aq);
        sb.append(", ");
        sb.append(this.ar);
        sb.append(") - (");
        sb.append(this.am);
        sb.append(" x ");
        sb.append(this.an);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.bg;
    }

    public void u(int i) {
        this.aw = i;
        this.bd = i > 0;
    }

    public int v() {
        return this.bh;
    }

    public void v(int i) {
        if (i >= 0) {
            this.bk = i;
        } else {
            this.bk = 0;
        }
    }

    public void w() {
        this.T.l();
        this.U.l();
        this.V.l();
        this.W.l();
        this.X.l();
        this.Y.l();
        this.Z.l();
        this.aa.l();
        this.al = null;
        this.bc = 0.0f;
        this.am = 0;
        this.an = 0;
        this.ao = 0.0f;
        this.ap = -1;
        this.aq = 0;
        this.ar = 0;
        this.au = 0;
        this.av = 0;
        this.aw = 0;
        this.ax = 0;
        this.ay = 0;
        this.aA = az;
        this.aB = az;
        this.ak[0] = a.FIXED;
        this.ak[1] = a.FIXED;
        this.bj = null;
        this.bk = 0;
        this.bl = 0;
        this.bn = null;
        this.aK = false;
        this.aL = false;
        this.aN = 0;
        this.aO = 0;
        this.aP = false;
        this.aQ = false;
        this.aR[0] = -1.0f;
        this.aR[1] = -1.0f;
        this.E = -1;
        this.F = -1;
        this.bb[0] = Integer.MAX_VALUE;
        this.bb[1] = Integer.MAX_VALUE;
        this.G = 0;
        this.H = 0;
        this.L = 1.0f;
        this.O = 1.0f;
        this.K = ActivityChooserView.a.f166a;
        this.N = ActivityChooserView.a.f166a;
        this.J = 0;
        this.M = 0;
        this.o = false;
        this.R = -1;
        this.S = 1.0f;
        this.aM = false;
        this.n[0] = true;
        this.n[1] = true;
        this.bf = false;
        this.bi[0] = false;
        this.bi[1] = false;
        this.c = true;
    }

    public void w(int i) {
        this.aN = i;
    }

    public void x(int i) {
        this.aO = i;
    }

    public boolean x() {
        return this.ak[0] == a.MATCH_CONSTRAINT && this.ak[1] == a.MATCH_CONSTRAINT;
    }

    public a y(int i) {
        if (i == 0) {
            return aj();
        }
        if (i == 1) {
            return ak();
        }
        return null;
    }

    public void y() {
        if (this.l == null) {
            this.l = new androidx.d.c.b.a.l(this);
        }
        if (this.m == null) {
            this.m = new androidx.d.c.b.a.n(this);
        }
    }

    public e z(int i) {
        if (i == 0) {
            if (this.T.c == null || this.T.c.c != this.T) {
                return null;
            }
            return this.T.c.f678a;
        }
        if (i == 1 && this.U.c != null && this.U.c.c == this.U) {
            return this.U.c.f678a;
        }
        return null;
    }

    public boolean z() {
        return this.al == null;
    }
}
