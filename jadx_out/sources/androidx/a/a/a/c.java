package androidx.a.a.a;

import androidx.annotation.ah;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public abstract class c {
    public abstract void a(@ah Runnable runnable);

    public abstract void b(@ah Runnable runnable);

    public void c(@ah Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public abstract boolean d();
}
