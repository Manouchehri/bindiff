/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.util.Comparator;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.p;
import y.c.q;
import y.f.a.f;
import y.f.a.y;
import y.f.k.o;

class x
extends o {
    A n;
    h o;
    h p;
    boolean q = false;
    double r = 90.0;
    private boolean t = false;

    x() {
    }

    public void a(h h2) {
        this.p = h2;
    }

    @Override
    protected void a(q q2) {
        if (this.t) {
            return;
        }
        if (this.n()) {
            y y2 = new y(this);
            q2.b(y2);
            if (f.u == 0) return;
        }
        super.a(q2);
    }

    void a(h h2, A a2) {
        this.n = a2;
        this.o = h2;
        this.q = true;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void b(q var1_1) {
        var27_2 = f.u;
        if (!this.d(var1_1)) {
            super.b(var1_1);
            return;
        }
        var2_3 = this.q();
        var4_4 = this.c(var1_1);
        var6_5 = this.r;
        var8_6 = new y.c.f(var1_1.l());
        block0 : do {
            block21 : {
                var9_7 = (360.0 - var4_4) / 2.0 + var4_4;
                var11_8 = var9_7 - var4_4;
                var13_9 = this.f(var1_1);
                var13_9 = (360.0 - var4_4) / 2.0;
                var15_10 = null;
                var16_11 = null;
                for (var17_13 = var8_6.k(); var17_13 != null; var13_9 += var20_17.a(), var17_13 = var17_13.a()) {
                    block22 : {
                        var18_15 = (d)var17_13.c();
                        var19_16 = var18_15.d();
                        var20_17 = this.e((q)var19_16);
                        var21_19 = this.o.c(var18_15);
                        var23_22 = var21_19 - (var13_9 + var20_17.c);
                        v0 = var23_22 DCMPL 0.0;
                        if (var27_2 != 0) break block21;
                        if (v0 < 0 || var21_19 + var20_17.b < var9_7) ** GOTO lbl29
                        if (var13_9 + var20_17.a() > var9_7) ** GOTO lbl-1000
                        var23_22 = var9_7 - var13_9 - var20_17.a();
                        if (var27_2 != 0) lbl-1000: // 2 sources:
                        {
                            var23_22 = 2.0 * (var9_7 - (var21_19 + var20_17.b));
                        }
lbl29: // 4 sources:
                        var20_17.d = 0.0;
                        if (var23_22 >= 0.0) {
                            var20_17.d = var23_22;
                            var15_10 = var17_13;
                            var16_11 = var20_17;
                            if (var27_2 == 0) continue;
                        }
                        if (- var23_22 > var20_17.b + var20_17.c) {
                            var23_22 = (var20_17.b + var20_17.c) / 2.0;
                            if (var27_2 == 0) break block22;
                        }
                        var23_22 /= -2.0;
                    }
                    if ((var13_9 -= var23_22) <= var9_7 && var13_9 + var20_17.a() > var9_7) {
                        var23_22 = (var13_9 += var23_22) + var20_17.a() - var9_7;
                        var13_9 -= var23_22;
                    }
                    while (var15_10 != null) {
                        v0 = var23_22 DCMPL var16_11.d;
                        if (var27_2 == 0) {
                            if (v0 <= 0) break;
                            var23_22 -= var16_11.d;
                            var16_11.d = 0.0;
                            if ((var15_10 = var15_10.b()) == null) {
                                var16_11 = null;
                                break;
                            }
                            var16_11 = this.e(((d)var15_10.c()).d());
                            if (var27_2 == 0) continue;
                        }
                        break block21;
                    }
                    if (var15_10 != null) {
                        var16_11.d -= var23_22;
                        if (var27_2 == 0) continue;
                    }
                    var13_9 += var23_22;
                    if (var27_2 == 0) continue;
                }
                v0 = var13_9 DCMPG var9_7;
            }
            if (v0 <= 0) {
                block23 : {
                    var17_14 = 0.0;
                    var13_9 = (360.0 - var4_4) / 2.0;
                    var19_16 = var1_1.l();
                    while (var19_16.f()) {
                        var20_17 = var19_16.a();
                        var21_20 = var20_17.d();
                        var22_21 = this.o.c(var20_17);
                        var24_23 = this.e(var21_20);
                        var25_24 = var13_9 + var24_23.d + var24_23.c;
                        v1 = var17_14 DCMPG Math.abs(var25_24 - var22_21);
                        if (var27_2 == 0) {
                            if (v1 < 0) {
                                var17_14 = Math.abs(var25_24 - var22_21);
                            }
                            var13_9 += var24_23.a();
                            var19_16.g();
                            if (var27_2 == 0) continue;
                        }
                        break block23;
                    }
                    v1 = var17_14 DCMPG this.r;
                }
                if (v1 <= 0) {
                    return;
                }
            }
            var17_12 = false;
            do {
                block24 : {
                    var18_15 = var1_1.o();
                    while (var18_15.f()) {
                        var19_16 = var18_15.e();
                        var20_18 = this.e((q)var19_16).e;
                        v2 = Double.isInfinite(var20_18 *= 1.0 + var2_3);
                        if (var27_2 == 0) {
                            if (v2) {
                                var20_18 = this.r();
                                var17_12 = true;
                            }
                            this.e((q)var19_16).e = var20_18;
                            var18_15.g();
                            if (var27_2 == 0) continue;
                        }
                        break block24;
                    }
                    v2 = var17_12;
                }
                if (!v2) continue block0;
                this.r += 10.0;
            } while (var27_2 != 0);
        } while (true);
    }

    @Override
    protected double c(q q2) {
        if (!this.d(q2)) {
            return super.c(q2);
        }
        if (q2.b() != 0) return this.p();
        return this.o();
    }

    boolean d(q q2) {
        if (!this.q) return false;
        if (q2.c() == 0) {
            return false;
        }
        if (this.o.b(q2.f()) == null) return false;
        return true;
    }
}

