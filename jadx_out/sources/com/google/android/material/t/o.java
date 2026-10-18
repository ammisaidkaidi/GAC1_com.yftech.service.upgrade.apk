package com.google.android.material.t;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.ah;
import androidx.annotation.ap;
import androidx.annotation.at;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1419a = new m(0.5f);
    e b;
    e c;
    e d;
    e e;
    d f;
    d g;
    d h;
    d i;
    g j;
    g k;
    g l;
    g m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ah
        private e f1420a;

        @ah
        private e b;

        @ah
        private e c;

        @ah
        private e d;

        @ah
        private d e;

        @ah
        private d f;

        @ah
        private d g;

        @ah
        private d h;

        @ah
        private g i;

        @ah
        private g j;

        @ah
        private g k;

        @ah
        private g l;

        public a() {
            this.f1420a = k.a();
            this.b = k.a();
            this.c = k.a();
            this.d = k.a();
            this.e = new com.google.android.material.t.a(0.0f);
            this.f = new com.google.android.material.t.a(0.0f);
            this.g = new com.google.android.material.t.a(0.0f);
            this.h = new com.google.android.material.t.a(0.0f);
            this.i = k.b();
            this.j = k.b();
            this.k = k.b();
            this.l = k.b();
        }

        public a(@ah o oVar) {
            this.f1420a = k.a();
            this.b = k.a();
            this.c = k.a();
            this.d = k.a();
            this.e = new com.google.android.material.t.a(0.0f);
            this.f = new com.google.android.material.t.a(0.0f);
            this.g = new com.google.android.material.t.a(0.0f);
            this.h = new com.google.android.material.t.a(0.0f);
            this.i = k.b();
            this.j = k.b();
            this.k = k.b();
            this.l = k.b();
            this.f1420a = oVar.b;
            this.b = oVar.c;
            this.c = oVar.d;
            this.d = oVar.e;
            this.e = oVar.f;
            this.f = oVar.g;
            this.g = oVar.h;
            this.h = oVar.i;
            this.i = oVar.j;
            this.j = oVar.k;
            this.k = oVar.l;
            this.l = oVar.m;
        }

        private static float f(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).f1418a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f1408a;
            }
            return -1.0f;
        }

        @ah
        public a a(@androidx.annotation.p float f) {
            return b(f).c(f).d(f).e(f);
        }

        @ah
        public a a(int i, @androidx.annotation.p float f) {
            return a(k.a(i)).a(f);
        }

        @ah
        public a a(int i, @ah d dVar) {
            return b(k.a(i)).b(dVar);
        }

        @ah
        public a a(@ah d dVar) {
            return b(dVar).c(dVar).d(dVar).e(dVar);
        }

        @ah
        public a a(@ah e eVar) {
            return b(eVar).c(eVar).d(eVar).e(eVar);
        }

        @ah
        public a a(@ah g gVar) {
            return b(gVar).c(gVar).d(gVar).e(gVar);
        }

        @ah
        public o a() {
            return new o(this);
        }

        @ah
        public a b(@androidx.annotation.p float f) {
            this.e = new com.google.android.material.t.a(f);
            return this;
        }

        @ah
        public a b(int i, @androidx.annotation.p float f) {
            return b(k.a(i)).b(f);
        }

        @ah
        public a b(int i, @ah d dVar) {
            return c(k.a(i)).c(dVar);
        }

        @ah
        public a b(@ah d dVar) {
            this.e = dVar;
            return this;
        }

        @ah
        public a b(@ah e eVar) {
            this.f1420a = eVar;
            float f = f(eVar);
            if (f != -1.0f) {
                b(f);
            }
            return this;
        }

        @ah
        public a b(@ah g gVar) {
            this.l = gVar;
            return this;
        }

        @ah
        public a c(@androidx.annotation.p float f) {
            this.f = new com.google.android.material.t.a(f);
            return this;
        }

        @ah
        public a c(int i, @androidx.annotation.p float f) {
            return c(k.a(i)).c(f);
        }

        @ah
        public a c(int i, @ah d dVar) {
            return d(k.a(i)).d(dVar);
        }

        @ah
        public a c(@ah d dVar) {
            this.f = dVar;
            return this;
        }

        @ah
        public a c(@ah e eVar) {
            this.b = eVar;
            float f = f(eVar);
            if (f != -1.0f) {
                c(f);
            }
            return this;
        }

        @ah
        public a c(@ah g gVar) {
            this.i = gVar;
            return this;
        }

        @ah
        public a d(@androidx.annotation.p float f) {
            this.g = new com.google.android.material.t.a(f);
            return this;
        }

        @ah
        public a d(int i, @androidx.annotation.p float f) {
            return d(k.a(i)).d(f);
        }

        @ah
        public a d(int i, @ah d dVar) {
            return e(k.a(i)).e(dVar);
        }

        @ah
        public a d(@ah d dVar) {
            this.g = dVar;
            return this;
        }

        @ah
        public a d(@ah e eVar) {
            this.c = eVar;
            float f = f(eVar);
            if (f != -1.0f) {
                d(f);
            }
            return this;
        }

        @ah
        public a d(@ah g gVar) {
            this.j = gVar;
            return this;
        }

        @ah
        public a e(@androidx.annotation.p float f) {
            this.h = new com.google.android.material.t.a(f);
            return this;
        }

        @ah
        public a e(int i, @androidx.annotation.p float f) {
            return e(k.a(i)).e(f);
        }

        @ah
        public a e(@ah d dVar) {
            this.h = dVar;
            return this;
        }

        @ah
        public a e(@ah e eVar) {
            this.d = eVar;
            float f = f(eVar);
            if (f != -1.0f) {
                e(f);
            }
            return this;
        }

        @ah
        public a e(@ah g gVar) {
            this.k = gVar;
            return this;
        }
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public interface b {
        @ah
        d a(@ah d dVar);
    }

    public o() {
        this.b = k.a();
        this.c = k.a();
        this.d = k.a();
        this.e = k.a();
        this.f = new com.google.android.material.t.a(0.0f);
        this.g = new com.google.android.material.t.a(0.0f);
        this.h = new com.google.android.material.t.a(0.0f);
        this.i = new com.google.android.material.t.a(0.0f);
        this.j = k.b();
        this.k = k.b();
        this.l = k.b();
        this.m = k.b();
    }

    private o(@ah a aVar) {
        this.b = aVar.f1420a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.j = aVar.i;
        this.k = aVar.j;
        this.l = aVar.k;
        this.m = aVar.l;
    }

    @ah
    private static d a(TypedArray typedArray, int i, @ah d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return dVar;
        }
        if (typedValuePeekValue.type == 5) {
            return new com.google.android.material.t.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return typedValuePeekValue.type == 6 ? new m(typedValuePeekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @ah
    public static a a() {
        return new a();
    }

    @ah
    public static a a(Context context, @at int i, @at int i2) {
        return a(context, i, i2, 0);
    }

    @ah
    private static a a(Context context, @at int i, @at int i2, int i3) {
        return a(context, i, i2, new com.google.android.material.t.a(i3));
    }

    @ah
    private static a a(Context context, @at int i, @at int i2, @ah d dVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, com.google.android.material.a.o.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(com.google.android.material.a.o.ShapeAppearance_cornerFamilyBottomLeft, i3);
            d dVarA = a(typedArrayObtainStyledAttributes, com.google.android.material.a.o.ShapeAppearance_cornerSize, dVar);
            d dVarA2 = a(typedArrayObtainStyledAttributes, com.google.android.material.a.o.ShapeAppearance_cornerSizeTopLeft, dVarA);
            d dVarA3 = a(typedArrayObtainStyledAttributes, com.google.android.material.a.o.ShapeAppearance_cornerSizeTopRight, dVarA);
            d dVarA4 = a(typedArrayObtainStyledAttributes, com.google.android.material.a.o.ShapeAppearance_cornerSizeBottomRight, dVarA);
            return new a().a(i4, dVarA2).b(i5, dVarA3).c(i6, dVarA4).d(i7, a(typedArrayObtainStyledAttributes, com.google.android.material.a.o.ShapeAppearance_cornerSizeBottomLeft, dVarA));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @ah
    public static a a(@ah Context context, AttributeSet attributeSet, @androidx.annotation.f int i, @at int i2) {
        return a(context, attributeSet, i, i2, 0);
    }

    @ah
    public static a a(@ah Context context, AttributeSet attributeSet, @androidx.annotation.f int i, @at int i2, int i3) {
        return a(context, attributeSet, i, i2, new com.google.android.material.t.a(i3));
    }

    @ah
    public static a a(@ah Context context, AttributeSet attributeSet, @androidx.annotation.f int i, @at int i2, @ah d dVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.a.o.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.a.o.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, dVar);
    }

    @ah
    public o a(float f) {
        return n().a(f).a();
    }

    @ah
    public o a(@ah d dVar) {
        return n().a(dVar).a();
    }

    @ah
    @ap(a = {ap.a.LIBRARY_GROUP})
    public o a(@ah b bVar) {
        return n().b(bVar.a(f())).c(bVar.a(g())).e(bVar.a(i())).d(bVar.a(h())).a();
    }

    @ap(a = {ap.a.LIBRARY_GROUP})
    public boolean a(@ah RectF rectF) {
        boolean z = this.m.getClass().equals(g.class) && this.k.getClass().equals(g.class) && this.j.getClass().equals(g.class) && this.l.getClass().equals(g.class);
        float fA = this.f.a(rectF);
        return z && ((this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0 && (this.i.a(rectF) > fA ? 1 : (this.i.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0) && ((this.c instanceof n) && (this.b instanceof n) && (this.d instanceof n) && (this.e instanceof n));
    }

    @ah
    public e b() {
        return this.b;
    }

    @ah
    public e c() {
        return this.c;
    }

    @ah
    public e d() {
        return this.d;
    }

    @ah
    public e e() {
        return this.e;
    }

    @ah
    public d f() {
        return this.f;
    }

    @ah
    public d g() {
        return this.g;
    }

    @ah
    public d h() {
        return this.h;
    }

    @ah
    public d i() {
        return this.i;
    }

    @ah
    public g j() {
        return this.m;
    }

    @ah
    public g k() {
        return this.j;
    }

    @ah
    public g l() {
        return this.k;
    }

    @ah
    public g m() {
        return this.l;
    }

    @ah
    public a n() {
        return new a(this);
    }
}
