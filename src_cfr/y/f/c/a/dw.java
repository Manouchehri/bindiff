/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.q;
import y.f.c.a.dt;
import y.g.e;

class dw
implements Comparator {
    private final int[] a;
    private final dt b;

    dw(dt dt2, int[] arrn) {
        this.b = dt2;
        this.a = arrn;
    }

    public int compare(Object object, Object object2) {
        return e.a(this.a[((q)object).d()], this.a[((q)object2).d()]);
    }
}

