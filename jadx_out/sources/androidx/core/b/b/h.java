package androidx.core.b.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.au;
import androidx.annotation.k;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f409a = "http://schemas.android.com/apk/res/android";

    private h() {
    }

    public static float a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i, float f) {
        return !a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int a(@ah Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static int a(@ah TypedArray typedArray, @au int i, @au int i2, int i3) {
        return typedArray.getInt(i, typedArray.getInt(i2, i3));
    }

    public static int a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i, int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    @ai
    public static ColorStateList a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ai Resources.Theme theme, @ah String str, @au int i) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        if (typedValue.type != 2) {
            return (typedValue.type < 28 || typedValue.type > 31) ? a.a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme) : a(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
    }

    @ah
    private static ColorStateList a(@ah TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    @ah
    public static TypedArray a(@ah Resources resources, @ai Resources.Theme theme, @ah AttributeSet attributeSet, @ah int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @ai
    public static Drawable a(@ah TypedArray typedArray, @au int i, @au int i2) {
        Drawable drawable = typedArray.getDrawable(i);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    public static b a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ai Resources.Theme theme, @ah String str, @au int i, @k int i2) {
        if (a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return b.a(typedValue.data);
            }
            b bVarA = b.a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (bVarA != null) {
                return bVarA;
            }
        }
        return b.a(i2);
    }

    @ai
    public static String a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i) {
        if (a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static boolean a(@ah TypedArray typedArray, @au int i, @au int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    public static boolean a(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i, boolean z) {
        return !a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean a(@ah XmlPullParser xmlPullParser, @ah String str) {
        return xmlPullParser.getAttributeValue(f409a, str) != null;
    }

    @androidx.annotation.c
    public static int b(@ah TypedArray typedArray, @au int i, @au int i2, @androidx.annotation.c int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    @k
    public static int b(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i, @k int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    @ai
    public static TypedValue b(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, int i) {
        if (a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    @ai
    public static String b(@ah TypedArray typedArray, @au int i, @au int i2) {
        String string = typedArray.getString(i);
        return string == null ? typedArray.getString(i2) : string;
    }

    @androidx.annotation.c
    public static int c(@ah TypedArray typedArray, @ah XmlPullParser xmlPullParser, @ah String str, @au int i, @androidx.annotation.c int i2) {
        return !a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    @ai
    public static CharSequence c(@ah TypedArray typedArray, @au int i, @au int i2) {
        CharSequence text = typedArray.getText(i);
        return text == null ? typedArray.getText(i2) : text;
    }

    @ai
    public static CharSequence[] d(@ah TypedArray typedArray, @au int i, @au int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }
}
