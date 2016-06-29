package y.f.i.a;

import y.d.*;
import java.util.*;
import y.c.*;

class bk extends ab implements bR
{
    private boolean b;
    private double c;
    private M d;
    private M e;
    private M f;
    private M g;
    private int h;
    
    protected void a(final Z z) {
        super.a(z);
        this.c = this.a().c().l();
    }
    
    protected void c() {
        super.c();
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }
    
    protected void b(final aa aa) {
        this.b = this.d();
        if (this.b) {
            final y g = aa.g().g();
            this.d = new M(g.c(), g.c() + g.a());
            this.e = new M(g.d(), g.d() + g.b());
            this.f = new M(g.c() - this.c, g.c() + g.a() + this.c);
            this.g = new M(g.d() - this.c, g.d() + g.b() + this.c);
            this.h = Math.min(aa.d().f().g(), 2 * aa.d().f().a());
            aa.a().a((bR)this);
        }
    }
    
    protected void c(final aa aa) {
        super.c(aa);
        if (this.b) {
            this.b().a().b(this);
        }
    }
    
    protected void d(final aa aa) {
        super.d(aa);
        if (this.b) {
            this.b().a().b(this);
        }
    }
    
    protected double b(final f f) {
        if (this.b && (f.b() == null || !f.b().g()) && this.a(f.a()) && this.d(f) && this.e(f)) {
            this.a("HEUR Punish intersecting source and target", this.h, true);
            return this.h;
        }
        return 0.0;
    }
    
    private boolean d(final f f) {
        final y.f.y d = f.d();
        final M m = d.d() ? this.d : this.e;
        if (d == y.f.y.b || d == y.f.y.c) {
            return f.c().f() <= m.b();
        }
        return f.c().f() >= m.a();
    }
    
    private boolean e(final f f) {
        return f.c().e().c(f.d().d() ? this.g : this.f);
    }
    
    public void a(final f f, final aa aa, final byte b) {
        if (!this.b) {
            return;
        }
        if (b == 1 || b == 2) {
            final f b2 = f.b();
            if (b2 != null && b2.g()) {
                f.b(true);
                if (ab.a == 0) {
                    return;
                }
            }
            if (!this.a(f.a())) {
                f.b(true);
            }
        }
    }
    
    protected boolean c(final f f) {
        final boolean b = f.j() != null;
        return (!this.b || f.g()) && b;
    }
    
    private boolean d() {
        final y g = this.b().f().g();
        final y g2 = this.b().g().g();
        return g.c + g.a > g2.c - 1.0E-6 && g.d + g.b > g2.d - 1.0E-6 && g.c < g2.c + g2.a + 1.0E-6 && g.d < g2.d + g2.b + 1.0E-6;
    }
    
    private boolean a(final R r) {
        final List b = this.b(r);
        final List c = this.c(r);
        final q d = this.b().c().d();
        return b.contains(d) || c.contains(d);
    }
    
    private List b(final R r) {
        return (List)r.a(T.b);
    }
    
    private List c(final R r) {
        return (List)r.a(T.a);
    }
}
