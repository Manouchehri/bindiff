/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.b.c;
import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.z;

final class C
implements am {
    private final z a;

    C(z z2) {
        this.a = z2;
    }

    @Override
    public void a(l l2, af af2) {
        c c2;
        Object object;
        boolean bl2;
        block8 : {
            bl2 = af.b;
            this.a.a = null;
            this.a.b = null;
            X x2 = af2.f();
            if (!c.b(x2)) {
                return;
            }
            this.a.a = c2 = new c(x2);
            x x3 = x2.o();
            while (x3.f()) {
                q q2 = x3.e();
                object = af2.c(q2);
                if (!bl2) {
                    if (c2.d(q2)) {
                        object.b(true);
                    }
                    if (c2.a(q2) != c2.b()) {
                        object.a(af2.a(c2.a(q2)));
                    }
                    x3.g();
                    if (!bl2) continue;
                }
                break block8;
            }
            this.a.b = c2.c(c2.b());
        }
        double d2 = l2.h() * 0.5 + l2.g() * 0.5;
        object = this.a.b.l();
        block1 : do {
            if (object == null) return;
            q q3 = (q)object.c();
            if (c2.d(q3) && !af2.a(q3).n()) {
                double d3;
                double d4;
                double d5 = 0.0;
                y y2 = c2.b(q3);
                double d6 = Double.MAX_VALUE;
                double d7 = Double.MAX_VALUE;
                double d8 = Double.MAX_VALUE;
                double d9 = -1.7976931348623157E308;
                double d10 = -1.7976931348623157E308;
                double d11 = -1.7976931348623157E308;
                for (p p2 = y2.k(); p2 != null; d5 += d3 * d3 * 3.0, p2 = p2.a()) {
                    q q4 = (q)p2.c();
                    m m2 = af2.a(q4);
                    d3 = m2.h();
                    d4 = m2.b();
                    double d12 = m2.c();
                    double d13 = m2.d();
                    double d14 = m2.h();
                    d6 = Math.min(d6, d4 - d14);
                    d9 = Math.max(d9, d4 + d14);
                    d7 = Math.min(d7, d12 - d14);
                    d10 = Math.max(d10, d12 + d14);
                    d8 = Math.min(d8, d13 - d14);
                    d11 = Math.max(d11, d13 + d14);
                    if (bl2) continue block1;
                    if (!bl2) continue;
                }
                double d15 = d5 / (double)(y2.size() + 1);
                d15 = Math.sqrt(d15) + d2 * 0.9;
                d15 *= d15;
                double d16 = Math.sqrt(d15 * (double)y2.size()) * 0.5 + d2;
                ag ag2 = af2.c(q3);
                ag2.e(d16 * 0.9);
                d4 = (d9 - d6) / 2.0;
                d4 = Math.max(d4, (d10 - d7) / 2.0);
                d4 = Math.max(d4, (d11 - d8) / 2.0);
                d4 = Math.max(50.0, d4);
                ag2.f(d4);
            }
            object = object.b();
        } while (!bl2);
    }
}

