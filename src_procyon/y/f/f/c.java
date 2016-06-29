package y.f.f;

import y.f.b.*;
import y.f.k.*;
import y.f.f.d.*;
import y.g.*;
import y.f.f.c.*;
import y.f.f.e.*;
import y.f.*;
import y.f.f.b.*;
import y.c.*;

public class c extends y.f.c
{
    private static final Object o;
    private static final Object p;
    public static final Object n;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    private boolean z;
    private boolean A;
    private boolean B;
    private ad C;
    private a D;
    
    protected a a() {
        return new a();
    }
    
    public a n() {
        if (this.D == null) {
            this.D = this.a();
        }
        return this.D;
    }
    
    public c() {
        this.q = 0;
        this.r = 25;
        this.s = true;
        this.t = true;
        this.u = true;
        this.v = false;
        this.w = false;
        this.x = 0;
        this.A = false;
        this.B = false;
        this.C = new V();
        this.f(false);
        this.b(false);
        final ad f = this.f();
        if (f instanceof b) {
            ((b)f).a(false);
        }
        final an an = new an();
        an.a(false);
        this.e(an);
    }
    
    public boolean o() {
        return this.z;
    }
    
    public void a(final int r) {
        if (r < 1) {
            throw new IllegalArgumentException("Illegal value for grid size: " + r);
        }
        this.r = r;
    }
    
    public int p() {
        return this.r;
    }
    
    public void b(final int q) {
        if (q < 0 || q > 6) {
            throw new IllegalArgumentException("Illegal value for layout style: " + q);
        }
        this.q = q;
    }
    
    public int q() {
        return this.q;
    }
    
    public boolean r() {
        return this.v;
    }
    
    public boolean b(final X x) {
        return true;
    }
    
    public void a(final X x) {
        final boolean a = y.f.f.a.a;
        final y.f.f.b.a a2 = new y.f.f.b.a();
        a2.a(this.r);
        a2.a(this.n());
        h u = null;
        A t = null;
        p p = null;
        y.f.f.b.d d = null;
        final boolean b = this.q == 0 || this.q == 4 || this.q == 1;
        if (b) {
            a2.a(new F());
        }
        Label_0230: {
            if (this.q == 4) {
                final d d2 = new d();
                d2.c(y.f.k.a.s);
                d2.b(Math.max(this.r, 10));
                d2.a(Math.max(this.r, 10));
                d2.c(Math.max(this.r, 20));
                d2.m();
                final L l = new L(d2);
                l.a(!this.r());
                a2.b(l);
                a2.g(true);
                if (!a) {
                    break Label_0230;
                }
                y.c.i.g = !y.c.i.g;
            }
            a2.g(false);
        }
        y.f.h.o o = null;
        Label_0370: {
            if (this.v) {
                u = x.u();
                t = x.t();
                this.a(x, t, u);
                final y.f.h.d d3 = new y.f.h.d();
                d3.a(u);
                d3.a(t);
                o = d3;
                if (b) {
                    d3.a(true);
                    if (!a) {
                        break Label_0370;
                    }
                }
                d3.a(false);
            }
            else {
                final y.f.h.c c = new y.f.h.c();
                c.a(-1);
                c.b(!this.w);
                c.d(this.u);
                c.a(this.t);
                c.c(this.w);
                o = c;
            }
        }
        y.f.f.b.b b2;
        if (b) {
            if (this.v) {
                final w w = new w();
                w.a(u);
                b2 = w;
            }
            else {
                final o o2 = new o();
                o2.a(this.o());
                b2 = o2;
            }
        }
        else {
            final k k = new k();
            k.a(this.o());
            b2 = k;
        }
        if (b) {
            final t t2 = new t();
            t2.a(false);
            x.a(y.f.f.d.t.a, y.g.q.a(new Integer(5)));
            Label_0539: {
                switch (this.q) {
                    case 0:
                    case 4: {
                        t2.a((short)0);
                        if (a) {
                            break Label_0539;
                        }
                        break;
                    }
                    case 1: {
                        t2.a((short)1);
                        break;
                    }
                }
            }
            if (this.y) {
                t2.a((short)3);
                t2.a(new m());
                t2.a(true);
            }
            t2.b((short)0);
            Label_0606: {
                if (this.s) {
                    t2.b(2);
                    if (!a) {
                        break Label_0606;
                    }
                }
                t2.b(3);
            }
            p = t2;
        }
        else if (this.q() == 2 || this.q() == 3) {
            final n n = new n();
            n.b((short)0);
            Label_0668: {
                if (this.s) {
                    n.b(2);
                    if (!a) {
                        break Label_0668;
                    }
                }
                n.b(3);
            }
            n.a((short)0);
            p = n;
        }
        else if (this.q() == 6 || this.q() == 5) {
            final y.f.f.e.m m = new y.f.f.e.m();
            m.a((short)0);
            Label_0737: {
                if (this.s) {
                    m.b(2);
                    if (!a) {
                        break Label_0737;
                    }
                }
                m.b(3);
            }
            p = m;
        }
        if (this.q() == 2 || this.q() == 3) {
            final y.f.f.e.i i = new y.f.f.e.i();
            Label_0791: {
                if (this.q() == 3) {
                    i.a((short)1);
                    if (!a) {
                        break Label_0791;
                    }
                }
                i.a((short)0);
            }
            d = i;
        }
        else if (this.q == 6 || this.q == 5) {
            final y.f.f.e.a a3 = new y.f.f.e.a();
            Label_0849: {
                if (this.q() == 5) {
                    a3.a((short)2);
                    if (!a) {
                        break Label_0849;
                    }
                }
                a3.a((short)3);
            }
            d = a3;
        }
        a2.a(o);
        a2.a(b2);
        a2.a(p);
        a2.a(d);
        if (!b) {
            a2.g(false);
        }
        if (!b) {
            a2.h(false);
        }
        Label_0931: {
            if (b) {
                a2.i(x.c(U.a) != null);
                if (!a) {
                    break Label_0931;
                }
            }
            a2.i(false);
        }
        a2.j(x.c(U.b) != null && (this.q == 0 || this.q == 4));
        if (this.e() instanceof y.f.e) {
            final y.f.e e = (y.f.e)this.e();
            e.a(this.p());
            e.b(0.0);
        }
        a2.m();
        a2.c(x);
        if (this.v) {
            x.a(u);
            x.a(t);
        }
        if (b) {
            x.d_(y.f.f.d.t.a);
        }
        new aI().c(x);
    }
    
    private void a(final X x, final A a, final h h) {
        final boolean a2 = a.a;
        final y.c.c c = x.c(y.f.f.c.p);
        y.c.c c2 = null;
        Label_0085: {
            if (c != null) {
                final y.c.e p3 = x.p();
                while (p3.f()) {
                    final y.c.d a3 = p3.a();
                    c2 = h;
                    if (a2) {
                        break Label_0085;
                    }
                    h.a(a3, c.d(a3));
                    p3.g();
                    if (a2) {
                        break;
                    }
                }
            }
            c2 = x.c(y.f.f.c.o);
        }
        final y.c.c c3 = c2;
        if (c3 != null) {
            final x o = x.o();
            while (o.f()) {
                final y.c.q e = o.e();
                a.a(e, c3.d(e));
                o.g();
                if (a2) {
                    break;
                }
            }
        }
    }
    
    static {
        o = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_NODES_DPKEY";
        p = "y.layout.orthogonal.OrthogonalLayouter.INCREMENTAL_EDGES_DPKEY";
        n = "y.layout.orthogonal.OrthogonalLayouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY";
    }
}
