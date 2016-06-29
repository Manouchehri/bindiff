/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.er;

class dX
implements az {
    private final Rectangle2D a;
    private final er b;

    dX(er er2, Rectangle2D rectangle2D) {
        this.b = er2;
        this.a = rectangle2D;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        this.b.a(graphics2D, this.a);
    }

    @Override
    public Rectangle getBounds() {
        return this.b.b(this.a);
    }
}

