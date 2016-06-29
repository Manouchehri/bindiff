/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.geom.Rectangle2D;
import y.c.c;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.am;
import y.f.b.a;

final class z
implements a {
    private final a a;
    private c b = null;
    private Object c = null;

    public z(a a2, c c2) {
        this.b = c2;
        this.a = a2;
    }

    @Override
    public Rectangle2D a(X x2, q q2, y y2) {
        if (this.c != null) {
            this.b = x2.c(this.c);
        }
        if (this.b == null) return this.a.a(x2, q2, y2);
        if (!this.b.d(q2)) {
            return this.a.a(x2, q2, y2);
        }
        if (!y2.isEmpty()) {
            Rectangle2D rectangle2D = this.a.a(x2, q2, y2);
            am am2 = x2.a(q2);
            double d2 = Math.min(rectangle2D.getX(), am2.getX());
            double d3 = Math.min(rectangle2D.getY(), am2.getY());
            double d4 = Math.max(rectangle2D.getMaxX(), am2.getX() + am2.getWidth());
            double d5 = Math.max(rectangle2D.getMaxY(), am2.getY() + am2.getHeight());
            rectangle2D.setFrame(d2, d3, d4 - d2, d5 - d3);
            return rectangle2D;
        }
        am am3 = x2.a(q2);
        if (am3.getWidth() != 0.0) {
            if (am3.getHeight() != 0.0) return new Rectangle2D.Double(am3.getX(), am3.getY(), am3.getWidth(), am3.getHeight());
        }
        Rectangle2D rectangle2D = this.a.a(x2, q2, y2);
        am3.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        return new Rectangle2D.Double(am3.getX(), am3.getY(), am3.getWidth(), am3.getHeight());
    }
}

