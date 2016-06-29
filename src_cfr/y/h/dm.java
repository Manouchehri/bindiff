/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.c.l;
import y.c.o;
import y.h.dI;

class dM
implements o {
    private final d a;
    private final dI b;

    dM(dI dI2, d d2) {
        this.b = dI2;
        this.a = d2;
    }

    @Override
    public void onGraphEvent(l l2) {
        if (l2.a() != 5) return;
        if (!l2.b().equals(this.a)) return;
        dI.c(this.b);
    }
}

