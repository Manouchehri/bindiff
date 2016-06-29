/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.Comparator;
import y.c.c;
import y.c.d;
import y.c.q;
import y.g.e;
import y.g.g;

final class au
implements Comparator,
g {
    Comparator a;
    c b;
    int[] c;

    au() {
    }

    public int compare(Object object, Object object2) {
        q q2 = (q)object;
        d d2 = (d)this.b.b(q2);
        q q3 = (q)object2;
        d d3 = (d)this.b.b(q3);
        if (d2 == null) {
            if (d3 != null) return -1;
            return e.a(this.c[q2.d()], this.c[q3.d()]);
        }
        if (d3 != null) return this.a.compare(d2, d3);
        return 1;
    }
}

