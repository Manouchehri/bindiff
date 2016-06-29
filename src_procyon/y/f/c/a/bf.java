package y.f.c.a;

import java.util.*;
import y.c.*;

class bf implements Comparator
{
    private final q a;
    private final aV b;
    
    private bf(final q a, final aV b) {
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o;
        final A a = this.b.a(d);
        final boolean a2 = bb.a(d.c().equals(this.a) ? a.c() : a.e());
        final d d2 = (d)o2;
        final A a3 = this.b.a(d2);
        final boolean a4 = bb.a(d2.c().equals(this.a) ? a3.c() : a3.e());
        if (a2 && !a4) {
            return -1;
        }
        if (!a2 && a4) {
            return 1;
        }
        return 0;
    }
    
    bf(final q q, final aV av, final bc bc) {
        this(q, av);
    }
}
