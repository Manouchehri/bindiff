/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import y.c.D;
import y.c.d;
import y.c.p;
import y.f.c.a.aM;
import y.f.c.a.aY;
import y.f.c.a.as;
import y.f.c.a.bK;

class aN
extends aM
implements as {
    private D a = new D();
    private d b;

    aN(d d2, bK bK2) {
        super(null, bK2);
        this.b = d2;
    }

    @Override
    public byte b() {
        return 10;
    }

    @Override
    public p d() {
        return this.a.k();
    }

    @Override
    public p a(d d2) {
        return this.a.b(d2);
    }

    @Override
    public int e() {
        return this.a.size();
    }

    @Override
    public d g() {
        return this.b;
    }
}

