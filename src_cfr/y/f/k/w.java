/*
 * Decompiled with CFR 0_115.
 */
package y.f.k;

import y.d.t;
import y.f.I;
import y.f.X;
import y.f.k.A;
import y.f.k.P;
import y.f.k.V;
import y.f.k.Y;
import y.f.k.d;
import y.f.k.l;

class W
extends V {
    private t c;
    private I d;
    private boolean e;

    W(l l2, X x2, y.c.d d2, P p2) {
        super(p2);
        this.d = x2.b(d2);
        this.d.clearPoints();
        this.c = d.a(l2, x2.p(d2));
        Y y2 = new Y();
        y2.a(new t(this.c.a(), this.c.b()));
        this.a(y2);
    }

    void c() {
        if (this.e) {
            throw new IllegalStateException("TargetPoints already have beend appended");
        }
        this.b.j();
        this.b.i().a(this.d);
        this.e = true;
    }

    public void d() {
        this.b.a(this.c.a(), this.c.b());
    }

    public void e() {
        this.d();
        this.c();
        this.b.h();
        this.b.j();
    }
}

