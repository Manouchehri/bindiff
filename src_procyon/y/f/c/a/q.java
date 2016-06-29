package y.f.c.a;

import y.f.*;
import y.c.*;

public class q implements z
{
    private static final double a;
    private double b;
    private double c;
    private double d;
    private boolean e;
    private bM f;
    private cc g;
    private bN h;
    private cp i;
    private boolean j;
    
    public q() {
        this.b = 30.0;
        this.c = 15.0;
        this.d = 20.0;
        this.e = true;
        this.f = new bM();
        this.g = new cc();
        this.h = new bN();
        this.i = new cp();
    }
    
    public void a(final X x, final aU au, final aV av) {
        this.f.c(this.c());
        this.f.a(this.a());
        this.f.b(this.b());
        this.f.a(x, au, av);
        this.g.a(Math.max(this.c(), this.b()));
        this.g.a(x, au, av);
        this.h.a(x, au, av);
        this.i.a(x, au, av);
    }
    
    public void b(final X x, final aU au, final aV av) {
        this.f.b(x, au, av);
        this.g.b(x, au, av);
        this.h.b(x, au, av);
        this.i.b(x, au, av);
    }
    
    private double b(final X x, final aQ aq, final aV av, final y.c.q q, final y.c.q q2) {
        double n = 0.0;
        if (q != null) {
            final aX a = av.a(q);
            final byte b = a.b();
            final boolean b2 = b == 8 || b == 9;
            if (b2 || b == 3 || b == 2) {
                final y.c.q f = a.f();
                final B k = av.a(a.g()).k();
                if (k != null && x.j(q) < x.j(f)) {
                    final bs h = k.h();
                    if ((b2 && h.a() == 1) || (b == 3 && h.d() == 1) || (b == 2 && h.c() == 1)) {
                        final double n2 = k.i() / q.a;
                        n += (b2 ? (2.0 * n2) : n2);
                    }
                }
            }
        }
        if (q2 != null) {
            final aX a2 = av.a(q2);
            final byte b3 = a2.b();
            final boolean b4 = b3 == 8 || b3 == 9;
            if (b4 || b3 == 3 || b3 == 2) {
                final y.c.q f2 = a2.f();
                final B i = av.a(a2.g()).k();
                if (i != null && x.j(q2) > x.j(f2)) {
                    final bs h2 = i.h();
                    if ((b4 && h2.a() == 1) || (b3 == 3 && h2.d() == 1) || (b3 == 2 && h2.c() == 1)) {
                        final double n3 = i.i() / q.a;
                        n += (b4 ? (2.0 * n3) : n3);
                    }
                }
            }
        }
        return n;
    }
    
    public double a(final X x, final aQ aq, final aV av, final y.c.q q, final y.c.q q2) {
        final aX ax = (q != null) ? av.a(q) : null;
        final aX ax2 = (q2 != null) ? av.a(q2) : null;
        if (q == null || q2 == null) {
            if (q != null && ax.b() == 15) {
                return this.c();
            }
            if (q2 != null && ax2.b() == 15) {
                return this.c();
            }
        }
        if (this.j && q != null && q2 != null) {
            final aX ax3 = ax;
            final aX ax4 = ax2;
            final bK h = ax3.h();
            final bK h2 = ax4.h();
            if (h != null && h2 != null && h.j() != h2.j()) {
                return 0.0;
            }
        }
        double a = this.e ? this.g.a(x, aq, av, q, q2) : 0.0;
        if (a > this.c()) {
            a = 0.0;
        }
        if (a == Double.MAX_VALUE || a <= 0.0) {
            a = this.f.a(x, aq, av, q, q2);
        }
        double n = Math.max(Math.max(a, a + this.h.a(x, aq, av, q, q2)), this.i.a(x, aq, av, q, q2));
        final cB b = cB.b((i)x);
        if (b != null) {
            n = Math.max(n, b.a(x, av, q, q2));
        }
        return Math.max(n, n + this.b(x, aq, av, q, q2));
    }
    
    public double a() {
        return this.b;
    }
    
    public void a(final double b) {
        this.b = b;
    }
    
    public double b() {
        return this.c;
    }
    
    public void b(final double c) {
        this.c = c;
    }
    
    public double c() {
        return this.d;
    }
    
    public void c(final double d) {
        this.d = d;
    }
    
    static {
        a = Math.sqrt(2.0);
    }
}
