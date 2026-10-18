package com.yftech.service.upgrade;

import androidx.annotation.ah;
import androidx.annotation.ai;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface b {

    public interface a {
        void a(b bVar, int i);

        void b(b bVar, int i);
    }

    int a();

    void a(a aVar);

    void a(@ah FileDescriptor fileDescriptor, @ah PrintWriter printWriter, @ai String[] strArr);

    boolean a(String[] strArr);

    boolean b(String[] strArr);
}
