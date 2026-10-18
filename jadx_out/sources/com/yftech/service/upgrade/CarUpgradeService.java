package com.yftech.service.upgrade;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.ah;
import androidx.annotation.ai;
import com.yftech.car.permission.CarPermission;
import com.yftech.car.upgrade.CarUpgradeInfo;
import com.yftech.car.upgrade.CarUpgradeManager;
import com.yftech.car.upgrade.ICarUpgradeCallback;
import com.yftech.car.upgrade.ICarUpgradeService;
import com.yftech.service.upgrade.jni.McuCommJni;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CarUpgradeService extends Service {
    private HashMap<Integer, com.yftech.service.upgrade.b> d;
    private CarUpgradeInfo e;
    private b g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1566a = new c();
    private final RemoteCallbackList<ICarUpgradeCallback> b = new RemoteCallbackList<>();
    private final ArrayList<a> c = new ArrayList<>();
    private boolean f = false;
    private Handler h = new Handler();
    private com.yftech.service.upgrade.b.a i = new com.yftech.service.upgrade.b.a() { // from class: com.yftech.service.upgrade.CarUpgradeService.1
        @Override // com.yftech.service.upgrade.b.a
        public void a(com.yftech.service.upgrade.b bVar, int i) {
            if (CarUpgradeService.this.e != null) {
                CarUpgradeService.this.e.setState(i);
            }
            if (CarUpgradeService.this.g != null) {
                for (CarUpgradeInfo carUpgradeInfo : CarUpgradeService.this.g.f1569a) {
                    if (carUpgradeInfo.getModule() == bVar.a()) {
                        carUpgradeInfo.setState(i);
                    }
                }
            }
            CarUpgradeService.this.a(bVar.a(), i);
        }

        @Override // com.yftech.service.upgrade.b.a
        public void b(com.yftech.service.upgrade.b bVar, int i) {
            if (CarUpgradeService.this.e != null) {
                CarUpgradeService.this.e.setProgress(i);
            }
            if (CarUpgradeService.this.g != null) {
                for (CarUpgradeInfo carUpgradeInfo : CarUpgradeService.this.g.f1569a) {
                    if (carUpgradeInfo.getModule() == bVar.a()) {
                        carUpgradeInfo.setProgress(i);
                    }
                }
            }
            CarUpgradeService.this.b(bVar.a(), i);
        }
    };

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1568a;
        String[] b;

        a(int i, String[] strArr) {
            this.f1568a = i;
            this.b = strArr;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<CarUpgradeInfo> f1569a;

        b() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            com.yftech.service.upgrade.g.b.c("UpgradeRunnable, start upgrade");
            McuCommJni.notifyMcuUpgradeStart();
            for (CarUpgradeInfo carUpgradeInfo : this.f1569a) {
                com.yftech.service.upgrade.g.b.c("UpgradeRunnable, start module(" + carUpgradeInfo.getModule() + ") upgrade");
                CarUpgradeService.this.e = new CarUpgradeInfo(carUpgradeInfo.getModule(), carUpgradeInfo.getPath());
                CarUpgradeService.this.e.setProgress(0);
                ((com.yftech.service.upgrade.b) CarUpgradeService.this.d.get(Integer.valueOf(carUpgradeInfo.getModule()))).b(carUpgradeInfo.getPath());
            }
            CarUpgradeService.this.e = null;
            synchronized (CarUpgradeService.this.f1566a) {
                CarUpgradeService.this.f = false;
            }
            synchronized (CarUpgradeService.this.c) {
                CarUpgradeService.this.c.clear();
            }
            McuCommJni.notifyMcuUpgradeEnd();
        }
    }

    class c extends ICarUpgradeService.Stub {
        private static final int b = 1;
        private static final int c = 2;
        private static final int d = 3;
        private Set<Integer> e = new androidx.c.b();
        private CarUpgradeManager.CarUpgradeCallback f = new CarUpgradeManager.CarUpgradeCallback() { // from class: com.yftech.service.upgrade.CarUpgradeService.c.1
            /* JADX WARN: Code duplicated, block: B:25:0x0032  */
            /* JADX WARN: Code duplicated, block: B:27:0x0037  */
            public void onUpgradeState(int i, int i2) {
                boolean z;
                if (c.this.e.contains(Integer.valueOf(i))) {
                    boolean z2 = false;
                    switch (i) {
                        case 1:
                            if (i2 == 1) {
                                z = false;
                                z2 = true;
                            } else if (i2 != 2) {
                                z = false;
                            } else {
                                z = true;
                            }
                            break;
                        case 2:
                            if (i2 == 1) {
                                z = false;
                                z2 = true;
                            } else if (i2 != 2) {
                                z = false;
                            } else {
                                z = true;
                            }
                            break;
                        case 3:
                            if (i2 == 1) {
                                z = false;
                                z2 = true;
                            } else if (i2 != 2) {
                                z = false;
                            } else {
                                z = true;
                            }
                            break;
                        case 4:
                            if (i2 == 1) {
                                z = false;
                                z2 = true;
                            } else if (i2 != 2) {
                                z = false;
                            } else {
                                z = true;
                            }
                            break;
                        case 5:
                            if (i2 == 1) {
                                z = false;
                                z2 = true;
                            } else if (i2 != 2) {
                                z = false;
                            } else {
                                z = true;
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                    if (z2 || z) {
                        c.this.e.remove(Integer.valueOf(i));
                        if (c.this.e.isEmpty()) {
                            c.this.a(3, "all upgrade finish");
                        } else if (z2) {
                            c.this.a(1, "upgrade " + i + " success");
                        } else {
                            c.this.a(2, "upgrade " + i + " fail");
                        }
                        switch (i) {
                            case 1:
                                CarUpgradeManager.getInstance().unregisterCarOSUpgradeCallback(c.this.f);
                                break;
                            case 2:
                                CarUpgradeManager.getInstance().unregisterCarMCUUpgradeCallback(c.this.f);
                                break;
                            case 3:
                                CarUpgradeManager.getInstance().unregisterCarScreenUpgradeCallback(c.this.f);
                                break;
                            case 4:
                                CarUpgradeManager.getInstance().unregisterCarDSPUpgradeCallback(c.this.f);
                                break;
                            case 5:
                                CarUpgradeManager.getInstance().unregisterCarScreenMcuUpgradeCallback(c.this.f);
                                break;
                        }
                    }
                }
            }
        };

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, final String str) {
            AudioManager audioManager = (AudioManager) CarUpgradeService.this.getSystemService("audio");
            if (audioManager == null) {
                return;
            }
            switch (i) {
                case 1:
                    audioManager.playSoundEffect(0);
                    break;
                case 2:
                    audioManager.playSoundEffect(7);
                    break;
                case 3:
                    audioManager.playSoundEffect(5);
                    break;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CarUpgradeService.this.h.post(new Runnable() { // from class: com.yftech.service.upgrade.CarUpgradeService.c.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(CarUpgradeService.this, str, 0).show();
                }
            });
        }

        private boolean a(PrintWriter printWriter, String[] strArr) {
            int iRemoveScreenMcuUpgradeModule;
            int iAddScreenMcuUpgradeModule;
            String str = strArr[0];
            int i = 5;
            if ("add".equals(str)) {
                if (strArr.length < 3) {
                    printWriter.println("add command exec failed: length of params is not right");
                    return false;
                }
                String str2 = strArr[1];
                String[] strArr2 = new String[strArr.length - 2];
                System.arraycopy(strArr, 2, strArr2, 0, strArr.length - 2);
                if ("os".equals(str2)) {
                    iAddScreenMcuUpgradeModule = CarUpgradeManager.getInstance().addOSUpgradeModule(strArr2[0]);
                    i = 1;
                } else if ("mcu".equals(str2)) {
                    iAddScreenMcuUpgradeModule = CarUpgradeManager.getInstance().addMCUUpgradeModule(strArr2[0]);
                    i = 2;
                } else if ("screen".equals(str2)) {
                    iAddScreenMcuUpgradeModule = CarUpgradeManager.getInstance().addScreenUpgradeModule(strArr2[0]);
                    i = 3;
                } else if ("dsp".equals(str2)) {
                    iAddScreenMcuUpgradeModule = CarUpgradeManager.getInstance().addDSPUpgradeModule(strArr2[0]);
                    i = 4;
                } else {
                    if (!"screenmcu".equals(str2)) {
                        printWriter.println("add command exec failed: unknown module(" + str2 + ")");
                        return false;
                    }
                    iAddScreenMcuUpgradeModule = CarUpgradeManager.getInstance().addScreenMcuUpgradeModule(strArr2[0]);
                }
                if (iAddScreenMcuUpgradeModule == 1) {
                    this.e.add(Integer.valueOf(i));
                    printWriter.println("add command exec success for module(" + str2 + ") and path(" + Arrays.toString(strArr2) + ")");
                    return true;
                }
                printWriter.println("add command exec failed for module(" + str2 + ") and path(" + Arrays.toString(strArr2) + "), error code is " + iAddScreenMcuUpgradeModule);
                return false;
            }
            if ("remove".equals(str)) {
                if (strArr.length != 2) {
                    printWriter.println("remove command exec failed: length of params is not right");
                    return false;
                }
                String str3 = strArr[1];
                if ("os".equals(str3)) {
                    iRemoveScreenMcuUpgradeModule = CarUpgradeManager.getInstance().removeOSUpgradeModule();
                    i = 1;
                } else if ("mcu".equals(str3)) {
                    iRemoveScreenMcuUpgradeModule = CarUpgradeManager.getInstance().removeMCUUpgradeModule();
                    i = 2;
                } else if ("screen".equals(str3)) {
                    iRemoveScreenMcuUpgradeModule = CarUpgradeManager.getInstance().removeScreenUpgradeModule();
                    i = 3;
                } else if ("dsp".equals(str3)) {
                    iRemoveScreenMcuUpgradeModule = CarUpgradeManager.getInstance().removeDSPUpgradeModule();
                    i = 4;
                } else {
                    if (!"screenmcu".equals(str3)) {
                        printWriter.println("remove command exec failed: unknown module(" + str3 + ")");
                        return false;
                    }
                    iRemoveScreenMcuUpgradeModule = CarUpgradeManager.getInstance().removeScreenMcuUpgradeModule();
                }
                if (iRemoveScreenMcuUpgradeModule == 1) {
                    this.e.remove(Integer.valueOf(i));
                    printWriter.println("remove command exec success for module(" + str3 + ")");
                    return true;
                }
                printWriter.println("remove command exec failed for module(" + str3 + "), error code is " + iRemoveScreenMcuUpgradeModule);
                return false;
            }
            if (!"start".equals(str)) {
                printWriter.println("command of " + str + "is unknown");
                return false;
            }
            if (CarUpgradeManager.getInstance().getCurUpgradingInfo() != null) {
                printWriter.println("start command exec failed: upgrading");
                return false;
            }
            Iterator<Integer> it = this.e.iterator();
            while (it.hasNext()) {
                switch (it.next().intValue()) {
                    case 1:
                        CarUpgradeManager.getInstance().registerCarOSUpgradeCallback(this.f, new Handler(CarUpgradeService.this.getMainLooper()));
                        break;
                    case 2:
                        CarUpgradeManager.getInstance().registerCarMCUUpgradeCallback(this.f, new Handler(CarUpgradeService.this.getMainLooper()));
                        break;
                    case 3:
                        CarUpgradeManager.getInstance().registerCarScreenUpgradeCallback(this.f, new Handler(CarUpgradeService.this.getMainLooper()));
                        break;
                    case 4:
                        CarUpgradeManager.getInstance().registerCarDSPUpgradeCallback(this.f, new Handler(CarUpgradeService.this.getMainLooper()));
                        break;
                    case 5:
                        CarUpgradeManager.getInstance().registerCarScreenMcuUpgradeCallback(this.f, new Handler(CarUpgradeService.this.getMainLooper()));
                        break;
                }
            }
            if (CarUpgradeManager.getInstance().startUpgrade()) {
                printWriter.println("start command exec success");
                return true;
            }
            Iterator<Integer> it2 = this.e.iterator();
            while (it2.hasNext()) {
                switch (it2.next().intValue()) {
                    case 1:
                        CarUpgradeManager.getInstance().unregisterCarOSUpgradeCallback(this.f);
                        break;
                    case 2:
                        CarUpgradeManager.getInstance().unregisterCarMCUUpgradeCallback(this.f);
                        break;
                    case 3:
                        CarUpgradeManager.getInstance().unregisterCarScreenUpgradeCallback(this.f);
                        break;
                    case 4:
                        CarUpgradeManager.getInstance().unregisterCarDSPUpgradeCallback(this.f);
                        break;
                    case 5:
                        CarUpgradeManager.getInstance().unregisterCarScreenMcuUpgradeCallback(this.f);
                        break;
                }
            }
            printWriter.println("start command exec failed");
            return false;
        }

        String a() {
            String str = com.yftech.service.upgrade.a.d;
            int callingPid = Binder.getCallingPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) CarUpgradeService.this.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == callingPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        }

        public int addUpgradeModule(int i, String[] strArr) throws Throwable {
            com.yftech.service.upgrade.g.b.c("addUpgradeModule, pid:" + Binder.getCallingPid() + ", package:" + a() + ", module:" + i + ", pathList:" + Arrays.toString(strArr));
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.b(i, strArr);
            }
            com.yftech.service.upgrade.g.b.e("addUpgradeModule, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public boolean checkUpgradeFile(int i, String[] strArr) throws Throwable {
            com.yftech.service.upgrade.g.b.c("checkUpgradeFile, pid:" + Binder.getCallingPid() + ", package:" + a() + ", module:" + i + ", pathList:" + Arrays.toString(strArr));
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.a(i, strArr);
            }
            com.yftech.service.upgrade.g.b.e("checkUpgradeFile, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        protected void dump(@ah FileDescriptor fileDescriptor, @ah PrintWriter printWriter, @ai String[] strArr) {
            boolean zA;
            if (strArr != null && strArr.length > 0 && !"-a".equals(strArr[0])) {
                try {
                    zA = a(printWriter, strArr);
                } catch (Exception e) {
                    e.printStackTrace();
                    zA = false;
                }
                if (zA) {
                    a(2, "command exec success");
                    return;
                } else {
                    a(1, "command exec fail");
                    return;
                }
            }
            printWriter.println("----upgrade service----");
            synchronized (CarUpgradeService.this.c) {
                printWriter.println("add upgrade module list:");
                for (a aVar : CarUpgradeService.this.c) {
                    printWriter.println("\tmodule:" + aVar.f1568a + ", pathList:" + Arrays.toString(aVar.b));
                }
            }
            printWriter.println("is upgrading: " + CarUpgradeService.this.f);
            b bVar = CarUpgradeService.this.g;
            if (CarUpgradeService.this.f && bVar != null) {
                printWriter.println("upgrading module list:");
                for (CarUpgradeInfo carUpgradeInfo : bVar.f1569a) {
                    printWriter.println("\tmodule:" + carUpgradeInfo.getModule() + ", state:" + carUpgradeInfo.getState() + ", progress:" + carUpgradeInfo.getProgress() + ", pathList:" + Arrays.toString(carUpgradeInfo.getPath()));
                }
                printWriter.println("upgrade module detailed state:");
                Iterator<CarUpgradeInfo> it = bVar.f1569a.iterator();
                while (it.hasNext()) {
                    ((com.yftech.service.upgrade.b) CarUpgradeService.this.d.get(Integer.valueOf(it.next().getModule()))).a(fileDescriptor, printWriter, strArr);
                }
            }
            super.dump(fileDescriptor, printWriter, strArr);
        }

        public CarUpgradeInfo getCurUpgradeingInfo() throws Throwable {
            com.yftech.service.upgrade.g.b.c("getCurUpgradeingInfo, pid:" + Binder.getCallingPid() + ", package:" + a());
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.c();
            }
            com.yftech.service.upgrade.g.b.e("getCurUpgradeingInfo, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public int[] getHasAddUpgradeModule() throws Throwable {
            com.yftech.service.upgrade.g.b.c("getHasAddUpgradeModule, pid:" + Binder.getCallingPid() + ", package:" + a());
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.d();
            }
            com.yftech.service.upgrade.g.b.e("getHasAddUpgradeModule, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public String getVersion(int i) throws Throwable {
            com.yftech.service.upgrade.g.b.c("getVersion, pid:" + Binder.getCallingPid() + ", package:" + a() + ", module=" + i);
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return com.yftech.service.upgrade.a.d;
            }
            com.yftech.service.upgrade.g.b.e("getVersion, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public void registerListener(ICarUpgradeCallback iCarUpgradeCallback) throws Throwable {
            com.yftech.service.upgrade.g.b.c("registerListener, pid:" + Binder.getCallingPid() + ", package:" + a());
            if (!CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                com.yftech.service.upgrade.g.b.e("registerListener, permission not granted");
                throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
            }
            synchronized (CarUpgradeService.this.b) {
                CarUpgradeService.this.b.register(iCarUpgradeCallback);
            }
        }

        public int removeUpgradeModule(int i) throws Throwable {
            com.yftech.service.upgrade.g.b.c("removeUpgradeModule, pid:" + Binder.getCallingPid() + ", package:" + a() + "module:" + i);
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.a(i);
            }
            com.yftech.service.upgrade.g.b.e("removeUpgradeModule, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public boolean startUpgrade() throws Throwable {
            com.yftech.service.upgrade.g.b.c("startUpgrade, pid:" + Binder.getCallingPid() + ", package:" + a());
            if (CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                return CarUpgradeService.this.b();
            }
            com.yftech.service.upgrade.g.b.e("startUpgrade, permission not granted");
            throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
        }

        public void unregisterListener(ICarUpgradeCallback iCarUpgradeCallback) throws Throwable {
            com.yftech.service.upgrade.g.b.c("unregisterListener, pid:" + Binder.getCallingPid() + ", package:" + a());
            if (!CarPermission.checkPermission(CarUpgradeService.this, com.yftech.service.upgrade.c.a.f1591a)) {
                com.yftech.service.upgrade.g.b.e("unregisterListener, permission not granted");
                throw new SecurityException("require com.yftech.permission.service.upgrade.upgrade");
            }
            synchronized (CarUpgradeService.this.b) {
                CarUpgradeService.this.b.unregister(iCarUpgradeCallback);
            }
        }
    }

    static {
        System.loadLibrary("UpgradeService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        synchronized (this.f1566a) {
            if (this.f) {
                return 3;
            }
            synchronized (this.c) {
                for (a aVar : this.c) {
                    if (aVar.f1568a == i) {
                        this.c.remove(aVar);
                        break;
                    }
                }
            }
            return 1;
        }
    }

    private void a() {
        this.d = new HashMap<>();
        this.d.put(1, new com.yftech.service.upgrade.d.a(getApplicationContext()));
        this.d.put(2, new com.yftech.service.upgrade.c.a(getApplicationContext()));
        this.d.put(3, new com.yftech.service.upgrade.e.a(getApplicationContext()));
        this.d.put(4, new com.yftech.service.upgrade.b.a(getApplicationContext()));
        this.d.put(5, new com.yftech.service.upgrade.f.a(getApplicationContext()));
        Iterator<com.yftech.service.upgrade.b> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().a(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.b) {
            int iBeginBroadcast = this.b.beginBroadcast();
            while (true) {
                int i3 = iBeginBroadcast - 1;
                if (iBeginBroadcast != 0) {
                    try {
                        this.b.getBroadcastItem(i3).onUpgradeState(i, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    iBeginBroadcast = i3;
                } else {
                    this.b.finishBroadcast();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String[] strArr) throws Throwable {
        if (this.d.containsKey(Integer.valueOf(i))) {
            return this.d.get(Integer.valueOf(i)).a(strArr);
        }
        com.yftech.service.upgrade.g.b.e("checkUpgradeFile, do not support this module:" + i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i, String[] strArr) throws Throwable {
        if (!this.d.containsKey(Integer.valueOf(i))) {
            com.yftech.service.upgrade.g.b.e("addUpgradeModule, do not this module:" + i);
            return 2;
        }
        synchronized (this.f1566a) {
            if (this.f) {
                com.yftech.service.upgrade.g.b.c("addUpgradeModule, upgrading");
                return 4;
            }
            if (strArr == null || strArr.length == 0) {
                com.yftech.service.upgrade.g.b.c("addUpgradeModule, path param is empty");
                return 5;
            }
            for (String str : strArr) {
                File file = new File(str);
                if (!file.exists() || !file.isDirectory()) {
                    com.yftech.service.upgrade.g.b.c("addUpgradeModule, path not exist");
                    return 5;
                }
            }
            synchronized (this.c) {
                Iterator<a> it = this.c.iterator();
                while (it.hasNext()) {
                    if (it.next().f1568a == i) {
                        com.yftech.service.upgrade.g.b.c("addUpgradeModule, module has exist");
                        return 3;
                    }
                }
                if (this.c.size() == 0 || this.c.get(this.c.size() - 1).f1568a != 1) {
                    this.c.add(new a(i, strArr));
                } else {
                    this.c.add(this.c.size() - 1, new a(i, strArr));
                }
                return 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        synchronized (this.b) {
            int iBeginBroadcast = this.b.beginBroadcast();
            while (true) {
                int i3 = iBeginBroadcast - 1;
                if (iBeginBroadcast != 0) {
                    try {
                        this.b.getBroadcastItem(i3).onUpgradeProgress(i, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    iBeginBroadcast = i3;
                } else {
                    this.b.finishBroadcast();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        synchronized (this.f1566a) {
            if (this.f) {
                com.yftech.service.upgrade.g.b.e("startUpgrade, is upgrading");
                return false;
            }
            this.f = true;
            this.g = new b();
            synchronized (this.c) {
                this.g.f1569a = new ArrayList();
                for (a aVar : this.c) {
                    CarUpgradeInfo carUpgradeInfo = new CarUpgradeInfo(aVar.f1568a, aVar.b);
                    carUpgradeInfo.setProgress(0);
                    carUpgradeInfo.setState(-1);
                    this.g.f1569a.add(carUpgradeInfo);
                }
            }
            new Thread(this.g, "upgrade.thread").start();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CarUpgradeInfo c() {
        if (this.f) {
            return this.e;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] d() {
        synchronized (this.c) {
            if (this.c.size() == 0) {
                return null;
            }
            int[] iArr = new int[this.c.size()];
            for (int i = 0; i < this.c.size(); i++) {
                iArr[i] = this.c.get(i).f1568a;
            }
            return iArr;
        }
    }

    private native void initJni();

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            super.dump(fileDescriptor, printWriter, strArr);
            return;
        }
        if ("log_debug".equals(strArr[0])) {
            if (strArr.length <= 2) {
                printWriter.println("dumpsys activity service CarMainService log_debug [level] [state]");
                printWriter.println("    level: [v/d/i/file/save_always]");
                printWriter.println("    state: [open/close]");
                return;
            }
            String str = strArr[1];
            String str2 = strArr[2];
            if ("v".equals(str)) {
                if ("open".equals(str2)) {
                    com.yftech.service.upgrade.g.b.a(true);
                    printWriter.println("success");
                    return;
                } else if (!"close".equals(str2)) {
                    printWriter.println("value error");
                    return;
                } else {
                    com.yftech.service.upgrade.g.b.a(false);
                    printWriter.println("success");
                    return;
                }
            }
            if ("d".equals(str)) {
                if ("open".equals(str2)) {
                    com.yftech.service.upgrade.g.b.b(true);
                    printWriter.println("success");
                    return;
                } else if (!"close".equals(str2)) {
                    printWriter.println("value error");
                    return;
                } else {
                    com.yftech.service.upgrade.g.b.b(false);
                    printWriter.println("success");
                    return;
                }
            }
            if ("i".equals(str)) {
                if ("open".equals(str2)) {
                    com.yftech.service.upgrade.g.b.c(true);
                    printWriter.println("success");
                    return;
                } else if (!"close".equals(str2)) {
                    printWriter.println("value error");
                    return;
                } else {
                    com.yftech.service.upgrade.g.b.c(false);
                    printWriter.println("success");
                    return;
                }
            }
            if ("file".equals(str)) {
                if ("open".equals(str2)) {
                    com.yftech.service.upgrade.g.b.d(true);
                    printWriter.println("success");
                    return;
                } else if (!"close".equals(str2)) {
                    printWriter.println("value error");
                    return;
                } else {
                    com.yftech.service.upgrade.g.b.d(false);
                    printWriter.println("success");
                    return;
                }
            }
            if (!"save_always".equals(str)) {
                printWriter.println("params error");
                return;
            }
            if ("open".equals(str2)) {
                com.yftech.service.upgrade.g.b.e(true);
                printWriter.println("success");
            } else if (!"close".equals(str2)) {
                printWriter.println("value error");
            } else {
                com.yftech.service.upgrade.g.b.e(false);
                printWriter.println("success");
            }
        }
    }

    @Override // android.app.Service
    @ai
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() throws Throwable {
        super.onCreate();
        com.yftech.service.upgrade.g.b.c("upgrade service start");
        initJni();
        a();
        com.yftech.service.upgrade.adapter.a.a(getApplicationContext());
        ServiceManager.addService("car_upgrade", this.f1566a);
    }

    @Override // android.app.Service
    public void onDestroy() throws Throwable {
        super.onDestroy();
        com.yftech.service.upgrade.g.b.c("upgrade service stop");
    }
}
