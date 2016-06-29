/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.h;
import y.f.a.x;

class y
implements Comparator {
    private final x a;

    y(x x2) {
        this.a = x2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        double d3 = this.a.p.c(object);
        if (d3 > (d2 = this.a.p.c(object2))) {
            return 1;
        }
        if (d3 >= d2) return 0;
        return -1;
    }
}

