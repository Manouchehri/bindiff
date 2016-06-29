/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.q;
import y.c.x;
import y.f.a.f;
import y.f.a.j;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;

class r
implements am {
    private final j a;

    r(j j2) {
        this.a = j2;
    }

    @Override
    public void a(l l2, af af2) {
        int n2 = f.u;
        x x2 = j.a(this.a).a();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            af2.c(q2).d(1.0);
            x2.g();
        } while (n2 == 0);
    }
}

