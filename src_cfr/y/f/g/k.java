/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.A;
import y.c.c;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.g.d;
import y.g.M;
import y.g.p;

class k
extends p {
    private A a;
    private c b;
    private final d d;

    k(d d2, q q2, c c2) {
        boolean bl2 = d.d;
        this.d = d2;
        this.b = c2;
        this.a = M.a();
        x x2 = d.a(d2).c(q2).a();
        do {
            if (!x2.f()) return;
            q q3 = x2.e();
            this.a.a((Object)q3, true);
            x2.g();
        } while (!bl2);
    }

    @Override
    public boolean d(Object object) {
        if (!this.b.d(object)) return false;
        if (this.a.d(object)) return false;
        return true;
    }
}

