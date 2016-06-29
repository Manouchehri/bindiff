/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.c.C;
import y.c.D;
import y.d.e;
import y.h.az;
import y.h.fj;

class im
extends D
implements az {
    im() {
    }

    @Override
    public void a(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        C c2 = this.m();
        do {
            if (!c2.f()) return;
            ((az)c2.d()).a(graphics2D);
            c2.g();
        } while (!bl2);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle rectangle;
        boolean bl2 = fj.z;
        if (this.isEmpty()) {
            return new Rectangle(0, 0, -1, -1);
        }
        C c2 = this.m();
        Rectangle rectangle2 = ((az)c2.d()).getBounds().getBounds();
        c2.g();
        while (c2.f()) {
            rectangle = ((az)c2.d()).getBounds();
            if (bl2) return rectangle;
            e.a(rectangle, rectangle2, rectangle2);
            c2.g();
            if (!bl2) continue;
        }
        rectangle = rectangle2;
        return rectangle;
    }
}

