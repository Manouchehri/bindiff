/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.e;
import y.c.B;
import y.c.d;
import y.c.q;

class C
extends e {
    C() {
        this.a(false);
    }

    @Override
    protected void a(d d2, q q2, boolean bl2) {
        if (bl2) return;
        throw new B(null);
    }

    @Override
    protected void a(q q2) {
        throw new B(null);
    }
}

