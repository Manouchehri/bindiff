/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.awt.geom.Rectangle2D;
import y.c.c;
import y.c.y;
import y.d.q;
import y.f.X;
import y.f.b.f;
import y.f.b.g;

public class h
extends g {
    private Object a;
    private double b;
    private double c;
    private double d = 0.5;
    private double e = 0.5;

    public h() {
        this(f.f);
    }

    public h(Object object) {
        this.a = object;
    }

    @Override
    public Rectangle2D a(X x2, y.c.q q2, y y2) {
        Object object;
        double d2;
        q q3;
        double d3;
        double d4 = this.b;
        double d5 = this.c;
        if (this.a != null && (object = x2.c(this.a)) != null && (q3 = (q)object.b(q2)) != null) {
            d4 = q3.a;
            d5 = q3.b;
        }
        object = super.a(x2, q2, y2);
        double d6 = object.getX();
        double d7 = object.getY();
        double d8 = object.getWidth();
        double d9 = object.getHeight();
        if (d8 < d4) {
            d3 = d4 - d8;
            d2 = this.d * d3;
            d6 -= d2;
            d8 = d4;
        }
        if (d9 < d5) {
            d3 = d5 - d9;
            d2 = this.e * d3;
            d7 -= d2;
            d9 = d5;
        }
        object.setFrame(d6, d7, d8, d9);
        return object;
    }
}

