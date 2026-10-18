package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.q;
import androidx.appcompat.widget.ao;
import androidx.c.j;
import androidx.core.b.b.h;
import androidx.k.b.a.i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class a extends androidx.appcompat.b.a.e implements androidx.core.graphics.drawable.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f96a = "a";
    private static final String b = "transition";
    private static final String c = "item";
    private static final String d = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String e = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private static final String f = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private b g;
    private f h;
    private int i;
    private int j;
    private boolean k;

    /* JADX INFO: renamed from: androidx.appcompat.b.a.a$a, reason: collision with other inner class name */
    private static class C0014a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f97a;

        C0014a(Animatable animatable) {
            super();
            this.f97a = animatable;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f97a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f97a.stop();
        }
    }

    static class b extends androidx.appcompat.b.a.e.a {
        private static final long M = 4294967296L;
        private static final long N = 8589934592L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.c.f<Long> f98a;
        j<Integer> b;

        b(@ai b bVar, @ah a aVar, @ai Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f98a = bVar.f98a;
                this.b = bVar.b;
            } else {
                this.f98a = new androidx.c.f<>();
                this.b = new j<>();
            }
        }

        private static long f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.b.a(i, 0).intValue();
        }

        int a(int i, int i2) {
            return (int) this.f98a.a(f(i, i2), -1L).longValue();
        }

        int a(int i, int i2, @ah Drawable drawable, boolean z) {
            int iA = super.a(drawable);
            long jF = f(i, i2);
            long j = z ? N : 0L;
            long j2 = iA;
            this.f98a.f(jF, Long.valueOf(j2 | j));
            if (z) {
                this.f98a.f(f(i2, i), Long.valueOf(M | j2 | j));
            }
            return iA;
        }

        int a(@ah int[] iArr) {
            int iB = super.b(iArr);
            return iB >= 0 ? iB : super.b(StateSet.WILD_CARD);
        }

        int a(@ah int[] iArr, @ah Drawable drawable, int i) {
            int iA = super.a(iArr, drawable);
            this.b.d(iA, Integer.valueOf(i));
            return iA;
        }

        @Override // androidx.appcompat.b.a.e.a, androidx.appcompat.b.a.b.AbstractC0015b
        void a() {
            this.f98a = this.f98a.clone();
            this.b = this.b.clone();
        }

        boolean b(int i, int i2) {
            return (this.f98a.a(f(i, i2), -1L).longValue() & M) != 0;
        }

        boolean c(int i, int i2) {
            return (this.f98a.a(f(i, i2), -1L).longValue() & N) != 0;
        }

        @Override // androidx.appcompat.b.a.e.a, android.graphics.drawable.Drawable.ConstantState
        @ah
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.b.a.e.a, android.graphics.drawable.Drawable.ConstantState
        @ah
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    private static class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.k.b.a.c f99a;

        c(androidx.k.b.a.c cVar) {
            super();
            this.f99a = cVar;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f99a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f99a.stop();
        }
    }

    private static class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f100a;
        private final boolean b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.a());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.b = z2;
            this.f100a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f100a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f100a.cancel();
        }

        @Override // androidx.appcompat.b.a.a.f
        public boolean c() {
            return this.b;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void d() {
            this.f100a.reverse();
        }
    }

    private static class e implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f101a;
        private int b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a() {
            return this.c;
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            if (this.f101a == null || this.f101a.length < numberOfFrames) {
                this.f101a = new int[numberOfFrames];
            }
            int[] iArr = this.f101a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.f101a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }

    private static abstract class f {
        private f() {
        }

        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }
    }

    public a() {
        this(null, null);
    }

    a(@ai b bVar, @ai Resources resources) {
        super(null);
        this.i = -1;
        this.j = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @ai
    public static a a(@ah Context context, @q int i, @ai Resources.Theme theme) {
        int next;
        try {
            Resources resources = context.getResources();
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(context, resources, (XmlPullParser) xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e(f96a, "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e(f96a, "parser error", e3);
            return null;
        }
    }

    public static a a(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void a(TypedArray typedArray) {
        b bVar = this.g;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void c(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals(c)) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals(b)) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private int d(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.appcompat.c.a.j.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayA.getResourceId(androidx.appcompat.c.a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayA.getResourceId(androidx.appcompat.c.a.j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayA.getResourceId(androidx.appcompat.c.a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableA = resourceId3 > 0 ? ao.a().a(context, resourceId3) : null;
        boolean z = typedArrayA.getBoolean(androidx.appcompat.c.a.j.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayA.recycle();
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + d);
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableA = androidx.k.b.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableA = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableA == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + d);
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.g.a(resourceId, resourceId2, drawableA, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + e);
    }

    private int e(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.appcompat.c.a.j.AnimatedStateListDrawableItem);
        int resourceId = typedArrayA.getResourceId(androidx.appcompat.c.a.j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayA.getResourceId(androidx.appcompat.c.a.j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableA = resourceId2 > 0 ? ao.a().a(context, resourceId2) : null;
        typedArrayA.recycle();
        int[] iArrA = a(attributeSet);
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + f);
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableA = i.a(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableA = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableA != null) {
            return this.g.a(iArrA, drawableA, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + f);
    }

    private void g() {
        onStateChange(getState());
    }

    private boolean g(int i) {
        int iD;
        int iA;
        f c0014a;
        f fVar = this.h;
        if (fVar == null) {
            iD = d();
        } else {
            if (i == this.i) {
                return true;
            }
            if (i == this.j && fVar.c()) {
                fVar.d();
                this.i = this.j;
                this.j = i;
                return true;
            }
            iD = this.i;
            fVar.b();
        }
        this.h = null;
        this.j = -1;
        this.i = -1;
        b bVar = this.g;
        int iA2 = bVar.a(iD);
        int iA3 = bVar.a(i);
        if (iA3 == 0 || iA2 == 0 || (iA = bVar.a(iA2, iA3)) < 0) {
            return false;
        }
        boolean zC = bVar.c(iA2, iA3);
        d(iA);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0014a = new d((AnimationDrawable) current, bVar.b(iA2, iA3), zC);
        } else if (current instanceof androidx.k.b.a.c) {
            c0014a = new c((androidx.k.b.a.c) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            c0014a = new C0014a((Animatable) current);
        }
        c0014a.a();
        this.h = c0014a;
        this.j = iD;
        this.i = i;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public b c() {
        return new b(this.g, this, null);
    }

    @Override // androidx.appcompat.b.a.b
    public /* bridge */ /* synthetic */ void a(int i) {
        super.a(i);
    }

    public <T extends Drawable & Animatable> void a(int i, int i2, @ah T t, boolean z) {
        if (t == null) {
            throw new IllegalArgumentException("Transition drawable must not be null");
        }
        this.g.a(i, i2, t, z);
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b
    void a(@ah androidx.appcompat.b.a.b.AbstractC0015b abstractC0015b) {
        super.a(abstractC0015b);
        if (abstractC0015b instanceof b) {
            this.g = (b) abstractC0015b;
        }
    }

    @Override // androidx.appcompat.b.a.e
    public /* bridge */ /* synthetic */ void a(int[] iArr, Drawable drawable) {
        super.a(iArr, drawable);
    }

    public void a(@ah int[] iArr, @ah Drawable drawable, int i) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable must not be null");
        }
        this.g.a(iArr, drawable, i);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @am(a = 21)
    public /* bridge */ /* synthetic */ void applyTheme(@ah Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.b.a.b
    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    @Override // androidx.appcompat.b.a.e
    public void b(@ah Context context, @ah Resources resources, @ah XmlPullParser xmlPullParser, @ah AttributeSet attributeSet, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayA = h.a(resources, theme, attributeSet, androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat);
        setVisible(typedArrayA.getBoolean(androidx.appcompat.c.a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(typedArrayA);
        a(resources);
        typedArrayA.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        g();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @am(a = 21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b
    void clearMutated() {
        super.clearMutated();
        this.k = false;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@ah Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @ah
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@ah Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    @am(a = 21)
    public /* bridge */ /* synthetic */ void getOutline(@ah Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@ah Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@ah Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.h != null) {
            this.h.b();
            this.h = null;
            d(this.i);
            this.i = -1;
            this.j = -1;
        }
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.k && super.mutate() == this) {
            this.g.a();
            this.k = true;
        }
        return this;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.b.a.e, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iA = this.g.a(iArr);
        boolean z = iA != d() && (g(iA) || d(iA));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@ah Drawable drawable, @ah Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.e
    public /* bridge */ /* synthetic */ void setTintMode(@ah PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.h != null && (visible || z2)) {
            if (z) {
                this.h.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@ah Drawable drawable, @ah Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }
}
