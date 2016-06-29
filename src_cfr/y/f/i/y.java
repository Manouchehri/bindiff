/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.awt.geom.Rectangle2D;
import java.util.Comparator;
import y.f.i.X;
import y.g.e;

class Y
implements Comparator {
    private final X a;

    Y(X x2) {
        this.a = x2;
    }

    public int compare(Object object, Object object2) {
        Rectangle2D.Double double_ = (Rectangle2D.Double)object;
        Rectangle2D.Double double_2 = (Rectangle2D.Double)object2;
        int n2 = e.a(double_.y, double_2.y);
        if (n2 == 0) return e.a(double_.x, double_2.x);
        return n2;
    }
}

