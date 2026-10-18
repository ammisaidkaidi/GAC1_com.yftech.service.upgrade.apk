package androidx.core.l;

import java.nio.CharBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.core.l.e f494a = new e(null, false);
    public static final androidx.core.l.e b = new e(null, true);
    public static final androidx.core.l.e c = new e(b.f496a, false);
    public static final androidx.core.l.e d = new e(b.f496a, true);
    public static final androidx.core.l.e e = new e(a.f495a, false);
    public static final androidx.core.l.e f = C0038f.f499a;
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;

    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f495a = new a(true);
        private final boolean b;

        private a(boolean z) {
            this.b = z;
        }

        @Override // androidx.core.l.f.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                switch (f.a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.b) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.b) {
                            return 1;
                        }
                        break;
                    default:
                        continue;
                        i++;
                        z = z;
                        break;
                }
                z = true;
                i++;
                z = z;
            }
            if (z) {
                return this.b ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f496a = new b();

        private b() {
        }

        @Override // androidx.core.l.f.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iB = 2;
            while (i < i3 && iB == 2) {
                iB = f.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iB;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static abstract class d implements androidx.core.l.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f497a;

        d(c cVar) {
            this.f497a = cVar;
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.f497a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }

        protected abstract boolean a();

        @Override // androidx.core.l.e
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f497a == null ? a() : b(charSequence, i, i2);
        }

        @Override // androidx.core.l.e
        public boolean a(char[] cArr, int i, int i2) {
            return a(CharBuffer.wrap(cArr), i, i2);
        }
    }

    private static class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f498a;

        e(c cVar, boolean z) {
            super(cVar);
            this.f498a = z;
        }

        @Override // androidx.core.l.f.d
        protected boolean a() {
            return this.f498a;
        }
    }

    /* JADX INFO: renamed from: androidx.core.l.f$f, reason: collision with other inner class name */
    private static class C0038f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0038f f499a = new C0038f();

        C0038f() {
            super(null);
        }

        @Override // androidx.core.l.f.d
        protected boolean a() {
            return g.a(Locale.getDefault()) == 1;
        }
    }

    private f() {
    }

    static int a(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int b(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                switch (i2) {
                    case 14:
                    case 15:
                        return 1;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
        }
    }
}
