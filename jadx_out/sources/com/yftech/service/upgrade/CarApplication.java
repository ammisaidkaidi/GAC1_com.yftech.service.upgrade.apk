package com.yftech.service.upgrade;

import android.app.Application;
import com.yftech.car.permission.CarPermission;

/* JADX INFO: loaded from: classes.dex */
public class CarApplication extends Application {
    @Override // android.app.Application
    public void onCreate() throws Throwable {
        super.onCreate();
        CarPermission.initAsync("UpgradeService", new Runnable() { // from class: com.yftech.service.upgrade.CarApplication.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                com.yftech.service.upgrade.g.b.c("permission init finish");
            }
        });
        com.yftech.service.upgrade.g.b.c("upgrade app start");
    }

    @Override // android.app.Application
    public void onTerminate() throws Throwable {
        super.onTerminate();
        com.yftech.service.upgrade.g.b.c("upgrade app stop");
    }
}
