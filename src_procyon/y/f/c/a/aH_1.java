package y.f.c.a;

import java.util.*;
import y.c.*;
import y.g.*;

class aH implements Comparator
{
    private c a;
    private c b;
    private int[] c;
    
    aH(final c a, final c b, final int[] c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final int a = this.b.a(o);
        final int a2 = this.b.a(o2);
        final bh bh = (bh)this.a.b(o);
        final bh bh2 = (bh)this.a.b(o2);
        final int a3 = e.a((bh != null) ? bh.c().a() : this.c[a], (bh2 != null) ? bh2.c().a() : this.c[a2]);
        if (a3 != 0) {
            return a3;
        }
        return e.a(a, a2);
    }
}
