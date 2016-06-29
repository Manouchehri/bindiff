package y.f.e.a;

import y.f.*;
import y.g.*;
import y.f.b.*;
import java.util.*;
import y.d.*;
import y.c.*;

class t implements am
{
    private final ay a;
    private A b;
    private u c;
    
    t(final ay a) {
        this.a = a;
    }
    
    private c a(final X x) {
        c c = x.c(as.a);
        if (c == null) {
            c = q.a(Boolean.TRUE);
        }
        return c;
    }
    
    public void a(final l l, final af af) {
        final boolean b = af.b;
        final X f = af.f();
        if (y.f.b.c.c(f)) {
            return;
        }
        final c c = f.c(y.f.b.f.e);
        this.b = f.t();
        final y.f.b.c c2 = new y.f.b.c(f);
        final A t = f.t();
        final A t2 = f.t();
        final ArrayList<J> list = new ArrayList<J>();
        final r r = new r(5.0, 5.0, 5.0, 5.0);
        final c a = this.a(f);
        int n = 0;
        final x o = f.o();
        while (true) {
            while (o.f()) {
                final y.c.q e = o.e();
                final int d = c2.d(e) ? 1 : 0;
                if (b) {
                    int d3 = 0;
                    if (d > 0) {
                        final x o2 = f.o();
                        do {
                            Label_0493: {
                                o2.f();
                            }
                            boolean d2 = false;
                            Label_0500:
                            while (d2) {
                                final y.c.q e2 = o2.e();
                                d3 = (c2.d(e2) ? 1 : 0);
                                if (!b) {
                                    if (d3 != 0 && a.d(e2)) {
                                        y.c.q q = c2.a(e2);
                                        while (q != c2.b()) {
                                            d2 = a.d(q);
                                            if (b) {
                                                continue Label_0500;
                                            }
                                            if (d2) {
                                                break;
                                            }
                                            q = c2.a(q);
                                            if (b) {
                                                break;
                                            }
                                        }
                                        if (q != c2.b()) {
                                            ((ArrayList)t.b(q)).add(t2.b(e2));
                                        }
                                    }
                                    o2.g();
                                    continue Label_0493;
                                }
                                break;
                            }
                            break;
                        } while (!b);
                    }
                    y.f.b.c c4 = null;
                    Label_1229: {
                        if (d3 > 0) {
                            final x o3 = f.o();
                            do {
                                Label_0647: {
                                    o3.f();
                                }
                                boolean d4 = false;
                                Label_0654:
                                while (d4) {
                                    final y.c.q e3 = o3.e();
                                    final ag c3 = af.c(e3);
                                    if (!b) {
                                        Label_0797: {
                                            if (!c3.k() || !a.d(e3)) {
                                                y.c.q q2 = c2.a(e3);
                                                while (q2 != c2.b()) {
                                                    d4 = a.d(q2);
                                                    if (b) {
                                                        continue Label_0654;
                                                    }
                                                    if (d4) {
                                                        break;
                                                    }
                                                    q2 = c2.a(q2);
                                                    if (b) {
                                                        break;
                                                    }
                                                }
                                                if (q2 != c2.b()) {
                                                    this.b.a(e3, t.b(q2));
                                                    if (!b) {
                                                        break Label_0797;
                                                    }
                                                }
                                                this.b.a(e3, list);
                                            }
                                        }
                                        o3.g();
                                        continue Label_0647;
                                    }
                                    return;
                                }
                                break;
                            } while (!b);
                            final e p2 = f.p();
                            while (p2.f()) {
                                final d a2 = p2.a();
                                c4 = c2;
                                if (b) {
                                    break Label_1229;
                                }
                                Label_1177: {
                                    if (!c4.a(a2)) {
                                        final y.c.q c5 = a2.c();
                                        final y.c.q d5 = a2.d();
                                        final y.c.q a3 = c2.a(c5);
                                        final y.c.q a4 = c2.a(d5);
                                        final boolean b2 = a3 != c2.b() && a.d(a3);
                                        final boolean b3 = a4 != c2.b() && a.d(a4);
                                        if (b2 && b3 && a4 != a3) {
                                            final double j = f.j(a3);
                                            final double k = f.k(a3);
                                            final double i = f.j(a4);
                                            final double m = f.k(a4);
                                            af.b(a2).a(Math.sqrt((i - j) * (i - j) + (m - k) * (m - k)));
                                            if (!b) {
                                                break Label_1177;
                                            }
                                        }
                                        if (b3 && a3 == c2.b()) {
                                            final double n2 = f.p(a4) / 2.0;
                                            final double n3 = f.q(a4) / 2.0;
                                            af.b(a2).a(Math.sqrt(n2 * n2 + n3 * n3) * 0.3);
                                            if (!b) {
                                                break Label_1177;
                                            }
                                        }
                                        if (a4 == c2.b() && b2) {
                                            final double n4 = f.p(a3) / 2.0;
                                            final double n5 = f.q(a3) / 2.0;
                                            af.b(a2).a(Math.sqrt(n4 * n4 + n5 * n5) * 0.3);
                                        }
                                    }
                                }
                                p2.g();
                                if (b) {
                                    break;
                                }
                            }
                            this.c = new u(this.b);
                            this.a.a(this.c);
                        }
                        f.a(t);
                        f.a(t2);
                    }
                    c4.c();
                    return;
                }
                if (d != 0 && a.d(e)) {
                    ++n;
                    r r2 = r;
                    if (c != null) {
                        final r a5 = y.d.r.a(c.b(e));
                        if (a5 != null) {
                            r2 = a5;
                        }
                    }
                    final double n6 = f.m(e) + r2.b;
                    final double n7 = f.n(e) + r2.a;
                    final double n8 = f.p(e) - r2.b - r2.d;
                    final double n9 = f.q(e) - r2.a - r2.c;
                    final double n10 = Math.min(n8, n9) / 10.0;
                    final J j2 = new J(new ai(n6, n7, n8, n9, n10), J.d, 0.0, 1.0);
                    j2.c(10.0);
                    final ArrayList<J> list2 = new ArrayList<J>(1);
                    list2.add(j2);
                    t.a(e, list2);
                    final J j3 = new J(new v(f.m(e) - n10, f.n(e) - n10, f.p(e) + 2.0 * n10, f.q(e) + 2.0 * n10, n10), J.a, 0.0, 1.0);
                    j3.a(J.j);
                    j3.c(10.0);
                    if (c2.a(e) == c2.b()) {
                        list.add(j3);
                    }
                    t2.a(e, j3);
                    af.c(e).d(1.0);
                    af.c(e).a(true);
                }
                o.g();
                if (b) {
                    break;
                }
            }
            continue;
        }
    }
    
    void a(final af af) {
        if (this.b != null) {
            af.f().a(this.b);
            this.b = null;
        }
        if (this.c != null) {
            this.a.b(this.c);
            this.c = null;
        }
    }
}
