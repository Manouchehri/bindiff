package y.f;

import java.util.*;

class h implements Comparator
{
    private final e a;
    
    h(final e a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        return y.g.e.a(((i)o2).c, ((i)o).c);
    }
}
