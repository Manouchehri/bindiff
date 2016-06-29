/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.D;
import y.c.d;
import y.c.p;
import y.c.q;
import y.f.c.a.aM;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aE
extends aM
implements as {
    p a;
    private q b;
    private d c;

    aE(d d2, d d3, q q2, bK bK2) {
        super(null, bK2);
        this.c = d2;
        this.b = q2;
    }

    @Override
    public byte b() {
        return 9;
    }

    @Override
    public p d() {
        return this.a;
    }

    @Override
    public p a(d d2) {
        if (this.a != null) throw new UnsupportedOperationException();
        this.a = new D().b(d2);
        return this.a;
    }

    @Override
    public int e() {
        if (this.a == null) return 0;
        return 1;
    }

    @Override
    public q f() {
        return this.b;
    }

    @Override
    public d g() {
        return this.c;
    }
}

