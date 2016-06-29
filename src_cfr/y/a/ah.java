/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.ag;
import y.a.ai;
import y.a.h;
import y.c.A;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.y;
import y.g.M;

class ah
extends ai {
    final y a;
    final f b;
    A c;
    final y.c.h d;
    private final ag j;

    ah(ag ag2, i i2) {
        super(ag2, i2);
        this.j = ag2;
        this.d = i2.u();
        this.a = new y();
        this.b = new f();
    }

    @Override
    void a() {
        this.e.a(this.d);
        this.a.clear();
        this.b.clear();
        this.c = null;
        super.a();
    }

    @Override
    y[] a(y y2, A a2) {
        ah ah2;
        boolean bl2 = h.a;
        ag.a(this.j).a(this.e, y2, this.c, this.d);
        ag.a((C)this.b.a(), this.f, this.d);
        e e2 = this.b.a();
        while (e2.f()) {
            ah2 = this;
            if (bl2) return super.a(y2, a2);
            super.a(e2.a());
            e2.g();
            if (!bl2) continue;
        }
        ah2 = this;
        return super.a(y2, a2);
    }

    @Override
    void a(y y2) {
    }

    @Override
    d b() {
        d d2 = super.b();
        this.a.clear();
        this.b.clear();
        this.c = M.a(new int[this.e.e()]);
        ag.a(d2, ag.a(this.j).b(), this.a, this.b, this.c);
        ag.a(this.j).a(this.e, this.a, this.c, this.d);
        ag.b(this.b.a(), this.f, this.d);
        this.b.remove(d2);
        return d2;
    }
}

