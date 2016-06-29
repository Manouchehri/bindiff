/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import java.util.Iterator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.i;
import y.c.x;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.a.G;
import y.f.a.f;
import y.f.a.g;
import y.f.a.k;
import y.f.a.l;
import y.f.a.m;
import y.f.a.n;
import y.f.a.o;
import y.f.a.p;
import y.f.a.q;
import y.f.a.r;
import y.f.ae;
import y.f.e.a.J;
import y.f.e.a.Y;
import y.f.e.a.aj;
import y.f.e.a.am;
import y.f.e.a.av;
import y.f.e.a.aw;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.f.e.a.h;
import y.f.j.a;
import y.g.I;
import y.g.ar;
import y.g.e;

class j
extends f {
    private A v;
    private A w;
    private y.c.y x;
    private av y;
    private int z;
    private double A;
    private y.c.y B;
    private boolean C = false;
    private y.c.y D = new y.c.y();

    j() {
    }

    public void i(boolean bl2) {
        this.C = bl2;
    }

    public y.c.y p() {
        return this.D;
    }

    public void a(y.c.y y2) {
        this.x = y2;
    }

    public void a(ay ay2, long l2) {
        ((y.f.e.a.o)ay2.z()).a(l2);
    }

    @Override
    double a(x x2, double d2) {
        double d3;
        ay ay2;
        h h2;
        block4 : {
            this.A = Math.max(this.s / 6.283185307179586, d2);
            if (this.x == null) {
                this.x = new y.c.y();
            }
            int n2 = Math.max(this.x.size(), (int)(4.0 * (Math.sqrt(this.n.e()) - 1.0) + 1.0));
            this.z = this.n.e();
            this.B = new y.c.y(x2);
            if (this.n.e() <= 8 || this.n.e() <= n2 - 1) {
                double d4 = 3.141592653589793 / (double)this.n.e();
                this.a(d4);
                this.D = this.B;
                return super.a(this.B.a(), d2);
            }
            this.v = this.n.t();
            ay2 = new ay(false);
            h2 = new h();
            ay2.a(h2);
            ay2.h(true);
            long l2 = Math.max((long)(1000.0 * Math.pow(this.n.e() - this.D.size(), 0.75)), 500);
            y.f.e.a.o o2 = new y.f.e.a.o();
            o2.a(l2);
            o2.a(0.05);
            o2.b(0.03);
            ay2.a(o2);
            ay2.a(new n());
            ay2.a(new r(this));
            if (this.C) {
                d3 = this.a(ay2, h2);
                if (f.u == 0) break block4;
            }
            d3 = this.a(ay2, d2, n2, h2);
        }
        d3 = this.a(ay2, d3, h2, this.p);
        this.n.a(this.v);
        return d3;
    }

    /*
     * Unable to fully structure code
     */
    private double a(ay var1_1, h var2_2) {
        var16_3 = f.u;
        if (!this.t) {
            this.D = new y.c.y();
            var3_4 = new y.c.f();
            if (!y.a.g.c(this.n)) {
                var3_4 = y.a.h.b(this.n);
            }
            var4_5 = new y.f.e.q();
            var4_5.b(0.3);
            var4_5.h(true);
            var4_5.g(true);
            var4_5.a(0.5);
            var4_5.c(this.p);
            var4_5.d(this.p);
            var4_5.m();
            var4_5.c(this.n);
            if (var3_4.size() > 0) {
                var5_6 = var3_4.a();
                while (var5_6.f()) {
                    var6_8 = var5_6.a();
                    this.n.a(var6_8);
                    var5_6.g();
                    if (var16_3 == 0) {
                        if (var16_3 == 0) continue;
                    }
                    break;
                }
            } else if (!this.q) {
                var5_7 = this.s();
                var7_10 = new a();
                var7_10.b(this.o / var5_7);
                var7_10.a(this.n);
            }
        }
        var3_4 = new G();
        var3_4.a(this.v);
        var3_4.a(this.q);
        var4_5 = ae.a(this.n, this.n.o());
        var5_6 = new t(var4_5.getCenterX(), var4_5.getCenterY());
        var6_9 = var5_6.a();
        var8_11 = var5_6.b();
        var10_12 = this.n.o();
        while (var10_12.f()) {
            var11_14 = var10_12.e();
            this.n.d(var11_14, - var6_9, - var8_11);
            var10_12.g();
            if (var16_3 == 0) {
                if (var16_3 == 0) continue;
            }
            ** GOTO lbl-1000
        }
        if (this.t) ** GOTO lbl-1000
        var3_4.a(this.r);
        var3_4.b(false);
        if (var16_3 != 0) lbl-1000: // 3 sources:
        {
            var10_13 = var4_5.getHeight() / 2.0;
            var12_15 = var4_5.getWidth() / 2.0;
            var14_16 = Math.sqrt(var10_13 * var10_13 + var12_15 * var12_15);
            var3_4.a(var14_16);
            var3_4.b(false);
        }
        if (!this.q) {
            var3_4.b(this.o);
        }
        var3_4.c(this.n);
        this.D = var3_4.a();
        return var3_4.b();
    }

    /*
     * Unable to fully structure code
     */
    private double a(ay var1_1, double var2_2, int var4_3, h var5_4) {
        this.w = this.n.t();
        var8_5 = this.o();
        if (!this.t || !(var8_5 instanceof g)) ** GOTO lbl-1000
        this.t();
        var9_6 = this.D.b();
        var10_8 = ((g)var8_5).a().a();
        var12_10 = ((g)var8_5).a().b();
        var14_11 = Math.atan2(this.n.k((y.c.q)var9_6) - var12_10, this.n.j((y.c.q)var9_6) - var10_8);
        this.a(var14_11);
        var6_12 = super.a(this.D.a(), var2_2);
        if (f.u != 0) lbl-1000: // 2 sources:
        {
            this.a(var4_3, this.n.e());
            var9_7 = 3.141592653589793 / (double)this.D.a().k();
            this.a(var9_7);
            var6_12 = super.a(this.D.a(), var2_2);
        }
        this.q();
        this.y = new l(this);
        this.y.b(var6_12);
        this.y.a(0.2 * var6_12);
        var9_6 = new J(this.y, J.d, 0.0, 1.0);
        var9_6.c(1.0);
        var9_6.a(J.c);
        var1_1.a((ax)var9_6);
        var10_9 = new q(this);
        var1_1.c(var10_9);
        var10_9.b(var6_12);
        var10_9.a(0.2 * var6_12);
        var1_1.b((double)this.p);
        var1_1.a((double)this.p);
        var5_4.a(2.0);
        var1_1.a(this.n);
        var1_1.d(var10_9);
        var1_1.b((ax)var9_6);
        this.n.a(this.w);
        var6_12 = this.s();
        var11_13 = Math.max(this.r / 2.0, (double)this.p);
        this.a(var6_12, var11_13);
        this.r();
        var13_14 = this.D.b();
        var14_11 = Math.atan2(this.n.k(var13_14), this.n.j(var13_14));
        this.a(var14_11);
        return super.a(this.D.a(), var6_12);
    }

    /*
     * Unable to fully structure code
     */
    private double a(ay var1_1, double var2_2, h var4_3, double var5_4) {
        block11 : {
            block10 : {
                var28_5 = f.u;
                if (this.q && this.t) {
                    var2_2 = Math.max(var2_2, this.s / 6.283185307179586);
                }
                if (this.q && var2_2 > this.A) {
                    var7_6 = this.A / var2_2;
                    var9_8 = new a();
                    var9_8.b(var7_6);
                    var9_8.g(false);
                    var9_8.a(this.n);
                    var2_2 = this.A;
                }
                var4_3.c(3.0);
                var1_1.a(var5_4);
                var1_1.b(var5_4);
                var7_7 = new J(new aj(), J.a, 0.0, Math.max(var5_4, this.r));
                ((aj)var7_7.b()).a(var5_4);
                var7_7.c(0.25);
                var7_7.a(J.j);
                var1_1.a(var7_7);
                this.y = new av();
                var8_9 = Math.max(var5_4 / 2.0, this.r / 2.0);
                this.y.b(var2_2 - var8_9);
                this.y.a(var8_9);
                var10_10 = new J(this.y, J.d, 0.0, 1.0);
                var1_1.a(var10_10);
                var10_10.c(1.0);
                if (this.q && !this.C) {
                    var11_11 = var1_1.s().e();
                    if (var28_5 == 0) break block10;
                }
                var11_11 = (long)(1000.0 * Math.pow(this.n.e() - this.D.size(), 0.75));
            }
            this.a(var1_1, Math.max(200, var11_11));
            var1_1.a(this.n);
            if (this.q) {
                var13_12 = new ar(42);
                var14_14 = new y.f.e.k(var13_12, var5_4);
                var14_14.c(this.n);
            }
            var13_13 = var2_2;
            var2_2 = this.s();
            this.a(var2_2, this.r / 2.0);
            var15_15 = this.D.b();
            var16_16 = Math.atan2(this.n.k(var15_15), this.n.j(var15_15));
            if (!this.q) ** GOTO lbl-1000
            this.a(var16_16);
            var2_2 = super.a(this.D.a(), var2_2);
            if (var28_5 != 0) lbl-1000: // 2 sources:
            {
                this.a(var16_16);
                super.b(this.D.a(), 0.0);
            }
            var18_17 = 0.0;
            var20_18 = this.D.a();
            while (var20_18.f()) {
                var21_20 = this.n.s(var20_18.e());
                var18_17 = Math.max(var18_17, var21_20.b());
                v0 = Math.max(var18_17, var21_20.a());
                if (var28_5 == 0) {
                    var18_17 = v0;
                    var20_18.g();
                    if (var28_5 == 0) continue;
                }
                break block11;
            }
            v0 = (var2_2 - var18_17) / var13_13;
        }
        if ((var20_19 = v0) > 1.0) {
            this.e(var20_19);
        }
        if (this.q == false) return var2_2;
        var22_21 = this.c(this.n.o(), var5_4);
        this.a(var22_21, var5_4);
        var13_13 = var2_2;
        var23_22 = Math.max(var18_17 / 5.0, 5.0);
        var25_23 = 0;
        do {
            if (var22_21.isEmpty() != false) return var2_2;
            if (var25_23++ >= 5) return var2_2;
            var26_24 = var13_13 + var23_22;
            this.d(var26_24 / var13_13);
            this.a(var22_21, var5_4);
            var13_13 = var26_24;
        } while (var28_5 == 0);
        return var2_2;
    }

    private void d(double d2) {
        int n2 = f.u;
        x x2 = this.n.o();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            double d3 = this.n.j(q2);
            double d4 = this.n.k(q2);
            this.n.a(q2, d3 * d2, d4 * d2);
            x2.g();
        } while (n2 == 0);
    }

    private static y a(y y2, double d2) {
        return new y(y2.c() - d2, y2.d() - d2, y2.a() + 2.0 * d2, y2.b() + 2.0 * d2);
    }

    private void a(D d2, double d3) {
        int n2 = f.u;
        C c2 = d2.m();
        do {
            if (!c2.f()) return;
            p p2 = (p)c2.d();
            if (!p2.a(d3)) {
                d2.b(c2);
            }
            c2.g();
        } while (n2 == 0);
    }

    private D c(x x2, double d2) {
        Object object;
        int n2 = f.u;
        D d3 = new D();
        double d4 = d2 * 0.5;
        while (x2.f()) {
            object = x2.e();
            d3.add(new m((y.c.q)object, j.a(this.n.s((y.c.q)object), d4)));
            x2.g();
            if (n2 == 0) continue;
        }
        object = new o(this);
        y.d.f.a(d3, (y.d.g)object);
        return object.a();
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, int var2_2) {
        block19 : {
            block17 : {
                var16_3 = f.u;
                var3_4 = this.n.t();
                var4_5 = this.n.e();
                if (this.x != null) {
                    for (Object var6_7 : this.x) {
                        v0 = this;
                        if (var16_3 == 0) {
                            v0.v.a(var6_7, true);
                            if (var16_3 == 0) continue;
                        }
                        break;
                    }
                } else {
                    v0 = this;
                }
                var5_6 = v0.B.e();
                var6_7 = this.n.t();
                var7_8 = 0;
                var8_9 = this.B.a();
                while (var8_9.f()) {
                    var9_11 = var8_9.e();
                    var6_7.a((Object)var9_11, var7_8);
                    var8_9.g();
                    ++var7_8;
                    if (var16_3 == 0) continue;
                }
                var8_10 = y.a.A.b(this.n);
                var9_12 = 0;
                block2 : do {
                    v1 = var9_12;
                    v2 = var5_6.length;
                    block3 : while (v1 < v2) {
                        var10_13 = var5_6[var9_12];
                        v3 = this.v.d(var10_13);
                        if (var16_3 != 0) break block17;
                        if (v3 == 0) ** GOTO lbl34
                        var3_4.a((Object)var10_13, -1);
                        if (var16_3 == 0) ** GOTO lbl54
lbl34: // 2 sources:
                        if (!var8_10 || var10_13.a() != 1) ** GOTO lbl-1000
                        var3_4.a((Object)var10_13, 0);
                        if (var16_3 != 0) lbl-1000: // 2 sources:
                        {
                            var11_16 = 0;
                            var12_20 = var10_13.j();
                            while (var12_20.f()) {
                                block18 : {
                                    var13_21 = var12_20.a();
                                    var14_22 = var6_7.a(var13_21.a(var10_13));
                                    v1 = var9_12;
                                    v2 = var14_22;
                                    if (var16_3 != 0) continue block3;
                                    if (v1 > v2) {
                                        var15_23 = Math.min(var9_12 - var14_22, var14_22 + var4_5 - var9_12) - 1;
                                        if (var16_3 == 0) break block18;
                                    }
                                    var15_23 = Math.min(var14_22 - var9_12, var4_5 + var9_12 - var14_22) - 1;
                                }
                                var11_16 += var15_23;
                                var12_20.g();
                                if (var16_3 == 0) continue;
                            }
                            var3_4.a((Object)var10_13, var11_16);
                        }
lbl54: // 4 sources:
                        ++var9_12;
                        if (var16_3 == 0) continue block2;
                    }
                    break block2;
                    break;
                } while (true);
                e.a(var5_6, e.b(var3_4));
                var9_12 = 0;
                v3 = var10_14 = 0;
            }
            while (var10_14 < var2_2) {
                var11_18 = var5_6[var10_14];
                if (var9_12 < var1_1 || var3_4.a(var11_18) <= 0) {
                    this.v.a(var11_18, true);
                    ++var9_12;
                }
                ++var10_14;
                if (var16_3 == 0) continue;
            }
            var10_15 = new y.c.y();
            var11_19 = this.B.a();
            while (var11_19.f()) {
                var12_20 = var11_19.e();
                v4 = (int)this.v.d(var12_20) ? 1 : 0;
                if (var16_3 == 0) {
                    if (v4 != 0) {
                        var10_15.add(var12_20);
                    }
                    var11_19.g();
                    if (var16_3 == 0) continue;
                }
                break block19;
            }
            this.D = var10_15;
            v4 = this.D.size();
        }
        if (v4 <= var2_2) {
            this.r();
        }
        this.n.a(var3_4);
        this.n.a((A)var6_7);
    }

    /*
     * Unable to fully structure code
     */
    private void r() {
        var10_1 = f.u;
        if (this.D.size() >= this.z) {
            return;
        }
        var1_2 = new y.c.y();
        var2_3 = this.n.o();
        while (var2_3.f()) {
            var3_5 = var2_3.e();
            v0 = this.v.d(var3_5);
            if (var10_1 == 0) {
                if (!v0) {
                    var1_2.add(var3_5);
                }
                var2_3.g();
                if (var10_1 == 0) continue;
            }
            ** GOTO lbl17
        }
        do {
            v0 = false;
lbl17: // 2 sources:
            var2_4 = v0;
            v1 = var3_5 = var1_2.a();
            while (var3_5.f()) {
                block12 : {
                    var4_6 = var3_5.e();
                    var5_7 = new y.c.y();
                    v1 = var4_6.m();
                    if (var10_1 != 0) continue;
                    var6_8 = v1;
                    while (var6_8.f()) {
                        var7_9 = var6_8.e();
                        v2 = (int)this.v.d(var7_9) ? 1 : 0;
                        if (var10_1 == 0) {
                            if (v2 != 0) {
                                var5_7.add(var7_9);
                            }
                            var6_8.g();
                            if (var10_1 == 0) continue;
                        }
                        break block12;
                    }
                    v2 = var5_7.size();
                }
                if (v2 != 2) ** GOTO lbl52
                var6_8 = var5_7.b();
                var7_9 = var5_7.c();
                var8_10 = this.D.d(var6_8);
                var9_11 = this.D.d(var7_9);
                if (this.D.e(var8_10) != var9_11) ** GOTO lbl-1000
                this.D.b(var4_6, var8_10);
                this.v.a((Object)var4_6, true);
                var1_2.remove(var4_6);
                var2_4 = true;
                if (var10_1 != 0) lbl-1000: // 2 sources:
                {
                    if (this.D.e(var9_11) == var8_10) {
                        this.D.b(var4_6, var9_11);
                        this.v.a((Object)var4_6, true);
                        var1_2.remove(var4_6);
                        var2_4 = true;
                    }
                }
lbl52: // 6 sources:
                if (this.D.size() >= this.z) {
                    return;
                }
                var3_5.g();
                if (var10_1 == 0) continue;
            }
        } while (var2_4);
    }

    private void e(double d2) {
        int n2 = f.u;
        x x2 = this.n.o();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            if (!this.v.d(q2)) {
                double d3 = this.n.j(q2);
                double d4 = this.n.k(q2);
                this.n.a(q2, d3 * d2, d4 * d2);
            }
            x2.g();
        } while (n2 == 0);
    }

    private double s() {
        double d2;
        int n2 = f.u;
        double d3 = 0.0;
        x x2 = this.n.o();
        while (x2.f()) {
            y.c.q q2 = x2.e();
            double d4 = this.n.j(q2);
            double d5 = this.n.k(q2);
            d2 = Math.max(d3, Math.sqrt(d4 * d4 + d5 * d5));
            if (n2 != 0) return d2;
            d3 = d2;
            x2.g();
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    private void a(double d2, double d3) {
        int n2 = f.u;
        y.c.y y2 = new y.c.y();
        x x2 = this.n.o();
        while (x2.f()) {
            y.c.q q2 = x2.e();
            double d4 = this.n.j(q2);
            double d5 = this.n.k(q2);
            double d6 = Math.sqrt(d4 * d4 + d5 * d5);
            if (n2 != 0) return;
            if (d6 >= d2 - d3) {
                this.v.a((Object)q2, true);
            }
            if (this.v.d(q2)) {
                y2.add(q2);
            }
            x2.g();
            if (n2 == 0) continue;
        }
        e.a(y2, (Comparator)new k(this));
        this.D = y2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    void b(x var1_1, double var2_2) {
        this.v = this.n.t();
        this.B = new y.c.y(var1_1);
        var4_3 = new ay(false);
        var5_4 = new h();
        var4_3.a(var5_4);
        var4_3.h(true);
        var4_3.a(new n());
        var4_3.a(new r(this));
        this.z = this.n.e();
        if (this.C) ** GOTO lbl-1000
        this.a(8, this.z);
        if (this.n.e() <= 8 || this.n.e() <= this.D.size()) {
            var6_5 = 3.141592653589793 / (double)this.n.e();
            this.a(var6_5);
            super.b(this.B.a(), 0.0);
            this.D = this.B;
            return;
        }
        var6_6 = 3.141592653589793 / (double)this.D.size();
        this.a(var6_6);
        super.b(this.D.a(), 0.0);
        this.q();
        this.a(var4_3, this.o, var5_4, this.o / Math.sqrt(this.n.e()));
        if (f.u != 0) lbl-1000: // 2 sources:
        {
            this.a(var4_3, var5_4);
            this.a(var4_3, this.o, var5_4, this.o / Math.sqrt(this.n.e()));
        }
        this.n.a(this.v);
    }

    void q() {
        int n2 = f.u;
        x x2 = this.n.o();
        do {
            if (!x2.f()) return;
            y.c.q q2 = x2.e();
            if (!this.v.d(q2)) {
                this.n.a(q2, 0.0, 0.0);
            }
            x2.g();
        } while (n2 == 0);
    }

    private void t() {
        Object object;
        Object object2;
        int n2;
        t t2;
        block20 : {
            double d2;
            double d3;
            block19 : {
                double d4;
                double d5;
                double d6;
                double d7;
                Object object3;
                Object object4;
                block18 : {
                    double d8;
                    n2 = f.u;
                    t2 = this.b(this.n.o());
                    d5 = 0.0;
                    d7 = 0.0;
                    d6 = this.n.e();
                    x x2 = this.n.o();
                    while (x2.f()) {
                        y.c.q q2 = x2.e();
                        d4 = t2.a(this.n.l(q2));
                        d5 += d4;
                        d8 = d7 + d4 * d4;
                        if (n2 == 0) {
                            d7 = d8;
                            x2.g();
                            if (n2 == 0) continue;
                        }
                        break block18;
                    }
                    d8 = d2 = d5 / d6;
                }
                if ((d4 = (d6 * d7 - d5 * d5) / (d6 * (d6 - 1.0))) < 0.0) {
                    d4 = 0.0;
                }
                double d9 = Math.sqrt(d4);
                y.c.y y2 = new y.c.y();
                if (d9 > 0.1) {
                    object3 = this.n.o();
                    while (object3.f()) {
                        object4 = object3.e();
                        double d10 = t2.a(this.n.l((y.c.q)object4));
                        if (d10 < d2 - 2.0 * d9 || d10 > d2 + 2.0 * d9) {
                            y2.add(object4);
                        }
                        object3.g();
                        if (n2 == 0) continue;
                    }
                }
                object3 = new I(this.n);
                object3.a(y2);
                object4 = new G();
                object4.b(true);
                object4.a(t2);
                object4.a(this.v);
                object4.a(false);
                object4.b(d2);
                object4.a(d2);
                object4.b(true);
                object4.c(this.n);
                y.c.y y3 = object4.a();
                object3.f();
                t2 = this.b(y3.a());
                d5 = 0.0;
                d6 = y3.size();
                object2 = y3.a();
                while (object2.f()) {
                    object = object2.e();
                    d3 = t2.a(this.n.l((y.c.q)object));
                    d5 += d3;
                    object2.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block19;
                }
                d2 = d5 / d6;
            }
            object2 = this.n.o();
            while (object2.f()) {
                object = object2.e();
                d3 = t2.a(this.n.l((y.c.q)object));
                if (n2 == 0) {
                    if (d3 >= d2 - this.r) {
                        this.v.a(object, true);
                    }
                    object2.g();
                    if (n2 == 0) continue;
                }
                break block20;
            }
            if (this.x != null) {
                object2 = this.x.iterator();
                while (object2.hasNext()) {
                    object = (y.c.q)object2.next();
                    this.v.a(object, true);
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break;
                }
            } else {
                this.D = new y.c.y();
            }
        }
        if ((object2 = this.o()) instanceof g) {
            ((g)object2).a(new t(t2.a(), t2.b()));
        }
        this.B = new y.c.y(object2.a(this.n));
        object = this.B.a();
        do {
            if (!object.f()) return;
            y.c.q q3 = object.e();
            if (this.v.d(q3)) {
                this.D.b(q3);
            }
            object.g();
        } while (n2 == 0);
    }

    private t b(x x2) {
        int n2 = f.u;
        double d2 = 0.0;
        double d3 = 0.0;
        x2.i();
        while (x2.f()) {
            y.c.q q2 = x2.e();
            d2 += this.n.j(q2);
            d3 += this.n.k(q2);
            x2.g();
            if (n2 != 0) return new t(d2, d3);
            if (n2 == 0) continue;
        }
        d2 /= (double)x2.k();
        d3 /= (double)x2.k();
        return new t(d2, d3);
    }

    static y.c.y a(j j2) {
        return j2.D;
    }

    static A b(j j2) {
        return j2.w;
    }

    static A c(j j2) {
        return j2.v;
    }

    static av d(j j2) {
        return j2.y;
    }
}

