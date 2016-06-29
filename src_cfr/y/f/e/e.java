/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.geom.Rectangle2D;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.am;
import y.f.b.h;
import y.f.e.d;

class e
extends h {
    private final d a;

    e(d d2) {
        this.a = d2;
    }

    @Override
    public Rectangle2D a(X x2, q q2, y y2) {
        if (!y2.isEmpty()) {
            return super.a(x2, q2, y2);
        }
        am am2 = x2.h(q2);
        return new Rectangle2D.Double(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
    }
}

