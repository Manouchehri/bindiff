package y.f.i.a;

import java.util.*;

class k implements Comparator
{
    private k() {
    }
    
    public int compare(final Object o, final Object o2) {
        final double n = ((ai)o).c().a() - ((ai)o2).c().a();
        if (n == 0.0) {
            return 0;
        }
        return (n < 0.0) ? -1 : 1;
    }
    
    k(final j j) {
        this();
    }
}
