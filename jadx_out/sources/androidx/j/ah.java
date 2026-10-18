package androidx.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f850a = {Context.class, AttributeSet.class};
    private static final androidx.c.a<String, Constructor<?>> b = new androidx.c.a<>();
    private final Context c;

    private ah(@androidx.annotation.ah Context context) {
        this.c = context;
    }

    private ag a(XmlPullParser xmlPullParser, AttributeSet attributeSet, ag agVar) throws XmlPullParserException, IOException {
        ag alVar;
        int depth = xmlPullParser.getDepth();
        al alVar2 = agVar instanceof al ? (al) agVar : null;
        loop0: while (true) {
            alVar = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                    break loop0;
                }
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("fade".equals(name)) {
                        alVar = new l(this.c, attributeSet);
                    } else if ("changeBounds".equals(name)) {
                        alVar = new e(this.c, attributeSet);
                    } else if ("slide".equals(name)) {
                        alVar = new ae(this.c, attributeSet);
                    } else if ("explode".equals(name)) {
                        alVar = new k(this.c, attributeSet);
                    } else if ("changeImageTransform".equals(name)) {
                        alVar = new g(this.c, attributeSet);
                    } else if ("changeTransform".equals(name)) {
                        alVar = new i(this.c, attributeSet);
                    } else if ("changeClipBounds".equals(name)) {
                        alVar = new f(this.c, attributeSet);
                    } else if ("autoTransition".equals(name)) {
                        alVar = new c(this.c, attributeSet);
                    } else if ("changeScroll".equals(name)) {
                        alVar = new h(this.c, attributeSet);
                    } else if ("transitionSet".equals(name)) {
                        alVar = new al(this.c, attributeSet);
                    } else if ("transition".equals(name)) {
                        alVar = (ag) a(attributeSet, ag.class, "transition");
                    } else if ("targets".equals(name)) {
                        b(xmlPullParser, attributeSet, agVar);
                    } else if ("arcMotion".equals(name)) {
                        if (agVar == null) {
                            throw new RuntimeException("Invalid use of arcMotion element");
                        }
                        agVar.a(new b(this.c, attributeSet));
                    } else if ("pathMotion".equals(name)) {
                        if (agVar == null) {
                            throw new RuntimeException("Invalid use of pathMotion element");
                        }
                        agVar.a((w) a(attributeSet, w.class, "pathMotion"));
                    } else {
                        if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        }
                        if (agVar == null) {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        agVar.a(new y(this.c, attributeSet));
                    }
                    if (alVar == null) {
                        continue;
                    } else {
                        if (!xmlPullParser.isEmptyElementTag()) {
                            a(xmlPullParser, attributeSet, alVar);
                        }
                        if (alVar2 != null) {
                            break;
                        }
                        if (agVar != null) {
                            throw new InflateException("Could not add transition to another transition.");
                        }
                    }
                }
            }
            alVar2.a(alVar);
        }
        return alVar;
    }

    public static ah a(Context context) {
        return new ah(context);
    }

    private aj a(XmlPullParser xmlPullParser, AttributeSet attributeSet, ViewGroup viewGroup) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        aj ajVar = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("transitionManager")) {
                    ajVar = new aj();
                } else {
                    if (!name.equals("transition") || ajVar == null) {
                        throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                    }
                    a(attributeSet, xmlPullParser, viewGroup, ajVar);
                }
            }
        }
        return ajVar;
    }

    private Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object objNewInstance;
        Class<? extends U> clsAsSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            synchronized (b) {
                Constructor<?> constructor = b.get(attributeValue);
                if (constructor == null && (clsAsSubclass = Class.forName(attributeValue, false, this.c.getClassLoader()).asSubclass(cls)) != 0) {
                    constructor = clsAsSubclass.getConstructor(f850a);
                    constructor.setAccessible(true);
                    b.put(attributeValue, constructor);
                }
                objNewInstance = constructor.newInstance(this.c, attributeSet);
            }
            return objNewInstance;
        } catch (Exception e) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void a(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, aj ajVar) {
        ag agVarA;
        TypedArray typedArrayObtainStyledAttributes = this.c.obtainStyledAttributes(attributeSet, af.b);
        int iC = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int iC2 = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        ac acVarA = iC2 < 0 ? null : ac.a(viewGroup, iC2, this.c);
        int iC3 = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        ac acVarA2 = iC3 >= 0 ? ac.a(viewGroup, iC3, this.c) : null;
        if (iC >= 0 && (agVarA = a(iC)) != null) {
            if (acVarA2 == null) {
                throw new RuntimeException("No toScene for transition ID " + iC);
            }
            if (acVarA == null) {
                ajVar.a(acVarA2, agVarA);
            } else {
                ajVar.a(acVarA, acVarA2, agVarA);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @SuppressLint({"RestrictedApi"})
    private void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, ag agVar) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals("target")) {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
                TypedArray typedArrayObtainStyledAttributes = this.c.obtainStyledAttributes(attributeSet, af.f834a);
                int iC = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (iC != 0) {
                    agVar.b(iC);
                } else {
                    int iC2 = androidx.core.b.b.h.c(typedArrayObtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (iC2 != 0) {
                        agVar.a(iC2, true);
                    } else {
                        String strA = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (strA != null) {
                            agVar.a(strA);
                        } else {
                            String strA2 = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (strA2 != null) {
                                agVar.a(strA2, true);
                            } else {
                                String strA3 = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (strA3 != null) {
                                    try {
                                        agVar.a(Class.forName(strA3), true);
                                    } catch (ClassNotFoundException e) {
                                        e = e;
                                        typedArrayObtainStyledAttributes.recycle();
                                        throw new RuntimeException("Could not create " + strA3, e);
                                    }
                                } else {
                                    String strA4 = androidx.core.b.b.h.a(typedArrayObtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                    if (strA4 != null) {
                                        try {
                                            agVar.a(Class.forName(strA4));
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            strA3 = strA4;
                                            typedArrayObtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create " + strA3, e);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public ag a(int i) {
        XmlResourceParser xml = this.c.getResources().getXml(i);
        try {
            try {
                ag agVarA = a(xml, Xml.asAttributeSet(xml), (ag) null);
                xml.close();
                return agVarA;
            } catch (IOException e) {
                throw new InflateException(xml.getPositionDescription() + ": " + e.getMessage(), e);
            } catch (XmlPullParserException e2) {
                throw new InflateException(e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public aj a(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.c.getResources().getXml(i);
        try {
            try {
                aj ajVarA = a(xml, Xml.asAttributeSet(xml), viewGroup);
                xml.close();
                return ajVarA;
            } catch (IOException e) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                inflateException.initCause(e);
                throw inflateException;
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
