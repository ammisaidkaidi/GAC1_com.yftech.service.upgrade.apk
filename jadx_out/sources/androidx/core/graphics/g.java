package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f433a = "\udfffd";
    private static final String b = "m";
    private static final ThreadLocal<androidx.core.m.f<Rect, Rect>> c = new ThreadLocal<>();

    private g() {
    }

    private static androidx.core.m.f<Rect, Rect> a() {
        androidx.core.m.f<Rect, Rect> fVar = c.get();
        if (fVar == null) {
            androidx.core.m.f<Rect, Rect> fVar2 = new androidx.core.m.f<>(new Rect(), new Rect());
            c.set(fVar2);
            return fVar2;
        }
        fVar.f503a.setEmpty();
        fVar.b.setEmpty();
        return fVar;
    }

    public static boolean a(@ah Paint paint, @ai c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            paint.setBlendMode(cVar != null ? d.a(cVar) : null);
            return true;
        }
        if (cVar == null) {
            paint.setXfermode(null);
            return true;
        }
        PorterDuff.Mode modeB = d.b(cVar);
        paint.setXfermode(modeB != null ? new PorterDuffXfermode(modeB) : null);
        return modeB != null;
    }

    public static boolean a(@ah Paint paint, @ah String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float fMeasureText = paint.measureText(f433a);
        float fMeasureText2 = paint.measureText(b);
        float fMeasureText3 = paint.measureText(str);
        float fMeasureText4 = 0.0f;
        if (fMeasureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (fMeasureText3 > fMeasureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int iCharCount = Character.charCount(str.codePointAt(i)) + i;
                fMeasureText4 += paint.measureText(str, i, iCharCount);
                i = iCharCount;
            }
            if (fMeasureText3 >= fMeasureText4) {
                return false;
            }
        }
        if (fMeasureText3 != fMeasureText) {
            return true;
        }
        androidx.core.m.f<Rect, Rect> fVarA = a();
        paint.getTextBounds(f433a, 0, f433a.length(), fVarA.f503a);
        paint.getTextBounds(str, 0, length, fVarA.b);
        return !fVarA.f503a.equals(fVarA.b);
    }
}
