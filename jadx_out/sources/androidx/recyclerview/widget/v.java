package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f1100a;

    interface a {
        androidx.recyclerview.widget.a.b a(int i, int i2, int i3, Object obj);

        void a(androidx.recyclerview.widget.a.b bVar);
    }

    v(a aVar) {
        this.f1100a = aVar;
    }

    private void a(List<androidx.recyclerview.widget.a.b> list, int i, int i2) {
        androidx.recyclerview.widget.a.b bVar = list.get(i);
        androidx.recyclerview.widget.a.b bVar2 = list.get(i2);
        int i3 = bVar2.f;
        if (i3 == 4) {
            b(list, i, bVar, i2, bVar2);
        }
        switch (i3) {
            case 1:
                c(list, i, bVar, i2, bVar2);
                break;
            case 2:
                a(list, i, bVar, i2, bVar2);
                break;
        }
    }

    private int b(List<androidx.recyclerview.widget.a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        int i3 = bVar.i < bVar2.g ? -1 : 0;
        if (bVar.g < bVar2.g) {
            i3++;
        }
        if (bVar2.g <= bVar.g) {
            bVar.g += bVar2.i;
        }
        if (bVar2.g <= bVar.i) {
            bVar.i += bVar2.i;
        }
        bVar2.g += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void a(List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            int iB = b(list);
            if (iB == -1) {
                return;
            } else {
                a(list, iB, iB + 1);
            }
        }
    }

    void a(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        boolean z;
        boolean z2 = false;
        if (bVar.g < bVar.i) {
            if (bVar2.g == bVar.g && bVar2.i == bVar.i - bVar.g) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.g == bVar.i + 1 && bVar2.i == bVar.g - bVar.i) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        if (bVar.i < bVar2.g) {
            bVar2.g--;
        } else if (bVar.i < bVar2.g + bVar2.i) {
            bVar2.i--;
            bVar.f = 2;
            bVar.i = 1;
            if (bVar2.i == 0) {
                list.remove(i2);
                this.f1100a.a(bVar2);
                return;
            }
            return;
        }
        androidx.recyclerview.widget.a.b bVarA = null;
        if (bVar.g <= bVar2.g) {
            bVar2.g++;
        } else if (bVar.g < bVar2.g + bVar2.i) {
            bVarA = this.f1100a.a(2, bVar.g + 1, (bVar2.g + bVar2.i) - bVar.g, null);
            bVar2.i = bVar.g - bVar2.g;
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.f1100a.a(bVar);
            return;
        }
        if (z) {
            if (bVarA != null) {
                if (bVar.g > bVarA.g) {
                    bVar.g -= bVarA.i;
                }
                if (bVar.i > bVarA.g) {
                    bVar.i -= bVarA.i;
                }
            }
            if (bVar.g > bVar2.g) {
                bVar.g -= bVar2.i;
            }
            if (bVar.i > bVar2.g) {
                bVar.i -= bVar2.i;
            }
        } else {
            if (bVarA != null) {
                if (bVar.g >= bVarA.g) {
                    bVar.g -= bVarA.i;
                }
                if (bVar.i >= bVarA.g) {
                    bVar.i -= bVarA.i;
                }
            }
            if (bVar.g >= bVar2.g) {
                bVar.g -= bVar2.i;
            }
            if (bVar.i >= bVar2.g) {
                bVar.i -= bVar2.i;
            }
        }
        list.set(i, bVar2);
        if (bVar.g != bVar.i) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002f  */
    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:14:0x003e  */
    /* JADX WARN: Code duplicated, block: B:17:0x005d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void b(List<androidx.recyclerview.widget.a.b> list, int i, androidx.recyclerview.widget.a.b bVar, int i2, androidx.recyclerview.widget.a.b bVar2) {
        androidx.recyclerview.widget.a.b bVarA;
        androidx.recyclerview.widget.a.b bVarA2 = null;
        if (bVar.i >= bVar2.g) {
            if (bVar.i < bVar2.g + bVar2.i) {
                bVar2.i--;
                bVarA = this.f1100a.a(4, bVar.g, 1, bVar2.h);
            }
            if (bVar.g <= bVar2.g) {
                bVar2.g++;
            } else if (bVar.g < bVar2.g + bVar2.i) {
                int i3 = (bVar2.g + bVar2.i) - bVar.g;
                bVarA2 = this.f1100a.a(4, bVar.g + 1, i3, bVar2.h);
                bVar2.i -= i3;
            }
            list.set(i2, bVar);
            if (bVar2.i > 0) {
                list.set(i, bVar2);
            } else {
                list.remove(i);
                this.f1100a.a(bVar2);
            }
            if (bVarA != null) {
                list.add(i, bVarA);
            }
            if (bVarA2 != null) {
                list.add(i, bVarA2);
            }
        }
        bVar2.g--;
        bVarA = null;
        if (bVar.g <= bVar2.g) {
            bVar2.g++;
        } else if (bVar.g < bVar2.g + bVar2.i) {
            int i4 = (bVar2.g + bVar2.i) - bVar.g;
            bVarA2 = this.f1100a.a(4, bVar.g + 1, i4, bVar2.h);
            bVar2.i -= i4;
        }
        list.set(i2, bVar);
        if (bVar2.i > 0) {
            list.set(i, bVar2);
        } else {
            list.remove(i);
            this.f1100a.a(bVar2);
        }
        if (bVarA != null) {
            list.add(i, bVarA);
        }
        if (bVarA2 != null) {
            list.add(i, bVarA2);
        }
    }
}
