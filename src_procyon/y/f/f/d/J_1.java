package y.f.f.d;

import y.f.f.b.*;
import y.f.*;
import java.awt.*;
import y.c.*;

class J implements M
{
    private h a;
    private A b;
    private int c;
    
    public J(final int c) {
        this.c = c;
    }
    
    public void a(final h a) {
        final boolean p = o.p;
        y.g.o.a(this, "Big Node Model !");
        this.a = a;
        final X x = (X)a.a();
        this.b = a.a().t();
        final x o = a.a().o();
        while (o.f()) {
            final q e = o.e();
            if (a.d(e)) {
                final int[] h = a.h(e);
                Dimension dimension;
                if (h[0] > 1 || h[1] > 1 || h[2] > 1 || h[3] > 1) {
                    int n = (h[1] > h[3]) ? h[1] : h[3];
                    int n2 = (h[0] > h[2]) ? h[0] : h[2];
                    if (n > 0) {
                        --n;
                    }
                    if (n2 > 0) {
                        --n2;
                    }
                    dimension = new Dimension(n2, n);
                }
                else {
                    dimension = new Dimension(0, 0);
                }
                this.b.a(e, dimension);
                x.b(e, dimension.width * this.c + this.c / 2, dimension.height * this.c + this.c / 2);
            }
            o.g();
            if (p) {
                break;
            }
        }
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean a(final q q) {
        return this.a.d(q);
    }
    
    public int b(final q q) {
        return ((Dimension)this.b.b(q)).width;
    }
    
    public int c(final q q) {
        return ((Dimension)this.b.b(q)).height;
    }
    
    public boolean d(final q q) {
        return this.a(q);
    }
    
    public double b() {
        return 1.0;
    }
    
    public boolean c() {
        return false;
    }
    
    public int e(final q q) {
        return 0;
    }
    
    public int f(final q q) {
        return 0;
    }
    
    public void d() {
        this.a.a().a(this.b);
    }
}
