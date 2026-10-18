package androidx.core.l;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Locale f500a = new Locale(com.yftech.service.upgrade.a.d, com.yftech.service.upgrade.a.d);
    private static final String b = "Arab";
    private static final String c = "Hebr";

    private g() {
    }

    public static int a(@ai Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f500a)) {
            return 0;
        }
        String strA = c.a(locale);
        if (strA == null) {
            return b(locale);
        }
        return (strA.equalsIgnoreCase(b) || strA.equalsIgnoreCase(c)) ? 1 : 0;
    }

    @ah
    public static String a(@ah String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.htmlEncode(str);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("&quot;");
            } else if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt != '>') {
                switch (cCharAt) {
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    default:
                        sb.append(cCharAt);
                        break;
                }
            } else {
                sb.append("&gt;");
            }
        }
        return sb.toString();
    }

    private static int b(@ah Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
