package y.f.a;

import java.util.*;
import y.c.*;

class k implements Comparator
{
    private final j a;
    
    k(final j a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final q q2 = (q)o2;
        final double atan2 = Math.atan2(this.a.n.k(q), this.a.n.j(q));
        final double atan3 = Math.atan2(this.a.n.k(q2), this.a.n.j(q2));
        if (atan2 < atan3) {
            return -1;
        }
        if (atan2 > atan3) {
            return 1;
        }
        return 0;
    }
}
