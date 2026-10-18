package androidx.lifecycle;

import androidx.annotation.ae;
import androidx.annotation.ah;
import androidx.annotation.ap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    @ap(a = {ap.a.LIBRARY_GROUP})
    AtomicReference<Object> f968a = new AtomicReference<>();

    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(@ah b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    @ae
    @ah
    public abstract b a();

    @ae
    public abstract void a(@ah i iVar);

    @ae
    public abstract void b(@ah i iVar);
}
