package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class d extends DataSetObservable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f262a = false;
    static final String b = "d";
    static final String c = "historical-records";
    static final String d = "historical-record";
    static final String e = "activity";
    static final String f = "time";
    static final String g = "weight";
    public static final String h = "activity_choser_model_history.xml";
    public static final int i = 50;
    private static final int m = 5;
    private static final float n = 1.0f;
    private static final String o = ".xml";
    private static final int p = -1;
    private static final Object q = new Object();
    private static final Map<String, d> r = new HashMap();
    private f B;
    final Context j;
    final String k;
    private Intent v;
    private final Object s = new Object();
    private final List<b> t = new ArrayList();
    private final List<e> u = new ArrayList();
    private c w = new C0019d();
    private int x = 50;
    boolean l = true;
    private boolean y = false;
    private boolean z = true;
    private boolean A = false;

    public interface a {
        void setActivityChooserModel(d dVar);
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResolveInfo f263a;
        public float b;

        public b(ResolveInfo resolveInfo) {
            this.f263a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Float.floatToIntBits(bVar.b) - Float.floatToIntBits(this.b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((b) obj).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f263a.toString() + "; weight:" + new BigDecimal(this.b) + "]";
        }
    }

    public interface c {
        void a(Intent intent, List<b> list, List<e> list2);
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.d$d, reason: collision with other inner class name */
    private static final class C0019d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final float f264a = 0.95f;
        private final Map<ComponentName, b> b = new HashMap();

        C0019d() {
        }

        @Override // androidx.appcompat.widget.d.c
        public void a(Intent intent, List<b> list, List<e> list2) {
            Map<ComponentName, b> map = this.b;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                b bVar = list.get(i);
                bVar.b = 0.0f;
                map.put(new ComponentName(bVar.f263a.activityInfo.packageName, bVar.f263a.activityInfo.name), bVar);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                e eVar = list2.get(size2);
                b bVar2 = map.get(eVar.f265a);
                if (bVar2 != null) {
                    bVar2.b += eVar.c * f;
                    f *= f264a;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f265a;
        public final long b;
        public final float c;

        public e(ComponentName componentName, long j, float f) {
            this.f265a = componentName;
            this.b = j;
            this.c = f;
        }

        public e(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f265a == null) {
                if (eVar.f265a != null) {
                    return false;
                }
            } else if (!this.f265a.equals(eVar.f265a)) {
                return false;
            }
            return this.b == eVar.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(eVar.c);
        }

        public int hashCode() {
            return (((((this.f265a == null ? 0 : this.f265a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            return "[; activity:" + this.f265a + "; time:" + this.b + "; weight:" + new BigDecimal(this.c) + "]";
        }
    }

    public interface f {
        boolean a(d dVar, Intent intent);
    }

    private final class g extends AsyncTask<Object, Void, Void> {
        g() {
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0071 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = d.this.j.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument("UTF-8", true);
                    xmlSerializerNewSerializer.startTag(null, d.c);
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        e eVar = (e) list.remove(0);
                        xmlSerializerNewSerializer.startTag(null, d.d);
                        xmlSerializerNewSerializer.attribute(null, d.e, eVar.f265a.flattenToString());
                        xmlSerializerNewSerializer.attribute(null, d.f, String.valueOf(eVar.b));
                        xmlSerializerNewSerializer.attribute(null, d.g, String.valueOf(eVar.c));
                        xmlSerializerNewSerializer.endTag(null, d.d);
                    }
                    xmlSerializerNewSerializer.endTag(null, d.c);
                    xmlSerializerNewSerializer.endDocument();
                } catch (IllegalStateException e) {
                    Log.e(d.b, "Error writing historical record file: " + d.this.k, e);
                } catch (IOException e2) {
                    Log.e(d.b, "Error writing historical record file: " + d.this.k, e2);
                } catch (IllegalArgumentException e3) {
                    Log.e(d.b, "Error writing historical record file: " + d.this.k, e3);
                } finally {
                    d.this.l = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                }
                return null;
            } catch (FileNotFoundException e4) {
                Log.e(d.b, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }

    private d(Context context, String str) {
        this.j = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(o)) {
            this.k = str;
            return;
        }
        this.k = str + o;
    }

    public static d a(Context context, String str) {
        d dVar;
        synchronized (q) {
            dVar = r.get(str);
            if (dVar == null) {
                dVar = new d(context, str);
                r.put(str, dVar);
            }
        }
        return dVar;
    }

    private boolean a(e eVar) {
        boolean zAdd = this.u.add(eVar);
        if (zAdd) {
            this.z = true;
            k();
            f();
            h();
            notifyChanged();
        }
        return zAdd;
    }

    private void f() {
        if (!this.y) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.z) {
            this.z = false;
            if (TextUtils.isEmpty(this.k)) {
                return;
            }
            new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.u), this.k);
        }
    }

    private void g() {
        boolean zI = i() | j();
        k();
        if (zI) {
            h();
            notifyChanged();
        }
    }

    private boolean h() {
        if (this.w == null || this.v == null || this.t.isEmpty() || this.u.isEmpty()) {
            return false;
        }
        this.w.a(this.v, this.t, Collections.unmodifiableList(this.u));
        return true;
    }

    private boolean i() {
        if (!this.A || this.v == null) {
            return false;
        }
        this.A = false;
        this.t.clear();
        List<ResolveInfo> listQueryIntentActivities = this.j.getPackageManager().queryIntentActivities(this.v, 0);
        int size = listQueryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.t.add(new b(listQueryIntentActivities.get(i2)));
        }
        return true;
    }

    private boolean j() {
        if (!this.l || !this.z || TextUtils.isEmpty(this.k)) {
            return false;
        }
        this.l = false;
        this.y = true;
        l();
        return true;
    }

    private void k() {
        int size = this.u.size() - this.x;
        if (size <= 0) {
            return;
        }
        this.z = true;
        for (int i2 = 0; i2 < size; i2++) {
            this.u.remove(0);
        }
    }

    private void l() {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.j.openFileInput(this.k);
            try {
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!c.equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<e> list = this.u;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput != null) {
                                    break;
                                } else {
                                    return;
                                }
                            } else if (next2 != 3 && next2 != 4) {
                                if (!d.equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new e(xmlPullParserNewPullParser.getAttributeValue(null, e), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, f)), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, g))));
                            }
                        }
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th) {
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (XmlPullParserException e2) {
                    Log.e(b, "Error reading historical recrod file: " + this.k, e2);
                    if (fileInputStreamOpenFileInput == null) {
                    }
                }
            } catch (IOException e3) {
                Log.e(b, "Error reading historical recrod file: " + this.k, e3);
                if (fileInputStreamOpenFileInput == null) {
                }
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.s) {
            g();
            List<b> list = this.t;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f263a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public Intent a() {
        Intent intent;
        synchronized (this.s) {
            intent = this.v;
        }
        return intent;
    }

    public ResolveInfo a(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.s) {
            g();
            resolveInfo = this.t.get(i2).f263a;
        }
        return resolveInfo;
    }

    public void a(Intent intent) {
        synchronized (this.s) {
            if (this.v == intent) {
                return;
            }
            this.v = intent;
            this.A = true;
            g();
        }
    }

    public void a(c cVar) {
        synchronized (this.s) {
            if (this.w == cVar) {
                return;
            }
            this.w = cVar;
            if (h()) {
                notifyChanged();
            }
        }
    }

    public void a(f fVar) {
        synchronized (this.s) {
            this.B = fVar;
        }
    }

    public int b() {
        int size;
        synchronized (this.s) {
            g();
            size = this.t.size();
        }
        return size;
    }

    public Intent b(int i2) {
        synchronized (this.s) {
            if (this.v == null) {
                return null;
            }
            g();
            b bVar = this.t.get(i2);
            ComponentName componentName = new ComponentName(bVar.f263a.activityInfo.packageName, bVar.f263a.activityInfo.name);
            Intent intent = new Intent(this.v);
            intent.setComponent(componentName);
            if (this.B != null) {
                if (this.B.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new e(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo c() {
        synchronized (this.s) {
            g();
            if (this.t.isEmpty()) {
                return null;
            }
            return this.t.get(0).f263a;
        }
    }

    public void c(int i2) {
        synchronized (this.s) {
            g();
            b bVar = this.t.get(i2);
            b bVar2 = this.t.get(0);
            a(new e(new ComponentName(bVar.f263a.activityInfo.packageName, bVar.f263a.activityInfo.name), System.currentTimeMillis(), bVar2 != null ? (bVar2.b - bVar.b) + 5.0f : 1.0f));
        }
    }

    public int d() {
        int i2;
        synchronized (this.s) {
            i2 = this.x;
        }
        return i2;
    }

    public void d(int i2) {
        synchronized (this.s) {
            if (this.x == i2) {
                return;
            }
            this.x = i2;
            k();
            if (h()) {
                notifyChanged();
            }
        }
    }

    public int e() {
        int size;
        synchronized (this.s) {
            g();
            size = this.u.size();
        }
        return size;
    }
}
