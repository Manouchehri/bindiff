/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.d;
import y.c.i;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.b.A;
import y.f.f.a.b.a;
import y.f.h.p;

public class y {
    private a a;
    private i b;
    private y.f.f.a.a.p c;
    private A d;
    private d e;
    private d f;
    private d g;
    private boolean h = true;
    private y.c.f i;

    public y(a a2) {
        this.a = a2;
        this.b = this.a.d();
        this.c = this.a.b();
    }

    public void a() {
        if (this.d == null) return;
        this.d.a();
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public static void a(a a2, d d2) {
        y y2 = new y(a2);
        y2.h = false;
        y2.a(new y.c.f(d2));
        y2.a();
    }

    public static boolean b(a a2, d d2) {
        y.c.f f2 = new y.c.f();
        y.c.f f3 = a2.d(d2);
        y y2 = new y(a2);
        y2.d = new A(a2);
        y2.h = false;
        double d3 = y2.d.a(d2, f2);
        y2.a();
        if (d3 <= (double)f3.size()) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public void a(y.c.f var1_1) {
        var4_2 = a.c;
        var2_3 = var1_1.a();
        do {
            if (var2_3.f() == false) return;
            if (this.d == null) {
                this.d = new A(this.a);
            }
            this.g = var2_3.a();
            if (!this.g.e()) ** GOTO lbl-1000
            this.a(this.g);
            if (var4_2) lbl-1000: // 2 sources:
            {
                var3_4 = this.d.a(this.g.c(), this.g.d());
                this.b(var3_4);
            }
            if (!this.h) {
                this.d.a();
                this.d = null;
            }
            var2_3.g();
        } while (!var4_2);
    }

    private void a(d d2) {
        q q2 = d2.c();
        d d3 = this.a.k(d2);
        y.c.f f2 = this.a.a(q2);
        f2.a(d2);
        f2.a(d3);
        if (!this.h) return;
        d d4 = f2.c();
        p p2 = this.a.b(d4);
        this.a(p2, d2);
    }

    /*
     * Unable to fully structure code
     */
    private void b(y.c.f var1_1) {
        var7_2 = a.c;
        var2_3 = null;
        var3_4 = var1_1.a();
        do {
            if (var3_4.f() == false) return;
            var4_5 = var3_4.a();
            var5_6 = this.d.a(var4_5);
            switch (var5_6) {
                case 0: {
                    var2_3 = this.b(var4_5);
                    if (!var7_2) ** GOTO lbl25
                }
                case 1: {
                    var2_3 = this.c(var4_5);
                    if (!var7_2) ** GOTO lbl25
                }
                case 2: {
                    var2_3 = this.f(var4_5);
                    if (!var7_2) ** GOTO lbl25
                }
                case 3: {
                    var2_3 = this.d(var4_5);
                    if (!var7_2) ** GOTO lbl25
                }
                case 4: {
                    var2_3 = this.e(var4_5);
                    if (!var7_2) ** GOTO lbl25
                }
            }
            throw new RuntimeException("Bad routing edge type!");
lbl25: // 5 sources:
            if (this.h && var5_6 != 0) {
                var6_7 = this.d.a(var4_5.c());
                this.a(var6_7, var2_3);
            }
            var3_4.g();
        } while (!var7_2);
    }

    private d b(d d2) {
        this.e = this.b.a(this.g.c(), this.g.d());
        d d3 = this.a(this.g.c(), d2.d());
        this.a.b(this.g.c(), d3, this.e);
        this.i = new y.c.f();
        y.c.p p2 = this.i.b(this.e);
        this.a.a(this.e, p2);
        this.a.b(this.e, this.g);
        return null;
    }

    private d c(d d2) {
        this.f = this.a.k(this.e);
        d d3 = this.a(this.g.d(), d2.c());
        this.a.b(this.g.d(), d3, this.f);
        this.a.a(this.g, this.i);
        return this.e;
    }

    private d d(d d2) {
        q q2 = this.d.b(d2);
        this.b.a(this.e, this.e.c(), q2);
        this.f = this.a.k(this.e);
        d d3 = null;
        d3 = this.a(q2, this.f);
        this.a.d(q2, d3, this.f);
        d d4 = this.e;
        this.e = this.b.a(q2, this.g.d());
        d d5 = this.a.i(d3);
        if (d5.c() != q2) {
            d5 = this.a.c(d5);
        }
        this.a.a(q2, d5, this.e);
        this.a.c(d4, this.e);
        y.c.p p2 = this.i.b(this.e);
        this.a.a(this.e, p2);
        this.a.b(this.e, this.g);
        return d4;
    }

    private d e(d d2) {
        q q2 = this.d.b(d2);
        this.b.a(this.e, this.e.c(), q2);
        this.f = this.a.k(this.e);
        d d3 = this.a(q2, d2.d());
        d d4 = this.a.i(d3);
        if (d4.c() != q2) {
            d4 = this.a.c(d4);
        }
        this.a.a(q2, d4, this.f);
        d d5 = this.e;
        this.e = this.b.a(q2, this.g.d());
        this.a.d(q2, d3, this.e);
        y.c.p p2 = this.i.b(this.e);
        this.a.a(this.e, p2);
        this.a.b(this.e, this.g);
        this.a.c(this.e, d5);
        return d5;
    }

    /*
     * Unable to fully structure code
     */
    private d f(d var1_1) {
        block16 : {
            block15 : {
                var21_2 = a.c;
                var2_3 = this.d.c(var1_1);
                var3_4 = this.a.c(var2_3);
                var4_5 = null;
                var5_6 = null;
                var6_7 = null;
                var7_8 = null;
                var8_9 = var2_3.d();
                var9_10 = var2_3.c();
                var10_11 = null;
                var11_12 = this.c.a(var8_9);
                var12_13 = this.c.a(var9_10);
                var13_14 = false;
                if (var12_13 == var11_12.c()) {
                    var13_14 = true;
                    var14_15 = var8_9;
                    var8_9 = var9_10;
                    var9_10 = var14_15;
                    var15_16 = var11_12;
                    var11_12 = var12_13;
                    var12_13 = var15_16;
                    var16_17 = var3_4;
                    var3_4 = var2_3;
                    var2_3 = var16_17;
                }
                if (var11_12 != var12_13.c()) ** GOTO lbl77
                var10_11 = this.b.d();
                this.a.c(var10_11);
                var14_15 = this.c.a(var11_12, var10_11);
                var11_12.a((f)var14_15);
                if (!this.a.a(var3_4)) {
                    var15_16 = this.a.h(var3_4);
                    var16_17 = this.a.i(var3_4);
                    var17_18 = this.a.e(var3_4);
                    var18_22 = this.a.d(var17_18);
                    this.a.y(var17_18);
                    var6_7 = this.b.a(var8_9, var10_11);
                    var4_5 = this.a.k(var6_7);
                    var5_6 = this.b.a(var10_11, var9_10);
                    var7_8 = this.a.k(var5_6);
                    this.a.b(var6_7, var17_18);
                    this.a.b(var5_6, var17_18);
                    var19_26 = var18_22.a(var6_7, this.a.j(var3_4));
                    this.a.a(var6_7, var19_26);
                    var19_26 = var18_22.a(var5_6, this.a.j(var3_4));
                    this.a.a(var5_6, var19_26);
                    var18_22.remove(var3_4);
                    this.a.c(var6_7, (d)var16_17);
                    if (var15_16 != null && this.a.i((d)var15_16) != null) {
                        this.a.c((d)var15_16, var5_6);
                    }
                } else {
                    var15_16 = this.a.g(var2_3);
                    var16_17 = this.a.i(var2_3);
                    var17_19 = this.a.e(var2_3);
                    var18_23 = this.a.d(var17_19);
                    this.a.y(var17_19);
                    var4_5 = this.b.a(var10_11, var8_9);
                    var6_7 = this.a.k(var4_5);
                    var7_8 = this.b.a(var9_10, var10_11);
                    var5_6 = this.a.k(var7_8);
                    this.a.b(var4_5, var17_19);
                    this.a.b(var7_8, var17_19);
                    var19_27 = var18_23.a(var7_8, this.a.j(var2_3));
                    this.a.a(var7_8, var19_27);
                    var19_27 = var18_23.a(var4_5, this.a.j(var2_3));
                    this.a.a(var4_5, var19_27);
                    var18_23.remove(var2_3);
                    this.a.c(var4_5, (d)var16_17);
                    if (var15_16 != null && this.a.i((d)var15_16) != null) {
                        this.a.c((d)var15_16, var7_8);
                    }
                }
                this.a.e(var8_9, var3_4, var6_7);
                this.a.a(var10_11).add(var4_5);
                this.a.c(var9_10, var2_3, var7_8);
                this.a.a(var10_11).add(var5_6);
                this.g(var3_4);
                this.g(var2_3);
                ** GOTO lbl152
lbl77: // 1 sources:
                var10_11 = this.b.d();
                this.a.c(var10_11);
                var14_15 = (b)var11_12.c();
                var15_16 = this.c.a((b)var14_15, var10_11);
                var14_15.a((f)var15_16);
                if (this.a.a(var3_4)) ** GOTO lbl115
                var6_7 = this.b.a(var8_9, var10_11);
                var4_5 = this.a.k(var6_7);
                var5_6 = this.b.a(var10_11, var9_10);
                var7_8 = this.a.k(var5_6);
                var16_17 = this.a.e(var3_4);
                if (var16_17 != null) ** GOTO lbl-1000
                var17_20 = new y.c.f();
                this.a.a(var3_4, var17_20);
                var18_24 = var17_20.b(var6_7);
                this.a.a(var6_7, (y.c.p)var18_24);
                var18_24 = var17_20.b(var5_6);
                this.a.a(var5_6, (y.c.p)var18_24);
                this.a.b(var6_7, var3_4);
                this.a.b(var5_6, var3_4);
                this.a.y(var3_4);
                if (var21_2) lbl-1000: // 2 sources:
                {
                    this.a.y((d)var16_17);
                    var17_20 = this.a.d((d)var16_17);
                    var18_24 = this.a.h(var3_4);
                    var19_28 = this.a.g(var3_4);
                    var20_30 = var17_20.a(var6_7, this.a.j(var3_4));
                    this.a.a(var6_7, var20_30);
                    var20_30 = var17_20.a(var5_6, this.a.j(var3_4));
                    this.a.a(var5_6, var20_30);
                    var17_20.remove(var3_4);
                    this.a.b(var6_7, (d)var16_17);
                    this.a.b(var5_6, (d)var16_17);
                    if (var18_24 != null && this.a.i((d)var18_24) == var3_4) {
                        this.a.c((d)var18_24, var5_6);
                    }
                    if (var19_28 != null && this.a.i(var19_28) == var3_4) {
                        this.a.c(var19_28, var6_7);
                    }
                }
                ** GOTO lbl146
lbl115: // 1 sources:
                var7_8 = this.b.a(var9_10, var10_11);
                var5_6 = this.a.k(var7_8);
                var4_5 = this.b.a(var10_11, var8_9);
                var6_7 = this.a.k(var4_5);
                var16_17 = this.a.e(var2_3);
                if (var16_17 != null) ** GOTO lbl-1000
                var17_21 = new y.c.f();
                this.a.a(var2_3, var17_21);
                var18_25 = var17_21.b(var7_8);
                this.a.a(var7_8, (y.c.p)var18_25);
                var18_25 = var17_21.b(var4_5);
                this.a.a(var4_5, (y.c.p)var18_25);
                this.a.b(var7_8, var2_3);
                this.a.b(var4_5, var2_3);
                this.a.y(var2_3);
                if (var21_2) lbl-1000: // 2 sources:
                {
                    this.a.y((d)var16_17);
                    var17_21 = this.a.d((d)var16_17);
                    var18_25 = this.a.h(var2_3);
                    var19_29 = this.a.g(var2_3);
                    var20_31 = var17_21.a(var7_8, this.a.j(var2_3));
                    this.a.a(var7_8, var20_31);
                    var20_31 = var17_21.a(var4_5, this.a.j(var2_3));
                    this.a.a(var4_5, var20_31);
                    var17_21.remove(var2_3);
                    this.a.b(var7_8, (d)var16_17);
                    this.a.b(var4_5, (d)var16_17);
                    if (var18_25 != null && this.a.i((d)var18_25) == var2_3) {
                        this.a.c((d)var18_25, var4_5);
                    }
                    if (var19_29 != null && this.a.i(var19_29) == var2_3) {
                        this.a.c(var19_29, var7_8);
                    }
                }
lbl146: // 6 sources:
                this.a.c(var8_9, var3_4, var6_7);
                this.a.a(var10_11).add(var4_5);
                this.a.c(var9_10, var2_3, var7_8);
                this.a.a(var10_11).add(var5_6);
                this.g(var3_4);
                this.g(var2_3);
lbl152: // 2 sources:
                this.a.y(this.g);
                this.b.a(this.e, this.e.c(), var10_11);
                var14_15 = this.e;
                var15_16 = this.a.k((d)var14_15);
                if (var13_14) {
                    this.a.a(var10_11, var4_5, (d)var15_16);
                    if (!var21_2) break block15;
                }
                this.a.a(var10_11, var5_6, (d)var15_16);
            }
            this.e = this.b.a(var10_11, this.g.d());
            if (var13_14) {
                this.a.a(var10_11, var5_6, this.e);
                if (!var21_2) break block16;
            }
            this.a.a(var10_11, var4_5, this.e);
        }
        this.a.b(this.e, this.g);
        var16_17 = this.i.b(this.e);
        this.a.a(this.e, (y.c.p)var16_17);
        return var14_15;
    }

    private d a(q q2, d d2) {
        d d3;
        boolean bl2 = a.c;
        d d4 = this.a.l(d2);
        while (d4.c() != q2) {
            d3 = this.a.l(d4);
            if (bl2) return d3;
            d4 = d3;
            if (!bl2) continue;
        }
        d3 = d4;
        return d3;
    }

    private d a(q q2, q q3) {
        d d2 = null;
        p p2 = this.d.a(q3);
        y.c.e e2 = p2.a();
        while (e2.f()) {
            if (e2.a().c() == q2) {
                return e2.a();
            }
            e2.g();
        }
        return d2;
    }

    private void a(p p2, d d2) {
        p[] arrp;
        block2 : {
            q q2 = d2.d();
            if (this.a.d(q2)) {
                arrp = this.a.a(p2, d2, q2);
                if (!a.c) break block2;
            }
            arrp = this.a.a(p2, d2);
        }
        this.d.a(p2, arrp);
    }

    private void g(d d2) {
        if (this.a.n(d2)) {
            this.b.a(d2);
            if (!a.c) return;
        }
        this.b.d(d2);
    }
}

