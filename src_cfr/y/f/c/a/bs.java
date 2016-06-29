/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.C;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.g.M;

class bS {
    static void a(X x2, aU aU2, aV aV2, aP aP2) {
        Object object;
        C c2;
        boolean bl2 = N.x;
        y.c.A a2 = M.a();
        int n2 = 0;
        while (n2 < aU2.b()) {
            block7 : {
                object = aU2.a(n2);
                c2 = object.d().a();
                while (c2.f()) {
                    q q2 = c2.e();
                    a2.a((Object)q2, n2);
                    c2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block7;
                }
                ++n2;
            }
            if (!bl2) continue;
        }
        aE aE2 = aE.a(2);
        object = aE.a(1);
        c2 = x2.p();
        do {
            if (!c2.f()) return;
            d d2 = c2.a();
            A a3 = aV2.a(d2);
            if (!d2.e() && bS.a(d2, a2)) {
                if (a3.c() == null || a3.c().g()) {
                    aP2.a(d2, true, aE2);
                }
                if (a3.e() == null || a3.e().g()) {
                    aP2.a(d2, false, (aE)object);
                }
            }
            c2.g();
        } while (!bl2);
    }

    private static boolean a(d d2, y.c.A a2) {
        if (a2.a(d2.c()) <= a2.a(d2.d())) return false;
        return true;
    }
}

