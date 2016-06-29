package y.f.k;

import java.util.*;
import y.g.*;
import y.c.*;

class s implements Comparator, g
{
    private final o a;
    
    s(final o a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q d = ((d)o).d();
        final q d2 = ((d)o2).d();
        final double c = o.a(this.a).c(d);
        final double c2 = o.a(this.a).c(d2);
        if (c > c2 + o.u()) {
            return 1;
        }
        if (c + o.u() < c2) {
            return -1;
        }
        return e.a(this.a.e(d).a(), this.a.e(d2).a());
    }
}
