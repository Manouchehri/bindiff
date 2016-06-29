/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.q;
import y.c.x;
import y.f.X;
import y.f.a.f;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;

class n
implements am {
    n() {
    }

    @Override
    public void a(l l2, af af2) {
        int n2 = f.u;
        X x2 = af2.f();
        x x3 = x2.o();
        do {
            if (!x3.f()) return;
            q q2 = x3.e();
            af2.c(q2).f(Math.max(x2.p(q2), x2.q(q2)));
            x3.g();
        } while (n2 == 0);
    }
}

