package y.d.b;

import java.util.*;

class k implements Comparator
{
    private final d a;
    
    k(final d a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a.l(o, o2);
    }
}
