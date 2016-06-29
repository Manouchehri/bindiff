/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import java.util.Comparator;
import y.c.D;
import y.d.t;
import y.f.g.n;
import y.f.g.q;
import y.g.e;
import y.g.g;

class v
implements Comparator,
g {
    private t a;
    private final n b;

    v(n n2) {
        this.b = n2;
        this.a = null;
    }

    v(n n2, double d2, double d3) {
        this.b = n2;
        this.a = new t(d2, d3);
    }

    public int compare(Object object, Object object2) {
        int n2;
        double d2 = 50.0 / n.a(this.b);
        q q2 = (q)object;
        q q3 = (q)object2;
        double d3 = this.a != null ? t.a(this.a.a, this.a.b, q2.a, q2.b) : 0.0;
        double d4 = this.a != null ? t.a(this.a.a, this.a.b, q3.a, q3.b) : 0.0;
        int n3 = (int)Math.floor(d3 / d2);
        if (n3 < (n2 = (int)Math.floor(d4 / d2))) {
            return -1;
        }
        if (n3 > n2) {
            return 1;
        }
        int n4 = e.a(((q)object2).d.size(), ((q)object).d.size());
        if (n4 == 0) return e.a(((q)object).c, ((q)object2).c);
        return n4;
    }
}

