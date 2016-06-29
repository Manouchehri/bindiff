/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.h.az;

class ad
implements az {
    private az a;

    ad() {
    }

    public az a() {
        return this.a;
    }

    public void a(az az2) {
        this.a = az2;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        if (this.a == null) return;
        this.a.a(graphics2D);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle;
        if (this.a != null) {
            rectangle = this.a.getBounds();
            return rectangle;
        }
        rectangle = new Rectangle();
        return rectangle;
    }
}

