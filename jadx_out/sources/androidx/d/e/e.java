package androidx.d.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f721a = "ConstraintLayoutStates";
    private static final boolean e = false;
    g b;
    private final d f;
    int c = -1;
    int d = -1;
    private SparseArray<a> g = new SparseArray<>();
    private SparseArray<g> h = new SparseArray<>();
    private i i = null;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f722a;
        ArrayList<b> b = new ArrayList<>();
        int c;
        g d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.C0052m.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.State_android_id) {
                    this.f722a = typedArrayObtainStyledAttributes.getResourceId(index, this.f722a);
                } else if (index == m.C0052m.State_constraints) {
                    this.c = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = new g();
                        this.d.a(context, this.c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a(float f, float f2) {
            for (int i = 0; i < this.b.size(); i++) {
                if (this.b.get(i).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }

        void a(b bVar) {
            this.b.add(bVar);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f723a;
        float b;
        float c;
        float d;
        float e;
        int f;
        g g;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = Float.NaN;
            this.f = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.C0052m.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.Variant_constraints) {
                    this.f = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f);
                    context.getResources().getResourceName(this.f);
                    if ("layout".equals(resourceTypeName)) {
                        this.g = new g();
                        this.g.a(context, this.f);
                    }
                } else if (index == m.C0052m.Variant_region_heightLessThan) {
                    this.e = typedArrayObtainStyledAttributes.getDimension(index, this.e);
                } else if (index == m.C0052m.Variant_region_heightMoreThan) {
                    this.c = typedArrayObtainStyledAttributes.getDimension(index, this.c);
                } else if (index == m.C0052m.Variant_region_widthLessThan) {
                    this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
                } else if (index == m.C0052m.Variant_region_widthMoreThan) {
                    this.b = typedArrayObtainStyledAttributes.getDimension(index, this.b);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float f, float f2) {
            if (!Float.isNaN(this.b) && f < this.b) {
                return false;
            }
            if (!Float.isNaN(this.c) && f2 < this.c) {
                return false;
            }
            if (Float.isNaN(this.d) || f <= this.d) {
                return Float.isNaN(this.e) || f2 <= this.e;
            }
            return false;
        }
    }

    e(Context context, d dVar, int i) {
        this.f = dVar;
        a(context, i);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
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
                            switch (name) {
                                case "layoutDescription":
                                case "StateSet":
                                    break;
                                case "State":
                                    aVar = new a(context, xml);
                                    this.g.put(aVar.f722a, aVar);
                                    break;
                                case "Variant":
                                    b bVar = new b(context, xml);
                                    if (aVar == null) {
                                        break;
                                    } else {
                                        aVar.a(bVar);
                                        break;
                                    }
                                    break;
                                case "ConstraintSet":
                                    a(context, xml);
                                    break;
                                default:
                                    Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                    break;
                            }
                            break;
                    }
                } else {
                    xml.getName();
                }
                eventType = xml.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        g gVar = new g();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    } else {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                gVar.a(context, xmlPullParser);
                this.h.put(identifier, gVar);
                return;
            }
        }
    }

    public void a(i iVar) {
        this.i = iVar;
    }

    public boolean a(int i, float f, float f2) {
        if (this.c != i) {
            return true;
        }
        a aVarValueAt = i == -1 ? this.g.valueAt(0) : this.g.get(this.c);
        return (this.d == -1 || !aVarValueAt.b.get(this.d).a(f, f2)) && this.d != aVarValueAt.a(f, f2);
    }

    public void b(int i, float f, float f2) {
        int iA;
        if (this.c == i) {
            a aVarValueAt = i == -1 ? this.g.valueAt(0) : this.g.get(this.c);
            if ((this.d == -1 || !aVarValueAt.b.get(this.d).a(f, f2)) && this.d != (iA = aVarValueAt.a(f, f2))) {
                g gVar = iA == -1 ? this.b : aVarValueAt.b.get(iA).g;
                int i2 = iA == -1 ? aVarValueAt.c : aVarValueAt.b.get(iA).f;
                if (gVar == null) {
                    return;
                }
                this.d = iA;
                if (this.i != null) {
                    this.i.a(-1, i2);
                }
                gVar.c(this.f);
                if (this.i != null) {
                    this.i.b(-1, i2);
                    return;
                }
                return;
            }
            return;
        }
        this.c = i;
        a aVar = this.g.get(this.c);
        int iA2 = aVar.a(f, f2);
        g gVar2 = iA2 == -1 ? aVar.d : aVar.b.get(iA2).g;
        int i3 = iA2 == -1 ? aVar.c : aVar.b.get(iA2).f;
        if (gVar2 != null) {
            this.d = iA2;
            if (this.i != null) {
                this.i.a(i, i3);
            }
            gVar2.c(this.f);
            if (this.i != null) {
                this.i.b(i, i3);
                return;
            }
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
    }
}
