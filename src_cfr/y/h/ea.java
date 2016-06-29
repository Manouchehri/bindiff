/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.q;
import y.g.e;

class eA
implements Comparable {
    final double a;
    final q b;
    final boolean c;
    final double d;
    final double e;

    public eA(double d2, q q2, boolean bl2, double d3, double d4) {
        this.a = d2;
        this.b = q2;
        this.c = bl2;
        this.d = d3;
        this.e = d4;
    }

    public int compareTo(Object object) {
        eA eA2 = (eA)object;
        int n2 = e.a(this.a, eA2.a);
        if (n2 != 0) {
            return n2;
        }
        if (this.c == eA2.c) return 0;
        if (!this.c) return -1;
        return 1;
    }
}

