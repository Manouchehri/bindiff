/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.C;
import y.c.D;
import y.d.n;
import y.d.t;
import y.f.Q;
import y.f.X;

class aW {
    public static Q a(D d2, t t2) {
        boolean bl2 = X.j;
        Q q2 = null;
        Q q3 = null;
        double d3 = Double.MAX_VALUE;
        double d4 = Double.MAX_VALUE;
        C c2 = d2.m();
        while (c2.f()) {
            Q q4 = (Q)c2.d();
            double d5 = t.a(t2, q4.d().k());
            if (bl2) return q2;
            if (d5 < d3) {
                d3 = d5;
                q2 = q4;
            }
            if (d5 < d4 && n.a(q4.d(), t2, 0.0)) {
                d4 = d5;
                q3 = q4;
            }
            c2.g();
            if (!bl2) continue;
        }
        if (q3 == null) return q2;
        return q3;
    }

    public static n a(n n2) {
        t t2 = n2.k();
        n n3 = new n(0.0, 0.0, n2.e(), n2.f());
        n3.e(t2.a, t2.b);
        return n3;
    }
}

