package com.google.android.material.t;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.ah;
import androidx.annotation.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final float f1423a = 180.0f;
    private static final float h = 270.0f;

    @Deprecated
    public float b;

    @Deprecated
    public float c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;

    @Deprecated
    public float g;
    private final List<f> i = new ArrayList();
    private final List<h> j = new ArrayList();
    private boolean k;

    static class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f1425a;

        public a(c cVar) {
            this.f1425a = cVar;
        }

        @Override // com.google.android.material.t.q.h
        public void a(Matrix matrix, @ah com.google.android.material.s.b bVar, int i, @ah Canvas canvas) {
            bVar.a(canvas, matrix, new RectF(this.f1425a.a(), this.f1425a.b(), this.f1425a.c(), this.f1425a.d()), i, this.f1425a.e(), this.f1425a.f());
        }
    }

    static class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f1426a;
        private final float b;
        private final float c;

        public b(e eVar, float f, float f2) {
            this.f1426a = eVar;
            this.b = f;
            this.c = f2;
        }

        float a() {
            return (float) Math.toDegrees(Math.atan((this.f1426a.b - this.c) / (this.f1426a.f1429a - this.b)));
        }

        @Override // com.google.android.material.t.q.h
        public void a(Matrix matrix, @ah com.google.android.material.s.b bVar, int i, @ah Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f1426a.b - this.c, this.f1426a.f1429a - this.b), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.b, this.c);
            matrix2.preRotate(a());
            bVar.a(canvas, matrix2, rectF, i);
        }
    }

    public static class c extends f {
        private static final RectF h = new RectF();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public float f1427a;

        @Deprecated
        public float b;

        @Deprecated
        public float c;

        @Deprecated
        public float d;

        @Deprecated
        public float e;

        @Deprecated
        public float f;

        public c(float f, float f2, float f3, float f4) {
            a(f);
            b(f2);
            c(f3);
            d(f4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float a() {
            return this.f1427a;
        }

        private void a(float f) {
            this.f1427a = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float b() {
            return this.b;
        }

        private void b(float f) {
            this.b = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float c() {
            return this.c;
        }

        private void c(float f) {
            this.c = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float d() {
            return this.d;
        }

        private void d(float f) {
            this.d = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float e() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(float f) {
            this.e = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float f() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(float f) {
            this.f = f;
        }

        @Override // com.google.android.material.t.q.f
        public void a(@ah Matrix matrix, @ah Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(a(), b(), c(), d());
            path.arcTo(h, e(), f(), false);
            path.transform(matrix);
        }
    }

    public static class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1428a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;

        public d(float f, float f2, float f3, float f4, float f5, float f6) {
            a(f);
            b(f2);
            c(f3);
            d(f4);
            e(f5);
            f(f6);
        }

        private float a() {
            return this.f1428a;
        }

        private void a(float f) {
            this.f1428a = f;
        }

        private float b() {
            return this.b;
        }

        private void b(float f) {
            this.b = f;
        }

        private float c() {
            return this.c;
        }

        private void c(float f) {
            this.c = f;
        }

        private float d() {
            return this.b;
        }

        private void d(float f) {
            this.d = f;
        }

        private float e() {
            return this.e;
        }

        private void e(float f) {
            this.e = f;
        }

        private float f() {
            return this.f;
        }

        private void f(float f) {
            this.f = f;
        }

        @Override // com.google.android.material.t.q.f
        public void a(@ah Matrix matrix, @ah Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f1428a, this.b, this.c, this.d, this.e, this.f);
            path.transform(matrix);
        }
    }

    public static class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1429a;
        private float b;

        @Override // com.google.android.material.t.q.f
        public void a(@ah Matrix matrix, @ah Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1429a, this.b);
            path.transform(matrix);
        }
    }

    public static abstract class f {
        protected final Matrix g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class g extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public float f1430a;

        @Deprecated
        public float b;

        @Deprecated
        public float c;

        @Deprecated
        public float d;

        private float a() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f) {
            this.c = f;
        }

        private float b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(float f) {
            this.b = f;
        }

        private float c() {
            return this.d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(float f) {
            this.d = f;
        }

        private float d() {
            return this.f1430a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(float f) {
            this.f1430a = f;
        }

        @Override // com.google.android.material.t.q.f
        public void a(@ah Matrix matrix, @ah Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(d(), b(), a(), c());
            path.transform(matrix);
        }
    }

    static abstract class h {
        static final Matrix d = new Matrix();

        h() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.s.b bVar, int i, Canvas canvas);

        public final void a(com.google.android.material.s.b bVar, int i, Canvas canvas) {
            a(d, bVar, i, canvas);
        }
    }

    public q() {
        a(0.0f, 0.0f);
    }

    public q(float f2, float f3) {
        a(f2, f3);
    }

    private void a(float f2) {
        if (f() == f2) {
            return;
        }
        float f3 = ((f2 - f()) + 360.0f) % 360.0f;
        if (f3 > f1423a) {
            return;
        }
        c cVar = new c(d(), e(), d(), e());
        cVar.e(f());
        cVar.f(f3);
        this.j.add(new a(cVar));
        f(f2);
    }

    private void a(h hVar, float f2, float f3) {
        a(f2);
        this.j.add(hVar);
        f(f3);
    }

    private void b(float f2) {
        this.b = f2;
    }

    private void c(float f2) {
        this.c = f2;
    }

    private void d(float f2) {
        this.d = f2;
    }

    private void e(float f2) {
        this.e = f2;
    }

    private float f() {
        return this.f;
    }

    private void f(float f2) {
        this.f = f2;
    }

    private float g() {
        return this.g;
    }

    private void g(float f2) {
        this.g = f2;
    }

    @ah
    h a(final Matrix matrix) {
        a(g());
        final ArrayList arrayList = new ArrayList(this.j);
        return new h() { // from class: com.google.android.material.t.q.1
            @Override // com.google.android.material.t.q.h
            public void a(Matrix matrix2, com.google.android.material.s.b bVar, int i, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).a(matrix, bVar, i, canvas);
                }
            }
        };
    }

    public void a(float f2, float f3) {
        a(f2, f3, h, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        b(f2);
        c(f3);
        d(f2);
        e(f3);
        f(f4);
        g((f4 + f5) % 360.0f);
        this.i.clear();
        this.j.clear();
        this.k = false;
    }

    @am(a = 21)
    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.i.add(new d(f2, f3, f4, f5, f6, f7));
        this.k = true;
        d(f6);
        e(f7);
    }

    public void a(Matrix matrix, Path path) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            this.i.get(i).a(matrix, path);
        }
    }

    boolean a() {
        return this.k;
    }

    float b() {
        return this.b;
    }

    public void b(float f2, float f3) {
        e eVar = new e();
        eVar.f1429a = f2;
        eVar.b = f3;
        this.i.add(eVar);
        b bVar = new b(eVar, d(), e());
        a(bVar, bVar.a() + h, bVar.a() + h);
        d(f2);
        e(f3);
    }

    @am(a = 21)
    public void b(float f2, float f3, float f4, float f5) {
        g gVar = new g();
        gVar.d(f2);
        gVar.b(f3);
        gVar.a(f4);
        gVar.c(f5);
        this.i.add(gVar);
        this.k = true;
        d(f4);
        e(f5);
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.e(f6);
        cVar.f(f7);
        this.i.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + f1423a) % 360.0f;
        }
        a(aVar, f6, z ? (f1423a + f8) % 360.0f : f8);
        double d2 = f8;
        d(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        e(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    float c() {
        return this.c;
    }

    float d() {
        return this.d;
    }

    float e() {
        return this.e;
    }
}
