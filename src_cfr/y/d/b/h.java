/*
 * Decompiled with CFR 0_115.
 */
package y.d.b;

import java.util.Comparator;
import y.d.b.d;
import y.g.g;

class h
implements Comparator,
g {
    private final d a;

    h(d d2) {
        this.a = d2;
    }

    public int compare(Object object, Object object2) {
        ++d.c;
        double d2 = this.a.h(object) * this.a.j(object2);
        double d3 = this.a.h(object2) * this.a.j(object);
        double d4 = d2 - d3;
        double d5 = 4.0 * ((d2 = Math.abs(d2)) + (d3 = Math.abs(d3))) * d.h;
        if (d4 > d5) {
            return 1;
        }
        if (d4 < - d5) {
            return -1;
        }
        if (d5 < 1.0) {
            double d6 = this.a.i(object) * this.a.j(object2);
            double d7 = this.a.i(object2) * this.a.j(object);
            d4 = d6 - d7;
            d5 = 4.0 * ((d6 = Math.abs(d6)) + (d7 = Math.abs(d7))) * d.h;
            if (d4 > d5) {
                return 1;
            }
            if (d4 < - d5) {
                return -1;
            }
            if (d5 < 1.0) {
                return 0;
            }
        }
        --d.c;
        return this.a.m(object, object2);
    }
}

