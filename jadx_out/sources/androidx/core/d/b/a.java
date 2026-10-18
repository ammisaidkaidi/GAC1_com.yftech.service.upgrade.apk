package androidx.core.d.b;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.am;
import androidx.annotation.ao;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f419a;

    /* JADX INFO: renamed from: androidx.core.d.b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0030a {
        public void a() {
        }

        public void a(int i, CharSequence charSequence) {
        }

        public void a(b bVar) {
        }

        public void b(int i, CharSequence charSequence) {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f421a;

        public b(c cVar) {
            this.f421a = cVar;
        }

        public c a() {
            return this.f421a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Signature f422a;
        private final Cipher b;
        private final Mac c;

        public c(@ah Signature signature) {
            this.f422a = signature;
            this.b = null;
            this.c = null;
        }

        public c(@ah Cipher cipher) {
            this.b = cipher;
            this.f422a = null;
            this.c = null;
        }

        public c(@ah Mac mac) {
            this.c = mac;
            this.b = null;
            this.f422a = null;
        }

        @ai
        public Signature a() {
            return this.f422a;
        }

        @ai
        public Cipher b() {
            return this.b;
        }

        @ai
        public Mac c() {
            return this.c;
        }
    }

    private a(Context context) {
        this.f419a = context;
    }

    @am(a = 23)
    private static FingerprintManager.AuthenticationCallback a(final AbstractC0030a abstractC0030a) {
        return new FingerprintManager.AuthenticationCallback() { // from class: androidx.core.d.b.a.1
            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationError(int i, CharSequence charSequence) {
                abstractC0030a.a(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationFailed() {
                abstractC0030a.a();
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                abstractC0030a.b(i, charSequence);
            }

            @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                abstractC0030a.a(new b(a.a(authenticationResult.getCryptoObject())));
            }
        };
    }

    @am(a = 23)
    private static FingerprintManager.CryptoObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.b() != null) {
            return new FingerprintManager.CryptoObject(cVar.b());
        }
        if (cVar.a() != null) {
            return new FingerprintManager.CryptoObject(cVar.a());
        }
        if (cVar.c() != null) {
            return new FingerprintManager.CryptoObject(cVar.c());
        }
        return null;
    }

    @am(a = 23)
    static c a(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new c(cryptoObject.getMac());
        }
        return null;
    }

    @ah
    public static a a(@ah Context context) {
        return new a(context);
    }

    @ai
    @am(a = 23)
    private static FingerprintManager b(@ah Context context) {
        if (Build.VERSION.SDK_INT == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (Build.VERSION.SDK_INT <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    @ao(a = "android.permission.USE_FINGERPRINT")
    public void a(@ai c cVar, int i, @ai androidx.core.i.b bVar, @ah AbstractC0030a abstractC0030a, @ai Handler handler) {
        FingerprintManager fingerprintManagerB;
        if (Build.VERSION.SDK_INT < 23 || (fingerprintManagerB = b(this.f419a)) == null) {
            return;
        }
        fingerprintManagerB.authenticate(a(cVar), bVar != null ? (CancellationSignal) bVar.d() : null, i, a(abstractC0030a), handler);
    }

    @ao(a = "android.permission.USE_FINGERPRINT")
    public boolean a() {
        FingerprintManager fingerprintManagerB;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerB = b(this.f419a)) != null && fingerprintManagerB.hasEnrolledFingerprints();
    }

    @ao(a = "android.permission.USE_FINGERPRINT")
    public boolean b() {
        FingerprintManager fingerprintManagerB;
        return Build.VERSION.SDK_INT >= 23 && (fingerprintManagerB = b(this.f419a)) != null && fingerprintManagerB.isHardwareDetected();
    }
}
