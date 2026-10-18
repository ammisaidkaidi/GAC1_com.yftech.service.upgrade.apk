package androidx.core.n.a;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
public interface g {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Bundle f523a;

        @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
        public void a(Bundle bundle) {
            this.f523a = bundle;
        }
    }

    public static final class b extends a {
        public int a() {
            return this.f523a.getInt(androidx.core.n.a.d.x);
        }

        public boolean b() {
            return this.f523a.getBoolean(androidx.core.n.a.d.z);
        }
    }

    public static final class c extends a {
        public String a() {
            return this.f523a.getString(androidx.core.n.a.d.y);
        }
    }

    public static final class d extends a {
        public int a() {
            return this.f523a.getInt(androidx.core.n.a.d.G);
        }

        public int b() {
            return this.f523a.getInt(androidx.core.n.a.d.H);
        }
    }

    public static final class e extends a {
        public int a() {
            return this.f523a.getInt(androidx.core.n.a.d.D);
        }

        public int b() {
            return this.f523a.getInt(androidx.core.n.a.d.E);
        }
    }

    public static final class f extends a {
        public float a() {
            return this.f523a.getFloat(androidx.core.n.a.d.F);
        }
    }

    /* JADX INFO: renamed from: androidx.core.n.a.g$g, reason: collision with other inner class name */
    public static final class C0042g extends a {
        public int a() {
            return this.f523a.getInt(androidx.core.n.a.d.A);
        }

        public int b() {
            return this.f523a.getInt(androidx.core.n.a.d.B);
        }
    }

    public static final class h extends a {
        public CharSequence a() {
            return this.f523a.getCharSequence(androidx.core.n.a.d.C);
        }
    }

    boolean a(@ah View view, @ai a aVar);
}
