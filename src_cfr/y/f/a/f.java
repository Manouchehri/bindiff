/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.A;
import y.c.q;
import y.g.g;

class F
implements Comparator,
g {
    A a;
    A b;
    A c;

    public F(A a2, A a3, A a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public int compare(Object object, Object object2) {
        q q2 = (q)object;
        q q3 = (q)object2;
        if (this.a.a(q2) < this.a.a(q3)) {
            return 1;
        }
        if (this.a.a(q2) > this.a.a(q3)) {
            return -1;
        }
        if (this.a(this.b.a(q2), this.b.a(q3))) {
            return -1;
        }
        if (this.a(this.b.a(q3), this.b.a(q2))) {
            return 1;
        }
        if (this.c.a(q2) < this.c.a(q3)) {
            return -1;
        }
        if (this.c.a(q2) <= this.c.a(q3)) return 0;
        return 1;
    }

    private boolean a(int n2, int n3) {
        if (n2 >= n3) return false;
        if (n2 > -1) {
            if (100.0 >= (double)(n3 - n2)) return false;
            return true;
        }
        if ((double)n2 + 100.0 >= (double)n3) return false;
        return true;
    }
}

