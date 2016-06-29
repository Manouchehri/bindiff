/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.c.d;
import y.h.aB;
import y.h.az;
import y.h.bu;

final class dO
extends bu
implements az {
    dO() {
    }

    @Override
    public void a(Graphics2D graphics2D) {
        this.i(this.l()).paint(graphics2D);
    }

    @Override
    public Rectangle getBounds() {
        return this.a();
    }
}

