package y.f.c;

import y.f.*;
import y.d.*;
import y.c.*;

class aw implements ao
{
    public void a(final X x, final A a, final A a2) {
        final boolean i = a.i;
        p p3 = x.E().l();
        while (p3 != null) {
            this.a(x, (d)p3.c(), a, a2);
            p3 = p3.b();
            if (i) {
                break;
            }
        }
    }
    
    public q a(final X x, final d d, final A a, final A a2) {
        final boolean i = a.i;
        final q c = d.c();
        final q d2 = d.d();
        int j = a.a(d2) - a.a(c);
        if (j > 1) {
            final A a3 = K.a((i)x);
            q d3 = null;
            q q = c;
            q q2 = null;
            while (j > 1) {
                d3 = x.d();
                a3.a(d3, K.q);
                x.b(d3, 1.0, 1.0);
                x.b(d3, t.c);
                final d a4 = x.a(q, d3);
                q2 = q;
                if (i) {
                    return q2;
                }
                if (q2 == c) {
                    x.a(a4, x.n(d));
                }
                a.a(d3, a.a(q) + 1);
                a2.a(d3, d);
                q = d3;
                --j;
                if (i) {
                    break;
                }
            }
            x.b(x.a(d3, d2), x.o(d));
            x.d(d);
            return q2;
        }
        return null;
    }
    
    public void b(final X x, final A a, final A a2) {
        final boolean i = a.i;
        x x2 = x.o();
        while (true) {
            while (x2.f()) {
                q e = x2.e();
                final d d = (d)a2.b(e);
                Object b;
                final d d2 = (d)(b = d);
                if (i) {
                    while (true) {
                        if (b != null) {
                            x.a(x2.e());
                        }
                        x2.g();
                        if (!i) {
                            if (x2.f()) {
                                b = a2.b(x2.e());
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0277: {
                    if (d2 != null && !x.f(d)) {
                        q q = e.g().c();
                        while (true) {
                            while (a2.b(q) != null) {
                                e = q;
                                q = e.g().c();
                                if (i) {
                                    d d3 = e.g();
                                    final D d4 = new D();
                                    while (true) {
                                        while (a2.b(d3.d()) != null) {
                                            final t p3 = x.p(d3);
                                            d4.add(p3);
                                            d4.a(x.k(d3));
                                            final t t = x.q(d3);
                                            final boolean equals = t.equals(p3);
                                            if (i) {
                                                if (!equals) {
                                                    d4.add(t);
                                                }
                                                x.a(d, d4);
                                                break Label_0277;
                                            }
                                            if (!equals) {
                                                d4.add(t);
                                            }
                                            d3 = d3.d().f();
                                            if (i) {
                                                break;
                                            }
                                        }
                                        final t p4 = x.p(d3);
                                        d4.add(p4);
                                        d4.a(x.k(d3));
                                        final t t = x.q(d3);
                                        t.equals(p4);
                                        continue;
                                    }
                                }
                                if (i) {
                                    break;
                                }
                            }
                            x.e(d);
                            continue;
                        }
                    }
                }
                x2.g();
                if (i) {
                    break;
                }
            }
            x2 = x.o();
            continue;
        }
    }
}
