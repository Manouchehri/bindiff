package y.f.i.a;

import y.c.*;
import y.f.*;
import java.util.*;
import y.d.*;

class bW extends ab
{
    private List b;
    private L c;
    private double d;
    
    protected void c() {
        super.c();
        this.b = null;
        this.c = null;
    }
    
    protected void a(final Z z) {
        super.a(z);
        this.c = z.c().k();
        this.b = new D();
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        this.f(aa);
    }
    
    private void f(final aa aa) {
        final int a = ab.a;
        final x d = this.b().d();
        final double d2 = d.d();
        final boolean b = d.f().j() > 0 && d2 > 0.0;
        final R g = aa.g();
        this.b.clear();
        final aU a2 = this.a().a(aa.c());
        final List list = (a2 != null) ? a2.a(false) : null;
        int a3 = 0;
        Label_0278: {
            if (list != null) {
                for (final ax ax : list) {
                    a3 = ax.a();
                    if (a != 0) {
                        break Label_0278;
                    }
                    if (a3 == 255) {
                        this.b.clear();
                        if (a == 0) {
                            break;
                        }
                    }
                    final P a4 = g.a(S.a(ax));
                    if (ax.b()) {
                        final t a5 = a2.a(ax, false);
                        final double n = a4.a() ? a5.b() : a5.a();
                        this.b.add(new P(n, n, a4.f(), a4.a()));
                        if (a == 0) {
                            continue;
                        }
                    }
                    this.b.add(this.a(a4, b, d2));
                    if (a != 0) {
                        break;
                    }
                }
            }
            this.b.isEmpty();
        }
        if (a3 != 0) {
            final P a6 = g.a(S.a);
            final P a7 = g.a(S.b);
            final P a8 = g.a(S.d);
            final P a9 = g.a(S.c);
            this.b.add(this.a(a6, b, d2));
            this.b.add(this.a(a7, b, d2));
            this.b.add(this.a(a9, b, d2));
            this.b.add(this.a(a8, b, d2));
        }
    }
    
    private P a(final P p3, final boolean b, final double n) {
        if (b && p3.d() > 2.0 * n) {
            return new P(p3.b() + n, p3.c() - n, p3.f(), p3.a());
        }
        return p3;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (f.d() == null) {
            this.b("distance penalty", 0.0, false);
            return new double[array.length];
        }
        this.d = 0.0;
        if (this.c != null && array2[0].c() == 3) {
            final P a = this.a(f.a(), array[0].a());
            if (this.c.a(a)) {
                this.d += 2.0 * this.c.b(array[0].f(), a);
            }
        }
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        double d = this.d;
        final P d2 = this.d(f);
        if (d2 != null) {
            d += d2.a(this.a(p5, d2));
        }
        final double n2 = d / this.b().h();
        this.a("distance penalty", n2, false);
        return n2;
    }
    
    private P a(final P p2, final P p3) {
        if (p2.a() == p3.a()) {
            return this.b(p3, p2);
        }
        return this.c(p3, p2);
    }
    
    private P d(final f f) {
        P p = f.h();
        if (p == null) {
            p = this.e(f);
            if (p != null) {
                f.b(p);
                if (ab.a == 0) {
                    return p;
                }
            }
            p = f.c();
        }
        return p;
    }
    
    private P e(final f f) {
        final f b = f.b();
        final P p = (b != null) ? this.d(b) : null;
        if (p != null) {
            return this.a(f.c(), p);
        }
        return null;
    }
    
    protected double b(final f f) {
        final int a = ab.a;
        double n = 0.0;
        double n2 = 0.0;
        Label_0101: {
            if (!this.b.isEmpty()) {
                n = Double.MAX_VALUE;
                final P d = this.d(f);
                final Iterator<P> iterator = (Iterator<P>)this.b.iterator();
                while (iterator.hasNext()) {
                    final double a2 = d.a(iterator.next());
                    if (a2 < n) {
                        n2 = a2;
                        if (a != 0) {
                            break Label_0101;
                        }
                        n = n2;
                        if (a != 0) {
                            break;
                        }
                        continue;
                    }
                }
            }
            final double n3 = n / this.b().h();
        }
        final double n4 = n2;
        this.a("HEUR distance penalty", n / this.b().h(), true);
        return n4;
    }
    
    private P b(final P p2, final P p3) {
        final double f = p3.f();
        final boolean a = p3.a();
        if (p2.d() == 0.0) {
            double n = p3.e().c(p2.b());
            if (this.c != null && this.c.a(p3)) {
                n = this.c.a(n, p3);
            }
            return new P(n, n, f, a);
        }
        final M a2 = M.a(p2.e(), p3.e());
        if (a2 == null) {
            double n2 = p3.e().c((p2.b() > p3.c()) ? p2.b() : p2.c());
            if (this.c != null && this.c.a(p3)) {
                n2 = this.c.a(n2, p3);
            }
            return new P(n2, n2, f, a);
        }
        if (this.c == null) {
            return new P(a2, f, a);
        }
        if (this.c.a(a2, !a)) {
            return new P(this.c.b(a2, !a), f, a);
        }
        if (this.c.a(p3)) {
            final double a3 = this.c.a(p2.b(), p3);
            return new P(a3, a3, f, a);
        }
        return new P(a2, f, a);
    }
    
    private P c(final P p2, final P p3) {
        double n = p3.e().c(p2.f());
        if (this.c != null && this.c.a(p3)) {
            n = this.c.a(n, p3);
        }
        return new P(n, n, p3.f(), p3.a());
    }
    
    private P a(final R r, final boolean b) {
        return r.a(b ? S.a : S.d);
    }
}
