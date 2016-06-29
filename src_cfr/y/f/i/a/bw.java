/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.List;
import y.c.D;
import y.c.d;
import y.d.t;
import y.f.ax;
import y.f.i.a.L;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.S;
import y.f.i.a.Z;
import y.f.i.a.aU;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.y;

class bW
extends ab {
    private List b;
    private L c;
    private double d;

    bW() {
    }

    @Override
    protected void c() {
        super.c();
        this.b = null;
        this.c = null;
    }

    @Override
    protected void a(Z z2) {
        super.a(z2);
        this.c = z2.c().k();
        this.b = new D();
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.f(aa2);
    }

    private void f(aa aa2) {
        Object object;
        Object object22;
        List list;
        P p2;
        int n2;
        int n3 = ab.a;
        x x2 = this.b().d();
        double d2 = x2.d();
        int n4 = x2.f().j();
        boolean bl2 = n4 > 0 && d2 > 0.0;
        R r2 = aa2.g();
        this.b.clear();
        aU aU2 = this.a().a(aa2.c());
        List list2 = list = aU2 != null ? aU2.a(false) : null;
        if (list != null) {
            for (Object object22 : list) {
                n2 = object22.a();
                if (n3 == 0) {
                    if (n2 == 255) {
                        this.b.clear();
                        if (n3 == 0) break;
                    }
                    p2 = r2.a(S.a((ax)object22));
                    if (object22.b()) {
                        object = aU2.a((ax)object22, false);
                        double d3 = p2.a() ? object.b() : object.a();
                        this.b.add(new P(d3, d3, p2.f(), p2.a()));
                        if (n3 == 0) continue;
                    }
                    this.b.add(this.a(p2, bl2, d2));
                    if (n3 == 0) continue;
                }
                break;
            }
        } else {
            n2 = this.b.isEmpty();
        }
        if (n2 == 0) return;
        P p3 = r2.a(S.a);
        object22 = r2.a(S.b);
        p2 = r2.a(S.d);
        object = r2.a(S.c);
        this.b.add(this.a(p3, bl2, d2));
        this.b.add(this.a((P)object22, bl2, d2));
        this.b.add(this.a((P)object, bl2, d2));
        this.b.add(this.a(p2, bl2, d2));
    }

    private P a(P p2, boolean bl2, double d2) {
        if (!bl2) return p2;
        if (p2.d() <= 2.0 * d2) return p2;
        return new P(p2.b() + d2, p2.c() - d2, p2.f(), p2.a());
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        if (f2.d() == null) {
            this.b("distance penalty", 0.0, false);
            return new double[arrp.length];
        }
        this.d = 0.0;
        if (this.c == null) return super.a(f2, r2, arrp, arrv, arrd);
        if (arrv[0].c() != 3) return super.a(f2, r2, arrp, arrv, arrd);
        R r3 = f2.a();
        P p2 = this.a(r3, arrp[0].a());
        if (!this.c.a(p2)) return super.a(f2, r2, arrp, arrv, arrd);
        this.d += 2.0 * this.c.b(arrp[0].f(), p2);
        return super.a(f2, r2, arrp, arrv, arrd);
    }

    @Override
    protected double a(f f2, R r2, P p2, v v2, double d2) {
        double d3 = this.d;
        P p3 = this.d(f2);
        if (p3 != null) {
            P p4 = this.a(p2, p3);
            d3 += p3.a(p4);
        }
        double d4 = d3 / this.b().h();
        this.a("distance penalty", d4, false);
        return d4;
    }

    private P a(P p2, P p3) {
        if (p2.a() != p3.a()) return this.c(p3, p2);
        return this.b(p3, p2);
    }

    private P d(f f2) {
        P p2 = f2.h();
        if (p2 != null) return p2;
        p2 = this.e(f2);
        if (p2 == null) return f2.c();
        f2.b(p2);
        if (ab.a == 0) return p2;
        return f2.c();
    }

    private P e(f f2) {
        f f3 = f2.b();
        if (f3 == null) return null;
        P p2 = this.d(f3);
        P p3 = p2;
        if (p3 == null) return null;
        return this.a(f2.c(), p3);
    }

    @Override
    protected double b(f f2) {
        double d2;
        int n2 = ab.a;
        double d3 = 0.0;
        if (!this.b.isEmpty()) {
            d3 = Double.MAX_VALUE;
            P p2 = this.d(f2);
            for (P p3 : this.b) {
                double d4 = p2.a(p3);
                if (d4 >= d3) continue;
                d2 = d4;
                if (n2 == 0) {
                    d3 = d2;
                    if (n2 == 0) continue;
                }
                break;
            }
        } else {
            d2 = d3 / this.b().h();
        }
        double d5 = d2;
        this.a("HEUR distance penalty", d3 / this.b().h(), true);
        return d5;
    }

    private P b(P p2, P p3) {
        double d2 = p3.f();
        boolean bl2 = p3.a();
        if (p2.d() == 0.0) {
            double d3 = p3.e().c(p2.b());
            if (this.c == null) return new P(d3, d3, d2, bl2);
            if (!this.c.a(p3)) return new P(d3, d3, d2, bl2);
            d3 = this.c.a(d3, p3);
            return new P(d3, d3, d2, bl2);
        }
        M m2 = M.a(p2.e(), p3.e());
        if (m2 == null) {
            double d4 = p2.b() > p3.c() ? p2.b() : p2.c();
            double d5 = p3.e().c(d4);
            if (this.c == null) return new P(d5, d5, d2, bl2);
            if (!this.c.a(p3)) return new P(d5, d5, d2, bl2);
            d5 = this.c.a(d5, p3);
            return new P(d5, d5, d2, bl2);
        }
        if (this.c == null) {
            return new P(m2, d2, bl2);
        }
        if (!this.c.a(m2, !bl2)) {
            if (!this.c.a(p3)) return new P(m2, d2, bl2);
            double d6 = this.c.a(p2.b(), p3);
            return new P(d6, d6, d2, bl2);
        }
        M m3 = this.c.b(m2, !bl2);
        return new P(m3, d2, bl2);
    }

    private P c(P p2, P p3) {
        double d2 = p3.e().c(p2.f());
        if (this.c == null) return new P(d2, d2, p3.f(), p3.a());
        if (!this.c.a(p3)) return new P(d2, d2, p3.f(), p3.a());
        d2 = this.c.a(d2, p3);
        return new P(d2, d2, p3.f(), p3.a());
    }

    private P a(R r2, boolean bl2) {
        S s2 = bl2 ? S.a : S.d;
        return r2.a(s2);
    }
}

