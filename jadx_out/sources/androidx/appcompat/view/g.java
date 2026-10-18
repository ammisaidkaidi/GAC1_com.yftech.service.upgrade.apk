package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.ac;
import androidx.annotation.ap;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.ba;
import androidx.core.n.o;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class g extends MenuInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f115a = "SupportMenuInflater";
    static final int b = 0;
    static final Class<?>[] c = {Context.class};
    static final Class<?>[] d = c;
    private static final String h = "menu";
    private static final String i = "group";
    private static final String j = "item";
    final Object[] e;
    final Object[] f;
    Context g;
    private Object k;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Class<?>[] f116a = {MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, f116a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, menuItem)).booleanValue();
                }
                this.c.invoke(this.b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        private static final int G = 0;
        private static final int H = 0;
        private static final int I = 0;
        private static final int J = 0;
        private static final int K = 0;
        private static final boolean L = false;
        private static final boolean M = true;
        private static final boolean N = true;
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.core.n.b f117a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.g.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w(g.f115a, "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (g.this.g.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
            }
            if (this.t >= 2) {
                if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                } else if (menuItem instanceof k) {
                    ((k) menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View) a(this.z, g.c, g.this.e));
                z = true;
            }
            if (this.y > 0) {
                if (z) {
                    Log.w(g.f115a, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.y);
                }
            }
            if (this.f117a != null) {
                o.a(menuItem, this.f117a);
            }
            o.a(menuItem, this.C);
            o.b(menuItem, this.D);
            o.b(menuItem, this.p, this.q);
            o.a(menuItem, this.r, this.s);
            if (this.F != null) {
                o.a(menuItem, this.F);
            }
            if (this.E != null) {
                o.a(menuItem, this.E);
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = g.this.g.obtainStyledAttributes(attributeSet, androidx.appcompat.a.m.MenuGroup);
            this.d = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.a.m.MenuGroup_android_id, 0);
            this.e = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.a.m.MenuGroup_android_menuCategory, 0);
            this.f = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.a.m.MenuGroup_android_orderInCategory, 0);
            this.g = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.a.m.MenuGroup_android_checkableBehavior, 0);
            this.h = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.a.m.MenuGroup_android_visible, true);
            this.i = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.a.m.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public void b(AttributeSet attributeSet) {
            ba baVarA = ba.a(g.this.g, attributeSet, androidx.appcompat.a.m.MenuItem);
            this.k = baVarA.g(androidx.appcompat.a.m.MenuItem_android_id, 0);
            this.l = (baVarA.a(androidx.appcompat.a.m.MenuItem_android_menuCategory, this.e) & androidx.core.e.a.a.f) | (baVarA.a(androidx.appcompat.a.m.MenuItem_android_orderInCategory, this.f) & androidx.core.e.a.a.d);
            this.m = baVarA.d(androidx.appcompat.a.m.MenuItem_android_title);
            this.n = baVarA.d(androidx.appcompat.a.m.MenuItem_android_titleCondensed);
            this.o = baVarA.g(androidx.appcompat.a.m.MenuItem_android_icon, 0);
            this.p = a(baVarA.e(androidx.appcompat.a.m.MenuItem_android_alphabeticShortcut));
            this.q = baVarA.a(androidx.appcompat.a.m.MenuItem_alphabeticModifiers, 4096);
            this.r = a(baVarA.e(androidx.appcompat.a.m.MenuItem_android_numericShortcut));
            this.s = baVarA.a(androidx.appcompat.a.m.MenuItem_numericModifiers, 4096);
            if (baVarA.j(androidx.appcompat.a.m.MenuItem_android_checkable)) {
                this.t = baVarA.a(androidx.appcompat.a.m.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.t = this.g;
            }
            this.u = baVarA.a(androidx.appcompat.a.m.MenuItem_android_checked, false);
            this.v = baVarA.a(androidx.appcompat.a.m.MenuItem_android_visible, this.h);
            this.w = baVarA.a(androidx.appcompat.a.m.MenuItem_android_enabled, this.i);
            this.x = baVarA.a(androidx.appcompat.a.m.MenuItem_showAsAction, -1);
            this.B = baVarA.e(androidx.appcompat.a.m.MenuItem_android_onClick);
            this.y = baVarA.g(androidx.appcompat.a.m.MenuItem_actionLayout, 0);
            this.z = baVarA.e(androidx.appcompat.a.m.MenuItem_actionViewClass);
            this.A = baVarA.e(androidx.appcompat.a.m.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.f117a = (androidx.core.n.b) a(this.A, g.d, g.this.f);
            } else {
                if (z) {
                    Log.w(g.f115a, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f117a = null;
            }
            this.C = baVarA.d(androidx.appcompat.a.m.MenuItem_contentDescription);
            this.D = baVarA.d(androidx.appcompat.a.m.MenuItem_tooltipText);
            if (baVarA.j(androidx.appcompat.a.m.MenuItem_iconTintMode)) {
                this.F = af.a(baVarA.a(androidx.appcompat.a.m.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (baVarA.j(androidx.appcompat.a.m.MenuItem_iconTint)) {
                this.E = baVarA.g(androidx.appcompat.a.m.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            baVarA.f();
            this.j = false;
        }

        public SubMenu c() {
            this.j = true;
            SubMenu subMenuAddSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public boolean d() {
            return this.j;
        }
    }

    public g(Context context) {
        super(context);
        this.g = context;
        this.e = new Object[]{context};
        this.f = this.e;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals(h)) {
                    eventType = xmlPullParser.next();
                    break;
                }
                throw new RuntimeException("Expecting menu, got " + name);
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (next) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals(i)) {
                            bVar.a(attributeSet);
                        } else if (name2.equals(j)) {
                            bVar.b(attributeSet);
                        } else if (!name2.equals(h)) {
                            z2 = true;
                            str = name2;
                        } else {
                            a(xmlPullParser, attributeSet, bVar.c());
                        }
                    }
                    break;
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (z2 && name3.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name3.equals(i)) {
                        bVar.a();
                    } else if (!name3.equals(j)) {
                        if (name3.equals(h)) {
                            z = true;
                        }
                    } else if (!bVar.d()) {
                        if (bVar.f117a != null && bVar.f117a.c()) {
                            bVar.c();
                        } else {
                            bVar.b();
                        }
                    }
                    break;
            }
            next = xmlPullParser.next();
        }
    }

    Object a() {
        if (this.k == null) {
            this.k = a(this.g);
        }
        return this.k;
    }

    @Override // android.view.MenuInflater
    public void inflate(@ac int i2, Menu menu) throws Throwable {
        if (!(menu instanceof androidx.core.e.a.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser layout = this.g.getResources().getLayout(i2);
                try {
                    a(layout, Xml.asAttributeSet(layout), menu);
                    if (layout != null) {
                        layout.close();
                    }
                } catch (IOException e) {
                    e = e;
                    throw new InflateException("Error inflating menu XML", e);
                } catch (XmlPullParserException e2) {
                    e = e2;
                    throw new InflateException("Error inflating menu XML", e);
                } catch (Throwable th) {
                    th = th;
                    xmlResourceParser = layout;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (XmlPullParserException e4) {
            e = e4;
        }
    }
}
