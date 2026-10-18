package androidx.d.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f631a = "MotionScene";
    static final int b = 0;
    static final int c = 1;
    public static final int d = -1;
    public static final int g = 0;
    public static final int h = 1;
    static final int k = 0;
    static final int l = 1;
    static final int m = 2;
    static final int n = 3;
    static final int o = 4;
    static final int p = 5;
    private static final boolean q = false;
    private static final int r = -1;
    private static final int s = -2;
    private MotionEvent E;
    private s.d H;
    private boolean I;
    float i;
    float j;
    private final s t;
    androidx.d.e.n e = null;
    a f = null;
    private boolean u = false;
    private ArrayList<a> v = new ArrayList<>();
    private a w = null;
    private ArrayList<a> x = new ArrayList<>();
    private SparseArray<androidx.d.e.g> y = new SparseArray<>();
    private HashMap<String, Integer> z = new HashMap<>();
    private SparseIntArray A = new SparseIntArray();
    private boolean B = false;
    private int C = 400;
    private int D = 0;
    private boolean F = false;
    private boolean G = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f633a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        static final int f = 1;
        private int g;
        private boolean h;
        private int i;
        private int j;
        private int k;
        private String l;
        private int m;
        private int n;
        private float o;
        private final u p;
        private ArrayList<j> q;
        private y r;
        private ArrayList<ViewOnClickListenerC0048a> s;
        private int t;
        private boolean u;
        private int v;
        private int w;
        private int x;

        /* JADX INFO: renamed from: androidx.d.b.b.u$a$a, reason: collision with other inner class name */
        static class ViewOnClickListenerC0048a implements View.OnClickListener {
            public static final int c = 1;
            public static final int d = 17;
            public static final int e = 16;
            public static final int f = 256;
            public static final int g = 4096;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f634a;
            int b;
            private final a h;

            public ViewOnClickListenerC0048a(Context context, a aVar, XmlPullParser xmlPullParser) {
                this.f634a = -1;
                this.b = 17;
                this.h = aVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.d.e.m.C0052m.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == androidx.d.e.m.C0052m.OnClick_targetId) {
                        this.f634a = typedArrayObtainStyledAttributes.getResourceId(index, this.f634a);
                    } else if (index == androidx.d.e.m.C0052m.OnClick_clickAction) {
                        this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(s sVar) {
                if (this.f634a == -1) {
                    return;
                }
                View viewFindViewById = sVar.findViewById(this.f634a);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e(u.f631a, " (*)  could not find id " + this.f634a);
            }

            public void a(s sVar, int i, a aVar) {
                boolean z;
                View viewFindViewById;
                s sVar2 = sVar;
                if (this.f634a != -1) {
                    viewFindViewById = sVar.findViewById(this.f634a);
                }
                if (sVar2 == null) {
                    sVar2 = viewFindViewById;
                    Log.e(u.f631a, "OnClick could not find id " + this.f634a);
                    return;
                }
                int i2 = aVar.j;
                int i3 = aVar.i;
                if (i2 == -1) {
                    sVar2 = viewFindViewById;
                    sVar2.setOnClickListener(this);
                    return;
                }
                if ((this.b & 1) == 0 || i != i2) {
                    sVar2 = viewFindViewById;
                    z = false;
                } else {
                    z = true;
                }
                if ((((this.b & 1) != 0 && i == i2) | z | ((this.b & 256) != 0 && i == i2) | ((this.b & 16) != 0 && i == i3)) || ((this.b & 4096) != 0 && i == i3)) {
                    sVar2.setOnClickListener(this);
                }
            }

            boolean a(a aVar, s sVar) {
                if (this.h == aVar) {
                    return true;
                }
                int i = this.h.i;
                int i2 = this.h.j;
                if (i2 == -1) {
                    return sVar.l != i;
                }
                return sVar.l == i2 || sVar.l == i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s sVar = this.h.p.t;
                if (sVar.i()) {
                    if (this.h.j == -1) {
                        int currentState = sVar.getCurrentState();
                        if (currentState == -1) {
                            sVar.b(this.h.i);
                            return;
                        }
                        a aVar = new a(this.h.p, this.h);
                        aVar.j = currentState;
                        aVar.i = this.h.i;
                        sVar.setTransition(aVar);
                        sVar.c();
                        return;
                    }
                    a aVar2 = this.h.p.f;
                    boolean z = ((this.b & 1) == 0 && (this.b & 256) == 0) ? false : true;
                    boolean z2 = ((this.b & 16) == 0 && (this.b & 4096) == 0) ? false : true;
                    if (z && z2) {
                        if (this.h.p.f != this.h) {
                            sVar.setTransition(this.h);
                        }
                        if (sVar.getCurrentState() == sVar.getEndState() || sVar.getProgress() > 0.5f) {
                            z = false;
                        } else {
                            z2 = false;
                        }
                    }
                    if (a(aVar2, sVar)) {
                        if (z && (this.b & 1) != 0) {
                            sVar.setTransition(this.h);
                            sVar.c();
                            return;
                        }
                        if (z2 && (this.b & 16) != 0) {
                            sVar.setTransition(this.h);
                            sVar.b();
                        } else if (z && (this.b & 256) != 0) {
                            sVar.setTransition(this.h);
                            sVar.setProgress(1.0f);
                        } else {
                            if (!z2 || (this.b & 4096) == 0) {
                                return;
                            }
                            sVar.setTransition(this.h);
                            sVar.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        public a(int i, u uVar, int i2, int i3) {
            this.g = -1;
            this.h = false;
            this.i = -1;
            this.j = -1;
            this.k = 0;
            this.l = null;
            this.m = -1;
            this.n = 400;
            this.o = 0.0f;
            this.q = new ArrayList<>();
            this.r = null;
            this.s = new ArrayList<>();
            this.t = 0;
            this.u = false;
            this.v = -1;
            this.w = 0;
            this.x = 0;
            this.g = i;
            this.p = uVar;
            this.j = i2;
            this.i = i3;
            this.n = uVar.C;
            this.w = uVar.D;
        }

        a(u uVar, Context context, XmlPullParser xmlPullParser) {
            this.g = -1;
            this.h = false;
            this.i = -1;
            this.j = -1;
            this.k = 0;
            this.l = null;
            this.m = -1;
            this.n = 400;
            this.o = 0.0f;
            this.q = new ArrayList<>();
            this.r = null;
            this.s = new ArrayList<>();
            this.t = 0;
            this.u = false;
            this.v = -1;
            this.w = 0;
            this.x = 0;
            this.n = uVar.C;
            this.w = uVar.D;
            this.p = uVar;
            a(uVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        a(u uVar, a aVar) {
            this.g = -1;
            this.h = false;
            this.i = -1;
            this.j = -1;
            this.k = 0;
            this.l = null;
            this.m = -1;
            this.n = 400;
            this.o = 0.0f;
            this.q = new ArrayList<>();
            this.r = null;
            this.s = new ArrayList<>();
            this.t = 0;
            this.u = false;
            this.v = -1;
            this.w = 0;
            this.x = 0;
            this.p = uVar;
            if (aVar != null) {
                this.v = aVar.v;
                this.k = aVar.k;
                this.l = aVar.l;
                this.m = aVar.m;
                this.n = aVar.n;
                this.q = aVar.q;
                this.o = aVar.o;
                this.w = aVar.w;
            }
        }

        private void a(u uVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == androidx.d.e.m.C0052m.Transition_constraintSetEnd) {
                    this.i = typedArray.getResourceId(index, this.i);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.i))) {
                        androidx.d.e.g gVar = new androidx.d.e.g();
                        gVar.b(context, this.i);
                        uVar.y.append(this.i, gVar);
                    }
                } else if (index == androidx.d.e.m.C0052m.Transition_constraintSetStart) {
                    this.j = typedArray.getResourceId(index, this.j);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.j))) {
                        androidx.d.e.g gVar2 = new androidx.d.e.g();
                        gVar2.b(context, this.j);
                        uVar.y.append(this.j, gVar2);
                    }
                } else if (index == androidx.d.e.m.C0052m.Transition_motionInterpolator) {
                    TypedValue typedValuePeekValue = typedArray.peekValue(index);
                    if (typedValuePeekValue.type == 1) {
                        this.m = typedArray.getResourceId(index, -1);
                        if (this.m != -1) {
                            this.k = -2;
                        }
                    } else if (typedValuePeekValue.type == 3) {
                        this.l = typedArray.getString(index);
                        if (this.l.indexOf("/") > 0) {
                            this.m = typedArray.getResourceId(index, -1);
                            this.k = -2;
                        } else {
                            this.k = -1;
                        }
                    } else {
                        this.k = typedArray.getInteger(index, this.k);
                    }
                } else if (index == androidx.d.e.m.C0052m.Transition_duration) {
                    this.n = typedArray.getInt(index, this.n);
                } else if (index == androidx.d.e.m.C0052m.Transition_staggered) {
                    this.o = typedArray.getFloat(index, this.o);
                } else if (index == androidx.d.e.m.C0052m.Transition_autoTransition) {
                    this.t = typedArray.getInteger(index, this.t);
                } else if (index == androidx.d.e.m.C0052m.Transition_android_id) {
                    this.g = typedArray.getResourceId(index, this.g);
                } else if (index == androidx.d.e.m.C0052m.Transition_transitionDisable) {
                    this.u = typedArray.getBoolean(index, this.u);
                } else if (index == androidx.d.e.m.C0052m.Transition_pathMotionArc) {
                    this.v = typedArray.getInteger(index, -1);
                } else if (index == androidx.d.e.m.C0052m.Transition_layoutDuringTransition) {
                    this.w = typedArray.getInteger(index, 0);
                } else if (index == androidx.d.e.m.C0052m.Transition_transitionFlags) {
                    this.x = typedArray.getInteger(index, 0);
                }
            }
            if (this.j == -1) {
                this.h = true;
            }
        }

        private void a(u uVar, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.Transition);
            a(uVar, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.w;
        }

        public String a(Context context) {
            String resourceEntryName = this.j == -1 ? "null" : context.getResources().getResourceEntryName(this.j);
            if (this.i == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.i);
        }

        public void a(float f2) {
            this.o = f2;
        }

        public void a(int i) {
            this.t = i;
        }

        public void a(Context context, XmlPullParser xmlPullParser) {
            this.s.add(new ViewOnClickListenerC0048a(context, this, xmlPullParser));
        }

        public void a(boolean z) {
            this.u = !z;
        }

        public int b() {
            return this.t;
        }

        public void b(int i) {
            this.n = i;
        }

        public int c() {
            return this.g;
        }

        public void c(int i) {
            this.v = i;
        }

        public int d() {
            return this.i;
        }

        public boolean d(int i) {
            return (this.x & i) != 0;
        }

        public int e() {
            return this.j;
        }

        public int f() {
            return this.n;
        }

        public float g() {
            return this.o;
        }

        public List<j> h() {
            return this.q;
        }

        public List<ViewOnClickListenerC0048a> i() {
            return this.s;
        }

        public y j() {
            return this.r;
        }

        public int k() {
            return this.v;
        }

        public boolean l() {
            return !this.u;
        }
    }

    u(Context context, s sVar, int i) {
        this.t = sVar;
        a(context, i);
        this.y.put(androidx.d.e.m.g.motion_base, new androidx.d.e.g());
        this.z.put("motion_base", Integer.valueOf(androidx.d.e.m.g.motion_base));
    }

    public u(s sVar) {
        this.t = sVar;
    }

    public static String a(String str) {
        if (str == null) {
            return com.yftech.service.upgrade.a.d;
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0083  */
    private void a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xml.getName();
                            if (this.B) {
                                System.out.println("parsing = " + name);
                            }
                            switch (name) {
                                case "MotionScene":
                                    a(context, xml);
                                    break;
                                case "Transition":
                                    ArrayList<a> arrayList = this.v;
                                    a aVar2 = new a(this, context, xml);
                                    arrayList.add(aVar2);
                                    if (this.f == null && !aVar2.h) {
                                        this.f = aVar2;
                                        if (this.f != null && this.f.r != null) {
                                            this.f.r.a(this.I);
                                        }
                                    }
                                    if (aVar2.h) {
                                        if (aVar2.i == -1) {
                                            this.w = aVar2;
                                        } else {
                                            this.x.add(aVar2);
                                        }
                                        this.v.remove(aVar2);
                                    }
                                    aVar = aVar2;
                                    break;
                                case "OnSwipe":
                                    if (aVar == null) {
                                        Log.v(f631a, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                                    }
                                    aVar.r = new y(context, this.t, xml);
                                    break;
                                case "OnClick":
                                    aVar.a(context, xml);
                                    break;
                                case "StateSet":
                                    this.e = new androidx.d.e.n(context, xml);
                                    break;
                                case "ConstraintSet":
                                    b(context, xml);
                                    break;
                                case "KeyFrameSet":
                                    aVar.q.add(new j(context, xml));
                                    break;
                                default:
                                    Log.v(f631a, "WARNING UNKNOWN ATTRIBUTE " + name);
                                    break;
                            }
                            break;
                    }
                } else {
                    xml.getName();
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), androidx.d.e.m.C0052m.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == androidx.d.e.m.C0052m.MotionScene_defaultDuration) {
                this.C = typedArrayObtainStyledAttributes.getInt(index, this.C);
            } else if (index == androidx.d.e.m.C0052m.MotionScene_layoutDuringTransition) {
                this.D = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private int b(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.B) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str != null && str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(f631a, "error in parsing id");
        return identifier;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0057  */
    private void b(Context context, XmlPullParser xmlPullParser) {
        androidx.d.e.g gVar = new androidx.d.e.g();
        gVar.a(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = 0;
        int iB = -1;
        int iB2 = -1;
        while (true) {
            if (i >= attributeCount) {
                if (iB != -1) {
                    if (this.t.v != 0) {
                        gVar.b(true);
                    }
                    gVar.a(context, xmlPullParser);
                    if (iB2 != -1) {
                        this.A.put(iB, iB2);
                    }
                    this.y.put(iB, gVar);
                    return;
                }
                return;
            }
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (this.B) {
                System.out.println("id string = " + attributeValue);
            }
            switch (attributeName) {
                case "id":
                    iB = b(context, attributeValue);
                    this.z.put(a(attributeValue), Integer.valueOf(iB));
                    break;
                case "deriveConstraintsFrom":
                    iB2 = b(context, attributeValue);
                    break;
            }
            i++;
        }
    }

    private int d(a aVar) {
        int i = aVar.g;
        if (i == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i2 = 0; i2 < this.v.size(); i2++) {
            if (this.v.get(i2).g == i) {
                return i2;
            }
        }
        return -1;
    }

    private int g(int i) {
        int iA;
        return (this.e == null || (iA = this.e.a(i, -1, -1)) == -1) ? i : iA;
    }

    private boolean h(int i) {
        int i2 = this.A.get(i);
        int size = this.A.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.A.get(i2);
            size = i3;
        }
        return false;
    }

    private void i(int i) {
        int i2 = this.A.get(i);
        if (i2 > 0) {
            i(this.A.get(i));
            androidx.d.e.g gVar = this.y.get(i);
            androidx.d.e.g gVar2 = this.y.get(i2);
            if (gVar2 != null) {
                gVar.a(gVar2);
                this.A.put(i, -1);
            } else {
                Log.e(f631a, "ERROR! invalid deriveConstraintsFrom: @id/" + c.a(this.t.getContext(), i2));
            }
        }
    }

    private boolean n() {
        return this.H != null;
    }

    e a(Context context, int i, int i2, int i3) {
        if (this.f == null) {
            return null;
        }
        for (j jVar : this.f.q) {
            for (Integer num : jVar.a()) {
                if (i2 == num.intValue()) {
                    for (e eVar : jVar.a(num.intValue())) {
                        if (eVar.b == i3 && eVar.e == i) {
                            return eVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    public a a(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.f;
        }
        List<a> listA = a(i);
        float f3 = 0.0f;
        a aVar = null;
        RectF rectF = new RectF();
        for (a aVar2 : listA) {
            if (!aVar2.u && aVar2.r != null) {
                aVar2.r.a(this.I);
                RectF rectFA = aVar2.r.a(this.t, rectF);
                if (rectFA == null || motionEvent == null || rectFA.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFA2 = aVar2.r.a(this.t, rectF);
                    if (rectFA2 == null || motionEvent == null || rectFA2.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fG = aVar2.r.g(f, f2);
                        float f4 = aVar2.i == i ? fG * (-1.0f) : fG * 1.1f;
                        if (f4 > f3) {
                            aVar = aVar2;
                            f3 = f4;
                        }
                    }
                }
            }
        }
        return aVar;
    }

    androidx.d.e.g a(int i, int i2, int i3) {
        int iA;
        if (this.B) {
            System.out.println("id " + i);
            System.out.println("size " + this.y.size());
        }
        if (this.e != null && (iA = this.e.a(i, i2, i3)) != -1) {
            i = iA;
        }
        if (this.y.get(i) != null) {
            return this.y.get(i);
        }
        Log.e(f631a, "Warning could not find ConstraintSet id/" + c.a(this.t.getContext(), i) + " In MotionScene");
        return this.y.get(this.y.keyAt(0));
    }

    public androidx.d.e.g a(Context context, String str) {
        if (this.B) {
            System.out.println("id " + str);
            System.out.println("size " + this.y.size());
        }
        for (int i = 0; i < this.y.size(); i++) {
            int iKeyAt = this.y.keyAt(i);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.B) {
                System.out.println("Id for <" + i + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.y.get(iKeyAt);
            }
        }
        return null;
    }

    public ArrayList<a> a() {
        return this.v;
    }

    public List<a> a(int i) {
        int iG = g(i);
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.v) {
            if (aVar.j == iG || aVar.i == iG) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    void a(float f, float f2) {
        if (this.f == null || this.f.r == null) {
            return;
        }
        this.f.r.e(f, f2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0026  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x005e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0066 A[SYNTHETIC] */
    void a(int i, int i2) {
        int iA;
        int iA2;
        Iterator<a> it;
        a aVar;
        a aVar2;
        a next;
        if (this.e != null) {
            iA = this.e.a(i, -1, -1);
            if (iA == -1) {
                iA = i;
            }
            iA2 = this.e.a(i2, -1, -1);
            if (iA2 == -1) {
            }
            it = this.v.iterator();
            while (true) {
                if (it.hasNext()) {
                    aVar = this.w;
                    for (a aVar3 : this.x) {
                        if (aVar3.i == i2) {
                            aVar = aVar3;
                        }
                    }
                    aVar2 = new a(this, aVar);
                    aVar2.j = iA;
                    aVar2.i = iA2;
                    if (iA != -1) {
                        this.v.add(aVar2);
                    }
                    this.f = aVar2;
                    return;
                }
                next = it.next();
                if ((next.i != iA2 && next.j == iA) || (next.i == i2 && next.j == i)) {
                    break;
                }
            }
            this.f = next;
            if (this.f != null || this.f.r == null) {
            }
            this.f.r.a(this.I);
            return;
        }
        iA = i;
        iA2 = i2;
        it = this.v.iterator();
        while (true) {
            if (it.hasNext()) {
                aVar = this.w;
                while (r3.hasNext()) {
                    if (aVar3.i == i2) {
                        aVar = aVar3;
                    }
                }
                aVar2 = new a(this, aVar);
                aVar2.j = iA;
                aVar2.i = iA2;
                if (iA != -1) {
                    this.v.add(aVar2);
                }
                this.f = aVar2;
                return;
            }
            next = it.next();
            if (next.i != iA2) {
            }
        }
        this.f = next;
        if (this.f != null) {
        }
    }

    public void a(int i, androidx.d.e.g gVar) {
        this.y.put(i, gVar);
    }

    void a(MotionEvent motionEvent, int i, s sVar) {
        RectF rectF = new RectF();
        if (this.H == null) {
            this.H = this.t.a();
        }
        this.H.a(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.i = motionEvent.getRawX();
                this.j = motionEvent.getRawY();
                this.E = motionEvent;
                this.F = false;
                if (this.f.r != null) {
                    RectF rectFB = this.f.r.b(this.t, rectF);
                    if (rectFB != null && !rectFB.contains(this.E.getX(), this.E.getY())) {
                        this.E = null;
                        this.F = true;
                        return;
                    }
                    RectF rectFA = this.f.r.a(this.t, rectF);
                    if (rectFA == null || rectFA.contains(this.E.getX(), this.E.getY())) {
                        this.G = false;
                    } else {
                        this.G = true;
                    }
                    this.f.r.b(this.i, this.j);
                    return;
                }
                return;
            }
            if (action == 2 && !this.F) {
                float rawY = motionEvent.getRawY() - this.j;
                float rawX = motionEvent.getRawX() - this.i;
                if ((rawX == 0.0d && rawY == 0.0d) || this.E == null) {
                    return;
                }
                a aVarA = a(i, rawX, rawY, this.E);
                if (aVarA != null) {
                    sVar.setTransition(aVarA);
                    RectF rectFA2 = this.f.r.a(this.t, rectF);
                    if (rectFA2 != null && !rectFA2.contains(this.E.getX(), this.E.getY())) {
                        z = true;
                    }
                    this.G = z;
                    this.f.r.a(this.i, this.j);
                }
            }
        }
        if (this.F) {
            return;
        }
        if (this.f != null && this.f.r != null && !this.G) {
            this.f.r.a(motionEvent, this.H, i, this);
        }
        this.i = motionEvent.getRawX();
        this.j = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || this.H == null) {
            return;
        }
        this.H.a();
        this.H = null;
        if (sVar.l != -1) {
            b(sVar, sVar.l);
        }
    }

    public void a(View view, int i, String str, Object obj) {
        if (this.f == null) {
            return;
        }
        Iterator it = this.f.q.iterator();
        while (it.hasNext()) {
            Iterator<e> it2 = ((j) it.next()).a(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().b == i) {
                    int i2 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void a(p pVar) {
        if (this.f != null) {
            Iterator it = this.f.q.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(pVar);
            }
        } else if (this.w != null) {
            Iterator it2 = this.w.q.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(pVar);
            }
        }
    }

    public void a(s sVar, int i) {
        for (a aVar : this.v) {
            if (aVar.s.size() > 0) {
                Iterator it = aVar.s.iterator();
                while (it.hasNext()) {
                    ((a.ViewOnClickListenerC0048a) it.next()).a(sVar);
                }
            }
        }
        for (a aVar2 : this.x) {
            if (aVar2.s.size() > 0) {
                Iterator it2 = aVar2.s.iterator();
                while (it2.hasNext()) {
                    ((a.ViewOnClickListenerC0048a) it2.next()).a(sVar);
                }
            }
        }
        for (a aVar3 : this.v) {
            if (aVar3.s.size() > 0) {
                Iterator it3 = aVar3.s.iterator();
                while (it3.hasNext()) {
                    ((a.ViewOnClickListenerC0048a) it3.next()).a(sVar, i, aVar3);
                }
            }
        }
        for (a aVar4 : this.x) {
            if (aVar4.s.size() > 0) {
                Iterator it4 = aVar4.s.iterator();
                while (it4.hasNext()) {
                    ((a.ViewOnClickListenerC0048a) it4.next()).a(sVar, i, aVar4);
                }
            }
        }
    }

    public void a(a aVar) {
        int iD = d(aVar);
        if (iD == -1) {
            this.v.add(aVar);
        } else {
            this.v.set(iD, aVar);
        }
    }

    public void a(boolean z) {
        this.I = z;
        if (this.f == null || this.f.r == null) {
            return;
        }
        this.f.r.a(this.I);
    }

    protected void a(boolean z, int i, int i2, int i3, int i4) {
    }

    boolean a(View view, int i) {
        if (this.f == null) {
            return false;
        }
        Iterator it = this.f.q.iterator();
        while (it.hasNext()) {
            Iterator<e> it2 = ((j) it.next()).a(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().b == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        return sVar == this.t && sVar.i == this;
    }

    public float b(View view, int i) {
        return 0.0f;
    }

    public int b(String str) {
        return this.z.get(str).intValue();
    }

    public a b(int i) {
        for (a aVar : this.v) {
            if (aVar.g == i) {
                return aVar;
            }
        }
        return null;
    }

    void b(float f, float f2) {
        if (this.f == null || this.f.r == null) {
            return;
        }
        this.f.r.d(f, f2);
    }

    void b(s sVar) {
        for (int i = 0; i < this.y.size(); i++) {
            int iKeyAt = this.y.keyAt(i);
            if (h(iKeyAt)) {
                Log.e(f631a, "Cannot be derived from yourself");
                return;
            }
            i(iKeyAt);
        }
        for (int i2 = 0; i2 < this.y.size(); i2++) {
            this.y.valueAt(i2).a(sVar);
        }
    }

    public void b(a aVar) {
        int iD = d(aVar);
        if (iD != -1) {
            this.v.remove(iD);
        }
    }

    public void b(boolean z) {
        this.u = z;
    }

    boolean b(s sVar, int i) {
        if (n() || this.u) {
            return false;
        }
        for (a aVar : this.v) {
            if (aVar.t != 0 && this.f != aVar) {
                if (i == aVar.j && (aVar.t == 4 || aVar.t == 2)) {
                    sVar.setState(s.h.FINISHED);
                    sVar.setTransition(aVar);
                    if (aVar.t == 4) {
                        sVar.c();
                        sVar.setState(s.h.SETUP);
                        sVar.setState(s.h.MOVING);
                    } else {
                        sVar.setProgress(1.0f);
                        sVar.a(true);
                        sVar.setState(s.h.SETUP);
                        sVar.setState(s.h.MOVING);
                        sVar.setState(s.h.FINISHED);
                        sVar.d();
                    }
                    return true;
                }
                if (i == aVar.i && (aVar.t == 3 || aVar.t == 1)) {
                    sVar.setState(s.h.FINISHED);
                    sVar.setTransition(aVar);
                    if (aVar.t == 3) {
                        sVar.b();
                        sVar.setState(s.h.SETUP);
                        sVar.setState(s.h.MOVING);
                    } else {
                        sVar.setProgress(0.0f);
                        sVar.a(true);
                        sVar.setState(s.h.SETUP);
                        sVar.setState(s.h.MOVING);
                        sVar.setState(s.h.FINISHED);
                        sVar.d();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int[] b() {
        int[] iArr = new int[this.y.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = this.y.keyAt(i);
        }
        return iArr;
    }

    float c(float f, float f2) {
        if (this.f == null || this.f.r == null) {
            return 0.0f;
        }
        return this.f.r.c(f, f2);
    }

    androidx.d.e.g c(int i) {
        return a(i, -1, -1);
    }

    public void c(a aVar) {
        this.f = aVar;
        if (this.f == null || this.f.r == null) {
            return;
        }
        this.f.r.a(this.I);
    }

    boolean c() {
        Iterator<a> it = this.v.iterator();
        while (it.hasNext()) {
            if (it.next().r != null) {
                return true;
            }
        }
        return (this.f == null || this.f.r == null) ? false : true;
    }

    int d() {
        if (this.f == null) {
            return -1;
        }
        return this.f.j;
    }

    int d(int i) {
        Iterator<a> it = this.v.iterator();
        while (it.hasNext()) {
            if (it.next().j == i) {
                return 0;
            }
        }
        return 1;
    }

    int e() {
        if (this.f == null) {
            return -1;
        }
        return this.f.i;
    }

    public void e(int i) {
        if (this.f != null) {
            this.f.b(i);
        } else {
            this.C = i;
        }
    }

    public Interpolator f() {
        switch (this.f.k) {
            case -2:
                return AnimationUtils.loadInterpolator(this.t.getContext(), this.f.m);
            case -1:
                final androidx.d.b.a.c cVarA = androidx.d.b.a.c.a(this.f.l);
                return new Interpolator() { // from class: androidx.d.b.b.u.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) cVarA.a(f);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new AnticipateInterpolator();
            case 5:
                return new BounceInterpolator();
            default:
                return null;
        }
    }

    public String f(int i) {
        for (Map.Entry<String, Integer> entry : this.z.entrySet()) {
            if (entry.getValue().intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    public int g() {
        return this.f != null ? this.f.n : this.C;
    }

    public int h() {
        if (this.f != null) {
            return this.f.v;
        }
        return -1;
    }

    public float i() {
        if (this.f != null) {
            return this.f.o;
        }
        return 0.0f;
    }

    float j() {
        if (this.f == null || this.f.r == null) {
            return 0.0f;
        }
        return this.f.r.c();
    }

    float k() {
        if (this.f == null || this.f.r == null) {
            return 0.0f;
        }
        return this.f.r.d();
    }

    void l() {
        if (this.f == null || this.f.r == null) {
            return;
        }
        this.f.r.a();
    }

    boolean m() {
        if (this.f == null || this.f.r == null) {
            return false;
        }
        return this.f.r.e();
    }
}
