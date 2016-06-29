/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.Iterator;
import y.c.i;
import y.c.q;
import y.f.h.a.k;
import y.f.h.a.l;
import y.f.h.a.s;

class j
extends s {
    j() {
    }

    j(i i2) {
        super(i2);
    }

    @Override
    protected void a() {
    }

    @Override
    Iterator a(q q2) {
        return new k(this, q2);
    }

    @Override
    Iterator b() {
        return new l(this);
    }
}

