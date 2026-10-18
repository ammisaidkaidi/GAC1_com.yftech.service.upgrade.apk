package androidx.versionedparcelable;

import androidx.annotation.ap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public @interface b {
    int a();

    String b() default "";
}
