/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import java.util.ArrayList;
import y.c.A;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.h.E;
import y.f.h.F;
import y.f.h.N;
import y.f.h.P;
import y.f.h.Q;
import y.f.h.p;
import y.f.h.q;

public class D
extends N {
    private h e;
    private h f;
    private f g;
    private A h;
    private ArrayList i;

    public D(i i2) {
        boolean bl2 = N.d;
        super(i2);
        this.h = i2.t();
        this.e = i2.u();
        this.f = i2.u();
        this.i = new ArrayList();
        this.g = new f();
        e e2 = i2.p();
        do {
            if (!e2.f()) return;
            this.f(e2.a()).b(true);
            e2.g();
        } while (!bl2);
    }

    @Override
    public void e() {
        super.e();
        this.a.a(this.e);
        this.a.a(this.f);
        this.a.a(this.h);
        this.g.clear();
    }

    public void a(y.c.q q2, int n2) {
        this.i(q2).a(n2);
    }

    public int a(y.c.q q2) {
        return this.i(q2).a();
    }

    public boolean b(y.c.q q2) {
        if (this.a(q2) != 1) return false;
        return true;
    }

    public void c(y.c.q q2) {
        this.a(q2, 1);
    }

    public void d(y.c.q q2) {
        this.a(q2, 2);
    }

    public boolean e(y.c.q q2) {
        if (this.a(q2) != 2) return false;
        return true;
    }

    public boolean f(y.c.q q2) {
        if (this.a(q2) != 0) return false;
        return true;
    }

    public void g(y.c.q q2) {
        this.a(q2, 0);
    }

    public int a() {
        int n2;
        boolean bl2 = N.d;
        int n3 = 0;
        x x2 = this.a.o();
        while (x2.f()) {
            n2 = (int)this.b(x2.e()) ? 1 : 0;
            if (bl2) return n2;
            if (n2 != 0) {
                ++n3;
            }
            x2.g();
            if (!bl2) continue;
        }
        n2 = n3;
        return n2;
    }

    public p[] a(p p2, d d2) {
        return this.a(p2, d2, null, null);
    }

    /*
     * Unable to fully structure code
     */
    public p[] a(p var1_1, d var2_2, d var3_3, d var4_4) {
        var15_5 = N.d;
        if (var3_3 != null && this.i(var3_3) != var1_1) {
            throw new RuntimeException("Fatal Error in edge to face assignment!");
        }
        if (var4_4 != null && this.i(var4_4) != var1_1) {
            throw new RuntimeException("Fatal Error in edge to face assignment!");
        }
        if (this.e(var2_2.c())) {
            this.c(var2_2.c());
        }
        if (this.e(var2_2.d())) {
            this.c(var2_2.d());
        }
        this.b.remove(var1_1);
        var5_6 = var1_1.a();
        if (var3_3 != null) ** GOTO lbl22
        while (var5_6.f()) {
            v0 = var5_6.a().d();
            v1 = var2_2.c();
            if (!var15_5) {
                if (v0 == v1) break;
                var5_6.b();
                if (!var15_5) continue;
            }
            ** GOTO lbl28
        }
        var3_3 = var5_6.a();
lbl22: // 2 sources:
        if (var4_4 == null) {
            block17 : {
                while (var5_6.f()) {
                    v2 = var5_6.a();
                    if (!var15_5) {
                        v0 = v2.d();
                        v1 = var2_2.d();
lbl28: // 2 sources:
                        if (v0 == v1) break;
                        var5_6.b();
                        if (!var15_5) continue;
                    }
                    break block17;
                }
                v2 = var5_6.a();
            }
            var4_4 = v2;
        }
        var6_7 = this.g(var2_2);
        var7_8 = new p[2];
        var8_9 = new p();
        var9_10 = new p();
        if (var3_3.d() != var2_2.d()) ** GOTO lbl-1000
        var10_11 = var2_2;
        var11_12 = var6_7;
        if (var15_5) lbl-1000: // 2 sources:
        {
            var10_11 = var6_7;
            var11_12 = var2_2;
        }
        this.f(var10_11).a(var8_9);
        this.f(var11_12).a(var9_10);
        var5_6.i();
        while (var5_6.f()) {
            v3 = var5_6.a();
            v4 = var3_3;
            if (!var15_5) {
                if (v3 == v4) break;
                var5_6.b();
                if (!var15_5) continue;
            }
            ** GOTO lbl76
        }
        var5_6.b();
        while (var5_6.f()) {
            v3 = var5_6.a();
            v4 = var4_4;
            if (!var15_5) {
                if (v3 == v4) break;
                this.f(var5_6.a()).a(var8_9);
                var8_9.a(var5_6.a());
                var5_6.b();
                if (!var15_5) continue;
            }
            ** GOTO lbl76
        }
        this.f(var4_4).a(var8_9);
        var8_9.a(var4_4);
        var8_9.a(var10_11);
        this.b.add(var8_9);
        var7_8[0] = var8_9;
        var5_6.b();
        while (var5_6.f()) {
            v3 = var5_6.a();
            v4 = var3_3;
lbl76: // 3 sources:
            if (v3 == v4) break;
            this.f(var5_6.a()).a(var9_10);
            var9_10.a(var5_6.a());
            var5_6.b();
            if (!var15_5) continue;
        }
        this.f(var3_3).a(var9_10);
        var9_10.a(var3_3);
        var9_10.a(var11_12);
        this.b.add(var9_10);
        var7_8[1] = var9_10;
        if (this.i() == var1_1) {
            this.b(D.a(var8_9, var9_10));
        }
        this.a.a(var10_11, this.h(var4_4), null, 0, 1);
        this.a.a(var11_12, this.h(var3_3), null, 0, 1);
        var12_13 = new p[]{var1_1};
        var13_14 = new p[]{var8_9, var9_10};
        if (this.f(var2_2).f() && (var14_15 = this.g.d(var2_2)) != null) {
            this.g.h(var14_15);
        }
        this.a(var2_2, var12_13, var13_14);
        if (i.g == false) return var7_8;
        N.d = var15_5 == false;
        return var7_8;
    }

    private static p a(p p2, p p3) {
        return p2.a().k() > p3.a().k() ? p2 : p3;
    }

    public void a(d d2, d d3) {
        d d4;
        e e2;
        boolean bl2 = N.d;
        if (d2 == null && d3.c().a() > 2) {
            d4 = null;
            e2 = d3.c().l();
        } else {
            p p2;
            p[] arrp;
            p[] arrp2;
            p p3 = new p();
            d d5 = this.g(d3);
            p3.a(d5);
            this.b.add(p3);
            this.f(d5).a(p3);
            if (d2 != null) {
                p2 = this.i(d2);
                p2.a(d2, d3, d2);
                this.f(d3).a(p2);
                arrp = new p[]{p2};
                arrp2 = new p[]{p3, p2};
                this.a(d3, arrp, arrp2);
                if (!bl2) return;
            }
            p2 = new p();
            this.b.add(p2);
            this.f(d3).a(p2);
            p2.a(d3);
            arrp = new p[]{};
            arrp2 = new p[]{p3, p2};
            this.a(d3, arrp, arrp2);
            return;
        }
        while (e2.f()) {
            d d6 = e2.a();
            if (bl2) return;
            if (d3 != d6) {
                if (d4 == null) {
                    d4 = d6;
                }
                if (this.i(d6).a().k() == 1) {
                    d4 = d6;
                }
            }
            e2.g();
            if (!bl2) continue;
        }
        this.a(d4, d3);
    }

    /*
     * Unable to fully structure code
     */
    public p a(d var1_1, d var2_2, d var3_3) {
        block32 : {
            block30 : {
                var18_4 = N.d;
                var4_5 = new p();
                var5_6 = null;
                var6_7 = null;
                var7_8 = null;
                var8_9 = null;
                var9_10 = var1_1.c();
                var10_11 = var1_1.d();
                var12_12 = this.g(var1_1);
                if (var2_2 != null) ** GOTO lbl53
                if (var9_10.a() != 2) ** GOTO lbl-1000
                var4_5.a(var12_12);
                this.f(var12_12).a(var4_5);
                var4_5.a(var1_1);
                this.f(var1_1).a(var4_5);
                if (var18_4) lbl-1000: // 2 sources:
                {
                    var4_5.a(var12_12);
                    this.f(var12_12).a(var4_5);
                    var13_13 = var9_10.f();
                    if (var13_13 == var1_1) {
                        throw new RuntimeException("Bridge Face failed !");
                    }
                    var5_6 = this.i(var13_13);
                    this.b.remove(var5_6);
                    var7_8 = var5_6.a();
                    while (var7_8.f()) {
                        v0 = var7_8.a();
                        v1 = var13_13;
                        if (!var18_4) {
                            if (v0 == v1) break;
                            var7_8.b();
                            if (!var18_4) continue;
                        }
                        break block29;
                    }
                    var11_14 = var7_8.a();
                    var4_5.a(var11_14);
                    this.f(var11_14).a(var4_5);
                    var7_8.b();
                    while (var7_8.f()) {
                        v0 = var7_8.a();
                        v1 = var11_14;
                        if (!var18_4) {
                            if (v0 == v1) break;
                            var4_5.a(var7_8.a());
                            this.f(var7_8.a()).a(var4_5);
                            var7_8.b();
                            if (!var18_4) continue;
                        }
                        break block29;
                    }
                    var4_5.a(var1_1);
                    this.f(var1_1).a(var4_5);
                    if (this.i() == var5_6) {
                        this.b(var4_5);
                    }
                }
                ** GOTO lbl84
lbl53: // 1 sources:
                var4_5.a(var12_12);
                this.f(var12_12).a(var4_5);
                var5_6 = this.i(var2_2);
                this.b.remove(var5_6);
                var7_8 = var5_6.a();
                while (var7_8.f()) {
                    v2 = var7_8.a();
                    v3 = var2_2;
                    if (!var18_4) {
                        if (v2 == v3) break;
                        var7_8.b();
                        if (!var18_4) continue;
                    }
                    ** GOTO lbl71
                }
                var7_8.b();
                while (var7_8.f()) {
                    v2 = var7_8.a();
                    if (!var18_4) {
                        v3 = var2_2;
lbl71: // 2 sources:
                        if (v2 == v3) break;
                        var14_15 = var7_8.a();
                        var4_5.a((d)var14_15);
                        this.f((d)var14_15).a(var4_5);
                        var7_8.b();
                        if (!var18_4) continue;
                    }
                    break block30;
                }
                var4_5.a(var2_2);
                this.f(var2_2).a(var4_5);
                var4_5.a(var1_1);
                this.f(var1_1).a(var4_5);
                if (this.i() == var5_6) {
                    this.b(var4_5);
                }
lbl84: // 4 sources:
                v2 = var3_3;
            }
            if (v2 != null) ** GOTO lbl122
            if (var10_11.a() != 2) {
                block31 : {
                    block29 : {
                        v0 = var13_13 = var10_11.f();
                        v1 = var12_12;
                    }
                    if (v0 == v1) {
                        throw new RuntimeException("Error in bridge Face !");
                    }
                    var6_7 = this.i(var13_13);
                    this.b.remove(var6_7);
                    var8_9 = var6_7.a();
                    while (var8_9.f()) {
                        v4 = var8_9.a();
                        if (!var18_4) {
                            if (v4 == var13_13) break;
                            var8_9.b();
                            if (!var18_4) continue;
                        }
                        break block31;
                    }
                    v4 = var8_9.a();
                }
                var11_14 = v4;
                var4_5.a(var11_14);
                this.f(var11_14).a(var4_5);
                var8_9.b();
                while (var8_9.f()) {
                    v5 = var8_9.a();
                    if (!var18_4) {
                        if (v5 == var11_14) break;
                        var4_5.a(var8_9.a());
                        this.f(var8_9.a()).a(var4_5);
                        var8_9.b();
                        if (!var18_4) continue;
                    }
                    break block32;
                }
                if (this.i() == var6_7) {
                    this.b(var4_5);
                }
            }
            ** GOTO lbl147
lbl122: // 1 sources:
            var6_7 = this.i(var3_3);
            this.b.remove(var6_7);
            var8_9 = var6_7.a();
            while (var8_9.f()) {
                v5 = var8_9.a();
                v6 = var3_3;
                if (!var18_4) {
                    if (v5 == v6) break;
                    var8_9.b();
                    if (!var18_4) continue;
                }
                ** GOTO lbl138
            }
            var8_9.b();
            while (var8_9.f()) {
                v5 = var8_9.a();
                if (!var18_4) {
                    v6 = var3_3;
lbl138: // 2 sources:
                    if (v5 == v6) break;
                    var14_15 = var8_9.a();
                    var4_5.a((d)var14_15);
                    this.f((d)var14_15).a(var4_5);
                    var8_9.b();
                    if (!var18_4) continue;
                }
                break block32;
            }
            var4_5.a(var3_3);
            this.f(var3_3).a(var4_5);
lbl147: // 2 sources:
            this.b.add(var4_5);
            if (this.i() == var6_7) {
                this.b(var4_5);
            }
            v5 = var2_2;
        }
        if (v5 != null) {
            this.a.a(var1_1, this.h(var2_2), null, 0, 1);
        }
        if (var3_3 != null) {
            this.a.a(this.h(var1_1), this.h(var3_3), null, 0, 1);
        }
        var14_15 = new p[]{var4_5};
        var15_16 = new ArrayList<p>(2);
        if (var5_6 != null) {
            var15_16.add(var5_6);
        }
        if (var6_7 != null) {
            var15_16.add(var6_7);
        }
        var16_17 = new p[var15_16.size()];
        var15_16.toArray(var16_17);
        if (this.f(var1_1).f() && (var17_18 = this.g.d(var1_1)) != null) {
            this.g.h(var17_18);
        }
        this.a(var1_1, var16_17, (p[])var14_15);
        return var4_5;
    }

    /*
     * Unable to fully structure code
     */
    public void a(d var1_1) {
        block19 : {
            var11_2 = N.d;
            var2_3 = this.h(var1_1);
            if (this.i(var1_1) == this.i(var2_3)) ** GOTO lbl-1000
            var5_4 = this.i(var1_1);
            var6_5 = this.i(var2_3);
            var7_6 = new p();
            var3_7 = new p[2];
            var4_8 = new p[1];
            var3_7[0] = var5_4;
            var3_7[1] = var6_5;
            var4_8[0] = var7_6;
            var8_9 = var5_4.a();
            var9_10 = var6_5.a();
            this.b.remove(var5_4);
            this.b.remove(var6_5);
            while (var8_9.f()) {
                block21 : {
                    var10_11 = var8_9.a();
                    if (var11_2) break block19;
                    if (var10_11 == var1_1) ** GOTO lbl-1000
                    var7_6.a(var10_11);
                    this.f(var10_11).a(var7_6);
                    if (var11_2) lbl-1000: // 3 sources:
                    {
                        block20 : {
                            while (var9_10.a() != var2_3) {
                                var9_10.b();
                                if (!var11_2) {
                                    if (!var11_2) continue;
                                }
                                break block20;
                            }
                            var9_10.b();
                        }
                        while (var9_10.a() != var2_3) {
                            var7_6.a(var9_10.a());
                            this.f(var9_10.a()).a(var7_6);
                            var9_10.b();
                            if (!var11_2) {
                                if (!var11_2) continue;
                            }
                            break block21;
                        }
                    }
                    var8_9.g();
                }
                if (!var11_2) continue;
            }
            this.p(var1_1);
            this.p(var2_3);
            this.b.add(var7_6);
        }
        if (var5_4 == this.i() || var6_5 == this.i()) {
            this.b(var7_6);
            ** if (!var11_2) goto lbl92
        }
        ** GOTO lbl92
lbl-1000: // 2 sources:
        {
            block24 : {
                block23 : {
                    block22 : {
                        var5_4 = this.i(var1_1);
                        var6_5 = new p();
                        var7_6 = new p();
                        var3_7 = new p[1];
                        var4_8 = new p[]{var6_5, var7_6};
                        var3_7[0] = var5_4;
                        this.b.remove(var5_4);
                        var8_9 = var5_4.a();
                        while (var8_9.a() != var1_1) {
                            var8_9.b();
                            if (!var11_2) {
                                if (!var11_2) continue;
                            }
                            break block22;
                        }
                        var8_9.b();
                    }
                    while (var8_9.a() != var2_3) {
                        var6_5.a(var8_9.a());
                        this.f(var8_9.a()).a(var6_5);
                        var8_9.b();
                        if (!var11_2) {
                            if (!var11_2) continue;
                        }
                        break block23;
                    }
                    var8_9.b();
                }
                while (var8_9.a() != var1_1) {
                    var7_6.a(var8_9.a());
                    this.f(var8_9.a()).a(var7_6);
                    var8_9.b();
                    if (!var11_2) {
                        if (!var11_2) continue;
                    }
                    break block24;
                }
                if (var6_5.a().k() > 0) {
                    if (var5_4 == this.i()) {
                        this.b(var6_5);
                    }
                    this.b.add(var6_5);
                }
            }
            if (var7_6.a().k() > 0) {
                if (var5_4 == this.i()) {
                    this.b(var7_6);
                }
                this.b.add(var7_6);
            }
            if (var6_5.a().k() == 0 && var7_6.a().k() == 0) {
                this.b(this.h().a());
            }
            this.p(var1_1);
            this.p(var2_3);
        }
lbl92: // 3 sources:
        this.b(var1_1, var3_7, var4_8);
    }

    public void a(d d2, y.c.q q2, p p2) {
        d d3;
        block2 : {
            d3 = this.g(d2);
            if (d2.d().equals(q2)) {
                p2.a(d2, d3);
                if (!N.d) break block2;
            }
            p2.a(d3, d2);
        }
        this.f(d2).a(p2);
        this.f(d3).a(p2);
    }

    public y.c.q b(d d2) {
        d d3 = this.h(d2);
        y.c.q q2 = d2.c();
        y.c.q q3 = d2.d();
        y.c.q q4 = this.a.d();
        this.d(q4);
        d d4 = this.a.a(q2, d2, q4, null, 1, 0);
        this.f(d4).c(false);
        d d5 = this.a.a(q4, null, q3, d2, 0, 1);
        this.f(d5).c(false);
        d d6 = this.a.a(q3, d3, q4, null, 1, 0);
        this.f(d6).c(true);
        d d7 = this.a.a(q4, null, q2, d3, 0, 1);
        this.f(d7).c(true);
        f f2 = new f();
        f2.add(d4);
        f2.add(d5);
        this.a(d2, f2, 0);
        p p2 = this.i(d2);
        p p3 = this.i(d3);
        this.f(d4).a(p2);
        this.f(d5).a(p2);
        this.f(d6).a(p3);
        this.f(d7).a(p3);
        p2.a(d2, d4, d5);
        p3.a(d3, d6, d7);
        this.b(d4, d7);
        this.b(d5, d6);
        this.a(d2, f2.e());
        this.p(d2);
        this.p(d3);
        return q4;
    }

    public f a(d d2, int n2) {
        p p2;
        f f2;
        boolean bl2;
        f f3;
        boolean bl3;
        d d3;
        Object object;
        p p3;
        d d4;
        block10 : {
            block9 : {
                d d5;
                y.c.q[] arrq;
                y.c.q q2;
                block8 : {
                    D d6;
                    bl2 = N.d;
                    d3 = this.h(d2);
                    y.c.q q3 = d2.c();
                    q2 = d2.d();
                    p3 = this.i(d2);
                    p2 = this.i(d3);
                    arrq = new y.c.q[n2];
                    y.c.q[] arrq2 = new y.c.q[n2 + 2];
                    bl3 = this.n(d2);
                    arrq2[0] = q3;
                    arrq2[n2 + 1] = q2;
                    for (int i2 = 0; i2 < n2; ++i2) {
                        arrq[i2] = this.a.d();
                        arrq2[i2 + 1] = arrq[i2];
                        this.d(arrq[i2]);
                        if (!bl2) continue;
                    }
                    f2 = new f();
                    f3 = new f();
                    d d7 = this.a.a(q3, d2, arrq[0], null, 1, 0);
                    f2.b(d7);
                    d d8 = this.a.a(arrq[0], null, q3, d3, 0, 1);
                    f3.a(d8);
                    this.b(d7, d8);
                    for (int i3 = 1; i3 < n2; ++i3) {
                        d5 = this.a.a(arrq2[i3], arrq2[i3 + 1]);
                        object = this.a.a(arrq2[i3 + 1], arrq2[i3]);
                        f2.b(d5);
                        f3.a(object);
                        d6 = this;
                        if (!bl2) {
                            d6.b(d5, (d)object);
                            if (!bl2) continue;
                        }
                        break block8;
                    }
                    d6 = this;
                }
                d d9 = d6.a.a(arrq[n2 - 1], null, q2, d2, 0, 1);
                f2.b(d9);
                d5 = this.a.a(q2, d3, arrq[n2 - 1], null, 1, 0);
                f3.a(d5);
                this.b(d9, d5);
                if (bl3) {
                    this.a(d3, f3, 0);
                    if (!bl2) break block9;
                }
                this.a(d2, f2, 0);
            }
            this.a(d2, f2.e());
            this.p(d2);
            this.p(d3);
            object = f2.a();
            while (object.f()) {
                d4 = object.a();
                this.f(d4).a(p3);
                this.f(d4).c(bl3);
                object.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block10;
            }
            object = f3.a();
        }
        while (object.f()) {
            d4 = object.a();
            this.f(d4).a(p2);
            if (bl2) return f2;
            this.f(d4).c(!bl3);
            object.g();
            if (!bl2) continue;
        }
        p3.a(d2, f2);
        p2.a(d3, f3);
        return f2;
    }

    /*
     * Unable to fully structure code
     */
    public d h(y.c.q var1_1) {
        block6 : {
            var17_2 = N.d;
            var12_3 = new f();
            if (var1_1.b() != 2) throw new RuntimeException("Node is not a crossing");
            if (var1_1.c() != 2) {
                throw new RuntimeException("Node is not a crossing");
            }
            var13_4 = var1_1.k();
            var4_5 = var13_4.a();
            var13_4.g();
            var5_6 = var13_4.a();
            var13_4 = var1_1.l();
            var2_7 = var13_4.a();
            var13_4.g();
            var3_8 = var13_4.a();
            if (!this.n(var4_5)) ** GOTO lbl-1000
            var6_9 = var5_6;
            var8_10 = var4_5;
            if (var17_2) lbl-1000: // 2 sources:
            {
                var6_9 = var4_5;
                var8_10 = var5_6;
            }
            if (var2_7 != this.h(var6_9)) ** GOTO lbl-1000
            var7_11 = var3_8;
            var9_12 = var2_7;
            if (var17_2) lbl-1000: // 2 sources:
            {
                var7_11 = var2_7;
                var9_12 = var3_8;
            }
            var14_13 = (d)this.f.b(var6_9);
            if (var6_9.c() == var14_13.c() && var7_11.d() == var14_13.d()) {
                this.q(var14_13);
                var11_14 = var14_13;
                if (!var17_2) break block6;
            }
            var11_14 = this.a.a(var6_9.c(), var7_11.d());
        }
        var10_15 = this.g(var11_14);
        if (var8_10.c() != var10_15.c()) throw new RuntimeException("Reverse Edge Restauration failed!");
        if (var9_12.d() != var10_15.d()) {
            throw new RuntimeException("Reverse Edge Restauration failed!");
        }
        var15_16 = this.i(var6_9);
        var15_16.b(var6_9, var7_11, var11_14);
        this.f(var11_14).a(var15_16);
        var16_17 = this.i(var8_10);
        var16_17.b(var8_10, var9_12, var10_15);
        this.f(var10_15).a(var16_17);
        this.j(var1_1);
        var12_3.a(var7_11);
        var12_3.a(var6_9);
        this.a(var11_14, var12_3, 1);
        this.a(var12_3.e(), var11_14);
        return var11_14;
    }

    public void a(Q q2) {
        this.i.add(q2);
    }

    public void b(Q q2) {
        int n2 = this.i.indexOf(q2);
        if (n2 < 0) return;
        this.i.remove(n2);
    }

    protected void a(d d2, d[] arrd) {
        boolean bl2 = N.d;
        int n2 = 0;
        do {
            if (n2 >= this.i.size()) return;
            Q q2 = (Q)this.i.get(n2);
            q2.a(d2, arrd);
            ++n2;
        } while (!bl2);
    }

    protected void a(d[] arrd, d d2) {
        boolean bl2 = N.d;
        int n2 = 0;
        do {
            if (n2 >= this.i.size()) return;
            Q q2 = (Q)this.i.get(n2);
            q2.a(arrd, d2);
            ++n2;
        } while (!bl2);
    }

    protected void a(d d2, p[] arrp, p[] arrp2) {
        boolean bl2 = N.d;
        int n2 = 0;
        do {
            if (n2 >= this.i.size()) return;
            Q q2 = (Q)this.i.get(n2);
            q2.a(d2, arrp, arrp2);
            ++n2;
        } while (!bl2);
    }

    protected void b(d d2, p[] arrp, p[] arrp2) {
        boolean bl2 = N.d;
        int n2 = 0;
        do {
            if (n2 >= this.i.size()) return;
            Q q2 = (Q)this.i.get(n2);
            q2.b(d2, arrp, arrp2);
            ++n2;
        } while (!bl2);
    }

    public e c(d d2) {
        y.c.p p2 = this.g.d(d2);
        if (p2 == null) {
            f f2 = new f();
            f2.add(d2);
            return f2.a();
        }
        f f3 = (f)this.e.b(d2);
        return f3.a();
    }

    public d d(d d2) {
        d d3 = (d)this.f.b(d2);
        if (d3 != null) return d3;
        return d2;
    }

    public void a(d d2, f f2, int n2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl2 = N.d;
        if (n2 == 0) {
            e e2;
            block9 : {
                if (this.f(d2).f()) {
                    object = this.g.d(d2);
                    if (object == null) {
                        this.g.add(d2);
                    }
                    this.e.a((Object)d2, f2);
                    object4 = f2.a();
                    do {
                        if (!object4.f()) return;
                        object2 = object4.a();
                        this.f.a(object2, d2);
                        this.e.a(object2, f2);
                        object4.g();
                    } while (!bl2);
                }
                object = (f)this.e.b(d2);
                object4 = object.d(d2);
                object2 = (d)this.f.b(object4.c());
                object3 = object4;
                e2 = f2.a();
                while (e2.f()) {
                    d d3 = e2.a();
                    this.f.a((Object)d3, object2);
                    object.b(d3, (y.c.p)object3);
                    object3 = object.c((y.c.p)object3);
                    e2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block9;
                }
                object.h((y.c.p)object4);
            }
            e2 = object.a();
            do {
                if (!e2.f()) return;
                this.e.a((Object)e2.a(), object);
                e2.g();
            } while (!bl2);
        }
        if (n2 != 1) throw new RuntimeException("UNSPECIFIED EDGE RECOVERY");
        object = f2.a();
        this.e.a((Object)d2, this.e.b(object.a()));
        this.f.a((Object)d2, this.f.b(object.a()));
        object4 = (f)this.e.b(d2);
        object2 = object4.d(object.a());
        object4.a(d2, (y.c.p)object2);
        while (object.f()) {
            if (object.a() != object4.g((y.c.p)object2)) throw new RuntimeException("WRONG SEGMENTS IN EDGE RECOVERY");
            object3 = object4.c((y.c.p)object2);
            object4.h((y.c.p)object2);
            object2 = object3;
            if (bl2) {
                throw new RuntimeException("WRONG SEGMENTS IN EDGE RECOVERY");
            }
            object.g();
            if (!bl2) continue;
        }
        if (object4.size() != 1) return;
        this.g.remove(d2);
        this.e(d2);
        if (!bl2) return;
        throw new RuntimeException("UNSPECIFIED EDGE RECOVERY");
    }

    public void b() {
        C c2;
        boolean bl2;
        block7 : {
            bl2 = N.d;
            X x2 = (X)this.a;
            y.c.D d2 = new y.c.D();
            c2 = this.g.a();
            block0 : do {
                boolean bl3 = c2.f();
                block1 : while (bl3) {
                    d2.clear();
                    d d3 = c2.a();
                    this.q(d3);
                    e e2 = ((f)this.e.b(d3)).a();
                    if (bl2) break block7;
                    if (e2 != null && e2.f()) {
                        while (e2.f()) {
                            y.c.D d4 = x2.k(e2.a());
                            d2.a(d4);
                            bl3 = this.e(e2.a().d());
                            if (bl2) continue block1;
                            if (bl3) {
                                d2.add(x2.l(e2.a().d()));
                            }
                            e2.g();
                            if (!bl2) continue;
                        }
                        x2.b(d3, d2);
                        e2.i();
                        x2.a(d3, x2.n(e2.a()));
                        e2.j();
                        x2.b(d3, x2.o(e2.a()));
                    }
                    this.e.a((Object)c2.a(), null);
                    c2.g();
                    if (!bl2) continue block0;
                }
                break block0;
                break;
            } while (true);
            this.g.clear();
        }
        c2 = this.a.o();
        do {
            if (!c2.f()) return;
            if (this.b(c2.e()) || this.e(c2.e())) {
                this.j(c2.e());
            }
            c2.g();
        } while (!bl2);
    }

    public void e(d d2) {
        this.f(d2).b(true);
    }

    protected F i(y.c.q q2) {
        F f2 = (F)this.h.b(q2);
        if (f2 != null) return f2;
        f2 = this.c();
        this.h.a((Object)q2, f2);
        return f2;
    }

    protected F c() {
        return new F();
    }

    protected E f(d d2) {
        return (E)this.o(d2);
    }

    protected E d() {
        return new E();
    }

    @Override
    protected P d_() {
        return this.d();
    }

    private void p(d d2) {
        if (this.f(d2).f()) {
            this.a.d(d2);
            if (!N.d) return;
        }
        this.a.a(d2);
    }

    private void q(d d2) {
        if (!this.f(d2).f()) throw new RuntimeException("Tried to reinsert non-original edge !");
        this.a.e(d2);
        if (!N.d) return;
        throw new RuntimeException("Tried to reinsert non-original edge !");
    }

    private void j(y.c.q q2) {
        boolean bl2 = N.d;
        e e2 = q2.j();
        while (e2.f()) {
            this.p(e2.a());
            e2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a.a(q2);
    }
}

