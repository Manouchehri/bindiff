package y.f.i.a;

import y.f.*;
import java.util.*;
import y.c.*;
import y.d.*;

class aM extends ab implements H
{
    private double b;
    private double c;
    private double d;
    private boolean e;
    private int f;
    private boolean g;
    
    aM() {
        this.g = false;
    }
    
    protected void b(final aa aa) {
        super.b(aa);
        this.b = aa.d().d();
        this.f = aa.d().f().j();
        this.g = (this.f > 0 && this.b > 0.0);
        if (this.g) {
            aa.a().a((H)this);
        }
    }
    
    protected void c(final aa aa) {
        super.c(aa);
        if (this.g) {
            aa.a().b(this);
        }
    }
    
    protected void d(final aa aa) {
        super.d(aa);
        if (this.g) {
            aa.a().b(this);
        }
    }
    
    protected double a(final f f) {
        if (!this.g) {
            return 0.0;
        }
        if (this.b().b(f.a()) || !this.b().b(f.b().a())) {
            return 0.0;
        }
        final y s = this.a().a().s(this.b().c().c());
        final P c = f.c();
        double n = 0.0;
        double n2 = 0.0;
        Label_0148: {
            if (c.a()) {
                n = s.d() + this.b;
                n2 = s.d() + s.b() - this.b;
                if (ab.a == 0) {
                    break Label_0148;
                }
            }
            n = s.c() + this.b;
            n2 = s.c() + s.a() - this.b;
        }
        if (c.b() + 1.0E-6 < n || c.c() - 1.0E-6 > n2) {
            return this.f;
        }
        return 0.0;
    }
    
    protected void a(final List list) {
        final int i = ab.a;
        if (!this.g) {
            return;
        }
        final X a = this.a().a();
        final aa b = this.b();
        final y s = a.s(b.c().c());
        int n = 0;
        final int e = b.e();
        do {
            int j = 0;
        Label_0054:
            while (j < e) {
                final R a2 = b.a(n);
                final f f = new f(a2);
                for (final R r : this.a().c().r().c(a2)) {
                    if (!b.b(r)) {
                        final P a3 = V.a(a2, r);
                        j = (a3.a() ? 1 : 0);
                        if (i != 0) {
                            continue Label_0054;
                        }
                        if (j != 0) {
                            if (s.b() <= 2.0 * this.b) {
                                continue;
                            }
                            final double max = Math.max(a3.b(), s.d() + this.b);
                            final double min = Math.min(a3.c(), s.d() + s.b() - this.b);
                            if (max >= min) {
                                continue;
                            }
                            final P p = new P(max, min, a3.f(), true);
                            final y.f.y a4 = V.a(f, r);
                            final f f2 = new f(r);
                            f2.a(f);
                            f2.a(p);
                            f2.a(a4);
                            list.add(f2);
                            if (i == 0) {
                                continue;
                            }
                        }
                        if (s.a() <= 2.0 * this.b) {
                            continue;
                        }
                        final double max2 = Math.max(a3.b(), s.c() + this.b);
                        final double min2 = Math.min(a3.c(), s.c() + s.a() - this.b);
                        if (max2 >= min2) {
                            continue;
                        }
                        final P p2 = new P(max2, min2, a3.f(), false);
                        final y.f.y a5 = V.a(f, r);
                        final f f3 = new f(r);
                        f3.a(f);
                        f3.a(p2);
                        f3.a(a5);
                        list.add(f3);
                        if (i != 0) {
                            break;
                        }
                        continue;
                    }
                }
                ++n;
            }
            break;
        } while (i == 0);
    }
    
    double[] a(final f f, final R r, final P[] array, final v[] array2, final double[] array3) {
        if (!this.g) {
            this.b("min node corner dist penalty", 0.0, false);
            return new double[array.length];
        }
        final y s = this.a().a().s(this.b().c().d());
        if (!(this.e = (!a(s, f.a()) && a(s, r)))) {
            this.b("min node corner dist penalty", 0.0, false);
            return new double[array.length];
        }
        if (array[0].a()) {
            this.c = s.d() + this.b;
            this.d = s.d() + s.b() - this.b;
            if (ab.a == 0) {
                return super.a(f, r, array, array2, array3);
            }
        }
        this.c = s.c() + this.b;
        this.d = s.c() + s.a() - this.b;
        return super.a(f, r, array, array2, array3);
    }
    
    protected double a(final f f, final R r, final P p5, final v v, final double n) {
        int n2 = 0;
        if (this.e && (p5.b() + 1.0E-6 < this.c || p5.c() - 1.0E-6 > this.d)) {
            n2 += this.f;
        }
        this.a("min node corner dist penalty", n2, false);
        return n2;
    }
    
    public void a(final f f, final R r, final P p5, final List list, final aa aa) {
        if (this.b <= 0.0) {
            return;
        }
        final X a = this.a().a();
        final d c = aa.c();
        P p6 = null;
        final y s = a.s(c.d());
        if (!a(s, f.a()) && a(s, r)) {
            if (p5.a()) {
                if (s.b() > 2.0 * this.b) {
                    final double max = Math.max(p5.b(), s.d() + this.b);
                    final double min = Math.min(p5.c(), s.d() + s.b() - this.b);
                    if (max < min) {
                        p6 = new P(max, min, p5.f(), true);
                    }
                }
            }
            else if (s.a() > 2.0 * this.b) {
                final double max2 = Math.max(p5.b(), s.c() + this.b);
                final double min2 = Math.min(p5.c(), s.c() + s.a() - this.b);
                if (max2 < min2) {
                    p6 = new P(max2, min2, p5.f(), false);
                }
            }
        }
        if (p6 != null) {
            list.add(p6);
        }
    }
    
    private static boolean a(final y y, final R r) {
        final t e = y.e();
        final t t = new t(y.c + y.a, y.d + y.b);
        return e.a - 1.0E-6 < r.h() && e.b - 1.0E-6 < r.i() && t.a + 1.0E-6 > r.j() && t.b + 1.0E-6 > r.k();
    }
}
