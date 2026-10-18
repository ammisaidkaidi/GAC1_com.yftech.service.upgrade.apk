package com.google.android.material.c;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.s;
import com.google.android.material.internal.k;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP})
public class d implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1222a;
    private c b;
    private boolean c = false;
    private int d;

    static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.google.android.material.c.d.a.1
            @Override // android.os.Parcelable.Creator
            @ah
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(@ah Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @ah
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1223a;

        @ai
        k b;

        a() {
        }

        a(@ah Parcel parcel) {
            this.f1223a = parcel.readInt();
            this.b = (k) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@ah Parcel parcel, int i) {
            parcel.writeInt(this.f1223a);
            parcel.writeParcelable(this.b, 0);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public o a(ViewGroup viewGroup) {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(Context context, g gVar) {
        this.f1222a = gVar;
        this.b.a(this.f1222a);
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            this.b.b(aVar.f1223a);
            this.b.setBadgeDrawables(com.google.android.material.b.b.a(this.b.getContext(), aVar.b));
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(g gVar, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(n.a aVar) {
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(boolean z) {
        if (this.c) {
            return;
        }
        if (z) {
            this.b.b();
        } else {
            this.b.c();
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean a(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean a(s sVar) {
        return false;
    }

    public void b(boolean z) {
        this.c = z;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public boolean b(g gVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n
    public int c() {
        return this.d;
    }

    @Override // androidx.appcompat.view.menu.n
    @ah
    public Parcelable f() {
        a aVar = new a();
        aVar.f1223a = this.b.getSelectedItemId();
        aVar.b = com.google.android.material.b.b.a(this.b.getBadgeDrawables());
        return aVar;
    }
}
