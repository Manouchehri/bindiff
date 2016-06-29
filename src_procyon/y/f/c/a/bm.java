package y.f.c.a;

import java.util.*;

class bm implements Comparator
{
    private final bk a;
    
    bm(final bk a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final l l = (l)o;
        final l i = (l)o2;
        if (l.j()) {
            if (i.j()) {
                return 0;
            }
            return 1;
        }
        else {
            if (i.j()) {
                return -1;
            }
            return l.compareTo(o2);
        }
    }
}
