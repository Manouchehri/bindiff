/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.awt.Rectangle;
import java.util.Comparator;
import y.c.q;
import y.f.e.l;
import y.g.e;
import y.g.g;

final class n
implements Comparator,
g {
    private final l a;

    n(l l2) {
        this.a = l2;
    }

    public int compare(Object object, Object object2) {
        boolean bl2;
        q q2 = (q)object;
        Rectangle rectangle = l.a(this.a)[q2.d()];
        q q3 = (q)object2;
        Rectangle rectangle2 = l.a(this.a)[q3.d()];
        boolean bl3 = l.a(this.a, q2);
        if (bl3 == (bl2 = l.a(this.a, q3)) || rectangle.x > rectangle2.x + rectangle2.width || rectangle.x + rectangle.width < rectangle2.x) {
            int n2 = e.a((double)rectangle.y + (double)rectangle.height * 0.5, (double)rectangle2.y + (double)rectangle2.height * 0.5);
            if (n2 == 0) return e.a(((q)object2).d(), ((q)object).d());
            return n2;
        }
        if (bl3) {
            if (rectangle2.y + rectangle2.height >= rectangle.y) return -1;
            return 1;
        }
        if (rectangle.y + rectangle.height >= rectangle2.y) return 1;
        return -1;
    }
}

