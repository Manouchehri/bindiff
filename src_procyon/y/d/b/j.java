package y.d.b;

import java.util.*;

class j implements Comparator
{
    private final d a;
    
    j(final d a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a.k(o, o2);
    }
}
