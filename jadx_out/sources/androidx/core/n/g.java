package androidx.core.n;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f562a;

    interface a {
        void a(GestureDetector.OnDoubleTapListener onDoubleTapListener);

        void a(boolean z);

        boolean a();

        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int j = ViewConfiguration.getLongPressTimeout();
        private static final int k = ViewConfiguration.getTapTimeout();
        private static final int l = ViewConfiguration.getDoubleTapTimeout();
        private static final int m = 1;
        private static final int n = 2;
        private static final int o = 3;
        private VelocityTracker A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final GestureDetector.OnGestureListener f563a;
        GestureDetector.OnDoubleTapListener b;
        boolean c;
        boolean d;
        MotionEvent e;
        private int f;
        private int g;
        private int h;
        private int i;
        private final Handler p;
        private boolean q;
        private boolean r;
        private boolean s;
        private MotionEvent t;
        private boolean u;
        private float v;
        private float w;
        private float x;
        private float y;
        private boolean z;

        private class a extends Handler {
            a() {
            }

            a(Handler handler) {
                super(handler.getLooper());
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.f563a.onShowPress(b.this.e);
                        return;
                    case 2:
                        b.this.b();
                        return;
                    case 3:
                        if (b.this.b != null) {
                            if (b.this.c) {
                                b.this.d = true;
                                return;
                            } else {
                                b.this.b.onSingleTapConfirmed(b.this.e);
                                return;
                            }
                        }
                        return;
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.p = new a(handler);
            } else {
                this.p = new a();
            }
            this.f563a = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f563a == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.z = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.h = viewConfiguration.getScaledMinimumFlingVelocity();
            this.i = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f = scaledTouchSlop * scaledTouchSlop;
            this.g = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.s || motionEvent3.getEventTime() - motionEvent2.getEventTime() > l) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.g;
        }

        private void c() {
            this.p.removeMessages(1);
            this.p.removeMessages(2);
            this.p.removeMessages(3);
            this.A.recycle();
            this.A = null;
            this.u = false;
            this.c = false;
            this.r = false;
            this.s = false;
            this.d = false;
            if (this.q) {
                this.q = false;
            }
        }

        private void d() {
            this.p.removeMessages(1);
            this.p.removeMessages(2);
            this.p.removeMessages(3);
            this.u = false;
            this.r = false;
            this.s = false;
            this.d = false;
            if (this.q) {
                this.q = false;
            }
        }

        @Override // androidx.core.n.g.a
        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.b = onDoubleTapListener;
        }

        @Override // androidx.core.n.g.a
        public void a(boolean z) {
            this.z = z;
        }

        @Override // androidx.core.n.g.a
        public boolean a() {
            return this.z;
        }

        @Override // androidx.core.n.g.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            boolean zOnFling;
            int action = motionEvent.getAction();
            if (this.A == null) {
                this.A = VelocityTracker.obtain();
            }
            this.A.addMovement(motionEvent);
            int i = action & 255;
            boolean z = i == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x = 0.0f;
            float y = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    x += motionEvent.getX(i2);
                    y += motionEvent.getY(i2);
                }
            }
            float f = z ? pointerCount - 1 : pointerCount;
            float f2 = x / f;
            float f3 = y / f;
            switch (i) {
                case 0:
                    if (this.b == null) {
                        zOnDoubleTap = false;
                    } else {
                        boolean zHasMessages = this.p.hasMessages(3);
                        if (zHasMessages) {
                            this.p.removeMessages(3);
                        }
                        if (this.e == null || this.t == null || !zHasMessages || !a(this.e, this.t, motionEvent)) {
                            this.p.sendEmptyMessageDelayed(3, l);
                            zOnDoubleTap = false;
                        } else {
                            this.u = true;
                            zOnDoubleTap = this.b.onDoubleTap(this.e) | false | this.b.onDoubleTapEvent(motionEvent);
                        }
                    }
                    this.v = f2;
                    this.x = f2;
                    this.w = f3;
                    this.y = f3;
                    if (this.e != null) {
                        this.e.recycle();
                    }
                    this.e = MotionEvent.obtain(motionEvent);
                    this.r = true;
                    this.s = true;
                    this.c = true;
                    this.q = false;
                    this.d = false;
                    if (this.z) {
                        this.p.removeMessages(2);
                        this.p.sendEmptyMessageAtTime(2, this.e.getDownTime() + ((long) k) + ((long) j));
                    }
                    this.p.sendEmptyMessageAtTime(1, this.e.getDownTime() + ((long) k));
                    return zOnDoubleTap | this.f563a.onDown(motionEvent);
                case 1:
                    this.c = false;
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    if (this.u) {
                        zOnFling = this.b.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.q) {
                            this.p.removeMessages(3);
                            this.q = false;
                        } else if (this.r) {
                            boolean zOnSingleTapUp = this.f563a.onSingleTapUp(motionEvent);
                            if (this.d && this.b != null) {
                                this.b.onSingleTapConfirmed(motionEvent);
                            }
                            zOnFling = zOnSingleTapUp;
                        } else {
                            VelocityTracker velocityTracker = this.A;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, this.i);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) > this.h || Math.abs(xVelocity) > this.h) {
                                zOnFling = this.f563a.onFling(this.e, motionEvent, xVelocity, yVelocity);
                            }
                        }
                        zOnFling = false;
                    }
                    if (this.t != null) {
                        this.t.recycle();
                    }
                    this.t = motionEventObtain;
                    if (this.A != null) {
                        this.A.recycle();
                        this.A = null;
                    }
                    this.u = false;
                    this.d = false;
                    this.p.removeMessages(1);
                    this.p.removeMessages(2);
                    break;
                case 2:
                    if (this.q) {
                        return false;
                    }
                    float f4 = this.v - f2;
                    float f5 = this.w - f3;
                    if (this.u) {
                        return false | this.b.onDoubleTapEvent(motionEvent);
                    }
                    if (!this.r) {
                        if (Math.abs(f4) < 1.0f && Math.abs(f5) < 1.0f) {
                            return false;
                        }
                        boolean zOnScroll = this.f563a.onScroll(this.e, motionEvent, f4, f5);
                        this.v = f2;
                        this.w = f3;
                        return zOnScroll;
                    }
                    int i3 = (int) (f2 - this.x);
                    int i4 = (int) (f3 - this.y);
                    int i5 = (i3 * i3) + (i4 * i4);
                    if (i5 > this.f) {
                        zOnFling = this.f563a.onScroll(this.e, motionEvent, f4, f5);
                        this.v = f2;
                        this.w = f3;
                        this.r = false;
                        this.p.removeMessages(3);
                        this.p.removeMessages(1);
                        this.p.removeMessages(2);
                    } else {
                        zOnFling = false;
                    }
                    if (i5 > this.f) {
                        this.s = false;
                    }
                    break;
                    break;
                case 3:
                    c();
                    return false;
                case 4:
                default:
                    return false;
                case 5:
                    this.v = f2;
                    this.x = f2;
                    this.w = f3;
                    this.y = f3;
                    d();
                    return false;
                case 6:
                    this.v = f2;
                    this.x = f2;
                    this.w = f3;
                    this.y = f3;
                    this.A.computeCurrentVelocity(1000, this.i);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.A.getXVelocity(pointerId2);
                    float yVelocity2 = this.A.getYVelocity(pointerId2);
                    for (int i6 = 0; i6 < pointerCount; i6++) {
                        if (i6 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i6);
                            if ((this.A.getXVelocity(pointerId3) * xVelocity2) + (this.A.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.A.clear();
                                return false;
                            }
                        }
                    }
                    return false;
            }
            return zOnFling;
        }

        void b() {
            this.p.removeMessages(3);
            this.d = false;
            this.q = true;
            this.f563a.onLongPress(this.e);
        }
    }

    static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GestureDetector f565a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f565a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.n.g.a
        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f565a.setOnDoubleTapListener(onDoubleTapListener);
        }

        @Override // androidx.core.n.g.a
        public void a(boolean z) {
            this.f565a.setIsLongpressEnabled(z);
        }

        @Override // androidx.core.n.g.a
        public boolean a() {
            return this.f565a.isLongpressEnabled();
        }

        @Override // androidx.core.n.g.a
        public boolean a(MotionEvent motionEvent) {
            return this.f565a.onTouchEvent(motionEvent);
        }
    }

    public g(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public g(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f562a = new c(context, onGestureListener, handler);
        } else {
            this.f562a = new b(context, onGestureListener, handler);
        }
    }

    public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f562a.a(onDoubleTapListener);
    }

    public void a(boolean z) {
        this.f562a.a(z);
    }

    public boolean a() {
        return this.f562a.a();
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f562a.a(motionEvent);
    }
}
