/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.q;
import y.f.X;
import y.f.a.j;

class k
implements Comparator {
    private final j a;

    k(j j2) {
        this.a = j2;
    }

    public int compare(Object object, Object object2) {
        double d2;
        q q2 = (q)object;
        q q3 = (q)object2;
        double d3 = Math.atan2(this.a.n.k(q2), this.a.n.j(q2));
        if (d3 < (d2 = Math.atan2(this.a.n.k(q3), this.a.n.j(q3)))) {
            return -1;
        }
        if (d3 <= d2) return 0;
        return 1;
    }
}

