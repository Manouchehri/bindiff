/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.c.c;
import y.c.d;
import y.c.h;
import y.f.f.e.k;
import y.f.h.N;
import y.f.h.p;

class l
extends y.g.p {
    private final h a;
    private final c b;
    private final N d;
    private final k e;

    l(k k2, h h2, c c2, N n2) {
        this.e = k2;
        this.a = h2;
        this.b = c2;
        this.d = n2;
    }

    @Override
    public boolean d(Object object) {
        d d2 = (d)object;
        if (((String)this.a.b(d2)).length() > 0) return true;
        if (this.b.d(this.d.i(d2))) return true;
        if (this.b.d(this.d.i(this.d.h(d2)))) return true;
        return false;
    }
}

