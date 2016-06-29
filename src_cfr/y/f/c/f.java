/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.c;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.aF;
import y.f.ah;
import y.f.c.E;
import y.f.c.J;
import y.f.c.a;
import y.f.c.at;

final class F
extends J
implements ah {
    at a;
    Object b;
    private final E h;

    public F(E e2, at at2) {
        super(e2);
        this.h = e2;
        this.a = at2;
    }

    @Override
    public y[] a(X x2, A a2, int n2) {
        y[] arry;
        boolean bl2 = a.i;
        this.a.a(this.b, x2, a2, n2, this.f, this.g, E.a(this.h).c(ah.f_), E.a(this.h).c(ah.k), E.a(this.h).c(aF.a), E.a(this.h).c(aF.b), E.a(this.h).c(aF.c), E.a(this.h).c(aF.d));
        y[] arry2 = new y[n2];
        for (int i2 = 0; i2 < arry2.length; ++i2) {
            arry2[i2] = new y();
            if (!bl2) continue;
        }
        x x3 = x2.o();
        while (x3.f()) {
            arry = arry2;
            if (bl2) return arry;
            arry[a2.a(x3.e())].add(x3.e());
            x3.g();
            if (!bl2) continue;
        }
        arry = arry2;
        return arry;
    }

    @Override
    public void a(X x2, y[] arry, c c2) {
    }

    @Override
    public void c(X x2) {
        this.h.d(x2);
    }
}

