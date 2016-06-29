package y.f.g;

import java.util.*;
import y.d.*;
import y.g.*;

class v implements Comparator, g
{
    private t a;
    private final n b;
    
    v(final n b) {
        this.b = b;
        this.a = null;
    }
    
    v(final n b, final double n, final double n2) {
        this.b = b;
        this.a = new t(n, n2);
    }
    
    public int compare(final Object o, final Object o2) {
        final double n = 50.0 / y.f.g.n.a(this.b);
        final q q = (q)o;
        final q q2 = (q)o2;
        final double n2 = (this.a != null) ? t.a(this.a.a, this.a.b, q.a, q.b) : 0.0;
        final double n3 = (this.a != null) ? t.a(this.a.a, this.a.b, q2.a, q2.b) : 0.0;
        final int n4 = (int)Math.floor(n2 / n);
        final int n5 = (int)Math.floor(n3 / n);
        if (n4 < n5) {
            return -1;
        }
        if (n4 > n5) {
            return 1;
        }
        final int a = e.a(((q)o2).d.size(), ((q)o).d.size());
        if (a != 0) {
            return a;
        }
        return e.a(((q)o).c, ((q)o2).c);
    }
}
