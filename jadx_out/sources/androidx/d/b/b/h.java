package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {
    private static final String A = "KeyCycle";
    static final String y = "KeyCycle";
    public static final int z = 4;
    private String B = null;
    private int C = 0;
    private int D = -1;
    private float E = Float.NaN;
    private float F = 0.0f;
    private float G = Float.NaN;
    private int H = -1;
    private float I = Float.NaN;
    private float J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private float R = Float.NaN;
    private float S = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f609a = 1;
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
        private static final int m = 13;
        private static final int n = 14;
        private static final int o = 15;
        private static final int p = 16;
        private static final int q = 17;
        private static final int r = 18;
        private static final int s = 19;
        private static final int t = 20;
        private static SparseIntArray u = new SparseIntArray();

        static {
            u.append(androidx.d.e.m.C0052m.KeyCycle_motionTarget, 1);
            u.append(androidx.d.e.m.C0052m.KeyCycle_framePosition, 2);
            u.append(androidx.d.e.m.C0052m.KeyCycle_transitionEasing, 3);
            u.append(androidx.d.e.m.C0052m.KeyCycle_curveFit, 4);
            u.append(androidx.d.e.m.C0052m.KeyCycle_waveShape, 5);
            u.append(androidx.d.e.m.C0052m.KeyCycle_wavePeriod, 6);
            u.append(androidx.d.e.m.C0052m.KeyCycle_waveOffset, 7);
            u.append(androidx.d.e.m.C0052m.KeyCycle_waveVariesBy, 8);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_alpha, 9);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_elevation, 10);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_rotation, 11);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_rotationX, 12);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_rotationY, 13);
            u.append(androidx.d.e.m.C0052m.KeyCycle_transitionPathRotate, 14);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_scaleX, 15);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_scaleY, 16);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_translationX, 17);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_translationY, 18);
            u.append(androidx.d.e.m.C0052m.KeyCycle_android_translationZ, 19);
            u.append(androidx.d.e.m.C0052m.KeyCycle_motionProgress, 20);
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(h hVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (u.get(index)) {
                    case 1:
                        if (s.h) {
                            hVar.c = typedArray.getResourceId(index, hVar.c);
                            if (hVar.c == -1) {
                                hVar.d = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            hVar.d = typedArray.getString(index);
                        } else {
                            hVar.c = typedArray.getResourceId(index, hVar.c);
                        }
                        break;
                    case 2:
                        hVar.b = typedArray.getInt(index, hVar.b);
                        break;
                    case 3:
                        hVar.B = typedArray.getString(index);
                        break;
                    case 4:
                        hVar.C = typedArray.getInteger(index, hVar.C);
                        break;
                    case 5:
                        hVar.D = typedArray.getInt(index, hVar.D);
                        break;
                    case 6:
                        hVar.E = typedArray.getFloat(index, hVar.E);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            hVar.F = typedArray.getDimension(index, hVar.F);
                        } else {
                            hVar.F = typedArray.getFloat(index, hVar.F);
                        }
                        break;
                    case 8:
                        hVar.H = typedArray.getInt(index, hVar.H);
                        break;
                    case 9:
                        hVar.I = typedArray.getFloat(index, hVar.I);
                        break;
                    case 10:
                        hVar.J = typedArray.getDimension(index, hVar.J);
                        break;
                    case 11:
                        hVar.K = typedArray.getFloat(index, hVar.K);
                        break;
                    case 12:
                        hVar.M = typedArray.getFloat(index, hVar.M);
                        break;
                    case 13:
                        hVar.N = typedArray.getFloat(index, hVar.N);
                        break;
                    case 14:
                        hVar.L = typedArray.getFloat(index, hVar.L);
                        break;
                    case 15:
                        hVar.O = typedArray.getFloat(index, hVar.O);
                        break;
                    case 16:
                        hVar.P = typedArray.getFloat(index, hVar.P);
                        break;
                    case 17:
                        hVar.Q = typedArray.getDimension(index, hVar.Q);
                        break;
                    case 18:
                        hVar.R = typedArray.getDimension(index, hVar.R);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            hVar.S = typedArray.getDimension(index, hVar.S);
                        }
                        break;
                    case 20:
                        hVar.G = typedArray.getFloat(index, hVar.G);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + u.get(index));
                        break;
                }
            }
        }
    }

    public h() {
        this.e = 4;
        this.f = new HashMap<>();
    }

    @Override // androidx.d.b.b.e
    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.KeyCycle));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7  */
    @Override // androidx.d.b.b.e
    public void a(String str, Object obj) {
        switch (str) {
            case "alpha":
                this.I = a(obj);
                break;
            case "curveFit":
                this.C = b(obj);
                break;
            case "elevation":
                this.J = a(obj);
                break;
            case "progress":
                this.G = a(obj);
                break;
            case "rotation":
                this.K = a(obj);
                break;
            case "rotationX":
                this.M = a(obj);
                break;
            case "rotationY":
                this.N = a(obj);
                break;
            case "scaleX":
                this.O = a(obj);
                break;
            case "scaleY":
                this.P = a(obj);
                break;
            case "transitionEasing":
                this.B = obj.toString();
                break;
            case "transitionPathRotate":
                this.L = a(obj);
                break;
            case "translationX":
                this.Q = a(obj);
                break;
            case "translationY":
                this.R = a(obj);
                break;
            case "mTranslationZ":
                this.S = a(obj);
                break;
            case "wavePeriod":
                this.E = a(obj);
                break;
            case "waveOffset":
                this.F = a(obj);
                break;
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashMap<String, w> map) {
        c.a("KeyCycle", "add " + map.size() + " values", 2);
        for (String str : map.keySet()) {
            w wVar = map.get(str);
            switch (str) {
                case "alpha":
                    wVar.a(this.b, this.I);
                    break;
                case "elevation":
                    wVar.a(this.b, this.J);
                    break;
                case "rotation":
                    wVar.a(this.b, this.K);
                    break;
                case "rotationX":
                    wVar.a(this.b, this.M);
                    break;
                case "rotationY":
                    wVar.a(this.b, this.N);
                    break;
                case "transitionPathRotate":
                    wVar.a(this.b, this.L);
                    break;
                case "scaleX":
                    wVar.a(this.b, this.O);
                    break;
                case "scaleY":
                    wVar.a(this.b, this.P);
                    break;
                case "translationX":
                    wVar.a(this.b, this.Q);
                    break;
                case "translationY":
                    wVar.a(this.b, this.R);
                    break;
                case "translationZ":
                    wVar.a(this.b, this.S);
                    break;
                case "waveOffset":
                    wVar.a(this.b, this.F);
                    break;
                case "progress":
                    wVar.a(this.b, this.G);
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + str);
                    break;
            }
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.I)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.R)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.S)) {
            hashSet.add("translationZ");
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    public float b(String str) {
        switch (str) {
            case "alpha":
                return this.I;
            case "elevation":
                return this.J;
            case "rotation":
                return this.K;
            case "rotationX":
                return this.M;
            case "rotationY":
                return this.N;
            case "transitionPathRotate":
                return this.L;
            case "scaleX":
                return this.O;
            case "scaleY":
                return this.P;
            case "translationX":
                return this.Q;
            case "translationY":
                return this.R;
            case "translationZ":
                return this.S;
            case "waveOffset":
                return this.F;
            case "progress":
                return this.G;
            default:
                Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public void c(HashMap<String, i> map) {
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                androidx.d.e.b bVar = this.f.get(str.substring("CUSTOM".length() + 1));
                if (bVar != null && bVar.a() == androidx.d.e.b.a.FLOAT_TYPE) {
                    map.get(str).a(this.b, this.D, this.H, this.E, this.F, bVar.c(), bVar);
                }
            } else {
                float fB = b(str);
                if (!Float.isNaN(fB)) {
                    map.get(str).a(this.b, this.D, this.H, this.E, this.F, fB);
                }
            }
        }
    }
}
