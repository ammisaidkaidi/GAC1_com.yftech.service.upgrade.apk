package androidx.d.b.b;

/* JADX INFO: loaded from: classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f604a = "TransitionBuilder";

    public static u.a a(u uVar, int i, int i2, androidx.d.e.g gVar, int i3, androidx.d.e.g gVar2) {
        u.a aVar = new u.a(i, uVar, i2, i3);
        a(uVar, aVar, gVar, gVar2);
        return aVar;
    }

    public static void a(s sVar) {
        if (sVar.i == null) {
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
        u uVar = sVar.i;
        if (!uVar.a(sVar)) {
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        if (uVar.f == null || uVar.a().isEmpty()) {
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }

    private static void a(u uVar, u.a aVar, androidx.d.e.g gVar, androidx.d.e.g gVar2) {
        int iE = aVar.e();
        int iD = aVar.d();
        uVar.a(iE, gVar);
        uVar.a(iD, gVar2);
    }
}
