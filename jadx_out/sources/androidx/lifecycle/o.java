package androidx.lifecycle;

import androidx.annotation.ap;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f975a = new HashMap();

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public boolean a(String str, int i) {
        Integer num = this.f975a.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z = (iIntValue & i) != 0;
        this.f975a.put(str, Integer.valueOf(i | iIntValue));
        return !z;
    }
}
