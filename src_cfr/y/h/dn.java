/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.q;
import y.d.t;
import y.h.az;
import y.h.dI;
import y.h.fj;

class dN
implements az {
    D a;
    Rectangle2D b;
    d c;
    q d;
    private final dI e;

    dN(dI dI2, D d2, Rectangle2D rectangle2D, q q2, d d3) {
        this.e = dI2;
        this.a = d2;
        this.b = rectangle2D;
        this.d = q2;
        this.c = d3;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        C c2 = this.a.m();
        while (c2.f()) {
            t t2 = (t)c2.d();
            this.e.a(graphics2D, t2, this.d, this.c);
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        if (!dI.d(this.e)) return;
        if (this.e.f == null) return;
        this.e.a(graphics2D, this.e.f);
    }

    @Override
    public Rectangle getBounds() {
        if (!dI.d(this.e)) return this.b.getBounds();
        if (this.e.f == null) return this.b.getBounds();
        return this.b.getBounds().createUnion(dI.e(this.e)).getBounds();
    }
}

