package y.f.a;

import y.f.k.*;
import java.util.*;
import y.c.*;

class x extends o
{
    A n;
    h o;
    h p;
    boolean q;
    double r;
    private boolean t;
    
    x() {
        this.q = false;
        this.r = 90.0;
        this.t = false;
    }
    
    public void a(final h p) {
        this.p = p;
    }
    
    protected void a(final q q) {
        if (this.t) {
            return;
        }
        if (this.n()) {
            q.b(new y(this));
            if (y.f.a.f.u == 0) {
                return;
            }
        }
        super.a(q);
    }
    
    void a(final h o, final A n) {
        this.n = n;
        this.o = o;
        this.q = true;
    }
    
    protected void b(final q q) {
        final int i = y.f.a.f.u;
        if (!this.d(q)) {
            super.b(q);
            return;
        }
        final double q2 = this.q();
        final double c = this.c(q);
        final double r = this.r;
        final y.c.f f = new y.c.f(q.l());
    Label_0050:
        while (true) {
        Label_0505_Outer:
            while (true) {
                final double n = (360.0 - c) / 2.0 + c;
                this.f(q);
                double n2 = (360.0 - c) / 2.0;
                p b = null;
                y.f.k.q e = null;
                p p = f.k();
            Label_0505:
                while (true) {
                    while (p != null) {
                        final d d = (d)p.c();
                        final y.f.k.q e2 = this.e(d.d());
                        final double c2 = this.o.c(d);
                        double d2 = c2 - (n2 + e2.c);
                        final double n3 = dcmpl(d2, 0.0);
                        if (i == 0) {
                            Label_0235: {
                                if (n3 >= 0 && c2 + e2.b >= n) {
                                    if (n2 + e2.a() <= n) {
                                        d2 = n - n2 - e2.a();
                                        if (i == 0) {
                                            break Label_0235;
                                        }
                                    }
                                    d2 = 2.0 * (n - (c2 + e2.b));
                                }
                            }
                            e2.d = 0.0;
                            Label_0478: {
                                if (d2 >= 0.0) {
                                    e2.d = d2;
                                    b = p;
                                    e = e2;
                                    if (i == 0) {
                                        break Label_0478;
                                    }
                                }
                                Label_0316: {
                                    if (-d2 > e2.b + e2.c) {
                                        d2 = (e2.b + e2.c) / 2.0;
                                        if (i == 0) {
                                            break Label_0316;
                                        }
                                    }
                                    d2 /= -2.0;
                                }
                                n2 -= d2;
                                if (n2 <= n && n2 + e2.a() > n) {
                                    final double n4 = n2 + d2;
                                    d2 = n4 + e2.a() - n;
                                    n2 = n4 - d2;
                                }
                                while (b != null) {
                                    final double n5 = dcmpl(d2, e.d);
                                    if (i != 0) {
                                        break Label_0505;
                                    }
                                    if (n5 <= 0) {
                                        break;
                                    }
                                    d2 -= e.d;
                                    e.d = 0.0;
                                    b = b.b();
                                    if (b == null) {
                                        e = null;
                                        break;
                                    }
                                    e = this.e(((d)b.c()).d());
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                if (b != null) {
                                    final y.f.k.q q3 = e;
                                    q3.d -= d2;
                                    if (i == 0) {
                                        break Label_0478;
                                    }
                                }
                                n2 += d2;
                            }
                            n2 += e2.a();
                            p = p.a();
                            if (i != 0) {
                                break;
                            }
                            continue Label_0505_Outer;
                        }
                        Label_0656: {
                            if (n3 <= 0) {
                                double abs = 0.0;
                                double n6 = (360.0 - c) / 2.0;
                                final e l = q.l();
                                while (true) {
                                    while (l.f()) {
                                        final d a = l.a();
                                        final q d3 = a.d();
                                        final double c3 = this.o.c(a);
                                        final y.f.k.q e3 = this.e(d3);
                                        final double n7 = n6 + e3.d + e3.c;
                                        final double n8 = dcmpg(abs, Math.abs(n7 - c3));
                                        if (i == 0) {
                                            if (n8 < 0) {
                                                abs = Math.abs(n7 - c3);
                                            }
                                            n6 += e3.a();
                                            l.g();
                                            if (i != 0) {
                                                break;
                                            }
                                            continue Label_0505_Outer;
                                        }
                                        else {
                                            if (n8 <= 0) {
                                                break Label_0050;
                                            }
                                            break Label_0656;
                                        }
                                    }
                                    final double n9 = dcmpg(abs, this.r);
                                    continue;
                                }
                            }
                        }
                        do {
                            final y.c.x o;
                            Label_0659: {
                                o = q.o();
                            }
                            while (true) {
                                while (o.f()) {
                                    final q e4 = o.e();
                                    double e5 = this.e(e4).e * (1.0 + q2);
                                    final boolean infinite = Double.isInfinite(e5);
                                    if (i == 0) {
                                        if (infinite) {
                                            e5 = this.r();
                                        }
                                        this.e(e4).e = e5;
                                        o.g();
                                        if (i != 0) {
                                            break;
                                        }
                                        continue Label_0505_Outer;
                                    }
                                    else {
                                        if (infinite) {
                                            this.r += 10.0;
                                            continue Label_0659;
                                        }
                                        continue Label_0050;
                                    }
                                }
                                continue;
                            }
                        } while (i != 0);
                        continue Label_0050;
                    }
                    final double n10 = dcmpg(n2, n);
                    continue Label_0505;
                }
            }
            break;
        }
    }
    
    protected double c(final q q) {
        if (!this.d(q)) {
            return super.c(q);
        }
        if (q.b() == 0) {
            return this.o();
        }
        return this.p();
    }
    
    boolean d(final q q) {
        return this.q && q.c() != 0 && this.o.b(q.f()) != null;
    }
}
