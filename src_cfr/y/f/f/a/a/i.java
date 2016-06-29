/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.a;

import y.c.D;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.b.c;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.p;

public class i {
    public static p a(X x2) {
        c c2;
        boolean bl2;
        p p2;
        block4 : {
            bl2 = f.e;
            c c3 = new c(x2);
            p2 = new p(x2);
            D d2 = new D();
            D d3 = new D();
            p2.a((b)null);
            d3.c(p2.a());
            d2.c(c3.b());
            block0 : do {
                boolean bl3 = d2.isEmpty();
                block1 : while (!bl3) {
                    q q2 = (q)d2.g();
                    b b2 = (b)d3.g();
                    x x3 = c3.b(q2).a();
                    do {
                        if (!x3.f()) continue block0;
                        q q3 = x3.e();
                        b b3 = p2.a(b2, null, q3);
                        b2.a(b3);
                        c2 = c3;
                        if (bl2) break block4;
                        bl3 = c2.d(q3);
                        if (bl2) continue block1;
                        if (bl3) {
                            d3.c(b3);
                            d2.c(q3);
                        }
                        x3.g();
                    } while (!bl2);
                }
                break block0;
                break;
            } while (true);
            c2 = c3;
        }
        c2.c();
        if (!y.c.i.g) return p2;
        f.e = !bl2;
        return p2;
    }
}

