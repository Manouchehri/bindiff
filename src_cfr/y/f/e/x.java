/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.c.c;
import y.f.X;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.i;
import y.f.e.q;

class x
implements am {
    private final q a;

    x(q q2) {
        this.a = q2;
    }

    @Override
    public void a(l l2, af af2) {
        boolean bl2 = i.b;
        X x2 = af2.f();
        c c2 = x2.c(q.n);
        if (c2 == null) return;
        y.c.x x3 = x2.o();
        do {
            if (!x3.f()) return;
            y.c.q q2 = x3.e();
            if (!c2.d(q2)) {
                af2.c(q2).d(1.0);
            }
            x3.g();
        } while (!bl2);
    }
}

