/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.f.c.a.dg;

class dh
implements Comparator {
    private final float[] a;
    private final dg b;

    dh(dg dg2, float[] arrf) {
        this.b = dg2;
        this.a = arrf;
    }

    public int compare(Object object, Object object2) {
        float f2;
        float f3 = object instanceof dg ? dg.a((dg)object) : this.a[((q)object).d()];
        float f4 = f2 = object2 instanceof dg ? dg.a((dg)object2) : this.a[((q)object2).d()];
        if (f3 < f2) {
            return -1;
        }
        if (f3 <= f2) return 0;
        return 1;
    }
}

