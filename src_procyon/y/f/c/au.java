package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

final class au implements Comparator, g
{
    Comparator a;
    c b;
    int[] c;
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final d d = (d)this.b.b(q);
        final q q2 = (q)o2;
        final d d2 = (d)this.b.b(q2);
        if (d == null) {
            if (d2 == null) {
                return e.a(this.c[q.d()], this.c[q2.d()]);
            }
            return -1;
        }
        else {
            if (d2 == null) {
                return 1;
            }
            return this.a.compare(d, d2);
        }
    }
}
