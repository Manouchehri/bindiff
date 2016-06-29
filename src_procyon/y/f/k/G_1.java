package y.f.k;

import y.f.*;
import y.c.*;

class G implements K
{
    private x a;
    private final X b;
    private final q c;
    private double d;
    private A e;
    private final B f;
    
    G(final B f, final x a, final X b, final q c) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final b b, final b b2, final b b3) {
        if (this.b.c(B.h) == null) {
            this.e = this.b.t();
            this.b.a(B.h, this.e);
        }
        this.a((A)this.b.c(B.h), b);
    }
    
    E a(final A a, final b b) {
        final int g = y.f.k.d.g;
        final E e = new E(this.f, this.b);
        e.a(this.d);
        final y y = new y();
        y.add(this.c);
    Label_0269:
        while (y.size() > 0) {
            final q d = y.d();
            F f = null;
            Label_0122: {
                if (d == this.c || d.g() == null) {
                    f = e.a(0);
                    if (g == 0) {
                        break Label_0122;
                    }
                }
                f = ((F)a.b(d.g().c())).e();
            }
            f.a(d, new P(this.f.c, this.a.f(d)), this.f.c);
            a.a(d, f);
            final I i = (I)b.b(d);
            if (!(i instanceof B)) {
                continue;
            }
            if (!this.f.c().equals(((B)i).c())) {
                continue;
            }
            y.c.d d2 = d.f();
            while (d2 != null) {
                y.add(d2.d());
                d2 = d2.g();
                if (g != 0 || g != 0) {
                    break Label_0269;
                }
            }
        }
        return e;
    }
    
    public void a() {
        if (this.e != null) {
            this.b.a(this.e);
            this.b.d_(B.h);
        }
    }
    
    public void a(final double d) {
        this.d = d;
    }
}
