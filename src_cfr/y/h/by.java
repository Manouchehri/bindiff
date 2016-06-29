/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import y.h.bX;

public abstract class bY
extends bX {
    Color g = Color.lightGray;

    @Override
    public void a(Graphics2D graphics2D) {
        this.a();
        if (this.g != null) {
            graphics2D.setColor(this.g);
            graphics2D.fill(this.f);
        }
        if (this.c == null) return;
        if (this.e == null) return;
        graphics2D.setColor(this.c);
        Rectangle2D rectangle2D = this.e.getBounds();
        this.e.draw(graphics2D, (float)(this.f.x + (this.f.width - rectangle2D.getWidth()) / 2.0), (float)(this.f.y - rectangle2D.getY() + (this.f.height - rectangle2D.getHeight()) / 2.0));
    }

    public void b(Color color) {
        this.g = color;
    }
}

