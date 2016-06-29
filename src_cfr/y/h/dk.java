/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.d.t;
import y.h.az;
import y.h.ch;
import y.h.dI;
import y.h.el;
import y.h.fj;
import y.h.gz;

class dK
extends gz {
    private final t a;
    private final el c;
    private final dI d;

    dK(dI dI2, double d2, az az2, t t2, el el2) {
        super(d2, az2);
        this.d = dI2;
        this.a = t2;
        this.c = el2;
    }

    @Override
    public byte a(t t2, Point2D.Double double_, byte by2) {
        double d2 = double_.x - this.a.a;
        double d3 = double_.y - this.a.b;
        t t3 = dI.a(this.d, double_.x, double_.y, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(d2, d3));
        byte by3 = 0;
        if (double_.x == t3.a) {
            if (double_.y == t3.b) return by3;
        }
        by3 = 3;
        double_.x = t3.a;
        double_.y = t3.b;
        return by3;
    }

    @Override
    public boolean a(t t2, t t3, byte by2) {
        double d2 = t3.a - this.a.a;
        double d3 = t3.b - this.a.b;
        return dI.a(this.d, t3.a, t3.b, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(d2, d3)).equals(t3);
    }
}

