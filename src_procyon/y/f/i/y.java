package y.f.i;

import java.util.*;
import y.c.*;

class y implements Comparator
{
    private final q a;
    private final q b;
    private final ao c;
    private final v d;
    
    y(final v d, final q a, final q b, final ao c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final int f = v.f;
        final q a = ((d)o).a(this.a);
        final q a2 = ((d)o2).a(this.a);
        final ao ao = (ao)v.a(this.d).b(a);
        final ao ao2 = (ao)v.a(this.d).b(a2);
        double n = 0.0;
        Label_0160: {
            if (ao == null) {
                final q q = (a == this.b) ? v.b(this.d) : v.c(this.d);
                n = (this.c.x() ? v.d(this.d).k(q) : v.d(this.d).j(q));
                if (f == 0) {
                    break Label_0160;
                }
            }
            n = 0.5 * (ao.t() + ao.u());
        }
        if (ao2 == null) {
            final q q2 = (a2 == this.b) ? v.b(this.d) : v.c(this.d);
            final double n2 = this.c.x() ? v.d(this.d).k(q2) : v.d(this.d).j(q2);
            if (f == 0) {
                return (n > n2) ? 1 : ((n < n2) ? -1 : 0);
            }
        }
        final double n2 = 0.5 * (ao2.t() + ao2.u());
        return (n > n2) ? 1 : ((n < n2) ? -1 : 0);
    }
}
