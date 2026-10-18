package com.yftech.service.upgrade;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.yftech.car.upgrade.CarUpgradeManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends e implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String p = "/sdcard";
    private a A = new a();
    private Handler B = new Handler();
    private Set<Integer> C = new HashSet();
    private boolean D = false;
    private CheckBox q;
    private TextView r;
    private CheckBox s;
    private TextView t;
    private CheckBox u;
    private TextView v;
    private CheckBox w;
    private TextView x;
    private Button y;
    private TextView z;

    class a extends CarUpgradeManager.CarUpgradeCallback {
        a() {
        }

        public void onUpgradeProgress(int i, int i2) throws Throwable {
            com.yftech.service.upgrade.g.b.c("onUpgradeProgress, module=" + i + ", progress=" + i2);
            MainActivity.this.b(i, i2);
        }

        public void onUpgradeState(int i, int i2) throws Throwable {
            com.yftech.service.upgrade.g.b.c("onUpgradeState, module=" + i + ", state=" + i2);
            MainActivity.this.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        switch (i) {
            case 1:
                g(i2);
                break;
            case 2:
                f(i2);
                break;
            case 3:
                h(i2);
                break;
            case 4:
                i(i2);
                break;
        }
        d(this.C.isEmpty());
    }

    private void a(String str) {
        this.z.setText(this.z.getText().toString() + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) throws Throwable {
        switch (i) {
            case 1:
                this.t.setText(i2 + "%");
                break;
            case 2:
                this.r.setText(i2 + "%");
                break;
            case 3:
                this.v.setText(i2 + "%");
                break;
            case 4:
                this.x.setText(i2 + "%");
                break;
            default:
                com.yftech.service.upgrade.g.b.e("updateUpgradeProgress, unknown module:" + i);
                break;
        }
    }

    private void d(boolean z) {
        this.q.setEnabled(z);
        this.s.setEnabled(z);
        this.u.setEnabled(z);
        this.w.setEnabled(z);
        this.y.setEnabled(z);
    }

    private void f(int i) {
        switch (i) {
            case 1:
                a("mcu upgrade success\n\n");
                this.C.remove(2);
                break;
            case 2:
                a("mcu upgrade fail\n\n");
                this.C.remove(2);
                break;
            case 3:
                a("mcu upgrade start\n");
                break;
            case 4:
                a("mcu copying\n");
                break;
            case 5:
                a("mcu checking\n");
                break;
            case 6:
                a("mcu request upgrade\n");
                break;
            case 7:
                a("mcu upgrading\n");
                break;
            default:
                a("mcu unknown state\n");
                break;
        }
    }

    private void g(int i) {
        switch (i) {
            case 1:
                a("os upgrade success\n\n");
                this.C.remove(1);
                break;
            case 2:
                a("os upgrade fail\n\n");
                this.C.remove(1);
                break;
            case 3:
                a("os upgrade start\n");
                break;
            case 4:
                a("os copying\n");
                break;
            case 5:
                a("os checking\n");
                break;
            case 6:
                a("os upgrading\n");
                break;
            default:
                a("os unknown state\n");
                break;
        }
    }

    private void h(int i) {
        switch (i) {
            case 1:
                a("screen upgrade success\n\n");
                this.C.remove(3);
                break;
            case 2:
                a("screen upgrade fail\n\n");
                this.C.remove(3);
                break;
            case 3:
                a("screen upgrade start\n");
                break;
            case 4:
                a("screen copying\n");
                break;
            case 5:
                a("screen checking\n");
                break;
            case 6:
                a("screen request upgrade\n");
                break;
            case 7:
                a("screen upgrading\n");
                break;
            default:
                a("screen unkown state\n");
                break;
        }
    }

    private void i(int i) {
        switch (i) {
            case 1:
                a("dsp upgrade success\n\n");
                this.C.remove(4);
                break;
            case 2:
                a("dsp upgrade fail\n\n");
                this.C.remove(4);
                break;
            case 3:
                a("dsp upgrade start\n");
                break;
            case 4:
                a("dsp copying\n");
                break;
            case 5:
                a("dsp checking\n");
                break;
            case 6:
                a("dsp request upgrade\n");
                break;
            case 7:
                a("dsp upgrading\n");
                break;
            default:
                a("dsp unknown state\n");
                break;
        }
    }

    private void s() {
        this.q = (CheckBox) findViewById(R.id.cbMcuUpgrade);
        this.r = (TextView) findViewById(R.id.tvMcuUpgradeProgress);
        this.s = (CheckBox) findViewById(R.id.cbOsUpgrade);
        this.t = (TextView) findViewById(R.id.tvOsUpgradeProgress);
        this.u = (CheckBox) findViewById(R.id.cbScreenUpgrade);
        this.v = (TextView) findViewById(R.id.tvScreenUpgradeProgress);
        this.w = (CheckBox) findViewById(R.id.cbDspUpgrade);
        this.x = (TextView) findViewById(R.id.tvDspUpgradeProgress);
        this.y = (Button) findViewById(R.id.btnStartUpgrade);
        this.z = (TextView) findViewById(R.id.tvUpgradeMsg);
    }

    private void t() {
        this.q.setOnCheckedChangeListener(this);
        this.s.setOnCheckedChangeListener(this);
        this.u.setOnCheckedChangeListener(this);
        this.w.setOnCheckedChangeListener(this);
        this.y.setOnClickListener(this);
    }

    private void u() throws Throwable {
        boolean z;
        this.D = true;
        d(false);
        v();
        this.C.clear();
        if (this.q.isChecked()) {
            int iAddMCUUpgradeModule = CarUpgradeManager.getInstance().addMCUUpgradeModule(p);
            if (iAddMCUUpgradeModule != 1) {
                com.yftech.service.upgrade.g.b.e("startUpgrade, add mcu fail, error code:" + iAddMCUUpgradeModule);
                z = false;
            } else {
                CarUpgradeManager.getInstance().registerCarMCUUpgradeCallback(this.A, this.B);
                this.C.add(2);
                z = true;
            }
        } else {
            z = true;
        }
        if (z && this.s.isChecked()) {
            int iAddOSUpgradeModule = CarUpgradeManager.getInstance().addOSUpgradeModule(p);
            if (iAddOSUpgradeModule != 1) {
                com.yftech.service.upgrade.g.b.e("startUpgrade, add os fail, error code:" + iAddOSUpgradeModule);
                z = false;
            } else {
                CarUpgradeManager.getInstance().registerCarOSUpgradeCallback(this.A, this.B);
                this.C.add(1);
            }
        }
        if (z && this.u.isChecked()) {
            int iAddScreenUpgradeModule = CarUpgradeManager.getInstance().addScreenUpgradeModule(p);
            if (iAddScreenUpgradeModule != 1) {
                com.yftech.service.upgrade.g.b.e("startUpgrade, add screen fail, error code:" + iAddScreenUpgradeModule);
                z = false;
            } else {
                CarUpgradeManager.getInstance().registerCarScreenUpgradeCallback(this.A, this.B);
                this.C.add(3);
            }
        }
        if (z && this.w.isChecked()) {
            int iAddDSPUpgradeModule = CarUpgradeManager.getInstance().addDSPUpgradeModule(p);
            if (iAddDSPUpgradeModule != 1) {
                com.yftech.service.upgrade.g.b.e("startUpgrade, add dsp fail, error code:" + iAddDSPUpgradeModule);
                z = false;
            } else {
                CarUpgradeManager.getInstance().registerCarDSPUpgradeCallback(this.A, this.B);
                this.C.add(4);
            }
        }
        if (z && !CarUpgradeManager.getInstance().startUpgrade()) {
            com.yftech.service.upgrade.g.b.e("startUpgrade, start fail");
            z = false;
        }
        if (z) {
            this.z.setText("start upgrade\n");
            return;
        }
        Iterator<Integer> it = this.C.iterator();
        while (it.hasNext()) {
            switch (it.next().intValue()) {
                case 1:
                    CarUpgradeManager.getInstance().removeOSUpgradeModule();
                    CarUpgradeManager.getInstance().unregisterCarOSUpgradeCallback(this.A);
                    break;
                case 2:
                    CarUpgradeManager.getInstance().removeMCUUpgradeModule();
                    CarUpgradeManager.getInstance().unregisterCarMCUUpgradeCallback(this.A);
                    break;
                case 3:
                    CarUpgradeManager.getInstance().removeScreenUpgradeModule();
                    CarUpgradeManager.getInstance().unregisterCarScreenUpgradeCallback(this.A);
                    break;
                case 4:
                    CarUpgradeManager.getInstance().removeDSPUpgradeModule();
                    CarUpgradeManager.getInstance().unregisterCarDSPUpgradeCallback(this.A);
                    break;
            }
        }
        this.C.clear();
        d(true);
        this.z.setText("start upgrade fail\n");
        this.D = false;
    }

    private void v() {
        this.r.setText(com.yftech.service.upgrade.a.d);
        this.t.setText(com.yftech.service.upgrade.a.d);
        this.v.setText(com.yftech.service.upgrade.a.d);
        this.x.setText(com.yftech.service.upgrade.a.d);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.D) {
            return;
        }
        if (!z) {
            switch (compoundButton.getId()) {
                case R.id.cbDspUpgrade /* 2131230811 */:
                    z |= this.q.isChecked() || this.s.isChecked() || this.u.isChecked();
                    break;
                case R.id.cbMcuUpgrade /* 2131230812 */:
                    z |= this.s.isChecked() || this.u.isChecked() || this.w.isChecked();
                    break;
                case R.id.cbOsUpgrade /* 2131230813 */:
                    z |= this.q.isChecked() || this.u.isChecked() || this.w.isChecked();
                    break;
                case R.id.cbScreenUpgrade /* 2131230814 */:
                    z |= this.q.isChecked() || this.s.isChecked() || this.w.isChecked();
                    break;
            }
        }
        this.y.setEnabled(z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (view.getId() != R.id.btnStartUpgrade) {
            return;
        }
        u();
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.j, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        s();
        t();
    }
}
