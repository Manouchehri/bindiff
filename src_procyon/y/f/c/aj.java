package y.f.c;

import y.f.*;
import y.c.*;
import y.g.*;
import java.util.*;
import y.a.*;
import y.f.c.a.*;

public class aj implements R, aT
{
    private long c;
    protected c a;
    protected Object b;
    private boolean d;
    
    public aj() {
        this(null);
    }
    
    public aj(final Object b) {
        this.c = Long.MAX_VALUE;
        this.b = b;
    }
    
    public boolean a() {
        return this.d;
    }
    
    public void a(final long c) {
        this.c = c;
    }
    
    public int a(final X x, final A a, final f f) {
        if (this.b != null) {
            return this.a(x, a, f, x.c(this.b));
        }
        return this.a(x, a, f, null);
    }
    
    public int a(final X x, final A a, final f f, final c a2) {
        final boolean i = a.i;
        this.a = a2;
        final boolean a3 = this.a();
        A t = null;
        y.c.h u = null;
        Label_0045: {
            if (a3) {
                t = x.t();
                u = x.u();
                if (!i) {
                    break Label_0045;
                }
            }
            t = null;
            u = null;
        }
        final A t2 = x.t();
        final int a4 = h.a(x, t2);
        final J j = new J(x, t2);
        int max = 0;
        int k = 0;
        while (true) {
            while (k < a4) {
                j.c(new Integer(k));
                o.a(this, "Make acyclic");
                this.a(x, f, t, u);
                o.a(this, "Assign layers");
                max = Math.max(max, this.a(x, a));
                o.a(this, "done");
                ++k;
                if (i) {
                    if (a3) {
                        x.a(u);
                        x.a(t);
                    }
                    return max;
                }
                if (i) {
                    break;
                }
            }
            j.b();
            x.a(t2);
            continue;
        }
    }
    
    private void a(final X x, final f f, final A a, final y.c.h h) {
        if (this.a()) {
            this.b(x, f, a, h);
            if (!a.i) {
                return;
            }
        }
        this.a(x, f);
    }
    
    private void b(final X x, final f f, final A a, final y.c.h h) {
        final boolean i = a.i;
        if (x.h() < 2 || x.f() < 2) {
            return;
        }
        final I j = new I(x);
        final x o = x.o();
        do {
            Label_0038: {
                o.f();
            }
            boolean e = false;
            Label_0045:
            while (e) {
                final q e2 = o.e();
                final e l = e2.l();
                while (l.f()) {
                    final d a2 = l.a();
                    e = a2.e();
                    if (i) {
                        continue Label_0045;
                    }
                    Label_0219: {
                        if (e) {
                            j.a(a2);
                            if (!i) {
                                break Label_0219;
                            }
                        }
                        final d d = (d)a.b(a2.d());
                        if (d != null && d.c() == e2) {
                            h.a(d, h.c(d) + this.a(a2));
                            h.a(a2, d);
                            j.a(a2);
                            if (!i) {
                                break Label_0219;
                            }
                        }
                        a.a(a2.d(), a2);
                        h.a(a2, this.a(a2));
                    }
                    l.g();
                    if (i) {
                        break;
                    }
                }
                o.g();
                continue Label_0038;
            }
            break;
        } while (!i);
        final HashSet set = new HashSet();
        Label_0297: {
            if (x.h() > 500) {
                y.a.c.a(x, new al(set), h);
                if (!i) {
                    break Label_0297;
                }
            }
            a(x, new al(set), h);
        }
        j.f();
        final e p4 = x.p();
        while (p4.f()) {
            final d a3 = p4.a();
            if (set.contains(a3) || set.contains(h.b(a3))) {
                x.c(a3);
                f.add(a3);
            }
            p4.g();
            if (i) {
                break;
            }
        }
    }
    
    private static void a(final i i, final y.c.h h, final c c) {
        final boolean j = a.i;
        if (g.a(i)) {
            return;
        }
        final I k = new I(i);
        final y.c.h b = M.b();
        final e p3 = i.p();
        while (p3.f()) {
            final d a = p3.a();
            b.a(a, c.c(a));
            h.a(a, false);
            if (a.e()) {
                k.a(a);
                h.a(a, true);
            }
            p3.g();
            if (j) {
                break;
            }
        }
        final f f = new f();
        Label_0312: {
        Label_0299:
            while (true) {
                final f a2;
                double empty = (a2 = y.a.c.a(i, 1 != 0)).isEmpty() ? 1 : 0;
            Label_0210_Outer:
                while (empty == 0) {
                    double n = Double.MAX_VALUE;
                    e e = a2.a();
                    while (true) {
                        while (e.f()) {
                            final double c2 = b.c(e.a());
                            final double n2 = dcmpg(c2, n);
                            if (!j) {
                                if (n2 < 0) {
                                    n = c2;
                                }
                                e.g();
                                if (j) {
                                    break;
                                }
                                continue Label_0210_Outer;
                            }
                            else {
                                while (true) {
                                    if (n2 == 0) {
                                        continue Label_0312;
                                    }
                                    final d a3 = e.a();
                                    final double n3 = b.c(a3) - n;
                                    b.a(a3, n3);
                                    if (j) {
                                        break Label_0312;
                                    }
                                    final double n4 = empty = dcmpg(n3, 0.001);
                                    if (j) {
                                        continue Label_0210_Outer;
                                    }
                                    if (n4 < 0) {
                                        k.a(a3);
                                        f.add(a3);
                                    }
                                    e.g();
                                    if (j) {
                                        break Label_0299;
                                    }
                                    e.f();
                                    continue Label_0210_Outer;
                                }
                            }
                        }
                        e = a2.a();
                        continue;
                    }
                }
                break;
            }
            f.sort(new ak(c));
        }
        final e a4 = f.a();
        while (a4.f()) {
            final d a5 = a4.a();
            k.c(a5);
            if (j) {
                return;
            }
            if (!g.a(i)) {
                k.a(a5);
                h.a(a5, true);
            }
            a4.g();
            if (j) {
                break;
            }
        }
        k.f();
    }
    
    protected double a(final d d) {
        return 1.0;
    }
    
    public void a(final X x, final f f) {
        this.a((i)x, f);
    }
    
    public void a(final i i, final f f) {
        final boolean j = y.f.c.a.i;
        final y.c.h b = M.b(new boolean[i.g()]);
        y.a.c.a(i, b);
        final e p2 = i.p();
        while (p2.f()) {
            final d a = p2.a();
            if (b.d(a)) {
                i.c(a);
                f.add(a);
            }
            p2.g();
            if (j) {
                break;
            }
        }
    }
    
    public int a(final i i, final A a) {
        return u.a(i, a, this.a, null, this.c);
    }
    
    public void a(final X x, final aU au, final aV av) {
        new ba(this).a(x, au, av);
    }
}
