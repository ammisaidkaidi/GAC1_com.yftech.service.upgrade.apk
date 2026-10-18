package androidx.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View[] f715a;
    private HashMap<Integer, String> b;
    protected int[] p;
    protected int q;
    protected Context r;
    protected androidx.d.c.b.i s;
    protected boolean t;
    protected String u;
    protected String v;

    public c(Context context) {
        super(context);
        this.p = new int[32];
        this.t = false;
        this.f715a = null;
        this.b = new HashMap<>();
        this.r = context;
        a((AttributeSet) null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = new int[32];
        this.t = false;
        this.f715a = null;
        this.b = new HashMap<>();
        this.r = context;
        a(attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new int[32];
        this.t = false;
        this.f715a = null;
        this.b = new HashMap<>();
        this.r = context;
        a(attributeSet);
    }

    private int a(d dVar, String str) {
        Resources resources;
        if (str == null || dVar == null || (resources = this.r.getResources()) == null) {
            return 0;
        }
        int childCount = dVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dVar.getChildAt(i);
            if (childAt.getId() != -1) {
                String resourceEntryName = null;
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private void a(int i) {
        if (i == getId()) {
            return;
        }
        if (this.q + 1 > this.p.length) {
            this.p = Arrays.copyOf(this.p, this.p.length * 2);
        }
        this.p[this.q] = i;
        this.q++;
    }

    private void a(String str) {
        if (str == null || str.length() == 0 || this.r == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof d) {
        }
        int iC = c(strTrim);
        if (iC != 0) {
            this.b.put(Integer.valueOf(iC), strTrim);
            a(iC);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private int[] a(View view, String str) {
        String[] strArrSplit = str.split(",");
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        for (String str2 : strArrSplit) {
            int iC = c(str2.trim());
            if (iC != 0) {
                iArr[i] = iC;
                i++;
            }
        }
        return i != strArrSplit.length ? Arrays.copyOf(iArr, i) : iArr;
    }

    private void b(String str) {
        if (str == null || str.length() == 0 || this.r == null) {
            return;
        }
        String strTrim = str.trim();
        d dVar = getParent() instanceof d ? (d) getParent() : null;
        if (dVar == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = dVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dVar.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof d.a) && strTrim.equals(((d.a) layoutParams).an)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    a(childAt.getId());
                }
            }
        }
    }

    private int c(String str) {
        int i;
        d dVar = getParent() instanceof d ? (d) getParent() : null;
        int iA = 0;
        if (isInEditMode() && dVar != null) {
            Object objA = dVar.a(0, str);
            if (objA instanceof Integer) {
                iA = ((Integer) objA).intValue();
            }
        }
        if (iA == 0 && dVar != null) {
            iA = a(dVar, str);
        }
        if (iA == 0) {
            try {
                i = m.g.class.getField(str).getInt(null);
            } catch (Exception unused) {
                i = iA;
            }
        } else {
            i = iA;
        }
        return i == 0 ? this.r.getResources().getIdentifier(str, "id", this.r.getPackageName()) : i;
    }

    protected void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.C0052m.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == m.C0052m.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.u = typedArrayObtainStyledAttributes.getString(index);
                    setIds(this.u);
                } else if (index == m.C0052m.ConstraintLayout_Layout_constraint_referenced_tags) {
                    this.v = typedArrayObtainStyledAttributes.getString(index);
                    setReferenceTags(this.v);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void a(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.u = null;
            a(view.getId());
            requestLayout();
        }
    }

    public void a(androidx.d.c.b.e eVar, boolean z) {
    }

    public void a(androidx.d.c.b.f fVar, androidx.d.c.b.i iVar, SparseArray<androidx.d.c.b.e> sparseArray) {
        iVar.j();
        for (int i = 0; i < this.q; i++) {
            iVar.a(sparseArray.get(this.p[i]));
        }
    }

    public void a(d dVar) {
    }

    public void a(g.a aVar, androidx.d.c.b.j jVar, d.a aVar2, SparseArray<androidx.d.c.b.e> sparseArray) {
        if (aVar.d.af != null) {
            setReferencedIds(aVar.d.af);
        } else if (aVar.d.ag != null && aVar.d.ag.length() > 0) {
            aVar.d.af = a(this, aVar.d.ag);
        }
        jVar.j();
        if (aVar.d.af != null) {
            for (int i = 0; i < aVar.d.af.length; i++) {
                androidx.d.c.b.e eVar = sparseArray.get(aVar.d.af[i]);
                if (eVar != null) {
                    jVar.a(eVar);
                }
            }
        }
    }

    public void b(View view) {
        int id = view.getId();
        if (id == -1) {
            return;
        }
        this.u = null;
        int i = 0;
        while (i < this.q) {
            if (this.p[i] == id) {
                while (i < this.q - 1) {
                    int i2 = i + 1;
                    this.p[i] = this.p[i2];
                    i = i2;
                }
                this.p[this.q - 1] = 0;
                this.q--;
                break;
            }
            i++;
        }
        requestLayout();
    }

    public void b(d dVar) {
    }

    public void c() {
        if (this.s == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof d.a) {
            ((d.a) layoutParams).aF = (androidx.d.c.b.e) this.s;
        }
    }

    protected void c(d dVar) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i = 0; i < this.q; i++) {
            View viewG = dVar.g(this.p[i]);
            if (viewG != null) {
                viewG.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewG.setTranslationZ(viewG.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof d)) {
            return;
        }
        c((d) parent);
    }

    public void d(d dVar) {
        String str;
        int iA;
        if (isInEditMode()) {
            setIds(this.u);
        }
        if (this.s == null) {
            return;
        }
        this.s.j();
        for (int i = 0; i < this.q; i++) {
            int i2 = this.p[i];
            View viewG = dVar.g(i2);
            if (viewG == null && (iA = a(dVar, (str = this.b.get(Integer.valueOf(i2))))) != 0) {
                this.p[i] = iA;
                this.b.put(Integer.valueOf(iA), str);
                viewG = dVar.g(iA);
            }
            if (viewG != null) {
                this.s.a(dVar.a(viewG));
            }
        }
        this.s.a(dVar.ad);
    }

    protected View[] e(d dVar) {
        if (this.f715a == null || this.f715a.length != this.q) {
            this.f715a = new View[this.q];
        }
        for (int i = 0; i < this.q; i++) {
            this.f715a[i] = dVar.g(this.p[i]);
        }
        return this.f715a;
    }

    public void f(d dVar) {
    }

    public void g(d dVar) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.p, this.q);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u != null) {
            setIds(this.u);
        }
        if (this.v != null) {
            setReferenceTags(this.v);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.t) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void setIds(String str) {
        this.u = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.v = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i);
            if (iIndexOf == -1) {
                b(str.substring(i));
                return;
            } else {
                b(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.u = null;
        this.q = 0;
        for (int i : iArr) {
            a(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.u == null) {
            a(i);
        }
    }
}
