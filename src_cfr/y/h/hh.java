/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.d;
import y.c.i;
import y.c.q;
import y.h.aB;
import y.h.bu;

class hH
extends d {
    aB l;

    protected hH(bu bu2, q q2, d d2, q q3, d d3, int n2, int n3, aB aB2) {
        super(bu2, q2, d2, q3, d3, n2, n3);
        if (aB2 == null) return;
        this.l = aB2;
        aB2.bindEdge(this);
    }

    @Override
    public d a(i i2, q q2, q q3) {
        if (!(i2 instanceof bu)) return super.a(i2, q2, q3);
        return new hH((bu)i2, q2, null, q3, null, 0, 0, this.l.createCopy());
    }

    @Override
    protected void f() {
        super.f();
        if (this.l == null) return;
        this.l.setDirty();
    }
}

