package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ap;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@am(a = 29)
@ap(a = {ap.a.LIBRARY_GROUP})
public class p extends q {
    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001b A[Catch: IOException -> 0x005b, PHI: r3
      0x001b: PHI (r3v5 android.graphics.fonts.FontFamily$Builder) = (r3v3 android.graphics.fonts.FontFamily$Builder), (r3v1 android.graphics.fonts.FontFamily$Builder) binds: [B:14:0x004c, B:7:0x0019] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {IOException -> 0x005b, blocks: (B:5:0x000d, B:8:0x001b, B:10:0x001f, B:12:0x0042, B:13:0x0049, B:18:0x0052, B:22:0x005a, B:21:0x0057), top: B:40:0x000d, inners: #0, #1 }] */
    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, @ai CancellationSignal cancellationSignal, @ah androidx.core.j.b.c[] cVarArr, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        FontFamily.Builder builder = null;
        for (androidx.core.j.b.c cVar : cVarArr) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(cVar.a(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(cVar.c()).setSlant(cVar.d() ? 1 : 0).setTtcIndex(cVar.b()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                    } catch (Throwable th) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } else if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
            } catch (IOException unused) {
            }
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.q
    @ai
    public Typeface a(Context context, androidx.core.b.b.d.c cVar, Resources resources, int i) {
        FontFamily.Builder builder = null;
        for (androidx.core.b.b.d.C0027d c0027d : cVar.a()) {
            try {
                Font fontBuild = new Font.Builder(resources, c0027d.f()).setWeight(c0027d.b()).setSlant(c0027d.c() ? 1 : 0).setTtcIndex(c0027d.e()).setFontVariationSettings(c0027d.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            } catch (IOException unused) {
            }
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
    }

    @Override // androidx.core.graphics.q
    protected Typeface a(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.q
    protected androidx.core.j.b.c a(androidx.core.j.b.c[] cVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
