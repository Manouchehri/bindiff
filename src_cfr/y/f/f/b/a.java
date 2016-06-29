/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.A;
import y.c.i;
import y.c.q;
import y.c.x;
import y.f.O;
import y.f.U;
import y.f.X;
import y.f.ad;
import y.f.ae;
import y.f.f.a.b.f;
import y.f.f.a.b.w;
import y.f.f.b.b;
import y.f.f.b.c;
import y.f.f.b.d;
import y.f.f.b.e;
import y.f.f.b.h;
import y.f.f.b.k;
import y.f.f.b.m;
import y.f.f.b.o;
import y.f.f.b.p;
import y.f.f.d.C;
import y.f.f.d.t;
import y.f.h.D;
import y.f.h.N;
import y.g.M;
import y.g.al;

public class a
extends y.f.c {
    protected D n = null;
    protected boolean o = false;
    protected boolean p = false;
    protected boolean q = true;
    protected boolean r = false;
    protected boolean s = false;
    protected int t;
    protected y.f.h.o u;
    protected b v;
    protected p w;
    protected d x;
    protected e y;
    protected y.f.e z = null;
    private y.f.f.a.b.a A;
    private m B = null;
    private al C = new al();
    private y.f.f.a D = new y.f.f.a();

    public a() {
        this.f(false);
        this.b(false);
        this.z = new y.f.e();
        this.d(this.z);
        this.e(true);
        this.y = new e();
        this.c(false);
    }

    public void a(y.f.f.a a2) {
        this.D = a2;
    }

    public void a(y.f.f.a.b.a a2) {
        this.A = a2;
    }

    public void a(int n2) {
        this.z.a(n2);
        this.t = n2;
    }

    public void g(boolean bl2) {
        this.p = bl2;
    }

    public void h(boolean bl2) {
        this.q = bl2;
    }

    public boolean a() {
        return this.r;
    }

    public void i(boolean bl2) {
        this.r = bl2;
    }

    public boolean n() {
        return this.s;
    }

    public void j(boolean bl2) {
        this.s = bl2;
    }

    public void a(y.f.h.o o2) {
        this.u = o2;
    }

    public y.f.h.o o() {
        return this.u;
    }

    public void a(b b2) {
        this.v = b2;
    }

    public void a(p p2) {
        this.w = p2;
    }

    public p p() {
        return this.w;
    }

    public void a(d d2) {
        this.x = d2;
    }

    public void a(e e2) {
        this.y = e2;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    private boolean q() {
        boolean bl2 = false;
        if (!(this.p() instanceof t)) return bl2;
        t t2 = (t)this.p();
        if (t2.c() != 0) return bl2;
        return true;
    }

    @Override
    protected void a(O o2, Object object) {
    }

    @Override
    protected void b(O o2, Object object) {
    }

    private y.f.f.a a(y.c.d d2, h h2) {
        D d3 = (D)h2.b();
        y.c.d d4 = d3.n(d2) ? d3.d(d3.h(d2)) : d3.d(d2);
        if (d4 == null) return this.D;
        if (d2.a() == null) return this.D;
        y.c.c c2 = d2.a().c(y.f.f.c.n);
        if (c2 == null) return this.D;
        if (c2.b(d4) == null) return this.D;
        return (y.f.f.a)c2.b(d4);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(X var1_1) {
        block32 : {
            block31 : {
                block30 : {
                    var23_2 = h.a;
                    y.g.o.a(this, 1, "---->> Starting Layout algorithm:");
                    this.B = new m();
                    var2_3 = new al();
                    this.a((i)var1_1);
                    if (var1_1.h() == 0) {
                        var1_1.a(var1_1.o().e(), 0.0, 0.0);
                        return;
                    }
                    var3_4 = new y.c.f(var1_1.p());
                    var4_5 = null;
                    var5_6 = this.o != false ? this.n : new D(var1_1);
                    var6_7 = new C();
                    if (this.n() && this.q()) {
                        var6_7.a(var1_1, this.t);
                    }
                    if (this.a() && (var7_8 = var1_1.c(U.a)) != null) {
                        this.y.a(var5_6, (y.c.c)var7_8, this.t);
                    }
                    y.a.a.a("before phase 1");
                    var7_8 = new c();
                    var8_9 = new k();
                    var8_9.a(this.t);
                    if (!this.o) {
                        if (this.q) {
                            var7_8.a(var1_1);
                        }
                        if (this.p) {
                            var8_9.a(var1_1);
                        }
                        this.C.e();
                        this.u.a(var5_6);
                        if (var1_1.h() != 0) {
                            this.u.c();
                        }
                        this.B.b = (int)this.C.d();
                        this.B.o = var5_6.a();
                        this.a((i)var1_1);
                    }
                    y.a.a.a("before phase 2");
                    if (this.x != null) {
                        this.x.a(this.t);
                        this.x.a(var5_6);
                        this.x.a();
                        var5_6 = this.x.b();
                        if (this.y instanceof f && (var9_10 = var1_1.c(U.a)) != null) {
                            ((f)this.y).a(this.A, var5_6, (y.c.c)var9_10, var3_4);
                        }
                        var4_5 = new h(var5_6);
                    } else {
                        var4_5 = new h(var5_6);
                    }
                    this.C.e();
                    this.v.a(var4_5);
                    if (var4_5.a().h() != 0) {
                        this.v.a();
                    }
                    this.B.f = (int)this.C.d();
                    if (!this.o) {
                        if (this.p) {
                            var8_9.a(var4_5);
                            var8_9.a();
                        }
                        if (this.q) {
                            var7_8.a(var4_5);
                            var7_8.a();
                        }
                    }
                    this.B.p = this.v.b();
                    this.a((i)var1_1);
                    y.a.a.a("before phase 3");
                    var9_10 = var4_5.a().n();
                    for (var10_11 = 0; var10_11 < var9_10.length; ++var10_11) {
                        var11_13 = var9_10[var10_11];
                        v0 = var4_5;
                        if (var23_2 == 0) {
                            if (v0.c((y.c.d)var11_13)) continue;
                            var4_5.n((y.c.d)var11_13);
                            if (var23_2 == 0) continue;
                        }
                        break block30;
                    }
                    v0 = var4_5;
                }
                var10_12 = (X)v0.a();
                var11_13 = M.b();
                var12_14 = var10_12.p();
                while (var12_14.f()) {
                    var13_15 = var12_14.a();
                    v1 = var4_5.c(var13_15);
                    if (var23_2 == 0) {
                        if (!v1 && (var14_16 = this.a(var13_15, var4_5)) != null) {
                            var11_13.a((Object)var13_15, var14_16.d());
                        }
                        var12_14.g();
                        if (var23_2 == 0) continue;
                    }
                    break block31;
                }
                v1 = this.a();
            }
            if (v1) {
                this.y.a((y.c.h)var11_13);
                this.y.a(var4_5);
                this.y.b();
            }
            var12_14 = var10_12.p();
            while (var12_14.f()) {
                var13_15 = var12_14.a();
                v2 = var4_5.c(var13_15);
                if (var23_2 != 0) break block32;
                if (v2 || (var14_16 = (y.f.f.a)var11_13.b(var13_15)) == null) ** GOTO lbl112
                var15_17 = this.a(var13_15, var10_12, var4_5);
                var16_18 = (int)Math.ceil(((double)var15_17 + var14_16.c()) / (double)this.t);
                var17_19 = (int)Math.ceil(((double)var15_17 + var14_16.a()) / (double)this.t);
                var18_20 = (int)Math.ceil(((double)var15_17 + var14_16.b()) / (double)this.t);
                var19_21 = (int)Math.ceil(((double)var15_17 + var14_16.b() + var14_16.a()) / (double)this.t);
                var20_22 = Math.max(var16_18, var4_5.i(var13_15));
                var21_23 = this.a(var13_15.c(), var4_5);
                var22_24 = this.a(var13_15.d(), var4_5);
                if (!var21_23 || !var22_24 || var20_22 >= var19_21) ** GOTO lbl105
                var20_22 = var19_21;
                if (var23_2 == 0) ** GOTO lbl110
lbl105: // 2 sources:
                if (!var21_23 || var20_22 >= var17_19) ** GOTO lbl-1000
                var20_22 = var17_19;
                if (var23_2 != 0) lbl-1000: // 2 sources:
                {
                    if (var22_24 && var20_22 < var18_20) {
                        var20_22 = var18_20;
                    }
                }
lbl110: // 6 sources:
                var4_5.b(var13_15, var20_22);
                var4_5.b(var4_5.a(var13_15), var20_22);
lbl112: // 2 sources:
                var12_14.g();
                if (var23_2 == 0) continue;
            }
            this.C.e();
            ae.a(var1_1);
            this.w.a(this.t);
            this.w.a(var4_5);
            this.w.a(this.B);
            this.w.a();
            this.B.g = (int)this.C.d();
            v2 = this.a();
        }
        if (v2) {
            this.y.a(var6_7);
            var4_5.j();
            this.y.c();
        }
        if (this.x != null) {
            this.x.c();
        }
        if (this.r) {
            this.y.a();
        }
        if (this.o) {
            var4_5.k();
        }
        if (!this.o) {
            this.u.a();
        }
        var4_5.q();
        this.a((i)var1_1);
        if (this.n()) {
            var6_7.a();
        }
        if (this.u instanceof y.f.h.c) {
            var12_14 = (y.f.h.c)this.u;
            this.B.c = var12_14.b();
            this.B.d = var12_14.d();
            this.B.e = var12_14.e();
        }
        this.B.a = (int)var2_3.d();
        y.g.o.a(this, 1, new StringBuffer().append("---> Total running time of the algorithm: ").append(var2_3).toString());
        y.g.o.a(this, 1, "<<---- Leaving algorithm");
    }

    private boolean a(q q2, h h2) {
        if (h2.d(q2)) {
            return true;
        }
        if (!(this.o() instanceof w)) return false;
        return ((w)this.o()).b().f(q2);
    }

    /*
     * Unable to fully structure code
     */
    private int a(y.c.d var1_1, X var2_2, h var3_3) {
        var10_4 = h.a;
        var4_5 = 0;
        if (!var3_3.g(var1_1.c())) ** GOTO lbl18
        var5_6 = var1_1.c().l();
        while (var5_6.f()) {
            var6_7 = var5_6.a();
            var7_8 = var6_7.d();
            v0 = var6_7;
            v1 = var1_1;
            if (var10_4 == 0) {
                if (v0 != v1 && var3_3.d(var7_8)) {
                    var8_9 = var3_3.h(var6_7);
                    var9_10 = o.a.a(var8_9) != false || o.c.a(var8_9) != false;
                    var4_5 = (int)((double)var4_5 + (var9_10 != false ? var2_2.p(var7_8) * 0.5 : var2_2.q(var7_8) * 0.5));
                }
                var5_6.g();
                if (var10_4 == 0) continue;
            }
            ** GOTO lbl26
        }
lbl18: // 3 sources:
        if (var3_3.g(var1_1.d()) == false) return var4_5;
        var5_6 = var1_1.d().k();
        do {
            if (var5_6.f() == false) return var4_5;
            var6_7 = var5_6.a();
            var7_8 = var6_7.c();
            v0 = var6_7;
            v1 = var1_1;
lbl26: // 2 sources:
            if (v0 != v1 && var3_3.d(var7_8)) {
                var8_9 = var3_3.h(var6_7);
                var9_10 = o.a.a(var8_9) != false || o.c.a(var8_9) != false;
                var4_5 = (int)((double)var4_5 + (var9_10 != false ? var2_2.p(var7_8) * 0.5 : var2_2.q(var7_8) * 0.5));
            }
            var5_6.g();
        } while (var10_4 == 0);
        return var4_5;
    }

    private void a(i i2) {
        y.g.o.a(this, (Object)new StringBuffer().append("Node Map Count: ").append(i2.v().length).toString());
        y.g.o.a(this, (Object)new StringBuffer().append("Edge Map Count: ").append(i2.w().length).toString());
    }
}

