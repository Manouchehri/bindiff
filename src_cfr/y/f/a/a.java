/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.d.t;
import y.f.a.z;

class A
implements Comparator {
    private final t a;
    private final double b;
    private final z c;

    A(z z2, t t2, double d2) {
        this.c = z2;
        this.a = t2;
        this.b = d2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        t t2 = z.a(this.c).l(((d)object).d());
        t t3 = z.a(this.c).l(((d)object2).d());
        double d3 = z.a(this.a, t2);
        if (d3 < this.b) {
            d3 += 6.283185307179586;
        }
        if ((d2 = z.a(this.a, t3)) < this.b) {
            d2 += 6.283185307179586;
        }
        if (d3 < d2) {
            return 1;
        }
        if (d3 <= d2) return 0;
        return -1;
    }
}

