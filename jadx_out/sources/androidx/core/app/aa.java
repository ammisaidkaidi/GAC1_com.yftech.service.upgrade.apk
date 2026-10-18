package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.ah;
import androidx.annotation.ai;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class aa implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f336a = "TaskStackBuilder";
    private final ArrayList<Intent> b = new ArrayList<>();
    private final Context c;

    public interface a {
        @ai
        Intent j();
    }

    private aa(Context context) {
        this.c = context;
    }

    @ah
    public static aa a(@ah Context context) {
        return new aa(context);
    }

    @Deprecated
    public static aa b(Context context) {
        return a(context);
    }

    public int a() {
        return this.b.size();
    }

    @ai
    public PendingIntent a(int i, int i2) {
        return a(i, i2, null);
    }

    @ai
    public PendingIntent a(int i, int i2, @ai Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return Build.VERSION.SDK_INT >= 16 ? PendingIntent.getActivities(this.c, i, intentArr, i2, bundle) : PendingIntent.getActivities(this.c, i, intentArr, i2);
    }

    @Deprecated
    public Intent a(int i) {
        return b(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ah
    public aa a(@ah Activity activity) {
        Intent intentJ = activity instanceof a ? ((a) activity).j() : null;
        if (intentJ == null) {
            intentJ = n.b(activity);
        }
        if (intentJ != null) {
            ComponentName component = intentJ.getComponent();
            if (component == null) {
                component = intentJ.resolveActivity(this.c.getPackageManager());
            }
            a(component);
            a(intentJ);
        }
        return this;
    }

    public aa a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent intentA = n.a(this.c, componentName);
            while (intentA != null) {
                this.b.add(size, intentA);
                intentA = n.a(this.c, intentA.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f336a, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @ah
    public aa a(@ah Intent intent) {
        this.b.add(intent);
        return this;
    }

    @ah
    public aa a(@ah Class<?> cls) {
        return a(new ComponentName(this.c, cls));
    }

    public void a(@ai Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.b.c.a(this.c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.c.startActivity(intent);
    }

    @ai
    public Intent b(int i) {
        return this.b.get(i);
    }

    @ah
    public aa b(@ah Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.c.getPackageManager());
        }
        if (component != null) {
            a(component);
        }
        a(intent);
        return this;
    }

    public void b() {
        a((Bundle) null);
    }

    @ah
    public Intent[] c() {
        Intent[] intentArr = new Intent[this.b.size()];
        if (intentArr.length == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.b.get(0)).addFlags(268484608);
        for (int i = 1; i < intentArr.length; i++) {
            intentArr[i] = new Intent(this.b.get(i));
        }
        return intentArr;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }
}
