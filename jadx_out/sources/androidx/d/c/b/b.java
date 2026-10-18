package androidx.d.c.b;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f676a = false;
    private static final boolean b = false;

    /* JADX WARN: Code duplicated, block: B:106:0x01af  */
    /* JADX WARN: Code duplicated, block: B:18:0x0037 A[PHI: r6 r8
      0x0037: PHI (r6v51 boolean) = (r6v3 boolean), (r6v54 boolean) binds: [B:30:0x0053, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0037: PHI (r8v40 boolean) = (r8v1 boolean), (r8v43 boolean) binds: [B:30:0x0053, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x0039 A[PHI: r6 r8
      0x0039: PHI (r6v5 boolean) = (r6v3 boolean), (r6v54 boolean) binds: [B:30:0x0053, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
      0x0039: PHI (r8v3 boolean) = (r8v1 boolean), (r8v43 boolean) binds: [B:30:0x0053, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:300:0x0553 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:305:0x0567  */
    /* JADX WARN: Code duplicated, block: B:306:0x056c  */
    /* JADX WARN: Code duplicated, block: B:309:0x0572  */
    /* JADX WARN: Code duplicated, block: B:311:0x057a  */
    /* JADX WARN: Code duplicated, block: B:313:0x057f  */
    /* JADX WARN: Code duplicated, block: B:315:0x0587  */
    /* JADX WARN: Code duplicated, block: B:316:0x058c  */
    /* JADX WARN: Code duplicated, block: B:318:0x0590  */
    /* JADX WARN: Code duplicated, block: B:320:0x059a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:345:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    static void a(f fVar, androidx.d.c.e eVar, int i, int i2, c cVar) {
        boolean z;
        boolean z2;
        boolean z3;
        e eVar2;
        d dVar;
        int i3;
        d dVar2;
        androidx.d.c.i iVar;
        androidx.d.c.i iVar2;
        e eVar3;
        d dVar3;
        int i4;
        androidx.d.c.e eVar4;
        int i5;
        d dVar4;
        androidx.d.c.i iVar3;
        androidx.d.c.i iVar4;
        int i6;
        androidx.d.c.i iVar5;
        androidx.d.c.i iVar6;
        d dVar5;
        int i7;
        int size;
        int i8;
        e eVar5 = cVar.f677a;
        e eVar6 = cVar.c;
        e eVar7 = cVar.b;
        e eVar8 = cVar.d;
        e eVar9 = cVar.e;
        float f = cVar.k;
        e eVar10 = cVar.f;
        e eVar11 = cVar.g;
        boolean z4 = fVar.ak[i] == e.a.WRAP_CONTENT;
        if (i == 0) {
            z = eVar9.aN == 0;
            z2 = eVar9.aN == 1;
            if (eVar9.aN == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z = eVar9.aO == 0;
            z2 = eVar9.aO == 1;
            if (eVar9.aO == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        boolean z5 = z3;
        boolean z6 = z2;
        boolean z7 = z;
        e eVar12 = eVar5;
        boolean z8 = false;
        while (true) {
            e eVar13 = null;
            if (z8) {
                break;
            }
            d dVar6 = eVar12.ag[i2];
            int i9 = z5 ? 1 : 4;
            int iJ = dVar6.j();
            float f2 = f;
            boolean z9 = z8;
            boolean z10 = eVar12.ak[i] == e.a.MATCH_CONSTRAINT && eVar12.I[i] == 0;
            if (dVar6.c != null && eVar12 != eVar5) {
                iJ += dVar6.c.j();
            }
            int i10 = iJ;
            if (z5 && eVar12 != eVar5 && eVar12 != eVar7) {
                i9 = 8;
            }
            if (dVar6.c != null) {
                if (eVar12 == eVar7) {
                    eVar.a(dVar6.f, dVar6.c.f, i10, 6);
                } else {
                    eVar.a(dVar6.f, dVar6.c.f, i10, 8);
                }
                eVar.c(dVar6.f, dVar6.c.f, i10, (!z10 || z5) ? i9 : 5);
            } else {
                eVar5 = eVar5;
                eVar7 = eVar7;
            }
            if (z4) {
                if (eVar12.E() == 8 || eVar12.ak[i] != e.a.MATCH_CONSTRAINT) {
                    i8 = 0;
                } else {
                    i8 = 0;
                    eVar.a(eVar12.ag[i2 + 1].f, eVar12.ag[i2].f, 0, 5);
                }
                eVar.a(eVar12.ag[i2].f, fVar.ag[i2].f, i8, 8);
            }
            d dVar7 = eVar12.ag[i2 + 1].c;
            if (dVar7 != null) {
                e eVar14 = dVar7.f678a;
                if (eVar14.ag[i2].c != null && eVar14.ag[i2].c.f678a == eVar12) {
                    eVar13 = eVar14;
                }
            }
            if (eVar13 != null) {
                eVar12 = eVar13;
                z8 = z9;
            } else {
                z8 = true;
            }
            f = f2;
            eVar9 = eVar9;
            eVar5 = eVar5;
            eVar7 = eVar7;
        }
        e eVar15 = eVar9;
        float f3 = f;
        e eVar16 = eVar5;
        e eVar17 = eVar7;
        if (eVar8 != null) {
            int i11 = i2 + 1;
            if (eVar6.ag[i11].c != null) {
                d dVar8 = eVar8.ag[i11];
                if ((eVar8.ak[i] == e.a.MATCH_CONSTRAINT && eVar8.I[i] == 0) && !z5 && dVar8.c.f678a == fVar) {
                    eVar.c(dVar8.f, dVar8.c.f, -dVar8.j(), 5);
                } else if (z5 && dVar8.c.f678a == fVar) {
                    eVar.c(dVar8.f, dVar8.c.f, -dVar8.j(), 4);
                }
                eVar.b(dVar8.f, eVar6.ag[i11].c.f, -dVar8.j(), 6);
            }
        }
        if (z4) {
            int i12 = i2 + 1;
            eVar.a(fVar.ag[i12].f, eVar6.ag[i12].f, eVar6.ag[i12].j(), 8);
        }
        ArrayList<e> arrayList = cVar.h;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f4 = (!cVar.p || cVar.r) ? f3 : cVar.j;
            float f5 = 0.0f;
            float f6 = 0.0f;
            e eVar18 = null;
            int i13 = 0;
            while (i13 < size) {
                e eVar19 = arrayList.get(i13);
                float f7 = eVar19.aR[i];
                if (f7 < f5) {
                    if (cVar.r) {
                        eVar.c(eVar19.ag[i2 + 1].f, eVar19.ag[i2].f, 0, 4);
                    } else {
                        f7 = 1.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i13++;
                    arrayList = arrayList;
                    size = size;
                    f5 = 0.0f;
                }
                if (f7 == 0.0f) {
                    eVar.c(eVar19.ag[i2 + 1].f, eVar19.ag[i2].f, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (eVar18 != null) {
                        androidx.d.c.i iVar7 = eVar18.ag[i2].f;
                        int i14 = i2 + 1;
                        androidx.d.c.i iVar8 = eVar18.ag[i14].f;
                        androidx.d.c.i iVar9 = eVar19.ag[i2].f;
                        androidx.d.c.i iVar10 = eVar19.ag[i14].f;
                        androidx.d.c.b bVarC = eVar.c();
                        bVarC.a(f6, f4, f7, iVar7, iVar8, iVar9, iVar10);
                        eVar.a(bVarC);
                    }
                    f6 = f7;
                    eVar18 = eVar19;
                }
                i13++;
                arrayList = arrayList;
                size = size;
                f5 = 0.0f;
            }
        }
        if (eVar17 != null) {
            eVar2 = eVar17;
            if (eVar2 == eVar8 || z5) {
                d dVar9 = eVar16.ag[i2];
                int i15 = i2 + 1;
                d dVar10 = eVar6.ag[i15];
                androidx.d.c.i iVar11 = dVar9.c != null ? dVar9.c.f : null;
                androidx.d.c.i iVar12 = dVar10.c != null ? dVar10.c.f : null;
                d dVar11 = eVar2.ag[i2];
                d dVar12 = eVar8.ag[i15];
                if (iVar11 != null && iVar12 != null) {
                    eVar.a(dVar11.f, iVar11, dVar11.j(), i == 0 ? eVar15.aA : eVar15.aB, iVar12, dVar12.f, dVar12.j(), 7);
                }
                eVar6 = eVar6;
            }
            if ((z7 && !z6) || eVar2 == null || eVar2 == eVar8) {
                return;
            }
            dVar = eVar2.ag[i2];
            i3 = i2 + 1;
            dVar2 = eVar8.ag[i3];
            if (dVar.c != null) {
                iVar = dVar.c.f;
            } else {
                iVar = null;
            }
            if (dVar2.c != null) {
                iVar2 = dVar2.c.f;
            } else {
                iVar2 = null;
            }
            eVar3 = eVar6;
            if (eVar3 != eVar8) {
                dVar3 = eVar3.ag[i3];
                if (dVar3.c != null) {
                    iVar2 = dVar3.c.f;
                } else {
                    iVar2 = null;
                }
            }
            if (eVar2 == eVar8) {
                dVar = eVar2.ag[i2];
                dVar2 = eVar2.ag[i3];
            }
            if (iVar != null || iVar2 == null) {
            }
            int iJ2 = dVar.j();
            if (eVar8 == null) {
                eVar8 = eVar3;
            }
            eVar.a(dVar.f, iVar, iJ2, 0.5f, iVar2, dVar2.f, eVar8.ag[i3].j(), 5);
            return;
        }
        eVar2 = eVar17;
        if (!z7 || eVar2 == null) {
            int i16 = 8;
            if (z6 && eVar2 != null) {
                boolean z11 = cVar.j > 0 && cVar.i == cVar.j;
                e eVar20 = eVar2;
                e eVar21 = eVar20;
                while (eVar21 != null) {
                    e eVar22 = eVar21.aT[i];
                    while (eVar22 != null && eVar22.E() == i16) {
                        eVar22 = eVar22.aT[i];
                    }
                    if (eVar21 == eVar2 || eVar21 == eVar8 || eVar22 == null) {
                        eVar20 = eVar20;
                        eVar21 = eVar21;
                        eVar21 = eVar22;
                    } else {
                        e eVar23 = eVar22 == eVar8 ? null : eVar22;
                        d dVar13 = eVar21.ag[i2];
                        androidx.d.c.i iVar13 = dVar13.f;
                        if (dVar13.c != null) {
                            androidx.d.c.i iVar14 = dVar13.c.f;
                        }
                        int i17 = i2 + 1;
                        androidx.d.c.i iVar15 = eVar20.ag[i17].f;
                        int iJ3 = dVar13.j();
                        int iJ4 = eVar21.ag[i17].j();
                        if (eVar23 != null) {
                            dVar4 = eVar23.ag[i2];
                            androidx.d.c.i iVar16 = dVar4.f;
                            iVar4 = dVar4.c != null ? dVar4.c.f : null;
                            iVar3 = iVar16;
                        } else {
                            dVar4 = eVar8.ag[i2];
                            iVar3 = dVar4 != null ? dVar4.f : null;
                            iVar4 = eVar21.ag[i17].f;
                        }
                        if (dVar4 != null) {
                            iJ4 += dVar4.j();
                        }
                        int i18 = iJ4;
                        if (eVar20 != null) {
                            iJ3 += eVar20.ag[i17].j();
                        }
                        int i19 = iJ3;
                        int i20 = z11 ? 8 : 4;
                        if (iVar13 != null && iVar15 != null && iVar3 != null && iVar4 != null) {
                            eVar.a(iVar13, iVar15, i19, 0.5f, iVar3, iVar4, i18, i20);
                        }
                        eVar21 = eVar23;
                    }
                    eVar20 = eVar21.E() != 8 ? eVar21 : eVar20;
                    i16 = 8;
                }
                d dVar14 = eVar2.ag[i2];
                d dVar15 = eVar16.ag[i2].c;
                int i21 = i2 + 1;
                d dVar16 = eVar8.ag[i21];
                d dVar17 = eVar6.ag[i21].c;
                if (dVar15 != null) {
                    if (eVar2 != eVar8) {
                        i5 = 5;
                        eVar4 = eVar;
                        eVar4.c(dVar14.f, dVar15.f, dVar14.j(), 5);
                    } else {
                        i5 = 5;
                        eVar4 = eVar;
                        if (dVar17 != null) {
                            i4 = 5;
                            eVar.a(dVar14.f, dVar15.f, dVar14.j(), 0.5f, dVar16.f, dVar17.f, dVar16.j(), 5);
                        }
                    }
                    i4 = i5;
                } else {
                    i4 = 5;
                    eVar4 = eVar;
                }
                if (dVar17 != null && eVar2 != eVar8) {
                    eVar4.c(dVar16.f, dVar17.f, -dVar16.j(), i4);
                }
            }
            if (z7) {
            }
            dVar = eVar2.ag[i2];
            i3 = i2 + 1;
            dVar2 = eVar8.ag[i3];
            if (dVar.c != null) {
                iVar = dVar.c.f;
            } else {
                iVar = null;
            }
            if (dVar2.c != null) {
                iVar2 = dVar2.c.f;
            } else {
                iVar2 = null;
            }
            eVar3 = eVar6;
            if (eVar3 != eVar8) {
                dVar3 = eVar3.ag[i3];
                if (dVar3.c != null) {
                    iVar2 = dVar3.c.f;
                } else {
                    iVar2 = null;
                }
            }
            if (eVar2 == eVar8) {
                dVar = eVar2.ag[i2];
                dVar2 = eVar2.ag[i3];
            }
            if (iVar != null) {
            }
        }
        boolean z12 = cVar.j > 0 && cVar.i == cVar.j;
        e eVar24 = eVar2;
        e eVar25 = eVar24;
        while (eVar25 != null) {
            e eVar26 = eVar25.aT[i];
            while (true) {
                if (eVar26 == null) {
                    i6 = 8;
                    break;
                }
                i6 = 8;
                if (eVar26.E() != 8) {
                    break;
                } else {
                    eVar26 = eVar26.aT[i];
                }
            }
            if (eVar26 != null || eVar25 == eVar8) {
                d dVar18 = eVar25.ag[i2];
                androidx.d.c.i iVar17 = dVar18.f;
                androidx.d.c.i iVar18 = dVar18.c != null ? dVar18.c.f : null;
                if (eVar24 != eVar25) {
                    iVar18 = eVar24.ag[i2 + 1].f;
                } else if (eVar25 == eVar2 && eVar24 == eVar25) {
                    iVar18 = eVar16.ag[i2].c != null ? eVar16.ag[i2].c.f : null;
                }
                int iJ5 = dVar18.j();
                int i22 = i2 + 1;
                int iJ6 = eVar25.ag[i22].j();
                if (eVar26 != null) {
                    d dVar19 = eVar26.ag[i2];
                    iVar5 = dVar19.f;
                    dVar5 = dVar19;
                    iVar6 = eVar25.ag[i22].f;
                } else {
                    d dVar20 = eVar6.ag[i22].c;
                    iVar5 = dVar20 != null ? dVar20.f : null;
                    iVar6 = eVar25.ag[i22].f;
                    dVar5 = dVar20;
                }
                androidx.d.c.i iVar19 = iVar5;
                androidx.d.c.i iVar20 = iVar6;
                if (dVar5 != null) {
                    iJ6 += dVar5.j();
                }
                if (eVar24 != null) {
                    iJ5 += eVar24.ag[i22].j();
                }
                if (iVar17 == null || iVar18 == null || iVar19 == null || iVar20 == null) {
                    i7 = 8;
                } else {
                    if (eVar25 == eVar2) {
                        iJ5 = eVar2.ag[i2].j();
                    }
                    int i23 = iJ5;
                    if (eVar25 == eVar8) {
                        iJ6 = eVar8.ag[i22].j();
                    }
                    i7 = 8;
                    eVar.a(iVar17, iVar18, i23, 0.5f, iVar19, iVar20, iJ6, z12 ? 8 : 5);
                }
            } else {
                i7 = i6;
            }
            eVar24 = eVar25.E() != i7 ? eVar25 : eVar24;
            eVar25 = eVar26;
        }
        eVar6 = eVar6;
        if (z7) {
        }
        dVar = eVar2.ag[i2];
        i3 = i2 + 1;
        dVar2 = eVar8.ag[i3];
        if (dVar.c != null) {
            iVar = dVar.c.f;
        } else {
            iVar = null;
        }
        if (dVar2.c != null) {
            iVar2 = dVar2.c.f;
        } else {
            iVar2 = null;
        }
        eVar3 = eVar6;
        if (eVar3 != eVar8) {
            dVar3 = eVar3.ag[i3];
            if (dVar3.c != null) {
                iVar2 = dVar3.c.f;
            } else {
                iVar2 = null;
            }
        }
        if (eVar2 == eVar8) {
            dVar = eVar2.ag[i2];
            dVar2 = eVar2.ag[i3];
        }
        if (iVar != null) {
        }
    }

    public static void a(f fVar, androidx.d.c.e eVar, ArrayList<e> arrayList, int i) {
        int i2;
        int i3;
        c[] cVarArr;
        if (i == 0) {
            int i4 = fVar.bd;
            cVarArr = fVar.bg;
            i3 = i4;
            i2 = 0;
        } else {
            i2 = 2;
            i3 = fVar.be;
            cVarArr = fVar.bf;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            c cVar = cVarArr[i5];
            cVar.i();
            if (arrayList == null || (arrayList != null && arrayList.contains(cVar.f677a))) {
                a(fVar, eVar, i, i2, cVar);
            }
        }
    }
}
