package y.f.i.a;

import java.util.*;
import y.c.*;

class D implements Comparator
{
    private c a;
    private c b;
    
    private D(final c a, final c b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final int n = this.a.a(o) + this.b.a(o);
        final int n2 = this.a.a(o2) + this.b.a(o2);
        if (n < n2) {
            return 1;
        }
        if (n > n2) {
            return -1;
        }
        return 0;
    }
    
    D(final c c, final c c2, final z z) {
        this(c, c2);
    }
}
