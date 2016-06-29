/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.c.d;
import y.c.q;
import y.d.y;
import y.h.F;
import y.h.aB;
import y.h.az;
import y.h.bu;
import y.h.eU;
import y.h.fj;

class L
extends bu
implements az {
    private final F a;

    L(F f2) {
        this.a = f2;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        this.i(this.l()).paint(graphics2D);
        if (!F.g(this.a)) return;
        if (this.a.e() && F.h(this.a) != null) {
            this.a.a(graphics2D, F.h(this.a));
            if (!fj.z) return;
        }
        if (F.i(this.a) == null) return;
        this.a.a(graphics2D, this.a.getGraph2D().t(F.i(this.a)));
    }

    @Override
    public Rectangle getBounds() {
        Object object;
        Rectangle rectangle = this.a();
        if (!F.g(this.a)) return rectangle;
        if (F.i(this.a) != null) {
            object = this.a.getGraph2D().t(F.i(this.a));
            rectangle = rectangle.union(this.a.b((fj)object).getBounds()).getBounds();
        }
        if (!this.a.e()) return rectangle;
        if (F.h(this.a) == null) return rectangle;
        object = F.h(this.a).k();
        rectangle.add(object.c(), object.d());
        rectangle.add(object.c() + object.a(), object.d() + object.b());
        return rectangle;
    }
}

