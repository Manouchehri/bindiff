package y.f.c.a;

import java.util.*;

class bl implements Comparator
{
    private final bk a;
    
    bl(final bk a) {
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final bt bt = (bt)o;
        final bt bt2 = (bt)o2;
        if (bt.j()) {
            if (bt2.j()) {
                return 0;
            }
            return 1;
        }
        else {
            if (bt2.j()) {
                return -1;
            }
            return bt.compareTo(o2);
        }
    }
}
