/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.d.t;
import y.h.az;
import y.h.gz;

class gC
extends gz {
    private final boolean a;
    private final double c;

    public gC(double d2, az az2, boolean bl2, double d3, Object object) {
        super(d2, az2, object);
        this.a = bl2;
        this.c = d3;
    }

    @Override
    public byte a(t t2, Point2D.Double double_, byte by2) {
        if (this.a) {
            double_.x = this.c;
            return (byte)(1 | by2);
        }
        double_.y = this.c;
        return (byte)(2 | by2);
    }

    @Override
    public boolean a(t t2, t t3, byte by2) {
        if (this.a) {
            if (t3.a != this.c) return false;
            return true;
        }
        if (t3.b != this.c) return false;
        return true;
    }
}

