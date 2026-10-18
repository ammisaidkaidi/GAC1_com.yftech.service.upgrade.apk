package com.google.android.material.i;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ah;
import androidx.annotation.ap;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @ah
    private final Dialog f1321a;
    private final int b;
    private final int c;
    private final int d;

    public a(@ah Dialog dialog, @ah Rect rect) {
        this.f1321a = dialog;
        this.b = rect.left;
        this.c = rect.top;
        this.d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@ah View view, @ah MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.c + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            motionEventObtain.setLocation((-this.d) - 1, (-this.d) - 1);
        }
        view.performClick();
        return this.f1321a.onTouchEvent(motionEventObtain);
    }
}
