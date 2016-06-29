/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.A;
import y.d.t;
import y.f.a.G;

class H
implements Comparator {
    private final A a;
    private final G b;

    H(G g2, A a2) {
        this.b = g2;
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        t t2 = (t)this.a.b(object);
        t t3 = (t)this.a.b(object2);
        double d3 = Math.atan2(t2.b, t2.a);
        if (d3 > (d2 = Math.atan2(t3.b, t3.a))) {
            return 1;
        }
        if (d3 >= d2) return 0;
        return -1;
    }
}

