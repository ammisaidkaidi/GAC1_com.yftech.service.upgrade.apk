package com.google.android.material.z;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f1544a = new f() { // from class: com.google.android.material.z.g.1
        @Override // com.google.android.material.z.f
        public h a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fA = u.a(f4, f6, f2, f3, f);
            float f8 = fA / f4;
            float f9 = fA / f6;
            return new h(f8, f9, fA, f5 * f8, fA, f7 * f9);
        }

        @Override // com.google.android.material.z.f
        public void a(RectF rectF, float f, h hVar) {
            rectF.bottom -= Math.abs(hVar.f - hVar.d) * f;
        }

        @Override // com.google.android.material.z.f
        public boolean a(h hVar) {
            return hVar.d > hVar.f;
        }
    };
    private static final f b = new f() { // from class: com.google.android.material.z.g.2
        @Override // com.google.android.material.z.f
        public h a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fA = u.a(f5, f7, f2, f3, f);
            float f8 = fA / f5;
            float f9 = fA / f7;
            return new h(f8, f9, f4 * f8, fA, f6 * f9, fA);
        }

        @Override // com.google.android.material.z.f
        public void a(RectF rectF, float f, h hVar) {
            float fAbs = (Math.abs(hVar.e - hVar.c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // com.google.android.material.z.f
        public boolean a(h hVar) {
            return hVar.c > hVar.e;
        }
    };

    private g() {
    }

    static f a(int i, boolean z, RectF rectF, RectF rectF2) {
        switch (i) {
            case 0:
                return a(z, rectF, rectF2) ? f1544a : b;
            case 1:
                return f1544a;
            case 2:
                return b;
            default:
                throw new IllegalArgumentException("Invalid fit mode: " + i);
        }
    }

    private static boolean a(boolean z, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f = (fHeight2 * fWidth) / fWidth2;
        float f2 = (fWidth2 * fHeight) / fWidth;
        if (z) {
            if (f < fHeight) {
                return false;
            }
        } else if (f2 < fHeight2) {
            return false;
        }
        return true;
    }
}
