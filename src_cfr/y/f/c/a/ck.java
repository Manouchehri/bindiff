/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.g.e;
import y.g.g;

final class cK
implements Comparator,
g {
    final int[] a;
    final Comparator b;
    final Comparator c;
    final Comparator d;

    cK(int[] arrn, Comparator comparator, Comparator comparator2, Comparator comparator3) {
        this.a = arrn;
        this.b = comparator;
        this.c = comparator2;
        this.d = comparator3;
    }

    public int compare(Object object, Object object2) {
        q q2;
        d d2 = (d)object;
        d d3 = (d)object2;
        q q3 = d2.c();
        if (q3 == (q2 = d3.c())) {
            int n2 = this.c.compare(d2, d3);
            if (n2 != 0) return n2;
            return this.d.compare(d2, d3);
        }
        if (this.a[q3.d()] < 0) {
            int n3;
            d d4 = d2.g() == null ? d2.i() : d2.g();
            q q4 = d4.d();
            if (this.a[q2.d()] >= 0) return this.b.compare(q4, d2.d());
            d d5 = d3.g() == null ? d3.i() : d3.g();
            q q5 = d5.d();
            int n4 = this.b.compare(d2.d(), q4);
            int n5 = this.b.compare(d3.d(), q5);
            if (n4 < 0) {
                if (n5 > 0) {
                    return 1;
                }
            } else if (n5 < 0) {
                return -1;
            }
            if ((n3 = this.b.compare(q5, q4)) != 0) return n3;
            int n6 = this.c.compare(d5, d4);
            if (n6 != 0) return n6;
            int n7 = this.d.compare(d5, d4);
            if (n7 != 0) return n7;
            return e.a(q3.d(), q2.d()) * n4;
        }
        if (this.a[q2.d()] >= 0) return this.b.compare(q3, q2);
        q q6 = d3.g() == null ? d3.i().d() : d3.g().d();
        return this.b.compare(d3.d(), q6);
    }
}

