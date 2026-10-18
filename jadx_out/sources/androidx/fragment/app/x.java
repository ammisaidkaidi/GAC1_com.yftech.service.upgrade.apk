package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class x extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f802a = 16711681;
    static final int b = 16711682;
    static final int c = 16711683;
    ListAdapter d;
    ListView e;
    View f;
    TextView g;
    View h;
    View i;
    CharSequence j;
    boolean k;
    private final Handler l = new Handler();
    private final Runnable m = new Runnable() { // from class: androidx.fragment.app.x.1
        @Override // java.lang.Runnable
        public void run() {
            x.this.e.focusableViewAvailable(x.this.e);
        }
    };
    private final AdapterView.OnItemClickListener an = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.x.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            x.this.a((ListView) adapterView, view, i, j);
        }
    };

    private void a(boolean z, boolean z2) {
        i();
        if (this.h == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            if (z2) {
                this.h.startAnimation(AnimationUtils.loadAnimation(y(), R.anim.fade_out));
                this.i.startAnimation(AnimationUtils.loadAnimation(y(), R.anim.fade_in));
            } else {
                this.h.clearAnimation();
                this.i.clearAnimation();
            }
            this.h.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        if (z2) {
            this.h.startAnimation(AnimationUtils.loadAnimation(y(), R.anim.fade_in));
            this.i.startAnimation(AnimationUtils.loadAnimation(y(), R.anim.fade_out));
        } else {
            this.h.clearAnimation();
            this.i.clearAnimation();
        }
        this.h.setVisibility(0);
        this.i.setVisibility(8);
    }

    private void i() {
        if (this.e != null) {
            return;
        }
        View viewX = X();
        if (viewX == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (viewX instanceof ListView) {
            this.e = (ListView) viewX;
        } else {
            this.g = (TextView) viewX.findViewById(f802a);
            if (this.g == null) {
                this.f = viewX.findViewById(R.id.empty);
            } else {
                this.g.setVisibility(8);
            }
            this.h = viewX.findViewById(b);
            this.i = viewX.findViewById(c);
            View viewFindViewById = viewX.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            this.e = (ListView) viewFindViewById;
            if (this.f != null) {
                this.e.setEmptyView(this.f);
            } else if (this.j != null) {
                this.g.setText(this.j);
                this.e.setEmptyView(this.g);
            }
        }
        this.k = true;
        this.e.setOnItemClickListener(this.an);
        if (this.d != null) {
            ListAdapter listAdapter = this.d;
            this.d = null;
            a(listAdapter);
        } else if (this.h != null) {
            a(false, false);
        }
        this.l.post(this.m);
    }

    public int a() {
        i();
        return this.e.getSelectedItemPosition();
    }

    @Override // androidx.fragment.app.d
    @ai
    public View a(@ah LayoutInflater layoutInflater, @ai ViewGroup viewGroup, @ai Bundle bundle) {
        Context contextZ = z();
        FrameLayout frameLayout = new FrameLayout(contextZ);
        LinearLayout linearLayout = new LinearLayout(contextZ);
        linearLayout.setId(b);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(contextZ, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(contextZ);
        frameLayout2.setId(c);
        TextView textView = new TextView(contextZ);
        textView.setId(f802a);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(contextZ);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.d
    public void a(@ah View view, @ai Bundle bundle) {
        super.a(view, bundle);
        i();
    }

    public void a(@ai ListAdapter listAdapter) {
        boolean z = this.d != null;
        this.d = listAdapter;
        if (this.e != null) {
            this.e.setAdapter(listAdapter);
            if (this.k || z) {
                return;
            }
            a(true, Y().getWindowToken() != null);
        }
    }

    public void a(@ah ListView listView, @ah View view, int i, long j) {
    }

    public void a(@ai CharSequence charSequence) {
        i();
        if (this.g == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        this.g.setText(charSequence);
        if (this.j == null) {
            this.e.setEmptyView(this.g);
        }
        this.j = charSequence;
    }

    public void a(boolean z) {
        a(z, true);
    }

    public long b() {
        i();
        return this.e.getSelectedItemId();
    }

    public void b(boolean z) {
        a(z, false);
    }

    @ah
    public ListView e() {
        i();
        return this.e;
    }

    public void e(int i) {
        i();
        this.e.setSelection(i);
    }

    @ai
    public ListAdapter g() {
        return this.d;
    }

    @ah
    public final ListAdapter h() {
        ListAdapter listAdapterG = g();
        if (listAdapterG != null) {
            return listAdapterG;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    @Override // androidx.fragment.app.d
    public void n() {
        this.l.removeCallbacks(this.m);
        this.e = null;
        this.k = false;
        this.i = null;
        this.h = null;
        this.f = null;
        this.g = null;
        super.n();
    }
}
