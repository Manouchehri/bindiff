/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.ag;
import y.c.A;
import y.c.C;
import y.c.c;
import y.c.i;
import y.c.x;
import y.g.M;

class aj {
    private final i a;
    private final A b;
    private final int c;
    private final double d;

    static aj a(i i2, A a2, int n2, double d2) {
        A a3 = M.a(new int[i2.e()]);
        ag.a((C)i2.o(), (c)a2, a3);
        return new aj(i2, a3, n2, d2);
    }

    private aj(i i2, A a2, int n2, double d2) {
        this.a = i2;
        this.b = a2;
        this.c = n2;
        this.d = d2;
    }

    A a() {
        return this.b;
    }

    int b() {
        return this.c;
    }

    double c() {
        return this.d;
    }
}

