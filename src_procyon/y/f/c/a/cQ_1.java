package y.f.c.a;

import java.util.*;
import y.g.*;
import y.c.*;

final class cQ implements Comparator, g
{
    final Comparator a;
    final Comparator b;
    final Comparator c;
    final int[] d;
    
    cQ(final int[] d, final Comparator a, final Comparator b, final Comparator c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final q d3 = d.d();
        final q d4 = d2.d();
        if (d3 == d4) {
            final int compare = this.b.compare(d, d2);
            if (compare == 0) {
                return this.c.compare(d, d2);
            }
            return compare;
        }
        else if (this.d[d3.d()] < 0) {
            final d d5 = (d.h() == null) ? d.j() : d.h();
            final q c = d5.c();
            if (this.d[d4.d()] >= 0) {
                return this.a.compare(c, d.c());
            }
            final d d6 = (d2.h() == null) ? d2.j() : d2.h();
            final q c2 = d6.c();
            final int compare2 = this.a.compare(d.c(), c);
            final int compare3 = this.a.compare(d2.c(), c2);
            if (compare2 < 0) {
                if (compare3 > 0) {
                    return 1;
                }
            }
            else if (compare3 < 0) {
                return -1;
            }
            final int compare4 = this.a.compare(c2, c);
            if (compare4 != 0) {
                return compare4;
            }
            final int compare5 = this.b.compare(d6, d5);
            if (compare5 != 0) {
                return compare5;
            }
            final int compare6 = this.c.compare(d6, d5);
            if (compare6 == 0) {
                return e.a(d3.d(), d4.d()) * compare2;
            }
            return compare6;
        }
        else {
            if (this.d[d4.d()] < 0) {
                return this.a.compare(d2.c(), (d2.h() == null) ? d2.j().c() : d2.h().c());
            }
            return this.a.compare(d3, d4);
        }
    }
}
