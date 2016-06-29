/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import y.h.ir;
import y.h.is;

class io
implements is {
    private final Graphics2D a;
    private final ir b;

    io(ir ir2, Graphics2D graphics2D) {
        this.b = ir2;
        this.a = graphics2D;
    }

    @Override
    public void a(Line2D line2D) {
        this.a.draw(line2D);
    }
}

