package y.f.i.a;

import java.util.*;
import y.c.*;

class bf extends ab implements bR
{
    private int b;
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = aa.d().f().b();
        if (this.d()) {
            aa.a().a((bR)this);
        }
    }
    
    protected void c(final aa aa) {
        super.c(aa);
        if (this.d()) {
            this.b().a().b(this);
        }
    }
    
    protected void d(final aa aa) {
        super.d(aa);
        if (this.d()) {
            this.b().a().b(this);
        }
    }
    
    private boolean d() {
        return this.b > 0;
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.d()) {
            this.b("crossing cost", 0.0, false);
            return new double[array.length];
        }
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        final int a = ab.a;
        int a2 = 0;
        Label_0498: {
            Label_0489: {
                if (v != null && v.c() == 0 && !v.i().d(v.j())) {
                    P p6 = v.i();
                    final M e = p6.e();
                    final M e2 = p5.e();
                    P i = new P(e2, p6.f(), p6.a());
                    final v v2 = null;
                    final v v3 = new v(v.g(), v.h(), i, v.j(), v.k(), v.l(), v.d());
                    final D d = new D();
                    d.add(new bh(f, v2, v3, null));
                    v v4 = f.j();
                    f f2 = f.b();
                    while (f2 != null && v4 != null) {
                        final P p7 = p6;
                        final P p8 = i;
                        final boolean b = v4.c() == 0 && !v4.i().d(p8);
                        Label_0286: {
                            if (b) {
                                p6 = new P(e, v4.i().f(), v4.i().a());
                                i = new P(e2, v4.i().f(), v4.i().a());
                                if (a == 0) {
                                    break Label_0286;
                                }
                            }
                            p6 = v4.i();
                            i = v4.i();
                        }
                        final v v5 = new v(v4.g(), v4.h(), p6, p7, v4.k(), v4.l(), v4.d());
                        d.a(new bh(f2, v5, new v(v5.g(), v5.h(), i, p8, v5.k(), v5.l(), v5.d()), null));
                        if (!b) {
                            break;
                        }
                        v4 = f2.j();
                        f2 = f2.b();
                        if (a != 0) {
                            break;
                        }
                    }
                    for (final bh bh : d) {
                        if (bh.a(bh) != null) {
                            a2 -= this.a(bh.b(bh), bh.a(bh));
                        }
                        a2 += this.a(bh.b(bh), bh.c(bh));
                        if (a != 0) {
                            break Label_0489;
                        }
                    }
                    break Label_0498;
                }
            }
            a2 = this.a(f, v);
        }
        final double n2 = a2 * this.b;
        this.a("crossing cost", n2, false);
        return n2;
    }
    
    private int a(final f f, final v v) {
        final int a = ab.a;
        int n = 0;
        final D a2 = f.a().b().a();
        if (a2 != null && !a2.isEmpty()) {
            final D a3 = new D();
            final HashSet<aW> set = new HashSet<aW>();
            final C m = a2.m();
            while (m.f()) {
                final v v2 = (v)m.d();
                final bE a4 = v2.a().a(v, this.a(f, this.b().c(), v2.g()));
                final aW f2 = v2.f();
                if (a != 0) {
                    return n;
                }
                if (f2 == null || set.add(f2)) {
                    n += a4.a();
                }
                if (a4.c()) {
                    a3.add(a4.b());
                }
                m.g();
                if (a != 0) {
                    break;
                }
            }
            if (a3.size() > 0) {
                v.a = a3;
            }
        }
        return n;
    }
    
    private bD a(final f f, final d d, final d d2) {
        final int a = ab.a;
        final D a2 = f.a;
        if (a2 != null && !a2.isEmpty()) {
            final C m = a2.m();
            while (m.f()) {
                final bD bd = (bD)m.d();
                if (bd.b() == d && bd.a() == d2) {
                    return bd;
                }
                m.g();
                if (a != 0) {
                    break;
                }
            }
        }
        return null;
    }
    
    public void a(final f f, final aa aa, final byte b) {
        if (b != 0 && f.b() != null && f.j() != null) {
            final D a = f.j().a;
            if (a != null) {
                f.a = a;
            }
        }
    }
}
