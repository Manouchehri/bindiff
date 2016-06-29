package y.f.a;

import java.util.*;
import y.c.*;
import y.g.*;

class b implements Comparator
{
    h a;
    h b;
    q c;
    private final a d;
    
    b(final a d, final h a, final h b, final q c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final d d2 = (d)o2;
        final int a = e.a(this.a.c(d), this.a.c(d2));
        if (a != 0) {
            return a;
        }
        if (!y.f.a.a.b(this.d)) {
            return 0;
        }
        double n = this.b.c(d);
        double n2 = this.b.c(d2);
        if (d.c() == this.c) {
            final double a2 = y.f.a.a.a(y.d.e.a(this.a.c(d)) + 3.141592653589793);
            n = y.f.a.a.a(n);
            n2 = y.f.a.a.a(n2);
            if (n < a2) {
                n += 6.283185307179586;
            }
            if (n2 < a2) {
                n2 += 6.283185307179586;
            }
        }
        if (n > n2) {
            return 1;
        }
        if (n2 > n) {
            return -1;
        }
        return 0;
    }
}
