package com.google.android.material.z;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f1546a = new Path();
    private final Path b = new Path();
    private final Path c = new Path();
    private final com.google.android.material.t.p d = new com.google.android.material.t.p();
    private com.google.android.material.t.o e;

    j() {
    }

    Path a() {
        return this.f1546a;
    }

    void a(float f, com.google.android.material.t.o oVar, com.google.android.material.t.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.c cVar) {
        this.e = u.a(oVar, oVar2, rectF, rectF3, cVar.a(), cVar.b(), f);
        this.d.a(this.e, 1.0f, rectF2, this.b);
        this.d.a(this.e, 1.0f, rectF3, this.c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1546a.op(this.b, this.c, Path.Op.UNION);
        }
    }

    void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f1546a);
        } else {
            canvas.clipPath(this.b);
            canvas.clipPath(this.c, Region.Op.UNION);
        }
    }

    com.google.android.material.t.o b() {
        return this.e;
    }
}
