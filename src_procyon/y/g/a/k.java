package y.g.a;

import java.util.*;
import y.c.*;
import y.g.*;

class k implements Comparator
{
    private final A a;
    private final j b;
    
    k(final j b, final A a) {
        this.b = b;
        this.a = a;
    }
    
    public int compare(final Object o, final Object o2) {
        final q q = (q)o;
        final q q2 = (q)o2;
        final int a = this.a.a(q);
        final int a2 = this.a.a(q2);
        if (a == a2) {
            return e.a(q.d(), q2.d());
        }
        if (a < a2) {
            return -1;
        }
        return 1;
    }
}
