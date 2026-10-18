package androidx.core.b;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.u;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class d extends ContentProvider {
    private static final String b = "android.support.FILE_PROVIDER_PATHS";
    private static final String c = "root-path";
    private static final String d = "files-path";
    private static final String e = "cache-path";
    private static final String f = "external-path";
    private static final String g = "external-files-path";
    private static final String h = "external-cache-path";
    private static final String i = "external-media-path";
    private static final String j = "name";
    private static final String k = "path";
    private a n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f413a = {"_display_name", "_size"};
    private static final File l = new File("/");

    @u(a = "sCache")
    private static HashMap<String, a> m = new HashMap<>();

    interface a {
        Uri a(File file);

        File a(Uri uri);
    }

    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f414a;
        private final HashMap<String, File> b = new HashMap<>();

        b(String str) {
            this.f414a = str;
        }

        @Override // androidx.core.b.d.a
        public Uri a(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f414a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // androidx.core.b.d.a
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        void a(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.b.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }
    }

    private static int a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static Uri a(@ah Context context, @ah String str, @ah File file) {
        return a(context, str).a(file);
    }

    private static a a(Context context, String str) {
        a aVarB;
        synchronized (m) {
            aVarB = m.get(str);
            if (aVarB == null) {
                try {
                    aVarB = b(context, str);
                    m.put(str, aVarB);
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (XmlPullParserException e3) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                }
            }
        }
        return aVarB;
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static Object[] a(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }

    private static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    private static a b(Context context, String str) {
        b bVar = new b(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), b);
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, j);
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, k);
                if (c.equals(name)) {
                    externalStorageDirectory = l;
                } else if (d.equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if (e.equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if (f.equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if (g.equals(name)) {
                    File[] fileArrA = c.a(context, (String) null);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                } else if (h.equals(name)) {
                    File[] fileArrC = c.c(context);
                    if (fileArrC.length > 0) {
                        externalStorageDirectory = fileArrC[0];
                    }
                } else if (Build.VERSION.SDK_INT >= 21 && i.equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    bVar.a(attributeValue, a(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@ah Context context, @ah ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.n = a(context, providerInfo.authority);
    }

    @Override // android.content.ContentProvider
    public int delete(@ah Uri uri, @ai String str, @ai String[] strArr) {
        return this.n.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@ah Uri uri) {
        File fileA = this.n.a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(@ah Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(@ah Uri uri, @ah String str) {
        return ParcelFileDescriptor.open(this.n.a(uri), a(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(@ah Uri uri, @ai String[] strArr, @ai String str, @ai String[] strArr2, @ai String str2) {
        int i2;
        File fileA = this.n.a(uri);
        if (strArr == null) {
            strArr = f413a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = fileA.getName();
            } else {
                if ("_size".equals(str3)) {
                    strArr3[i3] = "_size";
                    i2 = i3 + 1;
                    objArr[i3] = Long.valueOf(fileA.length());
                }
            }
            i3 = i2;
        }
        String[] strArrA = a(strArr3, i3);
        Object[] objArrA = a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArrA, 1);
        matrixCursor.addRow(objArrA);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@ah Uri uri, ContentValues contentValues, @ai String str, @ai String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
