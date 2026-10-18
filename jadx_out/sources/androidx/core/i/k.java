package androidx.core.i;

import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class k extends RuntimeException {
    public k() {
        this(null);
    }

    public k(@ai String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
