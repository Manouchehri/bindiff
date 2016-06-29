/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.d.t;
import y.h.dI;
import y.h.gz;

class dL
extends gz {
    private final dI a;

    dL(dI dI2, double d2) {
        super(d2);
        this.a = dI2;
    }

    @Override
    public boolean a(t t2, t t3, byte by2) {
        t t4 = dI.a(this.a, t2.a, t2.b, dI.b(this.a));
        if (t4 == null) return false;
        if (!t4.equals(t3)) return false;
        return true;
    }

    @Override
    public byte a(t t2, Point2D.Double double_, byte by2) {
        t t3 = dI.a(this.a, t2.a, t2.b, dI.b(this.a));
        if (t3 == null) return by2;
        double_.x = t3.a;
        double_.y = t3.b;
        return 3;
    }
}

