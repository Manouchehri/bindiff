package y.f.c.a;

import java.util.*;
import y.g.*;
import y.c.*;

final class cU implements Comparator, g
{
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private Comparator f;
    private final int[] g;
    
    cU(final int[] g, final Comparator a, final Comparator b, final Comparator c, final Comparator d, final Comparator e, final Comparator f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final q d3 = d.d();
        final q d4 = d2.d();
        final int compare = this.c.compare(d, d2);
        if (compare != 0) {
            return compare;
        }
        final int compare2 = this.d.compare(d, d2);
        if (compare2 != 0) {
            return compare2;
        }
        final q c = d.c();
        final q c2 = d2.c();
        if (this.g[c.d()] < 0) {
            final d d5 = (d.g() == null) ? d.i() : d.g();
            final q d6 = d5.d();
            if (this.g[c2.d()] >= 0) {
                return this.b.compare(d6, d3);
            }
            final d d7 = (d2.g() == null) ? d2.i() : d2.g();
            final q d8 = d7.d();
            final int compare3 = this.b.compare(d3, d6);
            final int compare4 = this.b.compare(d4, d8);
            if (compare3 < 0) {
                if (compare4 > 0) {
                    return 1;
                }
            }
            else if (compare4 < 0) {
                return -1;
            }
            final int compare5 = this.b.compare(d8, d6);
            if (compare5 != 0) {
                return compare5;
            }
            final int compare6 = this.c.compare(d7, d5);
            if (compare6 != 0) {
                return compare6;
            }
            final int compare7 = this.d.compare(d7, d5);
            if (compare7 == 0) {
                return y.g.e.a(c.d(), c2.d()) * compare3;
            }
            return compare7;
        }
        else {
            if (this.g[c2.d()] < 0) {
                return this.b.compare(d4, (d2.g() == null) ? d2.i().d() : d2.g().d());
            }
            final int compare8 = this.b.compare(c, c2);
            if (compare8 != 0) {
                return compare8;
            }
            final int compare9 = this.e.compare(d, d2);
            if (compare9 != 0) {
                return compare9;
            }
            final int compare10 = this.f.compare(d, d2);
            if (compare10 == 0) {
                return y.g.e.a(d.b(), d2.b());
            }
            return compare10;
        }
    }
}
