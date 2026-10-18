package androidx.core.l.a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.core.m.g;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f486a = new String[0];
    private static final Comparator<a> b = new Comparator<a>() { // from class: androidx.core.l.a.b.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            if (aVar.c < aVar2.c) {
                return -1;
            }
            if (aVar.c <= aVar2.c && aVar.d >= aVar2.d) {
                return aVar.d > aVar2.d ? -1 : 0;
            }
            return 1;
        }
    };

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        URLSpan f487a;
        String b;
        int c;
        int d;

        a() {
        }
    }

    /* JADX INFO: renamed from: androidx.core.l.a.b$b, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface InterfaceC0036b {
    }

    private b() {
    }

    private static String a(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : androidx.core.l.a.a.c(str);
    }

    private static String a(@ah String str, @ah String[] strArr, Matcher matcher, @ai Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            z = true;
            if (i >= strArr.length) {
                z = false;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                    break;
                }
                break;
            }
            i++;
        }
        if (z || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void a(@ah TextView textView) {
        if ((textView.getMovementMethod() instanceof LinkMovementMethod) || !textView.getLinksClickable()) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void a(@ah TextView textView, @ah Pattern pattern, @ai String str) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            a(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void a(@ah TextView textView, @ah Pattern pattern, @ai String str, @ai Linkify.MatchFilter matchFilter, @ai Linkify.TransformFilter transformFilter) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            a(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(@ah TextView textView, @ah Pattern pattern, @ai String str, @ai String[] strArr, @ai Linkify.MatchFilter matchFilter, @ai Linkify.TransformFilter transformFilter) {
        if (a()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(textView.getText());
        if (a(spannableStringValueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            a(textView);
        }
    }

    private static void a(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static void a(ArrayList<a> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strA = a(string);
                if (strA != null && (iIndexOf = string.indexOf(strA)) >= 0) {
                    a aVar = new a();
                    int length = strA.length() + iIndexOf;
                    aVar.c = iIndexOf + i;
                    i += length;
                    aVar.d = i;
                    string = string.substring(length);
                    try {
                        aVar.b = "geo:0,0?q=" + URLEncoder.encode(strA, "UTF-8");
                        arrayList.add(aVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static void a(ArrayList<a> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                a aVar = new a();
                aVar.b = a(matcher.group(0), strArr, matcher, transformFilter);
                aVar.c = iStart;
                aVar.d = iEnd;
                arrayList.add(aVar);
            }
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean a(@ah Spannable spannable, int i) {
        if (a()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList<a> arrayList = new ArrayList();
        if ((i & 1) != 0) {
            a((ArrayList<a>) arrayList, spannable, g.e, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i & 2) != 0) {
            a((ArrayList<a>) arrayList, spannable, g.f, new String[]{"mailto:"}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i & 8) != 0) {
            a((ArrayList<a>) arrayList, spannable);
        }
        b(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        for (a aVar : arrayList) {
            if (aVar.f487a == null) {
                a(aVar.b, aVar.c, aVar.d, spannable);
            }
        }
        return true;
    }

    public static boolean a(@ah Spannable spannable, @ah Pattern pattern, @ai String str) {
        return a() ? Linkify.addLinks(spannable, pattern, str) : a(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean a(@ah Spannable spannable, @ah Pattern pattern, @ai String str, @ai Linkify.MatchFilter matchFilter, @ai Linkify.TransformFilter transformFilter) {
        return a() ? Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter) : a(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean a(@ah Spannable spannable, @ah Pattern pattern, @ai String str, @ai String[] strArr, @ai Linkify.MatchFilter matchFilter, @ai Linkify.TransformFilter transformFilter) {
        if (a()) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = com.yftech.service.upgrade.a.d;
        }
        if (strArr == null || strArr.length < 1) {
            strArr = f486a;
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str2 = strArr[i];
            i++;
            strArr2[i] = str2 == null ? com.yftech.service.upgrade.a.d : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                a(a(matcher.group(0), strArr2, matcher, transformFilter), iStart, iEnd, spannable);
                z = true;
            }
        }
        return z;
    }

    public static boolean a(@ah TextView textView, int i) {
        if (a()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!a((Spannable) text, i)) {
                return false;
            }
            a(textView);
            return true;
        }
        SpannableString spannableStringValueOf = SpannableString.valueOf(text);
        if (!a(spannableStringValueOf, i)) {
            return false;
        }
        a(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    private static void b(ArrayList<a> arrayList, Spannable spannable) {
        int i = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i2 = 0; i2 < uRLSpanArr.length; i2++) {
            a aVar = new a();
            aVar.f487a = uRLSpanArr[i2];
            aVar.c = spannable.getSpanStart(uRLSpanArr[i2]);
            aVar.d = spannable.getSpanEnd(uRLSpanArr[i2]);
            arrayList.add(aVar);
        }
        Collections.sort(arrayList, b);
        int size = arrayList.size();
        while (i < size - 1) {
            a aVar2 = arrayList.get(i);
            int i3 = i + 1;
            a aVar3 = arrayList.get(i3);
            if (aVar2.c <= aVar3.c && aVar2.d > aVar3.c) {
                int i4 = (aVar3.d > aVar2.d && aVar2.d - aVar2.c <= aVar3.d - aVar3.c) ? aVar2.d - aVar2.c < aVar3.d - aVar3.c ? i : -1 : i3;
                if (i4 != -1) {
                    Object obj = arrayList.get(i4).f487a;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i4);
                    size--;
                }
            }
            i = i3;
        }
    }
}
