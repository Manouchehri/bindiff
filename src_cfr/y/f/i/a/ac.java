/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.List;
import y.c.x;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.N;
import y.f.i.a.R;
import y.f.i.a.T;
import y.f.i.a.Z;
import y.f.i.a.ab;

class aC
extends K {
    aC() {
    }

    @Override
    public void a(Z z2, I i2) {
        int n2 = ab.a;
        super.a(z2, i2);
        X x2 = z2.a();
        x x3 = x2.o();
        do {
            if (!x3.f()) return;
            y.c.q q2 = x3.e();
            q q3 = this.a(x2, q2);
            t t2 = x2.l(q2);
            double d2 = t2.a() - q3.a * 0.5;
            double d3 = t2.b() - q3.b * 0.5;
            this.b().a(new y(d2, d3, q3.a, q3.b), q2);
            x3.g();
        } while (n2 == 0);
    }

    @Override
    public void b(R r2) {
        r2.a(T.a, this.b().d(r2));
    }

    protected q a(X x2, y.c.q q2) {
        return x2.r(q2);
    }
}

