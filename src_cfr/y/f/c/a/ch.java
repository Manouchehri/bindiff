/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Comparator;
import y.c.d;
import y.c.q;
import y.g.e;
import y.g.g;

final class cH
implements Comparator,
g {
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private Comparator f;
    private final int[] g;

    cH(int[] arrn, Comparator comparator, Comparator comparator2, Comparator comparator3, Comparator comparator4, Comparator comparator5, Comparator comparator6) {
        this.g = arrn;
        this.a = comparator;
        this.b = comparator2;
        this.c = comparator3;
        this.d = comparator4;
        this.f = comparator6;
        this.e = comparator5;
    }

    Comparator a() {
        return this.f;
    }

    void a(Comparator comparator) {
        this.f = comparator;
    }

    public int compare(Object object, Object object2) {
        d d2 = (d)object;
        d d3 = (d)object2;
        q q2 = d2.c();
        q q3 = d3.c();
        q q4 = d2.d();
        q q5 = d3.d();
        if (this.g[q4.d()] < 0) {
            int n2;
            d d4 = d2.h() == null ? d2.j() : d2.h();
            q q6 = d4.c();
            if (this.g[q5.d()] >= 0) return this.b.compare(q6, q2);
            d d5 = d3.h() == null ? d3.j() : d3.h();
            q q7 = d5.c();
            int n3 = this.b.compare(q2, q6);
            int n4 = this.b.compare(q3, q7);
            if (n3 < 0) {
                if (n4 > 0) {
                    return 1;
                }
            } else if (n4 < 0) {
                return -1;
            }
            if ((n2 = this.b.compare(q7, q6)) != 0) return n2;
            int n5 = this.c.compare(d5, d4);
            if (n5 != 0) return n5;
            int n6 = this.d.compare(d5, d4);
            if (n6 != 0) return n6;
            return e.a(q4.d(), q5.d()) * n3;
        }
        if (this.g[q5.d()] >= 0) {
            int n7 = this.b.compare(q4, q5);
            if (n7 != 0) return n7;
            int n8 = this.e.compare(d2, d3);
            if (n8 != 0) return n8;
            int n9 = this.f.compare(d2, d3);
            if (n9 != 0) return n9;
            return e.a(d2.b(), d3.b());
        }
        q q8 = d3.h() == null ? d3.j().c() : d3.h().c();
        return this.b.compare(q3, q8);
    }
}

