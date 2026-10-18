package androidx.d.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f733a = "ConstraintLayoutStates";
    private static final boolean f = false;
    g c;
    int b = -1;
    int d = -1;
    int e = -1;
    private SparseArray<a> g = new SparseArray<>();
    private SparseArray<g> h = new SparseArray<>();
    private i i = null;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f734a;
        ArrayList<b> b = new ArrayList<>();
        int c;
        boolean d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.c = -1;
            this.d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.C0052m.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.State_android_id) {
                    this.f734a = typedArrayObtainStyledAttributes.getResourceId(index, this.f734a);
                } else if (index == m.C0052m.State_constraints) {
                    this.c = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = true;
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
        int f735a;
        float b;
        float c;
        float d;
        float e;
        int f;
        boolean g;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = Float.NaN;
            this.f = -1;
            this.g = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.C0052m.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.Variant_constraints) {
                    this.f = typedArrayObtainStyledAttributes.getResourceId(index, this.f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f);
                    context.getResources().getResourceName(this.f);
                    if ("layout".equals(resourceTypeName)) {
                        this.g = true;
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

    public n(Context context, XmlPullParser xmlPullParser) {
        a(context, xmlPullParser);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), m.C0052m.StateSet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == m.C0052m.StateSet_defaultState) {
                this.b = typedArrayObtainStyledAttributes.getResourceId(index, this.b);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        a aVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType != 0) {
                    switch (eventType) {
                        case 2:
                            String name = xmlPullParser.getName();
                            switch (name) {
                                case "LayoutDescription":
                                case "StateSet":
                                    break;
                                case "State":
                                    aVar = new a(context, xmlPullParser);
                                    this.g.put(aVar.f734a, aVar);
                                    break;
                                case "Variant":
                                    b bVar = new b(context, xmlPullParser);
                                    if (aVar == null) {
                                        break;
                                    } else {
                                        aVar.a(bVar);
                                        break;
                                    }
                                    break;
                                default:
                                    Log.v("ConstraintLayoutStates", "unknown tag " + name);
                                    break;
                            }
                            break;
                        case 3:
                            if ("StateSet".equals(xmlPullParser.getName())) {
                                return;
                            }
                            break;
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public int a(int i, int i2, float f2, float f3) {
        a aVar = this.g.get(i2);
        if (aVar == null) {
            return i2;
        }
        if (f2 == -1.0f || f3 == -1.0f) {
            if (aVar.c == i) {
                return i;
            }
            Iterator<b> it = aVar.b.iterator();
            while (it.hasNext()) {
                if (i == it.next().f) {
                    return i;
                }
            }
            return aVar.c;
        }
        b bVar = null;
        for (b bVar2 : aVar.b) {
            if (bVar2.a(f2, f3)) {
                if (i == bVar2.f) {
                    return i;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f : aVar.c;
    }

    public int a(int i, int i2, int i3) {
        return b(-1, i, i2, i3);
    }

    public void a(i iVar) {
        this.i = iVar;
    }

    public boolean a(int i, float f2, float f3) {
        if (this.d != i) {
            return true;
        }
        a aVarValueAt = i == -1 ? this.g.valueAt(0) : this.g.get(this.d);
        return (this.e == -1 || !aVarValueAt.b.get(this.e).a(f2, f3)) && this.e != aVarValueAt.a(f2, f3);
    }

    public int b(int i, int i2, float f2, float f3) {
        int iA;
        if (i != i2) {
            a aVar = this.g.get(i2);
            if (aVar == null) {
                return -1;
            }
            int iA2 = aVar.a(f2, f3);
            return iA2 == -1 ? aVar.c : aVar.b.get(iA2).f;
        }
        a aVarValueAt = i2 == -1 ? this.g.valueAt(0) : this.g.get(this.d);
        if (aVarValueAt == null) {
            return -1;
        }
        if ((this.e == -1 || !aVarValueAt.b.get(i).a(f2, f3)) && i != (iA = aVarValueAt.a(f2, f3))) {
            return iA == -1 ? aVarValueAt.c : aVarValueAt.b.get(iA).f;
        }
        return i;
    }
}
