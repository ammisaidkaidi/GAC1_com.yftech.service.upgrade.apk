package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.annotation.ah;
import androidx.annotation.ai;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
abstract class e implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1242a;
    private final DateFormat b;

    @ah
    private final TextInputLayout c;
    private final a d;
    private final String e;

    e(String str, DateFormat dateFormat, @ah TextInputLayout textInputLayout, a aVar) {
        this.f1242a = str;
        this.b = dateFormat;
        this.c = textInputLayout;
        this.d = aVar;
        this.e = textInputLayout.getContext().getString(com.google.android.material.a.m.mtrl_picker_out_of_range);
    }

    void a() {
    }

    abstract void a(@ai Long l);

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@ah CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.c.setError(null);
            a(null);
            return;
        }
        try {
            Date date = this.b.parse(charSequence.toString());
            this.c.setError(null);
            long time = date.getTime();
            if (this.d.a().a(time) && this.d.a(time)) {
                a(Long.valueOf(date.getTime()));
            } else {
                this.c.setError(String.format(this.e, g.e(time)));
                a();
            }
        } catch (ParseException unused) {
            String string = this.c.getContext().getString(com.google.android.material.a.m.mtrl_picker_invalid_format);
            String str = String.format(this.c.getContext().getString(com.google.android.material.a.m.mtrl_picker_invalid_format_use), this.f1242a);
            String str2 = String.format(this.c.getContext().getString(com.google.android.material.a.m.mtrl_picker_invalid_format_example), this.b.format(new Date(y.b().getTimeInMillis())));
            this.c.setError(string + "\n" + str + "\n" + str2);
            a();
        }
    }
}
