package y.f.f.b;

import java.util.*;
import y.c.*;

class f implements Comparator
{
    private A a;
    private boolean b;
    
    f(final A a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final double c = this.a.c(o);
        final double c2 = this.a.c(o2);
        if (c < c2) {
            return this.b ? 1 : -1;
        }
        if (c > c2) {
            return this.b ? -1 : 1;
        }
        return 0;
    }
}
