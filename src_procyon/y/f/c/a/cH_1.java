package y.f.c.a;

import java.util.*;
import y.g.*;
import y.c.*;

final class cH implements Comparator, g
{
    private final Comparator a;
    private final Comparator b;
    private final Comparator c;
    private final Comparator d;
    private final Comparator e;
    private Comparator f;
    private final int[] g;
    
    cH(final int[] g, final Comparator a, final Comparator b, final Comparator c, final Comparator d, final Comparator e, final Comparator f) {
        this.g = g;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
    }
    
    Comparator a() {
        return this.f;
    }
    
    void a(final Comparator f) {
        this.f = f;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final q c = d.c();
        final q c2 = d2.c();
        final q d3 = d.d();
        final q d4 = d2.d();
        if (this.g[d3.d()] < 0) {
            final d d5 = (d.h() == null) ? d.j() : d.h();
            final q c3 = d5.c();
            if (this.g[d4.d()] >= 0) {
                return this.b.compare(c3, c);
            }
            final d d6 = (d2.h() == null) ? d2.j() : d2.h();
            final q c4 = d6.c();
            final int compare = this.b.compare(c, c3);
            final int compare2 = this.b.compare(c2, c4);
            if (compare < 0) {
                if (compare2 > 0) {
                    return 1;
                }
            }
            else if (compare2 < 0) {
                return -1;
            }
            final int compare3 = this.b.compare(c4, c3);
            if (compare3 != 0) {
                return compare3;
            }
            final int compare4 = this.c.compare(d6, d5);
            if (compare4 != 0) {
                return compare4;
            }
            final int compare5 = this.d.compare(d6, d5);
            if (compare5 == 0) {
                return y.g.e.a(d3.d(), d4.d()) * compare;
            }
            return compare5;
        }
        else {
            if (this.g[d4.d()] < 0) {
                return this.b.compare(c2, (d2.h() == null) ? d2.j().c() : d2.h().c());
            }
            final int compare6 = this.b.compare(d3, d4);
            if (compare6 != 0) {
                return compare6;
            }
            final int compare7 = this.e.compare(d, d2);
            if (compare7 != 0) {
                return compare7;
            }
            final int compare8 = this.f.compare(d, d2);
            if (compare8 == 0) {
                return y.g.e.a(d.b(), d2.b());
            }
            return compare8;
        }
    }
}
