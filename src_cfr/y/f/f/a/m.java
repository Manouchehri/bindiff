/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a;

import y.c.d;
import y.c.q;
import y.d.t;
import y.d.u;
import y.d.v;
import y.f.X;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.h;
import y.f.f.a.f;
import y.f.f.a.k;
import y.f.f.a.l;

class m
implements h {
    private final k a;

    private m(k k2) {
        this.a = k2;
    }

    @Override
    public void a(e e2) {
        double d2;
        q q2;
        double d3;
        X x2;
        block9 : {
            boolean bl2 = f.a;
            if (e2.e()) {
                return;
            }
            if (e2.d()) {
                return;
            }
            b b2 = (b)e2;
            q2 = b2.b_();
            k.a(this.a).d(q2);
            d2 = Double.MAX_VALUE;
            double d4 = -1.7976931348623157E308;
            d3 = Double.MAX_VALUE;
            double d5 = -1.7976931348623157E308;
            y.c.e e3 = k.b(this.a).g(q2).a();
            block0 : do {
                int n2 = e3.f();
                block1 : while (n2 != 0) {
                    d d6 = e3.a();
                    x2 = k.a(this.a);
                    if (bl2) break block9;
                    u u2 = x2.j(d6).b();
                    while (u2.f()) {
                        double d7 = u2.a().a();
                        double d8 = u2.a().b();
                        n2 = d7 DCMPG d2;
                        if (bl2) continue block1;
                        if (n2 < 0) {
                            d2 = d7;
                        }
                        if (d7 > d4) {
                            d4 = d7;
                        }
                        if (d8 < d3) {
                            d3 = d8;
                        }
                        if (d8 > d5) {
                            d5 = d8;
                        }
                        u2.g();
                        if (!bl2) continue;
                    }
                    e3.g();
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            k.a(this.a).b(q2, d4 - d2, d5 - d3);
            x2 = k.a(this.a);
        }
        x2.c(q2, d2, d3);
    }

    m(k k2, l l2) {
        this(k2);
    }
}

