package androidx.core.b;

import android.content.SharedPreferences;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class h {

    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f417a;
        private final C0029a b = new C0029a();

        /* JADX INFO: renamed from: androidx.core.b.h$a$a, reason: collision with other inner class name */
        private static class C0029a {
            C0029a() {
            }

            public void a(@ah SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private a() {
        }

        @Deprecated
        public static a a() {
            if (f417a == null) {
                f417a = new a();
            }
            return f417a;
        }

        @Deprecated
        public void a(@ah SharedPreferences.Editor editor) {
            this.b.a(editor);
        }
    }

    private h() {
    }
}
