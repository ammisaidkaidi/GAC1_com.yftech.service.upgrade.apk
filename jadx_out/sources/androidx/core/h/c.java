package androidx.core.h;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.ah;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private c() {
    }

    @Deprecated
    public static void a() {
        TrafficStats.clearThreadStatsTag();
    }

    @Deprecated
    public static void a(int i) {
        TrafficStats.incrementOperationCount(i);
    }

    @Deprecated
    public static void a(int i, int i2) {
        TrafficStats.incrementOperationCount(i, i2);
    }

    public static void a(@ah DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            TrafficStats.tagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.tagSocket(new b(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
        parcelFileDescriptorFromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void a(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    @Deprecated
    public static int b() {
        return TrafficStats.getThreadStatsTag();
    }

    @Deprecated
    public static void b(int i) {
        TrafficStats.setThreadStatsTag(i);
    }

    public static void b(@ah DatagramSocket datagramSocket) throws SocketException {
        if (Build.VERSION.SDK_INT >= 24) {
            TrafficStats.untagDatagramSocket(datagramSocket);
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorFromDatagramSocket = ParcelFileDescriptor.fromDatagramSocket(datagramSocket);
        TrafficStats.untagSocket(new b(datagramSocket, parcelFileDescriptorFromDatagramSocket.getFileDescriptor()));
        parcelFileDescriptorFromDatagramSocket.detachFd();
    }

    @Deprecated
    public static void b(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }
}
