/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.awt.geom.Rectangle2D;
import y.c.c;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.r;
import y.f.X;
import y.f.ae;
import y.f.b.a;
import y.f.b.f;

public class g
implements a {
    private Object a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;

    public g() {
        this(f.e);
    }

    public g(Object object) {
        this.a = object;
        this.e = 15;
        this.d = 15;
        this.c = 15;
        this.b = 15;
    }

    public boolean a() {
        return this.f;
    }

    @Override
    public Rectangle2D a(X x2, q q2, y y2) {
        Rectangle2D rectangle2D = ae.a(x2, x2.o(), x2.p(), this.a());
        return this.a(x2, q2, y2, rectangle2D);
    }

    protected Rectangle2D a(X x2, q q2, y y2, Rectangle2D rectangle2D) {
        r r2;
        Object object;
        double d2 = this.b;
        double d3 = this.c;
        double d4 = this.e;
        double d5 = this.d;
        if (this.a != null && (object = x2.c(this.a)) != null && (r2 = r.a(object.b(q2))) != null) {
            d2 = r2.a;
            d3 = r2.c;
            d5 = r2.b;
            d4 = r2.d;
        }
        object = new Rectangle2D.Double();
        object.setFrame(rectangle2D.getX() - d5, rectangle2D.getY() - d2, rectangle2D.getWidth() + d5 + d4, rectangle2D.getHeight() + d2 + d3);
        return object;
    }
}

