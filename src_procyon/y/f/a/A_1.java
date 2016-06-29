package y.f.a;

import java.util.*;
import y.d.*;
import y.c.*;

class A implements Comparator
{
    private final t a;
    private final double b;
    private final z c;
    
    A(final z c, final t a, final double b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final t l = z.a(this.c).l(((d)o).d());
        final t i = z.a(this.c).l(((d)o2).d());
        double a = z.a(this.a, l);
        if (a < this.b) {
            a += 6.283185307179586;
        }
        double a2 = z.a(this.a, i);
        if (a2 < this.b) {
            a2 += 6.283185307179586;
        }
        return (a < a2) ? 1 : ((a > a2) ? -1 : 0);
    }
}
