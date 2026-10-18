package com.yftech.service.upgrade.adapter.screenmcu.a;

import com.yftech.service.upgrade.adapter.IScreenMcuAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IScreenMcuAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IScreenMcuAdapter.a f1588a;

    @Override // com.yftech.service.upgrade.adapter.IScreenMcuAdapter
    public void a(IScreenMcuAdapter.a aVar) {
        this.f1588a = aVar;
    }

    @Override // com.yftech.service.upgrade.adapter.b
    public String c() {
        return null;
    }

    @Override // com.yftech.service.upgrade.adapter.IScreenMcuAdapter
    public void onUpgradeProgressChanged(int i) {
        if (this.f1588a != null) {
            this.f1588a.b(i);
        }
    }

    @Override // com.yftech.service.upgrade.adapter.IScreenMcuAdapter
    public void onUpgradeStateChanged(int i) {
        if (this.f1588a != null) {
            this.f1588a.a(i);
        }
    }
}
