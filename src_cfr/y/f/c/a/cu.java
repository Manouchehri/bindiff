/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.g.e;
import y.g.g;

final class cU
implements Comparator,
g {
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private Comparator f;
    private final int[] g;

    cU(int[] arrn, Comparator comparator, Comparator comparator2, Comparator comparator3, Comparator comparator4, Comparator comparator5, Comparator comparator6) {
        this.g = arrn;
        this.a = comparator;
        this.b = comparator2;
        this.c = comparator3;
        this.d = comparator4;
        this.f = comparator6;
        this.e = comparator5;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        q q2 = d2.d();
        q q3 = d3.d();
        int n2 = this.c.compare(d2, d3);
        if (n2 != 0) return n2;
        int n3 = this.d.compare(d2, d3);
        if (n3 != 0) return n3;
        q q4 = d2.c();
        q q5 = d3.c();
        if (this.g[q4.d()] < 0) {
            int n4;
            d d4 = d2.g() == null ? d2.i() : d2.g();
            q q6 = d4.d();
            if (this.g[q5.d()] >= 0) return this.b.compare(q6, q2);
            d d5 = d3.g() == null ? d3.i() : d3.g();
            q q7 = d5.d();
            int n5 = this.b.compare(q2, q6);
            int n6 = this.b.compare(q3, q7);
            if (n5 < 0) {
                if (n6 > 0) {
                    return 1;
                }
            } else if (n6 < 0) {
                return -1;
            }
            if ((n4 = this.b.compare(q7, q6)) != 0) return n4;
            int n7 = this.c.compare(d5, d4);
            if (n7 != 0) return n7;
            int n8 = this.d.compare(d5, d4);
            if (n8 != 0) return n8;
            return e.a(q4.d(), q5.d()) * n5;
        }
        if (this.g[q5.d()] >= 0) {
            int n9 = this.b.compare(q4, q5);
            if (n9 != 0) return n9;
            int n10 = this.e.compare(d2, d3);
            if (n10 != 0) return n10;
            int n11 = this.f.compare(d2, d3);
            if (n11 != 0) return n11;
            return e.a(d2.b(), d3.b());
        }
        q q8 = d3.g() == null ? d3.i().d() : d3.g().d();
        return this.b.compare(q3, q8);
    }
}

