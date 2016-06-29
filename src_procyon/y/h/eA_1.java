package y.h;

import y.c.*;
import y.g.*;

class eA implements Comparable
{
    final double a;
    final q b;
    final boolean c;
    final double d;
    final double e;
    
    public eA(final double a, final q b, final boolean c, final double d, final double e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public int compareTo(final Object o) {
        final eA ea = (eA)o;
        final int a = y.g.e.a(this.a, ea.a);
        if (a != 0) {
            return a;
        }
        if (this.c != ea.c) {
            return this.c ? 1 : -1;
        }
        return 0;
    }
}
