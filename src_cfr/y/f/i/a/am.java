/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.List;
import y.c.d;
import y.c.q;
import y.d.t;
import y.f.X;
import y.f.i.a.H;
import y.f.i.a.I;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.V;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ad;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.x;
import y.f.y;

class aM
extends ab
implements H {
    private double b;
    private double c;
    private double d;
    private boolean e;
    private int f;
    private boolean g = false;

    aM() {
    }

    @Override
    protected void b(aa aa2) {
        super.b(aa2);
        this.b = aa2.d().d();
        this.f = aa2.d().f().j();
        this.g = this.f > 0 && this.b > 0.0;
        if (!this.g) return;
        aa2.a().a(this);
    }

    @Override
    protected void c(aa aa2) {
        super.c(aa2);
        if (!this.g) return;
        aa2.a().b(this);
    }

    @Override
    protected void d(aa aa2) {
        super.d(aa2);
        if (!this.g) return;
        aa2.a().b(this);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected double a(f var1_1) {
        if (!this.g) {
            return 0.0;
        }
        if (this.b().b(var1_1.a()) != false) return 0.0;
        if (!this.b().b(var1_1.b().a())) {
            return 0.0;
        }
        var2_2 = this.a().a();
        var3_3 = this.b().c();
        var4_4 = var2_2.s(var3_3.c());
        var5_5 = var1_1.c();
        if (!var5_5.a()) ** GOTO lbl-1000
        var6_6 = var4_4.d() + this.b;
        var8_7 = var4_4.d() + var4_4.b() - this.b;
        if (ab.a != 0) lbl-1000: // 2 sources:
        {
            var6_6 = var4_4.c() + this.b;
            var8_7 = var4_4.c() + var4_4.a() - this.b;
        }
        if (var5_5.b() + 1.0E-6 < var6_6) return this.f;
        if (var5_5.c() - 1.0E-6 <= var8_7) return 0.0;
        return this.f;
    }

    @Override
    protected void a(List list) {
        int n2 = ab.a;
        if (!this.g) {
            return;
        }
        X x2 = this.a().a();
        aa aa2 = this.b();
        d d2 = aa2.c();
        y.d.y y2 = x2.s(d2.c());
        int n3 = 0;
        int n4 = aa2.e();
        do {
            int n5 = n3;
            block1 : do {
                if (n5 >= n4) return;
                R r2 = aa2.a(n3);
                f f2 = new f(r2);
                List list2 = this.a().c().r().c(r2);
                for (R r3 : list2) {
                    double d3;
                    double d4;
                    f f3;
                    y y3;
                    P p2;
                    if (aa2.b(r3)) continue;
                    P p3 = V.a(r2, r3);
                    n5 = (int)p3.a() ? 1 : 0;
                    if (n2 != 0) continue block1;
                    if (n5 != 0) {
                        if (y2.b() <= 2.0 * this.b || (d4 = Math.max(p3.b(), y2.d() + this.b)) >= (d3 = Math.min(p3.c(), y2.d() + y2.b() - this.b))) continue;
                        p2 = new P(d4, d3, p3.f(), true);
                        y3 = V.a(f2, r3);
                        f3 = new f(r3);
                        f3.a(f2);
                        f3.a(p2);
                        f3.a(y3);
                        list.add(f3);
                        if (n2 == 0) continue;
                    }
                    if (y2.a() <= 2.0 * this.b || (d4 = Math.max(p3.b(), y2.c() + this.b)) >= (d3 = Math.min(p3.c(), y2.c() + y2.a() - this.b))) continue;
                    p2 = new P(d4, d3, p3.f(), false);
                    y3 = V.a(f2, r3);
                    f3 = new f(r3);
                    f3.a(f2);
                    f3.a(p2);
                    f3.a(y3);
                    list.add(f3);
                    if (n2 == 0) continue;
                }
                break;
            } while (true);
            ++n3;
        } while (n2 == 0);
    }

    @Override
    double[] a(f f2, R r2, P[] arrp, v[] arrv, double[] arrd) {
        R r3;
        d d2;
        if (!this.g) {
            this.b("min node corner dist penalty", 0.0, false);
            return new double[arrp.length];
        }
        X x2 = this.a().a();
        y.d.y y2 = x2.s((d2 = this.b().c()).d());
        boolean bl2 = this.e = !aM.a(y2, r3 = f2.a()) && aM.a(y2, r2);
        if (!this.e) {
            this.b("min node corner dist penalty", 0.0, false);
            return new double[arrp.length];
        }
        if (arrp[0].a()) {
            this.c = y2.d() + this.b;
            this.d = y2.d() + y2.b() - this.b;
            if (ab.a == 0) return super.a(f2, r2, arrp, arrv, arrd);
        }
        this.c = y2.c() + this.b;
        this.d = y2.c() + y2.a() - this.b;
        return super.a(f2, r2, arrp, arrv, arrd);
    }

    @Override
    protected double a(f f2, R r2, P p2, v v2, double d2) {
        int n2 = 0;
        if (this.e && (p2.b() + 1.0E-6 < this.c || p2.c() - 1.0E-6 > this.d)) {
            n2 += this.f;
        }
        this.a("min node corner dist penalty", n2, false);
        return n2;
    }

    @Override
    public void a(f f2, R r2, P p2, List list, aa aa2) {
        if (this.b <= 0.0) {
            return;
        }
        X x2 = this.a().a();
        d d2 = aa2.c();
        P p3 = null;
        y.d.y y2 = x2.s(d2.d());
        if (aM.a(y2, f2.a())) return;
        if (aM.a(y2, r2)) {
            double d3;
            double d4;
            if (p2.a()) {
                double d5;
                double d6;
                if (y2.b() > 2.0 * this.b && (d5 = Math.max(p2.b(), y2.d() + this.b)) < (d6 = Math.min(p2.c(), y2.d() + y2.b() - this.b))) {
                    p3 = new P(d5, d6, p2.f(), true);
                }
            } else if (y2.a() > 2.0 * this.b && (d3 = Math.max(p2.b(), y2.c() + this.b)) < (d4 = Math.min(p2.c(), y2.c() + y2.a() - this.b))) {
                p3 = new P(d3, d4, p2.f(), false);
            }
        }
        if (p3 == null) return;
        list.add(p3);
    }

    private static boolean a(y.d.y y2, R r2) {
        t t2 = y2.e();
        t t3 = new t(y2.c + y2.a, y2.d + y2.b);
        if (t2.a - 1.0E-6 >= r2.h()) return false;
        if (t2.b - 1.0E-6 >= r2.i()) return false;
        if (t3.a + 1.0E-6 <= r2.j()) return false;
        if (t3.b + 1.0E-6 <= r2.k()) return false;
        return true;
    }
}

