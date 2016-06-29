/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.D;
import y.c.d;
import y.c.p;
import y.c.q;
import y.f.c.a.aM;
import y.f.c.a.aQ;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aC
extends aM
implements as {
    byte a;
    private D b;

    aC(bK bK2, q q2, aQ aQ2, byte by2) {
        super(null, bK2);
        this.a = by2;
        this.a(q2);
        this.a(aQ2);
    }

    @Override
    public byte b() {
        return this.a;
    }

    @Override
    public q f() {
        return this.l();
    }

    @Override
    public p d() {
        if (this.b == null) return null;
        p p2 = this.b.k();
        return p2;
    }

    @Override
    public p a(d d2) {
        if (this.b != null) return this.b.b(d2);
        this.b = new D();
        return this.b.b(d2);
    }

    @Override
    public void a(p p2) {
        this.b.h(p2);
        if (!this.b.isEmpty()) return;
        this.b = null;
    }

    @Override
    public int e() {
        if (this.b == null) return 0;
        int n2 = this.b.size();
        return n2;
    }
}

