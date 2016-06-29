/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.x;
import y.g.o;

class V
extends y.a.e
implements x {
    private f a = new f();
    private i f = null;

    V() {
    }

    @Override
    public void a(D d2) {
        boolean bl2 = N.d;
        this.f = d2.g();
        this.a(this.f);
        o.a(0, "  Create reversed edges ...");
        e e2 = this.f.p();
        e2.j();
        while (e2.f()) {
            d2.g(e2.a());
            e2.h();
            if (bl2) return;
            if (!bl2) continue;
        }
        d2.l();
        d2.b(d2.i(e2.a()));
    }

    @Override
    public f c_() {
        return this.a;
    }

    @Override
    protected void a(d d2, q q2, boolean bl2) {
        if (bl2) return;
        this.a.add(d2);
        q2.e().d(d2);
    }
}

