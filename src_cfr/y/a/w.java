/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.S;
import y.a.T;
import y.a.h;
import y.c.c;
import y.c.d;

class W
extends S {
    private W() {
    }

    @Override
    double a(d[] arrd, c c2, int n2) {
        double d2;
        boolean bl2 = h.a;
        if (arrd.length == 0) {
            return -0.5;
        }
        double d3 = 0.0;
        double[][] arrd2 = S.b(arrd, c2, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            double d4 = arrd2[0][i2] + arrd2[1][i2];
            d2 = (d3 += arrd2[0][i2] / (double)arrd.length) - d4 * d4 / (4.0 * (double)arrd.length * (double)arrd.length);
            if (bl2) return d2;
            d3 = d2;
            if (!bl2) continue;
        }
        d2 = d3;
        return d2;
    }

    W(T t2) {
        this();
    }
}

