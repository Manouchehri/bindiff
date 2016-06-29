package y.f.i.a;

import y.f.*;
import y.c.*;
import java.util.*;
import y.d.*;

class bj extends ab implements H, bR
{
    private y b;
    private M c;
    private M d;
    private M e;
    private M f;
    private M g;
    private M h;
    private int i;
    private int j;
    private double k;
    private double l;
    private boolean m;
    private boolean n;
    private boolean[] o;
    private List[] p;
    private aU q;
    
    protected void c() {
        super.c();
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
        this.h = null;
        this.e = null;
        this.f = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }
    
    protected void b(final aa aa) {
        final int a = ab.a;
        super.b(aa);
        final X a2 = this.a().a();
        final d c = aa.c();
        final x d = aa.d();
        this.i = d.f().k();
        this.k = d.a();
        this.l = d.b();
        this.j = Math.min(this.i, 2 * d.f().a());
        if (!(this.n = (this.i > 0 && (this.l > 0.0 || this.k > 0.0)))) {
            return;
        }
        if (this.k > 0.0) {
            final y s = a2.s(c.c());
            this.c = new M(s.c() - this.k, s.c() + s.a() + this.k);
            this.d = new M(s.d() - this.k, s.d() + s.b() + this.k);
            this.b = new y(this.c.a(), this.d.a(), this.c.d(), this.d.d());
        }
        Label_0614: {
            if (this.l > 0.0) {
                final y s2 = a2.s(c.d());
                this.g = new M(s2.c(), s2.c() + s2.a());
                this.h = new M(s2.d(), s2.d() + s2.b());
                this.e = new M(s2.c() - this.l, s2.c() + s2.a() + this.l);
                this.f = new M(s2.d() - this.l, s2.d() + s2.b() + this.l);
                this.o = new boolean[4];
                this.p = new List[4];
                this.q = this.a().a(c);
                final List a3 = this.q.a(false);
                if (a3 == null || a3.size() == 0) {
                    Arrays.fill(this.o, true);
                    if (a == 0) {
                        break Label_0614;
                    }
                }
                for (final ax ax : a3) {
                    if (ax.a() == 255) {
                        Arrays.fill(this.o, true);
                        if (a == 0) {
                            break;
                        }
                    }
                    final y.f.y a4 = this.a(ax.a());
                    if (a4 != null) {
                        if (!ax.b()) {
                            this.o[a4.f()] = true;
                            if (a == 0) {
                                continue;
                            }
                        }
                        List list = this.p[a4.f()];
                        if (list == null) {
                            list = new D();
                            this.p[a4.f()] = list;
                        }
                        list.add(ax);
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                }
            }
        }
        final V a5 = aa.a();
        a5.a((H)this);
        a5.a((bR)this);
    }
    
    private y.f.y a(final int n) {
        switch (n) {
            case 1: {
                return y.f.y.c;
            }
            case 2: {
                return y.f.y.a;
            }
            case 8: {
                return y.f.y.b;
            }
            case 4: {
                return y.f.y.d;
            }
            default: {
                return null;
            }
        }
    }
    
    protected void c(final aa aa) {
        super.c(aa);
        this.f(aa);
    }
    
    protected void d(final aa aa) {
        super.d(aa);
        this.f(aa);
    }
    
    private void f(final aa aa) {
        if (this.n) {
            final V a = aa.a();
            a.b((H)this);
            a.b((bR)this);
        }
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.n) {
            this.b("minimal first/last segment length penalty", 0.0, false);
            return new double[array.length];
        }
        this.m = (this.k > 0.0 && f.c() != null && !f.i() && P.a(this.b, f.c()));
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final int a = ab.a;
        double n2 = 0.0;
        Label_0208: {
            if (this.m && this.k > 0.0) {
                final P c = f.c();
                final double n3 = (c != null) ? (c.a() ? f.a().l() : f.a().m()) : 0.0;
                if (v.c() == 1) {
                    if (!(p5.a() ? this.c : this.d).a(p5.f())) {
                        break Label_0208;
                    }
                    n2 = this.i;
                    if (a == 0) {
                        break Label_0208;
                    }
                }
                if (v.c() == 2) {
                    if (!p5.e().a(p5.a() ? this.d : this.c, 1.0E-6)) {
                        break Label_0208;
                    }
                    n2 = this.i;
                    if (a == 0) {
                        break Label_0208;
                    }
                }
                if (v.c() == 3 && this.b.a(f.a().g()) + n3 < this.k) {
                    n2 = this.i;
                }
            }
        }
        if (this.l > 0.0 && this.b().d(r) && this.a(f, v, p5)) {
            n2 += this.i;
        }
        this.a("minimal first/last segment length penalty", n2, false);
        return n2;
    }
    
    private boolean a(final f f, final v v, final P p3) {
        final int a = ab.a;
        v j = v;
        f b = f;
        while (true) {
            while (b != null) {
                final v v2 = j;
                if (a == 0) {
                    if (v2 == null || j.c() != 0) {
                        break;
                    }
                    j = b.j();
                    b = b.b();
                    if (a != 0) {
                        break;
                    }
                    continue;
                }
                else {
                    if (v2 == null) {
                        return (p3.a() ? new M(this.b().f().h(), this.b().f().j()) : new M(this.b().f().i(), this.b().f().k())).b(p3.f()) < this.l;
                    }
                    switch (j.c()) {
                        case 2: {
                            final P c = b.c();
                            return c.e().b(p3.f()) + c.d() < this.l;
                        }
                        case 1:
                        case 3: {
                            final R a2 = b.a();
                            final M m = p3.a() ? new M(a2.h(), a2.j()) : new M(a2.i(), a2.k());
                            return m.b(p3.f()) + m.d() < this.l;
                        }
                        default: {
                            return true;
                        }
                    }
                }
            }
            if (b != null) {
                continue;
            }
            break;
        }
        return (p3.a() ? new M(this.b().f().h(), this.b().f().j()) : new M(this.b().f().i(), this.b().f().k())).b(p3.f()) < this.l;
    }
    
    protected double b(final f f) {
        if (this.l > 0.0 && this.j > 0 && !this.b().d(f.a()) && this.d(f) && this.e(f)) {
            final y.f.y d = f.d();
            final P c = f.c();
            final M m = d.d() ? this.h : this.g;
            double n = 0.0;
            final M a = M.a(c.e(), m);
            if (a != null && a.d() > 0.0) {
                if (this.a(f, a)) {
                    return 0.0;
                }
                if (this.f(f)) {
                    n = this.i;
                }
            }
            final boolean b = d == y.f.y.b || d == y.f.y.a;
            if ((b && c.b() < m.a()) || (!b && c.c() > m.b())) {
                final int f2 = d.a().f();
                if (this.o[f2] || this.p[f2] != null) {
                    n = this.j;
                }
            }
            if ((!b && c.b() < m.a()) || (b && c.c() > m.b())) {
                final int f3 = d.b().f();
                if (this.o[f3] || this.p[f3] != null) {
                    n = this.j;
                }
            }
            this.a("HEUR minimal first/last segment length penalty", n, true);
            return n;
        }
        return 0.0;
    }
    
    private boolean d(final f f) {
        final y.f.y d = f.d();
        final M m = d.d() ? this.g : this.h;
        if (d == y.f.y.b || d == y.f.y.c) {
            return f.c().f() <= m.b();
        }
        return f.c().f() >= m.a();
    }
    
    private boolean e(final f f) {
        return f.c().e().c(f.d().d() ? this.f : this.e);
    }
    
    private boolean a(final f f, final M m) {
        final int a = ab.a;
        final int f2 = f.d().f();
        if (this.o[f2]) {
            return true;
        }
        if (this.p[f2] == null) {
            return false;
        }
        final Iterator iterator = this.p[f2].iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final t a2 = this.q.a(iterator.next(), false);
            if (m.a(f.d().e() ? a2.a() : a2.b())) {
                b = true;
                if (a == 0) {
                    return b;
                }
                return b;
            }
        }
        return b;
    }
    
    private boolean f(final f f) {
        return this.p[f.d().f()] != null && (f.d().d() ? this.e : this.f).a(f.c().f());
    }
    
    public void a(final f f, final R r, final P p5, final List list, final aa aa) {
        if (!this.n) {
            return;
        }
        final boolean b = !p5.a();
        final P c = f.c();
        if (!f.i() && c != null && this.k > 0.0) {
            if (V.a(f, r) == f.d() && (b ? this.d : this.c).a(p5.f()) && !p5.e().c(c.e())) {
                final P a = P.a(c, p5);
                if (a == null) {
                    return;
                }
                list.add(a);
            }
            if (c.a() == b) {
                final M a2 = this.a(p5.e(), b ? this.c : this.d);
                if (a2 != null) {
                    list.add(new P(a2.a(), a2.b(), p5.f(), p5.a()));
                }
            }
        }
    }
    
    private M a(final M m, final M i) {
        M j = null;
        if (m.a(i, 1.0E-6) && !m.c(i)) {
            if (m.a() < i.a()) {
                j = new M(m.a(), i.a());
            }
            else {
                j = new M(i.b(), m.b());
            }
        }
        return j;
    }
    
    public void a(final f f, final aa aa, final byte b) {
        final int a = ab.a;
        if (this.k > 0.0 && b != 0) {
            final f b2 = f.b();
            if (b2 == null || b2.c() == null) {
                f.c(false);
                if (a == 0) {
                    return;
                }
            }
            if (b2.i()) {
                f.c(true);
                if (a == 0) {
                    return;
                }
            }
            if (b2.d() != f.d() || !b2.c().b(f.c())) {
                f.c(true);
                if (a == 0) {
                    return;
                }
            }
            f.c(false);
        }
    }
}
