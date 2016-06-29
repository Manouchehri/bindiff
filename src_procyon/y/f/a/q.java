package y.f.a;

import y.f.*;
import y.c.*;
import y.f.e.a.*;

class q implements am
{
    private double a;
    private double b;
    private final j c;
    
    q(final j c) {
        this.c = c;
    }
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public void a(final l l, final af af) {
        final int u = f.u;
        final X f = af.f();
        if (f.e() - j.a(this.c).size() <= 0) {
            return;
        }
        double n = 0.0;
        final double n2 = 1.0 / af.c();
        final x o = f.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final q q = this;
                if (u != 0) {
                    final double a = q.a;
                    final double n3 = this.a * n * (1.0 - l.a());
                    if (n != 0.0 && n3 >= a) {
                        final double b = this.b;
                        this.b += n3;
                        j.d(this.c).b(this.b);
                        final double n4 = this.b / b;
                        final x a2 = j.a(this.c).a();
                        while (a2.f()) {
                            final ag c = af.c(a2.e());
                            c.a(c.b() * n4, c.c() * n4, 0.0);
                            a2.g();
                            if (u != 0) {
                                break;
                            }
                        }
                    }
                    return;
                }
                if (!j.c(this.c).d(e)) {
                    n += j.b(this.c).c(e) * (af.a(e).e() * n2);
                }
                o.g();
                if (u != 0) {
                    break;
                }
            }
            n /= f.e() - j.a(this.c).size();
            final q q = this;
            continue;
        }
    }
}
