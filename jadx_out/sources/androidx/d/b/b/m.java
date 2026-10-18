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
public class m extends e {
    private static final String A = "KeyTimeCycle";
    static final String y = "KeyTimeCycle";
    public static final int z = 3;
    private String B;
    private int C = -1;
    private float D = Float.NaN;
    private float E = Float.NaN;
    private float F = Float.NaN;
    private float G = Float.NaN;
    private float H = Float.NaN;
    private float I = Float.NaN;
    private float J = Float.NaN;
    private float K = Float.NaN;
    private float L = Float.NaN;
    private float M = Float.NaN;
    private float N = Float.NaN;
    private float O = Float.NaN;
    private int P = 0;
    private float Q = Float.NaN;
    private float R = 0.0f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f616a = 1;
        private static final int b = 2;
        private static final int c = 4;
        private static final int d = 5;
        private static final int e = 6;
        private static final int f = 8;
        private static final int g = 7;
        private static final int h = 9;
        private static final int i = 10;
        private static final int j = 12;
        private static final int k = 13;
        private static final int l = 14;
        private static final int m = 15;
        private static final int n = 16;
        private static final int o = 17;
        private static final int p = 18;
        private static final int q = 19;
        private static final int r = 20;
        private static final int s = 21;
        private static SparseIntArray t = new SparseIntArray();

        static {
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_alpha, 1);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_elevation, 2);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_rotation, 4);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_rotationX, 5);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_rotationY, 6);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_scaleX, 7);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_transitionPathRotate, 8);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_transitionEasing, 9);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_motionTarget, 10);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_framePosition, 12);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_curveFit, 13);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_scaleY, 14);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_translationX, 15);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_translationY, 16);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_android_translationZ, 17);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_motionProgress, 18);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_wavePeriod, 20);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_waveOffset, 21);
            t.append(androidx.d.e.m.C0052m.KeyTimeCycle_waveShape, 19);
        }

        private a() {
        }

        public static void a(m mVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (t.get(index)) {
                    case 1:
                        mVar.D = typedArray.getFloat(index, mVar.D);
                        break;
                    case 2:
                        mVar.E = typedArray.getDimension(index, mVar.E);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + t.get(index));
                        break;
                    case 4:
                        mVar.F = typedArray.getFloat(index, mVar.F);
                        break;
                    case 5:
                        mVar.G = typedArray.getFloat(index, mVar.G);
                        break;
                    case 6:
                        mVar.H = typedArray.getFloat(index, mVar.H);
                        break;
                    case 7:
                        mVar.J = typedArray.getFloat(index, mVar.J);
                        break;
                    case 8:
                        mVar.I = typedArray.getFloat(index, mVar.I);
                        break;
                    case 9:
                        mVar.B = typedArray.getString(index);
                        break;
                    case 10:
                        if (s.h) {
                            mVar.c = typedArray.getResourceId(index, mVar.c);
                            if (mVar.c == -1) {
                                mVar.d = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            mVar.d = typedArray.getString(index);
                        } else {
                            mVar.c = typedArray.getResourceId(index, mVar.c);
                        }
                        break;
                    case 12:
                        mVar.b = typedArray.getInt(index, mVar.b);
                        break;
                    case 13:
                        mVar.C = typedArray.getInteger(index, mVar.C);
                        break;
                    case 14:
                        mVar.K = typedArray.getFloat(index, mVar.K);
                        break;
                    case 15:
                        mVar.L = typedArray.getDimension(index, mVar.L);
                        break;
                    case 16:
                        mVar.M = typedArray.getDimension(index, mVar.M);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            mVar.N = typedArray.getDimension(index, mVar.N);
                        }
                        break;
                    case 18:
                        mVar.O = typedArray.getFloat(index, mVar.O);
                        break;
                    case 19:
                        mVar.P = typedArray.getInt(index, mVar.P);
                        break;
                    case 20:
                        mVar.Q = typedArray.getFloat(index, mVar.Q);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            mVar.R = typedArray.getDimension(index, mVar.R);
                        } else {
                            mVar.R = typedArray.getFloat(index, mVar.R);
                        }
                        break;
                }
            }
        }
    }

    public m() {
        this.e = 3;
        this.f = new HashMap<>();
    }

    @Override // androidx.d.b.b.e
    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.KeyTimeCycle));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x009f  */
    @Override // androidx.d.b.b.e
    public void a(String str, Object obj) {
        switch (str) {
            case "alpha":
                this.D = a(obj);
                break;
            case "curveFit":
                this.C = b(obj);
                break;
            case "elevation":
                this.E = a(obj);
                break;
            case "progress":
                this.O = a(obj);
                break;
            case "rotation":
                this.F = a(obj);
                break;
            case "rotationX":
                this.G = a(obj);
                break;
            case "rotationY":
                this.H = a(obj);
                break;
            case "scaleX":
                this.J = a(obj);
                break;
            case "scaleY":
                this.K = a(obj);
                break;
            case "transitionEasing":
                this.B = obj.toString();
                break;
            case "transitionPathRotate":
                this.I = a(obj);
                break;
            case "translationX":
                this.L = a(obj);
                break;
            case "translationY":
                this.M = a(obj);
                break;
            case "mTranslationZ":
                this.N = a(obj);
                break;
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashMap<String, w> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.d.b.b.e
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.D)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add(androidx.core.app.p.al);
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.d.b.b.e
    public void b(HashMap<String, Integer> map) {
        if (this.C == -1) {
            return;
        }
        if (!Float.isNaN(this.D)) {
            map.put("alpha", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.E)) {
            map.put("elevation", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.F)) {
            map.put("rotation", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.G)) {
            map.put("rotationX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.H)) {
            map.put("rotationY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.L)) {
            map.put("translationX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.M)) {
            map.put("translationY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.N)) {
            map.put("translationZ", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.I)) {
            map.put("transitionPathRotate", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.J)) {
            map.put("scaleX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.J)) {
            map.put("scaleY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.O)) {
            map.put(androidx.core.app.p.al, Integer.valueOf(this.C));
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.C));
            }
        }
    }

    public void c(HashMap<String, x> map) {
        for (String str : map.keySet()) {
            x xVar = map.get(str);
            if (!str.startsWith("CUSTOM")) {
                switch (str) {
                    case "alpha":
                        if (Float.isNaN(this.D)) {
                            break;
                        } else {
                            xVar.a(this.b, this.D, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "elevation":
                        if (Float.isNaN(this.E)) {
                            break;
                        } else {
                            xVar.a(this.b, this.E, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "rotation":
                        if (Float.isNaN(this.F)) {
                            break;
                        } else {
                            xVar.a(this.b, this.F, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "rotationX":
                        if (Float.isNaN(this.G)) {
                            break;
                        } else {
                            xVar.a(this.b, this.G, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "rotationY":
                        if (Float.isNaN(this.H)) {
                            break;
                        } else {
                            xVar.a(this.b, this.H, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "transitionPathRotate":
                        if (Float.isNaN(this.I)) {
                            break;
                        } else {
                            xVar.a(this.b, this.I, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "scaleX":
                        if (Float.isNaN(this.J)) {
                            break;
                        } else {
                            xVar.a(this.b, this.J, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "scaleY":
                        if (Float.isNaN(this.K)) {
                            break;
                        } else {
                            xVar.a(this.b, this.K, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "translationX":
                        if (Float.isNaN(this.L)) {
                            break;
                        } else {
                            xVar.a(this.b, this.L, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "translationY":
                        if (Float.isNaN(this.M)) {
                            break;
                        } else {
                            xVar.a(this.b, this.M, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "translationZ":
                        if (Float.isNaN(this.N)) {
                            break;
                        } else {
                            xVar.a(this.b, this.N, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    case "progress":
                        if (Float.isNaN(this.O)) {
                            break;
                        } else {
                            xVar.a(this.b, this.O, this.Q, this.P, this.R);
                            break;
                        }
                        break;
                    default:
                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                        break;
                }
            } else {
                androidx.d.e.b bVar = this.f.get(str.substring("CUSTOM".length() + 1));
                if (bVar != null) {
                    ((x.b) xVar).a(this.b, bVar, this.Q, this.P, this.R);
                }
            }
        }
    }
}
