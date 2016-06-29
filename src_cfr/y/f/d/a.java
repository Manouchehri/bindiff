/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.HashMap;
import java.util.Map;
import y.c.D;
import y.c.d;
import y.c.i;
import y.c.q;
import y.d.n;
import y.d.s;
import y.d.t;
import y.d.u;
import y.d.v;
import y.d.y;
import y.f.C;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aG;
import y.f.aH;
import y.f.d.a;
import y.f.d.m;
import y.f.d.r;

class A
implements aH {
    private double a = 3.0;
    private double b = 1.5;
    private double c = 1.0;
    private double d = 2.0;
    private double e = 1.0;
    private double f = 1.0;
    private double g = 1.0;
    private double h = 0.1;
    private Map i = new HashMap();
    private Map j = new HashMap();
    private double[] k;
    private double[] l;
    private double m;
    private double[] n;
    private double[] o;
    private aH p;

    public void a(double d2) {
        int n2 = a.f;
        if (d2 < 0.0) {
            this.h = 0.0;
            if (n2 == 0) return;
        }
        if (d2 > 1.0) {
            this.h = 1.0;
            if (n2 == 0) return;
        }
        this.h = d2;
    }

    public A(r[] arrr, X x2) {
        this.m = this.b(arrr);
        int n2 = this.a(arrr);
        this.k = new double[n2];
        this.l = new double[n2];
        this.n = new double[n2];
        this.o = new double[n2];
        this.a(arrr, x2);
    }

    public void b(double d2) {
        this.a = d2;
    }

    public void c(double d2) {
        this.f = d2;
    }

    public void d(double d2) {
        this.b = d2;
    }

    public void e(double d2) {
        this.c = d2;
    }

    public void f(double d2) {
        this.d = d2;
    }

    public void g(double d2) {
        this.e = d2;
    }

    public void h(double d2) {
        this.g = d2;
    }

    @Override
    public double a(Q q2) {
        double d2 = this.a + this.b + this.e + this.d + this.c + this.f + this.g;
        if (d2 == 0.0) {
            return 0.0;
        }
        double d3 = q2.a() * this.g;
        int n2 = (Integer)this.i.get(q2);
        d3 += this.o[n2] * this.e;
        d3 += this.n[n2] * this.f;
        double d4 = 0.0;
        if (q2.j() <= 0.0) {
            // empty if block
        }
        d4 = this.l[n2] > 1.0 ? 0.0 : 1.0 - this.l[n2];
        d3 += d4 * this.b;
        if (q2.i() <= 0.0) {
            // empty if block
        }
        d4 = this.k[n2] > 1.0 ? 0.0 : 1.0 - this.k[n2];
        d3 += d4 * this.a;
        r r2 = (r)this.j.get(q2);
        d4 = 1.0 / (double)r2.b().size();
        d3 += d4 * this.d;
        d4 = q2.d().f() * q2.d().e() / this.m;
        double d5 = (d3 += d4 * this.c) / d2;
        if (this.p == null) return d5;
        if (this.h <= 0.0) return d5;
        return this.p.a(q2) * this.h + d5 * (1.0 - this.h);
    }

    private double a(X x2, Q q2) {
        double d2;
        double d3;
        int n2 = a.f;
        R r2 = q2.e();
        if (!(r2 instanceof C)) return 0.0;
        t[] arrt = n.a(q2.d());
        double d4 = Double.MAX_VALUE;
        d d5 = A.a(r2, x2);
        v v2 = x2.l(d5);
        u u2 = v2.b();
        t t2 = u2.a();
        u2.g();
        block0 : do {
            int n3 = u2.f();
            block1 : while (n3 != 0) {
                y.d.m m2 = new y.d.m(t2, u2.a());
                for (int i2 = 0; i2 < arrt.length; ++i2) {
                    d2 = m.a(m2, arrt[i2]);
                    n3 = d2 DCMPG d4;
                    if (n2 != 0) continue block1;
                    if (n3 >= 0) continue;
                    d4 = d2;
                    if (n2 == 0) continue;
                }
                t2 = u2.a();
                u2.g();
                if (n2 == 0) continue block0;
            }
            break block0;
            break;
        } while (true);
        if ((d2 = Math.abs(d4 - (d3 = Math.max(0.0, ((C)r2).getPreferredPlacementDescriptor().h())))) <= 100.0) return 1.0 - d2 / 100.0;
        return 0.0;
    }

    private double a(X x2, d d2) {
        double d3;
        int n2 = a.f;
        v v2 = x2.l(d2);
        double d4 = 0.0;
        s s2 = v2.j();
        while (s2.f()) {
            y.d.m m2 = s2.a();
            d3 = d4 + m2.g();
            if (n2 != 0) return d3;
            d4 = d3;
            s2.g();
            if (n2 == 0) continue;
        }
        d3 = d4;
        return d3;
    }

    private static d a(R r2, X x2) {
        return x2.a((C)r2);
    }

    private double b(X x2, Q q2) {
        double d2;
        Object object;
        R r2 = q2.e();
        if (!(r2 instanceof C)) return 0.0;
        C c2 = (C)r2;
        aG aG2 = c2.getPreferredPlacementDescriptor();
        if (aG2.i() && aG2.j()) {
            if (aG2.k()) return 1.0;
        }
        if (!(aG2.i() || aG2.j() || aG2.k())) {
            return 1.0;
        }
        double d3 = 1.0;
        d d4 = A.a(r2, x2);
        double d5 = this.a(x2, d4);
        double d6 = Math.max(0.0, ((C)r2).getPreferredPlacementDescriptor().h());
        double d7 = 15.0 + d6;
        double d8 = Math.max(100.0, d5 * 0.2);
        n n2 = q2.d();
        if (aG2.i()) {
            object = x2.s(d4.c());
            d2 = m.a((y)object, n2);
            if (d2 <= d7) {
                return 1.0;
            }
            if (d2 < d8) {
                d3 *= d2 / d8;
            }
        }
        if (aG2.k()) {
            object = x2.s(d4.d());
            d2 = m.a((y)object, n2);
            if (d2 <= d7) {
                return 1.0;
            }
            if (d2 < d8) {
                d3 *= d2 / d8;
            }
        }
        if (!aG2.j()) return 1.0 - d3;
        object = x2.l(d4);
        int n3 = (int)Math.floor((double)(object.h() - 1) * 0.5);
        y.d.m m2 = object.a(n3);
        t t2 = t.c(m2.c(), m2.d());
        double d9 = m.a(n2, t2);
        d3 *= d9 / d8;
        return 1.0 - d3;
    }

    private void a(r[] arrr, X x2) {
        int n2 = a.f;
        int n3 = 0;
        block0 : do {
            if (n3 >= arrr.length) return;
            r r2 = arrr[n3];
            y.c.C c2 = r2.b().m();
            while (c2.f()) {
                Q q2 = (Q)c2.d();
                int n4 = (Integer)this.i.get(q2);
                this.n[n4] = this.a(x2, q2);
                this.o[n4] = this.b(x2, q2);
                c2.g();
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            ++n3;
        } while (n2 == 0);
    }

    private int a(r[] arrr) {
        int n2 = a.f;
        int n3 = 0;
        int n4 = 0;
        block0 : do {
            if (n4 >= arrr.length) return n3;
            r r2 = arrr[n4];
            y.c.C c2 = r2.b().m();
            while (c2.f()) {
                Q q2 = (Q)c2.d();
                this.i.put(q2, new Integer(n3++));
                this.j.put(q2, r2);
                c2.g();
                if (n2 != 0) continue block0;
                if (n2 == 0) continue;
            }
            ++n4;
        } while (n2 == 0);
        return n3;
    }

    void a(Q q2, q q3, y y2) {
        int n2 = (Integer)this.i.get(q2);
        double d2 = y.f.d.C.a(q2.d(), y2);
        double[] arrd = this.k;
        int n3 = n2;
        arrd[n3] = arrd[n3] + d2;
    }

    void a(Q q2, d d2, y.d.m m2) {
        int n2 = (Integer)this.i.get(q2);
        double d3 = y.f.d.C.a(q2.d(), m2);
        if (q2.e() != null && q2.e() instanceof C) {
            X x2;
            d d4;
            C c2 = (C)q2.e();
            if (d2.a() != null && d2.a() instanceof X && d2.equals(d4 = (x2 = (X)d2.a()).a(c2))) {
                d3 /= 2.0;
            }
        }
        double[] arrd = this.l;
        int n3 = n2;
        arrd[n3] = arrd[n3] + d3;
    }

    private double b(r[] arrr) {
        int n2 = a.f;
        double d2 = 0.0;
        int n3 = 0;
        do {
            Q q2;
            double d3;
            if (n3 >= arrr.length) return d2;
            D d4 = arrr[n3].b();
            if (!d4.isEmpty() && (d3 = (q2 = (Q)d4.f()).d().f() * q2.d().e()) > d2) {
                d2 = d3;
            }
            ++n3;
        } while (n2 == 0);
        return d2;
    }

    public void a(aH aH2) {
        this.p = aH2;
    }
}

