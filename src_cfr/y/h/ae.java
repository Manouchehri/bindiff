/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.g.p;
import y.h.aC;

class aE
extends p {
    private final aC a;

    aE(aC aC2) {
        this.a = aC2;
    }

    @Override
    public boolean d(Object object) {
        if (!(object instanceof d)) return false;
        d d2 = (d)object;
        return this.a.isOrthogonalRouting(d2);
    }
}

