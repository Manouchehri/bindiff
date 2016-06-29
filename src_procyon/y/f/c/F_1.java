package y.f.c;

import y.f.*;
import y.c.*;

final class F extends J implements ah
{
    at a;
    Object b;
    private final E h;
    
    public F(final E h, final at a) {
        super(h);
        this.h = h;
        this.a = a;
    }
    
    public y[] a(final X x, final A a, final int n) {
        final boolean i = a.i;
        this.a.a(this.b, x, a, n, this.f, this.g, E.a(this.h).c(ah.f_), E.a(this.h).c(ah.k), E.a(this.h).c(aF.a), E.a(this.h).c(aF.b), E.a(this.h).c(aF.c), E.a(this.h).c(aF.d));
        final y[] array = new y[n];
        int j = 0;
        while (j < array.length) {
            array[j] = new y();
            ++j;
            if (i) {
                break;
            }
        }
        final x o = x.o();
        y[] array2 = null;
        while (o.f()) {
            array2 = array;
            if (i) {
                return array2;
            }
            array2[a.a(o.e())].add(o.e());
            o.g();
            if (i) {
                break;
            }
        }
        return array2;
    }
    
    public void a(final X x, final y[] array, final c c) {
    }
    
    public void c(final X x) {
        this.h.d(x);
    }
}
