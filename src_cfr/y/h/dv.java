/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.d.t;
import y.h.az;
import y.h.e;
import y.h.ec;
import y.h.ev;
import y.h.gC;

class dV
extends gC {
    private final ev a;

    dV(ev ev2, double d2, az az2, boolean bl2, double d3, Object object) {
        super(d2, az2, bl2, d3, object);
        this.a = ev2;
    }

    @Override
    public az a(e e2, t t2) {
        double d2 = t2.a - e2.k().a;
        double d3 = t2.b - e2.k().b;
        return new ec(this, d2, d3);
    }

    static ev a(dV dV2) {
        return dV2.a;
    }
}

