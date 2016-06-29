/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.q;
import y.h.az;
import y.h.bu;
import y.h.dP;
import y.h.fj;

class dQ
implements az {
    private final dP a;

    dQ(dP dP2) {
        this.a = dP2;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        q q2 = this.a();
        if (q2 == null) return;
        this.a.a(graphics2D, this.a.getGraph2D().t(q2));
    }

    @Override
    public Rectangle getBounds() {
        q q2 = this.a();
        if (q2 == null) return new Rectangle(0, 0, -1, -1);
        return this.a.a(this.a.getGraph2D().t(q2)).getBounds();
    }

    private q a() {
        Object object = this.a.b(dP.a(this.a), dP.b(this.a));
        if (!(object instanceof q)) return null;
        return (q)object;
    }
}

