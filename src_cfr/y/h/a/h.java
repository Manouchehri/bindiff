/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import y.c.q;
import y.g.p;
import y.h.a.v;

class H
extends p {
    private final v a;

    H(v v2) {
        this.a = v2;
    }

    @Override
    public boolean d(Object object) {
        return this.a.k((q)object);
    }

    @Override
    public Object b(Object object) {
        Boolean bl2;
        if (this.a.k((q)object)) {
            bl2 = Boolean.TRUE;
            return bl2;
        }
        bl2 = Boolean.FALSE;
        return bl2;
    }
}

