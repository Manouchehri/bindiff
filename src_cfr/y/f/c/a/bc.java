/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.d.t;
import y.f.c.a.bF;
import y.f.c.a.by;
import y.g.e;

class bC
implements Comparator {
    private final by a;

    bC(by by2) {
        this.a = by2;
    }

    public int compare(Object object, Object object2) {
        bF bF2 = (bF)object;
        bF bF3 = (bF)object2;
        return e.a(bF2.e().a, bF3.e().a);
    }
}

