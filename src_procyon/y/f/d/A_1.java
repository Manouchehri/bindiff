package y.f.d;

import java.util.*;
import y.f.*;
import y.d.*;
import y.c.*;

class A implements aH
{
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private Map i;
    private Map j;
    private double[] k;
    private double[] l;
    private double m;
    private double[] n;
    private double[] o;
    private aH p;
    
    public void a(final double h) {
        final int f = y.f.d.a.f;
        if (h < 0.0) {
            this.h = 0.0;
            if (f == 0) {
                return;
            }
        }
        if (h > 1.0) {
            this.h = 1.0;
            if (f == 0) {
                return;
            }
        }
        this.h = h;
    }
    
    public A(final r[] array, final X x) {
        this.a = 3.0;
        this.b = 1.5;
        this.c = 1.0;
        this.d = 2.0;
        this.e = 1.0;
        this.f = 1.0;
        this.g = 1.0;
        this.h = 0.1;
        this.i = new HashMap();
        this.j = new HashMap();
        this.m = this.b(array);
        final int a = this.a(array);
        this.k = new double[a];
        this.l = new double[a];
        this.n = new double[a];
        this.o = new double[a];
        this.a(array, x);
    }
    
    public void b(final double a) {
        this.a = a;
    }
    
    public void c(final double f) {
        this.f = f;
    }
    
    public void d(final double b) {
        this.b = b;
    }
    
    public void e(final double c) {
        this.c = c;
    }
    
    public void f(final double d) {
        this.d = d;
    }
    
    public void g(final double e) {
        this.e = e;
    }
    
    public void h(final double g) {
        this.g = g;
    }
    
    public double a(final Q q) {
        final double n = this.a + this.b + this.e + this.d + this.c + this.f + this.g;
        if (n == 0.0) {
            return 0.0;
        }
        final double n2 = q.a() * this.g;
        final int intValue = this.i.get(q);
        final double n3 = n2 + this.o[intValue] * this.e + this.n[intValue] * this.f;
        if (q.j() <= 0.0) {}
        final double n4 = n3 + ((this.l[intValue] > 1.0) ? 0.0 : (1.0 - this.l[intValue])) * this.b;
        if (q.i() <= 0.0) {}
        double n5 = (n4 + ((this.k[intValue] > 1.0) ? 0.0 : (1.0 - this.k[intValue])) * this.a + 1.0 / this.j.get(q).b().size() * this.d + q.d().f() * q.d().e() / this.m * this.c) / n;
        if (this.p != null && this.h > 0.0) {
            n5 = this.p.a(q) * this.h + n5 * (1.0 - this.h);
        }
        return n5;
    }
    
    private double a(final X x, final Q q) {
        final int i = y.f.d.a.f;
        final R e = q.e();
        if (!(e instanceof C)) {
            return 0.0;
        }
        final t[] a = y.d.n.a(q.d());
        double n = Double.MAX_VALUE;
        final u b = x.l(a(e, x)).b();
        t t = b.a();
        b.g();
        do {
            double f = 0.0;
            Label_0069: {
                f = (b.f() ? 1 : 0);
            }
            Label_0076:
            while (f != 0) {
                final m m = new m(t, b.a());
                int j = 0;
                while (j < a.length) {
                    final double a2 = y.f.d.m.a(m, a[j]);
                    final double n2 = f = dcmpg(a2, n);
                    if (i != 0) {
                        continue Label_0076;
                    }
                    if (n2 < 0) {
                        n = a2;
                    }
                    ++j;
                    if (i != 0) {
                        break;
                    }
                }
                t = b.a();
                b.g();
                continue Label_0069;
            }
            break;
        } while (i == 0);
        final double abs = Math.abs(n - Math.max(0.0, ((C)e).getPreferredPlacementDescriptor().h()));
        if (abs > 100.0) {
            return 0.0;
        }
        return 1.0 - abs / 100.0;
    }
    
    private double a(final X x, final d d) {
        final int f = y.f.d.a.f;
        final v l = x.l(d);
        double n = 0.0;
        final s j = l.j();
        double n2 = 0.0;
        while (j.f()) {
            n2 = n + j.a().g();
            if (f != 0) {
                return n2;
            }
            n = n2;
            j.g();
            if (f != 0) {
                break;
            }
        }
        return n2;
    }
    
    private static d a(final R r, final X x) {
        return x.a((C)r);
    }
    
    private double b(final X x, final Q q) {
        final R e = q.e();
        if (!(e instanceof C)) {
            return 0.0;
        }
        final aG preferredPlacementDescriptor = ((C)e).getPreferredPlacementDescriptor();
        if ((preferredPlacementDescriptor.i() && preferredPlacementDescriptor.j() && preferredPlacementDescriptor.k()) || (!preferredPlacementDescriptor.i() && !preferredPlacementDescriptor.j() && !preferredPlacementDescriptor.k())) {
            return 1.0;
        }
        double n = 1.0;
        final d a = a(e, x);
        final double a2 = this.a(x, a);
        final double n2 = 15.0 + Math.max(0.0, ((C)e).getPreferredPlacementDescriptor().h());
        final double max = Math.max(100.0, a2 * 0.2);
        final n d = q.d();
        if (preferredPlacementDescriptor.i()) {
            final double a3 = y.f.d.m.a(x.s(a.c()), d);
            if (a3 <= n2) {
                return 1.0;
            }
            if (a3 < max) {
                n *= a3 / max;
            }
        }
        if (preferredPlacementDescriptor.k()) {
            final double a4 = y.f.d.m.a(x.s(a.d()), d);
            if (a4 <= n2) {
                return 1.0;
            }
            if (a4 < max) {
                n *= a4 / max;
            }
        }
        if (preferredPlacementDescriptor.j()) {
            final v l = x.l(a);
            final m a5 = l.a((int)Math.floor((l.h() - 1) * 0.5));
            n *= y.f.d.m.a(d, t.c(a5.c(), a5.d())) / max;
        }
        return 1.0 - n;
    }
    
    private void a(final r[] array, final X x) {
        final int f = y.f.d.a.f;
        int i = 0;
    Label_0117_Outer:
        while (i < array.length) {
            final y.c.C m = array[i].b().m();
            while (true) {
                while (m.f()) {
                    final Q q = (Q)m.d();
                    final int intValue = this.i.get(q);
                    this.n[intValue] = this.a(x, q);
                    this.o[intValue] = this.b(x, q);
                    m.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0117_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0117_Outer;
                        }
                        continue Label_0117_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
    }
    
    private int a(final r[] array) {
        final int f = y.f.d.a.f;
        int n = 0;
        int i = 0;
    Label_0109_Outer:
        while (i < array.length) {
            final r r = array[i];
            final y.c.C m = r.b().m();
            while (true) {
                while (m.f()) {
                    final Q q = (Q)m.d();
                    this.i.put(q, new Integer(n++));
                    this.j.put(q, r);
                    m.g();
                    if (f == 0) {
                        if (f != 0) {
                            break;
                        }
                        continue Label_0109_Outer;
                    }
                    else {
                        if (f != 0) {
                            break Label_0109_Outer;
                        }
                        continue Label_0109_Outer;
                    }
                }
                ++i;
                continue;
            }
        }
        return n;
    }
    
    void a(final Q q, final q q2, final y y) {
        final int intValue = this.i.get(q);
        final double a = y.f.d.C.a(q.d(), y);
        final double[] k = this.k;
        final int n = intValue;
        k[n] += a;
    }
    
    void a(final Q q, final d d, final m m) {
        final int intValue = this.i.get(q);
        double a = y.f.d.C.a(q.d(), m);
        if (q.e() != null && q.e() instanceof C) {
            final C c = (C)q.e();
            if (d.a() != null && d.a() instanceof X && d.equals(((X)d.a()).a(c))) {
                a /= 2.0;
            }
        }
        final double[] l = this.l;
        final int n = intValue;
        l[n] += a;
    }
    
    private double b(final r[] array) {
        final int f = y.f.d.a.f;
        double n = 0.0;
        int i = 0;
        while (i < array.length) {
            final D b = array[i].b();
            if (!b.isEmpty()) {
                final Q q = (Q)b.f();
                final double n2 = q.d().f() * q.d().e();
                if (n2 > n) {
                    n = n2;
                }
            }
            ++i;
            if (f != 0) {
                break;
            }
        }
        return n;
    }
    
    public void a(final aH p) {
        this.p = p;
    }
}
