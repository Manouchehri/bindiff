/*
 * Decompiled with CFR 0_115.
 */
package y.d;

import y.c.D;
import y.c.p;
import y.d.d;
import y.d.t;

public class c {
    private double a;
    private D b;
    private double c;

    public c(double d2) {
        this(-1.7976931348623157E308, Double.MAX_VALUE, d2);
    }

    public c(double d2, double d3, double d4) {
        if (d2 > d3) {
            throw new IllegalArgumentException(new StringBuffer().append("min (").append(d2).append(") must not be greater than max(").append(d3).append(")").toString());
        }
        this.b = new D();
        d d5 = d.a(d2, d4, 0.0);
        d5.a = this.b.a(d5);
        d d6 = d.a(d3, 0.0, 0.0);
        d6.a = this.b.b(d6);
    }

    public c(double d2, double d3, double d4, double d5) {
        if (d2 > d3) {
            throw new IllegalArgumentException(new StringBuffer().append("min (").append(d2).append(") must not be greater than max(").append(d3).append(")").toString());
        }
        this.b = new D();
        double d6 = d2 != d3 ? (d5 - d4) / (d3 - d2) : 0.0;
        d d7 = d.a(d2, d4, d6);
        d7.a = this.b.a(d7);
        d d8 = d.a(d3, 0.0, 0.0);
        d8.a = this.b.b(d8);
    }

    private c() {
    }

    /*
     * Unable to fully structure code
     */
    public c a(boolean var1_1, boolean var2_2) {
        var6_3 = t.d;
        var3_4 = new D();
        if (!var2_2) ** GOTO lbl-1000
        for (var4_5 = this.b.l().b(); var4_5 != null; var4_5 = var4_5.b()) {
            block7 : {
                if (var1_1) {
                    var5_6 = d.a(- this.d((p)var4_5), - this.a((p)var4_5), this.c((p)var4_5));
                    if (!var6_3) break block7;
                }
                var5_6 = d.a(- this.d((p)var4_5), this.a((p)var4_5), - this.c((p)var4_5));
            }
            var5_6.a = var3_4.b(var5_6);
            if (!var6_3) continue;
        }
        var4_5 = d.a(- this.a(), 0.0, 0.0);
        var4_5.a = var3_4.b(var4_5);
        if (var6_3) lbl-1000: // 3 sources:
        {
            for (var4_5 = this.b.k(); var4_5 != null; var4_5 = var4_5.a()) {
                block8 : {
                    if (var1_1) {
                        var5_6 = d.a(this.b((p)var4_5), - this.a((p)var4_5), - this.c((p)var4_5));
                        if (!var6_3) break block8;
                    }
                    var5_6 = d.a(this.b((p)var4_5), this.a((p)var4_5), this.c((p)var4_5));
                }
                var5_6.a = var3_4.b(var5_6);
                if (!var6_3) continue;
            }
        }
        var4_5 = new c();
        var4_5.c = 0.0;
        var4_5.a = 0.0;
        var4_5.b = var3_4;
        return var4_5;
    }

    public void a(double d2, double d3, double d4) {
        this.a(new c(d2, d3, d4), false, true);
    }

    public void b(double d2, double d3, double d4) {
        this.a(new c(d2, d3, d4), true, true);
    }

    public void c(double d2, double d3, double d4) {
        this.a(d2, d3, d4, 0.0);
    }

    /*
     * Unable to fully structure code
     */
    public void a(double var1_1, double var3_2, double var5_3, double var7_4) {
        block12 : {
            var15_5 = t.d;
            if (var1_1 > var3_2) {
                throw new IllegalArgumentException(new StringBuffer().append("min (").append(var1_1).append(") must not be greater than max(").append(var3_2).append(")").toString());
            }
            if (var1_1 > this.a()) ** GOTO lbl19
            if (var3_2 >= this.b()) {
                this.b.clear();
                var11_6 = d.a(var1_1, var5_3, var7_4);
                var11_6.a = this.b.a(var11_6);
                var12_9 = d.a(var3_2, 0.0, 0.0);
                var12_9.a = this.b.b(var12_9);
                this.c = 0.0;
                this.a = 0.0;
                return;
            }
            var9_12 = null;
            var10_13 = this.d(var3_2);
            var3_2 -= this.c;
            var1_1 -= this.c;
            if (!var15_5) ** GOTO lbl31
lbl19: // 2 sources:
            var9_12 = this.d(var1_1 -= this.c);
            if (var3_2 < this.b()) ** GOTO lbl-1000
            var10_13 = this.b.l();
            var3_2 -= this.c;
            if (var15_5) lbl-1000: // 2 sources:
            {
                var10_13 = var9_12.a();
                while (((d)var10_13.c()).c <= (var3_2 -= this.c)) {
                    var10_13 = var10_13.a();
                    if (!var15_5) {
                        if (!var15_5) continue;
                    }
                    break block12;
                }
                var10_13 = var10_13.b();
            }
lbl31: // 4 sources:
            var5_3 -= this.a;
        }
        if (var9_12 == var10_13) {
            var11_7 = (d)var10_13.c();
            var12_10 = d.a(var3_2, var11_7.a(var3_2), var11_7.d);
            var12_10.a = this.b.b(var12_10, var11_7.a);
            if (var11_7.c == var1_1) {
                var11_7.b = var5_3;
                var11_7.d = var7_4;
                if (var15_5 == false) return;
            }
            var13_14 = d.a(var1_1, var5_3, var7_4);
            var13_14.a = this.b.b(var13_14, var11_7.a);
            return;
        }
        if (var9_12 != null) ** GOTO lbl48
        var11_8 = d.a(var1_1, var5_3, var7_4);
        var9_12 = var11_8.a = this.b.a(var11_8);
        if (!var15_5) ** GOTO lbl55
lbl48: // 2 sources:
        var11_8 = (d)var9_12.c();
        if (var11_8.c != var1_1) ** GOTO lbl-1000
        var11_8.b = var5_3;
        var11_8.d = var7_4;
        if (var15_5) lbl-1000: // 2 sources:
        {
            var12_11 = d.a(var1_1, var5_3, var7_4);
            var9_12 = var12_11.a = this.b.b(var12_11, var11_8.a);
        }
lbl55: // 4 sources:
        if (var10_13 != null) {
            var11_8 = (d)var10_13.c();
            var11_8.b = var11_8.a(var3_2);
            var11_8.c = var3_2;
        }
        var11_8 = var9_12.b() != null ? (d)var9_12.b().c() : null;
        var12_11 = (d)var9_12.c();
        if (var11_8 != null && var11_8.d == var12_11.d && var11_8.a(var12_11.c) == var12_11.b) {
            var9_12 = var9_12.b();
        }
        var13_15 = var10_13 != null && var10_13.b() != null ? (d)var10_13.b().c() : null;
        v0 = var14_16 = var10_13 != null ? (d)var10_13.c() : null;
        if (var10_13 != null && var10_13 != this.b.l() && var13_15 != null && var13_15.d == var14_16.d && var13_15.a(var14_16.c) == var14_16.b) {
            var10_13 = var10_13.a();
        }
        var9_12 = var9_12.a();
        do {
            if (var9_12 == var10_13) return;
            this.b.h(var9_12);
            var9_12 = var9_12.a();
        } while (!var15_5);
    }

    public void a(double d2) {
        this.a += d2;
    }

    public void b(double d2) {
        this.c += d2;
    }

    public double a() {
        return ((d)this.b.f()).c + this.c;
    }

    public double b() {
        return ((d)this.b.i()).c + this.c;
    }

    public double c() {
        return this.b(this.a(), this.b());
    }

    public double d() {
        return this.a(this.a(), this.b());
    }

    public double a(p p2, double d2) {
        d d3 = (d)p2.c();
        return this.a(d3, d2);
    }

    public double a(d d2, double d3) {
        if ((d3 -= this.c) - 0.01 > d2.a()) throw new IllegalArgumentException(new StringBuffer().append(d3).append(" is outside of ").append(d2).toString());
        if (d3 + 0.01 >= d2.c) return d2.a(d3) + this.a;
        throw new IllegalArgumentException(new StringBuffer().append(d3).append(" is outside of ").append(d2).toString());
    }

    public void a(c c2) {
        this.a(c2, true, false);
    }

    public void b(c c2) {
        this.a(c2, false, false);
    }

    private static t a(d d2, d d3) {
        if (d2.d == d3.d) {
            return null;
        }
        if (d2.d == 0.0) {
            double d4 = d2.b;
            double d5 = d3.c;
            double d6 = d3.b;
            double d7 = d3.d;
            double d8 = d5 + (d4 - d6) / d7;
            return new t(d8, d4);
        }
        if (d3.d == 0.0) {
            double d9 = d3.b;
            double d10 = d2.c;
            double d11 = d2.b;
            double d12 = d2.d;
            double d13 = d10 + (d9 - d11) / d12;
            return new t(d13, d9);
        }
        double d14 = Math.max(d2.c, d3.c);
        double d15 = d2.a(d14);
        double d16 = d3.a(d14);
        double d17 = d16 - d15;
        double d18 = d2.d - d3.d;
        if (d17 == 0.0) {
            return new t(d14, d15);
        }
        if (d17 * d18 <= 0.0) {
            return null;
        }
        double d19 = d14 + d17 / d18;
        return new t(d19, d2.a(d19));
    }

    /*
     * Unable to fully structure code
     */
    private void a(c var1_1, boolean var2_2, boolean var3_3) {
        block48 : {
            block47 : {
                block44 : {
                    var53_4 = t.d;
                    var4_5 = var3_3 != false && this.b.size() <= var1_1.b.size();
                    var5_6 = var4_5 != false ? var1_1.c : this.c;
                    var7_7 = var4_5 != false ? var1_1.a : this.a;
                    var9_8 = var2_2 != false ? -1.7976931348623157E308 : Double.MAX_VALUE;
                    var11_9 = this.a();
                    var13_10 = var1_1.a();
                    var15_11 = this.b();
                    var17_12 = var1_1.b();
                    var19_13 = this.b;
                    var20_14 = var1_1.b;
                    var22_16 = var20_14.k();
                    var23_17 = new D();
                    if (var15_11 < var13_10) {
                        if (var4_5) {
                            for (var21_15 = var19_13.k(); var21_15 != null; var26_18.c += this.c - var1_1.c, var26_18.b += this.a - var1_1.a, var21_15 = var21_15.a()) {
                                var26_18 = (d)var21_15.c();
                                if (!var53_4) {
                                    if (!var53_4) continue;
                                }
                                break;
                            }
                        } else {
                            ((d)var19_13.i()).b = var9_8 - var7_7;
                        }
                        while (var22_16 != null) {
                            var26_18 = var22_16;
                            var22_16 = var22_16.a();
                            if (var53_4 != false) return;
                            if (var3_3) {
                                var20_14.h((p)var26_18);
                                if (!var4_5) {
                                    var27_22 = (d)var26_18.c();
                                    var27_22.b = var1_1.a((p)var26_18) - this.a;
                                    var27_22.c = var1_1.b((p)var26_18) - this.c;
                                }
                                var19_13.a((p)var26_18);
                                if (!var53_4) continue;
                            }
                            var27_22 = d.a(var1_1.b((p)var26_18) - var5_6, var1_1.a((p)var26_18) - var7_7, var1_1.c((p)var26_18));
                            var27_22.a = var19_13.b(var27_22);
                            if (!var53_4) continue;
                        }
                        this.c = var5_6;
                        this.a = var7_7;
                        return;
                    }
                    if (var17_12 < var11_9) ** GOTO lbl105
                    if (!c.c(var11_9, var13_10)) ** GOTO lbl45
                    var24_26 = d.a(var11_9, this.a(var21_15), this.c(var21_15));
                    var25_27 = d.a(var11_9, var1_1.a(var22_16), var1_1.c(var22_16));
                    if (!var53_4) ** GOTO lbl101
lbl45: // 2 sources:
                    if (var11_9 >= var13_10) ** GOTO lbl-1000
                    if (!var4_5 && Math.abs(var11_9 - var13_10) >= Math.abs(var15_11 - var13_10)) ** GOTO lbl-1000
                    var26_20 = var21_15;
                    if (var4_5) {
                        var27_24 = (d)var26_20.c();
                        var27_24.c += this.c - var1_1.c;
                        var27_24.b += this.a - var1_1.a;
                    }
                    var19_13.h(var26_20);
                    var23_17.a(var26_20);
                    var27_24 = var19_13.l();
                    for (var21_15 = var21_15.a(); var21_15 != var27_24 && this.b(var21_15) < var13_10; var21_15 = var21_15.a()) {
                        var26_20 = var21_15;
                        if (var4_5) {
                            var28_28 = (d)var26_20.c();
                            var28_28.c += this.c - var1_1.c;
                            var28_28.b += this.a - var1_1.a;
                        }
                        var19_13.h(var26_20);
                        var23_17.a(var26_20);
                        if (!var53_4) continue;
                    }
                    var28_28 = var23_17.l();
                    var24_26 = d.a(var13_10, var4_5 != false ? var1_1.a((p)var28_28, var13_10) : this.a((p)var28_28, var13_10), this.c((p)var28_28));
                    if (var53_4) lbl-1000: // 2 sources:
                    {
                        var23_17.a(var19_13);
                        var26_20 = var21_15 = var23_17.l();
                        var23_17.h(var26_20);
                        var19_13.b(var26_20);
                        var27_24 = var23_17.k();
                        for (var21_15 = var21_15.b(); var21_15 != var27_24 && this.b(var21_15) >= var13_10; var21_15 = var21_15.b()) {
                            var26_20 = var21_15;
                            var23_17.h(var26_20);
                            var19_13.b(var26_20);
                            if (!var53_4) continue;
                        }
                        var21_15 = var26_20;
                        var28_28 = var23_17.l();
                        var24_26 = d.a(var13_10, this.a((p)var28_28, var13_10), this.c((p)var28_28));
                    }
                    var25_27 = d.a(var1_1.b(var22_16), var1_1.a(var22_16), var1_1.c(var22_16));
                    if (var53_4) lbl-1000: // 2 sources:
                    {
                        var26_20 = var20_14.l();
                        while (var22_16 != var26_20 && var1_1.b(var22_16) < var11_9) {
                            var27_24 = var22_16;
                            var22_16 = var22_16.a();
                            if (var3_3) {
                                var20_14.h((p)var27_24);
                                if (!var4_5) {
                                    var28_28 = (d)var27_24.c();
                                    var28_28.b = var1_1.a((p)var27_24) - this.a;
                                    var28_28.c = var1_1.b((p)var27_24) - this.c;
                                }
                                var23_17.a((p)var27_24);
                                if (!var53_4) continue;
                            }
                            var28_28 = d.a(var1_1.b((p)var27_24) - var5_6, var1_1.a((p)var27_24) - var7_7, var1_1.c((p)var27_24));
                            var28_28.a = var23_17.b(var28_28);
                            if (!var53_4) continue;
                        }
                        var27_24 = var23_17.l();
                        var28_28 = (d)var27_24.c();
                        var24_26 = d.a(var11_9, this.a(var21_15, var11_9), this.c(var21_15));
                        var25_27 = d.a(var11_9, var28_28.a(var11_9 - var5_6) + var7_7, this.c((d)var28_28));
                    }
lbl101: // 4 sources:
                    var26_21 = Math.max(var11_9, var13_10);
                    var28_29 = var24_26.a(var26_21);
                    var30_30 = var25_27.a(var26_21);
                    ** GOTO lbl138
lbl105: // 1 sources:
                    ((d)var20_14.i()).b = var9_8 - var7_7;
                    while (var22_16 != null) {
                        var26_19 = var22_16;
                        v0 = var22_16 = var22_16.a();
                        if (!var53_4) {
                            v1 = var27_23 = v0 == null ? var9_8 : var1_1.a((p)var26_19);
                            if (var3_3) {
                                var20_14.h((p)var26_19);
                                if (!var4_5) {
                                    var29_25 = (d)var26_19.c();
                                    var29_25.b = var27_23 - this.a;
                                    var29_25.c = var1_1.b((p)var26_19) - this.c;
                                }
                                var23_17.a((p)var26_19);
                                if (!var53_4) continue;
                            }
                            var29_25 = d.a(var1_1.b((p)var26_19) - var5_6, var27_23 - var7_7, var1_1.c((p)var26_19));
                            var29_25.a = var23_17.b(var29_25);
                            if (!var53_4) continue;
                        }
                        ** GOTO lbl126
                    }
                    if (var4_5) {
                        do {
                            v0 = var21_15;
lbl126: // 2 sources:
                            if (v0 == null) break;
                            var26_19 = (d)var21_15.c();
                            var26_19.c += this.c - var1_1.c;
                            var26_19.b += this.a - var1_1.a;
                            var21_15 = var21_15.a();
                            if (var53_4 != false) return;
                        } while (!var53_4);
                    }
                    var23_17.a(var19_13);
                    this.b = var23_17;
                    this.c = var5_6;
                    this.a = var7_7;
                    return;
lbl138: // 6 sources:
                    while (var21_15 != null) {
                        block46 : {
                            v2 = var22_16;
                            if (var53_4) break block44;
                            if (v2 == null) break;
                            var32_31 = var26_21;
                            var34_34 = null;
                            var35_35 = false;
                            var36_36 = this.b(var21_15);
                            if (var36_36 == var32_31) {
                                block45 : {
                                    var24_26.c = var32_31;
                                    var24_26.b = this.a(var21_15);
                                    var24_26.d = this.c(var21_15);
                                    var34_34 = var21_15;
                                    var21_15 = var21_15.a();
                                    var19_13.h(var34_34);
                                    var35_35 = true;
                                    if (var21_15 == null) {
                                        var24_26.b = var9_8;
                                        var26_21 = Double.MAX_VALUE;
                                        if (!var53_4) break block45;
                                    }
                                    var26_21 = this.b(var21_15);
                                }
                                var28_29 = var24_26.a(var32_31);
                            } else {
                                var26_21 = var36_36;
                            }
                            var38_37 = var1_1.b(var22_16);
                            if (var38_37 != var32_31) ** GOTO lbl-1000
                            var25_27.c = var32_31;
                            var25_27.b = var1_1.a(var22_16);
                            var25_27.d = var1_1.c(var22_16);
                            if (var34_34 != null) ** GOTO lbl175
                            var34_34 = var22_16;
                            var22_16 = var22_16.a();
                            if (!var3_3) ** GOTO lbl181
                            var20_14.h(var34_34);
                            var35_35 = true;
                            if (!var53_4) ** GOTO lbl181
lbl175: // 2 sources:
                            if (!var3_3) ** GOTO lbl-1000
                            var40_38 = var22_16;
                            var22_16 = var22_16.a();
                            var20_14.h((p)var40_38);
                            if (var53_4) lbl-1000: // 2 sources:
                            {
                                var22_16 = var22_16.a();
                            }
lbl181: // 5 sources:
                            if (var22_16 == null) {
                                var25_27.b = var9_8;
                                var25_27.d = 0.0;
                                if (!var53_4) break block46;
                            }
                            var26_21 = Math.min(var26_21, var1_1.b(var22_16));
                        }
                        var30_30 = var25_27.a(var32_31);
                        if (var53_4) lbl-1000: // 2 sources:
                        {
                            var26_21 = Math.min(var26_21, var38_37);
                        }
                        if (var26_21 == Double.MAX_VALUE && var15_11 != Double.MAX_VALUE) {
                            var40_38 = (d)var34_34.c();
                            if (var35_35) {
                                var40_38.c = var32_31 - var5_6;
                                var40_38.b = var9_8 - var7_7;
                                var40_38.d = 0.0;
                                var23_17.a(var34_34);
                                if (!var53_4) continue;
                            }
                            var41_40 = d.a(var40_38.c, var40_38.b, var40_38.d);
                            var41_40.a = var23_17.b(var41_40);
                            if (!var53_4) continue;
                        }
                        var40_39 = var28_29;
                        var42_41 = var30_30;
                        var28_29 = var24_26.a(var26_21);
                        var30_30 = var25_27.a(var26_21);
                        var44_42 = var2_2 != false && var40_39 >= var42_41 || var2_2 == false && var40_39 <= var42_41;
                        v3 = var45_43 = var2_2 != false && var28_29 >= var30_30 || var2_2 == false && var28_29 <= var30_30;
                        if (var44_42 != var45_43) ** GOTO lbl210
                        var46_44 = var44_42;
                        if (!var53_4) ** GOTO lbl221
lbl210: // 2 sources:
                        if (!c.c(var40_39, var42_41)) ** GOTO lbl213
                        var46_44 = var45_43;
                        if (!var53_4) ** GOTO lbl221
lbl213: // 2 sources:
                        if (!c.c(var28_29, var30_30)) ** GOTO lbl-1000
                        var46_44 = var44_42;
                        if (var53_4) lbl-1000: // 2 sources:
                        {
                            var47_46 = c.a(var24_26, var25_27);
                            var26_21 = var47_46.a();
                            var28_29 = var47_46.b();
                            var30_30 = var47_46.b();
                            var46_44 = var44_42;
                        }
lbl221: // 5 sources:
                        var47_45 = var46_44 != false ? var24_26.d : var25_27.d;
                        var49_47 = var46_44 != false ? var40_39 : var42_41;
                        v4 = var51_48 = var23_17.isEmpty() == false ? (d)var23_17.i() : null;
                        if (var51_48 != null && var51_48.d == var47_45 && c.c(var51_48.a(var32_31 - var5_6) + var7_7, var49_47)) continue;
                        if (var34_34 != null && var35_35) {
                            var52_49 = (d)var34_34.c();
                            var52_49.c = var32_31 - var5_6;
                            var52_49.b = var49_47 - var7_7;
                            var52_49.d = var47_45;
                            var23_17.a(var34_34);
                            if (!var53_4) continue;
                        }
                        var52_49 = d.a(var32_31 - var5_6, var49_47 - var7_7, var47_45);
                        var52_49.a = var23_17.b(var52_49);
                        if (!var53_4) continue;
                    }
                    v2 = var21_15;
                }
                if (v2 == null) ** GOTO lbl252
                if (var4_5) ** GOTO lbl-1000
                var23_17.a(var19_13);
                if (var53_4) lbl-1000: // 3 sources:
                {
                    while (var21_15 != null) {
                        var32_32 = (d)var21_15.c();
                        var32_32.c += this.c - var1_1.c;
                        var32_32.b += this.a - var1_1.a;
                        var33_50 = var21_15;
                        var21_15 = var21_15.a();
                        var19_13.h((p)var33_50);
                        var23_17.a((p)var33_50);
                        if (!var53_4) {
                            if (!var53_4) continue;
                        }
                        break block47;
                    }
                }
lbl252: // 7 sources:
                while (var22_16 != null) {
                    var32_33 = var22_16;
                    var22_16 = var22_16.a();
                    v5 = var3_3;
                    if (!var53_4) {
                        if (v5) {
                            var20_14.h(var32_33);
                            if (!var4_5) {
                                var33_50 = (d)var32_33.c();
                                var33_50.c += var1_1.c - this.c;
                                var33_50.b += var1_1.a - this.a;
                            }
                            var23_17.a(var32_33);
                            if (!var53_4) continue;
                        }
                        var33_50 = d.a(var1_1.b(var32_33) - var5_6, var1_1.a(var32_33) - var7_7, var1_1.c(var32_33));
                        var33_50.a = var23_17.b(var33_50);
                        if (!var53_4) continue;
                    }
                    break block48;
                }
            }
            v5 = var4_5;
        }
        if (v5) {
            this.c = var1_1.c;
            this.a = var1_1.a;
        }
        this.b = var23_17;
    }

    private static boolean c(double d2, double d3) {
        if (Math.abs(d2 - d3) >= 0.001) return false;
        return true;
    }

    private double a(p p2) {
        return this.a((d)p2.c());
    }

    private double b(p p2) {
        return this.b((d)p2.c());
    }

    private double c(p p2) {
        return this.c((d)p2.c());
    }

    private double d(p p2) {
        if (p2.a() != null) return ((d)p2.a().c()).c + this.c;
        throw new IllegalArgumentException("Cell is unbound!");
    }

    private p d(double d2) {
        p p2;
        boolean bl2 = t.d;
        p p3 = this.b.k();
        double d3 = ((d)p3.c()).c;
        double d4 = ((d)this.b.i()).c;
        if ((d2 -= this.c) < d3) return null;
        if (d2 > d4) {
            return null;
        }
        if (d2 == d4) {
            return this.b.l();
        }
        double d5 = ((d)p3.a().c()).c;
        while (d2 >= d5) {
            p3 = p3.a();
            p2 = p3.a();
            if (bl2) return p2;
            d5 = ((d)p2.c()).c;
            if (!bl2) continue;
        }
        p2 = p3;
        return p2;
    }

    public double a(d d2) {
        return this.a + d2.b;
    }

    public double b(d d2) {
        return d2.c + this.c;
    }

    public double c(d d2) {
        return d2.d;
    }

    public d c(double d2) {
        p p2 = this.d(d2);
        if (p2 == null) return null;
        d d3 = (d)p2.c();
        return d3;
    }

    public double d(d d2) {
        if (d2.a.a() != null) return ((d)d2.a.a().c()).c + this.c;
        throw new IllegalArgumentException("Segment is unbound!");
    }

    public d e() {
        p p2 = this.b.k();
        if (p2 == null) return null;
        d d2 = (d)p2.c();
        return d2;
    }

    public d f() {
        p p2 = this.b.l().b();
        return (d)p2.c();
    }

    public d e(d d2) {
        if (d2.a.a() == this.b.l()) return null;
        return (d)d2.a.a().c();
    }

    /*
     * Unable to fully structure code
     */
    public double a(double var1_1, double var3_2) {
        var22_3 = t.d;
        var5_4 = this.a();
        var7_5 = this.b();
        var9_6 = var1_1;
        var11_7 = var3_2;
        if (var7_5 <= var5_4) return Double.MAX_VALUE;
        if (var11_7 <= var9_6) {
            return Double.MAX_VALUE;
        }
        var13_8 = Math.max(var5_4, var9_6);
        if (var13_8 >= (var15_9 = Math.min(var7_5, var11_7))) {
            return -1.7976931348623157E308;
        }
        var17_10 = var13_8;
        if (var5_4 != var9_6) ** GOTO lbl16
        var19_11 = this.e();
        if (!var22_3) ** GOTO lbl20
lbl16: // 2 sources:
        if (var5_4 >= var9_6) ** GOTO lbl-1000
        var19_11 = this.c(var17_10);
        if (var22_3) lbl-1000: // 2 sources:
        {
            var19_11 = this.e();
        }
lbl20: // 4 sources:
        var20_12 = var19_11.a(var13_8 - this.c) + this.a;
        var17_10 = this.d(var19_11);
        if (var17_10 < var15_9) {
            var19_11 = this.e(var19_11);
        }
        do {
            if (var17_10 >= var15_9) return Math.max(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            if (var19_11 == this.b.i()) return Math.max(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            var20_12 = Math.max(var20_12, this.a(var19_11));
            var20_12 = Math.max(var20_12, this.a(var19_11, this.d(var19_11)));
            var17_10 = this.d(var19_11);
            if (var17_10 >= var15_9) return Math.max(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            var19_11 = this.e(var19_11);
        } while (!var22_3);
        return Math.max(var20_12, var19_11.a(var15_9 - this.c) + this.a);
    }

    /*
     * Unable to fully structure code
     */
    public double b(double var1_1, double var3_2) {
        var22_3 = t.d;
        var5_4 = this.a();
        var7_5 = this.b();
        var9_6 = var1_1;
        var11_7 = var3_2;
        if (var7_5 <= var5_4) return Double.MAX_VALUE;
        if (var11_7 <= var9_6) {
            return Double.MAX_VALUE;
        }
        var13_8 = Math.max(var5_4, var9_6);
        if (var13_8 >= (var15_9 = Math.min(var7_5, var11_7))) {
            return Double.MAX_VALUE;
        }
        var17_10 = var13_8;
        if (var5_4 != var9_6) ** GOTO lbl16
        var19_11 = this.e();
        if (!var22_3) ** GOTO lbl20
lbl16: // 2 sources:
        if (var5_4 >= var9_6) ** GOTO lbl-1000
        var19_11 = this.c(var17_10);
        if (var22_3) lbl-1000: // 2 sources:
        {
            var19_11 = this.e();
        }
lbl20: // 4 sources:
        var20_12 = var19_11.a(var13_8 - this.c) + this.a;
        var17_10 = this.d(var19_11);
        if (var17_10 < var15_9) {
            var19_11 = this.e(var19_11);
        }
        do {
            if (var17_10 >= var15_9) return Math.min(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            if (var19_11 == this.b.i()) return Math.min(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            var20_12 = Math.min(var20_12, this.a(var19_11));
            var20_12 = Math.min(var20_12, this.a(var19_11, this.d(var19_11)));
            var17_10 = this.d(var19_11);
            if (var17_10 >= var15_9) return Math.min(var20_12, var19_11.a(var15_9 - this.c) + this.a);
            var19_11 = this.e(var19_11);
        } while (!var22_3);
        return Math.min(var20_12, var19_11.a(var15_9 - this.c) + this.a);
    }

    /*
     * Unable to fully structure code
     */
    public double c(c var1_1) {
        var20_2 = t.d;
        var2_3 = this.a();
        var4_4 = var1_1.a();
        var6_5 = this.b();
        var8_6 = var1_1.b();
        if (var6_5 <= var2_3) return Double.MAX_VALUE;
        if (var8_6 <= var4_4) {
            return Double.MAX_VALUE;
        }
        var10_7 = Math.max(var2_3, var4_4);
        if (var10_7 >= (var12_8 = Math.min(var6_5, var8_6))) {
            return Double.MAX_VALUE;
        }
        var14_9 = var10_7;
        if (var2_3 != var4_4) ** GOTO lbl17
        var16_10 = this.e();
        var17_11 = var1_1.e();
        if (!var20_2) ** GOTO lbl23
lbl17: // 2 sources:
        if (var2_3 >= var4_4) ** GOTO lbl-1000
        var16_10 = this.c(var14_9);
        var17_11 = var1_1.e();
        if (var20_2) lbl-1000: // 2 sources:
        {
            var16_10 = this.e();
            var17_11 = var1_1.c(var14_9);
        }
lbl23: // 4 sources:
        var18_12 = Double.MAX_VALUE;
        do lbl-1000: // 5 sources:
        {
            if (var14_9 >= var12_8) return Math.min(var18_12, var1_1.a(var17_11, var14_9) - this.a(var16_10, var14_9));
            var18_12 = Math.min(var18_12, var1_1.a(var17_11, var14_9) - this.a(var16_10, var14_9));
            if (var1_1.d(var17_11) >= this.d(var16_10)) ** GOTO lbl33
            var14_9 = var1_1.d(var17_11);
            var18_12 = Math.min(var18_12, var1_1.a(var17_11, var14_9) - this.a(var16_10, var14_9));
            if (var14_9 >= var12_8) ** GOTO lbl-1000
            var17_11 = var1_1.e(var17_11);
            if (!var20_2) ** GOTO lbl-1000
lbl33: // 2 sources:
            var14_9 = this.d(var16_10);
            var18_12 = Math.min(var18_12, var1_1.a(var17_11, var14_9) - this.a(var16_10, var14_9));
            if (var14_9 >= var12_8) ** GOTO lbl-1000
            var16_10 = this.e(var16_10);
            if (var20_2 != false) return var18_12;
        } while (!var20_2);
        return Math.min(var18_12, var1_1.a(var17_11, var14_9) - this.a(var16_10, var14_9));
    }

    public String toString() {
        StringBuffer stringBuffer;
        boolean bl2 = t.d;
        StringBuffer stringBuffer2 = new StringBuffer(this.b.size() * 20);
        d d2 = (d)this.b.f();
        while (d2 != null) {
            stringBuffer = stringBuffer2.append("Segment [").append(d2.c + this.c).append(" - ").append(d2.a() + this.c).append("], value=").append(d2.b + this.a).append(", slope=").append(d2.d);
            if (bl2) return stringBuffer.toString();
            d2 = this.e(d2);
            if (!bl2) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }
}

