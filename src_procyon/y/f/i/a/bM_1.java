package y.f.i.a;

import java.util.*;

class bM implements Comparator
{
    private final bN a;
    
    bM(final bN a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final M c = ((w)o).a(this.a.b).c();
        final double a = c.a();
        final M c2 = ((w)o2).a(this.a.b).c();
        final double a2 = c2.a();
        if (a < a2) {
            return -1;
        }
        if (a > a2) {
            return 1;
        }
        final double b = c.b();
        final double b2 = c2.b();
        if (b > b2) {
            return -1;
        }
        if (b < b2) {
            return 1;
        }
        return 0;
    }
}
