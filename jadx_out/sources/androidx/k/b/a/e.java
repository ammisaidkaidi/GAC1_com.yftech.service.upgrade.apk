package androidx.k.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.ap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f926a = "AnimatorInflater";
    private static final int b = 0;
    private static final int c = 100;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private static final boolean i = false;

    private static class a implements TypeEvaluator<androidx.core.graphics.h.b[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.core.graphics.h.b[] f927a;

        a() {
        }

        a(androidx.core.graphics.h.b[] bVarArr) {
            this.f927a = bVarArr;
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public androidx.core.graphics.h.b[] evaluate(float f, androidx.core.graphics.h.b[] bVarArr, androidx.core.graphics.h.b[] bVarArr2) {
            if (!androidx.core.graphics.h.a(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!androidx.core.graphics.h.a(this.f927a, bVarArr)) {
                this.f927a = androidx.core.graphics.h.a(bVarArr);
            }
            for (int i = 0; i < bVarArr.length; i++) {
                this.f927a[i].a(bVarArr[i], bVarArr2[i], f);
            }
            return this.f927a;
        }
    }

    private e() {
    }

    private static int a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayA = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.ah);
        int i2 = 0;
        TypedValue typedValueB = androidx.core.b.b.h.b(typedArrayA, xmlPullParser, "value", 0);
        if ((typedValueB != null) && a(typedValueB.type)) {
            i2 = 3;
        }
        typedArrayA.recycle();
        return i2;
    }

    private static int a(TypedArray typedArray, int i2, int i3) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && a(i4)) || (z2 && a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    public static Animator a(Context context, @androidx.annotation.b int i2) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i2) : a(context, context.getResources(), context.getTheme(), i2);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, @androidx.annotation.b int i2) {
        return a(context, resources, theme, i2, 1.0f);
    }

    public static Animator a(Context context, Resources resources, Resources.Theme theme, @androidx.annotation.b int i2, float f2) throws Throwable {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser animation = resources.getAnimation(i2);
                try {
                    Animator animatorA = a(context, resources, theme, animation, f2);
                    if (animation != null) {
                        animation.close();
                    }
                    return animatorA;
                } catch (IOException e2) {
                    e = e2;
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException.initCause(e);
                    throw notFoundException;
                } catch (XmlPullParserException e3) {
                    e = e3;
                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                    notFoundException2.initCause(e);
                    throw notFoundException2;
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = animation;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (XmlPullParserException e5) {
            e = e5;
        }
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f2) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f2);
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) throws XmlPullParserException, IOException {
        int i3;
        int depth = xmlPullParser.getDepth();
        Animator animatorA = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i3 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorA = a(context, resources, theme, attributeSet, f2, xmlPullParser);
                } else {
                    if (name.equals("animator")) {
                        animatorA = a(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayA = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.aa);
                        a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "ordering", 0, 0), f2);
                        typedArrayA.recycle();
                        animatorA = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrA = a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrA != null && (animatorA instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorA).setValues(propertyValuesHolderArrA);
                        }
                        i3 = 1;
                    }
                    if (animatorSet == null && i3 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorA);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i3] = (Animator) it.next();
                i3++;
            }
            if (i2 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorA;
    }

    private static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        return keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    private static Keyframe a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i2, XmlPullParser xmlPullParser) {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayA = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.ah);
        float fA = androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueB = androidx.core.b.b.h.b(typedArrayA, xmlPullParser, "value", 0);
        boolean z = typedValueB != null;
        if (i2 == 4) {
            i2 = (z && a(typedValueB.type)) ? 3 : 0;
        }
        if (!z) {
            keyframeOfFloat = i2 == 0 ? Keyframe.ofFloat(fA) : Keyframe.ofInt(fA);
        } else if (i2 != 3) {
            switch (i2) {
                case 0:
                    keyframeOfFloat = Keyframe.ofFloat(fA, androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                    keyframeOfFloat = Keyframe.ofInt(fA, androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "value", 0, 0));
                    break;
                default:
                    keyframeOfFloat = null;
                    break;
            }
        } else {
            keyframeOfFloat = Keyframe.ofInt(fA, androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "value", 0, 0));
        }
        int iC = androidx.core.b.b.h.c(typedArrayA, xmlPullParser, "interpolator", 1, 0);
        if (iC > 0) {
            keyframeOfFloat.setInterpolator(d.a(context, iC));
        }
        typedArrayA.recycle();
        return keyframeOfFloat;
    }

    private static ObjectAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i2) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iA = i2;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iA == 4) {
                    iA = a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeA = a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iA, xmlPullParser);
                if (keyframeA != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeA);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i3 = 0; i3 < size; i3++) {
                Keyframe keyframe3 = keyframeArr[i3];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i3 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i4 = size - 1;
                        if (i3 == i4) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i5 = i3;
                            for (int i6 = i3 + 1; i6 < i4 && keyframeArr[i6].getFraction() < 0.0f; i6++) {
                                i5 = i6;
                            }
                            a(keyframeArr, keyframeArr[i5 + 1].getFraction() - keyframeArr[i3 - 1].getFraction(), i3, i5);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iA == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(f.a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i2, int i3, int i4, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        boolean z = typedValuePeekValue != null;
        int i5 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i4);
        boolean z2 = typedValuePeekValue2 != null;
        int i6 = z2 ? typedValuePeekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && a(i5)) || (z2 && a(i6))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            androidx.core.graphics.h.b[] bVarArrB = androidx.core.graphics.h.b(string);
            androidx.core.graphics.h.b[] bVarArrB2 = androidx.core.graphics.h.b(string2);
            if (bVarArrB == null && bVarArrB2 == null) {
                return null;
            }
            if (bVarArrB == null) {
                if (bVarArrB2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), bVarArrB2);
                }
                return null;
            }
            a aVar = new a();
            if (bVarArrB2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrB);
            } else {
                if (!androidx.core.graphics.h.a(bVarArrB, bVarArrB2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrB, bVarArrB2);
            }
            return propertyValuesHolderOfObject;
        }
        f fVarA = i2 == 3 ? f.a() : null;
        if (z3) {
            if (z) {
                float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            if (i5 == 5) {
                color2 = (int) typedArray.getDimension(i3, 0.0f);
            } else {
                color2 = a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            }
            if (z2) {
                if (i6 == 5) {
                    color3 = (int) typedArray.getDimension(i4, 0.0f);
                } else {
                    color3 = a(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z2) {
            if (i6 == 5) {
                color = (int) typedArray.getDimension(i4, 0.0f);
            } else {
                color = a(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || fVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(fVarA);
        return propertyValuesHolderOfInt;
    }

    private static ValueAnimator a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray typedArrayA = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.R);
        TypedArray typedArrayA2 = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.am);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, typedArrayA, typedArrayA2, f2, xmlPullParser);
        int iC = androidx.core.b.b.h.c(typedArrayA, xmlPullParser, "interpolator", 0, 0);
        if (iC > 0) {
            valueAnimator.setInterpolator(d.a(context, iC));
        }
        typedArrayA.recycle();
        if (typedArrayA2 != null) {
            typedArrayA2.recycle();
        }
        return valueAnimator;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i2, float f2, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strA = androidx.core.b.b.h.a(typedArray, xmlPullParser, "pathData", 1);
        if (strA == null) {
            objectAnimator.setPropertyName(androidx.core.b.b.h.a(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strA2 = androidx.core.b.b.h.a(typedArray, xmlPullParser, "propertyXName", 2);
        String strA3 = androidx.core.b.b.h.a(typedArray, xmlPullParser, "propertyYName", 3);
        if (i2 != 2) {
        }
        if (strA2 != null || strA3 != null) {
            a(androidx.core.graphics.h.a(strA), objectAnimator, f2 * 0.5f, strA2, strA3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f2, XmlPullParser xmlPullParser) {
        long jA = androidx.core.b.b.h.a(typedArray, xmlPullParser, "duration", 1, 300);
        long jA2 = androidx.core.b.b.h.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iA = androidx.core.b.b.h.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (androidx.core.b.b.h.a(xmlPullParser, "valueFrom") && androidx.core.b.b.h.a(xmlPullParser, "valueTo")) {
            if (iA == 4) {
                iA = a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderA = a(typedArray, iA, 5, 6, com.yftech.service.upgrade.a.d);
            if (propertyValuesHolderA != null) {
                valueAnimator.setValues(propertyValuesHolderA);
            }
        }
        valueAnimator.setDuration(jA);
        valueAnimator.setStartDelay(jA2);
        valueAnimator.setRepeatCount(androidx.core.b.b.h.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(androidx.core.b.b.h.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, iA, f2, xmlPullParser);
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f2, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f2)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f3 = length / (iMin - 1);
        int i2 = 0;
        float f4 = 0.0f;
        int i3 = 0;
        while (true) {
            if (i3 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i2)).floatValue(), fArr3, null);
            fArr[i3] = fArr3[0];
            fArr2[i3] = fArr3[1];
            f4 += f3;
            int i4 = i2 + 1;
            if (i4 < arrayList.size() && f4 > ((Float) arrayList.get(i4)).floatValue()) {
                pathMeasure2.nextContour();
                i2 = i4;
            }
            i3++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }

    private static void a(Keyframe[] keyframeArr, float f2, int i2, int i3) {
        float f3 = f2 / ((i3 - i2) + 2);
        while (i2 <= i3) {
            keyframeArr[i2].setFraction(keyframeArr[i2 - 1].getFraction() + f3);
            i2++;
        }
    }

    private static void a(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Log.d(f926a, str);
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Keyframe keyframe = (Keyframe) objArr[i2];
            StringBuilder sb = new StringBuilder();
            sb.append("Keyframe ");
            sb.append(i2);
            sb.append(": fraction ");
            sb.append(keyframe.getFraction() < 0.0f ? "null" : Float.valueOf(keyframe.getFraction()));
            sb.append(", , value : ");
            sb.append(keyframe.hasValue() ? keyframe.getValue() : "null");
            Log.d(f926a, sb.toString());
        }
    }

    private static boolean a(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    private static PropertyValuesHolder[] a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayA = androidx.core.b.b.h.a(resources, theme, attributeSet, androidx.k.b.a.a.ac);
                    String strA = androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "propertyName", 3);
                    int iA = androidx.core.b.b.h.a(typedArrayA, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderA = a(context, resources, theme, xmlPullParser, strA, iA);
                    if (propertyValuesHolderA == null) {
                        propertyValuesHolderA = a(typedArrayA, iA, 0, 1, strA);
                    }
                    if (propertyValuesHolderA != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderA);
                    }
                    typedArrayA.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i2 = 0; i2 < size; i2++) {
                propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
            }
        }
        return propertyValuesHolderArr;
    }
}
