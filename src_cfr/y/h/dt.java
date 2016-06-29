/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.d.t;
import y.h.dP;
import y.h.gz;

class dT
extends gz {
    private final dP a;

    dT(dP dP2, double d2) {
        super(d2);
        this.a = dP2;
    }

    @Override
    public byte a(t t2, Point2D.Double double_, byte by2) {
        if (!this.a.isGridMode()) return by2;
        double d2 = t2.a;
        double d3 = t2.b;
        double d4 = this.a.getGridX(d2);
        double d5 = this.a.getGridY(d3);
        double_.x = d4;
        double_.y = d5;
        return 3;
    }

    @Override
    public boolean a(t t2, t t3, byte by2) {
        return this.a.isGridMode();
    }
}

