package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.ae;
import androidx.annotation.ah;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f981a = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final b b;
    private final x c;

    public static class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f982a;
        private Application b;

        public a(@ah Application application) {
            this.b = application;
        }

        @ah
        public static a a(@ah Application application) {
            if (f982a == null) {
                f982a = new a(application);
            }
            return f982a;
        }

        @Override // androidx.lifecycle.w.d, androidx.lifecycle.w.b
        @ah
        public <T extends v> T a(@ah Class<T> cls) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.b);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    public interface b {
        @ah
        <T extends v> T a(@ah Class<T> cls);
    }

    static abstract class c implements b {
        c() {
        }

        @Override // androidx.lifecycle.w.b
        @ah
        public <T extends v> T a(@ah Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @ah
        public abstract <T extends v> T a(@ah String str, @ah Class<T> cls);
    }

    public static class d implements b {
        @Override // androidx.lifecycle.w.b
        @ah
        public <T extends v> T a(@ah Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public w(@ah x xVar, @ah b bVar) {
        this.b = bVar;
        this.c = xVar;
    }

    public w(@ah y yVar, @ah b bVar) {
        this(yVar.d(), bVar);
    }

    @ae
    @ah
    public <T extends v> T a(@ah Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ae
    @ah
    public <T extends v> T a(@ah String str, @ah Class<T> cls) {
        T t = (T) this.c.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = this.b instanceof c ? (T) ((c) this.b).a(str, cls) : (T) this.b.a(cls);
        this.c.a(str, t2);
        return t2;
    }
}
