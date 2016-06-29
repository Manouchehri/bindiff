package y.f.k;

import java.util.*;
import y.f.*;
import y.d.*;
import y.c.*;

class p implements Comparator
{
    private final X a;
    private final t b;
    private final double c;
    private final o d;
    
    p(final o d, final X a, final t b, final double c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int compare(final Object o, final Object o2) {
        final t l = this.a.l(((d)o).d());
        final t i = this.a.l(((d)o2).d());
        double a = o.a(this.b, l);
        if (a < this.c) {
            a += 6.283185307179586;
        }
        double a2 = o.a(this.b, i);
        if (a2 < this.c) {
            a2 += 6.283185307179586;
        }
        return (a < a2) ? 1 : ((a > a2) ? -1 : 0);
    }
}
