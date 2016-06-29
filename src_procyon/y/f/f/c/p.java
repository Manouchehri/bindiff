package y.f.f.c;

import java.util.*;
import y.f.f.b.*;
import y.c.*;

public class p
{
    private int a;
    private h b;
    private i c;
    private y.c.h d;
    private y.c.h e;
    private A f;
    private A g;
    private A h;
    private a i;
    private int j;
    private D k;
    private g[] l;
    private boolean m;
    
    public p(final int a, final h b) {
        this.m = false;
        this.a(this.a = a, this.b = b);
        this.a();
    }
    
    public void a() {
        this.b(this.a, this.b);
        this.c(this.a, this.b);
    }
    
    public void b() {
        this.b(this.a, this.b);
    }
    
    public void c() {
        this.b.a().a(this.h);
        this.c = null;
        this.i = null;
        this.k = null;
        this.l = null;
    }
    
    public Iterator d() {
        return this.k.iterator();
    }
    
    public C e() {
        return this.k.m();
    }
    
    public g a(final q q) {
        return (g)this.h.b(q);
    }
    
    public g a(final d d) {
        return this.a(d.c());
    }
    
    public double b(final d d) {
        if (this.m) {
            return this.a(d.c(), d.d());
        }
        return this.d.c(d);
    }
    
    public double a(final q q, final q q2) {
        if (this.m) {
            return this.i.a(this.b(q).b(), this.b(q2).b());
        }
        final d a = q.a(q2);
        if (a == null) {
            return 2.147483647E9;
        }
        return this.d.c(a);
    }
    
    public g b(final q q) {
        return (g)this.f.b(q);
    }
    
    public d a(final g g, final g g2, int n) {
        if (g.c() != this.a || g2.c() != this.a) {
            throw new RuntimeException("Invalid call to set min-dist !");
        }
        final q a = g.a();
        final q a2 = g2.a();
        n += g.k() + g2.j();
        if (!this.m) {
            d d = a.a(a2);
            if (d == null) {
                d = this.c.a(a, a2);
                this.d.a(d, (double)n);
                this.a(d, 0);
                if (g.a == 0) {
                    return d;
                }
            }
            if (this.d.c(d) < n) {
                this.d.a(d, (double)n);
            }
            return d;
        }
        if (this.i.a(g.b(), g2.b()) == Integer.MAX_VALUE) {
            this.i.a(g.b(), g2.b(), n);
            final d a3 = this.c.a(a, a2);
            this.a(a3, 0);
            return a3;
        }
        if (this.i.a(g.b(), g2.b()) < n) {
            this.i.a(g.b(), g2.b(), n);
        }
        return null;
    }
    
    public o a(final g g) {
        return (o)this.g.b(g.a());
    }
    
    public void a(final d d, final int n) {
        this.e.a(d, n);
    }
    
    public int c(final d d) {
        if (this.e.b(d) == null) {
            return 0;
        }
        return this.e.a(d);
    }
    
    private void a(final int n, final h h) {
        final int a = y.f.f.c.g.a;
        final i a2 = h.a();
        y.f.f.b.o o = null;
        y.f.f.b.o o2 = null;
        short n2 = 0;
        Label_0095: {
            Label_0054: {
                switch (n) {
                    case 0: {
                        o = y.f.f.b.o.c;
                        o2 = y.f.f.b.o.a;
                        n2 = 0;
                        if (a != 0) {
                            break Label_0054;
                        }
                        break Label_0095;
                    }
                    case 1: {
                        o = y.f.f.b.o.b;
                        o2 = y.f.f.b.o.d;
                        n2 = 1;
                        if (a != 0) {
                            break;
                        }
                        break Label_0095;
                    }
                }
            }
            y.g.o.a((Object)("Constraint Graph Constructor: Unknown type:" + n));
            return;
        }
        this.c = new i();
        this.f = this.c.t();
        this.h = a2.t();
        this.k = new D();
        this.j = 0;
        final x o3 = a2.o();
        while (true) {
            while (o3.f()) {
                final q e = o3.e();
                final d a3 = this.a(e, o2, h);
                if (a != 0) {
                    for (final g g : this.k) {
                        this.l[g.b()] = g;
                        if (a != 0) {
                            return;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    this.d = this.c.u();
                    this.e = this.c.u();
                    return;
                }
                Label_0375: {
                    if (a3 == null) {
                        final q d = this.c.d();
                        final g g2 = new g(d, this.j, n2);
                        this.k.add(g2);
                        ++this.j;
                        this.f.a(d, g2);
                        this.h.a(e, g2);
                        g2.a(e);
                        d d2 = this.a(e, o, h);
                        while (d2 != null) {
                            final q d3 = d2.d();
                            g2.a(d3);
                            this.h.a(d3, g2);
                            g2.b(Math.max(h.l(d2), g2.j()));
                            g2.c(Math.max(h.m(d2), g2.k()));
                            d2 = this.a(d3, o, h);
                            if (a != 0) {
                                break Label_0375;
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                    }
                    o3.g();
                }
                if (a != 0) {
                    break;
                }
            }
            this.l = new g[this.j];
            continue;
        }
    }
    
    private void b(final int n, final h h) {
        final int a = y.f.f.c.g.a;
        this.m = false;
        final i a2 = h.a();
        final e p2 = this.c.p();
    Label_0143_Outer:
        while (true) {
            while (true) {
            Label_0332_Outer:
                while (p2.f()) {
                    this.c.a(p2.a());
                    p2.g();
                    if (a != 0) {
                        final y.f.f.b.o o = y.f.f.b.o.b;
                        final y.f.f.b.o o2 = y.f.f.b.o.d;
                        C c = a2.p();
                        while (true) {
                            while (c.f()) {
                                final d a3 = ((e)c).a();
                                final boolean j = h.j(a3);
                                if (a != 0) {
                                    while (true) {
                                        if (j) {
                                            final n n2 = (n)c.d();
                                            if (n2.d() != 2) {
                                                g g = null;
                                                g g2 = null;
                                                if (n2.e().a(o)) {
                                                    g = this.a(n2.a());
                                                    g2 = this.a(n2.b());
                                                }
                                                if (n2.e().a(o2)) {
                                                    g = this.a(n2.b());
                                                    g2 = this.a(n2.a());
                                                }
                                                if (g != null && g2 != null) {
                                                    this.a(g, g2, n2.c());
                                                }
                                            }
                                            c.g();
                                            if (a == 0) {
                                                c.f();
                                                continue Label_0332_Outer;
                                            }
                                        }
                                        break;
                                    }
                                    return;
                                }
                                if (j) {
                                    g g3 = null;
                                    g g4 = null;
                                    if (h.h(a3).a(o)) {
                                        g3 = this.a(a3.c());
                                        g4 = this.a(a3.d());
                                    }
                                    if (h.h(a3).a(o2)) {
                                        g3 = this.a(a3.d());
                                        g4 = this.a(a3.c());
                                    }
                                    if (g3 != null && g4 != null) {
                                        final d a4 = this.a(g3, g4, h.i(a3));
                                        final int n3 = (int)h.k(a3);
                                        if (this.c(a4) < n3) {
                                            this.a(a4, n3);
                                        }
                                    }
                                }
                                c.g();
                                if (a != 0) {
                                    break;
                                }
                            }
                            c = h.i();
                            continue;
                        }
                    }
                    if (a != 0) {
                        break;
                    }
                }
                switch (n) {
                    case 0: {
                        continue Label_0143_Outer;
                    }
                    case 1: {
                        final y.f.f.b.o o = y.f.f.b.o.c;
                        final y.f.f.b.o o2 = y.f.f.b.o.a;
                        continue;
                    }
                    default: {
                        y.g.o.a(this, 1, "Constraint Graph Constructor: Unknown type:" + n);
                    }
                }
                break;
            }
            break;
        }
    }
    
    private void c(final int n, final h h) {
        final int a = y.f.f.c.g.a;
        y.g.o.a(this, 5, "Init max-dist graph: ");
        this.g = this.c.t();
        y.f.f.b.o o = null;
        y.f.f.b.o o2 = null;
        Label_0105: {
            Label_0066: {
                switch (n) {
                    case 0: {
                        o = y.f.f.b.o.b;
                        o2 = y.f.f.b.o.d;
                        if (a != 0) {
                            break Label_0066;
                        }
                        break Label_0105;
                    }
                    case 1: {
                        o = y.f.f.b.o.c;
                        o2 = y.f.f.b.o.a;
                        if (a != 0) {
                            break;
                        }
                        break Label_0105;
                    }
                }
            }
            y.g.o.a(this, 5, "Constraint Graph Constructor: Unknown type:" + n);
            return;
        }
        final C i = h.i();
        while (i.f()) {
            final n n2 = (n)i.d();
            if (n2.d() != 1) {
                g g = null;
                g g2 = null;
                if (n2.e().a(o)) {
                    g = this.a(n2.a());
                    g2 = this.a(n2.b());
                }
                if (n2.e().a(o2)) {
                    g = this.a(n2.b());
                    g2 = this.a(n2.a());
                }
                if (g != null && g2 != null) {
                    final o o3 = new o(g, g2, n2.c());
                    this.g.a(g.a(), o3);
                    this.g.a(g2.a(), o3);
                }
            }
            i.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private d a(final q q, final y.f.f.b.o o, final h h) {
        final int a = y.f.f.c.g.a;
        final e l = q.l();
        while (l.f()) {
            final d a2 = l.a();
            if (h.h(a2).a(o)) {
                return a2;
            }
            l.g();
            if (a != 0) {
                break;
            }
        }
        return null;
    }
    
    public i f() {
        return this.c;
    }
}
