package y.f.k;

import y.f.*;
import y.c.*;

class D implements K
{
    private x a;
    private X b;
    private q c;
    private q d;
    private A e;
    private int f;
    private int g;
    private double h;
    private final B i;
    
    D(final B i, final x a, final X b, final q d) {
        this.i = i;
        this.a = a;
        this.b = b;
        this.d = d;
        final A t = b.t();
        this.c = y.a.A.d(b);
        y.a.A.b(b, t);
        this.f = t.a(this.c);
        this.g = t.a(d);
    }
    
    public void a(final b b, final b b2, final b b3) {
        if (this.b.c(B.h) == null) {
            this.e = this.b.t();
            this.b.a(B.h, this.e);
        }
        this.a((A)this.b.c(B.h), b);
    }
    
    E a(final A a, final b b) {
        final int i = y.f.k.d.g;
        final E e = new E(this.i, this.b);
        e.a(this.h);
        final F[] array = new F[this.f];
        int j = 0;
        while (j < this.f) {
            array[j] = e.a(j);
            ++j;
            if (i != 0) {
                break;
            }
        }
        final y y = new y();
        y.c.x x = null;
        Label_0199: {
            if (!this.b.i()) {
                q q = this.b.k();
                final y.c.x o = this.b.o();
                while (o.f()) {
                    x = o;
                    if (i != 0) {
                        break Label_0199;
                    }
                    if (x.e().b() == 0) {
                        q = o.e();
                        if (i == 0) {
                            break;
                        }
                    }
                    o.g();
                    if (i != 0) {
                        break;
                    }
                }
                final C c = new C(this, y);
                c.a(true);
                c.a(this.b, q);
            }
            y.n();
            y.a();
        }
        final y.c.x x2 = x;
        do {
            Label_0201: {
                x2.f();
            }
            int k = 0;
            Label_0208:
            while (k != 0) {
                final q e2 = x2.e();
                Label_0515: {
                    if (e2.c() == 0) {
                        final F f = array[this.f - 1];
                        f.a(e2, new P(this.i.c, this.a.f(e2)), this.i.c);
                        a.a(e2, f);
                        if (i == 0) {
                            break Label_0515;
                        }
                    }
                    if (e2 == this.c) {
                        final F f2 = array[0];
                        f2.a(e2, new P(this.i.c, this.a.f(e2)), this.i.c);
                        a.a(e2, f2);
                        if (i == 0) {
                            break Label_0515;
                        }
                    }
                    int c2 = Integer.MAX_VALUE;
                    final y.c.x o2 = e2.o();
                    while (o2.f()) {
                        final F f3 = (F)a.b(o2.e());
                        k = f3.c();
                        if (i != 0) {
                            continue Label_0208;
                        }
                        if (k < c2) {
                            c2 = f3.c();
                        }
                        o2.g();
                        if (i != 0) {
                            break;
                        }
                    }
                    final F f4 = array[c2 - 1];
                    f4.a(e2, new P(this.i.c, this.a.f(e2)), this.i.c);
                    a.a(e2, f4);
                }
                x2.g();
                continue Label_0201;
            }
            break;
        } while (i == 0);
        return e;
    }
    
    public void a() {
    }
    
    public void a(final double h) {
        this.h = h;
    }
}
