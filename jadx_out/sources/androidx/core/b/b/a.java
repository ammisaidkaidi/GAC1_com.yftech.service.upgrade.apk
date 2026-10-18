package androidx.core.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.az;
import androidx.annotation.k;
import androidx.annotation.r;
import androidx.core.n.af;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public final class a {
    private a() {
    }

    @k
    private static int a(@k int i, @r(a = 0.0d, b = 1.0d) float f) {
        return (i & af.r) | (Math.round(Color.alpha(i) * f) << 24);
    }

    @ai
    public static ColorStateList a(@ah Resources resources, @az int i, @ai Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    @ah
    public static ColorStateList a(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
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

    @ah
    public static ColorStateList a(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static ColorStateList b(@ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[iArr.length];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayA = a(resources, theme, attributeSet, androidx.core.a.j.ColorStateListItem);
                int color = typedArrayA.getColor(androidx.core.a.j.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (typedArrayA.hasValue(androidx.core.a.j.ColorStateListItem_android_alpha)) {
                    f = typedArrayA.getFloat(androidx.core.a.j.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayA.hasValue(androidx.core.a.j.ColorStateListItem_alpha)) {
                    f = typedArrayA.getFloat(androidx.core.a.j.ColorStateListItem_alpha, 1.0f);
                }
                typedArrayA.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != androidx.core.a.C0022a.alpha) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i3);
                iArrA = f.a(iArrA, i2, a(color, f));
                iArr = (int[][]) f.a(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            i = 1;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        System.arraycopy(iArrA, 0, iArr3, 0, i2);
        System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new ColorStateList(iArr4, iArr3);
    }
}
