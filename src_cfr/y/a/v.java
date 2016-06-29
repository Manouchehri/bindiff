/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.S;
import y.a.T;
import y.a.h;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;

class V
extends S {
    private V() {
    }

    @Override
    double a(d[] arrd, c c2, int n2) {
        boolean bl2 = h.a;
        if (arrd.length == 0) {
            return 0.0;
        }
        i i2 = arrd[0].c().e();
        double d2 = V.b().a(arrd, c2, n2);
        int[] arrn = S.a(i2, c2, n2);
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= arrn.length) return 1.0 - 2.0 / (double)(i2.e() * (i2.e() - 1)) * ((1.0 - 2.0 * d2 / (double)arrd.length) * (double)arrd.length + 0.5 * (double)n3);
            if (arrn[n4] > 0) {
                n3 += arrn[n4] * (arrn[n4] - 1);
            }
            ++n4;
        } while (!bl2);
        return 1.0 - 2.0 / (double)(i2.e() * (i2.e() - 1)) * ((1.0 - 2.0 * d2 / (double)arrd.length) * (double)arrd.length + 0.5 * (double)n3);
    }

    V(T t2) {
        this();
    }
}

