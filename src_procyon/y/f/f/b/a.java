package y.f.f.b;

import y.f.h.*;
import y.f.f.d.*;
import y.g.*;
import y.f.*;
import y.c.*;
import y.f.f.a.b.*;

public class a extends c
{
    protected D n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected int t;
    protected o u;
    protected b v;
    protected p w;
    protected d x;
    protected e y;
    protected y.f.e z;
    private y.f.f.a.b.a A;
    private m B;
    private al C;
    private y.f.f.a D;
    
    public a() {
        this.n = null;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = false;
        this.z = null;
        this.B = null;
        this.C = new al();
        this.D = new y.f.f.a();
        this.f(false);
        this.b(false);
        this.d(this.z = new y.f.e());
        this.e(true);
        this.y = new e();
        this.c(false);
    }
    
    public void a(final y.f.f.a d) {
        this.D = d;
    }
    
    public void a(final y.f.f.a.b.a a) {
        this.A = a;
    }
    
    public void a(final int t) {
        this.z.a(t);
        this.t = t;
    }
    
    public void g(final boolean p) {
        this.p = p;
    }
    
    public void h(final boolean q) {
        this.q = q;
    }
    
    public boolean a() {
        return this.r;
    }
    
    public void i(final boolean r) {
        this.r = r;
    }
    
    public boolean n() {
        return this.s;
    }
    
    public void j(final boolean s) {
        this.s = s;
    }
    
    public void a(final o u) {
        this.u = u;
    }
    
    public o o() {
        return this.u;
    }
    
    public void a(final b v) {
        this.v = v;
    }
    
    public void a(final p w) {
        this.w = w;
    }
    
    public p p() {
        return this.w;
    }
    
    public void a(final d x) {
        this.x = x;
    }
    
    public void a(final e y) {
        this.y = y;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    private boolean q() {
        boolean b = false;
        if (this.p() instanceof t && ((t)this.p()).c() == 0) {
            b = true;
        }
        return b;
    }
    
    protected void a(final O o, final Object o2) {
    }
    
    protected void b(final O o, final Object o2) {
    }
    
    private y.f.f.a a(final y.c.d d, final h h) {
        final D d2 = (D)h.b();
        final y.c.d d3 = d2.n(d) ? d2.d(d2.h(d)) : d2.d(d);
        if (d3 != null && d.a() != null) {
            final y.c.c c = d.a().c(y.f.f.c.n);
            if (c != null && c.b(d3) != null) {
                return (y.f.f.a)c.b(d3);
            }
        }
        return this.D;
    }
    
    public void a(final X x) {
        final int a = y.f.f.b.h.a;
        y.g.o.a(this, 1, "---->> Starting Layout algorithm:");
        this.B = new m();
        final al al = new al();
        this.a((i)x);
        if (x.h() == 0) {
            x.a(x.o().e(), 0.0, 0.0);
            return;
        }
        final f f = new f(x.p());
        final D d = this.o ? this.n : new D(x);
        final C c = new C();
        if (this.n() && this.q()) {
            c.a(x, this.t);
        }
        if (this.a()) {
            final y.c.c c2 = x.c(U.a);
            if (c2 != null) {
                this.y.a(d, c2, this.t);
            }
        }
        y.a.a.a("before phase 1");
        final y.f.f.b.c c3 = new y.f.f.b.c();
        final k k = new k();
        k.a(this.t);
        if (!this.o) {
            if (this.q) {
                c3.a(x);
            }
            if (this.p) {
                k.a(x);
            }
            this.C.e();
            this.u.a(d);
            if (x.h() != 0) {
                this.u.c();
            }
            this.B.b = (int)this.C.d();
            this.B.o = d.a();
            this.a((i)x);
        }
        y.a.a.a("before phase 2");
        h h;
        if (this.x != null) {
            this.x.a(this.t);
            this.x.a(d);
            this.x.a();
            final D b = this.x.b();
            if (this.y instanceof y.f.f.a.b.f) {
                final y.c.c c4 = x.c(U.a);
                if (c4 != null) {
                    ((y.f.f.a.b.f)this.y).a(this.A, b, c4, f);
                }
            }
            h = new h(b);
        }
        else {
            h = new h(d);
        }
        this.C.e();
        this.v.a(h);
        if (h.a().h() != 0) {
            this.v.a();
        }
        this.B.f = (int)this.C.d();
        if (!this.o) {
            if (this.p) {
                k.a(h);
                k.a();
            }
            if (this.q) {
                c3.a(h);
                c3.a();
            }
        }
        this.B.p = this.v.b();
        this.a((i)x);
        y.a.a.a("before phase 3");
        final y.c.d[] n = h.a().n();
        int i = 0;
        while (true) {
            while (i < n.length) {
                final y.c.d d2 = n[i];
                final h h2 = h;
                if (a != 0) {
                    final X x2 = (X)h2.a();
                    final y.c.h b2 = M.b();
                    final y.c.e p = x2.p();
                    while (true) {
                        while (p.f()) {
                            final y.c.d a2 = p.a();
                            final boolean c5 = h.c(a2);
                            if (a != 0) {
                                if (c5) {
                                    this.y.a(b2);
                                    this.y.a(h);
                                    this.y.b();
                                }
                                final y.c.e p2 = x2.p();
                                while (true) {
                                    while (p2.f()) {
                                        final y.c.d a3 = p2.a();
                                        final boolean c6 = h.c(a3);
                                        if (a != 0) {
                                            if (c6) {
                                                this.y.a(c);
                                                h.j();
                                                this.y.c();
                                            }
                                            if (this.x != null) {
                                                this.x.c();
                                            }
                                            if (this.r) {
                                                this.y.a();
                                            }
                                            if (this.o) {
                                                h.k();
                                            }
                                            if (!this.o) {
                                                this.u.a();
                                            }
                                            h.q();
                                            this.a((i)x);
                                            if (this.n()) {
                                                c.a();
                                            }
                                            if (this.u instanceof y.f.h.c) {
                                                final y.f.h.c c7 = (y.f.h.c)this.u;
                                                this.B.c = c7.b();
                                                this.B.d = c7.d();
                                                this.B.e = c7.e();
                                            }
                                            this.B.a = (int)al.d();
                                            y.g.o.a(this, 1, "---> Total running time of the algorithm: " + al);
                                            y.g.o.a(this, 1, "<<---- Leaving algorithm");
                                            return;
                                        }
                                        if (!c6) {
                                            final y.f.f.a a4 = (y.f.f.a)b2.b(a3);
                                            if (a4 != null) {
                                                final int a5 = this.a(a3, x2, h);
                                                final int n2 = (int)Math.ceil((a5 + a4.c()) / this.t);
                                                final int n3 = (int)Math.ceil((a5 + a4.a()) / this.t);
                                                final int n4 = (int)Math.ceil((a5 + a4.b()) / this.t);
                                                final int n5 = (int)Math.ceil((a5 + a4.b() + a4.a()) / this.t);
                                                int max = Math.max(n2, h.i(a3));
                                                final boolean a6 = this.a(a3.c(), h);
                                                final boolean a7 = this.a(a3.d(), h);
                                                Label_1001: {
                                                    if (a6 && a7 && max < n5) {
                                                        max = n5;
                                                        if (a == 0) {
                                                            break Label_1001;
                                                        }
                                                    }
                                                    if (a6 && max < n3) {
                                                        max = n3;
                                                        if (a == 0) {
                                                            break Label_1001;
                                                        }
                                                    }
                                                    if (a7 && max < n4) {
                                                        max = n4;
                                                    }
                                                }
                                                h.b(a3, max);
                                                h.b(h.a(a3), max);
                                            }
                                        }
                                        p2.g();
                                        if (a != 0) {
                                            break;
                                        }
                                    }
                                    this.C.e();
                                    ae.a(x);
                                    this.w.a(this.t);
                                    this.w.a(h);
                                    this.w.a(this.B);
                                    this.w.a();
                                    this.B.g = (int)this.C.d();
                                    this.a();
                                    continue;
                                }
                            }
                            if (!c5) {
                                final y.f.f.a a8 = this.a(a2, h);
                                if (a8 != null) {
                                    b2.a(a2, a8.d());
                                }
                            }
                            p.g();
                            if (a != 0) {
                                break;
                            }
                        }
                        this.a();
                        continue;
                    }
                }
                if (!h2.c(d2)) {
                    h.n(d2);
                }
                ++i;
                if (a != 0) {
                    break;
                }
            }
            continue;
        }
    }
    
    private boolean a(final q q, final h h) {
        return h.d(q) || (this.o() instanceof w && ((w)this.o()).b().f(q));
    }
    
    private int a(final y.c.d d, final X x, final h h) {
        final int a = h.a;
        int n = 0;
        while (true) {
            y.c.e e = null;
            y.c.d d2 = null;
            q q = null;
            y.c.d d3 = null;
            y.c.d d4 = null;
            Label_0207: {
                if (h.g(d.c())) {
                    e = d.c().l();
                    while (e.f()) {
                        d2 = e.a();
                        q = d2.d();
                        d3 = d2;
                        d4 = d;
                        if (a != 0) {
                            break Label_0207;
                        }
                        if (d3 != d && h.d(q)) {
                            final y.f.f.b.o h2 = h.h(d2);
                            n += (int)((y.f.f.b.o.a.a(h2) || y.f.f.b.o.c.a(h2)) ? (x.p(q) * 0.5) : (x.q(q) * 0.5));
                        }
                        e.g();
                        if (a != 0) {
                            break;
                        }
                    }
                }
                if (!h.g(d.d())) {
                    return n;
                }
                e = d.d().k();
                if (!e.f()) {
                    return n;
                }
                d2 = e.a();
                q = d2.c();
                d4 = d;
            }
            if (d3 != d4 && h.d(q)) {
                final y.f.f.b.o h3 = h.h(d2);
                n += (int)((y.f.f.b.o.a.a(h3) || y.f.f.b.o.c.a(h3)) ? (x.p(q) * 0.5) : (x.q(q) * 0.5));
            }
            e.g();
            if (a == 0) {
                continue;
            }
            break;
        }
        return n;
    }
    
    private void a(final i i) {
        y.g.o.a(this, "Node Map Count: " + i.v().length);
        y.g.o.a(this, "Edge Map Count: " + i.w().length);
    }
}
