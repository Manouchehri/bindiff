/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.c.d;
import y.c.i;
import y.c.q;
import y.f.f.b.h;
import y.f.f.d.L;

public class K
extends h {
    public K(i i2) {
        super(i2);
    }

    public boolean r(d d2) {
        return ((L)this.q(d2)).e();
    }

    public void s(d d2) {
        ((L)this.q(d2)).a(true);
    }

    @Override
    protected y.f.f.b.i s() {
        return new L(this);
    }

    public boolean k(q q2) {
        if (this.a(q2) != 3) return false;
        return true;
    }

    public void l(q q2) {
        this.a(q2, 3);
    }
}

