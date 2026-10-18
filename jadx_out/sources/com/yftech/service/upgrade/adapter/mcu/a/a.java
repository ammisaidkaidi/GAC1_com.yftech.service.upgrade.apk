package com.yftech.service.upgrade.adapter.mcu.a;

import com.yftech.service.upgrade.adapter.IMCUAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IMCUAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IMCUAdapter.a f1583a;

    @Override // com.yftech.service.upgrade.adapter.IMCUAdapter
    public void a(IMCUAdapter.a aVar) {
        this.f1583a = aVar;
    }

    @Override // com.yftech.service.upgrade.adapter.b
    public String c() {
        return null;
    }

    @Override // com.yftech.service.upgrade.adapter.IMCUAdapter
    public void onUpgradeProgressChanged(int i) {
        if (this.f1583a != null) {
            this.f1583a.b(i);
        }
    }

    @Override // com.yftech.service.upgrade.adapter.IMCUAdapter
    public void onUpgradeStateChanged(int i) {
        if (this.f1583a != null) {
            this.f1583a.a(i);
        }
    }
}
