/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import y.c.q;
import y.d.y;
import y.f.X;
import y.f.a.j;
import y.f.a.t;

class p {
    q a;
    q b;
    private final j c;

    p(j j2, q q2, q q3) {
        this.c = j2;
        this.a = q2;
        this.b = q3;
    }

    boolean a(double d2) {
        if (d2 <= 0.0) return y.a(this.c.n.s(this.a), this.c.n.s(this.b));
        double d3 = t.b(this.c.n.s(this.a), this.c.n.s(this.b));
        if (d3 >= d2) return false;
        return true;
    }
}

