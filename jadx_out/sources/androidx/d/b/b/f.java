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
public class f extends e {
    private static final String A = "KeyAttribute";
    static final String y = "KeyAttribute";
    public static final int z = 1;
    private String B;
    private int C = -1;
    private boolean D = false;
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
    private float P = Float.NaN;
    private float Q = Float.NaN;
    private float R = Float.NaN;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f607a = 1;
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
        private static SparseIntArray s = new SparseIntArray();

        static {
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_alpha, 1);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_elevation, 2);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_rotation, 4);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_rotationX, 5);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_rotationY, 6);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_transformPivotX, 19);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_transformPivotY, 20);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_scaleX, 7);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_transitionPathRotate, 8);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_transitionEasing, 9);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_motionTarget, 10);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_framePosition, 12);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_curveFit, 13);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_scaleY, 14);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_translationX, 15);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_translationY, 16);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_android_translationZ, 17);
            s.append(androidx.d.e.m.C0052m.KeyAttribute_motionProgress, 18);
        }

        private a() {
        }

        public static void a(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (s.get(index)) {
                    case 1:
                        fVar.E = typedArray.getFloat(index, fVar.E);
                        break;
                    case 2:
                        fVar.F = typedArray.getDimension(index, fVar.F);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + s.get(index));
                        break;
                    case 4:
                        fVar.G = typedArray.getFloat(index, fVar.G);
                        break;
                    case 5:
                        fVar.H = typedArray.getFloat(index, fVar.H);
                        break;
                    case 6:
                        fVar.I = typedArray.getFloat(index, fVar.I);
                        break;
                    case 7:
                        fVar.M = typedArray.getFloat(index, fVar.M);
                        break;
                    case 8:
                        fVar.L = typedArray.getFloat(index, fVar.L);
                        break;
                    case 9:
                        fVar.B = typedArray.getString(index);
                        break;
                    case 10:
                        if (s.h) {
                            fVar.c = typedArray.getResourceId(index, fVar.c);
                            if (fVar.c == -1) {
                                fVar.d = typedArray.getString(index);
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.d = typedArray.getString(index);
                        } else {
                            fVar.c = typedArray.getResourceId(index, fVar.c);
                        }
                        break;
                    case 12:
                        fVar.b = typedArray.getInt(index, fVar.b);
                        break;
                    case 13:
                        fVar.C = typedArray.getInteger(index, fVar.C);
                        break;
                    case 14:
                        fVar.N = typedArray.getFloat(index, fVar.N);
                        break;
                    case 15:
                        fVar.O = typedArray.getDimension(index, fVar.O);
                        break;
                    case 16:
                        fVar.P = typedArray.getDimension(index, fVar.P);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            fVar.Q = typedArray.getDimension(index, fVar.Q);
                        }
                        break;
                    case 18:
                        fVar.R = typedArray.getFloat(index, fVar.R);
                        break;
                    case 19:
                        fVar.J = typedArray.getDimension(index, fVar.J);
                        break;
                    case 20:
                        fVar.K = typedArray.getDimension(index, fVar.K);
                        break;
                }
            }
        }
    }

    public f() {
        this.e = 1;
        this.f = new HashMap<>();
    }

    int a() {
        return this.C;
    }

    @Override // androidx.d.b.b.e
    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.KeyAttribute));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:56:0x00c3  */
    @Override // androidx.d.b.b.e
    public void a(String str, Object obj) {
        switch (str) {
            case "alpha":
                this.E = a(obj);
                break;
            case "curveFit":
                this.C = b(obj);
                break;
            case "elevation":
                this.F = a(obj);
                break;
            case "motionProgress":
                this.R = a(obj);
                break;
            case "rotation":
                this.G = a(obj);
                break;
            case "rotationX":
                this.H = a(obj);
                break;
            case "rotationY":
                this.I = a(obj);
                break;
            case "pivotX":
                this.J = a(obj);
                break;
            case "pivotY":
                this.K = a(obj);
                break;
            case "scaleX":
                this.M = a(obj);
                break;
            case "scaleY":
                this.N = a(obj);
                break;
            case "transitionEasing":
                this.B = obj.toString();
                break;
            case "visibility":
                this.D = c(obj);
                break;
            case "transitionPathRotate":
                this.L = a(obj);
                break;
            case "translationX":
                this.O = a(obj);
                break;
            case "translationY":
                this.P = a(obj);
                break;
            case "mTranslationZ":
                this.Q = a(obj);
                break;
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashMap<String, w> map) {
        for (String str : map.keySet()) {
            w wVar = map.get(str);
            if (!str.startsWith("CUSTOM")) {
                switch (str) {
                    case "alpha":
                        if (Float.isNaN(this.E)) {
                            break;
                        } else {
                            wVar.a(this.b, this.E);
                            break;
                        }
                        break;
                    case "elevation":
                        if (Float.isNaN(this.F)) {
                            break;
                        } else {
                            wVar.a(this.b, this.F);
                            break;
                        }
                        break;
                    case "rotation":
                        if (Float.isNaN(this.G)) {
                            break;
                        } else {
                            wVar.a(this.b, this.G);
                            break;
                        }
                        break;
                    case "rotationX":
                        if (Float.isNaN(this.H)) {
                            break;
                        } else {
                            wVar.a(this.b, this.H);
                            break;
                        }
                        break;
                    case "rotationY":
                        if (Float.isNaN(this.I)) {
                            break;
                        } else {
                            wVar.a(this.b, this.I);
                            break;
                        }
                        break;
                    case "transformPivotX":
                        if (Float.isNaN(this.H)) {
                            break;
                        } else {
                            wVar.a(this.b, this.J);
                            break;
                        }
                        break;
                    case "transformPivotY":
                        if (Float.isNaN(this.I)) {
                            break;
                        } else {
                            wVar.a(this.b, this.K);
                            break;
                        }
                        break;
                    case "transitionPathRotate":
                        if (Float.isNaN(this.L)) {
                            break;
                        } else {
                            wVar.a(this.b, this.L);
                            break;
                        }
                        break;
                    case "scaleX":
                        if (Float.isNaN(this.M)) {
                            break;
                        } else {
                            wVar.a(this.b, this.M);
                            break;
                        }
                        break;
                    case "scaleY":
                        if (Float.isNaN(this.N)) {
                            break;
                        } else {
                            wVar.a(this.b, this.N);
                            break;
                        }
                        break;
                    case "translationX":
                        if (Float.isNaN(this.O)) {
                            break;
                        } else {
                            wVar.a(this.b, this.O);
                            break;
                        }
                        break;
                    case "translationY":
                        if (Float.isNaN(this.P)) {
                            break;
                        } else {
                            wVar.a(this.b, this.P);
                            break;
                        }
                        break;
                    case "translationZ":
                        if (Float.isNaN(this.Q)) {
                            break;
                        } else {
                            wVar.a(this.b, this.Q);
                            break;
                        }
                        break;
                    case "progress":
                        if (Float.isNaN(this.R)) {
                            break;
                        } else {
                            wVar.a(this.b, this.R);
                            break;
                        }
                        break;
                    default:
                        Log.v("KeyAttributes", "UNKNOWN addValues \"" + str + "\"");
                        break;
                }
            } else {
                androidx.d.e.b bVar = this.f.get(str.substring("CUSTOM".length() + 1));
                if (bVar != null) {
                    ((w.b) wVar).a(this.b, bVar);
                }
            }
        }
    }

    @Override // androidx.d.b.b.e
    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.E)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.O)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.P)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.Q)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.L)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.M)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.N)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.R)) {
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
        if (!Float.isNaN(this.E)) {
            map.put("alpha", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.F)) {
            map.put("elevation", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.G)) {
            map.put("rotation", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.H)) {
            map.put("rotationX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.I)) {
            map.put("rotationY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.J)) {
            map.put("transformPivotX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.K)) {
            map.put("transformPivotY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.O)) {
            map.put("translationX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.P)) {
            map.put("translationY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.Q)) {
            map.put("translationZ", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.L)) {
            map.put("transitionPathRotate", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.M)) {
            map.put("scaleX", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.N)) {
            map.put("scaleY", Integer.valueOf(this.C));
        }
        if (!Float.isNaN(this.R)) {
            map.put(androidx.core.app.p.al, Integer.valueOf(this.C));
        }
        if (this.f.size() > 0) {
            Iterator<String> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.C));
            }
        }
    }
}
