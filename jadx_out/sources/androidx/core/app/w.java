package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f386a = "android.remoteinput.results";
    public static final String b = "android.remoteinput.resultsData";
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    private static final String h = "RemoteInput";
    private static final String i = "android.remoteinput.dataTypeResultsData";
    private static final String j = "android.remoteinput.resultsSource";
    private final String k;
    private final CharSequence l;
    private final CharSequence[] m;
    private final boolean n;
    private final int o;
    private final Bundle p;
    private final Set<String> q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f387a;
        private CharSequence d;
        private CharSequence[] e;
        private final Set<String> b = new HashSet();
        private final Bundle c = new Bundle();
        private boolean f = true;
        private int g = 0;

        public a(@ah String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f387a = str;
        }

        @ah
        public Bundle a() {
            return this.c;
        }

        @ah
        public a a(int i) {
            this.g = i;
            return this;
        }

        @ah
        public a a(@ah Bundle bundle) {
            if (bundle != null) {
                this.c.putAll(bundle);
            }
            return this;
        }

        @ah
        public a a(@ai CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        @ah
        public a a(@ah String str, boolean z) {
            if (z) {
                this.b.add(str);
            } else {
                this.b.remove(str);
            }
            return this;
        }

        @ah
        public a a(boolean z) {
            this.f = z;
            return this;
        }

        @ah
        public a a(@ai CharSequence[] charSequenceArr) {
            this.e = charSequenceArr;
            return this;
        }

        @ah
        public w b() {
            return new w(this.f387a, this.d, this.e, this.f, this.g, this.c, this.b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    @ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    w(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i2, Bundle bundle, Set<String> set) {
        this.k = str;
        this.l = charSequence;
        this.m = charSequenceArr;
        this.n = z;
        this.o = i2;
        this.p = bundle;
        this.q = set;
        if (g() == 2 && !f()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    @am(a = 20)
    static RemoteInput a(w wVar) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(wVar.a()).setLabel(wVar.b()).setChoices(wVar.c()).setAllowFreeFormInput(wVar.f()).addExtras(wVar.h());
        if (Build.VERSION.SDK_INT >= 29) {
            builderAddExtras.setEditChoicesBeforeSending(wVar.g());
        }
        return builderAddExtras.build();
    }

    public static Bundle a(Intent intent) {
        Intent intentC;
        if (Build.VERSION.SDK_INT >= 20) {
            return RemoteInput.getResultsFromIntent(intent);
        }
        if (Build.VERSION.SDK_INT < 16 || (intentC = c(intent)) == null) {
            return null;
        }
        return (Bundle) intentC.getExtras().getParcelable(b);
    }

    private static String a(String str) {
        return i + str;
    }

    public static Map<String, Uri> a(Intent intent, String str) {
        Intent intentC;
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }
        if (Build.VERSION.SDK_INT < 16 || (intentC = c(intent)) == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str2 : intentC.getExtras().keySet()) {
            if (str2.startsWith(i)) {
                String strSubstring = str2.substring(i.length());
                if (!strSubstring.isEmpty() && (string = intentC.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    map.put(strSubstring, Uri.parse(string));
                }
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public static void a(@ah Intent intent, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            RemoteInput.setResultsSource(intent, i2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Intent intentC = c(intent);
            if (intentC == null) {
                intentC = new Intent();
            }
            intentC.putExtra(j, i2);
            intent.setClipData(ClipData.newIntent(f386a, intentC));
        }
    }

    public static void a(w wVar, Intent intent, Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            RemoteInput.addDataResultToIntent(a(wVar), intent, map);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Intent intentC = c(intent);
            if (intentC == null) {
                intentC = new Intent();
            }
            for (Map.Entry<String, Uri> entry : map.entrySet()) {
                String key = entry.getKey();
                Uri value = entry.getValue();
                if (key != null) {
                    Bundle bundleExtra = intentC.getBundleExtra(a(key));
                    if (bundleExtra == null) {
                        bundleExtra = new Bundle();
                    }
                    bundleExtra.putString(wVar.a(), value.toString());
                    intentC.putExtra(a(key), bundleExtra);
                }
            }
            intent.setClipData(ClipData.newIntent(f386a, intentC));
        }
    }

    public static void a(w[] wVarArr, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            RemoteInput.addResultsToIntent(a(wVarArr), intent, bundle);
            return;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            Bundle bundleA = a(intent);
            int iB = b(intent);
            if (bundleA != null) {
                bundleA.putAll(bundle);
                bundle = bundleA;
            }
            for (w wVar : wVarArr) {
                Map<String, Uri> mapA = a(intent, wVar.a());
                RemoteInput.addResultsToIntent(a(new w[]{wVar}), intent, bundle);
                if (mapA != null) {
                    a(wVar, intent, mapA);
                }
            }
            a(intent, iB);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Intent intentC = c(intent);
            if (intentC == null) {
                intentC = new Intent();
            }
            Bundle bundleExtra = intentC.getBundleExtra(b);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            for (w wVar2 : wVarArr) {
                Object obj = bundle.get(wVar2.a());
                if (obj instanceof CharSequence) {
                    bundleExtra.putCharSequence(wVar2.a(), (CharSequence) obj);
                }
            }
            intentC.putExtra(b, bundleExtra);
            intent.setClipData(ClipData.newIntent(f386a, intentC));
        }
    }

    @am(a = 20)
    static RemoteInput[] a(w[] wVarArr) {
        if (wVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[wVarArr.length];
        for (int i2 = 0; i2 < wVarArr.length; i2++) {
            remoteInputArr[i2] = a(wVarArr[i2]);
        }
        return remoteInputArr;
    }

    public static int b(@ah Intent intent) {
        Intent intentC;
        if (Build.VERSION.SDK_INT >= 28) {
            return RemoteInput.getResultsSource(intent);
        }
        if (Build.VERSION.SDK_INT < 16 || (intentC = c(intent)) == null) {
            return 0;
        }
        return intentC.getExtras().getInt(j, 0);
    }

    @am(a = 16)
    private static Intent c(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(f386a)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    public String a() {
        return this.k;
    }

    public CharSequence b() {
        return this.l;
    }

    public CharSequence[] c() {
        return this.m;
    }

    public Set<String> d() {
        return this.q;
    }

    public boolean e() {
        return (f() || (c() != null && c().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }

    public boolean f() {
        return this.n;
    }

    public int g() {
        return this.o;
    }

    public Bundle h() {
        return this.p;
    }
}
