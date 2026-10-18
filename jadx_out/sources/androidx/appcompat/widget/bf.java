package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public class bf extends Resources {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f252a = 20;
    private static boolean b = false;
    private final WeakReference<Context> c;

    public bf(@androidx.annotation.ah Context context, @androidx.annotation.ah Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.c = new WeakReference<>(context);
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public static boolean b() {
        return b;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.c.get();
        return context != null ? ao.a().a(context, this, i) : super.getDrawable(i);
    }
}
