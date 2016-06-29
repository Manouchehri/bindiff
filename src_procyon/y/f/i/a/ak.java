package y.f.i.a;

import java.util.*;

class ak implements Comparator
{
    private final Map a;
    private final aj b;
    
    ak(final aj b, final Map a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return this.a.get(o2) - this.a.get(o);
    }
}
