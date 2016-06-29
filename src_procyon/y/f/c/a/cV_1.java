package y.f.c.a;

import java.util.*;
import y.f.*;
import y.c.*;
import y.g.*;

final class cV implements Comparator
{
    boolean a;
    boolean b;
    X c;
    
    cV(final X c, final boolean a, final boolean b) {
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final d d = (d)o2;
        final d d2 = (d)o;
        if (this.a) {
            if (this.b) {
                return e.a(this.c.n(d).a, this.c.n(d2).a);
            }
            return e.a(this.c.n(d).b, this.c.n(d2).b);
        }
        else {
            if (this.b) {
                return e.a(this.c.o(d).a, this.c.o(d2).a);
            }
            return e.a(this.c.o(d).b, this.c.o(d2).b);
        }
    }
}
