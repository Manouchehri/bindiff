/*
 * Decompiled with CFR 0_115.
 */
package y.h.b;

import java.awt.Rectangle;
import y.h.az;

abstract class ab
implements az {
    protected double a;
    protected double b;
    protected double c;
    protected double d;

    ab() {
    }

    public void a(double d2, double d3, double d4, double d5) {
        this.a = d2;
        this.b = d3;
        this.c = Math.ceil(d4);
        this.d = Math.ceil(d5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)this.a, (int)this.b, (int)this.c, (int)this.d);
    }
}

