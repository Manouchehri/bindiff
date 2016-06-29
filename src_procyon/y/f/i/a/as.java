package y.f.i.a;

import java.util.*;
import y.f.c.a.*;

class as implements Comparator
{
    private final ar a;
    
    as(final ar a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final double g = ((l)o).g();
        final double g2 = ((l)o2).g();
        if (g < g2) {
            return -1;
        }
        if (g > g2) {
            return 1;
        }
        return 0;
    }
}
