package androidx.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f302a = new RectF();

    d() {
    }

    private h a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new h(context.getResources(), colorStateList, f, f2, f3);
    }

    private h j(e eVar) {
        return (h) eVar.c();
    }

    @Override // androidx.b.a.f
    public float a(e eVar) {
        return j(eVar).c();
    }

    @Override // androidx.b.a.f
    public void a() {
        h.f305a = new h.a() { // from class: androidx.b.a.d.1
            @Override // androidx.b.a.h.a
            public void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float fWidth = (rectF.width() - f2) - 1.0f;
                float fHeight = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    d.this.f302a.set(f4, f4, f3, f3);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(d.this.f302a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.f302a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.f302a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(d.this.f302a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    @Override // androidx.b.a.f
    public void a(e eVar, float f) {
        j(eVar).a(f);
        f(eVar);
    }

    @Override // androidx.b.a.f
    public void a(e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        h hVarA = a(context, colorStateList, f, f2, f3);
        hVarA.a(eVar.b());
        eVar.a(hVarA);
        f(eVar);
    }

    @Override // androidx.b.a.f
    public void a(e eVar, @ai ColorStateList colorStateList) {
        j(eVar).a(colorStateList);
    }

    @Override // androidx.b.a.f
    public float b(e eVar) {
        return j(eVar).d();
    }

    @Override // androidx.b.a.f
    public void b(e eVar, float f) {
        j(eVar).c(f);
        f(eVar);
    }

    @Override // androidx.b.a.f
    public float c(e eVar) {
        return j(eVar).e();
    }

    @Override // androidx.b.a.f
    public void c(e eVar, float f) {
        j(eVar).b(f);
    }

    @Override // androidx.b.a.f
    public float d(e eVar) {
        return j(eVar).a();
    }

    @Override // androidx.b.a.f
    public float e(e eVar) {
        return j(eVar).b();
    }

    @Override // androidx.b.a.f
    public void f(e eVar) {
        Rect rect = new Rect();
        j(eVar).a(rect);
        eVar.a((int) Math.ceil(b(eVar)), (int) Math.ceil(c(eVar)));
        eVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.b.a.f
    public void g(e eVar) {
    }

    @Override // androidx.b.a.f
    public void h(e eVar) {
        j(eVar).a(eVar.b());
        f(eVar);
    }

    @Override // androidx.b.a.f
    public ColorStateList i(e eVar) {
        return j(eVar).f();
    }
}
