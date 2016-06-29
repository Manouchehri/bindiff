/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.S;
import y.a.T;
import y.a.h;
import y.c.c;
import y.c.d;
import y.c.q;

class U
extends S {
    private U() {
    }

    @Override
    double a(d[] arrd, c c2, int n2) {
        int n3;
        boolean bl2 = h.a;
        int n4 = 0;
        for (int i2 = 0; i2 < arrd.length; ++i2) {
            d d2 = arrd[i2];
            n3 = c2.a(d2.c());
            if (bl2) return n3;
            if (n3 != c2.a(d2.d())) continue;
            ++n4;
            if (!bl2) continue;
        }
        n3 = n4;
        return n3;
    }

    U(T t2) {
        this();
    }
}

