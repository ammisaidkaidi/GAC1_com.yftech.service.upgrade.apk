package com.yftech.service.upgrade.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IDspAdapter extends b {

    public interface a {
        void a(int i);

        void b(int i);
    }

    void a(a aVar);

    boolean a(String[] strArr);

    boolean b(String[] strArr);

    void onUpgradeProgressChanged(int i);

    void onUpgradeStateChanged(int i);
}
