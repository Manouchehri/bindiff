package y.f.c;

import y.g.*;
import y.a.*;
import y.c.*;
import y.f.k.*;
import y.f.*;

public class ag extends a
{
    private v o;
    
    public ag() {
        this.o = new V();
    }
    
    public void a(final double n) {
        super.a(n);
        this.o.a(n);
    }
    
    public void b(final double n) {
        super.b(n);
        this.o.b(n);
    }
    
    public void c(final double a) {
        this.a = a;
        this.o.c(a);
    }
    
    public void d(final double b) {
        this.b = b;
        this.o.d(b);
    }
    
    protected void a(final y[] array, final c c) {
        final boolean i = y.f.c.a.i;
        final X g = this.g;
        if (this.o != null && this.e != null) {
            this.o.a(this.e);
        }
        if (array[0].size() != 1) {
            y.g.o.a(this, "Treedrawer: Not a tree !");
            this.o.a(g, array, c);
            return;
        }
        final x o = g.o();
        while (true) {
            while (o.f()) {
                final int b = o.e().b();
                if (!i) {
                    if (b > 1) {
                        y.g.o.a(this, "Treedrawer: Not a tree !");
                        this.o.a(g, array, c);
                        return;
                    }
                    o.g();
                    if (i) {
                        break;
                    }
                    continue;
                }
                else {
                    if (b != 0 || !A.b(g)) {
                        y.g.o.a(this, "Treedrawer: Not a valid tree !");
                        this.o.a(g, array, c);
                        return;
                    }
                    y.g.o.a(this, "Treedrawer: It's a tree !");
                    final x[] array2 = new x[array.length];
                    int j = 0;
                    while (true) {
                        while (j < array.length) {
                            array2[j] = array[j].a();
                            ++j;
                            if (i) {
                                final y.f.k.x x = new y.f.k.x();
                                x.a(new ai(this.c()));
                                x.a(new ah(this));
                                x.m();
                                x.c(g);
                                return;
                            }
                            if (i) {
                                break;
                            }
                        }
                        this.a(g, array2);
                        continue;
                    }
                }
            }
            this.g.i();
            continue;
        }
    }
}
