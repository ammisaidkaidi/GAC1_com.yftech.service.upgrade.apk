package androidx.core.b.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f403a = 0;
    private static final int b = 1;
    private static final int c = 2;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f404a;
        final float[] b;

        a(@k int i, @k int i2) {
            this.f404a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(@k int i, @k int i2, @k int i3) {
            this.f404a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }

        a(@ah List<Integer> list, @ah List<Float> list2) {
            int size = list.size();
            this.f404a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f404a[i] = list.get(i).intValue();
                this.b[i] = list2.get(i).floatValue();
            }
        }
    }

    private e() {
    }

    private static Shader.TileMode a(int i) {
        switch (i) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }

    static Shader a(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    static Shader a(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.core.a.j.GradientColor);
        float fA = h.a(typedArrayA, xmlPullParser, "startX", androidx.core.a.j.GradientColor_android_startX, 0.0f);
        float fA2 = h.a(typedArrayA, xmlPullParser, "startY", androidx.core.a.j.GradientColor_android_startY, 0.0f);
        float fA3 = h.a(typedArrayA, xmlPullParser, "endX", androidx.core.a.j.GradientColor_android_endX, 0.0f);
        float fA4 = h.a(typedArrayA, xmlPullParser, "endY", androidx.core.a.j.GradientColor_android_endY, 0.0f);
        float fA5 = h.a(typedArrayA, xmlPullParser, "centerX", androidx.core.a.j.GradientColor_android_centerX, 0.0f);
        float fA6 = h.a(typedArrayA, xmlPullParser, "centerY", androidx.core.a.j.GradientColor_android_centerY, 0.0f);
        int iA = h.a(typedArrayA, xmlPullParser, "type", androidx.core.a.j.GradientColor_android_type, 0);
        int iB = h.b(typedArrayA, xmlPullParser, "startColor", androidx.core.a.j.GradientColor_android_startColor, 0);
        boolean zA = h.a(xmlPullParser, "centerColor");
        int iB2 = h.b(typedArrayA, xmlPullParser, "centerColor", androidx.core.a.j.GradientColor_android_centerColor, 0);
        int iB3 = h.b(typedArrayA, xmlPullParser, "endColor", androidx.core.a.j.GradientColor_android_endColor, 0);
        int iA2 = h.a(typedArrayA, xmlPullParser, "tileMode", androidx.core.a.j.GradientColor_android_tileMode, 0);
        float fA7 = h.a(typedArrayA, xmlPullParser, "gradientRadius", androidx.core.a.j.GradientColor_android_gradientRadius, 0.0f);
        typedArrayA.recycle();
        a aVarA = a(b(resources, xmlPullParser, attributeSet, theme), iB, iB3, zA, iB2);
        switch (iA) {
            case 1:
                if (fA7 > 0.0f) {
                    return new RadialGradient(fA5, fA6, fA7, aVarA.f404a, aVarA.b, a(iA2));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            case 2:
                return new SweepGradient(fA5, fA6, aVarA.f404a, aVarA.b);
            default:
                return new LinearGradient(fA, fA2, fA3, fA4, aVarA.f404a, aVarA.b, a(iA2));
        }
    }

    private static a a(@ai a aVar, @k int i, @k int i2, boolean z, @k int i3) {
        if (aVar != null) {
            return aVar;
        }
        return z ? new a(i, i3, i2) : new a(i, i2);
    }

    private static a b(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.core.a.j.GradientColorItem);
                boolean zHasValue = typedArrayA.hasValue(androidx.core.a.j.GradientColorItem_android_color);
                boolean zHasValue2 = typedArrayA.hasValue(androidx.core.a.j.GradientColorItem_android_offset);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayA.getColor(androidx.core.a.j.GradientColorItem_android_color, 0);
                float f = typedArrayA.getFloat(androidx.core.a.j.GradientColorItem_android_offset, 0.0f);
                typedArrayA.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }
}
