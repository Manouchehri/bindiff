package y.f;

import y.c.*;
import y.d.*;

public class aw extends a implements ad
{
    protected double a;
    
    public aw() {
        super(null);
        this.a = 0.2;
    }
    
    public void c(final X x) {
        final ah a = this.a();
        if (a != null) {
            a.c(x);
        }
        this.b(x);
    }
    
    protected void b(final X x) {
        final boolean j = X.j;
        final c c = x.c(P.a);
        final c c2 = x.c(P.b);
        final c c3 = x.c(aF.a);
        final c c4 = x.c(aF.b);
        final e p = x.p();
        while (p.f()) {
            final d a = p.a();
            final I b = x.b((Object)a);
            P p2 = null;
            if (c != null && !this.a(c3, a)) {
                p2 = (P)c.b(a);
            }
            if (p2 != null) {
                final q c5 = a.c();
                t t = null;
                Label_0152: {
                    if (b.pointCount() > 0) {
                        t = b.getPoint(0);
                        if (!j) {
                            break Label_0152;
                        }
                    }
                    t = x.q(a);
                }
                final t p3 = x.p(a);
                final double a2 = p3.a;
                final double b2 = p3.b;
                final double n = a2 - t.a;
                final double n2 = b2 - t.b;
                final double sqrt = Math.sqrt(n * n + n2 * n2);
                if (sqrt > 0.001) {
                    final double n3 = n / sqrt;
                    final double n4 = n2 / sqrt;
                    final t l = x.l(c5);
                    final t a3 = p2.a(x.a((Object)c5), a2 - l.a, b2 - l.b, n3, n4);
                    if (a3 != null && !this.a(l.a + a3.a, l.b + a3.b, a2, b2)) {
                        Label_0465: {
                            if (Math.abs(n4 * (l.a + a3.a - t.a) - n3 * (l.b + a3.b - t.b)) > 0.001) {
                                b.addPoint(p3.a, p3.b);
                                int i = b.pointCount() - 1;
                                while (i > 0) {
                                    final t point = b.getPoint(i - 1);
                                    b.setPoint(i, point.a, point.b);
                                    --i;
                                    if (j) {
                                        break Label_0465;
                                    }
                                    if (j) {
                                        break;
                                    }
                                }
                                b.setPoint(0, p3.a, p3.b);
                            }
                        }
                        x.a(a, a3);
                    }
                }
            }
            P p4 = null;
            if (c2 != null && !this.a(c4, a)) {
                p4 = (P)c2.b(a);
            }
            if (p4 != null) {
                t t2 = null;
                Label_0552: {
                    if (b.pointCount() > 0) {
                        t2 = b.getPoint(b.pointCount() - 1);
                        if (!j) {
                            break Label_0552;
                        }
                    }
                    t2 = x.p(a);
                }
                final t q = x.q(a);
                final double a4 = q.a;
                final double b3 = q.b;
                final double n5 = a4 - t2.a;
                final double n6 = b3 - t2.b;
                final double sqrt2 = Math.sqrt(n5 * n5 + n6 * n6);
                if (sqrt2 > 0.001) {
                    final double n7 = n5 / sqrt2;
                    final double n8 = n6 / sqrt2;
                    final q d = a.d();
                    final t k = x.l(d);
                    final t a5 = p4.a(x.a((Object)d), a4 - k.a, b3 - k.b, n7, n8);
                    if (a5 != null && !this.a(k.a + a5.a, k.b + a5.b, a4, b3)) {
                        if (Math.abs(n8 * (k.a + a5.a - t2.a) - n7 * (k.b + a5.b - t2.b)) > 0.001) {
                            b.addPoint(q.a, q.b);
                        }
                        x.b(a, a5);
                    }
                }
            }
            p.g();
            if (j) {
                break;
            }
        }
    }
    
    protected boolean a(final double n, final double n2, final double n3, final double n4) {
        return Math.abs(n - n3) < this.a && Math.abs(n2 - n4) < this.a;
    }
    
    boolean a(final c c, final d d) {
        return c != null && c.b(d) instanceof aE && ((aE)c.b(d)).a();
    }
}
