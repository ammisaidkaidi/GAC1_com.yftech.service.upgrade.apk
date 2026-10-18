package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f337a = "android.activity.usage_time";
    public static final String b = "android.usage_time_packages";

    @am(a = 16)
    private static class a extends c {
        private final ActivityOptions c;

        a(ActivityOptions activityOptions) {
            this.c = activityOptions;
        }

        @Override // androidx.core.app.c
        @ah
        public c a(@ai Rect rect) {
            return Build.VERSION.SDK_INT < 24 ? this : new a(this.c.setLaunchBounds(rect));
        }

        @Override // androidx.core.app.c
        public void a(@ah PendingIntent pendingIntent) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.c.requestUsageTimeReport(pendingIntent);
            }
        }

        @Override // androidx.core.app.c
        public void a(@ah c cVar) {
            if (cVar instanceof a) {
                this.c.update(((a) cVar).c);
            }
        }

        @Override // androidx.core.app.c
        public Rect c() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return this.c.getLaunchBounds();
        }

        @Override // androidx.core.app.c
        public Bundle d() {
            return this.c.toBundle();
        }
    }

    protected c() {
    }

    @ah
    public static c a() {
        return Build.VERSION.SDK_INT >= 21 ? new a(ActivityOptions.makeTaskLaunchBehind()) : new c();
    }

    @ah
    public static c a(@ah Activity activity, @ah View view, @ah String str) {
        return Build.VERSION.SDK_INT >= 21 ? new a(ActivityOptions.makeSceneTransitionAnimation(activity, view, str)) : new c();
    }

    @ah
    public static c a(@ah Activity activity, androidx.core.m.f<View, String>... fVarArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new c();
        }
        Pair[] pairArr = null;
        if (fVarArr != null) {
            pairArr = new Pair[fVarArr.length];
            for (int i = 0; i < fVarArr.length; i++) {
                pairArr[i] = Pair.create(fVarArr[i].f503a, fVarArr[i].b);
            }
        }
        return new a(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    @ah
    public static c a(@ah Context context, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeCustomAnimation(context, i, i2)) : new c();
    }

    @ah
    public static c a(@ah View view, int i, int i2, int i3, int i4) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4)) : new c();
    }

    @ah
    public static c a(@ah View view, @ah Bitmap bitmap, int i, int i2) {
        return Build.VERSION.SDK_INT >= 16 ? new a(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2)) : new c();
    }

    @ah
    public static c b() {
        return Build.VERSION.SDK_INT >= 23 ? new a(ActivityOptions.makeBasic()) : new c();
    }

    @ah
    public static c b(@ah View view, int i, int i2, int i3, int i4) {
        return Build.VERSION.SDK_INT >= 23 ? new a(ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4)) : new c();
    }

    @ah
    public c a(@ai Rect rect) {
        return this;
    }

    public void a(@ah PendingIntent pendingIntent) {
    }

    public void a(@ah c cVar) {
    }

    @ai
    public Rect c() {
        return null;
    }

    @ai
    public Bundle d() {
        return null;
    }
}
