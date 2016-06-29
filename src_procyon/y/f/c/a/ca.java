package y.f.c.a;

import java.util.*;
import y.f.*;
import y.c.*;

class ca implements Comparator
{
    q a;
    private final X b;
    
    public ca(final X b) {
        this.b = b;
    }
    
    public int compare(final Object o, final Object o2) {
        final boolean x = N.x;
        final d d = (d)o;
        final d d2 = (d)o2;
        double n = 0.0;
        Label_0082: {
            if (d.c() == this.a) {
                n = this.b.n(d).b;
                if (!x) {
                    break Label_0082;
                }
            }
            if (d.d() == this.a) {
                n = this.b.o(d).b;
                if (!x) {
                    break Label_0082;
                }
            }
            throw new IllegalStateException();
        }
        if (d2.c() == this.a) {
            final double n2 = this.b.n(d2).b;
            if (!x) {
                return (n > n2) ? -1 : (n < n2);
            }
        }
        if (d2.d() == this.a) {
            final double n2 = this.b.o(d2).b;
            if (!x) {
                return (n > n2) ? -1 : (n < n2);
            }
        }
        throw new IllegalStateException();
    }
}
