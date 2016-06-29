package y.f.a;

import java.util.*;

class y implements Comparator
{
    private final x a;
    
    y(final x a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final double c = this.a.p.c(o);
        final double c2 = this.a.p.c(o2);
        return (c > c2) ? 1 : ((c < c2) ? -1 : 0);
    }
}
