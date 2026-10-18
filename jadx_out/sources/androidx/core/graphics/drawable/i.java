package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
final class i extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f430a;
    Drawable.ConstantState b;
    ColorStateList c;
    PorterDuff.Mode d;

    i(@ai i iVar) {
        this.c = null;
        this.d = g.f429a;
        if (iVar != null) {
            this.f430a = iVar.f430a;
            this.b = iVar.b;
            this.c = iVar.c;
            this.d = iVar.d;
        }
    }

    boolean a() {
        return this.b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return (this.b != null ? this.b.getChangingConfigurations() : 0) | this.f430a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @ah
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @ah
    public Drawable newDrawable(@ai Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new h(this, resources) : new g(this, resources);
    }
}
