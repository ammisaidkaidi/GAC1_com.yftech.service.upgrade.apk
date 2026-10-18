package androidx.lifecycle;

import androidx.annotation.ai;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static b f961a = new b();
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private final Map<Class, a> e = new HashMap();
    private final Map<Class, Boolean> f = new HashMap();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<g.a, List<C0072b>> f962a = new HashMap();
        final Map<C0072b, g.a> b;

        a(Map<C0072b, g.a> map) {
            this.b = map;
            for (Map.Entry<C0072b, g.a> entry : map.entrySet()) {
                g.a value = entry.getValue();
                List<C0072b> arrayList = this.f962a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f962a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void a(List<C0072b> list, j jVar, g.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(jVar, aVar, obj);
                }
            }
        }

        void a(j jVar, g.a aVar, Object obj) {
            a(this.f962a.get(aVar), jVar, aVar, obj);
            a(this.f962a.get(g.a.ON_ANY), jVar, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static class C0072b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f963a;
        final Method b;

        C0072b(int i, Method method) {
            this.f963a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        void a(j jVar, g.a aVar, Object obj) {
            try {
                switch (this.f963a) {
                    case 0:
                        this.b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.b.invoke(obj, jVar);
                        return;
                    case 2:
                        this.b.invoke(obj, jVar, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0072b c0072b = (C0072b) obj;
            return this.f963a == c0072b.f963a && this.b.getName().equals(c0072b.b.getName());
        }

        public int hashCode() {
            return (this.f963a * 31) + this.b.getName().hashCode();
        }
    }

    b() {
    }

    private a a(Class cls, @ai Method[] methodArr) {
        int i;
        a aVarB;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarB = b(superclass)) != null) {
            map.putAll(aVarB.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<C0072b, g.a> entry : b(cls2).b.entrySet()) {
                a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(j.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                g.a aVarA = rVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(g.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarA != g.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(map, new C0072b(i, method), aVarA, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.e.put(cls, aVar);
        this.f.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private void a(Map<C0072b, g.a> map, C0072b c0072b, g.a aVar, Class cls) {
        g.a aVar2 = map.get(c0072b);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(c0072b, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0072b.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    boolean a(Class cls) {
        Boolean bool = this.f.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrC = c(cls);
        for (Method method : methodArrC) {
            if (((r) method.getAnnotation(r.class)) != null) {
                a(cls, methodArrC);
                return true;
            }
        }
        this.f.put(cls, false);
        return false;
    }

    a b(Class cls) {
        a aVar = this.e.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }
}
