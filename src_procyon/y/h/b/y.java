package y.h.b;

import java.util.*;
import y.h.*;
import y.c.*;

class y implements Comparator
{
    private final bu a;
    private final v b;
    
    y(final v b, final bu a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final double j = this.a.j((q)o);
        final double i = this.a.j((q)o2);
        if (j > i) {
            return 1;
        }
        if (j < i) {
            return -1;
        }
        final double k = this.a.k((q)o);
        final double l = this.a.k((q)o2);
        if (k > l) {
            return 1;
        }
        if (k < l) {
            return -1;
        }
        return 0;
    }
}
