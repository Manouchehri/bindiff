package y.f.c;

import java.util.*;
import y.c.*;
import y.g.*;

class n implements Comparator
{
    boolean a;
    boolean b;
    private final h c;
    
    n(final h c, final boolean a, final boolean b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o2;
        final d d2 = (d)o;
        if (this.a) {
            if (this.b) {
                return e.a(this.c.b.n(d).a, this.c.b.n(d2).a);
            }
            return e.a(this.c.b.n(d).b, this.c.b.n(d2).b);
        }
        else {
            if (this.b) {
                return e.a(this.c.b.o(d).a, this.c.b.o(d2).a);
            }
            return e.a(this.c.b.o(d).b, this.c.b.o(d2).b);
        }
    }
}
