/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import java.util.Comparator;
import y.c.A;
import y.c.q;
import y.g.a.j;
import y.g.e;

class k
implements Comparator {
    private final A a;
    private final j b;

    k(j j2, A a2) {
        this.b = j2;
        this.a = a2;
    }

    public int compare(Object object, Object object2) {
        int n2;
        q q2 = (q)object;
        q q3 = (q)object2;
        int n3 = this.a.a(q2);
        if (n3 == (n2 = this.a.a(q3))) {
            return e.a(q2.d(), q3.d());
        }
        if (n3 >= n2) return 1;
        return -1;
    }
}

