package androidx.annotation.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface a {

    /* JADX INFO: renamed from: androidx.annotation.a.a$a, reason: collision with other inner class name */
    public enum EnumC0007a {
        WARNING,
        ERROR
    }

    EnumC0007a a() default EnumC0007a.ERROR;
}
