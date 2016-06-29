package y.f.f.d;

import y.f.*;
import y.d.*;
import y.c.*;

class f
{
    private q a;
    private int[] b;
    private y.d.q c;
    private final e d;
    
    public f(final e d, final q a, final double n, final double n2, final double n3, final double n4) {
        final boolean p6 = o.p;
        this.d = d;
        this.a = a;
        this.b = new int[4];
        final int max = Math.max(0, (int)Math.ceil(n));
        final int max2 = Math.max(0, (int)Math.ceil(n2));
        final int max3 = Math.max(0, (int)Math.ceil(n3));
        final int max4 = Math.max(0, (int)Math.ceil(n4));
        int n5 = (max % e.a(d) == 0) ? 0 : (e.a(d) - max % e.a(d));
        int n6 = (max2 % e.a(d) == 0) ? 0 : (e.a(d) - max2 % e.a(d));
        Label_0181: {
            if ((max + n5 + max2 + n6) / e.a(d) % 2 == 1) {
                if (n5 > n6) {
                    n6 += e.a(d);
                    if (!p6) {
                        break Label_0181;
                    }
                }
                n5 += e.a(d);
            }
        }
        int n7 = (max3 % e.a(d) == 0) ? 0 : (e.a(d) - max3 % e.a(d));
        int n8 = (max4 % e.a(d) == 0) ? 0 : (e.a(d) - max4 % e.a(d));
        Label_0289: {
            if ((max3 + n7 + max4 + n8) / e.a(d) % 2 == 1) {
                if (n7 > n8) {
                    n8 += e.a(d);
                    if (!p6) {
                        break Label_0289;
                    }
                }
                n7 += e.a(d);
            }
        }
        this.b[0] = max + n5;
        this.b[1] = max2 + n6;
        this.b[2] = max3 + n7;
        this.b[3] = max4 + n8;
        this.c = e.b(d).r(a);
    }
    
    public int a() {
        return this.b[0];
    }
    
    public int b() {
        return this.b[1];
    }
    
    public int c() {
        return this.b[2];
    }
    
    public int d() {
        return this.b[3];
    }
    
    public y.d.q e() {
        final boolean p = o.p;
        final X x = (X)this.a.e();
        double p2 = x.p(this.a);
        double q = x.q(this.a);
        int i = 0;
        while (i < this.b.length) {
            Label_0088: {
                if (i == 0 || i == 1) {
                    q += this.b[i];
                    if (!p) {
                        break Label_0088;
                    }
                }
                p2 += this.b[i];
            }
            ++i;
            if (p) {
                break;
            }
        }
        return new y.d.q(p2, q);
    }
    
    public void f() {
        final boolean p = o.p;
        if (!this.g()) {
            return;
        }
        final t o = e.b(this.d).o(this.a);
        final t t = new t(o.a() + this.c(), o.b() + this.a());
        e.b(this.d).a(this.a, this.c);
        e.b(this.d).b(this.a, t);
        y.c.e e = this.a.l();
        while (true) {
            while (e.f()) {
                final d a = e.a();
                final t t2 = (t)y.f.f.d.e.c(this.d).b(a);
                final y.f.f.b.o o2 = (y.f.f.b.o)y.f.f.d.e.d(this.d).b(a);
                final boolean a2 = o2.a(y.f.f.b.o.a);
                if (p) {
                    while (true) {
                        if (a2) {
                            final d a3 = e.a();
                            final t t3 = (t)y.f.f.d.e.e(this.d).b(a3);
                            final y.f.f.b.o o3 = (y.f.f.b.o)y.f.f.d.e.f(this.d).b(a3);
                            Label_0629: {
                                if (o3.a(y.f.f.b.o.a)) {
                                    y.f.f.d.e.b(this.d).d(a3, new t(t3.a(), t3.b() + this.a()));
                                    if (!p) {
                                        break Label_0629;
                                    }
                                }
                                if (o3.a(y.f.f.b.o.c)) {
                                    y.f.f.d.e.b(this.d).d(a3, new t(t3.a(), t3.b() - this.b()));
                                    if (!p) {
                                        break Label_0629;
                                    }
                                }
                                if (o3.a(y.f.f.b.o.d)) {
                                    y.f.f.d.e.b(this.d).d(a3, new t(t3.a() + this.c(), t3.b()));
                                    if (!p) {
                                        break Label_0629;
                                    }
                                }
                                if (o3.a(y.f.f.b.o.b)) {
                                    y.f.f.d.e.b(this.d).d(a3, new t(t3.a() - this.d(), t3.b()));
                                }
                            }
                            e.g();
                            if (!p) {
                                e.f();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0356: {
                    if (a2) {
                        y.f.f.d.e.b(this.d).c(a, new t(t2.a(), t2.b() + this.a()));
                        if (!p) {
                            break Label_0356;
                        }
                    }
                    if (o2.a(y.f.f.b.o.c)) {
                        y.f.f.d.e.b(this.d).c(a, new t(t2.a(), t2.b() - this.b()));
                        if (!p) {
                            break Label_0356;
                        }
                    }
                    if (o2.a(y.f.f.b.o.d)) {
                        y.f.f.d.e.b(this.d).c(a, new t(t2.a() + this.c(), t2.b()));
                        if (!p) {
                            break Label_0356;
                        }
                    }
                    if (o2.a(y.f.f.b.o.b)) {
                        y.f.f.d.e.b(this.d).c(a, new t(t2.a() - this.d(), t2.b()));
                    }
                }
                e.g();
                if (p) {
                    break;
                }
            }
            e = this.a.k();
            continue;
        }
    }
    
    public boolean g() {
        final boolean p = o.p;
        int i = 0;
        while (i < this.b.length) {
            final int n2;
            final int n = n2 = this.b[i];
            if (p) {
                return n2 != 0;
            }
            if (n > 0) {
                return true;
            }
            ++i;
            if (p) {
                break;
            }
        }
        int n2 = false ? 1 : 0;
        return n2 != 0;
    }
}
