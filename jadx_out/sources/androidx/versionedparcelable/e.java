package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.ah;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public abstract class e {
    private static final String d = "VersionedParcel";
    private static final int e = -1;
    private static final int f = -2;
    private static final int g = -3;
    private static final int h = -4;
    private static final int i = -5;
    private static final int j = -6;
    private static final int k = -7;
    private static final int l = -9;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 7;
    private static final int s = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final androidx.c.a<String, Method> f1111a;
    protected final androidx.c.a<String, Method> b;
    protected final androidx.c.a<String, Class> c;

    public static class a extends RuntimeException {
        public a(Throwable th) {
            super(th);
        }
    }

    public e(androidx.c.a<String, Method> aVar, androidx.c.a<String, Method> aVar2, androidx.c.a<String, Class> aVar3) {
        this.f1111a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    private <T> int a(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof h) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Exception a(int i2, String str) {
        return b(i2, str);
    }

    @ah
    protected static Throwable a(@ah Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method a(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = this.b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsB = b((Class<? extends h>) cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, e.class);
        this.b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private void a(Serializable serializable) {
        if (serializable == null) {
            a((String) null);
            return;
        }
        String name = serializable.getClass().getName();
        a(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            a(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e2);
        }
    }

    private <T> void a(Collection<T> collection) {
        if (collection == null) {
            a(-1);
        }
        int size = collection.size();
        a(size);
        if (size > 0) {
            int iA = a(collection.iterator().next());
            a(iA);
            switch (iA) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        a((h) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        a((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        a((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        a((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        a((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        a(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        a(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private <T> void a(Collection<T> collection, int i2) {
        c(i2);
        a((Collection) collection);
    }

    private Class b(Class<? extends h> cls) throws ClassNotFoundException {
        Class cls2 = this.c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.c.put(cls.getName(), cls3);
        return cls3;
    }

    private Exception b(int i2, String str) {
        switch (i2) {
            case l /* -9 */:
                return (Exception) l();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i2 + " msg " + str);
            case k /* -7 */:
                return new UnsupportedOperationException(str);
            case j /* -6 */:
                return new NetworkOnMainThreadException();
            case i /* -5 */:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Method b(String str) throws NoSuchMethodException {
        Method method = this.f1111a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, e.class.getClassLoader()).getDeclaredMethod("read", e.class);
        this.f1111a.put(str, declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S b(S s2) {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        if (iD != 0) {
            int iD2 = d();
            if (iD >= 0) {
                switch (iD2) {
                    case 1:
                        while (iD > 0) {
                            s2.add(u());
                            iD--;
                        }
                        break;
                    case 2:
                        while (iD > 0) {
                            s2.add(l());
                            iD--;
                        }
                        break;
                    case 3:
                        while (iD > 0) {
                            s2.add(v());
                            iD--;
                        }
                        break;
                    case 4:
                        while (iD > 0) {
                            s2.add(h());
                            iD--;
                        }
                        break;
                    case 5:
                        while (iD > 0) {
                            s2.add(i());
                            iD--;
                        }
                        break;
                }
            } else {
                return null;
            }
        }
        return s2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(h hVar) {
        try {
            a(b((Class<? extends h>) hVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(hVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private int w() {
        return d();
    }

    protected <T extends h> T a(String str, e eVar) {
        try {
            return (T) b(str).invoke(null, eVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    public void a(byte b, int i2) {
        c(i2);
        a((int) b);
    }

    protected abstract void a(double d2);

    public void a(double d2, int i2) {
        c(i2);
        a(d2);
    }

    protected abstract void a(float f2);

    public void a(float f2, int i2) {
        c(i2);
        a(f2);
    }

    protected abstract void a(int i2);

    public void a(int i2, int i3) {
        c(i3);
        a(i2);
    }

    protected abstract void a(long j2);

    public void a(long j2, int i2) {
        c(i2);
        a(j2);
    }

    protected abstract void a(Bundle bundle);

    public void a(Bundle bundle, int i2) {
        c(i2);
        a(bundle);
    }

    protected abstract void a(IBinder iBinder);

    public void a(IBinder iBinder, int i2) {
        c(i2);
        a(iBinder);
    }

    protected abstract void a(IInterface iInterface);

    public void a(IInterface iInterface, int i2) {
        c(i2);
        a(iInterface);
    }

    protected abstract void a(Parcelable parcelable);

    public void a(Parcelable parcelable, int i2) {
        c(i2);
        a(parcelable);
    }

    @am(b = 21)
    public void a(Size size, int i2) {
        c(i2);
        a(size != null);
        if (size != null) {
            a(size.getWidth());
            a(size.getHeight());
        }
    }

    @am(b = 21)
    public void a(SizeF sizeF, int i2) {
        c(i2);
        a(sizeF != null);
        if (sizeF != null) {
            a(sizeF.getWidth());
            a(sizeF.getHeight());
        }
    }

    public void a(SparseBooleanArray sparseBooleanArray, int i2) {
        c(i2);
        if (sparseBooleanArray == null) {
            a(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        a(size);
        for (int i3 = 0; i3 < size; i3++) {
            a(sparseBooleanArray.keyAt(i3));
            a(sparseBooleanArray.valueAt(i3));
        }
    }

    protected void a(h hVar) {
        if (hVar == null) {
            a((String) null);
            return;
        }
        b(hVar);
        e eVarC = c();
        a(hVar, eVarC);
        eVarC.b();
    }

    public void a(h hVar, int i2) {
        c(i2);
        a(hVar);
    }

    protected <T extends h> void a(T t, e eVar) {
        try {
            a((Class) t.getClass()).invoke(null, t, eVar);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (!(e5.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
            }
            throw ((RuntimeException) e5.getCause());
        }
    }

    public void a(Serializable serializable, int i2) {
        c(i2);
        a(serializable);
    }

    protected abstract void a(CharSequence charSequence);

    public void a(CharSequence charSequence, int i2) {
        c(i2);
        a(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Exception exc, int i2) {
        c(i2);
        if (exc == 0) {
            t();
            return;
        }
        int i3 = 0;
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i3 = l;
        } else if (exc instanceof SecurityException) {
            i3 = -1;
        } else if (exc instanceof BadParcelableException) {
            i3 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i3 = -3;
        } else if (exc instanceof NullPointerException) {
            i3 = -4;
        } else if (exc instanceof IllegalStateException) {
            i3 = i;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i3 = j;
        } else if (exc instanceof UnsupportedOperationException) {
            i3 = k;
        }
        a(i3);
        if (i3 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        a(exc.getMessage());
        if (i3 != l) {
            return;
        }
        a((Parcelable) exc);
    }

    protected abstract void a(String str);

    public void a(String str, int i2) {
        c(i2);
        a(str);
    }

    public <T> void a(List<T> list, int i2) {
        a((Collection) list, i2);
    }

    public <K, V> void a(Map<K, V> map, int i2) {
        c(i2);
        if (map == null) {
            a(-1);
            return;
        }
        int size = map.size();
        a(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        a((Collection) arrayList);
        a((Collection) arrayList2);
    }

    public <T> void a(Set<T> set, int i2) {
        a((Collection) set, i2);
    }

    protected abstract void a(boolean z);

    public void a(boolean z, int i2) {
        c(i2);
        a(z);
    }

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    public void a(byte[] bArr, int i2) {
        c(i2);
        a(bArr);
    }

    protected abstract void a(byte[] bArr, int i2, int i3);

    public void a(byte[] bArr, int i2, int i3, int i4) {
        c(i4);
        a(bArr, i2, i3);
    }

    public void a(char[] cArr, int i2) {
        c(i2);
        if (cArr == null) {
            a(-1);
            return;
        }
        a(cArr.length);
        for (char c : cArr) {
            a((int) c);
        }
    }

    protected void a(double[] dArr) {
        if (dArr == null) {
            a(-1);
            return;
        }
        a(dArr.length);
        for (double d2 : dArr) {
            a(d2);
        }
    }

    public void a(double[] dArr, int i2) {
        c(i2);
        a(dArr);
    }

    protected void a(float[] fArr) {
        if (fArr == null) {
            a(-1);
            return;
        }
        a(fArr.length);
        for (float f2 : fArr) {
            a(f2);
        }
    }

    public void a(float[] fArr, int i2) {
        c(i2);
        a(fArr);
    }

    protected void a(int[] iArr) {
        if (iArr == null) {
            a(-1);
            return;
        }
        a(iArr.length);
        for (int i2 : iArr) {
            a(i2);
        }
    }

    public void a(int[] iArr, int i2) {
        c(i2);
        a(iArr);
    }

    protected void a(long[] jArr) {
        if (jArr == null) {
            a(-1);
            return;
        }
        a(jArr.length);
        for (long j2 : jArr) {
            a(j2);
        }
    }

    public void a(long[] jArr, int i2) {
        c(i2);
        a(jArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void a(T[] tArr) {
        if (tArr == 0) {
            a(-1);
        }
        int length = tArr.length;
        a(length);
        if (length > 0) {
            int i2 = 0;
            int iA = a(tArr[0]);
            a(iA);
            switch (iA) {
                case 1:
                    while (i2 < length) {
                        a((h) tArr[i2]);
                        i2++;
                    }
                    break;
                case 2:
                    while (i2 < length) {
                        a((Parcelable) tArr[i2]);
                        i2++;
                    }
                    break;
                case 3:
                    while (i2 < length) {
                        a((Serializable) tArr[i2]);
                        i2++;
                    }
                    break;
                case 4:
                    while (i2 < length) {
                        a((String) tArr[i2]);
                        i2++;
                    }
                    break;
                case 5:
                    while (i2 < length) {
                        a((IBinder) tArr[i2]);
                        i2++;
                    }
                    break;
            }
        }
    }

    public <T> void a(T[] tArr, int i2) {
        c(i2);
        a((Object[]) tArr);
    }

    protected void a(boolean[] zArr) {
        if (zArr == null) {
            a(-1);
            return;
        }
        a(zArr.length);
        for (boolean z : zArr) {
            a(z ? 1 : 0);
        }
    }

    public void a(boolean[] zArr, int i2) {
        c(i2);
        a(zArr);
    }

    public boolean a() {
        return false;
    }

    public byte b(byte b, int i2) {
        return !b(i2) ? b : (byte) (d() & 255);
    }

    public double b(double d2, int i2) {
        return !b(i2) ? d2 : g();
    }

    public float b(float f2, int i2) {
        return !b(i2) ? f2 : f();
    }

    public int b(int i2, int i3) {
        return !b(i3) ? i2 : d();
    }

    public long b(long j2, int i2) {
        return !b(i2) ? j2 : e();
    }

    public Bundle b(Bundle bundle, int i2) {
        return !b(i2) ? bundle : m();
    }

    public IBinder b(IBinder iBinder, int i2) {
        return !b(i2) ? iBinder : i();
    }

    public <T extends Parcelable> T b(T t, int i2) {
        return !b(i2) ? t : (T) l();
    }

    @am(b = 21)
    public Size b(Size size, int i2) {
        if (!b(i2)) {
            return size;
        }
        if (n()) {
            return new Size(d(), d());
        }
        return null;
    }

    @am(b = 21)
    public SizeF b(SizeF sizeF, int i2) {
        if (!b(i2)) {
            return sizeF;
        }
        if (n()) {
            return new SizeF(f(), f());
        }
        return null;
    }

    public SparseBooleanArray b(SparseBooleanArray sparseBooleanArray, int i2) {
        if (!b(i2)) {
            return sparseBooleanArray;
        }
        int iD = d();
        if (iD < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(iD);
        for (int i3 = 0; i3 < iD; i3++) {
            sparseBooleanArray2.put(d(), n());
        }
        return sparseBooleanArray2;
    }

    public <T extends h> T b(T t, int i2) {
        return !b(i2) ? t : (T) u();
    }

    public CharSequence b(CharSequence charSequence, int i2) {
        return !b(i2) ? charSequence : k();
    }

    public Exception b(Exception exc, int i2) {
        int iW;
        return (b(i2) && (iW = w()) != 0) ? a(iW, h()) : exc;
    }

    public String b(String str, int i2) {
        return !b(i2) ? str : h();
    }

    public <T> List<T> b(List<T> list, int i2) {
        return !b(i2) ? list : (List) b(new ArrayList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> b(Map<K, V> map, int i2) {
        if (!b(i2)) {
            return map;
        }
        int iD = d();
        if (iD < 0) {
            return null;
        }
        androidx.c.a aVar = new androidx.c.a();
        if (iD == 0) {
            return aVar;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b(arrayList);
        b(arrayList2);
        for (int i3 = 0; i3 < iD; i3++) {
            aVar.put(arrayList.get(i3), arrayList2.get(i3));
        }
        return aVar;
    }

    public <T> Set<T> b(Set<T> set, int i2) {
        return !b(i2) ? set : (Set) b(new androidx.c.b());
    }

    protected abstract void b();

    protected abstract boolean b(int i2);

    public boolean b(boolean z, int i2) {
        return !b(i2) ? z : n();
    }

    public byte[] b(byte[] bArr, int i2) {
        return !b(i2) ? bArr : j();
    }

    public char[] b(char[] cArr, int i2) {
        if (!b(i2)) {
            return cArr;
        }
        int iD = d();
        if (iD < 0) {
            return null;
        }
        char[] cArr2 = new char[iD];
        for (int i3 = 0; i3 < iD; i3++) {
            cArr2[i3] = (char) d();
        }
        return cArr2;
    }

    public double[] b(double[] dArr, int i2) {
        return !b(i2) ? dArr : s();
    }

    public float[] b(float[] fArr, int i2) {
        return !b(i2) ? fArr : r();
    }

    public int[] b(int[] iArr, int i2) {
        return !b(i2) ? iArr : p();
    }

    public long[] b(long[] jArr, int i2) {
        return !b(i2) ? jArr : q();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected <T> T[] b(T[] tArr) {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iD);
        if (iD != 0) {
            int iD2 = d();
            if (iD >= 0) {
                switch (iD2) {
                    case 1:
                        while (iD > 0) {
                            arrayList.add(u());
                            iD--;
                        }
                        break;
                    case 2:
                        while (iD > 0) {
                            arrayList.add(l());
                            iD--;
                        }
                        break;
                    case 3:
                        while (iD > 0) {
                            arrayList.add(v());
                            iD--;
                        }
                        break;
                    case 4:
                        while (iD > 0) {
                            arrayList.add(h());
                            iD--;
                        }
                        break;
                    case 5:
                        while (iD > 0) {
                            arrayList.add(i());
                            iD--;
                        }
                        break;
                }
            } else {
                return null;
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public <T> T[] b(T[] tArr, int i2) {
        return !b(i2) ? tArr : (T[]) b(tArr);
    }

    public boolean[] b(boolean[] zArr, int i2) {
        return !b(i2) ? zArr : o();
    }

    protected abstract e c();

    protected abstract void c(int i2);

    protected abstract int d();

    protected abstract long e();

    protected abstract float f();

    protected abstract double g();

    protected abstract String h();

    protected abstract IBinder i();

    protected abstract byte[] j();

    protected abstract CharSequence k();

    protected abstract <T extends Parcelable> T l();

    protected abstract Bundle m();

    protected abstract boolean n();

    protected boolean[] o() {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        boolean[] zArr = new boolean[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            zArr[i2] = d() != 0;
        }
        return zArr;
    }

    protected int[] p() {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        int[] iArr = new int[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            iArr[i2] = d();
        }
        return iArr;
    }

    protected long[] q() {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        long[] jArr = new long[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            jArr[i2] = e();
        }
        return jArr;
    }

    protected float[] r() {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        float[] fArr = new float[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            fArr[i2] = f();
        }
        return fArr;
    }

    protected double[] s() {
        int iD = d();
        if (iD < 0) {
            return null;
        }
        double[] dArr = new double[iD];
        for (int i2 = 0; i2 < iD; i2++) {
            dArr[i2] = g();
        }
        return dArr;
    }

    protected void t() {
        a(0);
    }

    protected <T extends h> T u() {
        String strH = h();
        if (strH == null) {
            return null;
        }
        return (T) a(strH, c());
    }

    protected Serializable v() {
        String strH = h();
        if (strH == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(j())) { // from class: androidx.versionedparcelable.e.1
                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + strH + ")", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + strH + ")", e3);
        }
    }
}
