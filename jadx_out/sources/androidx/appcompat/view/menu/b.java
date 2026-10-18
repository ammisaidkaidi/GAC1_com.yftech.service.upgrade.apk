package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public abstract class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f125a;
    protected Context b;
    protected g c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected o f;
    private n.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int i, int i2) {
        this.f125a = context;
        this.d = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(j jVar, View view, ViewGroup viewGroup) {
        o.a aVarB = view instanceof o.a ? (o.a) view : b(viewGroup);
        a(jVar, aVarB);
        return (View) aVarB;
    }

    public n.a a() {
        return this.g;
    }

    @Override // androidx.appcompat.view.menu.n
    public o a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (o) this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            a(true);
        }
        return this.f;
    }

    public void a(int i) {
        this.j = i;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(Context context, g gVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = gVar;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(g gVar, boolean z) {
        if (this.g != null) {
            this.g.a(gVar, z);
        }
    }

    public abstract void a(j jVar, o.a aVar);

    @Override // androidx.appcompat.view.menu.n
    public void a(n.a aVar) {
        this.g = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.n
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return;
        }
        int i = 0;
        if (this.c != null) {
            this.c.l();
            ArrayList<j> arrayListK = this.c.k();
            int size = arrayListK.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                j jVar = arrayListK.get(i3);
                if (a(i2, jVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    j itemData = childAt instanceof o.a ? ((o.a) childAt).getItemData() : null;
                    View viewA = a(jVar, childAt, viewGroup);
                    if (jVar != itemData) {
                        viewA.setPressed(false);
                        viewA.jumpDrawablesToCurrentState();
                    }
                    if (viewA != childAt) {
                        a(viewA, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    public boolean a(int i, j jVar) {
        return true;
    }

    protected boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean a(g gVar, j jVar) {
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.n
    public boolean a(s sVar) {
        g gVar;
        if (this.g == null) {
            return false;
        }
        n.a aVar = this.g;
        if (sVar == null) {
            gVar = sVar;
            gVar = this.c;
        }
        gVar = sVar;
        return aVar.a(gVar);
    }

    public o.a b(ViewGroup viewGroup) {
        return (o.a) this.d.inflate(this.i, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public int c() {
        return this.j;
    }
}
