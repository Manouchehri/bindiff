/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.List;
import y.c.D;
import y.d.n;
import y.d.q;
import y.d.t;
import y.f.I;
import y.f.am;
import y.h.aA;
import y.h.aB;
import y.h.ch;
import y.h.dD;
import y.h.dh;
import y.h.fj;
import y.h.gZ;
import y.h.gu;
import y.h.gv;
import y.h.in;

final class it {
    final aA a;
    final gu b;
    final gv c;
    final dh d;
    n e;
    gv f;

    it(in in2, dD dD2) {
        double d2 = dD2.c() - in.a(in2);
        double d3 = dD2.d() - in.b(in2);
        t t2 = in.c(in2);
        this.a = (aA)dD2.b();
        this.b = in.d(in2);
        this.f = in.e(in2);
        this.c = in.f(in2);
        this.d = in.g(in2);
        this.e = new n(in.h(in2));
        if (this.b.b()) {
            this.e.a(6.283185307179586 - this.c.f());
        }
        this.e.e(t2.a() + d2, t2.b() + d3);
    }

    double a() {
        return this.d.e() / this.b();
    }

    double b() {
        return this.d.c().getZoom();
    }

    t a(D d2) {
        return this.d.b(d2, this.e.k());
    }

    n c() {
        aB aB2 = this.a.getRealizer();
        return this.b.a(this.e.d(), aB2, aB2.getSourceRealizer(), aB2.getTargetRealizer(), this.f);
    }

    void d() {
        this.f = this.b.a(this.e, this.a.getRealizer(), this.f, 2);
    }
}

