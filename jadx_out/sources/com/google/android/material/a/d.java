package com.google.android.material.a;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.ah;

/* JADX INFO: loaded from: classes.dex */
public class d extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f1148a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @ah
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(@ah ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(com.google.android.material.a.h.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(@ah ViewGroup viewGroup, @ah Float f) {
        float fFloatValue = f.floatValue();
        viewGroup.setTag(com.google.android.material.a.h.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(fFloatValue);
        }
    }
}
