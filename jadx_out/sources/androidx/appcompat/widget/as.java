package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class as extends androidx.core.n.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f232a = "share_history.xml";
    private static final int e = 4;
    final Context b;
    String c;
    a d;
    private int f;
    private final c g;
    private d.f h;

    public interface a {
        boolean a(as asVar, Intent intent);
    }

    private class b implements d.f {
        b() {
        }

        @Override // androidx.appcompat.widget.d.f
        public boolean a(d dVar, Intent intent) {
            if (as.this.d == null) {
                return false;
            }
            as.this.d.a(as.this, intent);
            return false;
        }
    }

    private class c implements MenuItem.OnMenuItemClickListener {
        c() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent intentB = d.a(as.this.b, as.this.c).b(menuItem.getItemId());
            if (intentB == null) {
                return true;
            }
            String action = intentB.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                as.this.b(intentB);
            }
            as.this.b.startActivity(intentB);
            return true;
        }
    }

    public as(Context context) {
        super(context);
        this.f = 4;
        this.g = new c();
        this.c = f232a;
        this.b = context;
    }

    private void i() {
        if (this.d == null) {
            return;
        }
        if (this.h == null) {
            this.h = new b();
        }
        d.a(this.b, this.c).a(this.h);
    }

    @Override // androidx.core.n.b
    public View a() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.b);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(d.a(this.b, this.c));
        }
        TypedValue typedValue = new TypedValue();
        this.b.getTheme().resolveAttribute(androidx.appcompat.a.b.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(androidx.appcompat.a.a.a.b(this.b, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(androidx.appcompat.a.k.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(androidx.appcompat.a.k.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                b(intent);
            }
        }
        d.a(this.b, this.c).a(intent);
    }

    @Override // androidx.core.n.b
    public void a(SubMenu subMenu) {
        subMenu.clear();
        d dVarA = d.a(this.b, this.c);
        PackageManager packageManager = this.b.getPackageManager();
        int iB = dVarA.b();
        int iMin = Math.min(iB, this.f);
        for (int i = 0; i < iMin; i++) {
            ResolveInfo resolveInfoA = dVarA.a(i);
            subMenu.add(0, i, i, resolveInfoA.loadLabel(packageManager)).setIcon(resolveInfoA.loadIcon(packageManager)).setOnMenuItemClickListener(this.g);
        }
        if (iMin < iB) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.b.getString(androidx.appcompat.a.k.abc_activity_chooser_view_see_all));
            for (int i2 = 0; i2 < iB; i2++) {
                ResolveInfo resolveInfoA2 = dVarA.a(i2);
                subMenuAddSubMenu.add(0, i2, i2, resolveInfoA2.loadLabel(packageManager)).setIcon(resolveInfoA2.loadIcon(packageManager)).setOnMenuItemClickListener(this.g);
            }
        }
    }

    public void a(a aVar) {
        this.d = aVar;
        i();
    }

    public void a(String str) {
        this.c = str;
        i();
    }

    void b(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    @Override // androidx.core.n.b
    public boolean c() {
        return true;
    }
}
