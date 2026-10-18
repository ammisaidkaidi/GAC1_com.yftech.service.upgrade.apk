package com.yftech.service.upgrade.adapter.screenmcu.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends a {
    @Override // com.yftech.service.upgrade.adapter.b
    public String a() {
        return "8015";
    }

    @Override // com.yftech.service.upgrade.adapter.screenmcu.a.a, com.yftech.service.upgrade.adapter.b
    public String c() {
        StringBuilder sb = new StringBuilder();
        String strC = super.c();
        if (strC != null) {
            sb.append(strC);
        }
        sb.append("platform=");
        sb.append(a());
        sb.append("\n");
        return sb.toString();
    }
}
