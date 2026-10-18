package androidx.core.n;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.ap;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final View.AccessibilityDelegate f508a = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate b;
    private final View.AccessibilityDelegate c;

    /* JADX INFO: renamed from: androidx.core.n.a$a, reason: collision with other inner class name */
    static final class C0039a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f509a;

        C0039a(a aVar) {
            this.f509a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f509a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        @androidx.annotation.am(a = 16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.n.a.e eVarA = this.f509a.a(view);
            if (eVarA != null) {
                return (AccessibilityNodeProvider) eVarA.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f509a.d(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.n.a.d dVarA = androidx.core.n.a.d.a(accessibilityNodeInfo);
            dVarA.t(af.au(view));
            dVarA.v(af.aw(view));
            dVarA.i(af.av(view));
            this.f509a.a(view, dVarA);
            dVarA.a(accessibilityNodeInfo.getText(), view);
            List<androidx.core.n.a.d.a> listB = a.b(view);
            for (int i = 0; i < listB.size(); i++) {
                dVarA.a(listB.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f509a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f509a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f509a.a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f509a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f509a.a(view, accessibilityEvent);
        }
    }

    public a() {
        this(f508a);
    }

    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.b = accessibilityDelegate;
        this.c = new C0039a(this);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(androidx.core.a.e.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrD = androidx.core.n.a.d.d(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrD != null && i < clickableSpanArrD.length; i++) {
                if (clickableSpan.equals(clickableSpanArrD[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<androidx.core.n.a.d.a> b(View view) {
        List<androidx.core.n.a.d.a> list = (List) view.getTag(androidx.core.a.e.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    View.AccessibilityDelegate a() {
        return this.c;
    }

    public androidx.core.n.a.e a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.n.a.e(accessibilityNodeProvider);
    }

    public void a(View view, int i) {
        this.b.sendAccessibilityEvent(view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, androidx.core.n.a.d dVar) {
        this.b.onInitializeAccessibilityNodeInfo(view, dVar.a());
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<androidx.core.n.a.d.a> listB = b(view);
        boolean zPerformAccessibilityAction = false;
        for (int i2 = 0; i2 < listB.size(); i2++) {
            androidx.core.n.a.d.a aVar = listB.get(i2);
            if (aVar.a() == i) {
                zPerformAccessibilityAction = aVar.a(view, bundle);
                break;
            }
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.b.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != androidx.core.a.e.accessibility_action_clickable_span) ? zPerformAccessibilityAction : a(bundle.getInt(androidx.core.n.a.a.f510a, -1), view);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return this.b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
}
