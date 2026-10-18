package androidx.core.l;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final char d = 8234;
    private static final char e = 8235;
    private static final char f = 8236;
    private static final String k = "";
    private static final int l = 2;
    private static final int m = 2;
    private static final int q = -1;
    private static final int r = 0;
    private static final int s = 1;
    private final boolean n;
    private final int o;
    private final e p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f481a = f.c;
    private static final char g = 8206;
    private static final String i = Character.toString(g);
    private static final char h = 8207;
    private static final String j = Character.toString(h);
    static final a b = new a(false, 2, f481a);
    static final a c = new a(true, 2, f481a);

    /* JADX INFO: renamed from: androidx.core.l.a$a, reason: collision with other inner class name */
    public static final class C0034a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f482a;
        private int b;
        private e c;

        public C0034a() {
            b(a.b(Locale.getDefault()));
        }

        public C0034a(Locale locale) {
            b(a.b(locale));
        }

        public C0034a(boolean z) {
            b(z);
        }

        private void b(boolean z) {
            this.f482a = z;
            this.c = a.f481a;
            this.b = 2;
        }

        private static a c(boolean z) {
            return z ? a.c : a.b;
        }

        public C0034a a(e eVar) {
            this.c = eVar;
            return this;
        }

        public C0034a a(boolean z) {
            if (z) {
                this.b |= 2;
            } else {
                this.b &= -3;
            }
            return this;
        }

        public a a() {
            return (this.b == 2 && this.c == a.f481a) ? c(this.f482a) : new a(this.f482a, this.b, this.c);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f483a = 1792;
        private static final byte[] b = new byte[f483a];
        private final CharSequence c;
        private final boolean d;
        private final int e;
        private int f;
        private char g;

        static {
            for (int i = 0; i < f483a; i++) {
                b[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.c = charSequence;
            this.d = z;
            this.e = charSequence.length();
        }

        private static byte a(char c) {
            return c < f483a ? b[c] : Character.getDirectionality(c);
        }

        private byte e() {
            int i = this.f;
            while (this.f < this.e) {
                CharSequence charSequence = this.c;
                int i2 = this.f;
                this.f = i2 + 1;
                this.g = charSequence.charAt(i2);
                if (this.g == '>') {
                    return (byte) 12;
                }
                if (this.g == '\"' || this.g == '\'') {
                    char c = this.g;
                    while (this.f < this.e) {
                        CharSequence charSequence2 = this.c;
                        int i3 = this.f;
                        this.f = i3 + 1;
                        char cCharAt = charSequence2.charAt(i3);
                        this.g = cCharAt;
                        if (cCharAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f = i;
            this.g = '<';
            return (byte) 13;
        }

        private byte f() {
            int i = this.f;
            while (this.f > 0) {
                CharSequence charSequence = this.c;
                int i2 = this.f - 1;
                this.f = i2;
                this.g = charSequence.charAt(i2);
                if (this.g == '<') {
                    return (byte) 12;
                }
                if (this.g == '>') {
                    break;
                }
                if (this.g == '\"' || this.g == '\'') {
                    char c = this.g;
                    while (this.f > 0) {
                        CharSequence charSequence2 = this.c;
                        int i3 = this.f - 1;
                        this.f = i3;
                        char cCharAt = charSequence2.charAt(i3);
                        this.g = cCharAt;
                        if (cCharAt == c) {
                            break;
                        }
                    }
                }
            }
            this.f = i;
            this.g = '>';
            return (byte) 13;
        }

        private byte g() {
            while (this.f < this.e) {
                CharSequence charSequence = this.c;
                int i = this.f;
                this.f = i + 1;
                char cCharAt = charSequence.charAt(i);
                this.g = cCharAt;
                if (cCharAt == ';') {
                    return (byte) 12;
                }
            }
            return (byte) 12;
        }

        private byte h() {
            int i = this.f;
            while (this.f > 0) {
                CharSequence charSequence = this.c;
                int i2 = this.f - 1;
                this.f = i2;
                this.g = charSequence.charAt(i2);
                if (this.g == '&') {
                    return (byte) 12;
                }
                if (this.g == ';') {
                    break;
                }
            }
            this.f = i;
            this.g = ';';
            return (byte) 13;
        }

        int a() {
            this.f = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f < this.e && i == 0) {
                byte bC = c();
                if (bC != 9) {
                    switch (bC) {
                        case 0:
                            if (i3 == 0) {
                                return -1;
                            }
                            i = i3;
                            break;
                        case 1:
                        case 2:
                            if (i3 == 0) {
                                return 1;
                            }
                            i = i3;
                            break;
                        default:
                            switch (bC) {
                                case 14:
                                case 15:
                                    i3++;
                                    i2 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i3++;
                                    i2 = 1;
                                    continue;
                                case 18:
                                    i3--;
                                    i2 = 0;
                                    continue;
                            }
                            i = i3;
                            break;
                    }
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        i3--;
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        i3--;
                        break;
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        int b() {
            this.f = this.e;
            int i = 0;
            int i2 = 0;
            while (this.f > 0) {
                byte bD = d();
                if (bD != 9) {
                    switch (bD) {
                        case 0:
                            if (i2 == 0) {
                                return -1;
                            }
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                        case 1:
                        case 2:
                            if (i2 == 0) {
                                return 1;
                            }
                            if (i == 0) {
                                i = i2;
                            }
                            break;
                        default:
                            switch (bD) {
                                case 14:
                                case 15:
                                    if (i == i2) {
                                        return -1;
                                    }
                                    i2--;
                                    continue;
                                    break;
                                case 16:
                                case 17:
                                    if (i == i2) {
                                        return 1;
                                    }
                                    i2--;
                                    continue;
                                    break;
                                case 18:
                                    i2++;
                                    continue;
                                default:
                                    if (i != 0) {
                                    }
                                    break;
                            }
                            i = i2;
                            break;
                    }
                }
            }
            return 0;
        }

        byte c() {
            this.g = this.c.charAt(this.f);
            if (Character.isHighSurrogate(this.g)) {
                int iCodePointAt = Character.codePointAt(this.c, this.f);
                this.f += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f++;
            byte bA = a(this.g);
            if (!this.d) {
                return bA;
            }
            if (this.g == '<') {
                return e();
            }
            return this.g == '&' ? g() : bA;
        }

        byte d() {
            this.g = this.c.charAt(this.f - 1);
            if (Character.isLowSurrogate(this.g)) {
                int iCodePointBefore = Character.codePointBefore(this.c, this.f);
                this.f -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f--;
            byte bA = a(this.g);
            if (!this.d) {
                return bA;
            }
            if (this.g == '>') {
                return f();
            }
            return this.g == ';' ? h() : bA;
        }
    }

    a(boolean z, int i2, e eVar) {
        this.n = z;
        this.o = i2;
        this.p = eVar;
    }

    public static a a() {
        return new C0034a().a();
    }

    public static a a(Locale locale) {
        return new C0034a(locale).a();
    }

    public static a a(boolean z) {
        return new C0034a(z).a();
    }

    private String b(CharSequence charSequence, e eVar) {
        boolean zA = eVar.a(charSequence, 0, charSequence.length());
        if (!this.n && (zA || c(charSequence) == 1)) {
            return i;
        }
        if (this.n) {
            return (!zA || c(charSequence) == -1) ? j : "";
        }
        return "";
    }

    static boolean b(Locale locale) {
        return g.a(locale) == 1;
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).b();
    }

    private String c(CharSequence charSequence, e eVar) {
        boolean zA = eVar.a(charSequence, 0, charSequence.length());
        if (!this.n && (zA || d(charSequence) == 1)) {
            return i;
        }
        if (this.n) {
            return (!zA || d(charSequence) == -1) ? j : "";
        }
        return "";
    }

    private static int d(CharSequence charSequence) {
        return new b(charSequence, false).a();
    }

    public CharSequence a(CharSequence charSequence, e eVar) {
        return a(charSequence, eVar, true);
    }

    public CharSequence a(CharSequence charSequence, e eVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = eVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (c() && z) {
            spannableStringBuilder.append((CharSequence) c(charSequence, zA ? f.b : f.f494a));
        }
        if (zA != this.n) {
            spannableStringBuilder.append(zA ? e : d);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(f);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, zA ? f.b : f.f494a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence, boolean z) {
        return a(charSequence, this.p, z);
    }

    public String a(String str, e eVar) {
        return a(str, eVar, true);
    }

    public String a(String str, e eVar, boolean z) {
        if (str == null) {
            return null;
        }
        return a((CharSequence) str, eVar, z).toString();
    }

    public String a(String str, boolean z) {
        return a(str, this.p, z);
    }

    public boolean a(CharSequence charSequence) {
        return this.p.a(charSequence, 0, charSequence.length());
    }

    public boolean a(String str) {
        return a((CharSequence) str);
    }

    public CharSequence b(CharSequence charSequence) {
        return a(charSequence, this.p, true);
    }

    public String b(String str) {
        return a(str, this.p, true);
    }

    public boolean b() {
        return this.n;
    }

    public boolean c() {
        return (this.o & 2) != 0;
    }
}
