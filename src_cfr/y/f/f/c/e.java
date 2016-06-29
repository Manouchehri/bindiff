/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.c;

import y.c.D;
import y.f.f.c.g;
import y.f.f.c.p;

class e {
    p a;
    D b = new D();

    e(p p2) {
        this.a = p2;
    }

    public g[] a(g g2) {
        y.c.p p2;
        y.c.p p3;
        g[] arrg;
        block3 : {
            int n2 = g.a;
            arrg = new g[]{null, null};
            p3 = this.b.k();
            p2 = null;
            while (p3 != null) {
                g g3 = (g)this.b.g(p3);
                if (n2 == 0) {
                    if (g3.i() >= g2.i()) break;
                    p2 = p3;
                    p3 = this.b.c(p3);
                    if (n2 == 0) continue;
                }
                break block3;
            }
            this.b.a(g2, p3);
        }
        if (p2 != null) {
            arrg[0] = (g)this.b.g(p2);
        }
        if (p3 == null) return arrg;
        arrg[1] = (g)this.b.g(p3);
        return arrg;
    }

    public void b(g g2) {
        this.b.remove(g2);
    }
}

