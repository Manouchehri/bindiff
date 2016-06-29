/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Point2D;
import y.d.t;
import y.h.az;
import y.h.gv;
import y.h.gz;
import y.h.ir;

class iq
extends gz {
    private final gv a;
    private final t c;

    iq(gv gv2, t t2, ir ir2) {
        super(1.0, ir2);
        this.a = gv2;
        this.c = t2;
    }

    @Override
    public byte a(t t2, Point2D.Double double_, byte by2) {
        double_.x = this.c.a();
        double_.y = this.c.b();
        return 3;
    }

    @Override
    public boolean a(t t2, t t3, byte by2) {
        if (t3.a != this.c.a()) return false;
        if (t3.b != this.c.b()) return false;
        return true;
    }

    gv c() {
        return this.a;
    }
}

