/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseWheelEvent;
import y.h.az;
import y.h.cQ;
import y.h.cS;

class cT
extends Rectangle
implements az {
    public double a;
    private final cS b;

    cT(cS cS2) {
        this.b = cS2;
    }

    @Override
    public void a(Graphics2D graphics2D) {
        cS.a(this.b).paintZoomIndicator(graphics2D, this.x, this.y, this.width, this.height, this.a, cS.a((cS)this.b).lastMouseWheelEvent);
    }
}

