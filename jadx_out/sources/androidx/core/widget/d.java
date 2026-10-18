package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.ah;
import androidx.annotation.ai;

/* JADX INFO: loaded from: classes.dex */
public class d extends ProgressBar {
    private static final int e = 500;
    private static final int f = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f583a;
    boolean b;
    boolean c;
    boolean d;
    private final Runnable g;
    private final Runnable h;

    public d(@ah Context context) {
        this(context, null);
    }

    public d(@ah Context context, @ai AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f583a = -1L;
        this.b = false;
        this.c = false;
        this.d = false;
        this.g = new Runnable() { // from class: androidx.core.widget.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.b = false;
                d.this.f583a = -1L;
                d.this.setVisibility(8);
            }
        };
        this.h = new Runnable() { // from class: androidx.core.widget.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.c = false;
                if (d.this.d) {
                    return;
                }
                d.this.f583a = System.currentTimeMillis();
                d.this.setVisibility(0);
            }
        };
    }

    private void c() {
        removeCallbacks(this.g);
        removeCallbacks(this.h);
    }

    public synchronized void a() {
        this.d = true;
        removeCallbacks(this.h);
        this.c = false;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f583a;
        if (jCurrentTimeMillis >= 500 || this.f583a == -1) {
            setVisibility(8);
        } else if (!this.b) {
            postDelayed(this.g, 500 - jCurrentTimeMillis);
            this.b = true;
        }
    }

    public synchronized void b() {
        this.f583a = -1L;
        this.d = false;
        removeCallbacks(this.g);
        this.b = false;
        if (!this.c) {
            postDelayed(this.h, 500L);
            this.c = true;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
