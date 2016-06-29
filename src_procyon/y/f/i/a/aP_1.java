package y.f.i.a;

import y.d.*;
import y.c.*;

class aP implements g
{
    private final i a;
    private final h b;
    private final h c;
    private final c d;
    private final aN e;
    
    aP(final aN e, final i a, final h b, final h c, final c d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void a(final Object o, final Object o2) {
        final int a = ab.a;
        final aT at = (aT)o;
        final aT at2 = (aT)o2;
        if (at.a() && at2.a()) {
            return;
        }
        final q f = at.f;
        final q f2 = at2.f;
        final int n = (at.a() || at2.a()) ? 10 : 100;
        if (at.f() != null && at.f() == at2.f()) {
            final q d = this.a.d();
            final d a2 = this.a.a(f, d);
            final d a3 = this.a.a(f2, d);
            this.b.a(a2, 0);
            this.c.a(a2, n);
            this.b.a(a3, 0);
            this.c.a(a3, n);
            if (a == 0) {
                return;
            }
        }
        final q d2 = this.a.d();
        final d a4 = this.a.a(f, d2);
        final d a5 = this.a.a(f2, d2);
        final q d3 = this.a.d();
        final d a6 = this.a.a(f, d3);
        final d a7 = this.a.a(f2, d3);
        final int n2 = (int)Math.ceil(aN.a(this.e, at, at2));
        if (at.i() == at2.i()) {
            final double n3 = at2.b() - at.b();
            final double n4 = at2.c() - at.c();
            if ((at.k() && n3 + n4 > 0.0) || (!at.k() && n3 - n4 > 0.0)) {
                this.b.a(a4, n2);
                this.b.a(a5, 0);
                this.c.a(a5, 10);
                this.c.a(a7, n);
                if (a == 0) {
                    return;
                }
            }
            this.b.a(a5, n2);
            this.b.a(a4, 0);
            this.c.a(a4, 10);
            this.c.a(a6, n);
            if (a == 0) {
                return;
            }
        }
        final boolean b = this.d.a(f) < this.d.a(f2);
        if (at.i() == 3 || at.i() == 1) {
            if (b) {
                this.b.a(a4, n2);
                this.b.a(a5, 0);
                this.c.a(a5, 10);
                this.c.a(a7, 100);
                if (a == 0) {
                    return;
                }
            }
            this.b.a(a5, n2);
            this.b.a(a4, 0);
            this.c.a(a4, 10);
            this.c.a(a6, 100);
            if (a == 0) {
                return;
            }
        }
        if (at.i() == 2 || at.i() == 0) {
            if (!b) {
                this.b.a(a5, n2);
                this.b.a(a4, 0);
                this.c.a(a4, 10);
                this.c.a(a6, 100);
                if (a == 0) {
                    return;
                }
            }
            this.b.a(a4, n2);
            this.b.a(a5, 0);
            this.c.a(a5, 10);
            this.c.a(a7, 100);
        }
    }
}
