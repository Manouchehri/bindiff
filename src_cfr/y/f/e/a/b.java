/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.p;
import y.c.q;
import y.c.y;
import y.f.b.c;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.z;

final class B
implements am {
    private final z a;

    B(z z2) {
        this.a = z2;
    }

    @Override
    public void a(l l2, af af2) {
        boolean bl2 = af.b;
        c c2 = this.a.a;
        if (c2 == null) return;
        p p2 = this.a.b.l();
        block0 : do {
            if (p2 == null) return;
            q q2 = (q)p2.c();
            if (c2.d(q2) && !af2.a(q2).n()) {
                Object object;
                y y2 = c2.b(q2);
                double d2 = Double.MAX_VALUE;
                double d3 = Double.MAX_VALUE;
                double d4 = Double.MAX_VALUE;
                double d5 = -1.7976931348623157E308;
                double d6 = -1.7976931348623157E308;
                double d7 = -1.7976931348623157E308;
                for (object = y2.k(); object != null; object = object.a()) {
                    q q3 = (q)object.c();
                    m m2 = af2.a(q3);
                    double d8 = m2.b();
                    double d9 = m2.c();
                    double d10 = m2.d();
                    double d11 = m2.h();
                    d2 = Math.min(d2, d8 - d11);
                    d5 = Math.max(d5, d8 + d11);
                    d3 = Math.min(d3, d9 - d11);
                    d6 = Math.max(d6, d9 + d11);
                    d4 = Math.min(d4, d10 - d11);
                    d7 = Math.max(d7, d10 + d11);
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
                object = af2.c(q2);
                double d12 = (d5 - d2) / 2.0;
                d12 = Math.max(d12, (d6 - d3) / 2.0);
                d12 = Math.max(d12, (d7 - d4) / 2.0);
                d12 = Math.max(50.0, d12);
                object.f(object.h() * 0.4 + d12 * 0.6);
            }
            p2 = p2.b();
        } while (!bl2);
    }
}

