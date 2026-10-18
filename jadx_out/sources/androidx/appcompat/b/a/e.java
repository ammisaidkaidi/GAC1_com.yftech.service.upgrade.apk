package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import androidx.appcompat.widget.ao;
import androidx.core.b.b.h;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
class e extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f107a = "StateListDrawable";
    private static final boolean b = false;
    private a c;
    private boolean d;

    static class a extends b.AbstractC0015b {
        int[][] L;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.L = aVar.L;
            } else {
                this.L = new int[c()][];
            }
        }

        int a(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.L[iA] = iArr;
            return iA;
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0015b
        void a() {
            int[][] iArr = new int[this.L.length][];
            for (int length = this.L.length - 1; length >= 0; length--) {
                iArr[length] = this.L[length] != null ? (int[]) this.L[length].clone() : null;
            }
            this.L = iArr;
        }

        int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int iD = d();
            for (int i = 0; i < iD; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.appcompat.b.a.b.AbstractC0015b
        public void e(int i, int i2) {
            super.e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.L, 0, iArr, 0, i);
            this.L = iArr;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @ah
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @ah
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e() {
        this(null, null);
    }

    e(@ai a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    e(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.c;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.appcompat.c.a.j.StateListDrawableItem);
                int resourceId = typedArrayA.getResourceId(androidx.appcompat.c.a.j.StateListDrawableItem_android_drawable, -1);
                Drawable drawableA = resourceId > 0 ? ao.a().a(context, resourceId) : null;
                typedArrayA.recycle();
                int[] iArrA = a(attributeSet);
                if (drawableA == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    drawableA = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
                aVar.a(iArrA, drawableA);
            }
        }
    }

    private void a(TypedArray typedArray) {
        a aVar = this.c;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(androidx.appcompat.c.a.j.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(androidx.appcompat.c.a.j.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(androidx.appcompat.c.a.j.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(androidx.appcompat.c.a.j.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(androidx.appcompat.c.a.j.StateListDrawable_android_dither, aVar.z);
    }

    int a(int[] iArr) {
        return this.c.b(iArr);
    }

    @Override // androidx.appcompat.b.a.b
    void a(@ah b.AbstractC0015b abstractC0015b) {
        super.a(abstractC0015b);
        if (abstractC0015b instanceof a) {
            this.c = (a) abstractC0015b;
        }
    }

    public void a(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.c.a(iArr, drawable);
            onStateChange(getState());
        }
    }

    int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @am(a = 21)
    public void applyTheme(@ah Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.b
    /* JADX INFO: renamed from: b */
    public a c() {
        return new a(this.c, this, null);
    }

    public void b(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.appcompat.c.a.j.StateListDrawable);
        setVisible(typedArrayA.getBoolean(androidx.appcompat.c.a.j.StateListDrawable_android_visible, true), true);
        a(typedArrayA);
        a(resources);
        typedArrayA.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.b.a.b
    void clearMutated() {
        super.clearMutated();
        this.d = false;
    }

    a e() {
        return this.c;
    }

    int[] e(int i) {
        return this.c.L[i];
    }

    int f() {
        return this.c.d();
    }

    Drawable f(int i) {
        return this.c.b(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @ah
    public Drawable mutate() {
        if (!this.d && super.mutate() == this) {
            this.c.a();
            this.d = true;
        }
        return this;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iB = this.c.b(iArr);
        if (iB < 0) {
            iB = this.c.b(StateSet.WILD_CARD);
        }
        return d(iB) || zOnStateChange;
    }
}
