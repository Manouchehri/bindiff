/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.et;

class dY
implements az {
    private final Rectangle2D a;
    private final et b;

    dY(et et2, Rectangle2D rectangle2D) {
        this.b = et2;
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

