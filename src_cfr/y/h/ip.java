/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import y.h.fj;
import y.h.ir;
import y.h.is;

class ip
implements is {
    private final Rectangle2D a;
    private final ir b;

    ip(ir ir2, Rectangle2D rectangle2D) {
        this.b = ir2;
        this.a = rectangle2D;
    }

    @Override
    public void a(Line2D line2D) {
        if (this.a.getWidth() < 0.0 || this.a.getHeight() < 0.0) {
            this.a.setFrameFromDiagonal(line2D.getX1(), line2D.getY1(), line2D.getX2(), line2D.getY2());
            if (!fj.z) return;
        }
        this.a.add(line2D.getX1(), line2D.getY1());
        this.a.add(line2D.getX2(), line2D.getY2());
    }
}

