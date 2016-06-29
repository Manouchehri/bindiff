package y.f.i.a;

import y.f.*;
import y.c.*;
import y.d.*;

class aH extends a
{
    public static final Object a;
    private final boolean b;
    
    aH(final boolean b) {
        this.b = b;
    }
    
    public void c(final X x) {
        final int a = ab.a;
        if (this.a() != null) {
            this.a().c(x);
        }
        final e p = x.p();
        while (p.f()) {
            final d a2 = p.a();
            while (this.b(a2, x)) {}
            if (this.b) {
                this.a(a2, x);
            }
            p.g();
            if (a != 0) {
                break;
            }
        }
    }
    
    private void a(final d d, final X x) {
        final int a = ab.a;
        final t[] f = x.l(d).f();
        int i = 0;
        while (i <= f.length - 4) {
            final m m = new m(f[i], f[i + 1]);
            final m j = new m(f[i + 2], f[i + 3]);
            final m k = m.a() ? m : (j.a() ? j : null);
            final m l = m.b() ? m : (j.b() ? j : null);
            if (k != null && l != null) {
                final double min = Math.min(k.c().b, k.d().b);
                final double max = Math.max(k.c().b, k.d().b);
                final double a2 = k.c().a;
                final double min2 = Math.min(l.c().a, l.d().a);
                final double max2 = Math.max(l.c().a, l.d().a);
                final double b = l.c().b;
                if ((min < b && max > b) || (min2 < a2 && max2 > a2)) {
                    final D d2 = new D();
                    int n = 0;
                    while (n <= i) {
                        d2.add(f[n]);
                        ++n;
                        if (a != 0) {
                            break;
                        }
                    }
                    d2.add(new t(a2, b));
                    int n2 = i + 3;
                    while (n2 < f.length) {
                        d2.add(f[n2]);
                        ++n2;
                        if (a != 0) {
                            return;
                        }
                        if (a != 0) {
                            break;
                        }
                    }
                    x.a(d, d2);
                    return;
                }
            }
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
    
    private boolean b(final d d, final X x) {
        final int a = ab.a;
        final v c = ae.c(x, d);
        final int n = c.h() - 1;
        if (n < 4) {
            return false;
        }
        final c c2 = x.c(aH.a);
        final x x2 = (c2 == null) ? null : ((x)c2.b(d));
        final D d2 = new D();
        int n2 = 1;
        final s j = c.j();
        while (j.f()) {
            final m a2 = j.a();
            Label_0320: {
                if (n2 == 1 && x2 != null && x2.a() > 0.0) {
                    if (x2.a() >= a2.g()) {
                        break Label_0320;
                    }
                    final z i = a2.i();
                    i.c();
                    i.b(x2.a());
                    d2.add(new aJ(z.a(a2.c(), i), a2.d(), n2, null));
                    if (a == 0) {
                        break Label_0320;
                    }
                }
                if (n2 == n && x2 != null && x2.b() > 0.0) {
                    if (x2.b() >= a2.g()) {
                        break Label_0320;
                    }
                    final z z = new z(a2.c(), a2.d());
                    z.c();
                    z.b(x2.b());
                    d2.add(new aJ(a2.c(), y.d.z.a(a2.d(), z), n2, null));
                    if (a == 0) {
                        break Label_0320;
                    }
                }
                d2.add(new aJ(a2, n2, null));
            }
            ++n2;
            j.g();
            if (a != 0) {
                break;
            }
        }
        final aL al = new aL(null);
        f.a(d2, al);
        final aK a3 = aL.a(al);
        if (a3 != null) {
            final t[] f = c.f();
            final D d3 = new D();
            int k = 0;
            while (true) {
                while (k < a3.a()) {
                    d3.add(f[k]);
                    ++k;
                    if (a != 0) {
                        int l = a3.b();
                        while (l < f.length) {
                            d3.add(f[l]);
                            ++l;
                            if (a != 0) {
                                return aL.b(al);
                            }
                            if (a != 0) {
                                break;
                            }
                        }
                        x.a(d, d3);
                        return aL.b(al);
                    }
                    if (a != 0) {
                        break;
                    }
                }
                d3.add(a3.c);
                continue;
            }
        }
        return aL.b(al);
    }
    
    static {
        a = "y.layout.router.polyline.SelfCrossingRemovalStage.LAYOUT_DESCRIPTOR_DPKEY";
    }
}
