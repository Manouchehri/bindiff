package y.h.b;

import java.util.*;
import y.h.*;
import y.c.*;

class x implements Comparator
{
    private final bu a;
    private final v b;
    
    x(final v b, final bu a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final double k = this.a.k((q)o);
        final double i = this.a.k((q)o2);
        if (k > i) {
            return 1;
        }
        if (k < i) {
            return -1;
        }
        final double j = this.a.j((q)o);
        final double l = this.a.j((q)o2);
        if (j > l) {
            return 1;
        }
        if (j < l) {
            return -1;
        }
        return 0;
    }
}
