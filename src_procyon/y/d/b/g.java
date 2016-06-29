package y.d.b;

import java.util.*;

class g implements Comparator
{
    private final d a;
    
    g(final d a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a.m(o, o2);
    }
}
