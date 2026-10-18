package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public final class j implements androidx.core.e.a.b {
    private static final int H = 1;
    private static final int I = 2;
    private static final int J = 4;
    private static final int K = 8;
    private static final int L = 16;
    private static final int M = 32;
    static final int b = 0;
    private static final String h = "MenuItemImpl";
    private static final int i = 3;
    private CharSequence A;
    private int N;
    private View O;
    private androidx.core.n.b P;
    private MenuItem.OnActionExpandListener Q;
    private ContextMenu.ContextMenuInfo S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f138a;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private CharSequence n;
    private CharSequence o;
    private Intent p;
    private char q;
    private char s;
    private Drawable u;
    private s w;
    private Runnable x;
    private MenuItem.OnMenuItemClickListener y;
    private CharSequence z;
    private int r = 4096;
    private int t = 4096;
    private int v = 0;
    private ColorStateList B = null;
    private PorterDuff.Mode C = null;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private int G = 16;
    private boolean R = false;

    j(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.N = 0;
        this.f138a = gVar;
        this.j = i3;
        this.k = i2;
        this.l = i4;
        this.m = i5;
        this.n = charSequence;
        this.N = i6;
    }

    private Drawable a(Drawable drawable) {
        if (drawable != null && this.F && (this.D || this.E)) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            if (this.D) {
                androidx.core.graphics.drawable.a.a(drawable, this.B);
            }
            if (this.E) {
                androidx.core.graphics.drawable.a.a(drawable, this.C);
            }
            this.F = false;
        }
        return drawable;
    }

    private static void a(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    public MenuItem a(Runnable runnable) {
        this.x = runnable;
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.core.e.a.b setActionView(int i2) {
        Context contextG = this.f138a.g();
        setActionView(LayoutInflater.from(contextG).inflate(i2, (ViewGroup) new LinearLayout(contextG), false));
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.core.e.a.b setActionView(View view) {
        this.O = view;
        this.P = null;
        if (view != null && view.getId() == -1 && this.j > 0) {
            view.setId(this.j);
        }
        this.f138a.b(this);
        return this;
    }

    @Override // androidx.core.e.a.b
    public androidx.core.e.a.b a(androidx.core.n.b bVar) {
        if (this.P != null) {
            this.P.h();
        }
        this.O = null;
        this.P = bVar;
        this.f138a.c(true);
        if (this.P != null) {
            this.P.a(new androidx.core.n.b.InterfaceC0043b() { // from class: androidx.appcompat.view.menu.j.1
                @Override // androidx.core.n.b.InterfaceC0043b
                public void a(boolean z) {
                    j.this.f138a.a(j.this);
                }
            });
        }
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public androidx.core.e.a.b setContentDescription(CharSequence charSequence) {
        this.z = charSequence;
        this.f138a.c(false);
        return this;
    }

    CharSequence a(o.a aVar) {
        return (aVar == null || !aVar.a()) ? getTitle() : getTitleCondensed();
    }

    void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.S = contextMenuInfo;
    }

    public void a(s sVar) {
        this.w = sVar;
        sVar.setHeaderTitle(getTitle());
    }

    public void a(boolean z) {
        this.G = (z ? 4 : 0) | (this.G & (-5));
    }

    public boolean a() {
        if ((this.y != null && this.y.onMenuItemClick(this)) || this.f138a.a(this.f138a, this)) {
            return true;
        }
        if (this.x != null) {
            this.x.run();
            return true;
        }
        if (this.p != null) {
            try {
                this.f138a.g().startActivity(this.p);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(h, "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.P != null && this.P.b();
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public androidx.core.e.a.b setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public androidx.core.e.a.b setTooltipText(CharSequence charSequence) {
        this.A = charSequence;
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b
    public androidx.core.n.b b() {
        return this.P;
    }

    void b(boolean z) {
        int i2 = this.G;
        this.G = (z ? 2 : 0) | (this.G & (-3));
        if (i2 != this.G) {
            this.f138a.c(false);
        }
    }

    public int c() {
        return this.m;
    }

    boolean c(boolean z) {
        int i2 = this.G;
        this.G = (z ? 0 : 8) | (this.G & (-9));
        return i2 != this.G;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.N & 8) == 0) {
            return false;
        }
        if (this.O == null) {
            return true;
        }
        if (this.Q == null || this.Q.onMenuItemActionCollapse(this)) {
            return this.f138a.d(this);
        }
        return false;
    }

    Runnable d() {
        return this.x;
    }

    public void d(boolean z) {
        if (z) {
            this.G |= 32;
        } else {
            this.G &= -33;
        }
    }

    char e() {
        return this.f138a.d() ? this.s : this.q;
    }

    public void e(boolean z) {
        this.R = z;
        this.f138a.c(false);
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!n()) {
            return false;
        }
        if (this.Q == null || this.Q.onMenuItemActionExpand(this)) {
            return this.f138a.c(this);
        }
        return false;
    }

    String f() {
        char cE = e();
        if (cE == 0) {
            return com.yftech.service.upgrade.a.d;
        }
        Resources resources = this.f138a.g().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f138a.g()).hasPermanentMenuKey()) {
            sb.append(resources.getString(androidx.appcompat.a.k.abc_prepend_shortcut_label));
        }
        int i2 = this.f138a.d() ? this.t : this.r;
        a(sb, i2, 65536, resources.getString(androidx.appcompat.a.k.abc_menu_meta_shortcut_label));
        a(sb, i2, 4096, resources.getString(androidx.appcompat.a.k.abc_menu_ctrl_shortcut_label));
        a(sb, i2, 2, resources.getString(androidx.appcompat.a.k.abc_menu_alt_shortcut_label));
        a(sb, i2, 1, resources.getString(androidx.appcompat.a.k.abc_menu_shift_shortcut_label));
        a(sb, i2, 4, resources.getString(androidx.appcompat.a.k.abc_menu_sym_shortcut_label));
        a(sb, i2, 8, resources.getString(androidx.appcompat.a.k.abc_menu_function_shortcut_label));
        if (cE == '\b') {
            sb.append(resources.getString(androidx.appcompat.a.k.abc_menu_delete_shortcut_label));
        } else if (cE == '\n') {
            sb.append(resources.getString(androidx.appcompat.a.k.abc_menu_enter_shortcut_label));
        } else if (cE != ' ') {
            sb.append(cE);
        } else {
            sb.append(resources.getString(androidx.appcompat.a.k.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    boolean g() {
        return this.f138a.e() && e() != 0;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public View getActionView() {
        if (this.O != null) {
            return this.O;
        }
        if (this.P == null) {
            return null;
        }
        this.O = this.P.a(this);
        return this.O;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.s;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.z;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        if (this.u != null) {
            return a(this.u);
        }
        if (this.v == 0) {
            return null;
        }
        Drawable drawableB = androidx.appcompat.a.a.a.b(this.f138a.g(), this.v);
        this.v = 0;
        this.u = drawableB;
        return a(drawableB);
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.B;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.p;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.S;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.l;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.w;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.o != null ? this.o : this.n;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.A;
    }

    public boolean h() {
        return (this.G & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.w != null;
    }

    public void i() {
        this.f138a.b(this);
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.R;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.G & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.G & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.G & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if (this.P == null || !this.P.d()) {
            return (this.G & 8) == 0;
        }
        return (this.G & 8) == 0 && this.P.e();
    }

    public boolean j() {
        return this.f138a.s();
    }

    public boolean k() {
        return (this.G & 32) == 32;
    }

    public boolean l() {
        return (this.N & 1) == 1;
    }

    public boolean m() {
        return (this.N & 4) == 4;
    }

    public boolean n() {
        if ((this.N & 8) == 0) {
            return false;
        }
        if (this.O == null && this.P != null) {
            this.O = this.P.a(this);
        }
        return this.O != null;
    }

    @Override // androidx.core.e.a.b
    public boolean requiresActionButton() {
        return (this.N & 2) == 2;
    }

    @Override // androidx.core.e.a.b
    public boolean requiresOverflow() {
        return (requiresActionButton() || l()) ? false : true;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.s == c) {
            return this;
        }
        this.s = Character.toLowerCase(c);
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        if (this.s == c && this.t == i2) {
            return this;
        }
        this.s = Character.toLowerCase(c);
        this.t = KeyEvent.normalizeMetaState(i2);
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.G;
        this.G = (z ? 1 : 0) | (this.G & (-2));
        if (i2 != this.G) {
            this.f138a.c(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.G & 4) != 0) {
            this.f138a.a((MenuItem) this);
        } else {
            b(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.G |= 16;
        } else {
            this.G &= -17;
        }
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.u = null;
        this.v = i2;
        this.F = true;
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.v = 0;
        this.u = drawable;
        this.F = true;
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(@ai ColorStateList colorStateList) {
        this.B = colorStateList;
        this.D = true;
        this.F = true;
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.C = mode;
        this.E = true;
        this.F = true;
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.p = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.q == c) {
            return this;
        }
        this.q = c;
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i2) {
        if (this.q == c && this.r == i2) {
            return this;
        }
        this.q = c;
        this.r = KeyEvent.normalizeMetaState(i2);
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.Q = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.y = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.q = c;
        this.s = Character.toLowerCase(c2);
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i2, int i3) {
        this.q = c;
        this.r = KeyEvent.normalizeMetaState(i2);
        this.s = Character.toLowerCase(c2);
        this.t = KeyEvent.normalizeMetaState(i3);
        this.f138a.c(false);
        return this;
    }

    @Override // androidx.core.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        switch (i2 & 3) {
            case 0:
            case 1:
            case 2:
                this.N = i2;
                this.f138a.b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        return setTitle(this.f138a.g().getString(i2));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.n = charSequence;
        this.f138a.c(false);
        if (this.w != null) {
            this.w.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.o = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.n;
        }
        this.f138a.c(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            this.f138a.a(this);
        }
        return this;
    }

    public String toString() {
        if (this.n != null) {
            return this.n.toString();
        }
        return null;
    }
}
