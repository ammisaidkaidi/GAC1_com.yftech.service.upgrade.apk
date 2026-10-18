package androidx.core.n.a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.ai;
import androidx.annotation.am;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f520a = -1;
    private final Object b;

    @am(a = 16)
    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f521a;

        a(e eVar) {
            this.f521a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            d dVarA = this.f521a.a(i);
            if (dVarA == null) {
                return null;
            }
            return dVarA.a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<d> listA = this.f521a.a(str, i);
            if (listA == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listA.get(i2).a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f521a.a(i, i2, bundle);
        }
    }

    @am(a = 19)
    static class b extends a {
        b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            d dVarB = this.f521a.b(i);
            if (dVarB == null) {
                return null;
            }
            return dVarB.a();
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.b = new b(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.b = new a(this);
        } else {
            this.b = null;
        }
    }

    public e(Object obj) {
        this.b = obj;
    }

    @ai
    public d a(int i) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    @ai
    public List<d> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    @ai
    public d b(int i) {
        return null;
    }
}
