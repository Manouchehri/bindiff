/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.fE;

class fF
implements az {
    private Rectangle2D.Double a = new Rectangle2D.Double();
    private Color b = new Color(100, 100, 100, 100);

    private fF() {
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.a.setRect(d2, d3, d4, d5);
    }

    @Override
    public void a(Graphics2D graphics2D) {
        Color color = graphics2D.getColor();
        graphics2D.setColor(this.b);
        graphics2D.fill(this.a);
        graphics2D.setColor(color);
    }

    public boolean a(double d2, double d3) {
        return this.a.contains(d2, d3);
    }

    @Override
    public Rectangle getBounds() {
        return this.a.getBounds();
    }

    fF(fE fE2) {
        this();
    }

    static Rectangle2D.Double a(fF fF2) {
        return fF2.a;
    }
}

