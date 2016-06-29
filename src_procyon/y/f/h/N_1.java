package y.f.h;

import y.g.*;
import y.c.*;

public class N
{
    protected i a;
    public D b;
    protected p c;
    private h e;
    private final l f;
    public static boolean d;
    
    public N(final i a) {
        this.f = new O(this);
        this.a = a;
        this.e = a.u();
        this.b = new D();
    }
    
    public i g() {
        return this.a;
    }
    
    public d g(final d d) {
        final d a = this.a.a(d.d(), d.c());
        this.b(d, a);
        this.o(a).c(true);
        return a;
    }
    
    public void b(final d d, final d d2) {
        this.o(d).a(d2);
        this.o(d2).a(d);
    }
    
    public d h(final d d) {
        return this.o(d).g();
    }
    
    public q h() {
        return new T(this.b);
    }
    
    public void b(final p c) {
        this.c = c;
    }
    
    public p i() {
        return this.c;
    }
    
    public int j() {
        return this.b.size();
    }
    
    public p i(final d d) {
        return this.o(d).i();
    }
    
    public void a(final d d, final p p2) {
        this.o(d).a(p2);
    }
    
    public void k() {
        final y.f.h.i i = new y.f.h.i(this);
        i.d();
        i.e();
    }
    
    public void l() {
        this.a(this.f);
    }
    
    public void a(final l l) {
        final boolean d = N.d;
        this.b = new D();
        if (this.a.h() == 0) {
            return;
        }
        final boolean[] array = new boolean[this.a.h()];
        final e p = this.a.p();
        while (p.f()) {
            final d a = p.a();
            if (d) {
                return;
            }
            if (!array[a.b()]) {
                this.a(a, l, array);
            }
            p.g();
            if (d) {
                break;
            }
        }
        this.b(null);
    }
    
    public p a(d d, final l l, final boolean[] array) {
        final boolean d2 = N.d;
        final p p3 = new p();
        final d d3 = d;
        int i = 1;
        while (i != 0) {
            p3.a(d);
            this.o(d).a(p3);
            array[d.b()] = true;
            final d a = l.a(d);
            final boolean b = array[a.b()];
            if (d2) {
                return p3;
            }
            Label_0097: {
                if (b) {
                    if (a == d3) {
                        i = 0;
                        if (!d2) {
                            break Label_0097;
                        }
                    }
                    throw new RuntimeException("Graph is not Planar !");
                }
            }
            d = a;
            if (d2) {
                break;
            }
        }
        this.b.add(p3);
        return p3;
    }
    
    public r m() {
        return new U();
    }
    
    public void a(final r r) {
        ((U)r).a();
    }
    
    public d j(final d d) {
        final d g = d.g();
        return (g == null) ? d.c().f() : g;
    }
    
    public d k(final d d) {
        final d i = d.i();
        return (i == null) ? d.c().h() : i;
    }
    
    protected d l(final d d) {
        return this.j(this.h(d));
    }
    
    public boolean n() {
        final boolean d = N.d;
        o.a(this, 0, "Planarity Check....");
        final i g = this.g();
        final boolean[] array = new boolean[g.h()];
        int i = 0;
        while (true) {
        Label_0661:
            while (true) {
            Label_0756_Outer:
                while (i < g.h()) {
                    array[i] = false;
                    ++i;
                    if (d) {
                        g.h();
                        this.h().k();
                        final int length = y.a.h.a(g).length;
                        int n = 0;
                        final x o = g.o();
                        while (true) {
                            while (o.f()) {
                                final int a = o.e().a();
                                if (!d) {
                                    if (a == 0) {
                                        ++n;
                                    }
                                    o.g();
                                    if (d) {
                                        break;
                                    }
                                    continue Label_0756_Outer;
                                }
                                else {
                                    final int n2 = a;
                                    if (n2 == 0) {
                                        return true;
                                    }
                                    y.g.o.a((Object)("genus ==  " + n2));
                                    return false;
                                }
                            }
                            continue;
                        }
                    }
                    if (d) {
                        break;
                    }
                }
                final q h = this.h();
                do {
                    Label_0056: {
                        h.f();
                    }
                    boolean b = false;
                    e a2;
                    e e;
                    d a3;
                    e e2;
                    q q;
                    d[] array2;
                    d[] array4 = null;
                    d[] array3;
                    p a4;
                    m b2;
                    p j;
                    e a5;
                    e e3;
                    d a6;
                    d a7;
                    d h2;
                    p a8;
                    e e4;
                    Label_0062:
                    Label_0528_Outer:Label_0513_Outer:
                    while (b) {
                        a2 = h.a().a();
                        if (!d) {
                            e = a2;
                            while (e.f()) {
                                a3 = e.a();
                                b = array[a3.b()];
                                if (d) {
                                    continue Label_0062;
                                }
                                if (b) {
                                    o.a((Object)("Edge " + a3 + " is in two faces !"));
                                    return false;
                                }
                                array[a3.b()] = true;
                                e.g();
                                if (d) {
                                    break;
                                }
                            }
                            h.g();
                            continue Label_0056;
                        }
                        e2 = a2;
                        while (e2.f()) {
                            if (!array[e2.a().b()]) {
                                o.a((Object)("Edge " + e2.a() + " is in no face !"));
                                return false;
                            }
                            e2.g();
                            if (d) {
                                break;
                            }
                        }
                        q = this.h();
                    Label_0513:
                        while (true) {
                        Label_0528:
                            while (true) {
                            Label_0535:
                                while (true) {
                                    while (q.f()) {
                                        array2 = new d[2];
                                        Label_0274:
                                        Block_14: {
                                            while (true) {
                                                array3 = array4;
                                                a4 = q.a();
                                                if (!d) {
                                                    b2 = a4.b();
                                                    while (b2.f()) {
                                                        b2.a(array3);
                                                        array4 = array3;
                                                        if (d) {
                                                            continue Label_0274;
                                                        }
                                                        if (array4[0].d() != array3[1].c()) {
                                                            break Block_14;
                                                        }
                                                        b2.g();
                                                        if (d) {
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                break Label_0528;
                                            }
                                            q.g();
                                            if (d) {
                                                break;
                                            }
                                            continue Label_0528_Outer;
                                        }
                                        o.a((Object)("Face is not a cycle: " + q.a()));
                                        return false;
                                        j.a();
                                        e3 = a5;
                                    Label_0656:
                                        while (true) {
                                            while (e3.f()) {
                                                a6 = e3.a();
                                                e3.c();
                                                a7 = e3.a();
                                                e3.b();
                                                h2 = this.h(a7);
                                                if (!d) {
                                                    if (this.j(h2) != a6) {
                                                        o.a((Object)("Edge " + a6 + " in wrong order !"));
                                                        return false;
                                                    }
                                                    e3.g();
                                                    if (d) {
                                                        break;
                                                    }
                                                    continue Label_0528_Outer;
                                                }
                                                else {
                                                    if (d) {
                                                        break Label_0656;
                                                    }
                                                    break Label_0513;
                                                }
                                            }
                                            Label_0645: {
                                                break Label_0645;
                                                if (q.f()) {
                                                    q.a();
                                                    continue Label_0528;
                                                }
                                                break Label_0656;
                                            }
                                            q.g();
                                            continue Label_0513_Outer;
                                        }
                                        i = g.f();
                                        continue Label_0661;
                                    }
                                    q = this.h();
                                    while (q.f()) {
                                        a8 = q.a();
                                        a5 = a8.a();
                                        if (d) {
                                            continue Label_0535;
                                        }
                                        e4 = a5;
                                        while (e4.f()) {
                                            j = this.i(e4.a());
                                            if (d) {
                                                continue Label_0528;
                                            }
                                            if (j != a8) {
                                                o.a((Object)("Edge " + e4.a() + " belongs to wrong face!"));
                                                return false;
                                            }
                                            e4.g();
                                            if (d) {
                                                break;
                                            }
                                        }
                                        q.g();
                                        if (d) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                            }
                            q = this.h();
                            continue Label_0513;
                        }
                    }
                    break;
                } while (!d);
                break;
            }
            this.a.p();
            continue;
        }
    }
    
    public void e() {
        final boolean d = N.d;
        final e p = this.a.p();
        while (true) {
            while (p.f()) {
                final d a = p.a();
                final N n = this;
                if (d) {
                    n.a.a(this.e);
                    return;
                }
                if (this.n(a)) {
                    this.a.a(a);
                }
                p.g();
                if (d) {
                    break;
                }
            }
            final N n = this;
            continue;
        }
    }
    
    public boolean o() {
        final boolean d = N.d;
        if (this.i() == null) {
            return false;
        }
        final p i = this.i();
        boolean b = false;
        final q h = this.h();
        while (h.f()) {
            if (i == h.a()) {
                b = true;
            }
            h.g();
            if (d) {
                break;
            }
        }
        return b;
    }
    
    public String toString() {
        final boolean d = N.d;
        final StringBuffer sb = new StringBuffer();
        sb.append("Facelist:\n");
        final q h = this.h();
        while (h.f()) {
            final p a = h.a();
            final StringBuffer append = sb.append("Face :");
            if (d) {
                return append.toString();
            }
            if (a == this.c) {
                sb.append("  --> Outer-Face <---");
            }
            sb.append("\n");
            sb.append(a);
            sb.append("\n");
            h.g();
            if (d) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    public void m(final d d) {
        this.a(d, true);
    }
    
    public void a(final d d, final boolean b) {
        this.o(d).c(b);
    }
    
    public boolean n(final d d) {
        return this.o(d).h();
    }
    
    protected P o(final d d) {
        P d_ = (P)this.e.b(d);
        if (d_ == null) {
            d_ = this.d_();
            this.e.a(d, d_);
        }
        return d_;
    }
    
    protected P d_() {
        return new P();
    }
}
