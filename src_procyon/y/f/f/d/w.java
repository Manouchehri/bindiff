package y.f.f.d;

import y.f.f.b.*;
import y.f.*;
import y.d.*;
import y.c.*;

public class w implements b
{
    private static boolean d;
    protected i a;
    protected h b;
    protected c c;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public w() {
        this.e = 0;
        this.f = 10;
        this.g = 5;
        this.h = 2;
        this.c = new x(this);
    }
    
    public void a(final h b) {
        this.b = b;
        this.a = b.a();
    }
    
    public int b() {
        return this.e;
    }
    
    public void a(final y.c.h c) {
        this.c = c;
    }
    
    public void a() {
        final boolean p = o.p;
        final X x = (X)this.a;
        final A t = this.a.t();
        final y.c.h u = this.a.u();
        this.a(x, u, this.c, t);
        final y.c.h u2 = this.a.u();
        this.b(u2);
        final int n = 2 * (this.g + this.h);
        final y.c.h u3 = x.u();
        final e p2 = x.p();
        while (p2.f()) {
            u3.a(p2.a(), n);
            p2.g();
            if (p) {
                break;
            }
        }
        final G g = new G();
        g.a(this.b);
        g.a(t);
        g.c(u2);
        g.a((c)u3);
        g.b(w.d);
        final y.c.h u4 = this.a.u();
        g.b(u4);
        g.a();
        this.a(u4, u);
        this.b.j();
        this.a.a(u4);
        this.a.a(u);
        this.a.a(t);
        this.a.a(u2);
        this.e = g.b();
        x.a(u3);
    }
    
    private void b(final y.c.h h) {
        final boolean p = o.p;
        final y.c.x o = this.a.o();
        do {
            Label_0013: {
                o.f();
            }
            boolean a = false;
            Label_0019:
            while (a) {
                final q e = o.e();
                if (this.b.g(e)) {
                    final e l = e.l();
                    while (l.f()) {
                        final d a2 = l.a();
                        a = this.a(a2.d());
                        if (p) {
                            continue Label_0019;
                        }
                        if (!a) {
                            h.a(this.b.a(a2), true);
                        }
                        l.g();
                        if (p) {
                            break;
                        }
                    }
                }
                o.g();
                continue Label_0013;
            }
            break;
        } while (!p);
    }
    
    private void a(final y.c.h h, final y.c.h h2) {
        final boolean p2 = o.p;
        y.f.f.b.o o = null;
        double n = Double.MAX_VALUE;
        final d a = this.a.p().a();
        int i = 0;
    Label_0029:
        while (true) {
        Label_0236_Outer:
            while (i < 4) {
                final y.f.f.b.o a2 = y.f.f.b.o.a(i);
                this.b.a(h, a, a2);
                double n2 = 0.0;
                final w w = this;
                if (!p2) {
                    final e p3 = this.a.p();
                    while (true) {
                        while (p3.f()) {
                            final d a3 = p3.a();
                            final double d;
                            final int n3 = (int)(d = (this.c.d(a3) ? 1 : 0));
                            if (!p2) {
                                if (n3 == 0) {
                                    if (!this.c.d(this.b.a(a3))) {
                                        final double n4 = this.b.h(a3).b(2).g() * 3.141592653589793 / 2.0;
                                        final double c = h2.c(a3);
                                        if (!Double.isNaN(c)) {
                                            double a4 = y.d.b.a(n4, -c);
                                            if (a4 > 3.141592653589793) {
                                                a4 = 6.283185307179586 - a4;
                                            }
                                            n2 += a4;
                                        }
                                    }
                                }
                                p3.g();
                                if (p2) {
                                    break;
                                }
                                continue Label_0236_Outer;
                            }
                            else {
                                if (d < 0) {
                                    n = n2;
                                    o = a2;
                                }
                                ++i;
                                if (p2) {
                                    break Label_0236_Outer;
                                }
                                continue Label_0029;
                            }
                        }
                        double d = dcmpg(n2, n);
                        continue;
                    }
                }
                w.b.l();
                return;
            }
            this.b.a(h, a, o);
            final w w = this;
            continue;
        }
    }
    
    private boolean a(final q q) {
        return this.b.b(q) || this.b.g(q);
    }
    
    private void a(final X x, final y.c.h h, final c c, final A a) {
        final boolean p4 = o.p;
        final double[] array = new double[x.h()];
        final z z = new z(0.0, 1.0);
        final e p5 = x.p();
        while (p5.f()) {
            final d a2 = p5.a();
            if (!c.d(a2)) {
                h.a(a2, array[a2.b()] = y.d.z.d(z, new z(x.q(a2), x.p(a2))));
            }
            p5.g();
            if (p4) {
                break;
            }
        }
        final y.c.x o = x.o();
    Label_0674:
        do {
            o.f();
            boolean d = false;
        Label_0138:
            while (d) {
                final q e = o.e();
                final D d2 = new D();
                int n = 0;
                final e l = e.l();
                while (true) {
                    while (l.f()) {
                        final int d3 = c.d(l.a()) ? 1 : 0;
                        if (p4) {
                            if (d3 >= 2) {
                                final e i = e.l();
                                while (c.d(i.a())) {
                                    i.g();
                                    if (p4) {
                                        continue Label_0674;
                                    }
                                    if (p4) {
                                        break;
                                    }
                                }
                                y.f.f.d.D d4 = new y.f.f.d.D();
                                d4.a(i.a());
                                final d[] array2 = { i.a(), null };
                                i.g();
                                int j = 0;
                                while (j < e.c()) {
                                    d4.a(array2[1] = i.a());
                                    d = c.d(array2[1]);
                                    if (p4) {
                                        continue Label_0138;
                                    }
                                    if (!d) {
                                        final double a3 = y.d.b.a(array[array2[1].b()], -array[array2[0].b()]);
                                        int n2 = 0;
                                        Label_0476: {
                                            if (a3 == 0.0) {
                                                if (y.d.z.b(new z(x.n(array2[0])), new z(x.n(array2[1])))) {
                                                    n2 = -1;
                                                    if (!p4) {
                                                        break Label_0476;
                                                    }
                                                }
                                                n2 = 3;
                                                if (!p4) {
                                                    break Label_0476;
                                                }
                                            }
                                            n2 = (int)Math.floor(2.0 * a3 / 3.141592653589793 + 0.5) - 1;
                                        }
                                        d4.a(n2);
                                        Label_0607: {
                                            if (this.b.g(e)) {
                                                if (n2 == 0) {
                                                    d4.a(new Integer(Math.max(0, 2 * (this.g - this.h))));
                                                    if (!p4) {
                                                        break Label_0607;
                                                    }
                                                }
                                                if (n2 == 2) {
                                                    d4.a(new Integer(Math.max(0, 2 * (this.h - this.g))));
                                                    if (!p4) {
                                                        break Label_0607;
                                                    }
                                                }
                                                d4.a(new Integer(this.f));
                                                if (!p4) {
                                                    break Label_0607;
                                                }
                                            }
                                            d4.a(new Integer(this.f));
                                        }
                                        d2.add(d4);
                                        d4 = new y.f.f.d.D();
                                        d4.a(array2[1]);
                                        array2[0] = array2[1];
                                    }
                                    ++j;
                                    i.b();
                                    if (p4) {
                                        break;
                                    }
                                }
                            }
                            a.a(e, d2);
                            o.g();
                            continue Label_0674;
                        }
                        if (d3 == 0) {
                            ++n;
                        }
                        l.g();
                        if (p4) {
                            break;
                        }
                    }
                    continue;
                }
            }
            break;
        } while (!p4);
    }
    
    static {
        w.d = false;
    }
}
