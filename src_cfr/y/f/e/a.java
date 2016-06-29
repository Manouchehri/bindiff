/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.geom.Rectangle2D;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.b.a;

final class A
implements a {
    private final a a;

    public A(a a2) {
        this.a = a2;
    }

    @Override
    public Rectangle2D a(X x2, q q2, y y2) {
        if (!y2.isEmpty()) return this.a.a(x2, q2, y2);
        Rectangle2D rectangle2D = this.a.a(x2, q2, y2);
        double d2 = x2.j(q2);
        double d3 = x2.k(q2);
        rectangle2D.setFrame(d2 - rectangle2D.getWidth() * 0.5, d3 - rectangle2D.getHeight() * 0.5, rectangle2D.getWidth(), rectangle2D.getHeight());
        return rectangle2D;
    }
}

