/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.Rectangle;
import y.d.y;

class o
implements y.d.o {
    public Rectangle a;
    private y b;

    o(Rectangle rectangle) {
        this.a = rectangle;
        this.b = new y(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public y h() {
        return this.b;
    }
}

