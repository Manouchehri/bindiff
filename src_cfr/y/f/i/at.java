/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.c;
import y.c.d;
import y.c.q;
import y.f.i.ar;
import y.g.p;

class at
extends p {
    private final c a;
    private final ar b;

    at(ar ar2, c c2) {
        this.b = ar2;
        this.a = c2;
    }

    @Override
    public boolean d(Object object) {
        d d2 = (d)object;
        if (this.a == null) {
            return true;
        }
        if (this.a.d(d2.c())) return true;
        if (this.a.d(d2.d())) return true;
        return false;
    }
}

