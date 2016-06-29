/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.awt.geom.Rectangle2D;
import y.c.D;
import y.d.g;
import y.f.i.aA;
import y.f.i.ao;
import y.f.i.av;

class aw
implements g {
    private final Rectangle2D.Double a;
    private final Rectangle2D.Double b;
    private final Rectangle2D.Double c;
    private final av d;

    aw(av av2, Rectangle2D.Double double_, Rectangle2D.Double double_2, Rectangle2D.Double double_3) {
        this.d = av2;
        this.a = double_;
        this.b = double_2;
        this.c = double_3;
    }

    @Override
    public void a(Object object, Object object2) {
        aA aA2 = (aA)object;
        aA aA3 = (aA)object2;
        if (aA2.e.x() == aA3.e.x()) return;
        this.a.setFrame(aA2.c, aA2.d, aA2.a, aA2.b);
        this.b.setFrame(aA3.c, aA3.d, aA3.a, aA3.b);
        Rectangle2D.intersect(this.a, this.b, this.c);
        if (this.c.width <= 0.01) return;
        if (this.c.height <= 0.01) return;
        D d2 = (D)av.a(this.d).b(aA2.e);
        d2.add(aA3.e);
        d2 = (D)av.a(this.d).b(aA3.e);
        d2.add(aA2.e);
        av.b(this.d);
    }
}

