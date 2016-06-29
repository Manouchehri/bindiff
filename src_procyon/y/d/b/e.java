package y.d.b;

import java.util.*;
import y.g.*;

class e implements Comparator, g
{
    private final d a;
    
    e(final d a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        ++d.c;
        final double n = this.a.h(o) * this.a.j(o2);
        final double n2 = this.a.h(o2) * this.a.j(o);
        final double n3 = n - n2;
        final double n4 = 4.0 * (Math.abs(n) + Math.abs(n2)) * d.h;
        if (n3 > n4) {
            return 1;
        }
        if (n3 < -n4) {
            return -1;
        }
        if (n4 < 1.0) {
            return 0;
        }
        --d.c;
        return this.a.k(o, o2);
    }
}
