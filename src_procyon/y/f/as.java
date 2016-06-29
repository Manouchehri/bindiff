package y.f;

import java.util.*;
import y.d.*;
import y.c.*;

public class as extends a
{
    public static final Object a;
    public static final Object b;
    protected f c;
    public h d;
    protected double e;
    boolean f;
    private boolean g;
    private double h;
    private double i;
    private boolean n;
    private boolean o;
    
    public as() {
        this.f = false;
        this.g = false;
        this.h = 20.0;
        this.i = 0.1;
        this.n = true;
        this.o = true;
        this.c = new f();
        this.e = 10.0;
    }
    
    public void a(final boolean o) {
        this.o = o;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public void c(final X x) {
        this.d = x.u();
        this.a((i)x);
        this.a(x);
        this.b(x);
        this.a(x, this.d);
        x.a(this.d);
    }
    
    protected void a(final X x, final h h) {
        final boolean j = X.j;
        final e p2 = x.p();
        while (p2.f()) {
            final d a = p2.a();
            Label_0737: {
                if (h.b(a) != null) {
                    final f f = (f)h.b(a);
                    final double e = this.e;
                    if (this.o && !this.g) {
                        if (a.e()) {
                            final int n = f.size() + 1;
                            final y s = x.s(a.c());
                            ae.a(x, a, f, Math.floor(Math.min(Math.min(s.a(), s.b()) * 0.5 / (n + 1), this.e)), this.n, false, this.h, this.i);
                            if (!j) {
                                break Label_0737;
                            }
                        }
                        if (x.k(a).isEmpty()) {
                            final z z = new z(x.p(a), x.q(a));
                            final D a2 = a(x.s(a.c()), z);
                            a2.a(a(x.s(a.d()), z));
                            a2.sort(new av());
                            final y.d.a a3 = (y.d.a)a2.get(1);
                            final y.d.a a4 = (y.d.a)a2.get(2);
                            final y.d.a a5 = new y.d.a(x.p(a), z);
                            ae.a(x, a, f, Math.floor(Math.min(2.0 * Math.min(a(a3, a5, z), a(a4, a5, z)) / (f.size() + 2), e)), this.n, this.g, this.h, this.i);
                            this.a(f, a.c(), a3, a4, x);
                            this.a(f, a.d(), a3, a4, x);
                            if (!j) {
                                break Label_0737;
                            }
                        }
                        final v l = x.l(a);
                        final z i = l.a(0).i();
                        final D a6 = a(x.s(a.c()), i);
                        final y.d.a a7 = new y.d.a(x.p(a), i);
                        final double n2 = 2.0 * Math.min(a((y.d.a)a6.f(), a7, i), a((y.d.a)a6.i(), a7, i)) / (f.size() + 2);
                        final z k = l.a(l.h() - 2).i();
                        final D a8 = a(x.s(a.d()), k);
                        ae.a(x, a, f, Math.floor(Math.min(Math.min(n2, a((y.d.a)a8.f(), (y.d.a)a8.i(), k) / (f.size() + 2)), e)), this.n, this.g, this.h, this.i);
                        this.a(f, a.c(), (y.d.a)a6.f(), (y.d.a)a6.i(), x);
                        this.a(f, a.d(), (y.d.a)a8.f(), (y.d.a)a8.i(), x);
                        if (!j) {
                            break Label_0737;
                        }
                    }
                    if (a.e()) {
                        ae.a(x, a, f, Math.floor(e), this.n, false, this.h, this.i);
                        if (!j) {
                            break Label_0737;
                        }
                    }
                    ae.a(x, a, f, Math.floor(e), this.n, this.g, this.h, this.i);
                }
            }
            p2.g();
            if (j) {
                break;
            }
        }
    }
    
    private void a(final f f, final q q, final y.d.a a, final y.d.a a2, final X x) {
        final boolean j = X.j;
        final y s = x.s(q);
        final t l = x.l(q);
        final boolean a3 = this.a(s, a, a2);
        final e a4 = f.a();
        while (a4.f()) {
            final d a5 = a4.a();
            final v i = x.l(a5);
            final m m = (a5.c() == q) ? i.a(0) : i.a(i.h() - 2);
            final y.d.a a6 = new y.d.a(m.c(), m.i());
            t t = null;
            Label_0185: {
                if (a3) {
                    t = y.d.a.a(new y.d.a(l, new z(1.0, 0.0)), a6);
                    if (!j) {
                        break Label_0185;
                    }
                }
                t = y.d.a.a(new y.d.a(l, new z(0.0, 1.0)), a6);
            }
            Label_0217: {
                if (a5.c() == q) {
                    x.c(a5, t);
                    if (!j) {
                        break Label_0217;
                    }
                }
                x.d(a5, t);
            }
            a4.g();
            if (j) {
                break;
            }
        }
    }
    
    private boolean a(final y y, final y.d.a a, final y.d.a a2) {
        final y.d.a a3 = new y.d.a(new t(0.0, y.d() + y.b() * 0.5), new z(1.0, 0.0));
        final t a4 = y.d.a.a(a3, a);
        if (a4 == null) {
            return false;
        }
        final t a5 = y.d.a.a(a3, a2);
        return a(y, a4) && a(y, a5);
    }
    
    private static boolean a(final y y, final t t) {
        return t.a() + 0.001 >= y.c() && t.a() - y.c() <= y.a() + 0.001 && t.b() + 0.001 >= y.d() && t.b() - y.d() <= y.b() + 0.001;
    }
    
    private static double a(final y.d.a a, final y.d.a a2, final z z) {
        final y.d.a a3 = new y.d.a(new t(0.0, 0.0), z.c(z));
        final t a4 = y.d.a.a(a, a3);
        final t a5 = y.d.a.a(a2, a3);
        if (a4 == null || a5 == null) {
            return 0.0;
        }
        return t.a(a4, a5);
    }
    
    private static D a(final y y, final z z) {
        final t t = new t(y.c() + 0.5 * y.a(), y.d());
        final t t2 = new t(y.c(), y.d() + 0.5 * y.b());
        final t t3 = new t(y.c() + 0.5 * y.a(), y.d() + y.b());
        final t t4 = new t(y.c() + y.a(), y.d() + 0.5 * y.b());
        final D d = new D();
        d.add(new y.d.a(t, z));
        d.add(new y.d.a(t2, z));
        d.add(new y.d.a(t4, z));
        d.add(new y.d.a(t3, z));
        d.sort(new av());
        final D d2 = new D();
        d2.add(d.f());
        d2.add(d.i());
        return d2;
    }
    
    private f a(final q q) {
        final boolean j = X.j;
        final f f = new f(q.l());
        final e k = q.k();
        while (k.f()) {
            final d a = k.a();
            if (!a.e()) {
                f.add(a);
            }
            k.g();
            if (j) {
                break;
            }
        }
        return f;
    }
    
    protected void a(final i i) {
        final boolean j = X.j;
        final A t = i.t();
        final c c = i.c(as.a);
        final c c2 = i.c(as.b);
        final x o = i.o();
    Label_0360_Outer:
        while (o.f()) {
            final q e = o.e();
            if (!j) {
                final f f = this.f ? new f(e.l()) : this.a(e);
            Label_0089:
                while (true) {
                    c c3 = null;
                    if (c3 != null) {
                        f.sort(new au(c2, null));
                    }
                    final e a = f.a();
                    while (a.f()) {
                        final d a2 = a.a();
                        c3 = c;
                        if (j) {
                            continue Label_0089;
                        }
                        Label_0280: {
                            if (c3 == null || c.d(a2)) {
                                final q a3 = a2.a(e);
                                final d d = (d)t.b(a3);
                                if (d != a2) {
                                    if (d == null) {
                                        t.a(a3, a2);
                                        if (!j) {
                                            break Label_0280;
                                        }
                                    }
                                    if (this.d.b(d) == null) {
                                        this.d.a(d, new f());
                                    }
                                    ((f)this.d.b(d)).add(a2);
                                    this.c.c(a2);
                                    i.d(a2);
                                }
                            }
                        }
                        a.g();
                        if (j) {
                            break;
                        }
                    }
                    break;
                }
                final e k = e.j();
                while (true) {
                    while (k.f()) {
                        t.a(k.a().a(e), null);
                        k.g();
                        if (!j) {
                            if (j) {
                                break;
                            }
                            continue Label_0360_Outer;
                        }
                        else {
                            if (j) {
                                break Label_0360_Outer;
                            }
                            continue Label_0360_Outer;
                        }
                    }
                    o.g();
                    continue;
                }
            }
            return;
        }
        i.a(t);
    }
    
    private void b(final i i) {
        final boolean j = X.j;
        while (!this.c.isEmpty()) {
            i.e(this.c.d());
            if (j) {
                break;
            }
        }
    }
    
    public void b(final boolean n) {
        this.n = n;
    }
    
    static {
        a = "y.layout.ParallelEdgeLayouter.SCOPE_DPKEY";
        b = "y.layout.ParallelEdgeLayouter.MASTER_EDGE_DPKEY";
    }
}
