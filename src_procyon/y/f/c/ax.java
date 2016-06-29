package y.f.c;

import y.f.*;
import y.c.*;

class ax
{
    double a;
    double b;
    
    public void a(final double a) {
        this.a = a;
    }
    
    public void b(final double b) {
        this.b = b;
    }
    
    public void a(final X x, final y[] array, final A a) {
        final boolean i = a.i;
        int n = 0;
        do {
            double n2 = 0.0;
            Label_0008: {
                n2 = n;
            }
            Label_0010:
            while (n2 < array.length) {
                final x a2 = array[n].a();
                if (a2.f()) {
                    q e = a2.e();
                    double q = x.q(e);
                    a2.g();
                    while (a2.f()) {
                        final q e2 = a2.e();
                        final double q2 = x.q(e2);
                        final double n3 = n2 = dcmpl(q2, 1.0);
                        if (i) {
                            continue Label_0010;
                        }
                        Label_0222: {
                            if (n3 > 0 && q > 1.0) {
                                a.a(e, this.a);
                                if (!i) {
                                    break Label_0222;
                                }
                            }
                            if (q2 < 1.0 && q < 1.0) {
                                a.a(e, this.b);
                                if (!i) {
                                    break Label_0222;
                                }
                            }
                            if (q < 1.0 && e.a() == 0) {
                                a.a(e, 0.0);
                                if (!i) {
                                    break Label_0222;
                                }
                            }
                            if (q2 < 1.0 && e2.a() == 0) {
                                a.a(e, 0.0);
                                if (!i) {
                                    break Label_0222;
                                }
                            }
                            a.a(e, this.b);
                        }
                        e = e2;
                        q = q2;
                        a2.g();
                        if (i) {
                            break;
                        }
                    }
                }
                ++n;
                continue Label_0008;
            }
            break;
        } while (!i);
    }
    
    public void a(final X x, final y[] array, final c c, final A a) {
        final boolean i = a.i;
        this.a(x, array, a);
        final d[] array2 = new d[x.g()];
        final d[] array3 = new d[x.g()];
        final x o = x.o();
        while (o.f()) {
            final q e = o.e();
            Object o2 = c.b(e);
        Label_0154_Outer:
            while (o2 == null) {
                d d = e.g();
            Label_0074:
                while (true) {
                Label_0147_Outer:
                    while (d != null) {
                        d g = d;
                        final q c2 = g.c();
                        if (!i) {
                            q c3 = c2;
                            while (true) {
                                while (c.b(c3) != null) {
                                    array3[g.b()] = d;
                                    g = c3.g();
                                    c3 = g.c();
                                    if (!i) {
                                        if (i) {
                                            break;
                                        }
                                        continue Label_0147_Outer;
                                    }
                                    else {
                                        if (i) {
                                            break Label_0147_Outer;
                                        }
                                        continue Label_0074;
                                    }
                                }
                                d = d.h();
                                continue Label_0154_Outer;
                            }
                        }
                        d d2 = c2.f();
                    Label_0159:
                        while (d2 != null) {
                            d f = d2;
                            final q q = (q)(o2 = f.d());
                            if (!i) {
                                q d3 = q;
                                while (true) {
                                    while (c.b(d3) != null) {
                                        array2[f.b()] = d2;
                                        f = d3.f();
                                        d3 = f.d();
                                        if (!i) {
                                            if (i) {
                                                break;
                                            }
                                            continue Label_0154_Outer;
                                        }
                                        else {
                                            if (i) {
                                                break Label_0154_Outer;
                                            }
                                            continue Label_0159;
                                        }
                                    }
                                    d2 = d2.g();
                                    continue;
                                }
                            }
                            continue Label_0154_Outer;
                        }
                        break Label_0154_Outer;
                    }
                    continue;
                }
            }
            o.g();
            if (i) {
                break;
            }
        }
        int n = 0;
        do {
            double n2 = 0.0;
            Label_0252: {
                n2 = n;
            }
            Label_0254:
            while (n2 < array.length) {
                final x a2 = array[n].a();
                if (a2.f()) {
                    q e2 = a2.e();
                    double p4 = x.p(e2);
                    a2.g();
                    while (a2.f()) {
                        final q e3 = a2.e();
                        final double p5 = x.p(e3);
                        final double n3 = n2 = dcmpg(p5, 1.0);
                        if (i) {
                            continue Label_0254;
                        }
                        if (n3 <= 0 && p4 <= 1.0) {
                            boolean b = false;
                            if (e3.b() == 1 && e2.b() == 1) {
                                d g2 = e2.g();
                                d g3 = e3.g();
                                if (c.b(e3) != null && c.b(e2) != null) {
                                    g2 = array2[g2.b()];
                                    g3 = array2[g3.b()];
                                }
                                if (g2.c() == g3.c()) {
                                    final double n4 = Math.abs(x.n(g2).a - x.n(g3).a) - 0.5 * (p5 + p4);
                                    if (a.c(e2) > n4) {
                                        a.a(e2, n4);
                                    }
                                    b = true;
                                }
                            }
                            if (e3.c() == 1 && e2.c() == 1) {
                                d f2 = e2.f();
                                d f3 = e3.f();
                                if (c.b(e3) != null && c.b(e2) != null) {
                                    f2 = array3[f2.b()];
                                    f3 = array3[f3.b()];
                                }
                                if (f2.d() == f3.d()) {
                                    double max = Math.abs(x.o(f2).a - x.o(f3).a) - 0.5 * (p5 + p4);
                                    final double c4 = a.c(e2);
                                    if (b) {
                                        max = Math.max(max, c4);
                                    }
                                    if (max < c4) {
                                        a.a(e2, max);
                                    }
                                }
                            }
                        }
                        e2 = e3;
                        p4 = p5;
                        a2.g();
                        if (i) {
                            break;
                        }
                    }
                }
                ++n;
                continue Label_0252;
            }
            break;
        } while (!i);
    }
}
