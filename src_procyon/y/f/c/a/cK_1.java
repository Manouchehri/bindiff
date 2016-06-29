package y.f.c.a;

import java.util.*;
import y.g.*;
import y.c.*;

final class cK implements Comparator, g
{
    final int[] a;
    final Comparator b;
    final Comparator c;
    final Comparator d;
    
    cK(final int[] a, final Comparator b, final Comparator c, final Comparator d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final q c = d.c();
        final q c2 = d2.c();
        if (c == c2) {
            final int compare = this.c.compare(d, d2);
            if (compare == 0) {
                return this.d.compare(d, d2);
            }
            return compare;
        }
        else if (this.a[c.d()] < 0) {
            final d d3 = (d.g() == null) ? d.i() : d.g();
            final q d4 = d3.d();
            if (this.a[c2.d()] >= 0) {
                return this.b.compare(d4, d.d());
            }
            final d d5 = (d2.g() == null) ? d2.i() : d2.g();
            final q d6 = d5.d();
            final int compare2 = this.b.compare(d.d(), d4);
            final int compare3 = this.b.compare(d2.d(), d6);
            if (compare2 < 0) {
                if (compare3 > 0) {
                    return 1;
                }
            }
            else if (compare3 < 0) {
                return -1;
            }
            final int compare4 = this.b.compare(d6, d4);
            if (compare4 != 0) {
                return compare4;
            }
            final int compare5 = this.c.compare(d5, d3);
            if (compare5 != 0) {
                return compare5;
            }
            final int compare6 = this.d.compare(d5, d3);
            if (compare6 == 0) {
                return e.a(c.d(), c2.d()) * compare2;
            }
            return compare6;
        }
        else {
            if (this.a[c2.d()] < 0) {
                return this.b.compare(d2.d(), (d2.g() == null) ? d2.i().d() : d2.g().d());
            }
            return this.b.compare(c, c2);
        }
    }
}
