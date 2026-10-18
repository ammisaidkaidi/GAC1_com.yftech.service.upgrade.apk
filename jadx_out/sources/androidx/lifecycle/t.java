package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks2;
import android.os.Bundle;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public class t extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f976a = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private a b;

    interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag(f976a) == null) {
            fragmentManager.beginTransaction().add(new t(), f976a).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a(g.a aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof l) {
            ((l) activity).a().a(aVar);
        } else if (activity instanceof j) {
            g gVarC = ((j) activity).c();
            if (gVarC instanceof k) {
                ((k) gVarC).a(aVar);
            }
        }
    }

    static t b(Activity activity) {
        return (t) activity.getFragmentManager().findFragmentByTag(f976a);
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void d(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    void a(a aVar) {
        this.b = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.b);
        a(g.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(g.a.ON_DESTROY);
        this.b = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(g.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.b);
        a(g.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.b);
        a(g.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(g.a.ON_STOP);
    }
}
