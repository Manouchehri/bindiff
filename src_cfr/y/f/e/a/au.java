/*
 * Decompiled with CFR 0_115.
 */
package y.f.e.a;

import y.c.c;
import y.c.d;
import y.c.e;
import y.f.X;
import y.f.e.a.af;
import y.f.e.a.ah;
import y.f.e.a.am;
import y.f.e.a.aq;
import y.f.e.a.ay;
import y.f.e.a.l;

class au
implements am {
    private ay a;

    au(ay ay2) {
        this.a = ay2;
    }

    @Override
    public void a(l l2, af af2) {
        boolean bl2 = af.b;
        c c2 = af2.f().c(ay.n);
        e e2 = af2.f().p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            ah ah2 = (ah)af2.a(d2);
            if (ah2.a() == 0.0 || ah2.a() == 50.0) {
                int n2;
                double d3 = this.a.w();
                if (c2 != null && (n2 = c2.a(d2)) > 0) {
                    d3 = n2;
                }
                ah2.a(d3);
            }
            e2.g();
        } while (!bl2);
    }
}

