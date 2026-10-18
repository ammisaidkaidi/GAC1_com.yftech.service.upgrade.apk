package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface x {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        String a();

        int b();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
        String a();

        int b();

        int c() default 0;
    }

    public enum c {
        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID
    }

    String a() default "";

    int b() default 0;

    boolean c() default true;

    c d() default c.INFERRED;

    a[] e() default {};

    b[] f() default {};
}
