package androidx.d.d.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.m;

/* JADX INFO: loaded from: classes.dex */
public class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f710a;
    private Paint b;
    private Paint c;
    private Paint d;
    private boolean e;
    private boolean f;
    private Rect g;
    private int h;
    private int i;
    private int j;
    private int k;

    public c(Context context) {
        super(context);
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f710a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, m.a.f1085a, m.a.f1085a, m.a.f1085a);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f710a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, m.a.f1085a, m.a.f1085a, m.a.f1085a);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Paint();
        this.c = new Paint();
        this.d = new Paint();
        this.e = true;
        this.f = true;
        this.f710a = null;
        this.g = new Rect();
        this.h = Color.argb(255, 0, 0, 0);
        this.i = Color.argb(255, m.a.f1085a, m.a.f1085a, m.a.f1085a);
        this.j = Color.argb(255, 50, 50, 50);
        this.k = 4;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.d.e.m.C0052m.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == androidx.d.e.m.C0052m.MockView_mock_label) {
                    this.f710a = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == androidx.d.e.m.C0052m.MockView_mock_showDiagonals) {
                    this.e = typedArrayObtainStyledAttributes.getBoolean(index, this.e);
                } else if (index == androidx.d.e.m.C0052m.MockView_mock_diagonalsColor) {
                    this.h = typedArrayObtainStyledAttributes.getColor(index, this.h);
                } else if (index == androidx.d.e.m.C0052m.MockView_mock_labelBackgroundColor) {
                    this.j = typedArrayObtainStyledAttributes.getColor(index, this.j);
                } else if (index == androidx.d.e.m.C0052m.MockView_mock_labelColor) {
                    this.i = typedArrayObtainStyledAttributes.getColor(index, this.i);
                } else if (index == androidx.d.e.m.C0052m.MockView_mock_showLabel) {
                    this.f = typedArrayObtainStyledAttributes.getBoolean(index, this.f);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f710a == null) {
            try {
                this.f710a = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.b.setColor(this.h);
        this.b.setAntiAlias(true);
        this.c.setColor(this.i);
        this.c.setAntiAlias(true);
        this.d.setColor(this.j);
        this.k = Math.round(this.k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.e) {
            width--;
            height--;
            float f = width;
            float f2 = height;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.b);
            canvas.drawLine(0.0f, f2, f, 0.0f, this.b);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.b);
            canvas.drawLine(f, 0.0f, f, f2, this.b);
            canvas.drawLine(f, f2, 0.0f, f2, this.b);
            canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.b);
        }
        if (this.f710a == null || !this.f) {
            return;
        }
        this.c.getTextBounds(this.f710a, 0, this.f710a.length(), this.g);
        float fWidth = (width - this.g.width()) / 2.0f;
        float fHeight = ((height - this.g.height()) / 2.0f) + this.g.height();
        this.g.offset((int) fWidth, (int) fHeight);
        this.g.set(this.g.left - this.k, this.g.top - this.k, this.g.right + this.k, this.g.bottom + this.k);
        canvas.drawRect(this.g, this.d);
        canvas.drawText(this.f710a, fWidth, fHeight, this.c);
    }
}
