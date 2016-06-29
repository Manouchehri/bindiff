/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.g.e;
import y.g.g;

final class cQ
implements Comparator,
g {
    final Comparator a;
    final Comparator b;
    final Comparator c;
    final int[] d;

    cQ(int[] arrn, Comparator comparator, Comparator comparator2, Comparator comparator3) {
        this.d = arrn;
        this.a = comparator;
        this.b = comparator2;
        this.c = comparator3;
    }

    public int compare(Object object, Object object2) {
        q q2;
        d d2 = (d)object;
        d d3 = (d)object2;
        q q3 = d2.d();
        if (q3 == (q2 = d3.d())) {
            int n2 = this.b.compare(d2, d3);
            if (n2 != 0) return n2;
            return this.c.compare(d2, d3);
        }
        if (this.d[q3.d()] < 0) {
            int n3;
            d d4 = d2.h() == null ? d2.j() : d2.h();
            q q4 = d4.c();
            if (this.d[q2.d()] >= 0) return this.a.compare(q4, d2.c());
            d d5 = d3.h() == null ? d3.j() : d3.h();
            q q5 = d5.c();
            int n4 = this.a.compare(d2.c(), q4);
            int n5 = this.a.compare(d3.c(), q5);
            if (n4 < 0) {
                if (n5 > 0) {
                    return 1;
                }
            } else if (n5 < 0) {
                return -1;
            }
            if ((n3 = this.a.compare(q5, q4)) != 0) return n3;
            int n6 = this.b.compare(d5, d4);
            if (n6 != 0) return n6;
            int n7 = this.c.compare(d5, d4);
            if (n7 != 0) return n7;
            return e.a(q3.d(), q2.d()) * n4;
        }
        if (this.d[q2.d()] >= 0) return this.a.compare(q3, q2);
        q q6 = d3.h() == null ? d3.j().c() : d3.h().c();
        return this.a.compare(d3.c(), q6);
    }
}

