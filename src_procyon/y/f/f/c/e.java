package y.f.f.c;

import y.c.*;

class e
{
    p a;
    D b;
    
    e(final p a) {
        this.b = new D();
        this.a = a;
    }
    
    public g[] a(final g g) {
        final int a = g.a;
        final g[] array = { null, null };
        y.c.p p = this.b.k();
        y.c.p p2 = null;
        while (true) {
            while (p != null) {
                final g g2 = (g)this.b.g(p);
                if (a != 0) {
                    if (p2 != null) {
                        array[0] = (g)this.b.g(p2);
                    }
                    if (p != null) {
                        array[1] = (g)this.b.g(p);
                    }
                    return array;
                }
                if (g2.i() >= g.i()) {
                    break;
                }
                p2 = p;
                p = this.b.c(p);
                if (a != 0) {
                    break;
                }
            }
            this.b.a(g, p);
            continue;
        }
    }
    
    public void b(final g g) {
        this.b.remove(g);
    }
}
