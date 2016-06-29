package y.f.i.a;

import java.util.*;
import y.f.c.a.*;

class at implements Comparator
{
    private final ar a;
    
    at(final ar a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final double f = ((bt)o).f();
        final double f2 = ((bt)o2).f();
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        return 0;
    }
}
