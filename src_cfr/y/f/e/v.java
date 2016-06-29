/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.geom.Rectangle2D;
import y.c.y;
import y.f.X;
import y.f.am;
import y.f.b.a;
import y.f.e.q;

class v
implements a {
    private final q a;

    v(q q2) {
        this.a = q2;
    }

    @Override
    public Rectangle2D a(X x2, y.c.q q2, y y2) {
        am am2 = x2.h(q2);
        return new Rectangle2D.Double(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
    }
}

